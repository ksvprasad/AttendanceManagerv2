package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.TextView;

public final class C0608x {
    static final C0602f f1406a;

    interface C0602f {
        int mo508a(TextView textView);

        void mo509a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4);
    }

    static class C0603b implements C0602f {
        C0603b() {
        }

        public int mo508a(TextView textView) {
            return C0609y.m3227a(textView);
        }

        public void mo509a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }
    }

    static class C0604e extends C0603b {
        C0604e() {
        }

        public int mo508a(TextView textView) {
            return C0610z.m3230a(textView);
        }
    }

    static class C0605c extends C0604e {
        C0605c() {
        }

        public void mo509a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            aa.m3004a(textView, drawable, drawable2, drawable3, drawable4);
        }
    }

    static class C0606d extends C0605c {
        C0606d() {
        }

        public void mo509a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            ab.m3005a(textView, drawable, drawable2, drawable3, drawable4);
        }
    }

    static class C0607a extends C0606d {
        C0607a() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f1406a = new C0607a();
        } else if (i >= 18) {
            f1406a = new C0606d();
        } else if (i >= 17) {
            f1406a = new C0605c();
        } else if (i >= 16) {
            f1406a = new C0604e();
        } else {
            f1406a = new C0603b();
        }
    }

    public static int m3225a(TextView textView) {
        return f1406a.mo508a(textView);
    }

    public static void m3226a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        f1406a.mo509a(textView, drawable, drawable2, drawable3, drawable4);
    }
}
