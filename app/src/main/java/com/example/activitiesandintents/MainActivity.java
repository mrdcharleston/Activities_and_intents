package com.example.activitiesandintents;

import android.content.Intent;
import android.support.annotation.Nullable;
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
    public static final String EXTRA_MESSAGE = "";
    public static final int TEXT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageReceived = findViewById(R.id.message_received);
        message = findViewById(R.id.reply_message);
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
                startActivityForResult(sendIntent,TEXT_REQUEST);
            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK){
                String reply = data.getStringExtra(Second_Activity.EXTRA_MESSAGE);
                messageReceived.setVisibility(View.VISIBLE);
                message.setText(reply);
                message.setVisibility(View.VISIBLE);
            }
        }
    }
}
