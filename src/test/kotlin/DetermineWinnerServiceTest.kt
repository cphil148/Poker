import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class DetermineWinnerServiceTest{

    val winnerService = DetermineWinnerService()
    @Test
    fun `compare Hands can determine winner by High Card (regardless of order)`() {
        val handOne = Hand(
            Card(Value.TWO,'S'),
            Card(Value.THREE,'S'),
            Card(Value.FOUR,'C'),
            Card(Value.SIX,'D'),
            Card(Value.TEN,'H'))

        val handTwo = Hand(
            Card(Value.TWO,'S'),
            Card(Value.THREE,'S'),
            Card(Value.FOUR,'C'),
            Card(Value.SIX,'D'),
            Card(Value.NINE,'H'))


        assertThat(winnerService.compareHands(handOne,handTwo)).isEqualTo(handOne)
        assertThat(winnerService.compareHands(handTwo,handOne)).isEqualTo(handOne)

    }

    @Test
    fun `compare Hands can determine winner by Pairs (regardless of order)`() {
        val handOne = Hand(
            Card(Value.TWO,'S'),
            Card(Value.TWO,'H'),
            Card(Value.FOUR,'C'),
            Card(Value.SIX,'D'),
            Card(Value.TEN,'H'))

        val handTwo = Hand(
            Card(Value.TWO,'S'),
            Card(Value.THREE,'S'),
            Card(Value.THREE,'C'),
            Card(Value.SIX,'D'),
            Card(Value.NINE,'H'))


        assertThat(winnerService.compareHands(handOne,handTwo)).isEqualTo(handTwo)
        assertThat(winnerService.compareHands(handTwo,handOne)).isEqualTo(handTwo)
    }
}