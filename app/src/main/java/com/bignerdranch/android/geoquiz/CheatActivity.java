package com.bignerdranch.android.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Eugene on 11/29/2014.
 */
public class CheatActivity extends Activity {

    private static final String TAG = "CheatActivity";
    private static final String KEY_ANSWER_SHOWN = "answer_shown";
    private static final String KEY_ANSWER_IS_TRUE = "answer_is_true";

    public static final String EXTRA_ANSWER_IS_TRUE =
            "com.bignerdranch.android.geoquiz.answer_is_true";
    public static final String EXTRA_ANSWER_SHOWN =
            "com.bignerdrancg.android.geoquiz.answer_shown";

    private boolean mAnswerIsTrue;
    private boolean mAnswerShown;

    private TextView mAnswerTextView;
    private Button mShowAnswer;

    private void setAnswerShownResult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        mAnswerShown = false;

        setAnswerShownResult(mAnswerShown);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mAnswerTextView = (TextView) findViewById(R.id.answerTextView);

        mShowAnswer = (Button) findViewById(R.id.showAnswerButton);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mAnswerIsTrue) {
                    mAnswerTextView.setText(R.string.true_button);
                } else {
                    mAnswerTextView.setText(R.string.false_button);
                }
                mAnswerShown = true;
                setAnswerShownResult(mAnswerShown);
            }
        });

        if(savedInstanceState != null) {
            Log.d(TAG, "Load savedInstanceState.");
            mAnswerShown = savedInstanceState.getBoolean(KEY_ANSWER_SHOWN, false);
            mAnswerIsTrue = savedInstanceState.getBoolean(KEY_ANSWER_IS_TRUE, false);
            setAnswerShownResult(mAnswerShown);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "savedInstanceState..");
        Log.i(TAG, "mAnswerShown: " + mAnswerShown);
        savedInstanceState.putBoolean(KEY_ANSWER_SHOWN, mAnswerShown);
        savedInstanceState.putBoolean(KEY_ANSWER_IS_TRUE, mAnswerIsTrue);
    }
}
