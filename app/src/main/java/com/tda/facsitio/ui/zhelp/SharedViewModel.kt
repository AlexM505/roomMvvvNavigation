package com.tda.facsitio.ui.zhelp

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.tda.facsitio.data.model.DhtItinTrabajo

class SharedViewModel(application: Application) : AndroidViewModel(application) {

    val emptyDb: MutableLiveData<Boolean> = MutableLiveData(false)

    fun checkIfDbEmpty(listDhtItinTrabajo: List<DhtItinTrabajo>){
        emptyDb.value = listDhtItinTrabajo.isEmpty()
    }

    //animacion para mostrar la vista suavemente
    fun fadeAnim(view : View){
        view.apply {
            alpha = 0f
            visibility = View.VISIBLE
            animate().alpha(1f)
                .setDuration(500)
                .setListener(null)
        }
    }

    //animacion para ocultar la vista suavemente
    fun fadeOutAnim(view : View){
        view.apply {
            animate().alpha(0f)
                .setDuration(500)
                .setListener(object : AnimatorListenerAdapter(){
                    override fun onAnimationEnd(animation: Animator?) {
                        visibility = View.GONE
                    }
                })
        }
    }

}