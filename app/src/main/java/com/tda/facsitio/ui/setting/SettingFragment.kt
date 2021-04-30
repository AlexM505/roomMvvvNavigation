package com.tda.facsitio.ui.setting

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tda.facsitio.R
import com.tda.facsitio.databinding.FragmentSettingBinding
import com.tda.facsitio.databinding.FragmentWorkItineraryBinding
import com.tda.facsitio.ui.MainActivity
import com.tda.facsitio.utils.MyPreferencesUtil

class SettingFragment : Fragment() {

    private var _binding: FragmentSettingBinding?= null
    private val binding get() = _binding!!

    private lateinit var preferences: MyPreferencesUtil

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSettingBinding.inflate(inflater, container,false)
        binding.lifecycleOwner = this

        loadUi()

        binding.sOnOffDark.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                preferences.setDarkModeState(true)
                restartApplication()
            }else{
                preferences.setDarkModeState(false)
                restartApplication()
            }
        }

        return binding.root
    }

    private fun loadUi(){
        preferences = MyPreferencesUtil(requireContext())
        if(preferences.loadDarkModeState()){
            binding.sOnOffDark.isChecked = true
        }
    }

    private fun restartApplication() {
        val i = Intent(requireContext(),MainActivity::class.java)
        startActivity(i)
        requireActivity().finish()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}