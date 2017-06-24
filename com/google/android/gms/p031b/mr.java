package com.google.android.gms.p031b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class mr extends BroadcastReceiver {
    protected Context f6000a;
    private final C1736a f6001b;

    public static abstract class C1736a {
        public abstract void mo1573a();
    }

    public mr(C1736a c1736a) {
        this.f6001b = c1736a;
    }

    public synchronized void m10065a() {
        if (this.f6000a != null) {
            this.f6000a.unregisterReceiver(this);
        }
        this.f6000a = null;
    }

    public void m10066a(Context context) {
        this.f6000a = context;
    }

    public void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        Object obj = null;
        if (data != null) {
            obj = data.getSchemeSpecificPart();
        }
        if ("com.google.android.gms".equals(obj)) {
            this.f6001b.mo1573a();
            m10065a();
        }
    }
}
