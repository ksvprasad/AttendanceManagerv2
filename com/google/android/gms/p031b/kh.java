package com.google.android.gms.p031b;

import android.graphics.Bitmap;
import com.google.android.gms.ads.internal.util.client.C1324b;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@id
public class kh {
    Map<Integer, Bitmap> f5621a = new ConcurrentHashMap();
    private AtomicInteger f5622b = new AtomicInteger(0);

    public int m9344a(Bitmap bitmap) {
        if (bitmap == null) {
            C1324b.m7227a("Bitmap is null. Skipping putting into the Memory Map.");
            return -1;
        }
        this.f5621a.put(Integer.valueOf(this.f5622b.get()), bitmap);
        return this.f5622b.getAndIncrement();
    }

    public Bitmap m9345a(Integer num) {
        return (Bitmap) this.f5621a.get(num);
    }

    public void m9346b(Integer num) {
        this.f5621a.remove(num);
    }
}
