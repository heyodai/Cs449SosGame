package com.example.cs449sosgame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class UiController extends AppCompatActivity {
    private ClassMatch match;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
    }

    public boolean startMatch(View view) {
        EditText sizeInput = findViewById(R.id.boardSizeInputField);
        String temp = sizeInput.getText().toString();
        int value = 0;
        if (!"".equals(temp)){
            value = Integer.parseInt(temp);
        }

        match = new ClassMatch();
        match.start(value, EnumMode.SIMPLE);
        setContentView(R.layout.activity_match);
        // BoardSizeDeclaration
        TextView boardSizeDecl = (TextView)findViewById(R.id.BoardSizeDeclaration);
        boardSizeDecl.setText("Board Size: " + value);

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

    public boolean selectTile(int x, int y) {
        // check if valid
        // place letter
        // switch turn
        // update view
        return false;
    }
}