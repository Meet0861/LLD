package practice.implementaions.DeckOfCards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    List<Card> cards = new ArrayList<>();

    public Deck() {
        createDeck();
        shuffle();
    }

    public void createDeck() {
        for (Suit s : Suit.values()) {
            for (FaceValue p : FaceValue.values()) {
                cards.add(new Card(s, p));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card removeOneCard() {
        if (cards.isEmpty()) throw new RuntimeException("NO MORE CARDS");
        Card card = cards.remove(cards.size() - 1);
        return card;
    }
}
