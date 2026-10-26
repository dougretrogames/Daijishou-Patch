package org.eclipse.jgit.notes;

import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.TreeFormatter;
import org.eclipse.jgit.util.Paths;

/* INFO: loaded from: classes5.dex */
class NonNoteEntry extends ObjectId {
    private final FileMode mode;
    private final byte[] name;
    NonNoteEntry next;

    NonNoteEntry(byte[] bArr, FileMode fileMode, AnyObjectId anyObjectId) {
        super(anyObjectId);
        this.name = bArr;
        this.mode = fileMode;
    }

    void format(TreeFormatter treeFormatter) {
        treeFormatter.append(this.name, this.mode, this);
    }

    int treeEntrySize() {
        return TreeFormatter.entrySize(this.mode, this.name.length);
    }

    int pathCompare(byte[] bArr, int i, int i2, FileMode fileMode) {
        byte[] bArr2 = this.name;
        return Paths.compare(bArr2, 0, bArr2.length, this.mode.getBits(), bArr, i, i2, fileMode.getBits());
    }
}
