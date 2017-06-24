package com.google.android.gms.p031b;

import android.text.TextUtils;
import java.util.Map;

@id
public abstract class cv {
    @id
    public static final cv f4427a = new C14081();
    @id
    public static final cv f4428b = new C14092();
    @id
    public static final cv f4429c = new C14103();

    class C14081 extends cv {
        C14081() {
        }

        public String mo1274a(String str, String str2) {
            return str2;
        }
    }

    class C14092 extends cv {
        C14092() {
        }

        public String mo1274a(String str, String str2) {
            return str != null ? str : str2;
        }
    }

    class C14103 extends cv {
        C14103() {
        }

        private String m7853a(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            int i = 0;
            int length = str.length();
            while (i < str.length() && str.charAt(i) == ',') {
                i++;
            }
            while (length > 0 && str.charAt(length - 1) == ',') {
                length--;
            }
            return (i == 0 && length == str.length()) ? str : str.substring(i, length);
        }

        public String mo1274a(String str, String str2) {
            String a = m7853a(str);
            String a2 = m7853a(str2);
            return TextUtils.isEmpty(a) ? a2 : TextUtils.isEmpty(a2) ? a : new StringBuilder((String.valueOf(a).length() + 1) + String.valueOf(a2).length()).append(a).append(",").append(a2).toString();
        }
    }

    public abstract String mo1274a(String str, String str2);

    public final void m7850a(Map<String, String> map, String str, String str2) {
        map.put(str, mo1274a((String) map.get(str), str2));
    }
}
