package com.example.services;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.services.databinding.ActivityMainBinding;

import service.ForegroundService;

public class ForegroundServiceActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private Intent foregroundIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        foregroundIntent=new Intent(ForegroundServiceActivity.this, ForegroundService.class);
        binding.buttonStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService();
            }
        });

        binding.buttonStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService_();
            }
        });
    }

    private void stopService_() {
        stopService(foregroundIntent);
    }

    private void startService() {
        foregroundIntent.putExtra("foreground","Foreground Service is running");
        ContextCompat.startForegroundService(getApplicationContext(), foregroundIntent);
    }
}