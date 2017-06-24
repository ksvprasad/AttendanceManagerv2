package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.CompoundButton;

public final class C0562b {
    private static final C0558c f1379a;

    interface C0558c {
        Drawable mo470a(CompoundButton compoundButton);

        void mo471a(CompoundButton compoundButton, ColorStateList colorStateList);

        void mo472a(CompoundButton compoundButton, Mode mode);
    }

    static class C0559b implements C0558c {
        C0559b() {
        }

        public Drawable mo470a(CompoundButton compoundButton) {
            return C0564d.m3055a(compoundButton);
        }

        public void mo471a(CompoundButton compoundButton, ColorStateList colorStateList) {
            C0564d.m3056a(compoundButton, colorStateList);
        }

        public void mo472a(CompoundButton compoundButton, Mode mode) {
            C0564d.m3057a(compoundButton, mode);
        }
    }

    static class C0560d extends C0559b {
        C0560d() {
        }

        public void mo471a(CompoundButton compoundButton, ColorStateList colorStateList) {
            C0565e.m3058a(compoundButton, colorStateList);
        }

        public void mo472a(CompoundButton compoundButton, Mode mode) {
            C0565e.m3059a(compoundButton, mode);
        }
    }

    static class C0561a extends C0560d {
        C0561a() {
        }

        public Drawable mo470a(CompoundButton compoundButton) {
            return C0563c.m3054a(compoundButton);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f1379a = new C0561a();
        } else if (i >= 21) {
            f1379a = new C0560d();
        } else {
            f1379a = new C0559b();
        }
    }

    public static Drawable m3051a(CompoundButton compoundButton) {
        return f1379a.mo470a(compoundButton);
    }

    public static void m3052a(CompoundButton compoundButton, ColorStateList colorStateList) {
        f1379a.mo471a(compoundButton, colorStateList);
    }

    public static void m3053a(CompoundButton compoundButton, Mode mode) {
        f1379a.mo472a(compoundButton, mode);
    }
}
