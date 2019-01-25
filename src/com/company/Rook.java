package com.company;

import java.awt.*;
import java.util.ArrayList;

public class Rook extends Piece {

    public Rook(Point position, boolean isWhite) {
        super(position, isWhite);
    }

    @Override
    ArrayList<Point> generateValidMoves(Board board) {
        ArrayList<Point> validMoves = new ArrayList<>();

        validMoves.addAll(movesInDirection(1,0, board)); // Checks upward moves
        validMoves.addAll(movesInDirection(0,1, board)); // Checks moves to the right
        validMoves.addAll(movesInDirection(-1,0, board)); // Checks downwards moves
        validMoves.addAll(movesInDirection(0,-1, board)); // checks moves to the left

        return validMoves;
    }
}
