package com.google.android.gms.p031b;

import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.util.client.C1324b;
import java.util.concurrent.Callable;

@id
public class kl {
    public static <T> T m9352a(Callable<T> callable) {
        ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        T call;
        try {
            StrictMode.setThreadPolicy(new Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            call = callable.call();
            return call;
        } catch (Throwable th) {
            call = th;
            C1324b.m7231b("Unexpected exception.", call);
            C1319u.m7186h().m9117a((Throwable) call, true);
            return null;
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }
}
