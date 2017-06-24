package com.rey.material.p042c;

import android.content.Context;
import android.graphics.Typeface;
import java.util.HashMap;

public class C2175c {
    private static final HashMap<String, Typeface> f7313a = new HashMap();

    public static Typeface m12400a(Context context, String str, int i) {
        if (str == null || !str.startsWith("asset:")) {
            return Typeface.create(str, i);
        }
        synchronized (f7313a) {
            try {
                Typeface typeface;
                if (f7313a.containsKey(str)) {
                    typeface = (Typeface) f7313a.get(str);
                    return typeface;
                }
                typeface = Typeface.createFromAsset(context.getAssets(), str.substring("asset:".length()));
                f7313a.put(str, typeface);
                return typeface;
            } catch (Exception e) {
                return Typeface.DEFAULT;
            }
        }
    }
}
