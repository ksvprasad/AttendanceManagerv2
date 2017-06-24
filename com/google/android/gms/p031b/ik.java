package com.google.android.gms.p031b;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@id
class ik {
    private final List<String> f5232a;
    private final List<String> f5233b;
    private final String f5234c;
    private final String f5235d;
    private final String f5236e;
    private final String f5237f;
    private final boolean f5238g;
    private final boolean f5239h;
    private final String f5240i;
    private final String f5241j;
    private String f5242k;
    private int f5243l;

    public ik(int i, Map<String, String> map) {
        this.f5242k = (String) map.get("url");
        this.f5235d = (String) map.get("base_uri");
        this.f5236e = (String) map.get("post_parameters");
        this.f5238g = ik.m8951b((String) map.get("drt_include"));
        this.f5239h = ik.m8951b((String) map.get("pan_include"));
        this.f5234c = (String) map.get("activation_overlay_url");
        this.f5233b = m8952c((String) map.get("check_packages"));
        this.f5240i = (String) map.get("request_id");
        this.f5237f = (String) map.get("type");
        this.f5232a = m8952c((String) map.get("errors"));
        this.f5243l = i;
        this.f5241j = (String) map.get("fetched_ad");
    }

    private static boolean m8951b(String str) {
        return str != null && (str.equals("1") || str.equals("true"));
    }

    private List<String> m8952c(String str) {
        return str == null ? null : Arrays.asList(str.split(","));
    }

    public int m8953a() {
        return this.f5243l;
    }

    public void m8954a(String str) {
        this.f5242k = str;
    }

    public List<String> m8955b() {
        return this.f5232a;
    }

    public String m8956c() {
        return this.f5236e;
    }

    public String m8957d() {
        return this.f5242k;
    }

    public String m8958e() {
        return this.f5237f;
    }

    public boolean m8959f() {
        return this.f5238g;
    }

    public String m8960g() {
        return this.f5240i;
    }

    public String m8961h() {
        return this.f5241j;
    }
}
