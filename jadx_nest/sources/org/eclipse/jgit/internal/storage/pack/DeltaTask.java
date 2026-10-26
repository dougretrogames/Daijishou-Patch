package org.eclipse.jgit.internal.storage.pack;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.ThreadSafeProgressMonitor;
import org.eclipse.jgit.storage.pack.PackConfig;

/* INFO: loaded from: classes5.dex */
final class DeltaTask implements Callable<Object> {
    static final long MAX_METER = 9437184;
    private final Block block;
    private DeltaWindow dw;
    private ObjectReader or;
    final ArrayDeque<Slice> slices = new ArrayDeque<>();

    static final class Block {
        private static final int MIN_TOP_PATH = 52428800;
        final int beginIndex;
        long bytesPerUnit;
        final PackConfig config;
        final DeltaCache dc;
        final int endIndex;
        final ObjectToPack[] list;
        final ThreadSafeProgressMonitor pm;
        final List<DeltaTask> tasks;
        final ObjectReader templateReader;
        final int threads;
        private long totalWeight;

        Block(int i, PackConfig packConfig, ObjectReader objectReader, DeltaCache deltaCache, ThreadSafeProgressMonitor threadSafeProgressMonitor, ObjectToPack[] objectToPackArr, int i2, int i3) {
            this.tasks = new ArrayList(i);
            this.threads = i;
            this.config = packConfig;
            this.templateReader = objectReader;
            this.dc = deltaCache;
            this.pm = threadSafeProgressMonitor;
            this.list = objectToPackArr;
            this.beginIndex = i2;
            this.endIndex = i3;
        }

        int cost() {
            long j = this.totalWeight;
            long j2 = this.bytesPerUnit;
            int i = (int) (j / j2);
            return j % j2 != 0 ? i + 1 : i;
        }

        synchronized DeltaWindow stealWork(DeltaTask deltaTask) {
            DeltaTask deltaTask2;
            Slice slice;
            do {
                int size = 0;
                deltaTask2 = null;
                slice = null;
                for (DeltaTask deltaTask3 : this.tasks) {
                    Slice sliceRemaining = deltaTask3.remaining();
                    if (sliceRemaining != null && size < sliceRemaining.size()) {
                        size = sliceRemaining.size();
                        deltaTask2 = deltaTask3;
                        slice = sliceRemaining;
                    }
                }
                if (deltaTask2 == null) {
                    return null;
                }
            } while (!deltaTask2.tryStealWork(slice));
            return deltaTask.initWindow(slice);
        }

        void partitionTasks() {
            long adjustedWeight;
            ArrayList<WeightedPath> arrayListComputeTopPaths = computeTopPaths();
            Iterator<WeightedPath> it = arrayListComputeTopPaths.iterator();
            long jMax = Math.max(this.totalWeight / ((long) this.threads), 1L);
            int i = this.beginIndex;
            int i2 = 0;
            while (i < this.endIndex) {
                DeltaTask deltaTask = new DeltaTask(this);
                if (it.hasNext()) {
                    WeightedPath next = it.next();
                    adjustedWeight = next.weight;
                    deltaTask.add(next.slice);
                } else {
                    adjustedWeight = 0;
                }
                int i3 = i2;
                int i4 = i;
                while (adjustedWeight < jMax && i < this.endIndex) {
                    if (i3 < arrayListComputeTopPaths.size() && i == arrayListComputeTopPaths.get(i3).slice.beginIndex) {
                        if (i4 < i) {
                            deltaTask.add(new Slice(i4, i));
                        }
                        i4 = arrayListComputeTopPaths.get(i3).slice.endIndex;
                        i3++;
                        i = i4;
                    } else {
                        adjustedWeight += (long) DeltaTask.getAdjustedWeight(this.list[i]);
                        i++;
                    }
                }
                if (i4 < i) {
                    int pathHash = this.list[i - 1].getPathHash();
                    while (i < this.endIndex && pathHash == this.list[i].getPathHash()) {
                        i++;
                    }
                    deltaTask.add(new Slice(i4, i));
                }
                if (!deltaTask.slices.isEmpty()) {
                    this.tasks.add(deltaTask);
                }
                i2 = i3;
            }
            while (it.hasNext()) {
                WeightedPath next2 = it.next();
                DeltaTask deltaTask2 = new DeltaTask(this);
                deltaTask2.add(next2.slice);
                this.tasks.add(deltaTask2);
            }
        }

