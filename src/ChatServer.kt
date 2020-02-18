import java.io.PrintStream
import java.net.ServerSocket
import java.net.Socket

class ChatServer {      // Server -luokka, jossa on socket serveriyhteydelle.


fun serverConnect() {

    val server = ServerSocket(0)

        println("We have port: " +server.localPort)

    TopChatter       // Serveri lukee kerran läpi, koska TopChatterilla on init -funktio
    while (true) {

        println("Step 1")
        val s = server.accept()
        println("Step 2")

        val ci = CommandInterpreter(s)

        val t = Thread(ci)

        t.start()
    }
}
}