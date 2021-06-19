package com.example.jagwe;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);


        String[] title = getResources().getStringArray(R.array.title_book);
        final String[] details = getResources().getStringArray(R.array.detail_book);


        ArrayAdapter<String>arrayAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,title);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String iss=details[position];
                Intent ii = new Intent(MainActivity.this,detailsactivity.class);
                ii.putExtra("detail",iss);
                startActivity(ii);
            }
        });
    }
}