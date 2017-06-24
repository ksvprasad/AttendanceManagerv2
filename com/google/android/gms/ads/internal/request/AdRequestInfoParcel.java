package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.p031b.id;
import java.util.Collections;
import java.util.List;

@id
public final class AdRequestInfoParcel extends AbstractSafeParcelable {
    public static final C1270f CREATOR = new C1270f();
    public final List<String> f3724A;
    public final long f3725B;
    public final CapabilityParcel f3726C;
    public final String f3727D;
    public final float f3728E;
    public final int f3729F;
    public final int f3730G;
    public final boolean f3731H;
    public final boolean f3732I;
    public final String f3733J;
    public final boolean f3734K;
    public final String f3735L;
    public final boolean f3736M;
    public final int f3737N;
    public final Bundle f3738O;
    public final int f3739a;
    public final Bundle f3740b;
    public final AdRequestParcel f3741c;
    public final AdSizeParcel f3742d;
    public final String f3743e;
    public final ApplicationInfo f3744f;
    public final PackageInfo f3745g;
    public final String f3746h;
    public final String f3747i;
    public final String f3748j;
    public final VersionInfoParcel f3749k;
    public final Bundle f3750l;
    public final int f3751m;
    public final List<String> f3752n;
    public final Bundle f3753o;
    public final boolean f3754p;
    public final Messenger f3755q;
    public final int f3756r;
    public final int f3757s;
    public final float f3758t;
    public final String f3759u;
    public final long f3760v;
    public final String f3761w;
    public final List<String> f3762x;
    public final String f3763y;
    public final NativeAdOptionsParcel f3764z;

    @id
    public static final class C1249a {
        public final String f3686A;
        public final float f3687B;
        public final boolean f3688C;
        public final int f3689D;
        public final int f3690E;
        public final boolean f3691F;
        public final boolean f3692G;
        public final String f3693H;
        public final String f3694I;
        public final boolean f3695J;
        public final int f3696K;
        public final Bundle f3697L;
        public final Bundle f3698a;
        public final AdRequestParcel f3699b;
        public final AdSizeParcel f3700c;
        public final String f3701d;
        public final ApplicationInfo f3702e;
        public final PackageInfo f3703f;
        public final String f3704g;
        public final String f3705h;
        public final Bundle f3706i;
        public final VersionInfoParcel f3707j;
        public final int f3708k;
        public final List<String> f3709l;
        public final List<String> f3710m;
        public final Bundle f3711n;
        public final boolean f3712o;
        public final Messenger f3713p;
        public final int f3714q;
        public final int f3715r;
        public final float f3716s;
        public final String f3717t;
        public final long f3718u;
        public final String f3719v;
        public final List<String> f3720w;
        public final String f3721x;
        public final NativeAdOptionsParcel f3722y;
        public final CapabilityParcel f3723z;

        public C1249a(Bundle bundle, AdRequestParcel adRequestParcel, AdSizeParcel adSizeParcel, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, VersionInfoParcel versionInfoParcel, Bundle bundle2, List<String> list, List<String> list2, Bundle bundle3, boolean z, Messenger messenger, int i, int i2, float f, String str4, long j, String str5, List<String> list3, String str6, NativeAdOptionsParcel nativeAdOptionsParcel, CapabilityParcel capabilityParcel, String str7, float f2, boolean z2, int i3, int i4, boolean z3, boolean z4, String str8, String str9, boolean z5, int i5, Bundle bundle4) {
            this.f3698a = bundle;
            this.f3699b = adRequestParcel;
            this.f3700c = adSizeParcel;
            this.f3701d = str;
            this.f3702e = applicationInfo;
            this.f3703f = packageInfo;
            this.f3704g = str2;
            this.f3705h = str3;
            this.f3707j = versionInfoParcel;
            this.f3706i = bundle2;
            this.f3712o = z;
            this.f3713p = messenger;
            this.f3714q = i;
            this.f3715r = i2;
            this.f3716s = f;
            if (list == null || list.size() <= 0) {
                if (adSizeParcel.f3113k) {
                    this.f3708k = 4;
                } else {
                    this.f3708k = 0;
                }
                this.f3709l = null;
                this.f3710m = null;
            } else {
                this.f3708k = 3;
                this.f3709l = list;
                this.f3710m = list2;
            }
            this.f3711n = bundle3;
            this.f3717t = str4;
            this.f3718u = j;
            this.f3719v = str5;
            this.f3720w = list3;
            this.f3721x = str6;
            this.f3722y = nativeAdOptionsParcel;
            this.f3723z = capabilityParcel;
            this.f3686A = str7;
            this.f3687B = f2;
            this.f3688C = z2;
            this.f3689D = i3;
            this.f3690E = i4;
            this.f3691F = z3;
            this.f3692G = z4;
            this.f3693H = str8;
            this.f3694I = str9;
            this.f3695J = z5;
            this.f3696K = i5;
            this.f3697L = bundle4;
        }
    }

