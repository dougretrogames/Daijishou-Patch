package androidx.leanback.app;

import android.app.Fragment;

/* JADX INFO: loaded from: classes.dex */
public class PermissionHelper {
    public static void requestPermissions(Fragment fragment, String[] strArr, int i) {
        fragment.requestPermissions(strArr, i);
    }

    private PermissionHelper() {
    }
}
