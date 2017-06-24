package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;
import java.util.List;

public class C1355a implements Creator<GoogleSignInAccount> {
    static void m7323a(GoogleSignInAccount googleSignInAccount, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, googleSignInAccount.f4031b);
        C1938b.m10942a(parcel, 2, googleSignInAccount.m7306a(), false);
        C1938b.m10942a(parcel, 3, googleSignInAccount.m7308b(), false);
        C1938b.m10942a(parcel, 4, googleSignInAccount.m7309c(), false);
        C1938b.m10942a(parcel, 5, googleSignInAccount.m7310d(), false);
        C1938b.m10937a(parcel, 6, googleSignInAccount.m7313g(), i, false);
        C1938b.m10942a(parcel, 7, googleSignInAccount.m7314h(), false);
        C1938b.m10934a(parcel, 8, googleSignInAccount.m7315i());
        C1938b.m10942a(parcel, 9, googleSignInAccount.m7316j(), false);
        C1938b.m10953b(parcel, 10, googleSignInAccount.f4032c, false);
        C1938b.m10942a(parcel, 11, googleSignInAccount.m7311e(), false);
        C1938b.m10942a(parcel, 12, googleSignInAccount.m7312f(), false);
        C1938b.m10931a(parcel, a);
    }

    public GoogleSignInAccount m7324a(Parcel parcel) {
        int b = C1937a.m10910b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        long j = 0;
        String str6 = null;
        List list = null;
        String str7 = null;
        String str8 = null;
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
                    str2 = C1937a.m10922k(parcel, a);
                    break;
                case 4:
                    str3 = C1937a.m10922k(parcel, a);
                    break;
                case 5:
                    str4 = C1937a.m10922k(parcel, a);
                    break;
                case 6:
                    uri = (Uri) C1937a.m10907a(parcel, a, Uri.CREATOR);
                    break;
                case 7:
                    str5 = C1937a.m10922k(parcel, a);
                    break;
                case 8:
                    j = C1937a.m10917f(parcel, a);
                    break;
                case 9:
                    str6 = C1937a.m10922k(parcel, a);
                    break;
                case 10:
                    list = C1937a.m10913c(parcel, a, Scope.CREATOR);
                    break;
                case 11:
                    str7 = C1937a.m10922k(parcel, a);
                    break;
                case 12:
                    str8 = C1937a.m10922k(parcel, a);
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GoogleSignInAccount(i, str, str2, str3, str4, uri, str5, j, str6, list, str7, str8);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public GoogleSignInAccount[] m7325a(int i) {
        return new GoogleSignInAccount[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7324a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7325a(i);
    }
}
