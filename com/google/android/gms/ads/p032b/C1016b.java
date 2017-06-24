package com.google.android.gms.ads.p032b;

import com.google.android.gms.p031b.id;

@id
public final class C1016b {
    private final boolean f2990a;
    private final int f2991b;
    private final boolean f2992c;
    private final int f2993d;

    public static final class C1015a {
        private boolean f2986a = false;
        private int f2987b = 0;
        private boolean f2988c = false;
        private int f2989d = 1;

        public C1015a m5742a(int i) {
            this.f2987b = i;
            return this;
        }

        public C1015a m5743a(boolean z) {
            this.f2986a = z;
            return this;
        }

        public C1016b m5744a() {
            return new C1016b();
        }

        public C1015a m5745b(boolean z) {
            this.f2988c = z;
            return this;
        }
    }

    private C1016b(C1015a c1015a) {
        this.f2990a = c1015a.f2986a;
        this.f2991b = c1015a.f2987b;
        this.f2992c = c1015a.f2988c;
        this.f2993d = c1015a.f2989d;
    }

    public boolean m5746a() {
        return this.f2990a;
    }

    public int m5747b() {
        return this.f2991b;
    }

    public boolean m5748c() {
        return this.f2992c;
    }

    public int m5749d() {
        return this.f2993d;
    }
}
