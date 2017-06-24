package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.p031b.nu;
import java.util.concurrent.Callable;

public class C1995b {
    private static SharedPreferences f6632a = null;

    class C19941 implements Callable<SharedPreferences> {
        final /* synthetic */ Context f6631a;

        C19941(Context context) {
            this.f6631a = context;
        }

        public SharedPreferences m11147a() {
            return this.f6631a.getSharedPreferences("google_sdk_flags", 1);
        }

        public /* synthetic */ Object call() {
            return m11147a();
        }
    }

    public static SharedPreferences m11148a(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (f6632a == null) {
                f6632a = (SharedPreferences) nu.m10208a(new C19941(context));
            }
            sharedPreferences = f6632a;
        }
        return sharedPreferences;
    }
}
