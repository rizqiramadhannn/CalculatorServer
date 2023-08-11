package com.example.calculatorservice;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Start the CalculatorService
        Intent serviceIntent = new Intent(this, CalculatorService.class);
        startService(serviceIntent);

    }
}
