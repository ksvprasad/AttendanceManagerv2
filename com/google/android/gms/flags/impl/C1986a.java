package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import com.google.android.gms.p031b.nu;
import java.util.concurrent.Callable;

public abstract class C1986a<T> {

    public static class C1987a extends C1986a<Boolean> {

        class C19851 implements Callable<Boolean> {
            final /* synthetic */ SharedPreferences f6619a;
            final /* synthetic */ String f6620b;
            final /* synthetic */ Boolean f6621c;

            C19851(SharedPreferences sharedPreferences, String str, Boolean bool) {
                this.f6619a = sharedPreferences;
                this.f6620b = str;
                this.f6621c = bool;
            }

            public Boolean m11139a() {
                return Boolean.valueOf(this.f6619a.getBoolean(this.f6620b, this.f6621c.booleanValue()));
            }

            public /* synthetic */ Object call() {
                return m11139a();
            }
        }

        public static Boolean m11140a(SharedPreferences sharedPreferences, String str, Boolean bool) {
            return (Boolean) nu.m10208a(new C19851(sharedPreferences, str, bool));
        }
    }

    public static class C1989b extends C1986a<Integer> {

        class C19881 implements Callable<Integer> {
            final /* synthetic */ SharedPreferences f6622a;
            final /* synthetic */ String f6623b;
            final /* synthetic */ Integer f6624c;

            C19881(SharedPreferences sharedPreferences, String str, Integer num) {
                this.f6622a = sharedPreferences;
                this.f6623b = str;
                this.f6624c = num;
            }

            public Integer m11141a() {
                return Integer.valueOf(this.f6622a.getInt(this.f6623b, this.f6624c.intValue()));
            }

            public /* synthetic */ Object call() {
                return m11141a();
            }
        }

        public static Integer m11142a(SharedPreferences sharedPreferences, String str, Integer num) {
            return (Integer) nu.m10208a(new C19881(sharedPreferences, str, num));
        }
    }

    public static class C1991c extends C1986a<Long> {

        class C19901 implements Callable<Long> {
            final /* synthetic */ SharedPreferences f6625a;
            final /* synthetic */ String f6626b;
            final /* synthetic */ Long f6627c;

            C19901(SharedPreferences sharedPreferences, String str, Long l) {
                this.f6625a = sharedPreferences;
                this.f6626b = str;
                this.f6627c = l;
            }

            public Long m11143a() {
                return Long.valueOf(this.f6625a.getLong(this.f6626b, this.f6627c.longValue()));
            }

            public /* synthetic */ Object call() {
                return m11143a();
            }
        }

        public static Long m11144a(SharedPreferences sharedPreferences, String str, Long l) {
            return (Long) nu.m10208a(new C19901(sharedPreferences, str, l));
        }
    }

    public static class C1993d extends C1986a<String> {

        class C19921 implements Callable<String> {
            final /* synthetic */ SharedPreferences f6628a;
            final /* synthetic */ String f6629b;
            final /* synthetic */ String f6630c;

            C19921(SharedPreferences sharedPreferences, String str, String str2) {
                this.f6628a = sharedPreferences;
                this.f6629b = str;
                this.f6630c = str2;
            }

            public String m11145a() {
                return this.f6628a.getString(this.f6629b, this.f6630c);
            }

            public /* synthetic */ Object call() {
                return m11145a();
            }
        }

        public static String m11146a(SharedPreferences sharedPreferences, String str, String str2) {
            return (String) nu.m10208a(new C19921(sharedPreferences, str, str2));
        }
    }
}
