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

        if (isThirdRowFilledByPlayer(PLAYER_X.value, POSITION_ZERO)
                || isThirdRowFilledByPlayer(PLAYER_X.value, POSITION_ONE)
                || isThirdRowFilledByPlayer(PLAYER_X.value, POSITION_TWO)) {
            winner = PLAYER_X.value;
        }

        if (isThirdRowFilledByPlayer(PLAYER_O.value, POSITION_ZERO)
                || isThirdRowFilledByPlayer(PLAYER_O.value, POSITION_ONE)
                || isThirdRowFilledByPlayer(PLAYER_O.value, POSITION_TWO)) {
            winner = PLAYER_O.value;
        }

        return winner;
    }

    private boolean isThirdRowFilledByPlayer(char player, int positionTwo) {
        return getPlayerAt(positionTwo, POSITION_ZERO) == player
                && getPlayerAt(positionTwo, POSITION_ONE) == player
                && getPlayerAt(positionTwo, POSITION_TWO) == player;
    }

}