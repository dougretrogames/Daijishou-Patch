package org.eclipse.jgit.api;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.errors.InvalidPatternException;
import org.eclipse.jgit.fnmatch.FileNameMatcher;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AbbrevConfig;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevFlag;
import org.eclipse.jgit.revwalk.RevFlagSet;
import org.eclipse.jgit.revwalk.RevTag;
import org.eclipse.jgit.revwalk.RevWalk;

/* INFO: loaded from: classes5.dex */
public class DescribeCommand extends GitCommand<String> {
    private final Comparator<Ref> TAG_TIE_BREAKER;
    private int abbrev;
    private boolean always;
    private boolean longDesc;
    private List<FileNameMatcher> matchers;
    private int maxCandidates;
    private RevCommit target;
    private boolean useAll;
    private boolean useTags;
    private final RevWalk w;

    static /* synthetic */ Stream lambda$1(Stream stream) {
        return stream;
    }

    protected DescribeCommand(Repository repository) {
        super(repository);
        this.maxCandidates = 10;
        this.matchers = new ArrayList();
        this.abbrev = Integer.MIN_VALUE;
        this.TAG_TIE_BREAKER = new AnonymousClass1();
        RevWalk revWalk = new RevWalk(repository);
        this.w = revWalk;
        revWalk.setRetainBody(false);
    }

    public DescribeCommand setTarget(ObjectId objectId) throws IOException {
        this.target = this.w.parseCommit(objectId);
        return this;
    }

    public DescribeCommand setTarget(String str) throws RefNotFoundException, IOException {
        ObjectId objectIdResolve = this.repo.resolve(str);
        if (objectIdResolve == null) {
            throw new RefNotFoundException(MessageFormat.format(JGitText.get().refNotResolved, str));
        }
        return setTarget(objectIdResolve);
    }

    public DescribeCommand setLong(boolean z) {
        this.longDesc = z;
        return this;
    }

    public DescribeCommand setAll(boolean z) {
        this.useAll = z;
        return this;
    }

    public DescribeCommand setTags(boolean z) {
        this.useTags = z;
        return this;
    }

    public DescribeCommand setAlways(boolean z) {
        this.always = z;
        return this;
    }

    public DescribeCommand setAbbrev(int i) {
        if (i == 0) {
            this.abbrev = 0;
            return this;
        }
        this.abbrev = AbbrevConfig.capAbbrev(i);
        return this;
    }

    /* INFO: Access modifiers changed from: private */
    public String longDescription(Ref ref, int i, ObjectId objectId) throws IOException {
        if (this.abbrev == 0) {
            return formatRefName(ref.getName());
        }
        return String.format("%s-%d-g%s", formatRefName(ref.getName()), Integer.valueOf(i), this.w.getObjectReader().abbreviate(objectId, this.abbrev).name());
    }

    public DescribeCommand setMatch(String... strArr) throws InvalidPatternException {
        for (String str : strArr) {
            this.matchers.add(new FileNameMatcher(str, (Character) null));
        }
        return this;
    }

    /* INFO: renamed from: org.eclipse.jgit.api.DescribeCommand$1, reason: invalid class name */
    class AnonymousClass1 implements Comparator<Ref> {
        AnonymousClass1() {
        }

        @Override // java.util.Comparator
        public int compare(Ref ref, Ref ref2) {
            try {
                return tagDate(ref2).compareTo(tagDate(ref));
            } catch (IOException unused) {
                return 0;
            }
        }

        private Date tagDate(Ref ref) throws IOException {
            RevTag tag = DescribeCommand.this.w.parseTag(ref.getObjectId());
            DescribeCommand.this.w.parseBody(tag);
            return tag.getTaggerIdent().getWhen();
        }
    }

    private Optional<Ref> getBestMatch(List<Ref> list) {
        if (list == null || list.isEmpty()) {
            return Optional.empty();
        }
        if (this.matchers.isEmpty()) {
            Collections.sort(list, this.TAG_TIE_BREAKER);
            return Optional.of(list.get(0));
        }
        Stream streamEmpty = Stream.empty();
        Iterator<FileNameMatcher> it = this.matchers.iterator();
        while (it.hasNext()) {
            streamEmpty = Stream.of((Object[]) new Stream[]{streamEmpty, list.stream().filter(new DescribeCommand$$ExternalSyntheticLambda3(this, it.next()))}).flatMap(new DescribeCommand$$ExternalSyntheticLambda4());
        }
        return streamEmpty.sorted(this.TAG_TIE_BREAKER).findFirst();
    }

    /* INFO: renamed from: lambda$0$org-eclipse-jgit-api-DescribeCommand, reason: not valid java name */
    /* synthetic */ boolean m5648lambda$0$orgeclipsejgitapiDescribeCommand(FileNameMatcher fileNameMatcher, Ref ref) {
        fileNameMatcher.append(formatRefName(ref.getName()));
        boolean zIsMatch = fileNameMatcher.isMatch();
        fileNameMatcher.reset();
        return zIsMatch;
    }

