package org.eclipse.jgit.internal.storage.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.StandardCopyOption;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.RefRename;
import org.eclipse.jgit.lib.RefUpdate;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.util.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
class RefDirectoryRename extends RefRename {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result;
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) RefDirectoryRename.class);
    private ObjectId objId;
    private final RefDirectory refdb;
    private RefDirectoryUpdate tmp;

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[RefUpdate.Result.valuesCustom().length];
        try {
            iArr2[RefUpdate.Result.FAST_FORWARD.ordinal()] = 6;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[RefUpdate.Result.FORCED.ordinal()] = 5;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[RefUpdate.Result.IO_FAILURE.ordinal()] = 9;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[RefUpdate.Result.LOCK_FAILURE.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[RefUpdate.Result.NEW.ordinal()] = 4;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[RefUpdate.Result.NOT_ATTEMPTED.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[RefUpdate.Result.NO_CHANGE.ordinal()] = 3;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr2[RefUpdate.Result.REJECTED.ordinal()] = 7;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr2[RefUpdate.Result.REJECTED_CURRENT_BRANCH.ordinal()] = 8;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr2[RefUpdate.Result.REJECTED_MISSING_OBJECT.ordinal()] = 11;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            iArr2[RefUpdate.Result.REJECTED_OTHER_REASON.ordinal()] = 12;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            iArr2[RefUpdate.Result.RENAMED.ordinal()] = 10;
        } catch (NoSuchFieldError unused12) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result = iArr2;
        return iArr2;
    }

    RefDirectoryRename(RefDirectoryUpdate refDirectoryUpdate, RefDirectoryUpdate refDirectoryUpdate2) {
        super(refDirectoryUpdate, refDirectoryUpdate2);
        this.refdb = refDirectoryUpdate.getRefDatabase();
    }

    protected RefDirectory getRefDirectory() {
        return this.refdb;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00e2 A[Catch: all -> 0x0190, TryCatch #2 {all -> 0x0190, blocks: (B:8:0x002f, B:14:0x005a, B:21:0x007b, B:23:0x0085, B:27:0x008f, B:29:0x0093, B:31:0x009b, B:35:0x00ac, B:36:0x00c7, B:38:0x00e2, B:40:0x00eb, B:41:0x00f0, B:45:0x00ff, B:47:0x0109, B:49:0x0127, B:50:0x012c, B:54:0x0137, B:56:0x014b, B:58:0x0155, B:59:0x015c, B:61:0x0173, B:62:0x0178, B:66:0x0185), top: B:89:0x002f, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00eb A[Catch: all -> 0x0190, TryCatch #2 {all -> 0x0190, blocks: (B:8:0x002f, B:14:0x005a, B:21:0x007b, B:23:0x0085, B:27:0x008f, B:29:0x0093, B:31:0x009b, B:35:0x00ac, B:36:0x00c7, B:38:0x00e2, B:40:0x00eb, B:41:0x00f0, B:45:0x00ff, B:47:0x0109, B:49:0x0127, B:50:0x012c, B:54:0x0137, B:56:0x014b, B:58:0x0155, B:59:0x015c, B:61:0x0173, B:62:0x0178, B:66:0x0185), top: B:89:0x002f, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00ff A[Catch: all -> 0x0190, TRY_ENTER, TryCatch #2 {all -> 0x0190, blocks: (B:8:0x002f, B:14:0x005a, B:21:0x007b, B:23:0x0085, B:27:0x008f, B:29:0x0093, B:31:0x009b, B:35:0x00ac, B:36:0x00c7, B:38:0x00e2, B:40:0x00eb, B:41:0x00f0, B:45:0x00ff, B:47:0x0109, B:49:0x0127, B:50:0x012c, B:54:0x0137, B:56:0x014b, B:58:0x0155, B:59:0x015c, B:61:0x0173, B:62:0x0178, B:66:0x0185), top: B:89:0x002f, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x0109 A[Catch: all -> 0x0190, TryCatch #2 {all -> 0x0190, blocks: (B:8:0x002f, B:14:0x005a, B:21:0x007b, B:23:0x0085, B:27:0x008f, B:29:0x0093, B:31:0x009b, B:35:0x00ac, B:36:0x00c7, B:38:0x00e2, B:40:0x00eb, B:41:0x00f0, B:45:0x00ff, B:47:0x0109, B:49:0x0127, B:50:0x012c, B:54:0x0137, B:56:0x014b, B:58:0x0155, B:59:0x015c, B:61:0x0173, B:62:0x0178, B:66:0x0185), top: B:89:0x002f, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x0127 A[Catch: all -> 0x0190, TryCatch #2 {all -> 0x0190, blocks: (B:8:0x002f, B:14:0x005a, B:21:0x007b, B:23:0x0085, B:27:0x008f, B:29:0x0093, B:31:0x009b, B:35:0x00ac, B:36:0x00c7, B:38:0x00e2, B:40:0x00eb, B:41:0x00f0, B:45:0x00ff, B:47:0x0109, B:49:0x0127, B:50:0x012c, B:54:0x0137, B:56:0x014b, B:58:0x0155, B:59:0x015c, B:61:0x0173, B:62:0x0178, B:66:0x0185), top: B:89:0x002f, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0137 A[Catch: all -> 0x0190, TRY_ENTER, TryCatch #2 {all -> 0x0190, blocks: (B:8:0x002f, B:14:0x005a, B:21:0x007b, B:23:0x0085, B:27:0x008f, B:29:0x0093, B:31:0x009b, B:35:0x00ac, B:36:0x00c7, B:38:0x00e2, B:40:0x00eb, B:41:0x00f0, B:45:0x00ff, B:47:0x0109, B:49:0x0127, B:50:0x012c, B:54:0x0137, B:56:0x014b, B:58:0x0155, B:59:0x015c, B:61:0x0173, B:62:0x0178, B:66:0x0185), top: B:89:0x002f, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x014b A[Catch: all -> 0x0190, TryCatch #2 {all -> 0x0190, blocks: (B:8:0x002f, B:14:0x005a, B:21:0x007b, B:23:0x0085, B:27:0x008f, B:29:0x0093, B:31:0x009b, B:35:0x00ac, B:36:0x00c7, B:38:0x00e2, B:40:0x00eb, B:41:0x00f0, B:45:0x00ff, B:47:0x0109, B:49:0x0127, B:50:0x012c, B:54:0x0137, B:56:0x014b, B:58:0x0155, B:59:0x015c, B:61:0x0173, B:62:0x0178, B:66:0x0185), top: B:89:0x002f, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0155 A[Catch: all -> 0x0190, TryCatch #2 {all -> 0x0190, blocks: (B:8:0x002f, B:14:0x005a, B:21:0x007b, B:23:0x0085, B:27:0x008f, B:29:0x0093, B:31:0x009b, B:35:0x00ac, B:36:0x00c7, B:38:0x00e2, B:40:0x00eb, B:41:0x00f0, B:45:0x00ff, B:47:0x0109, B:49:0x0127, B:50:0x012c, B:54:0x0137, B:56:0x014b, B:58:0x0155, B:59:0x015c, B:61:0x0173, B:62:0x0178, B:66:0x0185), top: B:89:0x002f, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x0173 A[Catch: all -> 0x0190, TryCatch #2 {all -> 0x0190, blocks: (B:8:0x002f, B:14:0x005a, B:21:0x007b, B:23:0x0085, B:27:0x008f, B:29:0x0093, B:31:0x009b, B:35:0x00ac, B:36:0x00c7, B:38:0x00e2, B:40:0x00eb, B:41:0x00f0, B:45:0x00ff, B:47:0x0109, B:49:0x0127, B:50:0x012c, B:54:0x0137, B:56:0x014b, B:58:0x0155, B:59:0x015c, B:61:0x0173, B:62:0x0178, B:66:0x0185), top: B:89:0x002f, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x0185 A[Catch: all -> 0x0190, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0190, blocks: (B:8:0x002f, B:14:0x005a, B:21:0x007b, B:23:0x0085, B:27:0x008f, B:29:0x0093, B:31:0x009b, B:35:0x00ac, B:36:0x00c7, B:38:0x00e2, B:40:0x00eb, B:41:0x00f0, B:45:0x00ff, B:47:0x0109, B:49:0x0127, B:50:0x012c, B:54:0x0137, B:56:0x014b, B:58:0x0155, B:59:0x015c, B:61:0x0173, B:62:0x0178, B:66:0x0185), top: B:89:0x002f, outer: #3 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [org.eclipse.jgit.lib.RefUpdate$Result] */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v5, types: [boolean] */
    @Override // org.eclipse.jgit.lib.RefRename
    protected RefUpdate.Result doRename() throws IOException {
        RefDirectory refDirectory;
        RefDirectoryUpdate refDirectoryUpdate;
        if (this.source.getRef().isSymbolic()) {
            return RefUpdate.Result.IO_FAILURE;
        }
        this.objId = this.source.getOldObjectId();
        RefUpdate.Result resultNeedToUpdateHEAD = needToUpdateHEAD();
        this.tmp = this.refdb.newTemporaryUpdate();
        Throwable th = null;
        try {
            RevWalk revWalk = new RevWalk(this.refdb.getRepository());
            try {
                this.tmp.setNewObjectId(this.objId);
                this.tmp.setForceUpdate(true);
                this.tmp.disableRefLog();
                int i = $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result()[this.tmp.update(revWalk).ordinal()];
                try {
                    if (i != 3 && i != 4 && i != 5) {
                        RefUpdate.Result result = this.tmp.getResult();
                        revWalk.close();
                        refDirectory = this.refdb;
                        refDirectoryUpdate = this.tmp;
                        resultNeedToUpdateHEAD = result;
                    } else if (renameLog(this.source, this.tmp)) {
                        RefUpdate refUpdateNewUpdate = this.destination;
                        if (resultNeedToUpdateHEAD == 0) {
                            this.source.setExpectedOldObjectId(this.objId);
                            this.source.setForceUpdate(true);
                            this.source.disableRefLog();
                            if (this.source.delete(revWalk) != RefUpdate.Result.FORCED) {
                                renameLog(this.tmp, this.source);
                                if (resultNeedToUpdateHEAD != 0) {
                                    linkHEAD(this.source);
                                }
                                RefUpdate.Result result2 = this.source.getResult();
                                revWalk.close();
                                refDirectory = this.refdb;
                                refDirectoryUpdate = this.tmp;
                                resultNeedToUpdateHEAD = result2;
                            } else if (renameLog(this.tmp, this.destination)) {
                                refUpdateNewUpdate.setExpectedOldObjectId(ObjectId.zeroId());
                                refUpdateNewUpdate.setNewObjectId(this.objId);
                                if (refUpdateNewUpdate.update(revWalk) != RefUpdate.Result.NEW) {
                                    if (renameLog(this.destination, this.tmp)) {
                                        renameLog(this.tmp, this.source);
                                    }
                                    this.source.setExpectedOldObjectId(ObjectId.zeroId());
                                    this.source.setNewObjectId(this.objId);
                                    this.source.update(revWalk);
                                    if (resultNeedToUpdateHEAD != 0) {
                                        linkHEAD(this.source);
                                    }
                                    RefUpdate.Result result3 = refUpdateNewUpdate.getResult();
                                    revWalk.close();
                                    refDirectory = this.refdb;
                                    refDirectoryUpdate = this.tmp;
                                    resultNeedToUpdateHEAD = result3;
                                } else {
                                    RefUpdate.Result result4 = RefUpdate.Result.RENAMED;
                                    revWalk.close();
                                    refDirectory = this.refdb;
                                    refDirectoryUpdate = this.tmp;
                                    resultNeedToUpdateHEAD = result4;
                                }
                            } else {
                                renameLog(this.tmp, this.source);
                                this.source.setExpectedOldObjectId(ObjectId.zeroId());
                                this.source.setNewObjectId(this.objId);
                                this.source.update(revWalk);
                                if (resultNeedToUpdateHEAD != 0) {
                                    linkHEAD(this.source);
                                }
                                RefUpdate.Result result5 = RefUpdate.Result.IO_FAILURE;
                                revWalk.close();
                                refDirectory = this.refdb;
                                refDirectoryUpdate = this.tmp;
                                resultNeedToUpdateHEAD = result5;
                            }
                        } else if (linkHEAD(this.destination)) {
                            refUpdateNewUpdate = this.refdb.newUpdate("HEAD", false);
                            refUpdateNewUpdate.setRefLogIdent(this.destination.getRefLogIdent());
                            refUpdateNewUpdate.setRefLogMessage(this.destination.getRefLogMessage(), false);
                            this.source.setExpectedOldObjectId(this.objId);
                            this.source.setForceUpdate(true);
                            this.source.disableRefLog();
                            if (this.source.delete(revWalk) != RefUpdate.Result.FORCED) {
                                renameLog(this.tmp, this.source);
                                if (resultNeedToUpdateHEAD != 0) {
                                    linkHEAD(this.source);
                                }
                                RefUpdate.Result result6 = this.source.getResult();
                                revWalk.close();
                                refDirectory = this.refdb;
                                refDirectoryUpdate = this.tmp;
                                resultNeedToUpdateHEAD = result6;
                            } else if (renameLog(this.tmp, this.destination)) {
                                renameLog(this.tmp, this.source);
                                this.source.setExpectedOldObjectId(ObjectId.zeroId());
                                this.source.setNewObjectId(this.objId);
                                this.source.update(revWalk);
                                if (resultNeedToUpdateHEAD != 0) {
                                    linkHEAD(this.source);
                                }
                                RefUpdate.Result result7 = RefUpdate.Result.IO_FAILURE;
                                revWalk.close();
                                refDirectory = this.refdb;
                                refDirectoryUpdate = this.tmp;
                                resultNeedToUpdateHEAD = result7;
                            } else {
                                refUpdateNewUpdate.setExpectedOldObjectId(ObjectId.zeroId());
                                refUpdateNewUpdate.setNewObjectId(this.objId);
                                if (refUpdateNewUpdate.update(revWalk) != RefUpdate.Result.NEW) {
                                    if (renameLog(this.destination, this.tmp)) {
                                        renameLog(this.tmp, this.source);
                                    }
                                    this.source.setExpectedOldObjectId(ObjectId.zeroId());
                                    this.source.setNewObjectId(this.objId);
                                    this.source.update(revWalk);
                                    if (resultNeedToUpdateHEAD != 0) {
                                        linkHEAD(this.source);
                                    }
                                    RefUpdate.Result result8 = refUpdateNewUpdate.getResult();
                                    revWalk.close();
                                    refDirectory = this.refdb;
                                    refDirectoryUpdate = this.tmp;
                                    resultNeedToUpdateHEAD = result8;
                                } else {
                                    RefUpdate.Result result9 = RefUpdate.Result.RENAMED;
                                    revWalk.close();
                                    refDirectory = this.refdb;
                                    refDirectoryUpdate = this.tmp;
                                    resultNeedToUpdateHEAD = result9;
                                }
                            }
                        } else {
                            renameLog(this.tmp, this.source);
                            RefUpdate.Result result10 = RefUpdate.Result.LOCK_FAILURE;
                            revWalk.close();
                            refDirectory = this.refdb;
                            refDirectoryUpdate = this.tmp;
                            resultNeedToUpdateHEAD = result10;
                        }
                    } else {
                        RefUpdate.Result result11 = RefUpdate.Result.IO_FAILURE;
                        revWalk.close();
                        refDirectory = this.refdb;
                        refDirectoryUpdate = this.tmp;
                        resultNeedToUpdateHEAD = result11;
                    }
                    refDirectory.delete(refDirectoryUpdate);
                    return resultNeedToUpdateHEAD;
                } catch (IOException unused) {
                    FileUtils.delete(this.refdb.fileFor(this.tmp.getName()));
                    return resultNeedToUpdateHEAD;
                }
            } catch (Throwable th2) {
                revWalk.close();
                throw th2;
            }
        } catch (Throwable th3) {
            if (0 == 0) {
                throw th3;
            }
            if (null != th3) {
                try {
                    th.addSuppressed(th3);
                } catch (Throwable th4) {
                    try {
                        this.refdb.delete(this.tmp);
                    } catch (IOException unused2) {
                        FileUtils.delete(this.refdb.fileFor(this.tmp.getName()));
                    }
                    throw th4;
                }
            }
            throw null;
        }
    }

    private boolean renameLog(RefUpdate refUpdate, RefUpdate refUpdate2) {
        File fileLogFor = this.refdb.logFor(refUpdate.getName());
        File fileLogFor2 = this.refdb.logFor(refUpdate2.getName());
        if (!fileLogFor.exists()) {
            return true;
        }
        if (!rename(fileLogFor, fileLogFor2)) {
            return false;
        }
        try {
            RefDirectory.delete(fileLogFor, RefDirectory.levelsIn(refUpdate.getName()) - 2);
            return true;
        } catch (IOException unused) {
            rename(fileLogFor2, fileLogFor);
            return false;
        }
    }

    private static boolean rename(File file, File file2) {
        File parentFile;
        try {
            FileUtils.rename(file, file2, StandardCopyOption.ATOMIC_MOVE);
            return true;
        } catch (AtomicMoveNotSupportedException e) {
            LOG.error(e.getMessage(), (Throwable) e);
            parentFile = file2.getParentFile();
            if ((parentFile.exists() && parentFile.mkdirs()) || parentFile.isDirectory()) {
                try {
                    FileUtils.rename(file, file2, StandardCopyOption.ATOMIC_MOVE);
                    return true;
                } catch (IOException e2) {
                    LOG.error(e2.getMessage(), (Throwable) e2);
                    return false;
                }
            }
        } catch (IOException unused) {
            parentFile = file2.getParentFile();
            return parentFile.exists() ? false : false;
            FileUtils.rename(file, file2, StandardCopyOption.ATOMIC_MOVE);
            return true;
        }
    }

    private boolean linkHEAD(RefUpdate refUpdate) {
        try {
            RefDirectoryUpdate refDirectoryUpdateNewUpdate = this.refdb.newUpdate("HEAD", false);
            refDirectoryUpdateNewUpdate.disableRefLog();
            int i = $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result()[refDirectoryUpdateNewUpdate.link(refUpdate.getName()).ordinal()];
            return i == 3 || i == 4 || i == 5;
        } catch (IOException unused) {
            return false;
        }
    }
}
