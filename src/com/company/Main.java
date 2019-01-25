package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    private Board board;
    private static final int MAX_MOVE_COUNT = 1000;
    private boolean isWhitesMove;

    private Random random = new Random();


    public static void main(String[] args) {
	// write your code here
    }

    public Main(){
        board = new Board();
        isWhitesMove = true;
    }

    private Boolean finishGame() {
        for (int moveCount = 0; moveCount < MAX_MOVE_COUNT; moveCount ++) {
            Piece chosenPiece;
            ArrayList<Point> validMoves;
            ArrayList<Piece> pieces = board.getPieces(isWhitesMove);
            do {
                // If there are no more valid moves then game is a draw
                if (pieces.isEmpty()) {
                    return null;
                }

                chosenPiece = pieces.get(random.nextInt(pieces.size()));
                pieces.remove(chosenPiece);
                validMoves = chosenPiece.generateValidMoves(this.board);
            } while (validMoves.isEmpty());

            makeMove(chosenPiece, validMoves.get(random.nextInt(validMoves.size())));

            if(isGameOver()) {
                return didWhiteWin();
            }
        }
        
        return false;
    }

    private void makeMove(final Piece piece, final Point point) {
        board.makeMove(piece, point);
        piece.move(point);
    }

    private boolean isGameOver() {
        return false;
    }

    private boolean didWhiteWin() {
        return false;
    }


}
