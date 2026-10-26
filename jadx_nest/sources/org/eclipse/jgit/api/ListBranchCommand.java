package org.eclipse.jgit.api;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.revwalk.RevWalkUtils;

/* INFO: loaded from: classes5.dex */
public class ListBranchCommand extends GitCommand<List<Ref>> {
    private String containsCommitish;
    private ListMode listMode;

    public enum ListMode {
        ALL,
        REMOTE;

        /* INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static ListMode[] valuesCustom() {
            ListMode[] listModeArrValuesCustom = values();
            int length = listModeArrValuesCustom.length;
            ListMode[] listModeArr = new ListMode[length];
            System.arraycopy(listModeArrValuesCustom, 0, listModeArr, 0, length);
            return listModeArr;
        }
    }

    protected ListBranchCommand(Repository repository) {
        super(repository);
    }

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public List<Ref> call() throws GitAPIException {
        checkCallable();
        try {
            ArrayList arrayList = new ArrayList();
            Ref refExactRef = this.repo.exactRef("HEAD");
            if (refExactRef != null && refExactRef.getLeaf().getName().equals("HEAD")) {
                arrayList.add(refExactRef);
            }
            ListMode listMode = this.listMode;
            if (listMode == null) {
                arrayList.addAll(this.repo.getRefDatabase().getRefsByPrefix(Constants.R_HEADS));
            } else if (listMode == ListMode.REMOTE) {
                arrayList.addAll(this.repo.getRefDatabase().getRefsByPrefix(Constants.R_REMOTES));
            } else {
                arrayList.addAll(this.repo.getRefDatabase().getRefsByPrefix(Constants.R_HEADS, Constants.R_REMOTES));
            }
            ArrayList arrayList2 = new ArrayList(filterRefs(arrayList));
            Collections.sort(arrayList2, new ListBranchCommand$$ExternalSyntheticLambda0());
            setCallable(false);
            return arrayList2;
        } catch (IOException e) {
            throw new JGitInternalException(e.getMessage(), e);
        }
    }

    private Collection<Ref> filterRefs(Collection<Ref> collection) throws RefNotFoundException, IOException {
        if (this.containsCommitish == null) {
            return collection;
        }
        Throwable th = null;
        try {
            RevWalk revWalk = new RevWalk(this.repo);
            try {
                ObjectId objectIdResolve = this.repo.resolve(this.containsCommitish);
                if (objectIdResolve == null) {
                    throw new RefNotFoundException(MessageFormat.format(JGitText.get().refNotResolved, this.containsCommitish));
                }
                List<Ref> listFindBranchesReachableFrom = RevWalkUtils.findBranchesReachableFrom(revWalk.parseCommit(objectIdResolve), revWalk, collection);
                revWalk.close();
                return listFindBranchesReachableFrom;
            } catch (Throwable th2) {
                revWalk.close();
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

    public ListBranchCommand setListMode(ListMode listMode) {
        checkCallable();
        this.listMode = listMode;
        return this;
    }

    public ListBranchCommand setContains(String str) {
        checkCallable();
        this.containsCommitish = str;
        return this;
    }
}
