package com.google.android.gms.gass.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.C1268k.C1265b;
import com.google.android.gms.common.internal.C1268k.C1266c;
import com.google.android.gms.p031b.C1493f.C1487a;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class C1997a {

    static class C1996a implements C1265b, C1266c {
        protected C1998b f6639a;
        private final String f6640b;
        private final String f6641c;
        private final LinkedBlockingQueue<C1487a> f6642d;
        private final HandlerThread f6643e = new HandlerThread("GassClient");

        public C1996a(Context context, String str, String str2) {
            this.f6640b = str;
            this.f6641c = str2;
            this.f6643e.start();
            this.f6639a = new C1998b(context, this.f6643e.getLooper(), this, this);
            this.f6642d = new LinkedBlockingQueue();
            m11160c();
        }

        public C1487a m11154a() {
            return m11158b(2000);
        }

        public void mo1178a(int i) {
            try {
                this.f6642d.put(new C1487a());
            } catch (InterruptedException e) {
            }
        }

        public void mo1179a(Bundle bundle) {
            C2001e b = m11159b();
            if (b != null) {
                try {
                    this.f6642d.put(b.mo1726a(new GassRequestParcel(this.f6640b, this.f6641c)).m11153b());
                } catch (Throwable th) {
                } finally {
                    m11161d();
                    this.f6643e.quit();
                }
            }
        }

        public void mo1180a(ConnectionResult connectionResult) {
            try {
                this.f6642d.put(new C1487a());
            } catch (InterruptedException e) {
            }
        }

        public C1487a m11158b(int i) {
            C1487a c1487a;
            try {
                c1487a = (C1487a) this.f6642d.poll((long) i, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                c1487a = null;
            }
            return c1487a == null ? new C1487a() : c1487a;
        }

        protected C2001e m11159b() {
            try {
                return this.f6639a.mo1702k();
            } catch (IllegalStateException e) {
                return null;
            } catch (DeadObjectException e2) {
                return null;
            }
        }

        protected void m11160c() {
            this.f6639a.m6974n();
        }

        public void m11161d() {
            if (this.f6639a == null) {
                return;
            }
            if (this.f6639a.m6966d() || this.f6639a.m6967e()) {
                this.f6639a.m6965c();
            }
        }
    }

    public static C1487a m11162a(Context context, String str, String str2) {
        return new C1996a(context, str, str2).m11154a();
    }
}
