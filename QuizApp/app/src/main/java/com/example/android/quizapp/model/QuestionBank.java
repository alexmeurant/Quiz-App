package com.example.android.quizapp.model;


import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class QuestionBank {

    private List<Question> mQuestionList;
    private int mNextQuestionIndex;


    public QuestionBank(List<Question> questionList) {
        mQuestionList = questionList;

        // shuffle the question list:
        Collections.shuffle(mQuestionList);

        mNextQuestionIndex = 0;
    }

    public Question getQuestion(){
        // Ensure we loop over the questions:
        if (mNextQuestionIndex == mQuestionList.size()) {
            mNextQuestionIndex = 0;
        }

        // Please note the post-incrementation:
        return mQuestionList.get(mNextQuestionIndex++);
    }
}
