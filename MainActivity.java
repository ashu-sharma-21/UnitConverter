package com.example.fahrenheittocelsius;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private RadioButton currencyRadioButton, lengthRadioButton, temperatureRadioButton, weightRadioButton, heightRadiioButton;
    private EditText editText;
    private TextView value1, value2, value3, value4,value5;
    private Button convertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currencyRadioButton = findViewById(R.id.currency);
        lengthRadioButton = findViewById(R.id.length);
        temperatureRadioButton = findViewById(R.id.temperature);
        weightRadioButton = findViewById(R.id.weight);
        editText = findViewById(R.id.input);
        value1 = findViewById(R.id.value1);
        value2 = findViewById(R.id.value2);
        value3 = findViewById(R.id.value3);
        value4 = findViewById(R.id.value4);

        convertButton = findViewById(R.id.convertButton);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performConversion();
            }
        });
    }

    @SuppressLint("NonConstantResourceId")
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        if (view.getId() == R.id.length) {
            if (checked) {
                Toast.makeText(MainActivity.this, "Enter length value to convert", Toast.LENGTH_SHORT).show();
            }
        } else if (view.getId() == R.id.currency) {
            if (checked) {
                Toast.makeText(this, "Enter currency value to convert", Toast.LENGTH_SHORT).show();
            }
        } else if (view.getId() == R.id.weight) {
            if (checked) {
                Toast.makeText(this, "Enter weight to convert", Toast.LENGTH_SHORT).show();
            }
        } else if (view.getId() == R.id.temperature) {
            if (checked) {
                Toast.makeText(this, "Enter temperature to convert", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void performConversion() {
        String temp = editText.getText().toString();
        int value = Integer.parseInt(temp);

        if (lengthRadioButton.isChecked()) {
            value1.setText(value + " Miles = " + value * 1.60934 + " Kilometers");
            value2.setText(value + " Miles = " + value * 1609.33999 + " Meters");
            value3.setText(value + " Miles = " + value * 5279.9868 + " Feet");
            value4.setText(value + " Miles = " + value * 63359.8425 + " Inches");
        } else if (currencyRadioButton.isChecked()) {
            value1.setText(value + " US Dollars = " + value * 0.85 + " Euros");
            value2.setText(value + " US Dollars = " + value * 75.82 + " Russian Rubles");
            value3.setText(value + " US Dollars = " + value * 1.40 + " Australian Dollars");
            value4.setText(value + " US Dollars = " + value * 1.33 + " Canadian Dollars");
        } else if (weightRadioButton.isChecked()) {
            value1.setText(value + " Pounds = " + value * 0.453592 + " Kilograms");
            value2.setText(value + " Pounds = " + value * 453.592 + " Grams");
            value3.setText(value + " Pounds = " + value * 15.999 + " Ounces");
            value4.setText(value + " Pounds = " + value * 0.005 + " Tons");
        } else if (temperatureRadioButton.isChecked()) {
            value1.setText(value + " Fahrenheit = " + value * -17.2222 + " Celsius");
            value2.setText(value + " Fahrenheit = " + value * 255.9278 + " Kelvin");
            value3.setText("");
            value4.setText("");

        }
    }
}
