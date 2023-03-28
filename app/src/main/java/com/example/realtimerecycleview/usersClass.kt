package com.example.realtimerecycleview

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.firebase.database.FirebaseDatabase
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import java.util.ArrayList

class usersClass : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    var database: DatabaseReference? = null
    var myAdapter: MyAdapter? = null
    var list: ArrayList<User?>? = null
    lateinit var rb: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users_class)
        recyclerView = findViewById(R.id.userList)
        database = FirebaseDatabase.getInstance().getReference("Users")
        recyclerView.setHasFixedSize(true)
        recyclerView.setLayoutManager(LinearLayoutManager(this))
        list = ArrayList()
        myAdapter = MyAdapter(this, list)
        recyclerView.setAdapter(myAdapter)
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