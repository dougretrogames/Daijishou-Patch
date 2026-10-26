package org.eclipse.jgit.patch;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.io.FilenameUtils;
import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.lib.AbbreviatedObjectId;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.util.RawParseUtils;

/* INFO: loaded from: classes5.dex */
public class CombinedFileHeader extends FileHeader {
    private static final byte[] MODE = Constants.encodeASCII("mode ");
    private AbbreviatedObjectId[] oldIds;
    private FileMode[] oldModes;

    CombinedFileHeader(byte[] bArr, int i) {
        super(bArr, i);
    }

    @Override // org.eclipse.jgit.patch.FileHeader
    public List<? extends CombinedHunkHeader> getHunks() {
        return super.getHunks();
    }

    @Override // org.eclipse.jgit.patch.FileHeader
    public int getParentCount() {
        return this.oldIds.length;
    }

    @Override // org.eclipse.jgit.diff.DiffEntry
    public FileMode getOldMode() {
        return getOldMode(0);
    }

    public FileMode getOldMode(int i) {
        return this.oldModes[i];
    }

    @Override // org.eclipse.jgit.diff.DiffEntry
    public AbbreviatedObjectId getOldId() {
        return getOldId(0);
    }

    public AbbreviatedObjectId getOldId(int i) {
        return this.oldIds[i];
    }

    @Override // org.eclipse.jgit.patch.FileHeader
    public String getScriptText(Charset charset, Charset charset2) {
        Charset[] charsetArr = new Charset[getParentCount() + 1];
        Arrays.fill(charsetArr, charset);
        charsetArr[getParentCount()] = charset2;
        return getScriptText(charsetArr);
    }

    @Override // org.eclipse.jgit.patch.FileHeader
    public String getScriptText(Charset[] charsetArr) {
        return super.getScriptText(charsetArr);
    }

    @Override // org.eclipse.jgit.patch.FileHeader
    int parseGitHeaders(int i, int i2) {
        while (i < i2) {
            int iNextLF = RawParseUtils.nextLF(this.buf, i);
            if (isHunkHdr(this.buf, i, i2) >= 1) {
                break;
            }
            if (RawParseUtils.match(this.buf, i, OLD_NAME) >= 0) {
                parseOldName(i, iNextLF);
            } else if (RawParseUtils.match(this.buf, i, NEW_NAME) >= 0) {
                parseNewName(i, iNextLF);
            } else if (RawParseUtils.match(this.buf, i, INDEX) >= 0) {
                parseIndexLine(i + INDEX.length, iNextLF);
            } else {
                byte[] bArr = this.buf;
                byte[] bArr2 = MODE;
                if (RawParseUtils.match(bArr, i, bArr2) >= 0) {
                    parseModeLine(i + bArr2.length, iNextLF);
                } else if (RawParseUtils.match(this.buf, i, NEW_FILE_MODE) >= 0) {
                    parseNewFileMode(i, iNextLF);
                } else {
                    if (RawParseUtils.match(this.buf, i, DELETED_FILE_MODE) < 0) {
                        break;
                    }
                    parseDeletedFileMode(i + DELETED_FILE_MODE.length, iNextLF);
                }
            }
            i = iNextLF;
        }
        return i;
    }

    @Override // org.eclipse.jgit.patch.FileHeader
    protected void parseIndexLine(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        while (i < i2) {
            int iNextLF = RawParseUtils.nextLF(this.buf, i, AbstractJsonLexerKt.COMMA);
            if (i2 <= iNextLF) {
                break;
            }
            arrayList.add(AbbreviatedObjectId.fromString(this.buf, i, iNextLF - 1));
            i = iNextLF;
        }
        AbbreviatedObjectId[] abbreviatedObjectIdArr = new AbbreviatedObjectId[arrayList.size() + 1];
        this.oldIds = abbreviatedObjectIdArr;
        arrayList.toArray(abbreviatedObjectIdArr);
        int iNextLF2 = RawParseUtils.nextLF(this.buf, i, FilenameUtils.EXTENSION_SEPARATOR);
        this.oldIds[arrayList.size()] = AbbreviatedObjectId.fromString(this.buf, i, iNextLF2 - 1);
        this.newId = AbbreviatedObjectId.fromString(this.buf, iNextLF2 + 1, i2 - 1);
        this.oldModes = new FileMode[this.oldIds.length];
    }

    @Override // org.eclipse.jgit.patch.FileHeader
    protected void parseNewFileMode(int i, int i2) {
        int i3 = 0;
        while (true) {
            FileMode[] fileModeArr = this.oldModes;
            if (i3 < fileModeArr.length) {
                fileModeArr[i3] = FileMode.MISSING;
                i3++;
            } else {
                super.parseNewFileMode(i, i2);
                return;
            }
        }
    }

    @Override // org.eclipse.jgit.patch.FileHeader
    HunkHeader newHunkHeader(int i) {
        return new CombinedHunkHeader(this, i);
    }

    private void parseModeLine(int i, int i2) {
        int i3 = 0;
        while (i < i2) {
            int iNextLF = RawParseUtils.nextLF(this.buf, i, AbstractJsonLexerKt.COMMA);
            if (i2 <= iNextLF) {
                break;
            }
            this.oldModes[i3] = parseFileMode(i, iNextLF);
            i = iNextLF;
            i3++;
        }
        int iNextLF2 = RawParseUtils.nextLF(this.buf, i, FilenameUtils.EXTENSION_SEPARATOR);
        this.oldModes[i3] = parseFileMode(i, iNextLF2);
        this.newMode = parseFileMode(iNextLF2 + 1, i2);
    }

    private void parseDeletedFileMode(int i, int i2) {
        this.changeType = DiffEntry.ChangeType.DELETE;
        int i3 = 0;
        while (i < i2) {
            int iNextLF = RawParseUtils.nextLF(this.buf, i, AbstractJsonLexerKt.COMMA);
            if (i2 <= iNextLF) {
                break;
            }
            this.oldModes[i3] = parseFileMode(i, iNextLF);
            i = iNextLF;
            i3++;
        }
        this.oldModes[i3] = parseFileMode(i, i2);
        this.newMode = FileMode.MISSING;
    }
}
