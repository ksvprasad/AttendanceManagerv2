package com.google.android.gms.ads.internal.purchase;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;

public class C1224a implements Creator<GInAppPurchaseManagerInfoParcel> {
    static void m6790a(GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, gInAppPurchaseManagerInfoParcel.f3618a);
        C1938b.m10936a(parcel, 3, gInAppPurchaseManagerInfoParcel.m6787b(), false);
        C1938b.m10936a(parcel, 4, gInAppPurchaseManagerInfoParcel.m6788c(), false);
        C1938b.m10936a(parcel, 5, gInAppPurchaseManagerInfoParcel.m6789d(), false);
        C1938b.m10936a(parcel, 6, gInAppPurchaseManagerInfoParcel.m6786a(), false);
        C1938b.m10931a(parcel, a);
    }

    public GInAppPurchaseManagerInfoParcel m6791a(Parcel parcel) {
        IBinder iBinder = null;
        int b = C1937a.m10910b(parcel);
        int i = 0;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        while (parcel.dataPosition() < b) {
            int a = C1937a.m10905a(parcel);
            switch (C1937a.m10904a(a)) {
                case 1:
                    i = C1937a.m10915d(parcel, a);
                    break;
                case 3:
                    iBinder4 = C1937a.m10923l(parcel, a);
                    break;
                case 4:
                    iBinder3 = C1937a.m10923l(parcel, a);
                    break;
                case 5:
                    iBinder2 = C1937a.m10923l(parcel, a);
                    break;
                case 6:
                    iBinder = C1937a.m10923l(parcel, a);
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GInAppPurchaseManagerInfoParcel(i, iBinder4, iBinder3, iBinder2, iBinder);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public GInAppPurchaseManagerInfoParcel[] m6792a(int i) {
        return new GInAppPurchaseManagerInfoParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m6791a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m6792a(i);
    }
}
