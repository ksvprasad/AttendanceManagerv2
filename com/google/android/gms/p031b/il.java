package com.google.android.gms.p031b;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.client.C1120y;
import com.google.android.gms.common.util.C1973f;
import java.util.Locale;

@id
public final class il {
    public final int f5270a;
    public final boolean f5271b;
    public final boolean f5272c;
    public final String f5273d;
    public final String f5274e;
    public final boolean f5275f;
    public final boolean f5276g;
    public final boolean f5277h;
    public final boolean f5278i;
    public final String f5279j;
    public final String f5280k;
    public final int f5281l;
    public final int f5282m;
    public final int f5283n;
    public final int f5284o;
    public final int f5285p;
    public final int f5286q;
    public final float f5287r;
    public final int f5288s;
    public final int f5289t;
    public final double f5290u;
    public final boolean f5291v;
    public final boolean f5292w;
    public final int f5293x;
    public final String f5294y;
    public final boolean f5295z;

    public static final class C1609a {
        private int f5244a;
        private boolean f5245b;
        private boolean f5246c;
        private int f5247d;
        private int f5248e;
        private int f5249f;
        private String f5250g;
        private int f5251h;
        private int f5252i;
        private int f5253j;
        private boolean f5254k;
        private int f5255l;
        private double f5256m;
        private boolean f5257n;
        private String f5258o;
        private boolean f5259p;
        private boolean f5260q;
        private String f5261r;
        private boolean f5262s;
        private boolean f5263t;
        private String f5264u;
        private String f5265v;
        private float f5266w;
        private int f5267x;
        private int f5268y;
        private boolean f5269z;

        public C1609a(Context context) {
            boolean z = true;
            PackageManager packageManager = context.getPackageManager();
            m8964a(context);
            m8965a(context, packageManager);
            m8966b(context);
            Locale locale = Locale.getDefault();
            this.f5259p = C1609a.m8962a(packageManager, "geo:0,0?q=donuts") != null;
            if (C1609a.m8962a(packageManager, "http://www.google.com") == null) {
                z = false;
            }
            this.f5260q = z;
            this.f5261r = locale.getCountry();
            this.f5262s = C1120y.m6293a().m7219a();
            this.f5263t = C1973f.m11093b(context);
            this.f5264u = locale.getLanguage();
            this.f5265v = C1609a.m8963a(packageManager);
            Resources resources = context.getResources();
            if (resources != null) {
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                if (displayMetrics != null) {
                    this.f5266w = displayMetrics.density;
                    this.f5267x = displayMetrics.widthPixels;
                    this.f5268y = displayMetrics.heightPixels;
                }
            }
        }

        public C1609a(Context context, il ilVar) {
            PackageManager packageManager = context.getPackageManager();
            m8964a(context);
            m8965a(context, packageManager);
            m8966b(context);
            m8967c(context);
            this.f5259p = ilVar.f5271b;
            this.f5260q = ilVar.f5272c;
            this.f5261r = ilVar.f5274e;
            this.f5262s = ilVar.f5275f;
            this.f5263t = ilVar.f5276g;
            this.f5264u = ilVar.f5279j;
            this.f5265v = ilVar.f5280k;
            this.f5266w = ilVar.f5287r;
            this.f5267x = ilVar.f5288s;
            this.f5268y = ilVar.f5289t;
        }

        private static ResolveInfo m8962a(PackageManager packageManager, String str) {
            return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
        }

        private static String m8963a(PackageManager packageManager) {
            String str = null;
            ResolveInfo a = C1609a.m8962a(packageManager, "market://details?id=com.google.android.gms.ads");
            if (a != null) {
                ActivityInfo activityInfo = a.activityInfo;
                if (activityInfo != null) {
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(activityInfo.packageName, 0);
                        if (packageInfo != null) {
                            int i = packageInfo.versionCode;
                            String valueOf = String.valueOf(activityInfo.packageName);
                            str = new StringBuilder(String.valueOf(valueOf).length() + 12).append(i).append(".").append(valueOf).toString();
                        }
                    } catch (NameNotFoundException e) {
                    }
                }
            }
            return str;
        }

