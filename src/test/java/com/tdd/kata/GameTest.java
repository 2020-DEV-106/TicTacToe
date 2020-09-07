package com.tdd.kata;

import org.junit.Before;
import org.junit.Test;

import static com.tdd.kata.Player.PLAYER_X;
import static com.tdd.kata.Player.PLAYER_O;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GameTest {

    private static final int POSITION_ZERO = 0;
    private static final int POSITION_ONE = 1;
    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void getPlayerAtShouldReturnXAfterFirstTurn() {
        game.playAt(POSITION_ZERO, POSITION_ZERO);

        assertThat(game.getPlayerAt(POSITION_ZERO, POSITION_ZERO), is(PLAYER_X.value));
    }

    @Test
    public void getPlayerAtShouldReturnOAfterSecondTurn() {
        game.playAt(POSITION_ZERO, POSITION_ZERO);
        game.playAt(POSITION_ZERO, POSITION_ONE);

        assertThat(game.getPlayerAt(POSITION_ZERO, POSITION_ONE), is(PLAYER_O.value));
    }
}