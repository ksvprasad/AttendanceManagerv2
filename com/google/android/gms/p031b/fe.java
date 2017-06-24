package com.google.android.gms.p031b;

import android.content.Context;
import com.google.android.gms.ads.internal.C1123e;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.C0971a;
import com.google.android.gms.ads.internal.client.C1120y;
import com.google.android.gms.ads.internal.overlay.C1040p;
import com.google.android.gms.ads.internal.overlay.C1047g;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.p031b.fc.C1494a;
import com.google.android.gms.p031b.lb.C1148a;
import org.json.JSONObject;

@id
public class fe implements fc {
    private final la f4736a;

    public fe(Context context, VersionInfoParcel versionInfoParcel, aj ajVar) {
        this.f4736a = C1319u.m7184f().m9480a(context, new AdSizeParcel(), false, false, ajVar, versionInfoParcel);
        this.f4736a.mo1492a().setWillNotDraw(true);
    }

    private void m8243a(Runnable runnable) {
        if (C1120y.m6293a().m7222b()) {
            runnable.run();
        } else {
            jz.f5567a.post(runnable);
        }
    }

    public void mo1315a() {
        this.f4736a.destroy();
    }

    public void mo1316a(C0971a c0971a, C1047g c1047g, dx dxVar, C1040p c1040p, boolean z, ed edVar, ef efVar, C1123e c1123e, gv gvVar) {
        this.f4736a.mo1519l().m9459a(c0971a, c1047g, dxVar, c1040p, z, edVar, efVar, new C1123e(this.f4736a.getContext(), false), gvVar, null);
    }

    public void mo1317a(final C1494a c1494a) {
        this.f4736a.mo1519l().m9463a(new C1148a(this) {
            final /* synthetic */ fe f4735b;

            public void mo1096a(la laVar, boolean z) {
                c1494a.mo1313a();
            }
        });
    }

    public void mo1318a(String str) {
        final String format = String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[]{str});
        m8243a(new Runnable(this) {
            final /* synthetic */ fe f4729b;

            public void run() {
                this.f4729b.f4736a.loadData(format, "text/html", "UTF-8");
            }
        });
    }

    public void mo1319a(String str, eb ebVar) {
        this.f4736a.mo1519l().m9466a(str, ebVar);
    }

    public void mo1320a(final String str, final String str2) {
        m8243a(new Runnable(this) {
            final /* synthetic */ fe f4727c;

            public void run() {
                this.f4727c.f4736a.mo1320a(str, str2);
            }
        });
    }

    public void mo1321a(final String str, final JSONObject jSONObject) {
        m8243a(new Runnable(this) {
            final /* synthetic */ fe f4724c;

            public void run() {
                this.f4724c.f4736a.mo1321a(str, jSONObject);
            }
        });
    }

    public fh mo1322b() {
        return new fi(this);
    }

    public void mo1323b(final String str) {
        m8243a(new Runnable(this) {
            final /* synthetic */ fe f4733b;

            public void run() {
                this.f4733b.f4736a.loadUrl(str);
            }
        });
    }

    public void mo1324b(String str, eb ebVar) {
        this.f4736a.mo1519l().m9471b(str, ebVar);
    }

    public void mo1325b(String str, JSONObject jSONObject) {
        this.f4736a.mo1325b(str, jSONObject);
    }

    public void mo1326c(final String str) {
        m8243a(new Runnable(this) {
            final /* synthetic */ fe f4731b;

            public void run() {
                this.f4731b.f4736a.loadData(str, "text/html", "UTF-8");
            }
        });
    }
}
