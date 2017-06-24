package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel.C1249a;
import com.google.android.gms.ads.internal.request.C1251a.C1041a;
import com.google.android.gms.ads.internal.util.client.C1323a;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.p035c.C1025a;
import com.google.android.gms.ads.p035c.C1025a.C1023a;
import com.google.android.gms.common.C1878c;
import com.google.android.gms.common.C1880d;
import com.google.android.gms.p031b.ci;
import com.google.android.gms.p031b.cq;
import com.google.android.gms.p031b.eb;
import com.google.android.gms.p031b.ec;
import com.google.android.gms.p031b.eg;
import com.google.android.gms.p031b.fc;
import com.google.android.gms.p031b.ff;
import com.google.android.gms.p031b.ff.C1519c;
import com.google.android.gms.p031b.fg;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p031b.ig;
import com.google.android.gms.p031b.jl.C1632a;
import com.google.android.gms.p031b.ju;
import com.google.android.gms.p031b.kd;
import com.google.android.gms.p031b.kt.C1161c;
import com.google.android.gms.p031b.kt.C1261a;
import com.google.android.gms.p031b.la;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

@id
public class C1290n extends ju {
    static final long f3886a = TimeUnit.SECONDS.toMillis(10);
    static boolean f3887b = false;
    private static final Object f3888c = new Object();
    private static ff f3889d = null;
    private static ec f3890e = null;
    private static eg f3891f = null;
    private static eb f3892g = null;
    private final C1041a f3893h;
    private final C1249a f3894i;
    private final Object f3895j = new Object();
    private final Context f3896k;
    private C1519c f3897l;

    class C12863 implements Runnable {
        final /* synthetic */ C1290n f3885a;

        C12863(C1290n c1290n) {
            this.f3885a = c1290n;
        }

        public void run() {
            if (this.f3885a.f3897l != null) {
                this.f3885a.f3897l.h_();
                this.f3885a.f3897l = null;
            }
        }
    }

    public static class C1287a implements kd<fc> {
        public void m7016a(fc fcVar) {
            C1290n.m7027b(fcVar);
        }

        public /* synthetic */ void mo1187a(Object obj) {
            m7016a((fc) obj);
        }
    }

    public static class C1288b implements kd<fc> {
        public void m7018a(fc fcVar) {
            C1290n.m7025a(fcVar);
        }

        public /* synthetic */ void mo1187a(Object obj) {
            m7018a((fc) obj);
        }
    }

    public static class C1289c implements eb {
        public void mo997a(la laVar, Map<String, String> map) {
            String str = (String) map.get("request_id");
            String str2 = "Invalid request: ";
            String valueOf = String.valueOf((String) map.get("errors"));
            C1324b.m7234d(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            C1290n.f3891f.m8029b(str);
        }
    }

    public C1290n(Context context, C1249a c1249a, C1041a c1041a) {
        super(true);
        this.f3893h = c1041a;
        this.f3896k = context;
        this.f3894i = c1249a;
        synchronized (f3888c) {
            if (!f3887b) {
                f3891f = new eg();
                f3890e = new ec(context.getApplicationContext(), c1249a.f3707j);
                f3892g = new C1289c();
                f3889d = new ff(this.f3896k.getApplicationContext(), this.f3894i.f3707j, (String) cq.f4387b.m7801c(), new C1288b(), new C1287a());
                f3887b = true;
            }
        }
    }

    private AdResponseParcel m7021a(AdRequestInfoParcel adRequestInfoParcel) {
        final String c = C1319u.m7183e().m9238c();
        final JSONObject a = m7024a(adRequestInfoParcel, c);
        if (a == null) {
            return new AdResponseParcel(0);
        }
        long b = C1319u.m7187i().mo1724b();
        Future a2 = f3891f.m8026a(c);
        C1323a.f3964a.post(new Runnable(this) {
            final /* synthetic */ C1290n f3884c;

            class C12831 implements C1161c<fg> {
                final /* synthetic */ C12852 f3880a;

                C12831(C12852 c12852) {
                    this.f3880a = c12852;
                }

                public void m7012a(fg fgVar) {
                    try {
                        fgVar.mo1321a("AFMA_getAdapterLessMediationAd", a);
                    } catch (Throwable e) {
                        C1324b.m7231b("Error requesting an ad url", e);
                        C1290n.f3891f.m8029b(c);
                    }
                }

                public /* synthetic */ void mo1101a(Object obj) {
                    m7012a((fg) obj);
                }
            }

            class C12842 implements C1261a {
                final /* synthetic */ C12852 f3881a;

                C12842(C12852 c12852) {
                    this.f3881a = c12852;
                }

                public void mo1175a() {
                    C1290n.f3891f.m8029b(c);
                }
            }

            public void run() {
                this.f3884c.f3897l = C1290n.f3889d.m8299a();
                this.f3884c.f3897l.mo1327a(new C12831(this), new C12842(this));
            }
        });
        try {
            JSONObject jSONObject = (JSONObject) a2.get(f3886a - (C1319u.m7187i().mo1724b() - b), TimeUnit.MILLISECONDS);
            if (jSONObject == null) {
                return new AdResponseParcel(-1);
            }
            AdResponseParcel a3 = ig.m8891a(this.f3896k, adRequestInfoParcel, jSONObject.toString());
            return (a3.f3783e == -3 || !TextUtils.isEmpty(a3.f3781c)) ? a3 : new AdResponseParcel(3);
        } catch (CancellationException e) {
            return new AdResponseParcel(-1);
        } catch (InterruptedException e2) {
            return new AdResponseParcel(-1);
        } catch (TimeoutException e3) {
            return new AdResponseParcel(2);
        } catch (ExecutionException e4) {
            return new AdResponseParcel(0);
        }
    }

