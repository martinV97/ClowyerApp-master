package com.dmd.martin.clowyer.adapters

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import com.dmd.martin.clowyer.R
import com.dmd.martin.clowyer.constants.Constants
import com.dmd.martin.clowyer.entity.ItemDoc

class DocAdapterRecyclerView(var items: List<ItemDoc>, var activity: Activity? = null, var resource: Int): RecyclerView.Adapter<DocAdapterRecyclerView.DocViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DocViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(resource, parent, false)
        return DocViewHolder(view)
    }

    override fun onBindViewHolder(holder: DocViewHolder, position: Int) {
        var doc = items[position]
        holder.nameDocCard.text = doc.getName()
        holder.typeDocCard.text = doc.getType()
        holder.imageButtonDocDownload.setOnClickListener{
            val uri = Uri.parse(Constants.listDocs!![position].getUrl())
            val intent = Intent(Intent.ACTION_VIEW, uri)
            activity!!.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class DocViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView){
        var nameDocCard = itemView!!.findViewById<TextView>(R.id.nameDocCard)!!
        var typeDocCard = itemView!!.findViewById<TextView>(R.id.typeDocCard)!!
        var imageButtonDocDownload = itemView!!.findViewById<ImageButton>(R.id.imageButtonDocDownload)!!
        var imageButtonDeleteDoc= itemView!!.findViewById<ImageButton>(R.id.imageButtonDeleteDoc)!!
    }
}