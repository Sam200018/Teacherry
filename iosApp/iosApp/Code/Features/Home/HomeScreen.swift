//
//  HomeScreen.swift
//  iosApp
//
//  Created by Samuel Bautista on 11/05/26.
//

import Foundation
import SwiftUI

struct HomeScreen: View {
    
    var body: some View {
        ScrollView {
           TopBarTitle()
            GroupsFilter()
            ForEach(0..<4) { _ in
                GroupItemView()
            }
            ListEnd()
        }.padding(24)
    }
}

struct ListEnd: View {
    var body: some View {
        VStack(alignment: .center) {
            Text("Delice hacia abajo para actualizar la lista")
                .font(.system(size: 14, weight: .semibold))
                .foregroundColor(.secondary)
                .padding(.top, 16)
                .padding(.bottom, 32)
        }
        .frame(maxWidth: .infinity)
    }
}

#Preview {
    ListEnd()
}

#Preview {
    HomeScreen()
}
