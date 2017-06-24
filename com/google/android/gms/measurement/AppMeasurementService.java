package com.google.android.gms.measurement;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.measurement.internal.C2069f;
import com.google.android.gms.measurement.internal.C2069f.C2014a;

public final class AppMeasurementService extends Service implements C2014a {
    private C2069f f6655a;

    private C2069f m11193b() {
        if (this.f6655a == null) {
            this.f6655a = new C2069f(this);
        }
        return this.f6655a;
    }

    public Context mo1728a() {
        return this;
    }

    public boolean mo1729a(int i) {
        return stopSelfResult(i);
    }

    public IBinder onBind(Intent intent) {
        return m11193b().m11666a(intent);
    }

    public void onCreate() {
        super.onCreate();
        m11193b().m11667a();
    }

    public void onDestroy() {
        m11193b().m11668b();
        super.onDestroy();
    }

    public void onRebind(Intent intent) {
        m11193b().m11670c(intent);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return m11193b().m11665a(intent, i, i2);
    }

    public boolean onUnbind(Intent intent) {
        return m11193b().m11669b(intent);
    }
}
