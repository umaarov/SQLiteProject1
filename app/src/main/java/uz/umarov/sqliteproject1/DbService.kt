package uz.umarov.sqliteproject1

interface DbService {
    fun insertUser(username: String, password: String)
    fun readUser(username: String, password: String): Boolean
}