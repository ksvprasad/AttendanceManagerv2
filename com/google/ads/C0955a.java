package com.google.ads;

import com.google.android.gms.ads.C1026c;

@Deprecated
public final class C0955a {
    public static final String f2927a = C1026c.f3013a;

    public enum C0953a {
        INVALID_REQUEST("Invalid Ad request."),
        NO_FILL("Ad request successful, but no ad returned due to lack of ad inventory."),
        NETWORK_ERROR("A network error occurred."),
        INTERNAL_ERROR("There was an internal error.");
        
        private final String f2922e;

        private C0953a(String str) {
            this.f2922e = str;
        }

        public String toString() {
            return this.f2922e;
        }
    }

    public enum C0954b {
        UNKNOWN,
        MALE,
        FEMALE
    }
}
