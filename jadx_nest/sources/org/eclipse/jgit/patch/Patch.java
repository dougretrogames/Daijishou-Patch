package org.eclipse.jgit.patch;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.util.RawParseUtils;
import org.eclipse.jgit.util.TemporaryBuffer;

/* INFO: loaded from: classes5.dex */
public class Patch {
    static final byte[] DIFF_GIT = Constants.encodeASCII("diff --git ");
    private static final byte[] DIFF_CC = Constants.encodeASCII("diff --cc ");
    private static final byte[] DIFF_COMBINED = Constants.encodeASCII("diff --combined ");
    private static final byte[][] BIN_HEADERS = {Constants.encodeASCII("Binary files "), Constants.encodeASCII("Files ")};
    private static final byte[] BIN_TRAILER = Constants.encodeASCII(" differ\n");
    private static final byte[] GIT_BINARY = Constants.encodeASCII("GIT binary patch\n");
    static final byte[] SIG_FOOTER = Constants.encodeASCII("-- \n");
    private final List<FileHeader> files = new ArrayList();
    private final List<FormatError> errors = new ArrayList(0);

    public void addFile(FileHeader fileHeader) {
        this.files.add(fileHeader);
    }

    public List<? extends FileHeader> getFiles() {
        return this.files;
    }

    public void addError(FormatError formatError) {
        this.errors.add(formatError);
    }

    public List<FormatError> getErrors() {
        return this.errors;
    }

    public void parse(InputStream inputStream) throws IOException {
        byte[] fully = readFully(inputStream);
        parse(fully, 0, fully.length);
    }

    private static byte[] readFully(InputStream inputStream) throws IOException {
        Throwable th = null;
        try {
            TemporaryBuffer.Heap heap = new TemporaryBuffer.Heap(Integer.MAX_VALUE);
            try {
                heap.copy(inputStream);
                return heap.toByteArray();
            } finally {
                heap.close();
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                th.addSuppressed(th2);
            }
            throw null;
        }
    }

    public void parse(byte[] bArr, int i, int i2) {
        while (i < i2) {
            i = parseFile(bArr, i, i2);
        }
    }

    private int parseFile(byte[] bArr, int i, int i2) {
        while (i < i2) {
            if (FileHeader.isHunkHdr(bArr, i, i2) >= 1) {
                error(bArr, i, JGitText.get().hunkDisconnectedFromFile);
                i = RawParseUtils.nextLF(bArr, i);
            } else {
                if (RawParseUtils.match(bArr, i, DIFF_GIT) >= 0) {
                    return parseDiffGit(bArr, i, i2);
                }
                byte[] bArr2 = DIFF_CC;
                if (RawParseUtils.match(bArr, i, bArr2) >= 0) {
                    return parseDiffCombined(bArr2, bArr, i, i2);
                }
                byte[] bArr3 = DIFF_COMBINED;
                if (RawParseUtils.match(bArr, i, bArr3) >= 0) {
                    return parseDiffCombined(bArr3, bArr, i, i2);
                }
                int iNextLF = RawParseUtils.nextLF(bArr, i);
                if (iNextLF < i2) {
                    if (iNextLF - i >= 6 && RawParseUtils.match(bArr, i, FileHeader.OLD_NAME) >= 0 && RawParseUtils.match(bArr, iNextLF, FileHeader.NEW_NAME) >= 0) {
                        int iNextLF2 = RawParseUtils.nextLF(bArr, iNextLF);
                        if (iNextLF2 < i2) {
                            if (FileHeader.isHunkHdr(bArr, iNextLF2, i2) == 1) {
                                return parseTraditionalPatch(bArr, i, i2);
                            }
                        }
                    }
                    i = iNextLF;
                }
                return i2;
            }
        }
        return i;
    }

    private int parseDiffGit(byte[] bArr, int i, int i2) {
        FileHeader fileHeader = new FileHeader(bArr, i);
        int gitFileName = fileHeader.parseGitFileName(DIFF_GIT.length + i, i2);
        if (gitFileName < 0) {
            return skipFile(bArr, i);
        }
        int hunks = parseHunks(fileHeader, fileHeader.parseGitHeaders(gitFileName, i2), i2);
        fileHeader.endOffset = hunks;
        addFile(fileHeader);
        return hunks;
    }

    private int parseDiffCombined(byte[] bArr, byte[] bArr2, int i, int i2) {
        CombinedFileHeader combinedFileHeader = new CombinedFileHeader(bArr2, i);
        int gitFileName = combinedFileHeader.parseGitFileName(bArr.length + i, i2);
        if (gitFileName < 0) {
            return skipFile(bArr2, i);
        }
        int hunks = parseHunks(combinedFileHeader, combinedFileHeader.parseGitHeaders(gitFileName, i2), i2);
        combinedFileHeader.endOffset = hunks;
        addFile(combinedFileHeader);
        return hunks;
    }

