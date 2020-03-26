class Hand(cardOne: Card,
           cardTwo: Card,
           cardThree: Card,
           cardFour: Card,
           cardFive: Card) {
    fun isValid(): Boolean  {
        return true
    }

    val cards = listOf(cardOne, cardTwo, cardThree, cardFour, cardFive)


}