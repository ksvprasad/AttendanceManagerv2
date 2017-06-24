package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.ads.internal.request.C1277k.C1279a;
import com.google.android.gms.common.internal.C1268k;
import com.google.android.gms.common.internal.C1268k.C1265b;
import com.google.android.gms.common.internal.C1268k.C1266c;
import com.google.android.gms.p031b.id;

@id
public class C1269e extends C1268k<C1277k> {
    final int f3874a;

    public C1269e(Context context, Looper looper, C1265b c1265b, C1266c c1266c, int i) {
        super(context, looper, 8, c1265b, c1266c, null);
        this.f3874a = i;
    }

    protected C1277k m6984a(IBinder iBinder) {
        return C1279a.m7007a(iBinder);
    }

    protected String mo1181a() {
        return "com.google.android.gms.ads.service.START";
    }

    protected /* synthetic */ IInterface mo1182b(IBinder iBinder) {
        return m6984a(iBinder);
    }

    protected String mo1183b() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    public C1277k b_() {
        return (C1277k) super.m6981u();
    }
}
