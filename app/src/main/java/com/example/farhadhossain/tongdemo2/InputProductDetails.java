package com.example.farhadhossain.tongdemo2;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class InputProductDetails extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    String[] categories = { "Tea","Bread", "Cigarate", "Banana", "Biscuit","Chips", "Bakery"};
    private EditText productName, quantity, purchasePrice, sellPrice;
    Button saveDetails,showData;
    private static String catG;
    SqliteHelper sqliteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_product_details);
        sqliteHelper = new SqliteHelper(getApplicationContext());

        productName = (EditText) findViewById(R.id.productName);
        quantity = (EditText) findViewById(R.id.quantity);
        purchasePrice = (EditText) findViewById(R.id.purchasePrice);
        sellPrice = (EditText) findViewById(R.id.sellPrice);
        saveDetails = (Button) findViewById(R.id.buttonSendFeedback);
        showData = (Button) findViewById(R.id.showData);



        Bundle extras = getIntent().getExtras();
        int pos = extras.getInt("category");

        Spinner spin = (Spinner) findViewById(R.id.spinner);


        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,categories);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
//        spin.setSelection(pos);
        spin.setAdapter(aa);
        spin.setSelection(pos);
        final String cateGory = spin.getSelectedItem().toString();


        saveDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String productNames = productName.getText().toString();
                int quanTity = Integer.parseInt(quantity.getText().toString());
                double buyPrice = Double.parseDouble(purchasePrice.getText().toString());
                double salePrice = Double.parseDouble(sellPrice.getText().toString());

                try {
                    sqliteHelper.addProduct(new Product(null, productNames, catG, quanTity, buyPrice, salePrice));
                    productName.setText("");
                    quantity.setText("");
                    purchasePrice.setText("");
                    sellPrice.setText("");
                    Toast.makeText(InputProductDetails.this, "Data Added", Toast.LENGTH_SHORT).show();
                } catch (Exception e){

                    Toast.makeText(InputProductDetails.this, "Product is not Added ", Toast.LENGTH_SHORT).show();

                }


            }
        });
        showData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), ProductList.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        catG = categories[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
/*
    public boolean validate() {
        boolean valid = false;

        //Get values from EditText fields


        //Handling validation for UserName field
        if (productName.getText().toString().isEmpty()) {
            valid = false;
            Toast.makeText(this, "Please enter product name", Toast.LENGTH_SHORT).show();
        } else {
            valid = true;
        }
        if (quantity.getText().toString().isEmpty()) {
            valid = false;
            Toast.makeText(this, "Please enter product name", Toast.LENGTH_SHORT).show();
        } else {
            valid = true;
        }

        if (purchasePrice.getText().toString().isEmpty()) {
            valid = false;
            Toast.makeText(this, "Please enter product name", Toast.LENGTH_SHORT).show();
        } else {
            valid = true;
        }

        if (sellPrice.getText().toString().isEmpty()) {
            valid = false;
            Toast.makeText(this, "Please enter product name", Toast.LENGTH_SHORT).show();
        } else {
            valid = true;
        }




        return valid;
    }
    */

}
