import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class CardTest{

    private val diamondAceCard = Card(Value.ACE, 'D')
    private val heartAceCard = Card(Value.ACE, 'H')
    private val twoCard = Card(Value.TWO, 'D')

    @Test
    fun `Cards of higher value are greater than cards of lower value`() {
        assertThat(heartAceCard.value > twoCard.value).isTrue()
        assertThat(heartAceCard.value < twoCard.value).isFalse()
    }

    @Test
    fun `Two Different cards of the same value are equal`() {
        assertThat(heartAceCard.value == diamondAceCard.value).isTrue()
    }

    @Test
    fun `A card has a suite`() {
        assertThat(heartAceCard.suit).isNotNull()
    }
}