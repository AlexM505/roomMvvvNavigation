package com.tda.facsitio.ui.actions

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.tda.facsitio.R
import com.tda.facsitio.data.model.DhtItinTrabajoServicio
import com.tda.facsitio.data.model.DhtItinTrabajoServicioAccion
import com.tda.facsitio.ui.services.ServicesFragmentDirections
import kotlinx.android.synthetic.main.row_action.view.*

class ActionsAdapter (val context: Context) : RecyclerView.Adapter<ActionsAdapter.ActionsViewHolder>() {

    private var dataList = emptyList<DhtItinTrabajoServicioAccion>()
    private lateinit var currentService : DhtItinTrabajoServicio

    fun setListActionData(data : List<DhtItinTrabajoServicioAccion>, service : DhtItinTrabajoServicio){
        dataList = data
        currentService = service
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

            itemView.cvAccionRow.setOnClickListener {
                when(action.tiTrabajoAccion){
                    "LECTU" ->{
                        val actionDirection = ActionsFragmentDirections.actionActionsFragmentToDetailScreen(currentService)
                        itemView.cvAccionRow.findNavController().navigate(actionDirection)
                    }
                    "CARTA" ->{
                        Toast.makeText(context, "Viajar a vista carta", Toast.LENGTH_SHORT).show()
                    }
                    "COBRO" ->{
                        Toast.makeText(context, "Viajar a vista cobro", Toast.LENGTH_SHORT).show()
                    }
                    "IMPFA" ->{
                        Toast.makeText(context, "Viajar a vista impresion factura", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}