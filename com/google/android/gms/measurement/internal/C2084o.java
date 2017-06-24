package com.google.android.gms.measurement.internal;

import android.support.v4.p015g.C0370a;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.measurement.AppMeasurement.C2009a;
import com.google.android.gms.measurement.AppMeasurement.C2012d;
import com.google.android.gms.measurement.AppMeasurement.C2013e;
import com.google.android.gms.measurement.internal.ab.C2018a;
import com.google.android.gms.p031b.nv.C1807a;
import com.google.android.gms.p031b.nv.C1808b;
import com.google.android.gms.p031b.nv.C1809c;
import com.google.android.gms.p031b.nv.C1811e;
import com.google.android.gms.p031b.nx.C1816a;
import com.google.android.gms.p031b.nx.C1817b;
import com.google.android.gms.p031b.nx.C1818c;
import com.google.android.gms.p031b.nx.C1821f;
import com.google.android.gms.p031b.nx.C1822g;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

class C2084o extends C2019b {
    C2084o(aj ajVar) {
        super(ajVar);
    }

    private Boolean m11810a(C1808b c1808b, C1817b c1817b, long j) {
        Boolean a;
        if (c1808b.f6109e != null) {
            a = new ae(c1808b.f6109e).m11346a(j);
            if (a == null) {
                return null;
            }
            if (!a.booleanValue()) {
                return Boolean.valueOf(false);
            }
        }
        Set hashSet = new HashSet();
        for (C1809c c1809c : c1808b.f6107c) {
            if (TextUtils.isEmpty(c1809c.f6114d)) {
                mo1746w().m11310z().m11250a("null or empty param name in filter. event", c1817b.f6148b);
                return null;
            }
            hashSet.add(c1809c.f6114d);
        }
        Map c0370a = new C0370a();
        for (C1818c c1818c : c1817b.f6147a) {
            if (hashSet.contains(c1818c.f6153a)) {
                if (c1818c.f6155c != null) {
                    c0370a.put(c1818c.f6153a, c1818c.f6155c);
                } else if (c1818c.f6157e != null) {
                    c0370a.put(c1818c.f6153a, c1818c.f6157e);
                } else if (c1818c.f6154b != null) {
                    c0370a.put(c1818c.f6153a, c1818c.f6154b);
                } else {
                    mo1746w().m11310z().m11251a("Unknown value for param. event, param", c1817b.f6148b, c1818c.f6153a);
                    return null;
                }
            }
        }
        for (C1809c c1809c2 : c1808b.f6107c) {
            boolean equals = Boolean.TRUE.equals(c1809c2.f6113c);
            CharSequence charSequence = c1809c2.f6114d;
            if (TextUtils.isEmpty(charSequence)) {
                mo1746w().m11310z().m11250a("Event has empty param name. event", c1817b.f6148b);
                return null;
            }
            Object obj = c0370a.get(charSequence);
            if (obj instanceof Long) {
                if (c1809c2.f6112b == null) {
                    mo1746w().m11310z().m11251a("No number filter for long param. event, param", c1817b.f6148b, charSequence);
                    return null;
                }
                a = new ae(c1809c2.f6112b).m11346a(((Long) obj).longValue());
                if (a == null) {
                    return null;
                }
                if (((!a.booleanValue() ? 1 : 0) ^ equals) != 0) {
                    return Boolean.valueOf(false);
                }
            } else if (obj instanceof Double) {
                if (c1809c2.f6112b == null) {
                    mo1746w().m11310z().m11251a("No number filter for double param. event, param", c1817b.f6148b, charSequence);
                    return null;
                }
                a = new ae(c1809c2.f6112b).m11345a(((Double) obj).doubleValue());
                if (a == null) {
                    return null;
                }
                if (((!a.booleanValue() ? 1 : 0) ^ equals) != 0) {
                    return Boolean.valueOf(false);
                }
            } else if (obj instanceof String) {
                if (c1809c2.f6111a == null) {
                    mo1746w().m11310z().m11251a("No string filter for String param. event, param", c1817b.f6148b, charSequence);
                    return null;
                }
                a = new C2077h(c1809c2.f6111a).m11705a((String) obj);
                if (a == null) {
                    return null;
                }
                if (((!a.booleanValue() ? 1 : 0) ^ equals) != 0) {
                    return Boolean.valueOf(false);
                }
            } else if (obj == null) {
                mo1746w().m11283E().m11251a("Missing param for filter. event, param", c1817b.f6148b, charSequence);
                return Boolean.valueOf(false);
            } else {
                mo1746w().m11310z().m11251a("Unknown param type. event, param", c1817b.f6148b, charSequence);
                return null;
            }
        }
        return Boolean.valueOf(true);
    }

