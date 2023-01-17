package com.example.realtimerecycleview;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button recylerviewbtn;
    Button recylerviewbtn1;
//    Button recylerviewbtn2;
//    Button recylerviewbtn3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recylerviewbtn = findViewById(R.id.recyclerviewbtn);
        recylerviewbtn1 = findViewById(R.id.recyclerviewbtn1);
//        recylerviewbtn2 = findViewById(R.id.recyclerviewbtn2);
//        recylerviewbtn3 = findViewById(R.id.recyclerviewbtn3);
        recylerviewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,userlist.class);
                startActivity(i);



            }
        });

        recylerviewbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,userlist1.class);
                startActivity(i);



            }
        });

//        recylerviewbtn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent i = new Intent(MainActivity.this,usersClass.class);
//                startActivity(i);
//
//
//
//            }
//        });
//
//        recylerviewbtn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent i = new Intent(MainActivity.this,feedbacksClass.class);
//                startActivity(i);
//
//
//
//            }
//        });

    }
}