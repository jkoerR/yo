package com.example.droi_mvvm.view

import android.app.Activity
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.droi_mvvm.R
import com.example.droi_mvvm.callback.OnItemClick
import com.example.droi_mvvm.databinding.ItemRecruitBinding
import com.example.droi_mvvm.model.DC_JOB
import com.example.droi_mvvm.util.DiffCallback
import com.example.droi_mvvm.util.Logger
import com.example.droi_mvvm.util.Util
import java.util.*

class FirstAdapter_recruit(
    private val listener: OnItemClick,
    val activity: Activity?
) : RecyclerView.Adapter<FirstAdapter_recruit.TodoViewHolder>(), Filterable {
    val data: ArrayList<DC_JOB.Recruit_items> = ArrayList()
    val arr: ArrayList<DC_JOB.Recruit_items> = ArrayList()

    //    init {
//        data.addAll(files.value!!)
//    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemRecruitBinding.inflate(layoutInflater, parent, false) //TODO match_parent 작동 안할때
        return TodoViewHolder(binding)
    }

    fun diff(arr: ArrayList<DC_JOB.Recruit_items>, str: String) {
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

    private fun setNewTiles(newTiles: MutableList<DC_JOB.Recruit_items>) {
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


    inner class TodoViewHolder(private val binding: ItemRecruitBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DC_JOB.Recruit_items) {
            binding.item = item
//            binding.tvTodo.setOnClickListener {
//                listener.onclic(it, adapterPosition)
//            }
            if (activity != null) {
                Glide.with(activity).load(item.image_url).centerCrop().into(binding.ivItemRecruit)
                binding.rlItemRecruit.setBackgroundResource(R.drawable.shape_tran_ra8)
                binding.rlItemRecruit.clipToOutline = true
            }
            var high = 0f
            for (rating in item.company.ratings){
                if (rating.rating > high)high = rating.rating
            }
            binding.tvRating.text = "$high"
            val slp = item.appeal.split(",")
//            Logger.loge("${slp}")
            val inflater = activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            for ((i,str) in slp.withIndex()) {
                if (i<2 && str!="") {
                    binding.llAppeal.addView(inflater.inflate(R.layout.item_infl, binding.llAppeal, false))
                    val tv_apper = binding.llAppeal.getChildAt(i).findViewById<View>(R.id.tv_apper) as TextView
                    tv_apper.text = str
                }
            }
            val won = Util.myFormatter(item.reward)
            binding.tvReward.text = won
//            binding.tvType.text = item.tierRank.name
//            binding.tvWinLose.text = "${item.wins}승 ${item.losses}패"

        }
    }

    override fun getFilter(): Filter? {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence): FilterResults {
                val charString = constraint.toString()
                arr.clear()
                if (charString.length < 2) {
//                    Logger.loge("performFiltering    ${data}")
                    arr.addAll(data)
                } else {
                    val filteredList = ArrayList<DC_JOB.Recruit_items>()
                    for (dto in data) {
                        if (dto.title.lowercase(Locale.getDefault()).contains(charString.lowercase(Locale.getDefault()))) {
                            filteredList.add(dto);
                            continue
                        }
                        if (dto.company.name.lowercase(Locale.getDefault()).contains(charString.lowercase(Locale.getDefault()))) {
                            filteredList.add(dto);
                        }
                    }
                    arr.addAll(filteredList)
                }
                val filterResults = FilterResults()
                filterResults.values = arr
                return filterResults
            }

            override fun publishResults(constraint: CharSequence, results: FilterResults) {
                Logger.loge("${results.values}")
                notifyDataSetChanged()
            }
        }
    }

}