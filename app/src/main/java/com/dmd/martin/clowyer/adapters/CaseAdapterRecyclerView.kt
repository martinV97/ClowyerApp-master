package com.dmd.martin.clowyer.adapters

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.dmd.martin.clowyer.R
import com.dmd.martin.clowyer.constants.Constants
import com.dmd.martin.clowyer.entity.ItemCase

class CaseAdapterRecyclerView: RecyclerView.Adapter<CaseAdapterRecyclerView.CaseViewHolder>() {

    private var  items:List<ItemCase> = Constants.listCases
    private var resource: Int = 0
    private var activity: Activity? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CaseViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: CaseViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class CaseViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        private val tVNameCase = itemView!!.findViewById<TextView>(R.id.nameCaseCard)
        private val tVNumberCase = itemView!!.findViewById<TextView>(R.id.numberCaseCard)
        private val tvCourtCase = itemView!!.findViewById<TextView>(R.id.courtCaseCard)
    }
}