package android.support.v4.p010b;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;

public final class C0301f {
    private static final C0297a f1050a;

    interface C0297a {
        Intent mo244a(ComponentName componentName);
    }

    static class C0298b implements C0297a {
        C0298b() {
        }

        public Intent mo244a(ComponentName componentName) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setComponent(componentName);
            intent.addCategory("android.intent.category.LAUNCHER");
            return intent;
        }
    }

    static class C0299c extends C0298b {
        C0299c() {
        }

        public Intent mo244a(ComponentName componentName) {
            return C0302g.m1691a(componentName);
        }
    }

    static class C0300d extends C0299c {
        C0300d() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 15) {
            f1050a = new C0300d();
        } else if (i >= 11) {
            f1050a = new C0299c();
        } else {
            f1050a = new C0298b();
        }
    }

    public static Intent m1690a(ComponentName componentName) {
        return f1050a.mo244a(componentName);
    }
}
