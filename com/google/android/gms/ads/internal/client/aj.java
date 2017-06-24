package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.ads.internal.client.ae.C1065a;
import com.google.android.gms.ads.internal.client.ag.C1039a;
import com.google.android.gms.ads.internal.client.al.C1077a;
import com.google.android.gms.ads.internal.reward.client.C1295b;
import com.google.android.gms.ads.internal.reward.client.C1295b.C1297a;
import com.google.android.gms.p031b.dh;
import com.google.android.gms.p031b.dh.C1158a;
import com.google.android.gms.p031b.fx;
import com.google.android.gms.p031b.fx.C1534a;
import com.google.android.gms.p031b.gx;
import com.google.android.gms.p031b.gx.C1199a;
import com.google.android.gms.p031b.he;
import com.google.android.gms.p031b.he.C1230a;
import com.google.android.gms.p033a.C0998a;
import com.google.android.gms.p033a.C0998a.C1000a;

public interface aj extends IInterface {

    public static abstract class C1037a extends Binder implements aj {

        private static class C1073a implements aj {
            private IBinder f3141a;

            C1073a(IBinder iBinder) {
                this.f3141a = iBinder;
            }

            public IBinder asBinder() {
                return this.f3141a;
            }

            public ae createAdLoaderBuilder(C0998a c0998a, String str, fx fxVar, int i) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(c0998a != null ? c0998a.asBinder() : null);
                    obtain.writeString(str);
                    if (fxVar != null) {
                        iBinder = fxVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.f3141a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    ae a = C1065a.m6014a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public gx createAdOverlay(C0998a c0998a) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(c0998a != null ? c0998a.asBinder() : null);
                    this.f3141a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    gx a = C1199a.m6650a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ag createBannerAdManager(C0998a c0998a, AdSizeParcel adSizeParcel, String str, fx fxVar, int i) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(c0998a != null ? c0998a.asBinder() : null);
                    if (adSizeParcel != null) {
                        obtain.writeInt(1);
                        adSizeParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (fxVar != null) {
                        iBinder = fxVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.f3141a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    ag a = C1039a.m5857a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public he createInAppPurchaseManager(C0998a c0998a) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(c0998a != null ? c0998a.asBinder() : null);
                    this.f3141a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    he a = C1230a.m6821a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ag createInterstitialAdManager(C0998a c0998a, AdSizeParcel adSizeParcel, String str, fx fxVar, int i) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(c0998a != null ? c0998a.asBinder() : null);
                    if (adSizeParcel != null) {
                        obtain.writeInt(1);
                        adSizeParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (fxVar != null) {
                        iBinder = fxVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.f3141a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    ag a = C1039a.m5857a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public dh createNativeAdViewDelegate(C0998a c0998a, C0998a c0998a2) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(c0998a != null ? c0998a.asBinder() : null);
                    if (c0998a2 != null) {
                        iBinder = c0998a2.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f3141a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    dh a = C1158a.m6459a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C1295b createRewardedVideoAd(C0998a c0998a, fx fxVar, int i) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(c0998a != null ? c0998a.asBinder() : null);
                    if (fxVar != null) {
                        iBinder = fxVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.f3141a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    C1295b a = C1297a.m7062a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ag createSearchAdManager(C0998a c0998a, AdSizeParcel adSizeParcel, String str, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(c0998a != null ? c0998a.asBinder() : null);
                    if (adSizeParcel != null) {
                        obtain.writeInt(1);
                        adSizeParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f3141a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    ag a = C1039a.m5857a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public al getMobileAdsSettingsManager(C0998a c0998a) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(c0998a != null ? c0998a.asBinder() : null);
                    this.f3141a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    al a = C1077a.m6060a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public al getMobileAdsSettingsManagerWithClientJarVersion(C0998a c0998a, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IClientApi");
                    obtain.writeStrongBinder(c0998a != null ? c0998a.asBinder() : null);
                    obtain.writeInt(i);
                    this.f3141a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    al a = C1077a.m6060a(obtain2.readStrongBinder());
                    return a;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C1037a() {
            attachInterface(this, "com.google.android.gms.ads.internal.client.IClientApi");
        }

        public static aj asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof aj)) ? new C1073a(iBinder) : (aj) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            IBinder iBinder = null;
            ag createBannerAdManager;
            al mobileAdsSettingsManager;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    createBannerAdManager = createBannerAdManager(C1000a.m5712a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (AdSizeParcel) AdSizeParcel.CREATOR.createFromParcel(parcel) : null, parcel.readString(), C1534a.m8388a(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    if (createBannerAdManager != null) {
                        iBinder = createBannerAdManager.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    createBannerAdManager = createInterstitialAdManager(C1000a.m5712a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (AdSizeParcel) AdSizeParcel.CREATOR.createFromParcel(parcel) : null, parcel.readString(), C1534a.m8388a(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    if (createBannerAdManager != null) {
                        iBinder = createBannerAdManager.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    ae createAdLoaderBuilder = createAdLoaderBuilder(C1000a.m5712a(parcel.readStrongBinder()), parcel.readString(), C1534a.m8388a(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    if (createAdLoaderBuilder != null) {
                        iBinder = createAdLoaderBuilder.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    mobileAdsSettingsManager = getMobileAdsSettingsManager(C1000a.m5712a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (mobileAdsSettingsManager != null) {
                        iBinder = mobileAdsSettingsManager.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    dh createNativeAdViewDelegate = createNativeAdViewDelegate(C1000a.m5712a(parcel.readStrongBinder()), C1000a.m5712a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (createNativeAdViewDelegate != null) {
                        iBinder = createNativeAdViewDelegate.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    C1295b createRewardedVideoAd = createRewardedVideoAd(C1000a.m5712a(parcel.readStrongBinder()), C1534a.m8388a(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    if (createRewardedVideoAd != null) {
                        iBinder = createRewardedVideoAd.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    he createInAppPurchaseManager = createInAppPurchaseManager(C1000a.m5712a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (createInAppPurchaseManager != null) {
                        iBinder = createInAppPurchaseManager.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    gx createAdOverlay = createAdOverlay(C1000a.m5712a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (createAdOverlay != null) {
                        iBinder = createAdOverlay.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    mobileAdsSettingsManager = getMobileAdsSettingsManagerWithClientJarVersion(C1000a.m5712a(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    if (mobileAdsSettingsManager != null) {
                        iBinder = mobileAdsSettingsManager.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    createBannerAdManager = createSearchAdManager(C1000a.m5712a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (AdSizeParcel) AdSizeParcel.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    if (createBannerAdManager != null) {
                        iBinder = createBannerAdManager.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.client.IClientApi");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    ae createAdLoaderBuilder(C0998a c0998a, String str, fx fxVar, int i);

    gx createAdOverlay(C0998a c0998a);

    ag createBannerAdManager(C0998a c0998a, AdSizeParcel adSizeParcel, String str, fx fxVar, int i);

    he createInAppPurchaseManager(C0998a c0998a);

    ag createInterstitialAdManager(C0998a c0998a, AdSizeParcel adSizeParcel, String str, fx fxVar, int i);

    dh createNativeAdViewDelegate(C0998a c0998a, C0998a c0998a2);

    C1295b createRewardedVideoAd(C0998a c0998a, fx fxVar, int i);

    ag createSearchAdManager(C0998a c0998a, AdSizeParcel adSizeParcel, String str, int i);

    al getMobileAdsSettingsManager(C0998a c0998a);

    al getMobileAdsSettingsManagerWithClientJarVersion(C0998a c0998a, int i);
}
