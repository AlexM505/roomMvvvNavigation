package com.tda.facsitio.ui.actions

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tda.facsitio.R
import com.tda.facsitio.data.model.DhtItinTrabajoServicioAccion
import kotlinx.android.synthetic.main.row_action.view.*

class ActionsAdapter (val context: Context) : RecyclerView.Adapter<ActionsAdapter.ActionsViewHolder>() {

    private var dataList = emptyList<DhtItinTrabajoServicioAccion>()

    fun setListActionData(data : List<DhtItinTrabajoServicioAccion>){
        dataList = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActionsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_action,parent,false)
        return ActionsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ActionsViewHolder, position: Int) {
        val action = dataList[position]
        holder.bindView(action)
    }

    inner class ActionsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bindView(action: DhtItinTrabajoServicioAccion){
            itemView.tvReferenciaAccion.text = action.referenciaAccion
            itemView.tvEsTrabajoAccion.text = action.esTrabajoAccion
        }
    }
}