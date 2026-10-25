package org.eclipse.jgit.internal.storage.dfs;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.transport.BundleWriter;

/* JADX INFO: loaded from: classes5.dex */
public class DfsBundleWriter {
    public static void writeEntireRepositoryAsBundle(ProgressMonitor progressMonitor, OutputStream outputStream, DfsRepository dfsRepository) throws IOException {
        BundleWriter bundleWriter = new BundleWriter(dfsRepository);
        dfsRepository.getRefDatabase().getRefs().forEach(new DfsBundleWriter$$ExternalSyntheticLambda0(bundleWriter));
        ArrayList arrayList = new ArrayList();
        for (DfsPackFile dfsPackFile : dfsRepository.getObjectDatabase().getPacks()) {
            arrayList.add(new DfsCachedPack(dfsPackFile));
        }
        bundleWriter.addObjectsAsIs(arrayList);
        bundleWriter.writeBundle(progressMonitor, outputStream);
    }

    private DfsBundleWriter() {
    }
}
