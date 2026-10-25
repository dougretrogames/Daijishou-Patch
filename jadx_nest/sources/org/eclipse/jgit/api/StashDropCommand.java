package org.eclipse.jgit.api;

import java.io.File;
import java.io.IOException;
import java.nio.file.StandardCopyOption;
import java.text.MessageFormat;
import java.util.List;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.errors.LockFailedException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.file.RefDirectory;
import org.eclipse.jgit.internal.storage.file.ReflogWriter;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.RefUpdate;
import org.eclipse.jgit.lib.ReflogEntry;
import org.eclipse.jgit.lib.ReflogReader;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.util.FileUtils;

/* JADX INFO: loaded from: classes5.dex */
public class StashDropCommand extends GitCommand<ObjectId> {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result;
    private boolean all;
    private int stashRefEntry;

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

    public StashDropCommand(Repository repository) {
        super(repository);
        if (!(repository.getRefDatabase() instanceof RefDirectory)) {
            throw new UnsupportedOperationException(JGitText.get().stashDropNotSupported);
        }
    }

    public StashDropCommand setStashRef(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        this.stashRefEntry = i;
        return this;
    }

    public StashDropCommand setAll(boolean z) {
        this.all = z;
        return this;
    }

    private Ref getRef() throws GitAPIException {
        try {
            return this.repo.exactRef(Constants.R_STASH);
        } catch (IOException e) {
            throw new InvalidRefNameException(MessageFormat.format(JGitText.get().cannotRead, Constants.R_STASH), e);
        }
    }

    private RefUpdate createRefUpdate(Ref ref) throws IOException {
        RefUpdate refUpdateUpdateRef = this.repo.updateRef(Constants.R_STASH);
        refUpdateUpdateRef.disableRefLog();
        refUpdateUpdateRef.setExpectedOldObjectId(ref.getObjectId());
        refUpdateUpdateRef.setForceUpdate(true);
        return refUpdateUpdateRef;
    }

    private void deleteRef(Ref ref) {
        try {
            RefUpdate.Result resultDelete = createRefUpdate(ref).delete();
            if (RefUpdate.Result.FORCED == resultDelete) {
            } else {
                throw new JGitInternalException(MessageFormat.format(JGitText.get().stashDropDeleteRefFailed, resultDelete));
            }
        } catch (IOException e) {
            throw new JGitInternalException(JGitText.get().stashDropFailed, e);
        }
    }

    private void updateRef(Ref ref, ObjectId objectId) {
        try {
            RefUpdate refUpdateCreateRefUpdate = createRefUpdate(ref);
            refUpdateCreateRefUpdate.setNewObjectId(objectId);
            RefUpdate.Result resultUpdate = refUpdateCreateRefUpdate.update();
            int i = $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result()[resultUpdate.ordinal()];
            if (i != 3 && i != 4 && i != 5) {
                throw new JGitInternalException(MessageFormat.format(JGitText.get().updatingRefFailed, Constants.R_STASH, objectId, resultUpdate));
            }
        } catch (IOException e) {
            throw new JGitInternalException(JGitText.get().stashDropFailed, e);
        }
    }

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public ObjectId call() throws GitAPIException {
        checkCallable();
        Ref ref = getRef();
        if (ref == null) {
            return null;
        }
        if (!this.all) {
            try {
                ReflogReader reflogReader = this.repo.getReflogReader(Constants.R_STASH);
                if (reflogReader == null) {
                    throw new RefNotFoundException(MessageFormat.format(JGitText.get().refNotResolved, ref));
                }
                List<ReflogEntry> reverseEntries = reflogReader.getReverseEntries();
                if (this.stashRefEntry >= reverseEntries.size()) {
                    throw new JGitInternalException(JGitText.get().stashDropMissingReflog);
                }
                if (reverseEntries.size() == 1) {
                    deleteRef(ref);
                    return null;
                }
                RefDirectory refDirectory = (RefDirectory) this.repo.getRefDatabase();
                ReflogWriter reflogWriter = new ReflogWriter(refDirectory, true);
                String strRefLockFor = ReflogWriter.refLockFor(Constants.R_STASH);
                File fileLogFor = refDirectory.logFor(strRefLockFor);
                File fileLogFor2 = refDirectory.logFor(Constants.R_STASH);
                if (fileLogFor.exists()) {
                    throw new JGitInternalException(JGitText.get().stashDropFailed, new LockFailedException(fileLogFor2));
                }
                reverseEntries.remove(this.stashRefEntry);
                ObjectId objectIdZeroId = ObjectId.zeroId();
                try {
                    for (int size = reverseEntries.size() - 1; size >= 0; size--) {
                        ReflogEntry reflogEntry = reverseEntries.get(size);
                        reflogWriter.log(strRefLockFor, objectIdZeroId, reflogEntry.getNewId(), reflogEntry.getWho(), reflogEntry.getComment());
                        objectIdZeroId = reflogEntry.getNewId();
                    }
                    try {
                        FileUtils.rename(fileLogFor, fileLogFor2, StandardCopyOption.ATOMIC_MOVE);
                        updateRef(ref, objectIdZeroId);
                        try {
                            Ref refExactRef = this.repo.exactRef(Constants.R_STASH);
                            if (refExactRef != null) {
                                return refExactRef.getObjectId();
                            }
                            return null;
                        } catch (IOException e) {
                            throw new InvalidRefNameException(MessageFormat.format(JGitText.get().cannotRead, Constants.R_STASH), e);
                        }
                    } catch (IOException e2) {
                        throw new JGitInternalException(MessageFormat.format(JGitText.get().renameFileFailed, fileLogFor.getPath(), fileLogFor2.getPath()), e2);
                    }
                } catch (IOException e3) {
                    throw new JGitInternalException(JGitText.get().stashDropFailed, e3);
                }
            } catch (IOException e4) {
                throw new JGitInternalException(JGitText.get().stashDropFailed, e4);
            }
        }
        deleteRef(ref);
        return null;
    }
}
