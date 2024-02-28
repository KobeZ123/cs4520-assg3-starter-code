package com.cs4520.assignment3.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.cs4520.assignment3.R
import com.cs4520.assignment3.data.mvvm.MvvmViewModel
import com.cs4520.assignment3.databinding.FragmentMvvmBinding

/**
 * Fragment for MVVM architecture
 */
class MVVMFragment: Fragment() {
    private var _binding: FragmentMvvmBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MvvmViewModel

    /**
     * creates the view with view binding
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreate(savedInstanceState)
        _binding = FragmentMvvmBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MvvmViewModel::class.java]

        // setting on click listeners
        binding.addButton.setOnClickListener {
            viewModel.onAdditionClick(
                num1 = binding.firstNumber.text.toString(),
                num2 = binding.secondNumber.text.toString()
            )
            binding.firstNumber.text.clear()
            binding.secondNumber.text.clear()
        }

        binding.subtractButton.setOnClickListener {
            viewModel.onSubtractionClick(
                num1 = binding.firstNumber.text.toString(),
                num2 = binding.secondNumber.text.toString()
            )
            binding.firstNumber.text.clear()
            binding.secondNumber.text.clear()
        }

        binding.multiplyButton.setOnClickListener {
            viewModel.onMultiplicationClick(
                num1 = binding.firstNumber.text.toString(),
                num2 = binding.secondNumber.text.toString()
            )
            binding.firstNumber.text.clear()
            binding.secondNumber.text.clear()
        }

        binding.divideButton.setOnClickListener {
            viewModel.onDivisionClick(
                num1 = binding.firstNumber.text.toString(),
                num2 = binding.secondNumber.text.toString()
            )
            binding.firstNumber.text.clear()
            binding.secondNumber.text.clear()
        }

        initObserver()
    }

    /**
     * initializes the live data observers
     */
    private fun initObserver() {
        viewModel.resultLiveData.observe(viewLifecycleOwner) {
            if (it == null) {
                binding.resultText.visibility = View.INVISIBLE
            } else {
                binding.resultText.text = getString(R.string.result, it)
                binding.resultText.visibility = View.VISIBLE
            }
        }

        viewModel.errorMessageLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                Toast.makeText(
                    this.context,
                    it,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}