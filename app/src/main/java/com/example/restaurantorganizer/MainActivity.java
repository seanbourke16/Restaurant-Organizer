package com.example.restaurantorganizer;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.BottomNavigationView;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Item> m;
    ArrayList<Reservation> r;
    //ArrayList<Table> t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(m==null)m=new ArrayList<>();
        if(r==null)r=new ArrayList<>();

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home: // Go Home
                        return true;
                    case R.id.menu:  // Go to disclaimer screen
                        Intent i1= new Intent(MainActivity.this,Menu.class);
                        i1.putParcelableArrayListExtra("m",m);
                        startActivity(i1);
                        return true;
                    case R.id.tables:  // Go to references screen
                        Intent i2= new Intent(MainActivity.this,Reservations.class);
                        i2.putParcelableArrayListExtra("r",r);
                        startActivity(i2);
                        return true;
                    case R.id.reservations: // Go to about screen
                        Intent i3= new Intent(MainActivity.this,Reservations.class);
                        i3.putParcelableArrayListExtra("r",r);
                        startActivity(i3);
                        return true;
                } return false; }});

        final Button mDefinitionsButton = findViewById(R.id.men);
        mDefinitionsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,Menu.class);
                i.putParcelableArrayListExtra("m",m);
                startActivity(i);
            }
        });
        /*final Button mInterpretationsButton = findViewById(R.id.reservations);
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
        });*/

        //tables with waiting list and click table to get orders and bill
        //input reservations
        //update menu

    }
}
