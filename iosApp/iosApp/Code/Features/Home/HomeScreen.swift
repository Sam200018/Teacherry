//
//  HomeScreen.swift
//  iosApp
//
//  Created by Samuel Bautista on 11/05/26.
//

import Foundation
import SwiftUI

struct HomeScreen: View {
    var name: String = "Sam"
    
    var body: some View {
        NavigationView {
            ScrollView {
           TopBarTitle(name: name)
            GroupsFilter()
            ForEach(0..<4) { _ in
                GroupItemView()
            }
            ListEnd()
            }.padding(24)
        }
    }
}

struct ListEnd: View {
    var body: some View {
        VStack(alignment: .center) {
            Text(.homeScreenGroupsListEnd)
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
