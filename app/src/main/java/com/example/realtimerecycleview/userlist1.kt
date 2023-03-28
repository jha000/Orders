package com.example.realtimerecycleview


import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import com.google.firebase.database.FirebaseDatabase
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import java.util.*

class userlist1 : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    var database: DatabaseReference? = null
    var myAdapter: MyAdapter? = null
    var list: ArrayList<User?>? = null
    lateinit var rb: FloatingActionButton
    lateinit var searchView: SearchView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userlist1)
        recyclerView = findViewById(R.id.userList)
        searchView = findViewById(R.id.search)
        searchView.clearFocus()
        database = FirebaseDatabase.getInstance().getReference("Country Eggs")
        recyclerView.setHasFixedSize(true)
        recyclerView.setLayoutManager(LinearLayoutManager(this))
        list = ArrayList()
        myAdapter = MyAdapter(this, list)
        recyclerView.setAdapter(myAdapter)
        rb = findViewById(R.id.bn_refresh)
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
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                searchList(newText)
                return true
            }
        })

    }

    fun searchList(text: String) {
        val searchList = ArrayList<User?>()
        for (dataClass in list!!) {
            if (dataClass!!.name.lowercase(Locale.getDefault())
                    .contains(text.lowercase(Locale.getDefault()))
            ) {
                searchList.add(dataClass)
            }
        }
        myAdapter!!.searchDataList(searchList)
    }
}