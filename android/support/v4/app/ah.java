package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ap.C0227a;

public class ah {

    public static abstract class C0199a {

        public interface C0197a {
        }

        public abstract int mo169a();

        public abstract CharSequence mo170b();

        public abstract PendingIntent mo171c();

        public abstract Bundle mo172d();

        public abstract C0227a[] mo173f();
    }

    public static Notification m1283a(Notification notification, Context context, CharSequence charSequence, CharSequence charSequence2, PendingIntent pendingIntent) {
        notification.setLatestEventInfo(context, charSequence, charSequence2, pendingIntent);
        return notification;
    }
}
