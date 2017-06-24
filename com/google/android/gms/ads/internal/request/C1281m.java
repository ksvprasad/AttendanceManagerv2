package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;

public class C1281m implements Creator<LargeParcelTeleporter> {
    static void m7009a(LargeParcelTeleporter largeParcelTeleporter, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, largeParcelTeleporter.f3815a);
        C1938b.m10937a(parcel, 2, largeParcelTeleporter.f3816b, i, false);
        C1938b.m10931a(parcel, a);
    }

    public LargeParcelTeleporter m7010a(Parcel parcel) {
        int b = C1937a.m10910b(parcel);
        int i = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < b) {
            int a = C1937a.m10905a(parcel);
            switch (C1937a.m10904a(a)) {
                case 1:
                    i = C1937a.m10915d(parcel, a);
                    break;
                case 2:
                    parcelFileDescriptor = (ParcelFileDescriptor) C1937a.m10907a(parcel, a, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new LargeParcelTeleporter(i, parcelFileDescriptor);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public LargeParcelTeleporter[] m7011a(int i) {
        return new LargeParcelTeleporter[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7010a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7011a(i);
    }
}
