package android.support.v4.p006e;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class C0341c {

    static class C0340a<T> implements Creator<T> {
        final C0056d<T> f1078a;

        public C0340a(C0056d<T> c0056d) {
            this.f1078a = c0056d;
        }

        public T createFromParcel(Parcel parcel) {
            return this.f1078a.mo40b(parcel, null);
        }

        public T[] newArray(int i) {
            return this.f1078a.mo41b(i);
        }
    }

    public static <T> Creator<T> m1829a(C0056d<T> c0056d) {
        return VERSION.SDK_INT >= 13 ? C0343f.m1830a(c0056d) : new C0340a(c0056d);
    }
}