    private int parseTraditionalPatch(byte[] bArr, int i, int i2) {
        FileHeader fileHeader = new FileHeader(bArr, i);
        int hunks = parseHunks(fileHeader, fileHeader.parseTraditionalHeaders(i, i2), i2);
        fileHeader.endOffset = hunks;
        addFile(fileHeader);
        return hunks;
    }

    private static int skipFile(byte[] bArr, int i) {
        int iNextLF = RawParseUtils.nextLF(bArr, i);
        return RawParseUtils.match(bArr, iNextLF, FileHeader.OLD_NAME) >= 0 ? RawParseUtils.nextLF(bArr, iNextLF) : iNextLF;
    }

    private int parseHunks(FileHeader fileHeader, int i, int i2) {
        int iNextLF;
        byte b;
        byte[] bArr = fileHeader.buf;
        while (i < i2 && RawParseUtils.match(bArr, i, DIFF_GIT) < 0 && RawParseUtils.match(bArr, i, DIFF_CC) < 0 && RawParseUtils.match(bArr, i, DIFF_COMBINED) < 0 && RawParseUtils.match(bArr, i, FileHeader.OLD_NAME) < 0 && RawParseUtils.match(bArr, i, FileHeader.NEW_NAME) < 0) {
            if (FileHeader.isHunkHdr(bArr, i, i2) == fileHeader.getParentCount()) {
                HunkHeader hunkHeaderNewHunkHeader = fileHeader.newHunkHeader(i);
                hunkHeaderNewHunkHeader.parseHeader();
                iNextLF = hunkHeaderNewHunkHeader.parseBody(this, i2);
                hunkHeaderNewHunkHeader.endOffset = iNextLF;
                fileHeader.addHunk(hunkHeaderNewHunkHeader);
                if (iNextLF < i2 && (b = bArr[iNextLF]) != 10 && b != 64 && b != 100 && RawParseUtils.match(bArr, iNextLF, SIG_FOOTER) < 0) {
                    warn(bArr, iNextLF, JGitText.get().unexpectedHunkTrailer);
                }
            } else {
                iNextLF = RawParseUtils.nextLF(bArr, i);
                if (fileHeader.getHunks().isEmpty() && RawParseUtils.match(bArr, i, GIT_BINARY) >= 0) {
                    fileHeader.patchType = FileHeader.PatchType.GIT_BINARY;
                    return parseGitBinary(fileHeader, iNextLF, i2);
                }
                if (fileHeader.getHunks().isEmpty()) {
                    byte[] bArr2 = BIN_TRAILER;
                    if (bArr2.length < iNextLF - i && RawParseUtils.match(bArr, iNextLF - bArr2.length, bArr2) >= 0 && matchAny(bArr, i, BIN_HEADERS)) {
                        fileHeader.patchType = FileHeader.PatchType.BINARY;
                        return iNextLF;
                    }
                } else {
                    continue;
                }
            }
            i = iNextLF;
        }
        if (fileHeader.getHunks().isEmpty() && fileHeader.getPatchType() == FileHeader.PatchType.UNIFIED && !fileHeader.hasMetaDataChanges()) {
            fileHeader.patchType = FileHeader.PatchType.BINARY;
        }
        return i;
    }

    private int parseGitBinary(FileHeader fileHeader, int i, int i2) {
        BinaryHunk binaryHunk = new BinaryHunk(fileHeader, i);
        int hunk = binaryHunk.parseHunk(i, i2);
        if (hunk < 0) {
            error(fileHeader.buf, i, JGitText.get().missingForwardImageInGITBinaryPatch);
            return i;
        }
        binaryHunk.endOffset = hunk;
        fileHeader.forwardBinaryHunk = binaryHunk;
        BinaryHunk binaryHunk2 = new BinaryHunk(fileHeader, hunk);
        int hunk2 = binaryHunk2.parseHunk(hunk, i2);
        if (hunk2 < 0) {
            return hunk;
        }
        binaryHunk2.endOffset = hunk2;
        fileHeader.reverseBinaryHunk = binaryHunk2;
        return hunk2;
    }

    void warn(byte[] bArr, int i, String str) {
        addError(new FormatError(bArr, i, FormatError.Severity.WARNING, str));
    }

    void error(byte[] bArr, int i, String str) {
        addError(new FormatError(bArr, i, FormatError.Severity.ERROR, str));
    }

    private static boolean matchAny(byte[] bArr, int i, byte[][] bArr2) {
        for (byte[] bArr3 : bArr2) {
            if (RawParseUtils.match(bArr, i, bArr3) >= 0) {
                return true;
            }
        }
        return false;
    }
}
