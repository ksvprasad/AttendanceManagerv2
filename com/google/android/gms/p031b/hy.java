package com.google.android.gms.p031b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.C1245q;
import com.google.android.gms.ads.internal.formats.C1131a;
import com.google.android.gms.ads.internal.formats.C1134c;
import com.google.android.gms.ads.internal.formats.C1141f;
import com.google.android.gms.ads.internal.formats.C1142h.C1136a;
import com.google.android.gms.ads.internal.formats.C1143i;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.common.util.C1977j;
import com.google.android.gms.p031b.hx.C1145a;
import com.google.android.gms.p031b.jl.C1632a;
import com.google.android.gms.p031b.kf.C1591a;
import com.google.android.gms.p031b.kp.C1589a;
import com.google.android.gms.p033a.C1001b;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@id
public class hy implements Callable<jl> {
    private static final long f5128a = TimeUnit.SECONDS.toMillis(60);
    private final Context f5129b;
    private final kf f5130c;
    private final C1245q f5131d;
    private final aj f5132e;
    private final hx f5133f;
    private final Object f5134g = new Object();
    private final C1632a f5135h;
    private boolean f5136i;
    private int f5137j;
    private List<String> f5138k;
    private JSONObject f5139l;

    public interface C1593a<T extends C1136a> {
        T mo1443a(hy hyVar, JSONObject jSONObject);
    }

    class C1594b {
        public eb f5126a;
        final /* synthetic */ hy f5127b;

        C1594b(hy hyVar) {
            this.f5127b = hyVar;
        }
    }

    public hy(Context context, C1245q c1245q, kf kfVar, aj ajVar, C1632a c1632a) {
        this.f5129b = context;
        this.f5131d = c1245q;
        this.f5130c = kfVar;
        this.f5135h = c1632a;
        this.f5132e = ajVar;
        this.f5133f = m8834a(context, c1632a, c1245q, ajVar);
        this.f5133f.m8799a();
        this.f5136i = false;
        this.f5137j = -2;
        this.f5138k = null;
    }

    private C1136a m8821a(C1593a c1593a, JSONObject jSONObject, String str) {
        if (m8843b()) {
            return null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("tracking_urls_and_actions");
        String[] b = m8833b(jSONObject2, "impression_tracking_urls");
        this.f5138k = b == null ? null : Arrays.asList(b);
        this.f5139l = jSONObject2.optJSONObject("active_view");
        C1136a a = c1593a.mo1443a(this, jSONObject);
        if (a == null) {
            C1324b.m7230b("Failed to retrieve ad assets.");
            return null;
        }
        a.mo1055a(new C1143i(this.f5129b, this.f5131d, this.f5133f, this.f5132e, jSONObject, a, this.f5135h.f5408a.f3749k, str));
        return a;
    }

    private kq<C1134c> m8823a(JSONObject jSONObject, boolean z, boolean z2) {
        final String string = z ? jSONObject.getString("url") : jSONObject.optString("url");
        final double optDouble = jSONObject.optDouble("scale", 1.0d);
        if (TextUtils.isEmpty(string)) {
            m8841a(0, z);
            return new ko(null);
        } else if (z2) {
            return new ko(new C1134c(null, Uri.parse(string), optDouble));
        } else {
            final boolean z3 = z;
            return this.f5130c.m9338a(string, new C1591a<C1134c>(this) {
                final /* synthetic */ hy f5125d;

                public C1134c m8816a() {
                    this.f5125d.m8841a(2, z3);
                    return null;
                }

                public C1134c m8817a(InputStream inputStream) {
                    byte[] a;
                    try {
                        a = C1977j.m11103a(inputStream);
                    } catch (IOException e) {
                        a = null;
                    }
                    if (a == null) {
                        this.f5125d.m8841a(2, z3);
                        return null;
                    }
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(a, 0, a.length);
                    if (decodeByteArray == null) {
                        this.f5125d.m8841a(2, z3);
                        return null;
                    }
                    decodeByteArray.setDensity((int) (160.0d * optDouble));
                    return new C1134c(new BitmapDrawable(Resources.getSystem(), decodeByteArray), Uri.parse(string), optDouble);
                }

                public /* synthetic */ Object mo1441b() {
                    return m8816a();
                }

                public /* synthetic */ Object mo1442b(InputStream inputStream) {
                    return m8817a(inputStream);
                }
            });
        }
    }

    private Integer m8824a(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException e) {
            return null;
        }
    }

