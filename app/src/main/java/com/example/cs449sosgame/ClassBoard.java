package com.example.cs449sosgame;

/**
 * Class definition for board data.
 *
 * @author Odai Athamneh
 */
public class ClassBoard {
    protected int boardSize;
    protected EnumLetter[][] boardData;

    /**
     * Class constructor. Builds the board array.
     *
     * @param size Board size
     */
    public ClassBoard(int size) {
        boardSize = size;
        boardData = new EnumLetter[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                boardData[i][j] = EnumLetter.NULL;
            }
        }
    }

    /**
     * Update data stored in a board square.
     *
     * @param x Row for square to update
     * @param y Column for square to update
     * @param letter Enum to change square to
     */
    public void set(int x, int y, EnumLetter letter) {
        if (x <= boardSize && y <= boardSize) {
            boardData[x][y] = letter;
        }
    }

    /**
     * Retrieve board data for specified square.
     *
     * @param x Row for square to retrieve
     * @param y Column for square to retrieve
     * @return Enum for letter; default to null on failure
     */
    public EnumLetter get(int x, int y) {
        return (x <= boardSize && y <= boardSize ? boardData[x][y] : EnumLetter.NULL);
    }
}
