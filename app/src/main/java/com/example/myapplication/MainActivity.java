package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String operation="";
    TextView textView;
    public void onCalculate(View view){
        EditText boxNum1 = findViewById(R.id.enteredNumber1);
        EditText boxNum2 = findViewById(R.id.enteredNumber2);
        textView =  findViewById(R.id.answerTextView);

        if(!(operation.isEmpty() || boxNum1.getText().toString().isEmpty() || boxNum2.getText().toString().isEmpty())) {
            double num1 = Double.parseDouble(String.valueOf(boxNum1.getText()));
            double num2 = Double.parseDouble(String.valueOf(boxNum2.getText()));

            if(operation.equals("add")){
                textView.setText(num1+num2+"");
            }
            else if(operation.equals("subtract")){
                textView.setText(num1-num2+"");
            }
            else if(operation.equals("multiply")){
                textView.setText(num1*num2+"");
            }
            else if(operation.equals("divide")){
                textView.setText(num1/num2+"");
            }
        }else{
            textView.setText("Select an operation or enter numbers");
        }
    }

    public void onClear(View view){
        EditText boxNum1 = findViewById(R.id.enteredNumber1);
        EditText boxNum2 = findViewById(R.id.enteredNumber2);
        textView =  findViewById(R.id.answerTextView);
        boxNum1.setText("");
        boxNum2.setText("");
        textView.setText("Answer will appear here");
        operation = "";
    }

    public void onAddOpClick(View view){
        operation = "add";
    }
    public void onSubtractOpClick(View view){
        operation = "subtract";
    }
    public void onMultiplyOpClick(View view){
        operation = "multiply";
    }
    public void onDivideOpClick(View view){
        operation = "divide";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}