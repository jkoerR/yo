package com.example.droi_mvvm.view

import android.app.Activity
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.droi_mvvm.R
import com.example.droi_mvvm.callback.OnItemClick
import com.example.droi_mvvm.databinding.ItemFirstVerBinding
import com.example.droi_mvvm.model.DC_OP
import com.example.droi_mvvm.util.DiffCallback
import com.example.droi_mvvm.util.Logger
import com.example.droi_mvvm.util.Util
import java.util.*
import kotlin.collections.ArrayList

class FirstAdapter_ver(
    private val listener: OnItemClick,
    val activity: Activity?
) : RecyclerView.Adapter<FirstAdapter_ver.TodoViewHolder>(), Filterable {
    val data : ArrayList<DC_OP.games>  = ArrayList()
    val arr : ArrayList<DC_OP.games>  = ArrayList()
//    init {
//        data.addAll(files.value!!)
//    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemFirstVerBinding.inflate(layoutInflater)
        return TodoViewHolder(binding)
    }

    fun diff(arr: ArrayList<DC_OP.games>, str: String) {
        val tileDiffUtilCallback = DiffCallback(this.arr, arr)
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(tileDiffUtilCallback)
        diffResult.dispatchUpdatesTo(this)
        setNewTiles(arr)
        val handler = Handler(Looper.getMainLooper())
        if (str != "") {
            handler.postDelayed({
                filter?.filter(str)
            }, 500)
        }
        notifyDataSetChanged()
    }

    private fun setNewTiles(newTiles: MutableList<DC_OP.games>) {
        this.arr.run {
            clear()
            addAll(newTiles)
        }
        this.data.run {
            clear()
            addAll(newTiles)
        }
    }


    override fun getItemCount(): Int {
        return arr.size
    }
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
//        Logger.loge("${files.value!![position]}")
        arr[position].let {
            holder.bind(it);
        }
//        holder.bind(items[position])
    }

    inner class TodoViewHolder(private val binding: ItemFirstVerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DC_OP.games) {
            Logger.loge("item   :  ${item}")
            if (activity != null) {
                Glide.with(activity).load(item.champion.imageUrl).circleCrop().into(binding.ivItemVerChamp)
                Glide.with(activity).load(item.spells[0].imageUrl).into(binding.ivItemVerSpell1)
                Glide.with(activity).load(item.spells[1].imageUrl).into(binding.ivItemVerSpell2)

                try {
                    Glide.with(activity).load(item.items[0].imageUrl).into(binding.ivItemVerItem1)
                    Glide.with(activity).load(item.items[1].imageUrl).into(binding.ivItemVerItem2)
                    Glide.with(activity).load(item.items[2].imageUrl).into(binding.ivItemVerItem3)
                    Glide.with(activity).load(item.items[3].imageUrl).into(binding.ivItemVerItem4)
                    Glide.with(activity).load(item.items[4].imageUrl).into(binding.ivItemVerItem5)
                    Glide.with(activity).load(item.items[5].imageUrl).into(binding.ivItemVerItem6)
                }catch (e :java.lang.Exception){
                    e.printStackTrace()
                }
            }
            binding.tvType.text  = item.gameType
            binding.tvTime.text = formatTimeString(item.createDate)
            binding.tvItemVerGamelength.text = convertSecondsToHMmSs(item.gameLength)
            if (item.isWin){
                binding.llItemVerWltime.setBackgroundColor(activity?.getColor(R.color.soft_blue) ?: 0)
                binding.tvItemVerWltime.text = "승"
            }else{
                binding.llItemVerWltime.setBackgroundColor(activity?.getColor(R.color.darkish_pink) ?: 0)
                binding.tvItemVerWltime.text = "패"
            }

            binding.tvKill.text = "${item.stats.general.kill}"
            binding.tvDeath.text = "${item.stats.general.death}"
            binding.tvAssi.text = "${item.stats.general.assist}"

            if (item.stats.general.opScoreBadge !=""){
                binding.rlOpScoreBadge.visibility = View.VISIBLE
                binding.tvOpScoreBadge.text = item.stats.general.opScoreBadge
            }else{
                binding.rlOpScoreBadge.visibility = View.INVISIBLE
                binding.tvOpScoreBadge.text = ""
            }
            binding.tvPer.text = item.stats.general.contributionForKillRate

            if (item.stats.general.largestMultiKillString !=""){
                binding.rlItemVerContinuity.visibility = View.VISIBLE
                binding.tvItemVerContinuity.text = item.stats.general.largestMultiKillString
            }else{
                binding.rlItemVerContinuity.visibility = View.INVISIBLE
                binding.tvItemVerContinuity.text = ""
            }

        }
    }

    override fun getFilter(): Filter? {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence): FilterResults {
                val charString = constraint.toString()
                arr!!.clear()
                if (charString.length < 2) {
//                    Logger.loge("performFiltering    ${data}")
                    arr?.addAll(data)
                } else {
                    val filteredList = ArrayList<DC_OP.games>()
                    for (dto in data!!) {
//                        if (dto.buyAdvertisingStatus != "") {
//                            if (dto.buyAdvertisingStatus?.contains(charString) == true) {
//                                filteredList.add(dto);
//                            }
//                        } else {
//                            if (dto.buyAdvertisingStatusName?.contains(charString) == true) {
//                                filteredList.add(dto);
//                            }
//                        }
                    }
                    arr!!.addAll(filteredList)
                }
                val filterResults = FilterResults()
                filterResults.values = arr
                return filterResults
            }

            override fun publishResults(constraint: CharSequence, results: FilterResults) {
//                Logger.loge("${results.values}")
                notifyDataSetChanged()
            }
        }
    }


    private object TIME_MAXIMUM {
        const val SEC = 60
        const val MIN = 60
        const val HOUR = 24
        const val DAY = 30
        const val MONTH = 12
    }

    fun formatTimeString(regTime: Long): String? {
        val curTime = System.currentTimeMillis() /1000L
        Logger.loge("curTime  :  $curTime")
        Logger.loge("regTime  :  $regTime")
        var diffTime = (curTime - regTime) / 1000
        var msg: String? = null
        if (diffTime < TIME_MAXIMUM.SEC) {
            msg = "방금 전"
        } else if (TIME_MAXIMUM.SEC.let { diffTime /= it; diffTime } < TIME_MAXIMUM.MIN) {
            msg = diffTime.toString() + "분 전"
        } else if (TIME_MAXIMUM.MIN.let { diffTime /= it; diffTime } < TIME_MAXIMUM.HOUR) {
            msg = diffTime.toString() + "시간 전"
        } else if (TIME_MAXIMUM.HOUR.let { diffTime /= it; diffTime } < TIME_MAXIMUM.DAY) {
            msg = diffTime.toString() + "일 전"
        } else if (TIME_MAXIMUM.DAY.let { diffTime /= it; diffTime } < TIME_MAXIMUM.MONTH) {
            msg = diffTime.toString() + "달 전"
        } else {
            msg = diffTime.toString() + "년 전"
        }
        return msg
    }

    fun convertSecondsToHMmSs(second: Long): String {
//        val second = seconds / 1000
        val s = second % 60
        val m = second / 60 % 60
        val h = second / (60 * 60) % 24
        return if (h > 0) {
            String.format(Locale.US, "%02d:%02d:%02d", h, m, s)
        } else {
            if (m > 0) {
                String.format(Locale.US, "%02d:%02d", m, s)
            } else {
                String.format(Locale.US, "00:%02d", s)
            }
        }
    }

}