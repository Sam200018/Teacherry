### System Documentation


This is a system to help the primary school teachers on Mexico to manage their group and their student's grades. Its goal is to simplify the administrative responsibilities, allowing the teachers to have digital control for the students' attendance and academic performance.
For detailed system documentation and additional resources, see the Microsoft-hosted document:
[System documentation (Microsoft)](https://home.microsoftpersonalcontent.com/:fl:/g/contentstorage/CSP_3913052a-3df8-439a-b9f5-ee268b2a573d/IQK-5bFjrfRhSK5GfnVzg_dEAcqriKoKcdLYqBVb01OgMAs?e=BFND4p&nav=cz0lMkZjb250ZW50c3RvcmFnZSUyRkNTUF8zOTEzMDUyYS0zZGY4LTQzOWEtYjlmNS1lZTI2OGIyYTU3M2QmZD1iIUtnVVRPZmc5bWtPNTllNG1peXBYUFhmaWN2bDlTbnhBdmlFSFR4dDZxMUxPRXFxQXlUSDRUNEtXLXV3WEI3OEEmZj0wMVFWRERGQzU2NFdZV0hMUFVNRkVLNFJUNk9WWllINTJFJmM9JTJGJmZsdWlkPTEmYT1Mb29wQXBwJnA9JTQwZmx1aWR4JTJGbG9vcC1wYWdlLWNvbnRhaW5lciZ4PSU3QiUyMnclMjIlM0ElMjJUMFJUVUh4b2IyMWxMbTFwWTNKdmMyOW1kSEJsY25OdmJtRnNZMjl1ZEdWdWRDNWpiMjE4WWlGTFoxVlVUMlpuT1cxclR6VTVaVFJ0YVhsd1dGQllabWxqZG13NVUyNTRRWFpwUlVoVWVIUTJjVEZNVDBWeGNVRjVWRWcwVkRSTFZ5MTFkMWhDTnpoQmZEQXhVVlpFUkVaRE5GUTNXalpNVVV0UFRUWmFTREpUVWpWQ1JsTkpURWhUUWtZJTNEJTIyJTJDJTIyaSUyMiUzQSUyMmY4NTBlZmJmLTgzNDYtNDA0Mi1iMDE4LWY3MTg1MGYzZjkzYyUyMiU3RA%3D%3D)

This is a Kotlin Multiplatform project targeting Android, iOS.

* [/composeApp](./composeApp/src) is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - [commonMain](./composeApp/src/commonMain/kotlin) is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    the [iosMain](./composeApp/src/iosMain/kotlin) folder would be the right place for such calls.
    Similarly, if you want to edit the Desktop (JVM) specific part, the [jvmMain](./composeApp/src/jvmMain/kotlin)
    folder is the appropriate location.

* [/iosApp](./iosApp/iosApp) contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform,
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.

* [/shared](./shared/src) is for the code that will be shared between all targets in the project.
  The most important subfolder is [commonMain](./shared/src/commonMain/kotlin). If preferred, you
  can add code to the platform-specific folders here too.

### Build and Run Android Application

To build and run the development version of the Android app, use the run configuration from the run widget
in your IDE’s toolbar or build it directly from the terminal:
- on macOS/Linux
  ```shell
  ./gradlew :composeApp:assembleDebug
  ```
- on Windows
  ```shell
  .\gradlew.bat :composeApp:assembleDebug
  ```

### Build and Run iOS Application

To build and run the development version of the iOS app, use the run configuration from the run widget
in your IDE’s toolbar or open the [/iosApp](./iosApp) directory in Xcode and run it from there.

---

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…