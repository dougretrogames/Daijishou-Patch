package org.eclipse.jgit.revwalk.filter;

import java.io.IOException;
import java.util.Date;
import org.eclipse.jgit.errors.StopWalkException;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;

/* INFO: loaded from: classes5.dex */
public abstract class CommitTimeRevFilter extends RevFilter {
    final int when;

    @Override // org.eclipse.jgit.revwalk.filter.RevFilter
    public RevFilter clone() {
        return this;
    }

    @Override // org.eclipse.jgit.revwalk.filter.RevFilter
    public boolean requiresCommitBody() {
        return false;
    }

    public static final RevFilter before(Date date) {
        return before(date.getTime());
    }

    public static final RevFilter before(long j) {
        return new Before(j);
    }

    public static final RevFilter after(Date date) {
        return after(date.getTime());
    }

    public static final RevFilter after(long j) {
        return new After(j);
    }

    public static final RevFilter between(Date date, Date date2) {
        return between(date.getTime(), date2.getTime());
    }

    public static final RevFilter between(long j, long j2) {
        return new Between(j, j2);
    }

    CommitTimeRevFilter(long j) {
        this.when = (int) (j / 1000);
    }

    private static class Before extends CommitTimeRevFilter {
        Before(long j) {
            super(j);
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public boolean include(RevWalk revWalk, RevCommit revCommit) throws IOException, StopWalkException {
            return revCommit.getCommitTime() <= this.when;
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public String toString() {
            return super.toString() + "(" + String.valueOf(new Date(((long) this.when) * 1000)) + ")";
        }
    }

    private static class After extends CommitTimeRevFilter {
        After(long j) {
            super(j);
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public boolean include(RevWalk revWalk, RevCommit revCommit) throws IOException, StopWalkException {
            if (revCommit.getCommitTime() >= this.when) {
                return true;
            }
            throw StopWalkException.INSTANCE;
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public String toString() {
            return super.toString() + "(" + String.valueOf(new Date(((long) this.when) * 1000)) + ")";
        }
    }

    private static class Between extends CommitTimeRevFilter {
        private final int until;

        Between(long j, long j2) {
            super(j);
            this.until = (int) (j2 / 1000);
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public boolean include(RevWalk revWalk, RevCommit revCommit) throws IOException, StopWalkException {
            return revCommit.getCommitTime() <= this.until && revCommit.getCommitTime() >= this.when;
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public String toString() {
            return super.toString() + "(" + String.valueOf(new Date(((long) this.when) * 1000)) + " - " + String.valueOf(new Date(((long) this.until) * 1000)) + ")";
        }
    }
}
