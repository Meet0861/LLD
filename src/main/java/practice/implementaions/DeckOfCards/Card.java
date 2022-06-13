package practice.implementaions.DeckOfCards;

public class Card {
    private Suit suit;
    private FaceValue faceValue;

    public Card(Suit suit, FaceValue point) {
        this.suit = suit;
        this.faceValue = point;
    }

    public Suit getSuit() {
        return suit;
    }

    public FaceValue getFaceValue() {
        return faceValue;
    }

    public int getPoints() {
        if (getFaceValue().ordinal() <= FaceValue.C_10.ordinal())
            return getFaceValue().ordinal() + 1;
        else return 10;
    }

    public String toString() {
        return suit.name() + "-" + faceValue.name();
    }

}
