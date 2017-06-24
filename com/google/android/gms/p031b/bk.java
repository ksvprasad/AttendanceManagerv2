package com.google.android.gms.p031b;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import com.google.android.gms.ads.p035c.C1025a.C1023a;
import com.google.android.gms.p031b.bn.C1372a;
import com.google.android.gms.p033a.C0998a;
import com.google.android.gms.p033a.C1001b;

public final class bk extends C1372a {
    private final ai f4202a;
    private final aj f4203b;
    private final C1840q f4204c;
    private boolean f4205d = false;

    public bk(String str, Context context, boolean z) {
        this.f4202a = ai.m7426a(str, context, z);
        this.f4203b = new aj(this.f4202a);
        this.f4204c = z ? null : C1840q.m10372d(context);
    }

    private C0998a m7558a(C0998a c0998a, C0998a c0998a2, boolean z) {
        try {
            Uri uri = (Uri) C1001b.m5714a(c0998a);
            Context context = (Context) C1001b.m5714a(c0998a2);
            return C1001b.m5713a(z ? this.f4203b.m7431a(uri, context) : this.f4203b.m7437b(uri, context));
        } catch (ak e) {
            return null;
        }
    }

    public C0998a mo1240a(C0998a c0998a, C0998a c0998a2) {
        return m7558a(c0998a, c0998a2, true);
    }

    public String mo1241a() {
        return "ms";
    }

    public String mo1242a(C0998a c0998a, String str) {
        return this.f4202a.mo1103a((Context) C1001b.m5714a(c0998a), str);
    }

    public void mo1243a(String str) {
        this.f4203b.m7434a(str);
    }

    public void mo1244a(String str, String str2) {
        this.f4203b.m7435a(str, str2);
    }

    public boolean mo1245a(C0998a c0998a) {
        return this.f4203b.m7436a((Uri) C1001b.m5714a(c0998a));
    }

    public boolean mo1246a(String str, boolean z) {
        if (this.f4204c == null) {
            return false;
        }
        this.f4204c.m10374a(new C1023a(str, z));
        this.f4205d = true;
        return true;
    }

    public C0998a mo1247b(C0998a c0998a, C0998a c0998a2) {
        return m7558a(c0998a, c0998a2, false);
    }

    public boolean mo1248b(C0998a c0998a) {
        return this.f4203b.m7439c((Uri) C1001b.m5714a(c0998a));
    }

    public String mo1249c(C0998a c0998a) {
        Context context = (Context) C1001b.m5714a(c0998a);
        String a = this.f4202a.mo1102a(context);
        if (this.f4204c == null || !this.f4205d) {
            return a;
        }
        String a2 = this.f4204c.m10373a(a, this.f4204c.mo1102a(context));
        this.f4205d = false;
        return a2;
    }

    public void mo1250d(C0998a c0998a) {
        this.f4203b.m7433a((MotionEvent) C1001b.m5714a(c0998a));
    }
}
