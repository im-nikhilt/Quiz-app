package com.example.quizapp;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Main_result extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ArrayList<String> result = (ArrayList<String>) getIntent().getSerializableExtra("result");

        Resources r = getResources();
        String name = getPackageName();

        for (int i=0; i< result.size(); i++){
            int temp = r.getIdentifier("p"+i,"id",name);

            TextView var = (TextView)findViewById(temp);
            var.setText(result.get(i));
        }
    }
}