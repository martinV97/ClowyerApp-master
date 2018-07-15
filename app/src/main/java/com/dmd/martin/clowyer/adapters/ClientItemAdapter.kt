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
import com.dmd.martin.clowyer.activities.ClientActivity
import com.dmd.martin.clowyer.entity.ItemClient

class ClientItemAdapter (var context: Context, private var  items:List<ItemClient>)  : BaseAdapter()  {

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
        rowView = layoutInflater.inflate(R.layout.activity_client_item, null)
        val tVNameClient = rowView.findViewById<TextView>(R.id.tVNameClientItem)
        val tVIdentificationClient = rowView.findViewById<TextView>(R.id.tVIdentificationClientItem)
        val tVTypeClientItem = rowView.findViewById<TextView>(R.id.tVTypeClientItem)
        val tVPhoneClientItem = rowView.findViewById<TextView>(R.id.tVPhoneClientItem)
        val buttonDeleteClientItem = rowView.findViewById<Button>(R.id.buttonDeleteClientItem)
        val item = this.items!![position]
        tVNameClient.text = item.getName()
        tVIdentificationClient.text = item.getIdentification()
        tVTypeClientItem.text = item.getType()
        tVPhoneClientItem.text = item.getPhone()
        buttonDeleteClientItem.setOnClickListener{
            var bundle = Bundle()
            bundle.putSerializable("Item", item)
            var intent = Intent(context, ClientActivity::class.java)
            intent.putExtras(bundle)
            context.startActivity(intent)
        }
        return rowView
    }
}