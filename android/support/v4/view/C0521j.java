package android.support.v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.View;

class C0521j {

    static class C0520a implements Factory {
        final C0271m f1285a;

        C0520a(C0271m c0271m) {
            this.f1285a = c0271m;
        }

        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.f1285a.mo225a(null, str, context, attributeSet);
        }

        public String toString() {
            return getClass().getName() + "{" + this.f1285a + "}";
        }
    }

    static C0271m m2822a(LayoutInflater layoutInflater) {
        Factory factory = layoutInflater.getFactory();
        return factory instanceof C0520a ? ((C0520a) factory).f1285a : null;
    }

    static void m2823a(LayoutInflater layoutInflater, C0271m c0271m) {
        layoutInflater.setFactory(c0271m != null ? new C0520a(c0271m) : null);
    }
}
