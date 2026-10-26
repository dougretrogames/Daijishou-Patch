package org.eclipse.jgit.internal.storage.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.MutableObjectId;
import org.eclipse.jgit.lib.ObjectIdOwnerMap;
import org.eclipse.jgit.lib.ObjectIdSet;

/* INFO: loaded from: classes5.dex */
public class LazyObjectIdSetFile implements ObjectIdSet {
    private ObjectIdOwnerMap<Entry> set;
    private final File src;

    public LazyObjectIdSetFile(File file) {
        this.src = file;
    }

    @Override // org.eclipse.jgit.lib.ObjectIdSet
    public boolean contains(AnyObjectId anyObjectId) {
        if (this.set == null) {
            this.set = load();
        }
        return this.set.contains(anyObjectId);
    }

    private ObjectIdOwnerMap<Entry> load() {
        ObjectIdOwnerMap<Entry> objectIdOwnerMap = new ObjectIdOwnerMap<>();
        Throwable th = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(this.src);
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                try {
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    try {
                        MutableObjectId mutableObjectId = new MutableObjectId();
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line != null) {
                                mutableObjectId.fromString(line);
                                if (!objectIdOwnerMap.contains(mutableObjectId)) {
                                    objectIdOwnerMap.add(new Entry(mutableObjectId));
                                }
                            } else {
                                bufferedReader.close();
                                inputStreamReader.close();
                                fileInputStream.close();
                                return objectIdOwnerMap;
                            }
                        }
                    } catch (Throwable th2) {
                        bufferedReader.close();
                        throw th2;
                    }
                } catch (Throwable th3) {
                    if (0 == 0) {
                        th = th3;
                    } else if (null != th3) {
                        th.addSuppressed(th3);
                    }
                    inputStreamReader.close();
                    throw th;
                }
            } catch (Throwable th4) {
                if (0 == 0) {
                    th = th4;
                } else if (null != th4) {
                    th.addSuppressed(th4);
                }
                fileInputStream.close();
                throw th;
            }
        } catch (Throwable th5) {
            if (0 == 0) {
                throw th5;
            }
            if (null == th5) {
                throw null;
            }
            try {
                th.addSuppressed(th5);
                throw null;
            } catch (IOException unused) {
                return objectIdOwnerMap;
            }
            return objectIdOwnerMap;
        }
    }

    static class Entry extends ObjectIdOwnerMap.Entry {
        Entry(AnyObjectId anyObjectId) {
            super(anyObjectId);
        }
    }
}
