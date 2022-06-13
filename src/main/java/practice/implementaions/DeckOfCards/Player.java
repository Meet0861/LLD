package practice.implementaions.DeckOfCards;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    private String name;
    private List<Card> hand = new ArrayList<>();
    abstract boolean canPlay();
    abstract boolean wantToPlay();

    public Player(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getTotalPoints(){
        int minTotal =0;
        int maxTotal =0;

        for(Card c:hand){
            int points = c.getPoints();
            minTotal+=points;

            maxTotal+=(c.getFaceValue()== FaceValue.ACE_1)?11:points;
        }
        return maxTotal>21?minTotal:maxTotal;
    }

    public void addCard(Card c){
        hand.add(c);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}
