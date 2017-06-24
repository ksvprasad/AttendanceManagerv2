package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C1895b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class ConnectionResult extends AbstractSafeParcelable {
    public static final Creator<ConnectionResult> CREATOR = new C1885i();
    public static final ConnectionResult f6323a = new ConnectionResult(0);
    final int f6324b;
    private final int f6325c;
    private final PendingIntent f6326d;
    private final String f6327e;

    public ConnectionResult(int i) {
        this(i, null, null);
    }

    ConnectionResult(int i, int i2, PendingIntent pendingIntent, String str) {
        this.f6324b = i;
        this.f6325c = i2;
        this.f6326d = pendingIntent;
        this.f6327e = str;
    }

    public ConnectionResult(int i, PendingIntent pendingIntent) {
        this(i, pendingIntent, null);
    }

    public ConnectionResult(int i, PendingIntent pendingIntent, String str) {
        this(1, i, pendingIntent, str);
    }

    static String m10545a(int i) {
        switch (i) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            case 13:
                return "CANCELED";
            case 14:
                return "TIMEOUT";
            case 15:
                return "INTERRUPTED";
            case 16:
                return "API_UNAVAILABLE";
            case 17:
                return "SIGN_IN_FAILED";
            case 18:
                return "SERVICE_UPDATING";
            case 19:
                return "SERVICE_MISSING_PERMISSION";
            case 20:
                return "RESTRICTED_PROFILE";
            case 21:
                return "API_VERSION_UPDATE_REQUIRED";
            case 42:
                return "UPDATE_ANDROID_WEAR";
            case 99:
                return "UNFINISHED";
            case 1500:
                return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
            default:
                return "UNKNOWN_ERROR_CODE(" + i + ")";
        }
    }

    public boolean m10546a() {
        return (this.f6325c == 0 || this.f6326d == null) ? false : true;
    }

    public boolean m10547b() {
        return this.f6325c == 0;
    }

    public int m10548c() {
        return this.f6325c;
    }

    public PendingIntent m10549d() {
        return this.f6326d;
    }

    public String m10550e() {
        return this.f6327e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.f6325c == connectionResult.f6325c && C1895b.m10789a(this.f6326d, connectionResult.f6326d) && C1895b.m10789a(this.f6327e, connectionResult.f6327e);
    }

    public int hashCode() {
        return C1895b.m10787a(Integer.valueOf(this.f6325c), this.f6326d, this.f6327e);
    }

    public String toString() {
        return C1895b.m10788a((Object) this).m10786a("statusCode", m10545a(this.f6325c)).m10786a("resolution", this.f6326d).m10786a("message", this.f6327e).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1885i.m10661a(this, parcel, i);
    }
}
