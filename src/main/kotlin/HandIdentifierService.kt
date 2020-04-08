class HandIdentifierService {
    fun determineType(hand: Hand): Rank {

        val type: Rank
        val listOfMatches = findMatches(hand)
        val straight = isStraight(hand)
        val flush = isFlush(hand)

        type = when {
            straight && flush -> Rank.STRAIGHTFLUSH
            listOfMatches.contains(4) -> Rank.FOUROFAKIND
            listOfMatches.contains(3) && listOfMatches.contains(2) -> Rank.FULLHOUSE
            flush -> Rank.FLUSH
            straight -> Rank.STRAIGHT
            listOfMatches.contains(3) -> Rank.THREEOFAKIND
            listOfMatches.contains(2) -> determinePairRank(listOfMatches)
            else -> Rank.HIGHCARD
        }

        return type
    }


    private fun isStraight(hand: Hand): Boolean{
        var isStraight = true
        val sortedHand = hand.listOfCards.sortedBy { it.value }
        val firstCardValue = sortedHand.first().value
        var previousOrdinal = firstCardValue.ordinal

        for(i in 1..4) {
            val currentOrdinal = sortedHand[i].value.ordinal
            if(currentOrdinal != previousOrdinal+1) {
                isStraight = false
                break
            }
            previousOrdinal = currentOrdinal
        }
        return isStraight
    }

    private fun isFlush(hand: Hand): Boolean {
        var isFlush = true
        val firstCardSuit = hand.cardOne.suit
        hand.listOfCards.forEach {
            if (it.suit != firstCardSuit)
                isFlush = false
        }
        return isFlush
    }

    private fun findMatches(hand: Hand): MutableList<Int> {
        val listOfMatches = mutableListOf<Int>()

        hand.cards.forEach {
            when (it.value.size) {
                1 -> listOfMatches.add(1)
                2 -> listOfMatches.add(2)
                3 -> listOfMatches.add(3)
                4 -> listOfMatches.add(4)
            }
        }
        return listOfMatches
    }

    private fun determinePairRank(listOfMatches: MutableList<Int>): Rank {
        return when (determineNumberOfPairs(listOfMatches)) {
            1 -> Rank.PAIR
            else -> Rank.TWOPAIR
        }
    }

    private fun determineNumberOfPairs(listOfMatches: MutableList<Int>): Int {
        var count = 0
        listOfMatches.forEach {
            if (it == 2)
                count++
        }
        return count
    }
}