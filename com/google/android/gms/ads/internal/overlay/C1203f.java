package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;

public class C1203f implements Creator<AdOverlayInfoParcel> {
    static void m6682a(AdOverlayInfoParcel adOverlayInfoParcel, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, adOverlayInfoParcel.f3474a);
        C1938b.m10937a(parcel, 2, adOverlayInfoParcel.f3475b, i, false);
        C1938b.m10936a(parcel, 3, adOverlayInfoParcel.m6589a(), false);
        C1938b.m10936a(parcel, 4, adOverlayInfoParcel.m6590b(), false);
        C1938b.m10936a(parcel, 5, adOverlayInfoParcel.m6591c(), false);
        C1938b.m10936a(parcel, 6, adOverlayInfoParcel.m6592d(), false);
        C1938b.m10942a(parcel, 7, adOverlayInfoParcel.f3480g, false);
        C1938b.m10944a(parcel, 8, adOverlayInfoParcel.f3481h);
        C1938b.m10942a(parcel, 9, adOverlayInfoParcel.f3482i, false);
        C1938b.m10936a(parcel, 10, adOverlayInfoParcel.m6594f(), false);
        C1938b.m10933a(parcel, 11, adOverlayInfoParcel.f3484k);
        C1938b.m10933a(parcel, 12, adOverlayInfoParcel.f3485l);
        C1938b.m10942a(parcel, 13, adOverlayInfoParcel.f3486m, false);
        C1938b.m10937a(parcel, 14, adOverlayInfoParcel.f3487n, i, false);
        C1938b.m10936a(parcel, 15, adOverlayInfoParcel.m6593e(), false);
        C1938b.m10942a(parcel, 16, adOverlayInfoParcel.f3489p, false);
        C1938b.m10937a(parcel, 17, adOverlayInfoParcel.f3490q, i, false);
        C1938b.m10931a(parcel, a);
    }

    public AdOverlayInfoParcel m6683a(Parcel parcel) {
        int b = C1937a.m10910b(parcel);
        int i = 0;
        AdLauncherIntentInfoParcel adLauncherIntentInfoParcel = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        boolean z = false;
        String str2 = null;
        IBinder iBinder5 = null;
        int i2 = 0;
        int i3 = 0;
        String str3 = null;
        VersionInfoParcel versionInfoParcel = null;
        IBinder iBinder6 = null;
        String str4 = null;
        InterstitialAdParameterParcel interstitialAdParameterParcel = null;
        while (parcel.dataPosition() < b) {
            int a = C1937a.m10905a(parcel);
            switch (C1937a.m10904a(a)) {
                case 1:
                    i = C1937a.m10915d(parcel, a);
                    break;
                case 2:
                    adLauncherIntentInfoParcel = (AdLauncherIntentInfoParcel) C1937a.m10907a(parcel, a, AdLauncherIntentInfoParcel.CREATOR);
                    break;
                case 3:
                    iBinder = C1937a.m10923l(parcel, a);
                    break;
                case 4:
                    iBinder2 = C1937a.m10923l(parcel, a);
                    break;
                case 5:
                    iBinder3 = C1937a.m10923l(parcel, a);
                    break;
                case 6:
                    iBinder4 = C1937a.m10923l(parcel, a);
                    break;
                case 7:
                    str = C1937a.m10922k(parcel, a);
                    break;
                case 8:
                    z = C1937a.m10914c(parcel, a);
                    break;
                case 9:
                    str2 = C1937a.m10922k(parcel, a);
                    break;
                case 10:
                    iBinder5 = C1937a.m10923l(parcel, a);
                    break;
                case 11:
                    i2 = C1937a.m10915d(parcel, a);
                    break;
                case 12:
                    i3 = C1937a.m10915d(parcel, a);
                    break;
                case 13:
                    str3 = C1937a.m10922k(parcel, a);
                    break;
                case 14:
                    versionInfoParcel = (VersionInfoParcel) C1937a.m10907a(parcel, a, (Creator) VersionInfoParcel.CREATOR);
                    break;
                case 15:
                    iBinder6 = C1937a.m10923l(parcel, a);
                    break;
                case 16:
                    str4 = C1937a.m10922k(parcel, a);
                    break;
                case 17:
                    interstitialAdParameterParcel = (InterstitialAdParameterParcel) C1937a.m10907a(parcel, a, (Creator) InterstitialAdParameterParcel.CREATOR);
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AdOverlayInfoParcel(i, adLauncherIntentInfoParcel, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i2, i3, str3, versionInfoParcel, iBinder6, str4, interstitialAdParameterParcel);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public AdOverlayInfoParcel[] m6684a(int i) {
        return new AdOverlayInfoParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m6683a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m6684a(i);
    }
}
