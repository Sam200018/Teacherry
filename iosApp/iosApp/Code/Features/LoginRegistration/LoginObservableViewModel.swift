//
//  LoginObservableViewModel.swift
//  iosApp
//
//  Created by Samuel Bautista on 26/04/26.
//

import Foundation
import Shared

@MainActor
/// SwiftUI adapter over the shared Kotlin `LoginViewModel`.
///
/// `loginVM.uiState` is the source of truth. `startObserving()` subscribes to that
/// flow and republishes values to SwiftUI.
///
/// Note: this class currently exposes both a full `loginUiState` and split fields
/// (`email`, `password`, flags). Keeping both can drift if one path stops updating,
/// so prefer binding UI to `loginUiState` when possible.
class LoginObservableViewModel: ObservableObject {
    private let loginVM = KoinHelper().getLoginViewModel()
    
    /// Split fields kept for convenience/backward compatibility.
    /// Prefer consuming `loginUiState` as the single state object.
    @Published var email = ""
    @Published var password = ""
    @Published var isLoading: Bool = false
    @Published var isSuccess: Bool = false
    @Published var isError: Bool = false
    @Published var message: String? = nil

    /// Canonical state mirrored from the shared Kotlin `uiState` flow.
    @Published var loginUiState : PresentationLoginUIState = PresentationLoginUIState.init(email: "", password: "", isLoading: false, isSuccessful: false, isError: false, message: nil)
    
    /// Starts collecting the Kotlin `uiState` flow and republishes updates.
    ///
    /// Call once from the view lifecycle (for example, `.task`) so the SwiftUI view
    /// stays subscribed to VM changes.
    func startObserving() async {
        for await state in loginVM.uiState {
            self.email = state.email
            self.password = state.password
            self.isLoading = state.isLoading
            self.message = state.message
            self.isSuccess = state.isSuccessful
            self.isError = state.isError
            self.loginUiState = state
            
        }
    }

    /// Processes login intents and forwards them to the shared Kotlin `LoginViewModel`.
    ///
    /// This method acts as a bridge between SwiftUI events and the shared business logic.
    /// It handles email changes, password changes, and login attempts by dispatching
    /// the appropriate intent to the Kotlin view model.
    ///
    /// - Parameter loginIntent: The login intent to process (email change, password change, or login).
    func updateState(loginIntent: PresentationLoginIntent){
        switch onEnum(of: loginIntent){
        case.onEmailChange(let change) :
            loginVM.handleIntent(intent: PresentationLoginIntent.OnEmailChange(email: change.email))
        case.onPasswordChange(let change) :
            loginVM.handleIntent(intent: PresentationLoginIntent.OnPasswordChange(password: change.password))
        case.onLoginWithCredentials :
            loginVM.handleIntent(intent: PresentationLoginIntent.OnLoginWithCredentials())
            break
        }
    }
}
