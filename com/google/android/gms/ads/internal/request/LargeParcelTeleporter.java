package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.C1977j;
import com.google.android.gms.p031b.id;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

@id
public final class LargeParcelTeleporter extends AbstractSafeParcelable {
    public static final Creator<LargeParcelTeleporter> CREATOR = new C1281m();
    final int f3815a;
    ParcelFileDescriptor f3816b;
    private Parcelable f3817c;
    private boolean f3818d;

    LargeParcelTeleporter(int i, ParcelFileDescriptor parcelFileDescriptor) {
        this.f3815a = i;
        this.f3816b = parcelFileDescriptor;
        this.f3817c = null;
        this.f3818d = true;
    }

    public LargeParcelTeleporter(SafeParcelable safeParcelable) {
        this.f3815a = 1;
        this.f3816b = null;
        this.f3817c = safeParcelable;
        this.f3818d = false;
    }

    protected <T> ParcelFileDescriptor m6892a(final byte[] bArr) {
        Throwable e;
        ParcelFileDescriptor parcelFileDescriptor = null;
        final Closeable autoCloseOutputStream;
        try {
            ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
            autoCloseOutputStream = new AutoCloseOutputStream(createPipe[1]);
            try {
                new Thread(new Runnable(this) {
                    final /* synthetic */ LargeParcelTeleporter f3814c;

                    public void run() {
                        Closeable dataOutputStream;
                        Throwable e;
                        try {
                            dataOutputStream = new DataOutputStream(autoCloseOutputStream);
                            try {
                                dataOutputStream.writeInt(bArr.length);
                                dataOutputStream.write(bArr);
                                C1977j.m11102a(dataOutputStream);
                            } catch (IOException e2) {
                                e = e2;
                                try {
                                    C1324b.m7231b("Error transporting the ad response", e);
                                    C1319u.m7186h().m9117a(e, true);
                                    if (dataOutputStream != null) {
                                        C1977j.m11102a(autoCloseOutputStream);
                                    } else {
                                        C1977j.m11102a(dataOutputStream);
                                    }
                                } catch (Throwable th) {
                                    e = th;
                                    if (dataOutputStream != null) {
                                        C1977j.m11102a(dataOutputStream);
                                    } else {
                                        C1977j.m11102a(autoCloseOutputStream);
                                    }
                                    throw e;
                                }
                            }
                        } catch (IOException e3) {
                            e = e3;
                            dataOutputStream = null;
                            C1324b.m7231b("Error transporting the ad response", e);
                            C1319u.m7186h().m9117a(e, true);
                            if (dataOutputStream != null) {
                                C1977j.m11102a(dataOutputStream);
                            } else {
                                C1977j.m11102a(autoCloseOutputStream);
                            }
                        } catch (Throwable th2) {
                            e = th2;
                            dataOutputStream = null;
                            if (dataOutputStream != null) {
                                C1977j.m11102a(autoCloseOutputStream);
                            } else {
                                C1977j.m11102a(dataOutputStream);
                            }
                            throw e;
                        }
                    }
                }).start();
                return createPipe[0];
            } catch (IOException e2) {
                e = e2;
            }
        } catch (IOException e3) {
            e = e3;
            autoCloseOutputStream = parcelFileDescriptor;
            C1324b.m7231b("Error transporting the ad response", e);
            C1319u.m7186h().m9117a(e, true);
            C1977j.m11102a(autoCloseOutputStream);
            return parcelFileDescriptor;
        }
    }

    public <T extends SafeParcelable> T m6893a(Creator<T> creator) {
        if (this.f3818d) {
            if (this.f3816b == null) {
                C1324b.m7230b("File descriptor is empty, returning null.");
                return null;
            }
            Closeable dataInputStream = new DataInputStream(new AutoCloseInputStream(this.f3816b));
            try {
                byte[] bArr = new byte[dataInputStream.readInt()];
                dataInputStream.readFully(bArr, 0, bArr.length);
                C1977j.m11102a(dataInputStream);
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.unmarshall(bArr, 0, bArr.length);
                    obtain.setDataPosition(0);
                    this.f3817c = (SafeParcelable) creator.createFromParcel(obtain);
                    this.f3818d = false;
                } finally {
                    obtain.recycle();
                }
            } catch (Throwable e) {
                throw new IllegalStateException("Could not read from parcel file descriptor", e);
            } catch (Throwable th) {
                C1977j.m11102a(dataInputStream);
            }
        }
        return (SafeParcelable) this.f3817c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.f3816b == null) {
            Parcel obtain = Parcel.obtain();
            try {
                this.f3817c.writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                this.f3816b = m6892a(marshall);
            } finally {
                obtain.recycle();
            }
        }
        C1281m.m7009a(this, parcel, i);
    }
}
