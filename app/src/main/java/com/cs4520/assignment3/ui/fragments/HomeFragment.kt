package com.cs4520.assignment3.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.cs4520.assignment3.R

class HomeFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.mvpButton).setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_mvpFragment)
        }

        view.findViewById<Button>(R.id.mvvmButton).setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_mvvmFragment)
        }
        super.onViewCreated(view, savedInstanceState)
    }
}