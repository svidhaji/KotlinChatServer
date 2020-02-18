object ChatHistory : ChatHistoryObservable { // Pitää listaa kaikista viesteistä ja katsojista,
                                                //  joita voi lisätä, poistaa tai muuttaa

    private val messageHistory : MutableList<ChatMessage> = mutableListOf()

    private val observers : MutableList<ChatObserver> = mutableListOf()

    fun insert(message : ChatMessage) {
        messageHistory.add(message)
        notifyObservers(message)
    }

    override fun registerUser(observer: ChatObserver) {
        observers.add(observer)
    }

    override fun deregisterUser(observer: ChatObserver) {

        observers.remove(observer)
    }

    override fun notifyObservers(message: ChatMessage) {

        for(i in observers) {

            i.newUserMessage(message)
        }
    }

    override fun toString() : String {

        var result = ""

        for(chat in messageHistory) {
            chat.toString()
            result = "$result\n\r$chat"
        }
        return result
    }
}