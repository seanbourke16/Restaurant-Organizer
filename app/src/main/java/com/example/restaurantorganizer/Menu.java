package com.example.restaurantorganizer;

import android.content.Intent;
import android.graphics.Color;
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

public class Menu extends AppCompatActivity {

    ArrayList<Item> m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        m=getIntent().getParcelableArrayListExtra("m");

        TableLayout ll = (TableLayout) findViewById(R.id.menu);

        final Button mDefinitionsButton = findViewById(R.id.newItem);
        mDefinitionsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i= new Intent(Menu.this,NewItem.class);
                i.putParcelableArrayListExtra("m",m);
                startActivity(i);
            }
        });
        final Button hDefinitionsButton = findViewById(R.id.home);
        hDefinitionsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i= new Intent(Menu.this,MainActivity.class);
                i.putParcelableArrayListExtra("m",m);
                startActivity(i);
            }
        });


        TableRow row= new TableRow(this);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        row.setLayoutParams(lp);
        TextView n = new TextView(this);
        TextView p = new TextView(this);
        String na="Item";
        n.setText(na);
        na="Price";
        p.setText(String.valueOf(na));
        n.setWidth(200);
        n.setTextColor(Color.argb(255,0,0,0));
        n.setTextSize(20);
        p.setWidth(200);
        p.setTextColor(Color.argb(255,0,0,0));
        p.setTextSize(20);
        row.addView(n);
        row.addView(p);
        ll.addView(row,0);

        for (int i = 0; i <m.size(); i++) {

            row= new TableRow(this);
            lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);
            n = new TextView(this);
            p = new TextView(this);
            n.setText(m.get(i).name);
            String pr="$"+String.valueOf(m.get(i).price);
            if(m.get(i).price%0.1==0)pr+="0";
            p.setText(pr);
            n.setWidth(200);
            n.setTextColor(Color.argb(255,0,0,0));
            n.setTextSize(20);
            p.setWidth(200);
            p.setTextColor(Color.argb(255,0,0,0));
            p.setTextSize(20);
            row.addView(n);
            row.addView(p);
            ll.addView(row,i+1);
        }
    }
}
