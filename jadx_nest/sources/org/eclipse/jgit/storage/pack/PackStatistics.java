package org.eclipse.jgit.storage.pack;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.pack.CachedPack;
import org.eclipse.jgit.lib.ObjectId;

/* JADX INFO: loaded from: classes5.dex */
public class PackStatistics {
    private Accumulator statistics;

    public static class ObjectType {
        private Accumulator objectType;

        public static class Accumulator {
            public long bytes;
            public long cntDeltas;
            public long cntObjects;
            public long deltaBytes;
            public long reusedDeltas;
            public long reusedObjects;
        }

        public ObjectType(Accumulator accumulator) {
            this.objectType = accumulator;
        }

        public long getObjects() {
            return this.objectType.cntObjects;
        }

        public long getDeltas() {
            return this.objectType.cntDeltas;
        }

        public long getReusedObjects() {
            return this.objectType.reusedObjects;
        }

        public long getReusedDeltas() {
            return this.objectType.reusedDeltas;
        }

        public long getBytes() {
            return this.objectType.bytes;
        }

        public long getDeltaBytes() {
            return this.objectType.deltaBytes;
        }
    }

    public static class Accumulator {
        public long advertised;
        public long bitmapIndexMisses;
        public Set<ObjectId> clientShallowCommits;
        public int deltaSearchNonEdgeObjects;
        public int deltasFound;
        public int depth;
        public long haves;
        public Set<ObjectId> interestingObjects;
        public long notAdvertisedWants;
        public ObjectType.Accumulator[] objectTypes;
        public long offloadedPackfileSize;
        public long offloadedPackfiles;
        public long reachabilityCheckDuration;
        public long reusedDeltas;
        public long reusedObjects;
        public List<CachedPack> reusedPacks;
        public Set<ObjectId> rootCommits;
        public long thinPackBytes;
        public long timeCompressing;
        public long timeCounting;
        public long timeNegotiating;
        public long timeSearchingForReuse;
        public long timeSearchingForSizes;
        public long timeWriting;
        public long totalBytes;
        public long totalDeltas;
        public long totalObjects;
        public long treesTraversed;
        public Set<ObjectId> uninterestingObjects;
        public long wants;

        public Accumulator() {
            ObjectType.Accumulator[] accumulatorArr = new ObjectType.Accumulator[5];
            this.objectTypes = accumulatorArr;
            accumulatorArr[1] = new ObjectType.Accumulator();
            this.objectTypes[2] = new ObjectType.Accumulator();
            this.objectTypes[3] = new ObjectType.Accumulator();
            this.objectTypes[4] = new ObjectType.Accumulator();
        }
    }

    public PackStatistics(Accumulator accumulator) {
        this.statistics = accumulator;
    }

    public long getAdvertised() {
        return this.statistics.advertised;
    }

    public long getWants() {
        return this.statistics.wants;
    }

    public long getHaves() {
        return this.statistics.haves;
    }

    public long getNotAdvertisedWants() {
        return this.statistics.notAdvertisedWants;
    }

    public long getTimeNegotiating() {
        return this.statistics.timeNegotiating;
    }

    public Set<ObjectId> getInterestingObjects() {
        return this.statistics.interestingObjects;
    }

    public Set<ObjectId> getUninterestingObjects() {
        return this.statistics.uninterestingObjects;
    }

    public Set<ObjectId> getClientShallowCommits() {
        return this.statistics.clientShallowCommits;
    }

    public List<CachedPack> getReusedPacks() {
        return this.statistics.reusedPacks;
    }

    public Set<ObjectId> getRootCommits() {
        return this.statistics.rootCommits;
    }

    public int getDeltaSearchNonEdgeObjects() {
        return this.statistics.deltaSearchNonEdgeObjects;
    }

    public int getDeltasFound() {
        return this.statistics.deltasFound;
    }

    public long getTotalObjects() {
        return this.statistics.totalObjects;
    }

    public long getBitmapIndexMisses() {
        return this.statistics.bitmapIndexMisses;
    }

    public long getTotalDeltas() {
        return this.statistics.totalDeltas;
    }

    public long getReusedObjects() {
        return this.statistics.reusedObjects;
    }

    public long getReusedDeltas() {
        return this.statistics.reusedDeltas;
    }

    public long getTotalBytes() {
        return this.statistics.totalBytes;
    }

    public long getThinPackBytes() {
        return this.statistics.thinPackBytes;
    }

    public ObjectType byObjectType(int i) {
        return new ObjectType(this.statistics.objectTypes[i]);
    }

    public boolean isShallow() {
        return this.statistics.depth > 0;
    }

    public int getDepth() {
        return this.statistics.depth;
    }

    public long getTimeCounting() {
        return this.statistics.timeCounting;
    }

    public long getTimeSearchingForReuse() {
        return this.statistics.timeSearchingForReuse;
    }

    public long getTimeSearchingForSizes() {
        return this.statistics.timeSearchingForSizes;
    }

    public long getTimeCompressing() {
        return this.statistics.timeCompressing;
    }

    public long getTimeWriting() {
        return this.statistics.timeWriting;
    }

    public long getReachabilityCheckDuration() {
        return this.statistics.reachabilityCheckDuration;
    }

    public long getTreesTraversed() {
        return this.statistics.treesTraversed;
    }

    public long getOffloadedPackfiles() {
        return this.statistics.offloadedPackfiles;
    }

    public long getOffloadedPackfilesSize() {
        return this.statistics.offloadedPackfileSize;
    }

    public long getTimeTotal() {
        return this.statistics.timeCounting + this.statistics.timeSearchingForReuse + this.statistics.timeSearchingForSizes + this.statistics.timeCompressing + this.statistics.timeWriting;
    }

    public double getTransferRate() {
        return getTotalBytes() / (getTimeWriting() / 1000.0d);
    }

    public String getMessage() {
        return MessageFormat.format(JGitText.get().packWriterStatistics, Long.valueOf(this.statistics.totalObjects), Long.valueOf(this.statistics.totalDeltas), Long.valueOf(this.statistics.reusedObjects), Long.valueOf(this.statistics.reusedDeltas));
    }

    public Map<Integer, ObjectType> getObjectTypes() {
        HashMap map = new HashMap();
        map.put(3, new ObjectType(this.statistics.objectTypes[3]));
        map.put(1, new ObjectType(this.statistics.objectTypes[1]));
        map.put(4, new ObjectType(this.statistics.objectTypes[4]));
        map.put(2, new ObjectType(this.statistics.objectTypes[2]));
        return map;
    }
}
