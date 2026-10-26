package org.eclipse.jgit.internal.fsck;

import java.util.HashSet;
import java.util.Set;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.errors.CorruptPackIndexException;
import org.eclipse.jgit.lib.ObjectChecker;
import org.eclipse.jgit.lib.ObjectId;

/* INFO: loaded from: classes5.dex */
public class FsckError {
    private final Set<CorruptObject> corruptObjects = new HashSet();
    private final Set<ObjectId> missingObjects = new HashSet();
    private final Set<CorruptIndex> corruptIndices = new HashSet();
    private final Set<String> nonCommitHeads = new HashSet();

    public static class CorruptObject {

        @Nullable
        final ObjectChecker.ErrorType errorType;

        /* INFO: renamed from: id, reason: collision with root package name */
        final ObjectId f115id;
        final int type;

        public CorruptObject(ObjectId objectId, int i, @Nullable ObjectChecker.ErrorType errorType) {
            this.f115id = objectId;
            this.type = i;
            this.errorType = errorType;
        }

        public ObjectId getId() {
            return this.f115id;
        }

        public int getType() {
            return this.type;
        }

        @Nullable
        public ObjectChecker.ErrorType getErrorType() {
            return this.errorType;
        }
    }

    public static class CorruptIndex {
        CorruptPackIndexException.ErrorType errorType;
        String fileName;

        public CorruptIndex(String str, CorruptPackIndexException.ErrorType errorType) {
            this.fileName = str;
            this.errorType = errorType;
        }

        public String getFileName() {
            return this.fileName;
        }

        public CorruptPackIndexException.ErrorType getErrorType() {
            return this.errorType;
        }
    }

    public Set<CorruptObject> getCorruptObjects() {
        return this.corruptObjects;
    }

    public Set<ObjectId> getMissingObjects() {
        return this.missingObjects;
    }

    public Set<CorruptIndex> getCorruptIndices() {
        return this.corruptIndices;
    }

    public Set<String> getNonCommitHeads() {
        return this.nonCommitHeads;
    }
}
