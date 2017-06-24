package com.google.android.gms.p031b;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.C1876j;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1857g;
import com.google.android.gms.common.api.C1864a;
import com.google.android.gms.common.api.C1864a.C1721c;
import com.google.android.gms.common.api.C1864a.C1722f;
import com.google.android.gms.common.api.C1864a.C1827b;
import com.google.android.gms.common.api.C1864a.C1859d;
import com.google.android.gms.common.internal.C1927n;
import com.google.android.gms.p031b.mc.C1714a;
import com.google.android.gms.p031b.mt.C1744a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class mo implements mt {
    final Map<C1859d<?>, C1722f> f5948a;
    final Map<C1859d<?>, ConnectionResult> f5949b = new HashMap();
    final C1927n f5950c;
    final Map<C1864a<?>, Integer> f5951d;
    final C1827b<? extends oa, ob> f5952e;
    int f5953f;
    final ml f5954g;
    final C1744a f5955h;
    private final Lock f5956i;
    private final Condition f5957j;
    private final Context f5958k;
    private final C1876j f5959l;
    private final C1768b f5960m;
    private volatile mm f5961n;
    private ConnectionResult f5962o = null;

    static abstract class C1747a {
        private final mm f5874a;

        protected C1747a(mm mmVar) {
            this.f5874a = mmVar;
        }

        protected abstract void mo1586a();

        public final void m9848a(mo moVar) {
            moVar.f5956i.lock();
            try {
                if (moVar.f5961n == this.f5874a) {
                    mo1586a();
                    moVar.f5956i.unlock();
                }
            } finally {
                moVar.f5956i.unlock();
            }
        }
    }

    final class C1768b extends Handler {
        final /* synthetic */ mo f5947a;

        C1768b(mo moVar, Looper looper) {
            this.f5947a = moVar;
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    ((C1747a) message.obj).m9848a(this.f5947a);
                    return;
                case 2:
                    throw ((RuntimeException) message.obj);
                default:
                    Log.w("GACStateManager", "Unknown message id: " + message.what);
                    return;
            }
        }
    }

    public mo(Context context, ml mlVar, Lock lock, Looper looper, C1876j c1876j, Map<C1859d<?>, C1722f> map, C1927n c1927n, Map<C1864a<?>, Integer> map2, C1827b<? extends oa, ob> c1827b, ArrayList<mf> arrayList, C1744a c1744a) {
        this.f5958k = context;
        this.f5956i = lock;
        this.f5959l = c1876j;
        this.f5948a = map;
        this.f5950c = c1927n;
        this.f5951d = map2;
        this.f5952e = c1827b;
        this.f5954g = mlVar;
        this.f5955h = c1744a;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((mf) it.next()).m9795a(this);
        }
        this.f5960m = new C1768b(this, looper);
        this.f5957j = lock.newCondition();
        this.f5961n = new mk(this);
    }

    public <A extends C1721c, R extends C1857g, T extends C1714a<R, A>> T mo1579a(T t) {
        t.m9654j();
        return this.f5961n.mo1587a((C1714a) t);
    }

    public void mo1580a() {
        this.f5961n.mo1594c();
    }

    public void m9991a(int i) {
        this.f5956i.lock();
        try {
            this.f5961n.mo1589a(i);
        } finally {
            this.f5956i.unlock();
        }
    }

    public void m9992a(Bundle bundle) {
        this.f5956i.lock();
        try {
            this.f5961n.mo1590a(bundle);
        } finally {
            this.f5956i.unlock();
        }
    }

    void m9993a(C1747a c1747a) {
        this.f5960m.sendMessage(this.f5960m.obtainMessage(1, c1747a));
    }

    void m9994a(ConnectionResult connectionResult) {
        this.f5956i.lock();
        try {
            this.f5962o = connectionResult;
            this.f5961n = new mk(this);
            this.f5961n.mo1588a();
            this.f5957j.signalAll();
        } finally {
            this.f5956i.unlock();
        }
    }

    public void m9995a(ConnectionResult connectionResult, C1864a<?> c1864a, int i) {
        this.f5956i.lock();
        try {
            this.f5961n.mo1591a(connectionResult, c1864a, i);
        } finally {
            this.f5956i.unlock();
        }
    }

    void m9996a(RuntimeException runtimeException) {
        this.f5960m.sendMessage(this.f5960m.obtainMessage(2, runtimeException));
    }

    public void mo1581a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append(str).append("mState=").println(this.f5961n);
        for (C1864a c1864a : this.f5951d.keySet()) {
            printWriter.append(str).append(c1864a.m10578f()).println(":");
            ((C1722f) this.f5948a.get(c1864a.m10576d())).m9690a(concat, fileDescriptor, printWriter, strArr);
        }
    }

    public <A extends C1721c, T extends C1714a<? extends C1857g, A>> T mo1582b(T t) {
        t.m9654j();
        return this.f5961n.mo1592b(t);
    }

    public void mo1583b() {
        if (this.f5961n.mo1593b()) {
            this.f5949b.clear();
        }
    }

    public boolean mo1584c() {
        return this.f5961n instanceof mi;
    }

    public void mo1585d() {
        if (mo1584c()) {
            ((mi) this.f5961n).m9869d();
        }
    }

    void m10002e() {
        this.f5956i.lock();
        try {
            this.f5961n = new mj(this, this.f5950c, this.f5951d, this.f5959l, this.f5952e, this.f5956i, this.f5958k);
            this.f5961n.mo1588a();
            this.f5957j.signalAll();
        } finally {
            this.f5956i.unlock();
        }
    }

    void m10003f() {
        this.f5956i.lock();
        try {
            this.f5954g.m9983h();
            this.f5961n = new mi(this);
            this.f5961n.mo1588a();
            this.f5957j.signalAll();
        } finally {
            this.f5956i.unlock();
        }
    }

    void m10004g() {
        for (C1722f c : this.f5948a.values()) {
            c.m9691c();
        }
    }
}
