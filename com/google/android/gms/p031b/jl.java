package com.google.android.gms.p031b;

import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.C1142h.C1136a;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.AutoClickProtectionConfigurationParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

@id
public class jl {
    public final long f5416A;
    public final long f5417B;
    public final String f5418C;
    public final C1136a f5419D;
    public boolean f5420E;
    public boolean f5421F;
    public final List<String> f5422G;
    public final AdRequestParcel f5423a;
    public final la f5424b;
    public final List<String> f5425c;
    public final int f5426d;
    public final List<String> f5427e;
    public final List<String> f5428f;
    public final int f5429g;
    public final long f5430h;
    public final String f5431i;
    public final JSONObject f5432j;
    public final boolean f5433k;
    public final AutoClickProtectionConfigurationParcel f5434l;
    public boolean f5435m;
    public final boolean f5436n;
    public final fm f5437o;
    public final fy f5438p;
    public final String f5439q;
    public final fo f5440r;
    public final fq f5441s;
    public final long f5442t;
    public final String f5443u;
    public final AdSizeParcel f5444v;
    public final long f5445w;
    public final RewardItemParcel f5446x;
    public final List<String> f5447y;
    public final List<String> f5448z;

    @id
    public static final class C1632a {
        public final AdRequestInfoParcel f5408a;
        public final AdResponseParcel f5409b;
        public final fo f5410c;
        public final AdSizeParcel f5411d;
        public final int f5412e;
        public final long f5413f;
        public final long f5414g;
        public final JSONObject f5415h;

        public C1632a(AdRequestInfoParcel adRequestInfoParcel, AdResponseParcel adResponseParcel, fo foVar, AdSizeParcel adSizeParcel, int i, long j, long j2, JSONObject jSONObject) {
            this.f5408a = adRequestInfoParcel;
            this.f5409b = adResponseParcel;
            this.f5410c = foVar;
            this.f5411d = adSizeParcel;
            this.f5412e = i;
            this.f5413f = j;
            this.f5414g = j2;
            this.f5415h = jSONObject;
        }
    }

    public jl(AdRequestParcel adRequestParcel, la laVar, List<String> list, int i, List<String> list2, List<String> list3, int i2, long j, String str, boolean z, fm fmVar, fy fyVar, String str2, fo foVar, fq fqVar, long j2, AdSizeParcel adSizeParcel, long j3, long j4, long j5, String str3, JSONObject jSONObject, C1136a c1136a, RewardItemParcel rewardItemParcel, List<String> list4, List<String> list5, boolean z2, AutoClickProtectionConfigurationParcel autoClickProtectionConfigurationParcel, String str4, List<String> list6) {
        this.f5420E = false;
        this.f5421F = false;
        this.f5423a = adRequestParcel;
        this.f5424b = laVar;
        this.f5425c = jl.m9082a(list);
        this.f5426d = i;
        this.f5427e = jl.m9082a(list2);
        this.f5428f = jl.m9082a(list3);
        this.f5429g = i2;
        this.f5430h = j;
        this.f5431i = str;
        this.f5436n = z;
        this.f5437o = fmVar;
        this.f5438p = fyVar;
        this.f5439q = str2;
        this.f5440r = foVar;
        this.f5441s = fqVar;
        this.f5442t = j2;
        this.f5444v = adSizeParcel;
        this.f5445w = j3;
        this.f5416A = j4;
        this.f5417B = j5;
        this.f5418C = str3;
        this.f5432j = jSONObject;
        this.f5419D = c1136a;
        this.f5446x = rewardItemParcel;
        this.f5447y = jl.m9082a(list4);
        this.f5448z = jl.m9082a(list5);
        this.f5433k = z2;
        this.f5434l = autoClickProtectionConfigurationParcel;
        this.f5443u = str4;
        this.f5422G = jl.m9082a(list6);
    }

    public jl(C1632a c1632a, la laVar, fm fmVar, fy fyVar, String str, fq fqVar, C1136a c1136a, String str2) {
        this(c1632a.f5408a.f3741c, laVar, c1632a.f5409b.f3782d, c1632a.f5412e, c1632a.f5409b.f3784f, c1632a.f5409b.f3788j, c1632a.f5409b.f3790l, c1632a.f5409b.f3789k, c1632a.f5408a.f3747i, c1632a.f5409b.f3786h, fmVar, fyVar, str, c1632a.f5410c, fqVar, c1632a.f5409b.f3787i, c1632a.f5411d, c1632a.f5409b.f3785g, c1632a.f5413f, c1632a.f5414g, c1632a.f5409b.f3793o, c1632a.f5415h, c1136a, c1632a.f5409b.f3767C, c1632a.f5409b.f3768D, c1632a.f5409b.f3768D, c1632a.f5409b.f3770F, c1632a.f5409b.f3771G, str2, c1632a.f5409b.f3774J);
    }

    private static <T> List<T> m9082a(List<T> list) {
        return list == null ? null : Collections.unmodifiableList(list);
    }

    public boolean m9083a() {
        return (this.f5424b == null || this.f5424b.mo1519l() == null) ? false : this.f5424b.mo1519l().m9472b();
    }
}
