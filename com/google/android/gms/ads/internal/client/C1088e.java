package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.C0957b;
import com.google.android.gms.ads.p036e.C1030a;
import com.google.android.gms.p031b.id;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@id
public final class C1088e {
    public static final String f3162a = C1120y.m6293a().m7211a("emulator");
    private final Date f3163b;
    private final String f3164c;
    private final int f3165d;
    private final Set<String> f3166e;
    private final Location f3167f;
    private final boolean f3168g;
    private final Bundle f3169h;
    private final Map<Class<? extends Object>, Object> f3170i;
    private final String f3171j;
    private final String f3172k;
    private final C1030a f3173l;
    private final int f3174m;
    private final Set<String> f3175n;
    private final Bundle f3176o;
    private final Set<String> f3177p;
    private final boolean f3178q;

    public static final class C1087a {
        private final HashSet<String> f3147a = new HashSet();
        private final Bundle f3148b = new Bundle();
        private final HashMap<Class<? extends Object>, Object> f3149c = new HashMap();
        private final HashSet<String> f3150d = new HashSet();
        private final Bundle f3151e = new Bundle();
        private final HashSet<String> f3152f = new HashSet();
        private Date f3153g;
        private String f3154h;
        private int f3155i = -1;
        private Location f3156j;
        private boolean f3157k = false;
        private String f3158l;
        private String f3159m;
        private int f3160n = -1;
        private boolean f3161o;

        public void m6105a(int i) {
            this.f3155i = i;
        }

        public void m6106a(Location location) {
            this.f3156j = location;
        }

        public void m6107a(Class<? extends C0957b> cls, Bundle bundle) {
            this.f3148b.putBundle(cls.getName(), bundle);
        }

        public void m6108a(String str) {
            this.f3147a.add(str);
        }

        public void m6109a(Date date) {
            this.f3153g = date;
        }

        public void m6110a(boolean z) {
            this.f3160n = z ? 1 : 0;
        }

        public void m6111b(String str) {
            this.f3150d.add(str);
        }

        public void m6112b(boolean z) {
            this.f3161o = z;
        }

        public void m6113c(String str) {
            this.f3150d.remove(str);
        }
    }

    public C1088e(C1087a c1087a) {
        this(c1087a, null);
    }

    public C1088e(C1087a c1087a, C1030a c1030a) {
        this.f3163b = c1087a.f3153g;
        this.f3164c = c1087a.f3154h;
        this.f3165d = c1087a.f3155i;
        this.f3166e = Collections.unmodifiableSet(c1087a.f3147a);
        this.f3167f = c1087a.f3156j;
        this.f3168g = c1087a.f3157k;
        this.f3169h = c1087a.f3148b;
        this.f3170i = Collections.unmodifiableMap(c1087a.f3149c);
        this.f3171j = c1087a.f3158l;
        this.f3172k = c1087a.f3159m;
        this.f3173l = c1030a;
        this.f3174m = c1087a.f3160n;
        this.f3175n = Collections.unmodifiableSet(c1087a.f3150d);
        this.f3176o = c1087a.f3151e;
        this.f3177p = Collections.unmodifiableSet(c1087a.f3152f);
        this.f3178q = c1087a.f3161o;
    }

    public Bundle m6114a(Class<? extends C0957b> cls) {
        return this.f3169h.getBundle(cls.getName());
    }

    public Date m6115a() {
        return this.f3163b;
    }

    public boolean m6116a(Context context) {
        return this.f3175n.contains(C1120y.m6293a().m7210a(context));
    }

    public String m6117b() {
        return this.f3164c;
    }

    public int m6118c() {
        return this.f3165d;
    }

    public Set<String> m6119d() {
        return this.f3166e;
    }

    public Location m6120e() {
        return this.f3167f;
    }

    public boolean m6121f() {
        return this.f3168g;
    }

    public String m6122g() {
        return this.f3171j;
    }

    public String m6123h() {
        return this.f3172k;
    }

    public C1030a m6124i() {
        return this.f3173l;
    }

    public Map<Class<? extends Object>, Object> m6125j() {
        return this.f3170i;
    }

    public Bundle m6126k() {
        return this.f3169h;
    }

    public int m6127l() {
        return this.f3174m;
    }

    public Bundle m6128m() {
        return this.f3176o;
    }

    public Set<String> m6129n() {
        return this.f3177p;
    }

    public boolean m6130o() {
        return this.f3178q;
    }
}
