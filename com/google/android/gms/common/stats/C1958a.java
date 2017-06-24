package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;

public class C1958a implements Creator<ConnectionEvent> {
    static void m11036a(ConnectionEvent connectionEvent, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, connectionEvent.f6539a);
        C1938b.m10934a(parcel, 2, connectionEvent.mo1719a());
        C1938b.m10942a(parcel, 4, connectionEvent.m11011c(), false);
        C1938b.m10942a(parcel, 5, connectionEvent.m11012d(), false);
        C1938b.m10942a(parcel, 6, connectionEvent.m11013e(), false);
        C1938b.m10942a(parcel, 7, connectionEvent.m11014f(), false);
        C1938b.m10942a(parcel, 8, connectionEvent.m11015g(), false);
        C1938b.m10934a(parcel, 10, connectionEvent.m11019k());
        C1938b.m10934a(parcel, 11, connectionEvent.m11018j());
        C1938b.m10933a(parcel, 12, connectionEvent.mo1720b());
        C1938b.m10942a(parcel, 13, connectionEvent.m11016h(), false);
        C1938b.m10931a(parcel, a);
    }

    public ConnectionEvent m11037a(Parcel parcel) {
        int b = C1937a.m10910b(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        long j2 = 0;
        long j3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1937a.m10905a(parcel);
            switch (C1937a.m10904a(a)) {
                case 1:
                    i = C1937a.m10915d(parcel, a);
                    break;
                case 2:
                    j = C1937a.m10917f(parcel, a);
                    break;
                case 4:
                    str = C1937a.m10922k(parcel, a);
                    break;
                case 5:
                    str2 = C1937a.m10922k(parcel, a);
                    break;
                case 6:
                    str3 = C1937a.m10922k(parcel, a);
                    break;
                case 7:
                    str4 = C1937a.m10922k(parcel, a);
                    break;
                case 8:
                    str5 = C1937a.m10922k(parcel, a);
                    break;
                case 10:
                    j2 = C1937a.m10917f(parcel, a);
                    break;
                case 11:
                    j3 = C1937a.m10917f(parcel, a);
                    break;
                case 12:
                    i2 = C1937a.m10915d(parcel, a);
                    break;
                case 13:
                    str6 = C1937a.m10922k(parcel, a);
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ConnectionEvent(i, j, i2, str, str2, str3, str4, str5, str6, j2, j3);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public ConnectionEvent[] m11038a(int i) {
        return new ConnectionEvent[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11037a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11038a(i);
    }
}
