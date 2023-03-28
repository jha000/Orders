package com.example.realtimerecycleview


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.*
import java.util.*

class userlist : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    var database: DatabaseReference? = null
    var myAdapter: MyAdapter? = null
    var list: ArrayList<User?>? = null
    lateinit var rb: FloatingActionButton
    lateinit var searchView: SearchView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userlist)
        recyclerView = findViewById(R.id.userList)
        searchView = findViewById(R.id.search)
        searchView.clearFocus()
        database = FirebaseDatabase.getInstance().reference
        recyclerView.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.reverseLayout = true
        layoutManager.stackFromEnd = true
        recyclerView.setLayoutManager(layoutManager)
        list = ArrayList()
        myAdapter = MyAdapter(this, list)
        recyclerView.setAdapter(myAdapter)
        rb = findViewById(R.id.bn_refresh)
        list!!.clear()
        val query = database!!.child("Poultry Eggs").orderByChild("Amount").limitToLast(2)
        query.addValueEventListener(object : ValueEventListener {
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