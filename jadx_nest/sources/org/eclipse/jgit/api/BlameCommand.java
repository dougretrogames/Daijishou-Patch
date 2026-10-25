package org.eclipse.jgit.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.blame.BlameGenerator;
import org.eclipse.jgit.blame.BlameResult;
import org.eclipse.jgit.diff.DiffAlgorithm;
import org.eclipse.jgit.diff.RawTextComparator;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Repository;

/* JADX INFO: loaded from: classes5.dex */
public class BlameCommand extends GitCommand<BlameResult> {
    private DiffAlgorithm diffAlgorithm;
    private Boolean followFileRenames;
    private String path;
    private Collection<ObjectId> reverseEndCommits;
    private ObjectId startCommit;
    private RawTextComparator textComparator;

    public BlameCommand(Repository repository) {
        super(repository);
    }

    public BlameCommand setFilePath(String str) {
        this.path = str;
        return this;
    }

    public BlameCommand setDiffAlgorithm(DiffAlgorithm diffAlgorithm) {
        this.diffAlgorithm = diffAlgorithm;
        return this;
    }

    public BlameCommand setTextComparator(RawTextComparator rawTextComparator) {
        this.textComparator = rawTextComparator;
        return this;
    }

    public BlameCommand setStartCommit(AnyObjectId anyObjectId) {
        this.startCommit = anyObjectId.toObjectId();
        return this;
    }

    public BlameCommand setFollowFileRenames(boolean z) {
        this.followFileRenames = Boolean.valueOf(z);
        return this;
    }

    public BlameCommand reverse(AnyObjectId anyObjectId, AnyObjectId anyObjectId2) throws IOException {
        return reverse(anyObjectId, Collections.singleton(anyObjectId2.toObjectId()));
    }

    public BlameCommand reverse(AnyObjectId anyObjectId, Collection<ObjectId> collection) throws IOException {
        this.startCommit = anyObjectId.toObjectId();
        this.reverseEndCommits = new ArrayList(collection);
        return this;
    }

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public BlameResult call() throws GitAPIException {
        checkCallable();
        Throwable th = null;
        try {
            BlameGenerator blameGenerator = new BlameGenerator(this.repo, this.path);
            try {
                DiffAlgorithm diffAlgorithm = this.diffAlgorithm;
                if (diffAlgorithm != null) {
                    blameGenerator.setDiffAlgorithm(diffAlgorithm);
                }
                RawTextComparator rawTextComparator = this.textComparator;
                if (rawTextComparator != null) {
                    blameGenerator.setTextComparator(rawTextComparator);
                }
                Boolean bool = this.followFileRenames;
                if (bool != null) {
                    blameGenerator.setFollowFileRenames(bool.booleanValue());
                }
                Collection<ObjectId> collection = this.reverseEndCommits;
                if (collection != null) {
                    blameGenerator.reverse(this.startCommit, collection);
                } else {
                    ObjectId objectId = this.startCommit;
                    if (objectId != null) {
                        blameGenerator.push((String) null, objectId);
                    } else {
                        blameGenerator.prepareHead();
                    }
                }
                return blameGenerator.computeBlameResult();
            } finally {
                blameGenerator.close();
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null == th2) {
                throw null;
            }
            try {
                th.addSuppressed(th2);
                throw null;
            } catch (IOException e) {
                throw new JGitInternalException(e.getMessage(), e);
            }
            throw new JGitInternalException(e.getMessage(), e);
        }
    }
}
