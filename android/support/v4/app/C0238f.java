package android.support.v4.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

class C0238f {
    private final ActivityOptions f863a;

    private C0238f(ActivityOptions activityOptions) {
        this.f863a = activityOptions;
    }

    public static C0238f m1331a(Activity activity, View[] viewArr, String[] strArr) {
        Pair[] pairArr = null;
        if (viewArr != null) {
            Pair[] pairArr2 = new Pair[viewArr.length];
            for (int i = 0; i < pairArr2.length; i++) {
                pairArr2[i] = Pair.create(viewArr[i], strArr[i]);
            }
            pairArr = pairArr2;
        }
        return new C0238f(ActivityOptions.makeSceneTransitionAnimation(activity, pairArr));
    }

    public Bundle m1332a() {
        return this.f863a.toBundle();
    }
}
