package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.C0251i.C0248a;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

final class BackStackState implements Parcelable {
    public static final Creator<BackStackState> CREATOR = new C01861();
    final int[] f719a;
    final int f720b;
    final int f721c;
    final String f722d;
    final int f723e;
    final int f724f;
    final CharSequence f725g;
    final int f726h;
    final CharSequence f727i;
    final ArrayList<String> f728j;
    final ArrayList<String> f729k;

    static class C01861 implements Creator<BackStackState> {
        C01861() {
        }

        public BackStackState m1127a(Parcel parcel) {
            return new BackStackState(parcel);
        }

        public BackStackState[] m1128a(int i) {
            return new BackStackState[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m1127a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m1128a(i);
        }
    }

    public BackStackState(Parcel parcel) {
        this.f719a = parcel.createIntArray();
        this.f720b = parcel.readInt();
        this.f721c = parcel.readInt();
        this.f722d = parcel.readString();
        this.f723e = parcel.readInt();
        this.f724f = parcel.readInt();
        this.f725g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f726h = parcel.readInt();
        this.f727i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f728j = parcel.createStringArrayList();
        this.f729k = parcel.createStringArrayList();
    }

    public BackStackState(C0251i c0251i) {
        int i = 0;
        for (C0248a c0248a = c0251i.f896c; c0248a != null; c0248a = c0248a.f880a) {
            if (c0248a.f888i != null) {
                i += c0248a.f888i.size();
            }
        }
        this.f719a = new int[(i + (c0251i.f898e * 7))];
        if (c0251i.f905l) {
            i = 0;
            for (C0248a c0248a2 = c0251i.f896c; c0248a2 != null; c0248a2 = c0248a2.f880a) {
                int i2 = i + 1;
                this.f719a[i] = c0248a2.f882c;
                int i3 = i2 + 1;
                this.f719a[i2] = c0248a2.f883d != null ? c0248a2.f883d.f765p : -1;
                int i4 = i3 + 1;
                this.f719a[i3] = c0248a2.f884e;
                i2 = i4 + 1;
                this.f719a[i4] = c0248a2.f885f;
                i4 = i2 + 1;
                this.f719a[i2] = c0248a2.f886g;
                i2 = i4 + 1;
                this.f719a[i4] = c0248a2.f887h;
                if (c0248a2.f888i != null) {
                    int size = c0248a2.f888i.size();
                    i4 = i2 + 1;
                    this.f719a[i2] = size;
                    i2 = 0;
                    while (i2 < size) {
                        i3 = i4 + 1;
                        this.f719a[i4] = ((Fragment) c0248a2.f888i.get(i2)).f765p;
                        i2++;
                        i4 = i3;
                    }
                    i = i4;
                } else {
                    i = i2 + 1;
                    this.f719a[i2] = 0;
                }
            }
            this.f720b = c0251i.f903j;
            this.f721c = c0251i.f904k;
            this.f722d = c0251i.f907n;
            this.f723e = c0251i.f909p;
            this.f724f = c0251i.f910q;
            this.f725g = c0251i.f911r;
            this.f726h = c0251i.f912s;
            this.f727i = c0251i.f913t;
            this.f728j = c0251i.f914u;
            this.f729k = c0251i.f915v;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public C0251i m1129a(C0272s c0272s) {
        C0251i c0251i = new C0251i(c0272s);
        int i = 0;
        int i2 = 0;
        while (i2 < this.f719a.length) {
            C0248a c0248a = new C0248a();
            int i3 = i2 + 1;
            c0248a.f882c = this.f719a[i2];
            if (C0272s.f969a) {
                Log.v("FragmentManager", "Instantiate " + c0251i + " op #" + i + " base fragment #" + this.f719a[i3]);
            }
            int i4 = i3 + 1;
            i2 = this.f719a[i3];
            if (i2 >= 0) {
                c0248a.f883d = (Fragment) c0272s.f975f.get(i2);
            } else {
                c0248a.f883d = null;
            }
            i3 = i4 + 1;
            c0248a.f884e = this.f719a[i4];
            i4 = i3 + 1;
            c0248a.f885f = this.f719a[i3];
            i3 = i4 + 1;
            c0248a.f886g = this.f719a[i4];
            int i5 = i3 + 1;
            c0248a.f887h = this.f719a[i3];
            i4 = i5 + 1;
            int i6 = this.f719a[i5];
            if (i6 > 0) {
                c0248a.f888i = new ArrayList(i6);
                i3 = 0;
                while (i3 < i6) {
                    if (C0272s.f969a) {
                        Log.v("FragmentManager", "Instantiate " + c0251i + " set remove fragment #" + this.f719a[i4]);
                    }
                    i5 = i4 + 1;
                    c0248a.f888i.add((Fragment) c0272s.f975f.get(this.f719a[i4]));
                    i3++;
                    i4 = i5;
                }
            }
            c0251i.f899f = c0248a.f884e;
            c0251i.f900g = c0248a.f885f;
            c0251i.f901h = c0248a.f886g;
            c0251i.f902i = c0248a.f887h;
            c0251i.m1387a(c0248a);
            i++;
            i2 = i4;
        }
        c0251i.f903j = this.f720b;
        c0251i.f904k = this.f721c;
        c0251i.f907n = this.f722d;
        c0251i.f909p = this.f723e;
        c0251i.f905l = true;
        c0251i.f910q = this.f724f;
        c0251i.f911r = this.f725g;
        c0251i.f912s = this.f726h;
        c0251i.f913t = this.f727i;
        c0251i.f914u = this.f728j;
        c0251i.f915v = this.f729k;
        c0251i.m1386a(1);
        return c0251i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f719a);
        parcel.writeInt(this.f720b);
        parcel.writeInt(this.f721c);
        parcel.writeString(this.f722d);
        parcel.writeInt(this.f723e);
        parcel.writeInt(this.f724f);
        TextUtils.writeToParcel(this.f725g, parcel, 0);
        parcel.writeInt(this.f726h);
        TextUtils.writeToParcel(this.f727i, parcel, 0);
        parcel.writeStringList(this.f728j);
        parcel.writeStringList(this.f729k);
    }
}
