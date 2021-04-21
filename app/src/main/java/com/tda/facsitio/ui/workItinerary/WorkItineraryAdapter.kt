package com.tda.facsitio.ui.workItinerary

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.tda.facsitio.data.model.DhtItinTrabajo
import com.tda.facsitio.databinding.RowWorkItineraryBinding
import com.tda.facsitio.utils.DhtItinTrabajoDiffUtil

class WorkItineraryAdapter : RecyclerView.Adapter<WorkItineraryAdapter.MyViewHolder>(){

    var dataList = emptyList<DhtItinTrabajo>()

    class MyViewHolder(private val binding: RowWorkItineraryBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(data: DhtItinTrabajo){
            binding.itinTrabajoData = data
            binding.executePendingBindings()
        }

        companion object{
            fun from(parent: ViewGroup):MyViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RowWorkItineraryBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = dataList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setData(dhtItinTrabajoList: List<DhtItinTrabajo>){
        val dhtItinTrabajoDiffUtil = DhtItinTrabajoDiffUtil(dataList, dhtItinTrabajoList)
        val dhtItinTrabajoDiffResult = DiffUtil.calculateDiff(dhtItinTrabajoDiffUtil)
        this.dataList = dhtItinTrabajoList
        dhtItinTrabajoDiffResult.dispatchUpdatesTo(this)
    }

}