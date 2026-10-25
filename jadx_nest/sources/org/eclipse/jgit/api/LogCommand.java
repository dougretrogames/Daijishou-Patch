package org.eclipse.jgit.api;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.revwalk.filter.AndRevFilter;
import org.eclipse.jgit.revwalk.filter.MaxCountRevFilter;
import org.eclipse.jgit.revwalk.filter.RevFilter;
import org.eclipse.jgit.revwalk.filter.SkipRevFilter;
import org.eclipse.jgit.treewalk.filter.AndTreeFilter;
import org.eclipse.jgit.treewalk.filter.PathFilter;
import org.eclipse.jgit.treewalk.filter.PathFilterGroup;
import org.eclipse.jgit.treewalk.filter.TreeFilter;

/* JADX INFO: loaded from: classes5.dex */
public class LogCommand extends GitCommand<Iterable<RevCommit>> {
    private final List<TreeFilter> excludeTreeFilters;
    private int maxCount;
    private final List<PathFilter> pathFilters;
    private RevFilter revFilter;
    private int skip;
    private boolean startSpecified;
    private RevWalk walk;

    protected LogCommand(Repository repository) {
        super(repository);
        this.startSpecified = false;
        this.pathFilters = new ArrayList();
        this.excludeTreeFilters = new ArrayList();
        this.maxCount = -1;
        this.skip = -1;
        this.walk = new RevWalk(repository);
    }

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public Iterable<RevCommit> call() throws GitAPIException {
        checkCallable();
        ArrayList arrayList = new ArrayList();
        if (!this.pathFilters.isEmpty()) {
            arrayList.add(AndTreeFilter.create(PathFilterGroup.create(this.pathFilters), TreeFilter.ANY_DIFF));
        }
        if (!this.excludeTreeFilters.isEmpty()) {
            Iterator<TreeFilter> it = this.excludeTreeFilters.iterator();
            while (it.hasNext()) {
                arrayList.add(AndTreeFilter.create(it.next(), TreeFilter.ANY_DIFF));
            }
        }
        if (!arrayList.isEmpty()) {
            if (arrayList.size() == 1) {
                arrayList.add(TreeFilter.ANY_DIFF);
            }
            this.walk.setTreeFilter(AndTreeFilter.create(arrayList));
        }
        int i = this.skip;
        if (i > -1 && this.maxCount > -1) {
            this.walk.setRevFilter(AndRevFilter.create(SkipRevFilter.create(i), MaxCountRevFilter.create(this.maxCount)));
        } else if (i > -1) {
            this.walk.setRevFilter(SkipRevFilter.create(i));
        } else {
            int i2 = this.maxCount;
            if (i2 > -1) {
                this.walk.setRevFilter(MaxCountRevFilter.create(i2));
            }
        }
        if (!this.startSpecified) {
            try {
                ObjectId objectIdResolve = this.repo.resolve("HEAD");
                if (objectIdResolve == null) {
                    throw new NoHeadException(JGitText.get().noHEADExistsAndNoExplicitStartingRevisionWasSpecified);
                }
                add(objectIdResolve);
            } catch (IOException e) {
                throw new JGitInternalException(JGitText.get().anExceptionOccurredWhileTryingToAddTheIdOfHEAD, e);
            }
        }
        RevFilter revFilter = this.revFilter;
        if (revFilter != null) {
            this.walk.setRevFilter(revFilter);
        }
        setCallable(false);
        return this.walk;
    }

    public LogCommand add(AnyObjectId anyObjectId) throws IncorrectObjectTypeException, MissingObjectException {
        return add(true, anyObjectId);
    }

    public LogCommand not(AnyObjectId anyObjectId) throws IncorrectObjectTypeException, MissingObjectException {
        return add(false, anyObjectId);
    }

    public LogCommand addRange(AnyObjectId anyObjectId, AnyObjectId anyObjectId2) throws IncorrectObjectTypeException, MissingObjectException {
        return not(anyObjectId).add(anyObjectId2);
    }

    public LogCommand all() throws IOException {
        RevCommit commit;
        for (Ref refPeel : getRepository().getRefDatabase().getRefs()) {
            if (!refPeel.isPeeled()) {
                refPeel = getRepository().getRefDatabase().peel(refPeel);
            }
            ObjectId peeledObjectId = refPeel.getPeeledObjectId();
            if (peeledObjectId == null) {
                peeledObjectId = refPeel.getObjectId();
            }
            try {
                commit = this.walk.parseCommit(peeledObjectId);
            } catch (IncorrectObjectTypeException | MissingObjectException unused) {
                commit = null;
            }
            if (commit != null) {
                add(commit);
            }
        }
        return this;
    }

    public LogCommand addPath(String str) {
        checkCallable();
        this.pathFilters.add(PathFilter.create(str));
        return this;
    }

    public LogCommand excludePath(String str) {
        checkCallable();
        this.excludeTreeFilters.add(PathFilter.create(str).negate());
        return this;
    }

    public LogCommand setSkip(int i) {
        checkCallable();
        this.skip = i;
        return this;
    }

    public LogCommand setMaxCount(int i) {
        checkCallable();
        this.maxCount = i;
        return this;
    }

    private LogCommand add(boolean z, AnyObjectId anyObjectId) throws IncorrectObjectTypeException, JGitInternalException, MissingObjectException {
        checkCallable();
        try {
            if (z) {
                RevWalk revWalk = this.walk;
                revWalk.markStart(revWalk.lookupCommit(anyObjectId));
                this.startSpecified = true;
                return this;
            }
            RevWalk revWalk2 = this.walk;
            revWalk2.markUninteresting(revWalk2.lookupCommit(anyObjectId));
            return this;
        } catch (IncorrectObjectTypeException e) {
            throw e;
        } catch (MissingObjectException e2) {
            throw e2;
        } catch (IOException e3) {
            throw new JGitInternalException(MessageFormat.format(JGitText.get().exceptionOccurredDuringAddingOfOptionToALogCommand, anyObjectId), e3);
        }
    }

    public LogCommand setRevFilter(RevFilter revFilter) {
        checkCallable();
        this.revFilter = revFilter;
        return this;
    }
}
