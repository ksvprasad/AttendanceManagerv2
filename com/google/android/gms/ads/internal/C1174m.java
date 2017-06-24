package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;

public class C1174m implements Creator<InterstitialAdParameterParcel> {
    static void m6548a(InterstitialAdParameterParcel interstitialAdParameterParcel, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, interstitialAdParameterParcel.f3048a);
        C1938b.m10944a(parcel, 2, interstitialAdParameterParcel.f3049b);
        C1938b.m10944a(parcel, 3, interstitialAdParameterParcel.f3050c);
        C1938b.m10942a(parcel, 4, interstitialAdParameterParcel.f3051d, false);
        C1938b.m10944a(parcel, 5, interstitialAdParameterParcel.f3052e);
        C1938b.m10932a(parcel, 6, interstitialAdParameterParcel.f3053f);
        C1938b.m10933a(parcel, 7, interstitialAdParameterParcel.f3054g);
        C1938b.m10931a(parcel, a);
    }

    public InterstitialAdParameterParcel m6549a(Parcel parcel) {
        int i = 0;
        int b = C1937a.m10910b(parcel);
        String str = null;
        float f = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1937a.m10905a(parcel);
            switch (C1937a.m10904a(a)) {
                case 1:
                    i2 = C1937a.m10915d(parcel, a);
                    break;
                case 2:
                    z3 = C1937a.m10914c(parcel, a);
                    break;
                case 3:
                    z2 = C1937a.m10914c(parcel, a);
                    break;
                case 4:
                    str = C1937a.m10922k(parcel, a);
                    break;
                case 5:
                    z = C1937a.m10914c(parcel, a);
                    break;
                case 6:
                    f = C1937a.m10919h(parcel, a);
                    break;
                case 7:
                    i = C1937a.m10915d(parcel, a);
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new InterstitialAdParameterParcel(i2, z3, z2, str, z, f, i);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public InterstitialAdParameterParcel[] m6550a(int i) {
        return new InterstitialAdParameterParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m6549a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m6550a(i);
    }
}
