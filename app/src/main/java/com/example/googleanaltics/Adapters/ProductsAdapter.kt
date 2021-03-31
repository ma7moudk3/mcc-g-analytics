package com.example.googleanaltics.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.googleanaltics.Models.Product
import com.example.googleanaltics.R

class ProductsAdapter(private val context: Context, var data: ArrayList<Product>) : BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.products_item, parent, false)
        val tvName = rowView.findViewById(R.id.tvProductName) as TextView
        tvName.text = data[position].name
        val tvDescrip = rowView.findViewById(R.id.tvProductDescription) as TextView
        tvDescrip.text = data[position].description
        val img = rowView.findViewById(R.id.ProductImg) as ImageView
        img.setImageResource(data[position].img)
        return rowView
    }
}