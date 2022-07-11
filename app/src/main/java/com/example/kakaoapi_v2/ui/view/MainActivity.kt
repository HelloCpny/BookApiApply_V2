package com.example.kakaoapi_v2.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.kakaoapi_v2.R
import com.example.kakaoapi_v2.data.repository.BookSearchRepositoryImpl
import com.example.kakaoapi_v2.databinding.ActivityMainBinding
import com.example.kakaoapi_v2.ui.viewmodel.BookSearchVIewModelProviderFactory
import com.example.kakaoapi_v2.ui.viewmodel.BookSearchViewModel

class MainActivity : AppCompatActivity() {
    private val binding :ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    lateinit var bookSearchViewModel: BookSearchViewModel
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setBottomNavigation()
        val bookSearchRepository = BookSearchRepositoryImpl()
        val factory = BookSearchVIewModelProviderFactory(bookSearchRepository)
        bookSearchViewModel = ViewModelProvider(this,factory)[BookSearchViewModel::class.java]
    }
    fun setBottomNavigation(){
        //supportFragmentManager가 만약 booksearch_nav_host_fragment를 찾지 못할 경우
        // 어차피 화면 표시를 할 수 없기 때문에 val host를 만들지 못하고 종료되도록 한 것
        val host = supportFragmentManager
            .findFragmentById(R.id.booksearch_nav_host_fragment) as NavHostFragment? ?: return
        navController = host.navController
        binding.bottomNavigationBar.setupWithNavController(navController)
        //binding.bottomNavBar.setupWithNavController(navController)
    }
}