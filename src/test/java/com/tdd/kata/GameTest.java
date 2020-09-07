package com.tdd.kata;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class GameTest {

    private static final int POSITION_ZERO = 0;
    private static final char PLAYER_X = 'X';

    @Test
    public void getPlayerAtShouldReturnXAfterFirstTurn() {
        Game game = new Game();

        game.playAt(POSITION_ZERO, POSITION_ZERO);

        Assert.assertThat(game.getPlayerAt(POSITION_ZERO, POSITION_ZERO), Is.is(PLAYER_X));
    }
}