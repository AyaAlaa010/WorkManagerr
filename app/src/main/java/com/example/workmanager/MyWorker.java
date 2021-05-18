package com.example.workmanager;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWorker  extends Worker {
    private static final String TAG = "MyWorker";
    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Thread thread= new Thread(new Runnable() {
            @Override
            public void run() {
try{
    for(int i=0;i<10;i++){
        Thread.sleep(1000);
        Log.i(TAG, "run: "+i);
    }
}
catch (Exception e) {
    e.printStackTrace();
}
        }});
        thread.start();
        return Result.success();
    }
}
