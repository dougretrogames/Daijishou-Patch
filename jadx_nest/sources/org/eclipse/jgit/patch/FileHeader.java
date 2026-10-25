package org.eclipse.jgit.patch;

import java.io.IOException;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.FilenameUtils;
import org.apache.http.message.TokenParser;
import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.diff.EditList;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AbbreviatedObjectId;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.util.QuotedString;
import org.eclipse.jgit.util.RawParseUtils;
import org.eclipse.jgit.util.TemporaryBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class FileHeader extends DiffEntry {
    final byte[] buf;
    int endOffset;
    BinaryHunk forwardBinaryHunk;
    private List<HunkHeader> hunks;
    PatchType patchType;
    BinaryHunk reverseBinaryHunk;
    final int startOffset;
    private static final byte[] OLD_MODE = Constants.encodeASCII("old mode ");
    private static final byte[] NEW_MODE = Constants.encodeASCII("new mode ");
    static final byte[] DELETED_FILE_MODE = Constants.encodeASCII("deleted file mode ");
    static final byte[] NEW_FILE_MODE = Constants.encodeASCII("new file mode ");
    private static final byte[] COPY_FROM = Constants.encodeASCII("copy from ");
    private static final byte[] COPY_TO = Constants.encodeASCII("copy to ");
    private static final byte[] RENAME_OLD = Constants.encodeASCII("rename old ");
    private static final byte[] RENAME_NEW = Constants.encodeASCII("rename new ");
    private static final byte[] RENAME_FROM = Constants.encodeASCII("rename from ");
    private static final byte[] RENAME_TO = Constants.encodeASCII("rename to ");
    private static final byte[] SIMILARITY_INDEX = Constants.encodeASCII("similarity index ");
    private static final byte[] DISSIMILARITY_INDEX = Constants.encodeASCII("dissimilarity index ");
    static final byte[] INDEX = Constants.encodeASCII("index ");
    static final byte[] OLD_NAME = Constants.encodeASCII("--- ");
    static final byte[] NEW_NAME = Constants.encodeASCII("+++ ");

    public enum PatchType {
        UNIFIED,
        BINARY,
        GIT_BINARY;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static PatchType[] valuesCustom() {
            PatchType[] patchTypeArrValuesCustom = values();
            int length = patchTypeArrValuesCustom.length;
            PatchType[] patchTypeArr = new PatchType[length];
            System.arraycopy(patchTypeArrValuesCustom, 0, patchTypeArr, 0, length);
            return patchTypeArr;
        }
    }

    int getParentCount() {
        return 1;
    }

    public FileHeader(byte[] bArr, EditList editList, PatchType patchType) {
        this(bArr, 0);
        this.endOffset = bArr.length;
        parseGitHeaders(parseGitFileName(Patch.DIFF_GIT.length, bArr.length), bArr.length);
        this.patchType = patchType;
        addHunk(new HunkHeader(this, editList));
    }

    FileHeader(byte[] bArr, int i) {
        this.buf = bArr;
        this.startOffset = i;
        this.changeType = DiffEntry.ChangeType.MODIFY;
        this.patchType = PatchType.UNIFIED;
    }

    public byte[] getBuffer() {
        return this.buf;
    }

    public int getStartOffset() {
        return this.startOffset;
    }

    public int getEndOffset() {
        return this.endOffset;
    }

    public String getScriptText() {
        return getScriptText(null, null);
    }

    public String getScriptText(Charset charset, Charset charset2) {
        return getScriptText(new Charset[]{charset, charset2});
    }

    String getScriptText(Charset[] charsetArr) {
        if (getHunks().isEmpty()) {
            return RawParseUtils.extractBinaryString(this.buf, this.startOffset, this.endOffset);
        }
        if (charsetArr != null && charsetArr.length != getParentCount() + 1) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().expectedCharacterEncodingGuesses, Integer.valueOf(getParentCount() + 1)));
        }
        if (trySimpleConversion(charsetArr)) {
            Charset charset = charsetArr != null ? charsetArr[0] : null;
            if (charset == null) {
                charset = StandardCharsets.UTF_8;
            }
            try {
                return RawParseUtils.decodeNoFallback(charset, this.buf, this.startOffset, this.endOffset);
            } catch (CharacterCodingException unused) {
            }
        }
        StringBuilder sb = new StringBuilder(this.endOffset - this.startOffset);
        int startOffset = getHunks().get(0).getStartOffset();
        int i = this.startOffset;
        while (i < startOffset) {
            int iMin = Math.min(startOffset, RawParseUtils.nextLF(this.buf, i));
            sb.append(RawParseUtils.extractBinaryString(this.buf, i, iMin));
            i = iMin;
        }
        String[] strArrExtractFileLines = extractFileLines(charsetArr);
        int[] iArr = new int[strArrExtractFileLines.length];
        Iterator<? extends HunkHeader> it = getHunks().iterator();
        while (it.hasNext()) {
            it.next().extractFileLines(sb, strArrExtractFileLines, iArr);
        }
        return sb.toString();
    }

    private static boolean trySimpleConversion(Charset[] charsetArr) {
        if (charsetArr == null) {
            return true;
        }
        for (int i = 1; i < charsetArr.length; i++) {
            if (charsetArr[i] != charsetArr[0]) {
                return false;
            }
        }
        return true;
    }

    private String[] extractFileLines(Charset[] charsetArr) {
        int parentCount = getParentCount() + 1;
        TemporaryBuffer[] temporaryBufferArr = new TemporaryBuffer[parentCount];
        for (int i = 0; i < parentCount; i++) {
            try {
                temporaryBufferArr[i] = new TemporaryBuffer.Heap(Integer.MAX_VALUE);
            } catch (IOException e) {
                throw new RuntimeException(JGitText.get().cannotConvertScriptToText, e);
            }
        }
        Iterator<? extends HunkHeader> it = getHunks().iterator();
        while (it.hasNext()) {
            it.next().extractFileLines(temporaryBufferArr);
        }
        String[] strArr = new String[parentCount];
        for (int i2 = 0; i2 < parentCount; i2++) {
            Charset charset = charsetArr != null ? charsetArr[i2] : null;
            if (charset == null) {
                charset = StandardCharsets.UTF_8;
            }
            strArr[i2] = RawParseUtils.decode(charset, temporaryBufferArr[i2].toByteArray());
        }
        return strArr;
    }

    public PatchType getPatchType() {
        return this.patchType;
    }

    public boolean hasMetaDataChanges() {
        return (this.changeType == DiffEntry.ChangeType.MODIFY && this.newMode == this.oldMode) ? false : true;
    }

    public List<? extends HunkHeader> getHunks() {
        List<HunkHeader> list = this.hunks;
        return list == null ? Collections.emptyList() : list;
    }

    void addHunk(HunkHeader hunkHeader) {
        if (hunkHeader.getFileHeader() != this) {
            throw new IllegalArgumentException(JGitText.get().hunkBelongsToAnotherFile);
        }
        if (this.hunks == null) {
            this.hunks = new ArrayList();
        }
        this.hunks.add(hunkHeader);
    }

    HunkHeader newHunkHeader(int i) {
        return new HunkHeader(this, i);
    }

    public BinaryHunk getForwardBinaryHunk() {
        return this.forwardBinaryHunk;
    }

    public BinaryHunk getReverseBinaryHunk() {
        return this.reverseBinaryHunk;
    }

    public EditList toEditList() {
        EditList editList = new EditList();
        Iterator<HunkHeader> it = this.hunks.iterator();
        while (it.hasNext()) {
            editList.addAll(it.next().toEditList());
        }
        return editList;
    }

    int parseGitFileName(int i, int i2) {
        int iNextLF;
        int iNextLF2 = RawParseUtils.nextLF(this.buf, i);
        if (iNextLF2 >= i2) {
            return -1;
        }
        int iNextLF3 = RawParseUtils.nextLF(this.buf, i, '/');
        if (iNextLF3 < iNextLF2) {
            int iNextLF4 = i;
            while (iNextLF4 < iNextLF2) {
                iNextLF4 = RawParseUtils.nextLF(this.buf, iNextLF4, TokenParser.SP);
                if (iNextLF4 >= iNextLF2 || (iNextLF = RawParseUtils.nextLF(this.buf, iNextLF4, '/')) >= iNextLF2) {
                    break;
                }
                int i3 = iNextLF4 - 1;
                if (eq(iNextLF3, i3, iNextLF, iNextLF2 - 1)) {
                    byte[] bArr = this.buf;
                    if (bArr[i] == 34) {
                        if (bArr[iNextLF4 - 2] != 34) {
                            break;
                        }
                        this.oldPath = QuotedString.GIT_PATH.dequote(this.buf, i, i3);
                        this.oldPath = p1(this.oldPath);
                    } else {
                        this.oldPath = RawParseUtils.decode(StandardCharsets.UTF_8, this.buf, iNextLF3, i3);
                    }
                    this.newPath = this.oldPath;
                    return iNextLF2;
                }
            }
        }
        return iNextLF2;
    }

    int parseGitHeaders(int i, int i2) {
        while (i < i2) {
            int iNextLF = RawParseUtils.nextLF(this.buf, i);
            if (isHunkHdr(this.buf, i, iNextLF) >= 1) {
                break;
            }
            if (RawParseUtils.match(this.buf, i, OLD_NAME) >= 0) {
                parseOldName(i, iNextLF);
            } else if (RawParseUtils.match(this.buf, i, NEW_NAME) >= 0) {
                parseNewName(i, iNextLF);
            } else {
                byte[] bArr = this.buf;
                byte[] bArr2 = OLD_MODE;
                if (RawParseUtils.match(bArr, i, bArr2) >= 0) {
                    this.oldMode = parseFileMode(i + bArr2.length, iNextLF);
                } else {
                    byte[] bArr3 = this.buf;
                    byte[] bArr4 = NEW_MODE;
                    if (RawParseUtils.match(bArr3, i, bArr4) >= 0) {
                        this.newMode = parseFileMode(i + bArr4.length, iNextLF);
                    } else {
                        byte[] bArr5 = this.buf;
                        byte[] bArr6 = DELETED_FILE_MODE;
                        if (RawParseUtils.match(bArr5, i, bArr6) >= 0) {
                            this.oldMode = parseFileMode(i + bArr6.length, iNextLF);
                            this.newMode = FileMode.MISSING;
                            this.changeType = DiffEntry.ChangeType.DELETE;
                        } else if (RawParseUtils.match(this.buf, i, NEW_FILE_MODE) >= 0) {
                            parseNewFileMode(i, iNextLF);
                        } else {
                            byte[] bArr7 = this.buf;
                            byte[] bArr8 = COPY_FROM;
                            if (RawParseUtils.match(bArr7, i, bArr8) >= 0) {
                                this.oldPath = parseName(this.oldPath, i + bArr8.length, iNextLF);
                                this.changeType = DiffEntry.ChangeType.COPY;
                            } else {
                                byte[] bArr9 = this.buf;
                                byte[] bArr10 = COPY_TO;
                                if (RawParseUtils.match(bArr9, i, bArr10) >= 0) {
                                    this.newPath = parseName(this.newPath, i + bArr10.length, iNextLF);
                                    this.changeType = DiffEntry.ChangeType.COPY;
                                } else {
                                    byte[] bArr11 = this.buf;
                                    byte[] bArr12 = RENAME_OLD;
                                    if (RawParseUtils.match(bArr11, i, bArr12) >= 0) {
                                        this.oldPath = parseName(this.oldPath, i + bArr12.length, iNextLF);
                                        this.changeType = DiffEntry.ChangeType.RENAME;
                                    } else {
                                        byte[] bArr13 = this.buf;
                                        byte[] bArr14 = RENAME_NEW;
                                        if (RawParseUtils.match(bArr13, i, bArr14) >= 0) {
                                            this.newPath = parseName(this.newPath, i + bArr14.length, iNextLF);
                                            this.changeType = DiffEntry.ChangeType.RENAME;
                                        } else {
                                            byte[] bArr15 = this.buf;
                                            byte[] bArr16 = RENAME_FROM;
                                            if (RawParseUtils.match(bArr15, i, bArr16) >= 0) {
                                                this.oldPath = parseName(this.oldPath, i + bArr16.length, iNextLF);
                                                this.changeType = DiffEntry.ChangeType.RENAME;
                                            } else {
                                                byte[] bArr17 = this.buf;
                                                byte[] bArr18 = RENAME_TO;
                                                if (RawParseUtils.match(bArr17, i, bArr18) >= 0) {
                                                    this.newPath = parseName(this.newPath, i + bArr18.length, iNextLF);
                                                    this.changeType = DiffEntry.ChangeType.RENAME;
                                                } else {
                                                    byte[] bArr19 = this.buf;
                                                    byte[] bArr20 = SIMILARITY_INDEX;
                                                    if (RawParseUtils.match(bArr19, i, bArr20) >= 0) {
                                                        this.score = RawParseUtils.parseBase10(this.buf, i + bArr20.length, null);
                                                    } else {
                                                        byte[] bArr21 = this.buf;
                                                        byte[] bArr22 = DISSIMILARITY_INDEX;
                                                        if (RawParseUtils.match(bArr21, i, bArr22) >= 0) {
                                                            this.score = RawParseUtils.parseBase10(this.buf, i + bArr22.length, null);
                                                        } else {
                                                            byte[] bArr23 = this.buf;
                                                            byte[] bArr24 = INDEX;
                                                            if (RawParseUtils.match(bArr23, i, bArr24) < 0) {
                                                                break;
                                                            }
                                                            parseIndexLine(i + bArr24.length, iNextLF);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            i = iNextLF;
        }
        return i;
    }

    void parseOldName(int i, int i2) {
        this.oldPath = p1(parseName(this.oldPath, i + OLD_NAME.length, i2));
        if (this.oldPath == DiffEntry.DEV_NULL) {
            this.changeType = DiffEntry.ChangeType.ADD;
        }
    }

    void parseNewName(int i, int i2) {
        this.newPath = p1(parseName(this.newPath, i + NEW_NAME.length, i2));
        if (this.newPath == DiffEntry.DEV_NULL) {
            this.changeType = DiffEntry.ChangeType.DELETE;
        }
    }

    void parseNewFileMode(int i, int i2) {
        this.oldMode = FileMode.MISSING;
        this.newMode = parseFileMode(i + NEW_FILE_MODE.length, i2);
        this.changeType = DiffEntry.ChangeType.ADD;
    }

    int parseTraditionalHeaders(int i, int i2) {
        while (i < i2) {
            int iNextLF = RawParseUtils.nextLF(this.buf, i);
            if (isHunkHdr(this.buf, i, iNextLF) >= 1) {
                break;
            }
            if (RawParseUtils.match(this.buf, i, OLD_NAME) >= 0) {
                parseOldName(i, iNextLF);
            } else {
                if (RawParseUtils.match(this.buf, i, NEW_NAME) < 0) {
                    break;
                }
                parseNewName(i, iNextLF);
            }
            i = iNextLF;
        }
        return i;
    }

    private String parseName(String str, int i, int i2) {
        String strDecode;
        if (i == i2) {
            return str;
        }
        if (this.buf[i] == 34) {
            strDecode = QuotedString.GIT_PATH.dequote(this.buf, i, i2 - 1);
        } else {
            int i3 = i2;
            while (i < i3 && this.buf[i3 - 1] != 9) {
                i3--;
            }
            if (i != i3) {
                i2 = i3;
            }
            strDecode = RawParseUtils.decode(StandardCharsets.UTF_8, this.buf, i, i2 - 1);
        }
        return strDecode.equals(DiffEntry.DEV_NULL) ? DiffEntry.DEV_NULL : strDecode;
    }

    private static String p1(String str) {
        int iIndexOf = str.indexOf(47);
        return iIndexOf > 0 ? str.substring(iIndexOf + 1) : str;
    }

    FileMode parseFileMode(int i, int i2) {
        int i3 = 0;
        while (i < i2 - 1) {
            i3 = (i3 << 3) + (this.buf[i] - 48);
            i++;
        }
        return FileMode.fromBits(i3);
    }

    void parseIndexLine(int i, int i2) {
        int iNextLF = RawParseUtils.nextLF(this.buf, i, FilenameUtils.EXTENSION_SEPARATOR);
        int iNextLF2 = RawParseUtils.nextLF(this.buf, iNextLF, TokenParser.SP);
        this.oldId = AbbreviatedObjectId.fromString(this.buf, i, iNextLF - 1);
        this.newId = AbbreviatedObjectId.fromString(this.buf, iNextLF + 1, iNextLF2 - 1);
        if (iNextLF2 < i2) {
            FileMode fileMode = parseFileMode(iNextLF2, i2);
            this.oldMode = fileMode;
            this.newMode = fileMode;
        }
    }

    private boolean eq(int i, int i2, int i3, int i4) {
        if (i2 - i != i4 - i3) {
            return false;
        }
        while (i < i2) {
            byte[] bArr = this.buf;
            int i5 = i + 1;
            int i6 = i3 + 1;
            if (bArr[i] != bArr[i3]) {
                return false;
            }
            i = i5;
            i3 = i6;
        }
        return true;
    }

    static int isHunkHdr(byte[] bArr, int i, int i2) {
        int i3 = i;
        while (i3 < i2 && bArr[i3] == 64) {
            i3++;
        }
        if (i3 - i >= 2 && i3 != i2) {
            int i4 = i3 + 1;
            if (bArr[i3] == 32 && i4 != i2 && bArr[i4] == 45) {
                return (i3 - 1) - i;
            }
        }
        return 0;
    }
}
