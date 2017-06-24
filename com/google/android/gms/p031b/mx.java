package com.google.android.gms.p031b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.p015g.C0370a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

@TargetApi(11)
public final class mx extends Fragment implements mw {
    private static WeakHashMap<Activity, WeakReference<mx>> f6016a = new WeakHashMap();
    private Map<String, mv> f6017b = new C0370a();
    private int f6018c = 0;
    private Bundle f6019d;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.p031b.mx m10080a(android.app.Activity r3) {
        /*
        r0 = f6016a;
        r0 = r0.get(r3);
        r0 = (java.lang.ref.WeakReference) r0;
        if (r0 == 0) goto L_0x0013;
    L_0x000a:
        r0 = r0.get();
        r0 = (com.google.android.gms.p031b.mx) r0;
        if (r0 == 0) goto L_0x0013;
    L_0x0012:
        return r0;
    L_0x0013:
        r0 = r3.getFragmentManager();	 Catch:{ ClassCastException -> 0x0048 }
        r1 = "LifecycleFragmentImpl";
        r0 = r0.findFragmentByTag(r1);	 Catch:{ ClassCastException -> 0x0048 }
        r0 = (com.google.android.gms.p031b.mx) r0;	 Catch:{ ClassCastException -> 0x0048 }
        if (r0 == 0) goto L_0x0027;
    L_0x0021:
        r1 = r0.isRemoving();
        if (r1 == 0) goto L_0x003d;
    L_0x0027:
        r0 = new com.google.android.gms.b.mx;
        r0.<init>();
        r1 = r3.getFragmentManager();
        r1 = r1.beginTransaction();
        r2 = "LifecycleFragmentImpl";
        r1 = r1.add(r0, r2);
        r1.commitAllowingStateLoss();
    L_0x003d:
        r1 = f6016a;
        r2 = new java.lang.ref.WeakReference;
        r2.<init>(r0);
        r1.put(r3, r2);
        goto L_0x0012;
    L_0x0048:
        r0 = move-exception;
        r1 = new java.lang.IllegalStateException;
        r2 = "Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl";
        r1.<init>(r2, r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.mx.a(android.app.Activity):com.google.android.gms.b.mx");
    }

    private void m10082b(final String str, final mv mvVar) {
        if (this.f6018c > 0) {
            new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ mx f6015c;

                public void run() {
                    if (this.f6015c.f6018c >= 1) {
                        mvVar.mo1567a(this.f6015c.f6019d != null ? this.f6015c.f6019d.getBundle(str) : null);
                    }
                    if (this.f6015c.f6018c >= 2) {
                        mvVar.mo1565a();
                    }
                    if (this.f6015c.f6018c >= 3) {
                        mvVar.mo1568b();
                    }
                }
            });
        }
    }

    public Activity mo1616a() {
        return getActivity();
    }

    public <T extends mv> T mo1617a(String str, Class<T> cls) {
        return (mv) cls.cast(this.f6017b.get(str));
    }

    public void mo1618a(String str, mv mvVar) {
        if (this.f6017b.containsKey(str)) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 59).append("LifecycleCallback with tag ").append(str).append(" already added to this fragment.").toString());
        }
        this.f6017b.put(str, mvVar);
        m10082b(str, mvVar);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (mv a : this.f6017b.values()) {
            a.mo1571a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (mv a : this.f6017b.values()) {
            a.mo1566a(i, i2, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6018c = 1;
        this.f6019d = bundle;
        for (Entry entry : this.f6017b.entrySet()) {
            ((mv) entry.getValue()).mo1567a(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Entry entry : this.f6017b.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((mv) entry.getValue()).mo1569b(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public void onStart() {
        super.onStop();
        this.f6018c = 2;
        for (mv a : this.f6017b.values()) {
            a.mo1565a();
        }
    }

    public void onStop() {
        super.onStop();
        this.f6018c = 3;
        for (mv b : this.f6017b.values()) {
            b.mo1568b();
        }
    }
}
