package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.p031b.fx;
import com.google.android.gms.p031b.fx.C1534a;
import com.google.android.gms.p033a.C0998a;
import com.google.android.gms.p033a.C0998a.C1000a;

public interface af extends IInterface {

    public static abstract class C1067a extends Binder implements af {

        private static class C1066a implements af {
            private IBinder f3137a;

            C1066a(IBinder iBinder) {
                this.f3137a = iBinder;
            }

            public IBinder mo1021a(C0998a c0998a, String str, fx fxVar, int i) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
                    obtain.writeStrongBinder(c0998a != null ? c0998a.asBinder() : null);
                    obtain.writeString(str);
                    if (fxVar != null) {
                        iBinder = fxVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.f3137a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    iBinder = obtain2.readStrongBinder();
                    return iBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f3137a;
            }
        }

        public static af m6017a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof af)) ? new C1066a(iBinder) : (af) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
                    IBinder a = mo1021a(C1000a.m5712a(parcel.readStrongBinder()), parcel.readString(), C1534a.m8388a(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    IBinder mo1021a(C0998a c0998a, String str, fx fxVar, int i);
}
