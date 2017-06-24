package com.google.android.gms.ads.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.ads.internal.C1130f.C1129a;
import com.google.android.gms.ads.internal.formats.C1137d;
import com.google.android.gms.ads.internal.formats.C1139e;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.df;
import com.google.android.gms.p031b.df.C1133a;
import com.google.android.gms.p031b.eb;
import com.google.android.gms.p031b.fs;
import com.google.android.gms.p031b.gb;
import com.google.android.gms.p031b.gc;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p031b.jl;
import com.google.android.gms.p031b.la;
import com.google.android.gms.p031b.lb.C1148a;
import com.google.android.gms.p033a.C0998a;
import com.google.android.gms.p033a.C1001b;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONObject;

@id
public class C1180n {

    class C11751 implements C1148a {
        final /* synthetic */ C1137d f3446a;
        final /* synthetic */ String f3447b;
        final /* synthetic */ la f3448c;

        C11751(C1137d c1137d, String str, la laVar) {
            this.f3446a = c1137d;
            this.f3447b = str;
            this.f3448c = laVar;
        }

        public void mo1096a(la laVar, boolean z) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("headline", this.f3446a.mo1054a());
                jSONObject.put("body", this.f3446a.mo1057c());
                jSONObject.put("call_to_action", this.f3446a.mo1059e());
                jSONObject.put("price", this.f3446a.mo1062h());
                jSONObject.put("star_rating", String.valueOf(this.f3446a.mo1060f()));
                jSONObject.put("store", this.f3446a.mo1061g());
                jSONObject.put("icon", C1180n.m6563a(this.f3446a.mo1058d()));
                JSONArray jSONArray = new JSONArray();
                List<Object> b = this.f3446a.mo1056b();
                if (b != null) {
                    for (Object a : b) {
                        jSONArray.put(C1180n.m6563a(C1180n.m6571b(a)));
                    }
                }
                jSONObject.put("images", jSONArray);
                jSONObject.put("extras", C1180n.m6574b(this.f3446a.mo1067m(), this.f3447b));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("assets", jSONObject);
                jSONObject2.put("template_id", "2");
                this.f3448c.mo1321a("google.afma.nativeExpressAds.loadAssets", jSONObject2);
            } catch (Throwable e) {
                C1324b.m7235d("Exception occurred when loading assets", e);
            }
        }
    }

    class C11762 implements C1148a {
        final /* synthetic */ C1139e f3449a;
        final /* synthetic */ String f3450b;
        final /* synthetic */ la f3451c;

        C11762(C1139e c1139e, String str, la laVar) {
            this.f3449a = c1139e;
            this.f3450b = str;
            this.f3451c = laVar;
        }

        public void mo1096a(la laVar, boolean z) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("headline", this.f3449a.mo1069a());
                jSONObject.put("body", this.f3449a.mo1071c());
                jSONObject.put("call_to_action", this.f3449a.mo1073e());
                jSONObject.put("advertiser", this.f3449a.mo1074f());
                jSONObject.put("logo", C1180n.m6563a(this.f3449a.mo1072d()));
                JSONArray jSONArray = new JSONArray();
                List<Object> b = this.f3449a.mo1070b();
                if (b != null) {
                    for (Object a : b) {
                        jSONArray.put(C1180n.m6563a(C1180n.m6571b(a)));
                    }
                }
                jSONObject.put("images", jSONArray);
                jSONObject.put("extras", C1180n.m6574b(this.f3449a.mo1076h(), this.f3450b));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("assets", jSONObject);
                jSONObject2.put("template_id", "1");
                this.f3451c.mo1321a("google.afma.nativeExpressAds.loadAssets", jSONObject2);
            } catch (Throwable e) {
                C1324b.m7235d("Exception occurred when loading assets", e);
            }
        }
    }

    class C11773 implements eb {
        final /* synthetic */ CountDownLatch f3452a;

        C11773(CountDownLatch countDownLatch) {
            this.f3452a = countDownLatch;
        }

        public void mo997a(la laVar, Map<String, String> map) {
            this.f3452a.countDown();
            laVar.mo1503b().setVisibility(0);
        }
    }

    class C11784 implements eb {
        final /* synthetic */ CountDownLatch f3453a;

        C11784(CountDownLatch countDownLatch) {
            this.f3453a = countDownLatch;
        }

        public void mo997a(la laVar, Map<String, String> map) {
            C1324b.m7234d("Adapter returned an ad, but assets substitution failed");
            this.f3453a.countDown();
            laVar.destroy();
        }
    }

    class C11795 implements eb {
        final /* synthetic */ gb f3454a;
        final /* synthetic */ C1129a f3455b;
        final /* synthetic */ gc f3456c;

        C11795(gb gbVar, C1129a c1129a, gc gcVar) {
            this.f3454a = gbVar;
            this.f3455b = c1129a;
            this.f3456c = gcVar;
        }

        public void mo997a(la laVar, Map<String, String> map) {
            Object b = laVar.mo1503b();
            if (b != null) {
                try {
                    if (this.f3454a != null) {
                        if (this.f3454a.mo1383k()) {
                            C1180n.m6575b(laVar);
                            return;
                        }
                        this.f3454a.mo1371a(C1001b.m5713a(b));
                        this.f3455b.m6306a();
                    } else if (this.f3456c == null) {
                    } else {
                        if (this.f3456c.mo1396i()) {
                            C1180n.m6575b(laVar);
                            return;
                        }
                        this.f3456c.mo1386a(C1001b.m5713a(b));
                        this.f3455b.m6306a();
                    }
                } catch (Throwable e) {
                    C1324b.m7235d("Unable to call handleClick on mapper", e);
                }
            }
        }
    }

    public static View m6556a(jl jlVar) {
        if (jlVar == null) {
            C1324b.m7230b("AdState is null");
            return null;
        } else if (C1180n.m6576b(jlVar) && jlVar.f5424b != null) {
            return jlVar.f5424b.mo1503b();
        } else {
            try {
                C0998a a = jlVar.f5438p != null ? jlVar.f5438p.mo1349a() : null;
                if (a != null) {
                    return (View) C1001b.m5714a(a);
                }
                C1324b.m7234d("View in mediation adapter is null.");
                return null;
            } catch (Throwable e) {
                C1324b.m7235d("Could not get View from mediation adapter.", e);
                return null;
            }
        }
    }

    private static C1137d m6557a(gb gbVar) {
        return new C1137d(gbVar.mo1370a(), gbVar.mo1372b(), gbVar.mo1374c(), gbVar.mo1376d(), gbVar.mo1377e(), gbVar.mo1378f(), gbVar.mo1379g(), gbVar.mo1380h(), null, gbVar.mo1384l());
    }

    private static C1139e m6558a(gc gcVar) {
        return new C1139e(gcVar.mo1385a(), gcVar.mo1387b(), gcVar.mo1389c(), gcVar.mo1391d(), gcVar.mo1392e(), gcVar.mo1393f(), null, gcVar.mo1397j());
    }

    static eb m6560a(gb gbVar, gc gcVar, C1129a c1129a) {
        return new C11795(gbVar, c1129a, gcVar);
    }

    static eb m6561a(CountDownLatch countDownLatch) {
        return new C11773(countDownLatch);
    }

    private static String m6562a(Bitmap bitmap) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap == null) {
            C1324b.m7234d("Bitmap is null. Returning empty string");
            return "";
        }
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        String valueOf = String.valueOf("data:image/png;base64,");
        encodeToString = String.valueOf(encodeToString);
        return encodeToString.length() != 0 ? valueOf.concat(encodeToString) : new String(valueOf);
    }

    static String m6563a(df dfVar) {
        if (dfVar == null) {
            C1324b.m7234d("Image is null. Returning empty string");
            return "";
        }
        try {
            Uri b = dfVar.mo1052b();
            if (b != null) {
                return b.toString();
            }
        } catch (RemoteException e) {
            C1324b.m7234d("Unable to get image uri. Trying data uri next");
        }
        return C1180n.m6573b(dfVar);
    }

    public static void m6565a(jl jlVar, C1129a c1129a) {
        gc gcVar = null;
        if (jlVar != null && C1180n.m6576b(jlVar)) {
            la laVar = jlVar.f5424b;
            Object b = laVar != null ? laVar.mo1503b() : null;
            if (b == null) {
                C1324b.m7234d("AdWebView is null");
                return;
            }
            try {
                List list = jlVar.f5437o != null ? jlVar.f5437o.f4804o : null;
                if (list == null || list.isEmpty()) {
                    C1324b.m7234d("No template ids present in mediation response");
                    return;
                }
                gb h = jlVar.f5438p != null ? jlVar.f5438p.mo1365h() : null;
                if (jlVar.f5438p != null) {
                    gcVar = jlVar.f5438p.mo1366i();
                }
                if (list.contains("2") && h != null) {
                    h.mo1373b(C1001b.m5713a(b));
                    if (!h.mo1382j()) {
                        h.mo1381i();
                    }
                    laVar.mo1519l().m9466a("/nativeExpressViewClicked", C1180n.m6560a(h, null, c1129a));
                } else if (!list.contains("1") || gcVar == null) {
                    C1324b.m7234d("No matching template id and mapper");
                } else {
                    gcVar.mo1388b(C1001b.m5713a(b));
                    if (!gcVar.mo1395h()) {
                        gcVar.mo1394g();
                    }
                    laVar.mo1519l().m9466a("/nativeExpressViewClicked", C1180n.m6560a(null, gcVar, c1129a));
                }
            } catch (Throwable e) {
                C1324b.m7235d("Error occurred while recording impression and registering for clicks", e);
            }
        }
    }

    private static void m6567a(la laVar, C1137d c1137d, String str) {
        laVar.mo1519l().m9463a(new C11751(c1137d, str, laVar));
    }

    private static void m6568a(la laVar, C1139e c1139e, String str) {
        laVar.mo1519l().m9463a(new C11762(c1139e, str, laVar));
    }

    private static void m6569a(la laVar, CountDownLatch countDownLatch) {
        laVar.mo1519l().m9466a("/nativeExpressAssetsLoaded", C1180n.m6561a(countDownLatch));
        laVar.mo1519l().m9466a("/nativeExpressAssetsLoadingFailed", C1180n.m6572b(countDownLatch));
    }

    public static boolean m6570a(la laVar, fs fsVar, CountDownLatch countDownLatch) {
        boolean z = false;
        try {
            z = C1180n.m6577b(laVar, fsVar, countDownLatch);
        } catch (Throwable e) {
            C1324b.m7235d("Unable to invoke load assets", e);
        } catch (RuntimeException e2) {
            countDownLatch.countDown();
            throw e2;
        }
        if (!z) {
            countDownLatch.countDown();
        }
        return z;
    }

    private static df m6571b(Object obj) {
        return obj instanceof IBinder ? C1133a.m6331a((IBinder) obj) : null;
    }

    static eb m6572b(CountDownLatch countDownLatch) {
        return new C11784(countDownLatch);
    }

    private static String m6573b(df dfVar) {
        try {
            C0998a a = dfVar.mo1051a();
            if (a == null) {
                C1324b.m7234d("Drawable is null. Returning empty string");
                return "";
            }
            Drawable drawable = (Drawable) C1001b.m5714a(a);
            if (drawable instanceof BitmapDrawable) {
                return C1180n.m6562a(((BitmapDrawable) drawable).getBitmap());
            }
            C1324b.m7234d("Drawable is not an instance of BitmapDrawable. Returning empty string");
            return "";
        } catch (RemoteException e) {
            C1324b.m7234d("Unable to get drawable. Returning empty string");
            return "";
        }
    }

    private static JSONObject m6574b(Bundle bundle, String str) {
        JSONObject jSONObject = new JSONObject();
        if (bundle == null || TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject(str);
        Iterator keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            if (bundle.containsKey(str2)) {
                if ("image".equals(jSONObject2.getString(str2))) {
                    Object obj = bundle.get(str2);
                    if (obj instanceof Bitmap) {
                        jSONObject.put(str2, C1180n.m6562a((Bitmap) obj));
                    } else {
                        C1324b.m7234d("Invalid type. An image type extra should return a bitmap");
                    }
                } else if (bundle.get(str2) instanceof Bitmap) {
                    C1324b.m7234d("Invalid asset type. Bitmap should be returned only for image type");
                } else {
                    jSONObject.put(str2, String.valueOf(bundle.get(str2)));
                }
            }
        }
        return jSONObject;
    }

    private static void m6575b(la laVar) {
        OnClickListener E = laVar.mo1491E();
        if (E != null) {
            E.onClick(laVar.mo1503b());
        }
    }

    public static boolean m6576b(jl jlVar) {
        return (jlVar == null || !jlVar.f5436n || jlVar.f5437o == null || jlVar.f5437o.f4801l == null) ? false : true;
    }

    private static boolean m6577b(la laVar, fs fsVar, CountDownLatch countDownLatch) {
        View b = laVar.mo1503b();
        if (b == null) {
            C1324b.m7234d("AdWebView is null");
            return false;
        }
        b.setVisibility(4);
        List list = fsVar.f4851b.f4804o;
        if (list == null || list.isEmpty()) {
            C1324b.m7234d("No template ids present in mediation response");
            return false;
        }
        C1180n.m6569a(laVar, countDownLatch);
        gb h = fsVar.f4852c.mo1365h();
        gc i = fsVar.f4852c.mo1366i();
        if (list.contains("2") && h != null) {
            C1180n.m6567a(laVar, C1180n.m6557a(h), fsVar.f4851b.f4803n);
        } else if (!list.contains("1") || i == null) {
            C1324b.m7234d("No matching template id and mapper");
            return false;
        } else {
            C1180n.m6568a(laVar, C1180n.m6558a(i), fsVar.f4851b.f4803n);
        }
        String str = fsVar.f4851b.f4801l;
        String str2 = fsVar.f4851b.f4802m;
        if (str2 != null) {
            laVar.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
        } else {
            laVar.loadData(str, "text/html", "UTF-8");
        }
        return true;
    }
}
