package com.tklimczak.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateBMI(View view) {
        try {
            final int height = Integer.parseInt(((EditText) findViewById(R.id.heightEditText)).getText().toString());
            final int weight = Integer.parseInt(((EditText) findViewById(R.id.weightEditText)).getText().toString());
            final double bmi = calculateBMI(height, weight);

            final TextView bmiTextView = findViewById(R.id.bmiText);
            final TextView stateTextView = findViewById(R.id.stateText);

            bmiTextView.setText(String.format("%.2f", bmi));
            stateTextView.setText(getStateText(bmi));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please provide right number!", Toast.LENGTH_LONG).show();
        } catch (Throwable e) {
            Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private String getStateText(double bmi) {
        if(bmi <= 15) {
            return "Very Severely Underweight";
        } else if(bmi > 15 && bmi <= 16) {
            return "Severely Underweight";
        } else if(bmi > 16 && bmi <= 18.5) {
            return "Underweight";
        } else if(bmi > 18.5 && bmi <= 25) {
            return "Normal";
        } else if(bmi > 25 && bmi <= 30) {
            return "Overweight";
        } else if(bmi > 30 && bmi <= 35) {
            return "Obese Class I";
        } else if(bmi > 35 && bmi <= 40) {
            return "Obese Class II";
        } else {
            return "Obese Class III";
        }
    }

    private double calculateBMI(int height, int weight) {
        final double heightPercent = (double)height / 100;
        return (double)weight / (heightPercent * heightPercent);
    }
}
