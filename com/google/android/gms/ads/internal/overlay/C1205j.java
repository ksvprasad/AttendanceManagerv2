package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.google.android.gms.common.util.C1979l;
import com.google.android.gms.p031b.cw;
import com.google.android.gms.p031b.cy;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p031b.la;

@id
public abstract class C1205j {
    public abstract C1191i mo1153a(Context context, la laVar, int i, boolean z, cy cyVar, cw cwVar);

    protected boolean m6693a(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return C1979l.m11110d() && (applicationInfo == null || applicationInfo.targetSdkVersion >= 11);
    }

    protected boolean m6694a(la laVar) {
        return laVar.mo1518k().f3107e;
    }
}
