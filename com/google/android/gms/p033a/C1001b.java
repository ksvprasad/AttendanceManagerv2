package com.google.android.gms.p033a;

import android.os.IBinder;
import com.google.android.gms.p033a.C0998a.C1000a;
import java.lang.reflect.Field;

public final class C1001b<T> extends C1000a {
    private final T f2978a;

    private C1001b(T t) {
        this.f2978a = t;
    }

    public static <T> C0998a m5713a(T t) {
        return new C1001b(t);
    }

    public static <T> T m5714a(C0998a c0998a) {
        if (c0998a instanceof C1001b) {
            return ((C1001b) c0998a).f2978a;
        }
        IBinder asBinder = c0998a.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        if (declaredFields.length == 1) {
            Field field = declaredFields[0];
            if (field.isAccessible()) {
                throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
            }
            field.setAccessible(true);
            try {
                return field.get(asBinder);
            } catch (Throwable e) {
                throw new IllegalArgumentException("Binder object is null.", e);
            } catch (Throwable e2) {
                throw new IllegalArgumentException("remoteBinder is the wrong class.", e2);
            } catch (Throwable e22) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.", e22);
            }
        }
        throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
    }
}
