package com.tdd.kata;

import com.tdd.kata.io.InputScanner;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
    }

    @Test
    public void instructionsShouldBePrintedOnGameStart() {
        when(scanner.nextLine()).thenReturn("2 0");
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

        Assert.assertNotNull(message);
        Assert.assertTrue(message.contains(instruction));
    }

    @Test
    public void positionInputShouldBeCollectedAfterPrintingInstructions() {
        when(scanner.nextLine()).thenReturn("2 0");

        gameRunner.startGame();

        verify(scanner, times(1)).nextLine();
    }

    @Test
    public void collectedPositionInputShouldBePassedToGame() {
        when(scanner.nextLine()).thenReturn("2 0");

        gameRunner.startGame();

        verify(game, times(1)).playAt(2, 0);
    }

    private class TestableGameRunner extends GameRunner {

        public TestableGameRunner(InputScanner scanner, Game game) {
            super(scanner, game);
        }

        private StringBuilder message = new StringBuilder();

        @Override
        protected void print(String message) {
            this.message.append(message);
        }

        public String getMessage() {
            return message.toString();
        }
    }
}