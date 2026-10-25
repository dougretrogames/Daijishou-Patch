package org.eclipse.jgit.diff;

import org.eclipse.jgit.util.IntList;
import org.eclipse.jgit.util.RawCharUtil;

/* JADX INFO: loaded from: classes5.dex */
public abstract class RawTextComparator extends SequenceComparator<RawText> {
    public static final RawTextComparator DEFAULT = new AnonymousClass1();
    public static final RawTextComparator WS_IGNORE_ALL = new AnonymousClass2();
    public static final RawTextComparator WS_IGNORE_LEADING = new AnonymousClass3();
    public static final RawTextComparator WS_IGNORE_TRAILING = new AnonymousClass4();
    public static final RawTextComparator WS_IGNORE_CHANGE = new AnonymousClass5();

    protected abstract int hashRegion(byte[] bArr, int i, int i2);

    /* JADX INFO: renamed from: org.eclipse.jgit.diff.RawTextComparator$1, reason: invalid class name */
    class AnonymousClass1 extends RawTextComparator {
        AnonymousClass1() {
        }

        @Override // org.eclipse.jgit.diff.SequenceComparator
        public boolean equals(RawText rawText, int i, RawText rawText2, int i2) {
            int i3 = rawText.lines.get(i + 1);
            int i4 = rawText2.lines.get(i2 + 1);
            int i5 = rawText.lines.get(i + 2);
            if (i5 - i3 != rawText2.lines.get(i2 + 2) - i4) {
                return false;
            }
            while (i3 < i5) {
                int i6 = i3 + 1;
                int i7 = i4 + 1;
                if (rawText.content[i3] != rawText2.content[i4]) {
                    return false;
                }
                i3 = i6;
                i4 = i7;
            }
            return true;
        }

        @Override // org.eclipse.jgit.diff.RawTextComparator
        protected int hashRegion(byte[] bArr, int i, int i2) {
            int i3 = 5381;
            while (i < i2) {
                i3 = (bArr[i] & 255) + (i3 << 5) + i3;
                i++;
            }
            return i3;
        }
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.diff.RawTextComparator$2, reason: invalid class name */
    class AnonymousClass2 extends RawTextComparator {
        AnonymousClass2() {
        }

        @Override // org.eclipse.jgit.diff.SequenceComparator
        public boolean equals(RawText rawText, int i, RawText rawText2, int i2) {
            int i3 = rawText.lines.get(i + 1);
            int i4 = rawText2.lines.get(i2 + 1);
            int i5 = rawText.lines.get(i + 2);
            int i6 = rawText2.lines.get(i2 + 2);
            int iTrimTrailingWhitespace = RawCharUtil.trimTrailingWhitespace(rawText.content, i3, i5);
            int iTrimTrailingWhitespace2 = RawCharUtil.trimTrailingWhitespace(rawText2.content, i4, i6);
            while (i3 < iTrimTrailingWhitespace && i4 < iTrimTrailingWhitespace2) {
                byte b = rawText.content[i3];
                byte b2 = rawText2.content[i4];
                while (i3 < iTrimTrailingWhitespace - 1 && RawCharUtil.isWhitespace(b)) {
                    i3++;
                    b = rawText.content[i3];
                }
                while (i4 < iTrimTrailingWhitespace2 - 1 && RawCharUtil.isWhitespace(b2)) {
                    i4++;
                    b2 = rawText2.content[i4];
                }
                if (b != b2) {
                    return false;
                }
                i3++;
                i4++;
            }
            return i3 == iTrimTrailingWhitespace && i4 == iTrimTrailingWhitespace2;
        }

        @Override // org.eclipse.jgit.diff.RawTextComparator
        protected int hashRegion(byte[] bArr, int i, int i2) {
            int i3 = 5381;
            while (i < i2) {
                byte b = bArr[i];
                if (!RawCharUtil.isWhitespace(b)) {
                    i3 = (i3 << 5) + i3 + (b & 255);
                }
                i++;
            }
            return i3;
        }
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.diff.RawTextComparator$3, reason: invalid class name */
    class AnonymousClass3 extends RawTextComparator {
        AnonymousClass3() {
        }

