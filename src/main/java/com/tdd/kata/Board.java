package com.tdd.kata;

public class Board {

    private static final int GRID_SIZE = 3;
    private static final int TOTAL_NUMBER_CELLS_IN_BOARD = 9;
    private static final int NUMBER_OF_CELLS_FILLED_BEFORE_GAME_STARTS = 0;
    private static final char INITIAL_VALUE_OF_POSITION_IN_BOARD = '\0';
    private final char[][] gameBoard;
    private int numberOfCellsFilled;

    public Board() {
        gameBoard = new char[GRID_SIZE][GRID_SIZE];
        numberOfCellsFilled = NUMBER_OF_CELLS_FILLED_BEFORE_GAME_STARTS;
    }

    public void playAt(int row, int column, char currentPlayer) {
        gameBoard[row][column] = currentPlayer;
        numberOfCellsFilled++;
    }

    public char getPlayerAt(int row, int column) {
        return gameBoard[row][column];
    }

    public boolean isBoardFull() {
        return numberOfCellsFilled == TOTAL_NUMBER_CELLS_IN_BOARD;
    }

    public boolean isPositionOccupied(int row, int column) {
        return gameBoard[row][column] != INITIAL_VALUE_OF_POSITION_IN_BOARD;
    }
}