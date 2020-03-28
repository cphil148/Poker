import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class HandIdentifierServiceTest {

    val handIdentifierService = HandIdentifierService()

    @Test
    fun `determineType can identify a highCard hand`() {
        val highCardHand = Hand(
            Card(Value.TWO, 'S'),
            Card(Value.THREE, 'S'),
            Card(Value.FOUR, 'C'),
            Card(Value.SIX, 'D'),
            Card(Value.TEN, 'H')
        )

        highCardHand.organizeHand()

        assertThat(handIdentifierService.determineType(highCardHand)).isEqualTo(Rank.HIGHCARD)
    }

    @Test
    fun `determineType can identify a Pair hand`() {
        val pairHand = Hand(
            Card(Value.TWO, 'S'),
            Card(Value.TWO, 'H'),
            Card(Value.FOUR, 'C'),
            Card(Value.SIX, 'D'),
            Card(Value.TEN, 'H')
        )

        pairHand.organizeHand()
        assertThat(handIdentifierService.determineType(pairHand)).isEqualTo(Rank.PAIR)
    }
}