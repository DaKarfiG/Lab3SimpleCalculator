package com.example.lab3simplecalculator;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //
    public enum Operator {none, add, minus, multiply, divide}
    //instance variables to be used for the arithmetic operations
    private double data1 = 0, data2 = 0;
    //holds the current operation
    //set at none for now
    private Operator optr = Operator.none; //set a

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void btn00Click(View view) {
        TextView eText = (TextView) findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + "0");
    }

    public void btn01Click(View view) {
        TextView eText = (TextView) findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + "1");
    }

    public void btn02Click(View view) {
        TextView eText = (TextView) findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + "2");
    }

    public void btn03Click(View view) {
        TextView eText = (TextView)findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + "3");
    }

    public void btn04Click(View view) {
        TextView eText = (TextView)findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + "4");
    }

    public void btn05Click(View view) {
        TextView eText = (TextView)findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + "5");
    }

    public void btn06Click(View view) {
        TextView eText = (TextView)findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + "6");
    }

    public void btn07Click(View view) {
        TextView eText = (TextView)findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + "7");
    }

    public void btn08Click(View view) {
        TextView eText = (TextView) findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + "8");
    }

    public void btn09Click(View view) {
        TextView eText = (TextView) findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + "9");
    }

    public void btnAddClick(View view) {
        optr = Operator.add;
        TextView eText = (TextView) findViewById(R.id.resultEdit);
        data1 = Double.parseDouble(eText.getText().toString());
        eText.setText("");
    }

    public void btnMinusClick(View view) {
        optr = Operator.minus;
        TextView eText = (TextView) findViewById(R.id.resultEdit);
        data1 = Double.parseDouble(eText.getText().toString());
        eText.setText("");
    }

    public void btnMultiplyClick(View view) {
        optr = Operator.multiply;
        TextView eText = (TextView) findViewById(R.id.resultEdit);
        data1 = Double.parseDouble(eText.getText().toString());
        eText.setText("");
    }

    public void btnDivideClick(View view) {
        optr = Operator.divide;
        TextView eText = (TextView) findViewById(R.id.resultEdit);
        data1 = Double.parseDouble(eText.getText().toString());
        eText.setText("");
    }

    public void btnClearClick(View view) {
        TextView eText = (TextView) findViewById(R.id.resultEdit);
        eText.setText("");
    }

    public void btnDotClick(View view) {
        TextView eText = (TextView) findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + ".");
    }

    public void btnResultClick(View view) {
        if(optr != Operator.none){
            TextView eText = (TextView)findViewById(R.id.resultEdit);
            data2 = Double.parseDouble(eText.getText().toString());
            double result = 0;
            if(optr == Operator.add) {
                result = data1 + data2;
            }
            else if(optr ==Operator.minus){
                result = data1-data2;
            }
            else if(optr==Operator.multiply){
                result = data1*data2;
            }
            else if(optr == Operator.divide){
                result = data1/data2;
            }

            optr = Operator.none;
            data1= result;
            if((result - (int)result) != 0){
                eText.setText(String.valueOf(result));

            } else{
                eText.setText(String.valueOf((int)result));
            }

        }
    }

    public void onClickNumericalButton(View view) {
        int pressID = view.getId();
        TextView curText = (TextView) findViewById(R.id.resultEdit);

        if (optr == Operator.eq) {
            opp = Operator.none;
            curText.setText("");
        }

        if (requiresCleaning) {
            requiresCleaning = false;
            curText.setText("");
        }

        switch (pressID) {
            case R.id.button0:
                curText.setText(curText.getText() + "0");
                break;
            case R.id.button1:
                curText.setText(curText.getText() + "1");
                break;
            case R.id.button2:
                curText.setText(curText.getText() + "2");
                break;
            case R.id.button3:
                curText.setText(curText.getText() + "3");
                break;
            case R.id.button4:
                curText.setText(curText.getText() + "4");
                break;
            case R.id.button5:
                curText.setText(curText.getText() + "5");
                break;
            case R.id.button6:
                curText.setText(curText.getText() + "6");
                break;
            case R.id.button7:
                curText.setText(curText.getText() + "7");
                break;
            case R.id.button8:
                curText.setText(curText.getText() + "8");
                break;
            case R.id.button9:
                curText.setText(curText.getText() + "9");
                break;
            case R.id.buttonDot:
                if (!hasDot) {
                    curText.setText(curText.getText() + ".");
                    hasDot = true;
                }
                break;
            case R.id.buttonEq:
                // Implement the equals button functionality
                double result = evaluateExpression(curText.getText().toString());
                curText.setText(String.valueOf(result));
                opp = Operator.eq;
                break;
            default:
                curText.setText("ERROR");
                Log.d("Error", "Error: Unknown Button pressed!");
                break;
        }
    }

    // Function to evaluate the expression
    private double evaluateExpression(String expression) {
        // Implement your expression evaluation logic here
        // This is a placeholder implementation
        return 0.0;
    }


    public void onClickFunctionButton(View view) {
        //getting ID of pressed button
        int pressID = view.getId();
        //getting TextView object where we display the current number value
        TextView curText = (TextView) findViewById(R.id.resultEdit);
        //CE clears all regardless of context
        if (pressID == R.id.buttonce) {
            opp = Operator.none;
            curText.setText("");
            data1 = 0;
            data2 = 0;
            requiresCleaning = false;
            return;
        }
        String dataText = curText.getText().toString();
        double numberVal = dataText.length() > 0 ? Double.parseDouble(dataText) : 0;
        //checking if we have "prior data" aka stored data that we should use
        //Having data1 = 0 is not enough, we need an operator, hence this
        if (opp == Operator.none) {
            data1 = numberVal;
            requiresCleaning = true;
            switch (pressID) {
                case R.id.buttonEq:
                    opp = Operator.eq;
                    data1 = 0;
                    break;
                case R.id.buttonAdd:
                    opp = Operator.add;
                    break;
                case R.id.buttonSub:
                    opp = Operator.sub;
                    break;
                case R.id.buttonMul:
                    opp = Operator.mul;
                    break;
                case R.id.buttonDiv:
                    opp = Operator.div;
                    break;
                case R.id.buttonCE:
                    opp = Operator.none;
                    break;
            }
        } else {
            double result = 0;
            data2 = numberVal;
            switch (opp) {
                case eq:
                    break;
                case none:
                    break;
                case add:
                    result = data1 + data2;
                    break;
                case sub:
                    result = data1 - data2;
                    break;
                case div:
                    result = data1 / data2;
                    break;
                case mul:
                    result = data1 * data2;
                    break;
        }
        data1 = result;
        opp = Operator.none;
        if ((result - (int) result) != 0) {
            curText.setText(String.valueOf(result));
        } else {
            curText.setText(String.valueOf((int) result));
        }
    }

}



}