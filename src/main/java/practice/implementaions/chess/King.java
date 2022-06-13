package practice.implementaions.chess;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;

public class King extends Piece{
    @Override
    public List<CellPosition> possibleMoves(CellPosition fromCellPosition) {
        return null;
    }

    @Override
    public boolean canMove(CellPosition fromCellPosition, CellPosition toCellPosition) {
        return false;
    }

    @Override
    public boolean move(CellPosition fromCellPosition, CellPosition toCellPosition) {
        return false;
    }


}
