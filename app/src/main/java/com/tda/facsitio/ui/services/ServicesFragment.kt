package com.tda.facsitio.ui.services

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.tda.facsitio.R
import com.tda.facsitio.databinding.FragmentServicesBinding
import com.tda.facsitio.ui.zhelp.SharedViewModel
import com.tda.facsitio.utils.MyPreferencesUtil
import com.tda.facsitio.utils.Status
import jp.wasabeef.recyclerview.animators.SlideInRightAnimator
import kotlinx.android.synthetic.main.activity_main.*

class ServicesFragment : Fragment(), SearchView.OnQueryTextListener {

    companion object{
        const val TAG_SCREEN = "SERVICES_SCREEN"
    }
    private var _binding : FragmentServicesBinding?= null
    private val binding get() = _binding!!

    private val servicesFragmentArgs by navArgs<ServicesFragmentArgs>()
    private val mSharedViewModel : SharedViewModel by viewModels()
    private val mServicesViewModel : ServicesViewModel by viewModels()
    private val servicesAdapter : ServicesAdapter by lazy {ServicesAdapter()}

    private lateinit var preferences: MyPreferencesUtil

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentServicesBinding.inflate(inflater,container,false)
        binding.lifecycleOwner = this
        binding.args = servicesFragmentArgs

        preferences = MyPreferencesUtil(requireContext())
        preferences.setTagFragment(TAG_SCREEN)
        setHasOptionsMenu(true)
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
                    it.data?.let { servicios -> servicesAdapter.setData(servicios) }
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_services, menu)
        val search = menu.findItem(R.id.menu_search)
        val searchView = search.actionView as? SearchView
        searchView?.isSubmitButtonEnabled = true
        searchView?.setOnQueryTextListener(this)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if(query != null)
            searchThroughDatabase(query)

        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if(newText != null)
            searchThroughDatabase(newText)

        return true
    }

    private fun searchThroughDatabase(query: String) {
        var searchQuery = query
        searchQuery = "%$searchQuery%"
        mServicesViewModel.searchServiciosDb(searchQuery).observe(this, { list ->
            list?.let {
                servicesAdapter.setData(it)
            }
        })
    }

}