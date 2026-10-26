package org.eclipse.jgit.merge;

import java.io.IOException;
import java.text.MessageFormat;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.NoMergeBaseException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.NullProgressMonitor;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevObject;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.revwalk.filter.RevFilter;
import org.eclipse.jgit.treewalk.AbstractTreeIterator;
import org.eclipse.jgit.treewalk.CanonicalTreeParser;

/* INFO: loaded from: classes5.dex */
public abstract class Merger {

    @Nullable
    protected final Repository db;
    private ObjectInserter inserter;
    protected ProgressMonitor monitor;
    protected ObjectReader reader;
    protected RevCommit[] sourceCommits;
    protected RevObject[] sourceObjects;
    protected RevTree[] sourceTrees;
    protected RevWalk walk;

    public abstract ObjectId getBaseCommitId();

    public abstract ObjectId getResultTreeId();

    protected abstract boolean mergeImpl() throws IOException;

    protected Merger(Repository repository) {
        this.monitor = NullProgressMonitor.INSTANCE;
        if (repository == null) {
            throw new NullPointerException(JGitText.get().repositoryIsRequired);
        }
        this.db = repository;
        ObjectInserter objectInserterNewObjectInserter = repository.newObjectInserter();
        this.inserter = objectInserterNewObjectInserter;
        this.reader = objectInserterNewObjectInserter.newReader();
        this.walk = new RevWalk(this.reader);
    }

    protected Merger(ObjectInserter objectInserter) {
        this.monitor = NullProgressMonitor.INSTANCE;
        this.db = null;
        this.inserter = objectInserter;
        this.reader = objectInserter.newReader();
        this.walk = new RevWalk(this.reader);
    }

    @Nullable
    public Repository getRepository() {
        return this.db;
    }

    protected Repository nonNullRepo() {
        Repository repository = this.db;
        if (repository != null) {
            return repository;
        }
        throw new NullPointerException(JGitText.get().repositoryIsRequired);
    }

    public ObjectInserter getObjectInserter() {
        return this.inserter;
    }

    public void setObjectInserter(ObjectInserter objectInserter) {
        this.walk.close();
        this.reader.close();
        this.inserter.close();
        this.inserter = objectInserter;
        this.reader = objectInserter.newReader();
        this.walk = new RevWalk(this.reader);
    }

    public boolean merge(AnyObjectId... anyObjectIdArr) throws IOException {
        return merge(true, anyObjectIdArr);
    }

    public boolean merge(boolean z, AnyObjectId... anyObjectIdArr) throws IOException {
        RevObject[] revObjectArr;
        this.sourceObjects = new RevObject[anyObjectIdArr.length];
        int i = 0;
        for (int i2 = 0; i2 < anyObjectIdArr.length; i2++) {
            this.sourceObjects[i2] = this.walk.parseAny(anyObjectIdArr[i2]);
        }
        this.sourceCommits = new RevCommit[this.sourceObjects.length];
        int i3 = 0;
        while (true) {
            revObjectArr = this.sourceObjects;
            if (i3 >= revObjectArr.length) {
                break;
            }
            try {
                this.sourceCommits[i3] = this.walk.parseCommit(revObjectArr[i3]);
            } catch (IncorrectObjectTypeException unused) {
                this.sourceCommits[i3] = null;
            }
            i3++;
        }
        this.sourceTrees = new RevTree[revObjectArr.length];
        while (true) {
            RevObject[] revObjectArr2 = this.sourceObjects;
            if (i < revObjectArr2.length) {
                this.sourceTrees[i] = this.walk.parseTree(revObjectArr2[i]);
                i++;
            } else {
                try {
                    break;
                } finally {
                    if (z) {
                        this.inserter.close();
                    }
                    this.reader.close();
                }
            }
        }
        boolean zMergeImpl = mergeImpl();
        if (zMergeImpl && z) {
            this.inserter.flush();
        }
        return zMergeImpl;
    }

    protected RevCommit getBaseCommit(RevCommit revCommit, RevCommit revCommit2) throws IOException {
        this.walk.reset();
        this.walk.setRevFilter(RevFilter.MERGE_BASE);
        this.walk.markStart(revCommit);
        this.walk.markStart(revCommit2);
        RevCommit next = this.walk.next();
        if (next == null) {
            return null;
        }
        RevCommit next2 = this.walk.next();
        if (next2 == null) {
            return next;
        }
        throw new NoMergeBaseException(NoMergeBaseException.MergeBaseFailureReason.MULTIPLE_MERGE_BASES_NOT_SUPPORTED, MessageFormat.format(JGitText.get().multipleMergeBasesFor, revCommit.name(), revCommit2.name(), next.name(), next2.name()));
    }

    protected AbstractTreeIterator openTree(AnyObjectId anyObjectId) throws IOException {
        return new CanonicalTreeParser(null, this.reader, anyObjectId);
    }

    public void setProgressMonitor(ProgressMonitor progressMonitor) {
        if (progressMonitor == null) {
            this.monitor = NullProgressMonitor.INSTANCE;
        } else {
            this.monitor = progressMonitor;
        }
    }
}
