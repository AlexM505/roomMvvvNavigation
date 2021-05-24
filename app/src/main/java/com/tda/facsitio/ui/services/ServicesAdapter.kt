package com.tda.facsitio.ui.services

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tda.facsitio.data.model.DhtItinTrabajoServicio
import com.tda.facsitio.data.model.DhtItinTrabajoServicioAccion
import com.tda.facsitio.databinding.RowServiceBinding
import com.tda.facsitio.utils.DhtItinTrabajoServciosDiffUtil
import kotlinx.coroutines.*

class ServicesAdapter(servicesViewModel: ServicesViewModel) : RecyclerView.Adapter<ServicesAdapter.MyViewHolder>(){

    private val mServicesViewModel = servicesViewModel
    var dataList = emptyList<DhtItinTrabajoServicio>()

    class MyViewHolder(private val binding: RowServiceBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(data: DhtItinTrabajoServicio){
            binding.serviceData = data
            binding.executePendingBindings()
        }

        fun bindActions(listAction : List<DhtItinTrabajoServicioAccion>){
            val adapterAction = ServiceActionChipAdapter(binding.root.context)
            binding.rvServicioAcciones.layoutManager = LinearLayoutManager(binding.root.context, RecyclerView.HORIZONTAL, false)
            binding.rvServicioAcciones.adapter = adapterAction
            adapterAction.setListActionData(listAction)
            adapterAction.notifyDataSetChanged()
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

        GlobalScope.launch {
            //Background proccess (database)
            val listActionData = mServicesViewModel.obtenerAccionesByServicios(currentItem.ixItinerarioTrabajo, currentItem.idServicio)
            withContext(Dispatchers.Main){
                //Cambiamos al hilo principal para actualizar la UI
                holder.bindActions(listActionData)
            }
        }
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