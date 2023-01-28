package com.example.tasksbotapp.data.firebaseRepository

import com.example.tasksbotapp.domain.model.Ask
import com.example.tasksbotapp.domain.repository.NetworkRepository
import com.example.tasksbotapp.presentation.asks_screen.AsksListAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class UserAsksFirebase(val ref: String): NetworkRepository {


    private val myRef = Firebase.database.getReference(ref)


    override fun removeData(){
        FirebaseDatabase.getInstance().getReference()
            .child(ref).removeValue()
    }


    override suspend fun getData(adapter: AsksListAdapter?) {
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = ArrayList<Ask>()
                for (s in snapshot.children) {
                    try {
                        val card: Ask? = s.getValue(Ask::class.java)
                        list.add(0, card!!)
                    } catch (e: Exception) {}
                    adapter!!.submitList(list)
                }
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }
}