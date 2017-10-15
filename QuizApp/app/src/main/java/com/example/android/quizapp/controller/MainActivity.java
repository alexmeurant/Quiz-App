package com.example.android.quizapp.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.quizapp.R;
import com.example.android.quizapp.model.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declare member variables and connect to xml views:
        TextView mWelcomeTextView = (TextView) findViewById(R.id.WelcomeTextView);
        final EditText mNameInput = (EditText) findViewById(R.id.NameInput);
        final Button mPlayButton = (Button) findViewById(R.id.PlayButton);
        final User mUser = new User();

        // Play button is not enabled till player does not write his name:
        mPlayButton.setEnabled(false);

        mNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mPlayButton.setEnabled(charSequence.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        // Display Game Activity when Play Button is clicked:
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gameActivityIntent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(gameActivityIntent);

                String userName = mNameInput.getText().toString();
                mUser.setUserName(userName);
            }
        });
    }
}
