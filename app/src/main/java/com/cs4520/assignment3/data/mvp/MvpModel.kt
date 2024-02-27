package com.cs4520.assignment3.data.mvp

public class MvpModel: MvpContract.Model {
    override fun addition(firstNumber: Double, secondNumber: Double): Double {
        return firstNumber + secondNumber
    }

    override fun subtraction(firstNumber: Double, secondNumber: Double): Double {
        return firstNumber - secondNumber
    }

    override fun multiplication(firstNumber: Double, secondNumber: Double): Double {
        return firstNumber * secondNumber
    }

    override fun division(firstNumber: Double, secondNumber: Double): Double {
        return firstNumber / secondNumber
    }

}