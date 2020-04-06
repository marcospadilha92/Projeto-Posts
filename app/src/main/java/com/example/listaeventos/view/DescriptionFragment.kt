package com.example.listaeventos.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listaeventos.R
import com.example.listaeventos.model.ApiClient
import com.example.listaeventos.viewmodel.DescriptionList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DescriptionFragment : Fragment() {

    var listView = ArrayList<DescriptionList>()
    lateinit var recyclerView : RecyclerView
    lateinit var adapter : DescriptionAdapter
    var name: String? = "1"

    companion object {

        const val ARG_NAME = "user"

        fun newInstance(user: String): DescriptionFragment {
            val fragment = DescriptionFragment()

            val bundle = Bundle().apply {
                putString(ARG_NAME, user)
            }

            fragment.arguments = bundle

            return DescriptionFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.description_fragment, container, false)
        val activity = activity as Context

        name = arguments?.getString(ARG_NAME)

        recyclerView = view.findViewById(R.id.description_recyclerView)

        recyclerView.adapter = DescriptionAdapter(listView, activity)
        recyclerView.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)

        if (name != null) {
            getData(name!!.toInt())
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        getData(name!!.toInt())
    }

    private fun getData(user: Int) {
        val call: Call<List<DescriptionList>> = ApiClient.getDescription(user)
        call.enqueue(object : Callback<List<DescriptionList>> {

            override fun onResponse(call: Call<List<DescriptionList>>?, response: Response<List<DescriptionList>>?) {
                listView.addAll(response!!.body()!!)
                recyclerView.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<DescriptionList>>?, t: Throwable?) {
            }

        })
    }
}


