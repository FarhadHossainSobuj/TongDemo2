package com.example.farhadhossain.tongdemo2;

import android.support.v7.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProductList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        SQLiteOpenHelper myDatabaseHelper = new SqliteHelper(this);
        try {
            SQLiteDatabase db = myDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query ("product",
                    new String[] {"productName", "category", "quantity", "purchase_price", "sell_price"},
                    "_id = ?",
                    new String[] {Integer.toString(1)},
                    null, null,null);
            //Move to the first record in the Cursor
            if (cursor.moveToFirst()) {
                //Get the drink details from the cursor
                String id = cursor.getString(0);
                String category = cursor.getString(1);
                String quantity = cursor.getString(2);
                String purchasePrice = cursor.getString(3);
                String sellPrice = cursor.getString(4);

                //Populate the drink name
                TextView ids = (TextView)findViewById(R.id.pid);
                ids.setText(id);
                TextView cataGory = (TextView)findViewById(R.id.category);
                cataGory.setText(category);
                TextView quantitys = (TextView)findViewById(R.id.quantity);
                quantitys.setText(quantity);
                TextView purchasePrices = (TextView)findViewById(R.id.purchasePrice);
                purchasePrices.setText(purchasePrice);
                TextView sellPrices = (TextView)findViewById(R.id.sellPrice);
                sellPrices.setText(sellPrice);


            }
        } catch(SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
