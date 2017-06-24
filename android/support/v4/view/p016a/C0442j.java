package android.support.v4.view.p016a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

class C0442j {

    interface C0433a {
        Object mo343a(int i);

        List<Object> mo344a(String str, int i);

        boolean mo345a(int i, int i2, Bundle bundle);
    }

    public static Object m2269a(final C0433a c0433a) {
        return new AccessibilityNodeProvider() {
            public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
                return (AccessibilityNodeInfo) c0433a.mo343a(i);
            }

            public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
                return c0433a.mo344a(str, i);
            }

            public boolean performAction(int i, int i2, Bundle bundle) {
                return c0433a.mo345a(i, i2, bundle);
            }
        };
    }
}
