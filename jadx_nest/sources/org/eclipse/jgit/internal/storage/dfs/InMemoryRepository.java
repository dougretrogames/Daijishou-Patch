package org.eclipse.jgit.internal.storage.dfs;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.internal.storage.pack.PackExt;
import org.eclipse.jgit.internal.storage.reftable.ReftableConfig;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.RefDatabase;

/* JADX INFO: loaded from: classes5.dex */
public class InMemoryRepository extends DfsRepository {
    static final AtomicInteger packId = new AtomicInteger();
    private String gitwebDescription;
    private final MemObjDatabase objdb;
    private final MemRefDatabase refdb;

    public static class Builder extends DfsRepositoryBuilder<Builder, InMemoryRepository> {
        @Override // org.eclipse.jgit.internal.storage.dfs.DfsRepositoryBuilder, org.eclipse.jgit.lib.BaseRepositoryBuilder
        public InMemoryRepository build() throws IOException {
            return new InMemoryRepository(this);
        }
    }

    public InMemoryRepository(DfsRepositoryDescription dfsRepositoryDescription) {
        this(new Builder().setRepositoryDescription(dfsRepositoryDescription));
    }

    InMemoryRepository(Builder builder) {
        super(builder);
        this.objdb = new MemObjDatabase(this);
        this.refdb = createRefDatabase();
    }

