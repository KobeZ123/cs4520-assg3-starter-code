package com.cs4520.assignment3.data.mvp

class MvpPresenter(private var view: MvpContract.View) : MvpContract.Presenter {

    private var model: MvpContract.Model = MvpModel()

    override fun onAdditionClick(num1: String, num2: String) {
        try {
            val firstNumber = num1.toDouble()
            val secondNumber = num2.toDouble()
            val result = this.model.addition(firstNumber, secondNumber)

            this.view.setResultText(result)
        } catch(_: NumberFormatException){
            this.view.showToastMessage("Invalid input! Please enter valid numbers.")
        }
    }

    override fun onSubtractionClick(num1: String, num2: String) {
        try {
            val firstNumber = num1.toDouble()
            val secondNumber = num2.toDouble()
            val result = this.model.subtraction(firstNumber, secondNumber)
            this.view.setResultText(result)
        } catch(_: NumberFormatException){
            this.view.showToastMessage("Invalid input! Please enter valid numbers.")
        }
    }

    override fun onMultiplicationClick(num1: String, num2: String) {
        try {
            val firstNumber = num1.toDouble()
            val secondNumber = num2.toDouble()
            val result = this.model.multiplication(firstNumber, secondNumber)
            this.view.setResultText(result)
        } catch(_: NumberFormatException){
            this.view.showToastMessage("Invalid input! Please enter valid numbers.")
        }
    }

    override fun onDivisionClick(num1: String, num2: String) {
        try {
            val firstNumber = num1.toDouble()
            val secondNumber = num2.toDouble()
            if (secondNumber == 0.0) {
                this.view.showToastMessage("Cannot divide by zero! Please try other numbers.")
            } else {
                val result = this.model.division(firstNumber, secondNumber)
                this.view.setResultText(result)
            }
        } catch(_: NumberFormatException){
            this.view.showToastMessage("Invalid input! Please enter valid numbers.")
        }
    }
}