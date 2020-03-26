import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class CardTest{

    @Test
    fun `Ace should be higher than Two`() {
        val aceCard = Card(Value.ACE)
        val twoCard = Card(Value.TWO)
        assertThat(aceCard.value > twoCard.value).isTrue()
    }
}