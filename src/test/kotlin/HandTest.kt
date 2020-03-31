import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class HandTest {

    val validHand = Hand(
        Card(Value.TWO, 'H'),
        Card(Value.THREE, 'H'),
        Card(Value.THREE, 'S'),
        Card(Value.KING, 'H'),
        Card(Value.JACK, 'H')
    )

    val twoPairHand = Hand(
        Card(Value.TWO, 'H'),
        Card(Value.TWO, 'S'),
        Card(Value.THREE, 'S'),
        Card(Value.THREE, 'H'),
        Card(Value.JACK, 'H')
    )

    val threeOfAKindHand = Hand(
        Card(Value.TWO, 'H'),
        Card(Value.TWO, 'S'),
        Card(Value.TWO, 'C'),
        Card(Value.THREE, 'H'),
        Card(Value.JACK, 'H')
    )

    @Test
    fun `organizeHand throws an exception is hand isn't valid`() {

        try {
            Hand(
                Card(Value.FOUR, 'H'),
                Card(Value.FOUR, 'H'),
                Card(Value.FOUR, 'H'),
                Card(Value.FOUR, 'H'),
                Card(Value.FOUR, 'H')
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
        assertThat(validHand.cards.containsValue(listOf(Card(Value.KING, 'H'))))
    }

    @Test
    fun `determineHighCard finds the highest card in the hand`() {
        val expectedCard = Card(Value.KING, 'H')
        assertThat(validHand.determineHighCard()).isEqualTo(expectedCard)
    }

    @Test
    fun `determineHighestPairedCard finds the highest paired card in the hand`() {
        twoPairHand.organizeHand()
        val expectedCard = Card(Value.THREE, 'S')
        assertThat(twoPairHand.determineHighestPairedCard()).isEqualTo(expectedCard)
    }

    @Test
    fun `determineThreeOfAKindCard finds a card whose value matches the three of a kind in the hand`() {
        threeOfAKindHand.organizeHand()
        val expectedCard = Card(Value.TWO, 'H')
        assertThat(threeOfAKindHand.determineThreeOfAKindCard().value).isEqualTo(expectedCard.value)
    }
}