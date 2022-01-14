package com.neobis.testproject.app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.neobis.testproject.R
import com.neobis.testproject.app.adapter.RecyclerAdapter
import com.neobis.testproject.databinding.FragmentProductBinding
import org.koin.android.viewmodel.ext.android.viewModel


class ProductFragment : Fragment() {

    private var _binding: FragmentProductBinding? = null
    private val binding
        get() = _binding!!
    private val productViewModel by viewModel<ProductViewModel>()
    private val recyclerAdapter by lazy {RecyclerAdapter()}

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
        productViewModel.productLiveData.observe(viewLifecycleOwner) {
            recyclerAdapter.setList(it.toList())
        }


    }

    private fun setUpRecycler() {
        binding.productRecycler.apply {
            adapter = recyclerAdapter
        }
    }
}