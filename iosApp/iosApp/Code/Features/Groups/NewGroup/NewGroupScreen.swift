import SwiftUI

struct NewGroupScreen: View {
    @Environment(\.presentationMode) var presentationMode
    @State private var groupName: String = ""
    @State private var grade: String = ""

    var body: some View {
        ZStack(alignment: .topTrailing) {
            
            // Decorative top right circle
            Circle()
                .fill(Color(hex: "EAF9EF"))
                .frame(width: 200, height: 200)
                .offset(x: 60, y: -60)
            
            ScrollView {
                VStack(spacing: 16) {
                    // Header Icon
                    ZStack {
                        Circle()
                            .fill(Color(hex: "C7F3C7"))
                            .frame(width: 72, height: 72)
                        
                        Image(systemName: "person.fill")
                            .resizable()
                            .scaledToFit()
                            .frame(width: 36, height: 36)
                            .foregroundColor(Color("PrimaryContainerLight"))
                    }
                    .padding(.top, 24)
                    
                    Text("new_screen_header_subtitle")
                        .font(.title2)
                        .fontWeight(.bold)
                        .foregroundColor(.black)
                    
                    Text("new_screen_description")
                        .font(.subheadline)
                        .multilineTextAlignment(.center)
                        .foregroundColor(.gray)
                        .padding(.bottom, 16)
                    
                    TextFieldTeacherry(
                        label: "new_screen_group_name_label",
                        placeholder: "new_screen_group_name_placeholder",
                        text: $groupName
                    )
                    
                    DropdownTextField(
                        label: "new_screen_group_level_label",
                        placeholder: "new_screen_group_level_placeholder",
                        value: grade.isEmpty ? nil : LocalizedStringKey(grade)
                    )
                    
                    InfoCard(text: "new_screen_group_info_text")
                        .padding(.vertical, 8)
                    
                    Spacer(minLength: 40)
                    
                    ButtonTeacherry(
                        title: "new_screen_group_create_cta_label",
                        systemImage: "plus.circle",
                        action: {
                            // TODO: Handle button click
                        }
                    )
                    .padding(.bottom, 24)
                }
                .padding(.horizontal, 24)
            }
        }
        .navigationBarBackButtonHidden(true)
        .navigationBarItems(leading: Button(action: {
            presentationMode.wrappedValue.dismiss()
        }) {
            Image(systemName: "arrow.left")
                .foregroundColor(.black)
        })
        .navigationBarTitleDisplayMode(.inline)
        .toolbar {
            ToolbarItem(placement: .principal) {
                Text("new_screen_header_title")
                    .font(.headline)
                    .fontWeight(.bold)
            }
        }
    }
}

#Preview {
    NavigationView {
        NewGroupScreen()
    }
}
