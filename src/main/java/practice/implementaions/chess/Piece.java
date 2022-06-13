package practice.implementaions.chess;


import practice.implementaions.chess.DataTypes.Colour;
import practice.implementaions.chess.DataTypes.PieceType;

import java.util.List;

public abstract class Piece {

    private Colour colour;
    private PieceType pieceType;
    public abstract List<CellPosition> possibleMoves(CellPosition fromCellPosition);
    public abstract boolean canMove(CellPosition fromCellPosition, CellPosition toCellPosition);
    public abstract boolean move(CellPosition fromCellPosition, CellPosition toCellPosition);

}
