package com.example.cs449sosgame;

public class ClassPlayer {
    protected EnumLetter currentLetter;
    protected EnumPlayer playerColor;

    public ClassPlayer(EnumLetter letter, EnumPlayer color) {
        currentLetter = letter;
        playerColor = color;
    }

    public EnumPlayer getColor() {
        return playerColor;
    }

    public EnumLetter getLetter() {
        return currentLetter;
    }

    public void setLetter(EnumLetter letter) {
        currentLetter = letter;
    }
}
