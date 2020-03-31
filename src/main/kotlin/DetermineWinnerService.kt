class DetermineWinnerService {

    fun compareHands(handOne: Hand, handTwo: Hand): Hand {

        if(!handOne.isOrganized)
            handOne.organizeHand()

        if(!handTwo.isOrganized)
            handTwo.organizeHand()

        var winner = handOne

        val handIdentifierService = HandIdentifierService()
        val handOneType = handIdentifierService.determineType(handOne)
        val handTwoType = handIdentifierService.determineType(handTwo)

        if (handOneType == handTwoType) {
            winner = when (handOneType) {
                Rank.HIGHCARD -> determineHighCardWinner(handOne, handTwo)
                Rank.PAIR -> determinePairWinner(handOne,handTwo)
                Rank.TWOPAIR -> determinePairWinner(handOne,handTwo)
                else -> determinePairWinner(handOne, handTwo)
            }
        }

        return winner
    }

    private fun determinePairWinner(handOne: Hand, handTwo: Hand): Hand {
        val pairCardOne = handOne.determinePair()
        val pairCardTwo = handTwo.determinePair()

        return if (pairCardOne.value > pairCardTwo.value) handOne else handTwo
    }

    private fun determineHighCardWinner(handOne: Hand, handTwo: Hand): Hand {
        val highCardOne = handOne.determineHighCard()
        val highCardTwo = handTwo.determineHighCard()

        return if (highCardOne.value > highCardTwo.value) handOne else handTwo
    }
}