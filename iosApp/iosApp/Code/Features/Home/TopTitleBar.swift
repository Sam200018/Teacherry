//
//  TopTitleBar.swift
//  iosApp
//
//  Created by Samuel Bautista on 11/05/26.
//

import SwiftUI

struct TopBarTitle: View {
    let name: String
    
    var body: some View {
        HStack {
            VStack(alignment: .leading, spacing: 4) {
                Text(.homeScreenWelcomeTitle)
                    .font(.title3)
                    .foregroundColor(Color("PrimaryContainerLight"))
                Text(.homeScreenWelcomeName(name: name))
                    .font(.title)
                    .fontWeight(.bold)
                    .foregroundColor(Color("PrimaryTextLight"))
            }
            Spacer()
            Image(systemName: "bell")
                .font(.title2)
                .foregroundColor(.primary)
        }
        .padding(.top, 32)
        .padding(.bottom, 16)
        .frame(maxWidth: .infinity)
    }
}

#Preview {
    TopBarTitle(name: "Samuel")
}
