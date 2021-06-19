package com.example.jagwe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class detailsactivity extends AppCompatActivity {
    TextView textView;
    Button copy;
    Button share;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        textView = findViewById(R.id.textt);
        copy = findViewById(R.id.copy_btn);
        share = findViewById(R.id.share_btn);


        String details = getIntent().getStringExtra("detail");
        textView.setText(details);

        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip= ClipData.newPlainText("Text",details);
                clipboard.setPrimaryClip(clip);

                Toast.makeText(detailsactivity.this,"copied",Toast.LENGTH_SHORT).show();
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,details);
                intent.setType("text/plain");
                intent = Intent.createChooser(intent,"Loved this? Share it via");
                startActivity(intent);
            }
        });
    }
}