package org.eclipse.jgit.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;

/* JADX INFO: loaded from: classes5.dex */
public class ListTagCommand extends GitCommand<List<Ref>> {
    private RevCommit commit;
    private final RevWalk rw;

    protected ListTagCommand(Repository repository) {
        super(repository);
        this.rw = new RevWalk(repository);
    }

    public ListTagCommand setContains(AnyObjectId anyObjectId) throws IOException {
        checkCallable();
        this.commit = this.rw.parseCommit(anyObjectId);
        return this;
    }

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public List<Ref> call() throws GitAPIException {
        List<Ref> arrayList;
        checkCallable();
        try {
            try {
                List<Ref> refsByPrefix = this.repo.getRefDatabase().getRefsByPrefix(Constants.R_TAGS);
                if (this.commit != null) {
                    this.rw.setRetainBody(false);
                    arrayList = this.rw.getMergedInto(this.commit, refsByPrefix);
                } else {
                    arrayList = new ArrayList(refsByPrefix);
                }
                this.rw.close();
                Collections.sort(arrayList, new ListTagCommand$$ExternalSyntheticLambda0());
                setCallable(false);
                return arrayList;
            } catch (IOException e) {
                throw new JGitInternalException(e.getMessage(), e);
            }
        } catch (Throwable th) {
            this.rw.close();
            throw th;
        }
    }
}
