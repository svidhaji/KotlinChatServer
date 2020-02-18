import java.time.LocalDateTime
import java.time.LocalTime

open class ChatMessage (val username : String, val message : String) {
    val time = LocalDateTime.now()

    override fun toString(): String {
        return "$time: $username : $message"
    }

}