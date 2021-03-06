package com.tdd.kata;

import static com.tdd.kata.Player.PLAYER_X;
import static com.tdd.kata.Player.PLAYER_O;

public class Game {

    private static final int POSITION_ZERO = 0;
    private static final int POSITION_ONE = 1;
    private static final int POSITION_TWO = 2;
    private static final char CHARACTER_NULL = '\0';
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
        char winner = CHARACTER_NULL;

        if (isGameWonByPlayer(previousPlayer)) {
            winner = previousPlayer;
        }

        return winner;
    }

    private boolean isGameWonByPlayer(char player) {
        return isAnyRowFilledByPlayer(player)
                || isAnyColumnFilledByPlayer(player)
                || isAnyDiagonalFilledByPlayer(player);
    }

    private boolean isAnyDiagonalFilledByPlayer(char player) {
        return isTopLeftToBottomRightDiagonalFilledByPlayer(player)
                || isTopRightToBottomLeftDiagonalFilledByPlayer(player);
    }

    private boolean isTopRightToBottomLeftDiagonalFilledByPlayer(char player) {
        return getPlayerAt(POSITION_ZERO, POSITION_TWO) == player
                && getPlayerAt(POSITION_ONE, POSITION_ONE) == player
                && getPlayerAt(POSITION_TWO, POSITION_ZERO) == player;
    }

    private boolean isTopLeftToBottomRightDiagonalFilledByPlayer(char player) {
        return getPlayerAt(POSITION_ZERO, POSITION_ZERO) == player
                && getPlayerAt(POSITION_ONE, POSITION_ONE) == player
                && getPlayerAt(POSITION_TWO, POSITION_TWO) == player;
    }

    private boolean isAnyColumnFilledByPlayer(char player) {
        return isColumnFilledByPlayer(POSITION_ZERO, player)
                || isColumnFilledByPlayer(POSITION_ONE, player)
                || isColumnFilledByPlayer(POSITION_TWO, player);
    }

    private boolean isColumnFilledByPlayer(int columnPosition, char player) {
        return getPlayerAt(POSITION_ZERO, columnPosition) == player
                && getPlayerAt(POSITION_ONE, columnPosition) == player
                && getPlayerAt(POSITION_TWO, columnPosition) == player;
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

    public boolean isNotOver() {
        return !isOver();
    }

    public boolean isDraw() {
        return board.isBoardFull() && getWinner() == CHARACTER_NULL;
    }

    public boolean isOver() {
        char winner = getWinner();
        return winner == PLAYER_X.value
                || winner == PLAYER_O.value
                || isDraw();
    }

    public boolean isPositionOccupied(int row, int column) {
        return board.isPositionOccupied(row, column);
    }
}