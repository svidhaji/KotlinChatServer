object User {  //Pitää sisällään käyttäjän toiminnot, kuten lisääminen, poistaminen, tarkistaminen
                //sekä toString() -metodi

    val users: HashSet<String> = hashSetOf()

    fun addUser(username: String) :Boolean {
        if (!checkUser(username)) {
            users.add(username)
            return true
        }
        return false
    }

    fun getUsername(username: String) : Boolean {

        return username in users
    }

    fun removeUser(username: String) {

        if(checkUser(username))
        users.remove(username)
    }

    fun checkUser(username: String): Boolean {

        if (username in users) {
            return true
        } else {
            return false
        }

    }


    override fun toString(): String {

        var result = " "
        for (user in users) {

            result += "\n\r $user"
        }
        return result
    }
}