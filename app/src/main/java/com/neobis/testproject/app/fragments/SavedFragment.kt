package com.neobis.testproject.app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.neobis.testproject.app.adapter.RecyclerAdapter
import com.neobis.testproject.databinding.FragmentSavedBinding
import org.koin.android.viewmodel.ext.android.viewModel


class SavedFragment : Fragment() {

    private var _binding:FragmentSavedBinding? = null
    private val binding
    get() = _binding!!
    private val recyclerAdapter by lazy { RecyclerAdapter(null) }
    private val viewModel:SavedViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSavedBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecycler()
        lifecycle.addObserver(viewModel)
        viewModel.productList.observe(viewLifecycleOwner){
            recyclerAdapter.setList(it)
        }
    }

    private fun setUpRecycler() {
        binding.roomProductRecycler.apply {
            adapter = recyclerAdapter
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}