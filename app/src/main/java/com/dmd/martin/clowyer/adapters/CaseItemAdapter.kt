package com.dmd.martin.clowyer.adapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.dmd.martin.clowyer.R
import com.dmd.martin.clowyer.activities.LoadCaseActivity
import com.dmd.martin.clowyer.entity.ItemCase

class CaseItemAdapter(var context: Context, private var  items:List<ItemCase>)  : BaseAdapter() {

    override fun getItem(position: Int): Any {
        return  items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var rowView: View? = convertView
        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        rowView = layoutInflater.inflate(R.layout.activity_case_item, null)
        val tVNameCase = rowView.findViewById<TextView>(R.id.nameCaseCard)
        val tVNumberCase = rowView.findViewById<TextView>(R.id.numberCaseCard)
        val tvCourtCase = rowView.findViewById<TextView>(R.id.tVCourtCaseItem)
        val fabLookCase = rowView.findViewById<FloatingActionButton>(R.id.fabLookCase)
        val item = this.items!![position]
        tVNameCase.text = item.getName()
        tVNumberCase.text = item.getNumber()
        tvCourtCase.text = item.getCourtName()
        fabLookCase.setOnClickListener{
            var bundle = Bundle()
            bundle.putSerializable("Item", item)
            var intent = Intent(context, LoadCaseActivity::class.java)
            intent.putExtras(bundle)
            context.startActivity(intent)
        }
        return rowView
    }
}
