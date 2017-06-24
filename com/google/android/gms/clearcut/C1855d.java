package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;
import com.google.android.gms.playlog.internal.PlayLoggerContext;

public class C1855d implements Creator<LogEventParcelable> {
    static void m10542a(LogEventParcelable logEventParcelable, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, logEventParcelable.f6278a);
        C1938b.m10937a(parcel, 2, logEventParcelable.f6279b, i, false);
        C1938b.m10945a(parcel, 3, logEventParcelable.f6280c, false);
        C1938b.m10946a(parcel, 4, logEventParcelable.f6281d, false);
        C1938b.m10948a(parcel, 5, logEventParcelable.f6282e, false);
        C1938b.m10946a(parcel, 6, logEventParcelable.f6283f, false);
        C1938b.m10949a(parcel, 7, logEventParcelable.f6284g, false);
        C1938b.m10944a(parcel, 8, logEventParcelable.f6285h);
        C1938b.m10931a(parcel, a);
    }

    public LogEventParcelable m10543a(Parcel parcel) {
        byte[][] bArr = null;
        int b = C1937a.m10910b(parcel);
        int i = 0;
        boolean z = true;
        int[] iArr = null;
        String[] strArr = null;
        int[] iArr2 = null;
        byte[] bArr2 = null;
        PlayLoggerContext playLoggerContext = null;
        while (parcel.dataPosition() < b) {
            int a = C1937a.m10905a(parcel);
            switch (C1937a.m10904a(a)) {
                case 1:
                    i = C1937a.m10915d(parcel, a);
                    break;
                case 2:
                    playLoggerContext = (PlayLoggerContext) C1937a.m10907a(parcel, a, PlayLoggerContext.CREATOR);
                    break;
                case 3:
                    bArr2 = C1937a.m10925n(parcel, a);
                    break;
                case 4:
                    iArr2 = C1937a.m10927p(parcel, a);
                    break;
                case 5:
                    strArr = C1937a.m10928q(parcel, a);
                    break;
                case 6:
                    iArr = C1937a.m10927p(parcel, a);
                    break;
                case 7:
                    bArr = C1937a.m10926o(parcel, a);
                    break;
                case 8:
                    z = C1937a.m10914c(parcel, a);
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new LogEventParcelable(i, playLoggerContext, bArr2, iArr2, strArr, iArr, bArr, z);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public LogEventParcelable[] m10544a(int i) {
        return new LogEventParcelable[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10543a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10544a(i);
    }
}
