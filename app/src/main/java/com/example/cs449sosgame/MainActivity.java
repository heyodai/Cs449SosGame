package com.example.cs449sosgame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private ClassMatch Match;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Match = new ClassMatch();
    }

    public boolean startMatch(View view) {
        setContentView(R.layout.activity_match);
        return Match.start(0, EnumMode.SIMPLE);
    }
}