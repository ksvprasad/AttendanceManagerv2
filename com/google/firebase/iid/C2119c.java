package com.google.firebase.iid;

public class C2119c {
    private final FirebaseInstanceId f7102a;

    private C2119c(FirebaseInstanceId firebaseInstanceId) {
        this.f7102a = firebaseInstanceId;
    }

    public static C2119c m12154a() {
        return new C2119c(FirebaseInstanceId.m12106a());
    }

    public String m12155b() {
        return this.f7102a.m12118c();
    }
}
