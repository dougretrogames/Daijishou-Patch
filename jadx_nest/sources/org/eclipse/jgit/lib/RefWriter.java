package org.eclipse.jgit.lib;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.eclipse.jgit.internal.storage.file.RefDirectory;
import org.eclipse.jgit.util.RefList;
import org.eclipse.jgit.util.RefMap;

/* JADX INFO: loaded from: classes5.dex */
public abstract class RefWriter {
    private final Collection<Ref> refs;

    protected abstract void writeFile(String str, byte[] bArr) throws IOException;

    public RefWriter(Collection<Ref> collection) {
        this.refs = RefComparator.sort(collection);
    }

    public RefWriter(Map<String, Ref> map) {
        if (map instanceof RefMap) {
            this.refs = map.values();
        } else {
            this.refs = RefComparator.sort(map.values());
        }
    }

    public RefWriter(RefList<Ref> refList) {
        this.refs = refList.asList();
    }

    public void writeInfoRefs() throws IOException {
        ObjectId objectId;
        StringWriter stringWriter = new StringWriter();
        char[] cArr = new char[40];
        for (Ref ref : this.refs) {
            if (!"HEAD".equals(ref.getName()) && (objectId = ref.getObjectId()) != null) {
                objectId.copyTo(cArr, stringWriter);
                stringWriter.write(9);
                stringWriter.write(ref.getName());
                stringWriter.write(10);
                ObjectId peeledObjectId = ref.getPeeledObjectId();
                if (peeledObjectId != null) {
                    peeledObjectId.copyTo(cArr, stringWriter);
                    stringWriter.write(9);
                    stringWriter.write(ref.getName());
                    stringWriter.write("^{}\n");
                }
            }
        }
        writeFile(Constants.INFO_REFS, Constants.encode(stringWriter.toString()));
    }

    public void writePackedRefs() throws IOException {
        boolean z;
        Iterator<Ref> it = this.refs.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            Ref next = it.next();
            if (next.getStorage().isPacked() && next.isPeeled()) {
                z = true;
                break;
            }
        }
        StringWriter stringWriter = new StringWriter();
        if (z) {
            stringWriter.write(RefDirectory.PACKED_REFS_HEADER);
            stringWriter.write(RefDirectory.PACKED_REFS_PEELED);
            stringWriter.write(10);
        }
        char[] cArr = new char[40];
        for (Ref ref : this.refs) {
            if (ref.getStorage() == Ref.Storage.PACKED) {
                ObjectId objectId = ref.getObjectId();
                objectId.getClass();
                objectId.copyTo(cArr, stringWriter);
                stringWriter.write(32);
                stringWriter.write(ref.getName());
                stringWriter.write(10);
                ObjectId peeledObjectId = ref.getPeeledObjectId();
                if (peeledObjectId != null) {
                    stringWriter.write(94);
                    peeledObjectId.copyTo(cArr, stringWriter);
                    stringWriter.write(10);
                }
            }
        }
        writeFile(Constants.PACKED_REFS, Constants.encode(stringWriter.toString()));
    }
}
