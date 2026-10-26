package com.googlecode.javaewah32.symmetric;

import com.googlecode.javaewah.datastructure.PriorityQ;
import com.googlecode.javaewah32.BitmapStorage32;
import com.googlecode.javaewah32.EWAHCompressedBitmap32;
import com.googlecode.javaewah32.IteratingBufferedRunningLengthWord32;
import java.util.Comparator;

/* INFO: loaded from: classes4.dex */
public class RunningBitmapMerge32 implements BitmapSymmetricAlgorithm32 {
    @Override // com.googlecode.javaewah32.symmetric.BitmapSymmetricAlgorithm32
    public void symmetric(UpdateableBitmapFunction32 updateableBitmapFunction32, BitmapStorage32 bitmapStorage32, EWAHCompressedBitmap32... eWAHCompressedBitmap32Arr) {
        bitmapStorage32.clear();
        PriorityQ priorityQ = new PriorityQ(eWAHCompressedBitmap32Arr.length, new AnonymousClass1());
        updateableBitmapFunction32.resize(eWAHCompressedBitmap32Arr.length);
        int i = 0;
        for (int i2 = 0; i2 < eWAHCompressedBitmap32Arr.length; i2++) {
            EWAHPointer32 eWAHPointer32 = new EWAHPointer32(0, new IteratingBufferedRunningLengthWord32(eWAHCompressedBitmap32Arr[i2]), i2);
            if (!eWAHPointer32.hasNoData()) {
                updateableBitmapFunction32.rw[i2] = eWAHPointer32;
                eWAHPointer32.callbackUpdate(updateableBitmapFunction32);
                priorityQ.toss(eWAHPointer32);
            }
        }
        priorityQ.buildHeap();
        if (priorityQ.isEmpty()) {
            return;
        }
        while (true) {
            int iEndOfRun = ((EWAHPointer32) priorityQ.peek()).endOfRun();
            updateableBitmapFunction32.dispatch(bitmapStorage32, i, iEndOfRun);
            while (((EWAHPointer32) priorityQ.peek()).endOfRun() == iEndOfRun) {
                EWAHPointer32 eWAHPointer33 = (EWAHPointer32) priorityQ.peek();
                eWAHPointer33.parseNextRun();
                eWAHPointer33.callbackUpdate(updateableBitmapFunction32);
                if (eWAHPointer33.hasNoData()) {
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

    /* INFO: renamed from: com.googlecode.javaewah32.symmetric.RunningBitmapMerge32$1, reason: invalid class name */
    class AnonymousClass1 implements Comparator<EWAHPointer32> {
        AnonymousClass1() {
        }

        @Override // java.util.Comparator
        public int compare(EWAHPointer32 eWAHPointer32, EWAHPointer32 eWAHPointer33) {
            return eWAHPointer32.compareTo(eWAHPointer33);
        }
    }
}
