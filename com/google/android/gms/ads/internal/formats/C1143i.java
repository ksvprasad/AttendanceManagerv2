package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.internal.C1245q;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.C1142h.C1136a;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.p031b.aj;
import com.google.android.gms.p031b.cq;
import com.google.android.gms.p031b.eb;
import com.google.android.gms.p031b.fg;
import com.google.android.gms.p031b.hx;
import com.google.android.gms.p031b.hx.C1145a;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p031b.la;
import com.google.android.gms.p031b.lb.C1148a;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

@id
public class C1143i implements C1142h {
    private final Object f3347a = new Object();
    private final C1245q f3348b;
    private final Context f3349c;
    private final JSONObject f3350d;
    private final hx f3351e;
    private final C1136a f3352f;
    private final aj f3353g;
    private final VersionInfoParcel f3354h;
    private boolean f3355i;
    private la f3356j;
    private String f3357k;
    private String f3358l;
    private WeakReference<View> f3359m = null;

    class C11553 extends C1145a {
        final /* synthetic */ C1143i f3379a;

        class C11512 implements eb {
            final /* synthetic */ C11553 f3374a;

            C11512(C11553 c11553) {
                this.f3374a = c11553;
            }

            public void mo997a(la laVar, Map<String, String> map) {
                this.f3374a.f3379a.f3356j.mo1503b().setVisibility(0);
            }
        }

        class C11523 implements eb {
            final /* synthetic */ C11553 f3375a;

            C11523(C11553 c11553) {
                this.f3375a = c11553;
            }

            public void mo997a(la laVar, Map<String, String> map) {
                this.f3375a.f3379a.f3356j.mo1503b().setVisibility(8);
            }
        }

        class C11534 implements eb {
            final /* synthetic */ C11553 f3376a;

            C11534(C11553 c11553) {
                this.f3376a = c11553;
            }

            public void mo997a(la laVar, Map<String, String> map) {
                this.f3376a.f3379a.f3356j.mo1503b().setVisibility(8);
            }
        }

        C11553(C1143i c1143i) {
            this.f3379a = c1143i;
        }