        @Override // org.eclipse.jgit.diff.SequenceComparator
        public boolean equals(RawText rawText, int i, RawText rawText2, int i2) {
            int i3 = rawText.lines.get(i + 1);
            int i4 = rawText2.lines.get(i2 + 1);
            int i5 = rawText.lines.get(i + 2);
            int i6 = rawText2.lines.get(i2 + 2);
            int iTrimLeadingWhitespace = RawCharUtil.trimLeadingWhitespace(rawText.content, i3, i5);
            int iTrimLeadingWhitespace2 = RawCharUtil.trimLeadingWhitespace(rawText2.content, i4, i6);
            if (i5 - iTrimLeadingWhitespace != i6 - iTrimLeadingWhitespace2) {
                return false;
            }
            while (iTrimLeadingWhitespace < i5) {
                int i7 = iTrimLeadingWhitespace + 1;
                int i8 = iTrimLeadingWhitespace2 + 1;
                if (rawText.content[iTrimLeadingWhitespace] != rawText2.content[iTrimLeadingWhitespace2]) {
                    return false;
                }
                iTrimLeadingWhitespace = i7;
                iTrimLeadingWhitespace2 = i8;
            }
            return true;
        }

        @Override // org.eclipse.jgit.diff.RawTextComparator
        protected int hashRegion(byte[] bArr, int i, int i2) {
            int i3 = 5381;
            for (int iTrimLeadingWhitespace = RawCharUtil.trimLeadingWhitespace(bArr, i, i2); iTrimLeadingWhitespace < i2; iTrimLeadingWhitespace++) {
                i3 = (bArr[iTrimLeadingWhitespace] & 255) + (i3 << 5) + i3;
            }
            return i3;
        }
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.diff.RawTextComparator$4, reason: invalid class name */
    class AnonymousClass4 extends RawTextComparator {
        AnonymousClass4() {
        }

        @Override // org.eclipse.jgit.diff.SequenceComparator
        public boolean equals(RawText rawText, int i, RawText rawText2, int i2) {
            int i3 = rawText.lines.get(i + 1);
            int i4 = rawText2.lines.get(i2 + 1);
            int i5 = rawText.lines.get(i + 2);
            int i6 = rawText2.lines.get(i2 + 2);
            int iTrimTrailingWhitespace = RawCharUtil.trimTrailingWhitespace(rawText.content, i3, i5);
            if (iTrimTrailingWhitespace - i3 != RawCharUtil.trimTrailingWhitespace(rawText2.content, i4, i6) - i4) {
                return false;
            }
            while (i3 < iTrimTrailingWhitespace) {
                int i7 = i3 + 1;
                int i8 = i4 + 1;
                if (rawText.content[i3] != rawText2.content[i4]) {
                    return false;
                }
                i3 = i7;
                i4 = i8;
            }
            return true;
        }

        @Override // org.eclipse.jgit.diff.RawTextComparator
        protected int hashRegion(byte[] bArr, int i, int i2) {
            int iTrimTrailingWhitespace = RawCharUtil.trimTrailingWhitespace(bArr, i, i2);
            int i3 = 5381;
            while (i < iTrimTrailingWhitespace) {
                i3 = (bArr[i] & 255) + (i3 << 5) + i3;
                i++;
            }
            return i3;
        }
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.diff.RawTextComparator$5, reason: invalid class name */
    class AnonymousClass5 extends RawTextComparator {
        AnonymousClass5() {
        }

