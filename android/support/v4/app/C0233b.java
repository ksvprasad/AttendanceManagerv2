package android.support.v4.app;

import android.app.Activity;

class C0233b {

    public interface C0232a {
        void mo215a(int i);
    }

    public static void m1324a(Activity activity, String[] strArr, int i) {
        if (activity instanceof C0232a) {
            ((C0232a) activity).mo215a(i);
        }
        activity.requestPermissions(strArr, i);
    }
}
