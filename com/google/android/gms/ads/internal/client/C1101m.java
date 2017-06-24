package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;

public class C1101m implements Creator<VideoOptionsParcel> {
    static void m6219a(VideoOptionsParcel videoOptionsParcel, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, videoOptionsParcel.f3129a);
        C1938b.m10944a(parcel, 2, videoOptionsParcel.f3130b);
        C1938b.m10931a(parcel, a);
    }

    public VideoOptionsParcel m6220a(Parcel parcel) {
        boolean z = false;
        int b = C1937a.m10910b(parcel);
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
                default:
                    C1937a.m10911b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new VideoOptionsParcel(i, z);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public VideoOptionsParcel[] m6221a(int i) {
        return new VideoOptionsParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m6220a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m6221a(i);
    }
}
