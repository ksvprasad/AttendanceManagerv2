package com.google.android.gms.p031b;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.p035c.C1025a.C1023a;
import com.google.android.gms.p031b.C1493f.C1487a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class C1840q extends ae {
    private static final String f6250p = C1840q.class.getSimpleName();
    private C1023a f6251q;

    protected C1840q(Context context) {
        super(context, "");
    }

    public static C1840q m10372d(Context context) {
        ae.m7414a(context, true);
        return new C1840q(context);
    }

    public String m10373a(String str, String str2) {
        return C1597i.m8849a(str, str2, true);
    }

    public void m10374a(C1023a c1023a) {
        this.f6251q = c1023a;
    }

    protected void mo1641a(ao aoVar, C1487a c1487a) {
        if (!aoVar.m7501g()) {
            m7418a(mo1238b(aoVar, c1487a));
        } else if (this.f6251q != null) {
            String a = this.f6251q.m5776a();
            if (!TextUtils.isEmpty(a)) {
                c1487a.f4650O = ap.m7511a(a);
                c1487a.f4651P = Integer.valueOf(5);
                c1487a.f4652Q = Boolean.valueOf(this.f6251q.m5777b());
            }
            this.f6251q = null;
        }
    }

    protected List<Callable<Void>> mo1238b(ao aoVar, C1487a c1487a) {
        List<Callable<Void>> arrayList = new ArrayList();
        if (aoVar.m7496b() == null) {
            return arrayList;
        }
        ao aoVar2 = aoVar;
        arrayList.add(new az(aoVar2, am.m7468p(), am.m7469q(), c1487a, aoVar.m7510p(), 24));
        return arrayList;
    }

    protected C1487a mo1237c(Context context) {
        return null;
    }
}
