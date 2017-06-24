package com.google.android.gms.ads.internal.formats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;

public class C1156j implements Creator<NativeAdOptionsParcel> {
    static void m6452a(NativeAdOptionsParcel nativeAdOptionsParcel, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, nativeAdOptionsParcel.f3297a);
        C1938b.m10944a(parcel, 2, nativeAdOptionsParcel.f3298b);
        C1938b.m10933a(parcel, 3, nativeAdOptionsParcel.f3299c);
        C1938b.m10944a(parcel, 4, nativeAdOptionsParcel.f3300d);
        C1938b.m10933a(parcel, 5, nativeAdOptionsParcel.f3301e);
        C1938b.m10931a(parcel, a);
    }

    public NativeAdOptionsParcel m6453a(Parcel parcel) {
        int i = 0;
        int b = C1937a.m10910b(parcel);
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1937a.m10905a(parcel);
            switch (C1937a.m10904a(a)) {
                case 1:
                    i3 = C1937a.m10915d(parcel, a);
                    break;
                case 2:
                    z2 = C1937a.m10914c(parcel, a);
                    break;
                case 3:
                    i2 = C1937a.m10915d(parcel, a);
                    break;
                case 4:
                    z = C1937a.m10914c(parcel, a);
                    break;
                case 5:
                    i = C1937a.m10915d(parcel, a);
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new NativeAdOptionsParcel(i3, z2, i2, z, i);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public NativeAdOptionsParcel[] m6454a(int i) {
        return new NativeAdOptionsParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m6453a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m6454a(i);
    }
}
