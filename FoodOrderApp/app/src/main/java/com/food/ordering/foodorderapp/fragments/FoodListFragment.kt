package com.food.ordering.foodorderapp.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.food.ordering.foodorderapp.R
import com.food.ordering.foodorderapp.adapter.foodadapter.FoodListAdapter
import com.food.ordering.foodorderapp.databinding.FragmentFoodListBinding
import com.food.ordering.foodorderapp.viewmodel.FoodListViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

class FoodListFragment : Fragment() {
    private lateinit var binding: FragmentFoodListBinding
    private lateinit var foodListAdapter: FoodListAdapter
    private lateinit var viewModel: FoodListViewModel
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_food_list, container, false)

        binding.foodListFragment = this
        binding.foodListToolbar = "Anasayfa"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarFoodList)

        viewModel.foodList.observe(viewLifecycleOwner, {
            foodListAdapter = FoodListAdapter()
            binding.foodListAdapter = foodListAdapter
            foodListAdapter.setData(it)
        })
        return binding.root
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_food_list, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        val tempViewModel: FoodListViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.basket_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_basket) {
            val action =
                FoodListFragmentDirections.actionFoodListFragmentToFoodBasketFragment()
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
//         * @return A new instance of fragment FoodListFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            FoodListFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
}