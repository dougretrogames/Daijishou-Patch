package androidx.compose.ui.node;

import kotlin.Metadata;

/* INFO: compiled from: MyersDiff.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0015\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001aZ\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a \u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0005H\u0002\u001a \u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a8\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0012H\u0000\u001aZ\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b \u0010\u0014\u001aR\u0010!\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\u001c\u0010$\u001a\u00020\u0001*\u00020\u00122\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\tH\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006'"}, d2 = {"applyDiff", "", "diagonals", "Landroidx/compose/ui/node/IntStack;", "callback", "Landroidx/compose/ui/node/DiffCallback;", "backward", "", "oldStart", "", "oldEnd", "newStart", "newEnd", "cb", "forward", "Landroidx/compose/ui/node/CenteredArray;", "d", "snake", "", "backward-4l5_RBY", "(IIIILandroidx/compose/ui/node/DiffCallback;[I[II[I)Z", "calculateDiff", "oldSize", "newSize", "executeDiff", "fillSnake", "startX", "startY", "endX", "endY", "reverse", "data", "forward-4l5_RBY", "midPoint", "midPoint-q5eDKzI", "(IIIILandroidx/compose/ui/node/DiffCallback;[I[I[I)Z", "swap", "i", "j", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MyersDiffKt {
    private static final IntStack calculateDiff(int i, int i2, DiffCallback diffCallback) {
        int i3 = ((i + i2) + 1) / 2;
        IntStack intStack = new IntStack(i3 * 3);
        IntStack intStack2 = new IntStack(i3 * 4);
        intStack2.pushRange(0, i, 0, i2);
        int i4 = (i3 * 2) + 1;
        int[] iArrM1918constructorimpl = CenteredArray.m1918constructorimpl(new int[i4]);
        int[] iArrM1918constructorimpl2 = CenteredArray.m1918constructorimpl(new int[i4]);
        int[] iArrM2094constructorimpl = Snake.m2094constructorimpl(new int[5]);
        while (intStack2.isNotEmpty()) {
            int iPop = intStack2.pop();
            int iPop2 = intStack2.pop();
            int iPop3 = intStack2.pop();
            int iPop4 = intStack2.pop();
            DiffCallback diffCallback2 = diffCallback;
            if (m1995midPointq5eDKzI(iPop4, iPop3, iPop2, iPop, diffCallback2, iArrM1918constructorimpl, iArrM1918constructorimpl2, iArrM2094constructorimpl)) {
                if (Snake.m2097getDiagonalSizeimpl(iArrM2094constructorimpl) > 0) {
                    Snake.m2092addDiagonalToStackimpl(iArrM2094constructorimpl, intStack);
                }
                intStack2.pushRange(iPop4, Snake.m2102getStartXimpl(iArrM2094constructorimpl), iPop2, Snake.m2103getStartYimpl(iArrM2094constructorimpl));
                intStack2.pushRange(Snake.m2098getEndXimpl(iArrM2094constructorimpl), iPop3, Snake.m2099getEndYimpl(iArrM2094constructorimpl), iPop);
            }
            diffCallback = diffCallback2;
        }
        intStack.sortDiagonals();
        intStack.pushDiagonal(i, i2, 0);
        return intStack;
    }

    private static final void applyDiff(IntStack intStack, DiffCallback diffCallback) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < intStack.getSize()) {
            int i4 = i + 2;
            int i5 = intStack.get(i) - intStack.get(i4);
            int i6 = intStack.get(i + 1) - intStack.get(i4);
            int i7 = intStack.get(i4);
            i += 3;
            while (i2 < i5) {
                diffCallback.remove(i3, i2);
                i2++;
            }
            while (i3 < i6) {
                diffCallback.insert(i3);
                i3++;
            }
            while (true) {
                int i8 = i7 - 1;
                if (i7 > 0) {
                    diffCallback.same(i2, i3);
                    i2++;
                    i3++;
                    i7 = i8;
                }
            }
        }
    }

    public static final void executeDiff(int i, int i2, DiffCallback diffCallback) {
        applyDiff(calculateDiff(i, i2, diffCallback), diffCallback);
    }

    /* INFO: renamed from: midPoint-q5eDKzI, reason: not valid java name */
    private static final boolean m1995midPointq5eDKzI(int i, int i2, int i3, int i4, DiffCallback diffCallback, int[] iArr, int[] iArr2, int[] iArr3) {
        int i5 = i2 - i;
        int i6 = i4 - i3;
        if (i5 >= 1 && i6 >= 1) {
            int i7 = ((i5 + i6) + 1) / 2;
            int[] iArr4 = iArr;
            CenteredArray.m1924setimpl(iArr4, 1, i);
            int[] iArr5 = iArr2;
            CenteredArray.m1924setimpl(iArr5, 1, i2);
            int i8 = 0;
            while (i8 < i7) {
                if (m1994forward4l5_RBY(i, i2, i3, i4, diffCallback, iArr4, iArr5, i8, iArr3) || m1993backward4l5_RBY(i, i2, i3, i4, diffCallback, iArr, iArr2, i8, iArr3)) {
                    return true;
                }
                i8++;
                iArr4 = iArr;
                iArr5 = iArr2;
            }
        }
        return false;
    }

    /* INFO: renamed from: forward-4l5_RBY, reason: not valid java name */
    private static final boolean m1994forward4l5_RBY(int i, int i2, int i3, int i4, DiffCallback diffCallback, int[] iArr, int[] iArr2, int i5, int[] iArr3) {
        int iM1921getimpl;
        int i6;
        int i7 = (i2 - i) - (i4 - i3);
        boolean z = Math.abs(i7) % 2 == 1;
        int i8 = -i5;
        for (int i9 = i8; i9 <= i5; i9 += 2) {
            if (i9 == i8 || (i9 != i5 && CenteredArray.m1921getimpl(iArr, i9 + 1) > CenteredArray.m1921getimpl(iArr, i9 - 1))) {
                iM1921getimpl = CenteredArray.m1921getimpl(iArr, i9 + 1);
                i6 = iM1921getimpl;
            } else {
                iM1921getimpl = CenteredArray.m1921getimpl(iArr, i9 - 1);
                i6 = iM1921getimpl + 1;
            }
            int i10 = (i3 + (i6 - i)) - i9;
            int i11 = (i5 == 0 || i6 != iM1921getimpl) ? i10 : i10 - 1;
            while (true) {
                if (i6 >= i2 || i10 >= i4) {
                    break;
                }
                if (!diffCallback.areItemsTheSame(i6, i10)) {
                    break;
                }
                i6++;
                i10++;
            }
            CenteredArray.m1924setimpl(iArr, i9, i6);
            if (z) {
                int i12 = i7 - i9;
                if (i12 >= i8 + 1 && i12 <= i5 - 1) {
                    if (CenteredArray.m1921getimpl(iArr2, i12) <= i6) {
                        fillSnake(iM1921getimpl, i11, i6, i10, false, iArr3);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* INFO: renamed from: backward-4l5_RBY, reason: not valid java name */
    private static final boolean m1993backward4l5_RBY(int i, int i2, int i3, int i4, DiffCallback diffCallback, int[] iArr, int[] iArr2, int i5, int[] iArr3) {
        int iM1921getimpl;
        int i6;
        int i7;
        int i8 = (i2 - i) - (i4 - i3);
        boolean z = i8 % 2 == 0;
        int i9 = -i5;
        for (int i10 = i9; i10 <= i5; i10 += 2) {
            if (i10 == i9 || (i10 != i5 && CenteredArray.m1921getimpl(iArr2, i10 + 1) < CenteredArray.m1921getimpl(iArr2, i10 - 1))) {
                iM1921getimpl = CenteredArray.m1921getimpl(iArr2, i10 + 1);
                i6 = iM1921getimpl;
            } else {
                iM1921getimpl = CenteredArray.m1921getimpl(iArr2, i10 - 1);
                i6 = iM1921getimpl - 1;
            }
            int i11 = i4 - ((i2 - i6) - i10);
            int i12 = (i5 == 0 || i6 != iM1921getimpl) ? i11 : i11 + 1;
            while (true) {
                if (i6 <= i || i11 <= i3) {
                    break;
                }
                if (!diffCallback.areItemsTheSame(i6 - 1, i11 - 1)) {
                    break;
                }
                i6--;
                i11--;
            }
            CenteredArray.m1924setimpl(iArr2, i10, i6);
            if (z && (i7 = i8 - i10) >= i9 && i7 <= i5) {
                if (CenteredArray.m1921getimpl(iArr, i7) >= i6) {
                    fillSnake(i6, i11, iM1921getimpl, i12, true, iArr3);
                    return true;
                }
            }
        }
        return false;
    }

    public static final void fillSnake(int i, int i2, int i3, int i4, boolean z, int[] iArr) {
        iArr[0] = i;
        iArr[1] = i2;
        iArr[2] = i3;
        iArr[3] = i4;
        iArr[4] = z ? 1 : 0;
    }

    /* INFO: Access modifiers changed from: private */
    public static final void swap(int[] iArr, int i, int i2) {
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
    }
}
