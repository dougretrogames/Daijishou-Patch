package org.eclipse.jgit.api;

import java.io.IOException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.dircache.DirCacheEditor;
import org.eclipse.jgit.dircache.DirCacheEntry;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.CommitBuilder;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.RefUpdate;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;

/* JADX INFO: loaded from: classes5.dex */
public class StashCreateCommand extends GitCommand<RevCommit> {
    private static final String MSG_INDEX = "index on {0}: {1} {2}";
    private static final String MSG_UNTRACKED = "untracked files on {0}: {1} {2}";
    private static final String MSG_WORKING_DIR = "WIP on {0}: {1} {2}";
    private boolean includeUntracked;
    private String indexMessage;
    private PersonIdent person;
    private String ref;
    private String workingDirectoryMessage;

    public StashCreateCommand(Repository repository) {
        super(repository);
        this.indexMessage = MSG_INDEX;
        this.workingDirectoryMessage = MSG_WORKING_DIR;
        this.ref = Constants.R_STASH;
        this.person = new PersonIdent(repository);
    }

    public StashCreateCommand setIndexMessage(String str) {
        this.indexMessage = str;
        return this;
    }

    public StashCreateCommand setWorkingDirectoryMessage(String str) {
        this.workingDirectoryMessage = str;
        return this;
    }

    public StashCreateCommand setPerson(PersonIdent personIdent) {
        this.person = personIdent;
        return this;
    }

    public StashCreateCommand setRef(String str) {
        this.ref = str;
        return this;
    }

    public StashCreateCommand setIncludeUntracked(boolean z) {
        this.includeUntracked = z;
        return this;
    }

