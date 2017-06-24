package android.support.v4.view;

import android.content.Context;
import android.support.v4.view.C0521j.C0520a;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import android.view.View;
import java.lang.reflect.Field;

class C0523k {
    private static Field f1286a;
    private static boolean f1287b;

    static class C0522a extends C0520a implements Factory2 {
        C0522a(C0271m c0271m) {
            super(c0271m);
        }

        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.a.mo225a(view, str, context, attributeSet);
        }
    }

    static void m2824a(LayoutInflater layoutInflater, C0271m c0271m) {
        Factory2 c0522a = c0271m != null ? new C0522a(c0271m) : null;
        layoutInflater.setFactory2(c0522a);
        Factory factory = layoutInflater.getFactory();
        if (factory instanceof Factory2) {
            C0523k.m2825a(layoutInflater, (Factory2) factory);
        } else {
            C0523k.m2825a(layoutInflater, c0522a);
        }
    }

    static void m2825a(LayoutInflater layoutInflater, Factory2 factory2) {
        if (!f1287b) {
            try {
                f1286a = LayoutInflater.class.getDeclaredField("mFactory2");
                f1286a.setAccessible(true);
            } catch (Throwable e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            f1287b = true;
        }
        if (f1286a != null) {
            try {
                f1286a.set(layoutInflater, factory2);
            } catch (Throwable e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }
}
