package android.support.v4.p006e;

import android.os.AsyncTask;
import android.os.Build.VERSION;

public final class C0338a {
    public static <Params, Progress, Result> AsyncTask<Params, Progress, Result> m1827a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        if (asyncTask == null) {
            throw new IllegalArgumentException("task can not be null");
        }
        if (VERSION.SDK_INT >= 11) {
            C0339b.m1828a(asyncTask, paramsArr);
        } else {
            asyncTask.execute(paramsArr);
        }
        return asyncTask;
    }
}
