package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.p031b.ne;

public final class C1867e {
    public static C1713d<Status> m10587a(Status status) {
        C1896c.m10791a((Object) status, (Object) "Result must not be null");
        C1713d neVar = new ne(Looper.getMainLooper());
        neVar.m9647b((C1857g) status);
        return neVar;
    }
}
