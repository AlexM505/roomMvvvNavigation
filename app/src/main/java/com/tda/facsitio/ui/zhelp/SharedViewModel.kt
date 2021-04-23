package com.tda.facsitio.ui.zhelp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.tda.facsitio.data.model.DhtItinTrabajo

class SharedViewModel(application: Application) : AndroidViewModel(application) {

    val emptyDb: MutableLiveData<Boolean> = MutableLiveData(false)

    fun checkIfDbEmpty(listDhtItinTrabajo: List<DhtItinTrabajo>){
        emptyDb.value = listDhtItinTrabajo.isEmpty()
    }

}