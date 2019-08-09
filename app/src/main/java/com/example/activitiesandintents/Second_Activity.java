package com.example.activitiesandintents;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Second_Activity extends AppCompatActivity {

    private TextView message;
    private EditText editText;
    private Button replyToMessage;
    public static final String EXTRA_MESSAGE = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        message = findViewById(R.id.message);
        editText = findViewById(R.id.editText);
        replyToMessage = findViewById(R.id.sendMessage);

        if(getSupportActionBar() != null) {
            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();
        String getMessage = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        message.setText(getMessage);

        replyToMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userText = editText.getText().toString();
                Intent replyIntent = new Intent();
                replyIntent.putExtra(EXTRA_MESSAGE,userText);
                setResult(RESULT_OK,replyIntent);
                finish();

            }
        });



    }
}