    AdRequestInfoParcel(int i, Bundle bundle, AdRequestParcel adRequestParcel, AdSizeParcel adSizeParcel, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, VersionInfoParcel versionInfoParcel, Bundle bundle2, int i2, List<String> list, Bundle bundle3, boolean z, Messenger messenger, int i3, int i4, float f, String str5, long j, String str6, List<String> list2, String str7, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list3, long j2, CapabilityParcel capabilityParcel, String str8, float f2, boolean z2, int i5, int i6, boolean z3, boolean z4, String str9, String str10, boolean z5, int i7, Bundle bundle4) {
        this.f3739a = i;
        this.f3740b = bundle;
        this.f3741c = adRequestParcel;
        this.f3742d = adSizeParcel;
        this.f3743e = str;
        this.f3744f = applicationInfo;
        this.f3745g = packageInfo;
        this.f3746h = str2;
        this.f3747i = str3;
        this.f3748j = str4;
        this.f3749k = versionInfoParcel;
        this.f3750l = bundle2;
        this.f3751m = i2;
        this.f3752n = list;
        this.f3724A = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.f3753o = bundle3;
        this.f3754p = z;
        this.f3755q = messenger;
        this.f3756r = i3;
        this.f3757s = i4;
        this.f3758t = f;
        this.f3759u = str5;
        this.f3760v = j;
        this.f3761w = str6;
        this.f3762x = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.f3763y = str7;
        this.f3764z = nativeAdOptionsParcel;
        this.f3725B = j2;
        this.f3726C = capabilityParcel;
        this.f3727D = str8;
        this.f3728E = f2;
        this.f3734K = z2;
        this.f3729F = i5;
        this.f3730G = i6;
        this.f3731H = z3;
        this.f3732I = z4;
        this.f3733J = str9;
        this.f3735L = str10;
        this.f3736M = z5;
        this.f3737N = i7;
        this.f3738O = bundle4;
    }

    public AdRequestInfoParcel(Bundle bundle, AdRequestParcel adRequestParcel, AdSizeParcel adSizeParcel, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, VersionInfoParcel versionInfoParcel, Bundle bundle2, int i, List<String> list, List<String> list2, Bundle bundle3, boolean z, Messenger messenger, int i2, int i3, float f, String str5, long j, String str6, List<String> list3, String str7, NativeAdOptionsParcel nativeAdOptionsParcel, long j2, CapabilityParcel capabilityParcel, String str8, float f2, boolean z2, int i4, int i5, boolean z3, boolean z4, String str9, String str10, boolean z5, int i6, Bundle bundle4) {
        this(18, bundle, adRequestParcel, adSizeParcel, str, applicationInfo, packageInfo, str2, str3, str4, versionInfoParcel, bundle2, i, list, bundle3, z, messenger, i2, i3, f, str5, j, str6, list3, str7, nativeAdOptionsParcel, list2, j2, capabilityParcel, str8, f2, z2, i4, i5, z3, z4, str9, str10, z5, i6, bundle4);
    }

    public AdRequestInfoParcel(C1249a c1249a, String str, long j) {
        this(c1249a.f3698a, c1249a.f3699b, c1249a.f3700c, c1249a.f3701d, c1249a.f3702e, c1249a.f3703f, str, c1249a.f3704g, c1249a.f3705h, c1249a.f3707j, c1249a.f3706i, c1249a.f3708k, c1249a.f3709l, c1249a.f3710m, c1249a.f3711n, c1249a.f3712o, c1249a.f3713p, c1249a.f3714q, c1249a.f3715r, c1249a.f3716s, c1249a.f3717t, c1249a.f3718u, c1249a.f3719v, c1249a.f3720w, c1249a.f3721x, c1249a.f3722y, j, c1249a.f3723z, c1249a.f3686A, c1249a.f3687B, c1249a.f3688C, c1249a.f3689D, c1249a.f3690E, c1249a.f3691F, c1249a.f3692G, c1249a.f3693H, c1249a.f3694I, c1249a.f3695J, c1249a.f3696K, c1249a.f3697L);
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1270f.m6988a(this, parcel, i);
    }
}
