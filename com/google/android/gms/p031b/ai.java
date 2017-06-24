package com.google.android.gms.p031b;

import android.content.Context;
import com.google.android.gms.p031b.C1493f.C1487a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class ai extends ae {
    private static final String f4121p = ai.class.getSimpleName();

    protected ai(Context context, String str, boolean z) {
        super(context, str, z);
    }

    public static ai m7426a(String str, Context context, boolean z) {
        ae.m7414a(context, z);
        return new ai(context, str, z);
    }

    protected List<Callable<Void>> mo1238b(ao aoVar, C1487a c1487a) {
        if (aoVar.m7496b() == null || !this.i) {
            return super.mo1238b(aoVar, c1487a);
        }
        int p = aoVar.m7510p();
        List<Callable<Void>> arrayList = new ArrayList();
        arrayList.addAll(super.mo1238b(aoVar, c1487a));
        arrayList.add(new az(aoVar, am.m7468p(), am.m7469q(), c1487a, p, 24));
        return arrayList;
    }
}
