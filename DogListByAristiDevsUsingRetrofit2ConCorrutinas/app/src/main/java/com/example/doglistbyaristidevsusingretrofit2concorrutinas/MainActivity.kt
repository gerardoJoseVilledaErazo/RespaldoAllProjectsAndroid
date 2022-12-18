package com.example.doglistbyaristidevsusingretrofit2concorrutinas

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doglistbyaristidevsusingretrofit2concorrutinas.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jetbrains.anko.alert
import org.jetbrains.anko.yesButton
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: DogAdapter
    private val dogImages = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.svDogs.setOnQueryTextListener(this)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = DogAdapter(dogImages)
        binding.rvDogs.setHasFixedSize(true)
        binding.rvDogs.layoutManager = LinearLayoutManager(this)
        binding.rvDogs.adapter = adapter
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create()) // conversion de json a dogResponse
            .build()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun searchByName(query: String) {
        CoroutineScope(Dispatchers.IO).launch {
            // esto se hara en un hilo secundario
            val call =
                getRetrofit().create(APIService::class.java).getDogsByBreeds("$query/images")
            val puppies = call.body() /*as DogsResponse*/
            runOnUiThread {
                // lo que ejecutemos aca se ejecutara en el hilo principal
                if (call.isSuccessful) {
                    val images: List<String> = puppies?.images ?: emptyList() // operador Elvis
                    dogImages.clear()
                    dogImages.addAll(images)
                    adapter.notifyDataSetChanged()
                } else {
                    // show error
//                    showError()
                    showErrorDialog()
                }
                hideKeyboard()
            }
        }
    }


    /*private fun searchByName(query: String) {
        doAsync {
            // esto se hara en un hilo secundario
            val call*//*: Response<DogsResponse>*//* =
                getRetrofit().create(APIService::class.java).getDogsByBreeds("$query/images")
            val puppies*//*: DogsResponse?*//* = call.body() as DogsResponse
            runOnUiThread {
                // lo que ejecutemos aca se ejecutara en el hilo principal
                if (call.isSuccessful) {
                    val images: List<String> = puppies?.images ?: emptyList() // operador Elvis
                    dogImages.clear()
                    dogImages.addAll(images)
                    adapter.notifyDataSetChanged()
                } else {
                    // show error
                    showError()
                }
                hideKeyBoard()
            }
        }
    }*/

    private fun hideKeyboard() {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.viewRoot.windowToken, 0)
    }

    private fun showError() {
        Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }

    private fun showErrorDialog() {
        alert("Ha ocurrido un error, inténtelo de nuevo.") {
            yesButton { }
        }.show()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
//        if (query.isNullOrEmpty()) {
//            if (query != null) {
//                searchByName(query.lowercase())
//            }
//        }
        if (query != null) {

            searchByName(query.lowercase().trim())
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
}