//package com.example.droi_mvvm.view
//
//import android.app.Activity
//import android.os.Handler
//import android.os.Looper
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import android.widget.Filter
//import android.widget.Filterable
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
//import com.example.droi_mvvm.callback.OnItemClick
//import com.example.droi_mvvm.databinding.ItemFirstBinding
//import com.example.droi_mvvm.model.DC_JOB
//import com.example.droi_mvvm.util.DiffCallback
//
//class FirstAdapter(
//    private val listener: OnItemClick,
//    val activity: Activity?
//) : RecyclerView.Adapter<FirstAdapter.TodoViewHolder>(), Filterable {
//    val data : ArrayList<DC_JOB.leagues>  = ArrayList()
//    val arr : ArrayList<DC_JOB.leagues>  = ArrayList()
////    init {
////        data.addAll(files.value!!)
////    }
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
//        val layoutInflater = LayoutInflater.from(parent.context)
//        val binding = ItemFirstBinding.inflate(layoutInflater, parent, false) //TODO match_parent 작동 안할때
//        return TodoViewHolder(binding)
//    }
//
//    fun diff(arr: ArrayList<DC_JOB.leagues>, str: String) {
//        val tileDiffUtilCallback = DiffCallback(this.arr, arr)
//        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(tileDiffUtilCallback)
//        diffResult.dispatchUpdatesTo(this)
//        setNewTiles(arr)
//        val handler = Handler(Looper.getMainLooper())
//        if (str != "") {
//            handler.postDelayed({
//                filter?.filter(str)
//            }, 500)
//        }
//        notifyDataSetChanged()
//    }
//
//    private fun setNewTiles(newTiles: MutableList<DC_JOB.leagues>) {
//        this.arr.run {
//            clear()
//            addAll(newTiles)
//        }
//        this.data.run {
//            clear()
//            addAll(newTiles)
//        }
//    }
//
//
//    override fun getItemCount(): Int {
//        return arr.size
//    }
//    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
////        Logger.loge("${files.value!![position]}")
//        arr[position].let {
//            holder.bind(it);
//        }
////        holder.bind(items[position])
//    }
//
//    inner class TodoViewHolder(private val binding: ItemFirstBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//        fun bind(item: DC_JOB.leagues) {
////            binding.tvTodo.setOnClickListener {
////                listener.onclic(it, adapterPosition)
////            }
//            if (activity != null) {
//                Glide.with(activity).load(item.tierRank.imageUrl).into(binding.ivTier)
//            }
//            binding.tvType.text = item.tierRank.name
//            binding.tvWinLose.text = "${item.wins}승 ${item.losses}패"
//
//        }
//    }
//
//    override fun getFilter(): Filter? {
//        return object : Filter() {
//            override fun performFiltering(constraint: CharSequence): FilterResults {
//                val charString = constraint.toString()
//                arr!!.clear()
//                if (charString.length < 2) {
////                    Logger.loge("performFiltering    ${data}")
//                    arr?.addAll(data)
//                } else {
//                    val filteredList = ArrayList<DC_JOB.leagues>()
//                    for (dto in data!!) {
////                        if (dto.buyAdvertisingStatus != "") {
////                            if (dto.buyAdvertisingStatus?.contains(charString) == true) {
////                                filteredList.add(dto);
////                            }
////                        } else {
////                            if (dto.buyAdvertisingStatusName?.contains(charString) == true) {
////                                filteredList.add(dto);
////                            }
////                        }
//                    }
//                    arr!!.addAll(filteredList)
//                }
//                val filterResults = FilterResults()
//                filterResults.values = arr
//                return filterResults
//            }
//
//            override fun publishResults(constraint: CharSequence, results: FilterResults) {
////                Logger.loge("${results.values}")
//                notifyDataSetChanged()
//            }
//        }
//    }
//
//}