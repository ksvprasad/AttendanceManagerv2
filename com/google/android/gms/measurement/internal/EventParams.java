package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Iterator;

public class EventParams extends AbstractSafeParcelable implements Iterable<String> {
    public static final C2093v CREATOR = new C2093v();
    public final int f6670a;
    private final Bundle f6671b;

    class C20151 implements Iterator<String> {
        Iterator<String> f6668a = this.f6669b.f6671b.keySet().iterator();
        final /* synthetic */ EventParams f6669b;

        C20151(EventParams eventParams) {
            this.f6669b = eventParams;
        }

        public String m11196a() {
            return (String) this.f6668a.next();
        }

        public boolean hasNext() {
            return this.f6668a.hasNext();
        }

        public /* synthetic */ Object next() {
            return m11196a();
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove not supported");
        }
    }

    EventParams(int i, Bundle bundle) {
        this.f6670a = i;
        this.f6671b = bundle;
    }

    EventParams(Bundle bundle) {
        C1896c.m10790a((Object) bundle);
        this.f6671b = bundle;
        this.f6670a = 1;
    }

    public int m11198a() {
        return this.f6671b.size();
    }

    Object m11199a(String str) {
        return this.f6671b.get(str);
    }

    public Bundle m11200b() {
        return new Bundle(this.f6671b);
    }

    public Iterator<String> iterator() {
        return new C20151(this);
    }

    public String toString() {
        return this.f6671b.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2093v.m11966a(this, parcel, i);
    }
}
