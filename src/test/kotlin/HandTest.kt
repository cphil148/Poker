
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

    @Test
    fun `A Hand cannot have two cards of equal value and suit`() {
        val invalidHand = Hand(Card(Value.FOUR, 'H'),
            Card(Value.FOUR, 'H'),
            Card(Value.FOUR, 'H'),
            Card(Value.FOUR, 'H'),
            Card(Value.FOUR, 'H'))

        assertThat(invalidHand.isValid()).isTrue()
    }
}