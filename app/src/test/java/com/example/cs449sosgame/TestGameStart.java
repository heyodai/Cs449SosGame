package com.example.cs449sosgame;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class TestGameStart {
    protected ClassMatch match;

    @Before
    public void setUp() throws Exception {
        match = new ClassMatch();
    }

    @Test
    public void success() {
        int boardSize = 4;
        EnumMode gameMode = EnumMode.SIMPLE;
        assertTrue(match.start(boardSize, gameMode));
    }

    @Test
    public void failure() {
        // to be written
    }
}
