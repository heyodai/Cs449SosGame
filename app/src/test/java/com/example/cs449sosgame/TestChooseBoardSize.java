package com.example.cs449sosgame;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class TestChooseBoardSize {
    protected ClassMatch match;

    @Before
    public void setUp() throws Exception {
        match = new ClassMatch();
    }

    @Test
    public void boardIsTooSmall() {
        int boardSize = 2;
        assertFalse(match.isBoardSizeValid(boardSize));
    }

    @Test
    public void boardIsTooLarge() {
        int boardSize = 9;
        assertFalse(match.isBoardSizeValid(boardSize));
    }

    @Test
    public void boardIsProperSize() {
        int boardSize = 4;
        assertTrue(match.isBoardSizeValid(boardSize));
    }
}
