package com.example.networkingappwebinarpokemonretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.networkingappwebinarpokemonretrofit.data.Api
import com.example.networkingappwebinarpokemonretrofit.data.PokemonResponse
import com.example.networkingappwebinarpokemonretrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        val request = Api.build().loadPokemon(151)
        request.enqueue(object : Callback<PokemonResponse> {
            override fun onResponse(
                call: Call<PokemonResponse>,
                response: Response<PokemonResponse>
            ) {
                val pokemonResponse = response.body()
                pokemonResponse?.results?.let {
                    it.forEach {
                        binding.tvResult.append("${it.name}")
                        binding.tvResult.append("\n")
                    }
                }
            }

            override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                println(t.message)
            }
        })
    }
}