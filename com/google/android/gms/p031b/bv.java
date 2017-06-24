package com.google.android.gms.p031b;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import org.json.JSONObject;

@id
public class bv extends bq {
    private final fg f4262d;

    public bv(Context context, AdSizeParcel adSizeParcel, jl jlVar, VersionInfoParcel versionInfoParcel, bx bxVar, fg fgVar) {
        super(context, adSizeParcel, jlVar, versionInfoParcel, bxVar);
        this.f4262d = fgVar;
        m7626a(this.f4262d);
        m7621a();
        m7622a(3);
        String str = "Tracking ad unit: ";
        String valueOf = String.valueOf(this.b.m7651d());
        C1324b.m7227a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    protected void mo1261b(JSONObject jSONObject) {
        this.f4262d.mo1321a("AFMA_updateActiveView", jSONObject);
    }

    protected void mo1262c() {
        synchronized (this.a) {
            super.mo1262c();
            m7631b(this.f4262d);
        }
    }

    public void mo1263d() {
        mo1262c();
    }

    protected boolean mo1264j() {
        return true;
    }
}
