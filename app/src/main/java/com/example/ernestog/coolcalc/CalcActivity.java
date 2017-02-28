package com.example.ernestog.coolcalc;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CalcActivity extends Activity {

    public enum Operation {
        ADD, SUBSTRACT, DIVIDE, MULTIPLY, EQUAL
    }

    public Integer result;
    public String runningNumber;
    public String rightValueStr;
    public String leftValueStr;
    public TextView resultsText;
    Operation currentOperantion;

    public CalcActivity() {
        this.result = 0;
        this.runningNumber = "";
        this.rightValueStr = "";
        this.leftValueStr = "";
        this.currentOperantion = null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        resultsText = (TextView)findViewById(R.id.resultsText);
        resultsText.setText("");
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.oneBtn:
                numberPressed(1);
                break;
            case R.id.twoBtn:
                numberPressed(2);
                break;
            case R.id.threeBtn:
                numberPressed(3);
                break;
            case R.id.fourBtn:
                numberPressed(4);
                break;
            case R.id.fiveBtn:
                numberPressed(5);
                break;
            case R.id.sixBtn:
                numberPressed(6);
                break;
            case R.id.sevenBtn:
                numberPressed(7);
                break;
            case R.id.eightBtn:
                numberPressed(8);
                break;
            case R.id.nineBtn:
                numberPressed(9);
                break;
            case R.id.zeroBtn:
                numberPressed(0);
                break;
            case R.id.calcBtn:
                processOperation(Operation.EQUAL);
                break;
            case R.id.divideBtn:
                processOperation(Operation.DIVIDE);
                break;
            case R.id.multiplideBtn:
                processOperation(Operation.MULTIPLY);
                break;
            case R.id.substractBtn:
                processOperation(Operation.SUBSTRACT);
                break;
            case R.id.addBtn:
                processOperation(Operation.ADD);
                break;
            case R.id.clearBtn:
                leftValueStr = "";
                rightValueStr = "";
                result = 0;
                runningNumber = "";
                currentOperantion = null;
                resultsText.setText("");
                break;
        }
    }

    private void numberPressed(int number) {
        runningNumber += String.valueOf(number);
        resultsText.setText(runningNumber);

    }

    private void processOperation(Operation operation) {
        if (currentOperantion != null) {
            if (runningNumber != "") {
                rightValueStr = runningNumber;
                runningNumber = "";

                switch (currentOperantion) {
                    case ADD:
                        result =  Integer.parseInt(leftValueStr) + Integer.parseInt(rightValueStr);
                        break;
                    case SUBSTRACT:
                        result = Integer.parseInt(leftValueStr) - Integer.parseInt(rightValueStr);
                        break;
                    case MULTIPLY:
                        result = Integer.parseInt(leftValueStr) * Integer.parseInt(rightValueStr);
                        break;
                    case DIVIDE:
                        if (Integer.parseInt(rightValueStr) > 0) {
                            result = Integer.parseInt(leftValueStr) * Integer.parseInt(rightValueStr);
                        }
                        break;
                }
                leftValueStr = String.valueOf(result);
                resultsText.setText(leftValueStr);
            }

        } else {
            leftValueStr = runningNumber;
            runningNumber = "";
        }
        currentOperantion = operation;
    }
}
