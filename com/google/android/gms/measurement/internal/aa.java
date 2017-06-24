package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.C1268k;
import com.google.android.gms.common.internal.C1268k.C1265b;
import com.google.android.gms.common.internal.C1268k.C1266c;
import com.google.android.gms.measurement.internal.C2046y.C2047a;

public class aa extends C1268k<C2046y> {
    public aa(Context context, Looper looper, C1265b c1265b, C1266c c1266c) {
        super(context, looper, 93, c1265b, c1266c, null);
    }

    public C2046y m11245a(IBinder iBinder) {
        return C2047a.m11532a(iBinder);
    }

    protected String mo1181a() {
        return "com.google.android.gms.measurement.START";
    }

    public /* synthetic */ IInterface mo1182b(IBinder iBinder) {
        return m11245a(iBinder);
    }

    protected String mo1183b() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }
}
