package com.test.reddittop.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.reddittop.R
import com.test.reddittop.models.Child
import com.test.reddittop.models.GlobalData
import com.test.reddittop.models.News
import kotlinx.android.synthetic.main.item_news.view.*


class RecyclerViewAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerVH>() {
    private var newsList:List<GlobalData> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerVH {
        return RecyclerVH(LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false))
    }


    override fun getItemCount(): Int = newsList.size

    override fun onBindViewHolder(holder: RecyclerVH, position: Int) {
        val news = newsList[position]

        val url: String? = news.globalData?.data?.get(position)?.childData?.url
        if (url!=null) {
            url.let {
                holder.imgView.visibility = View.VISIBLE
                Glide.with(context).load(url).into(holder.imgView)
            }
        }else{
            holder.imgView.visibility = View.GONE
        }
        holder.titleTextView.text = news.globalData?.data?.get(position)?.childData?.title
        holder.sourceTextView.text = news.globalData?.data?.get(position)?.childData?.author
    }

    fun setNewsListItems(newsList: List<GlobalData>?){
        if (newsList != null) {
            this.newsList = newsList
        }
        notifyDataSetChanged()
    }

    open class RecyclerVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.tvText
        val sourceTextView: TextView = itemView.tvAuthor
        val imgView = itemView.imageView
    }

}