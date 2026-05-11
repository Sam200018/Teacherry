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
                .foregroundColor(.primaryContainerLight)
            Text("Mis grupos")
                .font(.system(size: 16, weight: .medium))
        }
        .padding(.vertical, 16)
    }
}

private struct NewGroupButton: View {
    var body: some View {
        HStack(spacing: 8) {
            Image(systemName: "plus.circle")
                .foregroundColor(.primaryContainerLight)
            Text("Nuevo")
                .font(.system(size: 16, weight: .medium))
                .foregroundColor(.primaryContainerLight)
        }
    }
}

#Preview {
    GroupsFilter()
}
