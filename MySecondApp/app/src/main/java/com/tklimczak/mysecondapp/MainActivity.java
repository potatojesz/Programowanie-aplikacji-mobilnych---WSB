package com.tklimczak.mysecondapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String TOTAL_COUNT = "total_count";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * too lazy to add javadoc
     */
    public void toastMe(View view) {
        final Toast toast = Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT);
        toast.show();
    }

    /**
     * too lazy to add javadoc
     */
    public void countMe(View view) {
        final TextView textViewCount = findViewById(R.id.textViewCounter);
        int counter = Integer.parseInt(textViewCount.getText().toString()) + 1;
        textViewCount.setText(String.valueOf(counter));
    }

    /**
     * too lazy to add javadoc
     */
    public void randomMe(View view) {
        final TextView textViewCount = findViewById(R.id.textViewCounter);
        final int counter = Integer.parseInt(textViewCount.getText().toString());
        final Intent intent = new Intent(this, RandomActivity.class);
        intent.putExtra(TOTAL_COUNT, counter);
        startActivity(intent);
    }
}
