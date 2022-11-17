package com.example.droi_mvvm.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import com.example.droi_mvvm.*
import com.example.droi_mvvm.databinding.ActivityMainBinding
import com.example.droi_mvvm.viewmodel.MainViewModel


class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private val model: MainViewModel by viewModels()
////    private lateinit var model: MainViewModel
//    private lateinit var adapter: TodoAdapter
//    var data = MutableLiveData<ArrayList<DTOS.recy>>()


    var fragmentManager: FragmentManager? = null
    var firstFragment: FirstFragment? = null
//    var secondFragment: SecondFragment? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
    }

    override fun _init() {
        initTap()
    }
    override fun onClick(v: View) {
        when (v.id) {
//            R.id.fab_minus -> {
//                model.decrease()
//            }
        }
    }
    private fun initTap(){
        fragmentManager = supportFragmentManager
        if (firstFragment == null) {
            firstFragment = FirstFragment()
            fragmentManager!!.beginTransaction().add(R.id.fl_main, firstFragment!!)
                .commitAllowingStateLoss()
        }
    }
    override fun onclic(v: View, position: Int) {
//        Log.e("onclic",  "${v.id}  :  ${position}")
        when(v.id){
//            R.id.tv_todo ->{
//                model.modi(position)
////                adapter.notifyDataSetChanged()
//            }
        }
    }


}