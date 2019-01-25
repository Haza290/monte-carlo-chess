package com.company;

import java.awt.*;
import java.util.ArrayList;

public class Queen extends Piece {

    public Queen(Point position, boolean isWhite) {
        super(position, isWhite);
    }

    @Override
    ArrayList<Point> generateValidMoves(Board board) {
        ArrayList<Point> validMoves = new ArrayList<>();

        validMoves.addAll(movesInDirection(1,0, board)); // Checks upward moves
        validMoves.addAll(movesInDirection(0,1, board)); // Checks moves to the right
        validMoves.addAll(movesInDirection(-1,0, board)); // Checks downwards moves
        validMoves.addAll(movesInDirection(0,-1, board)); // checks moves to the left

        validMoves.addAll(movesInDirection(1,1, board)); // Checks upward and right moves
        validMoves.addAll(movesInDirection(-1,1, board)); // Checks upward and left moves
        validMoves.addAll(movesInDirection(1,-1, board)); // Checks downwards and right moves
        validMoves.addAll(movesInDirection(-1,-1, board)); // checks downwards and left moves


        return validMoves;
    }


}
