package com.example.droi_mvvm.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.droi_mvvm.BaseFragment
import com.example.droi_mvvm.R
import com.example.droi_mvvm.databinding.FragmentFirstBinding
import com.example.droi_mvvm.model.DC_OP
import com.example.droi_mvvm.ui.CustomRecyclerDecoration_Ho
import com.example.droi_mvvm.viewmodel.MainViewModel
import com.facebook.shimmer.ShimmerFrameLayout
import kotlinx.android.synthetic.main.fragment_first.*


class FirstFragment : BaseFragment() {
    lateinit var binding: FragmentFirstBinding
    lateinit var firstAdapter: FirstAdapter

    //    var data = MutableLiveData<ArrayList<DTOS.recy>>()
//    var data = MutableLiveData<ArrayList<DC_OP.summoner>>()

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
        model.requsetSummoner("genetory")

    }

    private fun initRecyclerView() {

        binding.rvSu.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        firstAdapter = FirstAdapter(this, requireActivity())
        binding.rvSu.adapter = firstAdapter

//        val adapterobsever: Observer<ArrayList<DC_OP.summoner>> =
//            Observer {
////                data.value = it
//                firstAdapter.diff(it, "")
//            }
//        model.liveData_summoner.observe(this, adapterobsever)
        binding.rvSu.addItemDecoration(CustomRecyclerDecoration_Ho(15))





    }

    fun startShimmer(view: ShimmerFrameLayout) {
        view.showShimmer(true)
        view.startShimmer()
    }

    fun stopShimmer(view: ShimmerFrameLayout) {
        view.stopShimmer()
        view.hideShimmer()
    }

    override fun onclic(v: View, position: Int) {
//        Log.e("onclic", "${v.id}  :  ${position}")
        when (v.id) {
//            R.id.tv_todo -> {
////                model.moveDetail(position)
//            }
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
}