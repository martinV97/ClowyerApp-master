package com.dmd.martin.clowyer.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import com.dmd.martin.clowyer.R
import com.dmd.martin.clowyer.activities.LoadActivity
import com.dmd.martin.clowyer.constants.Constants
import com.dmd.martin.clowyer.entity.ItemDoc

class DocItemAdapter(var context: Context, private var  items:List<ItemDoc>)  : BaseAdapter() {

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
        rowView = layoutInflater.inflate(R.layout.activity_doc_item, null)
        val tvNameDocItem = rowView.findViewById<TextView>(R.id.tvNameDocItem)
        val tvTypeDocItem = rowView.findViewById<TextView>(R.id.tvTypeDocItem)
        val fabLookDoc = rowView.findViewById<FloatingActionButton>(R.id.fabLookDoc)
        val item = this.items!![position]
        tvNameDocItem.text = item.getName()
        tvTypeDocItem.text = item.getType()
        fabLookDoc.setOnClickListener{
            val uri = Uri.parse(Constants.listDocs!![position].getUrl())
            val intent = Intent(Intent.ACTION_VIEW, uri)
            context.startActivity(intent)
        }
        return rowView
    }
}