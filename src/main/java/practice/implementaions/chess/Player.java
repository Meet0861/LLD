package practice.implementaions.chess;

import lombok.Getter;
import lombok.Setter;
import practice.implementaions.chess.DataTypes.Colour;

@Getter
@Setter
public abstract class Player {
    private int id;
    private Account account;
    private Colour colour;
}
