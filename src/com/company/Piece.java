package com.company;

import java.awt.*;
import java.util.ArrayList;

public abstract class Piece {

    boolean isWhite;
    Point position;
    abstract ArrayList<Point> generateValidMoves(Board board);

    public Piece(Point position, boolean isWhite) {
        this.position = position;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public Point getPosition() {
        return position;
    }

    public boolean isOnBoard(Point point) {
        return point.getX() >= 0 && point.getX() < 8 && point.getY() >= 0 && point.getY() < 8;
    }

    public boolean isSpaceEmpty(Point point, Board board) {
        return null == board.getPieceAtPoint(point);
    }

    public boolean isSpaceEmptyOfAllies(Point point, Board board) {
        return board.getPieceAtPoint(point).isWhite != this.isWhite;
    }

    public void move(Point point) {
        this.position.setLocation(point);
    }

    public ArrayList<Point> movesInDirection(int xMove, int yMove, Board board) {

        ArrayList<Point> validMoves = new ArrayList<>();
        int xOffset = 0;
        int yOffset = 0;

        while(true) {

            xOffset =+ xMove;
            yOffset =+ yMove;

            Point move = new Point((int) this.position.getX() + xOffset, (int) this.position.getY() + yOffset);
            if (isOnBoard(move)){
                if (isSpaceEmpty(move, board)) {
                    validMoves.add(move);
                } else {
                    if (!isSpaceEmptyOfAllies(move, board)) {
                        validMoves.add(move);
                    }
                    break;
                }
            } else {
                break;
            }
        }
        return validMoves;
    }
}
