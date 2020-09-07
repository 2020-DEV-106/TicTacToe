package com.tdd.kata;

public class Game {

    private static final int GRID_SIZE = 3;
    private final char[][] board = new char[GRID_SIZE][GRID_SIZE];
    private char previousPlayer;

    public void playAt(int row, int column) {
        char currentPlayer = getCurrentPlayer();
        board[row][column] = currentPlayer;
        setPreviousPlayer(currentPlayer);
    }

    private void setPreviousPlayer(char currentPlayer) {
        previousPlayer = currentPlayer;
    }

    private char getCurrentPlayer() {
        return previousPlayer == Player.PLAYER_X.value ? Player.PLAYER_O.value : Player.PLAYER_X.value;
    }

    public char getPlayerAt(int row, int column) {
        return board[row][column];
    }
}