package com.company;

import java.awt.*;
import java.util.ArrayList;

public class Board {

    private Piece[][] board;

    public Board() {
        board = new Piece[8][8];
    }

    public ArrayList<Piece> getPieces(boolean isWhite) {

        ArrayList<Piece> pieces = new ArrayList<>();

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board.length; y++) {
                if(null != board[x][y] && isWhite == board[x][y].isWhite()) {
                    pieces.add(board[x][y]);
                }
            }
        }

        return pieces;
    }

    public Piece getPieceAtPoint(Point point) {
        return board[(int) point.getX()][(int) point.getY()];
    }

    public void makeMove(Piece piece, Point point) {
        board[(int) piece.getPosition().getX()][(int) piece.getPosition().getY()] = null;
        board[(int) point.getX()][(int) point.getY()] = piece;
    }
}
