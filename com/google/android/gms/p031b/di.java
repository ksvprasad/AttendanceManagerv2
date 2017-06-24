package com.google.android.gms.p031b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p033a.C0998a;
import com.google.android.gms.p033a.C0998a.C1000a;

public interface di extends IInterface {

    public static abstract class C1420a extends Binder implements di {

        private static class C1419a implements di {
            private IBinder f4459a;

            C1419a(IBinder iBinder) {
                this.f4459a = iBinder;
            }

            public IBinder mo1284a(C0998a c0998a, C0998a c0998a2, C0998a c0998a3, int i) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
                    obtain.writeStrongBinder(c0998a != null ? c0998a.asBinder() : null);
                    obtain.writeStrongBinder(c0998a2 != null ? c0998a2.asBinder() : null);
                    if (c0998a3 != null) {
                        iBinder = c0998a3.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.f4459a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    iBinder = obtain2.readStrongBinder();
                    return iBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f4459a;
            }
        }

        public static di m7911a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof di)) ? new C1419a(iBinder) : (di) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
                    IBinder a = mo1284a(C1000a.m5712a(parcel.readStrongBinder()), C1000a.m5712a(parcel.readStrongBinder()), C1000a.m5712a(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    IBinder mo1284a(C0998a c0998a, C0998a c0998a2, C0998a c0998a3, int i);
}
