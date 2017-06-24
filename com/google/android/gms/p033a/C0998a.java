package com.google.android.gms.p033a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface C0998a extends IInterface {

    public static abstract class C1000a extends Binder implements C0998a {

        private static class C0999a implements C0998a {
            private IBinder f2977a;

            C0999a(IBinder iBinder) {
                this.f2977a = iBinder;
            }

            public IBinder asBinder() {
                return this.f2977a;
            }
        }

        public C1000a() {
            attachInterface(this, "com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static C0998a m5712a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0998a)) ? new C0999a(iBinder) : (C0998a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.dynamic.IObjectWrapper");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }
}
