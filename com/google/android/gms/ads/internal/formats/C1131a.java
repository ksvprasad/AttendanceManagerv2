package com.google.android.gms.ads.internal.formats;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.google.android.gms.p031b.id;
import java.util.List;

@id
public class C1131a {
    static final int f3302a = f3305d;
    static final int f3303b = f3304c;
    private static final int f3304c = Color.rgb(12, 174, 206);
    private static final int f3305d = Color.rgb(204, 204, 204);
    private final String f3306e;
    private final List<Drawable> f3307f;
    private final int f3308g;
    private final int f3309h;
    private final int f3310i;
    private final int f3311j;
    private final int f3312k;

    public C1131a(String str, List<Drawable> list, Integer num, Integer num2, Integer num3, int i, int i2) {
        this.f3306e = str;
        this.f3307f = list;
        this.f3308g = num != null ? num.intValue() : f3302a;
        this.f3309h = num2 != null ? num2.intValue() : f3303b;
        this.f3310i = num3 != null ? num3.intValue() : 12;
        this.f3311j = i;
        this.f3312k = i2;
    }

    public String m6320a() {
        return this.f3306e;
    }

    public List<Drawable> m6321b() {
        return this.f3307f;
    }

    public int m6322c() {
        return this.f3308g;
    }

    public int m6323d() {
        return this.f3309h;
    }

    public int m6324e() {
        return this.f3310i;
    }

    public int m6325f() {
        return this.f3311j;
    }

    public int m6326g() {
        return this.f3312k;
    }
}
