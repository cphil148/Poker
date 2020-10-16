import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class DetermineWinnerServiceTest{

    val winnerService = DetermineWinnerService()
    @Test
    fun `compare Hands can determine winner by High Card (regardless of order)`() {
        val handOne = Hand(
            Card(Value.TWO,Suit.SPADE),
            Card(Value.THREE,Suit.SPADE),
            Card(Value.FOUR,Suit.CLUB),
            Card(Value.SIX,Suit.DIAMOND),
            Card(Value.TEN,Suit.HEART))

        val handTwo = Hand(
            Card(Value.TWO,Suit.SPADE),
            Card(Value.THREE,Suit.SPADE),
            Card(Value.FOUR,Suit.CLUB),
            Card(Value.SIX,Suit.DIAMOND),
            Card(Value.NINE,Suit.HEART))


        assertThat(winnerService.compareHands(handOne,handTwo)).isEqualTo(handOne)
        assertThat(winnerService.compareHands(handTwo,handOne)).isEqualTo(handOne)

    }

    @Test
    fun `compare Hands can determine winner by Pairs (regardless of order)`() {
        val handOne = Hand(
            Card(Value.TWO,Suit.SPADE),
            Card(Value.TWO,Suit.HEART),
            Card(Value.FOUR,Suit.CLUB),
            Card(Value.SIX,Suit.DIAMOND),
            Card(Value.TEN,Suit.HEART))

        val handTwo = Hand(
            Card(Value.TWO,Suit.SPADE),
            Card(Value.THREE,Suit.SPADE),
            Card(Value.THREE,Suit.CLUB),
            Card(Value.SIX,Suit.DIAMOND),
            Card(Value.NINE,Suit.HEART))


        assertThat(winnerService.compareHands(handOne,handTwo)).isEqualTo(handTwo)
        assertThat(winnerService.compareHands(handTwo,handOne)).isEqualTo(handTwo)
    }

    @Test
    fun `compare Hands can determine winner by TwoPairs (regardless of order)`() {
        val handOne = Hand(
            Card(Value.SIX,Suit.SPADE),
            Card(Value.SIX,Suit.HEART),
            Card(Value.TWO,Suit.CLUB),
            Card(Value.TWO,Suit.DIAMOND),
            Card(Value.TEN,Suit.HEART))

        val handTwo = Hand(
            Card(Value.TWO,Suit.SPADE),
            Card(Value.THREE,Suit.SPADE),
            Card(Value.THREE,Suit.CLUB),
            Card(Value.FOUR,Suit.DIAMOND),
            Card(Value.FOUR,Suit.HEART))


        assertThat(winnerService.compareHands(handOne,handTwo)).isEqualTo(handOne)
        assertThat(winnerService.compareHands(handTwo,handOne)).isEqualTo(handOne)
    }

    @Test
    fun `compare Hands can determine winner by ThreeOfAKind (regardless of order)`() {
        val threeOfAKindHandOne = Hand(
            Card(Value.SIX,Suit.SPADE),
            Card(Value.FIVE,Suit.HEART),
            Card(Value.TWO,Suit.CLUB),
            Card(Value.TWO,Suit.DIAMOND),
            Card(Value.TWO,Suit.HEART))

        val threeOfAKindHandTwo = Hand(
            Card(Value.TWO,Suit.SPADE),
            Card(Value.THREE,Suit.SPADE),
            Card(Value.THREE,Suit.CLUB),
            Card(Value.THREE,Suit.DIAMOND),
            Card(Value.FOUR,Suit.HEART))


        assertThat(winnerService.compareHands(threeOfAKindHandOne,threeOfAKindHandTwo)).isEqualTo(threeOfAKindHandTwo)
        assertThat(winnerService.compareHands(threeOfAKindHandTwo,threeOfAKindHandOne)).isEqualTo(threeOfAKindHandTwo)
    }

    @Test
    fun `compare Hands can determine winner by FullHouse (regardless of order)`() {
        val fullHouseHandOne = Hand(
            Card(Value.SIX,Suit.SPADE),
            Card(Value.SIX,Suit.HEART),
            Card(Value.TWO,Suit.CLUB),
            Card(Value.TWO,Suit.DIAMOND),
            Card(Value.TWO,Suit.HEART))

        val fullHouseHandTwo = Hand(
            Card(Value.FOUR,Suit.SPADE),
            Card(Value.THREE,Suit.SPADE),
            Card(Value.THREE,Suit.CLUB),
            Card(Value.THREE,Suit.DIAMOND),
            Card(Value.FOUR,Suit.HEART))


        assertThat(winnerService.compareHands(fullHouseHandOne,fullHouseHandTwo)).isEqualTo(fullHouseHandTwo)
        assertThat(winnerService.compareHands(fullHouseHandTwo,fullHouseHandOne)).isEqualTo(fullHouseHandTwo)
    }

    @Test
    fun `compare Hands can determine winner by FourOfAKind (regardless of order)`() {
        val fourOfAKindHandOne = Hand(
            Card(Value.SIX,Suit.SPADE),
            Card(Value.TWO,Suit.SPADE),
            Card(Value.TWO,Suit.CLUB),
            Card(Value.TWO,Suit.DIAMOND),
            Card(Value.TWO,Suit.HEART))

        val fourOfAKindHandTwo = Hand(
            Card(Value.TWO,Suit.SPADE),
            Card(Value.THREE,Suit.SPADE),
            Card(Value.THREE,Suit.CLUB),
            Card(Value.THREE,Suit.DIAMOND),
            Card(Value.THREE,Suit.HEART))


        assertThat(winnerService.compareHands(fourOfAKindHandOne,fourOfAKindHandTwo)).isEqualTo(fourOfAKindHandTwo)
        assertThat(winnerService.compareHands(fourOfAKindHandTwo,fourOfAKindHandOne)).isEqualTo(fourOfAKindHandTwo)
    }

    @Test
    fun `compare Hands can determine winner by Flush (regardless of order)`() {
        val flushOfAKindHandOne = Hand(
            Card(Value.TWO,Suit.SPADE),
            Card(Value.THREE,Suit.SPADE),
            Card(Value.FOUR,Suit.SPADE),
            Card(Value.SIX,Suit.SPADE),
            Card(Value.TEN,Suit.SPADE))

        val flushOfAKindHandTwo = Hand(
            Card(Value.TWO,Suit.HEART),
            Card(Value.THREE,Suit.HEART),
            Card(Value.FOUR,Suit.HEART),
            Card(Value.SIX,Suit.HEART),
            Card(Value.NINE,Suit.HEART))


        assertThat(winnerService.compareHands(flushOfAKindHandOne,flushOfAKindHandTwo)).isEqualTo(flushOfAKindHandOne)
        assertThat(winnerService.compareHands(flushOfAKindHandTwo,flushOfAKindHandOne)).isEqualTo(flushOfAKindHandOne)
    }

    @Test
    fun `compare Hands can determine winner by Straight (regardless of order)`() {
        val straightHandOne = Hand(
            Card(Value.TWO,Suit.SPADE),
            Card(Value.THREE,Suit.SPADE),
            Card(Value.FOUR,Suit.SPADE),
            Card(Value.FIVE,Suit.DIAMOND),
            Card(Value.SIX,Suit.SPADE))

        val straightHandTwo = Hand(
            Card(Value.FIVE,Suit.HEART),
            Card(Value.SIX,Suit.HEART),
            Card(Value.SEVEN,Suit.HEART),
            Card(Value.EIGHT,Suit.DIAMOND),
            Card(Value.NINE,Suit.HEART))


        assertThat(winnerService.compareHands(straightHandOne,straightHandTwo)).isEqualTo(straightHandTwo)
        assertThat(winnerService.compareHands(straightHandTwo,straightHandOne)).isEqualTo(straightHandTwo)
    }

    @Test
    fun `compare Hands can determine winner by StraightFlush (regardless of order)`() {
        val straightFlushHandOne = Hand(
            Card(Value.TWO,Suit.SPADE),
            Card(Value.THREE,Suit.SPADE),
            Card(Value.FOUR,Suit.SPADE),
            Card(Value.FIVE,Suit.SPADE),
            Card(Value.SIX,Suit.SPADE))

        val straightFlushHandTwo = Hand(
            Card(Value.FIVE,Suit.HEART),
            Card(Value.SIX,Suit.HEART),
            Card(Value.SEVEN,Suit.HEART),
            Card(Value.EIGHT,Suit.HEART),
            Card(Value.NINE,Suit.HEART))


        assertThat(winnerService.compareHands(straightFlushHandOne,straightFlushHandTwo)).isEqualTo(straightFlushHandTwo)
        assertThat(winnerService.compareHands(straightFlushHandTwo,straightFlushHandOne)).isEqualTo(straightFlushHandTwo)
    }
}