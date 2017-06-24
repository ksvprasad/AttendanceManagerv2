package com.google.android.gms.p031b;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.C1271l;
import com.google.android.gms.ads.internal.request.C1277k.C1279a;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.p031b.ff.C1515b;
import com.google.android.gms.p031b.ff.C1519c;
import com.google.android.gms.p031b.ip.C1611a;
import com.google.android.gms.p031b.kt.C1161c;
import com.google.android.gms.p031b.kt.C1261a;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

@id
public final class C1605if extends C1279a {
    private static final Object f5182a = new Object();
    private static C1605if f5183b;
    private final Context f5184c;
    private final ie f5185d;
    private final ci f5186e;
    private final ff f5187f;

    class C15981 implements Callable<Void> {
        final /* synthetic */ ie f5162a;
        final /* synthetic */ Context f5163b;
        final /* synthetic */ AdRequestInfoParcel f5164c;
        final /* synthetic */ Bundle f5165d;

        C15981(ie ieVar, Context context, AdRequestInfoParcel adRequestInfoParcel, Bundle bundle) {
            this.f5162a = ieVar;
            this.f5163b = context;
            this.f5164c = adRequestInfoParcel;
            this.f5165d = bundle;
        }

        public Void m8877a() {
            this.f5162a.f5161h.m8950a(this.f5163b, this.f5164c.f3745g.packageName, this.f5165d);
            return null;
        }

        public /* synthetic */ Object call() {
            return m8877a();
        }
    }

    class C16012 implements Runnable {
        final /* synthetic */ ff f5169a;
        final /* synthetic */ ih f5170b;
        final /* synthetic */ cy f5171c;
        final /* synthetic */ cw f5172d;
        final /* synthetic */ String f5173e;

        class C16002 implements C1261a {
            final /* synthetic */ C16012 f5168a;

            C16002(C16012 c16012) {
                this.f5168a = c16012;
            }

            public void mo1175a() {
            }
        }

        C16012(ff ffVar, ih ihVar, cy cyVar, cw cwVar, String str) {
            this.f5169a = ffVar;
            this.f5170b = ihVar;
            this.f5171c = cyVar;
            this.f5172d = cwVar;
            this.f5173e = str;
        }

        public void run() {
            C1519c a = this.f5169a.m8299a();
            this.f5170b.m8912a(a);
            this.f5171c.m7867a(this.f5172d, "rwc");
            final cw a2 = this.f5171c.m7861a();
            a.mo1327a(new C1161c<fg>(this) {
                final /* synthetic */ C16012 f5167b;

                public void m8878a(fg fgVar) {
                    this.f5167b.f5171c.m7867a(a2, "jsf");
                    this.f5167b.f5171c.m7868b();
                    fgVar.mo1319a("/invalidRequest", this.f5167b.f5170b.f5193b);
                    fgVar.mo1319a("/loadAdURL", this.f5167b.f5170b.f5194c);
                    fgVar.mo1319a("/loadAd", this.f5167b.f5170b.f5195d);
                    try {
                        fgVar.mo1320a("AFMA_getAd", this.f5167b.f5173e);
                    } catch (Throwable e) {
                        C1324b.m7231b("Error requesting an ad url", e);
                    }
                }

                public /* synthetic */ void mo1101a(Object obj) {
                    m8878a((fg) obj);
                }
            }, new C16002(this));
        }
    }

    class C16023 implements Runnable {
        final /* synthetic */ ie f5174a;
        final /* synthetic */ Context f5175b;
        final /* synthetic */ ih f5176c;
        final /* synthetic */ AdRequestInfoParcel f5177d;

        C16023(ie ieVar, Context context, ih ihVar, AdRequestInfoParcel adRequestInfoParcel) {
            this.f5174a = ieVar;
            this.f5175b = context;
            this.f5176c = ihVar;
            this.f5177d = adRequestInfoParcel;
        }

