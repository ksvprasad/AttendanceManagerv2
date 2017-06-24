package com.google.android.gms.p031b;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.client.C1120y;
import com.google.android.gms.ads.internal.util.client.C1323a;
import com.google.android.gms.common.api.C1458f;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

@id
public abstract class eq implements C1458f {
    protected Context f4565a;
    protected String f4566b;
    protected WeakReference<la> f4567c;

    public eq(la laVar) {
        this.f4565a = laVar.getContext();
        this.f4566b = C1319u.m7183e().m9204a(this.f4565a, laVar.mo1525o().f3957b);
        this.f4567c = new WeakReference(laVar);
    }

    private void m8064a(String str, Map<String, String> map) {
        la laVar = (la) this.f4567c.get();
        if (laVar != null) {
            laVar.mo1501a(str, (Map) map);
        }
    }

    private String m8065c(String str) {
        String str2 = "internal";
        Object obj = -1;
        switch (str.hashCode()) {
            case -1396664534:
                if (str.equals("badUrl")) {
                    obj = 6;
                    break;
                }
                break;
            case -1347010958:
                if (str.equals("inProgress")) {
                    obj = 2;
                    break;
                }
                break;
            case -918817863:
                if (str.equals("downloadTimeout")) {
                    obj = 7;
                    break;
                }
                break;
            case -659376217:
                if (str.equals("contentLengthMissing")) {
                    obj = 3;
                    break;
                }
                break;
            case -642208130:
                if (str.equals("playerFailed")) {
                    obj = 1;
                    break;
                }
                break;
            case -354048396:
                if (str.equals("sizeExceeded")) {
                    obj = 8;
                    break;
                }
                break;
            case -32082395:
                if (str.equals("externalAbort")) {
                    obj = 9;
                    break;
                }
                break;
            case 96784904:
                if (str.equals("error")) {
                    obj = null;
                    break;
                }
                break;
            case 580119100:
                if (str.equals("expireFailed")) {
                    obj = 5;
                    break;
                }
                break;
            case 725497484:
                if (str.equals("noCacheDir")) {
                    obj = 4;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
            case 1:
            case 2:
            case 3:
                return "internal";
            case 4:
            case 5:
                return "io";
            case 6:
            case 7:
                return "network";
            case 8:
            case 9:
                return "policy";
            default:
                return str2;
        }
    }

    public void mo1308a() {
    }

    protected void m8067a(final String str, final String str2, final int i) {
        C1323a.f3964a.post(new Runnable(this) {
            final /* synthetic */ eq f4559d;

            public void run() {
                Map hashMap = new HashMap();
                hashMap.put("event", "precacheComplete");
                hashMap.put("src", str);
                hashMap.put("cachedSrc", str2);
                hashMap.put("totalBytes", Integer.toString(i));
                this.f4559d.m8064a("onPrecacheEvent", hashMap);
            }
        });
    }

    protected void m8068a(String str, String str2, int i, int i2, boolean z) {
        final String str3 = str;
        final String str4 = str2;
        final int i3 = i;
        final int i4 = i2;
        final boolean z2 = z;
        C1323a.f3964a.post(new Runnable(this) {
            final /* synthetic */ eq f4555f;

            public void run() {
                Map hashMap = new HashMap();
                hashMap.put("event", "precacheProgress");
                hashMap.put("src", str3);
                hashMap.put("cachedSrc", str4);
                hashMap.put("bytesLoaded", Integer.toString(i3));
                hashMap.put("totalBytes", Integer.toString(i4));
                hashMap.put("cacheReady", z2 ? "1" : "0");
                this.f4555f.m8064a("onPrecacheEvent", hashMap);
            }
        });
    }

    protected void m8069a(String str, String str2, String str3, String str4) {
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        C1323a.f3964a.post(new Runnable(this) {
            final /* synthetic */ eq f4564e;

            public void run() {
                Map hashMap = new HashMap();
                hashMap.put("event", "precacheCanceled");
                hashMap.put("src", str5);
                if (!TextUtils.isEmpty(str6)) {
                    hashMap.put("cachedSrc", str6);
                }
                hashMap.put("type", this.f4564e.m8065c(str7));
                hashMap.put("reason", str7);
                if (!TextUtils.isEmpty(str8)) {
                    hashMap.put("message", str8);
                }
                this.f4564e.m8064a("onPrecacheEvent", hashMap);
            }
        });
    }

    public abstract boolean mo1309a(String str);

    protected String m8071b(String str) {
        return C1120y.m6293a().m7211a(str);
    }

    public abstract void mo1310b();
}
