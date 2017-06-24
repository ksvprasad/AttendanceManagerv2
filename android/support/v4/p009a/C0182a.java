package android.support.v4.p009a;

import android.os.Build.VERSION;
import android.view.View;

public final class C0182a {
    private static final C0183b f717a;

    static {
        if (VERSION.SDK_INT >= 12) {
            f717a = new C0185d();
        } else {
            f717a = new C0184c();
        }
    }

    public static void m1123a(View view) {
        f717a.mo166a(view);
    }
}
