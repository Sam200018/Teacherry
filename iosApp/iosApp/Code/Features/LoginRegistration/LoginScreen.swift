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
            Text("Login Screen")
            Spacer().frame(height: 40)
            TextField("Email", text: $email).onChange(
                of: email,
                { _, newValue in
                    loginObservable.updateState(loginIntent: PresentationLoginIntent.OnEmailChange(email: newValue))
                }
            ).textFieldStyle(.roundedBorder)

            Spacer().frame(height: 20)

            TextField("Password", text: $password).onChange(
                of: password,
                { _, newValue in
                    loginObservable.updateState(loginIntent: PresentationLoginIntent.OnPasswordChange(password: newValue))
                }
            ).textFieldStyle(
                .roundedBorder
            )

            Spacer().frame(height: 20)
            Button("Login") {
                loginObservable.updateState(loginIntent: PresentationLoginIntent.OnLoginWithCredentials())
            }.buttonStyle(.bordered)
            
            if(loginObservable.loginUiState.isLoading) {
                Text("Loading...")
            }
            if(loginObservable.loginUiState.isError) {
                Text("Error")
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
