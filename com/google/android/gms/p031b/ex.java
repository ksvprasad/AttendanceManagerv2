package com.google.android.gms.p031b;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Base64;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.ez.C1485a;
import com.google.android.gms.p031b.il.C1609a;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

@id
public class ex {
    private final Map<ey, ez> f4617a = new HashMap();
    private final LinkedList<ey> f4618b = new LinkedList();
    private eu f4619c;

    static Bundle m8128a(AdRequestParcel adRequestParcel) {
        Bundle bundle = adRequestParcel.f3097m;
        return bundle == null ? null : bundle.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
    }

    private static void m8129a(Bundle bundle, String str) {
        String[] split = str.split("/", 2);
        if (split.length != 0) {
            String str2 = split[0];
            if (split.length == 1) {
                bundle.remove(str2);
                return;
            }
            Bundle bundle2 = bundle.getBundle(str2);
            if (bundle2 != null) {
                ex.m8129a(bundle2, split[1]);
            }
        }
    }

    private static void m8130a(String str, ey eyVar) {
        if (C1324b.m7229a(2)) {
            jv.m9152e(String.format(str, new Object[]{eyVar}));
        }
    }

    private String[] m8131a(String str) {
        try {
            String[] split = str.split("\u0000");
            for (int i = 0; i < split.length; i++) {
                split[i] = new String(Base64.decode(split[i], 0), "UTF-8");
            }
            return split;
        } catch (UnsupportedEncodingException e) {
            return new String[0];
        }
    }

    static AdRequestParcel m8132b(AdRequestParcel adRequestParcel) {
        Parcel obtain = Parcel.obtain();
        adRequestParcel.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        AdRequestParcel adRequestParcel2 = (AdRequestParcel) AdRequestParcel.CREATOR.createFromParcel(obtain);
        obtain.recycle();
        Bundle a = ex.m8128a(adRequestParcel2);
        if (a == null) {
            a = new Bundle();
            adRequestParcel2.f3097m.putBundle("com.google.ads.mediation.admob.AdMobAdapter", a);
        }
        a.putBoolean("_skipMediation", true);
        return adRequestParcel2;
    }

    private boolean m8133b(String str) {
        try {
            return Pattern.matches((String) cq.ao.m7801c(), str);
        } catch (Throwable e) {
            C1319u.m7186h().m9117a(e, true);
            return false;
        }
    }

    static boolean m8134c(AdRequestParcel adRequestParcel) {
        Bundle bundle = adRequestParcel.f3097m;
        if (bundle == null) {
            return false;
        }
        bundle = bundle.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        return bundle != null && bundle.containsKey("_skipMediation");
    }

    private static AdRequestParcel m8135d(AdRequestParcel adRequestParcel) {
        Parcel obtain = Parcel.obtain();
        adRequestParcel.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        AdRequestParcel adRequestParcel2 = (AdRequestParcel) AdRequestParcel.CREATOR.createFromParcel(obtain);
        obtain.recycle();
        for (String a : ((String) cq.ak.m7801c()).split(",")) {
            ex.m8129a(adRequestParcel2.f3097m, a);
        }
        return adRequestParcel2;
    }

