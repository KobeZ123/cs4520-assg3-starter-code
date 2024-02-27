package com.cs4520.assignment3.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cs4520.assignment3.R
import com.cs4520.assignment3.data.mvp.MvpContract
import com.cs4520.assignment3.data.mvp.MvpPresenter
import com.cs4520.assignment3.databinding.FragmentMvpBinding

class MVPFragment : Fragment(), MvpContract.View {
    private var _binding: FragmentMvpBinding? = null
    private val binding get() = _binding!!

    private lateinit var presenter: MvpPresenter

    /**
     * creates the view with view binding
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreate(savedInstanceState)
        _binding = FragmentMvpBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = MvpPresenter(this)

        binding.addButton.setOnClickListener {
            presenter.onAdditionClick(
                num1 = binding.firstNumber.text.toString(),
                num2 = binding.secondNumber.text.toString()
            )
        }

        binding.subtractButton.setOnClickListener {
            presenter.onSubtractionClick(
                num1 = binding.firstNumber.text.toString(),
                num2 = binding.secondNumber.text.toString()
            )
        }

        binding.multiplyButton.setOnClickListener {
            presenter.onMultiplicationClick(
                num1 = binding.firstNumber.text.toString(),
                num2 = binding.secondNumber.text.toString()
            )
        }

        binding.divideButton.setOnClickListener {
            presenter.onDivisionClick(
                num1 = binding.firstNumber.text.toString(),
                num2 = binding.secondNumber.text.toString()
            )
        }
    }

    override fun showToastMessage(message: String) {
        Toast.makeText(
            this.context,
            message,
            Toast.LENGTH_LONG
        ).show()
    }

    override fun setResultText(resultValue: Double) {
        binding.resultText.text = getString(R.string.result, resultValue)
        binding.resultText.visibility = View.VISIBLE
    }
}