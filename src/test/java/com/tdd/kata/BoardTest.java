package com.tdd.kata;

import org.junit.Before;
import org.junit.Test;

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
        board.playAt(POSITION_ZERO, POSITION_ZERO, Player.PLAYER_X.value);

        assertThat(board.getPlayerAt(POSITION_ZERO, POSITION_ZERO), is(Player.PLAYER_X.value));
    }

    @Test
    public void getPlayerAtShouldReturnOAfterSecondTurn() {
        board.playAt(POSITION_ZERO, POSITION_ZERO, Player.PLAYER_X.value);
        board.playAt(POSITION_ZERO, POSITION_ONE, Player.PLAYER_O.value);

        assertThat(board.getPlayerAt(POSITION_ZERO, POSITION_ONE), is(Player.PLAYER_O.value));
    }
}