package com.google.android.gms.p031b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.ads.internal.C1319u;

@id
public class jw extends Handler {
    public jw(Looper looper) {
        super(looper);
    }

    public void handleMessage(Message message) {
        try {
            super.handleMessage(message);
        } catch (Throwable e) {
            C1319u.m7186h().m9117a(e, false);
            throw e;
        }
    }
}
