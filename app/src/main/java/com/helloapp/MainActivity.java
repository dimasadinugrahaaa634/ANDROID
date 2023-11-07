package com.helloapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button toastButton;
    private Button countButton;

    private int previousFibonacci = 0; // Inisialisasi dengan 0
    private int currentFibonacci = 1;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        toastButton = findViewById(R.id.toast);
        countButton = findViewById(R.id.count);

        // Inisialisasi TextView dengan angka pertama
        textView.setText(String.valueOf(previousFibonacci));

        toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(String.valueOf(currentFibonacci));
            }
        });

        countButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count == 0) {
                    currentFibonacci = 1;
                    count++;
                } else {
                    int nextFibonacci = previousFibonacci + currentFibonacci;
                    previousFibonacci = currentFibonacci;
                    currentFibonacci = nextFibonacci;
                }
                textView.setText(String.valueOf(currentFibonacci));
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}