package com.bignerdranch.android.geoquiz;

import java.io.Serializable;

/**
 * Created by eugene on 26/11/14.
 */
public class TrueFalse implements Serializable {
    private int mQuestion;

    private boolean mTrueQuestion;

    private boolean mIsCheated;

    public TrueFalse(int question, boolean trueQuestion) {
        this.mQuestion = question;
        this.mTrueQuestion = trueQuestion;
        this.mIsCheated = false;
    }

    public int getQuestion() {
        return mQuestion;
    }

    public void setQuestion(int question) {
        mQuestion = question;
    }

    public boolean isTrueQuestion() {
        return mTrueQuestion;
    }

    public void setTrueQuestion(boolean trueQuestion) {
        mTrueQuestion = trueQuestion;
    }

    public boolean isCheated() {
        return mIsCheated;
    }

    public void setCheated(boolean isCheated) {
        mIsCheated = isCheated;
    }

}
