package org.eclipse.jgit.transport;

import org.eclipse.jgit.storage.pack.PackStatistics;

/* INFO: loaded from: classes5.dex */
public interface PostUploadHook {
    public static final PostUploadHook NULL = new PostUploadHook$$ExternalSyntheticLambda0();

    static /* synthetic */ void lambda$0(PackStatistics packStatistics) {
    }

    void onPostUpload(PackStatistics packStatistics);
}
