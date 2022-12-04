package com.example.droi_mvvm

import com.example.droi_mvvm.retrofit.ApiInterfaceImpl
import com.example.droi_mvvm.retrofit.RetrofitService
import com.example.droi_mvvm.view.FirstFragment
import com.example.droi_mvvm.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // single instance of HelloRepository
    /* single : 싱글톤 빈 정의를 제공. 즉 1번만 객체를 생성한다 */
    single<RetrofitService>() { ApiInterfaceImpl() }

    // Simple Presenter Factory
    /* factory : 호출될 때마다 객체 생성 */
//    factory { ApiViewModel(get()) }
//  factory {MainViewModel(get(),get())}
    single {MainViewModel(get(),get())}
    factory { FirstFragment() }
}