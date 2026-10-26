package org.eclipse.jgit.transport;

/* INFO: loaded from: classes5.dex */
public class ReceivedPackStatistics {
    private long numBytesDuplicated;
    private long numBytesRead;
    private long numDeltaBlob;
    private long numDeltaCommit;
    private long numDeltaTag;
    private long numDeltaTree;
    private long numObjectsDuplicated;
    private long numOfsDelta;
    private long numRefDelta;
    private long numWholeBlob;
    private long numWholeCommit;
    private long numWholeTag;
    private long numWholeTree;

    public long getNumBytesRead() {
        return this.numBytesRead;
    }

    public long getNumBytesDuplicated() {
        return this.numBytesDuplicated;
    }

    public long getNumWholeCommit() {
        return this.numWholeCommit;
    }

    public long getNumWholeTree() {
        return this.numWholeTree;
    }

    public long getNumWholeBlob() {
        return this.numWholeBlob;
    }

    public long getNumWholeTag() {
        return this.numWholeTag;
    }

    public long getNumOfsDelta() {
        return this.numOfsDelta;
    }

    public long getNumRefDelta() {
        return this.numRefDelta;
    }

    public long getNumObjectsDuplicated() {
        return this.numObjectsDuplicated;
    }

    public long getNumDeltaCommit() {
        return this.numDeltaCommit;
    }

    public long getNumDeltaTree() {
        return this.numDeltaTree;
    }

    public long getNumDeltaBlob() {
        return this.numDeltaBlob;
    }

    public long getNumDeltaTag() {
        return this.numDeltaTag;
    }

    public static class Builder {
        private long numBytesDuplicated;
        private long numBytesRead;
        private long numDeltaBlob;
        private long numDeltaCommit;
        private long numDeltaTag;
        private long numDeltaTree;
        private long numObjectsDuplicated;
        private long numOfsDelta;
        private long numRefDelta;
        private long numWholeBlob;
        private long numWholeCommit;
        private long numWholeTag;
        private long numWholeTree;

        public Builder setNumBytesRead(long j) {
            this.numBytesRead = j;
            return this;
        }

        Builder incrementNumBytesDuplicated(long j) {
            this.numBytesDuplicated += j;
            return this;
        }

        public Builder addWholeObject(int i) {
            if (i == 1) {
                this.numWholeCommit++;
                return this;
            }
            if (i == 2) {
                this.numWholeTree++;
                return this;
            }
            if (i == 3) {
                this.numWholeBlob++;
                return this;
            }
            if (i == 4) {
                this.numWholeTag++;
                return this;
            }
            throw new IllegalArgumentException(i + " cannot be a whole object");
        }

        public Builder addOffsetDelta() {
            this.numOfsDelta++;
            return this;
        }

        public Builder addRefDelta() {
            this.numRefDelta++;
            return this;
        }

        Builder incrementObjectsDuplicated() {
            this.numObjectsDuplicated++;
            return this;
        }

        public Builder addDeltaObject(int i) {
            if (i == 1) {
                this.numDeltaCommit++;
                return this;
            }
            if (i == 2) {
                this.numDeltaTree++;
                return this;
            }
            if (i == 3) {
                this.numDeltaBlob++;
                return this;
            }
            if (i == 4) {
                this.numDeltaTag++;
                return this;
            }
            throw new IllegalArgumentException("delta should be a delta to a whole object. " + i + " cannot be a whole object");
        }

        ReceivedPackStatistics build() {
            ReceivedPackStatistics receivedPackStatistics = new ReceivedPackStatistics();
            receivedPackStatistics.numBytesRead = this.numBytesRead;
            receivedPackStatistics.numBytesDuplicated = this.numBytesDuplicated;
            receivedPackStatistics.numWholeCommit = this.numWholeCommit;
            receivedPackStatistics.numWholeTree = this.numWholeTree;
            receivedPackStatistics.numWholeBlob = this.numWholeBlob;
            receivedPackStatistics.numWholeTag = this.numWholeTag;
            receivedPackStatistics.numOfsDelta = this.numOfsDelta;
            receivedPackStatistics.numRefDelta = this.numRefDelta;
            receivedPackStatistics.numDeltaCommit = this.numDeltaCommit;
            receivedPackStatistics.numDeltaTree = this.numDeltaTree;
            receivedPackStatistics.numDeltaBlob = this.numDeltaBlob;
            receivedPackStatistics.numDeltaTag = this.numDeltaTag;
            receivedPackStatistics.numObjectsDuplicated = this.numObjectsDuplicated;
            return receivedPackStatistics;
        }
    }
}
