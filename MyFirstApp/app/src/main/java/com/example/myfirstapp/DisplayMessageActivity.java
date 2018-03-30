package com.example.myfirstapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;


public class DisplayMessageActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);

        handler.postDelayed(runnable, 5000);
        //handler.removeCallback(runnable);

    }
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
      /* do what you need to do */
            Log.d("TEST","test");
            Intent startActivity = new Intent(DisplayMessageActivity.this, DisplayMessageActivity2.class);
            String message = "Activity 2";
            startActivity.putExtra(EXTRA_MESSAGE, message);
            startActivity(startActivity);
            finish();
            //Intent intent = new Intent(DisplayMessageActivity.class, MainActivity.class);
           // EditText editText = (EditText) findViewById(R.id.editText);
            //String message = editText.getText().toString();
            //String message1 = "Activity 2";
            //intent.putExtra(EXTRA_MESSAGE, message1);
            //intent.putExtra(EXTRA_MESSAGE, message);
           // startActivity(intent);

      /* and here comes the "trick" */
           // handler.postDelayed(this, 10000);
           // handler.removeCallback(runnable);
        }
    };
}
