package com.cs4520.assignment3.data.mvp

// MVP architecture: https://www.scaler.com/topics/android/mvp-architecture-android/
public interface MvpContract {
    // interface for the View
    interface View {
        fun showToastMessage(message: String)

        fun setResultText(resultValue: Double)
    }


    // interface for the Presenter
    interface Presenter {
        /**
         * when addition is clicked
         */
        fun onAdditionClick(num1: String, num2: String)

        /**
         * when subtraction is clicked
         */
        fun onSubtractionClick(num1: String, num2: String)

        /**
         * when multiplication is clicked
         */
        fun onMultiplicationClick(num1: String, num2: String)

        /**
         * when division is clicked
         */
        fun onDivisionClick(num1: String, num2: String)
    }


    // interface for the Model
    interface Model {
        /**
         * calculates addition of two numbers
         */
        fun addition(firstNumber: Double, secondNumber: Double): Double

        /**
         * calculates subtraction calculation of two numbers
         */
        fun subtraction(firstNumber: Double, secondNumber: Double): Double

        /**
         * calculates multiplication calculation of two numbers
         */
        fun multiplication(firstNumber: Double, secondNumber: Double): Double

        /**
         * calculates division of two numbers
         */
        fun division(firstNumber: Double, secondNumber: Double): Double
    }

}