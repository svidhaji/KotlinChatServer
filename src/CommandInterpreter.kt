import java.io.PrintStream
import java.net.Socket
import java.util.*


class CommandInterpreter(val s : Socket) : Runnable, ChatObserver { // Toiminnallisuusluokka, jossa kaikki
                                                                    //implementoidaan run() -metodin alla

    var scanner = Scanner(s.getInputStream())
    var printer = PrintStream(s.getOutputStream())
    var username = ""

    override fun newUserMessage(message: ChatMessage) {

        printer.println(message)
    }



    override fun run() {

        ChatConsole()
        ChatHistory.registerUser(observer = this)

        printer.println("Welcome to chat: ")

        printer.println("Write your username using :user [username] command:")


         while (true) {

             val text = scanner.nextLine()

             if (text.substringBefore(" ").equals(":user")) {

                 username = text.split(' ')[1]
             if (!User.checkUser(username)){  // katsotaan jos käyttäjää ei ole luotu, jos ei, niin luodaan uusi käyttäjä
                     User.addUser(username)
                     printer.println("Welcome to chat: $username" )
                 } else {
                     printer.println("Username is already in use, Please enter another username!")
                 }
             } else if (text.startsWith(":users")) {
                    printer.println(User.users.toString())
             } else if (text.startsWith(":history")) {
                 printer.println(ChatHistory.toString())            //Eri komennoilla, kuten vaikka :user, :history pääsee katsomaan käyttäjien
             } else if (text.startsWith(":topchatter")){
                    printer.println(TopChatter.toString())
             } else if (text.startsWith(":quit")) {

                 ChatHistory.insert(ChatMessage(username, "has left the chat"))
                 ChatHistory.deregisterUser(this)
                 User.removeUser(username)
                 scanner.close()
                 printer.close()
                 break
             } else {

                 val command = ChatMessage(username, text)
                 ChatHistory.insert(command)
             }
         }

}
}