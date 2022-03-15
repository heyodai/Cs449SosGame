package com.example.cs449sosgame;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test the creation of a match.
 *
 * @see <a href="https://github.com/heyodai/Cs449SosGame/issues/1">User story on GitHubs</a>
 */
public class MatchStartUnitTest {
    private ClassMatch Match;

    @Test
    public void matchSetupSuccess() {
        Match = new ClassMatch();
        int boardSize = 3;
        EnumMode gameMode = EnumMode.SIMPLE;

        assertTrue(Match.start(boardSize, gameMode));
    }

    @Test
    public void matchSetupBoardTooSmall() {
        Match = new ClassMatch();
        int boardSize = 0;
        EnumMode gameMode = EnumMode.SIMPLE;

        assertFalse(Match.start(boardSize, gameMode));
    }

    @Test
    public void matchSetupBoardTooLarge() {
        Match = new ClassMatch();
        int boardSize = 9;
        EnumMode gameMode = EnumMode.SIMPLE;

        assertFalse(Match.start(boardSize, gameMode));
    }
}