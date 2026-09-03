import SwiftUI

struct DropdownTextField: View {
    let label: LocalizedStringKey
    let placeholder: LocalizedStringKey
    let value: LocalizedStringKey?

    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            Text(label)
                .font(.subheadline)
                .foregroundColor(.black)

            HStack {
                Text(value ?? placeholder)
                    .foregroundColor(value == nil ? .gray : .black)
                Spacer()
                Image(systemName: "chevron.down")
                    .foregroundColor(.gray)
            }
            .padding()
            .background(Color.white)
            .cornerRadius(12)
            .overlay(
                RoundedRectangle(cornerRadius: 12)
                    .stroke(Color.gray.opacity(0.3), lineWidth: 1)
            )
        }
    }
}

#Preview {
    DropdownTextField(label: "Hola", placeholder: "Input", value: "")
}
