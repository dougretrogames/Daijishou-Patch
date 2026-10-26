package org.eclipse.jgit.patch;

import java.io.IOException;
import java.io.OutputStream;
import java.text.MessageFormat;
import org.apache.http.message.TokenParser;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AbbreviatedObjectId;
import org.eclipse.jgit.util.MutableInteger;
import org.eclipse.jgit.util.RawParseUtils;

/* INFO: loaded from: classes5.dex */
public class CombinedHunkHeader extends HunkHeader {
    private CombinedOldImage[] old;

    private static abstract class CombinedOldImage extends HunkHeader.OldImage {
        int nContext;

        /* synthetic */ CombinedOldImage(CombinedHunkHeaderIA combinedHunkHeaderIA) {
            this();
        }

        private CombinedOldImage() {
        }
    }

    CombinedHunkHeader(CombinedFileHeader combinedFileHeader, int i) {
        super(combinedFileHeader, i, null);
        this.old = new CombinedOldImage[combinedFileHeader.getParentCount()];
        int i2 = 0;
        while (true) {
            CombinedOldImage[] combinedOldImageArr = this.old;
            if (i2 >= combinedOldImageArr.length) {
                return;
            }
            combinedOldImageArr[i2] = new AnonymousClass1(combinedFileHeader, i2);
            i2++;
        }
    }

    /* INFO: renamed from: org.eclipse.jgit.patch.CombinedHunkHeader$1, reason: invalid class name */
    class AnonymousClass1 extends CombinedOldImage {
        private final /* synthetic */ CombinedFileHeader val$fh;
        private final /* synthetic */ int val$imagePos;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CombinedFileHeader combinedFileHeader, int i) {
            super(null);
            this.val$fh = combinedFileHeader;
            this.val$imagePos = i;
        }

