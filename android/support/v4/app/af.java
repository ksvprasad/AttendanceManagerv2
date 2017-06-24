package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Action;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.ah.C0199a;
import android.widget.RemoteViews;
import java.util.ArrayList;

class af {

    public static class C0216a implements ac, ad {
        private Builder f837a;
        private Bundle f838b;

        public C0216a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2) {
            this.f837a = new Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & 128) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setGroup(str).setGroupSummary(z5).setSortKey(str2);
            this.f838b = new Bundle();
            if (bundle != null) {
                this.f838b.putAll(bundle);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                this.f838b.putStringArray("android.people", (String[]) arrayList.toArray(new String[arrayList.size()]));
            }
        }

        public Builder mo175a() {
            return this.f837a;
        }

        public void mo176a(C0199a c0199a) {
            af.m1279a(this.f837a, c0199a);
        }

        public Notification mo177b() {
            this.f837a.setExtras(this.f838b);
            return this.f837a.build();
        }
    }

    public static void m1279a(Builder builder, C0199a c0199a) {
        Action.Builder builder2 = new Action.Builder(c0199a.mo169a(), c0199a.mo170b(), c0199a.mo171c());
        if (c0199a.mo173f() != null) {
            for (RemoteInput addRemoteInput : ao.m1310a(c0199a.mo173f())) {
                builder2.addRemoteInput(addRemoteInput);
            }
        }
        if (c0199a.mo172d() != null) {
            builder2.addExtras(c0199a.mo172d());
        }
        builder.addAction(builder2.build());
    }
}
