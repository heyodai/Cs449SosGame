package com.example.cs449sosgame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

public class UiController extends AppCompatActivity {
    private ClassMatch match;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
    }

    public boolean startMatch(View view) {
        match = new ClassMatch();
        
        EditText sizeInput = findViewById(R.id.boardSizeInputField);
        String temp = sizeInput.getText().toString();
        int value = 0;
        if (!"".equals(temp)){
            value = Integer.parseInt(temp);
        }

        if (!match.isBoardSizeValid(value)) {
            return false;
        }


        match.start(value, EnumMode.SIMPLE);
        setContentView(R.layout.activity_match);

        drawBoard(view);
        // BoardSizeDeclaration
//        TextView boardSizeDecl = (TextView)findViewById(R.id.BoardSizeDeclaration);
//        boardSizeDecl.setText("Board Size: " + value);

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

    public void drawBoard(View view) {
        int size = match.getBoardSize();
        TableLayout table = findViewById(R.id.boardLayoutArea);

        // add rows and columns
        for (int i = 0; i < size; i++) {
            TableRow row = new TableRow(this);

            for (int j = 0; j < size; j++) {
                TextView square = new TextView(this);
//                square.setId("squareX");
                square.setMinWidth(70);
                square.setMinHeight(70);

                square.setText("/");
                square.setTextSize(30);
                square.setPadding(15, 5, 15, 5);
//                square.setBackgroundResource(R.color.gray);
                square.setBackgroundResource(R.drawable.textview_border);
                square.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0);

                square.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        this.setText("O");
                        TextView s = (TextView)findViewById(v.getId());
//                        s.setText("O");
                    }
                });

                row.addView(square);
            }

            table.addView(row);
        }
    }

    public void clickSquare() {

    }
}