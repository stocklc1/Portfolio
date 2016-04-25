package com.example.chris.calculator;

public class MathResults {
    //Variables used on the class.
    private int tempNum;
    private double tempDoub;

    //Function that takes in two strings, converts them and adds them together. Then returns the result.
    public String Addition(String result1, String result2){
        if((Double.parseDouble(result1) % 1 != 0.0 || Double.parseDouble(result2) % 1 != 0.0)) {
            tempDoub = Double.parseDouble(result1) + Double.parseDouble(result2);
            return Double.toString(tempDoub);
        }
        else {
            tempNum = (int)Double.parseDouble(result1) + (int)Double.parseDouble(result2);
            return Integer.toString(tempNum);
        }
    }
    //Function that takes in two strings, converts them and subtracts them together. Then returns the result.
    public String Subtraction(String result1, String result2){
        if((Double.parseDouble(result1) % 1 != 0.0 || Double.parseDouble(result2) % 1 != 0.0)) {
            tempDoub = Double.parseDouble(result1) - Double.parseDouble(result2);
            return Double.toString(tempDoub);
        }
        else {
            tempNum = (int)Double.parseDouble(result1) - (int)Double.parseDouble(result2);
            return Integer.toString(tempNum);
        }
    }
    //Function that takes in two strings, converts them and multiplys them together. Then returns the result.
    public String Multiplication(String result1, String result2){
        if((Double.parseDouble(result1) % 1 != 0.0 || Double.parseDouble(result2) % 1 != 0.0)) {
            tempDoub = Double.parseDouble(result1) * Double.parseDouble(result2);
            return Double.toString(tempDoub);
        }
        else {
            tempNum = (int)Double.parseDouble(result1) * (int)Double.parseDouble(result2);
            return Integer.toString(tempNum);
        }
    }
    //Function that takes in two strings, converts them and divides them together. Then returns the result.
    public String Division(String result1, String result2){
        if(Double.parseDouble(result2) != 0.0) {
            tempDoub = Double.parseDouble(result1) / Double.parseDouble(result2);
            if ((tempDoub % 1 != 0.0)) {
                return Double.toString(tempDoub);
            } else {
                tempNum = (int) Double.parseDouble(result1) / (int) Double.parseDouble(result2);
                return Integer.toString(tempNum);
            }
        }
        else
            return "Not a Real Number";

    }
    //Function that takes in a string, converts it to a percent. Then returns the result.
    public String PercentMultiplyDivision(String result){
        tempDoub = Double.parseDouble(result) / 100;
        return Double.toString(tempDoub);
    }
    //Function that takes in a two strings, converts the second string to a percent of the first string.
    // Then returns the result.
    public String percentAddSubtract(String result1, String result2) {
        tempDoub = (Double.parseDouble(result1) * Double.parseDouble(result2) / 100);
        if ((tempDoub % 1 != 0.0)) {
            return Double.toString(tempDoub);
        } else {
            tempNum = (int) (Double.parseDouble(result1) * Double.parseDouble(result2) / 100);
            return Integer.toString(tempNum);
        }
    }
}
