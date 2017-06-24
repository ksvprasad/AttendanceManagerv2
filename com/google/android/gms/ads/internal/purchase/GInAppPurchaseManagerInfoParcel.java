package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.p031b.hc;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p033a.C0998a.C1000a;
import com.google.android.gms.p033a.C1001b;

@id
public final class GInAppPurchaseManagerInfoParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final C1224a CREATOR = new C1224a();
    public final int f3618a;
    public final C1239k f3619b;
    public final hc f3620c;
    public final Context f3621d;
    public final C1048j f3622e;

    GInAppPurchaseManagerInfoParcel(int i, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4) {
        this.f3618a = i;
        this.f3619b = (C1239k) C1001b.m5714a(C1000a.m5712a(iBinder));
        this.f3620c = (hc) C1001b.m5714a(C1000a.m5712a(iBinder2));
        this.f3621d = (Context) C1001b.m5714a(C1000a.m5712a(iBinder3));
        this.f3622e = (C1048j) C1001b.m5714a(C1000a.m5712a(iBinder4));
    }

    public GInAppPurchaseManagerInfoParcel(Context context, C1239k c1239k, hc hcVar, C1048j c1048j) {
        this.f3618a = 2;
        this.f3621d = context;
        this.f3619b = c1239k;
        this.f3620c = hcVar;
        this.f3622e = c1048j;
    }

    public static GInAppPurchaseManagerInfoParcel m6784a(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
            bundleExtra.setClassLoader(GInAppPurchaseManagerInfoParcel.class.getClassLoader());
            return (GInAppPurchaseManagerInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
        } catch (Exception e) {
            return null;
        }
    }

    public static void m6785a(Intent intent, GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", gInAppPurchaseManagerInfoParcel);
        intent.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", bundle);
    }

    IBinder m6786a() {
        return C1001b.m5713a(this.f3622e).asBinder();
    }

    IBinder m6787b() {
        return C1001b.m5713a(this.f3619b).asBinder();
    }

    IBinder m6788c() {
        return C1001b.m5713a(this.f3620c).asBinder();
    }

    IBinder m6789d() {
        return C1001b.m5713a(this.f3621d).asBinder();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1224a.m6790a(this, parcel, i);
    }
}
