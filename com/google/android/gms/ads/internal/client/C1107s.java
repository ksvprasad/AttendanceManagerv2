package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;
import java.util.List;

public class C1107s implements Creator<AdRequestParcel> {
    static void m6237a(AdRequestParcel adRequestParcel, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, adRequestParcel.f3085a);
        C1938b.m10934a(parcel, 2, adRequestParcel.f3086b);
        C1938b.m10935a(parcel, 3, adRequestParcel.f3087c, false);
        C1938b.m10933a(parcel, 4, adRequestParcel.f3088d);
        C1938b.m10943a(parcel, 5, adRequestParcel.f3089e, false);
        C1938b.m10944a(parcel, 6, adRequestParcel.f3090f);
        C1938b.m10933a(parcel, 7, adRequestParcel.f3091g);
        C1938b.m10944a(parcel, 8, adRequestParcel.f3092h);
        C1938b.m10942a(parcel, 9, adRequestParcel.f3093i, false);
        C1938b.m10937a(parcel, 10, adRequestParcel.f3094j, i, false);
        C1938b.m10937a(parcel, 11, adRequestParcel.f3095k, i, false);
        C1938b.m10942a(parcel, 12, adRequestParcel.f3096l, false);
        C1938b.m10935a(parcel, 13, adRequestParcel.f3097m, false);
        C1938b.m10935a(parcel, 14, adRequestParcel.f3098n, false);
        C1938b.m10943a(parcel, 15, adRequestParcel.f3099o, false);
        C1938b.m10942a(parcel, 16, adRequestParcel.f3100p, false);
        C1938b.m10942a(parcel, 17, adRequestParcel.f3101q, false);
        C1938b.m10944a(parcel, 18, adRequestParcel.f3102r);
        C1938b.m10931a(parcel, a);
    }

    public AdRequestParcel m6238a(Parcel parcel) {
        int b = C1937a.m10910b(parcel);
        int i = 0;
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        List list = null;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        String str = null;
        SearchAdRequestParcel searchAdRequestParcel = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        Bundle bundle3 = null;
        List list2 = null;
        String str3 = null;
        String str4 = null;
        boolean z3 = false;
        while (parcel.dataPosition() < b) {
            int a = C1937a.m10905a(parcel);
            switch (C1937a.m10904a(a)) {
                case 1:
                    i = C1937a.m10915d(parcel, a);
                    break;
                case 2:
                    j = C1937a.m10917f(parcel, a);
                    break;
                case 3:
                    bundle = C1937a.m10924m(parcel, a);
                    break;
                case 4:
                    i2 = C1937a.m10915d(parcel, a);
                    break;
                case 5:
                    list = C1937a.m10929r(parcel, a);
                    break;
                case 6:
                    z = C1937a.m10914c(parcel, a);
                    break;
                case 7:
                    i3 = C1937a.m10915d(parcel, a);
                    break;
                case 8:
                    z2 = C1937a.m10914c(parcel, a);
                    break;
                case 9:
                    str = C1937a.m10922k(parcel, a);
                    break;
                case 10:
                    searchAdRequestParcel = (SearchAdRequestParcel) C1937a.m10907a(parcel, a, SearchAdRequestParcel.CREATOR);
                    break;
                case 11:
                    location = (Location) C1937a.m10907a(parcel, a, Location.CREATOR);
                    break;
                case 12:
                    str2 = C1937a.m10922k(parcel, a);
                    break;
                case 13:
                    bundle2 = C1937a.m10924m(parcel, a);
                    break;
                case 14:
                    bundle3 = C1937a.m10924m(parcel, a);
                    break;
                case 15:
                    list2 = C1937a.m10929r(parcel, a);
                    break;
                case 16:
                    str3 = C1937a.m10922k(parcel, a);
                    break;
                case 17:
                    str4 = C1937a.m10922k(parcel, a);
                    break;
                case 18:
                    z3 = C1937a.m10914c(parcel, a);
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AdRequestParcel(i, j, bundle, i2, list, z, i3, z2, str, searchAdRequestParcel, location, str2, bundle2, bundle3, list2, str3, str4, z3);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public AdRequestParcel[] m6239a(int i) {
        return new AdRequestParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m6238a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m6239a(i);
    }
}
