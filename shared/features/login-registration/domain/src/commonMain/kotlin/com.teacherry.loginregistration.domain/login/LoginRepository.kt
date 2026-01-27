interface LoginRepository {
    suspend fun login(): String
}