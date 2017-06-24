package com.google.android.gms.p031b;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.common.api.C1767c.C1733c;
import com.google.android.gms.common.api.C1767c.C1742b;
import com.google.android.gms.common.internal.C1724r;
import com.google.android.gms.common.internal.C1927n;
import com.google.android.gms.p031b.lv.C1727a;

public class ls extends C1724r<lv> {
    public ls(Context context, Looper looper, C1927n c1927n, C1742b c1742b, C1733c c1733c) {
        super(context, looper, 40, c1927n, c1742b, c1733c);
    }

    protected lv m9707a(IBinder iBinder) {
        return C1727a.m9724a(iBinder);
    }

    protected String mo1181a() {
        return "com.google.android.gms.clearcut.service.START";
    }

    public void m9709a(lu luVar, LogEventParcelable logEventParcelable) {
        ((lv) m6981u()).mo1558a(luVar, logEventParcelable);
    }

    protected /* synthetic */ IInterface mo1182b(IBinder iBinder) {
        return m9707a(iBinder);
    }

    protected String mo1183b() {
        return "com.google.android.gms.clearcut.internal.IClearcutLoggerService";
    }
}
