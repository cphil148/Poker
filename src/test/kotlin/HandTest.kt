
import org.assertj.core.api.Assertions.assertThat
import org.junit.Ignore
import org.junit.Test

class HandTest{

    val validHand = Hand(
        Card(Value.TWO, 'H'),
        Card(Value.THREE, 'H'),
        Card(Value.THREE, 'S'),
        Card(Value.KING, 'H'),
        Card(Value.JACK, 'H'))


    @Test
    fun `organizeHand returns false if hand has not been organized`() {
        assertThat(validHand.isOrganized).isFalse()
    }

    @Test
    fun `organizeHand return true if cards contains at least one list that isn't empty`() {
        validHand.organizeHand()
        assertThat(validHand.isOrganized).isTrue()
        assertThat(validHand.cards.containsValue(listOf(Card(Value.KING,'H'))))
    }

    @Test
    fun `determineHighCard finds the highest card in the hand`() {
        val expectedCard = Card(Value.KING,'H')
        assertThat(validHand.determineHighCard()).isEqualTo(expectedCard)
    }
}