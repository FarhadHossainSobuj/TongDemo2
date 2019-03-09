package com.example.farhadhossain.tongdemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class SellProductDetails extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    String[] categories = { "Tea","Bread", "Cigarate", "Banana", "Biscuit","Chips", "Bakery"};
    String[] names = { "Tea","Bread", "Cigarate", "Banana", "Biscuit","Chips", "Bakery"};

    private EditText productName, quantity;
    Button saveDetails;
    private static String catG;
    SqliteHelper sqliteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_product_details);
        sqliteHelper = new SqliteHelper(getApplicationContext());

        productName = (EditText) findViewById(R.id.productName);
        quantity = (EditText) findViewById(R.id.quantity);
        saveDetails = (Button) findViewById(R.id.buttonSendFeedback);



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

                try {
                    sqliteHelper.sellProduct(new Product(null, productNames, catG, quanTity));
                    productName.setText("");
                    quantity.setText("");
                    Toast.makeText(SellProductDetails.this, "Product Sold", Toast.LENGTH_SHORT).show();
                } catch (Exception e){

                    Toast.makeText(SellProductDetails.this, "Product is not Sold ", Toast.LENGTH_SHORT).show();

                }


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
