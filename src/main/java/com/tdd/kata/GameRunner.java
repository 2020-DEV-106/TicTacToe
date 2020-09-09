package com.tdd.kata;

import com.tdd.kata.io.InputScanner;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameRunner {
    private static final Logger logger = Logger.getLogger(GameRunner.class.getName());
    private static final String INPUT_PATTERN_REGEX = "^[0-2]{1}\\s{1}[0-2]{1}$";
    private final InputScanner scanner;
    private final Game game;

    public GameRunner() {
        this(new InputScanner(), new Game());
    }

    public GameRunner(InputScanner scanner, Game game) {
        this.scanner = scanner;
        this.game = game;
    }

    public static void main(String[] args) {
        new GameRunner().startGame();
    }

    public void startGame() {
        printInitialInstructions();

        playGame();

        printGameResult();
    }

    private void printGameResult() {
        if (game.isDraw()) {
            print(Level.INFO, "Game is draw!!");
        } else {
            print(Level.INFO, "Player " + game.getWinner() + " won!!");
        }
    }

    private void playGame() {
        while (game.isNotOver()) {
            String position = scanner.nextLine();

            if (isInvalidPosition(position)) {
                print(Level.SEVERE, "Please give a valid input for position");
                continue;
            }

            int row = Integer.parseInt(position.substring(0, 1));
            int column = Integer.parseInt(position.substring(2));

            if (game.isPositionOccupied(row, column)) {
                print(Level.SEVERE, "Please choose a position which is unoccupied in the board");
                continue;
            }

            game.playAt(row, column);
        }
    }

    private boolean isInvalidPosition(String position) {
        Pattern pattern = Pattern.compile(INPUT_PATTERN_REGEX);
        Matcher matcher = pattern.matcher(position);

        return !matcher.find();
    }

    private void printInitialInstructions() {
        StringBuilder instruction = new StringBuilder("Welcome to TicTacToe game!!\n")
                .append("This is a game on a board of size 3x3\n")
                .append("Position of each box is represented by a combination of two numbers as below\n")
                .append("0 0, 0 1, 0 2\n")
                .append("1 0, 1 1, 1 2\n")
                .append("2 0, 2 1, 2 2\n")
                .append("Choose one of these positions on a player's turn\n")
                .append("Game always starts with player 'X'\n")
                .append("Players cannot play on a position which is already played\n")
                .append("Mark your position:\n");
        print(Level.INFO, instruction.toString());
    }

    protected void print(Level level, String message) {
        logger.log(level, message);
    }

}