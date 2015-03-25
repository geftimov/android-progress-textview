package com.eftimoff.empty;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.eftimoff.progresstextview.ProgressTextView;


public class MainActivity extends ActionBarActivity {

    private int progressStatus = 0;
    private Handler handler = new Handler();
    private ProgressTextView progressTextView1;
    private ProgressTextView progressTextView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressTextView1 = (ProgressTextView) findViewById(R.id.progressBar1);
        progressTextView2 = (ProgressTextView) findViewById(R.id.progressBar2);
        progressTextView1.setOnClickListener(buttonClickListener);
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            new Thread(new Runnable() {
                public void run() {
                    progressStatus = 0;
                    while (progressStatus < 100) {
                        progressStatus += 1;
                        // Update the progress bar and display the
                        //current value in the text view
                        handler.post(new Runnable() {
                            public void run() {
                                progressTextView1.setProgress(progressStatus);
                                progressTextView2.setProgress(progressStatus);
                            }
                        });
                        try {
                            // Sleep for 200 milliseconds.
                            //Just to display the progress slowly
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    };

}
