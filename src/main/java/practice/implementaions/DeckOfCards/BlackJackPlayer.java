package practice.implementaions.DeckOfCards;

public class BlackJackPlayer extends Player{

    public BlackJackPlayer(String name){
        super(name);
    }
    @Override
    boolean canPlay() {
        return getTotalPoints()<21;
    }

    @Override
    boolean wantToPlay() {
        return getTotalPoints()<17;
    }
}
