package com.example.hw10

import android.content.ContentUris
import android.content.Context
import android.graphics.BitmapFactory
import android.os.Build
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw10.databinding.ItemBinding

data class Photo(val id: Long, val name: String)

class MyViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root)

class MyAdapter(private val context: Context, private val photos:MutableList<Photo>) : RecyclerView.Adapter<MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBinding.inflate(inflater,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val photo = photos[position]

        holder.binding.textView.text=photo.name

        val collection = if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.Q){
            MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL)
        }else{
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        }

        val contentUri = ContentUris.withAppendedId(
            collection,
            photo.id
        )

        val bitmap = context.contentResolver.openInputStream(contentUri)?.use{
            BitmapFactory.decodeStream(it)
        }

        holder.binding.imageView2.setImageBitmap(bitmap)
    }

    override fun getItemCount(): Int {
        return photos.size
    }
}

