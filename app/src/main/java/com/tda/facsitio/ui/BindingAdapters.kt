package com.tda.facsitio.ui

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData

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
    }
}