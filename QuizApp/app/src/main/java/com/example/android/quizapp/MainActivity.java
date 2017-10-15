package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declare member variables and connect to xml views:
        TextView mWelcomeTextView = (TextView) findViewById(R.id.WelcomeTextView);
        EditText mNameInput = (EditText) findViewById(R.id.NameInput);
        Button mPlayButton = (Button) findViewById(R.id.PlayButton);
    }
}
