package com.dmd.martin.clowyer.adapters
import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import com.dmd.martin.clowyer.R
import com.dmd.martin.clowyer.entity.ItemCourt

class CourtAdapterRecyclerView(var items: List<ItemCourt>, var activity: Activity? = null, var resource: Int): RecyclerView.Adapter<CourtAdapterRecyclerView.CourtViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourtViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(resource, parent, false)
        return CourtViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourtViewHolder, position: Int) {
        var court = items[position]
        holder.nameCourtCard.text = court.getName()
        holder.phoneCourtCard.text = activity!!.getString(R.string.tel_abbreviation) + court.getPhone()
        holder.typeCourtCard.text = court.getType()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class CourtViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView){
        var nameCourtCard = itemView!!.findViewById<TextView>(R.id.nameCourtCard)!!
        var phoneCourtCard = itemView!!.findViewById<TextView>(R.id.phoneCourtCard)!!
        var typeCourtCard = itemView!!.findViewById<TextView>(R.id.typeCourtCard)!!
        var imageButtonCourtDetails = itemView!!.findViewById<ImageButton>(R.id.imageButtonCourtDetails)!!
        var imageButtonDeleteCourt = itemView!!.findViewById<ImageButton>(R.id.imageButtonDeleteCourt)!!
    }
}