        public void run() {
            this.f5174a.f5156c.mo1444a(this.f5175b, this.f5176c, this.f5177d.f3749k);
        }
    }

    class C16034 implements kd<fc> {
        final /* synthetic */ C1605if f5178a;

        C16034(C1605if c1605if) {
            this.f5178a = c1605if;
        }

        public void m8881a(fc fcVar) {
            fcVar.mo1319a("/log", ea.f4501i);
        }

        public /* synthetic */ void mo1187a(Object obj) {
            m8881a((fc) obj);
        }
    }

    C1605if(Context context, ci ciVar, ie ieVar) {
        this.f5184c = context;
        this.f5185d = ieVar;
        this.f5186e = ciVar;
        this.f5187f = new ff(context.getApplicationContext() != null ? context.getApplicationContext() : context, new VersionInfoParcel(9452208, 9452208, true), ciVar.m7789a(), new C16034(this), new C1515b());
    }

    private static Location m8883a(kq<Location> kqVar) {
        try {
            return (Location) kqVar.get(((Long) cq.bs.m7801c()).longValue(), TimeUnit.MILLISECONDS);
        } catch (Throwable e) {
            C1324b.m7235d("Exception caught while getting location", e);
            return null;
        }
    }

    private static AdResponseParcel m8884a(Context context, ff ffVar, ci ciVar, ie ieVar, AdRequestInfoParcel adRequestInfoParcel) {
        Bundle bundle;
        Future future;
        Throwable e;
        C1324b.m7227a("Starting ad request from service using: AFMA_getAd");
        cq.m7828a(context);
        cy cyVar = new cy(((Boolean) cq.f4367H.m7801c()).booleanValue(), "load_ad", adRequestInfoParcel.f3742d.f3104b);
        if (adRequestInfoParcel.f3739a > 10 && adRequestInfoParcel.f3725B != -1) {
            cyVar.m7867a(cyVar.m7862a(adRequestInfoParcel.f3725B), "cts");
        }
        cw a = cyVar.m7861a();
        Bundle bundle2 = (adRequestInfoParcel.f3739a < 4 || adRequestInfoParcel.f3753o == null) ? null : adRequestInfoParcel.f3753o;
        if (!((Boolean) cq.f4376Q.m7801c()).booleanValue() || ieVar.f5161h == null) {
            bundle = bundle2;
            future = null;
        } else {
            if (bundle2 == null && ((Boolean) cq.f4377R.m7801c()).booleanValue()) {
                jv.m9152e("contentInfo is not present, but we'll still launch the app index task");
                bundle2 = new Bundle();
            }
            if (bundle2 != null) {
                bundle = bundle2;
                future = jy.m9181a(new C15981(ieVar, context, adRequestInfoParcel, bundle2));
            } else {
                bundle = bundle2;
                future = null;
            }
        }
        ko koVar = new ko(null);
        Bundle bundle3 = adRequestInfoParcel.f3741c.f3087c;
        Object obj = (bundle3 == null || bundle3.getString("_ad") == null) ? null : 1;
        if (adRequestInfoParcel.f3732I && obj == null) {
            kq a2 = ieVar.f5157d.mo1332a(adRequestInfoParcel.f3744f);
        } else {
            Object obj2 = koVar;
        }
        il a3 = C1319u.m7189k().m8970a(context);
        if (a3.f5282m == -1) {
            C1324b.m7227a("Device is offline.");
            return new AdResponseParcel(2);
        }
        String uuid = adRequestInfoParcel.f3739a >= 7 ? adRequestInfoParcel.f3761w : UUID.randomUUID().toString();
        ih ihVar = new ih(uuid, adRequestInfoParcel.f3744f.packageName);
        if (adRequestInfoParcel.f3741c.f3087c != null) {
            String string = adRequestInfoParcel.f3741c.f3087c.getString("_ad");
            if (string != null) {
                return ig.m8891a(context, adRequestInfoParcel, string);
            }
        }
        List a4 = ieVar.f5155b.mo1269a(adRequestInfoParcel);
        String a5 = ieVar.f5158e.mo1461a(adRequestInfoParcel);
        C1611a a6 = ieVar.f5159f.mo1447a(context);
        if (future != null) {
            try {
                jv.m9152e("Waiting for app index fetching task.");
                future.get(((Long) cq.f4378S.m7801c()).longValue(), TimeUnit.MILLISECONDS);
                jv.m9152e("App index fetching task completed.");
            } catch (ExecutionException e2) {
                e = e2;
                C1324b.m7235d("Failed to fetch app index signal", e);
            } catch (InterruptedException e3) {
                e = e3;
                C1324b.m7235d("Failed to fetch app index signal", e);
            } catch (TimeoutException e4) {
                C1324b.m7227a("Timed out waiting for app index fetching task");
            }
        }
        String a7 = ieVar.f5154a.mo1460a(adRequestInfoParcel.f3745g.packageName);
        JSONObject a8 = ig.m8897a(context, adRequestInfoParcel, a3, a6, C1605if.m8883a(a2), ciVar, a5, a4, bundle, a7);
        if (a8 == null) {
            return new AdResponseParcel(0);
        }
        if (adRequestInfoParcel.f3739a < 7) {
            try {
                a8.put("request_id", uuid);
            } catch (JSONException e5) {
            }
        }
        try {
            a8.put("prefetch_mode", "url");
        } catch (Throwable e6) {
            C1324b.m7235d("Failed putting prefetch parameters to ad request.", e6);
        }
        String jSONObject = a8.toString();
        cyVar.m7867a(a, "arc");
        jz.f5567a.post(new C16012(ffVar, ihVar, cyVar, cyVar.m7861a(), jSONObject));
        AdResponseParcel adResponseParcel;
        try {
            ik ikVar = (ik) ihVar.m8913b().get(10, TimeUnit.SECONDS);
            if (ikVar == null) {
                adResponseParcel = new AdResponseParcel(0);
                return adResponseParcel;
            } else if (ikVar.m8953a() != -2) {
                adResponseParcel = new AdResponseParcel(ikVar.m8953a());
                jz.f5567a.post(new C16023(ieVar, context, ihVar, adRequestInfoParcel));
                return adResponseParcel;
            } else {
                if (cyVar.m7871e() != null) {
                    cyVar.m7867a(cyVar.m7871e(), "rur");
                }
                adResponseParcel = null;
                if (!TextUtils.isEmpty(ikVar.m8961h())) {
                    adResponseParcel = ig.m8891a(context, adRequestInfoParcel, ikVar.m8961h());
                }
                if (adResponseParcel == null && !TextUtils.isEmpty(ikVar.m8957d())) {
                    adResponseParcel = C1605if.m8885a(adRequestInfoParcel, context, adRequestInfoParcel.f3749k.f3957b, ikVar.m8957d(), a7, ikVar, cyVar, ieVar);
                }
                if (adResponseParcel == null) {
                    adResponseParcel = new AdResponseParcel(0);
                }
                cyVar.m7867a(a, "tts");
                adResponseParcel.f3803y = cyVar.m7869c();
                jz.f5567a.post(new C16023(ieVar, context, ihVar, adRequestInfoParcel));
                return adResponseParcel;
            }
        } catch (Exception e7) {
            adResponseParcel = new AdResponseParcel(0);
            return adResponseParcel;
        } finally {
            jz.f5567a.post(new C16023(ieVar, context, ihVar, adRequestInfoParcel));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.ads.internal.request.AdResponseParcel m8885a(com.google.android.gms.ads.internal.request.AdRequestInfoParcel r13, android.content.Context r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, com.google.android.gms.p031b.ik r18, com.google.android.gms.p031b.cy r19, com.google.android.gms.p031b.ie r20) {
        /*
        if (r19 == 0) goto L_0x00e9;
    L_0x0002:
        r2 = r19.m7861a();
        r3 = r2;
    L_0x0007:
        r8 = new com.google.android.gms.b.ii;	 Catch:{ IOException -> 0x00f4 }
        r8.<init>(r13);	 Catch:{ IOException -> 0x00f4 }
        r4 = "AdRequestServiceImpl: Sending request: ";
        r2 = java.lang.String.valueOf(r16);	 Catch:{ IOException -> 0x00f4 }
        r5 = r2.length();	 Catch:{ IOException -> 0x00f4 }
        if (r5 == 0) goto L_0x00ed;
    L_0x0018:
        r2 = r4.concat(r2);	 Catch:{ IOException -> 0x00f4 }
    L_0x001c:
        com.google.android.gms.ads.internal.util.client.C1324b.m7227a(r2);	 Catch:{ IOException -> 0x00f4 }
        r4 = new java.net.URL;	 Catch:{ IOException -> 0x00f4 }
        r0 = r16;
        r4.<init>(r0);	 Catch:{ IOException -> 0x00f4 }
        r2 = 0;
        r5 = com.google.android.gms.ads.internal.C1319u.m7187i();	 Catch:{ IOException -> 0x00f4 }
        r10 = r5.mo1724b();	 Catch:{ IOException -> 0x00f4 }
        r6 = r2;
        r7 = r4;
    L_0x0031:
        if (r20 == 0) goto L_0x003a;
    L_0x0033:
        r0 = r20;
        r2 = r0.f5160g;	 Catch:{ IOException -> 0x00f4 }
        r2.mo1445a();	 Catch:{ IOException -> 0x00f4 }
    L_0x003a:
        r2 = r7.openConnection();	 Catch:{ IOException -> 0x00f4 }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ IOException -> 0x00f4 }
        r4 = com.google.android.gms.ads.internal.C1319u.m7183e();	 Catch:{ all -> 0x0119 }
        r5 = 0;
        r4.m9219a(r14, r15, r5, r2);	 Catch:{ all -> 0x0119 }
        r4 = android.text.TextUtils.isEmpty(r17);	 Catch:{ all -> 0x0119 }
        if (r4 != 0) goto L_0x005b;
    L_0x004e:
        r4 = r18.m8959f();	 Catch:{ all -> 0x0119 }
        if (r4 == 0) goto L_0x005b;
    L_0x0054:
        r4 = "x-afma-drt-cookie";
        r0 = r17;
        r2.addRequestProperty(r4, r0);	 Catch:{ all -> 0x0119 }
    L_0x005b:
        r4 = r13.f3733J;	 Catch:{ all -> 0x0119 }
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x0119 }
        if (r5 != 0) goto L_0x006d;
    L_0x0063:
        r5 = "Sending webview cookie in ad request header.";
        com.google.android.gms.ads.internal.util.client.C1324b.m7227a(r5);	 Catch:{ all -> 0x0119 }
        r5 = "Cookie";
        r2.addRequestProperty(r5, r4);	 Catch:{ all -> 0x0119 }
    L_0x006d:
        if (r18 == 0) goto L_0x0099;
    L_0x006f:
        r4 = r18.m8956c();	 Catch:{ all -> 0x0119 }
        r4 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x0119 }
        if (r4 != 0) goto L_0x0099;
    L_0x0079:
        r4 = 1;
        r2.setDoOutput(r4);	 Catch:{ all -> 0x0119 }
        r4 = r18.m8956c();	 Catch:{ all -> 0x0119 }
        r9 = r4.getBytes();	 Catch:{ all -> 0x0119 }
        r4 = r9.length;	 Catch:{ all -> 0x0119 }
        r2.setFixedLengthStreamingMode(r4);	 Catch:{ all -> 0x0119 }
        r5 = 0;
        r4 = new java.io.BufferedOutputStream;	 Catch:{ all -> 0x0113 }
        r12 = r2.getOutputStream();	 Catch:{ all -> 0x0113 }
        r4.<init>(r12);	 Catch:{ all -> 0x0113 }
        r4.write(r9);	 Catch:{ all -> 0x01d0 }
        com.google.android.gms.common.util.C1977j.m11102a(r4);	 Catch:{ all -> 0x0119 }
    L_0x0099:
        r9 = r2.getResponseCode();	 Catch:{ all -> 0x0119 }
        r12 = r2.getHeaderFields();	 Catch:{ all -> 0x0119 }
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r9 < r4) goto L_0x012d;
    L_0x00a5:
        r4 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r9 >= r4) goto L_0x012d;
    L_0x00a9:
        r6 = r7.toString();	 Catch:{ all -> 0x0119 }
        r5 = 0;
        r4 = new java.io.InputStreamReader;	 Catch:{ all -> 0x0127 }
        r7 = r2.getInputStream();	 Catch:{ all -> 0x0127 }
        r4.<init>(r7);	 Catch:{ all -> 0x0127 }
        r5 = com.google.android.gms.ads.internal.C1319u.m7183e();	 Catch:{ all -> 0x01cd }
        r5 = r5.m9206a(r4);	 Catch:{ all -> 0x01cd }
        com.google.android.gms.common.util.C1977j.m11102a(r4);	 Catch:{ all -> 0x0119 }
        com.google.android.gms.p031b.C1605if.m8887a(r6, r12, r5, r9);	 Catch:{ all -> 0x0119 }
        r8.m8948a(r6, r12, r5);	 Catch:{ all -> 0x0119 }
        if (r19 == 0) goto L_0x00d7;
    L_0x00ca:
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ all -> 0x0119 }
        r5 = 0;
        r6 = "ufe";
        r4[r5] = r6;	 Catch:{ all -> 0x0119 }
        r0 = r19;
        r0.m7867a(r3, r4);	 Catch:{ all -> 0x0119 }
    L_0x00d7:
        r3 = r8.m8947a(r10);	 Catch:{ all -> 0x0119 }
        r2.disconnect();	 Catch:{ IOException -> 0x00f4 }
        if (r20 == 0) goto L_0x00e7;
    L_0x00e0:
        r0 = r20;
        r2 = r0.f5160g;	 Catch:{ IOException -> 0x00f4 }
        r2.mo1446b();	 Catch:{ IOException -> 0x00f4 }
    L_0x00e7:
        r2 = r3;
    L_0x00e8:
        return r2;
    L_0x00e9:
        r2 = 0;
        r3 = r2;
        goto L_0x0007;
    L_0x00ed:
        r2 = new java.lang.String;	 Catch:{ IOException -> 0x00f4 }
        r2.<init>(r4);	 Catch:{ IOException -> 0x00f4 }
        goto L_0x001c;
    L_0x00f4:
        r2 = move-exception;
        r3 = "Error while connecting to ad server: ";
        r2 = r2.getMessage();
        r2 = java.lang.String.valueOf(r2);
        r4 = r2.length();
        if (r4 == 0) goto L_0x01c6;
    L_0x0105:
        r2 = r3.concat(r2);
    L_0x0109:
        com.google.android.gms.ads.internal.util.client.C1324b.m7234d(r2);
        r2 = new com.google.android.gms.ads.internal.request.AdResponseParcel;
        r3 = 2;
        r2.<init>(r3);
        goto L_0x00e8;
    L_0x0113:
        r3 = move-exception;
        r4 = r5;
    L_0x0115:
        com.google.android.gms.common.util.C1977j.m11102a(r4);	 Catch:{ all -> 0x0119 }
        throw r3;	 Catch:{ all -> 0x0119 }
    L_0x0119:
        r3 = move-exception;
        r2.disconnect();	 Catch:{ IOException -> 0x00f4 }
        if (r20 == 0) goto L_0x0126;
    L_0x011f:
        r0 = r20;
        r2 = r0.f5160g;	 Catch:{ IOException -> 0x00f4 }
        r2.mo1446b();	 Catch:{ IOException -> 0x00f4 }
    L_0x0126:
        throw r3;	 Catch:{ IOException -> 0x00f4 }
    L_0x0127:
        r3 = move-exception;
        r4 = r5;
    L_0x0129:
        com.google.android.gms.common.util.C1977j.m11102a(r4);	 Catch:{ all -> 0x0119 }
        throw r3;	 Catch:{ all -> 0x0119 }
    L_0x012d:
        r4 = r7.toString();	 Catch:{ all -> 0x0119 }
        r5 = 0;
        com.google.android.gms.p031b.C1605if.m8887a(r4, r12, r5, r9);	 Catch:{ all -> 0x0119 }
        r4 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r9 < r4) goto L_0x0186;
    L_0x0139:
        r4 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r9 >= r4) goto L_0x0186;
    L_0x013d:
        r4 = "Location";
        r4 = r2.getHeaderField(r4);	 Catch:{ all -> 0x0119 }
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x0119 }
        if (r5 == 0) goto L_0x0162;
    L_0x0149:
        r3 = "No location header to follow redirect.";
        com.google.android.gms.ads.internal.util.client.C1324b.m7234d(r3);	 Catch:{ all -> 0x0119 }
        r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel;	 Catch:{ all -> 0x0119 }
        r4 = 0;
        r3.<init>(r4);	 Catch:{ all -> 0x0119 }
        r2.disconnect();	 Catch:{ IOException -> 0x00f4 }
        if (r20 == 0) goto L_0x0160;
    L_0x0159:
        r0 = r20;
        r2 = r0.f5160g;	 Catch:{ IOException -> 0x00f4 }
        r2.mo1446b();	 Catch:{ IOException -> 0x00f4 }
    L_0x0160:
        r2 = r3;
        goto L_0x00e8;
    L_0x0162:
        r5 = new java.net.URL;	 Catch:{ all -> 0x0119 }
        r5.<init>(r4);	 Catch:{ all -> 0x0119 }
        r4 = r6 + 1;
        r6 = 5;
        if (r4 <= r6) goto L_0x01b3;
    L_0x016c:
        r3 = "Too many redirects.";
        com.google.android.gms.ads.internal.util.client.C1324b.m7234d(r3);	 Catch:{ all -> 0x0119 }
        r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel;	 Catch:{ all -> 0x0119 }
        r4 = 0;
        r3.<init>(r4);	 Catch:{ all -> 0x0119 }
        r2.disconnect();	 Catch:{ IOException -> 0x00f4 }
        if (r20 == 0) goto L_0x0183;
    L_0x017c:
        r0 = r20;
        r2 = r0.f5160g;	 Catch:{ IOException -> 0x00f4 }
        r2.mo1446b();	 Catch:{ IOException -> 0x00f4 }
    L_0x0183:
        r2 = r3;
        goto L_0x00e8;
    L_0x0186:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0119 }
        r4 = 46;
        r3.<init>(r4);	 Catch:{ all -> 0x0119 }
        r4 = "Received error HTTP response code: ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x0119 }
        r3 = r3.append(r9);	 Catch:{ all -> 0x0119 }
        r3 = r3.toString();	 Catch:{ all -> 0x0119 }
        com.google.android.gms.ads.internal.util.client.C1324b.m7234d(r3);	 Catch:{ all -> 0x0119 }
        r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel;	 Catch:{ all -> 0x0119 }
        r4 = 0;
        r3.<init>(r4);	 Catch:{ all -> 0x0119 }
        r2.disconnect();	 Catch:{ IOException -> 0x00f4 }
        if (r20 == 0) goto L_0x01b0;
    L_0x01a9:
        r0 = r20;
        r2 = r0.f5160g;	 Catch:{ IOException -> 0x00f4 }
        r2.mo1446b();	 Catch:{ IOException -> 0x00f4 }
    L_0x01b0:
        r2 = r3;
        goto L_0x00e8;
    L_0x01b3:
        r8.m8949a(r12);	 Catch:{ all -> 0x0119 }
        r2.disconnect();	 Catch:{ IOException -> 0x00f4 }
        if (r20 == 0) goto L_0x01c2;
    L_0x01bb:
        r0 = r20;
        r2 = r0.f5160g;	 Catch:{ IOException -> 0x00f4 }
        r2.mo1446b();	 Catch:{ IOException -> 0x00f4 }
    L_0x01c2:
        r6 = r4;
        r7 = r5;
        goto L_0x0031;
    L_0x01c6:
        r2 = new java.lang.String;
        r2.<init>(r3);
        goto L_0x0109;
    L_0x01cd:
        r3 = move-exception;
        goto L_0x0129;
    L_0x01d0:
        r3 = move-exception;
        goto L_0x0115;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.if.a(com.google.android.gms.ads.internal.request.AdRequestInfoParcel, android.content.Context, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.b.ik, com.google.android.gms.b.cy, com.google.android.gms.b.ie):com.google.android.gms.ads.internal.request.AdResponseParcel");
    }

    public static C1605if m8886a(Context context, ci ciVar, ie ieVar) {
        C1605if c1605if;
        synchronized (f5182a) {
            if (f5183b == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                f5183b = new C1605if(context, ciVar, ieVar);
            }
            c1605if = f5183b;
        }
        return c1605if;
    }

    private static void m8887a(String str, Map<String, List<String>> map, String str2, int i) {
        if (C1324b.m7229a(2)) {
            jv.m9152e(new StringBuilder(String.valueOf(str).length() + 39).append("Http Response: {\n  URL:\n    ").append(str).append("\n  Headers:").toString());
            if (map != null) {
                for (String str3 : map.keySet()) {
                    String str32;
                    jv.m9152e(new StringBuilder(String.valueOf(str32).length() + 5).append("    ").append(str32).append(":").toString());
                    for (String str322 : (List) map.get(str322)) {
                        String str4 = "      ";
                        str322 = String.valueOf(str322);
                        jv.m9152e(str322.length() != 0 ? str4.concat(str322) : new String(str4));
                    }
                }
            }
            jv.m9152e("  Body:");
            if (str2 != null) {
                for (int i2 = 0; i2 < Math.min(str2.length(), 100000); i2 += 1000) {
                    jv.m9152e(str2.substring(i2, Math.min(str2.length(), i2 + 1000)));
                }
            } else {
                jv.m9152e("    null");
            }
            jv.m9152e("  Response Code:\n    " + i + "\n}");
        }
    }

    public AdResponseParcel mo1185a(AdRequestInfoParcel adRequestInfoParcel) {
        return C1605if.m8884a(this.f5184c, this.f5187f, this.f5186e, this.f5185d, adRequestInfoParcel);
    }

    public void mo1186a(final AdRequestInfoParcel adRequestInfoParcel, final C1271l c1271l) {
        C1319u.m7186h().m9111a(this.f5184c, adRequestInfoParcel.f3749k);
        jy.m9180a(new Runnable(this) {
            final /* synthetic */ C1605if f5181c;

            public void run() {
                AdResponseParcel a;
                try {
                    a = this.f5181c.mo1185a(adRequestInfoParcel);
                } catch (Throwable e) {
                    C1319u.m7186h().m9117a(e, true);
                    C1324b.m7235d("Could not fetch ad response due to an Exception.", e);
                    a = null;
                }
                if (a == null) {
                    a = new AdResponseParcel(0);
                }
                try {
                    c1271l.mo1184a(a);
                } catch (Throwable e2) {
                    C1324b.m7235d("Fail to forward ad response.", e2);
                }
            }
        });
    }
}
