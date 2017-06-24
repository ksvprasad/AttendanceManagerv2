package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.ads.internal.client.C1120y;
import com.google.android.gms.ads.internal.request.C1263d.C1264a;
import com.google.android.gms.ads.internal.request.C1263d.C1267b;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.C1973f;
import com.google.android.gms.p031b.cq;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p031b.kb;
import com.google.android.gms.p031b.kt;

@id
public final class C1259c {

    public interface C1255a {
        void mo1173a(AdResponseParcel adResponseParcel);
    }

    interface C1257b {
        boolean mo1174a(VersionInfoParcel versionInfoParcel);
    }

    class C12581 implements C1257b {
        final /* synthetic */ Context f3835a;

        C12581(Context context) {
            this.f3835a = context;
        }

        public boolean mo1174a(VersionInfoParcel versionInfoParcel) {
            return versionInfoParcel.f3960e || (C1973f.m11093b(this.f3835a) && !((Boolean) cq.f4362C.m7801c()).booleanValue());
        }
    }

    public static kb m6911a(Context context, VersionInfoParcel versionInfoParcel, kt<AdRequestInfoParcel> ktVar, C1255a c1255a) {
        return C1259c.m6912a(context, versionInfoParcel, ktVar, c1255a, new C12581(context));
    }

    static kb m6912a(Context context, VersionInfoParcel versionInfoParcel, kt<AdRequestInfoParcel> ktVar, C1255a c1255a, C1257b c1257b) {
        return c1257b.mo1174a(versionInfoParcel) ? C1259c.m6913a(context, ktVar, c1255a) : C1259c.m6914b(context, versionInfoParcel, ktVar, c1255a);
    }

    private static kb m6913a(Context context, kt<AdRequestInfoParcel> ktVar, C1255a c1255a) {
        C1324b.m7227a("Fetching ad response from local ad request service.");
        kb c1264a = new C1264a(context, ktVar, c1255a);
        Void voidR = (Void) c1264a.mo1107e();
        return c1264a;
    }

    private static kb m6914b(Context context, VersionInfoParcel versionInfoParcel, kt<AdRequestInfoParcel> ktVar, C1255a c1255a) {
        C1324b.m7227a("Fetching ad response from remote ad request service.");
        if (C1120y.m6293a().m7223b(context)) {
            return new C1267b(context, versionInfoParcel, ktVar, c1255a);
        }
        C1324b.m7234d("Failed to connect to remote ad request service.");
        return null;
    }
}
