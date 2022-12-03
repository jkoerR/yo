package com.example.droi_mvvm.view

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.droi_mvvm.BaseFragment
import com.example.droi_mvvm.R
import com.example.droi_mvvm.databinding.FragmentFirstBinding
import com.example.droi_mvvm.model.DC_JOB
import com.example.droi_mvvm.ui.CustomRecyclerDecoration_Ho
import com.example.droi_mvvm.ui.CustomRecyclerDecoration_Ve
import com.example.droi_mvvm.util.Logger
import com.example.droi_mvvm.viewmodel.MainViewModel
import com.facebook.shimmer.ShimmerFrameLayout
import org.koin.android.ext.android.inject


class FirstFragment : BaseFragment() {
    lateinit var binding: FragmentFirstBinding

    lateinit var firstAdapter_recruit: FirstAdapter_recruit
    lateinit var firstAdapter_cell: FirstAdapter_cell
//    private lateinit var model: MainViewModel
    private val model: MainViewModel by inject()

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
//        model = ViewModelProvider(activity as FragmentActivity)[MainViewModel::class.java]

        binding.rlEmployment.setOnClickListener(this)
        binding.rlEnterprise.setOnClickListener(this)


        binding.etJobplanet.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString().isNotEmpty()) {
//                    iv_fm_reportstore_find.visibility = View.VISIBLE
                    firstAdapter_recruit.filter?.filter("${p0.toString()}")
                    firstAdapter_cell.filter?.filter("${p0.toString()}")
                    if (firstAdapter_recruit.arr.size==0){
                        binding.tvRecruit.visibility = View.VISIBLE
                    }else{
                        binding.tvRecruit.visibility = View.GONE
                    }
//                    Logger.loge("firstAdapter_cell.arr.size  ${firstAdapter_cell.arr.size}")
                    if (firstAdapter_cell.arr.size==0){
                        binding.tvCell.visibility = View.VISIBLE
                    }else{
                        binding.tvCell.visibility = View.GONE
                    }
                } else {
//                    iv_fm_reportstore_find.visibility = View.GONE
                    firstAdapter_recruit.filter?.filter("")
                    binding.tvRecruit.visibility = View.GONE
                    firstAdapter_cell.filter?.filter("")
                    binding.tvCell.visibility = View.GONE
                }
            }
            override fun afterTextChanged(p0: Editable?) {
            }
        })
//        setObseve()
        initRecyclerView()
        startShimmer(binding.sfRecruit)
        model.requsetRecruit()
        model.requsetCell()
    }

//    fun setObseve() {
////        model.liveData_ResRecruit.observe(this) {
////            Logger.loge("liveData_ResRecruit  : ${it}")
//////            Logger.loge("it.profileImageUrl  : ${it.profileImageUrl}")
//////            Glide.with(requireActivity()).load(it.profileImageUrl).circleCrop().into(binding.ivProfileImg)
//////            binding.tvProfileId.text = it.name
//////            binding.tvProfileLevel.text = it.level
//////            stopShimmer(binding.sfTop)
//////            startShimmer(binding.sfBot)
//////            lastMatch = 0
//////            model.requsetmatches(id,lastMatch)
////        }
////        model.liveData_ResCell.observe(this) {
////            Logger.loge("liveData_ResCell  : ${it}")
////        }
//    }

    private fun initRecyclerView() {

//        binding.rvRecruit.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        binding.rvRecruit.layoutManager = GridLayoutManager(requireActivity(),2)
        firstAdapter_recruit = FirstAdapter_recruit(this, requireActivity())
        binding.rvRecruit.adapter = firstAdapter_recruit
        val adapterobseverRecruit: Observer<DC_JOB.ResRecruit> =
            Observer {
                firstAdapter_recruit.diff(it.recruit_items, "")
                stopShimmer(binding.sfRecruit)
            }
        model.liveData_ResRecruit.observe(this, adapterobseverRecruit)
        binding.rvRecruit.addItemDecoration(CustomRecyclerDecoration_Ho(12))
        binding.rvRecruit.addItemDecoration(CustomRecyclerDecoration_Ve(20))

        binding.rvCell.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        firstAdapter_cell = FirstAdapter_cell(this, requireActivity())
        binding.rvCell.adapter = firstAdapter_cell
        val adapterobseverCell: Observer<DC_JOB.ResCell> =
            Observer {
                firstAdapter_cell.diff(it.cell_items, "")
                stopShimmer(binding.sfCell)
            }
        model.liveData_ResCell.observe(this, adapterobseverCell)
//        binding.rvCell.addItemDecoration(CustomRecyclerDecoration_Ho(12))
//        binding.rvCell.addItemDecoration(CustomRecyclerDecoration_Ve(20))

    }

    fun startShimmer(view: ShimmerFrameLayout) {
        view.showShimmer(true)
        view.startShimmer()
    }

    fun stopShimmer(view: ShimmerFrameLayout) {
        view.stopShimmer()
        view.hideShimmer()
    }

    override fun oneClick(v: View, position: Int) {
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
            R.id.rl_employment -> {
                binding.rlEmployment.setBackgroundResource(R.drawable.shape_green_ra15)
                binding.rlEnterprise.setBackgroundResource(R.drawable.shape_ffffff_gray03_ra15)
                binding.tvEmployment.setTextColor(requireActivity().getColor(R.color.white))
                binding.tvEnterprise.setTextColor(requireActivity().getColor(R.color.cool_grey))
                binding.sfRecruit.visibility = View.VISIBLE
                binding.sfCell.visibility = View.GONE
            }
            R.id.rl_enterprise -> {
                binding.rlEmployment.setBackgroundResource(R.drawable.shape_ffffff_gray03_ra15)
                binding.rlEnterprise.setBackgroundResource(R.drawable.shape_green_ra15)
                binding.tvEmployment.setTextColor(requireActivity().getColor(R.color.cool_grey))
                binding.tvEnterprise.setTextColor(requireActivity().getColor(R.color.white))
                binding.sfRecruit.visibility = View.GONE
                binding.sfCell.visibility = View.VISIBLE
            }
            else -> {

            }
        }
    }
}