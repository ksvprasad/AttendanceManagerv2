package com.google.android.gms.p031b;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.C1319u;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@id
public class cy {
    boolean f4435a;
    private final List<cw> f4436b = new LinkedList();
    private final Map<String, String> f4437c = new LinkedHashMap();
    private final Object f4438d = new Object();
    private String f4439e;
    private cw f4440f;
    private cy f4441g;

    public cy(boolean z, String str, String str2) {
        this.f4435a = z;
        this.f4437c.put("action", str);
        this.f4437c.put("ad_format", str2);
    }

    public cw m7861a() {
        return m7862a(C1319u.m7187i().mo1724b());
    }

    public cw m7862a(long j) {
        return !this.f4435a ? null : new cw(j, null, null);
    }

    public void m7863a(cy cyVar) {
        synchronized (this.f4438d) {
            this.f4441g = cyVar;
        }
    }

    public void m7864a(String str) {
        if (this.f4435a) {
            synchronized (this.f4438d) {
                this.f4439e = str;
            }
        }
    }

    public void m7865a(String str, String str2) {
        if (this.f4435a && !TextUtils.isEmpty(str2)) {
            cs e = C1319u.m7186h().m9126e();
            if (e != null) {
                synchronized (this.f4438d) {
                    e.m7839a(str).m7850a(this.f4437c, str, str2);
                }
            }
        }
    }

    public boolean m7866a(cw cwVar, long j, String... strArr) {
        synchronized (this.f4438d) {
            for (String cwVar2 : strArr) {
                this.f4436b.add(new cw(j, cwVar2, cwVar));
            }
        }
        return true;
    }

    public boolean m7867a(cw cwVar, String... strArr) {
        return (!this.f4435a || cwVar == null) ? false : m7866a(cwVar, C1319u.m7187i().mo1724b(), strArr);
    }

    public void m7868b() {
        synchronized (this.f4438d) {
            this.f4440f = m7861a();
        }
    }

    public String m7869c() {
        String stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        synchronized (this.f4438d) {
            for (cw cwVar : this.f4436b) {
                long a = cwVar.m7855a();
                String b = cwVar.m7856b();
                cw cwVar2 = cwVar2.m7857c();
                if (cwVar2 != null && a > 0) {
                    stringBuilder2.append(b).append('.').append(a - cwVar2.m7855a()).append(',');
                }
            }
            this.f4436b.clear();
            if (!TextUtils.isEmpty(this.f4439e)) {
                stringBuilder2.append(this.f4439e);
            } else if (stringBuilder2.length() > 0) {
                stringBuilder2.setLength(stringBuilder2.length() - 1);
            }
            stringBuilder = stringBuilder2.toString();
        }
        return stringBuilder;
    }

    Map<String, String> m7870d() {
        Map<String, String> map;
        synchronized (this.f4438d) {
            cs e = C1319u.m7186h().m9126e();
            if (e == null || this.f4441g == null) {
                map = this.f4437c;
            } else {
                map = e.m7841a(this.f4437c, this.f4441g.m7870d());
            }
        }
        return map;
    }

    public cw m7871e() {
        cw cwVar;
        synchronized (this.f4438d) {
            cwVar = this.f4440f;
        }
        return cwVar;
    }
}
