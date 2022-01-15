package com.neobis.testproject.app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.neobis.testproject.R
import com.neobis.testproject.app.adapter.RecyclerAdapter
import com.neobis.testproject.app.utils.RecyclerItemListener
import com.neobis.testproject.data.model.ProductItem
import com.neobis.testproject.databinding.FragmentProductBinding
import org.koin.android.viewmodel.ext.android.viewModel


class ProductFragment : Fragment(),RecyclerItemListener {

    private var _binding: FragmentProductBinding? = null
    private val binding
        get() = _binding!!
    private val productViewModel by viewModel<ProductViewModel>()
    private val recyclerAdapter by lazy {RecyclerAdapter(this)}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycle.addObserver(productViewModel)
        setUpRecycler()
        binding.actionButton.setOnClickListener {
            findNavController().navigate(ProductFragmentDirections.actionProductFragmentToSavedFragment())
        }
        productViewModel.productLiveData.observe(viewLifecycleOwner) {
            recyclerAdapter.setList(it.toList())

        }
    }

    private fun setUpRecycler() {
        binding.productRecycler.apply {
            adapter = recyclerAdapter
        }
    }

    override fun itemViewClicker(model: ProductItem) {
        productViewModel.insertData(model)
        Toast.makeText(requireContext(), "Saved", Toast.LENGTH_SHORT).show()
    }
}