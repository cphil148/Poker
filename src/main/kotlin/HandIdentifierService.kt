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

        type = if (listOfMatches.contains(2)) {
            var count = 0
            listOfMatches.forEach {
                if (it == 2)
                    count++
            }
            if (count == 1)
                Rank.PAIR
            else
                Rank.TWOPAIR
        } else
            Rank.HIGHCARD

        return type
    }
}