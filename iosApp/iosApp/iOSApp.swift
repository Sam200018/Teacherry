import SwiftUI
import Shared

@main
struct iOSApp: App {
    init() {
        SharedModulesKt.doInitKoin()
    }
    
    var body: some Scene {
        WindowGroup {
            LoginScreen(loginObservable: LoginObservableViewModel())
        }
    }
}
