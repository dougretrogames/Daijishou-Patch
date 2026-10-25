package org.apache.commons.collections4.bloomfilter;

import java.util.TreeMap;
import java.util.function.IntPredicate;

/* JADX INFO: loaded from: classes5.dex */
@FunctionalInterface
public interface CellExtractor extends IndexExtractor {

    @FunctionalInterface
    public interface CellPredicate {
        boolean test(int i, int i2);
    }

    boolean processCells(CellPredicate cellPredicate);

    @Override // org.apache.commons.collections4.bloomfilter.IndexExtractor
    default IndexExtractor uniqueIndices() {
        return this;
    }

    /* JADX INFO: renamed from: org.apache.commons.collections4.bloomfilter.CellExtractor$1, reason: invalid class name */
    class AnonymousClass1 implements CellExtractor {
        TreeMap<CounterCell, CounterCell> counterCells = new TreeMap<>();
        final /* synthetic */ IndexExtractor val$indexExtractor;

        AnonymousClass1(IndexExtractor indexExtractor) {
            this.val$indexExtractor = indexExtractor;
        }

        /* JADX INFO: renamed from: org.apache.commons.collections4.bloomfilter.CellExtractor$1$CounterCell */
        final class CounterCell implements Comparable<CounterCell> {
            int count;
            final int idx;

            CounterCell(int i, int i2) {
                this.idx = i;
                this.count = i2;
            }

            @Override // java.lang.Comparable
            public int compareTo(CounterCell counterCell) {
                return Integer.compare(this.idx, counterCell.idx);
            }
        }

        @Override // org.apache.commons.collections4.bloomfilter.IndexExtractor
        public int[] asIndexArray() {
            populate();
            return this.counterCells.keySet().stream().mapToInt(new CellExtractor$1$$ExternalSyntheticLambda1()).toArray();
        }

        private void populate() {
            if (this.counterCells.isEmpty()) {
                this.val$indexExtractor.processIndices(new CellExtractor$1$$ExternalSyntheticLambda0(this));
            }
        }

        /* JADX INFO: renamed from: lambda$populate$1$org-apache-commons-collections4-bloomfilter-CellExtractor$1, reason: not valid java name */
        /* synthetic */ boolean m5533xb15feafa(int i) {
            CounterCell counterCell = new CounterCell(i, 1);
            CounterCell counterCell2 = this.counterCells.get(counterCell);
            if (counterCell2 == null) {
                this.counterCells.put(counterCell, counterCell);
            } else {
                counterCell2.count++;
            }
            return true;
        }

        @Override // org.apache.commons.collections4.bloomfilter.CellExtractor
        public boolean processCells(CellPredicate cellPredicate) {
            populate();
            for (CounterCell counterCell : this.counterCells.values()) {
                if (!cellPredicate.test(counterCell.idx, counterCell.count)) {
                    return false;
                }
            }
            return true;
        }
    }

    static CellExtractor from(IndexExtractor indexExtractor) {
        return new AnonymousClass1(indexExtractor);
    }

    default boolean processIndices(IntPredicate intPredicate) {
        return processCells(new CellExtractor$$ExternalSyntheticLambda0(intPredicate));
    }
}
