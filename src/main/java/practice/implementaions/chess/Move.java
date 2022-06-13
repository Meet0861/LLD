package practice.implementaions.chess;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Move {
    Player turn;
    Piece piece;
    Piece pieceKilled;
    CellPosition startPosition;
    CellPosition endPosition;
}
