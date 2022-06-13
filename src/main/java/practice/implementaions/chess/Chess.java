package practice.implementaions.chess;

import practice.implementaions.chess.DataTypes.Colour;
import practice.implementaions.chess.DataTypes.GameStatus;

import java.util.List;

public class Chess {
    Player[] players;
    ChessBoard chessBoard;
    List<Move> movesPlayed;
    List<Piece> pieces;
    Player currentPlayer;
    GameStatus gameStatus;

    public void initialize(Player P1, Player P2){
        players[0] = P1;
        players[1] = P2;
        chessBoard.resetBoard();
        if(P1.getColour().equals(Colour.WHITE))
            currentPlayer = P1;
        else
            currentPlayer = P2;

        movesPlayed.clear();
    }
}
