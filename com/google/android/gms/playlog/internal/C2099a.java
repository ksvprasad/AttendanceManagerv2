package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;

public class C2099a implements Creator<PlayLoggerContext> {
    static void m12019a(PlayLoggerContext playLoggerContext, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, playLoggerContext.f7029a);
        C1938b.m10942a(parcel, 2, playLoggerContext.f7030b, false);
        C1938b.m10933a(parcel, 3, playLoggerContext.f7031c);
        C1938b.m10933a(parcel, 4, playLoggerContext.f7032d);
        C1938b.m10942a(parcel, 5, playLoggerContext.f7033e, false);
        C1938b.m10942a(parcel, 6, playLoggerContext.f7034f, false);
        C1938b.m10944a(parcel, 7, playLoggerContext.f7035g);
        C1938b.m10942a(parcel, 8, playLoggerContext.f7036h, false);
        C1938b.m10944a(parcel, 9, playLoggerContext.f7037i);
        C1938b.m10933a(parcel, 10, playLoggerContext.f7038j);
        C1938b.m10931a(parcel, a);
    }

    public PlayLoggerContext m12020a(Parcel parcel) {
        String str = null;
        int i = 0;
        int b = C1937a.m10910b(parcel);
        boolean z = true;
        boolean z2 = false;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        int i3 = 0;
        String str4 = null;
        int i4 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1937a.m10905a(parcel);
            switch (C1937a.m10904a(a)) {
                case 1:
                    i4 = C1937a.m10915d(parcel, a);
                    break;
                case 2:
                    str4 = C1937a.m10922k(parcel, a);
                    break;
                case 3:
                    i3 = C1937a.m10915d(parcel, a);
                    break;
                case 4:
                    i2 = C1937a.m10915d(parcel, a);
                    break;
                case 5:
                    str3 = C1937a.m10922k(parcel, a);
                    break;
                case 6:
                    str2 = C1937a.m10922k(parcel, a);
                    break;
                case 7:
                    z = C1937a.m10914c(parcel, a);
                    break;
                case 8:
                    str = C1937a.m10922k(parcel, a);
                    break;
                case 9:
                    z2 = C1937a.m10914c(parcel, a);
                    break;
                case 10:
                    i = C1937a.m10915d(parcel, a);
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new PlayLoggerContext(i4, str4, i3, i2, str3, str2, z, str, z2, i);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public PlayLoggerContext[] m12021a(int i) {
        return new PlayLoggerContext[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m12020a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m12021a(i);
    }
}