    private JSONObject m8826a(final String str) {
        if (m8843b()) {
            return null;
        }
        final kn knVar = new kn();
        final C1594b c1594b = new C1594b(this);
        this.f5133f.m8800a(new C1145a(this) {
            final /* synthetic */ hy f5106d;

            public void mo1439a() {
                knVar.m8236b(null);
            }

            public void mo1095a(final fg fgVar) {
                eb c15841 = new eb(this) {
                    final /* synthetic */ C15851 f5102b;

                    public void mo997a(la laVar, Map<String, String> map) {
                        fgVar.mo1324b("/nativeAdPreProcess", c1594b.f5126a);
                        try {
                            String str = (String) map.get("success");
                            if (!TextUtils.isEmpty(str)) {
                                knVar.m8236b(new JSONObject(str).getJSONArray("ads").getJSONObject(0));
                                return;
                            }
                        } catch (Throwable e) {
                            C1324b.m7231b("Malformed native JSON response.", e);
                        }
                        this.f5102b.f5106d.m8840a(0);
                        C1896c.m10795a(this.f5102b.f5106d.m8843b(), (Object) "Unable to set the ad state error!");
                        knVar.m8236b(null);
                    }
                };
                c1594b.f5126a = c15841;
                fgVar.mo1319a("/nativeAdPreProcess", c15841);
                try {
                    JSONObject jSONObject = new JSONObject(this.f5106d.f5135h.f5409b.f3781c);
                    jSONObject.put("ads_id", str);
                    fgVar.mo1321a("google.afma.nativeAds.preProcessJsonGmsg", jSONObject);
                } catch (Throwable e) {
                    C1324b.m7235d("Exception occurred while invoking javascript", e);
                    knVar.m8236b(null);
                }
            }
        });
        return (JSONObject) knVar.get(f5128a, TimeUnit.MILLISECONDS);
    }

    private void m8827a(C1136a c1136a) {
        if (c1136a instanceof C1141f) {
            final C1141f c1141f = (C1141f) c1136a;
            C1594b c1594b = new C1594b(this);
            final eb c15873 = new eb(this) {
                final /* synthetic */ hy f5111b;

                public void mo997a(la laVar, Map<String, String> map) {
                    this.f5111b.m8828a(c1141f, (String) map.get("asset"));
                }
            };
            c1594b.f5126a = c15873;
            this.f5133f.m8800a(new C1145a(this) {
                final /* synthetic */ hy f5113b;

                public void mo1095a(fg fgVar) {
                    fgVar.mo1319a("/nativeAdCustomClick", c15873);
                }
            });
        }
    }

    private void m8828a(dn dnVar, String str) {
        try {
            dr c = this.f5131d.m6877c(dnVar.mo1065k());
            if (c != null) {
                c.mo1305a(dnVar, str);
            }
        } catch (Throwable e) {
            C1324b.m7235d(new StringBuilder(String.valueOf(str).length() + 40).append("Failed to call onCustomClick for asset ").append(str).append(".").toString(), e);
        }
    }

    private jl m8831b(C1136a c1136a) {
        int i;
        synchronized (this.f5134g) {
            i = this.f5137j;
            if (c1136a == null && this.f5137j == -2) {
                i = 0;
            }
        }
        return new jl(this.f5135h.f5408a.f3741c, null, this.f5135h.f5409b.f3782d, i, this.f5135h.f5409b.f3784f, this.f5138k, this.f5135h.f5409b.f3790l, this.f5135h.f5409b.f3789k, this.f5135h.f5408a.f3747i, false, null, null, null, null, null, 0, this.f5135h.f5411d, this.f5135h.f5409b.f3785g, this.f5135h.f5413f, this.f5135h.f5414g, this.f5135h.f5409b.f3793o, this.f5139l, i != -2 ? null : c1136a, null, null, null, this.f5135h.f5409b.f3770F, this.f5135h.f5409b.f3771G, null, this.f5135h.f5409b.f3774J);
    }

    private static List<Drawable> m8832b(List<C1134c> list) {
        List<Drawable> arrayList = new ArrayList();
        for (C1134c a : list) {
            arrayList.add((Drawable) C1001b.m5714a(a.mo1051a()));
        }
        return arrayList;
    }

    private String[] m8833b(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        String[] strArr = new String[optJSONArray.length()];
        for (int i = 0; i < optJSONArray.length(); i++) {
            strArr[i] = optJSONArray.getString(i);
        }
        return strArr;
    }

    hx m8834a(Context context, C1632a c1632a, C1245q c1245q, aj ajVar) {
        return new hx(context, c1632a, c1245q, ajVar);
    }

    protected C1593a m8835a(JSONObject jSONObject) {
        if (m8843b()) {
            return null;
        }
        String string = jSONObject.getString("template_id");
        boolean z = this.f5135h.f5408a.f3764z != null ? this.f5135h.f5408a.f3764z.f3298b : false;
        boolean z2 = this.f5135h.f5408a.f3764z != null ? this.f5135h.f5408a.f3764z.f3300d : false;
        if ("2".equals(string)) {
            return new hz(z, z2);
        }
        if ("1".equals(string)) {
            return new ia(z, z2);
        }
        if ("3".equals(string)) {
            final String string2 = jSONObject.getString("custom_template_id");
            final kn knVar = new kn();
            jz.f5567a.post(new Runnable(this) {
                final /* synthetic */ hy f5109c;

                public void run() {
                    knVar.m8236b((ds) this.f5109c.f5131d.m6864D().get(string2));
                }
            });
            if (knVar.get(f5128a, TimeUnit.MILLISECONDS) != null) {
                return new ib(z);
            }
            string2 = "No handler for custom template: ";
            String valueOf = String.valueOf(jSONObject.getString("custom_template_id"));
            C1324b.m7230b(valueOf.length() != 0 ? string2.concat(valueOf) : new String(string2));
        } else {
            m8840a(0);
        }
        return null;
    }

