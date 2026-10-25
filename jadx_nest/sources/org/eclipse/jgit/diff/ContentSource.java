package org.eclipse.jgit.diff;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.eclipse.jgit.errors.LargeObjectException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.ObjectStream;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.treewalk.WorkingTreeIterator;
import org.eclipse.jgit.treewalk.filter.PathFilter;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ContentSource {
    public void close() {
    }

    public boolean isWorkingTreeSource() {
        return false;
    }

    public abstract ObjectLoader open(String str, ObjectId objectId) throws IOException;

    public abstract long size(String str, ObjectId objectId) throws IOException;

    public static ContentSource create(ObjectReader objectReader) {
        return new ObjectReaderSource(objectReader);
    }

    public static ContentSource create(WorkingTreeIterator workingTreeIterator) {
        return new WorkingTreeSource(workingTreeIterator);
    }

    private static class ObjectReaderSource extends ContentSource {
        private final ObjectReader reader;

        @Override // org.eclipse.jgit.diff.ContentSource
        public boolean isWorkingTreeSource() {
            return false;
        }

        ObjectReaderSource(ObjectReader objectReader) {
            this.reader = objectReader;
        }

        @Override // org.eclipse.jgit.diff.ContentSource
        public long size(String str, ObjectId objectId) throws IOException {
            try {
                return this.reader.getObjectSize(objectId, 3);
            } catch (MissingObjectException unused) {
                return 0L;
            }
        }

        @Override // org.eclipse.jgit.diff.ContentSource
        public ObjectLoader open(String str, ObjectId objectId) throws IOException {
            return this.reader.open(objectId, 3);
        }

        @Override // org.eclipse.jgit.diff.ContentSource
        public void close() {
            this.reader.close();
        }
    }

    private static class WorkingTreeSource extends ContentSource {
        private String current;
        private final WorkingTreeIterator iterator;
        WorkingTreeIterator ptr;
        private final TreeWalk tw;

        @Override // org.eclipse.jgit.diff.ContentSource
        public boolean isWorkingTreeSource() {
            return true;
        }

        WorkingTreeSource(WorkingTreeIterator workingTreeIterator) {
            TreeWalk treeWalk = new TreeWalk(workingTreeIterator.getRepository(), null);
            this.tw = treeWalk;
            treeWalk.setRecursive(true);
            this.iterator = workingTreeIterator;
        }

        @Override // org.eclipse.jgit.diff.ContentSource
        public long size(String str, ObjectId objectId) throws IOException {
            seek(str);
            return this.ptr.getEntryLength();
        }

        @Override // org.eclipse.jgit.diff.ContentSource
        public ObjectLoader open(String str, ObjectId objectId) throws IOException {
            seek(str);
            return new AnonymousClass1(this.ptr.getEntryContentLength());
        }

        /* JADX INFO: renamed from: org.eclipse.jgit.diff.ContentSource$WorkingTreeSource$1, reason: invalid class name */
        class AnonymousClass1 extends ObjectLoader {
            private final /* synthetic */ long val$entrySize;

            @Override // org.eclipse.jgit.lib.ObjectLoader
            public boolean isLarge() {
                return true;
            }

            AnonymousClass1(long j) {
                this.val$entrySize = j;
            }

            @Override // org.eclipse.jgit.lib.ObjectLoader
            public long getSize() {
                return this.val$entrySize;
            }

            @Override // org.eclipse.jgit.lib.ObjectLoader
            public int getType() {
                return WorkingTreeSource.this.ptr.getEntryFileMode().getObjectType();
            }

            @Override // org.eclipse.jgit.lib.ObjectLoader
            public ObjectStream openStream() throws IOException {
                return new ObjectStream.Filter(getType(), this.val$entrySize, new BufferedInputStream(WorkingTreeSource.this.ptr.openEntryStream()));
            }

            @Override // org.eclipse.jgit.lib.ObjectLoader
            public byte[] getCachedBytes() throws LargeObjectException {
                throw new LargeObjectException();
            }
        }

        private void seek(String str) throws IOException {
            if (str.equals(this.current)) {
                return;
            }
            this.iterator.reset();
            this.iterator.setWalkIgnoredDirectories(true);
            this.iterator.setDirCacheIterator(null, -1);
            this.tw.reset();
            this.tw.addTree(this.iterator);
            this.tw.setFilter(PathFilter.create(str));
            this.current = str;
            if (!this.tw.next()) {
                throw new FileNotFoundException(str);
            }
            WorkingTreeIterator workingTreeIterator = (WorkingTreeIterator) this.tw.getTree(0, WorkingTreeIterator.class);
            this.ptr = workingTreeIterator;
            if (workingTreeIterator == null) {
                throw new FileNotFoundException(str);
            }
        }

        @Override // org.eclipse.jgit.diff.ContentSource
        public void close() {
            this.tw.close();
        }
    }

    public static final class Pair {
        private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$diff$DiffEntry$Side;
        private final ContentSource newSource;
        private final ContentSource oldSource;

        static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$diff$DiffEntry$Side() {
            int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$diff$DiffEntry$Side;
            if (iArr != null) {
                return iArr;
            }
            int[] iArr2 = new int[DiffEntry.Side.valuesCustom().length];
            try {
                iArr2[DiffEntry.Side.NEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr2[DiffEntry.Side.OLD.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            $SWITCH_TABLE$org$eclipse$jgit$diff$DiffEntry$Side = iArr2;
            return iArr2;
        }

        public Pair(ContentSource contentSource, ContentSource contentSource2) {
            this.oldSource = contentSource;
            this.newSource = contentSource2;
        }

        public long size(DiffEntry.Side side, DiffEntry diffEntry) throws IOException {
            int i = $SWITCH_TABLE$org$eclipse$jgit$diff$DiffEntry$Side()[side.ordinal()];
            if (i == 1) {
                return this.oldSource.size(diffEntry.oldPath, diffEntry.oldId.toObjectId());
            }
            if (i == 2) {
                return this.newSource.size(diffEntry.newPath, diffEntry.newId.toObjectId());
            }
            throw new IllegalArgumentException();
        }

        public ObjectLoader open(DiffEntry.Side side, DiffEntry diffEntry) throws IOException {
            int i = $SWITCH_TABLE$org$eclipse$jgit$diff$DiffEntry$Side()[side.ordinal()];
            if (i == 1) {
                return this.oldSource.open(diffEntry.oldPath, diffEntry.oldId.toObjectId());
            }
            if (i == 2) {
                return this.newSource.open(diffEntry.newPath, diffEntry.newId.toObjectId());
            }
            throw new IllegalArgumentException();
        }

        public void close() {
            this.oldSource.close();
            this.newSource.close();
        }

        public boolean isWorkingTreeSource(DiffEntry.Side side) {
            int i = $SWITCH_TABLE$org$eclipse$jgit$diff$DiffEntry$Side()[side.ordinal()];
            if (i == 1) {
                return this.oldSource.isWorkingTreeSource();
            }
            if (i == 2) {
                return this.newSource.isWorkingTreeSource();
            }
            throw new IllegalArgumentException();
        }
    }
}
