package com.tklimczak.fragmentexample;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

public class MainActivity extends FragmentActivity implements ToolbarFragment.ToolbarListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onButtonClick(int fontsize, String text) {
        TextFragment textFragment = (TextFragment)getSupportFragmentManager().findFragmentById(R.id.text_fragment);
        textFragment.changeTextProperties(fontsize, text);
    }
}
