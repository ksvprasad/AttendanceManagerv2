package android.support.v4.p006e;

import android.os.AsyncTask;

class C0339b {
    static <Params, Progress, Result> void m1828a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramsArr);
    }
}
