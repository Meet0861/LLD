package practice.implementaions.chess;

public interface ChessGame {
    void startPlay(Player P1, Player P2);
    void makeMove(Player player, Move move);
    boolean endGame();
    void changeTurn();
    boolean getGameStatus();

}
