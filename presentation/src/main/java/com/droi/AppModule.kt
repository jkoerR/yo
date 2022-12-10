package com.droi

import com.droi.retrofit.ApiInterfaceImpl
import com.droi.retrofit.RetrofitService
import com.droi.view.FirstFragment
import com.droi.viewmodel.MainViewModel
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