package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.common.util.C1970c;
import com.google.android.gms.measurement.AppMeasurement.C2009a;
import com.google.android.gms.measurement.AppMeasurement.C2013e;
import com.google.android.gms.p031b.C1843s;
import com.google.android.gms.p031b.nv.C1808b;
import com.google.android.gms.p031b.nv.C1809c;
import com.google.android.gms.p031b.nv.C1810d;
import com.google.android.gms.p031b.nv.C1811e;
import com.google.android.gms.p031b.nv.C1812f;
import com.google.android.gms.p031b.nx.C1816a;
import com.google.android.gms.p031b.nx.C1817b;
import com.google.android.gms.p031b.nx.C1818c;
import com.google.android.gms.p031b.nx.C1819d;
import com.google.android.gms.p031b.nx.C1820e;
import com.google.android.gms.p031b.nx.C1821f;
import com.google.android.gms.p031b.nx.C1822g;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class C2082m extends al {
    C2082m(aj ajVar) {
        super(ajVar);
    }

    private Object m11734a(int i, Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (!(obj instanceof Boolean)) {
            return obj instanceof Float ? Double.valueOf(((Float) obj).doubleValue()) : ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) ? m11761a(String.valueOf(obj), i, z) : null;
        } else {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        }
    }

    public static String m11735a(C1808b c1808b) {
        int i = 0;
        if (c1808b == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nevent_filter {\n");
        C2082m.m11743a(stringBuilder, 0, "filter_id", c1808b.f6105a);
        C2082m.m11743a(stringBuilder, 0, "event_name", c1808b.f6106b);
        C2082m.m11740a(stringBuilder, 1, "event_count_filter", c1808b.f6109e);
        stringBuilder.append("  filters {\n");
        C1809c[] c1809cArr = c1808b.f6107c;
        int length = c1809cArr.length;
        while (i < length) {
            C2082m.m11738a(stringBuilder, 2, c1809cArr[i]);
            i++;
        }
        C2082m.m11737a(stringBuilder, 1);
        stringBuilder.append("}\n}\n");
        return stringBuilder.toString();
    }

    public static String m11736a(C1811e c1811e) {
        if (c1811e == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nproperty_filter {\n");
        C2082m.m11743a(stringBuilder, 0, "filter_id", c1811e.f6121a);
        C2082m.m11743a(stringBuilder, 0, "property_name", c1811e.f6122b);
        C2082m.m11738a(stringBuilder, 1, c1811e.f6123c);
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }

    private static void m11737a(StringBuilder stringBuilder, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append("  ");
        }
    }

    private static void m11738a(StringBuilder stringBuilder, int i, C1809c c1809c) {
        if (c1809c != null) {
            C2082m.m11737a(stringBuilder, i);
            stringBuilder.append("filter {\n");
            C2082m.m11743a(stringBuilder, i, "complement", c1809c.f6113c);
            C2082m.m11743a(stringBuilder, i, "param_name", c1809c.f6114d);
            C2082m.m11741a(stringBuilder, i + 1, "string_filter", c1809c.f6111a);
            C2082m.m11740a(stringBuilder, i + 1, "number_filter", c1809c.f6112b);
            C2082m.m11737a(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private static void m11739a(StringBuilder stringBuilder, int i, C1820e c1820e) {
        if (c1820e != null) {
            C2082m.m11737a(stringBuilder, i);
            stringBuilder.append("bundle {\n");
            C2082m.m11743a(stringBuilder, i, "protocol_version", c1820e.f6166a);
            C2082m.m11743a(stringBuilder, i, "platform", c1820e.f6174i);
            C2082m.m11743a(stringBuilder, i, "gmp_version", c1820e.f6182q);
            C2082m.m11743a(stringBuilder, i, "uploading_gmp_version", c1820e.f6183r);
            C2082m.m11743a(stringBuilder, i, "gmp_app_id", c1820e.f6190y);
            C2082m.m11743a(stringBuilder, i, "app_id", c1820e.f6180o);
            C2082m.m11743a(stringBuilder, i, "app_version", c1820e.f6181p);
            C2082m.m11743a(stringBuilder, i, "app_version_major", c1820e.f6162C);
            C2082m.m11743a(stringBuilder, i, "firebase_instance_id", c1820e.f6161B);
            C2082m.m11743a(stringBuilder, i, "dev_cert_hash", c1820e.f6187v);
            C2082m.m11743a(stringBuilder, i, "app_store", c1820e.f6179n);
            C2082m.m11743a(stringBuilder, i, "upload_timestamp_millis", c1820e.f6169d);
            C2082m.m11743a(stringBuilder, i, "start_timestamp_millis", c1820e.f6170e);
            C2082m.m11743a(stringBuilder, i, "end_timestamp_millis", c1820e.f6171f);
            C2082m.m11743a(stringBuilder, i, "previous_bundle_start_timestamp_millis", c1820e.f6172g);
            C2082m.m11743a(stringBuilder, i, "previous_bundle_end_timestamp_millis", c1820e.f6173h);
            C2082m.m11743a(stringBuilder, i, "app_instance_id", c1820e.f6186u);
            C2082m.m11743a(stringBuilder, i, "resettable_device_id", c1820e.f6184s);
            C2082m.m11743a(stringBuilder, i, "device_id", c1820e.f6165F);
            C2082m.m11743a(stringBuilder, i, "limited_ad_tracking", c1820e.f6185t);
            C2082m.m11743a(stringBuilder, i, "os_version", c1820e.f6175j);
            C2082m.m11743a(stringBuilder, i, "device_model", c1820e.f6176k);
            C2082m.m11743a(stringBuilder, i, "user_default_language", c1820e.f6177l);
            C2082m.m11743a(stringBuilder, i, "time_zone_offset_minutes", c1820e.f6178m);
            C2082m.m11743a(stringBuilder, i, "bundle_sequential_index", c1820e.f6188w);
            C2082m.m11743a(stringBuilder, i, "service_upload", c1820e.f6191z);
            C2082m.m11743a(stringBuilder, i, "health_monitor", c1820e.f6189x);
            C2082m.m11747a(stringBuilder, i, c1820e.f6168c);
            C2082m.m11744a(stringBuilder, i, c1820e.f6160A);
            C2082m.m11745a(stringBuilder, i, c1820e.f6167b);
            C2082m.m11737a(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private static void m11740a(StringBuilder stringBuilder, int i, String str, C1810d c1810d) {
        if (c1810d != null) {
            C2082m.m11737a(stringBuilder, i);
            stringBuilder.append(str);
            stringBuilder.append(" {\n");
            if (c1810d.f6115a != null) {
                Object obj = "UNKNOWN_COMPARISON_TYPE";
                switch (c1810d.f6115a.intValue()) {
                    case 1:
                        obj = "LESS_THAN";
                        break;
                    case 2:
                        obj = "GREATER_THAN";
                        break;
                    case 3:
                        obj = "EQUAL";
                        break;
                    case 4:
                        obj = "BETWEEN";
                        break;
                }
                C2082m.m11743a(stringBuilder, i, "comparison_type", obj);
            }
            C2082m.m11743a(stringBuilder, i, "match_as_float", c1810d.f6116b);
            C2082m.m11743a(stringBuilder, i, "comparison_value", c1810d.f6117c);
            C2082m.m11743a(stringBuilder, i, "min_comparison_value", c1810d.f6118d);
            C2082m.m11743a(stringBuilder, i, "max_comparison_value", c1810d.f6119e);
            C2082m.m11737a(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private static void m11741a(StringBuilder stringBuilder, int i, String str, C1812f c1812f) {
        if (c1812f != null) {
            C2082m.m11737a(stringBuilder, i);
            stringBuilder.append(str);
            stringBuilder.append(" {\n");
            if (c1812f.f6124a != null) {
                Object obj = "UNKNOWN_MATCH_TYPE";
                switch (c1812f.f6124a.intValue()) {
                    case 1:
                        obj = "REGEXP";
                        break;
                    case 2:
                        obj = "BEGINS_WITH";
                        break;
                    case 3:
                        obj = "ENDS_WITH";
                        break;
                    case 4:
                        obj = "PARTIAL";
                        break;
                    case 5:
                        obj = "EXACT";
                        break;
                    case 6:
                        obj = "IN_LIST";
                        break;
                }
                C2082m.m11743a(stringBuilder, i, "match_type", obj);
            }
            C2082m.m11743a(stringBuilder, i, "expression", c1812f.f6125b);
            C2082m.m11743a(stringBuilder, i, "case_sensitive", c1812f.f6126c);
            if (c1812f.f6127d.length > 0) {
                C2082m.m11737a(stringBuilder, i + 1);
                stringBuilder.append("expression_list {\n");
                for (String str2 : c1812f.f6127d) {
                    C2082m.m11737a(stringBuilder, i + 2);
                    stringBuilder.append(str2);
                    stringBuilder.append("\n");
                }
                stringBuilder.append("}\n");
            }
            C2082m.m11737a(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private static void m11742a(StringBuilder stringBuilder, int i, String str, C1821f c1821f) {
        int i2 = 0;
        if (c1821f != null) {
            int i3;
            int i4;
            int i5 = i + 1;
            C2082m.m11737a(stringBuilder, i5);
            stringBuilder.append(str);
            stringBuilder.append(" {\n");
            if (c1821f.f6193b != null) {
                C2082m.m11737a(stringBuilder, i5 + 1);
                stringBuilder.append("results: ");
                long[] jArr = c1821f.f6193b;
                int length = jArr.length;
                i3 = 0;
                i4 = 0;
                while (i3 < length) {
                    Long valueOf = Long.valueOf(jArr[i3]);
                    int i6 = i4 + 1;
                    if (i4 != 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(valueOf);
                    i3++;
                    i4 = i6;
                }
                stringBuilder.append('\n');
            }
            if (c1821f.f6192a != null) {
                C2082m.m11737a(stringBuilder, i5 + 1);
                stringBuilder.append("status: ");
                long[] jArr2 = c1821f.f6192a;
                int length2 = jArr2.length;
                i3 = 0;
                while (i2 < length2) {
                    Long valueOf2 = Long.valueOf(jArr2[i2]);
                    i4 = i3 + 1;
                    if (i3 != 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(valueOf2);
                    i2++;
                    i3 = i4;
                }
                stringBuilder.append('\n');
            }
            C2082m.m11737a(stringBuilder, i5);
            stringBuilder.append("}\n");
        }
    }

    private static void m11743a(StringBuilder stringBuilder, int i, String str, Object obj) {
        if (obj != null) {
            C2082m.m11737a(stringBuilder, i + 1);
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(obj);
            stringBuilder.append('\n');
        }
    }

    private static void m11744a(StringBuilder stringBuilder, int i, C1816a[] c1816aArr) {
        if (c1816aArr != null) {
            int i2 = i + 1;
            for (C1816a c1816a : c1816aArr) {
                if (c1816a != null) {
                    C2082m.m11737a(stringBuilder, i2);
                    stringBuilder.append("audience_membership {\n");
                    C2082m.m11743a(stringBuilder, i2, "audience_id", c1816a.f6142a);
                    C2082m.m11743a(stringBuilder, i2, "new_audience", c1816a.f6145d);
                    C2082m.m11742a(stringBuilder, i2, "current_data", c1816a.f6143b);
                    C2082m.m11742a(stringBuilder, i2, "previous_data", c1816a.f6144c);
                    C2082m.m11737a(stringBuilder, i2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    private static void m11745a(StringBuilder stringBuilder, int i, C1817b[] c1817bArr) {
        if (c1817bArr != null) {
            int i2 = i + 1;
            for (C1817b c1817b : c1817bArr) {
                if (c1817b != null) {
                    C2082m.m11737a(stringBuilder, i2);
                    stringBuilder.append("event {\n");
                    C2082m.m11743a(stringBuilder, i2, "name", c1817b.f6148b);
                    C2082m.m11743a(stringBuilder, i2, "timestamp_millis", c1817b.f6149c);
                    C2082m.m11743a(stringBuilder, i2, "previous_timestamp_millis", c1817b.f6150d);
                    C2082m.m11743a(stringBuilder, i2, "count", c1817b.f6151e);
                    C2082m.m11746a(stringBuilder, i2, c1817b.f6147a);
                    C2082m.m11737a(stringBuilder, i2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    private static void m11746a(StringBuilder stringBuilder, int i, C1818c[] c1818cArr) {
        if (c1818cArr != null) {
            int i2 = i + 1;
            for (C1818c c1818c : c1818cArr) {
                if (c1818c != null) {
                    C2082m.m11737a(stringBuilder, i2);
                    stringBuilder.append("param {\n");
                    C2082m.m11743a(stringBuilder, i2, "name", c1818c.f6153a);
                    C2082m.m11743a(stringBuilder, i2, "string_value", c1818c.f6154b);
                    C2082m.m11743a(stringBuilder, i2, "int_value", c1818c.f6155c);
                    C2082m.m11743a(stringBuilder, i2, "double_value", c1818c.f6157e);
                    C2082m.m11737a(stringBuilder, i2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    private static void m11747a(StringBuilder stringBuilder, int i, C1822g[] c1822gArr) {
        if (c1822gArr != null) {
            int i2 = i + 1;
            for (C1822g c1822g : c1822gArr) {
                if (c1822g != null) {
                    C2082m.m11737a(stringBuilder, i2);
                    stringBuilder.append("user_property {\n");
                    C2082m.m11743a(stringBuilder, i2, "set_timestamp_millis", c1822g.f6195a);
                    C2082m.m11743a(stringBuilder, i2, "name", c1822g.f6196b);
                    C2082m.m11743a(stringBuilder, i2, "string_value", c1822g.f6197c);
                    C2082m.m11743a(stringBuilder, i2, "int_value", c1822g.f6198d);
                    C2082m.m11743a(stringBuilder, i2, "double_value", c1822g.f6200f);
                    C2082m.m11737a(stringBuilder, i2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    public static boolean m11748a(Context context, String str) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, str), 4);
            if (serviceInfo != null && serviceInfo.enabled) {
                return true;
            }
        } catch (NameNotFoundException e) {
        }
        return false;
    }

    public static boolean m11749a(Context context, String str, boolean z) {
        try {
            ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, str), 2);
            if (receiverInfo != null && receiverInfo.enabled && (!z || receiverInfo.exported)) {
                return true;
            }
        } catch (NameNotFoundException e) {
        }
        return false;
    }

    public static boolean m11750a(Bundle bundle) {
        return bundle.getLong("_c") == 1;
    }

    static boolean m11751a(String str) {
        C1896c.m10792a(str);
        return str.charAt(0) != '_';
    }

    public static boolean m11752a(long[] jArr, int i) {
        return i < jArr.length * 64 && (jArr[i / 64] & (1 << (i % 64))) != 0;
    }

    public static long[] m11753a(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        long[] jArr = new long[length];
        int i = 0;
        while (i < length) {
            jArr[i] = 0;
            int i2 = 0;
            while (i2 < 64 && (i * 64) + i2 < bitSet.length()) {
                if (bitSet.get((i * 64) + i2)) {
                    jArr[i] = jArr[i] | (1 << i2);
                }
                i2++;
            }
            i++;
        }
        return jArr;
    }

    public static String m11754b(C1819d c1819d) {
        if (c1819d == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nbatch {\n");
        if (c1819d.f6158a != null) {
            for (C1820e c1820e : c1819d.f6158a) {
                if (c1820e != null) {
                    C2082m.m11739a(stringBuilder, 1, c1820e);
                }
            }
        }
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }

    static long m11755c(byte[] bArr) {
        long j = null;
        C1896c.m10790a((Object) bArr);
        C1896c.m10794a(bArr.length > 0);
        long j2 = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j2 += (((long) bArr[length]) & 255) << j;
            j += 8;
            length--;
        }
        return j2;
    }

    public static boolean m11756c(String str, String str2) {
        return (str == null && str2 == null) ? true : str == null ? false : str.equals(str2);
    }

    static MessageDigest m11757i(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
                i++;
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return null;
    }

    public static boolean m11758k(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    private int m11759l(String str) {
        return "_ldl".equals(str) ? mo1748y().m11819A() : mo1748y().m11879z();
    }

    public Bundle m11760a(String str, Bundle bundle, List<String> list, boolean z) {
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        int b = mo1748y().m11849b();
        int i = 0;
        for (String str2 : bundle.keySet()) {
            int e;
            if (list == null || !list.contains(str2)) {
                e = z ? m11784e(str2) : 0;
                if (e == 0) {
                    e = m11785f(str2);
                }
            } else {
                e = 0;
            }
            if (e != 0) {
                if (m11767a(bundle2, e)) {
                    bundle2.putString("_ev", m11761a(str2, mo1748y().m11856e(), true));
                }
                bundle2.remove(str2);
            } else if (m11769a(str2, bundle.get(str2)) || "_ev".equals(str2)) {
                if (C2082m.m11751a(str2)) {
                    i++;
                    if (i > b) {
                        mo1746w().m11290f().m11251a("Event can't contain more then " + b + " params", str, bundle);
                        m11767a(bundle2, 5);
                        bundle2.remove(str2);
                    }
                }
                i = i;
            } else {
                if (m11767a(bundle2, 4)) {
                    bundle2.putString("_ev", m11761a(str2, mo1748y().m11856e(), true));
                }
                bundle2.remove(str2);
            }
        }
        return bundle2;
    }

    public String m11761a(String str, int i, boolean z) {
        return str.length() > i ? z ? String.valueOf(str.substring(0, i)).concat("...") : null : str;
    }

    public void m11762a(int i, String str, String str2) {
        Bundle bundle = new Bundle();
        m11767a(bundle, i);
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(str, str2);
        }
        this.n.m11508l().m11579a("auto", "_err", bundle);
    }

    public void m11763a(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (str != null) {
                mo1746w().m11280B().m11251a("Not putting event parameter. Invalid value type. name, type", str, obj != null ? obj.getClass().getSimpleName() : null);
            }
        }
    }

    public void m11764a(C1818c c1818c, Object obj) {
        C1896c.m10790a(obj);
        c1818c.f6154b = null;
        c1818c.f6155c = null;
        c1818c.f6157e = null;
        if (obj instanceof String) {
            c1818c.f6154b = (String) obj;
        } else if (obj instanceof Long) {
            c1818c.f6155c = (Long) obj;
        } else if (obj instanceof Double) {
            c1818c.f6157e = (Double) obj;
        } else {
            mo1746w().m11290f().m11250a("Ignoring invalid (type) event param value", obj);
        }
    }

    public void m11765a(C1822g c1822g, Object obj) {
        C1896c.m10790a(obj);
        c1822g.f6197c = null;
        c1822g.f6198d = null;
        c1822g.f6200f = null;
        if (obj instanceof String) {
            c1822g.f6197c = (String) obj;
        } else if (obj instanceof Long) {
            c1822g.f6198d = (Long) obj;
        } else if (obj instanceof Double) {
            c1822g.f6200f = (Double) obj;
        } else {
            mo1746w().m11290f().m11250a("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public boolean m11766a(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(mo1739p().mo1723a() - j) > j2;
    }

    public boolean m11767a(Bundle bundle, int i) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i);
        return true;
    }

    boolean m11768a(String str, int i, String str2) {
        if (str2 == null) {
            mo1746w().m11290f().m11250a("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() <= i) {
            return true;
        } else {
            mo1746w().m11290f().m11252a("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    public boolean m11769a(String str, Object obj) {
        return C2082m.m11758k(str) ? m11771a("param", str, mo1748y().m11860g(), obj) : m11771a("param", str, mo1748y().m11858f(), obj);
    }

    boolean m11770a(String str, String str2) {
        if (str2 == null) {
            mo1746w().m11290f().m11250a("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            mo1746w().m11290f().m11250a("Name is required and can't be empty. Type", str);
            return false;
        } else if (Character.isLetter(str2.charAt(0))) {
            int i = 1;
            while (i < str2.length()) {
                char charAt = str2.charAt(i);
                if (charAt == '_' || Character.isLetterOrDigit(charAt)) {
                    i++;
                } else {
                    mo1746w().m11290f().m11251a("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        } else {
            mo1746w().m11290f().m11251a("Name must start with a letter. Type, name", str, str2);
            return false;
        }
    }

    boolean m11771a(String str, String str2, int i, Object obj) {
        if (obj == null || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Boolean) || (obj instanceof Double)) {
            return true;
        }
        if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
            return false;
        }
        String valueOf = String.valueOf(obj);
        if (valueOf.length() <= i) {
            return true;
        }
        mo1746w().m11310z().m11252a("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
        return false;
    }

    boolean m11772a(String str, Map<String, String> map, String str2) {
        if (str2 == null) {
            mo1746w().m11290f().m11250a("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.startsWith("firebase_")) {
            mo1746w().m11290f().m11251a("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        } else if (map == null || !map.containsKey(str2)) {
            return true;
        } else {
            mo1746w().m11290f().m11251a("Name is reserved. Type, name", str, str2);
            return false;
        }
    }

    public byte[] m11773a(C1819d c1819d) {
        try {
            byte[] bArr = new byte[c1819d.m7349f()];
            C1843s a = C1843s.m10412a(bArr);
            c1819d.mo1231a(a);
            a.m10458b();
            return bArr;
        } catch (IOException e) {
            mo1746w().m11290f().m11250a("Data loss. Failed to serialize batch", e);
            return null;
        }
    }

    public byte[] m11774a(byte[] bArr) {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            mo1746w().m11290f().m11250a("Failed to gzip content", e);
            throw e;
        }
    }

    public int m11775b(String str) {
        return !m11770a("event", str) ? 2 : !m11772a("event", C2009a.f6650a, str) ? 13 : m11768a("event", mo1748y().m11852c(), str) ? 0 : 2;
    }

    public Object m11776b(String str, Object obj) {
        if ("_ev".equals(str)) {
            return m11734a(mo1748y().m11860g(), obj, true);
        }
        return m11734a(C2082m.m11758k(str) ? mo1748y().m11860g() : mo1748y().m11858f(), obj, false);
    }

    boolean m11777b(String str, String str2) {
        if (str2 == null) {
            mo1746w().m11290f().m11250a("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            mo1746w().m11290f().m11250a("Name is required and can't be empty. Type", str);
            return false;
        } else {
            char charAt = str2.charAt(0);
            if (Character.isLetter(charAt) || charAt == '_') {
                int i = 1;
                while (i < str2.length()) {
                    char charAt2 = str2.charAt(i);
                    if (charAt2 == '_' || Character.isLetterOrDigit(charAt2)) {
                        i++;
                    } else {
                        mo1746w().m11290f().m11251a("Name must start with a letter or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            mo1746w().m11290f().m11251a("Name must start with a letter or _ (underscores). Type, name", str, str2);
            return false;
        }
    }

    public byte[] m11778b(byte[] bArr) {
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read <= 0) {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
        } catch (IOException e) {
            mo1746w().m11290f().m11250a("Failed to ungzip content", e);
            throw e;
        }
    }

    public int m11779c(String str) {
        return !m11777b("event", str) ? 2 : !m11772a("event", C2009a.f6650a, str) ? 13 : m11768a("event", mo1748y().m11852c(), str) ? 0 : 2;
    }

    public int m11780c(String str, Object obj) {
        return "_ldl".equals(str) ? m11771a("user property referrer", str, m11759l(str), obj) : m11771a("user property", str, m11759l(str), obj) ? 0 : 7;
    }

    public int m11781d(String str) {
        return !m11777b("user property", str) ? 6 : !m11772a("user property", C2013e.f6652a, str) ? 15 : m11768a("user property", mo1748y().m11854d(), str) ? 0 : 6;
    }

    public long m11782d(byte[] bArr) {
        C1896c.m10790a((Object) bArr);
        MessageDigest i = C2082m.m11757i("MD5");
        if (i != null) {
            return C2082m.m11755c(i.digest(bArr));
        }
        mo1746w().m11290f().m11249a("Failed to get MD5");
        return 0;
    }

    public Object m11783d(String str, Object obj) {
        return "_ldl".equals(str) ? m11734a(m11759l(str), obj, true) : m11734a(m11759l(str), obj, false);
    }

    public int m11784e(String str) {
        return !m11770a("event param", str) ? 3 : !m11772a("event param", null, str) ? 14 : m11768a("event param", mo1748y().m11856e(), str) ? 0 : 3;
    }

    public int m11785f(String str) {
        return !m11777b("event param", str) ? 3 : !m11772a("event param", null, str) ? 14 : m11768a("event param", mo1748y().m11856e(), str) ? 0 : 3;
    }

    public boolean m11786g(String str) {
        if (TextUtils.isEmpty(str)) {
            mo1746w().m11290f().m11249a("Measurement Service called without google_app_id");
            return false;
        } else if (!str.startsWith("1:")) {
            mo1746w().m11310z().m11250a("Measurement Service called with unknown id version", str);
            return true;
        } else if (m11788h(str)) {
            return true;
        } else {
            mo1746w().m11290f().m11250a("Invalid google_app_id. Firebase Analytics disabled. See", "https://goo.gl/FZRIUV");
            return false;
        }
    }

    public /* bridge */ /* synthetic */ void mo1731h() {
        super.mo1731h();
    }

    boolean m11788h(String str) {
        C1896c.m10790a((Object) str);
        return str.matches("^1:\\d+:android:[a-f0-9]+$");
    }

    public /* bridge */ /* synthetic */ void mo1732i() {
        super.mo1732i();
    }

    public /* bridge */ /* synthetic */ void mo1733j() {
        super.mo1733j();
    }

    public boolean m11791j(String str) {
        mo1733j();
        if (mo1740q().checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        mo1746w().m11282D().m11250a("Permission not granted", str);
        return false;
    }

    public /* bridge */ /* synthetic */ C2084o mo1734k() {
        return super.mo1734k();
    }

    public /* bridge */ /* synthetic */ C2053d mo1735l() {
        return super.mo1735l();
    }

    public /* bridge */ /* synthetic */ C2098z mo1736m() {
        return super.mo1736m();
    }

    public /* bridge */ /* synthetic */ C2090s mo1737n() {
        return super.mo1737n();
    }

    public /* bridge */ /* synthetic */ C2066e mo1738o() {
        return super.mo1738o();
    }

    public /* bridge */ /* synthetic */ C1970c mo1739p() {
        return super.mo1739p();
    }

    public /* bridge */ /* synthetic */ Context mo1740q() {
        return super.mo1740q();
    }

    public /* bridge */ /* synthetic */ C2088q mo1741r() {
        return super.mo1741r();
    }

    public /* bridge */ /* synthetic */ C2082m mo1742s() {
        return super.mo1742s();
    }

    public /* bridge */ /* synthetic */ ah mo1743t() {
        return super.mo1743t();
    }

    public /* bridge */ /* synthetic */ C2076g mo1744u() {
        return super.mo1744u();
    }

    public /* bridge */ /* synthetic */ ai mo1745v() {
        return super.mo1745v();
    }

    public /* bridge */ /* synthetic */ ab mo1746w() {
        return super.mo1746w();
    }

    public /* bridge */ /* synthetic */ af mo1747x() {
        return super.mo1747x();
    }

    public /* bridge */ /* synthetic */ C2085p mo1748y() {
        return super.mo1748y();
    }
}
