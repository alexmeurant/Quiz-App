package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        TextView mQuestion = (TextView) findViewById(R.id.Question);
        Button mAnswer1 = (Button) findViewById(R.id.Answer1);
        Button mAnswer2 = (Button) findViewById(R.id.Answer2);
        Button mAnswer3 = (Button) findViewById(R.id.Answer3);
        Button mAnswer4 = (Button) findViewById(R.id.Answer4);
    }
}
