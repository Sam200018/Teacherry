//
//  ImageTeacherry.swift
//  iosApp
//
//  Created by Samuel Bautista on 11/05/26.
//

import SwiftUI

struct ImageTeacherry: View {
    let data : String
    var body: some View {
        AsyncImage(url: URL(string: data)) { image in
            image
                .resizable()
                .scaledToFill()
        } placeholder: {
            Image("holder")
                .resizable()
                .scaledToFill()
        }
        
    }
}

#Preview {
    ImageTeacherry(data: "https://cdn.milenio.com/uploads/media/2021/05/15/frases-para-el-dia-del.jpg")
        .scaledToFill()
        .clipShape(Circle())
        .frame(width: 100, height: 100)
}
