import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class HandIdentifierServiceTest {

    val handIdentifierService = HandIdentifierService()

    @Test
    fun `determineType can identify a highCard hand`() {
        val highCardHand = Hand(
            Card(Value.TWO, 'S'),
            Card(Value.THREE, 'S'),
            Card(Value.FOUR, 'C'),
            Card(Value.SIX, 'D'),
            Card(Value.TEN, 'H')
        )

        highCardHand.organizeHand()

        assertThat(handIdentifierService.determineType(highCardHand)).isEqualTo(Rank.HIGHCARD)
    }

    @Test
    fun `determineType can identify a Pair hand`() {
        val pairHand = Hand(
            Card(Value.TWO, 'S'),
            Card(Value.TWO, 'H'),
            Card(Value.FOUR, 'C'),
            Card(Value.SIX, 'D'),
            Card(Value.TEN, 'H')
        )

        pairHand.organizeHand()
        assertThat(handIdentifierService.determineType(pairHand)).isEqualTo(Rank.PAIR)
    }

    @Test
    fun `determineType can identify a TwoPair hand`() {
        val pairHand = Hand(
            Card(Value.TWO, 'S'),
            Card(Value.TWO, 'H'),
            Card(Value.FOUR, 'C'),
            Card(Value.FOUR, 'D'),
            Card(Value.TEN, 'H')
        )

        pairHand.organizeHand()
        assertThat(handIdentifierService.determineType(pairHand)).isEqualTo(Rank.TWOPAIR)
    }

    @Test
    fun `determineType can identify a ThreeOfAKind hand`() {
        val threeOfAKindHand = Hand(
            Card(Value.TWO, 'S'),
            Card(Value.TWO, 'H'),
            Card(Value.TWO, 'C'),
            Card(Value.SIX, 'D'),
            Card(Value.TEN, 'H')
        )

        threeOfAKindHand.organizeHand()
        assertThat(handIdentifierService.determineType(threeOfAKindHand)).isEqualTo(Rank.THREEOFAKIND)
    }

    @Test
    fun `determinetype can identify a Flush hand`() {
        val flushHand = Hand(
            Card(Value.TWO,'H'),
            Card(Value.THREE,'H'),
            Card(Value.FOUR,'H'),
            Card(Value.SIX,'H'),
            Card(Value.NINE,'H'))

        assertThat(handIdentifierService.determineType((flushHand))).isEqualTo(Rank.FLUSH)
    }

    @Test
    fun `determineType can identify a FourOfAKind hand`() {
        val fourOfAKindHand = Hand(
            Card(Value.TWO, 'S'),
            Card(Value.TWO, 'H'),
            Card(Value.TWO, 'C'),
            Card(Value.TWO, 'D'),
            Card(Value.TEN, 'H')
        )

        fourOfAKindHand.organizeHand()
        assertThat(handIdentifierService.determineType(fourOfAKindHand)).isEqualTo(Rank.FOUROFAKIND)
    }

    @Test
    fun `determineType can identify a FullHouse hand`() {
        val fullHouseHand = Hand(
            Card(Value.TWO, 'S'),
            Card(Value.TWO, 'H'),
            Card(Value.TWO, 'C'),
            Card(Value.TEN, 'D'),
            Card(Value.TEN, 'H')
        )

        fullHouseHand.organizeHand()
        assertThat(handIdentifierService.determineType(fullHouseHand)).isEqualTo(Rank.FULLHOUSE)
    }
}