package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;
import java.util.List;

public class C1270f implements Creator<AdRequestInfoParcel> {
    static void m6988a(AdRequestInfoParcel adRequestInfoParcel, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, adRequestInfoParcel.f3739a);
        C1938b.m10935a(parcel, 2, adRequestInfoParcel.f3740b, false);
        C1938b.m10937a(parcel, 3, adRequestInfoParcel.f3741c, i, false);
        C1938b.m10937a(parcel, 4, adRequestInfoParcel.f3742d, i, false);
        C1938b.m10942a(parcel, 5, adRequestInfoParcel.f3743e, false);
        C1938b.m10937a(parcel, 6, adRequestInfoParcel.f3744f, i, false);
        C1938b.m10937a(parcel, 7, adRequestInfoParcel.f3745g, i, false);
        C1938b.m10942a(parcel, 8, adRequestInfoParcel.f3746h, false);
        C1938b.m10942a(parcel, 9, adRequestInfoParcel.f3747i, false);
        C1938b.m10942a(parcel, 10, adRequestInfoParcel.f3748j, false);
        C1938b.m10937a(parcel, 11, adRequestInfoParcel.f3749k, i, false);
        C1938b.m10935a(parcel, 12, adRequestInfoParcel.f3750l, false);
        C1938b.m10933a(parcel, 13, adRequestInfoParcel.f3751m);
        C1938b.m10943a(parcel, 14, adRequestInfoParcel.f3752n, false);
        C1938b.m10935a(parcel, 15, adRequestInfoParcel.f3753o, false);
        C1938b.m10944a(parcel, 16, adRequestInfoParcel.f3754p);
        C1938b.m10937a(parcel, 17, adRequestInfoParcel.f3755q, i, false);
        C1938b.m10933a(parcel, 18, adRequestInfoParcel.f3756r);
        C1938b.m10933a(parcel, 19, adRequestInfoParcel.f3757s);
        C1938b.m10932a(parcel, 20, adRequestInfoParcel.f3758t);
        C1938b.m10942a(parcel, 21, adRequestInfoParcel.f3759u, false);
        C1938b.m10934a(parcel, 25, adRequestInfoParcel.f3760v);
        C1938b.m10942a(parcel, 26, adRequestInfoParcel.f3761w, false);
        C1938b.m10943a(parcel, 27, adRequestInfoParcel.f3762x, false);
        C1938b.m10942a(parcel, 28, adRequestInfoParcel.f3763y, false);
        C1938b.m10937a(parcel, 29, adRequestInfoParcel.f3764z, i, false);
        C1938b.m10943a(parcel, 30, adRequestInfoParcel.f3724A, false);
        C1938b.m10934a(parcel, 31, adRequestInfoParcel.f3725B);
        C1938b.m10937a(parcel, 32, adRequestInfoParcel.f3726C, i, false);
        C1938b.m10942a(parcel, 33, adRequestInfoParcel.f3727D, false);
        C1938b.m10932a(parcel, 34, adRequestInfoParcel.f3728E);
        C1938b.m10933a(parcel, 35, adRequestInfoParcel.f3729F);
        C1938b.m10933a(parcel, 36, adRequestInfoParcel.f3730G);
        C1938b.m10944a(parcel, 37, adRequestInfoParcel.f3731H);
        C1938b.m10944a(parcel, 38, adRequestInfoParcel.f3732I);
        C1938b.m10942a(parcel, 39, adRequestInfoParcel.f3733J, false);
        C1938b.m10944a(parcel, 40, adRequestInfoParcel.f3734K);
        C1938b.m10942a(parcel, 41, adRequestInfoParcel.f3735L, false);
        C1938b.m10944a(parcel, 42, adRequestInfoParcel.f3736M);
        C1938b.m10933a(parcel, 43, adRequestInfoParcel.f3737N);
        C1938b.m10935a(parcel, 44, adRequestInfoParcel.f3738O, false);
        C1938b.m10931a(parcel, a);
    }

    public AdRequestInfoParcel m6989a(Parcel parcel) {
        int b = C1937a.m10910b(parcel);
        int i = 0;
        Bundle bundle = null;
        AdRequestParcel adRequestParcel = null;
        AdSizeParcel adSizeParcel = null;
        String str = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        VersionInfoParcel versionInfoParcel = null;
        Bundle bundle2 = null;
        int i2 = 0;
        List list = null;
        Bundle bundle3 = null;
        boolean z = false;
        Messenger messenger = null;
        int i3 = 0;
        int i4 = 0;
        float f = 0.0f;
        String str5 = null;
        long j = 0;
        String str6 = null;
        List list2 = null;
        String str7 = null;
        NativeAdOptionsParcel nativeAdOptionsParcel = null;
        List list3 = null;
        long j2 = 0;
        CapabilityParcel capabilityParcel = null;
        String str8 = null;
        float f2 = 0.0f;
        boolean z2 = false;
        int i5 = 0;
        int i6 = 0;
        boolean z3 = false;
        boolean z4 = false;
        String str9 = null;
        String str10 = null;
        boolean z5 = false;
        int i7 = 0;
        Bundle bundle4 = null;
        while (parcel.dataPosition() < b) {
            int a = C1937a.m10905a(parcel);
            switch (C1937a.m10904a(a)) {
                case 1:
                    i = C1937a.m10915d(parcel, a);
                    break;
                case 2:
                    bundle = C1937a.m10924m(parcel, a);
                    break;
                case 3:
                    adRequestParcel = (AdRequestParcel) C1937a.m10907a(parcel, a, AdRequestParcel.CREATOR);
                    break;
                case 4:
                    adSizeParcel = (AdSizeParcel) C1937a.m10907a(parcel, a, AdSizeParcel.CREATOR);
                    break;
                case 5:
                    str = C1937a.m10922k(parcel, a);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) C1937a.m10907a(parcel, a, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) C1937a.m10907a(parcel, a, PackageInfo.CREATOR);
                    break;
                case 8:
                    str2 = C1937a.m10922k(parcel, a);
                    break;
                case 9:
                    str3 = C1937a.m10922k(parcel, a);
                    break;
                case 10:
                    str4 = C1937a.m10922k(parcel, a);
                    break;
                case 11:
                    versionInfoParcel = (VersionInfoParcel) C1937a.m10907a(parcel, a, VersionInfoParcel.CREATOR);
                    break;
                case 12:
                    bundle2 = C1937a.m10924m(parcel, a);
                    break;
                case 13:
                    i2 = C1937a.m10915d(parcel, a);
                    break;
                case 14:
                    list = C1937a.m10929r(parcel, a);
                    break;
                case 15:
                    bundle3 = C1937a.m10924m(parcel, a);
                    break;
                case 16:
                    z = C1937a.m10914c(parcel, a);
                    break;
                case 17:
                    messenger = (Messenger) C1937a.m10907a(parcel, a, Messenger.CREATOR);
                    break;
                case 18:
                    i3 = C1937a.m10915d(parcel, a);
                    break;
                case 19:
                    i4 = C1937a.m10915d(parcel, a);
                    break;
                case 20:
                    f = C1937a.m10919h(parcel, a);
                    break;
                case 21:
                    str5 = C1937a.m10922k(parcel, a);
                    break;
                case 25:
                    j = C1937a.m10917f(parcel, a);
                    break;
                case 26:
                    str6 = C1937a.m10922k(parcel, a);
                    break;
                case 27:
                    list2 = C1937a.m10929r(parcel, a);
                    break;
                case 28:
                    str7 = C1937a.m10922k(parcel, a);
                    break;
                case 29:
                    nativeAdOptionsParcel = (NativeAdOptionsParcel) C1937a.m10907a(parcel, a, (Creator) NativeAdOptionsParcel.CREATOR);
                    break;
                case 30:
                    list3 = C1937a.m10929r(parcel, a);
                    break;
                case 31:
                    j2 = C1937a.m10917f(parcel, a);
                    break;
                case 32:
                    capabilityParcel = (CapabilityParcel) C1937a.m10907a(parcel, a, CapabilityParcel.CREATOR);
                    break;
                case 33:
                    str8 = C1937a.m10922k(parcel, a);
                    break;
                case 34:
                    f2 = C1937a.m10919h(parcel, a);
                    break;
                case 35:
                    i5 = C1937a.m10915d(parcel, a);
                    break;
                case 36:
                    i6 = C1937a.m10915d(parcel, a);
                    break;
                case 37:
                    z3 = C1937a.m10914c(parcel, a);
                    break;
                case 38:
                    z4 = C1937a.m10914c(parcel, a);
                    break;
                case 39:
                    str9 = C1937a.m10922k(parcel, a);
                    break;
                case 40:
                    z2 = C1937a.m10914c(parcel, a);
                    break;
                case 41:
                    str10 = C1937a.m10922k(parcel, a);
                    break;
                case 42:
                    z5 = C1937a.m10914c(parcel, a);
                    break;
                case 43:
                    i7 = C1937a.m10915d(parcel, a);
                    break;
                case 44:
                    bundle4 = C1937a.m10924m(parcel, a);
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AdRequestInfoParcel(i, bundle, adRequestParcel, adSizeParcel, str, applicationInfo, packageInfo, str2, str3, str4, versionInfoParcel, bundle2, i2, list, bundle3, z, messenger, i3, i4, f, str5, j, str6, list2, str7, nativeAdOptionsParcel, list3, j2, capabilityParcel, str8, f2, z2, i5, i6, z3, z4, str9, str10, z5, i7, bundle4);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public AdRequestInfoParcel[] m6990a(int i) {
        return new AdRequestInfoParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m6989a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m6990a(i);
    }
}
