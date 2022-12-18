package com.example.aristidevsrecyclerviewexample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aristidevsrecyclerviewexample.Modelo.SuperHero
import com.example.aristidevsrecyclerviewexample.R

class SuperHeroAdapter(
    private var superHeroList: List<SuperHero>,
    private val onClickListener: (SuperHero) -> Unit,
    private val onClickDelete: (Int) -> Unit
) :
    RecyclerView.Adapter<SuperHeroViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SuperHeroViewHolder(layoutInflater.inflate(R.layout.item_superhero, parent, false))
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        val item = superHeroList[position]
        holder.render(item, onClickListener, onClickDelete)
    }

    override fun getItemCount(): Int = superHeroList.size

    fun updateSuperHeroes(superHeroList: List<SuperHero>){
        this.superHeroList = superHeroList
        notifyDataSetChanged()
    }
}