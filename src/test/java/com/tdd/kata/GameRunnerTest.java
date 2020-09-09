package com.tdd.kata;

import com.tdd.kata.io.InputScanner;

import org.junit.Before;
import org.junit.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GameRunnerTest {

    @Mock
    private InputScanner scanner;

    @Mock
    private Game game;

    @InjectMocks
    private GameRunner gameRunner;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(scanner.nextLine()).thenReturn("2 0");
        when(game.isNotOver()).thenReturn(true, false);
    }

    @Test
    public void instructionsShouldBePrintedOnGameStart() {
        String instruction = new StringBuilder("Welcome to TicTacToe game!!\n")
                .append("This is a game on a board of size 3x3\n")
                .append("Position of each box is represented by a combination of two numbers as below\n")
                .append("0 0, 0 1, 0 2\n")
                .append("1 0, 1 1, 1 2\n")
                .append("2 0, 2 1, 2 2\n")
                .append("Choose one of these positions on a player's turn\n")
                .append("Game always starts with player 'X'\n")
                .append("Players cannot play on a position which is already played\n")
                .append("Mark your position:\n").toString();
        TestableGameRunner testableGameRunner = new TestableGameRunner(scanner, game);

        testableGameRunner.startGame();
        String message = testableGameRunner.getMessage();

        assertNotNull(message);
        assertTrue(message.contains(instruction));
    }

    @Test
    public void positionInputShouldBeCollectedAfterPrintingInstructions() {
        gameRunner.startGame();

        verify(scanner, times(1)).nextLine();
    }

    @Test
    public void collectedPositionInputShouldBePassedToGame() {
        gameRunner.startGame();

        verify(game, times(1)).playAt(2, 0);
    }

    @Test
    public void gameShouldBePlayedUntilItsOver() {
        when(scanner.nextLine()).thenReturn("2 0", "1 0", "2 1");
        when(game.isNotOver()).thenReturn(true, true, true, false);

        gameRunner.startGame();

        verify(scanner, times(3)).nextLine();
        verify(game, times(3)).playAt(anyInt(), anyInt());
    }

    @Test
    public void gameResultShouldBePrintedAsDrawWhenGameIsDraw() {
        when(game.isDraw()).thenReturn(true);
        TestableGameRunner testableGameRunner = new TestableGameRunner(scanner, game);

        testableGameRunner.startGame();

        String message = testableGameRunner.getMessage();
        assertNotNull(message);
        assertTrue(message.contains("Game is draw!!"));
    }

    @Test
    public void gameResultShouldBePrintedWithWinnerNameWhenGameResultIsNotADraw() {
        char winner = 'X';
        String winnerMessage = "Player " + winner + " won!!";
        when(game.isDraw()).thenReturn(false);
        when(game.getWinner()).thenReturn(winner);
        TestableGameRunner testableGameRunner = new TestableGameRunner(scanner, game);

        testableGameRunner.startGame();

        String message = testableGameRunner.getMessage();
        assertNotNull(message);
        assertTrue(message.contains(winnerMessage));
    }

    @Test
    public void playAtShouldShouldThrowErrorIfRowIsLessThanZero() {
        when(scanner.nextLine()).thenReturn("-1 0");
        String message = "Please give a valid input for position";
        TestableGameRunner testableGameRunner = new TestableGameRunner(scanner, game);

        testableGameRunner.startGame();

        String errorMessage = testableGameRunner.getErrorMessages();
        assertNotNull(errorMessage);
        assertTrue(errorMessage.contains(message));
    }

    private class TestableGameRunner extends GameRunner {

        public TestableGameRunner(InputScanner scanner, Game game) {
            super(scanner, game);
        }

        private StringBuilder message = new StringBuilder();

        private StringBuilder errorMessages = new StringBuilder();

        @Override
        protected void print(String message) {
            this.message.append(message);
        }

        @Override
        protected void printError(String errorMessage) {
            errorMessages.append(errorMessage);
        }

        public String getMessage() {
            return message.toString();
        }

        public String getErrorMessages() {
            return errorMessages.toString();
        }
    }
}