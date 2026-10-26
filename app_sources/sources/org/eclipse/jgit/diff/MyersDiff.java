package org.eclipse.jgit.diff;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import org.eclipse.jgit.diff.Sequence;
import org.eclipse.jgit.errors.DiffInterruptedException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.util.IntList;
import org.eclipse.jgit.util.LongList;

/* INFO: loaded from: classes5.dex */
public class MyersDiff<S extends Sequence> {
    public static final DiffAlgorithm INSTANCE = new AnonymousClass1();
    protected HashedSequence<S> a;
    protected HashedSequence<S> b;
    protected HashedSequenceComparator<S> cmp;
    protected EditList edits;
    MyersDiff<S>.MiddleEdit middle;

    /* synthetic */ MyersDiff(EditList editList, HashedSequenceComparator hashedSequenceComparator, HashedSequence hashedSequence, HashedSequence hashedSequence2, Edit edit, MyersDiffIA myersDiffIA) {
        this(editList, hashedSequenceComparator, hashedSequence, hashedSequence2, edit);
    }

    /* INFO: renamed from: org.eclipse.jgit.diff.MyersDiff$1, reason: invalid class name */
    class AnonymousClass1 extends LowLevelDiffAlgorithm {
        AnonymousClass1() {
        }

        @Override // org.eclipse.jgit.diff.LowLevelDiffAlgorithm
        public <S extends Sequence> void diffNonCommon(EditList editList, HashedSequenceComparator<S> hashedSequenceComparator, HashedSequence<S> hashedSequence, HashedSequence<S> hashedSequence2, Edit edit) {
            new MyersDiff(editList, hashedSequenceComparator, hashedSequence, hashedSequence2, edit, null);
        }
    }

    private MyersDiff(EditList editList, HashedSequenceComparator<S> hashedSequenceComparator, HashedSequence<S> hashedSequence, HashedSequence<S> hashedSequence2, Edit edit) {
        this.middle = new MiddleEdit();
        this.edits = editList;
        this.cmp = hashedSequenceComparator;
        this.a = hashedSequence;
        this.b = hashedSequence2;
        calculateEdits(edit);
    }

    private void calculateEdits(Edit edit) {
        this.middle.initialize(edit.beginA, edit.endA, edit.beginB, edit.endB);
        if (this.middle.beginA < this.middle.endA || this.middle.beginB < this.middle.endB) {
            calculateEdits(this.middle.beginA, this.middle.endA, this.middle.beginB, this.middle.endB);
        }
    }

    protected void calculateEdits(int i, int i2, int i3, int i4) {
        Edit editCalculate = this.middle.calculate(i, i2, i3, i4);
        if (i < editCalculate.beginA || i3 < editCalculate.beginB) {
            int i5 = editCalculate.beginB - editCalculate.beginA;
            int iSnake = this.middle.backward.snake(i5, editCalculate.beginA);
            calculateEdits(i, iSnake, i3, i5 + iSnake);
        }
        if (editCalculate.getType() != Edit.Type.EMPTY) {
            EditList editList = this.edits;
            editList.add(editList.size(), editCalculate);
        }
        if (i2 > editCalculate.endA || i4 > editCalculate.endB) {
            int i6 = editCalculate.endB - editCalculate.endA;
            int iSnake2 = this.middle.forward.snake(i6, editCalculate.endA);
            calculateEdits(iSnake2, i2, i6 + iSnake2, i4);
        }
    }

    class MiddleEdit {
        protected int beginA;
        protected int beginB;
        protected Edit edit;
        protected int endA;
        protected int endB;
        MyersDiff<S>.MiddleEdit.EditPaths forward = new ForwardEditPaths();
        MyersDiff<S>.MiddleEdit.EditPaths backward = new BackwardEditPaths();

        MiddleEdit() {
        }

        void initialize(int i, int i2, int i3, int i4) {
            this.beginA = i;
            this.endA = i2;
            this.beginB = i3;
            this.endB = i4;
            int i5 = i3 - i;
            int iSnake = this.forward.snake(i5, i);
            this.beginA = iSnake;
            this.beginB = i5 + iSnake;
            int i6 = i4 - i2;
            int iSnake2 = this.backward.snake(i6, i2);
            this.endA = iSnake2;
            this.endB = i6 + iSnake2;
        }

        Edit calculate(int i, int i2, int i3, int i4) {
            if (i == i2 || i3 == i4) {
                return new Edit(i, i2, i3, i4);
            }
            this.beginA = i;
            this.endA = i2;
            this.beginB = i3;
            this.endB = i4;
            int i5 = i3 - i2;
            int i6 = i4 - i;
            this.forward.initialize(i3 - i, i, i5, i6);
            this.backward.initialize(i4 - i2, i2, i5, i6);
            for (int i7 = 1; !this.forward.calculate(i7) && !this.backward.calculate(i7); i7++) {
            }
            return this.edit;
        }

        abstract class EditPaths {
            int beginK;
            int endK;
            int maxK;
            int middleK;
            int minK;
            int prevBeginK;
            int prevEndK;
            private IntList x = new IntList();
            private LongList snake = new LongList();

