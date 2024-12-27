package com.example.week1


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.week1.data.Contact

class ContactsAdapter(private val contactList: List<Contact>) : RecyclerView.Adapter<ContactsAdapter.ContactViewHolder>(){
    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.contactName)
        val timeTextView: TextView = itemView.findViewById(R.id.contactTime)
        val phoneTextView: TextView = itemView.findViewById(R.id.contactPhoneNumber)
        val contactImageView: ImageView =itemView.findViewById(R.id.contactImage)
    }

    // ViewHolder 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ContactViewHolder(view)
    }

    // 데이터 바인딩
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contactList[position]
        holder.nameTextView.text = contact.name
        holder.timeTextView.text = contact.time
        holder.phoneTextView.text = contact.phoneNumber
        holder.contactImageView.setImageResource(contact.image)
    }

    // 아이템 갯수 반환
    override fun getItemCount(): Int {
        return contactList.size
    }
}

