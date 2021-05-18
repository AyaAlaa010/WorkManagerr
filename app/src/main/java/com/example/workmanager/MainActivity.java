package com.example.workmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import android.os.Bundle;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Constraints constraints=new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).setRequiresBatteryNotLow(true)
                .setRequiresCharging(true)
                .build();
        PeriodicWorkRequest periodicWorkRequest= new PeriodicWorkRequest.Builder(MyWorker.class,15, TimeUnit.MINUTES).addTag("periodic Worker").setConstraints(constraints).build();
        OneTimeWorkRequest oneTimeWorkRequest=new OneTimeWorkRequest.Builder(MyWorker.class).addTag("oneTimeWorker").build();
        WorkManager.getInstance(this).enqueue(oneTimeWorkRequest);
    }

}