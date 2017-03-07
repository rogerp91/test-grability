package com.grability.executor;

import android.os.Handler;
import android.os.Looper;

import javax.inject.Inject;

/**
 * Created by rogerp91 on 03/03/17.
 */

public class MainThreadImpl implements MainThread {

    private Handler handler;

    @Inject
    public MainThreadImpl() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void post(Runnable task) {
        handler.post(task);
    }
}
