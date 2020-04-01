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
                Rank.THREEOFAKIND -> determineThreeOfAKindWinner(handOne,handTwo)
                Rank.FOUROFAKIND -> determineFourOfAKindWinner(handOne,handTwo)
                else -> determinePairWinner(handOne, handTwo)
            }
        }

        return winner
    }

    private fun determineFourOfAKindWinner(handOne: Hand, handTwo: Hand): Hand {
        val fourOfAKindCardOne = handOne.determineFourOfAKindCard()
        val fourOfAKindCardTwo = handTwo.determineFourOfAKindCard()

            return if (fourOfAKindCardOne.value > fourOfAKindCardTwo.value) handOne else handTwo
    }

    private fun determineThreeOfAKindWinner(handOne: Hand, handTwo: Hand): Hand {
        val threeOfAKindCardOne = handOne.determineThreeOfAKindCard()
        val threeOfAKindCardTwo = handTwo.determineThreeOfAKindCard()

        return if (threeOfAKindCardOne.value > threeOfAKindCardTwo.value) handOne else handTwo
    }

    private fun determinePairWinner(handOne: Hand, handTwo: Hand): Hand {
        val pairCardOne = handOne.determineHighestPairedCard()
        val pairCardTwo = handTwo.determineHighestPairedCard()

        return if (pairCardOne.value > pairCardTwo.value) handOne else handTwo
    }

    private fun determineHighCardWinner(handOne: Hand, handTwo: Hand): Hand {
        val highCardOne = handOne.determineHighCard()
        val highCardTwo = handTwo.determineHighCard()

        return if (highCardOne.value > highCardTwo.value) handOne else handTwo
    }
}