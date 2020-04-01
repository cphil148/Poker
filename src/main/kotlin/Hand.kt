import java.lang.Exception

data class Hand(
    val cardOne: Card,
    val cardTwo: Card,
    val cardThree: Card,
    val cardFour: Card,
    val cardFive: Card) {

    private val listOfCards = if (this.isValid()) listOf(
        cardOne,
        cardTwo,
        cardThree,
        cardFour,
        cardFive
    ) else throw Exception("Cannot Organize invalid hand")

    var isOrganized: Boolean = false

    val cards: MutableMap<Value,MutableList<Card>> =
        mutableMapOf(
            Pair(Value.TWO,mutableListOf()),
            Pair(Value.THREE, mutableListOf()),
            Pair(Value.FOUR, mutableListOf()),
            Pair(Value.FIVE, mutableListOf()),
            Pair(Value.SIX, mutableListOf()),
            Pair(Value.SEVEN, mutableListOf()),
            Pair(Value.EIGHT, mutableListOf()),
            Pair(Value.NINE, mutableListOf()),
            Pair(Value.TEN, mutableListOf()),
            Pair(Value.JACK, mutableListOf()),
            Pair(Value.QUEEN, mutableListOf()),
            Pair(Value.KING, mutableListOf()),
            Pair(Value.ACE, mutableListOf()))

    private fun isValid(): Boolean =
        setOf(cardOne,cardTwo,cardThree,cardFour,cardFive).distinctBy{Pair(it.value,it.suit)}.size == 5


    fun organizeHand(){
        listOfCards.forEach { cards.get(it.value)!!.add(it)}
        isOrganized = true
    }

    fun determineHighCard(): Card {
        var highCard = listOfCards.first()
        listOfCards.forEach {
            if(it.value > highCard.value)
                highCard = it
        }
        return highCard
    }

    fun determineHighestPairedCard(): Card {
        var pairCard = listOfCards.first()
        cards.forEach {
            if(it.value.size == 2)
                pairCard = it.value.first()
        }
        return pairCard
    }

    fun determineThreeOfAKindCard(): Card {
        var threeOfAKindCard = listOfCards.first()
        cards.forEach{
            if(it.value.size == 3)
                threeOfAKindCard = it.value.first()
        }
        return threeOfAKindCard
    }

    fun determineFourOfAKindCard(): Card {
        var fourOfAKindCard = listOfCards.first()
        cards.forEach{
            if(it.value.size == 4)
                fourOfAKindCard = it.value.first()

        }
        return fourOfAKindCard
    }
}