    public jl m8836a() {
        try {
            this.f5133f.m8801b();
            String uuid = UUID.randomUUID().toString();
            JSONObject a = m8826a(uuid);
            C1136a a2 = m8821a(m8835a(a), a, uuid);
            m8827a(a2);
            return m8831b(a2);
        } catch (CancellationException e) {
            if (!this.f5136i) {
                m8840a(0);
            }
            return m8831b(null);
        } catch (ExecutionException e2) {
            if (this.f5136i) {
                m8840a(0);
            }
            return m8831b(null);
        } catch (InterruptedException e3) {
            if (this.f5136i) {
                m8840a(0);
            }
            return m8831b(null);
        } catch (Throwable e4) {
            C1324b.m7235d("Malformed native JSON response.", e4);
            if (this.f5136i) {
                m8840a(0);
            }
            return m8831b(null);
        } catch (Throwable e42) {
            C1324b.m7235d("Timeout when loading native ad.", e42);
            if (this.f5136i) {
                m8840a(0);
            }
            return m8831b(null);
        }
    }

    public kq<C1134c> m8837a(JSONObject jSONObject, String str, boolean z, boolean z2) {
        JSONObject jSONObject2 = z ? jSONObject.getJSONObject(str) : jSONObject.optJSONObject(str);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return m8823a(jSONObject2, z, z2);
    }

    public List<kq<C1134c>> m8838a(JSONObject jSONObject, String str, boolean z, boolean z2, boolean z3) {
        JSONArray jSONArray = z ? jSONObject.getJSONArray(str) : jSONObject.optJSONArray(str);
        List<kq<C1134c>> arrayList = new ArrayList();
        if (jSONArray == null || jSONArray.length() == 0) {
            m8841a(0, z);
            return arrayList;
        }
        int length = z3 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            arrayList.add(m8823a(jSONObject2, z, z2));
        }
        return arrayList;
    }

    public Future<C1134c> m8839a(JSONObject jSONObject, String str, boolean z) {
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        boolean optBoolean = jSONObject2.optBoolean("require", true);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return m8823a(jSONObject2, optBoolean, z);
    }

    public void m8840a(int i) {
        synchronized (this.f5134g) {
            this.f5136i = true;
            this.f5137j = i;
        }
    }

    public void m8841a(int i, boolean z) {
        if (z) {
            m8840a(i);
        }
    }

    public kq<C1131a> m8842b(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("attribution");
        if (optJSONObject == null) {
            return new ko(null);
        }
        String optString = optJSONObject.optString("text");
        int optInt = optJSONObject.optInt("text_size", -1);
        Integer a = m8824a(optJSONObject, "text_color");
        Integer a2 = m8824a(optJSONObject, "bg_color");
        final int optInt2 = optJSONObject.optInt("animation_ms", 1000);
        final int optInt3 = optJSONObject.optInt("presentation_ms", 4000);
        final int i = (this.f5135h.f5408a.f3764z == null || this.f5135h.f5408a.f3764z.f3297a < 2) ? 1 : this.f5135h.f5408a.f3764z.f3301e;
        List arrayList = new ArrayList();
        if (optJSONObject.optJSONArray("images") != null) {
            arrayList = m8838a(optJSONObject, "images", false, false, true);
        } else {
            arrayList.add(m8837a(optJSONObject, "image", false, false));
        }
        final String str = optString;
        final Integer num = a2;
        final Integer num2 = a;
        final int i2 = optInt;
        return kp.m9361a(kp.m9362a(arrayList), new C1589a<List<C1134c>, C1131a>(this) {
            final /* synthetic */ hy f5121h;

            public C1131a m8812a(List<C1134c> list) {
                C1131a c1131a;
                if (list != null) {
                    try {
                        if (!list.isEmpty()) {
                            c1131a = new C1131a(str, hy.m8832b((List) list), num, num2, i2 > 0 ? Integer.valueOf(i2) : null, optInt3 + optInt2, i);
                            return c1131a;
                        }
                    } catch (Throwable e) {
                        C1324b.m7231b("Could not get attribution icon", e);
                        return null;
                    }
                }
                c1131a = null;
                return c1131a;
            }

            public /* synthetic */ Object mo1440a(Object obj) {
                return m8812a((List) obj);
            }
        });
    }

    public boolean m8843b() {
        boolean z;
        synchronized (this.f5134g) {
            z = this.f5136i;
        }
        return z;
    }

    public /* synthetic */ Object call() {
        return m8836a();
    }
}
