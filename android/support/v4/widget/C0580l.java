package android.support.v4.widget;

import android.os.Build.VERSION;
import android.widget.ListView;

public final class C0580l {
    public static void m3122a(ListView listView, int i) {
        if (VERSION.SDK_INT >= 19) {
            C0582n.m3124a(listView, i);
        } else {
            C0581m.m3123a(listView, i);
        }
    }
}
