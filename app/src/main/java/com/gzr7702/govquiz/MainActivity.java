package com.gzr7702.govquiz;

import android.support.annotation.BoolRes;
import android.support.constraint.solver.ArrayLinkedVariables;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    int mNumberCorrect = 0;
    // Question 1 views
    @BindView(R.id.judicial_checkbox) CheckBox judicialCheckbox;
    @BindView(R.id.nominal_checkbox) CheckBox nominalCheckbox;
    @BindView(R.id.executive_checkbox) CheckBox executiveCheckbox;
    @BindView(R.id.cooperative_checkbox) CheckBox cooperativeCheckbox;
    @BindView(R.id.legislative_checkbox) CheckBox legislativeCheckbox;
    //Question 2 views
    @BindView(R.id.question2_answer_text) EditText electoralVotesText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public void processAnswers(View v) {

        processQuestion1();
        processQuestion2();

        String answerString = Integer.toString(mNumberCorrect);
        Log.v("Answers correct", answerString);
    }

    private void processQuestion1() {
        if (judicialCheckbox.isChecked()
                && executiveCheckbox.isChecked()
                && legislativeCheckbox.isChecked()
                && !nominalCheckbox.isChecked()
                && !cooperativeCheckbox.isChecked()) {
            mNumberCorrect++;
        }
    }

    private void processQuestion2() {
        String answer = electoralVotesText.getText().toString().toString();
        Log.v("answer 2", answer);
        if (answer.equals("240")) {
            mNumberCorrect++;
        }
    }
}
