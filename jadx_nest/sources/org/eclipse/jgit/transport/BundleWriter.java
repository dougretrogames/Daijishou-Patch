package org.eclipse.jgit.transport;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.pack.CachedPack;
import org.eclipse.jgit.internal.storage.pack.PackWriter;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.storage.pack.PackConfig;

/* JADX INFO: loaded from: classes5.dex */
public class BundleWriter {
    private final Set<RevCommit> assume;
    private final List<CachedPack> cachedPacks;
    private ObjectCountCallback callback;
    private final Repository db;
    private final Map<String, ObjectId> include;
    private PackConfig packConfig;
    private final ObjectReader reader;
    private final Set<ObjectId> tagTargets;

    public BundleWriter(Repository repository) {
        this.cachedPacks = new ArrayList();
        this.db = repository;
        this.reader = null;
        this.include = new TreeMap();
        this.assume = new HashSet();
        this.tagTargets = new HashSet();
    }

    public BundleWriter(ObjectReader objectReader) {
        this.cachedPacks = new ArrayList();
        this.db = null;
        this.reader = objectReader;
        this.include = new TreeMap();
        this.assume = new HashSet();
        this.tagTargets = new HashSet();
    }

    public void setPackConfig(PackConfig packConfig) {
        this.packConfig = packConfig;
    }

    public void include(String str, AnyObjectId anyObjectId) {
        if (!Repository.isValidRefName(str) && !"HEAD".equals(str)) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().invalidRefName, str));
        }
        if (this.include.containsKey(str)) {
            throw new IllegalStateException(JGitText.get().duplicateRef + str);
        }
        this.include.put(str, anyObjectId.toObjectId());
    }

    public void include(Ref ref) {
        include(ref.getName(), ref.getObjectId());
        if (ref.getPeeledObjectId() != null) {
            this.tagTargets.add(ref.getPeeledObjectId());
        } else {
            if (ref.getObjectId() == null || !ref.getName().startsWith(Constants.R_HEADS)) {
                return;
            }
            this.tagTargets.add(ref.getObjectId());
        }
    }

    public void addObjectsAsIs(Collection<? extends CachedPack> collection) {
        this.cachedPacks.addAll(collection);
    }

    public void assume(RevCommit revCommit) {
        if (revCommit != null) {
            this.assume.add(revCommit);
        }
    }

    public void writeBundle(ProgressMonitor progressMonitor, OutputStream outputStream) throws IOException {
        Throwable th = null;
        try {
            PackWriter packWriterNewPackWriter = newPackWriter();
            try {
                packWriterNewPackWriter.setObjectCountCallback(this.callback);
                packWriterNewPackWriter.setIndexDisabled(true);
                packWriterNewPackWriter.setDeltaBaseAsOffset(true);
                packWriterNewPackWriter.setReuseValidatingObjects(false);
                if (this.cachedPacks.isEmpty()) {
                    HashSet hashSet = new HashSet();
                    HashSet hashSet2 = new HashSet();
                    hashSet.addAll(this.include.values());
                    Iterator<RevCommit> it = this.assume.iterator();
                    while (it.hasNext()) {
                        hashSet2.add(it.next().getId());
                    }
                    if (hashSet2.isEmpty()) {
                        packWriterNewPackWriter.setTagTargets(this.tagTargets);
                    }
                    packWriterNewPackWriter.setThin(true ^ hashSet2.isEmpty());
                    packWriterNewPackWriter.preparePack(progressMonitor, hashSet, hashSet2);
                } else {
                    packWriterNewPackWriter.preparePack(this.cachedPacks);
                }
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
                outputStreamWriter.write(TransportBundle.V2_BUNDLE_SIGNATURE);
                outputStreamWriter.write(10);
                char[] cArr = new char[40];
                for (RevCommit revCommit : this.assume) {
                    outputStreamWriter.write(45);
                    revCommit.copyTo(cArr, outputStreamWriter);
                    if (revCommit.getRawBuffer() != null) {
                        outputStreamWriter.write(32);
                        outputStreamWriter.write(revCommit.getShortMessage());
                    }
                    outputStreamWriter.write(10);
                }
                for (Map.Entry<String, ObjectId> entry : this.include.entrySet()) {
                    entry.getValue().copyTo(cArr, outputStreamWriter);
                    outputStreamWriter.write(32);
                    outputStreamWriter.write(entry.getKey());
                    outputStreamWriter.write(10);
                }
                outputStreamWriter.write(10);
                outputStreamWriter.flush();
                packWriterNewPackWriter.writePack(progressMonitor, progressMonitor, outputStream);
            } finally {
                if (packWriterNewPackWriter != null) {
                    packWriterNewPackWriter.close();
                }
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                th.addSuppressed(th2);
            }
            throw null;
        }
    }

    private PackWriter newPackWriter() {
        PackConfig packConfig = this.packConfig;
        if (packConfig == null) {
            packConfig = this.db != null ? new PackConfig(this.db) : new PackConfig();
        }
        ObjectReader objectReaderNewObjectReader = this.reader;
        if (objectReaderNewObjectReader == null) {
            objectReaderNewObjectReader = this.db.newObjectReader();
        }
        return new PackWriter(packConfig, objectReaderNewObjectReader);
    }

    public BundleWriter setObjectCountCallback(ObjectCountCallback objectCountCallback) {
        this.callback = objectCountCallback;
        return this;
    }
}
