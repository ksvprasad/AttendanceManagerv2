package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.ap.C0227a;

class aq {
    static Bundle m1311a(C0227a c0227a) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", c0227a.mo178a());
        bundle.putCharSequence("label", c0227a.mo179b());
        bundle.putCharSequenceArray("choices", c0227a.mo180c());
        bundle.putBoolean("allowFreeFormInput", c0227a.mo181d());
        bundle.putBundle("extras", c0227a.mo182e());
        return bundle;
    }

    static Bundle[] m1312a(C0227a[] c0227aArr) {
        if (c0227aArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[c0227aArr.length];
        for (int i = 0; i < c0227aArr.length; i++) {
            bundleArr[i] = m1311a(c0227aArr[i]);
        }
        return bundleArr;
    }
}
