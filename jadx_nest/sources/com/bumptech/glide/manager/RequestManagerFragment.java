package com.bumptech.glide.manager;

import android.app.Fragment;
import com.bumptech.glide.RequestManager;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class RequestManagerFragment extends Fragment {
    @Deprecated
    public RequestManager getRequestManager() {
        return null;
    }

    @Deprecated
    public void setRequestManager(RequestManager requestManager) {
    }

    /* JADX INFO: renamed from: com.bumptech.glide.manager.RequestManagerFragment$1, reason: invalid class name */
    class AnonymousClass1 implements RequestManagerTreeNode {
        AnonymousClass1() {
        }

        @Override // com.bumptech.glide.manager.RequestManagerTreeNode
        public Set<RequestManager> getDescendants() {
            return Collections.emptySet();
        }
    }

    @Deprecated
    public RequestManagerTreeNode getRequestManagerTreeNode() {
        return new AnonymousClass1();
    }
}
