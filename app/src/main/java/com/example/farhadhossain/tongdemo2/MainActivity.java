package com.example.farhadhossain.tongdemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView cha;
    private TextView cigg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cha = findViewById(R.id.cha);
        cigg = findViewById(R.id.cigg);


        cha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"চা" , Toast.LENGTH_LONG).show();
            }
        });

        cigg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"সিগারেট" , Toast.LENGTH_LONG).show();
            }
        });
    }
}
