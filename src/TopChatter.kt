object TopChatter : ChatObserver { // Tehdään objekti, joka observoi keskustelua

    var topChatters = mutableMapOf<String, Int>()


    init {
        ChatHistory.registerUser(this)
    }

    override fun newUserMessage(message: ChatMessage) {

        var countMessage = topChatters.get(message.username) // Otetaan käyttäjä ja viesti muistiin

        if (countMessage != null) {
            countMessage += 1
            topChatters.put(message.username,countMessage) // Lisätään viesti, (kunhan viesti ei ole tyhjä) ja perään viestien määrä
        } else {
            topChatters.put(message.username, 1)
        }
    }

    override fun toString() : String {

        var result = ""

        for(top in topChatters) {

            result = "$result\n\r${top.key}: ${top.value}"      // Käydään viestiketju läpi ja kutsuu viestit järjestyksessä top 3
        }
        return result
    }
}