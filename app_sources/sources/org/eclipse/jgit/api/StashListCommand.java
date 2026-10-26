package org.eclipse.jgit.api;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ReflogEntry;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;

/* INFO: loaded from: classes5.dex */
public class StashListCommand extends GitCommand<Collection<RevCommit>> {
    public StashListCommand(Repository repository) {
        super(repository);
    }

    /* WARN: Multi-variable type inference failed */
    /* WARN: Type inference failed for: r0v6, types: [java.lang.Throwable] */
    /* WARN: Type inference failed for: r2v10 */
    /* WARN: Type inference failed for: r2v11 */
    /* WARN: Type inference failed for: r2v3 */
    /* WARN: Type inference failed for: r2v4, types: [java.lang.Throwable] */
    /* WARN: Type inference failed for: r2v8, types: [java.lang.String] */
    /* WARN: Type inference failed for: r2v9 */
    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public Collection<RevCommit> call() throws GitAPIException {
        checkCallable();
        try {
            if (this.repo.exactRef(Constants.R_STASH) == null) {
                return Collections.emptyList();
            }
            ReflogCommand reflogCommand = new ReflogCommand(this.repo);
            reflogCommand.setRef(Constants.R_STASH);
            Collection<ReflogEntry> collectionCall = reflogCommand.call();
            if (collectionCall.isEmpty()) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList(collectionCall.size());
            ?? r2 = 0;
            r2 = 0;
            r2 = 0;
            r2 = 0;
            try {
                RevWalk revWalk = new RevWalk(this.repo);
                try {
                    for (ReflogEntry reflogEntry : collectionCall) {
                        try {
                            arrayList.add(revWalk.parseCommit(reflogEntry.getNewId()));
                        } catch (IOException e) {
                            r2 = MessageFormat.format(JGitText.get().cannotReadCommit, reflogEntry.getNewId());
                            throw new JGitInternalException(r2, e);
                        }
                    }
                    revWalk.close();
                    return arrayList;
                } catch (Throwable th) {
                    revWalk.close();
                    throw th;
                }
            } catch (Throwable th2) {
                if (r2 == 0) {
                    throw th2;
                }
                if (r2 != th2) {
                    r2.addSuppressed(th2);
                }
                throw r2;
            }
        } catch (IOException e2) {
            throw new InvalidRefNameException(MessageFormat.format(JGitText.get().cannotRead, Constants.R_STASH), e2);
        }
    }
}
