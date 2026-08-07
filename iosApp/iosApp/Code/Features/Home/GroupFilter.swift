//
//  GroupFilter.swift
//  iosApp
//
//  Created by Samuel Bautista on 11/05/26.
//

import SwiftUI


struct GroupsFilter: View {
    var body: some View {
        HStack(spacing: 0) {
            GroupsFilterButton()
            Spacer()
            NewGroupButton()
        }
        .frame(maxWidth: .infinity)
    }
}

private struct GroupsFilterButton: View {
    var body: some View {
        HStack(spacing: 8) {
            Image(systemName: "info.circle")
                .foregroundColor(Color("PrimaryContainerLight"))
            Text(.homeScreenMyGroups)
                .font(.system(size: 16, weight: .medium))
        }
        .padding(.vertical, 16)
    }
}

private struct NewGroupButton: View {
    var body: some View {
        HStack(spacing: 8) {
            Image(systemName: "plus.circle")
                .foregroundColor(Color("PrimaryContainerLight"))
            Text(.homeScreenNewGroup)
                .font(.system(size: 16, weight: .medium))
                .foregroundColor(Color("PrimaryContainerLight"))
        }
    }
}

#Preview {
    GroupsFilter()
}
