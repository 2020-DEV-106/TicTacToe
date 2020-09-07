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

        if (isFirstRowFilledByPlayer(PLAYER_X.value)
                || isSecondRowFilledByPlayerX()) {
            winner = PLAYER_X.value;
        }

        if (isFirstRowFilledByPlayer(PLAYER_O.value)
                || isSecondRowFilledByPlayerO()) {
            winner = PLAYER_O.value;
        }

        return winner;
    }

    private boolean isSecondRowFilledByPlayerO() {
        return getPlayerAt(POSITION_ONE, POSITION_ZERO) == PLAYER_O.value
                && getPlayerAt(POSITION_ONE, POSITION_ONE) == PLAYER_O.value
                && getPlayerAt(POSITION_ONE, POSITION_TWO) == PLAYER_O.value;
    }

    private boolean isSecondRowFilledByPlayerX() {
        return getPlayerAt(POSITION_ONE, POSITION_ZERO) == PLAYER_X.value
                && getPlayerAt(POSITION_ONE, POSITION_ONE) == PLAYER_X.value
                && getPlayerAt(POSITION_ONE, POSITION_TWO) == PLAYER_X.value;
    }

    private boolean isFirstRowFilledByPlayer(char player) {
        return getPlayerAt(POSITION_ZERO, POSITION_ZERO) == player
                && getPlayerAt(POSITION_ZERO, POSITION_ONE) == player
                && getPlayerAt(POSITION_ZERO, POSITION_TWO) == player;
    }

}