            abstract void adjustMinMaxK(int i, int i2);

            abstract int getLeft(int i);

            abstract int getRight(int i);

            abstract boolean isBetter(int i, int i2);

            abstract boolean meets(int i, int i2, int i3, long j);

            final long newSnake(int i, int i2) {
                long j = i;
                long j2 = i2;
                return (j2 << 32) | (j + j2);
            }

            abstract int snake(int i, int i2);

            final int snake2x(long j) {
                return (int) (j >>> 32);
            }

            final int snake2y(long j) {
                return (int) j;
            }

            EditPaths() {
            }

            final int getIndex(int i, int i2) {
                int i3 = i + i2;
                int i4 = this.middleK;
                if ((i3 - i4) % 2 != 0) {
                    throw new RuntimeException(MessageFormat.format(JGitText.get().unexpectedOddResult, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.middleK)));
                }
                return (i3 - i4) / 2;
            }

            final int getX(int i, int i2) {
                if (i2 < this.beginK || i2 > this.endK) {
                    throw new RuntimeException(MessageFormat.format(JGitText.get().kNotInRange, Integer.valueOf(i2), Integer.valueOf(this.beginK), Integer.valueOf(this.endK)));
                }
                return this.x.get(getIndex(i, i2));
            }

            final long getSnake(int i, int i2) {
                if (i2 < this.beginK || i2 > this.endK) {
                    throw new RuntimeException(MessageFormat.format(JGitText.get().kNotInRange, Integer.valueOf(i2), Integer.valueOf(this.beginK), Integer.valueOf(this.endK)));
                }
                return this.snake.get(getIndex(i, i2));
            }

            private int forceKIntoRange(int i) {
                int i2 = this.minK;
                if (i < i2) {
                    return i2 + ((i ^ i2) & 1);
                }
                int i3 = this.maxK;
                return i > i3 ? i3 - ((i ^ i3) & 1) : i;
            }

            void initialize(int i, int i2, int i3, int i4) {
                this.minK = i3;
                this.maxK = i4;
                this.middleK = i;
                this.endK = i;
                this.beginK = i;
                this.x.clear();
                this.x.add(i2);
                this.snake.clear();
                this.snake.add(newSnake(i, i2));
            }

            final boolean makeEdit(long j, long j2) {
                int iSnake2x = snake2x(j);
                int iSnake2x2 = snake2x(j2);
                int iSnake2y = snake2y(j);
                int iSnake2y2 = snake2y(j2);
                if (iSnake2x > iSnake2x2 || iSnake2y > iSnake2y2) {
                    iSnake2y = iSnake2y2;
                    iSnake2x = iSnake2x2;
                }
                MiddleEdit.this.edit = new Edit(iSnake2x, iSnake2x2, iSnake2y, iSnake2y2);
                return true;
            }

            boolean calculate(int i) {
                long j;
                int left;
                int i2;
                long j2;
                long jNewSnake;
                long jNewSnake2;
                this.prevBeginK = this.beginK;
                this.prevEndK = this.endK;
                this.beginK = forceKIntoRange(this.middleK - i);
                int iForceKIntoRange = forceKIntoRange(this.middleK + i);
                this.endK = iForceKIntoRange;
                int i3 = iForceKIntoRange;
                while (i3 >= this.beginK) {
                    if (Thread.interrupted()) {
                        throw new DiffInterruptedException();
                    }
                    long j3 = -1;
                    int right = -1;
                    if (i3 > this.prevBeginK) {
                        int i4 = i3 - 1;
                        int index = getIndex(i - 1, i4);
                        int i5 = this.x.get(index);
                        int iSnake = snake(i4, i5);
                        if (i5 != iSnake) {
                            jNewSnake2 = newSnake(i4, iSnake);
                        } else {
                            jNewSnake2 = this.snake.get(index);
                        }
                        long j4 = jNewSnake2;
                        if (meets(i, i4, iSnake, j4)) {
                            return true;
                        }
                        j = j4;
                        left = getLeft(iSnake);
                    } else {
                        j = -1;
                        left = -1;
                    }
                    if (i3 < this.prevEndK) {
                        int i6 = i3 + 1;
                        int index2 = getIndex(i - 1, i6);
                        int i7 = this.x.get(index2);
                        int iSnake2 = snake(i6, i7);
                        if (i7 != iSnake2) {
                            jNewSnake = newSnake(i6, iSnake2);
                        } else {
                            jNewSnake = this.snake.get(index2);
                        }
                        long j5 = jNewSnake;
                        j3 = j5;
                        if (meets(i, i6, iSnake2, j5)) {
                            return true;
                        }
                        right = getRight(iSnake2);
                    }
                    if (i3 >= this.prevEndK || (i3 > this.prevBeginK && isBetter(left, right))) {
                        i2 = left;
                        j2 = j;
                    } else {
                        j2 = j3;
                        i2 = right;
                    }
                    int i8 = i3;
                    int i9 = i2;
                    long j6 = j2;
                    if (meets(i, i8, i2, j2)) {
                        return true;
                    }
                    adjustMinMaxK(i8, i9);
                    int index3 = getIndex(i, i8);
                    this.x.set(index3, i9);
                    this.snake.set(index3, j6);
                    i3 = i8 - 2;
                }
                return false;
            }
        }

