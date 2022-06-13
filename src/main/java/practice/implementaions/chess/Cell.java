package practice.implementaions.chess;

import lombok.Getter;
import lombok.Setter;
import practice.implementaions.chess.DataTypes.Colour;

@Setter
@Getter
public class Cell {
    private Colour colour;
    private CellPosition cellPosition;
    private Piece piece;
}
