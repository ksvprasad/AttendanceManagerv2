package com.google.android.gms.p031b;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.C1324b;

@id
public class jp {
    long f5501a = -1;
    long f5502b = -1;
    int f5503c = -1;
    final String f5504d;
    int f5505e = 0;
    int f5506f = 0;
    private final Object f5507g = new Object();

    public jp(String str) {
        this.f5504d = str;
    }

    public static boolean m9139a(Context context) {
        int identifier = context.getResources().getIdentifier("Theme.Translucent", "style", "android");
        if (identifier == 0) {
            C1324b.m7232c("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        try {
            if (identifier == context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.google.android.gms.ads.AdActivity"), 0).theme) {
                return true;
            }
            C1324b.m7232c("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (NameNotFoundException e) {
            C1324b.m7234d("Fail to fetch AdActivity theme");
            C1324b.m7232c("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }

    public long m9140a() {
        return this.f5502b;
    }

    public Bundle m9141a(Context context, String str) {
        Bundle bundle;
        synchronized (this.f5507g) {
            bundle = new Bundle();
            bundle.putString("session_id", this.f5504d);
            bundle.putLong("basets", this.f5502b);
            bundle.putLong("currts", this.f5501a);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.f5503c);
            bundle.putInt("pclick", this.f5505e);
            bundle.putInt("pimp", this.f5506f);
            bundle.putBoolean("support_transparent_background", jp.m9139a(context));
        }
        return bundle;
    }

    public void m9142a(AdRequestParcel adRequestParcel, long j) {
        synchronized (this.f5507g) {
            if (this.f5502b == -1) {
                this.f5502b = j;
                this.f5501a = this.f5502b;
            } else {
                this.f5501a = j;
            }
            if (adRequestParcel.f3087c == null || adRequestParcel.f3087c.getInt("gw", 2) != 1) {
                this.f5503c++;
                return;
            }
        }
    }

    public void m9143b() {
        synchronized (this.f5507g) {
            this.f5505e++;
        }
    }

    public void m9144c() {
        synchronized (this.f5507g) {
            this.f5506f++;
        }
    }
}
