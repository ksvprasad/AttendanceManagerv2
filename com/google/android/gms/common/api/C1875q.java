package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;

public class C1875q implements Creator<Status> {
    static void m10602a(Status status, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, status.m10566f());
        C1938b.m10942a(parcel, 2, status.m10563c(), false);
        C1938b.m10937a(parcel, 3, status.m10562b(), i, false);
        C1938b.m10933a(parcel, 1000, status.m10564d());
        C1938b.m10931a(parcel, a);
    }

    public Status m10603a(Parcel parcel) {
        PendingIntent pendingIntent = null;
        int i = 0;
        int b = C1937a.m10910b(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1937a.m10905a(parcel);
            switch (C1937a.m10904a(a)) {
                case 1:
                    i = C1937a.m10915d(parcel, a);
                    break;
                case 2:
                    str = C1937a.m10922k(parcel, a);
                    break;
                case 3:
                    pendingIntent = (PendingIntent) C1937a.m10907a(parcel, a, PendingIntent.CREATOR);
                    break;
                case 1000:
                    i2 = C1937a.m10915d(parcel, a);
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new Status(i2, i, str, pendingIntent);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public Status[] m10604a(int i) {
        return new Status[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10603a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10604a(i);
    }
}
