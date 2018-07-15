package com.dmd.martin.clowyer.adapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import com.dmd.martin.clowyer.R
import com.dmd.martin.clowyer.activities.CourtActivity
import com.dmd.martin.clowyer.entity.ItemCourt

class CourtItemAdapter (var context: Context, private var  items:List<ItemCourt>)  : BaseAdapter()   {
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
        rowView = layoutInflater.inflate(R.layout.activity_court_item, null)
        val tvNameCourtItem = rowView.findViewById<TextView>(R.id.tvNameCourtItem)
        val tvPhoneCourtItem = rowView.findViewById<TextView>(R.id.tvPhoneCourtItem)
        val tvTypeCourtItem = rowView.findViewById<TextView>(R.id.tvTypeCourtItem)
        val buttonDeleteCourtItem = rowView.findViewById<Button>(R.id.buttonDeleteCourtItem)
        val item = this.items!![position]
        tvNameCourtItem.text = item.getName()
        tvPhoneCourtItem.text = item.getPhone()
        tvTypeCourtItem.text = item.getType()
        buttonDeleteCourtItem.setOnClickListener{
            var bundle = Bundle()
            bundle.putSerializable("Item", item)
            var intent = Intent(context, CourtActivity::class.java)
            intent.putExtras(bundle)
            context.startActivity(intent)
        }
        return rowView
    }
}