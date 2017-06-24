package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.C1895b;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class PlayLoggerContext extends AbstractSafeParcelable {
    public static final C2099a CREATOR = new C2099a();
    public final int f7029a;
    public final String f7030b;
    public final int f7031c;
    public final int f7032d;
    public final String f7033e;
    public final String f7034f;
    public final boolean f7035g;
    public final String f7036h;
    public final boolean f7037i;
    public final int f7038j;

    public PlayLoggerContext(int i, String str, int i2, int i3, String str2, String str3, boolean z, String str4, boolean z2, int i4) {
        this.f7029a = i;
        this.f7030b = str;
        this.f7031c = i2;
        this.f7032d = i3;
        this.f7033e = str2;
        this.f7034f = str3;
        this.f7035g = z;
        this.f7036h = str4;
        this.f7037i = z2;
        this.f7038j = i4;
    }

    public PlayLoggerContext(String str, int i, int i2, String str2, String str3, String str4, boolean z, int i3) {
        this.f7029a = 1;
        this.f7030b = (String) C1896c.m10790a((Object) str);
        this.f7031c = i;
        this.f7032d = i2;
        this.f7036h = str2;
        this.f7033e = str3;
        this.f7034f = str4;
        this.f7035g = !z;
        this.f7037i = z;
        this.f7038j = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayLoggerContext)) {
            return false;
        }
        PlayLoggerContext playLoggerContext = (PlayLoggerContext) obj;
        return this.f7029a == playLoggerContext.f7029a && this.f7030b.equals(playLoggerContext.f7030b) && this.f7031c == playLoggerContext.f7031c && this.f7032d == playLoggerContext.f7032d && C1895b.m10789a(this.f7036h, playLoggerContext.f7036h) && C1895b.m10789a(this.f7033e, playLoggerContext.f7033e) && C1895b.m10789a(this.f7034f, playLoggerContext.f7034f) && this.f7035g == playLoggerContext.f7035g && this.f7037i == playLoggerContext.f7037i && this.f7038j == playLoggerContext.f7038j;
    }

    public int hashCode() {
        return C1895b.m10787a(Integer.valueOf(this.f7029a), this.f7030b, Integer.valueOf(this.f7031c), Integer.valueOf(this.f7032d), this.f7036h, this.f7033e, this.f7034f, Boolean.valueOf(this.f7035g), Boolean.valueOf(this.f7037i), Integer.valueOf(this.f7038j));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PlayLoggerContext[");
        stringBuilder.append("versionCode=").append(this.f7029a).append(',');
        stringBuilder.append("package=").append(this.f7030b).append(',');
        stringBuilder.append("packageVersionCode=").append(this.f7031c).append(',');
        stringBuilder.append("logSource=").append(this.f7032d).append(',');
        stringBuilder.append("logSourceName=").append(this.f7036h).append(',');
        stringBuilder.append("uploadAccount=").append(this.f7033e).append(',');
        stringBuilder.append("loggingId=").append(this.f7034f).append(',');
        stringBuilder.append("logAndroidId=").append(this.f7035g).append(',');
        stringBuilder.append("isAnonymous=").append(this.f7037i).append(',');
        stringBuilder.append("qosTier=").append(this.f7038j);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2099a.m12019a(this, parcel, i);
    }
}
