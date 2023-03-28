package com.example.realtimerecycleview

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class feedbacksClass : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    var database: DatabaseReference? = null
    var myAdapter: MyAdapter? = null
    var list: ArrayList<User?>? = null
    lateinit var rb: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedbacks_class)
        recyclerView = findViewById(R.id.userList)
        database = FirebaseDatabase.getInstance().getReference("Feedbacks")
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        list = ArrayList()
        myAdapter = MyAdapter(this, list)
        recyclerView.adapter = myAdapter
        rb = findViewById(R.id.bn_refresh)
        rb.setOnClickListener(View.OnClickListener {
            list!!.clear()
            database!!.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (dataSnapshot in snapshot.children) {
                        val user = dataSnapshot.getValue(
                            User::class.java
                        )
                        list!!.add(user)
                    }
                    myAdapter!!.notifyDataSetChanged()
                }

                override fun onCancelled(error: DatabaseError) {}
            })
        })

    }
}