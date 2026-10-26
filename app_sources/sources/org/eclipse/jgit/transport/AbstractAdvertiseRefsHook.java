package org.eclipse.jgit.transport;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevWalk;

/* INFO: loaded from: classes5.dex */
public abstract class AbstractAdvertiseRefsHook implements AdvertiseRefsHook {
    protected Set<ObjectId> getAdvertisedHaves(Repository repository, RevWalk revWalk) throws ServiceMayNotContinueException {
        return null;
    }

    protected abstract Map<String, Ref> getAdvertisedRefs(Repository repository, RevWalk revWalk) throws ServiceMayNotContinueException;

    @Override // org.eclipse.jgit.transport.AdvertiseRefsHook
    public void advertiseRefs(UploadPack uploadPack) throws ServiceMayNotContinueException {
        uploadPack.setAdvertisedRefs(getAdvertisedRefs(uploadPack.getRepository(), uploadPack.getRevWalk()));
    }

    @Override // org.eclipse.jgit.transport.AdvertiseRefsHook
    public void advertiseRefs(ReceivePack receivePack) throws IOException {
        receivePack.setAdvertisedRefs(getAdvertisedRefs(receivePack.getRepository(), receivePack.getRevWalk()), getAdvertisedHaves(receivePack.getRepository(), receivePack.getRevWalk()));
    }
}
