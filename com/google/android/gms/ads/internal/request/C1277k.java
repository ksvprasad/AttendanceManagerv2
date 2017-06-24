package com.google.android.gms.ads.internal.request;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.ads.internal.request.C1271l.C1272a;

public interface C1277k extends IInterface {

    public static abstract class C1279a extends Binder implements C1277k {

        private static class C1278a implements C1277k {
            private IBinder f3876a;

            C1278a(IBinder iBinder) {
                this.f3876a = iBinder;
            }

            public AdResponseParcel mo1185a(AdRequestInfoParcel adRequestInfoParcel) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (adRequestInfoParcel != null) {
                        obtain.writeInt(1);
                        adRequestInfoParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f3876a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    AdResponseParcel adResponseParcel = obtain2.readInt() != 0 ? (AdResponseParcel) AdResponseParcel.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return adResponseParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void mo1186a(AdRequestInfoParcel adRequestInfoParcel, C1271l c1271l) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (adRequestInfoParcel != null) {
                        obtain.writeInt(1);
                        adRequestInfoParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c1271l != null ? c1271l.asBinder() : null);
                    this.f3876a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f3876a;
            }
        }

        public C1279a() {
            attachInterface(this, "com.google.android.gms.ads.internal.request.IAdRequestService");
        }

        public static C1277k m7007a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1277k)) ? new C1278a(iBinder) : (C1277k) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            AdRequestInfoParcel adRequestInfoParcel = null;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (parcel.readInt() != 0) {
                        adRequestInfoParcel = (AdRequestInfoParcel) AdRequestInfoParcel.CREATOR.createFromParcel(parcel);
                    }
                    AdResponseParcel a = mo1185a(adRequestInfoParcel);
                    parcel2.writeNoException();
                    if (a != null) {
                        parcel2.writeInt(1);
                        a.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (parcel.readInt() != 0) {
                        adRequestInfoParcel = (AdRequestInfoParcel) AdRequestInfoParcel.CREATOR.createFromParcel(parcel);
                    }
                    mo1186a(adRequestInfoParcel, C1272a.m6992a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.request.IAdRequestService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    AdResponseParcel mo1185a(AdRequestInfoParcel adRequestInfoParcel);

    void mo1186a(AdRequestInfoParcel adRequestInfoParcel, C1271l c1271l);
}
