package android.support.v4.app;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.p015g.C0381h;
import android.view.View;

public class C0236e {

    private static class C0237a extends C0236e {
        private final C0238f f862a;

        C0237a(C0238f c0238f) {
            this.f862a = c0238f;
        }

        public Bundle mo183a() {
            return this.f862a.m1332a();
        }
    }

    protected C0236e() {
    }

    public static C0236e m1328a(Activity activity, C0381h<View, String>... c0381hArr) {
        String[] strArr = null;
        if (VERSION.SDK_INT < 21) {
            return new C0236e();
        }
        View[] viewArr;
        if (c0381hArr != null) {
            View[] viewArr2 = new View[c0381hArr.length];
            String[] strArr2 = new String[c0381hArr.length];
            for (int i = 0; i < c0381hArr.length; i++) {
                viewArr2[i] = (View) c0381hArr[i].f1143a;
                strArr2[i] = (String) c0381hArr[i].f1144b;
            }
            strArr = strArr2;
            viewArr = viewArr2;
        } else {
            viewArr = null;
        }
        return new C0237a(C0238f.m1331a(activity, viewArr, strArr));
    }

    public Bundle mo183a() {
        return null;
    }
}
