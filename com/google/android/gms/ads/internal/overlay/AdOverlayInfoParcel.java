package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.client.C0971a;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.p031b.dx;
import com.google.android.gms.p031b.ed;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p031b.la;
import com.google.android.gms.p033a.C0998a.C1000a;
import com.google.android.gms.p033a.C1001b;

@id
public final class AdOverlayInfoParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final C1203f CREATOR = new C1203f();
    public final int f3474a;
    public final AdLauncherIntentInfoParcel f3475b;
    public final C0971a f3476c;
    public final C1047g f3477d;
    public final la f3478e;
    public final dx f3479f;
    public final String f3480g;
    public final boolean f3481h;
    public final String f3482i;
    public final C1040p f3483j;
    public final int f3484k;
    public final int f3485l;
    public final String f3486m;
    public final VersionInfoParcel f3487n;
    public final ed f3488o;
    public final String f3489p;
    public final InterstitialAdParameterParcel f3490q;

    AdOverlayInfoParcel(int i, AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i2, int i3, String str3, VersionInfoParcel versionInfoParcel, IBinder iBinder6, String str4, InterstitialAdParameterParcel interstitialAdParameterParcel) {
        this.f3474a = i;
        this.f3475b = adLauncherIntentInfoParcel;
        this.f3476c = (C0971a) C1001b.m5714a(C1000a.m5712a(iBinder));
        this.f3477d = (C1047g) C1001b.m5714a(C1000a.m5712a(iBinder2));
        this.f3478e = (la) C1001b.m5714a(C1000a.m5712a(iBinder3));
        this.f3479f = (dx) C1001b.m5714a(C1000a.m5712a(iBinder4));
        this.f3480g = str;
        this.f3481h = z;
        this.f3482i = str2;
        this.f3483j = (C1040p) C1001b.m5714a(C1000a.m5712a(iBinder5));
        this.f3484k = i2;
        this.f3485l = i3;
        this.f3486m = str3;
        this.f3487n = versionInfoParcel;
        this.f3488o = (ed) C1001b.m5714a(C1000a.m5712a(iBinder6));
        this.f3489p = str4;
        this.f3490q = interstitialAdParameterParcel;
    }

    public AdOverlayInfoParcel(C0971a c0971a, C1047g c1047g, C1040p c1040p, la laVar, int i, VersionInfoParcel versionInfoParcel, String str, InterstitialAdParameterParcel interstitialAdParameterParcel) {
        this.f3474a = 4;
        this.f3475b = null;
        this.f3476c = c0971a;
        this.f3477d = c1047g;
        this.f3478e = laVar;
        this.f3479f = null;
        this.f3480g = null;
        this.f3481h = false;
        this.f3482i = null;
        this.f3483j = c1040p;
        this.f3484k = i;
        this.f3485l = 1;
        this.f3486m = null;
        this.f3487n = versionInfoParcel;
        this.f3488o = null;
        this.f3489p = str;
        this.f3490q = interstitialAdParameterParcel;
    }

    public AdOverlayInfoParcel(C0971a c0971a, C1047g c1047g, C1040p c1040p, la laVar, boolean z, int i, VersionInfoParcel versionInfoParcel) {
        this.f3474a = 4;
        this.f3475b = null;
        this.f3476c = c0971a;
        this.f3477d = c1047g;
        this.f3478e = laVar;
        this.f3479f = null;
        this.f3480g = null;
        this.f3481h = z;
        this.f3482i = null;
        this.f3483j = c1040p;
        this.f3484k = i;
        this.f3485l = 2;
        this.f3486m = null;
        this.f3487n = versionInfoParcel;
        this.f3488o = null;
        this.f3489p = null;
        this.f3490q = null;
    }

    public AdOverlayInfoParcel(C0971a c0971a, C1047g c1047g, dx dxVar, C1040p c1040p, la laVar, boolean z, int i, String str, VersionInfoParcel versionInfoParcel, ed edVar) {
        this.f3474a = 4;
        this.f3475b = null;
        this.f3476c = c0971a;
        this.f3477d = c1047g;
        this.f3478e = laVar;
        this.f3479f = dxVar;
        this.f3480g = null;
        this.f3481h = z;
        this.f3482i = null;
        this.f3483j = c1040p;
        this.f3484k = i;
        this.f3485l = 3;
        this.f3486m = str;
        this.f3487n = versionInfoParcel;
        this.f3488o = edVar;
        this.f3489p = null;
        this.f3490q = null;
    }

    public AdOverlayInfoParcel(C0971a c0971a, C1047g c1047g, dx dxVar, C1040p c1040p, la laVar, boolean z, int i, String str, String str2, VersionInfoParcel versionInfoParcel, ed edVar) {
        this.f3474a = 4;
        this.f3475b = null;
        this.f3476c = c0971a;
        this.f3477d = c1047g;
        this.f3478e = laVar;
        this.f3479f = dxVar;
        this.f3480g = str2;
        this.f3481h = z;
        this.f3482i = str;
        this.f3483j = c1040p;
        this.f3484k = i;
        this.f3485l = 3;
        this.f3486m = null;
        this.f3487n = versionInfoParcel;
        this.f3488o = edVar;
        this.f3489p = null;
        this.f3490q = null;
    }

    public AdOverlayInfoParcel(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, C0971a c0971a, C1047g c1047g, C1040p c1040p, VersionInfoParcel versionInfoParcel) {
        this.f3474a = 4;
        this.f3475b = adLauncherIntentInfoParcel;
        this.f3476c = c0971a;
        this.f3477d = c1047g;
        this.f3478e = null;
        this.f3479f = null;
        this.f3480g = null;
        this.f3481h = false;
        this.f3482i = null;
        this.f3483j = c1040p;
        this.f3484k = -1;
        this.f3485l = 4;
        this.f3486m = null;
        this.f3487n = versionInfoParcel;
        this.f3488o = null;
        this.f3489p = null;
        this.f3490q = null;
    }

    public static AdOverlayInfoParcel m6587a(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception e) {
            return null;
        }
    }

    public static void m6588a(Intent intent, AdOverlayInfoParcel adOverlayInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    IBinder m6589a() {
        return C1001b.m5713a(this.f3476c).asBinder();
    }

    IBinder m6590b() {
        return C1001b.m5713a(this.f3477d).asBinder();
    }

    IBinder m6591c() {
        return C1001b.m5713a(this.f3478e).asBinder();
    }

    IBinder m6592d() {
        return C1001b.m5713a(this.f3479f).asBinder();
    }

    IBinder m6593e() {
        return C1001b.m5713a(this.f3488o).asBinder();
    }

    IBinder m6594f() {
        return C1001b.m5713a(this.f3483j).asBinder();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1203f.m6682a(this, parcel, i);
    }
}
