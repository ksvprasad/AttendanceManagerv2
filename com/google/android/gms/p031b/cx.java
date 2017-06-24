package com.google.android.gms.p031b;

import java.util.HashMap;
import java.util.Map;

@id
public class cx {
    private final Map<String, cw> f4433a = new HashMap();
    private final cy f4434b;

    public cx(cy cyVar) {
        this.f4434b = cyVar;
    }

    public cy m7858a() {
        return this.f4434b;
    }

    public void m7859a(String str, cw cwVar) {
        this.f4433a.put(str, cwVar);
    }

    public void m7860a(String str, String str2, long j) {
        cu.m7847a(this.f4434b, (cw) this.f4433a.get(str2), j, str);
        this.f4433a.put(str, cu.m7846a(this.f4434b, j));
    }
}
