package com.food.ordering.foodorderapp.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.food.ordering.foodorderapp.R
import com.food.ordering.foodorderapp.adapter.foodbasketadapter.FoodBasketAdapter
import com.food.ordering.foodorderapp.databinding.FragmentFoodBasketBinding
import com.food.ordering.foodorderapp.viewmodel.FoodBasketViewModel
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

class FoodBasketFragment : Fragment() {
    private lateinit var binding: FragmentFoodBasketBinding
    private lateinit var viewModel: FoodBasketViewModel
    private val args: FoodBasketFragmentArgs by navArgs()
    private val foodBasketAdapter: FoodBasketAdapter by lazy {
        FoodBasketAdapter(
            requireContext(),
            viewModel,
            args
        )
    }
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
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_food_basket, container, false)

        binding.foodBasketFragment = this
        binding.foodBasketToolbar = "Sepetim"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarFoodBasket)

        setAdapter()

        viewModel.loadFoodsFromBasket("e_inan")

        getAllFoodsFromBasket()

        binding.buttonOrder.setOnClickListener {
            val action = FoodBasketFragmentDirections.actionFoodBasketFragmentToEndFragment()
            Navigation.findNavController(it).navigate(action)
        }

        return binding.root
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_food_basket, container, false)
    }

    private fun getAllFoodsFromBasket() {
        viewModel.foodBasketList.observe(viewLifecycleOwner, {
            foodBasketAdapter.setData(it)
        })
    }

    private fun setAdapter() {
        val recyclerView = binding.recyclerViewBasket
        recyclerView.adapter = foodBasketAdapter

        foodBasketAdapter.apply {
            onItemTrashClicked = { currentItem ->
                viewModel.deleteFoodFromBasket(currentItem.foodIdBasket, "e_inan")
                Snackbar.make(
                    binding.root,
                    "${currentItem.foodNameBasket} sepetten silindi.",
                    Snackbar.LENGTH_LONG
                ).setAction("TAMAM") {
                }.show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        val tempViewModel: FoodBasketViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_home) {
            val action =
                FoodBasketFragmentDirections.actionFoodBasketFragmentToFoodListFragment()
            Navigation.findNavController(binding.root).navigate(action)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadFoodsFromBasket("e_inan")
    }

//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment FoodBasketFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            FoodBasketFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
}