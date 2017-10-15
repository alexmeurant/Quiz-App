package com.example.android.quizapp.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.quizapp.R;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        TextView mQuestionView = (TextView) findViewById(R.id.QuestionView);
        Button mAnswer1View = (Button) findViewById(R.id.Answer1View);
        Button mAnswer2View = (Button) findViewById(R.id.Answer2View);
        Button mAnswer3View = (Button) findViewById(R.id.Answer3View);
        Button mAnswer4View = (Button) findViewById(R.id.Answer4View);
    }
}
