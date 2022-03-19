package com.example.cs449sosgame;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TableRow;

import androidx.appcompat.app.AppCompatActivity;

public class UiController extends AppCompatActivity {
    private ClassMatch match;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
    }

    public boolean startMatch(View view) {
        match = new ClassMatch();
        int value = getBoardSizeInput();
        if (!match.isBoardSizeValid(value)) {
            return false;
        }

        match.start(value, EnumMode.SIMPLE);
        setContentView(R.layout.activity_match);
        drawBoard(view);

        return true;
    }

    /**
     * End the match when player hits "New Game" button.
     *
     * @param {View} view - The current view object on device screen.
     * @return {bool} - TRUE if match successfully reset, FALSE otherwise.
     */
    public boolean endMatch(View view) {
        setContentView(R.layout.activity_setup);
        match = null;
        return true;
    }

    public boolean changeInputLetter() {
        // get current letter
        // set player data
        // update view
        return false;
    }

//    @Override
//    public void onClick(View view) {
    public View.OnClickListener selectTile(View view) {
        Button b = (Button)view;
//        int squareNumber = Integer.parseInt(b.getTag().toString());
        int squareNumber = (Integer)view.getTag();

        if (match.isSquareFree(squareNumber)) {
            EnumPlayer player = match.getCurrentActivePlayer();
            EnumLetter inputLetter = getLetterInput(player);
            match.setSquare(squareNumber, inputLetter);

            String text = (inputLetter == EnumLetter.S ? "S" : "O");
            b.setText(text);
            // update active player
        }

        return null;
    }

    public void drawBoard(View view) {
        int size = match.getBoardSize();
        int squareCount = 0;
        TableLayout table = findViewById(R.id.boardLayoutArea);

        // add rows and columns
        for (int i = 0; i < size; i++) {
            TableRow row = new TableRow(this);
            for (int j = 0; j < size; j++) {
                Button square = new Button(this);

                square.setText(" ");
                square.setTag(squareCount);
//                square.setOnClickListener(selectTile(null));
                square.setOnClickListener(this::selectTile);

                row.addView(square);
                squareCount++;
            }
            table.addView(row);
        }
    }

    public int getBoardSizeInput() {
        int value = 0;

        EditText sizeInput = findViewById(R.id.boardSizeInputField);
        String temp = sizeInput.getText().toString();
        if (!"".equals(temp)){ // field is not empty
            value = Integer.parseInt(temp);
        }

        return value;
    }

    public EnumLetter getLetterInput(EnumPlayer player) {
        int buttonId = (player == EnumPlayer.BLUE ? R.id.blueSRadioButton : R.id.redSRadioButton);
        RadioButton buttonElem = findViewById(buttonId);
        return (buttonElem.isChecked() ? EnumLetter.S : EnumLetter.O);
    }
}