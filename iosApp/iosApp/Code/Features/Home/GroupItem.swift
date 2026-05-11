//
//  GroupItem.swift
//  iosApp
//
//  Created by Samuel Bautista on 11/05/26.
//

import SwiftUI

struct GroupItemView: View {
    var body: some View {
        HStack(spacing: 0) {
            RoundedRectangle(cornerRadius: 20)
                .fill(Color("PrimaryContainer"))
                .frame(width: 8)

            VStack(alignment: .leading, spacing: 16) {
                ImageTeacherry(data: "https://cdn.milenio.com/uploads/media/2021/05/15/frases-para-el-dia-del.jpg")
                    .scaledToFill()
                    .frame(height: 96)
                    .clipped()
                    .cornerRadius(12)
                
                GroupInfoView()
            }
            .padding(16)
            .frame(maxWidth: .infinity, alignment: .leading)
        }
        .background(Color.white)
        .cornerRadius(20)
        .padding(.vertical, 8)
        .shadow(color: .black.opacity(0.06), radius: 6, x: 0, y: 2)
    }
}

struct GroupInfoView: View {
    var body: some View {
        VStack(alignment: .leading, spacing: 16) {
            HStack(alignment: .center) {
                VStack(alignment: .leading, spacing: 4) {
                    Text("Group name")
                        .font(.title3)
                        .fontWeight(.semibold)
                        .foregroundColor(Color("PrimaryTextLight"))

                    Text("Group description")
                        .font(.body)
                        .foregroundStyle(Color.secondary)
                }

                Spacer()

                Text("ACTIVO")
                    .font(.caption)
                    .fontWeight(.bold)
                    .foregroundStyle(Color("PrimaryContainerLight"))
                    .padding(.horizontal, 16)
                    .padding(.vertical, 8)
                    .background(Color(red: 0.91, green: 0.97, blue: 0.92))
                    .clipShape(Capsule())
            }

            HStack {
                Label("",systemImage: "person.fill")
                    .foregroundStyle(Color("PrimaryContainerLight"))
                Text("100 miembros")

                Spacer()

                Button(action: {}) {
                    HStack(spacing: 4) {
                        Text("Entrar")
                        Image(systemName: "chevron.right")
                    }
                    .foregroundStyle(Color.white)
                    .padding(.horizontal, 16)
                    .padding(.vertical, 10)
                    .background(Color("PrimaryContainerLight"))
                    .clipShape(Capsule())
                }
            }
        }
    }
}

#Preview {
    GroupInfoView()
}
