package org.eclipse.jgit.merge;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.dircache.DirCache;
import org.eclipse.jgit.errors.NoMergeBaseException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.CommitBuilder;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.filter.RevFilter;
import org.eclipse.jgit.treewalk.AbstractTreeIterator;
import org.eclipse.jgit.treewalk.EmptyTreeIterator;
import org.eclipse.jgit.treewalk.WorkingTreeIterator;

/* INFO: loaded from: classes5.dex */
public class RecursiveMerger extends ResolveMerger {
    public final int MAX_BASES;

    protected RecursiveMerger(Repository repository, boolean z) {
        super(repository, z);
        this.MAX_BASES = 200;
    }

    protected RecursiveMerger(Repository repository) {
        this(repository, false);
    }

    protected RecursiveMerger(ObjectInserter objectInserter, Config config) {
        super(objectInserter, config);
        this.MAX_BASES = 200;
    }

    @Override // org.eclipse.jgit.merge.Merger
    protected RevCommit getBaseCommit(RevCommit revCommit, RevCommit revCommit2) throws IOException {
        return getBaseCommit(revCommit, revCommit2, 0);
    }

    protected RevCommit getBaseCommit(RevCommit revCommit, RevCommit revCommit2, int i) throws IOException {
        AbstractTreeIterator abstractTreeIteratorOpenTree;
        ArrayList arrayList = new ArrayList();
        this.walk.reset();
        this.walk.setRevFilter(RevFilter.MERGE_BASE);
        this.walk.markStart(revCommit);
        this.walk.markStart(revCommit2);
        while (true) {
            RevCommit next = this.walk.next();
            if (next == null) {
                break;
            }
            arrayList.add(next);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (arrayList.size() == 1) {
            return (RevCommit) arrayList.get(0);
        }
        if (arrayList.size() >= 200) {
            throw new NoMergeBaseException(NoMergeBaseException.MergeBaseFailureReason.TOO_MANY_MERGE_BASES, MessageFormat.format(JGitText.get().mergeRecursiveTooManyMergeBasesFor, 200, revCommit.name(), revCommit2.name(), Integer.valueOf(arrayList.size())));
        }
        RevCommit revCommitCreateCommitForTree = (RevCommit) arrayList.get(0);
        DirCache dirCache = this.dircache;
        boolean z = this.inCore;
        WorkingTreeIterator workingTreeIterator = this.workingTreeIterator;
        this.workingTreeIterator = null;
        try {
            this.dircache = DirCache.read(this.reader, revCommitCreateCommitForTree.getTree());
            this.inCore = true;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(revCommitCreateCommitForTree);
            for (int i2 = 1; i2 < arrayList.size(); i2++) {
                RevCommit revCommit3 = (RevCommit) arrayList.get(i2);
                if (i2 >= 200) {
                    throw new NoMergeBaseException(NoMergeBaseException.MergeBaseFailureReason.TOO_MANY_MERGE_BASES, MessageFormat.format(JGitText.get().mergeRecursiveTooManyMergeBasesFor, 200, revCommit.name(), revCommit2.name(), Integer.valueOf(arrayList.size())));
                }
                arrayList2.add(revCommit3);
                RevCommit baseCommit = getBaseCommit(revCommitCreateCommitForTree, revCommit3, i + 1);
                if (baseCommit == null) {
                    abstractTreeIteratorOpenTree = new EmptyTreeIterator();
                } else {
                    abstractTreeIteratorOpenTree = openTree(baseCommit.getTree());
                }
                if (mergeTrees(abstractTreeIteratorOpenTree, revCommitCreateCommitForTree.getTree(), revCommit3.getTree(), true)) {
                    revCommitCreateCommitForTree = createCommitForTree(this.resultTree, arrayList2);
                } else {
                    throw new NoMergeBaseException(NoMergeBaseException.MergeBaseFailureReason.CONFLICTS_DURING_MERGE_BASE_CALCULATION, MessageFormat.format(JGitText.get().mergeRecursiveConflictsWhenMergingCommonAncestors, revCommitCreateCommitForTree.getName(), revCommit3.getName(), failingPathsMessage()));
                }
            }
            this.inCore = z;
            this.dircache = dirCache;
            this.workingTreeIterator = workingTreeIterator;
            this.unmergedPaths.clear();
            this.mergeResults.clear();
            this.failingPaths.clear();
            return revCommitCreateCommitForTree;
        } catch (Throwable th) {
            this.inCore = z;
            this.dircache = dirCache;
            this.workingTreeIterator = workingTreeIterator;
            this.unmergedPaths.clear();
            this.mergeResults.clear();
            this.failingPaths.clear();
            throw th;
        }
    }

    private RevCommit createCommitForTree(ObjectId objectId, List<RevCommit> list) throws IOException {
        CommitBuilder commitBuilder = new CommitBuilder();
        commitBuilder.setTreeId(objectId);
        commitBuilder.setParentIds(list);
        commitBuilder.setAuthor(mockAuthor(list));
        commitBuilder.setCommitter(commitBuilder.getAuthor());
        return RevCommit.parse(this.walk, commitBuilder.build());
    }

    private static PersonIdent mockAuthor(List<RevCommit> list) {
        Iterator<RevCommit> it = list.iterator();
        int iMax = 0;
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().getCommitTime());
        }
        return new PersonIdent("RecursiveMerger", "RecursiveMerger@JGit", new Date(((long) (iMax + 1)) * 1000), TimeZone.getTimeZone("GMT+0000"));
    }

    private String failingPathsMessage() {
        String str = (String) this.failingPaths.entrySet().stream().limit(25).map(new RecursiveMerger$$ExternalSyntheticLambda0()).collect(Collectors.joining("\n"));
        return this.failingPaths.size() > 25 ? String.format("%s\n... (%s failing paths omitted)", str, Integer.valueOf(this.failingPaths.size() - 25)) : str;
    }

    static /* synthetic */ String lambda$0(Map.Entry entry) {
        return ((String) entry.getKey()) + CollectionUtils.COLON + String.valueOf(entry.getValue());
    }
}
