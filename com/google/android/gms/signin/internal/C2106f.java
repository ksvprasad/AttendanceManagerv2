package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;

public class C2106f implements Creator<RecordConsentRequest> {
    static void m12063a(RecordConsentRequest recordConsentRequest, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, recordConsentRequest.f7045a);
        C1938b.m10937a(parcel, 2, recordConsentRequest.m12025a(), i, false);
        C1938b.m10947a(parcel, 3, recordConsentRequest.m12026b(), i, false);
        C1938b.m10942a(parcel, 4, recordConsentRequest.m12027c(), false);
        C1938b.m10931a(parcel, a);
    }

    public RecordConsentRequest m12064a(Parcel parcel) {
        String str = null;
        int b = C1937a.m10910b(parcel);
        int i = 0;
        Scope[] scopeArr = null;
        Account account = null;
        while (parcel.dataPosition() < b) {
            Scope[] scopeArr2;
            Account account2;
            int d;
            String str2;
            int a = C1937a.m10905a(parcel);
            String str3;
            switch (C1937a.m10904a(a)) {
                case 1:
                    str3 = str;
                    scopeArr2 = scopeArr;
                    account2 = account;
                    d = C1937a.m10915d(parcel, a);
                    str2 = str3;
                    break;
                case 2:
                    d = i;
                    Scope[] scopeArr3 = scopeArr;
                    account2 = (Account) C1937a.m10907a(parcel, a, Account.CREATOR);
                    str2 = str;
                    scopeArr2 = scopeArr3;
                    break;
                case 3:
                    account2 = account;
                    d = i;
                    str3 = str;
                    scopeArr2 = (Scope[]) C1937a.m10912b(parcel, a, Scope.CREATOR);
                    str2 = str3;
                    break;
                case 4:
                    str2 = C1937a.m10922k(parcel, a);
                    scopeArr2 = scopeArr;
                    account2 = account;
                    d = i;
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    str2 = str;
                    scopeArr2 = scopeArr;
                    account2 = account;
                    d = i;
                    break;
            }
            i = d;
            account = account2;
            scopeArr = scopeArr2;
            str = str2;
        }
        if (parcel.dataPosition() == b) {
            return new RecordConsentRequest(i, account, scopeArr, str);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public RecordConsentRequest[] m12065a(int i) {
        return new RecordConsentRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m12064a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m12065a(i);
    }
}