    private Boolean m11811a(C1811e c1811e, C1822g c1822g) {
        Boolean bool = null;
        C1809c c1809c = c1811e.f6123c;
        if (c1809c == null) {
            mo1746w().m11310z().m11250a("Missing property filter. property", c1822g.f6196b);
            return bool;
        }
        boolean equals = Boolean.TRUE.equals(c1809c.f6113c);
        if (c1822g.f6198d != null) {
            if (c1809c.f6112b != null) {
                return C2084o.m11812a(new ae(c1809c.f6112b).m11346a(c1822g.f6198d.longValue()), equals);
            }
            mo1746w().m11310z().m11250a("No number filter for long property. property", c1822g.f6196b);
            return bool;
        } else if (c1822g.f6200f != null) {
            if (c1809c.f6112b != null) {
                return C2084o.m11812a(new ae(c1809c.f6112b).m11345a(c1822g.f6200f.doubleValue()), equals);
            }
            mo1746w().m11310z().m11250a("No number filter for double property. property", c1822g.f6196b);
            return bool;
        } else if (c1822g.f6197c == null) {
            mo1746w().m11310z().m11250a("User property has no value, property", c1822g.f6196b);
            return bool;
        } else if (c1809c.f6111a != null) {
            return C2084o.m11812a(new C2077h(c1809c.f6111a).m11705a(c1822g.f6197c), equals);
        } else {
            if (c1809c.f6112b == null) {
                mo1746w().m11310z().m11250a("No string or number filter defined. property", c1822g.f6196b);
                return bool;
            }
            ae aeVar = new ae(c1809c.f6112b);
            if (c1809c.f6112b.f6116b == null || !c1809c.f6112b.f6116b.booleanValue()) {
                if (m11814a(c1822g.f6197c)) {
                    try {
                        return C2084o.m11812a(aeVar.m11346a(Long.parseLong(c1822g.f6197c)), equals);
                    } catch (NumberFormatException e) {
                        mo1746w().m11310z().m11251a("User property value exceeded Long value range. property, value", c1822g.f6196b, c1822g.f6197c);
                        return bool;
                    }
                }
                mo1746w().m11310z().m11251a("Invalid user property value for Long number filter. property, value", c1822g.f6196b, c1822g.f6197c);
                return bool;
            } else if (m11816b(c1822g.f6197c)) {
                try {
                    double parseDouble = Double.parseDouble(c1822g.f6197c);
                    if (!Double.isInfinite(parseDouble)) {
                        return C2084o.m11812a(aeVar.m11345a(parseDouble), equals);
                    }
                    mo1746w().m11310z().m11251a("User property value exceeded Double value range. property, value", c1822g.f6196b, c1822g.f6197c);
                    return bool;
                } catch (NumberFormatException e2) {
                    mo1746w().m11310z().m11251a("User property value exceeded Double value range. property, value", c1822g.f6196b, c1822g.f6197c);
                    return bool;
                }
            } else {
                mo1746w().m11310z().m11251a("Invalid user property value for Double number filter. property, value", c1822g.f6196b, c1822g.f6197c);
                return bool;
            }
        }
    }

    static Boolean m11812a(Boolean bool, boolean z) {
        return bool == null ? null : Boolean.valueOf(bool.booleanValue() ^ z);
    }

    void m11813a(String str, C1807a[] c1807aArr) {
        C1896c.m10790a((Object) c1807aArr);
        for (C1807a c1807a : c1807aArr) {
            for (C1808b c1808b : c1807a.f6103c) {
                String str2 = (String) C2009a.f6650a.get(c1808b.f6106b);
                if (str2 != null) {
                    c1808b.f6106b = str2;
                }
                for (C1809c c1809c : c1808b.f6107c) {
                    str2 = (String) C2012d.f6651a.get(c1809c.f6114d);
                    if (str2 != null) {
                        c1809c.f6114d = str2;
                    }
                }
            }
            for (C1811e c1811e : c1807a.f6102b) {
                str2 = (String) C2013e.f6652a.get(c1811e.f6122b);
                if (str2 != null) {
                    c1811e.f6122b = str2;
                }
            }
        }
        mo1741r().m11915a(str, c1807aArr);
    }

    boolean m11814a(String str) {
        return Pattern.matches("[+-]?[0-9]+", str);
    }

