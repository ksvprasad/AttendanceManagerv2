package android.support.v4.app;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.support.v4.app.ap.C0227a;

class ao {
    static RemoteInput[] m1310a(C0227a[] c0227aArr) {
        if (c0227aArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[c0227aArr.length];
        for (int i = 0; i < c0227aArr.length; i++) {
            C0227a c0227a = c0227aArr[i];
            remoteInputArr[i] = new Builder(c0227a.mo178a()).setLabel(c0227a.mo179b()).setChoices(c0227a.mo180c()).setAllowFreeFormInput(c0227a.mo181d()).addExtras(c0227a.mo182e()).build();
        }
        return remoteInputArr;
    }
}
