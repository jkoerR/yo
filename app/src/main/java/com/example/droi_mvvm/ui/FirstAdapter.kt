package com.example.droi_mvvm.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.droi_mvvm.callback.OnItemClick
import com.example.droi_mvvm.databinding.ItemFirstBinding
import com.example.droi_mvvm.model.GDTO
import com.example.droi_mvvm.util.Logger
import com.example.droi_mvvm.viewmodel.MainViewModel

class FirstAdapter(
    private val listener: OnItemClick,
    val files: MutableLiveData<ArrayList<GDTO.city>>,
) : RecyclerView.Adapter<FirstAdapter.TodoViewHolder>(), Filterable {
    val data : ArrayList<GDTO.city>  = ArrayList()
    init {
        data.addAll(files.value!!)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemFirstBinding.inflate(layoutInflater)
        return TodoViewHolder(binding)
    }
    override fun getItemCount(): Int {
        return files.value!!.size
    }
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
//        Logger.loge("${files.value!![position]}")
        files.value!![position].let {
            holder.bind(it);
        }
//        holder.bind(items[position])
    }

    inner class TodoViewHolder(private val binding: ItemFirstBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GDTO.city) {
            binding.tvTodo.tag = adapterPosition
            binding.tvTodo.text = "${item.country}   :   ${item.name}"
            binding.tvTodo.setOnClickListener {
                listener.onclic(it, adapterPosition)
            }
        }
    }

    override fun getFilter(): Filter? {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence): FilterResults {
                val charString = constraint.toString()
                if (charString.length < 2) {
                    files.postValue(data)
                } else {
                    val filteredList = ArrayList<GDTO.city>()
                    for (name in files.value!!) {
                        if (name.name.contains(charString)) {
//                                Logger.loge("$charString  :   ${name}")
                            filteredList.add(name);
                        }
                    }
                    files.postValue(filteredList)
                }
                val filterResults = FilterResults()
                filterResults.values = files.value
                return filterResults
            }

            override fun publishResults(constraint: CharSequence, results: FilterResults) {
                Logger.loge("${results.values}")
                files.postValue(results.values as ArrayList<GDTO.city>?)
                notifyDataSetChanged()
            }
        }
    }

}