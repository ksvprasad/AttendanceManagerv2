package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.gms.C1004a.C0997c;
import com.google.android.gms.ads.C1029d;
import com.google.android.gms.p031b.id;

@id
public final class C1111w {
    private final C1029d[] f3243a;
    private final String f3244b;

    public C1111w(Context context, AttributeSet attributeSet) {
        Object obj = 1;
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, C0997c.AdsAttrs);
        String string = obtainAttributes.getString(C0997c.AdsAttrs_adSize);
        String string2 = obtainAttributes.getString(C0997c.AdsAttrs_adSizes);
        Object obj2 = !TextUtils.isEmpty(string) ? 1 : null;
        if (TextUtils.isEmpty(string2)) {
            obj = null;
        }
        if (obj2 != null && r1 == null) {
            this.f3243a = C1111w.m6246a(string);
        } else if (obj2 == null && r1 != null) {
            this.f3243a = C1111w.m6246a(string2);
        } else if (obj2 != null) {
            throw new IllegalArgumentException("Either XML attribute \"adSize\" or XML attribute \"supportedAdSizes\" should be specified, but not both.");
        } else {
            throw new IllegalArgumentException("Required XML attribute \"adSize\" was missing.");
        }
        this.f3244b = obtainAttributes.getString(C0997c.AdsAttrs_adUnitId);
        if (TextUtils.isEmpty(this.f3244b)) {
            throw new IllegalArgumentException("Required XML attribute \"adUnitId\" was missing.");
        }
    }

    private static C1029d[] m6246a(String str) {
        String str2;
        String valueOf;
        String[] split = str.split("\\s*,\\s*");
        C1029d[] c1029dArr = new C1029d[split.length];
        for (int i = 0; i < split.length; i++) {
            String trim = split[i].trim();
            if (trim.matches("^(\\d+|FULL_WIDTH)\\s*[xX]\\s*(\\d+|AUTO_HEIGHT)$")) {
                String[] split2 = trim.split("[xX]");
                split2[0] = split2[0].trim();
                split2[1] = split2[1].trim();
                try {
                    c1029dArr[i] = new C1029d("FULL_WIDTH".equals(split2[0]) ? -1 : Integer.parseInt(split2[0]), "AUTO_HEIGHT".equals(split2[1]) ? -2 : Integer.parseInt(split2[1]));
                } catch (NumberFormatException e) {
                    str2 = "Could not parse XML attribute \"adSize\": ";
                    valueOf = String.valueOf(trim);
                    throw new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                }
            } else if ("BANNER".equals(trim)) {
                c1029dArr[i] = C1029d.f3015a;
            } else if ("LARGE_BANNER".equals(trim)) {
                c1029dArr[i] = C1029d.f3017c;
            } else if ("FULL_BANNER".equals(trim)) {
                c1029dArr[i] = C1029d.f3016b;
            } else if ("LEADERBOARD".equals(trim)) {
                c1029dArr[i] = C1029d.f3018d;
            } else if ("MEDIUM_RECTANGLE".equals(trim)) {
                c1029dArr[i] = C1029d.f3019e;
            } else if ("SMART_BANNER".equals(trim)) {
                c1029dArr[i] = C1029d.f3021g;
            } else if ("WIDE_SKYSCRAPER".equals(trim)) {
                c1029dArr[i] = C1029d.f3020f;
            } else if ("FLUID".equals(trim)) {
                c1029dArr[i] = C1029d.f3022h;
            } else {
                str2 = "Could not parse XML attribute \"adSize\": ";
                valueOf = String.valueOf(trim);
                throw new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            }
        }
        if (c1029dArr.length != 0) {
            return c1029dArr;
        }
        str2 = "Could not parse XML attribute \"adSize\": ";
        valueOf = String.valueOf(str);
        throw new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
    }

    public String m6247a() {
        return this.f3244b;
    }

    public C1029d[] m6248a(boolean z) {
        if (z || this.f3243a.length == 1) {
            return this.f3243a;
        }
        throw new IllegalArgumentException("The adSizes XML attribute is only allowed on PublisherAdViews.");
    }
}
