package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;

public class C2083n implements Creator<AppMetadata> {
    static void m11807a(AppMetadata appMetadata, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, appMetadata.f6656a);
        C1938b.m10942a(parcel, 2, appMetadata.f6657b, false);
        C1938b.m10942a(parcel, 3, appMetadata.f6658c, false);
        C1938b.m10942a(parcel, 4, appMetadata.f6659d, false);
        C1938b.m10942a(parcel, 5, appMetadata.f6660e, false);
        C1938b.m10934a(parcel, 6, appMetadata.f6661f);
        C1938b.m10934a(parcel, 7, appMetadata.f6662g);
        C1938b.m10942a(parcel, 8, appMetadata.f6663h, false);
        C1938b.m10944a(parcel, 9, appMetadata.f6664i);
        C1938b.m10944a(parcel, 10, appMetadata.f6665j);
        C1938b.m10934a(parcel, 11, appMetadata.f6666k);
        C1938b.m10942a(parcel, 12, appMetadata.f6667l, false);
        C1938b.m10931a(parcel, a);
    }

    public AppMetadata m11808a(Parcel parcel) {
        int b = C1937a.m10910b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        long j = 0;
        long j2 = 0;
        String str5 = null;
        boolean z = false;
        boolean z2 = false;
        long j3 = 0;
        String str6 = null;
        while (parcel.dataPosition() < b) {
            int a = C1937a.m10905a(parcel);
            switch (C1937a.m10904a(a)) {
                case 1:
                    i = C1937a.m10915d(parcel, a);
                    break;
                case 2:
                    str = C1937a.m10922k(parcel, a);
                    break;
                case 3:
                    str2 = C1937a.m10922k(parcel, a);
                    break;
                case 4:
                    str3 = C1937a.m10922k(parcel, a);
                    break;
                case 5:
                    str4 = C1937a.m10922k(parcel, a);
                    break;
                case 6:
                    j = C1937a.m10917f(parcel, a);
                    break;
                case 7:
                    j2 = C1937a.m10917f(parcel, a);
                    break;
                case 8:
                    str5 = C1937a.m10922k(parcel, a);
                    break;
                case 9:
                    z = C1937a.m10914c(parcel, a);
                    break;
                case 10:
                    z2 = C1937a.m10914c(parcel, a);
                    break;
                case 11:
                    j3 = C1937a.m10917f(parcel, a);
                    break;
                case 12:
                    str6 = C1937a.m10922k(parcel, a);
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AppMetadata(i, str, str2, str3, str4, j, j2, str5, z, z2, j3, str6);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public AppMetadata[] m11809a(int i) {
        return new AppMetadata[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11808a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11809a(i);
    }
}