    private JSONObject m7024a(AdRequestInfoParcel adRequestInfoParcel, String str) {
        C1023a b;
        Throwable e;
        Object obj;
        Map hashMap;
        JSONObject jSONObject = null;
        Bundle bundle = adRequestInfoParcel.f3741c.f3087c.getBundle("sdk_less_server_data");
        String string = adRequestInfoParcel.f3741c.f3087c.getString("sdk_less_network_id");
        if (bundle != null) {
            JSONObject a = ig.m8897a(this.f3896k, adRequestInfoParcel, C1319u.m7189k().m8970a(this.f3896k), jSONObject, jSONObject, new ci((String) cq.f4387b.m7801c()), jSONObject, new ArrayList(), jSONObject, jSONObject);
            if (a != null) {
                try {
                    b = C1025a.m5783b(this.f3896k);
                } catch (IOException e2) {
                    e = e2;
                    C1324b.m7235d("Cannot get advertising id info", e);
                    obj = jSONObject;
                    hashMap = new HashMap();
                    hashMap.put("request_id", str);
                    hashMap.put("network_id", string);
                    hashMap.put("request_param", a);
                    hashMap.put("data", bundle);
                    if (b != null) {
                        hashMap.put("adid", b.m5776a());
                        hashMap.put("lat", Integer.valueOf(b.m5777b() ? 0 : 1));
                    }
                    jSONObject = C1319u.m7183e().m9211a(hashMap);
                    return jSONObject;
                } catch (IllegalStateException e3) {
                    e = e3;
                    C1324b.m7235d("Cannot get advertising id info", e);
                    obj = jSONObject;
                    hashMap = new HashMap();
                    hashMap.put("request_id", str);
                    hashMap.put("network_id", string);
                    hashMap.put("request_param", a);
                    hashMap.put("data", bundle);
                    if (b != null) {
                        hashMap.put("adid", b.m5776a());
                        if (b.m5777b()) {
                        }
                        hashMap.put("lat", Integer.valueOf(b.m5777b() ? 0 : 1));
                    }
                    jSONObject = C1319u.m7183e().m9211a(hashMap);
                    return jSONObject;
                } catch (C1878c e4) {
                    e = e4;
                    C1324b.m7235d("Cannot get advertising id info", e);
                    obj = jSONObject;
                    hashMap = new HashMap();
                    hashMap.put("request_id", str);
                    hashMap.put("network_id", string);
                    hashMap.put("request_param", a);
                    hashMap.put("data", bundle);
                    if (b != null) {
                        hashMap.put("adid", b.m5776a());
                        if (b.m5777b()) {
                        }
                        hashMap.put("lat", Integer.valueOf(b.m5777b() ? 0 : 1));
                    }
                    jSONObject = C1319u.m7183e().m9211a(hashMap);
                    return jSONObject;
                } catch (C1880d e5) {
                    e = e5;
                    C1324b.m7235d("Cannot get advertising id info", e);
                    obj = jSONObject;
                    hashMap = new HashMap();
                    hashMap.put("request_id", str);
                    hashMap.put("network_id", string);
                    hashMap.put("request_param", a);
                    hashMap.put("data", bundle);
                    if (b != null) {
                        hashMap.put("adid", b.m5776a());
                        if (b.m5777b()) {
                        }
                        hashMap.put("lat", Integer.valueOf(b.m5777b() ? 0 : 1));
                    }
                    jSONObject = C1319u.m7183e().m9211a(hashMap);
                    return jSONObject;
                }
                hashMap = new HashMap();
                hashMap.put("request_id", str);
                hashMap.put("network_id", string);
                hashMap.put("request_param", a);
                hashMap.put("data", bundle);
                if (b != null) {
                    hashMap.put("adid", b.m5776a());
                    if (b.m5777b()) {
                    }
                    hashMap.put("lat", Integer.valueOf(b.m5777b() ? 0 : 1));
                }
                try {
                    jSONObject = C1319u.m7183e().m9211a(hashMap);
                } catch (JSONException e6) {
                }
            }
        }
        return jSONObject;
    }

    protected static void m7025a(fc fcVar) {
        fcVar.mo1319a("/loadAd", f3891f);
        fcVar.mo1319a("/fetchHttpRequest", f3890e);
        fcVar.mo1319a("/invalidRequest", f3892g);
    }

    protected static void m7027b(fc fcVar) {
        fcVar.mo1324b("/loadAd", f3891f);
        fcVar.mo1324b("/fetchHttpRequest", f3890e);
        fcVar.mo1324b("/invalidRequest", f3892g);
    }

    public void mo1108a() {
        C1324b.m7227a("SdkLessAdLoaderBackgroundTask started.");
        AdRequestInfoParcel adRequestInfoParcel = new AdRequestInfoParcel(this.f3894i, null, -1);
        AdResponseParcel a = m7021a(adRequestInfoParcel);
        AdSizeParcel adSizeParcel = null;
        final C1632a c1632a = new C1632a(adRequestInfoParcel, a, null, adSizeParcel, a.f3783e, C1319u.m7187i().mo1724b(), a.f3792n, null);
        C1323a.f3964a.post(new Runnable(this) {
            final /* synthetic */ C1290n f3879b;

            public void run() {
                this.f3879b.f3893h.mo959a(c1632a);
                if (this.f3879b.f3897l != null) {
                    this.f3879b.f3897l.h_();
                    this.f3879b.f3897l = null;
                }
            }
        });
    }

    public void mo1109b() {
        synchronized (this.f3895j) {
            C1323a.f3964a.post(new C12863(this));
        }
    }
}
