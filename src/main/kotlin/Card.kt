

data class Card(val Value: CardValue, val suit: Suits) {


}

enum class CardValue{
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING,
    ACE
}

enum class Suits{
    SPADES,
    CLUBS,
    HEARTS,
    DIAMONDS
}