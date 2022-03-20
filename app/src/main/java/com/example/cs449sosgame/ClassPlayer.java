package com.example.cs449sosgame;

/**
 * Class definition for player object.
 *
 * @author Odai Athamneh
 */
public class ClassPlayer {
    protected EnumLetter currentLetter;
    protected EnumPlayer playerColor;

    /**
     * Class constructor.
     *
     * @param letter The current letter for the player
     * @param color The color for the player
     */
    public ClassPlayer(EnumLetter letter, EnumPlayer color) {
        currentLetter = letter;
        playerColor = color;
    }

    /**
     * Getter for player's color property.
     * @return Color as EnumPlayer type
     */
    public EnumPlayer getColor() {
        return playerColor;
    }

    /**
     * Getter for player's current letter property.
     * @return Current letter as EnumLetter type
     */
    public EnumLetter getLetter() {
        return currentLetter;
    }

    /**
     * Setter for player's current letter property.
     * @param letter The letter to switch to
     */
    public void setLetter(EnumLetter letter) {
        currentLetter = letter;
    }
}
