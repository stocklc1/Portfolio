//Chris Stockley
//Application Development
//Assignment 1
//October 2, 2015
//Calculator
package com.example.chris.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //Variables used in the Main activity.
    private Button btnClear;
    private Button btnNegPos;
    private Button btnPercent;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn0;
    private Button btnDecimal;
    private Button btnDivide;
    private Button btnMultiply;
    private Button btnSubtract;
    private Button btnAddition;
    private Button btnEquals;
    private Button btnBackSpace;
    private EditText etResult;
    public String result = "";
    public String tempResult = "";
    private MathResults math = new MathResults();
    private String clickedLast = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Joins the variables created in the main method and joins them to their
        //corresponding XML object.
        etResult = (EditText)findViewById(R.id.etResult);
        btnClear = (Button)findViewById(R.id.btnClear);
        btnNegPos = (Button)findViewById(R.id.btnNegPos);
        btnPercent = (Button)findViewById(R.id.btnPercent);
        btn7= (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);
        btn9 = (Button)findViewById(R.id.btn9);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn0 = (Button)findViewById(R.id.btn0);
        btnDecimal = (Button)findViewById(R.id.btnDecimal);
        btnDivide = (Button)findViewById(R.id.btnDivide);
        btnMultiply = (Button)findViewById(R.id.btnMultiply);
        btnSubtract = (Button)findViewById(R.id.btnSubtract);
        btnAddition = (Button)findViewById(R.id.btnAddition);
        btnEquals = (Button)findViewById(R.id.btnEquals);
        btnBackSpace = (Button)findViewById(R.id.btnBackSpace);
        disableMath();

        //Listner for 0 button. Enables math buttons and adds "0" to the result.
        //Then makes the etResult's text equal result.
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//---------------------------------------0
                enableMath();
                result += "0";
                etResult.setText(result);
            }
        });
        //Listner for 1 button. Enables math buttons and adds "1" to the result.
        //Then makes the etResult's text equal result.
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//---------------------------------------1
                enableMath();
                result += "1";
                etResult.setText(result);
            }
        });
        //Listner for 2 button. Enables math buttons and adds "2" to the result.
        //Then makes the etResult's text equal result.
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//---------------------------------------2
                enableMath();
                result += "2";
                etResult.setText(result);
            }
        });
        //Listner for 3 button. Enables math buttons and adds "3" to the result.
        //Then makes the etResult's text equal result.
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//---------------------------------------3
                enableMath();
                result += "3";
                etResult.setText(result);
            }
        });
        //Listner for 4 button. Enables math buttons and adds "4" to the result.
        //Then makes the etResult's text equal result.
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//---------------------------------------4
                enableMath();
                result += "4";
                etResult.setText(result);
            }
        });
        //Listner for 5 button. Enables math buttons and adds "5" to the result.
        //Then makes the etResult's text equal result.
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//---------------------------------------5
                enableMath();
                result += "5";
                etResult.setText(result);
            }
        });
        //Listner for 6 button. Enables math buttons and adds "6" to the result.
        //Then makes the etResult's text equal result.
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//---------------------------------------6
                enableMath();
                result += "6";
                etResult.setText(result);
            }
        });
        //Listner for 7 button. Enables math buttons and adds "7" to the result.
        //Then makes the etResult's text equal result.
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//---------------------------------------7
                enableMath();
                result += "7";
                etResult.setText(result);
            }
        });
        //Listner for 8 button. Enables math buttons and adds "8" to the result.
        //Then makes the etResult's text equal result.
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//---------------------------------------8
                enableMath();
                result += "8";
                etResult.setText(result);
            }
        });
        //Listner for 9 button. Enables math buttons and adds "9" to the result.
        //Then makes the etResult's text equal result.
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//---------------------------------------9
                enableMath();
                result += "9";
                etResult.setText(result);
            }
        });
        //Listner for . button. Disbales the . button and adds "." to the result.
        //Then makes the etResult's text equal result.
        btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//---------------------------------------Decimal
                btnDecimal.setEnabled(false);
                btnBackSpace.setEnabled(true);
                result += ".";
                etResult.setText(result);
            }
        });
        //Listner for clear button. Enables all buttons other than math buttons.
        // Makes result and temp result equal "".
        //Then makes the etResult's text equal result.
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//---------------------------------------Clear
                btnDecimal.setEnabled(true);
                tempResult = "";
                result = "";
                clickedLast = "";
                etResult.setText(result);
                enableAll();
                disableMath();
            }
        });
        //Listner for neg/Pos button. If number doesn\t have a "-" then add it, else delete it.
        //Then makes the etResult's text equal result.
        btnNegPos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//---------------------------------------Negative/Positive
                if(!result.startsWith("-")) {
                    result = "-" + result;
                }
                else
                    result = result.replace("-", "");
                etResult.setText(result);
            }
        });
        //Listener for percent button.
        // If dividing or multiplying. Then calls PercentMultiplyDivision function from MathResult class
        // If adding or subtracting. Then calls PercentAddSubtract function from MathResult class
        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//---------------------------------------Percent
                if(result != "" && clickedLast == "mult" && result != "-")
                    result = math.PercentMultiplyDivision(result);
                else if(result != "" && clickedLast == "div" && result != "-")
                    result = math.PercentMultiplyDivision(result);
                else if (result != "" && clickedLast == "add" && result != "-")
                    result = math.percentAddSubtract(tempResult, result);
                else if (result != "" && clickedLast == "sub" && result != "-")
                    result = math.percentAddSubtract(tempResult, result);
                etResult.setText(result);
            }
        });
        //Listener for addition button.
        //Calls additionClicked function
        //Calls disablesAll function.
        btnAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//---------------------------------------Addition
                additionClicked();
                disableAll();
            }
        });
        //Listener for subtraction button.
        //Calls additionClicked function
        //Calls disablesAll function.
        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//---------------------------------------Subtract
                subtractionClicked();
                disableAll();
            }
        });
        //Listener for multiplication button.
        //Calls additionClicked function
        //Calls disablesAll function.
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//---------------------------------------Multiply
                multiplicationClicked();
                disableAll();
            }
        });
        //Listener for division button.
        //Calls additionClicked function
        //Calls disablesAll function.
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//---------------------------------------Divide
                divisionClicked();
                disableAll();
            }
        });
        //Listener for equals button.
        //Checks to see if tempResult has a value,
        //if it does then it runs a math function based on last math fucntion clicked.
        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//---------------------------------------Equals
                if (tempResult != "") {
                    clickedLast();
                    disableAll();
                    tempResult = "";
                    etResult.setText(result);
                }

            }
        });
        //Listen for Backspace button.
        //Checks to see if the result has a length above 0 and if so
        //deletes the last character.
        //Checks if the last character is a decimal so it can enable the
        //decimal button if its disabled.
        btnBackSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//---------------------------------------Backspace
                if (result.length() == 1 ) {
                    if(result.charAt(result.length() - 1) == '.')
                        btnDecimal.setEnabled(true);
                    result = result.substring(0, result.length() - 1);
                    etResult.setText(result);
                    disableMath();
                }
                if(result.length() > 0) {
                    if (result.charAt(result.length() - 1) == '.')
                        btnDecimal.setEnabled(true);
                    result = result.substring(0, result.length() - 1);
                    etResult.setText(result);
                }
            }
        });
    }
    //method addition button calls.
    public void additionClicked(){
        if(tempResult == "") {
            beforeMath();
        }
        else {
            clickedLast();
            afterMath();
        }
        clickedLast = "add";
    }
    //method subtraction button calls.
    public void subtractionClicked(){
        if(tempResult == "") {
            beforeMath();
        } else {
            clickedLast();
            afterMath();
        }
        clickedLast = "sub";
    }
    //method multiplication button calls.
    public void multiplicationClicked(){
        if(tempResult == "") {
            beforeMath();
        }
        else {
            clickedLast();
            afterMath();
        }
        clickedLast = "mult";
    }
    //method division button calls.
    public void divisionClicked(){
        if(tempResult == "") {
            beforeMath();
        } else {
            clickedLast();
            afterMath();
        }
        clickedLast = "div";
    }
    //Method that decides that if a math function was hit for the first time,
    //it waits for the second input to use function on.
    public void afterMath(){
        etResult.setText(result);
        tempResult = result;
        result = "";
        disableMath();
        btnDecimal.setEnabled(true);
    }
    //Method that decides that if a math function was hit for the second time,
    //math function is then used.
    public void beforeMath(){
        tempResult = result;
        result = "";
        etResult.setText(result);
        disableMath();
        btnDecimal.setEnabled(true);
    }
    //Method that decides that MathResult class function to use based on last math button pressed.
    public void clickedLast(){
        if(clickedLast == "add")
            result = math.Addition(tempResult, result);
        else if (clickedLast == "sub")
            result = math.Subtraction(tempResult, result);
        else if (clickedLast == "div")
            result = math.Division(tempResult, result);
        else if (clickedLast == "mult")
            result = math.Multiplication(tempResult, result);
    }
    //Method that disables all math button.
    public void disableMath(){
        btnEquals.setEnabled(false);
        btnBackSpace.setEnabled(false);
        btnPercent.setEnabled(false);
        btnMultiply.setEnabled(false);
        btnAddition.setEnabled(false);
        btnSubtract.setEnabled(false);
        btnDivide.setEnabled(false);
    }
    //Method that enables all math buttons.
    public void enableMath(){
        btnEquals.setEnabled(true);
        btnBackSpace.setEnabled(true);
        btnPercent.setEnabled(true);
        btnMultiply.setEnabled(true);
        btnAddition.setEnabled(true);
        btnSubtract.setEnabled(true);
        btnDivide.setEnabled(true);
    }
    //Method to check is result was divided by 0,
    // then disables all buttons but clear button
    public void disableAll(){
        if(tempResult == "Not a Real Number" || result == "Not a Real Number") {
            disableMath();
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
            btn6.setEnabled(false);
            btn7.setEnabled(false);
            btn8.setEnabled(false);
            btn9.setEnabled(false);
            btn0.setEnabled(false);
            btnNegPos.setEnabled(false);
            btnDecimal.setEnabled(false);
        }
    }
    //Enables all buttons.
    public void enableAll(){
            btn1.setEnabled(true);
            btn2.setEnabled(true);
            btn3.setEnabled(true);
            btn4.setEnabled(true);
            btn5.setEnabled(true);
            btn6.setEnabled(true);
            btn7.setEnabled(true);
            btn8.setEnabled(true);
            btn9.setEnabled(true);
            btn0.setEnabled(true);
            btnNegPos.setEnabled(true);
            btnDecimal.setEnabled(true);
    }
}