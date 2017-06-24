package com.google.android.gms.p031b;

import com.google.android.gms.common.api.C1864a;
import com.google.android.gms.common.api.C1864a.C1830a;
import com.google.android.gms.common.api.C1864a.C1859d;
import com.google.android.gms.common.internal.C1895b;

public final class lz<O extends C1830a> {
    private final C1864a<O> f5829a;
    private final O f5830b;

    public C1859d<?> m9743a() {
        return this.f5829a.m10576d();
    }

    public String m9744b() {
        return this.f5829a.m10578f();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof lz)) {
            return false;
        }
        lz lzVar = (lz) obj;
        return C1895b.m10789a(this.f5829a, lzVar.f5829a) && C1895b.m10789a(this.f5830b, lzVar.f5830b);
    }

    public int hashCode() {
        return C1895b.m10787a(this.f5829a, this.f5830b);
    }
}
