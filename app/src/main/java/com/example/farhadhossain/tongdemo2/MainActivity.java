package com.example.farhadhossain.tongdemo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView cha;
    private TextView cigg;
    private Button addProduct, sellProduct, seeReport, others;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addProduct = (Button) findViewById(R.id.addProduct);
        sellProduct = (Button) findViewById(R.id.sellProduct);
        seeReport = (Button) findViewById(R.id.report);
        others = (Button) findViewById(R.id.others);

        addProduct.setOnClickListener(this);
        sellProduct.setOnClickListener(this);
        seeReport.setOnClickListener(this);
        others.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.addProduct){
            Intent i = new Intent(getApplicationContext(),AddProduct.class);
            startActivity(i);
        }
        if(v.getId()==R.id.sellProduct){
            Intent i = new Intent(getApplicationContext(),SellProduct.class);
            startActivity(i);
        }
        if(v.getId()==R.id.report){
            Toast.makeText(MainActivity.this,"Report" , Toast.LENGTH_LONG).show();
        }
        if(v.getId()==R.id.others){
            Toast.makeText(MainActivity.this,"Others" , Toast.LENGTH_LONG).show();
        }
    }
}
