package com.example.listaeventos.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listaeventos.R
import com.example.listaeventos.dto.PostList
import com.example.listaeventos.model.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var listView = ArrayList<PostList>()
    lateinit var recyclerView : RecyclerView
    lateinit var adapter : DataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.adapter = DataAdapter(listView, this)
        recyclerView.layoutManager=LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)

        getData()
        //CustomAdapter(listView, this);
    }

    private fun getData() {
        val call: Call<List<PostList>> = ApiClient.getPosts()
        call.enqueue(object : Callback<List<PostList>> {

            override fun onResponse(call: Call<List<PostList>>?, response: Response<List<PostList>>?) {
                listView.addAll(response!!.body()!!)
                recyclerView.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<PostList>>?, t: Throwable?) {
            }

        })
    }

    private class CustomAdapter(context: Context) : BaseAdapter(){

        private val mContext : Context = context

        private val titles = arrayListOf<String>(

        )

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val row = layoutInflater.inflate(R.layout.row_adapter, parent, false)

            val textViewTitulo = row.findViewById<TextView>(R.id.title)
            textViewTitulo.text = "Titulo"
            return row
        }

        override fun getItem(position: Int): Any {
            return 0
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        //responsável pela quantia de itens da lista
        override fun getCount(): Int {
            return 5
        }


    }

}
