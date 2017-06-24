package com.google.android.gms.p031b;

import com.google.ads.C0955a.C0953a;
import com.google.ads.C0955a.C0954b;
import com.google.ads.C0956b;
import com.google.ads.mediation.C0977b;
import com.google.android.gms.ads.C1330k;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import java.util.Date;
import java.util.HashSet;

@id
public final class gl {

    static /* synthetic */ class C15491 {
        static final /* synthetic */ int[] f4934a = new int[C0954b.values().length];

        static {
            f4935b = new int[C0953a.values().length];
            try {
                f4935b[C0953a.INTERNAL_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4935b[C0953a.INVALID_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4935b[C0953a.NETWORK_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4935b[C0953a.NO_FILL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f4934a[C0954b.FEMALE.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f4934a[C0954b.MALE.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f4934a[C0954b.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public static int m8624a(C0953a c0953a) {
        switch (c0953a) {
            case INVALID_REQUEST:
                return 1;
            case NETWORK_ERROR:
                return 2;
            case NO_FILL:
                return 3;
            default:
                return 0;
        }
    }

    public static C0954b m8625a(int i) {
        switch (i) {
            case 1:
                return C0954b.MALE;
            case 2:
                return C0954b.FEMALE;
            default:
                return C0954b.UNKNOWN;
        }
    }

    public static C0956b m8626a(AdSizeParcel adSizeParcel) {
        int i = 0;
        C0956b[] c0956bArr = new C0956b[]{C0956b.f2928a, C0956b.f2929b, C0956b.f2930c, C0956b.f2931d, C0956b.f2932e, C0956b.f2933f};
        while (i < 6) {
            if (c0956bArr[i].m5601a() == adSizeParcel.f3108f && c0956bArr[i].m5602b() == adSizeParcel.f3105c) {
                return c0956bArr[i];
            }
            i++;
        }
        return new C0956b(C1330k.m7257a(adSizeParcel.f3108f, adSizeParcel.f3105c, adSizeParcel.f3104b));
    }

    public static C0977b m8627a(AdRequestParcel adRequestParcel) {
        return new C0977b(new Date(adRequestParcel.f3086b), gl.m8625a(adRequestParcel.f3088d), adRequestParcel.f3089e != null ? new HashSet(adRequestParcel.f3089e) : null, adRequestParcel.f3090f, adRequestParcel.f3095k);
    }
}
