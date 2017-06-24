package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.p019b.C0694a.C0683a;
import android.support.v7.p019b.C0694a.C0693k;
import android.support.v7.p022f.C0702a;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

class C0822z {
    private static final int[] f2359b = new int[]{16842804, 16843119, 16843117, 16843120, 16843118};
    private static final int[] f2360c = new int[]{C0683a.textAllCaps};
    final TextView f2361a;
    private bf f2362d;
    private bf f2363e;
    private bf f2364f;
    private bf f2365g;

    C0822z(TextView textView) {
        this.f2361a = textView;
    }

    protected static bf m4832a(Context context, C0893m c0893m, int i) {
        ColorStateList b = c0893m.m5451b(context, i);
        if (b == null) {
            return null;
        }
        bf bfVar = new bf();
        bfVar.f2592d = true;
        bfVar.f2589a = b;
        return bfVar;
    }

    static C0822z m4833a(TextView textView) {
        return VERSION.SDK_INT >= 17 ? new aa(textView) : new C0822z(textView);
    }

    void mo772a() {
        if (this.f2362d != null || this.f2363e != null || this.f2364f != null || this.f2365g != null) {
            Drawable[] compoundDrawables = this.f2361a.getCompoundDrawables();
            m4836a(compoundDrawables[0], this.f2362d);
            m4836a(compoundDrawables[1], this.f2363e);
            m4836a(compoundDrawables[2], this.f2364f);
            m4836a(compoundDrawables[3], this.f2365g);
        }
    }

    void m4835a(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, f2360c);
        if (obtainStyledAttributes.hasValue(0)) {
            m4838a(obtainStyledAttributes.getBoolean(0, false));
        }
        obtainStyledAttributes.recycle();
    }

    final void m4836a(Drawable drawable, bf bfVar) {
        if (drawable != null && bfVar != null) {
            C0893m.m5428a(drawable, bfVar, this.f2361a.getDrawableState());
        }
    }

    void mo773a(AttributeSet attributeSet, int i) {
        int i2 = 1;
        Context context = this.f2361a.getContext();
        C0893m a = C0893m.m5425a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2359b, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        if (obtainStyledAttributes.hasValue(1)) {
            this.f2362d = C0822z.m4832a(context, a, obtainStyledAttributes.getResourceId(1, 0));
        }
        if (obtainStyledAttributes.hasValue(2)) {
            this.f2363e = C0822z.m4832a(context, a, obtainStyledAttributes.getResourceId(2, 0));
        }
        if (obtainStyledAttributes.hasValue(3)) {
            this.f2364f = C0822z.m4832a(context, a, obtainStyledAttributes.getResourceId(3, 0));
        }
        if (obtainStyledAttributes.hasValue(4)) {
            this.f2365g = C0822z.m4832a(context, a, obtainStyledAttributes.getResourceId(4, 0));
        }
        obtainStyledAttributes.recycle();
        if (!(this.f2361a.getTransformationMethod() instanceof PasswordTransformationMethod)) {
            boolean z;
            int i3;
            boolean z2;
            if (resourceId != -1) {
                TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, C0693k.TextAppearance);
                if (obtainStyledAttributes2.hasValue(C0693k.TextAppearance_textAllCaps)) {
                    z = obtainStyledAttributes2.getBoolean(C0693k.TextAppearance_textAllCaps, false);
                    i3 = 1;
                } else {
                    z2 = false;
                    z = false;
                }
                obtainStyledAttributes2.recycle();
            } else {
                z2 = false;
                z = false;
            }
            TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f2360c, i, 0);
            if (obtainStyledAttributes3.hasValue(0)) {
                z = obtainStyledAttributes3.getBoolean(0, false);
            } else {
                i2 = i3;
            }
            obtainStyledAttributes3.recycle();
            if (i2 != 0) {
                m4838a(z);
            }
        }
    }

    void m4838a(boolean z) {
        this.f2361a.setTransformationMethod(z ? new C0702a(this.f2361a.getContext()) : null);
    }
}
