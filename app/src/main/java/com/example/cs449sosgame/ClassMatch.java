package com.example.cs449sosgame;

public class ClassMatch {
    protected ClassPlayer redPlayer;
    protected ClassPlayer bluePlayer;
    protected ClassBoard boardData;
    protected EnumPlayer currentActivePlayer;

    protected static final int MIN_BOARD_SIZE = 3;
    protected static final int MAX_BOARD_SIZE = 8;
    protected int boardSize;

    public boolean isBoardSizeValid(int size) {
        return (size >= MIN_BOARD_SIZE && size <= MAX_BOARD_SIZE);
    }

    public boolean isSquareFree(int square) {
        int[] coords = getCoordinatesFromSquareNumber(square);
        EnumLetter squareData = boardData.get(coords[0], coords[1]);
        return (squareData == EnumLetter.NULL);
    }

    public boolean start(int size, EnumMode gameMode) {
        boardSize = size;
        boardData = new ClassBoard(size);
        currentActivePlayer = EnumPlayer.BLUE;
        return false;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public EnumPlayer getCurrentActivePlayer() {
        return currentActivePlayer;
    }

    public void setSquare(int square, EnumLetter letter) {
        int[] coords = getCoordinatesFromSquareNumber(square);
        boardData.set(coords[0], coords[1], letter);

        if (currentActivePlayer == EnumPlayer.BLUE ) {
            currentActivePlayer = EnumPlayer.RED;
        }
        else {
            currentActivePlayer = EnumPlayer.BLUE;
        }
    }

    /**
     * @see ://stackoverflow.com/questions/11821899
     */
    protected int[] getCoordinatesFromSquareNumber(int square){
        int row = Math.round( square / boardSize );
        int column = Math.round( square - (row * boardSize) );
        return new int[] {row, column};
    }
}
