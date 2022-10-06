package com.example.learningrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.learningrecyclerview.model.fakeEmails

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler_view_main = findViewById<RecyclerView>(R.id.recycler_view_main)

        recycler_view_main.adapter = EmailAdapter(fakeEmails())
        recycler_view_main.layoutManager = LinearLayoutManager(this)

    }
}
