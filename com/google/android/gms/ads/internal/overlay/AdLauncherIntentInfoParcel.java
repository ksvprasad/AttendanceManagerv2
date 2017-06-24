package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.p031b.id;

@id
public final class AdLauncherIntentInfoParcel extends AbstractSafeParcelable {
    public static final C1183b CREATOR = new C1183b();
    public final int f3465a;
    public final String f3466b;
    public final String f3467c;
    public final String f3468d;
    public final String f3469e;
    public final String f3470f;
    public final String f3471g;
    public final String f3472h;
    public final Intent f3473i;

    public AdLauncherIntentInfoParcel(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, Intent intent) {
        this.f3465a = i;
        this.f3466b = str;
        this.f3467c = str2;
        this.f3468d = str3;
        this.f3469e = str4;
        this.f3470f = str5;
        this.f3471g = str6;
        this.f3472h = str7;
        this.f3473i = intent;
    }

    public AdLauncherIntentInfoParcel(Intent intent) {
        this(2, null, null, null, null, null, null, null, intent);
    }

    public AdLauncherIntentInfoParcel(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this(2, str, str2, str3, str4, str5, str6, str7, null);
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1183b.m6597a(this, parcel, i);
    }
}
