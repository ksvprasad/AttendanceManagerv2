package com.google.android.gms.p031b;

import android.content.Context;
import android.os.Build.VERSION;
import com.google.android.gms.ads.internal.C1319u;
import java.util.LinkedHashMap;
import java.util.Map;

@id
public class cr {
    private boolean f4412a;
    private String f4413b;
    private Map<String, String> f4414c;
    private Context f4415d = null;
    private String f4416e = null;

    public cr(Context context, String str) {
        this.f4415d = context;
        this.f4416e = str;
        this.f4412a = ((Boolean) cq.f4367H.m7801c()).booleanValue();
        this.f4413b = (String) cq.f4368I.m7801c();
        this.f4414c = new LinkedHashMap();
        this.f4414c.put("s", "gmob_sdk");
        this.f4414c.put("v", "3");
        this.f4414c.put("os", VERSION.RELEASE);
        this.f4414c.put("sdk", VERSION.SDK);
        this.f4414c.put("device", C1319u.m7183e().m9246e());
        this.f4414c.put("app", context.getApplicationContext() != null ? context.getApplicationContext().getPackageName() : context.getPackageName());
        this.f4414c.put("is_lite_sdk", C1319u.m7183e().m9257l(context) ? "1" : "0");
        il a = C1319u.m7189k().m8970a(this.f4415d);
        this.f4414c.put("network_coarse", Integer.toString(a.f5282m));
        this.f4414c.put("network_fine", Integer.toString(a.f5283n));
    }

    boolean m7830a() {
        return this.f4412a;
    }

    String m7831b() {
        return this.f4413b;
    }

    Context m7832c() {
        return this.f4415d;
    }

    String m7833d() {
        return this.f4416e;
    }

    Map<String, String> m7834e() {
        return this.f4414c;
    }
}
