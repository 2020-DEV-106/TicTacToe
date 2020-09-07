package com.tdd.kata;

public class Game {

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
        return previousPlayer == Player.PLAYER_X.value ? Player.PLAYER_O.value : Player.PLAYER_X.value;
    }

    public char getPlayerAt(int row, int column) {
        return board.getPlayerAt(row, column);
    }
}