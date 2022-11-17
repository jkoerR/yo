package com.example.droi_mvvm.ui

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.droi_mvvm.BaseFragment
import com.example.droi_mvvm.R
import com.example.droi_mvvm.databinding.FragmentFirstBinding
import com.example.droi_mvvm.model.GDTO
import com.example.droi_mvvm.viewmodel.MainViewModel
import com.google.gson.JsonObject

class FirstFragment : BaseFragment() {
    lateinit var binding: FragmentFirstBinding
    lateinit var firstAdapter: FirstAdapter

    //    var data = MutableLiveData<ArrayList<DTOS.recy>>()
    var data = MutableLiveData<ArrayList<GDTO.city>>()

    //    private val model: MainViewModel by viewModels()
    private lateinit var model: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)
//        return super.onCreateView(inflater, container, savedInstanceState)
        return binding.root
    }

    override fun _init() {
        model = ViewModelProvider(activity as FragmentActivity)[MainViewModel::class.java]
        initRecyclerView()
        model.call_assets()
        binding.etMain.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                if (s!=null &&s.length >2){
                    firstAdapter?.filter?.filter(s)
//                }else{
//                    firstAdapter?.filter?.filter(null)
//                }
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
    }

    private fun initRecyclerView() {
        var layout = LinearLayoutManager(activity)
        binding.rvFirst.layoutManager = layout
        val adapterobsever: Observer<ArrayList<GDTO.city>> =
            Observer {
                data.value = it
                firstAdapter = FirstAdapter(this, data)
                binding.rvFirst.adapter = firstAdapter
            }
        model.liveData.observe(this, adapterobsever)
    }

    override fun onclic(v: View, position: Int) {
//        Log.e("onclic", "${v.id}  :  ${position}")
        when (v.id) {
            R.id.tv_todo -> {
                model.moveDetail(position)
            }
        }
    }

    override fun onClick(v: View) {
        super.onClick(v)
        var cPosition: Int?
        var cIntent: Intent?
        when (v.id) {
//            R.id.btn_modi -> {
//
//            }
            else -> {

            }
        }
    }

    override fun jk_result(result: JsonObject?, from: String?) {
        super.jk_result(result, from)
//        val code = result!!["rst_cd"].asString
//        when (code) {
//            else -> {
//
//            }
//        }
    }
}