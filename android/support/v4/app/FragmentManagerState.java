package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class FragmentManagerState implements Parcelable {
    public static final Creator<FragmentManagerState> CREATOR = new C01911();
    FragmentState[] f776a;
    int[] f777b;
    BackStackState[] f778c;

    static class C01911 implements Creator<FragmentManagerState> {
        C01911() {
        }

        public FragmentManagerState m1219a(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        public FragmentManagerState[] m1220a(int i) {
            return new FragmentManagerState[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m1219a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m1220a(i);
        }
    }

    public FragmentManagerState(Parcel parcel) {
        this.f776a = (FragmentState[]) parcel.createTypedArray(FragmentState.CREATOR);
        this.f777b = parcel.createIntArray();
        this.f778c = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f776a, i);
        parcel.writeIntArray(this.f777b);
        parcel.writeTypedArray(this.f778c, i);
    }
}
