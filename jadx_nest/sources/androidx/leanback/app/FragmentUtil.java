package androidx.leanback.app;

import android.app.Fragment;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
class FragmentUtil {
    static Context getContext(Fragment fragment) {
        return Api23Impl.getContext(fragment);
    }

    private FragmentUtil() {
    }

    private static class Api23Impl {
        private Api23Impl() {
        }

        static Context getContext(Fragment fragment) {
            return fragment.getContext();
        }
    }
}
