package com.googlecode.javaewah.symmetric;

import com.googlecode.javaewah.BitmapStorage;
import com.googlecode.javaewah.EWAHCompressedBitmap;
import com.googlecode.javaewah.IteratingBufferedRunningLengthWord;
import com.googlecode.javaewah.datastructure.PriorityQ;
import java.util.Comparator;

/* INFO: loaded from: classes4.dex */
public class RunningBitmapMerge implements BitmapSymmetricAlgorithm {
    @Override // com.googlecode.javaewah.symmetric.BitmapSymmetricAlgorithm
    public void symmetric(UpdateableBitmapFunction updateableBitmapFunction, BitmapStorage bitmapStorage, EWAHCompressedBitmap... eWAHCompressedBitmapArr) {
        bitmapStorage.clear();
        PriorityQ priorityQ = new PriorityQ(eWAHCompressedBitmapArr.length, new AnonymousClass1());
        updateableBitmapFunction.resize(eWAHCompressedBitmapArr.length);
        int i = 0;
        for (int i2 = 0; i2 < eWAHCompressedBitmapArr.length; i2++) {
            EWAHPointer eWAHPointer = new EWAHPointer(0, new IteratingBufferedRunningLengthWord(eWAHCompressedBitmapArr[i2]), i2);
            if (!eWAHPointer.hasNoData()) {
                updateableBitmapFunction.rw[i2] = eWAHPointer;
                eWAHPointer.callbackUpdate(updateableBitmapFunction);
                priorityQ.toss(eWAHPointer);
            }
        }
        priorityQ.buildHeap();
        if (priorityQ.isEmpty()) {
            return;
        }
        while (true) {
            int iEndOfRun = ((EWAHPointer) priorityQ.peek()).endOfRun();
            updateableBitmapFunction.dispatch(bitmapStorage, i, iEndOfRun);
            while (((EWAHPointer) priorityQ.peek()).endOfRun() == iEndOfRun) {
                EWAHPointer eWAHPointer2 = (EWAHPointer) priorityQ.peek();
                eWAHPointer2.parseNextRun();
                eWAHPointer2.callbackUpdate(updateableBitmapFunction);
                if (eWAHPointer2.hasNoData()) {
                    priorityQ.poll();
                    if (priorityQ.isEmpty()) {
                        return;
                    }
                } else {
                    priorityQ.percolateDown();
                }
            }
            i = iEndOfRun;
        }
    }

    /* INFO: renamed from: com.googlecode.javaewah.symmetric.RunningBitmapMerge$1, reason: invalid class name */
    class AnonymousClass1 implements Comparator<EWAHPointer> {
        AnonymousClass1() {
        }

        @Override // java.util.Comparator
        public int compare(EWAHPointer eWAHPointer, EWAHPointer eWAHPointer2) {
            return eWAHPointer.compareTo(eWAHPointer2);
        }
    }
}