        class ForwardEditPaths extends MyersDiff<S>.MiddleEdit.EditPaths {
            @Override // org.eclipse.jgit.diff.MyersDiff.MiddleEdit.EditPaths
            final int getLeft(int i) {
                return i;
            }

            @Override // org.eclipse.jgit.diff.MyersDiff.MiddleEdit.EditPaths
            final int getRight(int i) {
                return i + 1;
            }

            @Override // org.eclipse.jgit.diff.MyersDiff.MiddleEdit.EditPaths
            final boolean isBetter(int i, int i2) {
                return i > i2;
            }

            ForwardEditPaths() {
                super();
            }

            @Override // org.eclipse.jgit.diff.MyersDiff.MiddleEdit.EditPaths
            final int snake(int i, int i2) {
                int i3;
                while (i2 < MiddleEdit.this.endA && (i3 = i + i2) < MiddleEdit.this.endB && MyersDiff.this.cmp.equals((HashedSequence) MyersDiff.this.a, i2, (HashedSequence) MyersDiff.this.b, i3)) {
                    i2++;
                }
                return i2;
            }

            @Override // org.eclipse.jgit.diff.MyersDiff.MiddleEdit.EditPaths
            final void adjustMinMaxK(int i, int i2) {
                if (i2 >= MiddleEdit.this.endA || i2 + i >= MiddleEdit.this.endB) {
                    if (i > MiddleEdit.this.backward.middleK) {
                        this.maxK = i;
                    } else {
                        this.minK = i;
                    }
                }
            }

            @Override // org.eclipse.jgit.diff.MyersDiff.MiddleEdit.EditPaths
            final boolean meets(int i, int i2, int i3, long j) {
                if (i2 < MiddleEdit.this.backward.beginK || i2 > MiddleEdit.this.backward.endK) {
                    return false;
                }
                int i4 = i - 1;
                if (((i4 + i2) - MiddleEdit.this.backward.middleK) % 2 != 0 || i3 < MiddleEdit.this.backward.getX(i4, i2)) {
                    return false;
                }
                makeEdit(j, MiddleEdit.this.backward.getSnake(i4, i2));
                return true;
            }
        }

        class BackwardEditPaths extends MyersDiff<S>.MiddleEdit.EditPaths {
            @Override // org.eclipse.jgit.diff.MyersDiff.MiddleEdit.EditPaths
            final int getLeft(int i) {
                return i - 1;
            }

            @Override // org.eclipse.jgit.diff.MyersDiff.MiddleEdit.EditPaths
            final int getRight(int i) {
                return i;
            }

            @Override // org.eclipse.jgit.diff.MyersDiff.MiddleEdit.EditPaths
            final boolean isBetter(int i, int i2) {
                return i < i2;
            }

            BackwardEditPaths() {
                super();
            }

            @Override // org.eclipse.jgit.diff.MyersDiff.MiddleEdit.EditPaths
            final int snake(int i, int i2) {
                int i3;
                while (i2 > MiddleEdit.this.beginA && (i3 = i + i2) > MiddleEdit.this.beginB && MyersDiff.this.cmp.equals((HashedSequence) MyersDiff.this.a, i2 - 1, (HashedSequence) MyersDiff.this.b, i3 - 1)) {
                    i2--;
                }
                return i2;
            }

            @Override // org.eclipse.jgit.diff.MyersDiff.MiddleEdit.EditPaths
            final void adjustMinMaxK(int i, int i2) {
                if (i2 <= MiddleEdit.this.beginA || i2 + i <= MiddleEdit.this.beginB) {
                    if (i > MiddleEdit.this.forward.middleK) {
                        this.maxK = i;
                    } else {
                        this.minK = i;
                    }
                }
            }

            @Override // org.eclipse.jgit.diff.MyersDiff.MiddleEdit.EditPaths
            final boolean meets(int i, int i2, int i3, long j) {
                if (i2 < MiddleEdit.this.forward.beginK || i2 > MiddleEdit.this.forward.endK || ((i + i2) - MiddleEdit.this.forward.middleK) % 2 != 0 || i3 > MiddleEdit.this.forward.getX(i, i2)) {
                    return false;
                }
                makeEdit(MiddleEdit.this.forward.getSnake(i, i2), j);
                return true;
            }
        }
    }

    public static void main(String[] strArr) {
        if (strArr.length != 2) {
            err().println(JGitText.get().need2Arguments);
            System.exit(1);
        }
        try {
            System.out.println(INSTANCE.diff(RawTextComparator.DEFAULT, new RawText(new File(strArr[0])), new RawText(new File(strArr[1]))).toString());
        } catch (Exception e) {
            PrintWriter printWriterErr = err();
            printWriterErr.println(e.getMessage());
            e.printStackTrace(printWriterErr);
        }
    }

    private static PrintWriter err() {
        return new PrintWriter(new OutputStreamWriter(System.err, StandardCharsets.UTF_8));
    }
}
