package com.rey.material.p040a;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import com.rey.material.C2167a.C2162b;

public class C2166a {
    private static volatile C2166a f7228a;
    private Context f7229b;
    private SparseArray<int[]> f7230c = new SparseArray();
    private int f7231d;
    private C2163a f7232e;

    public interface C2163a {
        void m12334a(C2165c c2165c);

        void m12335b(C2165c c2165c);
    }

    public static class C2164b {
    }

    public interface C2165c {
    }

    public static int m12336a(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2162b.ThemableView, i, i2);
        int resourceId = obtainStyledAttributes.getResourceId(C2162b.ThemableView_v_styleId, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public static C2166a m12337a() {
        if (f7228a == null) {
            synchronized (C2166a.class) {
                if (f7228a == null) {
                    f7228a = new C2166a();
                }
            }
        }
        return f7228a;
    }

    private int[] m12338a(Context context, int i) {
        if (context == null) {
            return null;
        }
        TypedArray obtainTypedArray = context.getResources().obtainTypedArray(i);
        int[] iArr = new int[obtainTypedArray.length()];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = obtainTypedArray.getResourceId(i2, 0);
        }
        obtainTypedArray.recycle();
        return iArr;
    }

    private int[] m12339b(int i) {
        if (this.f7230c == null) {
            return null;
        }
        int[] iArr = (int[]) this.f7230c.get(i);
        if (iArr != null) {
            return iArr;
        }
        Object a = m12338a(this.f7229b, i);
        this.f7230c.put(i, a);
        return a;
    }

    public int m12340a(int i) {
        return m12341a(i, this.f7231d);
    }

    public int m12341a(int i, int i2) {
        int[] b = m12339b(i);
        return b == null ? 0 : b[i2];
    }

    public void m12342a(C2165c c2165c) {
        if (this.f7232e != null) {
            this.f7232e.m12334a(c2165c);
        }
    }

    public void m12343b(C2165c c2165c) {
        if (this.f7232e != null) {
            this.f7232e.m12335b(c2165c);
        }
    }
}
