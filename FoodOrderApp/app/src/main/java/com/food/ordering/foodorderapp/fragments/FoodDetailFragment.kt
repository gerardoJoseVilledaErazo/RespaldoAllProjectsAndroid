package com.food.ordering.foodorderapp.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
//import androidx.navigation.Navigation.findNavController
//import androidx.navigation.ui.navigateUp
import androidx.navigation.fragment.navArgs
import com.food.ordering.foodorderapp.R
import com.food.ordering.foodorderapp.databinding.FragmentFoodDetailBinding
import com.food.ordering.foodorderapp.viewmodel.FoodDetailViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

class FoodDetailFragment : Fragment() {
    private lateinit var binding: FragmentFoodDetailBinding
    private lateinit var viewModel: FoodDetailViewModel
    private val args: FoodDetailFragmentArgs by navArgs()
    private var quantity = 1
    // TODO: Rename and change types of parameters
//    private var param1: String? = null
//    private var param2: String? = null

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_food_detail, container, false)
        binding.foodDetailToolbar = "Detalle de la comida"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarDetail)

        val food = args.food
        binding.food = food

        binding.buttonAddToBasket.setOnClickListener {
            viewModel.addFoodsToBasket(
                foodNameBasket = food.foodName,
                foodImageNameBasket = food.foodImageName,
                foodPriceBasket = food.foodPrice,
                foodAmountBasket = quantity,
                "e_inan"
            )

//            val action =
//                FoodDetailFragmentDirections.actionFoodDetailFragmentToFoodBasketFragment(quantity)
//            Navigation.findNavController(it).navigate(action)

            val action =
                FoodDetailFragmentDirections.actionFoodDetailFragmentToFoodBasketFragment()
            Navigation.findNavController(it).navigate(action)
        }

        binding.imageViewIncrease.setOnClickListener {
            quantity++
            binding.textViewQuantity.text = quantity.toString()
            binding.textViewFoodPriceDetail.text = (quantity * food.foodPrice).toString() + " ₺"
        }

        binding.imageViewDecrease.setOnClickListener {
            if (quantity > 1) {
                quantity--
                binding.imageViewDecrease.isClickable = true
                binding.textViewQuantity.text = quantity.toString()
                binding.textViewFoodPriceDetail.text = (quantity * food.foodPrice).toString() + " ₺"
            } else {
                Toast.makeText(
                    requireContext(),
                    "Adet sayısı 1'den küçük olamaz.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        return binding.root
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_food_detail, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        val tempViewModel: FoodDetailViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.basket_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_basket) {
            val action =
                FoodDetailFragmentDirections.actionFoodDetailFragmentToFoodBasketFragment()
            Navigation.findNavController(binding.root).navigate(action)
        }
        return super.onOptionsItemSelected(item)
    }

//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment FoodDetailFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            FoodDetailFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
}