package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.p036e.C1030a;
import com.google.android.gms.p031b.id;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@id
public class C1108t {
    public static final C1108t f3241a = new C1108t();

    protected C1108t() {
    }

    public static C1108t m6240a() {
        return f3241a;
    }

    public AdRequestParcel m6241a(Context context, C1088e c1088e) {
        Date a = c1088e.m6115a();
        long time = a != null ? a.getTime() : -1;
        String b = c1088e.m6117b();
        int c = c1088e.m6118c();
        Collection d = c1088e.m6119d();
        List unmodifiableList = !d.isEmpty() ? Collections.unmodifiableList(new ArrayList(d)) : null;
        boolean a2 = c1088e.m6116a(context);
        int l = c1088e.m6127l();
        Location e = c1088e.m6120e();
        Bundle a3 = c1088e.m6114a(AdMobAdapter.class);
        boolean f = c1088e.m6121f();
        String g = c1088e.m6122g();
        C1030a i = c1088e.m6124i();
        SearchAdRequestParcel searchAdRequestParcel = i != null ? new SearchAdRequestParcel(i) : null;
        String str = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            str = C1120y.m6293a().m7213a(Thread.currentThread().getStackTrace(), applicationContext.getPackageName());
        }
        return new AdRequestParcel(7, time, a3, c, unmodifiableList, a2, l, f, g, searchAdRequestParcel, e, b, c1088e.m6126k(), c1088e.m6128m(), Collections.unmodifiableList(new ArrayList(c1088e.m6129n())), c1088e.m6123h(), str, c1088e.m6130o());
    }
}
