//
//  LoginScreen.swift
//  iosApp
//
//  Created by Samuel Bautista on 28/03/26.
//

import Shared
import SwiftUI

struct LoginScreen: View {

    @State private var email: String = ""
    @State private var password: String = ""
    @ObservedObject private(set) var loginObservable : LoginObservableViewModel

    var body: some View {
        VStack {
            Text(String(localized: "login_registration_login_button_label"))
            Spacer().frame(height: 40)
            TextField(String(localized: "login_registration_login_email_label"), text: $email).onChange(
                of: email,
                { _, newValue in
                    loginObservable.updateState(loginIntent: PresentationLoginIntent.OnEmailChange(email: newValue))
                }
            ).textFieldStyle(.roundedBorder)

            Spacer().frame(height: 20)

            TextField(String(localized: "login_registration_login_password_label"), text: $password).onChange(
                of: password,
                { _, newValue in
                    loginObservable.updateState(loginIntent: PresentationLoginIntent.OnPasswordChange(password: newValue))
                }
            ).textFieldStyle(
                .roundedBorder
            )

            Spacer().frame(height: 20)
            Button(String(localized: "login_registration_login_button_label")) {
                loginObservable.updateState(loginIntent: PresentationLoginIntent.OnLoginWithCredentials())
            }.buttonStyle(.bordered)
            
            if(loginObservable.loginUiState.isLoading) {
                Text(String(localized: "login_registration_loading_label"))
            }
            if(loginObservable.loginUiState.isError) {
                Text(String(localized: "login_registration_error_label"))
            }
            if(loginObservable.loginUiState.isSuccessful) {
                Text(loginObservable.message!)
            }
        }.padding().task {
            await loginObservable.startObserving()
            email = loginObservable.email
            password = loginObservable.password
        }
    }
}
