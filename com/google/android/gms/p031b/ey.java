package com.google.android.gms.p031b;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@id
class ey {
    private final Object[] f4620a;

    ey(AdRequestParcel adRequestParcel, String str, int i) {
        this.f4620a = ey.m8145a(adRequestParcel, str, i);
    }

    private static String m8144a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Collections.sort(new ArrayList(bundle.keySet()));
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            String str2 = obj == null ? "null" : obj instanceof Bundle ? ey.m8144a((Bundle) obj) : obj.toString();
            stringBuilder.append(str2);
        }
        return stringBuilder.toString();
    }

    private static Object[] m8145a(AdRequestParcel adRequestParcel, String str, int i) {
        Set hashSet = new HashSet(Arrays.asList(((String) cq.aj.m7801c()).split(",")));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        if (hashSet.contains("networkType")) {
            arrayList.add(Integer.valueOf(i));
        }
        if (hashSet.contains("birthday")) {
            arrayList.add(Long.valueOf(adRequestParcel.f3086b));
        }
        if (hashSet.contains("extras")) {
            arrayList.add(ey.m8144a(adRequestParcel.f3087c));
        }
        if (hashSet.contains("gender")) {
            arrayList.add(Integer.valueOf(adRequestParcel.f3088d));
        }
        if (hashSet.contains("keywords")) {
            if (adRequestParcel.f3089e != null) {
                arrayList.add(adRequestParcel.f3089e.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("isTestDevice")) {
            arrayList.add(Boolean.valueOf(adRequestParcel.f3090f));
        }
        if (hashSet.contains("tagForChildDirectedTreatment")) {
            arrayList.add(Integer.valueOf(adRequestParcel.f3091g));
        }
        if (hashSet.contains("manualImpressionsEnabled")) {
            arrayList.add(Boolean.valueOf(adRequestParcel.f3092h));
        }
        if (hashSet.contains("publisherProvidedId")) {
            arrayList.add(adRequestParcel.f3093i);
        }
        if (hashSet.contains("location")) {
            if (adRequestParcel.f3095k != null) {
                arrayList.add(adRequestParcel.f3095k.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("contentUrl")) {
            arrayList.add(adRequestParcel.f3096l);
        }
        if (hashSet.contains("networkExtras")) {
            arrayList.add(ey.m8144a(adRequestParcel.f3097m));
        }
        if (hashSet.contains("customTargeting")) {
            arrayList.add(ey.m8144a(adRequestParcel.f3098n));
        }
        if (hashSet.contains("categoryExclusions")) {
            if (adRequestParcel.f3099o != null) {
                arrayList.add(adRequestParcel.f3099o.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("requestAgent")) {
            arrayList.add(adRequestParcel.f3100p);
        }
        if (hashSet.contains("requestPackage")) {
            arrayList.add(adRequestParcel.f3101q);
        }
        return arrayList.toArray();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ey)) {
            return false;
        }
        return Arrays.equals(this.f4620a, ((ey) obj).f4620a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f4620a);
    }

    public String toString() {
        String valueOf = String.valueOf(Arrays.toString(this.f4620a));
        return new StringBuilder(String.valueOf(valueOf).length() + 24).append("[InterstitialAdPoolKey ").append(valueOf).append("]").toString();
    }
}
