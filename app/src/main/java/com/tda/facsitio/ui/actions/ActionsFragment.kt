package com.tda.facsitio.ui.actions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.tda.facsitio.databinding.FragmentActionsBinding
import com.tda.facsitio.utils.Status
import jp.wasabeef.recyclerview.animators.SlideInRightAnimator
import kotlinx.coroutines.*

class ActionsFragment : Fragment() {

    private var _binding : FragmentActionsBinding?= null
    private val binding get() = _binding!!
    private val actionsFragmentArgs by navArgs<ActionsFragmentArgs>()

    private val mActionsViewModel : ActionsViewModel by viewModels()
    private val actionsAdapter : ActionsAdapter by lazy { ActionsAdapter(binding.root.context) }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentActionsBinding.inflate(inflater,container,false)
        binding.lifecycleOwner = this
        binding.args = actionsFragmentArgs

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpListOfAction()
        getActionsByService()
    }

    private fun setUpListOfAction(){
        val recyclerView = binding.rvAcciones
        recyclerView.adapter = actionsAdapter
        recyclerView.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false)
        recyclerView.itemAnimator = SlideInRightAnimator().apply { addDuration = 300 }
    }

    private fun getActionsByService(){

        if(mActionsViewModel.accionesServicio.value == null) {
            val ixItin = actionsFragmentArgs.currentService.ixItinerarioTrabajo
            val servicio = actionsFragmentArgs.currentService.idServicio
            mActionsViewModel.obtenerAccionesByServicio(ixItin, servicio)
        }

        mActionsViewModel.accionesServicio.observe(viewLifecycleOwner, Observer{
            when(it.status){
                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    it.data?.let { actions -> actionsAdapter.setListActionData(actions, actionsFragmentArgs.currentService) }
                }
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                Status.ERROR -> {
                    //Handle Error
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}