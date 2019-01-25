package com.company;

import java.awt.*;
import java.util.ArrayList;

public class Pawn extends Piece {

    boolean isFirstMove = false;


    public Pawn(Point position, boolean isWhite) {
        super(position, isWhite);
    }

    @Override
    ArrayList<Point> generateValidMoves(Board board) {

        ArrayList<Point> validMoves = new ArrayList<>();

        int yForwardMove;

        if (isWhite) {
            yForwardMove = 1;
        } else {
            yForwardMove = -1;
        }

        Point forwardMove = new Point((int)this.position.getX(), (int)this.position.getY() + yForwardMove);
        if (isOnBoard(forwardMove) && isSpaceEmpty(forwardMove, board) && isSpaceEmptyOfAllies(forwardMove, board)) {
            validMoves.add(forwardMove);
        }

        ArrayList<Point> captureMoves = new ArrayList<>();
        captureMoves.add(new Point((int)this.position.getX() - 1, (int)this.position.getY() + yForwardMove));
        captureMoves.add(new Point((int)this.position.getX() + 1, (int)this.position.getY() + yForwardMove));

        for (Point captureMove : captureMoves) {
            if (isOnBoard(captureMove) && !isSpaceEmpty(captureMove, board) && !isSpaceEmptyOfAllies(captureMove, board)) {
                validMoves.add(captureMove);
            }
        }

        // Need to add king pin check on all valid moves

        return validMoves;
    }
}
