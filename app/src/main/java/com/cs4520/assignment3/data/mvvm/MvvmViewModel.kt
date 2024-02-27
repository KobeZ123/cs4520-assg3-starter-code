package com.cs4520.assignment3.data.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MvvmViewModel: ViewModel() {
    private var _resultLiveData = MutableLiveData<Double?>(null)
    val resultLiveData: LiveData<Double?>
        get() = _resultLiveData

    private var _errorMessageLiveData = MutableLiveData<String?>(null)

    val errorMessageLiveData: LiveData<String?>
        get() = _errorMessageLiveData

    public fun onAdditionClick(num1: String, num2: String) {
        try {
            val firstNumber = num1.toDouble()
            val secondNumber = num2.toDouble()
            val result = firstNumber + secondNumber
            this._resultLiveData.postValue(result)
        } catch(_: NumberFormatException){
            this._errorMessageLiveData.postValue("Invalid input! Please enter valid numbers.")
        }
    }

    fun onSubtractionClick(num1: String, num2: String) {
        try {
            val firstNumber = num1.toDouble()
            val secondNumber = num2.toDouble()
            val result = firstNumber - secondNumber
            this._resultLiveData.postValue(result)
        } catch(_: NumberFormatException){
            this._errorMessageLiveData.postValue("Invalid input! Please enter valid numbers.")
        }
    }

    fun onMultiplicationClick(num1: String, num2: String) {
        try {
            val firstNumber = num1.toDouble()
            val secondNumber = num2.toDouble()
            val result = firstNumber * secondNumber
            this._resultLiveData.postValue(result)
        } catch(_: NumberFormatException){
            this._errorMessageLiveData.postValue("Invalid input! Please enter valid numbers.")
        }
    }

    fun onDivisionClick(num1: String, num2: String) {
        try {
            val firstNumber = num1.toDouble()
            val secondNumber = num2.toDouble()
            if (secondNumber == 0.0) {
                this._errorMessageLiveData.postValue("Cannot divide by zero! Please try other numbers.")
            } else {
                val result = firstNumber / secondNumber
                this._resultLiveData.postValue(result)
            }
        } catch(_: NumberFormatException){
            this._errorMessageLiveData.postValue("Invalid input! Please enter valid numbers.")
        }
    }
}