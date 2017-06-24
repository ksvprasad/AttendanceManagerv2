package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.v4.p015g.C0369j;
import android.util.Log;

public class C1964e {
    private final long f6594a;
    private final int f6595b;
    private final C0369j<String, Long> f6596c;

    public C1964e() {
        this.f6594a = 60000;
        this.f6595b = 10;
        this.f6596c = new C0369j(10);
    }

    public C1964e(int i, long j) {
        this.f6594a = j;
        this.f6595b = i;
        this.f6596c = new C0369j();
    }

    private void m11055a(long j, long j2) {
        for (int size = this.f6596c.size() - 1; size >= 0; size--) {
            if (j2 - ((Long) this.f6596c.m1901c(size)).longValue() > j) {
                this.f6596c.m1902d(size);
            }
        }
    }

    public Long m11056a(String str) {
        Long l;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.f6594a;
        synchronized (this) {
            while (this.f6596c.size() >= this.f6595b) {
                m11055a(j, elapsedRealtime);
                j /= 2;
                Log.w("ConnectionTracker", "The max capacity " + this.f6595b + " is not enough. Current durationThreshold is: " + j);
            }
            l = (Long) this.f6596c.put(str, Long.valueOf(elapsedRealtime));
        }
        return l;
    }

    public boolean m11057b(String str) {
        boolean z;
        synchronized (this) {
            z = this.f6596c.remove(str) != null;
        }
        return z;
    }
}
