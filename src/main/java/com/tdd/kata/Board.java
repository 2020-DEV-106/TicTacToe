package com.tdd.kata;

public class Board {

    private static final int GRID_SIZE = 3;
    private final char[][] gameBoard = new char[GRID_SIZE][GRID_SIZE];

    public void playAt(int row, int column, char currentPlayer) {
        gameBoard[row][column] = currentPlayer;
    }

    public char getPlayerAt(int row, int column) {
        return gameBoard[row][column];
    }
}