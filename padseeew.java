package com.example.liangminglin.mytab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class padseeew extends AppCompatActivity {

    //constant price
    final double priceAmount = 199.99;

    //get the textbox
    TextView numorder;


    //get the confirm button
    Button confirms;

    //create db
    DBManager db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_padseeew);

        //get the textbox
        numorder = (TextView) findViewById(R.id.order);

        //get the confirm button
        confirms = (Button) findViewById(R.id.confirm);


        //set it to the pointer
        db = new DBManager(this);

        storeOrder();
    }

    //insert into the database
    public void storeOrder()
    {
        confirms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                order newOrder = new order();

                newOrder.setFoodName("Pad See Ew");
                newOrder.setFoodPrice(priceAmount);
                newOrder.setAmount(count);

                db.insert(newOrder);

                Intent goTO = new Intent(padseeew.this, Menu1.class);

                startActivity(goTO);
            }
        });
    }

    //store numbers of orders
    private int count;

    //increase amount of orders
    public void countOrder(View v)
    {
        count ++;
        numorder.setText(Integer.toString(count));
    }

    //decrease amount of orders
    public void dCountOrder(View v)
    {
        //to prevent going to negative
        if(count > 0)
        {
            count--;
        }
        numorder.setText(Integer.toString(count));
    }
}
