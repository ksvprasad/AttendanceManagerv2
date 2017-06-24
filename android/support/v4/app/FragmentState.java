package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

final class FragmentState implements Parcelable {
    public static final Creator<FragmentState> CREATOR = new C01921();
    final String f779a;
    final int f780b;
    final boolean f781c;
    final int f782d;
    final int f783e;
    final String f784f;
    final boolean f785g;
    final boolean f786h;
    final Bundle f787i;
    Bundle f788j;
    Fragment f789k;

    static class C01921 implements Creator<FragmentState> {
        C01921() {
        }

        public FragmentState m1221a(Parcel parcel) {
            return new FragmentState(parcel);
        }

        public FragmentState[] m1222a(int i) {
            return new FragmentState[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m1221a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m1222a(i);
        }
    }

    public FragmentState(Parcel parcel) {
        boolean z = true;
        this.f779a = parcel.readString();
        this.f780b = parcel.readInt();
        this.f781c = parcel.readInt() != 0;
        this.f782d = parcel.readInt();
        this.f783e = parcel.readInt();
        this.f784f = parcel.readString();
        this.f785g = parcel.readInt() != 0;
        if (parcel.readInt() == 0) {
            z = false;
        }
        this.f786h = z;
        this.f787i = parcel.readBundle();
        this.f788j = parcel.readBundle();
    }

    public FragmentState(Fragment fragment) {
        this.f779a = fragment.getClass().getName();
        this.f780b = fragment.f765p;
        this.f781c = fragment.f773x;
        this.f782d = fragment.f739F;
        this.f783e = fragment.f740G;
        this.f784f = fragment.f741H;
        this.f785g = fragment.f744K;
        this.f786h = fragment.f743J;
        this.f787i = fragment.f767r;
    }

    public Fragment m1223a(C0257q c0257q, Fragment fragment) {
        if (this.f789k != null) {
            return this.f789k;
        }
        Context g = c0257q.m1430g();
        if (this.f787i != null) {
            this.f787i.setClassLoader(g.getClassLoader());
        }
        this.f789k = Fragment.m1137a(g, this.f779a, this.f787i);
        if (this.f788j != null) {
            this.f788j.setClassLoader(g.getClassLoader());
            this.f789k.f763n = this.f788j;
        }
        this.f789k.m1157a(this.f780b, fragment);
        this.f789k.f773x = this.f781c;
        this.f789k.f775z = true;
        this.f789k.f739F = this.f782d;
        this.f789k.f740G = this.f783e;
        this.f789k.f741H = this.f784f;
        this.f789k.f744K = this.f785g;
        this.f789k.f743J = this.f786h;
        this.f789k.f735B = c0257q.f929d;
        if (C0272s.f969a) {
            Log.v("FragmentManager", "Instantiated fragment " + this.f789k);
        }
        return this.f789k;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.f779a);
        parcel.writeInt(this.f780b);
        parcel.writeInt(this.f781c ? 1 : 0);
        parcel.writeInt(this.f782d);
        parcel.writeInt(this.f783e);
        parcel.writeString(this.f784f);
        parcel.writeInt(this.f785g ? 1 : 0);
        if (!this.f786h) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeBundle(this.f787i);
        parcel.writeBundle(this.f788j);
    }
}
