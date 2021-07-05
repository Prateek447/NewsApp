package com.example.mycodebook.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.mycodebook.newsapp.databinding.ActivityMainBinding
import com.example.mycodebook.newsapp.presentation.NewsAdapter
import com.example.mycodebook.newsapp.presentation.viewmodel.NewsViewModel
import com.example.mycodebook.newsapp.presentation.viewmodel.NewsViewModelFactory
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory : NewsViewModelFactory
    lateinit var viewModel : NewsViewModel
    @Inject
    lateinit var newsAdapter: NewsAdapter
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
         setContentView(binding.root)
//        binding.bnvNews.setupWithNavController(
//            fragment.findNavController()
//        )

        val navHostFragment =  supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bnvNews.setupWithNavController(
            navController
        )


        viewModel =  ViewModelProvider(this,factory).get(NewsViewModel::class.java)

    }
}