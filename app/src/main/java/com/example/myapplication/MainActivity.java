package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String operation="";
    TextView textView;
    Button addButton ;
    Button subtractButton ;
    Button multiplyButton ;
    Button divideButton ;
    Button clearButton;
    Button calculateButton;
    int blueyColor, tealColor;


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
                double ans = (Math.round((num1*num2)*1000000000000.0))/1000000000000.0;
                textView.setText(ans+"");
            }
            else if(operation.equals("divide")){
                if(num2!=0){
                    double ans = (Math.round(num1/num2*1000000000000.0))/1000000000000.0;
                    textView.setText(ans+"");
                }else{
                    textView.setText("Undefined");
                }
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
        resetColors();
    }

    public void onAddOpClick(View view){
        operation = "add";
        resetColors();
        addButton.setBackgroundTintList(ColorStateList.valueOf(tealColor));
    }
    public void onSubtractOpClick(View view){
        operation = "subtract";
        resetColors();
        subtractButton.setBackgroundTintList(ColorStateList.valueOf(tealColor));
    }
    public void onMultiplyOpClick(View view){
        operation = "multiply";
        resetColors();
        multiplyButton.setBackgroundTintList(ColorStateList.valueOf(tealColor));
    }
    public void onDivideOpClick(View view){
        operation = "divide";
        resetColors();
        divideButton.setBackgroundTintList(ColorStateList.valueOf(tealColor));
    }
    public void resetColors(){
        addButton.setBackgroundTintList(ColorStateList.valueOf(blueyColor));
        subtractButton.setBackgroundTintList(ColorStateList.valueOf(blueyColor));
        multiplyButton.setBackgroundTintList(ColorStateList.valueOf(blueyColor));
        divideButton.setBackgroundTintList(ColorStateList.valueOf(blueyColor));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blueyColor = ResourcesCompat.getColor(getResources(), R.color.bluey, null); // Copied this process from a github comment by sat
        tealColor = ResourcesCompat.getColor(getResources(), R.color.teal_200, null); // https://stackoverflow.com/a/5271452

        addButton = findViewById(R.id.addition);
        subtractButton = findViewById(R.id.subtraction);
        multiplyButton = findViewById(R.id.multiplication);
        divideButton = findViewById(R.id.division);
        clearButton = findViewById(R.id.clearButton);
        calculateButton = findViewById(R.id.calculateButton);
    }
}