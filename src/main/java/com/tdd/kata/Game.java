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

        if (isAnyRowFilledByPlayer(PLAYER_X.value)
                || isFirstColumnFilledByPlayer(PLAYER_X.value)
                || isSecondColumnFilledByPlayer(PLAYER_X.value)
                || isThirdColumnFilledByPlayerX()) {
            winner = PLAYER_X.value;
        }

        if (isAnyRowFilledByPlayer(PLAYER_O.value)
                || isFirstColumnFilledByPlayer(PLAYER_O.value)
                || isSecondColumnFilledByPlayer(PLAYER_O.value)
                || isThirdColumnFilledByPlayerO()) {
            winner = PLAYER_O.value;
        }

        return winner;
    }

    private boolean isThirdColumnFilledByPlayerO() {
        return getPlayerAt(POSITION_ZERO, POSITION_TWO) == PLAYER_O.value
                && getPlayerAt(POSITION_ONE, POSITION_TWO) == PLAYER_O.value
                && getPlayerAt(POSITION_TWO, POSITION_TWO) == PLAYER_O.value;
    }

    private boolean isThirdColumnFilledByPlayerX() {
        return getPlayerAt(POSITION_ZERO, POSITION_TWO) == PLAYER_X.value
                && getPlayerAt(POSITION_ONE, POSITION_TWO) == PLAYER_X.value
                && getPlayerAt(POSITION_TWO, POSITION_TWO) == PLAYER_X.value;
    }

    private boolean isSecondColumnFilledByPlayer(char player) {
        return getPlayerAt(POSITION_ZERO, POSITION_ONE) == player
                && getPlayerAt(POSITION_ONE, POSITION_ONE) == player
                && getPlayerAt(POSITION_TWO, POSITION_ONE) == player;
    }

    private boolean isFirstColumnFilledByPlayer(char player) {
        return getPlayerAt(POSITION_ZERO, POSITION_ZERO) == player
                && getPlayerAt(POSITION_ONE, POSITION_ZERO) == player
                && getPlayerAt(POSITION_TWO, POSITION_ZERO) == player;
    }

    private boolean isAnyRowFilledByPlayer(char player) {
        return isRowFilledByPlayer(POSITION_ZERO, player)
                || isRowFilledByPlayer(POSITION_ONE, player)
                || isRowFilledByPlayer(POSITION_TWO, player);
    }

    private boolean isRowFilledByPlayer(int rowPosition, char player) {
        return getPlayerAt(rowPosition, POSITION_ZERO) == player
                && getPlayerAt(rowPosition, POSITION_ONE) == player
                && getPlayerAt(rowPosition, POSITION_TWO) == player;
    }

}