    /* INFO: Access modifiers changed from: private */
    public ObjectId getObjectIdFromRef(Ref ref) throws JGitInternalException {
        try {
            ObjectId peeledObjectId = this.repo.getRefDatabase().peel(ref).getPeeledObjectId();
            return peeledObjectId == null ? ref.getObjectId() : peeledObjectId;
        } catch (IOException e) {
            throw new JGitInternalException(e.getMessage(), e);
        }
    }

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public String call() throws GitAPIException {
        String strDescribe;
        try {
            try {
                checkCallable();
                if (this.target == null) {
                    setTarget("HEAD");
                }
                if (this.abbrev == Integer.MIN_VALUE) {
                    this.abbrev = AbbrevConfig.parseFromConfig(this.repo).get();
                }
                Map map = (Map) this.repo.getRefDatabase().getRefsByPrefix(this.useAll ? Constants.R_REFS : Constants.R_TAGS).stream().filter(new DescribeCommand$$ExternalSyntheticLambda0(this)).collect(Collectors.groupingBy(new DescribeCommand$$ExternalSyntheticLambda1(this)));
                RevFlagSet revFlagSet = new RevFlagSet();
                ArrayList<C1Candidate> arrayList = new ArrayList();
                Optional<Ref> bestMatch = getBestMatch((List) map.get(this.target));
                if (bestMatch.isPresent()) {
                    strDescribe = this.longDesc ? longDescription(bestMatch.get(), 0, this.target) : formatRefName(bestMatch.get().getName());
                } else {
                    this.w.markStart(this.target);
                    int i = 0;
                    while (true) {
                        RevCommit next = this.w.next();
                        if (next == null) {
                            break;
                        }
                        if (!next.hasAny(revFlagSet)) {
                            Optional<Ref> bestMatch2 = getBestMatch((List) map.get(next));
                            if (bestMatch2.isPresent()) {
                                C1Candidate c1Candidate = new C1Candidate(next, bestMatch2.get(), revFlagSet);
                                arrayList.add(c1Candidate);
                                c1Candidate.depth = i;
                            }
                        }
                        for (C1Candidate c1Candidate2 : arrayList) {
                            if (!c1Candidate2.reaches(next)) {
                                c1Candidate2.depth++;
                            }
                        }
                        if (arrayList.size() >= this.maxCandidates) {
                            break;
                        }
                        i++;
                    }
                    while (true) {
                        RevCommit next2 = this.w.next();
                        if (next2 == null) {
                            break;
                        }
                        if (next2.hasAll(revFlagSet)) {
                            for (RevCommit revCommit : next2.getParents()) {
                                revCommit.add(RevFlag.SEEN);
                            }
                        } else {
                            for (C1Candidate c1Candidate3 : arrayList) {
                                if (!c1Candidate3.reaches(next2)) {
                                    c1Candidate3.depth++;
                                }
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        strDescribe = this.always ? this.w.getObjectReader().abbreviate(this.target, AbbrevConfig.capAbbrev(this.abbrev)).name() : null;
                    } else {
                        strDescribe = ((C1Candidate) Collections.min(arrayList, new DescribeCommand$$ExternalSyntheticLambda2())).describe(this.target);
                    }
                }
                setCallable(false);
                this.w.close();
                return strDescribe;
            } catch (IOException e) {
                throw new JGitInternalException(e.getMessage(), e);
            }
        } catch (Throwable th) {
            setCallable(false);
            this.w.close();
            throw th;
        }
    }

    /* INFO: renamed from: org.eclipse.jgit.api.DescribeCommand$1Candidate, reason: invalid class name */
    class C1Candidate {
        int depth;
        final RevFlag flag;
        final Ref tag;

        C1Candidate(RevCommit revCommit, Ref ref, RevFlagSet revFlagSet) {
            this.tag = ref;
            RevFlag revFlagNewFlag = DescribeCommand.this.w.newFlag(ref.getName());
            this.flag = revFlagNewFlag;
            revFlagSet.add(revFlagNewFlag);
            DescribeCommand.this.w.carry(revFlagNewFlag);
            revCommit.add(revFlagNewFlag);
            revCommit.carry(revFlagNewFlag);
        }

        boolean reaches(RevCommit revCommit) {
            return revCommit.has(this.flag);
        }

        String describe(ObjectId objectId) throws IOException {
            return DescribeCommand.this.longDescription(this.tag, this.depth, objectId);
        }
    }

    static /* synthetic */ int lambda$4(C1Candidate c1Candidate, C1Candidate c1Candidate2) {
        return c1Candidate.depth - c1Candidate2.depth;
    }

    private String formatRefName(String str) {
        if (str.startsWith(Constants.R_TAGS)) {
            return str.substring(Constants.R_TAGS.length());
        }
        return str.substring(Constants.R_REFS.length());
    }

    /* INFO: Access modifiers changed from: private */
    public boolean filterLightweightTags(Ref ref) {
        ObjectId objectId = ref.getObjectId();
        try {
            if (this.useAll || this.useTags) {
                return true;
            }
            return (objectId == null || this.w.parseTag(objectId) == null) ? false : true;
        } catch (IOException unused) {
            return false;
        }
    }
}
