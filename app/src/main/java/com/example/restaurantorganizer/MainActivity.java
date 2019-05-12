package com.example.restaurantorganizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Item> m;
    ArrayList<Reservation> r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(m==null)m=new ArrayList<>();
        if(r==null)r=new ArrayList<>();
        final Button mDefinitionsButton = findViewById(R.id.men);
        mDefinitionsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,Menu.class);
                i.putParcelableArrayListExtra("m",m);
                startActivity(i);
            }
        });
        final Button mInterpretationsButton = findViewById(R.id.reservations);
        mInterpretationsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,Reservations.class);
                i.putParcelableArrayListExtra("r",r);
                startActivity(i);
            }
        });
        final Button mManagementButton = findViewById(R.id.tables);
        mManagementButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,Tables.class);
                i.putParcelableArrayListExtra("m",m);
                startActivity(i);
            }
        });

        //tables with waiting list and click table to get orders and bill
        //input reservations
        //update menu

    }
}
