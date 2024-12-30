package com.example.week1

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.week1.data.Contact
import com.example.week1.ui.my.ContactViewModel

class ContactsAdapter(private var contactList: List<Contact>,private val viewModel: ContactViewModel) : RecyclerView.Adapter<ContactsAdapter.ContactViewHolder>() {

    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.contactName)
        val timeTextView: TextView = itemView.findViewById(R.id.contactTime)
        val phoneTextView: TextView = itemView.findViewById(R.id.contactPhoneNumber)
        val contactImageView: ImageView = itemView.findViewById(R.id.contactImage)
        val phoneIcon: ImageView = itemView.findViewById(R.id.phoneIcon)
        val favoriteIcon:ImageView=itemView.findViewById(R.id.favoriteIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contactList[position]
        holder.nameTextView.text = contact.name
        holder.timeTextView.text = contact.time
        holder.phoneTextView.text = contact.phoneNumber
        holder.contactImageView.setImageResource(contact.image)

        val favoriteIconRes=if(contact.isFavorite){
            R.drawable.favorite_yes
        }else{
            R.drawable.favorite
        }
        holder.favoriteIcon.setImageResource(favoriteIconRes)

        //즐겨찾기 버튼 클릭 이벤트
        holder.favoriteIcon.setOnClickListener{
            viewModel.toggleFavorite(contact)
        }

        // 전화 아이콘 클릭 시 전화 걸기 기능 구현
        holder.phoneIcon.setOnClickListener {
            val phoneNumber = contact.phoneNumber
            val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            it.context.startActivity(dialIntent)
        }
    }

    fun updateContacts(newContacts:List<Contact>){
        this.contactList=newContacts
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return contactList.size
    }
}
