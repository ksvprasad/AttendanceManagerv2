package com.google.android.gms.p031b;

import android.content.Context;
import com.google.firebase.C2112a;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class C1689l {
    private static final AtomicReference<C1689l> f5670a = new AtomicReference();

    C1689l(Context context) {
    }

    public static C1689l m9393a() {
        return (C1689l) f5670a.get();
    }

    public static C1689l m9394a(Context context) {
        f5670a.compareAndSet(null, new C1689l(context));
        return (C1689l) f5670a.get();
    }

    public void m9395a(C2112a c2112a) {
    }

    public Set<String> m9396b() {
        return Collections.emptySet();
    }
}
