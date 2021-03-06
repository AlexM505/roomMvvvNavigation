package com.tda.facsitio.ui.zhelp

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import com.tda.facsitio.data.model.DhtItinTrabajo
import com.tda.facsitio.data.model.DhtItinTrabajoServicio
import com.tda.facsitio.ui.services.ServicesFragmentDirections
import com.tda.facsitio.ui.workItinerary.WorkItineraryFragmentDirections

class BindingAdapters {

    companion object{

        @BindingAdapter("android:emptyDbItinerarios")
        @JvmStatic
        fun emptyDbItinerarios(view: View, emptyDb: MutableLiveData<Boolean>){
            when(emptyDb.value){
                true -> view.visibility = View.VISIBLE
                false -> view.visibility = View.INVISIBLE
            }
        }

        @BindingAdapter("android:convertIntAndSetText")
        @JvmStatic
        fun convertIntAndSetText(view: TextView, data: Int){
            view.text = data.toString()
        }

        @BindingAdapter("android:convertLongAndSetText")
        @JvmStatic
        fun convertLongAndSetText(view: TextView, data: Long){
            view.text = data.toString()
        }

        @BindingAdapter("android:navigateAndSendDataToServicesFragment")
        @JvmStatic
        fun navigateAndSendDataToServicesFragment(view: CardView, currentItem: DhtItinTrabajo){
            view.setOnClickListener {
                val action = WorkItineraryFragmentDirections.actionWorkItineraryScreenToServicesScreen(currentItem)
                view.findNavController().navigate(action)
            }
        }

        @BindingAdapter("android:navigateAndSendDataToActionsFragment")
        @JvmStatic
        fun navigateAndSendDataToActionsFragment(view: CardView, currentItem: DhtItinTrabajoServicio){
            view.setOnClickListener {
                val action = ServicesFragmentDirections.actionServicesScreenToActionsFragment(currentItem)
                view.findNavController().navigate(action)
            }
        }

        @BindingAdapter("android:navigateAndSendDataToMapFragment")
        @JvmStatic
        fun navigateAndSendDataToMapFragment(view: ConstraintLayout, currentItem: DhtItinTrabajo){
            view.setOnClickListener {
                val action = WorkItineraryFragmentDirections.actionWorkItineraryScreenToMapFragment(currentItem)
                view.findNavController().navigate(action)
            }
        }
    }
}