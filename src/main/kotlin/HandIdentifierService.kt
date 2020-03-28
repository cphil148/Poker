class HandIdentifierService {
    fun determineType(hand: Hand): Rank {

        var type = Rank.HIGHCARD
        val listOfMatches = mutableListOf<Int>()

        hand.cards.forEach {
            when (it.value.size) {
                1 -> listOfMatches.add(1)
                2 -> listOfMatches.add(2)
            }
        }
        if (listOfMatches.contains(2))
            type = Rank.PAIR
        else
            type = Rank.HIGHCARD
        return type
    }
}