package com.gzr7702.govquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    int mNumberCorrect = 0;

    // Assign Views, only assign radio buttons that will be used
    // Question 1
    @BindView(R.id.question_one_answer_one_check) CheckBox judicialCheckbox;
    @BindView(R.id.question_one_answer_two_check) CheckBox nominalCheckbox;
    @BindView(R.id.question_one_answer_three_check) CheckBox executiveCheckbox;
    @BindView(R.id.question_one_answer_four_check) CheckBox cooperativeCheckbox;
    @BindView(R.id.question_one_answer_five_check) CheckBox legislativeCheckbox;

    //Question 2
    @BindView(R.id.question2_answer_text) EditText electoralVotesText;

    // Question 3
    @BindView(R.id.question_three_senate) RadioButton senateRadio;

    // Question 4
    @BindView(R.id.question_four_answer_one) RadioButton questionFourButtonOne;

    // Question 5
    @BindView(R.id.question_five_answer_one) RadioButton houseRadio;

    // Question 1
    @BindView(R.id.question_six_answer_one) CheckBox otherCheckBox;
    @BindView(R.id.question_six_answer_two) CheckBox weCheckBox;
    @BindView(R.id.question_six_answer_three) CheckBox democracyCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public void processAnswers(View v) {

        processQuestion1();
        processQuestion2();
        processQuestion3();
        processQuestion4();
        processQuestion5();
        processQuestion6();

         String message = null;

        if (mNumberCorrect == 0) {
            message = "Sorry, you didn't get any answers correct.";
        } else if (mNumberCorrect == 1) {
            message = "You got one answer correct!";
        } else {
            message = "You got " + Integer.toString(mNumberCorrect)+ " answers correct!";
        }

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

        // Reset number of answers correct
        mNumberCorrect = 0;
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
        String answer = electoralVotesText.getText().toString();
        if (answer.equals("240")) {
            mNumberCorrect++;
        }
    }

    public void processQuestion3() {
        if (senateRadio.isChecked()) {
            mNumberCorrect++;
        }
    }

    public void processQuestion4() {
        if (questionFourButtonOne.isChecked()) {
            mNumberCorrect++;
        }
    }

    public void processQuestion5() {
        if (houseRadio.isChecked()) {
            mNumberCorrect++;
        }
    }

    private void processQuestion6() {
        if (otherCheckBox.isChecked()
                && weCheckBox.isChecked()
                && democracyCheckBox.isChecked()) {
            mNumberCorrect++;
        }
    }

}
