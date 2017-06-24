package com.google.android.gms.p031b;

import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@id
public class jm {
    private final jo f5451a;
    private final LinkedList<C1633a> f5452b;
    private final Object f5453c;
    private final String f5454d;
    private final String f5455e;
    private long f5456f;
    private long f5457g;
    private boolean f5458h;
    private long f5459i;
    private long f5460j;
    private long f5461k;
    private long f5462l;

    @id
    private static final class C1633a {
        private long f5449a = -1;
        private long f5450b = -1;

        public long m9084a() {
            return this.f5450b;
        }

        public void m9085b() {
            this.f5450b = SystemClock.elapsedRealtime();
        }

        public void m9086c() {
            this.f5449a = SystemClock.elapsedRealtime();
        }

        public Bundle m9087d() {
            Bundle bundle = new Bundle();
            bundle.putLong("topen", this.f5449a);
            bundle.putLong("tclose", this.f5450b);
            return bundle;
        }
    }

    public jm(jo joVar, String str, String str2) {
        this.f5453c = new Object();
        this.f5456f = -1;
        this.f5457g = -1;
        this.f5458h = false;
        this.f5459i = -1;
        this.f5460j = 0;
        this.f5461k = -1;
        this.f5462l = -1;
        this.f5451a = joVar;
        this.f5454d = str;
        this.f5455e = str2;
        this.f5452b = new LinkedList();
    }

    public jm(String str, String str2) {
        this(C1319u.m7186h(), str, str2);
    }

    public void m9088a() {
        synchronized (this.f5453c) {
            if (this.f5462l != -1 && this.f5457g == -1) {
                this.f5457g = SystemClock.elapsedRealtime();
                this.f5451a.m9113a(this);
            }
            this.f5451a.m9125d().m9144c();
        }
    }

    public void m9089a(long j) {
        synchronized (this.f5453c) {
            this.f5462l = j;
            if (this.f5462l != -1) {
                this.f5451a.m9113a(this);
            }
        }
    }

    public void m9090a(AdRequestParcel adRequestParcel) {
        synchronized (this.f5453c) {
            this.f5461k = SystemClock.elapsedRealtime();
            this.f5451a.m9125d().m9142a(adRequestParcel, this.f5461k);
        }
    }

    public void m9091a(boolean z) {
        synchronized (this.f5453c) {
            if (this.f5462l != -1) {
                this.f5459i = SystemClock.elapsedRealtime();
                if (!z) {
                    this.f5457g = this.f5459i;
                    this.f5451a.m9113a(this);
                }
            }
        }
    }

    public void m9092b() {
        synchronized (this.f5453c) {
            if (this.f5462l != -1) {
                C1633a c1633a = new C1633a();
                c1633a.m9086c();
                this.f5452b.add(c1633a);
                this.f5460j++;
                this.f5451a.m9125d().m9143b();
                this.f5451a.m9113a(this);
            }
        }
    }

    public void m9093b(long j) {
        synchronized (this.f5453c) {
            if (this.f5462l != -1) {
                this.f5456f = j;
                this.f5451a.m9113a(this);
            }
        }
    }

    public void m9094b(boolean z) {
        synchronized (this.f5453c) {
            if (this.f5462l != -1) {
                this.f5458h = z;
                this.f5451a.m9113a(this);
            }
        }
    }

    public void m9095c() {
        synchronized (this.f5453c) {
            if (!(this.f5462l == -1 || this.f5452b.isEmpty())) {
                C1633a c1633a = (C1633a) this.f5452b.getLast();
                if (c1633a.m9084a() == -1) {
                    c1633a.m9085b();
                    this.f5451a.m9113a(this);
                }
            }
        }
    }

    public Bundle m9096d() {
        Bundle bundle;
        synchronized (this.f5453c) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.f5454d);
            bundle.putString("slotid", this.f5455e);
            bundle.putBoolean("ismediation", this.f5458h);
            bundle.putLong("treq", this.f5461k);
            bundle.putLong("tresponse", this.f5462l);
            bundle.putLong("timp", this.f5457g);
            bundle.putLong("tload", this.f5459i);
            bundle.putLong("pcc", this.f5460j);
            bundle.putLong("tfetch", this.f5456f);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f5452b.iterator();
            while (it.hasNext()) {
                arrayList.add(((C1633a) it.next()).m9087d());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }
}
