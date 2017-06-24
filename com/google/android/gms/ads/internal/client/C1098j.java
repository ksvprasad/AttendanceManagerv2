package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.client.ag.C1039a;
import com.google.android.gms.ads.internal.reward.client.C1301d;
import com.google.android.gms.ads.internal.util.client.C1323a;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.dc;
import com.google.android.gms.p031b.hd;
import com.google.android.gms.p031b.hh;
import com.google.android.gms.p033a.C0998a;

public class C1098j extends C1039a {
    private ac f3220a;

    class C10971 implements Runnable {
        final /* synthetic */ C1098j f3219a;

        C10971(C1098j c1098j) {
            this.f3219a = c1098j;
        }

        public void run() {
            if (this.f3219a.f3220a != null) {
                try {
                    this.f3219a.f3220a.mo1007a(1);
                } catch (Throwable e) {
                    C1324b.m7235d("Could not notify onAdFailedToLoad event.", e);
                }
            }
        }
    }

    public C0998a mo948a() {
        return null;
    }

    public void mo949a(AdSizeParcel adSizeParcel) {
    }

    public void mo950a(VideoOptionsParcel videoOptionsParcel) {
    }

    public void mo951a(ab abVar) {
    }

    public void mo952a(ac acVar) {
        this.f3220a = acVar;
    }

    public void mo953a(ai aiVar) {
    }

    public void mo954a(ak akVar) {
    }

    public void mo955a(C1301d c1301d) {
    }

    public void mo956a(dc dcVar) {
    }

    public void mo957a(hd hdVar) {
    }

    public void mo958a(hh hhVar, String str) {
    }

    public void mo960a(String str) {
    }

    public void mo963a(boolean z) {
    }

    public boolean mo964a(AdRequestParcel adRequestParcel) {
        C1324b.m7230b("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        C1323a.f3964a.post(new C10971(this));
        return false;
    }

    public void mo965b() {
    }

    public boolean mo967c() {
        return false;
    }

    public void c_() {
    }

    public void mo969d() {
    }

    public void mo986f() {
    }

    public void g_() {
    }

    public void mo971h() {
    }

    public AdSizeParcel mo972i() {
        return null;
    }

    public String mo989j() {
        return null;
    }

    public boolean mo973k() {
        return false;
    }

    public C1081c mo974l() {
        return null;
    }
}
