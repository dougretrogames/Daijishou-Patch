package org.eclipse.jgit.internal.storage.dfs;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import org.eclipse.jgit.errors.CorruptPackIndexException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.fsck.FsckError;
import org.eclipse.jgit.internal.fsck.FsckPackParser;
import org.eclipse.jgit.internal.storage.pack.PackExt;
import org.eclipse.jgit.internal.submodule.SubmoduleValidator;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.GitmoduleEntry;
import org.eclipse.jgit.lib.NullProgressMonitor;
import org.eclipse.jgit.lib.ObjectChecker;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.revwalk.ObjectWalk;
import org.eclipse.jgit.revwalk.RevObject;

/* JADX INFO: loaded from: classes5.dex */
public class DfsFsck {
    private boolean connectivityOnly;
    private ObjectChecker objChecker = new ObjectChecker();
    private final DfsObjDatabase objdb;
    private final DfsRepository repo;

    public DfsFsck(DfsRepository dfsRepository) {
        this.repo = dfsRepository;
        this.objdb = dfsRepository.getObjectDatabase();
    }

    public FsckError check(ProgressMonitor progressMonitor) throws IOException {
        if (progressMonitor == null) {
            progressMonitor = NullProgressMonitor.INSTANCE;
        }
        FsckError fsckError = new FsckError();
        if (!this.connectivityOnly) {
            this.objChecker.reset();
            checkPacks(progressMonitor, fsckError);
        }
        checkConnectivity(progressMonitor, fsckError);
        return fsckError;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0058 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:66:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private void checkPacks(ProgressMonitor progressMonitor, FsckError fsckError) throws IOException {
        ProgressMonitor progressMonitor2;
        FsckError fsckError2;
        Throwable th;
        Throwable th2;
        Throwable th3 = null;
        try {
            DfsReader dfsReaderNewReader = this.objdb.newReader();
            try {
                DfsPackFile[] packs = this.objdb.getPacks();
                int length = packs.length;
                int i = 0;
                while (i < length) {
                    DfsPackFile dfsPackFile = packs[i];
                    DfsPackDescription packDescription = dfsPackFile.getPackDescription();
                    if (packDescription.getPackSource() == DfsObjDatabase.PackSource.UNREACHABLE_GARBAGE) {
                        progressMonitor2 = progressMonitor;
                        fsckError2 = fsckError;
                    } else {
                        try {
                            ReadableChannel readableChannelOpenFile = this.objdb.openFile(packDescription, PackExt.PACK);
                            progressMonitor2 = progressMonitor;
                            fsckError2 = fsckError;
                            try {
                                verifyPack(progressMonitor2, fsckError2, dfsReaderNewReader, dfsPackFile, readableChannelOpenFile);
                                if (readableChannelOpenFile != null) {
                                    try {
                                        readableChannelOpenFile.close();
                                    } catch (Throwable th4) {
                                        th = th4;
                                        th2 = th;
                                        th = null;
                                        if (th != null) {
                                            if (th != th2) {
                                                try {
                                                    th.addSuppressed(th2);
                                                } catch (CorruptPackIndexException e) {
                                                    fsckError2.getCorruptIndices().add(new FsckError.CorruptIndex(dfsPackFile.getPackDescription().getFileName(PackExt.INDEX), e.getErrorType()));
                                                    i++;
                                                    progressMonitor = progressMonitor2;
                                                    fsckError = fsckError2;
                                                } catch (MissingObjectException e2) {
                                                    fsckError2.getMissingObjects().add(e2.getObjectId());
                                                    i++;
                                                    progressMonitor = progressMonitor2;
                                                    fsckError = fsckError2;
                                                }
                                            }
                                            th2 = th;
                                        }
                                        throw th2;
                                    }
                                }
                            } catch (Throwable th5) {
                                if (readableChannelOpenFile != null) {
                                    try {
                                        readableChannelOpenFile.close();
                                    } catch (Throwable th6) {
                                        th = th5;
                                        th2 = th6;
                                        if (th != null) {
                                            if (th != th2) {
                                                th.addSuppressed(th2);
                                            }
                                            th2 = th;
                                        }
                                        throw th2;
                                    }
                                }
                                throw th5;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            progressMonitor2 = progressMonitor;
                            fsckError2 = fsckError;
                        }
                    }
                    i++;
                    progressMonitor = progressMonitor2;
                    fsckError = fsckError2;
                }
                if (dfsReaderNewReader != null) {
                    dfsReaderNewReader.close();
                }
                checkGitModules(progressMonitor, fsckError);
            } catch (Throwable th8) {
                if (dfsReaderNewReader == null) {
                    throw th8;
                }
                dfsReaderNewReader.close();
                throw th8;
            }
        } catch (Throwable th9) {
            if (0 == 0) {
                throw th9;
            }
            if (null != th9) {
                th3.addSuppressed(th9);
            }
            throw null;
        }
    }

    private void verifyPack(ProgressMonitor progressMonitor, FsckError fsckError, DfsReader dfsReader, DfsPackFile dfsPackFile, ReadableChannel readableChannel) throws IOException, CorruptPackIndexException {
        FsckPackParser fsckPackParser = new FsckPackParser(this.objdb, readableChannel);
        fsckPackParser.setObjectChecker(this.objChecker);
        fsckPackParser.overwriteObjectCount(dfsPackFile.getPackDescription().getObjectCount());
        fsckPackParser.parse(progressMonitor);
        fsckError.getCorruptObjects().addAll(fsckPackParser.getCorruptObjects());
        fsckPackParser.verifyIndex(dfsPackFile.getPackIndex(dfsReader));
    }

    private void checkGitModules(ProgressMonitor progressMonitor, FsckError fsckError) throws IOException {
        progressMonitor.beginTask(JGitText.get().validatingGitModules, this.objChecker.getGitsubmodules().size());
        Iterator<GitmoduleEntry> it = this.objChecker.getGitsubmodules().iterator();
        while (it.hasNext()) {
            AnyObjectId blobId = it.next().getBlobId();
            try {
                SubmoduleValidator.assertValidGitModulesFile(new String(this.objdb.open(blobId, 3).getBytes(), StandardCharsets.UTF_8));
            } catch (SubmoduleValidator.SubmoduleValidationException e) {
                fsckError.getCorruptObjects().add(new FsckError.CorruptObject(blobId.toObjectId(), 3, e.getFsckMessageId()));
            }
            progressMonitor.update(1);
        }
        progressMonitor.endTask();
    }

    private void checkConnectivity(ProgressMonitor progressMonitor, FsckError fsckError) throws IOException {
        progressMonitor.beginTask(JGitText.get().countingObjects, 0);
        Throwable th = null;
        try {
            ObjectWalk objectWalk = new ObjectWalk(this.repo);
            try {
                for (Ref ref : this.repo.getRefDatabase().getRefs()) {
                    ObjectId objectId = ref.getObjectId();
                    if (objectId != null) {
                        try {
                            RevObject any = objectWalk.parseAny(objectId);
                            if (ref.getLeaf().getName().startsWith(Constants.R_HEADS) && any.getType() != 1) {
                                fsckError.getNonCommitHeads().add(ref.getLeaf().getName());
                            }
                            objectWalk.markStart(any);
                        } catch (MissingObjectException e) {
                            fsckError.getMissingObjects().add(e.getObjectId());
                        }
                    }
                }
                try {
                    objectWalk.checkConnectivity();
                } catch (MissingObjectException e2) {
                    fsckError.getMissingObjects().add(e2.getObjectId());
                }
                objectWalk.close();
                progressMonitor.endTask();
            } catch (Throwable th2) {
                objectWalk.close();
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

    public void setObjectChecker(ObjectChecker objectChecker) {
        this.objChecker = objectChecker;
    }

    public void setConnectivityOnly(boolean z) {
        this.connectivityOnly = z;
    }
}
