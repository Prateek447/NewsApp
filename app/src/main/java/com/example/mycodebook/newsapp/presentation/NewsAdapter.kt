package com.example.mycodebook.newsapp.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mycodebook.newsapp.data.model.Article
import com.example.mycodebook.newsapp.databinding.NewsListItemBinding

class NewsAdapter: RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {



    private val callback = object : DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {

            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this,callback)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        Log.i("MYTAG","OnCreateViewHoder")
        val binding = NewsListItemBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return NewsViewHolder(binding)
    }



    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        Log.i("MYTAG","OnbindingViewHoder")
        val article = differ.currentList[position]
        holder.bind(article)
    }

    override fun getItemCount(): Int {
        Log.i("MYTAG","getItemCount")
        return differ.currentList.size
    }

    inner class NewsViewHolder(
        private val binding:NewsListItemBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(article: Article){
            Log.i("MYTAG","came here ${article.title}")
            binding.tvTitle.text = article.title
            binding.tvDescription.text = article.description
            binding.tvPublishedAt.text = article.publishedAt
            binding.tvSource.text = article.source.name

            Glide.with(binding.ivArticleImage.context).
            load(article.urlToImage).
            into(binding.ivArticleImage)
        }
    }




}