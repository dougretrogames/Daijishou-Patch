package org.eclipse.jgit.notes;

import java.io.IOException;
import org.eclipse.jgit.lib.AbbreviatedObjectId;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.lib.MutableObjectId;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.treewalk.CanonicalTreeParser;
import org.eclipse.jgit.util.RawParseUtils;

/* JADX INFO: loaded from: classes5.dex */
final class NoteParser extends CanonicalTreeParser {
    private NonNoteEntry firstNonNote;
    private NonNoteEntry lastNonNote;
    private final int pathPadding;
    private final int prefixLen;

    static InMemoryNoteBucket parse(AbbreviatedObjectId abbreviatedObjectId, ObjectId objectId, ObjectReader objectReader) throws IOException {
        return new NoteParser(abbreviatedObjectId, objectReader, objectId).parse();
    }

    private NoteParser(AbbreviatedObjectId abbreviatedObjectId, ObjectReader objectReader, ObjectId objectId) throws IOException {
        super(Constants.encodeASCII(abbreviatedObjectId.name()), objectReader, objectId);
        int length = abbreviatedObjectId.length();
        this.prefixLen = length;
        int i = length > 0 ? 1 : 0;
        this.pathPadding = i;
        if (i > 0) {
            System.arraycopy(this.path, 0, this.path, i, length);
        }
    }

    private InMemoryNoteBucket parse() {
        InMemoryNoteBucket tree = parseTree();
        tree.nonNotes = this.firstNonNote;
        return tree;
    }

    private InMemoryNoteBucket parseTree() {
        while (!eof()) {
            if (this.pathLen == this.pathPadding + 40 && isHex()) {
                return parseLeafTree();
            }
            if (getNameLength() == 2 && isHex() && isTree()) {
                return parseFanoutTree();
            }
            storeNonNote();
            next(1);
        }
        return new LeafBucket(this.prefixLen);
    }

    private LeafBucket parseLeafTree() {
        LeafBucket leafBucket = new LeafBucket(this.prefixLen);
        MutableObjectId mutableObjectId = new MutableObjectId();
        while (!eof()) {
            if (parseObjectId(mutableObjectId)) {
                leafBucket.parseOneEntry(mutableObjectId, getEntryObjectId());
            } else {
                storeNonNote();
            }
            next(1);
        }
        return leafBucket;
    }

    private boolean parseObjectId(MutableObjectId mutableObjectId) {
        if (this.pathLen == this.pathPadding + 40) {
            try {
                mutableObjectId.fromString(this.path, this.pathPadding);
                return true;
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return false;
    }

    private FanoutBucket parseFanoutTree() {
        FanoutBucket fanoutBucket = new FanoutBucket(this.prefixLen);
        while (!eof()) {
            int fanoutCell = parseFanoutCell();
            if (fanoutCell >= 0) {
                fanoutBucket.setBucket(fanoutCell, getEntryObjectId());
            } else {
                storeNonNote();
            }
            next(1);
        }
        return fanoutBucket;
    }

    private int parseFanoutCell() {
        if (getNameLength() == 2 && isTree()) {
            try {
                return (RawParseUtils.parseHexInt4(this.path[this.pathOffset]) << 4) | RawParseUtils.parseHexInt4(this.path[this.pathOffset + 1]);
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return -1;
    }

    private void storeNonNote() {
        ObjectId entryObjectId = getEntryObjectId();
        FileMode entryFileMode = getEntryFileMode();
        byte[] bArr = new byte[getNameLength()];
        getName(bArr, 0);
        NonNoteEntry nonNoteEntry = new NonNoteEntry(bArr, entryFileMode, entryObjectId);
        if (this.firstNonNote == null) {
            this.firstNonNote = nonNoteEntry;
        }
        NonNoteEntry nonNoteEntry2 = this.lastNonNote;
        if (nonNoteEntry2 != null) {
            nonNoteEntry2.next = nonNoteEntry;
        }
        this.lastNonNote = nonNoteEntry;
    }

    private boolean isTree() {
        return FileMode.TREE.equals(this.mode);
    }

    private boolean isHex() {
        try {
            for (int i = this.pathOffset; i < this.pathLen; i++) {
                RawParseUtils.parseHexInt4(this.path[i]);
            }
            return true;
        } catch (ArrayIndexOutOfBoundsException unused) {
            return false;
        }
    }
}
