package com.neobis.testproject.koin

import android.content.Context
import com.neobis.testproject.Constants
import com.neobis.testproject.app.fragments.ProductViewModel
import com.neobis.testproject.app.fragments.SavedViewModel
import com.neobis.testproject.data.retrofit.ProductAPI
import com.neobis.testproject.data.repository.MainRepository
import com.neobis.testproject.data.room.MyRoomDatabase
import com.neobis.testproject.data.room.ProductDao
import com.neobis.testproject.data.room.ProvideRoom
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.math.sin

val retrofitModule = module {

    single { getOkHttp() }
    single { getRetrofitInstance(okHttpClient = get()) }
    single { getProductApi(retrofit = get()) }
    factory { MainRepository(productAPI = get(), productDao = get()) }
    single { ProvideRoom(context = androidContext()) }
    single { getProductDao(database = get()) }

}

val viewModules = module {
    viewModel { ProductViewModel(repository = get()) }
    viewModel { SavedViewModel(repository = get()) }
}

fun getProductDao(database: ProvideRoom):ProductDao{
    return database.provide().productDao()
}

fun getOkHttp(): OkHttpClient {
    return OkHttpClient.Builder()
        .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .build()
}

fun getProductApi(retrofit: Retrofit): ProductAPI {
    return retrofit.create(ProductAPI::class.java)
}

fun getRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
}