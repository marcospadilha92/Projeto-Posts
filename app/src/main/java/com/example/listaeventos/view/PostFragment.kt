package com.example.listaeventos.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listaeventos.R
import com.example.listaeventos.model.ApiClient
import com.example.listaeventos.viewmodel.PostList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostFragment : Fragment() {

    var listView = ArrayList<PostList>()
    lateinit var recyclerView : RecyclerView
    lateinit var adapter : PostAdapter

    companion object {

        fun newInstance(): PostFragment {
            return PostFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.post_fragment, container, false)
        val activity = activity as Context

        recyclerView = view.findViewById(R.id.post_recyclerView)
        recyclerView.adapter = PostAdapter(listView, activity)
        recyclerView.layoutManager=LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)

        getData()

        return view
    }

    private fun getData() {
        val call: Call<List<PostList>> = ApiClient.getPosts()
        call.enqueue(object : Callback<List<PostList>> {

            override fun onResponse(call: Call<List<PostList>>?, response: Response<List<PostList>>?) {
                listView.addAll(response!!.body()!!)
                recyclerView.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<PostList>>?, t: Throwable?) {
                Toast.makeText(context, "Ocorreu um erro, desculpe o transtorno", Toast.LENGTH_SHORT).show()
            }

        })
    }
}