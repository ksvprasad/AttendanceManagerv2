package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;
import java.util.List;

public class C1966g implements Creator<WakeLockEvent> {
    static void m11061a(WakeLockEvent wakeLockEvent, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, wakeLockEvent.f6551a);
        C1938b.m10934a(parcel, 2, wakeLockEvent.mo1719a());
        C1938b.m10942a(parcel, 4, wakeLockEvent.m11023c(), false);
        C1938b.m10933a(parcel, 5, wakeLockEvent.m11026f());
        C1938b.m10943a(parcel, 6, wakeLockEvent.m11027g(), false);
        C1938b.m10934a(parcel, 8, wakeLockEvent.m11030j());
        C1938b.m10942a(parcel, 10, wakeLockEvent.m11024d(), false);
        C1938b.m10933a(parcel, 11, wakeLockEvent.mo1720b());
        C1938b.m10942a(parcel, 12, wakeLockEvent.m11028h(), false);
        C1938b.m10942a(parcel, 13, wakeLockEvent.m11033m(), false);
        C1938b.m10933a(parcel, 14, wakeLockEvent.m11031k());
        C1938b.m10932a(parcel, 15, wakeLockEvent.m11034n());
        C1938b.m10934a(parcel, 16, wakeLockEvent.m11035o());
        C1938b.m10942a(parcel, 17, wakeLockEvent.m11025e(), false);
        C1938b.m10931a(parcel, a);
    }

    public WakeLockEvent m11062a(Parcel parcel) {
        int b = C1937a.m10910b(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        List list = null;
        String str2 = null;
        long j2 = 0;
        int i4 = 0;
        String str3 = null;
        String str4 = null;
        float f = 0.0f;
        long j3 = 0;
        String str5 = null;
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
                    i3 = C1937a.m10915d(parcel, a);
                    break;
                case 6:
                    list = C1937a.m10929r(parcel, a);
                    break;
                case 8:
                    j2 = C1937a.m10917f(parcel, a);
                    break;
                case 10:
                    str3 = C1937a.m10922k(parcel, a);
                    break;
                case 11:
                    i2 = C1937a.m10915d(parcel, a);
                    break;
                case 12:
                    str2 = C1937a.m10922k(parcel, a);
                    break;
                case 13:
                    str4 = C1937a.m10922k(parcel, a);
                    break;
                case 14:
                    i4 = C1937a.m10915d(parcel, a);
                    break;
                case 15:
                    f = C1937a.m10919h(parcel, a);
                    break;
                case 16:
                    j3 = C1937a.m10917f(parcel, a);
                    break;
                case 17:
                    str5 = C1937a.m10922k(parcel, a);
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new WakeLockEvent(i, j, i2, str, i3, list, str2, j2, i4, str3, str4, f, j3, str5);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public WakeLockEvent[] m11063a(int i) {
        return new WakeLockEvent[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11062a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11063a(i);
    }
}
