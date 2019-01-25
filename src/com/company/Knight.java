package com.company;

import java.awt.*;
import java.util.ArrayList;

public class Knight extends Piece{

    public Knight(Point position, boolean isWhite) {
        super(position, isWhite);
    }

    @Override
    ArrayList<Point> generateValidMoves(Board board) {

        ArrayList<Point> vaildMoves = new ArrayList<>();
        ArrayList<Point> moves = new ArrayList<>();

        moves.add(new Point((int) this.position.getX() + 2, (int) this.position.getY() + 1));
        moves.add(new Point((int) this.position.getX() + 1, (int) this.position.getY() + 2));
        moves.add(new Point((int) this.position.getX() - 2, (int) this.position.getY() + 1));
        moves.add(new Point((int) this.position.getX() + 1, (int) this.position.getY() - 2));
        moves.add(new Point((int) this.position.getX() - 1, (int) this.position.getY() + 2));
        moves.add(new Point((int) this.position.getX() + 2, (int) this.position.getY() - 1));
        moves.add(new Point((int) this.position.getX() - 2, (int) this.position.getY() - 1));
        moves.add(new Point((int) this.position.getX() - 1, (int) this.position.getY() - 2));

        for (Point move : moves) {
            if (isOnBoard(move) && isSpaceEmpty(move, board) && isSpaceEmptyOfAllies(move, board)) {
                vaildMoves.add(move);
            }
        }

        return vaildMoves;
    }
}
