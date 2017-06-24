package com.rey.material.p042c;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.TypedValue;
import com.rey.material.C2167a.C2161a;

public class C2174b {
    private static TypedValue f7312a;

    public static int m12394a(Context context, int i) {
        return (int) (TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics()) + 0.5f);
    }

    private static int m12395a(Context context, int i, int i2) {
        if (f7312a == null) {
            f7312a = new TypedValue();
        }
        try {
            Theme theme = context.getTheme();
            return (theme == null || !theme.resolveAttribute(i, f7312a, true)) ? i2 : (f7312a.type < 16 || f7312a.type > 31) ? f7312a.type == 3 ? context.getResources().getColor(f7312a.resourceId) : i2 : f7312a.data;
        } catch (Exception e) {
            return i2;
        }
    }

    public static int m12396a(TypedArray typedArray, int i) {
        if (VERSION.SDK_INT >= 21) {
            return typedArray.getType(i);
        }
        TypedValue peekValue = typedArray.peekValue(i);
        return peekValue == null ? 0 : peekValue.type;
    }

    @TargetApi(21)
    public static int m12397b(Context context, int i) {
        return VERSION.SDK_INT >= 21 ? C2174b.m12395a(context, 16843817, i) : C2174b.m12395a(context, C2161a.colorControlNormal, i);
    }

    @TargetApi(21)
    public static int m12398c(Context context, int i) {
        return VERSION.SDK_INT >= 21 ? C2174b.m12395a(context, 16843818, i) : C2174b.m12395a(context, C2161a.colorControlActivated, i);
    }

    @TargetApi(21)
    public static int m12399d(Context context, int i) {
        return VERSION.SDK_INT >= 21 ? C2174b.m12395a(context, 16843820, i) : C2174b.m12395a(context, C2161a.colorControlHighlight, i);
    }
}
