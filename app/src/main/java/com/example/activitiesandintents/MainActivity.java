package com.example.activitiesandintents;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private TextView messageReceived;
    private TextView message;
    private EditText editText;
    private Button sendMessage;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.android.activitiesandintents.extra.MESSAGE";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageReceived = findViewById(R.id.message_received);
        editText = findViewById(R.id.editText);
        sendMessage = findViewById(R.id.sendMessage);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        if (getActionBar() != null) {
            if(getSupportActionBar() != null) {
                ActionBar actionBar = getSupportActionBar();
                actionBar.setDisplayHomeAsUpEnabled(true);
            }

        }



        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LOG_TAG,"Button clicked");
                Intent sendIntent = new Intent(MainActivity.this,Second_Activity.class);
                sendIntent.setAction(Intent.ACTION_SEND);
                String userText = editText.getText().toString();
                sendIntent.putExtra(EXTRA_MESSAGE,userText);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });





    }
}
