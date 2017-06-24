package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.Notification.InboxStyle;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.ah.C0199a;
import android.util.Log;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class al {
    private static final Object f844a = new Object();
    private static Field f845b;
    private static boolean f846c;
    private static final Object f847d = new Object();

    public static class C0219a implements ac, ad {
        private Builder f841a;
        private final Bundle f842b;
        private List<Bundle> f843c = new ArrayList();

        public C0219a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, int i4, CharSequence charSequence4, boolean z3, Bundle bundle, String str, boolean z4, String str2) {
            this.f841a = new Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & 128) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z2).setPriority(i4).setProgress(i2, i3, z);
            this.f842b = new Bundle();
            if (bundle != null) {
                this.f842b.putAll(bundle);
            }
            if (z3) {
                this.f842b.putBoolean("android.support.localOnly", true);
            }
            if (str != null) {
                this.f842b.putString("android.support.groupKey", str);
                if (z4) {
                    this.f842b.putBoolean("android.support.isGroupSummary", true);
                } else {
                    this.f842b.putBoolean("android.support.useSideChannel", true);
                }
            }
            if (str2 != null) {
                this.f842b.putString("android.support.sortKey", str2);
            }
        }

        public Builder mo175a() {
            return this.f841a;
        }

        public void mo176a(C0199a c0199a) {
            this.f843c.add(al.m1291a(this.f841a, c0199a));
        }

        public Notification mo177b() {
            Notification build = this.f841a.build();
            Bundle a = al.m1292a(build);
            Bundle bundle = new Bundle(this.f842b);
            for (String str : this.f842b.keySet()) {
                if (a.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            a.putAll(bundle);
            SparseArray a2 = al.m1293a(this.f843c);
            if (a2 != null) {
                al.m1292a(build).putSparseParcelableArray("android.support.actionExtras", a2);
            }
            return build;
        }
    }

    public static Bundle m1291a(Builder builder, C0199a c0199a) {
        builder.addAction(c0199a.mo169a(), c0199a.mo170b(), c0199a.mo171c());
        Bundle bundle = new Bundle(c0199a.mo172d());
        if (c0199a.mo173f() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", aq.m1312a(c0199a.mo173f()));
        }
        return bundle;
    }

    public static Bundle m1292a(Notification notification) {
        synchronized (f844a) {
            if (f846c) {
                return null;
            }
            try {
                if (f845b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (Bundle.class.isAssignableFrom(declaredField.getType())) {
                        declaredField.setAccessible(true);
                        f845b = declaredField;
                    } else {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f846c = true;
                        return null;
                    }
                }
                Bundle bundle = (Bundle) f845b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f845b.set(notification, bundle);
                }
                return bundle;
            } catch (Throwable e) {
                Log.e("NotificationCompat", "Unable to access notification extras", e);
                f846c = true;
                return null;
            } catch (Throwable e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                f846c = true;
                return null;
            }
        }
    }

    public static SparseArray<Bundle> m1293a(List<Bundle> list) {
        SparseArray<Bundle> sparseArray = null;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Bundle bundle = (Bundle) list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    public static void m1294a(ad adVar, CharSequence charSequence, boolean z, CharSequence charSequence2, Bitmap bitmap, Bitmap bitmap2, boolean z2) {
        BigPictureStyle bigPicture = new BigPictureStyle(adVar.mo175a()).setBigContentTitle(charSequence).bigPicture(bitmap);
        if (z2) {
            bigPicture.bigLargeIcon(bitmap2);
        }
        if (z) {
            bigPicture.setSummaryText(charSequence2);
        }
    }

    public static void m1295a(ad adVar, CharSequence charSequence, boolean z, CharSequence charSequence2, CharSequence charSequence3) {
        BigTextStyle bigText = new BigTextStyle(adVar.mo175a()).setBigContentTitle(charSequence).bigText(charSequence3);
        if (z) {
            bigText.setSummaryText(charSequence2);
        }
    }

    public static void m1296a(ad adVar, CharSequence charSequence, boolean z, CharSequence charSequence2, ArrayList<CharSequence> arrayList) {
        InboxStyle bigContentTitle = new InboxStyle(adVar.mo175a()).setBigContentTitle(charSequence);
        if (z) {
            bigContentTitle.setSummaryText(charSequence2);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            bigContentTitle.addLine((CharSequence) it.next());
        }
    }
}