        public void mo1095a(final fg fgVar) {
            fgVar.mo1319a("/loadHtml", new eb(this) {
                final /* synthetic */ C11553 f3373b;

                public void mo997a(la laVar, final Map<String, String> map) {
                    this.f3373b.f3379a.f3356j.mo1519l().m9463a(new C1148a(this) {
                        final /* synthetic */ C11501 f3371b;

                        public void mo1096a(la laVar, boolean z) {
                            this.f3371b.f3373b.f3379a.f3357k = (String) map.get("id");
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("messageType", "htmlLoaded");
                                jSONObject.put("id", this.f3371b.f3373b.f3379a.f3357k);
                                fgVar.mo1325b("sendMessageToNativeJs", jSONObject);
                            } catch (Throwable e) {
                                C1324b.m7231b("Unable to dispatch sendMessageToNativeJs event", e);
                            }
                        }
                    });
                    String str = (String) map.get("overlayHtml");
                    String str2 = (String) map.get("baseUrl");
                    if (TextUtils.isEmpty(str2)) {
                        this.f3373b.f3379a.f3356j.loadData(str, "text/html", "UTF-8");
                    } else {
                        this.f3373b.f3379a.f3356j.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
                    }
                }
            });
            fgVar.mo1319a("/showOverlay", new C11512(this));
            fgVar.mo1319a("/hideOverlay", new C11523(this));
            this.f3379a.f3356j.mo1519l().m9466a("/hideOverlay", new C11534(this));
            this.f3379a.f3356j.mo1519l().m9466a("/sendMessageToSdk", new eb(this) {
                final /* synthetic */ C11553 f3378b;

                public void mo997a(la laVar, Map<String, String> map) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        for (String str : map.keySet()) {
                            jSONObject.put(str, map.get(str));
                        }
                        jSONObject.put("id", this.f3378b.f3379a.f3357k);
                        fgVar.mo1325b("sendMessageToNativeJs", jSONObject);
                    } catch (Throwable e) {
                        C1324b.m7231b("Unable to dispatch sendMessageToNativeJs event", e);
                    }
                }
            });
        }
    }

    public C1143i(Context context, C1245q c1245q, hx hxVar, aj ajVar, JSONObject jSONObject, C1136a c1136a, VersionInfoParcel versionInfoParcel, String str) {
        this.f3349c = context;
        this.f3348b = c1245q;
        this.f3351e = hxVar;
        this.f3353g = ajVar;
        this.f3350d = jSONObject;
        this.f3352f = c1136a;
        this.f3354h = versionInfoParcel;
        this.f3358l = str;
    }

    public C1132b mo1092a(OnClickListener onClickListener) {
        C1131a l = this.f3352f.mo1066l();
        if (l == null) {
            return null;
        }
        C1132b c1132b = new C1132b(this.f3349c, l);
        c1132b.setLayoutParams(new LayoutParams(-1, -1));
        c1132b.m6327a().setOnClickListener(onClickListener);
        c1132b.m6327a().setContentDescription("Ad attribution icon");
        return c1132b;
    }

    public void mo1083a() {
        C1896c.m10797b("recordImpression must be called on the main UI thread.");
        m6425a(true);
        try {
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", this.f3350d);
            jSONObject.put("ads_id", this.f3358l);
            this.f3351e.m8800a(new C1145a(this) {
                final /* synthetic */ C1143i f3369b;

                public void mo1095a(fg fgVar) {
                    fgVar.mo1321a("google.afma.nativeAds.handleImpressionPing", jSONObject);
                }
            });
        } catch (Throwable e) {
            C1324b.m7231b("Unable to create impression JSON.", e);
        }
        this.f3348b.m6867a((C1142h) this);
    }

    public void mo1084a(MotionEvent motionEvent) {
        this.f3353g.m7433a(motionEvent);
    }

    public void mo1085a(View view) {
        synchronized (this.f3347a) {
            if (this.f3355i) {
            } else if (!view.isShown()) {
            } else if (view.getGlobalVisibleRect(new Rect(), null)) {
                mo1083a();
            }
        }
    }

    public void mo1086a(View view, Map<String, WeakReference<View>> map) {
        view.setOnTouchListener(null);
        view.setClickable(false);
        view.setOnClickListener(null);
        for (Entry value : map.entrySet()) {
            View view2 = (View) ((WeakReference) value.getValue()).get();
            if (view2 != null) {
                view2.setOnTouchListener(null);
                view2.setClickable(false);
                view2.setOnClickListener(null);
            }
        }
    }

    public void mo1093a(View view, Map<String, WeakReference<View>> map, OnTouchListener onTouchListener, OnClickListener onClickListener) {
        if (((Boolean) cq.bl.m7801c()).booleanValue()) {
            view.setOnTouchListener(onTouchListener);
            view.setClickable(true);
            view.setOnClickListener(onClickListener);
            for (Entry value : map.entrySet()) {
                View view2 = (View) ((WeakReference) value.getValue()).get();
                if (view2 != null) {
                    view2.setOnTouchListener(onTouchListener);
                    view2.setClickable(true);
                    view2.setOnClickListener(onClickListener);
                }
            }
        }
    }

    public void mo1087a(View view, Map<String, WeakReference<View>> map, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        C1896c.m10797b("performClick must be called on the main UI thread.");
        for (Entry entry : map.entrySet()) {
            if (view.equals((View) ((WeakReference) entry.getValue()).get())) {
                mo1088a((String) entry.getKey(), jSONObject, jSONObject2, jSONObject3);
                return;
            }
        }
        if ("2".equals(this.f3352f.mo1064j())) {
            mo1088a("2099", jSONObject, jSONObject2, jSONObject3);
        } else if ("1".equals(this.f3352f.mo1064j())) {
            mo1088a("1099", jSONObject, jSONObject2, jSONObject3);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo1088a(java.lang.String r7, org.json.JSONObject r8, org.json.JSONObject r9, org.json.JSONObject r10) {
        /*
        r6 = this;
        r0 = "performClick must be called on the main UI thread.";
        com.google.android.gms.common.internal.C1896c.m10797b(r0);
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0095 }
        r1.<init>();	 Catch:{ JSONException -> 0x0095 }
        r0 = "asset";
        r1.put(r0, r7);	 Catch:{ JSONException -> 0x0095 }
        r0 = "template";
        r2 = r6.f3352f;	 Catch:{ JSONException -> 0x0095 }
        r2 = r2.mo1064j();	 Catch:{ JSONException -> 0x0095 }
        r1.put(r0, r2);	 Catch:{ JSONException -> 0x0095 }
        r2 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0095 }
        r2.<init>();	 Catch:{ JSONException -> 0x0095 }
        r0 = "ad";
        r3 = r6.f3350d;	 Catch:{ JSONException -> 0x0095 }
        r2.put(r0, r3);	 Catch:{ JSONException -> 0x0095 }
        r0 = "click";
        r2.put(r0, r1);	 Catch:{ JSONException -> 0x0095 }
        r3 = "has_custom_click_handler";
        r0 = r6.f3348b;	 Catch:{ JSONException -> 0x0095 }
        r4 = r6.f3352f;	 Catch:{ JSONException -> 0x0095 }
        r4 = r4.mo1065k();	 Catch:{ JSONException -> 0x0095 }
        r0 = r0.m6877c(r4);	 Catch:{ JSONException -> 0x0095 }
        if (r0 == 0) goto L_0x008c;
    L_0x003b:
        r0 = 1;
    L_0x003c:
        r2.put(r3, r0);	 Catch:{ JSONException -> 0x0095 }
        if (r8 == 0) goto L_0x0046;
    L_0x0041:
        r0 = "view_rectangles";
        r2.put(r0, r8);	 Catch:{ JSONException -> 0x0095 }
    L_0x0046:
        if (r9 == 0) goto L_0x004d;
    L_0x0048:
        r0 = "click_point";
        r2.put(r0, r9);	 Catch:{ JSONException -> 0x0095 }
    L_0x004d:
        if (r10 == 0) goto L_0x0054;
    L_0x004f:
        r0 = "native_view_rectangle";
        r2.put(r0, r10);	 Catch:{ JSONException -> 0x0095 }
    L_0x0054:
        r0 = r6.f3350d;	 Catch:{ Exception -> 0x008e }
        r3 = "tracking_urls_and_actions";
        r0 = r0.optJSONObject(r3);	 Catch:{ Exception -> 0x008e }
        if (r0 != 0) goto L_0x0063;
    L_0x005e:
        r0 = new org.json.JSONObject;	 Catch:{ Exception -> 0x008e }
        r0.<init>();	 Catch:{ Exception -> 0x008e }
    L_0x0063:
        r3 = "click_string";
        r0 = r0.optString(r3);	 Catch:{ Exception -> 0x008e }
        r3 = "click_signals";
        r4 = r6.f3353g;	 Catch:{ Exception -> 0x008e }
        r4 = r4.m7432a();	 Catch:{ Exception -> 0x008e }
        r5 = r6.f3349c;	 Catch:{ Exception -> 0x008e }
        r0 = r4.mo1103a(r5, r0);	 Catch:{ Exception -> 0x008e }
        r1.put(r3, r0);	 Catch:{ Exception -> 0x008e }
    L_0x007a:
        r0 = "ads_id";
        r1 = r6.f3358l;	 Catch:{ JSONException -> 0x0095 }
        r2.put(r0, r1);	 Catch:{ JSONException -> 0x0095 }
        r0 = r6.f3351e;	 Catch:{ JSONException -> 0x0095 }
        r1 = new com.google.android.gms.ads.internal.formats.i$1;	 Catch:{ JSONException -> 0x0095 }
        r1.<init>(r6, r2);	 Catch:{ JSONException -> 0x0095 }
        r0.m8800a(r1);	 Catch:{ JSONException -> 0x0095 }
    L_0x008b:
        return;
    L_0x008c:
        r0 = 0;
        goto L_0x003c;
    L_0x008e:
        r0 = move-exception;
        r1 = "Exception obtaining click signals";
        com.google.android.gms.ads.internal.util.client.C1324b.m7231b(r1, r0);	 Catch:{ JSONException -> 0x0095 }
        goto L_0x007a;
    L_0x0095:
        r0 = move-exception;
        r1 = "Unable to create click JSON.";
        com.google.android.gms.ads.internal.util.client.C1324b.m7231b(r1, r0);
        goto L_0x008b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.formats.i.a(java.lang.String, org.json.JSONObject, org.json.JSONObject, org.json.JSONObject):void");
    }

    protected void m6425a(boolean z) {
        this.f3355i = z;
    }

    public void mo1089b(View view) {
        this.f3359m = new WeakReference(view);
    }

    public la mo1094d() {
        this.f3356j = m6430g();
        this.f3356j.mo1503b().setVisibility(8);
        this.f3351e.m8800a(new C11553(this));
        return this.f3356j;
    }

    public View mo1090e() {
        return this.f3359m != null ? (View) this.f3359m.get() : null;
    }

    public Context mo1091f() {
        return this.f3349c;
    }

    la m6430g() {
        return C1319u.m7184f().m9480a(this.f3349c, AdSizeParcel.m5968a(this.f3349c), false, false, this.f3353g, this.f3354h);
    }
}
