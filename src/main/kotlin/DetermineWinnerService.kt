class DetermineWinnerService {

    fun compareHands(handOne: Hand, handTwo: Hand):Hand{

        handOne.organizeHand()
        handTwo.organizeHand()

        val winner = determineHighCardWinner(handOne,handTwo)

        return winner
    }

    private fun determineHighCardWinner(handOne: Hand, handTwo: Hand): Hand {
        val highCardOne = handOne.determineHighCard()
        val highCardTwo = handTwo.determineHighCard()

        return if (highCardOne.value > highCardTwo.value) handOne else handTwo
    }
}