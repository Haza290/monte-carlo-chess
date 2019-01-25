package com.company;

import java.awt.*;
import java.util.ArrayList;

public class Bishop extends Piece {

    public Bishop(Point position, boolean isWhite) {
        super(position, isWhite);
    }

    @Override
    ArrayList<Point> generateValidMoves(Board board) {
        ArrayList<Point> validMoves = new ArrayList<>();

        validMoves.addAll(movesInDirection(1,1, board)); // Checks upward and right moves
        validMoves.addAll(movesInDirection(-1,1, board)); // Checks upward and left moves
        validMoves.addAll(movesInDirection(1,-1, board)); // Checks downwards and right moves
        validMoves.addAll(movesInDirection(-1,-1, board)); // checks downwards and left moves

        return validMoves;
    }


}
