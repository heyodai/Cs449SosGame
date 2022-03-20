package com.example.cs449sosgame;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Class definition for UI controller.
 * Main app activity.
 *
 * @author Odai Athamneh
 */
public class UiController extends AppCompatActivity {
    private ClassMatch match;

    /**
     * Override the default onCreate method to set custom view.
     * @param savedInstanceState Saved state for app
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
    }

    /**
     * Start match and update app view.
     * Will return FALSE if match parameters are invalid.
     *
     * @param view Current on-screen app view.
     * @return TRUE if match started successfully, FALSE if not
     */
    public boolean startMatch(View view) {
        match = new ClassMatch();
        int value = getBoardSizeInput();
        if (!match.isBoardSizeValid(value)) {
            return false;
        }

        match.start(value, EnumMode.SIMPLE);
        setContentView(R.layout.activity_match);
        drawBoard(view);
        swapActivePlayerLabel();

        return true;
    }

    /**
     * End the match when player hits "New Game" button.
     *
     * @param view The current view object on device screen
     * @return TRUE if match successfully reset, FALSE otherwise
     */
    public boolean endMatch(View view) {
        setContentView(R.layout.activity_setup);
        match = null;
        return true;
    }

    /**
     * onClick listener for when a board square is clicked.
     *
     * @param view View object for invoking button
     * @return Always returns null
     */
    public View.OnClickListener selectTile(View view) {
        Button b = (Button)view;
        int squareNumber = (Integer)view.getTag();

        if (match.isSquareEmpty(squareNumber)) {
            EnumPlayer player = match.getCurrentActivePlayer();
            EnumLetter inputLetter = getLetterInput(player);
            match.setSquare(squareNumber, inputLetter);

            String text = (inputLetter == EnumLetter.S ? "S" : "O");
            b.setText(text);
            swapActivePlayerLabel();
        }

        return null;
    }

    /**
     * Draw SOS board on the screen.
     *
     * @param view Current on-screen app view
     */
    public void drawBoard(View view) {
        int size = match.getBoardSize();
        int squareCount = 0;
        TableLayout table = findViewById(R.id.boardLayoutArea);

        for (int i = 0; i < size; i++) {
            TableRow row = new TableRow(this);
            for (int j = 0; j < size; j++) {
                Button square = new Button(this);

                square.setText(" ");
                square.setTag(squareCount);
                square.setOnClickListener(this::selectTile);

                row.addView(square);
                squareCount++;
            }
            table.addView(row);
        }
    }

    /**
     * Swap which player is highlighted green to indicate active status.
     * Function determines active player internally.
     */
    public void swapActivePlayerLabel() {
        int activeId, inactiveId;

        if (match.getCurrentActivePlayer() == EnumPlayer.BLUE) {
            activeId = R.id.bluePlayerLabel;
            inactiveId = R.id.redPlayerLabel;
        }
        else {
            activeId = R.id.redPlayerLabel;
            inactiveId = R.id.bluePlayerLabel;
        }

        TextView activePlayerElem = findViewById(activeId);
        TextView inactivePlayerElem = findViewById(inactiveId);

        activePlayerElem.setTextColor(Color.GREEN);
        inactivePlayerElem.setTextColor(Color.BLACK);
    }

    /**
     * Get user input for board size. Defaults to zero.
     *
     * @return Size for board provided by user
     */
    public int getBoardSizeInput() {
        int value = 0;

        EditText sizeInput = findViewById(R.id.boardSizeInputField);
        String temp = sizeInput.getText().toString();
        if (!"".equals(temp)){ // field is not empty
            value = Integer.parseInt(temp);
        }

        return value;
    }

    /**
     * Get currently selected letter for requested player.
     *
     * @param player The player to check letter selection for
     * @return Letter that user has selected
     */
    public EnumLetter getLetterInput(EnumPlayer player) {
        int buttonId = (player == EnumPlayer.BLUE ? R.id.blueSRadioButton : R.id.redSRadioButton);
        RadioButton buttonElem = findViewById(buttonId);
        return (buttonElem.isChecked() ? EnumLetter.S : EnumLetter.O);
    }
}