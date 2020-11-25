package com.test.reddittop

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.reddittop.adapters.RecyclerViewAdapter
import com.test.reddittop.network.Status
import com.test.reddittop.viewmodels.ActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

import androidx.lifecycle.lifecycleScope
import com.test.reddittop.models.Child
import com.test.reddittop.models.News
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private lateinit var activityViewModel: ActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        val recyclerViewAdapter = RecyclerViewAdapter(this)
        recyclerView.adapter = recyclerViewAdapter

        activityViewModel = ViewModelProvider(this).get(ActivityViewModel::class.java)
        observeGetPosts()
    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch {
            activityViewModel.getNews()
        }
    }

    private fun observeGetPosts() {
        activityViewModel.simpleLiveData.observe(this, Observer {
            when (it.status) {
                Status.LOADING -> viewOneLoading()
                Status.SUCCESS -> viewOneSuccess(it.data)
                Status.ERROR -> viewOneError(it.error)
            }
        })
    }

    private fun viewOneLoading() {
    }

    private fun viewOneSuccess(data: List<News>?) {
        println("success")
    }

    private fun viewOneError(error: Error?) {
        error?.let {
            Toast.makeText(applicationContext, error.message, Toast.LENGTH_SHORT).show()
        }
    }
}