    protected MemRefDatabase createRefDatabase() {
        return new MemRefDatabase();
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsRepository, org.eclipse.jgit.lib.Repository
    public MemObjDatabase getObjectDatabase() {
        return this.objdb;
    }

    @Override // org.eclipse.jgit.lib.Repository
    public RefDatabase getRefDatabase() {
        return this.refdb;
    }

    public void setPerformsAtomicTransactions(boolean z) {
        this.refdb.performsAtomicTransactions = z;
    }

    @Override // org.eclipse.jgit.lib.Repository
    @Nullable
    public String getGitwebDescription() {
        return this.gitwebDescription;
    }

    @Override // org.eclipse.jgit.lib.Repository
    public void setGitwebDescription(@Nullable String str) {
        this.gitwebDescription = str;
    }

    public static class MemObjDatabase extends DfsObjDatabase {
        private int blockSize;
        private List<DfsPackDescription> packs;
        private Set<ObjectId> shallowCommits;

        @Override // org.eclipse.jgit.internal.storage.dfs.DfsObjDatabase
        protected void rollbackPack(Collection<DfsPackDescription> collection) {
        }

        MemObjDatabase(DfsRepository dfsRepository) {
            super(dfsRepository, new DfsReaderOptions());
            this.packs = new ArrayList();
            this.shallowCommits = Collections.emptySet();
        }

        public void setReadableChannelBlockSizeForTest(int i) {
            this.blockSize = i;
        }

        @Override // org.eclipse.jgit.internal.storage.dfs.DfsObjDatabase
        protected synchronized List<DfsPackDescription> listPacks() {
            return this.packs;
        }

        @Override // org.eclipse.jgit.internal.storage.dfs.DfsObjDatabase
        protected DfsPackDescription newPack(DfsObjDatabase.PackSource packSource) {
            return new MemPack("pack-" + InMemoryRepository.packId.incrementAndGet() + "-" + packSource.name(), getRepository().getDescription(), packSource);
        }

        @Override // org.eclipse.jgit.internal.storage.dfs.DfsObjDatabase
        protected synchronized void commitPackImpl(Collection<DfsPackDescription> collection, Collection<DfsPackDescription> collection2) {
            ArrayList arrayList = new ArrayList(collection.size() + this.packs.size());
            arrayList.addAll(collection);
            arrayList.addAll(this.packs);
            if (collection2 != null) {
                arrayList.removeAll(collection2);
            }
            this.packs = arrayList;
            clearCache();
        }

        @Override // org.eclipse.jgit.internal.storage.dfs.DfsObjDatabase
        protected ReadableChannel openFile(DfsPackDescription dfsPackDescription, PackExt packExt) throws IOException {
            byte[] bArr = ((MemPack) dfsPackDescription).get(packExt);
            if (bArr == null) {
                throw new FileNotFoundException(dfsPackDescription.getFileName(packExt));
            }
            return new ByteArrayReadableChannel(bArr, this.blockSize);
        }

        /* JADX INFO: renamed from: org.eclipse.jgit.internal.storage.dfs.InMemoryRepository$MemObjDatabase$1, reason: invalid class name */
        class AnonymousClass1 extends Out {
            private final /* synthetic */ PackExt val$ext;
            private final /* synthetic */ MemPack val$memPack;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(MemPack memPack, PackExt packExt) {
                super(null);
                this.val$memPack = memPack;
                this.val$ext = packExt;
            }

            @Override // org.eclipse.jgit.internal.storage.dfs.InMemoryRepository.Out, java.io.OutputStream, java.io.Flushable
            public void flush() {
                this.val$memPack.put(this.val$ext, getData());
            }
        }

        @Override // org.eclipse.jgit.internal.storage.dfs.DfsObjDatabase
        protected DfsOutputStream writeFile(DfsPackDescription dfsPackDescription, PackExt packExt) throws IOException {
            return new AnonymousClass1((MemPack) dfsPackDescription, packExt);
        }

        @Override // org.eclipse.jgit.lib.ObjectDatabase
        public Set<ObjectId> getShallowCommits() throws IOException {
            return this.shallowCommits;
        }

        @Override // org.eclipse.jgit.lib.ObjectDatabase
        public void setShallowCommits(Set<ObjectId> set) {
            this.shallowCommits = set;
        }

        @Override // org.eclipse.jgit.lib.ObjectDatabase
        public long getApproximateObjectCount() {
            Iterator<DfsPackDescription> it = this.packs.iterator();
            long objectCount = 0;
            while (it.hasNext()) {
                objectCount += it.next().getObjectCount();
            }
            return objectCount;
        }
    }

    private static class MemPack extends DfsPackDescription {
        final byte[][] fileMap;

        MemPack(String str, DfsRepositoryDescription dfsRepositoryDescription, DfsObjDatabase.PackSource packSource) {
            super(dfsRepositoryDescription, str, packSource);
            this.fileMap = new byte[PackExt.valuesCustom().length][];
        }

        void put(PackExt packExt, byte[] bArr) {
            this.fileMap[packExt.getPosition()] = bArr;
        }

        byte[] get(PackExt packExt) {
            return this.fileMap[packExt.getPosition()];
        }
    }

    private static abstract class Out extends DfsOutputStream {
        private byte[] data;
        private final ByteArrayOutputStream dst;

        /* synthetic */ Out(InMemoryRepositoryIA inMemoryRepositoryIA) {
            this();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public abstract void flush();

        private Out() {
            this.dst = new ByteArrayOutputStream();
        }

        @Override // org.eclipse.jgit.internal.storage.dfs.DfsOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            this.data = null;
            this.dst.write(bArr, i, i2);
        }

        @Override // org.eclipse.jgit.internal.storage.dfs.DfsOutputStream
        public int read(long j, ByteBuffer byteBuffer) {
            byte[] data = getData();
            int i = (int) j;
            int iMin = Math.min(byteBuffer.remaining(), data.length - i);
            if (iMin == 0) {
                return -1;
            }
            byteBuffer.put(data, i, iMin);
            return iMin;
        }

        byte[] getData() {
            if (this.data == null) {
                this.data = this.dst.toByteArray();
            }
            return this.data;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            flush();
        }
    }

    private static class ByteArrayReadableChannel implements ReadableChannel {
        private final int blockSize;
        private final byte[] data;
        private boolean open = true;
        private int position;

        @Override // org.eclipse.jgit.internal.storage.dfs.ReadableChannel
        public void setReadAheadBytes(int i) {
        }

        ByteArrayReadableChannel(byte[] bArr, int i) {
            this.data = bArr;
            this.blockSize = i;
        }

        @Override // java.nio.channels.ReadableByteChannel
        public int read(ByteBuffer byteBuffer) {
            int iMin = Math.min(byteBuffer.remaining(), this.data.length - this.position);
            if (iMin == 0) {
                return -1;
            }
            byteBuffer.put(this.data, this.position, iMin);
            this.position += iMin;
            return iMin;
        }

        @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.open = false;
        }

        @Override // java.nio.channels.Channel
        public boolean isOpen() {
            return this.open;
        }

        @Override // org.eclipse.jgit.internal.storage.dfs.ReadableChannel
        public long position() {
            return this.position;
        }

        @Override // org.eclipse.jgit.internal.storage.dfs.ReadableChannel
        public void position(long j) {
            this.position = (int) j;
        }

        @Override // org.eclipse.jgit.internal.storage.dfs.ReadableChannel
        public long size() {
            return this.data.length;
        }

        @Override // org.eclipse.jgit.internal.storage.dfs.ReadableChannel
        public int blockSize() {
            return this.blockSize;
        }
    }

    protected class MemRefDatabase extends DfsReftableDatabase {
        boolean performsAtomicTransactions;

        protected MemRefDatabase() {
            super(InMemoryRepository.this);
            this.performsAtomicTransactions = true;
        }

        @Override // org.eclipse.jgit.internal.storage.dfs.DfsReftableDatabase
        public ReftableConfig getReftableConfig() {
            ReftableConfig reftableConfig = new ReftableConfig();
            reftableConfig.setAlignBlocks(false);
            reftableConfig.setIndexObjects(false);
            reftableConfig.fromConfig(getRepository().getConfig());
            return reftableConfig;
        }

        @Override // org.eclipse.jgit.internal.storage.dfs.DfsReftableDatabase, org.eclipse.jgit.lib.RefDatabase
        public boolean performsAtomicTransactions() {
            return this.performsAtomicTransactions;
        }
    }
}
