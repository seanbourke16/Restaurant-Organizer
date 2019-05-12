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


        for (int i = 0; i <m.size(); i++) {

            TableRow row= new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);
            TextView n = new TextView(this);
            TextView p = new TextView(this);
            n.setText(m.get(i).name);
            p.setText(String.valueOf(m.get(i).price));
            row.addView(n);
            row.addView(p);
            ll.addView(row,i);
        }
    }
}