    private RevCommit parseCommit(ObjectReader objectReader, ObjectId objectId) throws IOException {
        Throwable th = null;
        try {
            RevWalk revWalk = new RevWalk(objectReader);
            try {
                return revWalk.parseCommit(objectId);
            } finally {
                revWalk.close();
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

    private CommitBuilder createBuilder() {
        CommitBuilder commitBuilder = new CommitBuilder();
        PersonIdent personIdent = this.person;
        if (personIdent == null) {
            personIdent = new PersonIdent(this.repo);
        }
        commitBuilder.setAuthor(personIdent);
        commitBuilder.setCommitter(personIdent);
        return commitBuilder;
    }

    private void updateStashRef(ObjectId objectId, PersonIdent personIdent, String str) throws IOException {
        if (this.ref == null) {
            return;
        }
        Ref refFindRef = this.repo.findRef(this.ref);
        RefUpdate refUpdateUpdateRef = this.repo.updateRef(this.ref);
        refUpdateUpdateRef.setNewObjectId(objectId);
        refUpdateUpdateRef.setRefLogIdent(personIdent);
        refUpdateUpdateRef.setRefLogMessage(str, false);
        refUpdateUpdateRef.setForceRefLog(true);
        if (refFindRef != null) {
            refUpdateUpdateRef.setExpectedOldObjectId(refFindRef.getObjectId());
        } else {
            refUpdateUpdateRef.setExpectedOldObjectId(ObjectId.zeroId());
        }
        refUpdateUpdateRef.forceUpdate();
    }

    private Ref getHead() throws GitAPIException {
        try {
            Ref refExactRef = this.repo.exactRef("HEAD");
            if (refExactRef == null || refExactRef.getObjectId() == null) {
                throw new NoHeadException(JGitText.get().headRequiredToStash);
            }
            return refExactRef;
        } catch (IOException e) {
            throw new JGitInternalException(JGitText.get().stashFailed, e);
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0377 */
    /* JADX WARN: Code duplicated, block: B:104:0x024b A[Catch: all -> 0x0331, TryCatch #7 {all -> 0x0331, blocks: (B:78:0x0185, B:92:0x01b1, B:94:0x01ef, B:95:0x01fb, B:97:0x0201, B:100:0x023f, B:102:0x0245, B:111:0x0266, B:113:0x026e, B:114:0x0271, B:116:0x02a8, B:117:0x02ac, B:120:0x02b3, B:104:0x024b, B:105:0x0253, B:107:0x0259, B:108:0x025d, B:110:0x0263, B:133:0x0306, B:134:0x0316, B:98:0x022f, B:47:0x011d, B:56:0x014f, B:76:0x017d, B:57:0x0153, B:70:0x016c, B:72:0x0170), top: B:199:0x0185 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x026e A[Catch: all -> 0x0331, TryCatch #7 {all -> 0x0331, blocks: (B:78:0x0185, B:92:0x01b1, B:94:0x01ef, B:95:0x01fb, B:97:0x0201, B:100:0x023f, B:102:0x0245, B:111:0x0266, B:113:0x026e, B:114:0x0271, B:116:0x02a8, B:117:0x02ac, B:120:0x02b3, B:104:0x024b, B:105:0x0253, B:107:0x0259, B:108:0x025d, B:110:0x0263, B:133:0x0306, B:134:0x0316, B:98:0x022f, B:47:0x011d, B:56:0x014f, B:76:0x017d, B:57:0x0153, B:70:0x016c, B:72:0x0170), top: B:199:0x0185 }] */
    /* JADX WARN: Code duplicated, block: B:116:0x02a8 A[Catch: all -> 0x0331, TryCatch #7 {all -> 0x0331, blocks: (B:78:0x0185, B:92:0x01b1, B:94:0x01ef, B:95:0x01fb, B:97:0x0201, B:100:0x023f, B:102:0x0245, B:111:0x0266, B:113:0x026e, B:114:0x0271, B:116:0x02a8, B:117:0x02ac, B:120:0x02b3, B:104:0x024b, B:105:0x0253, B:107:0x0259, B:108:0x025d, B:110:0x0263, B:133:0x0306, B:134:0x0316, B:98:0x022f, B:47:0x011d, B:56:0x014f, B:76:0x017d, B:57:0x0153, B:70:0x016c, B:72:0x0170), top: B:199:0x0185 }] */
    /* JADX WARN: Code duplicated, block: B:120:0x02b3 A[Catch: all -> 0x0331, LOOP:2: B:117:0x02ac->B:120:0x02b3, LOOP_END, TRY_LEAVE, TryCatch #7 {all -> 0x0331, blocks: (B:78:0x0185, B:92:0x01b1, B:94:0x01ef, B:95:0x01fb, B:97:0x0201, B:100:0x023f, B:102:0x0245, B:111:0x0266, B:113:0x026e, B:114:0x0271, B:116:0x02a8, B:117:0x02ac, B:120:0x02b3, B:104:0x024b, B:105:0x0253, B:107:0x0259, B:108:0x025d, B:110:0x0263, B:133:0x0306, B:134:0x0316, B:98:0x022f, B:47:0x011d, B:56:0x014f, B:76:0x017d, B:57:0x0153, B:70:0x016c, B:72:0x0170), top: B:199:0x0185 }] */
    /* JADX WARN: Code duplicated, block: B:124:0x02d4 A[Catch: all -> 0x0351, TRY_ENTER, TRY_LEAVE, TryCatch #8 {all -> 0x0351, blocks: (B:5:0x0023, B:83:0x0192, B:124:0x02d4), top: B:198:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:127:0x02f0 A[Catch: all -> 0x036c, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x036c, blocks: (B:3:0x000f, B:86:0x019a, B:127:0x02f0), top: B:197:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:130:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:132:0x0305  */
    /* JADX WARN: Code duplicated, block: B:134:0x0316 A[Catch: all -> 0x0331, LOOP:3: B:105:0x0253->B:134:0x0316, LOOP_END, TRY_LEAVE, TryCatch #7 {all -> 0x0331, blocks: (B:78:0x0185, B:92:0x01b1, B:94:0x01ef, B:95:0x01fb, B:97:0x0201, B:100:0x023f, B:102:0x0245, B:111:0x0266, B:113:0x026e, B:114:0x0271, B:116:0x02a8, B:117:0x02ac, B:120:0x02b3, B:104:0x024b, B:105:0x0253, B:107:0x0259, B:108:0x025d, B:110:0x0263, B:133:0x0306, B:134:0x0316, B:98:0x022f, B:47:0x011d, B:56:0x014f, B:76:0x017d, B:57:0x0153, B:70:0x016c, B:72:0x0170), top: B:199:0x0185 }] */
    /* JADX WARN: Code duplicated, block: B:136:0x0322 A[LOOP:0: B:21:0x00a8->B:136:0x0322, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:160:0x0355 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:177:0x0370 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:179:0x0375  */
    /* JADX WARN: Code duplicated, block: B:188:0x038c A[REMOVE] */
    /* JADX WARN: Code duplicated, block: B:190:0x0372 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:208:0x0357 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:211:0x018b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:221:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:223:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x018d A[Catch: all -> 0x033d, TRY_ENTER, TRY_LEAVE, TryCatch #15 {all -> 0x033d, blocks: (B:6:0x0029, B:81:0x018d, B:122:0x02cf), top: B:210:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x0192 A[Catch: all -> 0x0351, TRY_ENTER, TRY_LEAVE, TryCatch #8 {all -> 0x0351, blocks: (B:5:0x0023, B:83:0x0192, B:124:0x02d4), top: B:198:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x019a A[Catch: all -> 0x036c, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x036c, blocks: (B:3:0x000f, B:86:0x019a, B:127:0x02f0), top: B:197:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:89:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:90:0x01af A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:92:0x01b1 A[Catch: all -> 0x0331, TRY_ENTER, TryCatch #7 {all -> 0x0331, blocks: (B:78:0x0185, B:92:0x01b1, B:94:0x01ef, B:95:0x01fb, B:97:0x0201, B:100:0x023f, B:102:0x0245, B:111:0x0266, B:113:0x026e, B:114:0x0271, B:116:0x02a8, B:117:0x02ac, B:120:0x02b3, B:104:0x024b, B:105:0x0253, B:107:0x0259, B:108:0x025d, B:110:0x0263, B:133:0x0306, B:134:0x0316, B:98:0x022f, B:47:0x011d, B:56:0x014f, B:76:0x017d, B:57:0x0153, B:70:0x016c, B:72:0x0170), top: B:199:0x0185 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x01ef A[Catch: all -> 0x0331, TryCatch #7 {all -> 0x0331, blocks: (B:78:0x0185, B:92:0x01b1, B:94:0x01ef, B:95:0x01fb, B:97:0x0201, B:100:0x023f, B:102:0x0245, B:111:0x0266, B:113:0x026e, B:114:0x0271, B:116:0x02a8, B:117:0x02ac, B:120:0x02b3, B:104:0x024b, B:105:0x0253, B:107:0x0259, B:108:0x025d, B:110:0x0263, B:133:0x0306, B:134:0x0316, B:98:0x022f, B:47:0x011d, B:56:0x014f, B:76:0x017d, B:57:0x0153, B:70:0x016c, B:72:0x0170), top: B:199:0x0185 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x022f A[Catch: all -> 0x0331, LOOP:1: B:95:0x01fb->B:98:0x022f, LOOP_END, TryCatch #7 {all -> 0x0331, blocks: (B:78:0x0185, B:92:0x01b1, B:94:0x01ef, B:95:0x01fb, B:97:0x0201, B:100:0x023f, B:102:0x0245, B:111:0x0266, B:113:0x026e, B:114:0x0271, B:116:0x02a8, B:117:0x02ac, B:120:0x02b3, B:104:0x024b, B:105:0x0253, B:107:0x0259, B:108:0x025d, B:110:0x0263, B:133:0x0306, B:134:0x0316, B:98:0x022f, B:47:0x011d, B:56:0x014f, B:76:0x017d, B:57:0x0153, B:70:0x016c, B:72:0x0170), top: B:199:0x0185 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x023e  */
    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.eclipse.jgit.revwalk.RevCommit call() throws org.eclipse.jgit.api.errors.GitAPIException {
        /*
            Method dump skipped, instruction units count: 920
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jgit.api.StashCreateCommand.call():org.eclipse.jgit.revwalk.RevCommit");
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.api.StashCreateCommand$1, reason: invalid class name */
    class AnonymousClass1 extends DirCacheEditor.PathEdit {
        private final /* synthetic */ DirCacheEntry val$entry;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(DirCacheEntry dirCacheEntry, DirCacheEntry dirCacheEntry2) {
            super(dirCacheEntry);
            this.val$entry = dirCacheEntry2;
        }

        @Override // org.eclipse.jgit.dircache.DirCacheEditor.PathEdit
        public void apply(DirCacheEntry dirCacheEntry) {
            dirCacheEntry.copyMetaData(this.val$entry);
        }
    }
}
