package com.dmd.martin.clowyer.cardviews.cases.view

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import com.dmd.martin.clowyer.R
import com.dmd.martin.clowyer.entity.ItemCase
import com.dmd.martin.clowyer.services.consumeRest.DocRest

class CaseAdapterRecyclerView(var items: List<ItemCase>, var activity: Activity? = null, var resource: Int) : RecyclerView.Adapter<CaseAdapterRecyclerView.CaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CaseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(resource, parent, false)
        return CaseViewHolder(view)
    }

    override fun onBindViewHolder(holder: CaseViewHolder, position: Int) {
        val case = items[position]
        holder.tVNameCase.text = case.getName()
        holder.tVNumberCase.text = activity!!.getString(R.string.number_abbreviation) + case.getNumber()
        holder.tvCourtCase.text = case.getCourtName()
        holder.imageButtonCaseDetails.setOnClickListener {
        DocRest(activity as AppCompatActivity?, case,
                    activity!!.findViewById(R.id.imageViewLoadDocs),activity!!.findViewById(R.id.progressBarMain)).execute()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class CaseViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var tVNameCase = itemView!!.findViewById<TextView>(R.id.nameCaseCard)!!
        var tVNumberCase = itemView!!.findViewById<TextView>(R.id.numberCaseCard)!!
        var tvCourtCase = itemView!!.findViewById<TextView>(R.id.courtCaseCard)!!
        var imageButtonCaseDetails = itemView!!.findViewById<ImageButton>(R.id.imageButtonCaseDetails)!!
        var imageButtonDeleteCase = itemView!!.findViewById<ImageButton>(R.id.imageButtonDeleteCase)!!
    }
}