package org.eclipse.jgit.internal.storage.dfs;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.eclipse.jgit.internal.storage.io.BlockSource;
import org.eclipse.jgit.internal.storage.pack.PackExt;
import org.eclipse.jgit.internal.storage.reftable.ReftableBatchRefUpdate;
import org.eclipse.jgit.internal.storage.reftable.ReftableCompactor;
import org.eclipse.jgit.internal.storage.reftable.ReftableConfig;
import org.eclipse.jgit.internal.storage.reftable.ReftableReader;
import org.eclipse.jgit.internal.storage.reftable.ReftableWriter;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.transport.ReceiveCommand;

/* INFO: loaded from: classes5.dex */
public class DfsReftableBatchRefUpdate extends ReftableBatchRefUpdate {
    private static final int AVG_BYTES = 36;
    private final DfsObjDatabase odb;
    private final DfsReftableDatabase refdb;

    protected DfsReftableBatchRefUpdate(DfsReftableDatabase dfsReftableDatabase, DfsObjDatabase dfsObjDatabase) {
        super(dfsReftableDatabase, dfsReftableDatabase.reftableDatabase, dfsReftableDatabase.getLock(), dfsReftableDatabase.getRepository());
        this.refdb = dfsReftableDatabase;
        this.odb = dfsObjDatabase;
    }

    @Override // org.eclipse.jgit.internal.storage.reftable.ReftableBatchRefUpdate
    protected void applyUpdates(List<Ref> list, List<ReceiveCommand> list2) throws IOException {
        ReftableWriter.Stats stats;
        Set<DfsPackDescription> setEmptySet = Collections.emptySet();
        DfsPackDescription dfsPackDescriptionNewPack = this.odb.newPack(DfsObjDatabase.PackSource.INSERT);
        Throwable th = null;
        try {
            DfsOutputStream dfsOutputStreamWriteFile = this.odb.writeFile(dfsPackDescriptionNewPack, PackExt.REFTABLE);
            try {
                ReftableConfig reftableConfigConfigureReftable = DfsPackCompactor.configureReftable(this.refdb.getReftableConfig(), dfsOutputStreamWriteFile);
                if (this.refdb.compactDuringCommit() && list.size() * 36 <= reftableConfigConfigureReftable.getRefBlockSize() && canCompactTopOfStack(reftableConfigConfigureReftable)) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ReftableWriter reftableWriter = new ReftableWriter(reftableConfigConfigureReftable, byteArrayOutputStream);
                    write(reftableWriter, list, list2);
                    reftableWriter.finish();
                    stats = compactTopOfStack(dfsOutputStreamWriteFile, reftableConfigConfigureReftable, byteArrayOutputStream.toByteArray());
                    setEmptySet = toPruneTopOfStack();
                } else {
                    ReftableWriter reftableWriter2 = new ReftableWriter(reftableConfigConfigureReftable, dfsOutputStreamWriteFile);
                    write(reftableWriter2, list, list2);
                    reftableWriter2.finish();
                    stats = reftableWriter2.getStats();
                }
                dfsPackDescriptionNewPack.addFileExt(PackExt.REFTABLE);
                dfsPackDescriptionNewPack.setReftableStats(stats);
                if (dfsOutputStreamWriteFile != null) {
                    dfsOutputStreamWriteFile.close();
                }
                this.odb.commitPack(Collections.singleton(dfsPackDescriptionNewPack), setEmptySet);
                this.odb.addReftable(dfsPackDescriptionNewPack, setEmptySet);
                this.refdb.clearCache();
            } catch (Throwable th2) {
                if (dfsOutputStreamWriteFile == null) {
                    throw th2;
                }
                dfsOutputStreamWriteFile.close();
                throw th2;
            }
        } catch (Throwable th3) {
            if (0 == 0) {
                throw th3;
            }
            if (null != th3) {
                th.addSuppressed(th3);
            }
            throw null;
        }
    }

    private boolean canCompactTopOfStack(ReftableConfig reftableConfig) throws IOException {
        this.refdb.getLock().lock();
        try {
            DfsReftableStack dfsReftableStackStack = this.refdb.stack();
            List<ReftableReader> list = dfsReftableStackStack.readers();
            boolean z = false;
            if (!list.isEmpty()) {
                int size = list.size() - 1;
                DfsPackDescription packDescription = dfsReftableStackStack.files().get(size).getPackDescription();
                if (packDescription.getPackSource() == DfsObjDatabase.PackSource.INSERT && packOnlyContainsReftable(packDescription)) {
                    if (list.get(size).size() <= reftableConfig.getRefBlockSize() * 3) {
                        z = true;
                    }
                }
            }
            return z;
        } finally {
            this.refdb.getLock().unlock();
        }
    }

    private ReftableWriter.Stats compactTopOfStack(OutputStream outputStream, ReftableConfig reftableConfig, byte[] bArr) throws IOException {
        this.refdb.getLock().lock();
        try {
            List<ReftableReader> list = this.refdb.stack().readers();
            ReftableReader reftableReader = list.get(list.size() - 1);
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(reftableReader);
            arrayList.add(new ReftableReader(BlockSource.from(bArr)));
            ReftableCompactor reftableCompactor = new ReftableCompactor(outputStream);
            reftableCompactor.setConfig(reftableConfig);
            reftableCompactor.setIncludeDeletes(true);
            reftableCompactor.addAll(arrayList);
            reftableCompactor.compact();
            return reftableCompactor.getStats();
        } finally {
            this.refdb.getLock().unlock();
        }
    }

    private Set<DfsPackDescription> toPruneTopOfStack() throws IOException {
        this.refdb.getLock().lock();
        try {
            List<DfsReftable> listFiles = this.refdb.stack().files();
            return Collections.singleton(listFiles.get(listFiles.size() - 1).getPackDescription());
        } finally {
            this.refdb.getLock().unlock();
        }
    }

    private boolean packOnlyContainsReftable(DfsPackDescription dfsPackDescription) {
        for (PackExt packExt : PackExt.valuesCustom()) {
            if (packExt != PackExt.REFTABLE && dfsPackDescription.hasFileExt(packExt)) {
                return false;
            }
        }
        return true;
    }
}
