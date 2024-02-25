package com.cs4520.assignment3.data

class MvpPresenter(private var view: MvpContract.View) : MvpContract.Presenter {

    private var model: MvpContract.Model = MvpModel()

    override fun onAdditionClick(num1: String, num2: String) {
        try {
            val firstNumber = num1.toDouble()
            val secondNumber = num2.toDouble()
            val result = this.model.addition(firstNumber, secondNumber)
            this.view.setResultText(result)
        } catch(_: NumberFormatException){
            this.view.showInvalidInputError()
        }
    }

    override fun onSubtractionClick(num1: String, num2: String) {
        try {
            val firstNumber = num1.toDouble()
            val secondNumber = num2.toDouble()
            val result = this.model.subtraction(firstNumber, secondNumber)
            this.view.setResultText(result)
        } catch(_: NumberFormatException){
            this.view.showInvalidInputError()
        }    }

    override fun onMultiplicationClick(num1: String, num2: String) {
        try {
            val firstNumber = num1.toDouble()
            val secondNumber = num2.toDouble()
            val result = this.model.multiplication(firstNumber, secondNumber)
            this.view.setResultText(result)
        } catch(_: NumberFormatException){
            this.view.showInvalidInputError()
        }    }

    override fun onDivisionClick(num1: String, num2: String) {
        try {
            val firstNumber = num1.toDouble()
            val secondNumber = num2.toDouble()
            val result = this.model.division(firstNumber, secondNumber)
            this.view.setResultText(result)
        } catch(_: NumberFormatException){
            this.view.showInvalidInputError()
        }    }

}