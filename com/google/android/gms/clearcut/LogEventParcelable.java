package com.google.android.gms.clearcut;

import android.os.Parcel;
import com.google.android.gms.clearcut.C1854b.C1852c;
import com.google.android.gms.common.internal.C1895b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.p031b.ad.C1362d;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.Arrays;

public class LogEventParcelable extends AbstractSafeParcelable {
    public static final C1855d CREATOR = new C1855d();
    public final int f6278a;
    public PlayLoggerContext f6279b;
    public byte[] f6280c;
    public int[] f6281d;
    public String[] f6282e;
    public int[] f6283f;
    public byte[][] f6284g;
    public boolean f6285h;
    public final C1362d f6286i;
    public final C1852c f6287j;
    public final C1852c f6288k;

    LogEventParcelable(int i, PlayLoggerContext playLoggerContext, byte[] bArr, int[] iArr, String[] strArr, int[] iArr2, byte[][] bArr2, boolean z) {
        this.f6278a = i;
        this.f6279b = playLoggerContext;
        this.f6280c = bArr;
        this.f6281d = iArr;
        this.f6282e = strArr;
        this.f6286i = null;
        this.f6287j = null;
        this.f6288k = null;
        this.f6283f = iArr2;
        this.f6284g = bArr2;
        this.f6285h = z;
    }

    public LogEventParcelable(PlayLoggerContext playLoggerContext, C1362d c1362d, C1852c c1852c, C1852c c1852c2, int[] iArr, String[] strArr, int[] iArr2, byte[][] bArr, boolean z) {
        this.f6278a = 1;
        this.f6279b = playLoggerContext;
        this.f6286i = c1362d;
        this.f6287j = c1852c;
        this.f6288k = c1852c2;
        this.f6281d = iArr;
        this.f6282e = strArr;
        this.f6283f = iArr2;
        this.f6284g = bArr;
        this.f6285h = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogEventParcelable)) {
            return false;
        }
        LogEventParcelable logEventParcelable = (LogEventParcelable) obj;
        return this.f6278a == logEventParcelable.f6278a && C1895b.m10789a(this.f6279b, logEventParcelable.f6279b) && Arrays.equals(this.f6280c, logEventParcelable.f6280c) && Arrays.equals(this.f6281d, logEventParcelable.f6281d) && Arrays.equals(this.f6282e, logEventParcelable.f6282e) && C1895b.m10789a(this.f6286i, logEventParcelable.f6286i) && C1895b.m10789a(this.f6287j, logEventParcelable.f6287j) && C1895b.m10789a(this.f6288k, logEventParcelable.f6288k) && Arrays.equals(this.f6283f, logEventParcelable.f6283f) && Arrays.deepEquals(this.f6284g, logEventParcelable.f6284g) && this.f6285h == logEventParcelable.f6285h;
    }

    public int hashCode() {
        return C1895b.m10787a(Integer.valueOf(this.f6278a), this.f6279b, this.f6280c, this.f6281d, this.f6282e, this.f6286i, this.f6287j, this.f6288k, this.f6283f, this.f6284g, Boolean.valueOf(this.f6285h));
    }

    public String toString() {
        return "LogEventParcelable[" + this.f6278a + ", " + this.f6279b + ", " + "LogEventBytes: " + (this.f6280c == null ? null : new String(this.f6280c)) + ", " + "TestCodes: " + Arrays.toString(this.f6281d) + ", " + "MendelPackages: " + Arrays.toString(this.f6282e) + ", " + "LogEvent: " + this.f6286i + ", " + "ExtensionProducer: " + this.f6287j + ", " + "VeProducer: " + this.f6288k + ", " + "ExperimentIDs: " + Arrays.toString(this.f6283f) + ", " + "ExperimentTokens: " + Arrays.toString(this.f6284g) + ", " + "AddPhenotypeExperimentTokens: " + this.f6285h + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1855d.m10542a(this, parcel, i);
    }
}
