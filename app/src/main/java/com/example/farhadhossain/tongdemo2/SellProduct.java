package com.example.farhadhossain.tongdemo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SellProduct extends AppCompatActivity implements View.OnClickListener{
    private Button tea, bread, cigarate, banana, biscuit,chips, bakery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        tea = (Button) findViewById(R.id.cha);
        bread = (Button) findViewById(R.id.bread);
        cigarate = (Button) findViewById(R.id.cigarate);
        banana = (Button) findViewById(R.id.banana);
        biscuit = (Button) findViewById(R.id.biscuit);
        chips = (Button) findViewById(R.id.chips);
        bakery = (Button) findViewById(R.id.bakery);

        tea.setOnClickListener(this);
        bread.setOnClickListener(this);
        cigarate.setOnClickListener(this);
        banana.setOnClickListener(this);
        biscuit.setOnClickListener(this);
        chips.setOnClickListener(this);
        bakery.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.cha){
            Intent i = new Intent(getApplicationContext(),SellProductDetails.class);
            i.putExtra("category",0);
            startActivity(i);
        }
        if(v.getId()==R.id.bread){
            Intent i = new Intent(getApplicationContext(),SellProductDetails.class);
            i.putExtra("category",1);
            startActivity(i);
        }
        if(v.getId()==R.id.cigarate){
            Intent i = new Intent(getApplicationContext(),SellProductDetails.class);
            i.putExtra("category",2);
            startActivity(i);
        }
        if(v.getId()==R.id.banana){
            Intent i = new Intent(getApplicationContext(),SellProductDetails.class);
            i.putExtra("category",3);
            startActivity(i);
        }
        if(v.getId()==R.id.biscuit){
            Intent i = new Intent(getApplicationContext(),SellProductDetails.class);
            i.putExtra("category",4);
            startActivity(i);
        }
        if(v.getId()==R.id.chips){
            Intent i = new Intent(getApplicationContext(),SellProductDetails.class);
            i.putExtra("category",5);
            startActivity(i);
        }
        if(v.getId()==R.id.bakery){
            Intent i = new Intent(getApplicationContext(),SellProductDetails.class);
            i.putExtra("category",6);
            startActivity(i);
        }
    }
}
