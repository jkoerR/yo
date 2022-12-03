package com.example.droi_mvvm.view

import android.app.Activity
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.droi_mvvm.Const
import com.example.droi_mvvm.R
import com.example.droi_mvvm.callback.OnItemClick
import com.example.droi_mvvm.databinding.ItemCellBinding
import com.example.droi_mvvm.databinding.ItemHoThemeBinding
import com.example.droi_mvvm.model.DC_JOB
import com.example.droi_mvvm.ui.CustomRecyclerDecoration_Ho
import com.example.droi_mvvm.ui.CustomRecyclerDecoration_Ve
import com.example.droi_mvvm.util.DiffCallback
import com.example.droi_mvvm.util.Logger
import com.example.droi_mvvm.util.Util
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class FirstAdapter_cell(
    private val listener: OnItemClick,
    val activity: Activity?
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), Filterable {
    val data: ArrayList<DC_JOB.Cell_items> = ArrayList()
    val arr: ArrayList<DC_JOB.Cell_items> = ArrayList()
    lateinit var firstAdapter_recruit: FirstAdapter_recruit

    //    init {
//        data.addAll(files.value!!)
//    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            0 -> {
                val binding = ItemCellBinding.inflate(layoutInflater, parent, false)
                TodoViewHolderCell(binding)
            }
            1 -> {
                val binding = ItemHoThemeBinding.inflate(layoutInflater, parent, false)
                TodoViewHolderHo(binding)
            }
            else -> {
                val binding = ItemCellBinding.inflate(layoutInflater, parent, false)
                TodoViewHolderCell(binding)
            }
        }
    }

    fun diff(arr: ArrayList<DC_JOB.Cell_items>, str: String) {
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

    private fun setNewTiles(newTiles: MutableList<DC_JOB.Cell_items>) {
        this.arr.run {
            clear()
            addAll(newTiles)
        }
        this.data.run {
            clear()
            addAll(newTiles)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (arr[position].cell_type) {
            Const.CELL_TYPE_COMPANY -> {
                0
            }
            Const.CELL_TYPE_HORIZONTAL_THEME -> {
                1
            }
            else -> {
                0
            }
        }
    }


    override fun getItemCount(): Int {
        return arr.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        Logger.loge("${files.value!![position]}")
//        when (arr[position].type) {
        when (getItemViewType(position)) {
            0 -> {
                arr[position].let {
                    (holder as TodoViewHolderCell).bind(it)
                }
            }
            1 -> {
                arr[position].let {
                    (holder as TodoViewHolderHo).bind(it)
                }
            }
        }
//        holder.bind(items[position])
    }

    inner class TodoViewHolderCell(private val binding: ItemCellBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DC_JOB.Cell_items) {
            binding.item = item
            if (activity != null) {
                Glide.with(activity).load(item.logo_path).placeholder(R.drawable.user).centerCrop().into(binding.ivItemCell)
                binding.rlItemCell.setBackgroundResource(R.drawable.shape_tran_ra4)
                binding.rlItemCell.clipToOutline = true
            }
            binding.tvDate.text = Util.getDateFormatTime(item.update_date)
        }
    }


    inner class TodoViewHolderHo(private val binding: ItemHoThemeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DC_JOB.Cell_items) {
            binding.rvItemHoTheme.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
//            binding.rvRecruit.layoutManager = GridLayoutManager(requireActivity(),2)
            firstAdapter_recruit = FirstAdapter_recruit(listener, activity)
            binding.rvItemHoTheme.adapter = firstAdapter_recruit
            firstAdapter_recruit.diff(item.recommend_recruit, "")
            binding.rvItemHoTheme.addItemDecoration(CustomRecyclerDecoration_Ho(12))
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
                    val filteredList = ArrayList<DC_JOB.Cell_items>()
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
        val curTime = System.currentTimeMillis() / 1000L
//        Logger.loge("curTime  :  $curTime")
//        Logger.loge("regTime  :  $regTime")
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