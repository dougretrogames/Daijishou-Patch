package org.eclipse.jgit.patch;

import java.io.IOException;
import java.io.OutputStream;
import java.text.MessageFormat;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.http.message.TokenParser;
import org.eclipse.jgit.diff.Edit;
import org.eclipse.jgit.diff.EditList;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AbbreviatedObjectId;
import org.eclipse.jgit.util.MutableInteger;
import org.eclipse.jgit.util.RawParseUtils;

/* JADX INFO: loaded from: classes5.dex */
public class HunkHeader {
    private EditList editList;
    int endOffset;
    final FileHeader file;
    int nContext;
    int newLineCount;
    int newStartLine;
    private final OldImage old;
    final int startOffset;

    public static abstract class OldImage {
        int lineCount;
        int nAdded;
        int nDeleted;
        int startLine;

        public abstract AbbreviatedObjectId getId();

        public int getStartLine() {
            return this.startLine;
        }

        public int getLineCount() {
            return this.lineCount;
        }

        public int getLinesDeleted() {
            return this.nDeleted;
        }

        public int getLinesAdded() {
            return this.nAdded;
        }
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.patch.HunkHeader$1, reason: invalid class name */
    class AnonymousClass1 extends OldImage {
        private final /* synthetic */ FileHeader val$fh;

        AnonymousClass1(FileHeader fileHeader) {
            this.val$fh = fileHeader;
        }

        @Override // org.eclipse.jgit.patch.HunkHeader.OldImage
        public AbbreviatedObjectId getId() {
            return this.val$fh.getOldId();
        }
    }

    HunkHeader(FileHeader fileHeader, int i) {
        this(fileHeader, i, new AnonymousClass1(fileHeader));
    }

    HunkHeader(FileHeader fileHeader, int i, OldImage oldImage) {
        this.file = fileHeader;
        this.startOffset = i;
        this.old = oldImage;
    }

    HunkHeader(FileHeader fileHeader, EditList editList) {
        this(fileHeader, fileHeader.buf.length);
        this.editList = editList;
        this.endOffset = this.startOffset;
        this.nContext = 0;
        if (editList.isEmpty()) {
            this.newStartLine = 0;
            this.newLineCount = 0;
        } else {
            this.newStartLine = editList.get(0).getBeginB();
            this.newLineCount = editList.get(editList.size() - 1).getEndB() - this.newStartLine;
        }
    }

    public FileHeader getFileHeader() {
        return this.file;
    }

    public byte[] getBuffer() {
        return this.file.buf;
    }

    public int getStartOffset() {
        return this.startOffset;
    }

    public int getEndOffset() {
        return this.endOffset;
    }

    public OldImage getOldImage() {
        return this.old;
    }

    public int getNewStartLine() {
        return this.newStartLine;
    }

    public int getNewLineCount() {
        return this.newLineCount;
    }

    public int getLinesContext() {
        return this.nContext;
    }

    public EditList toEditList() {
        if (this.editList == null) {
            this.editList = new EditList();
            byte[] bArr = this.file.buf;
            int i = this.old.startLine;
            int i2 = this.newStartLine;
            Edit edit = null;
            for (int iNextLF = RawParseUtils.nextLF(bArr, this.startOffset); iNextLF < this.endOffset; iNextLF = RawParseUtils.nextLF(bArr, iNextLF)) {
                byte b = bArr[iNextLF];
                if (b != 10 && b != 32) {
                    if (b != 43) {
                        if (b != 45) {
                            if (b != 92) {
                                break;
                            }
                        } else {
                            if (edit == null) {
                                edit = new Edit(i - 1, i2 - 1);
                                this.editList.add(edit);
                            }
                            i++;
                            edit.extendA();
                        }
                    } else {
                        if (edit == null) {
                            edit = new Edit(i - 1, i2 - 1);
                            this.editList.add(edit);
                        }
                        i2++;
                        edit.extendB();
                    }
                } else {
                    i++;
                    i2++;
                    edit = null;
                }
            }
        }
        return this.editList;
    }

    void parseHeader() {
        byte[] bArr = this.file.buf;
        MutableInteger mutableInteger = new MutableInteger();
        mutableInteger.value = RawParseUtils.nextLF(bArr, this.startOffset, TokenParser.SP);
        this.old.startLine = -RawParseUtils.parseBase10(bArr, mutableInteger.value, mutableInteger);
        if (bArr[mutableInteger.value] == 44) {
            this.old.lineCount = RawParseUtils.parseBase10(bArr, mutableInteger.value + 1, mutableInteger);
        } else {
            this.old.lineCount = 1;
        }
        this.newStartLine = RawParseUtils.parseBase10(bArr, mutableInteger.value + 1, mutableInteger);
        if (bArr[mutableInteger.value] == 44) {
            this.newLineCount = RawParseUtils.parseBase10(bArr, mutableInteger.value + 1, mutableInteger);
        } else {
            this.newLineCount = 1;
        }
    }

