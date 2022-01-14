package com.neobis.testproject.app.fragments

import androidx.lifecycle.*
import com.neobis.testproject.data.model.Product
import com.neobis.testproject.data.model.ProductItem
import com.neobis.testproject.data.repository.MainRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductViewModel(private val repository: MainRepository) : ViewModel(), DefaultLifecycleObserver {

    val productLiveData = MutableLiveData<ArrayList<ProductItem>>()

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        getAllProduct()
    }

    fun getAllProduct(){
        viewModelScope.launch {
            val response = repository.getAllProduct()
            if (response.isSuccessful){
                productLiveData.postValue(response.body())
            }
        }
    }
}