package com.tdd.kata;

import static com.tdd.kata.Player.PLAYER_X;
import static com.tdd.kata.Player.PLAYER_O;

public class Game {

    private static final int POSITION_ZERO = 0;
    private static final int POSITION_ONE = 1;
    private static final int POSITION_TWO = 2;
    private char previousPlayer;
    private final Board board;

    public Game() {
        board = new Board();
    }

    public void playAt(int row, int column) {
        char currentPlayer = getCurrentPlayer();
        board.playAt(row, column, currentPlayer);
        setPreviousPlayer(currentPlayer);
    }

    private void setPreviousPlayer(char currentPlayer) {
        previousPlayer = currentPlayer;
    }

    private char getCurrentPlayer() {
        return previousPlayer == PLAYER_X.value ? PLAYER_O.value : PLAYER_X.value;
    }

    public char getPlayerAt(int row, int column) {
        return board.getPlayerAt(row, column);
    }

    public char getWinner() {
        char winner = '\0';

        if (isFirstRowFilledByPlayerO(PLAYER_X.value)) {
            winner = PLAYER_X.value;
        }

        if (isFirstRowFilledByPlayerO(PLAYER_O.value)) {
            winner = PLAYER_O.value;
        }

        return winner;
    }

    private boolean isFirstRowFilledByPlayerO(char playerO) {
        return getPlayerAt(POSITION_ZERO, POSITION_ZERO) == playerO
                && getPlayerAt(POSITION_ZERO, POSITION_ONE) == playerO
                && getPlayerAt(POSITION_ZERO, POSITION_TWO) == playerO;
    }

}