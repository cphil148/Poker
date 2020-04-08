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
                Rank.PAIR -> determinePairWinner(handOne,handTwo)
                Rank.TWOPAIR -> determinePairWinner(handOne,handTwo)
                Rank.THREEOFAKIND -> determineThreeOfAKindWinner(handOne,handTwo)
                Rank.FOUROFAKIND -> determineFourOfAKindWinner(handOne,handTwo)
                else -> determineHighCardWinner(handOne, handTwo)
            }
        }

        return winner
    }

    private fun determineFourOfAKindWinner(handOne: Hand, handTwo: Hand): Hand {
        val fourOfAKindCardOne = handOne.determineFourOfAKindCard()
        val fourOfAKindCardTwo = handTwo.determineFourOfAKindCard()

            return determineWinner(fourOfAKindCardOne, fourOfAKindCardTwo, handOne, handTwo)
    }

    private fun determineThreeOfAKindWinner(handOne: Hand, handTwo: Hand): Hand {
        val threeOfAKindCardOne = handOne.determineThreeOfAKindCard()
        val threeOfAKindCardTwo = handTwo.determineThreeOfAKindCard()

        return determineWinner(threeOfAKindCardOne, threeOfAKindCardTwo, handOne, handTwo)
    }

    private fun determinePairWinner(handOne: Hand, handTwo: Hand): Hand {
        val pairCardOne = handOne.determineHighestPairedCard()
        val pairCardTwo = handTwo.determineHighestPairedCard()

        return determineWinner(pairCardOne, pairCardTwo, handOne, handTwo)
    }

    private fun determineHighCardWinner(handOne: Hand, handTwo: Hand): Hand {
        val highCardOne = handOne.determineHighCard()
        val highCardTwo = handTwo.determineHighCard()

        return determineWinner(highCardOne, highCardTwo, handOne, handTwo)
    }

    private fun determineWinner(cardOne: Card, cardTwo: Card, handOne: Hand, handTwo: Hand) =
        if (cardOne.value > cardTwo.value) handOne else handTwo
}