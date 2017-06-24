package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;

public class C1326d implements Creator<VersionInfoParcel> {
    static void m7237a(VersionInfoParcel versionInfoParcel, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, versionInfoParcel.f3956a);
        C1938b.m10942a(parcel, 2, versionInfoParcel.f3957b, false);
        C1938b.m10933a(parcel, 3, versionInfoParcel.f3958c);
        C1938b.m10933a(parcel, 4, versionInfoParcel.f3959d);
        C1938b.m10944a(parcel, 5, versionInfoParcel.f3960e);
        C1938b.m10931a(parcel, a);
    }

    public VersionInfoParcel m7238a(Parcel parcel) {
        boolean z = false;
        int b = C1937a.m10910b(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1937a.m10905a(parcel);
            switch (C1937a.m10904a(a)) {
                case 1:
                    i3 = C1937a.m10915d(parcel, a);
                    break;
                case 2:
                    str = C1937a.m10922k(parcel, a);
                    break;
                case 3:
                    i2 = C1937a.m10915d(parcel, a);
                    break;
                case 4:
                    i = C1937a.m10915d(parcel, a);
                    break;
                case 5:
                    z = C1937a.m10914c(parcel, a);
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new VersionInfoParcel(i3, str, i2, i, z);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public VersionInfoParcel[] m7239a(int i) {
        return new VersionInfoParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7238a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7239a(i);
    }
}
