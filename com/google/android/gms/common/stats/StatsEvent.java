package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {
    public abstract long mo1719a();

    public abstract int mo1720b();

    public abstract long mo1721i();

    public abstract String mo1722l();

    public String toString() {
        long a = mo1719a();
        String valueOf = String.valueOf("\t");
        int b = mo1720b();
        String valueOf2 = String.valueOf("\t");
        long i = mo1721i();
        String valueOf3 = String.valueOf(mo1722l());
        return new StringBuilder(((String.valueOf(valueOf).length() + 51) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()).append(a).append(valueOf).append(b).append(valueOf2).append(i).append(valueOf3).toString();
    }
}
