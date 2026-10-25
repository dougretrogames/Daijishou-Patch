package org.eclipse.jgit.internal.storage.pack;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import org.eclipse.jgit.errors.StoredObjectRepresentationNotAvailableException;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.BitmapIndex;
import org.eclipse.jgit.lib.ProgressMonitor;

/* JADX INFO: loaded from: classes5.dex */
public interface ObjectReuseAsIs {
    void copyObjectAsIs(PackOutputStream packOutputStream, ObjectToPack objectToPack, boolean z) throws StoredObjectRepresentationNotAvailableException, IOException;

    void copyPackAsIs(PackOutputStream packOutputStream, CachedPack cachedPack) throws IOException;

    Collection<CachedPack> getCachedPacksAndUpdate(BitmapIndex.BitmapBuilder bitmapBuilder) throws IOException;

    ObjectToPack newObjectToPack(AnyObjectId anyObjectId, int i);

    void selectObjectRepresentation(PackWriter packWriter, ProgressMonitor progressMonitor, Iterable<ObjectToPack> iterable) throws IOException;

    void writeObjects(PackOutputStream packOutputStream, List<ObjectToPack> list) throws IOException;
}
