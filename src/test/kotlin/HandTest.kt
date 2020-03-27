
import org.assertj.core.api.Assertions.assertThat
import org.junit.Ignore
import org.junit.Test

class HandTest{

    val invalidHand = Hand(
        Card(Value.FOUR, 'H'),
        Card(Value.FOUR, 'H'),
        Card(Value.FOUR, 'H'),
        Card(Value.FOUR, 'H'),
        Card(Value.FOUR, 'H'))

    val validHand = Hand(
        Card(Value.TWO, 'H'),
        Card(Value.THREE, 'H'),
        Card(Value.THREE, 'S'),
        Card(Value.KING, 'H'),
        Card(Value.JACK, 'H'))

    @Test
    fun `isValid returns true if it is`() {
        assertThat(invalidHand.isValid()).isFalse()
        assertThat(validHand.isValid()).isTrue()
    }

    @Test
    fun `organizeHand returns false if hand has not been organized`() {
        assertThat(invalidHand.isOrganized).isFalse()
        assertThat(validHand.isOrganized).isFalse()
    }

    @Test
    fun `organizeHand throws an exception is hand isn't valid`() {
        try{
            invalidHand.organizeHand()
        }catch(e: Exception){
            assertThat(e.message).isEqualTo("Cannot Organize invalid hand")
        }
    }

    @Test
    fun `organizeHand return true if cards contains at least one list that isn't empty`() {
        validHand.organizeHand()
        assertThat(validHand.isOrganized).isTrue()
        assertThat(validHand.cards.containsValue(listOf(Card(Value.KING,'H'))))
    }
}