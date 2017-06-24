package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.p031b.id;
import java.util.ArrayList;
import java.util.List;

@id
public final class C1106r {
    private long f3224a;
    private Bundle f3225b;
    private int f3226c;
    private List<String> f3227d;
    private boolean f3228e;
    private int f3229f;
    private boolean f3230g;
    private String f3231h;
    private SearchAdRequestParcel f3232i;
    private Location f3233j;
    private String f3234k;
    private Bundle f3235l;
    private Bundle f3236m;
    private List<String> f3237n;
    private String f3238o;
    private String f3239p;
    private boolean f3240q;

    public C1106r() {
        this.f3224a = -1;
        this.f3225b = new Bundle();
        this.f3226c = -1;
        this.f3227d = new ArrayList();
        this.f3228e = false;
        this.f3229f = -1;
        this.f3230g = false;
        this.f3231h = null;
        this.f3232i = null;
        this.f3233j = null;
        this.f3234k = null;
        this.f3235l = new Bundle();
        this.f3236m = new Bundle();
        this.f3237n = new ArrayList();
        this.f3238o = null;
        this.f3239p = null;
        this.f3240q = false;
    }

    public C1106r(AdRequestParcel adRequestParcel) {
        this.f3224a = adRequestParcel.f3086b;
        this.f3225b = adRequestParcel.f3087c;
        this.f3226c = adRequestParcel.f3088d;
        this.f3227d = adRequestParcel.f3089e;
        this.f3228e = adRequestParcel.f3090f;
        this.f3229f = adRequestParcel.f3091g;
        this.f3230g = adRequestParcel.f3092h;
        this.f3231h = adRequestParcel.f3093i;
        this.f3232i = adRequestParcel.f3094j;
        this.f3233j = adRequestParcel.f3095k;
        this.f3234k = adRequestParcel.f3096l;
        this.f3235l = adRequestParcel.f3097m;
        this.f3236m = adRequestParcel.f3098n;
        this.f3237n = adRequestParcel.f3099o;
        this.f3238o = adRequestParcel.f3100p;
        this.f3239p = adRequestParcel.f3101q;
    }

    public AdRequestParcel m6234a() {
        return new AdRequestParcel(7, this.f3224a, this.f3225b, this.f3226c, this.f3227d, this.f3228e, this.f3229f, this.f3230g, this.f3231h, this.f3232i, this.f3233j, this.f3234k, this.f3235l, this.f3236m, this.f3237n, this.f3238o, this.f3239p, false);
    }

    public C1106r m6235a(Location location) {
        this.f3233j = location;
        return this;
    }

    public C1106r m6236a(Bundle bundle) {
        this.f3235l = bundle;
        return this;
    }
}
