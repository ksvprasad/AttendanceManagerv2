package com.google.android.gms.gass.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.C1268k;
import com.google.android.gms.common.internal.C1268k.C1265b;
import com.google.android.gms.common.internal.C1268k.C1266c;
import com.google.android.gms.gass.internal.C2001e.C2003a;

public class C1998b extends C1268k<C2001e> {
    public C1998b(Context context, Looper looper, C1265b c1265b, C1266c c1266c) {
        super(context, looper, 116, c1265b, c1266c, null);
    }

    protected C2001e m11163a(IBinder iBinder) {
        return C2003a.m11176a(iBinder);
    }

    protected String mo1181a() {
        return "com.google.android.gms.gass.START";
    }

    protected /* synthetic */ IInterface mo1182b(IBinder iBinder) {
        return m11163a(iBinder);
    }

    protected String mo1183b() {
        return "com.google.android.gms.gass.internal.IGassService";
    }

    public C2001e mo1702k() {
        return (C2001e) super.m6981u();
    }
}