        @Override // org.eclipse.jgit.patch.HunkHeader.OldImage
        public AbbreviatedObjectId getId() {
            return this.val$fh.getOldId(this.val$imagePos);
        }
    }

    @Override // org.eclipse.jgit.patch.HunkHeader
    public CombinedFileHeader getFileHeader() {
        return (CombinedFileHeader) super.getFileHeader();
    }

    @Override // org.eclipse.jgit.patch.HunkHeader
    public HunkHeader.OldImage getOldImage() {
        return getOldImage(0);
    }

    public HunkHeader.OldImage getOldImage(int i) {
        return this.old[i];
    }

    @Override // org.eclipse.jgit.patch.HunkHeader
    void parseHeader() {
        byte[] bArr = this.file.buf;
        MutableInteger mutableInteger = new MutableInteger();
        mutableInteger.value = RawParseUtils.nextLF(bArr, this.startOffset, TokenParser.SP);
        for (CombinedOldImage combinedOldImage : this.old) {
            combinedOldImage.startLine = -RawParseUtils.parseBase10(bArr, mutableInteger.value, mutableInteger);
            if (bArr[mutableInteger.value] == 44) {
                combinedOldImage.lineCount = RawParseUtils.parseBase10(bArr, mutableInteger.value + 1, mutableInteger);
            } else {
                combinedOldImage.lineCount = 1;
            }
        }
        this.newStartLine = RawParseUtils.parseBase10(bArr, mutableInteger.value + 1, mutableInteger);
        if (bArr[mutableInteger.value] == 44) {
            this.newLineCount = RawParseUtils.parseBase10(bArr, mutableInteger.value + 1, mutableInteger);
        } else {
            this.newLineCount = 1;
        }
    }

    @Override // org.eclipse.jgit.patch.HunkHeader
    int parseBody(Patch patch, int i) {
        byte b;
        CombinedOldImage[] combinedOldImageArr;
        byte[] bArr = this.file.buf;
        int iNextLF = RawParseUtils.nextLF(bArr, this.startOffset);
        int i2 = 0;
        for (CombinedOldImage combinedOldImage : this.old) {
            combinedOldImage.nDeleted = 0;
            combinedOldImage.nAdded = 0;
            combinedOldImage.nContext = 0;
        }
        this.nContext = 0;
        int i3 = iNextLF;
        int i4 = 0;
        loop1: while (i3 < i) {
            int iNextLF2 = RawParseUtils.nextLF(bArr, i3);
            if (iNextLF2 - i3 < this.old.length + 1 || ((b = bArr[i3]) != 32 && b != 43 && b != 45)) {
                break;
            }
            int i5 = 0;
            int i6 = 0;
            while (true) {
                combinedOldImageArr = this.old;
                if (i5 >= combinedOldImageArr.length) {
                    break;
                }
                byte b2 = bArr[i3 + i5];
                if (b2 == 32) {
                    i6++;
                    combinedOldImageArr[i5].nContext++;
                } else if (b2 == 43) {
                    combinedOldImageArr[i5].nAdded++;
                    i4++;
                } else {
                    if (b2 != 45) {
                        break loop1;
                    }
                    combinedOldImageArr[i5].nDeleted++;
                }
                i5++;
            }
            if (i6 == combinedOldImageArr.length) {
                this.nContext++;
            }
            i3 = iNextLF2;
        }
        int i7 = i4;
        while (true) {
            CombinedOldImage[] combinedOldImageArr2 = this.old;
            if (i2 >= combinedOldImageArr2.length) {
                break;
            }
            CombinedOldImage combinedOldImage2 = combinedOldImageArr2[i2];
            int i8 = combinedOldImage2.nContext + combinedOldImage2.nDeleted;
            if (i8 < combinedOldImage2.lineCount) {
                patch.error(bArr, this.startOffset, MessageFormat.format(JGitText.get().truncatedHunkLinesMissingForAncestor, Integer.valueOf(combinedOldImage2.lineCount - i8), Integer.valueOf(i2 + 1)));
            }
            i2++;
        }
        if (this.nContext + i7 < this.newLineCount) {
            patch.error(bArr, this.startOffset, MessageFormat.format(JGitText.get().truncatedHunkNewLinesMissing, Integer.valueOf(this.newLineCount - (this.nContext + i7))));
        }
        return i3;
    }

    @Override // org.eclipse.jgit.patch.HunkHeader
    void extractFileLines(OutputStream[] outputStreamArr) throws IOException {
        int iNextLF;
        int iNextLF2;
        CombinedOldImage[] combinedOldImageArr;
        byte[] bArr = this.file.buf;
        int i = this.startOffset;
        int iNextLF3 = RawParseUtils.nextLF(bArr, i);
        if (this.endOffset <= iNextLF3) {
            return;
        }
        outputStreamArr[0].write(bArr, i, iNextLF3 - i);
        while (iNextLF3 < this.endOffset && (iNextLF2 = (iNextLF = RawParseUtils.nextLF(bArr, iNextLF3)) - iNextLF3) >= this.old.length + 1) {
            byte b = bArr[iNextLF3];
            if (b != 32 && b != 43 && b != 45) {
                return;
            }
            int i2 = 0;
            int i3 = 0;
            while (true) {
                combinedOldImageArr = this.old;
                if (i2 >= combinedOldImageArr.length) {
                    break;
                }
                byte b2 = bArr[iNextLF3 + i2];
                if (b2 == 32) {
                    outputStreamArr[i2].write(bArr, iNextLF3, iNextLF2);
                } else if (b2 == 43) {
                    continue;
                } else {
                    if (b2 != 45) {
                        return;
                    }
                    i3++;
                    outputStreamArr[i2].write(bArr, iNextLF3, iNextLF2);
                }
                i2++;
            }
            if (i3 < combinedOldImageArr.length) {
                outputStreamArr[combinedOldImageArr.length].write(bArr, iNextLF3, iNextLF2);
            }
            iNextLF3 = iNextLF;
        }
    }

    /* WARN: Code duplicated, block: B:29:0x0051  */
    /* WARN: Code duplicated, block: B:30:0x0055  */
    @Override // org.eclipse.jgit.patch.HunkHeader
    void extractFileLines(StringBuilder sb, String[] strArr, int[] iArr) {
        CombinedOldImage[] combinedOldImageArr;
        byte[] bArr = this.file.buf;
        int iNextLF = RawParseUtils.nextLF(bArr, this.startOffset);
        if (this.endOffset <= iNextLF) {
            return;
        }
        copyLine(sb, strArr, iArr, 0);
        while (iNextLF < this.endOffset) {
            int iNextLF2 = RawParseUtils.nextLF(bArr, iNextLF);
            if (iNextLF2 - iNextLF < this.old.length + 1) {
                return;
            }
            byte b = bArr[iNextLF];
            if (b != 32 && b != 43 && b != 45) {
                return;
            }
            int i = 0;
            boolean z = false;
            while (true) {
                combinedOldImageArr = this.old;
                if (i >= combinedOldImageArr.length) {
                    break;
                }
                byte b2 = bArr[iNextLF + i];
                if (b2 == 32) {
                    if (z) {
                        skipLine(strArr, iArr, i);
                    } else {
                        copyLine(sb, strArr, iArr, i);
                        z = true;
                    }
                } else if (b2 == 43) {
                    continue;
                } else {
                    if (b2 != 45) {
                        return;
                    }
                    if (z) {
                        skipLine(strArr, iArr, i);
                    } else {
                        copyLine(sb, strArr, iArr, i);
                        z = true;
                    }
                }
                i++;
            }
            if (!z) {
                copyLine(sb, strArr, iArr, combinedOldImageArr.length);
            }
            iNextLF = iNextLF2;
        }
    }
}
