package com.google.android.gms.iid;

import android.annotation.TargetApi;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.iid.C2005a.C2006a;

public class MessengerCompat implements Parcelable {
    public static final Creator<MessengerCompat> CREATOR = new C20041();
    Messenger f6647a;
    C2005a f6648b;

    class C20041 implements Creator<MessengerCompat> {
        C20041() {
        }

        public MessengerCompat m11177a(Parcel parcel) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            return readStrongBinder != null ? new MessengerCompat(readStrongBinder) : null;
        }

        public MessengerCompat[] m11178a(int i) {
            return new MessengerCompat[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m11177a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m11178a(i);
        }
    }

    private final class C2007a extends C2006a {
        Handler f6645a;
        final /* synthetic */ MessengerCompat f6646b;

        C2007a(MessengerCompat messengerCompat, Handler handler) {
            this.f6646b = messengerCompat;
            this.f6645a = handler;
        }

        public void mo1727a(Message message) {
            message.arg2 = Binder.getCallingUid();
            this.f6645a.dispatchMessage(message);
        }
    }

    public MessengerCompat(Handler handler) {
        if (VERSION.SDK_INT >= 21) {
            this.f6647a = new Messenger(handler);
        } else {
            this.f6648b = new C2007a(this, handler);
        }
    }

    public MessengerCompat(IBinder iBinder) {
        if (VERSION.SDK_INT >= 21) {
            this.f6647a = new Messenger(iBinder);
        } else {
            this.f6648b = C2006a.m11180a(iBinder);
        }
    }

    public static int m11182a(Message message) {
        return VERSION.SDK_INT >= 21 ? m11183c(message) : message.arg2;
    }

    @TargetApi(21)
    private static int m11183c(Message message) {
        return message.sendingUid;
    }

    public IBinder m11184a() {
        return this.f6647a != null ? this.f6647a.getBinder() : this.f6648b.asBinder();
    }

    public void m11185b(Message message) {
        if (this.f6647a != null) {
            this.f6647a.send(message);
        } else {
            this.f6648b.mo1727a(message);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj != null) {
            try {
                z = m11184a().equals(((MessengerCompat) obj).m11184a());
            } catch (ClassCastException e) {
            }
        }
        return z;
    }

    public int hashCode() {
        return m11184a().hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.f6647a != null) {
            parcel.writeStrongBinder(this.f6647a.getBinder());
        } else {
            parcel.writeStrongBinder(this.f6648b.asBinder());
        }
    }
}
