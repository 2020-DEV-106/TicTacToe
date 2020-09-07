package com.tdd.kata;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class GameTest {

    @Test
    public void getPlayerAtShouldReturnXAfterFirstTurn() {
        Game game = new Game();

        game.playAt(0, 0);

        Assert.assertThat(game.getPlayerAt(0, 0), Is.is('X'));
    }
}