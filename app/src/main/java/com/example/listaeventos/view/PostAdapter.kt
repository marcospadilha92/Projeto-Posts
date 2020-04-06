package com.example.listaeventos.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listaeventos.R
import com.example.listaeventos.viewmodel.PostList


class PostAdapter(private var postList: List<PostList>, val context: Context) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.post_adapter, parent, false))
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post= postList[position]

        holder.titleTextView.text=post.title
        holder.descriptionTextView.text=post.body
        var item = holder.buttonDescription.id

        holder.buttonDescription.setOnClickListener {
            val fragmentManager: FragmentManager =
                (context as AppCompatActivity).supportFragmentManager

            fragmentManager.beginTransaction()
                .add(
                    R.id.post_fragment,
                    DescriptionFragment.newInstance(item.toString()),
                    "description fragment"
                )
                .replace(R.id.post_fragment, Fragment())
                .commit()
        }
    }

    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        var titleTextView: TextView = itemLayoutView.findViewById(R.id.title_textView)
        var descriptionTextView: TextView = itemLayoutView.findViewById(R.id.description_textView)
        var buttonDescription: Button = itemLayoutView.findViewById(R.id.details_button)
    }

}


