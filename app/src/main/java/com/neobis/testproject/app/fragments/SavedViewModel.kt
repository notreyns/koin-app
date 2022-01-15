package com.neobis.testproject.app.fragments

import androidx.lifecycle.*
import com.neobis.testproject.data.model.ProductItem
import com.neobis.testproject.data.repository.MainRepository
import kotlinx.coroutines.launch

class SavedViewModel(private val repository: MainRepository) : ViewModel(),DefaultLifecycleObserver {

    lateinit var productList:LiveData<List<ProductItem>>

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        viewModelScope.launch {
            productList = repository.getAllProductFromRoom().asLiveData()
        }
    }
}