package com.google.ads.mediation;

import com.google.android.gms.ads.internal.util.client.C1324b;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@Deprecated
public abstract class C0988h {

    public static final class C0992a extends Exception {
        public C0992a(String str) {
            super(str);
        }
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface C0993b {
        String m5710a();

        boolean m5711b() default true;
    }

    protected void m5706a() {
    }

    public void m5707a(Map<String, String> map) {
        Map hashMap = new HashMap();
        for (Field field : getClass().getFields()) {
            C0993b c0993b = (C0993b) field.getAnnotation(C0993b.class);
            if (c0993b != null) {
                hashMap.put(c0993b.m5710a(), field);
            }
        }
        if (hashMap.isEmpty()) {
            C1324b.m7234d("No server options fields detected. To suppress this message either add a field with the @Parameter annotation, or override the load() method.");
        }
        for (Entry entry : map.entrySet()) {
            String str;
            Field field2 = (Field) hashMap.remove(entry.getKey());
            if (field2 != null) {
                try {
                    field2.set(this, entry.getValue());
                } catch (IllegalAccessException e) {
                    str = (String) entry.getKey();
                    C1324b.m7234d(new StringBuilder(String.valueOf(str).length() + 49).append("Server option \"").append(str).append("\" could not be set: Illegal Access").toString());
                } catch (IllegalArgumentException e2) {
                    str = (String) entry.getKey();
                    C1324b.m7234d(new StringBuilder(String.valueOf(str).length() + 43).append("Server option \"").append(str).append("\" could not be set: Bad Type").toString());
                }
            } else {
                str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                C1324b.m7227a(new StringBuilder((String.valueOf(str).length() + 31) + String.valueOf(str2).length()).append("Unexpected server option: ").append(str).append(" = \"").append(str2).append("\"").toString());
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Field field22 : hashMap.values()) {
            if (((C0993b) field22.getAnnotation(C0993b.class)).m5711b()) {
                String str3 = "Required server option missing: ";
                str2 = String.valueOf(((C0993b) field22.getAnnotation(C0993b.class)).m5710a());
                C1324b.m7234d(str2.length() != 0 ? str3.concat(str2) : new String(str3));
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(((C0993b) field22.getAnnotation(C0993b.class)).m5710a());
            }
        }
        if (stringBuilder.length() > 0) {
            String str4 = "Required server option(s) missing: ";
            str = String.valueOf(stringBuilder.toString());
            throw new C0992a(str.length() != 0 ? str4.concat(str) : new String(str4));
        }
        m5706a();
    }
}
