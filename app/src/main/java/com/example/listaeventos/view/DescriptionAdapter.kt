package com.example.listaeventos.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listaeventos.R
import com.example.listaeventos.viewmodel.DescriptionList

class DescriptionAdapter(private var descriptionList: List<DescriptionList>, val context: Context) : RecyclerView.Adapter<DescriptionAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.description_adapter,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return descriptionList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val description = descriptionList[position]

        holder.nameTextView.text = description.name
        holder.userNameTextView.text = description.userName
        holder.emailTextView.text = description.email
        holder.cityTextView.text = description.adress?.city
        holder.streetTextView.text = description.adress?.street
        holder.suiteTextView.text = description.adress?.suite
        holder.zipcodeTextView.text = description.adress?.zipcode
        holder.phoneTextView.text = description.phone
        holder.websiteTextView.text = description.webSite
        holder.zipcodeTextView.text = description.adress?.zipcode
        holder.companyNameTextView.text = description.company?.name
        holder.catchPhraseTextView.text = description.company?.catchPhrase
        holder.bsTextView.text = description.company?.bs
    }


    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        var nameTextView: TextView = itemLayoutView.findViewById(R.id.name_textView)
        var userNameTextView: TextView = itemLayoutView.findViewById(R.id.username_textView)
        var emailTextView: TextView = itemLayoutView.findViewById(R.id.email_textView)
        var cityTextView: TextView = itemLayoutView.findViewById(R.id.city_textView)
        var streetTextView: TextView = itemLayoutView.findViewById(R.id.street_textView)
        var suiteTextView: TextView = itemLayoutView.findViewById(R.id.suite_textView)
        var zipcodeTextView: TextView = itemLayoutView.findViewById(R.id.zipcode_textView)
        var phoneTextView: TextView = itemLayoutView.findViewById(R.id.phone_textView)
        var websiteTextView: TextView = itemLayoutView.findViewById(R.id.website_textView)
        var catchPhraseTextView: TextView = itemLayoutView.findViewById(R.id.catchph_textView)
        var companyNameTextView: TextView = itemLayoutView.findViewById(R.id.company_textView)
        var bsTextView: TextView = itemLayoutView.findViewById(R.id.bs_textView)
    }
}