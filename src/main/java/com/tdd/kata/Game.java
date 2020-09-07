package com.tdd.kata;

public class Game {

    private static final char PLAYER_X = 'X';
    private final char[][] board = new char[3][3];
    private char previousPlayer;

    public void playAt(int row, int column) {
        char currentPlayer = previousPlayer == PLAYER_X ? 'O' : PLAYER_X;
        board[row][column] = currentPlayer;
        previousPlayer = currentPlayer;
    }

    public char getPlayerAt(int row, int column) {
        return board[row][column];
    }
}