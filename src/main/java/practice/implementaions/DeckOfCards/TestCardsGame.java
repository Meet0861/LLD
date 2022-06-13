package practice.implementaions.DeckOfCards;

import java.util.ArrayList;
import java.util.List;

public class TestCardsGame {
    private Deck deckOfCards = new Deck();
    private Player dealer = new BlackJackPlayer("Steve");
    private Player player = null;
    private List<Move> moves = new ArrayList<>();
    private Card hiddenDealerCard = null;

    public TestCardsGame(String playerName){
        player = new BlackJackPlayer(playerName);
    }
    public static void main(String[] args){
        TestCardsGame testCardsGame = new TestCardsGame("Meet");
        testCardsGame.play();
    }
    public void play() {
        // the first dealer card
        hiddenDealerCard = deckOfCards.removeOneCard();

        // give a card to each player
        giveNewCard(dealer);
        giveNewCard(player);

        // let the player play as long as he wants and we are not over
        while (player.canPlay() && player.wantToPlay() && !gameEnded()) {
            giveNewCard(player);
        }

        // if the player did not get over (and the game ended), let the dealer play
        if (!gameEnded()) {
            // first, turn the hidden card
            giveCard(dealer, hiddenDealerCard);
            // then play until either wins
            while (dealer.canPlay() && !gameEnded()) {
                giveNewCard(dealer);
            }
        }

        // show who won
        showGameWinner();
    }

    public void giveNewCard(Player p) {
        giveCard(p, deckOfCards.removeOneCard());
    }

    public void giveCard(Player p, Card c) {
        Move move = new Move(p, c);
        moves.add(move);
        p.addCard(move.getCard());
        System.out.println(move.toString() + "   (" + p.getTotalPoints() + ")");
    }

    public boolean gameEnded() {
        if (player.getTotalPoints() >= 21) {
            return true;
        } else if (dealer.getTotalPoints() >= 21) {
            return true;
        }
        return false;
    }

    public void showGameWinner() {
        if (player.getTotalPoints() >= 21) {
            System.out.println(player.getName() + " has lost... " + player.getTotalPoints() + " > 21");
        } else if (dealer.getTotalPoints() >= 21) {
            System.out.println(dealer.getName() + " has lost... " + dealer.getTotalPoints() + " > 21");
        }  else {
            Player winner = (player.getTotalPoints() > dealer.getTotalPoints())?player:dealer;
            System.out.println(winner.getName() + " wins... " + winner.getTotalPoints());
        }

    }
}
