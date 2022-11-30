package com.example.droi_mvvm.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.droi_mvvm.BaseFragment
import com.example.droi_mvvm.R
import com.example.droi_mvvm.databinding.FragmentFirstBinding
import com.example.droi_mvvm.util.Logger
import com.example.droi_mvvm.viewmodel.MainViewModel
import com.facebook.shimmer.ShimmerFrameLayout


class FirstFragment : BaseFragment() {
    lateinit var binding: FragmentFirstBinding

    lateinit var firstAdapter: FirstAdapter_recruit
    lateinit var firstAdapter_ver: FirstAdapter_cell
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
        binding.rlProfileRef.setOnClickListener(this)

        setObseve()
        initRecyclerView()
        startShimmer(binding.sfTop)
        model.requsetRecruit()
        model.requsetCell()
    }

    fun setObseve() {
        model.liveData_ResRecruit.observe(this) {
            Logger.loge("liveData_ResRecruit  : ${it}")
//            Logger.loge("it.profileImageUrl  : ${it.profileImageUrl}")
//            Glide.with(requireActivity()).load(it.profileImageUrl).circleCrop().into(binding.ivProfileImg)
//            binding.tvProfileId.text = it.name
//            binding.tvProfileLevel.text = it.level
//            stopShimmer(binding.sfTop)
//            startShimmer(binding.sfBot)
//            lastMatch = 0
//            model.requsetmatches(id,lastMatch)
        }

        model.liveData_ResCell.observe(this) {
            Logger.loge("liveData_ResCell  : ${it}")
        }

    }

    private fun initRecyclerView() {

        binding.rvHo.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
//        firstAdapter = FirstAdapter(this, requireActivity())
//        binding.rvHo.adapter = firstAdapter
//        val adapterobsever: Observer<DC_JOB.summoner> =
//            Observer {
////                Logger.loge("it  :  ${it}")
//                firstAdapter.diff(it.leagues, "")
//                stopShimmer(binding.sfBot)
//            }
//        model.liveData_summoner.observe(this, adapterobsever)
//        binding.rvHo.addItemDecoration(CustomRecyclerDecoration_Ho(8))
//
//
//        binding.rvVer.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
//        firstAdapter_ver = FirstAdapter_ver(this, requireActivity())
//        binding.rvVer.adapter = firstAdapter_ver
//        val adapterobsever_ver: Observer<ArrayList<DC_JOB.games>> =
//            Observer {
//                firstAdapter_ver.diff(it, "")
//            }
//        model.liveData_games.observe(this, adapterobsever_ver)
//        binding.rvVer.addItemDecoration(CustomRecyclerDecoration_Ve(4))
//
//        binding.rvVer.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//                if (!binding.rvVer.canScrollVertically(-1)) {
////                    Log.i(TAG, "Top of list")
//                } else if (!binding.rvVer.canScrollVertically(1)) {
//                    Logger.loge("End of list")
//                    lastMatch = model.liveData_matches.value?.games?.get(model.liveData_matches.value?.games!!.size-1)?.createDate!!
//                    model.requsetmatches(id,lastMatch)
//
//                } else {
////                    Log.i(TAG, "idle")
//                }
//            }
//        })

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
            R.id.rl_profile_ref -> {
//                model.requsetSummoner("Genetory")
            }
            else -> {

            }
        }
    }
}