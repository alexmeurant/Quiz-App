package com.example.android.quizapp.controller;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.quizapp.R;
import com.example.android.quizapp.model.Question;
import com.example.android.quizapp.model.QuestionBank;

import java.util.Arrays;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import static android.os.Build.VERSION_CODES.M;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mQuestionView;
    private Button mAnswer1View;
    private Button mAnswer2View;
    private Button mAnswer3View;
    private Button mAnswer4View;

    private QuestionBank mQuestionBank;
    private Question mCurrentQuestion;

    private int mNumberOfQuestions;
    private int mScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mQuestionBank = this.generateQuestions();

        mNumberOfQuestions = 9;
        mScore = 0;

        // Wire widgets
        mQuestionView = (TextView) findViewById(R.id.QuestionView);
        mAnswer1View = (Button) findViewById(R.id.Answer1View);
        mAnswer2View = (Button) findViewById(R.id.Answer2View);
        mAnswer3View = (Button) findViewById(R.id.Answer3View);
        mAnswer4View = (Button) findViewById(R.id.Answer4View);

        // Use the tag property to 'name' the buttons
        mAnswer1View.setTag(0);
        mAnswer2View.setTag(1);
        mAnswer3View.setTag(2);
        mAnswer4View.setTag(3);

        // Use the same listener for the four buttons.
        // The tag value will be used to distinguish the button triggered
        mAnswer1View.setOnClickListener(this);
        mAnswer2View.setOnClickListener(this);
        mAnswer3View.setOnClickListener(this);
        mAnswer4View.setOnClickListener(this);

        mCurrentQuestion = mQuestionBank.getQuestion();
        this.displayQuestion(mCurrentQuestion);
    }

    @Override
    public void onClick(View view) {
        int goodAnswer = mCurrentQuestion.getAnswerIndex();
        int responseIndex = (int) view.getTag();

        mNumberOfQuestions--;

        // Check correct or wrong answer:
        if (responseIndex == goodAnswer) {
            Toast.makeText(GameActivity.this, "Correct", Toast.LENGTH_SHORT).show();
            mScore++;
        } else {
            Toast.makeText(GameActivity.this, "Wrong answer", Toast.LENGTH_SHORT).show();
        }

        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Display another question:
                if (mNumberOfQuestions >= 1){
                    mCurrentQuestion = mQuestionBank.getQuestion();
                    displayQuestion(mCurrentQuestion);
                } else {
                    endGame();
                }
            }
        }, 2000);
    }

    private void endGame(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Well done!")
                .setMessage("Your score is: " + mScore + "/9")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .create()
                .show();
    }

    private void displayQuestion(final Question question) {
        mQuestionView.setText(question.getQuestion());
        mAnswer1View.setText(question.getChoiceList().get(0));
        mAnswer2View.setText(question.getChoiceList().get(1));
        mAnswer3View.setText(question.getChoiceList().get(2));
        mAnswer4View.setText(question.getChoiceList().get(3));
    }

    private QuestionBank generateQuestions(){
        Question question1 = new Question("What is the name of the current french president?",
                Arrays.asList("François Hollande", "Emmanuel Macron", "Jacques Chirac", "François Mitterand"),
                1);

        Question question2 = new Question("How many countries are there in the European Union?",
                Arrays.asList("15", "24", "28", "32"),
                2);

        Question question3 = new Question("Who is the creator of the Android operating system?",
                Arrays.asList("Andy Rubin", "Steve Wozniak", "Jake Wharton", "Paul Smith"),
                0);

        Question question4 = new Question("When did the first man land on the moon?",
                Arrays.asList("1958", "1962", "1967", "1969"),
                3);

        Question question5 = new Question("What is the capital of Romania?",
                Arrays.asList("Bucarest", "Warsaw", "Budapest", "Berlin"),
                0);

        Question question6 = new Question("Who did the Mona Lisa paint?",
                Arrays.asList("Michelangelo", "Leonardo Da Vinci", "Raphael", "Carravagio"),
                1);

        Question question7 = new Question("In which city is the composer Frédéric Chopin buried?",
                Arrays.asList("Strasbourg", "Warsaw", "Paris", "Moscow"),
                2);

        Question question8 = new Question("What is the country top-level domain of Belgium?",
                Arrays.asList(".bg", ".bm", ".bl", ".be"),
                3);

        Question question9 = new Question("What is the house number of The Simpsons?",
                Arrays.asList("42", "101", "666", "742"),
                3);

        return new QuestionBank(Arrays.asList(question1,
                question2,
                question3,
                question4,
                question5,
                question6,
                question7,
                question8,
                question9));
    }
}