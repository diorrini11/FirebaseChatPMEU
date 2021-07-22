package com.example.firebasechatpmeu.recyclerview.item

import android.content.Context
import com.example.firebasechatpmeu.R
import com.example.firebasechatpmeu.glide.GlideApp
import com.example.firebasechatpmeu.model.User
import com.example.firebasechatpmeu.util.StorageUtil
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_person.*

class PersonItem(val person: User,
                 val userId: String,
                 private val context: Context): Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.textView_name.text = person.name
        viewHolder.textView_bio.text = person.bio
        if (person.profilePicturePath != null)
            GlideApp.with(context)
                .load(StorageUtil.pathToReference(person.profilePicturePath))
                .placeholder(R.drawable.ic_baseline_account_box_24)
                .into(viewHolder.imageView_profile_picture)
    }

    override fun getLayout() = R.layout.item_person
}