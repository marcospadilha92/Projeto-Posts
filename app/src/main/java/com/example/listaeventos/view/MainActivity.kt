package com.example.listaeventos.view

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.listaeventos.R
import com.example.listaeventos.viewmodel.PostList


class MainActivity : AppCompatActivity() {

    var listView = ArrayList<PostList>()
    lateinit var recyclerView : RecyclerView
    lateinit var adapter : PostAdapter
    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(
                    R.id.post_fragment,
                    PostFragment.newInstance(),
                    "Post fragment"
                )
                .commit()
        }
    }
}
