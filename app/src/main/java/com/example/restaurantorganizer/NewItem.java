package com.example.restaurantorganizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class NewItem extends AppCompatActivity {

    ArrayList<Item> m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        m=getIntent().getParcelableArrayListExtra("m");
        setup();
    }

    void setup(){
        setContentView(R.layout.activity_new_item);
        final Button mDefinitionsButton = findViewById(R.id.confirm);
        mDefinitionsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                createEvent();
                setup();
            }
        });
        final Button mInterpretationsButton = findViewById(R.id.back);
        mInterpretationsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i= new Intent(NewItem.this,Menu.class);
                i.putParcelableArrayListExtra("m",m);
                startActivity(i);
            }
        });
    }


    void createEvent(){
        Log.e("create","start");
        EditText edit=findViewById(R.id.name);
        String n=edit.getText().toString();
        edit=findViewById(R.id.price);
        double p=Double.parseDouble(edit.getText().toString());
        Log.e("create","date start");
        if(p<0) {
            TextView textView = findViewById(R.id.status);
            String text = "Invalid price";
            textView.setText(text);
            return;
        }
        m.add(new Item(n,p));
        TextView textView =findViewById(R.id.status);
        String text="New Item Created";
        textView.setText(text);
        Log.e("create","finish");
    }
}
