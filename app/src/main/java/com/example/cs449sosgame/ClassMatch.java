package com.example.cs449sosgame;

/**
 * Class definition for match object.
 *
 * @author Odai Athamneh
 */
public class ClassMatch {
    protected ClassPlayer redPlayer;
    protected ClassPlayer bluePlayer;
    protected ClassBoard boardData;
    protected EnumPlayer currentActivePlayer;

    protected static final int MIN_BOARD_SIZE = 3;
    protected static final int MAX_BOARD_SIZE = 8;

    /**
     * Check if user-provided board size is acceptable.
     *
     * @param size Board size provided by user
     * @return TRUE if valid board size, FALSE if not
     */
    public boolean isBoardSizeValid(int size) {
        return (size >= MIN_BOARD_SIZE && size <= MAX_BOARD_SIZE);
    }

    /**
     * Check if user-selected board square is available.
     *
     * @param square The square the user has selected
     * @return TRUE if square is empty, FALSE if not
     */
    public boolean isSquareEmpty(int square) {
        int[] coords = getCoordinatesFromSquareNumber(square);
        EnumLetter squareData = boardData.get(coords[0], coords[1]);
        return (squareData == EnumLetter.NULL);
    }

    /**
     * Begin the SOS match.
     *
     * @param size Board size provided by user
     * @param gameMode Enum for game mode chosen by user
     * @return TRUE if match started successfully, FALSE if not
     */
    public boolean start(int size, EnumMode gameMode) {
        boardData = new ClassBoard(size);
        currentActivePlayer = EnumPlayer.BLUE;
        return true;
    }

    /**
     * Getter for board size property.
     * @return Board size
     */
    public int getBoardSize() {
        return boardData.getBoardSize();
    }

    /**
     * Getter for current active player property.
     * @return Current active player
     */
    public EnumPlayer getCurrentActivePlayer() {
        return currentActivePlayer;
    }

    /**
     * Place the provided letter in the provided square.
     *
     * @param square The square to place a letter in
     * @param letter The letter to place in a square
     */
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
     * Convert a square number to X and Y coordinates.
     * Implementation taken from Stack Overflow.
     *
     * @param square The square to convert to coordinates
     * @return int[] Int array with coords (x first, y second)
     *
     * @see <a href="https://stackoverflow.com/questions/11821899">Stack Overflow</a>
     */
    protected int[] getCoordinatesFromSquareNumber(int square){
        int boardSize = boardData.getBoardSize();
        int row = Math.round( square / boardSize );
        int column = Math.round( square - (row * boardSize) );
        return new int[] {row, column};
    }
}
