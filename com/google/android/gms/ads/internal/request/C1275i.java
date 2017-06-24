package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;
import java.util.List;

public class C1275i implements Creator<AutoClickProtectionConfigurationParcel> {
    static void m6997a(AutoClickProtectionConfigurationParcel autoClickProtectionConfigurationParcel, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, autoClickProtectionConfigurationParcel.f3805a);
        C1938b.m10944a(parcel, 2, autoClickProtectionConfigurationParcel.f3806b);
        C1938b.m10943a(parcel, 3, autoClickProtectionConfigurationParcel.f3807c, false);
        C1938b.m10931a(parcel, a);
    }

    public AutoClickProtectionConfigurationParcel m6998a(Parcel parcel) {
        boolean z = false;
        int b = C1937a.m10910b(parcel);
        List list = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C1937a.m10905a(parcel);
            switch (C1937a.m10904a(a)) {
                case 1:
                    i = C1937a.m10915d(parcel, a);
                    break;
                case 2:
                    z = C1937a.m10914c(parcel, a);
                    break;
                case 3:
                    list = C1937a.m10929r(parcel, a);
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AutoClickProtectionConfigurationParcel(i, z, list);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public AutoClickProtectionConfigurationParcel[] m6999a(int i) {
        return new AutoClickProtectionConfigurationParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m6998a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m6999a(i);
    }
}
