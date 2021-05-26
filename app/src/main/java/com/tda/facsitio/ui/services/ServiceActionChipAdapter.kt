package com.tda.facsitio.ui.services

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tda.facsitio.R
import com.tda.facsitio.data.model.DhtItinTrabajoServicioAccion
import kotlinx.android.synthetic.main.row_chip_action.view.*

class ServiceActionChipAdapter(val context: Context) : RecyclerView.Adapter<ServiceActionChipAdapter.ServiceActionChipViewHolder>() {

    private var dataList = emptyList<DhtItinTrabajoServicioAccion>()

    fun setListActionData(data : List<DhtItinTrabajoServicioAccion>){
        dataList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceActionChipViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_chip_action,parent,false)
        return ServiceActionChipViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ServiceActionChipViewHolder, position: Int) {
        val action = dataList[position]
        holder.bindView(action)
    }

    inner class ServiceActionChipViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bindView(action: DhtItinTrabajoServicioAccion){
            itemView.tvAccionRow.text = action.tiTrabajoAccion
        }
    }
}