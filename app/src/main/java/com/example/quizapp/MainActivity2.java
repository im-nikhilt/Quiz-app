package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        final ArrayList<String> overall = (ArrayList<String>) getIntent().getSerializableExtra("Start");

        Button btn = (Button) findViewById(R.id.ans1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int score = 0;

                RadioButton correct_one = (RadioButton) findViewById(R.id.r3);
                if (correct_one.isChecked()) {
                    overall.add("Answer of 1 is Correct");
                    score += 1;
                } else
                    overall.add("Answer of 1 is Incorrect");

                RadioButton correct_two = (RadioButton) findViewById(R.id.t);
                if (correct_two.isChecked()) {
                    overall.add("Answer of 2 is Correct");
                    score += 1;
                } else
                    overall.add("Answer of 2 is Incorrect");

                int[] correct_three = new int[]{R.id.c1, R.id.c2, R.id.c4};
                int knt = 0;
                for (int i = 0; i < 3; i++) {
                    CheckBox temp2 = (CheckBox) findViewById(correct_three[i]);
                    if (temp2.isChecked())
                        knt += 1;
                }
                if (knt == 3) {
                    overall.add("Answer of 3 is Correct");
                    score += 1;
                } else {
                    overall.add("Answer of 3 is Incorrect");
                }

                EditText Q4 = (EditText) findViewById(R.id.ans);
                String answer_written2 = Q4.getText().toString();
                String answer2 = "Java archive";
                if (answer_written2.equalsIgnoreCase(answer2)) {
                    overall.add("Answer of 4 is Correct");
                    score += 1;
                } else {
                    overall.add("Answer of 4 is Incorrect");
                }

                String scorez = "Score : " + score;
                overall.add(scorez);

                Intent i1 = new Intent(MainActivity2.this, Main_result.class);
                i1.putStringArrayListExtra("result",overall);
                startActivity(i1);
            }
        });
    }
}