    private String m8136e() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            Iterator it = this.f4618b.iterator();
            while (it.hasNext()) {
                stringBuilder.append(Base64.encodeToString(((ey) it.next()).toString().getBytes("UTF-8"), 0));
                if (it.hasNext()) {
                    stringBuilder.append("\u0000");
                }
            }
            return stringBuilder.toString();
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    C1485a m8137a(AdRequestParcel adRequestParcel, String str) {
        if (m8133b(str)) {
            return null;
        }
        ez ezVar;
        int i = new C1609a(this.f4619c.m8080a()).m8968a().f5282m;
        AdRequestParcel d = ex.m8135d(adRequestParcel);
        ey eyVar = new ey(d, str, i);
        ez ezVar2 = (ez) this.f4617a.get(eyVar);
        if (ezVar2 == null) {
            ex.m8130a("Interstitial pool created at %s.", eyVar);
            ezVar2 = new ez(d, str, i);
            this.f4617a.put(eyVar, ezVar2);
            ezVar = ezVar2;
        } else {
            ezVar = ezVar2;
        }
        this.f4618b.remove(eyVar);
        this.f4618b.add(eyVar);
        ezVar.m8158g();
        while (this.f4618b.size() > ((Integer) cq.al.m7801c()).intValue()) {
            ey eyVar2 = (ey) this.f4618b.remove();
            ez ezVar3 = (ez) this.f4617a.get(eyVar2);
            ex.m8130a("Evicting interstitial queue for %s.", eyVar2);
            while (ezVar3.m8155d() > 0) {
                ezVar3.m8150a(null).f4621a.m6535H();
            }
            this.f4617a.remove(eyVar2);
        }
        while (ezVar.m8155d() > 0) {
            C1485a a = ezVar.m8150a(d);
            if (!a.f4625e || C1319u.m7187i().mo1723a() - a.f4624d <= 1000 * ((long) ((Integer) cq.an.m7801c()).intValue())) {
                String str2 = a.f4622b != null ? " (inline) " : " ";
                ex.m8130a(new StringBuilder(String.valueOf(str2).length() + 34).append("Pooled interstitial").append(str2).append("returned at %s.").toString(), eyVar);
                return a;
            }
            ex.m8130a("Expired interstitial at %s.", eyVar);
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m8138a() {
        /*
        r9 = this;
        r8 = 2;
        r0 = r9.f4619c;
        if (r0 != 0) goto L_0x0006;
    L_0x0005:
        return;
    L_0x0006:
        r0 = r9.f4617a;
        r0 = r0.entrySet();
        r3 = r0.iterator();
    L_0x0010:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x0076;
    L_0x0016:
        r0 = r3.next();
        r0 = (java.util.Map.Entry) r0;
        r1 = r0.getKey();
        r1 = (com.google.android.gms.p031b.ey) r1;
        r0 = r0.getValue();
        r0 = (com.google.android.gms.p031b.ez) r0;
        r2 = com.google.android.gms.ads.internal.util.client.C1324b.m7229a(r8);
        if (r2 == 0) goto L_0x0056;
    L_0x002e:
        r2 = r0.m8155d();
        r4 = r0.m8156e();
        if (r4 >= r2) goto L_0x0056;
    L_0x0038:
        r5 = "Loading %s/%s pooled interstitials for %s.";
        r6 = 3;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r4 = r2 - r4;
        r4 = java.lang.Integer.valueOf(r4);
        r6[r7] = r4;
        r4 = 1;
        r2 = java.lang.Integer.valueOf(r2);
        r6[r4] = r2;
        r6[r8] = r1;
        r2 = java.lang.String.format(r5, r6);
        com.google.android.gms.p031b.jv.m9152e(r2);
    L_0x0056:
        r0.m8157f();
    L_0x0059:
        r4 = r0.m8155d();
        r2 = com.google.android.gms.p031b.cq.am;
        r2 = r2.m7801c();
        r2 = (java.lang.Integer) r2;
        r2 = r2.intValue();
        if (r4 >= r2) goto L_0x0010;
    L_0x006b:
        r2 = "Pooling and loading one new interstitial for %s.";
        com.google.android.gms.p031b.ex.m8130a(r2, r1);
        r2 = r9.f4619c;
        r0.m8151a(r2);
        goto L_0x0059;
    L_0x0076:
        r9.m8140b();
        goto L_0x0005;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.ex.a():void");
    }

    void m8139a(eu euVar) {
        if (this.f4619c == null) {
            this.f4619c = euVar.m8083b();
            m8142c();
        }
    }

    void m8140b() {
        if (this.f4619c != null) {
            Editor edit = this.f4619c.m8080a().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0).edit();
            edit.clear();
            for (Entry entry : this.f4617a.entrySet()) {
                ey eyVar = (ey) entry.getKey();
                ez ezVar = (ez) entry.getValue();
                if (ezVar.m8159h()) {
                    edit.putString(eyVar.toString(), new fb(ezVar).m8218a());
                    ex.m8130a("Saved interstitial queue for %s.", eyVar);
                }
            }
            edit.putString("PoolKeys", m8136e());
            edit.apply();
        }
    }

    void m8141b(AdRequestParcel adRequestParcel, String str) {
        if (this.f4619c != null) {
            int i = new C1609a(this.f4619c.m8080a()).m8968a().f5282m;
            AdRequestParcel d = ex.m8135d(adRequestParcel);
            ey eyVar = new ey(d, str, i);
            ez ezVar = (ez) this.f4617a.get(eyVar);
            if (ezVar == null) {
                ex.m8130a("Interstitial pool created at %s.", eyVar);
                ezVar = new ez(d, str, i);
                this.f4617a.put(eyVar, ezVar);
            }
            ezVar.m8152a(this.f4619c, adRequestParcel);
            ezVar.m8158g();
            ex.m8130a("Inline entry added to the queue at %s.", eyVar);
        }
    }

    void m8142c() {
        Throwable e;
        if (this.f4619c != null) {
            ey eyVar;
            SharedPreferences sharedPreferences = this.f4619c.m8080a().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0);
            m8143d();
            Map hashMap = new HashMap();
            for (Entry entry : sharedPreferences.getAll().entrySet()) {
                try {
                    if (!((String) entry.getKey()).equals("PoolKeys")) {
                        fb fbVar = new fb((String) entry.getValue());
                        eyVar = new ey(fbVar.f4705a, fbVar.f4706b, fbVar.f4707c);
                        if (!this.f4617a.containsKey(eyVar)) {
                            this.f4617a.put(eyVar, new ez(fbVar.f4705a, fbVar.f4706b, fbVar.f4707c));
                            hashMap.put(eyVar.toString(), eyVar);
                            ex.m8130a("Restored interstitial queue for %s.", eyVar);
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    C1324b.m7235d("Malformed preferences value for InterstitialAdPool.", e);
                } catch (ClassCastException e3) {
                    e = e3;
                    C1324b.m7235d("Malformed preferences value for InterstitialAdPool.", e);
                }
            }
            for (Object obj : m8131a(sharedPreferences.getString("PoolKeys", ""))) {
                eyVar = (ey) hashMap.get(obj);
                if (this.f4617a.containsKey(eyVar)) {
                    this.f4618b.add(eyVar);
                }
            }
        }
    }

    void m8143d() {
        while (this.f4618b.size() > 0) {
            ey eyVar = (ey) this.f4618b.remove();
            ez ezVar = (ez) this.f4617a.get(eyVar);
            ex.m8130a("Flushing interstitial queue for %s.", eyVar);
            while (ezVar.m8155d() > 0) {
                ezVar.m8150a(null).f4621a.m6535H();
            }
            this.f4617a.remove(eyVar);
        }
    }
}
