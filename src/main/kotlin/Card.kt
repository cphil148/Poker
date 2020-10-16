

data class Card(val value: Value, val suit: Suit) {

}

enum class Value{
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

enum class Suit{
    HEART,
    DIAMOND,
    SPADE,
    CLUB
}