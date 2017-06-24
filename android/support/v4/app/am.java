package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.ah.C0199a;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;

class am {

    public static class C0220a implements ac, ad {
        private Builder f848a;
        private Bundle f849b;
        private List<Bundle> f850c = new ArrayList();

        public C0220a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2) {
            this.f848a = new Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & 128) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z);
            this.f849b = new Bundle();
            if (bundle != null) {
                this.f849b.putAll(bundle);
            }
            if (!(arrayList == null || arrayList.isEmpty())) {
                this.f849b.putStringArray("android.people", (String[]) arrayList.toArray(new String[arrayList.size()]));
            }
            if (z4) {
                this.f849b.putBoolean("android.support.localOnly", true);
            }
            if (str != null) {
                this.f849b.putString("android.support.groupKey", str);
                if (z5) {
                    this.f849b.putBoolean("android.support.isGroupSummary", true);
                } else {
                    this.f849b.putBoolean("android.support.useSideChannel", true);
                }
            }
            if (str2 != null) {
                this.f849b.putString("android.support.sortKey", str2);
            }
        }

        public Builder mo175a() {
            return this.f848a;
        }

        public void mo176a(C0199a c0199a) {
            this.f850c.add(al.m1291a(this.f848a, c0199a));
        }

        public Notification mo177b() {
            SparseArray a = al.m1293a(this.f850c);
            if (a != null) {
                this.f849b.putSparseParcelableArray("android.support.actionExtras", a);
            }
            this.f848a.setExtras(this.f849b);
            return this.f848a.build();
        }
    }
}
