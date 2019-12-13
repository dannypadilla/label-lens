package com.android.labellens


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.android.labellens.databinding.FragmentMainMenuBinding
import kotlin.system.exitProcess


class MainMenu : Fragment() {

    private lateinit var cameraButton: Button
    private lateinit var exitButton: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentMainMenuBinding>(inflater,
            R.layout.fragment_main_menu, container, false)

        this.cameraButton = binding.CameraButton
        this.exitButton = binding.ExitButton

        binding.apply {
            cameraButton.setOnClickListener {view: View ->
                view.findNavController().navigate(R.id.action_mainMenu_to_cameraDisplay)
            }

            exitButton.setOnClickListener{view: View ->
                exitProcess(1)
            }

        }

        return binding.root
    }


}