    int parseBody(Patch patch, int i) {
        byte[] bArr = this.file.buf;
        int iNextLF = RawParseUtils.nextLF(bArr, this.startOffset);
        this.old.nDeleted = 0;
        this.old.nAdded = 0;
        int i2 = iNextLF;
        while (iNextLF < i) {
            byte b = bArr[iNextLF];
            if (b == 10 || b == 32) {
                this.nContext++;
            } else if (b == 43) {
                this.old.nAdded++;
            } else if (b == 45) {
                this.old.nDeleted++;
            } else if (b != 92) {
                break;
            }
            i2 = iNextLF;
            iNextLF = RawParseUtils.nextLF(bArr, iNextLF);
        }
        if (i2 < i && (this.nContext + this.old.nDeleted) - 1 == this.old.lineCount && this.nContext + this.old.nAdded == this.newLineCount && RawParseUtils.match(bArr, i2, Patch.SIG_FOOTER) >= 0) {
            this.old.nDeleted--;
            return i2;
        }
        if (this.nContext + this.old.nDeleted < this.old.lineCount) {
            patch.error(bArr, this.startOffset, MessageFormat.format(JGitText.get().truncatedHunkOldLinesMissing, Integer.valueOf(this.old.lineCount - (this.nContext + this.old.nDeleted))));
            return iNextLF;
        }
        int i3 = this.nContext + this.old.nAdded;
        int i4 = this.newLineCount;
        if (i3 < i4) {
            patch.error(bArr, this.startOffset, MessageFormat.format(JGitText.get().truncatedHunkNewLinesMissing, Integer.valueOf(i4 - (this.nContext + this.old.nAdded))));
            return iNextLF;
        }
        if (this.nContext + this.old.nDeleted <= this.old.lineCount && this.nContext + this.old.nAdded <= this.newLineCount) {
            return iNextLF;
        }
        patch.warn(bArr, this.startOffset, MessageFormat.format(JGitText.get().hunkHeaderDoesNotMatchBodyLineCountOf, this.old.lineCount + CollectionUtils.COLON + this.newLineCount, (this.nContext + this.old.nDeleted) + CollectionUtils.COLON + (this.nContext + this.old.nAdded)));
        return iNextLF;
    }

    void extractFileLines(OutputStream[] outputStreamArr) throws IOException {
        byte[] bArr = this.file.buf;
        int i = this.startOffset;
        int iNextLF = RawParseUtils.nextLF(bArr, i);
        if (this.endOffset <= iNextLF) {
            return;
        }
        outputStreamArr[0].write(bArr, i, iNextLF - i);
        while (iNextLF < this.endOffset) {
            int iNextLF2 = RawParseUtils.nextLF(bArr, iNextLF);
            byte b = bArr[iNextLF];
            if (b == 10 || b == 32) {
                int i2 = iNextLF2 - iNextLF;
                outputStreamArr[0].write(bArr, iNextLF, i2);
                outputStreamArr[1].write(bArr, iNextLF, i2);
            } else if (b == 43) {
                outputStreamArr[1].write(bArr, iNextLF, iNextLF2 - iNextLF);
            } else if (b != 45) {
                if (b != 92) {
                    return;
                }
                int i3 = iNextLF2 - iNextLF;
                outputStreamArr[0].write(bArr, iNextLF, i3);
                outputStreamArr[1].write(bArr, iNextLF, i3);
            } else {
                outputStreamArr[0].write(bArr, iNextLF, iNextLF2 - iNextLF);
            }
            iNextLF = iNextLF2;
        }
    }

    void extractFileLines(StringBuilder sb, String[] strArr, int[] iArr) {
        byte[] bArr = this.file.buf;
        int iNextLF = RawParseUtils.nextLF(bArr, this.startOffset);
        if (this.endOffset <= iNextLF) {
            return;
        }
        copyLine(sb, strArr, iArr, 0);
        while (iNextLF < this.endOffset) {
            int iNextLF2 = RawParseUtils.nextLF(bArr, iNextLF);
            byte b = bArr[iNextLF];
            if (b == 10 || b == 32) {
                copyLine(sb, strArr, iArr, 0);
                skipLine(strArr, iArr, 1);
            } else if (b == 43) {
                copyLine(sb, strArr, iArr, 1);
            } else if (b != 45) {
                if (b != 92) {
                    return;
                }
                copyLine(sb, strArr, iArr, 0);
                skipLine(strArr, iArr, 1);
            } else {
                copyLine(sb, strArr, iArr, 0);
            }
            iNextLF = iNextLF2;
        }
    }

    void copyLine(StringBuilder sb, String[] strArr, int[] iArr, int i) {
        String str = strArr[i];
        int i2 = iArr[i];
        int iIndexOf = str.indexOf(10, i2);
        int length = iIndexOf < 0 ? str.length() : iIndexOf + 1;
        sb.append((CharSequence) str, i2, length);
        iArr[i] = length;
    }

    void skipLine(String[] strArr, int[] iArr, int i) {
        String str = strArr[i];
        int iIndexOf = str.indexOf(10, iArr[i]);
        iArr[i] = iIndexOf < 0 ? str.length() : iIndexOf + 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("HunkHeader[");
        sb.append(getOldImage().getStartLine());
        sb.append(AbstractJsonLexerKt.COMMA);
        sb.append(getOldImage().getLineCount());
        sb.append("->");
        sb.append(getNewStartLine()).append(AbstractJsonLexerKt.COMMA).append(getNewLineCount());
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }
}
