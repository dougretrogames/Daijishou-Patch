package org.eclipse.jgit.transport;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import org.eclipse.jgit.storage.pack.PackStatistics;

/* INFO: loaded from: classes5.dex */
public class PostUploadHookChain implements PostUploadHook {
    private final List<PostUploadHook> hooks;

    public static PostUploadHook newChain(List<PostUploadHook> list) {
        List list2 = (List) list.stream().filter(new PostUploadHookChain$$ExternalSyntheticLambda0()).collect(Collectors.toList());
        if (list2.isEmpty()) {
            return PostUploadHook.NULL;
        }
        if (list2.size() == 1) {
            return (PostUploadHook) list2.get(0);
        }
        return new PostUploadHookChain(list2);
    }

    static /* synthetic */ boolean lambda$0(PostUploadHook postUploadHook) {
        return !postUploadHook.equals(PostUploadHook.NULL);
    }

    @Override // org.eclipse.jgit.transport.PostUploadHook
    public void onPostUpload(PackStatistics packStatistics) {
        Iterator<PostUploadHook> it = this.hooks.iterator();
        while (it.hasNext()) {
            it.next().onPostUpload(packStatistics);
        }
    }

    private PostUploadHookChain(List<PostUploadHook> list) {
        this.hooks = Collections.unmodifiableList(list);
    }
}
