package android.support.v4.p006e;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

class C0342e<T> implements ClassLoaderCreator<T> {
    private final C0056d<T> f1079a;

    public C0342e(C0056d<T> c0056d) {
        this.f1079a = c0056d;
    }

    public T createFromParcel(Parcel parcel) {
        return this.f1079a.mo40b(parcel, null);
    }

    public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.f1079a.mo40b(parcel, classLoader);
    }

    public T[] newArray(int i) {
        return this.f1079a.mo41b(i);
    }
}
