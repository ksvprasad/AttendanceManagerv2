package com.google.android.gms.p031b;

import java.io.IOException;

public class C1848y extends IOException {
    public C1848y(String str) {
        super(str);
    }

    static C1848y m10504a() {
        return new C1848y("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static C1848y m10505b() {
        return new C1848y("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static C1848y m10506c() {
        return new C1848y("CodedInputStream encountered a malformed varint.");
    }

    static C1848y m10507d() {
        return new C1848y("Protocol message contained an invalid tag (zero).");
    }

    static C1848y m10508e() {
        return new C1848y("Protocol message end-group tag did not match expected tag.");
    }

    static C1848y m10509f() {
        return new C1848y("Protocol message tag had invalid wire type.");
    }

    static C1848y m10510g() {
        return new C1848y("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }
}
