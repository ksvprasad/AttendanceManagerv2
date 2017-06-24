package com.google.android.gms.common.util;

import android.support.v4.p015g.C0370a;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

public class C1968a<E> extends AbstractSet<E> {
    private final C0370a<E, E> f6600a;

    public C1968a() {
        this.f6600a = new C0370a();
    }

    public C1968a(int i) {
        this.f6600a = new C0370a(i);
    }

    public C1968a(Collection<E> collection) {
        this(collection.size());
        addAll(collection);
    }

    public boolean m11069a(C1968a<? extends E> c1968a) {
        int size = size();
        this.f6600a.m1898a(c1968a.f6600a);
        return size() > size;
    }

    public boolean add(E e) {
        if (this.f6600a.containsKey(e)) {
            return false;
        }
        this.f6600a.put(e, e);
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        return collection instanceof C1968a ? m11069a((C1968a) collection) : super.addAll(collection);
    }

    public void clear() {
        this.f6600a.clear();
    }

    public boolean contains(Object obj) {
        return this.f6600a.containsKey(obj);
    }

    public Iterator<E> iterator() {
        return this.f6600a.keySet().iterator();
    }

    public boolean remove(Object obj) {
        if (!this.f6600a.containsKey(obj)) {
            return false;
        }
        this.f6600a.remove(obj);
        return true;
    }

    public int size() {
        return this.f6600a.size();
    }
}
