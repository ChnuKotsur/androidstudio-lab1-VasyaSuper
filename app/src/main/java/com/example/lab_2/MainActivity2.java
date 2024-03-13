package com.example.lab_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String messageText = intent.getStringExtra(EXTRA_MESSAGE);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView messageView = (TextView)findViewById(R.id.textView2);
        messageView.setText(messageText);

        View rootLayout = findViewById(android.R.id.content);
        int backgroundResource;

        backgroundResource = R.drawable.new_activity2;
        rootLayout.setBackgroundResource(backgroundResource);
    }
}