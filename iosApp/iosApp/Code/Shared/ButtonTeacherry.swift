import SwiftUI

struct ButtonTeacherry: View {
    let title: LocalizedStringKey
    let systemImage: String
    let action: () -> Void

    var body: some View {
        Button(action: action) {
            HStack {
                Text(title)
                    .fontWeight(.bold)
                Image(systemName: systemImage)
            }
            .foregroundColor(.black)
            .frame(maxWidth: .infinity)
            .padding()
            .background(Color("PrimaryContainerLight"))
            .cornerRadius(12)
        }
    }
}

#Preview {
    ButtonTeacherry(title: "Button", systemImage: "") {
        
    }
}
