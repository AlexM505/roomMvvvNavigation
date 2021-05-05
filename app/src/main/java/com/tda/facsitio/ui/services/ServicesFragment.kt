package com.tda.facsitio.ui.services

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.tda.facsitio.data.model.DhtItinTrabajoServicio
import com.tda.facsitio.databinding.FragmentServicesBinding
import com.tda.facsitio.ui.zhelp.SharedViewModel
import com.tda.facsitio.utils.Status
import jp.wasabeef.recyclerview.animators.SlideInDownAnimator
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator
import jp.wasabeef.recyclerview.animators.SlideInRightAnimator
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator
import kotlinx.android.synthetic.main.activity_main.*

class ServicesFragment : Fragment() {

    private var _binding : FragmentServicesBinding?= null
    private val binding get() = _binding!!

    private val servicesFragmentArgs by navArgs<ServicesFragmentArgs>()
    private val mSharedViewModel : SharedViewModel by viewModels()
    private val mServicesViewModel : ServicesViewModel by viewModels()
    private val servicesAdapter : ServicesAdapter by lazy {ServicesAdapter()}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentServicesBinding.inflate(inflater,container,false)
        binding.lifecycleOwner = this
        binding.args = servicesFragmentArgs

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mSharedViewModel.fadeOutAnim(requireActivity().bottom_nav)

        setupListServices()
        getListServices()
    }

    private fun setupListServices(){
        val recyclerView = binding.rvServices
        recyclerView.adapter = servicesAdapter
        recyclerView.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false)
        recyclerView.itemAnimator = SlideInRightAnimator().apply { addDuration = 300 }
    }

    private fun getListServices(){

        mServicesViewModel.searchServiciosByItin(servicesFragmentArgs.currentItin.ixItinerarioTrabajo)
        mServicesViewModel.getServiciosByItin().observe(viewLifecycleOwner, {
            when (it.status) {
                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    it.data?.let { servicios -> renderList(servicios) }
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

    private fun renderList(servicios:List<DhtItinTrabajoServicio>){
        servicesAdapter.setData(servicios)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}