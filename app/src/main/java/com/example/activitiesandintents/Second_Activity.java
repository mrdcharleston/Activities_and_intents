package com.example.activitiesandintents;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Second_Activity extends AppCompatActivity {

    TextView messageReceived;
    TextView message;
    EditText editText;
    Button replyToMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        message = findViewById(R.id.message_received);

        if(getSupportActionBar() != null) {
            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();
        String getMessage = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        message.setText(getMessage);



    }
}
