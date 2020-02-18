class ChatConsole : ChatObserver {

   init {
       ChatHistory.registerUser(this)
   }

    override fun newUserMessage(message: ChatMessage) { //Printtaa konsolille viestit näkyviin

        println(message.toString())
    }


}