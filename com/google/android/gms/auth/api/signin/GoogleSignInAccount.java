package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.util.C1970c;
import com.google.android.gms.common.util.C1972e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<GoogleSignInAccount> CREATOR = new C1355a();
    public static C1970c f4029a = C1972e.m11087d();
    private static Comparator<Scope> f4030n = new C13531();
    final int f4031b;
    List<Scope> f4032c;
    private String f4033d;
    private String f4034e;
    private String f4035f;
    private String f4036g;
    private Uri f4037h;
    private String f4038i;
    private long f4039j;
    private String f4040k;
    private String f4041l;
    private String f4042m;

    class C13531 implements Comparator<Scope> {
        C13531() {
        }

        public int m7302a(Scope scope, Scope scope2) {
            return scope.m10558a().compareTo(scope2.m10558a());
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m7302a((Scope) obj, (Scope) obj2);
        }
    }

    GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List<Scope> list, String str7, String str8) {
        this.f4031b = i;
        this.f4033d = str;
        this.f4034e = str2;
        this.f4035f = str3;
        this.f4036g = str4;
        this.f4037h = uri;
        this.f4038i = str5;
        this.f4039j = j;
        this.f4040k = str6;
        this.f4032c = list;
        this.f4041l = str7;
        this.f4042m = str8;
    }

    public static GoogleSignInAccount m7303a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        Object optString = jSONObject.optString("photoUrl", null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        Set hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        return m7304a(jSONObject.optString("id"), jSONObject.optString("tokenId", null), jSONObject.optString("email", null), jSONObject.optString("displayName", null), jSONObject.optString("givenName", null), jSONObject.optString("familyName", null), parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet).m7307b(jSONObject.optString("serverAuthCode", null));
    }

    public static GoogleSignInAccount m7304a(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l, String str7, Set<Scope> set) {
        if (l == null) {
            l = Long.valueOf(f4029a.mo1723a() / 1000);
        }
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, l.longValue(), C1896c.m10792a(str7), new ArrayList((Collection) C1896c.m10790a((Object) set)), str5, str6);
    }

    private JSONObject m7305l() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (m7306a() != null) {
                jSONObject.put("id", m7306a());
            }
            if (m7308b() != null) {
                jSONObject.put("tokenId", m7308b());
            }
            if (m7309c() != null) {
                jSONObject.put("email", m7309c());
            }
            if (m7310d() != null) {
                jSONObject.put("displayName", m7310d());
            }
            if (m7311e() != null) {
                jSONObject.put("givenName", m7311e());
            }
            if (m7312f() != null) {
                jSONObject.put("familyName", m7312f());
            }
            if (m7313g() != null) {
                jSONObject.put("photoUrl", m7313g().toString());
            }
            if (m7314h() != null) {
                jSONObject.put("serverAuthCode", m7314h());
            }
            jSONObject.put("expirationTime", this.f4039j);
            jSONObject.put("obfuscatedIdentifier", m7316j());
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f4032c, f4030n);
            for (Scope a : this.f4032c) {
                jSONArray.put(a.m10558a());
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public String m7306a() {
        return this.f4033d;
    }

    public GoogleSignInAccount m7307b(String str) {
        this.f4038i = str;
        return this;
    }

    public String m7308b() {
        return this.f4034e;
    }

    public String m7309c() {
        return this.f4035f;
    }

    public String m7310d() {
        return this.f4036g;
    }

    public String m7311e() {
        return this.f4041l;
    }

    public boolean equals(Object obj) {
        return !(obj instanceof GoogleSignInAccount) ? false : ((GoogleSignInAccount) obj).m7317k().equals(m7317k());
    }

    public String m7312f() {
        return this.f4042m;
    }

    public Uri m7313g() {
        return this.f4037h;
    }

    public String m7314h() {
        return this.f4038i;
    }

    public long m7315i() {
        return this.f4039j;
    }

    public String m7316j() {
        return this.f4040k;
    }

    public String m7317k() {
        return m7305l().toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1355a.m7323a(this, parcel, i);
    }
}
