package com.google.android.gms.p031b;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.p031b.ff.C1519c;
import com.google.android.gms.p031b.kt.C1161c;
import com.google.android.gms.p031b.kt.C1261a;
import com.google.android.gms.p031b.kt.C1687b;
import org.json.JSONException;
import org.json.JSONObject;

@id
public class bw extends bq {
    private C1519c f4271d;
    private boolean f4272e;

    class C13882 implements C1261a {
        final /* synthetic */ bw f4265a;

        C13882(bw bwVar) {
            this.f4265a = bwVar;
        }

        public void mo1175a() {
        }
    }

    class C13893 implements C1161c<fg> {
        final /* synthetic */ bw f4266a;

        C13893(bw bwVar) {
            this.f4266a = bwVar;
        }

        public void m7673a(fg fgVar) {
            this.f4266a.f4272e = true;
            this.f4266a.m7626a(fgVar);
            this.f4266a.m7621a();
            this.f4266a.m7622a(3);
        }

        public /* synthetic */ void mo1101a(Object obj) {
            m7673a((fg) obj);
        }
    }

    class C13904 implements C1261a {
        final /* synthetic */ bw f4267a;

        C13904(bw bwVar) {
            this.f4267a = bwVar;
        }

        public void mo1175a() {
            this.f4267a.mo1262c();
        }
    }

    class C13926 implements C1161c<fg> {
        final /* synthetic */ bw f4270a;

        C13926(bw bwVar) {
            this.f4270a = bwVar;
        }

        public void m7678a(fg fgVar) {
            this.f4270a.m7631b(fgVar);
        }

        public /* synthetic */ void mo1101a(Object obj) {
            m7678a((fg) obj);
        }
    }

    public bw(Context context, AdSizeParcel adSizeParcel, jl jlVar, VersionInfoParcel versionInfoParcel, bx bxVar, ff ffVar) {
        super(context, adSizeParcel, jlVar, versionInfoParcel, bxVar);
        this.f4271d = ffVar.m8299a();
        try {
            final JSONObject a = m7620a(bxVar.mo1259c().mo1257a());
            this.f4271d.mo1327a(new C1161c<fg>(this) {
                final /* synthetic */ bw f4264b;

                public void m7670a(fg fgVar) {
                    this.f4264b.m7627a(a);
                }

                public /* synthetic */ void mo1101a(Object obj) {
                    m7670a((fg) obj);
                }
            }, new C13882(this));
        } catch (JSONException e) {
        } catch (Throwable e2) {
            C1324b.m7231b("Failure while processing active view data.", e2);
        }
        this.f4271d.mo1327a(new C13893(this), new C13904(this));
        String str = "Tracking ad unit: ";
        String valueOf = String.valueOf(this.b.m7651d());
        C1324b.m7227a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    protected void mo1261b(final JSONObject jSONObject) {
        this.f4271d.mo1327a(new C1161c<fg>(this) {
            final /* synthetic */ bw f4269b;

            public void m7676a(fg fgVar) {
                fgVar.mo1321a("AFMA_updateActiveView", jSONObject);
            }

            public /* synthetic */ void mo1101a(Object obj) {
                m7676a((fg) obj);
            }
        }, new C1687b());
    }

    protected void mo1262c() {
        synchronized (this.a) {
            super.mo1262c();
            this.f4271d.mo1327a(new C13926(this), new C1687b());
            this.f4271d.h_();
        }
    }

    protected boolean mo1264j() {
        return this.f4272e;
    }
}
