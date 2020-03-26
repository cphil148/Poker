import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class CardTest{

    @Test
    fun `Ace should be higher than Two`() {
        val aceCard = Card(Value.ACE)
        val twoCard = Card(Value.TWO)
        assertThat(aceCard.value > twoCard.value).isTrue()
    }

    @Test
    fun `Two Greater Than Ace Is False`() {
        val aceCard = Card(Value.ACE)
        val twoCard = Card(Value.TWO)
        assertThat(aceCard.value < twoCard.value).isFalse()
    }

    @Test
    fun `Two cards of the same value are equal`() {
        val fiveCard = Card(Value.FIVE)
        val anotherFiveCard = Card(Value.FIVE)
        assertThat(fiveCard.value == anotherFiveCard.value).isTrue()
    }
}