package com.example.myfirstapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DisplayMessageActivity2 extends AppCompatActivity {
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message2);

        Intent intent = getIntent();
        String message = intent.getStringExtra(DisplayMessageActivity.EXTRA_MESSAGE);

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
            Log.d("TEST","test2");
            Intent startActivity = new Intent(DisplayMessageActivity2.this, MainActivity.class);
            startActivity(startActivity);
            finish();
      /* and here comes the "trick" */
            // handler.postDelayed(this, 10000);
            // handler.removeCallback(runnable);
        }
    };

}
