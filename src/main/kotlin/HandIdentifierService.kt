class HandIdentifierService {
    fun determineType(hand: Hand): Rank {

        val type: Rank
        val listOfMatches = findMatches(hand)

        type = when {
            listOfMatches.contains(4) -> Rank.FOUROFAKIND
            listOfMatches.contains(3) -> Rank.THREEOFAKIND
            listOfMatches.contains(2) -> determinePairRank(listOfMatches)
            else -> Rank.HIGHCARD
        }

        return type
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