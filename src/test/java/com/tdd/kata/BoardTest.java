package com.tdd.kata;

import org.junit.Before;
import org.junit.Test;

import static com.tdd.kata.Player.PLAYER_X;
import static com.tdd.kata.Player.PLAYER_O;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoardTest {

    private static final int POSITION_ZERO = 0;
    private static final int POSITION_ONE = 1;
    private Board board;

    @Before
    public void setUp() {
        board = new Board();
    }

    @Test
    public void getPlayerAtShouldReturnXAfterFirstTurn() {
        board.playAt(POSITION_ZERO, POSITION_ZERO, PLAYER_X.value);

        assertThat(board.getPlayerAt(POSITION_ZERO, POSITION_ZERO), is(PLAYER_X.value));
    }

    @Test
    public void getPlayerAtShouldReturnOAfterSecondTurn() {
        board.playAt(POSITION_ZERO, POSITION_ZERO, PLAYER_X.value);
        board.playAt(POSITION_ZERO, POSITION_ONE, PLAYER_O.value);

        assertThat(board.getPlayerAt(POSITION_ZERO, POSITION_ONE), is(PLAYER_O.value));
    }
}