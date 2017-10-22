package com.example.android.quizapp.controller;

import android.content.Intent;
import android.content.SharedPreferences;
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

    public static final int GAME_ACTIVITY_REQUEST_CODE = 1;

    private SharedPreferences mPreferences;

    public static final String PREF_KEY_SCORE = "PREF_KEY_SCORE";
    public static final String PREF_KEY_USERNAME = "PREF_KEY_USERNAME";

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (GAME_ACTIVITY_REQUEST_CODE == requestCode && RESULT_OK == resultCode){
            // Fetch the score from the Intent
            int score = data.getIntExtra(GameActivity.BUNDLE_EXTRA_SCORE, 0);

            // Save score:
            mPreferences.edit().putInt(PREF_KEY_SCORE, score).apply();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Access to player preferences:
        mPreferences = getPreferences(MODE_PRIVATE);

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
                startActivityForResult(gameActivityIntent, GAME_ACTIVITY_REQUEST_CODE);

                String userName = mNameInput.getText().toString();
                mUser.setUserName(userName);

                // Save User Name:
                mPreferences.edit().putString(PREF_KEY_USERNAME, mUser.getUserName()).apply();
            }
        });
    }
}
