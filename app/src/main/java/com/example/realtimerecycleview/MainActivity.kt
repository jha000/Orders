package com.example.realtimerecycleview

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var recylerviewbtn: Button
    lateinit var recylerviewbtn1: Button

    //    Button recylerviewbtn2;
    //    Button recylerviewbtn3;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recylerviewbtn = findViewById(R.id.recyclerviewbtn)
        recylerviewbtn1 = findViewById(R.id.recyclerviewbtn1)
        //        recylerviewbtn2 = findViewById(R.id.recyclerviewbtn2);
//        recylerviewbtn3 = findViewById(R.id.recyclerviewbtn3);
        recylerviewbtn.setOnClickListener(View.OnClickListener {
            val i = Intent(this@MainActivity, userlist::class.java)
            startActivity(i)
        })
        recylerviewbtn1.setOnClickListener(View.OnClickListener {
            val i = Intent(this@MainActivity, userlist1::class.java)
            startActivity(i)
        })

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