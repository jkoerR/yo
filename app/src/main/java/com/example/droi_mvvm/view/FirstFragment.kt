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
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.droi_mvvm.BaseFragment
import com.example.droi_mvvm.R
import com.example.droi_mvvm.databinding.FragmentFirstBinding
import com.example.droi_mvvm.model.DC_OP
import com.example.droi_mvvm.ui.CustomRecyclerDecoration_Ho
import com.example.droi_mvvm.ui.CustomRecyclerDecoration_Ve
import com.example.droi_mvvm.util.Logger
import com.example.droi_mvvm.viewmodel.MainViewModel
import com.facebook.shimmer.ShimmerFrameLayout


class FirstFragment : BaseFragment() {
    lateinit var binding: FragmentFirstBinding
    lateinit var firstAdapter: FirstAdapter
    lateinit var firstAdapter_ver: FirstAdapter_ver
    var id = "Genetory"
    var lastMatch :Long = 0

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
        binding.rlProfileRef.setOnClickListener(this)

        setObseve()
        initRecyclerView()
        startShimmer(binding.sfTop)
        model.requsetSummoner(id)

    }

    fun setObseve() {
        model.liveData_summoner.observe(this) {
//            Logger.loge("it.profileImageUrl  : ${it.profileImageUrl}")
            Glide.with(requireActivity()).load(it.profileImageUrl).circleCrop().into(binding.ivProfileImg)
            binding.tvProfileId.text = it.name
            binding.tvProfileLevel.text = it.level
            stopShimmer(binding.sfTop)
            startShimmer(binding.sfBot)
            lastMatch = 0
            model.requsetmatches(id,lastMatch)
        }

        model.liveData_matches.observe(this) {
            stopShimmer(binding.sfBot)
//            Logger.loge("${it.summary}")
            binding.tv20winLose.text = "${it.summary.wins}승 ${it.summary.losses}패"
            binding.tvKill.text = "${it.summary.kills}"
            binding.tvDeath.text = "${it.summary.deaths}"
            binding.tvAssi.text = "${it.summary.assists}"
            val kda = String.format("%.2f", (it.summary.kills + it.summary.assists) / it.summary.deaths)
            binding.tvKda.text = "${kda}:1"
            val per: Double = it.summary.wins.toDouble().div(20)
            binding.tvPer.text = "(${(per * 100).toInt()}%)"

            val arr: ArrayList<DC_OP.champions> = model.calcMost(it.champions)
            if (arr.size >= 2) {
                Glide.with(requireActivity()).load(arr[0].imageUrl).circleCrop().into(binding.ivMost1)
                Glide.with(requireActivity()).load(arr[1].imageUrl).circleCrop().into(binding.ivMost2)
                var m1 = ((arr[0].wins.toDouble() / arr[0].games.toDouble()) * 100).toInt()
                if (m1 == 100) {
                    binding.tvMost1.setTextColor(requireActivity().getColor(R.color.darkish_pink))
                } else {
                    binding.tvMost1.setTextColor(requireActivity().getColor(R.color.dark_grey))
                }
                binding.tvMost1.text = "${m1}%"
                var m2 = ((arr[1].wins.toDouble() / arr[1].games.toDouble()) * 100).toInt()
                if (m2 == 100) {
                    binding.tvMost2.setTextColor(requireActivity().getColor(R.color.darkish_pink))
                } else {
                    binding.tvMost2.setTextColor(requireActivity().getColor(R.color.dark_grey))
                }
                binding.tvMost2.text = "${m2}%"
            } else if (arr.size >= 1) {
                Glide.with(requireActivity()).load(arr[0].imageUrl).circleCrop().into(binding.ivMost1)
                var m1 = ((arr[0].wins.toDouble() / arr[0].games.toDouble()) * 100).toInt()
                if (m1 == 100) {
                    binding.tvMost1.setTextColor(requireActivity().getColor(R.color.darkish_pink))
                } else {
                    binding.tvMost1.setTextColor(requireActivity().getColor(R.color.dark_grey))
                }
                binding.tvMost1.text = "${m1}%"
            }

            val position = model.calcPosition(it.positions)
            val posiper = model.calcPosiper(it.positions)
            binding.tvPositionName.text = position
            binding.tvPositionPer.text = posiper

            model.liveData_games.postValue(it.games)

        }
    }

    private fun initRecyclerView() {

        binding.rvHo.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        firstAdapter = FirstAdapter(this, requireActivity())
        binding.rvHo.adapter = firstAdapter
        val adapterobsever: Observer<DC_OP.summoner> =
            Observer {
//                Logger.loge("it  :  ${it}")
                firstAdapter.diff(it.leagues, "")
                stopShimmer(binding.sfBot)
            }
        model.liveData_summoner.observe(this, adapterobsever)
        binding.rvHo.addItemDecoration(CustomRecyclerDecoration_Ho(8))


        binding.rvVer.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        firstAdapter_ver = FirstAdapter_ver(this, requireActivity())
        binding.rvVer.adapter = firstAdapter_ver
        val adapterobsever_ver: Observer<ArrayList<DC_OP.games>> =
            Observer {
                firstAdapter_ver.diff(it, "")
            }
        model.liveData_games.observe(this, adapterobsever_ver)
        binding.rvVer.addItemDecoration(CustomRecyclerDecoration_Ve(4))

        binding.rvVer.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (!binding.rvVer.canScrollVertically(-1)) {
//                    Log.i(TAG, "Top of list")
                } else if (!binding.rvVer.canScrollVertically(1)) {
                    Logger.loge("End of list")
                    lastMatch = model.liveData_matches.value?.games?.get(model.liveData_matches.value?.games!!.size-1)?.createDate!!
                    model.requsetmatches(id,lastMatch)

                } else {
//                    Log.i(TAG, "idle")
                }
            }
        })

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
            R.id.rl_profile_ref -> {
                model.requsetSummoner("Genetory")
            }
            else -> {

            }
        }
    }
}