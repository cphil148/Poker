
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class HandTest{

    @Test
    fun `A hand has exactly five cards`() {
        val hand = Hand(Card(Value.FOUR, 'H'),
                               Card(Value.FOUR, 'H'),
                               Card(Value.FOUR, 'H'),
                               Card(Value.FOUR, 'H'),
                               Card(Value.FOUR, 'H'))

        assertThat(hand.cards.size).isEqualTo(5)
    }
}