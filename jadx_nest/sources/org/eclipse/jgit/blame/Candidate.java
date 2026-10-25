package org.eclipse.jgit.blame;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.diff.Edit;
import org.eclipse.jgit.diff.EditList;
import org.eclipse.jgit.diff.RawText;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevFlag;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.treewalk.filter.PathFilter;
import org.eclipse.jgit.util.LfsFactory;

/* JADX INFO: loaded from: classes5.dex */
class Candidate {
    Candidate queueNext;
    Region regionList;
    int renameScore;
    ObjectId sourceBlob;
    RevCommit sourceCommit;
    PathFilter sourcePath;
    private Repository sourceRepository;
    RawText sourceText;

    Candidate getNextCandidate(int i) {
        return null;
    }

    Candidate(Repository repository, RevCommit revCommit, PathFilter pathFilter) {
        this.sourceRepository = repository;
        this.sourceCommit = revCommit;
        this.sourcePath = pathFilter;
    }

    void beginResult(RevWalk revWalk) throws IOException {
        revWalk.parseBody(this.sourceCommit);
    }

    int getParentCount() {
        return this.sourceCommit.getParentCount();
    }

    RevCommit getParent(int i) {
        return this.sourceCommit.getParent(i);
    }

    boolean has(RevFlag revFlag) {
        return this.sourceCommit.has(revFlag);
    }

    void add(RevFlag revFlag) {
        this.sourceCommit.add(revFlag);
    }

    void remove(RevFlag revFlag) {
        this.sourceCommit.remove(revFlag);
    }

    int getTime() {
        return this.sourceCommit.getCommitTime();
    }

    PersonIdent getAuthor() {
        return this.sourceCommit.getAuthorIdent();
    }

    Candidate create(Repository repository, RevCommit revCommit, PathFilter pathFilter) {
        return new Candidate(repository, revCommit, pathFilter);
    }

    Candidate copy(RevCommit revCommit) {
        Candidate candidateCreate = create(this.sourceRepository, revCommit, this.sourcePath);
        candidateCreate.sourceBlob = this.sourceBlob;
        candidateCreate.sourceText = this.sourceText;
        candidateCreate.regionList = this.regionList;
        candidateCreate.renameScore = this.renameScore;
        return candidateCreate;
    }

    void loadText(ObjectReader objectReader) throws IOException {
        this.sourceText = new RawText(LfsFactory.getInstance().applySmudgeFilter(this.sourceRepository, objectReader.open(this.sourceBlob, 3), LfsFactory.getAttributesForPath(this.sourceRepository, this.sourcePath.getPath(), this.sourceCommit).get("diff")).getCachedBytes(Integer.MAX_VALUE));
    }

