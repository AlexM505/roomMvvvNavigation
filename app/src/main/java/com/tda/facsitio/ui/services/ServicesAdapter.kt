package com.tda.facsitio.ui.services

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.tda.facsitio.data.model.DhtItinTrabajoServicio
import com.tda.facsitio.databinding.RowServiceBinding
import com.tda.facsitio.utils.DhtItinTrabajoServciosDiffUtil

class ServicesAdapter : RecyclerView.Adapter<ServicesAdapter.MyViewHolder>(){

    var dataList = emptyList<DhtItinTrabajoServicio>()

    class MyViewHolder(private val binding: RowServiceBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(data: DhtItinTrabajoServicio){
            binding.serviceData = data
            binding.executePendingBindings()
        }

        companion object{
            fun from(parent: ViewGroup):MyViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RowServiceBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return ServicesAdapter.MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = dataList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setData(dhtItinTrabajoServicioList: List<DhtItinTrabajoServicio>){
        val dhtItinTrabajoServicioDiffUtil = DhtItinTrabajoServciosDiffUtil(dataList, dhtItinTrabajoServicioList)
        val dhtItinTrabajoServicioDiffResult = DiffUtil.calculateDiff(dhtItinTrabajoServicioDiffUtil)
        this.dataList = dhtItinTrabajoServicioList
        dhtItinTrabajoServicioDiffResult.dispatchUpdatesTo(this)
    }

}