        private void m8964a(Context context) {
            AudioManager i = C1319u.m7183e().m9253i(context);
            if (i != null) {
                try {
                    this.f5244a = i.getMode();
                    this.f5245b = i.isMusicActive();
                    this.f5246c = i.isSpeakerphoneOn();
                    this.f5247d = i.getStreamVolume(3);
                    this.f5248e = i.getRingerMode();
                    this.f5249f = i.getStreamVolume(2);
                    return;
                } catch (Throwable th) {
                    C1319u.m7186h().m9117a(th, true);
                }
            }
            this.f5244a = -2;
            this.f5245b = false;
            this.f5246c = false;
            this.f5247d = 0;
            this.f5248e = 0;
            this.f5249f = 0;
        }

        @TargetApi(16)
        private void m8965a(Context context, PackageManager packageManager) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            this.f5250g = telephonyManager.getNetworkOperator();
            this.f5252i = telephonyManager.getNetworkType();
            this.f5253j = telephonyManager.getPhoneType();
            this.f5251h = -2;
            this.f5254k = false;
            this.f5255l = -1;
            if (C1319u.m7183e().m9226a(packageManager, context.getPackageName(), "android.permission.ACCESS_NETWORK_STATE")) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    this.f5251h = activeNetworkInfo.getType();
                    this.f5255l = activeNetworkInfo.getDetailedState().ordinal();
                } else {
                    this.f5251h = -1;
                }
                if (VERSION.SDK_INT >= 16) {
                    this.f5254k = connectivityManager.isActiveNetworkMetered();
                }
            }
        }

        private void m8966b(Context context) {
            boolean z = false;
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                int intExtra = registerReceiver.getIntExtra("status", -1);
                this.f5256m = (double) (((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
                if (intExtra == 2 || intExtra == 5) {
                    z = true;
                }
                this.f5257n = z;
                return;
            }
            this.f5256m = -1.0d;
            this.f5257n = false;
        }

        private void m8967c(Context context) {
            this.f5258o = Build.FINGERPRINT;
            this.f5269z = de.m7894a(context);
        }

        public il m8968a() {
            return new il(this.f5244a, this.f5259p, this.f5260q, this.f5250g, this.f5261r, this.f5262s, this.f5263t, this.f5245b, this.f5246c, this.f5264u, this.f5265v, this.f5247d, this.f5251h, this.f5252i, this.f5253j, this.f5248e, this.f5249f, this.f5266w, this.f5267x, this.f5268y, this.f5256m, this.f5257n, this.f5254k, this.f5255l, this.f5258o, this.f5269z);
        }
    }

    il(int i, boolean z, boolean z2, String str, String str2, boolean z3, boolean z4, boolean z5, boolean z6, String str3, String str4, int i2, int i3, int i4, int i5, int i6, int i7, float f, int i8, int i9, double d, boolean z7, boolean z8, int i10, String str5, boolean z9) {
        this.f5270a = i;
        this.f5271b = z;
        this.f5272c = z2;
        this.f5273d = str;
        this.f5274e = str2;
        this.f5275f = z3;
        this.f5276g = z4;
        this.f5277h = z5;
        this.f5278i = z6;
        this.f5279j = str3;
        this.f5280k = str4;
        this.f5281l = i2;
        this.f5282m = i3;
        this.f5283n = i4;
        this.f5284o = i5;
        this.f5285p = i6;
        this.f5286q = i7;
        this.f5287r = f;
        this.f5288s = i8;
        this.f5289t = i9;
        this.f5290u = d;
        this.f5291v = z7;
        this.f5292w = z8;
        this.f5293x = i10;
        this.f5294y = str5;
        this.f5295z = z9;
    }
}