    void takeBlame(EditList editList, Candidate candidate) {
        blame(editList, this, candidate);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0089  */
    /* JADX WARN: Code duplicated, block: B:36:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:38:0x0094 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x00a3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x004d A[SYNTHETIC] */
    private static void blame(EditList editList, Candidate candidate, Candidate candidate2) {
        int i;
        Region region;
        Region regionClearRegionList = candidate2.clearRegionList();
        Region regionAdd = null;
        int i2 = 0;
        Region regionAdd2 = null;
        while (i2 < editList.size()) {
            if (regionClearRegionList == null) {
                return;
            }
            Edit edit = editList.get(i2);
            if (edit.getEndB() > regionClearRegionList.sourceStart) {
                if (regionClearRegionList.sourceStart < edit.getBeginB()) {
                    int beginB = edit.getBeginB() - regionClearRegionList.sourceStart;
                    if (regionClearRegionList.length <= beginB) {
                        region = regionClearRegionList.next;
                        regionClearRegionList.sourceStart = edit.getBeginA() - beginB;
                        regionAdd = add(regionAdd, candidate, regionClearRegionList);
                    } else {
                        regionAdd = add(regionAdd, candidate, regionClearRegionList.splitFirst(edit.getBeginA() - beginB, beginB));
                        regionClearRegionList.slideAndShrink(beginB);
                        if (edit.getLengthB() != 0) {
                            i = regionClearRegionList.sourceStart + regionClearRegionList.length;
                            if (i <= edit.getEndB()) {
                                region = regionClearRegionList.next;
                                regionAdd2 = add(regionAdd2, candidate2, regionClearRegionList);
                                if (i == edit.getEndB()) {
                                    i2++;
                                }
                            } else {
                                int endB = edit.getEndB() - regionClearRegionList.sourceStart;
                                regionAdd2 = add(regionAdd2, candidate2, regionClearRegionList.splitFirst(regionClearRegionList.sourceStart, endB));
                                regionClearRegionList.slideAndShrink(endB);
                            }
                        }
                    }
                    regionClearRegionList = region;
                } else if (edit.getLengthB() != 0) {
                    i = regionClearRegionList.sourceStart + regionClearRegionList.length;
                    if (i <= edit.getEndB()) {
                        region = regionClearRegionList.next;
                        regionAdd2 = add(regionAdd2, candidate2, regionClearRegionList);
                        if (i == edit.getEndB()) {
                            i2++;
                        }
                        regionClearRegionList = region;
                    } else {
                        int endB2 = edit.getEndB() - regionClearRegionList.sourceStart;
                        regionAdd2 = add(regionAdd2, candidate2, regionClearRegionList.splitFirst(regionClearRegionList.sourceStart, endB2));
                        regionClearRegionList.slideAndShrink(endB2);
                    }
                }
            }
            i2++;
        }
        if (regionClearRegionList == null) {
            return;
        }
        Edit edit2 = editList.get(editList.size() - 1);
        int endB3 = edit2.getEndB();
        int endA = endB3 - edit2.getEndA();
        if (regionAdd == null) {
            candidate.regionList = regionClearRegionList;
        } else {
            regionAdd.next = regionClearRegionList;
        }
        do {
            if (endB3 <= regionClearRegionList.sourceStart) {
                regionClearRegionList.sourceStart -= endA;
            }
            regionClearRegionList = regionClearRegionList.next;
        } while (regionClearRegionList != null);
    }

    private static Region add(Region region, Candidate candidate, Region region2) {
        if (region == null) {
            candidate.regionList = region2;
            region2.next = null;
            return region2;
        }
        if (region.resultStart + region.length == region2.resultStart && region.sourceStart + region.length == region2.sourceStart) {
            region.length += region2.length;
            return region;
        }
        region.next = region2;
        region2.next = null;
        return region2;
    }

    private Region clearRegionList() {
        Region region = this.regionList;
        this.regionList = null;
        return region;
    }

    boolean canMergeRegions(Candidate candidate) {
        return Objects.equals(this.sourceCommit, candidate.sourceCommit) && this.sourcePath.getPath().equals(candidate.sourcePath.getPath());
    }

    void mergeRegions(Candidate candidate) {
        Region regionClearRegionList = clearRegionList();
        Region regionClearRegionList2 = candidate.clearRegionList();
        Region regionAdd = null;
        while (regionClearRegionList != null && regionClearRegionList2 != null) {
            if (regionClearRegionList.resultStart < regionClearRegionList2.resultStart) {
                Region region = regionClearRegionList.next;
                regionAdd = add(regionAdd, this, regionClearRegionList);
                regionClearRegionList = region;
            } else {
                Region region2 = regionClearRegionList2.next;
                regionAdd = add(regionAdd, this, regionClearRegionList2);
                regionClearRegionList2 = region2;
            }
        }
        if (regionClearRegionList != null) {
            add(regionAdd, this, regionClearRegionList).next = regionClearRegionList.next;
        } else {
            add(regionAdd, this, regionClearRegionList2).next = regionClearRegionList2.next;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Candidate[");
        sb.append(this.sourcePath.getPath());
        if (this.sourceCommit != null) {
            sb.append(" @ ").append(this.sourceCommit.abbreviate(6).name());
        }
        if (this.regionList != null) {
            sb.append(" regions:").append(this.regionList);
        }
        sb.append(CollectionUtils.DEFAULT_TOSTRING_SUFFIX);
        return sb.toString();
    }

    static final class ReverseCandidate extends Candidate {
        ReverseCandidate(Repository repository, ReverseWalk.ReverseCommit reverseCommit, PathFilter pathFilter) {
            super(repository, reverseCommit, pathFilter);
        }

        @Override // org.eclipse.jgit.blame.Candidate
        int getParentCount() {
            return ((ReverseWalk.ReverseCommit) this.sourceCommit).getChildCount();
        }

        @Override // org.eclipse.jgit.blame.Candidate
        RevCommit getParent(int i) {
            return ((ReverseWalk.ReverseCommit) this.sourceCommit).getChild(i);
        }

        @Override // org.eclipse.jgit.blame.Candidate
        int getTime() {
            return -this.sourceCommit.getCommitTime();
        }

        @Override // org.eclipse.jgit.blame.Candidate
        Candidate create(Repository repository, RevCommit revCommit, PathFilter pathFilter) {
            return new ReverseCandidate(repository, (ReverseWalk.ReverseCommit) revCommit, pathFilter);
        }

        @Override // org.eclipse.jgit.blame.Candidate
        public String toString() {
            return "Reverse" + super.toString();
        }
    }

    static final class HeadCandidate extends Candidate {
        private List<RevCommit> parents;

        @Override // org.eclipse.jgit.blame.Candidate
        void add(RevFlag revFlag) {
        }

        @Override // org.eclipse.jgit.blame.Candidate
        void beginResult(RevWalk revWalk) {
        }

        @Override // org.eclipse.jgit.blame.Candidate
        int getTime() {
            return Integer.MAX_VALUE;
        }

        @Override // org.eclipse.jgit.blame.Candidate
        boolean has(RevFlag revFlag) {
            return true;
        }

        @Override // org.eclipse.jgit.blame.Candidate
        void remove(RevFlag revFlag) {
        }

        HeadCandidate(Repository repository, PathFilter pathFilter, List<RevCommit> list) {
            super(repository, null, pathFilter);
            this.parents = list;
        }

        @Override // org.eclipse.jgit.blame.Candidate
        int getParentCount() {
            return this.parents.size();
        }

        @Override // org.eclipse.jgit.blame.Candidate
        RevCommit getParent(int i) {
            return this.parents.get(i);
        }

        @Override // org.eclipse.jgit.blame.Candidate
        PersonIdent getAuthor() {
            return new PersonIdent(JGitText.get().blameNotCommittedYet, "");
        }
    }

    static final class BlobCandidate extends Candidate {
        String description;
        Candidate parent;

        @Override // org.eclipse.jgit.blame.Candidate
        void add(RevFlag revFlag) {
        }

        @Override // org.eclipse.jgit.blame.Candidate
        void beginResult(RevWalk revWalk) {
        }

        @Override // org.eclipse.jgit.blame.Candidate
        RevCommit getParent(int i) {
            return null;
        }

        @Override // org.eclipse.jgit.blame.Candidate
        int getTime() {
            return Integer.MAX_VALUE;
        }

        @Override // org.eclipse.jgit.blame.Candidate
        boolean has(RevFlag revFlag) {
            return true;
        }

        @Override // org.eclipse.jgit.blame.Candidate
        void remove(RevFlag revFlag) {
        }

        BlobCandidate(Repository repository, String str, PathFilter pathFilter) {
            super(repository, null, pathFilter);
            this.description = str;
        }

        @Override // org.eclipse.jgit.blame.Candidate
        int getParentCount() {
            return this.parent != null ? 1 : 0;
        }

        @Override // org.eclipse.jgit.blame.Candidate
        Candidate getNextCandidate(int i) {
            return this.parent;
        }

        @Override // org.eclipse.jgit.blame.Candidate
        PersonIdent getAuthor() {
            return new PersonIdent(this.description, "");
        }
    }
}
