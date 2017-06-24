package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.hc.C1228a;
import com.google.android.gms.p031b.id;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@id
public class C1229d extends C1228a {
    private String f3637a;
    private Context f3638b;
    private String f3639c;
    private ArrayList<String> f3640d;

    public C1229d(String str, ArrayList<String> arrayList, Context context, String str2) {
        this.f3639c = str;
        this.f3640d = arrayList;
        this.f3637a = str2;
        this.f3638b = context;
    }

    protected int m6812a(int i) {
        return i == 0 ? 1 : i == 1 ? 2 : i == 4 ? 3 : 0;
    }

    public String mo1162a() {
        return this.f3639c;
    }

    Map<String, String> m6814b() {
        String packageName = this.f3638b.getPackageName();
        Object obj = "";
        try {
            obj = this.f3638b.getPackageManager().getPackageInfo(packageName, 0).versionName;
        } catch (Throwable e) {
            C1324b.m7235d("Error to retrieve app version", e);
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - C1319u.m7186h().m9125d().m9140a();
        Map<String, String> hashMap = new HashMap();
        hashMap.put("sessionid", C1319u.m7186h().m9107a());
        hashMap.put("appid", packageName);
        hashMap.put("osversion", String.valueOf(VERSION.SDK_INT));
        hashMap.put("sdkversion", this.f3637a);
        hashMap.put("appversion", obj);
        hashMap.put("timestamp", String.valueOf(elapsedRealtime));
        return hashMap;
    }

    public void mo1163b(int i) {
        if (i == 1) {
            m6816c();
        }
        Map b = m6814b();
        b.put("status", String.valueOf(i));
        b.put("sku", this.f3639c);
        List linkedList = new LinkedList();
        Iterator it = this.f3640d.iterator();
        while (it.hasNext()) {
            linkedList.add(C1319u.m7183e().m9208a((String) it.next(), b));
        }
        C1319u.m7183e().m9218a(this.f3638b, this.f3637a, linkedList);
    }

    void m6816c() {
        try {
            this.f3638b.getClassLoader().loadClass("com.google.ads.conversiontracking.IAPConversionReporter").getDeclaredMethod("reportWithProductId", new Class[]{Context.class, String.class, String.class, Boolean.TYPE}).invoke(null, new Object[]{this.f3638b, this.f3639c, "", Boolean.valueOf(true)});
        } catch (ClassNotFoundException e) {
            C1324b.m7234d("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (NoSuchMethodException e2) {
            C1324b.m7234d("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (Throwable e3) {
            C1324b.m7235d("Fail to report a conversion.", e3);
        }
    }

    public void mo1164c(int i) {
        if (i == 0) {
            m6816c();
        }
        Map b = m6814b();
        b.put("google_play_status", String.valueOf(i));
        b.put("sku", this.f3639c);
        b.put("status", String.valueOf(m6812a(i)));
        List linkedList = new LinkedList();
        Iterator it = this.f3640d.iterator();
        while (it.hasNext()) {
            linkedList.add(C1319u.m7183e().m9208a((String) it.next(), b));
        }
        C1319u.m7183e().m9218a(this.f3638b, this.f3637a, linkedList);
    }
}
