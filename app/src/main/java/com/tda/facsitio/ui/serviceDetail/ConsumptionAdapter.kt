package com.tda.facsitio.ui.serviceDetail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tda.facsitio.R
import com.tda.facsitio.data.model.DhtMedidoresLecturas
import kotlinx.android.synthetic.main.row_consumption.view.*

class ConsumptionAdapter(val context: Context) : RecyclerView.Adapter<ConsumptionAdapter.ConsumptionViewHolder>() {

    private var dataList = emptyList<DhtMedidoresLecturas>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConsumptionViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_consumption,parent,false)
        return ConsumptionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ConsumptionViewHolder, position: Int) {
        val medLect = dataList[position]
        holder.bindView(medLect)
    }

    inner class ConsumptionViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bindView(medLect:DhtMedidoresLecturas){
            itemView.tvTipoCsmo.text = medLect.tiConsumo
        }
    }
}