import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class CardTest{

    private val aceCard = Card(Value.ACE)

    private val twoCard = Card(Value.TWO)

    @Test
    fun `Ace should be higher than Two`() {
        assertThat(aceCard.value > twoCard.value).isTrue()
        assertThat(aceCard.value < twoCard.value).isFalse()
    }

    @Test
    fun `Two cards of the same value are equal`() {
        val fiveCard = Card(Value.FIVE)
        val anotherFiveCard = Card(Value.FIVE)
        assertThat(fiveCard.value == anotherFiveCard.value).isTrue()
    }
}