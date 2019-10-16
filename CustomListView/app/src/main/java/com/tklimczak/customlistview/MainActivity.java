package com.tklimczak.customlistview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private static String[] TITLES = {"Facebook", "Whatsapp", "Twitter", "Instagram", "Youtube"};
    private static String[] DESCRIPTION = {"Facebook description", "Whatsapp description", "Twitter description", "Instagram description", "Youtube description"};
    private static int[] IMAGES = {R.drawable.facebook, R.drawable.whatsapp, R.drawable.twitter, R.drawable.instagram, R.drawable.youtube};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyAdapter adapter = new MyAdapter(this);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, DESCRIPTION[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class MyAdapter extends ArrayAdapter<String> {
        Context context;
        MyAdapter(Context context) {
            super(context, R.layout.row, R.id.textView, TITLES);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView imageView = row.findViewById(R.id.imageView);
            TextView textViewMain = row.findViewById(R.id.textView);
            TextView textViewSub = row.findViewById(R.id.textView2);

            imageView.setImageResource(IMAGES[position]);
            textViewMain.setText(TITLES[position]);
            textViewSub.setText(DESCRIPTION[position]);

            return row;
        }
    }
}
