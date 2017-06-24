package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.p031b.id;
import java.util.Collections;
import java.util.List;

@id
public final class AdResponseParcel extends AbstractSafeParcelable {
    public static final C1274h CREATOR = new C1274h();
    public final boolean f3765A;
    public final boolean f3766B;
    public final RewardItemParcel f3767C;
    public final List<String> f3768D;
    public final List<String> f3769E;
    public final boolean f3770F;
    public final AutoClickProtectionConfigurationParcel f3771G;
    public final boolean f3772H;
    public String f3773I;
    public final List<String> f3774J;
    public final String f3775K;
    public final boolean f3776L;
    public final String f3777M;
    private AdRequestInfoParcel f3778N;
    public final int f3779a;
    public final String f3780b;
    public String f3781c;
    public final List<String> f3782d;
    public final int f3783e;
    public final List<String> f3784f;
    public final long f3785g;
    public final boolean f3786h;
    public final long f3787i;
    public final List<String> f3788j;
    public final long f3789k;
    public final int f3790l;
    public final String f3791m;
    public final long f3792n;
    public final String f3793o;
    public final boolean f3794p;
    public final String f3795q;
    public final String f3796r;
    public final boolean f3797s;
    public final boolean f3798t;
    public final boolean f3799u;
    public final boolean f3800v;
    public final boolean f3801w;
    public LargeParcelTeleporter f3802x;
    public String f3803y;
    public final String f3804z;

    public AdResponseParcel(int i) {
        this(18, null, null, null, i, null, -1, false, -1, null, -1, -1, null, -1, null, false, null, null, false, false, false, true, false, null, null, null, false, false, null, null, null, false, null, false, null, null, null, false, null);
    }

    public AdResponseParcel(int i, long j) {
        this(18, null, null, null, i, null, -1, false, -1, null, j, -1, null, -1, null, false, null, null, false, false, false, true, false, null, null, null, false, false, null, null, null, false, null, false, null, null, null, false, null);
    }

    AdResponseParcel(int i, String str, String str2, List<String> list, int i2, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i3, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, LargeParcelTeleporter largeParcelTeleporter, String str7, String str8, boolean z8, boolean z9, RewardItemParcel rewardItemParcel, List<String> list4, List<String> list5, boolean z10, AutoClickProtectionConfigurationParcel autoClickProtectionConfigurationParcel, boolean z11, String str9, List<String> list6, String str10, boolean z12, String str11) {
        this.f3779a = i;
        this.f3780b = str;
        this.f3781c = str2;
        this.f3782d = list != null ? Collections.unmodifiableList(list) : null;
        this.f3783e = i2;
        this.f3784f = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.f3785g = j;
        this.f3786h = z;
        this.f3787i = j2;
        this.f3788j = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.f3789k = j3;
        this.f3790l = i3;
        this.f3791m = str3;
        this.f3792n = j4;
        this.f3793o = str4;
        this.f3794p = z2;
        this.f3795q = str5;
        this.f3796r = str6;
        this.f3797s = z3;
        this.f3798t = z4;
        this.f3799u = z5;
        this.f3800v = z6;
        this.f3801w = z7;
        this.f3802x = largeParcelTeleporter;
        this.f3803y = str7;
        this.f3804z = str8;
        if (this.f3781c == null && this.f3802x != null) {
            StringParcel stringParcel = (StringParcel) this.f3802x.m6893a(StringParcel.CREATOR);
            if (!(stringParcel == null || TextUtils.isEmpty(stringParcel.m6894a()))) {
                this.f3781c = stringParcel.m6894a();
            }
        }
        this.f3765A = z8;
        this.f3766B = z9;
        this.f3767C = rewardItemParcel;
        this.f3768D = list4;
        this.f3769E = list5;
        this.f3770F = z10;
        this.f3771G = autoClickProtectionConfigurationParcel;
        this.f3772H = z11;
        this.f3773I = str9;
        this.f3774J = list6;
        this.f3775K = str10;
        this.f3776L = z12;
        this.f3777M = str11;
    }

    public AdResponseParcel(AdRequestInfoParcel adRequestInfoParcel, String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, String str5, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str6, boolean z7, boolean z8, RewardItemParcel rewardItemParcel, List<String> list4, List<String> list5, boolean z9, AutoClickProtectionConfigurationParcel autoClickProtectionConfigurationParcel, boolean z10, String str7, List<String> list6, String str8, boolean z11, String str9) {
        this(18, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, false, null, str5, z2, z3, z4, z5, z6, null, null, str6, z7, z8, rewardItemParcel, list4, list5, z9, autoClickProtectionConfigurationParcel, z10, str7, list6, str8, z11, str9);
        this.f3778N = adRequestInfoParcel;
    }

    public AdResponseParcel(AdRequestInfoParcel adRequestInfoParcel, String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str7, boolean z8, boolean z9, RewardItemParcel rewardItemParcel, List<String> list4, List<String> list5, boolean z10, AutoClickProtectionConfigurationParcel autoClickProtectionConfigurationParcel, boolean z11, String str8, List<String> list6, String str9, boolean z12, String str10) {
        this(18, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, null, null, str7, z8, z9, rewardItemParcel, list4, list5, z10, autoClickProtectionConfigurationParcel, z11, str8, list6, str9, z12, str10);
        this.f3778N = adRequestInfoParcel;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (!(this.f3778N == null || this.f3778N.f3739a < 9 || TextUtils.isEmpty(this.f3781c))) {
            this.f3802x = new LargeParcelTeleporter(new StringParcel(this.f3781c));
            this.f3781c = null;
        }
        C1274h.m6994a(this, parcel, i);
    }
}
