package com.dmd.martin.clowyer.adapters

import android.app.Activity
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.dmd.martin.clowyer.R
import com.dmd.martin.clowyer.entity.ItemClient

class ClientAdapterRecyclerView(var items: List<ItemClient>, var activity: Activity? = null, var resource: Int): RecyclerView.Adapter<ClientAdapterRecyclerView.ClientViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(resource, parent, false)
        return ClientViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {
        var client = items[position]
        holder.nameClientCard.text = client.getName()
        holder.idClientCard.text = client.getIdentification()
        holder.phoneClientCard.text = client.getPhone()
        if(client.getType() == "N")
            holder.typeClientCard.setBackgroundResource(R.drawable.n_icon)
        else
            holder.typeClientCard.setBackgroundResource(R.drawable.j_icon)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ClientViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var nameClientCard = itemView!!.findViewById<TextView>(R.id.nameClientCard)!!
        var idClientCard = itemView!!.findViewById<TextView>(R.id.idClientCard)!!
        var phoneClientCard = itemView!!.findViewById<TextView>(R.id.phoneClientCard)!!
        var typeClientCard = itemView!!.findViewById<ImageView>(R.id.typeClientCard)!!
        var imageButtonClientDetails = itemView!!.findViewById<ImageButton>(R.id.imageButtonClientDetails)!!
        var imageButtonDeleteClient = itemView!!.findViewById<ImageButton>(R.id.imageButtonDeleteClient)!!
    }
}