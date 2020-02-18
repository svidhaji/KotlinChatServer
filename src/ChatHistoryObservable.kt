interface ChatHistoryObservable { //Seurattava luokka, jossa on kaikki katsojat, jotka rekistöivät itsensä


    fun registerUser(observer : ChatObserver)

    fun deregisterUser(observer: ChatObserver)

    fun notifyObservers(message : ChatMessage)

}