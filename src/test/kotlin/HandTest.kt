import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class HandTest {

    val validHand = Hand(
        Card(Value.TWO, Suit.HEART),
        Card(Value.THREE, Suit.HEART),
        Card(Value.THREE, Suit.SPADE),
        Card(Value.KING, Suit.HEART),
        Card(Value.JACK, Suit.HEART)
    )

    val twoPairHand = Hand(
        Card(Value.TWO, Suit.HEART),
        Card(Value.TWO, Suit.SPADE),
        Card(Value.THREE, Suit.SPADE),
        Card(Value.THREE, Suit.HEART),
        Card(Value.JACK, Suit.HEART)
    )

    val threeOfAKindHand = Hand(
        Card(Value.TWO, Suit.HEART),
        Card(Value.TWO, Suit.SPADE),
        Card(Value.TWO, Suit.CLUB),
        Card(Value.THREE, Suit.HEART),
        Card(Value.JACK, Suit.HEART)
    )

    val fourOfAKindHand = Hand(
        Card(Value.TWO, Suit.HEART),
        Card(Value.TWO, Suit.SPADE),
        Card(Value.TWO, Suit.CLUB),
        Card(Value.TWO, Suit.DIAMOND),
        Card(Value.JACK, Suit.HEART)
    )

    @Test
    fun `organizeHand throws an exception is hand isn't valid`() {

        try {
            Hand(
                Card(Value.FOUR, Suit.HEART),
                Card(Value.FOUR, Suit.HEART),
                Card(Value.FOUR, Suit.HEART),
                Card(Value.FOUR, Suit.HEART),
                Card(Value.FOUR, Suit.HEART)
            ).organizeHand()
        } catch (e: Exception) {
            assertThat(e.message).isEqualTo("Cannot Organize invalid hand")
        }
    }

    @Test
    fun `organizeHand returns false if hand has not been organized`() {
        assertThat(validHand.isOrganized).isFalse()
    }

    @Test
    fun `organizeHand returns true if cards contains at least one list that isn't empty`() {
        validHand.organizeHand()
        assertThat(validHand.isOrganized).isTrue()
        assertThat(validHand.cards.containsValue(listOf(Card(Value.KING, Suit.HEART))))
    }

    @Test
    fun `determineHighCard finds the highest card in the hand`() {
        val expectedCard = Card(Value.KING, Suit.HEART)
        assertThat(validHand.determineHighCard()).isEqualTo(expectedCard)
    }

    @Test
    fun `determineHighestPairedCard finds the highest paired card in the hand`() {
        twoPairHand.organizeHand()
        val expectedCard = Card(Value.THREE, Suit.SPADE)
        assertThat(twoPairHand.determineHighestPairedCard()).isEqualTo(expectedCard)
    }

    @Test
    fun `determineThreeOfAKindCard finds a card whose value matches the three of a kind in the hand`() {
        threeOfAKindHand.organizeHand()
        val expectedCard = Card(Value.TWO, Suit.HEART)
        assertThat(threeOfAKindHand.determineThreeOfAKindCard().value).isEqualTo(expectedCard.value)
    }

    @Test
    fun `determineFourOfAKindCard finds a card whose value matches the three of a kind in the hand`() {
        fourOfAKindHand.organizeHand()
        val expectedCard = Card(Value.TWO, Suit.HEART)
        assertThat(fourOfAKindHand.determineFourOfAKindCard().value).isEqualTo(expectedCard.value)
    }
}