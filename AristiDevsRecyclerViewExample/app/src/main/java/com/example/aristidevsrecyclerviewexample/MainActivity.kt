package com.example.aristidevsrecyclerviewexample

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aristidevsrecyclerviewexample.Modelo.SuperHero
import com.example.aristidevsrecyclerviewexample.Modelo.SuperHeroProvider
import com.example.aristidevsrecyclerviewexample.adapter.SuperHeroAdapter
import com.example.aristidevsrecyclerviewexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var superHeroMutableList: MutableList<SuperHero> =
        SuperHeroProvider.superHeroList.toMutableList()
    private lateinit var adapter: SuperHeroAdapter
    private val llmanager = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAddSuperHero.setOnClickListener { createSuperHero() }
        configFilter()
//        configSwipe()
        myConfigSwipe()
        initRecyclerView()
    }

    private fun configSwipe() {
        binding.swipe.setColorSchemeResources(R.color.teal_700, R.color.purple_200)
        binding.swipe.setProgressBackgroundColorSchemeColor(
            ContextCompat.getColor(
                this,
                R.color.black
            )
        )
//        binding.swipe.isEnabled = false
        binding.swipe.setOnRefreshListener {
            Log.i("aris", "Funciona")
            Handler(Looper.getMainLooper()).postDelayed({
                binding.swipe.isRefreshing = false
            }, 2000)
        }
    }

    private fun myConfigSwipe() {
        binding.swipe.setColorSchemeResources(R.color.teal_700, R.color.purple_200)
        binding.swipe.setProgressBackgroundColorSchemeColor(
            ContextCompat.getColor(
                this,
                R.color.black
            )
        )
        binding.swipe.setOnRefreshListener {
            Log.i("Gerardo", "FUNIONA")
            Handler(Looper.getMainLooper()).postDelayed({
                binding.swipe.isRefreshing = false
            }, 2000)
            binding.swipe.setRefreshing(false)
            //your code on swipe refresh
            //we are checking networking connectivity
            val connection = isNetworkAvailable()
            if (connection) {
                // Configurar RecyclerView
                initRecyclerView()
            }
        }
    }

    fun isNetworkAvailable(): Boolean {
        val connectivityManager =
            this.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.activeNetworkInfo != null
    }

    private fun configFilter() {
        binding.etFilter.addTextChangedListener { userFilter ->
            val superheroesFiltered = superHeroMutableList.filter { superHero ->
                superHero.superHero.lowercase().contains(userFilter.toString().lowercase())
            }
            adapter.updateSuperHeroes(superheroesFiltered)
        }
    }

    private fun createSuperHero() {
        val superHero = SuperHero(
            "Incognito",
            "AristiDevs",
            "???",
            "https://cursokotlin.com/wp-content/uploads/2017/07/daredevil.jpg"
        )

        superHeroMutableList.add(index = 3, superHero)
        adapter.notifyItemInserted(3)
        llmanager.scrollToPositionWithOffset(3, 10) // margen top 10
//        ultima posicion
//        adapter.notifyItemInserted(superHeroMutableList.size-1)
    }

    private fun initRecyclerView() {
        adapter = SuperHeroAdapter(
            superHeroList = superHeroMutableList,
            onClickListener = { superHero -> onItemSelected(superHero) },
            onClickDelete = { position -> onDeletedItem(position) })
        binding.recyclerSuperHero.layoutManager = llmanager
        binding.recyclerSuperHero.adapter = adapter

    }

    private fun onDeletedItem(position: Int) {
        superHeroMutableList.removeAt(position)
        adapter.notifyItemRemoved(position)
    }

    private fun onItemSelected(superHero: SuperHero) {
        Toast.makeText(this, superHero.superHero, Toast.LENGTH_SHORT).show()
    }

//    private fun initRecyclerView() {
////        val recyclerView = findViewById<RecyclerView>(R.id.recyclerSuperHero)
////        val managerGridLayoutManager = GridLayoutManager(this,2)
////        val decoration = DividerItemDecoration(this, manager.orientation)
//        val manager = LinearLayoutManager(this)
//        binding.recyclerSuperHero.layoutManager = manager
//        binding.recyclerSuperHero.adapter =
//            SuperHeroAdapter() { superHero ->
//                onItemSelected(superHero)
//            }
////        binding.recyclerSuperHero.addItemDecoration(decoration)
//    }
}