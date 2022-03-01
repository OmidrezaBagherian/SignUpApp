package ir.omidrezabagherian.quiz3app

data class CreateUser(
    val firstName: String,
    val lastName: String,
    val nationalCode: String,
    val hobbies: List<String>
)