    C1816a[] m11815a(String str, C1817b[] c1817bArr, C1822g[] c1822gArr) {
        int intValue;
        BitSet bitSet;
        BitSet bitSet2;
        Map map;
        Map map2;
        Boolean a;
        Object obj;
        C1896c.m10792a(str);
        Set hashSet = new HashSet();
        C0370a c0370a = new C0370a();
        Map c0370a2 = new C0370a();
        C0370a c0370a3 = new C0370a();
        Map f = mo1741r().m11931f(str);
        if (f != null) {
            for (Integer intValue2 : f.keySet()) {
                intValue = intValue2.intValue();
                C1821f c1821f = (C1821f) f.get(Integer.valueOf(intValue));
                bitSet = (BitSet) c0370a2.get(Integer.valueOf(intValue));
                bitSet2 = (BitSet) c0370a3.get(Integer.valueOf(intValue));
                if (bitSet == null) {
                    bitSet = new BitSet();
                    c0370a2.put(Integer.valueOf(intValue), bitSet);
                    bitSet2 = new BitSet();
                    c0370a3.put(Integer.valueOf(intValue), bitSet2);
                }
                for (int i = 0; i < c1821f.f6192a.length * 64; i++) {
                    if (C2082m.m11752a(c1821f.f6192a, i)) {
                        mo1746w().m11283E().m11251a("Filter already evaluated. audience ID, filter ID", Integer.valueOf(intValue), Integer.valueOf(i));
                        bitSet2.set(i);
                        if (C2082m.m11752a(c1821f.f6193b, i)) {
                            bitSet.set(i);
                        }
                    }
                }
                C1816a c1816a = new C1816a();
                c0370a.put(Integer.valueOf(intValue), c1816a);
                c1816a.f6145d = Boolean.valueOf(false);
                c1816a.f6144c = c1821f;
                c1816a.f6143b = new C1821f();
                c1816a.f6143b.f6193b = C2082m.m11753a(bitSet);
                c1816a.f6143b.f6192a = C2082m.m11753a(bitSet2);
            }
        }
        if (c1817bArr != null) {
            C0370a c0370a4 = new C0370a();
            for (C1817b c1817b : c1817bArr) {
                C2092u c2092u;
                C2092u a2 = mo1741r().m11902a(str, c1817b.f6148b);
                if (a2 == null) {
                    mo1746w().m11310z().m11250a("Event aggregate wasn't created during raw event logging. event", c1817b.f6148b);
                    c2092u = new C2092u(str, c1817b.f6148b, 1, 1, c1817b.f6149c.longValue());
                } else {
                    c2092u = a2.m11964a();
                }
                mo1741r().m11910a(c2092u);
                long j = c2092u.f6987c;
                map = (Map) c0370a4.get(c1817b.f6148b);
                if (map == null) {
                    map = mo1741r().m11926d(str, c1817b.f6148b);
                    if (map == null) {
                        map = new C0370a();
                    }
                    c0370a4.put(c1817b.f6148b, map);
                    map2 = map;
                } else {
                    map2 = map;
                }
                mo1746w().m11283E().m11251a("event, affected audience count", c1817b.f6148b, Integer.valueOf(map2.size()));
                for (Integer intValue22 : map2.keySet()) {
                    int intValue3 = intValue22.intValue();
                    if (hashSet.contains(Integer.valueOf(intValue3))) {
                        mo1746w().m11283E().m11250a("Skipping failed audience ID", Integer.valueOf(intValue3));
                    } else {
                        bitSet = (BitSet) c0370a2.get(Integer.valueOf(intValue3));
                        bitSet2 = (BitSet) c0370a3.get(Integer.valueOf(intValue3));
                        if (((C1816a) c0370a.get(Integer.valueOf(intValue3))) == null) {
                            C1816a c1816a2 = new C1816a();
                            c0370a.put(Integer.valueOf(intValue3), c1816a2);
                            c1816a2.f6145d = Boolean.valueOf(true);
                            bitSet = new BitSet();
                            c0370a2.put(Integer.valueOf(intValue3), bitSet);
                            bitSet2 = new BitSet();
                            c0370a3.put(Integer.valueOf(intValue3), bitSet2);
                        }
                        for (C1808b c1808b : (List) map2.get(Integer.valueOf(intValue3))) {
                            if (mo1746w().m11288a(2)) {
                                mo1746w().m11283E().m11252a("Evaluating filter. audience, filter, event", Integer.valueOf(intValue3), c1808b.f6105a, c1808b.f6106b);
                                mo1746w().m11283E().m11250a("Filter definition", C2082m.m11735a(c1808b));
                            }
                            if (c1808b.f6105a == null || c1808b.f6105a.intValue() > 256) {
                                mo1746w().m11310z().m11250a("Invalid event filter ID. id", String.valueOf(c1808b.f6105a));
                            } else if (bitSet.get(c1808b.f6105a.intValue())) {
                                mo1746w().m11283E().m11251a("Event filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue3), c1808b.f6105a);
                            } else {
                                a = m11810a(c1808b, c1817b, j);
                                C2018a E = mo1746w().m11283E();
                                String str2 = "Event filter result";
                                if (a == null) {
                                    obj = "null";
                                } else {
                                    Boolean bool = a;
                                }
                                E.m11250a(str2, obj);
                                if (a == null) {
                                    hashSet.add(Integer.valueOf(intValue3));
                                } else {
                                    bitSet2.set(c1808b.f6105a.intValue());
                                    if (a.booleanValue()) {
                                        bitSet.set(c1808b.f6105a.intValue());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (c1822gArr != null) {
            Map c0370a5 = new C0370a();
            for (C1822g c1822g : c1822gArr) {
                map = (Map) c0370a5.get(c1822g.f6196b);
                if (map == null) {
                    map = mo1741r().m11928e(str, c1822g.f6196b);
                    if (map == null) {
                        map = new C0370a();
                    }
                    c0370a5.put(c1822g.f6196b, map);
                    map2 = map;
                } else {
                    map2 = map;
                }
                mo1746w().m11283E().m11251a("property, affected audience count", c1822g.f6196b, Integer.valueOf(map2.size()));
                for (Integer intValue222 : map2.keySet()) {
                    int intValue4 = intValue222.intValue();
                    if (hashSet.contains(Integer.valueOf(intValue4))) {
                        mo1746w().m11283E().m11250a("Skipping failed audience ID", Integer.valueOf(intValue4));
                    } else {
                        bitSet = (BitSet) c0370a2.get(Integer.valueOf(intValue4));
                        bitSet2 = (BitSet) c0370a3.get(Integer.valueOf(intValue4));
                        if (((C1816a) c0370a.get(Integer.valueOf(intValue4))) == null) {
                            c1816a2 = new C1816a();
                            c0370a.put(Integer.valueOf(intValue4), c1816a2);
                            c1816a2.f6145d = Boolean.valueOf(true);
                            bitSet = new BitSet();
                            c0370a2.put(Integer.valueOf(intValue4), bitSet);
                            bitSet2 = new BitSet();
                            c0370a3.put(Integer.valueOf(intValue4), bitSet2);
                        }
                        for (C1811e c1811e : (List) map2.get(Integer.valueOf(intValue4))) {
                            if (mo1746w().m11288a(2)) {
                                mo1746w().m11283E().m11252a("Evaluating filter. audience, filter, property", Integer.valueOf(intValue4), c1811e.f6121a, c1811e.f6122b);
                                mo1746w().m11283E().m11250a("Filter definition", C2082m.m11736a(c1811e));
                            }
                            if (c1811e.f6121a == null || c1811e.f6121a.intValue() > 256) {
                                mo1746w().m11310z().m11250a("Invalid property filter ID. id", String.valueOf(c1811e.f6121a));
                                hashSet.add(Integer.valueOf(intValue4));
                                break;
                            } else if (bitSet.get(c1811e.f6121a.intValue())) {
                                mo1746w().m11283E().m11251a("Property filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue4), c1811e.f6121a);
                            } else {
                                a = m11811a(c1811e, c1822g);
                                C2018a E2 = mo1746w().m11283E();
                                String str3 = "Property filter result";
                                if (a == null) {
                                    obj = "null";
                                } else {
                                    bool = a;
                                }
                                E2.m11250a(str3, obj);
                                if (a == null) {
                                    hashSet.add(Integer.valueOf(intValue4));
                                } else {
                                    bitSet2.set(c1811e.f6121a.intValue());
                                    if (a.booleanValue()) {
                                        bitSet.set(c1811e.f6121a.intValue());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        C1816a[] c1816aArr = new C1816a[c0370a2.size()];
        int i2 = 0;
        for (Integer intValue2222 : c0370a2.keySet()) {
            intValue = intValue2222.intValue();
            if (!hashSet.contains(Integer.valueOf(intValue))) {
                c1816a2 = (C1816a) c0370a.get(Integer.valueOf(intValue));
                c1816a = c1816a2 == null ? new C1816a() : c1816a2;
                int i3 = i2 + 1;
                c1816aArr[i2] = c1816a;
                c1816a.f6142a = Integer.valueOf(intValue);
                c1816a.f6143b = new C1821f();
                c1816a.f6143b.f6193b = C2082m.m11753a((BitSet) c0370a2.get(Integer.valueOf(intValue)));
                c1816a.f6143b.f6192a = C2082m.m11753a((BitSet) c0370a3.get(Integer.valueOf(intValue)));
                mo1741r().m11912a(str, intValue, c1816a.f6143b);
                i2 = i3;
            }
        }
        return (C1816a[]) Arrays.copyOf(c1816aArr, i2);
    }

    boolean m11816b(String str) {
        return Pattern.matches("[+-]?(([0-9]+\\.?)|([0-9]*\\.[0-9]+))", str);
    }

    protected void mo1730e() {
    }
}
