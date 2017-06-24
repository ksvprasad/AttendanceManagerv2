package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.C1896c;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class C1884h implements ServiceConnection {
    boolean f6396a = false;
    private final BlockingQueue<IBinder> f6397b = new LinkedBlockingQueue();

    public IBinder m10660a(long j, TimeUnit timeUnit) {
        C1896c.m10800c("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.f6396a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f6396a = true;
        IBinder iBinder = (IBinder) this.f6397b.poll(j, timeUnit);
        if (iBinder != null) {
            return iBinder;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f6397b.add(iBinder);
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
