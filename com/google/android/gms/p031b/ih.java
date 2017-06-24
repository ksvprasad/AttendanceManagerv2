package com.google.android.gms.p031b;

import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.ff.C1519c;
import java.util.Map;
import java.util.concurrent.Future;

@id
public final class ih {
    C1519c f5192a;
    public final eb f5193b = new C16061(this);
    public final eb f5194c = new C16072(this);
    public final eb f5195d = new C16083(this);
    private final Object f5196e = new Object();
    private String f5197f;
    private String f5198g;
    private kn<ik> f5199h = new kn();

    class C16061 implements eb {
        final /* synthetic */ ih f5189a;

        C16061(ih ihVar) {
            this.f5189a = ihVar;
        }

        public void mo997a(la laVar, Map<String, String> map) {
            synchronized (this.f5189a.f5196e) {
                if (this.f5189a.f5199h.isDone()) {
                } else if (this.f5189a.f5197f.equals(map.get("request_id"))) {
                    Object ikVar = new ik(1, map);
                    String valueOf = String.valueOf(ikVar.m8958e());
                    String valueOf2 = String.valueOf(ikVar.m8955b());
                    C1324b.m7234d(new StringBuilder((String.valueOf(valueOf).length() + 24) + String.valueOf(valueOf2).length()).append("Invalid ").append(valueOf).append(" request error: ").append(valueOf2).toString());
                    this.f5189a.f5199h.m8236b(ikVar);
                }
            }
        }
    }

    class C16072 implements eb {
        final /* synthetic */ ih f5190a;

        C16072(ih ihVar) {
            this.f5190a = ihVar;
        }

        public void mo997a(la laVar, Map<String, String> map) {
            synchronized (this.f5190a.f5196e) {
                if (this.f5190a.f5199h.isDone()) {
                    return;
                }
                Object ikVar = new ik(-2, map);
                if (this.f5190a.f5197f.equals(ikVar.m8960g())) {
                    String d = ikVar.m8957d();
                    if (d == null) {
                        C1324b.m7234d("URL missing in loadAdUrl GMSG.");
                        return;
                    }
                    if (d.contains("%40mediation_adapters%40")) {
                        String replaceAll = d.replaceAll("%40mediation_adapters%40", jt.m9148a(laVar.getContext(), (String) map.get("check_adapters"), this.f5190a.f5198g));
                        ikVar.m8954a(replaceAll);
                        d = "Ad request URL modified to ";
                        replaceAll = String.valueOf(replaceAll);
                        jv.m9152e(replaceAll.length() != 0 ? d.concat(replaceAll) : new String(d));
                    }
                    this.f5190a.f5199h.m8236b(ikVar);
                    return;
                }
            }
        }
    }

    class C16083 implements eb {
        final /* synthetic */ ih f5191a;

        C16083(ih ihVar) {
            this.f5191a = ihVar;
        }

        public void mo997a(la laVar, Map<String, String> map) {
            synchronized (this.f5191a.f5196e) {
                if (this.f5191a.f5199h.isDone()) {
                    return;
                }
                Object ikVar = new ik(-2, map);
                if (this.f5191a.f5197f.equals(ikVar.m8960g())) {
                    ikVar.m8961h();
                    this.f5191a.f5199h.m8236b(ikVar);
                    return;
                }
            }
        }
    }

    public ih(String str, String str2) {
        this.f5198g = str2;
        this.f5197f = str;
    }

    public C1519c m8911a() {
        return this.f5192a;
    }

    public void m8912a(C1519c c1519c) {
        this.f5192a = c1519c;
    }

    public Future<ik> m8913b() {
        return this.f5199h;
    }

    public void m8914c() {
    }
}
