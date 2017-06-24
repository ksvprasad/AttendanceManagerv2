package com.google.android.gms.p031b;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.client.C1120y;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.gs.C1559a;
import java.util.Map;

@id
public class gt extends gu implements eb {
    DisplayMetrics f4994a;
    int f4995b = -1;
    int f4996c = -1;
    int f4997d = -1;
    int f4998e = -1;
    int f4999f = -1;
    int f5000g = -1;
    private final la f5001h;
    private final Context f5002i;
    private final WindowManager f5003j;
    private final ch f5004k;
    private float f5005l;
    private int f5006m;

    public gt(la laVar, Context context, ch chVar) {
        super(laVar);
        this.f5001h = laVar;
        this.f5002i = context;
        this.f5004k = chVar;
        this.f5003j = (WindowManager) context.getSystemService("window");
    }

    private void m8673g() {
        this.f4994a = new DisplayMetrics();
        Display defaultDisplay = this.f5003j.getDefaultDisplay();
        defaultDisplay.getMetrics(this.f4994a);
        this.f5005l = this.f4994a.density;
        this.f5006m = defaultDisplay.getRotation();
    }

    private void m8674h() {
        int[] iArr = new int[2];
        this.f5001h.getLocationOnScreen(iArr);
        m8677a(C1120y.m6293a().m7220b(this.f5002i, iArr[0]), C1120y.m6293a().m7220b(this.f5002i, iArr[1]));
    }

    private gs m8675i() {
        return new C1559a().m8668b(this.f5004k.m7783a()).m8666a(this.f5004k.m7785b()).m8669c(this.f5004k.m7788f()).m8670d(this.f5004k.m7786c()).m8671e(this.f5004k.m7787d()).m8667a();
    }

    void m8676a() {
        this.f4995b = C1120y.m6293a().m7221b(this.f4994a, this.f4994a.widthPixels);
        this.f4996c = C1120y.m6293a().m7221b(this.f4994a, this.f4994a.heightPixels);
        Activity f = this.f5001h.mo1513f();
        if (f == null || f.getWindow() == null) {
            this.f4997d = this.f4995b;
            this.f4998e = this.f4996c;
            return;
        }
        int[] a = C1319u.m7183e().m9230a(f);
        this.f4997d = C1120y.m6293a().m7221b(this.f4994a, a[0]);
        this.f4998e = C1120y.m6293a().m7221b(this.f4994a, a[1]);
    }

    public void m8677a(int i, int i2) {
        m8635b(i, i2 - (this.f5002i instanceof Activity ? C1319u.m7183e().m9244d((Activity) this.f5002i)[0] : 0), this.f4999f, this.f5000g);
        this.f5001h.mo1519l().m9456a(i, i2);
    }

    public void mo997a(la laVar, Map<String, String> map) {
        m8680c();
    }

    void m8679b() {
        if (this.f5001h.mo1518k().f3107e) {
            this.f4999f = this.f4995b;
            this.f5000g = this.f4996c;
            return;
        }
        this.f5001h.measure(0, 0);
        this.f4999f = C1120y.m6293a().m7220b(this.f5002i, this.f5001h.getMeasuredWidth());
        this.f5000g = C1120y.m6293a().m7220b(this.f5002i, this.f5001h.getMeasuredHeight());
    }

    public void m8680c() {
        m8673g();
        m8676a();
        m8679b();
        m8682e();
        m8683f();
        m8674h();
        m8681d();
    }

    void m8681d() {
        if (C1324b.m7229a(2)) {
            C1324b.m7232c("Dispatching Ready Event.");
        }
        m8637c(this.f5001h.mo1525o().f3957b);
    }

    void m8682e() {
        m8634a(this.f4995b, this.f4996c, this.f4997d, this.f4998e, this.f5005l, this.f5006m);
    }

    void m8683f() {
        this.f5001h.mo1325b("onDeviceFeaturesReceived", m8675i().m8672a());
    }
}
