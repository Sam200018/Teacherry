import SwiftUI

struct InfoCard: View {
    let text: LocalizedStringKey

    var body: some View {
        HStack(alignment: .top, spacing: 12) {
            Image(systemName: "info.circle")
                .foregroundColor(Color(hex: "00B939"))
            Text(text)
                .font(.footnote)
        }
        .padding()
        .frame(maxWidth: .infinity, alignment: .leading)
        .background(Color(.primaryContainerShadow))
        .cornerRadius(12)
        .overlay(
            RoundedRectangle(cornerRadius: 12)
                .stroke(Color(hex: "00B939"), lineWidth: 1)
        )
    }
}

#Preview{
    InfoCard(text: "Hi")
}
