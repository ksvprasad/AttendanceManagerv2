package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;

public class C1885i implements Creator<ConnectionResult> {
    static void m10661a(ConnectionResult connectionResult, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, connectionResult.f6324b);
        C1938b.m10933a(parcel, 2, connectionResult.m10548c());
        C1938b.m10937a(parcel, 3, connectionResult.m10549d(), i, false);
        C1938b.m10942a(parcel, 4, connectionResult.m10550e(), false);
        C1938b.m10931a(parcel, a);
    }

    public ConnectionResult m10662a(Parcel parcel) {
        String str = null;
        int i = 0;
        int b = C1937a.m10910b(parcel);
        PendingIntent pendingIntent = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            PendingIntent pendingIntent2;
            int i3;
            String str2;
            int a = C1937a.m10905a(parcel);
            String str3;
            switch (C1937a.m10904a(a)) {
                case 1:
                    str3 = str;
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = C1937a.m10915d(parcel, a);
                    str2 = str3;
                    break;
                case 2:
                    i = i2;
                    PendingIntent pendingIntent3 = pendingIntent;
                    i3 = C1937a.m10915d(parcel, a);
                    str2 = str;
                    pendingIntent2 = pendingIntent3;
                    break;
                case 3:
                    i3 = i;
                    i = i2;
                    str3 = str;
                    pendingIntent2 = (PendingIntent) C1937a.m10907a(parcel, a, PendingIntent.CREATOR);
                    str2 = str3;
                    break;
                case 4:
                    str2 = C1937a.m10922k(parcel, a);
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = i2;
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    str2 = str;
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = i2;
                    break;
            }
            i2 = i;
            i = i3;
            pendingIntent = pendingIntent2;
            str = str2;
        }
        if (parcel.dataPosition() == b) {
            return new ConnectionResult(i2, i, pendingIntent, str);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public ConnectionResult[] m10663a(int i) {
        return new ConnectionResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10662a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10663a(i);
    }
}
