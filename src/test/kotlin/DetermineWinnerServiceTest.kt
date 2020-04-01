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

    @Test
    fun `compare Hands can determine winner by TwoPairs (regardless of order)`() {
        val handOne = Hand(
            Card(Value.SIX,'S'),
            Card(Value.SIX,'H'),
            Card(Value.TWO,'C'),
            Card(Value.TWO,'D'),
            Card(Value.TEN,'H'))

        val handTwo = Hand(
            Card(Value.TWO,'S'),
            Card(Value.THREE,'S'),
            Card(Value.THREE,'C'),
            Card(Value.FOUR,'D'),
            Card(Value.FOUR,'H'))


        assertThat(winnerService.compareHands(handOne,handTwo)).isEqualTo(handOne)
        assertThat(winnerService.compareHands(handTwo,handOne)).isEqualTo(handOne)
    }

    @Test
    fun `compare Hands can determine winner by ThreeOfAKind (regardless of order)`() {
        val threeOfAKindHandOne = Hand(
            Card(Value.SIX,'S'),
            Card(Value.FIVE,'H'),
            Card(Value.TWO,'C'),
            Card(Value.TWO,'D'),
            Card(Value.TWO,'H'))

        val threeOfAKindHandTwo = Hand(
            Card(Value.TWO,'S'),
            Card(Value.THREE,'S'),
            Card(Value.THREE,'C'),
            Card(Value.THREE,'D'),
            Card(Value.FOUR,'H'))


        assertThat(winnerService.compareHands(threeOfAKindHandOne,threeOfAKindHandTwo)).isEqualTo(threeOfAKindHandTwo)
        assertThat(winnerService.compareHands(threeOfAKindHandTwo,threeOfAKindHandOne)).isEqualTo(threeOfAKindHandTwo)
    }

    @Test
    fun `compare Hands can determine winner by FourOfAKind (regardless of order)`() {
        val fourOfAKindHandOne = Hand(
            Card(Value.SIX,'S'),
            Card(Value.TWO,'S'),
            Card(Value.TWO,'C'),
            Card(Value.TWO,'D'),
            Card(Value.TWO,'H'))

        val fourOfAKindHandTwo = Hand(
            Card(Value.TWO,'S'),
            Card(Value.THREE,'S'),
            Card(Value.THREE,'C'),
            Card(Value.THREE,'D'),
            Card(Value.THREE,'H'))


        assertThat(winnerService.compareHands(fourOfAKindHandOne,fourOfAKindHandTwo)).isEqualTo(fourOfAKindHandTwo)
        assertThat(winnerService.compareHands(fourOfAKindHandTwo,fourOfAKindHandOne)).isEqualTo(fourOfAKindHandTwo)
    }
}