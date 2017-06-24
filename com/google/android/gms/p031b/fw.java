package com.google.android.gms.p031b;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.C0978c;
import com.google.ads.mediation.C0988h;
import com.google.ads.mediation.C0994i;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.mediation.C0957b;
import com.google.android.gms.ads.mediation.customevent.C1339a;
import com.google.android.gms.ads.mediation.customevent.C1341d;
import com.google.android.gms.ads.mediation.customevent.CustomEventAdapter;
import com.google.android.gms.p031b.fx.C1534a;
import java.util.Map;

@id
public final class fw extends C1534a {
    private Map<Class<? extends Object>, Object> f4889a;

    private <NETWORK_EXTRAS extends C0994i, SERVER_PARAMETERS extends C0988h> fy m8389c(String str) {
        try {
            Class cls = Class.forName(str, false, fw.class.getClassLoader());
            if (C0978c.class.isAssignableFrom(cls)) {
                C0978c c0978c = (C0978c) cls.newInstance();
                return new gj(c0978c, (C0994i) this.f4889a.get(c0978c.mo921b()));
            } else if (C0957b.class.isAssignableFrom(cls)) {
                return new ge((C0957b) cls.newInstance());
            } else {
                C1324b.m7234d(new StringBuilder(String.valueOf(str).length() + 64).append("Could not instantiate mediation adapter: ").append(str).append(" (not a valid adapter).").toString());
                throw new RemoteException();
            }
        } catch (Throwable th) {
            return m8390d(str);
        }
    }

    private fy m8390d(String str) {
        try {
            C1324b.m7227a("Reflection failed, retrying using direct instantiation");
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                return new ge(new AdMobAdapter());
            }
            if ("com.google.ads.mediation.AdUrlAdapter".equals(str)) {
                return new ge(new AdUrlAdapter());
            }
            if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
                return new ge(new CustomEventAdapter());
            }
            if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
                C0978c customEventAdapter = new com.google.ads.mediation.customevent.CustomEventAdapter();
                return new gj(customEventAdapter, (C1341d) this.f4889a.get(customEventAdapter.mo921b()));
            }
            throw new RemoteException();
        } catch (Throwable th) {
            C1324b.m7235d(new StringBuilder(String.valueOf(str).length() + 43).append("Could not instantiate mediation adapter: ").append(str).append(". ").toString(), th);
        }
    }

    public fy mo1347a(String str) {
        return m8389c(str);
    }

    public void m8392a(Map<Class<? extends Object>, Object> map) {
        this.f4889a = map;
    }

    public boolean mo1348b(String str) {
        boolean z = false;
        try {
            z = C1339a.class.isAssignableFrom(Class.forName(str, false, fw.class.getClassLoader()));
        } catch (Throwable th) {
            C1324b.m7234d(new StringBuilder(String.valueOf(str).length() + 80).append("Could not load custom event implementation class: ").append(str).append(", assuming old implementation.").toString());
        }
        return z;
    }
}