        @Override // org.eclipse.jgit.diff.SequenceComparator
        public boolean equals(RawText rawText, int i, RawText rawText2, int i2) {
            int iTrimLeadingWhitespace = rawText.lines.get(i + 1);
            int iTrimLeadingWhitespace2 = rawText2.lines.get(i2 + 1);
            int i3 = rawText.lines.get(i + 2);
            int i4 = rawText2.lines.get(i2 + 2);
            int iTrimTrailingWhitespace = RawCharUtil.trimTrailingWhitespace(rawText.content, iTrimLeadingWhitespace, i3);
            int iTrimTrailingWhitespace2 = RawCharUtil.trimTrailingWhitespace(rawText2.content, iTrimLeadingWhitespace2, i4);
            while (iTrimLeadingWhitespace < iTrimTrailingWhitespace && iTrimLeadingWhitespace2 < iTrimTrailingWhitespace2) {
                int i5 = iTrimLeadingWhitespace + 1;
                byte b = rawText.content[iTrimLeadingWhitespace];
                int i6 = iTrimLeadingWhitespace2 + 1;
                byte b2 = rawText2.content[iTrimLeadingWhitespace2];
                if (RawCharUtil.isWhitespace(b) && RawCharUtil.isWhitespace(b2)) {
                    iTrimLeadingWhitespace = RawCharUtil.trimLeadingWhitespace(rawText.content, i5, iTrimTrailingWhitespace);
                    iTrimLeadingWhitespace2 = RawCharUtil.trimLeadingWhitespace(rawText2.content, i6, iTrimTrailingWhitespace2);
                } else {
                    if (b != b2) {
                        return false;
                    }
                    iTrimLeadingWhitespace = i5;
                    iTrimLeadingWhitespace2 = i6;
                }
            }
            return iTrimLeadingWhitespace == iTrimTrailingWhitespace && iTrimLeadingWhitespace2 == iTrimTrailingWhitespace2;
        }

        @Override // org.eclipse.jgit.diff.RawTextComparator
        protected int hashRegion(byte[] bArr, int i, int i2) {
            int iTrimTrailingWhitespace = RawCharUtil.trimTrailingWhitespace(bArr, i, i2);
            int i3 = 5381;
            while (i < iTrimTrailingWhitespace) {
                int iTrimLeadingWhitespace = i + 1;
                byte b = bArr[i];
                if (RawCharUtil.isWhitespace(b)) {
                    iTrimLeadingWhitespace = RawCharUtil.trimLeadingWhitespace(bArr, iTrimLeadingWhitespace, iTrimTrailingWhitespace);
                    b = 32;
                }
                i3 = (i3 << 5) + i3 + (b & 255);
                i = iTrimLeadingWhitespace;
            }
            return i3;
        }
    }

    @Override // org.eclipse.jgit.diff.SequenceComparator
    public int hash(RawText rawText, int i) {
        return hashRegion(rawText.content, rawText.lines.get(i + 1), rawText.lines.get(i + 2));
    }

    @Override // org.eclipse.jgit.diff.SequenceComparator
    public Edit reduceCommonStartEnd(RawText rawText, RawText rawText2, Edit edit) {
        if (edit.beginA == edit.endA || edit.beginB == edit.endB) {
            return edit;
        }
        byte[] bArr = rawText.content;
        byte[] bArr2 = rawText2.content;
        int i = rawText.lines.get(edit.beginA + 1);
        int i2 = rawText.lines.get(edit.beginB + 1);
        int i3 = rawText.lines.get(edit.endA + 1);
        int i4 = rawText2.lines.get(edit.endB + 1);
        if (i < 0 || i2 < 0 || i3 > bArr.length || i4 > bArr2.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        while (i < i3 && i2 < i4 && bArr[i] == bArr2[i2]) {
            i++;
            i2++;
        }
        while (i < i3 && i2 < i4 && bArr[i3 - 1] == bArr2[i4 - 1]) {
            i3--;
            i4--;
        }
        edit.beginA = findForwardLine(rawText.lines, edit.beginA, i);
        edit.beginB = findForwardLine(rawText2.lines, edit.beginB, i2);
        edit.endA = findReverseLine(rawText.lines, edit.endA, i3);
        boolean z = i3 < rawText.lines.get(edit.endA + 1);
        if (z) {
            i4 += rawText.lines.get(edit.endA + 1) - i3;
        }
        edit.endB = findReverseLine(rawText2.lines, edit.endB, i4);
        if (!z && i4 < rawText2.lines.get(edit.endB + 1)) {
            edit.endA++;
        }
        return super.reduceCommonStartEnd(rawText, rawText2, edit);
    }

    private static int findForwardLine(IntList intList, int i, int i2) {
        int size = intList.size() - 2;
        while (i < size && intList.get(i + 2) < i2) {
            i++;
        }
        return i;
    }

    private static int findReverseLine(IntList intList, int i, int i2) {
        while (i > 0 && i2 <= intList.get(i)) {
            i--;
        }
        return i;
    }
}
