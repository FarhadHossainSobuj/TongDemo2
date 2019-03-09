package com.example.farhadhossain.tongdemo2;

import android.support.v7.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProductList extends AppCompatActivity {


    SqliteHelper databaseHelper;
    TextView textView;

    ListView list;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        databaseHelper = new SqliteHelper(this);
        textView = (TextView) findViewById(R.id.textViewTask);

        printDB();



//        try {
//            SQLiteDatabase db = myDatabaseHelper.getReadableDatabase();
//            Cursor cursor = db.query ("product",
//                    new String[] {"productName", "category", "quantity", "purchase_price", "sell_price"},
//                    "_id = ?",
//                    new String[] {Integer.toString(1)},
//                    null, null,null);
//            //Move to the first record in the Cursor
//            if (cursor.moveToFirst()) {
//                String id = cursor.getString(0);
//                String category = cursor.getString(1);
//                String quantity = cursor.getString(2);
//                String purchasePrice = cursor.getString(3);
//                String sellPrice = cursor.getString(4);
//
//
//                TextView ids = (TextView)findViewById(R.id.pid);
//                ids.setText(id);
//                TextView cataGory = (TextView)findViewById(R.id.category);
//                cataGory.setText(category);
//                TextView quantitys = (TextView)findViewById(R.id.quantity);
//                quantitys.setText(quantity);
//                TextView purchasePrices = (TextView)findViewById(R.id.purchasePrice);
//                purchasePrices.setText(purchasePrice);
//                TextView sellPrices = (TextView)findViewById(R.id.sellPrice);
//                sellPrices.setText(sellPrice);
//
//
//            }
//        } catch(SQLiteException e) {
//            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
//            toast.show();
//        }


    }


    public void printDB(){
        String dbString = databaseHelper.databasetostring();
        textView.setText(dbString);
    }
}
