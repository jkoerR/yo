package com.example.droi_mvvm.view

import android.app.Activity
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.droi_mvvm.R
import com.example.droi_mvvm.callback.OnItemClick
import com.example.droi_mvvm.databinding.ItemFirstBinding
import com.example.droi_mvvm.model.DC_yo
import com.example.droi_mvvm.util.DiffCallback
import java.util.*

class FirstAdapter(
    private val listener: OnItemClick,
    val activity: Activity?
) : RecyclerView.Adapter<FirstAdapter.TodoViewHolder>(), Filterable {
    val data: ArrayList<DC_yo.Items> = ArrayList()
    val arr: ArrayList<DC_yo.Items> = ArrayList()

    //    init {
//        data.addAll(files.value!!)
//    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemFirstBinding.inflate(layoutInflater, parent, false) //TODO match_parent 작동 안할때
        return TodoViewHolder(binding)
    }

    fun diff(arr: ArrayList<DC_yo.Items>, str: String, change: Int) {
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
        if (change == -1){
            notifyDataSetChanged()
        }else{
            notifyItemChanged(change)
        }
    }

    private fun setNewTiles(newTiles: MutableList<DC_yo.Items>) {
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


    inner class TodoViewHolder(private val binding: ItemFirstBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DC_yo.Items) {
            binding.item = item
            if (activity != null) {
                Glide.with(activity).load(item.avatar_url).centerCrop().into(binding.ivItemFirst)
            }

            if (item.like){
                binding.ivLike.setImageResource(R.drawable.circle)
            }else{
                binding.ivLike.setImageResource(R.drawable.circle_empty)
            }

            binding.clFirst.setOnClickListener { p0 ->
                listener.oneClick(p0, bindingAdapterPosition)
            }
            binding.ivLike.setOnClickListener { p0 ->
                listener.oneClick(p0, bindingAdapterPosition)
            }
        }
    }

    override fun getFilter(): Filter? {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence): FilterResults {
                val charString = constraint.toString()
                arr.clear()
                if (charString.length < 2) {
                    arr.addAll(data)
                } else {
                    val filteredList = ArrayList<DC_yo.Items>()
//                    for (dto in data) {
//                        if (dto.title.lowercase(Locale.getDefault()).contains(charString.lowercase(Locale.getDefault()))) {
//                            filteredList.add(dto);
//                            continue
//                        }
//                        if (dto.company.name.lowercase(Locale.getDefault()).contains(charString.lowercase(Locale.getDefault()))) {
//                            filteredList.add(dto);
//                        }
//                    }
                    arr.addAll(filteredList)
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

}