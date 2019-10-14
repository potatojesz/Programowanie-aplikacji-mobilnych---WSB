package com.tklimczak.mysecondapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class RandomActivity extends AppCompatActivity {
    private final static Random RANDOMIZER = new Random();
    private final static String HEADER_LABEL = "Here is a random number beetween 0 and ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        showRandom();
    }

    /** to lazy to write javadoc */
    public void showRandom() {
        final int counter = getIntent().getIntExtra(MainActivity.TOTAL_COUNT, 0);
        final TextView headerLabel = findViewById(R.id.headerLabel);
        final TextView randomNumber = findViewById(R.id.randomNumber);

        headerLabel.setText(HEADER_LABEL + String.valueOf(counter));
        final int random = counter == 0 ? 0 : RANDOMIZER.nextInt(counter);
        randomNumber.setText(String.valueOf(random));
    }
}
