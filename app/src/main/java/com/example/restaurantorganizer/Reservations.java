package com.example.restaurantorganizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class Reservations extends AppCompatActivity {

    ArrayList<Reservation> r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        r=getIntent().getParcelableArrayListExtra("r");

        TableLayout ll = (TableLayout) findViewById(R.id.reservation);

        final Button mDefinitionsButton = findViewById(R.id.newRes);
        mDefinitionsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i= new Intent(Reservations.this,NewReservation.class);
                i.putParcelableArrayListExtra("r",r);
                startActivity(i);
            }
        });


        TableRow row= new TableRow(this);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        row.setLayoutParams(lp);
        TextView n = new TextView(this);
        TextView p = new TextView(this);
        String na="Name";
        n.setText(na);
        na="Reservation Time";
        p.setText(String.valueOf(na));
        n.setWidth(200);
        p.setWidth(200);
        row.addView(n);
        row.addView(p);
        ll.addView(row,0);

        for (int i = 0; i <r.size(); i++) {

            row= new TableRow(this);
            lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);
            n = new TextView(this);
            p = new TextView(this);
            n.setText(r.get(i).name);
            String pr=String.valueOf(r.get(0).date);
            p.setText(pr);
            n.setWidth(200);
            p.setWidth(200);
            row.addView(n);
            row.addView(p);
            ll.addView(row,i+1);
        }
    }
}
