package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.measurement.internal.ag;

public final class AppMeasurementReceiver extends BroadcastReceiver {
    private ag f6654a;

    private ag m11190a() {
        if (this.f6654a == null) {
            this.f6654a = new ag();
        }
        return this.f6654a;
    }

    public void onReceive(Context context, Intent intent) {
        m11190a().m11379a(context, intent);
    }
}
