package com.dmd.martin.clowyer.adapters

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import com.dmd.martin.clowyer.R
import com.dmd.martin.clowyer.activities.LoadCaseActivity
import com.dmd.martin.clowyer.entity.ItemCase

class CaseAdapterRecyclerView(var items: List<ItemCase>, var activity: Activity? = null, var resource: Int) : RecyclerView.Adapter<CaseAdapterRecyclerView.CaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CaseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(resource, parent, false)
        return CaseViewHolder(view)
    }

    override fun onBindViewHolder(holder: CaseViewHolder, position: Int) {
        val case = items[position]
        holder.tVNameCase.text = case.getName()
        holder.tVNumberCase.text = case.getNumber()
        holder.tvCourtCase.text = case.getCourtName()
        holder.imageButtonCaseDetails.setOnClickListener {
            var bundle = Bundle()
            bundle.putSerializable("Item", case)
            var intent = Intent(activity, LoadCaseActivity::class.java)
            intent.putExtras(bundle)
            activity!!.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class CaseViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var tVNameCase = itemView!!.findViewById<TextView>(R.id.nameCaseCard)!!
        var tVNumberCase = itemView!!.findViewById<TextView>(R.id.numberCaseCard)!!
        var tvCourtCase = itemView!!.findViewById<TextView>(R.id.courtCaseCard)!!
        var imageButtonCaseDetails = itemView!!.findViewById<ImageButton>(R.id.imageButtonCaseDetails)
        var imageButtonDeleteCase = itemView!!.findViewById<ImageButton>(R.id.imageButtonDeleteCase)
    }
}