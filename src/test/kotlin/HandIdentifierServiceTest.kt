import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class HandIdentifierServiceTest {

    val handIdentifierService = HandIdentifierService()

    @Test
    fun `determineType can identify a highCard hand`() {
        val highCardHand = Hand(
            Card(Value.TWO, Suit.SPADE),
            Card(Value.THREE, Suit.SPADE),
            Card(Value.FOUR, Suit.CLUB),
            Card(Value.SIX, Suit.DIAMOND),
            Card(Value.TEN, Suit.HEART)
        )

        highCardHand.organizeHand()

        assertThat(handIdentifierService.determineType(highCardHand)).isEqualTo(Rank.HIGHCARD)
    }

    @Test
    fun `determineType can identify a Pair hand`() {
        val pairHand = Hand(
            Card(Value.TWO, Suit.SPADE),
            Card(Value.TWO, Suit.HEART),
            Card(Value.FOUR, Suit.CLUB),
            Card(Value.SIX, Suit.DIAMOND),
            Card(Value.TEN, Suit.HEART)
        )

        pairHand.organizeHand()
        assertThat(handIdentifierService.determineType(pairHand)).isEqualTo(Rank.PAIR)
    }

    @Test
    fun `determineType can identify a TwoPair hand`() {
        val pairHand = Hand(
            Card(Value.TWO, Suit.SPADE),
            Card(Value.TWO, Suit.HEART),
            Card(Value.FOUR, Suit.CLUB),
            Card(Value.FOUR, Suit.DIAMOND),
            Card(Value.TEN, Suit.HEART)
        )

        pairHand.organizeHand()
        assertThat(handIdentifierService.determineType(pairHand)).isEqualTo(Rank.TWOPAIR)
    }

    @Test
    fun `determineType can identify a ThreeOfAKind hand`() {
        val threeOfAKindHand = Hand(
            Card(Value.TWO, Suit.SPADE),
            Card(Value.TWO, Suit.HEART),
            Card(Value.TWO, Suit.CLUB),
            Card(Value.SIX, Suit.DIAMOND),
            Card(Value.TEN, Suit.HEART)
        )

        threeOfAKindHand.organizeHand()
        assertThat(handIdentifierService.determineType(threeOfAKindHand)).isEqualTo(Rank.THREEOFAKIND)
    }

    @Test
    fun `determinetype can identify a Flush hand`() {
        val flushHand = Hand(
            Card(Value.TWO,Suit.HEART),
            Card(Value.THREE,Suit.HEART),
            Card(Value.FOUR,Suit.HEART),
            Card(Value.SIX,Suit.HEART),
            Card(Value.NINE,Suit.HEART))

        assertThat(handIdentifierService.determineType((flushHand))).isEqualTo(Rank.FLUSH)
    }

    @Test
    fun `determineType can identify a FourOfAKind hand`() {
        val fourOfAKindHand = Hand(
            Card(Value.TWO, Suit.SPADE),
            Card(Value.TWO, Suit.HEART),
            Card(Value.TWO, Suit.CLUB),
            Card(Value.TWO, Suit.DIAMOND),
            Card(Value.TEN, Suit.HEART)
        )

        fourOfAKindHand.organizeHand()
        assertThat(handIdentifierService.determineType(fourOfAKindHand)).isEqualTo(Rank.FOUROFAKIND)
    }

    @Test
    fun `determineType can identify a FullHouse hand`() {
        val fullHouseHand = Hand(
            Card(Value.TWO, Suit.SPADE),
            Card(Value.TWO, Suit.HEART),
            Card(Value.TWO, Suit.CLUB),
            Card(Value.TEN, Suit.DIAMOND),
            Card(Value.TEN, Suit.HEART)
        )

        fullHouseHand.organizeHand()
        assertThat(handIdentifierService.determineType(fullHouseHand)).isEqualTo(Rank.FULLHOUSE)
    }

    @Test
    fun `determineType can identify a Straight hand`() {
        val straightHand = Hand(
            Card(Value.TWO, Suit.SPADE),
            Card(Value.THREE, Suit.HEART),
            Card(Value.FOUR, Suit.CLUB),
            Card(Value.FIVE, Suit.DIAMOND),
            Card(Value.SIX, Suit.HEART)
        )

        val nonStraightHand = Hand(
            Card(Value.TWO, Suit.SPADE),
            Card(Value.THREE, Suit.HEART),
            Card(Value.FOUR, Suit.CLUB),
            Card(Value.SIX, Suit.DIAMOND),
            Card(Value.SEVEN, Suit.HEART)
        )

        assertThat(handIdentifierService.determineType(straightHand)).isEqualTo(Rank.STRAIGHT)
        assertThat(handIdentifierService.determineType(nonStraightHand)).isNotEqualTo(Rank.STRAIGHT)
    }

    @Test
    fun `determineType can identify a StraightFlush hand`() {
        val straightFlushHand = Hand(
            Card(Value.TWO, Suit.HEART),
            Card(Value.THREE, Suit.HEART),
            Card(Value.FOUR, Suit.HEART),
            Card(Value.FIVE, Suit.HEART),
            Card(Value.SIX, Suit.HEART)
        )

        val nonStraightFlushHand = Hand(
            Card(Value.TWO, Suit.SPADE),
            Card(Value.THREE, Suit.HEART),
            Card(Value.FOUR, Suit.CLUB),
            Card(Value.FIVE, Suit.DIAMOND),
            Card(Value.SIX, Suit.HEART)
        )

        assertThat(handIdentifierService.determineType(straightFlushHand)).isEqualTo(Rank.STRAIGHTFLUSH)
        assertThat(handIdentifierService.determineType(nonStraightFlushHand)).isNotEqualTo(Rank.STRAIGHTFLUSH)
    }
}