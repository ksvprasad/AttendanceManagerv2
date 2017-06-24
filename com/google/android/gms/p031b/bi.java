package com.google.android.gms.p031b;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import com.google.android.gms.p033a.C0998a;
import com.google.android.gms.p033a.C1001b;

public final class bi {
    private final bn f4201a;

    public bi(String str, Context context, boolean z) {
        this.f4201a = bl.m7570a(str, context, z);
    }

    public Uri m7543a(Uri uri, Context context) {
        C0998a a = this.f4201a.mo1240a(C1001b.m5713a((Object) uri), C1001b.m5713a((Object) context));
        if (a != null) {
            return (Uri) C1001b.m5714a(a);
        }
        throw new bj();
    }

    public void m7544a(MotionEvent motionEvent) {
        this.f4201a.mo1250d(C1001b.m5713a((Object) motionEvent));
    }

    public Uri m7545b(Uri uri, Context context) {
        C0998a b = this.f4201a.mo1247b(C1001b.m5713a((Object) uri), C1001b.m5713a((Object) context));
        if (b != null) {
            return (Uri) C1001b.m5714a(b);
        }
        throw new bj();
    }
}
