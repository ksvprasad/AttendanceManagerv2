package com.google.android.gms.gass.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface C2001e extends IInterface {

    public static abstract class C2003a extends Binder implements C2001e {

        private static class C2002a implements C2001e {
            private IBinder f6644a;

            C2002a(IBinder iBinder) {
                this.f6644a = iBinder;
            }

            public GassResponseParcel mo1726a(GassRequestParcel gassRequestParcel) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.gass.internal.IGassService");
                    if (gassRequestParcel != null) {
                        obtain.writeInt(1);
                        gassRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f6644a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    GassResponseParcel gassResponseParcel = obtain2.readInt() != 0 ? (GassResponseParcel) GassResponseParcel.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return gassResponseParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f6644a;
            }
        }

        public static C2001e m11176a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.gass.internal.IGassService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C2001e)) ? new C2002a(iBinder) : (C2001e) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.gass.internal.IGassService");
                    GassResponseParcel a = mo1726a(parcel.readInt() != 0 ? (GassRequestParcel) GassRequestParcel.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (a != null) {
                        parcel2.writeInt(1);
                        a.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.gass.internal.IGassService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    GassResponseParcel mo1726a(GassRequestParcel gassRequestParcel);
}