        private ArrayList<WeightedPath> computeTopPaths() {
            ArrayList<WeightedPath> arrayList = new ArrayList<>(this.threads);
            int i = this.beginIndex;
            int pathHash = this.list[i].getPathHash();
            long adjustedWeight = DeltaTask.getAdjustedWeight(this.list[i]);
            this.totalWeight = adjustedWeight;
            for (int i2 = i + 1; i2 < this.endIndex; i2++) {
                ObjectToPack objectToPack = this.list[i2];
                if (pathHash != objectToPack.getPathHash()) {
                    if (PackConfig.DEFAULT_DELTA_CACHE_SIZE < adjustedWeight) {
                        if (arrayList.size() < this.threads) {
                            arrayList.add(new WeightedPath(adjustedWeight, new Slice(i, i2)));
                            if (arrayList.size() == this.threads) {
                                Collections.sort(arrayList);
                            }
                        } else if (arrayList.get(0).weight < adjustedWeight) {
                            WeightedPath weightedPath = new WeightedPath(adjustedWeight, new Slice(i, i2));
                            arrayList.set(0, weightedPath);
                            if (weightedPath.compareTo(arrayList.get(1)) > 0) {
                                Collections.sort(arrayList);
                            }
                        }
                    }
                    adjustedWeight = 0;
                    pathHash = objectToPack.getPathHash();
                    i = i2;
                }
                long adjustedWeight2 = DeltaTask.getAdjustedWeight(objectToPack);
                adjustedWeight += adjustedWeight2;
                this.totalWeight += adjustedWeight2;
            }
            Collections.sort(arrayList, new DeltaTask$Block$$ExternalSyntheticLambda0());
            this.bytesPerUnit = 1L;
            while (true) {
                long j = this.totalWeight;
                long j2 = this.bytesPerUnit;
                if (DeltaTask.MAX_METER > j / j2) {
                    return arrayList;
                }
                this.bytesPerUnit = j2 << 10;
            }
        }

        static /* synthetic */ int lambda$0(WeightedPath weightedPath, WeightedPath weightedPath2) {
            return weightedPath.slice.beginIndex - weightedPath2.slice.beginIndex;
        }
    }

    static int getAdjustedWeight(ObjectToPack objectToPack) {
        if (objectToPack.isEdge() || objectToPack.doNotAttemptDelta()) {
            return 0;
        }
        return objectToPack.getWeight();
    }

    static final class WeightedPath implements Comparable<WeightedPath> {
        final Slice slice;
        final long weight;

        WeightedPath(long j, Slice slice) {
            this.weight = j;
            this.slice = slice;
        }

        @Override // java.lang.Comparable
        public int compareTo(WeightedPath weightedPath) {
            int iSignum = Long.signum(this.weight - weightedPath.weight);
            return iSignum != 0 ? iSignum : this.slice.beginIndex - weightedPath.slice.beginIndex;
        }
    }

    static final class Slice {
        final int beginIndex;
        final int endIndex;

        Slice(int i, int i2) {
            this.beginIndex = i;
            this.endIndex = i2;
        }

        final int size() {
            return this.endIndex - this.beginIndex;
        }
    }

    DeltaTask(Block block) {
        this.block = block;
    }

    void add(Slice slice) {
        if (!this.slices.isEmpty()) {
            Slice last = this.slices.getLast();
            if (last.endIndex == slice.beginIndex) {
                this.slices.removeLast();
                this.slices.add(new Slice(last.beginIndex, slice.endIndex));
                return;
            }
        }
        this.slices.add(slice);
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        DeltaWindow deltaWindowInitWindow;
        this.or = this.block.templateReader.newReader();
        while (true) {
            try {
                synchronized (this) {
                    if (this.slices.isEmpty()) {
                        break;
                    }
                    deltaWindowInitWindow = initWindow(this.slices.removeFirst());
                }
                runWindow(deltaWindowInitWindow);
            } catch (Throwable th) {
                this.block.pm.endWorker();
                this.or.close();
                this.or = null;
                throw th;
            }
        }
        while (true) {
            DeltaWindow deltaWindowStealWork = this.block.stealWork(this);
            if (deltaWindowStealWork != null) {
                runWindow(deltaWindowStealWork);
            } else {
                this.block.pm.endWorker();
                this.or.close();
                this.or = null;
                return null;
            }
        }
    }

    DeltaWindow initWindow(Slice slice) {
        DeltaWindow deltaWindow = new DeltaWindow(this.block.config, this.block.dc, this.or, this.block.pm, this.block.bytesPerUnit, this.block.list, slice.beginIndex, slice.endIndex);
        synchronized (this) {
            this.dw = deltaWindow;
        }
        return deltaWindow;
    }

    private void runWindow(DeltaWindow deltaWindow) throws IOException {
        try {
            deltaWindow.search();
            synchronized (this) {
                this.dw = null;
            }
        } catch (Throwable th) {
            synchronized (this) {
                this.dw = null;
                throw th;
            }
        }
    }

    synchronized Slice remaining() {
        if (!this.slices.isEmpty()) {
            return this.slices.getLast();
        }
        DeltaWindow deltaWindow = this.dw;
        return deltaWindow != null ? deltaWindow.remaining() : null;
    }

    synchronized boolean tryStealWork(Slice slice) {
        if (!this.slices.isEmpty() && this.slices.getLast().beginIndex == slice.beginIndex) {
            this.slices.removeLast();
            return true;
        }
        DeltaWindow deltaWindow = this.dw;
        return deltaWindow != null ? deltaWindow.tryStealWork(slice) : false;
    }
}
