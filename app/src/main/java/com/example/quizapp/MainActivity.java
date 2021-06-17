package com.example.quizapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<String> overall = new ArrayList<>();

        Button btn = (Button) findViewById(R.id.quiz);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                temp = (EditText) findViewById(R.id.ename);
                temp.setOnClickListener(this);
                String namez = "Name: " + temp.getText().toString();
                overall.add(namez);

                temp = (EditText) findViewById(R.id.esem);
                temp.setOnClickListener(this);
                String semesterz = "Semester: "+ temp.getText().toString();
                overall.add(semesterz);

                temp = (EditText) findViewById(R.id.eroll);
                temp.setOnClickListener(this);
                String rollnoz = "Roll no: "+ temp.getText().toString();
                overall.add(rollnoz);

                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putStringArrayListExtra("Start",overall);
                startActivity(i);
            }
        });

    }

    @Override
    public void onClick(View v) {
        if(v == temp){
            temp.getText().clear();;
        }
        //temp.setText("");
    }
}