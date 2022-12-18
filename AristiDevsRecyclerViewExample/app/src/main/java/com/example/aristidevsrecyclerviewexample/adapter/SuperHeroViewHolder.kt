package com.example.aristidevsrecyclerviewexample.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.aristidevsrecyclerviewexample.Modelo.SuperHero
import com.example.aristidevsrecyclerviewexample.R
import com.example.aristidevsrecyclerviewexample.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperHeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemSuperheroBinding.bind(view)

//    val superHero = view.findViewById<TextView>(R.id.tvSuperHeroName)
//    val realName = view.findViewById<TextView>(R.id.tvRealName)
//    val publisher = view.findViewById<TextView>(R.id.tvPublisher)
//    val photo = view.findViewById<ImageView>(R.id.ivSuperHero)

    fun render(
        superHeroModel: SuperHero,
        onClickListener: (SuperHero) -> Unit,
        onClickDelete: (Int) -> Unit
    ) {
        binding.tvSuperHeroName.text = superHeroModel.superHero
        binding.tvRealName.text = superHeroModel.realName
        binding.tvPublisher.text = superHeroModel.publisher
        Picasso.with(binding.ivSuperHero.context).load(superHeroModel.photo)
            .into(binding.ivSuperHero)
        itemView.setOnClickListener { onClickListener(superHeroModel) }
        binding.btnDelete.setOnClickListener { onClickDelete(absoluteAdapterPosition) }

//        binding.ivSuperHero.setOnClickListener {
//            Toast.makeText(
//                binding.ivSuperHero.context,
//                superHeroModel.realName,
//                Toast.LENGTH_SHORT
//            ).show()
//        }

//        itemView.setOnClickListener {
//            Toast.makeText(
//                binding.ivSuperHero.context,
//                superHeroModel.superHero,
//                Toast.LENGTH_SHORT
//            ).show()
//        }
    }
}