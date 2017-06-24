package com.google.android.gms.p031b;

import com.google.android.gms.ads.internal.util.client.C1324b;
import org.json.JSONObject;

@id
public class gs {
    private final boolean f4989a;
    private final boolean f4990b;
    private final boolean f4991c;
    private final boolean f4992d;
    private final boolean f4993e;

    public static final class C1559a {
        private boolean f4984a;
        private boolean f4985b;
        private boolean f4986c;
        private boolean f4987d;
        private boolean f4988e;

        public C1559a m8666a(boolean z) {
            this.f4984a = z;
            return this;
        }

        public gs m8667a() {
            return new gs();
        }

        public C1559a m8668b(boolean z) {
            this.f4985b = z;
            return this;
        }

        public C1559a m8669c(boolean z) {
            this.f4986c = z;
            return this;
        }

        public C1559a m8670d(boolean z) {
            this.f4987d = z;
            return this;
        }

        public C1559a m8671e(boolean z) {
            this.f4988e = z;
            return this;
        }
    }

    private gs(C1559a c1559a) {
        this.f4989a = c1559a.f4984a;
        this.f4990b = c1559a.f4985b;
        this.f4991c = c1559a.f4986c;
        this.f4992d = c1559a.f4987d;
        this.f4993e = c1559a.f4988e;
    }

    public JSONObject m8672a() {
        try {
            return new JSONObject().put("sms", this.f4989a).put("tel", this.f4990b).put("calendar", this.f4991c).put("storePicture", this.f4992d).put("inlineVideo", this.f4993e);
        } catch (Throwable e) {
            C1324b.m7231b("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
