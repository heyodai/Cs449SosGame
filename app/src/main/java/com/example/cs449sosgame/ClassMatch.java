package com.example.cs449sosgame;

public class ClassMatch {
    protected ClassPlayer redPlayer;
    protected ClassPlayer bluePlayer;
    protected ClassBoard boardData;
    protected EnumPlayer currentActivePlayer;

    protected static final int MIN_BOARD_SIZE = 3;
    protected static final int MAX_BOARD_SIZE = 8;

    public boolean isBoardSizeValid(int size) {
        return (size >= MIN_BOARD_SIZE && size <= MAX_BOARD_SIZE);
    }

    public boolean start(int boardSize, EnumMode gameMode) {
        return false;
    }
}
