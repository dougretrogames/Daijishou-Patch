package org.eclipse.jgit.dircache;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import org.eclipse.jgit.errors.UnmergedPathException;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.lib.TreeFormatter;
import org.eclipse.jgit.util.MutableInteger;
import org.eclipse.jgit.util.RawParseUtils;

/* INFO: loaded from: classes5.dex */
public class DirCacheTree {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int childCnt;
    private DirCacheTree[] children;
    byte[] encodedName;
    private int entrySpan;

    /* INFO: renamed from: id, reason: collision with root package name */
    private ObjectId f114id;
    private DirCacheTree parent;
    private static final byte[] NO_NAME = new byte[0];
    private static final DirCacheTree[] NO_CHILDREN = new DirCacheTree[0];
    private static final Comparator<DirCacheTree> TREE_CMP = new DirCacheTree$$ExternalSyntheticLambda0();

    static /* synthetic */ int lambda$0(DirCacheTree dirCacheTree, DirCacheTree dirCacheTree2) {
        byte[] bArr = dirCacheTree.encodedName;
        byte[] bArr2 = dirCacheTree2.encodedName;
        int length = bArr.length;
        int length2 = bArr2.length;
        int i = 0;
        while (i < length && i < length2) {
            int i2 = (bArr[i] & 255) - (bArr2[i] & 255);
            if (i2 != 0) {
                return i2;
            }
            i++;
        }
        if (length == length2) {
            return 0;
        }
        if (length < length2) {
            return 47 - (bArr2[i] & 255);
        }
        return (bArr[i] & 255) - 47;
    }

    DirCacheTree() {
        this.encodedName = NO_NAME;
        this.children = NO_CHILDREN;
        this.childCnt = 0;
        this.entrySpan = -1;
    }

    private DirCacheTree(DirCacheTree dirCacheTree, byte[] bArr, int i, int i2) {
        this.parent = dirCacheTree;
        byte[] bArr2 = new byte[i2];
        this.encodedName = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        this.children = NO_CHILDREN;
        this.childCnt = 0;
        this.entrySpan = -1;
    }

    DirCacheTree(byte[] bArr, MutableInteger mutableInteger, DirCacheTree dirCacheTree) {
        this.parent = dirCacheTree;
        int next = RawParseUtils.next(bArr, mutableInteger.value, (char) 0);
        boolean z = true;
        int i = (next - mutableInteger.value) - 1;
        if (i > 0) {
            this.encodedName = new byte[i];
            System.arraycopy(bArr, mutableInteger.value, this.encodedName, 0, i);
        } else {
            this.encodedName = NO_NAME;
        }
        this.entrySpan = RawParseUtils.parseBase10(bArr, next, mutableInteger);
        int base10 = RawParseUtils.parseBase10(bArr, mutableInteger.value, mutableInteger);
        mutableInteger.value = RawParseUtils.next(bArr, mutableInteger.value, '\n');
        if (this.entrySpan >= 0) {
            this.f114id = ObjectId.fromRaw(bArr, mutableInteger.value);
            mutableInteger.value += 20;
        }
        if (base10 > 0) {
            this.children = new DirCacheTree[base10];
            for (int i2 = 0; i2 < base10; i2++) {
                this.children[i2] = new DirCacheTree(bArr, mutableInteger, this);
                if (z && i2 > 0) {
                    Comparator<DirCacheTree> comparator = TREE_CMP;
                    DirCacheTree[] dirCacheTreeArr = this.children;
                    if (comparator.compare(dirCacheTreeArr[i2 - 1], dirCacheTreeArr[i2]) > 0) {
                        z = false;
                    }
                }
            }
            if (!z) {
                Arrays.sort(this.children, 0, base10, TREE_CMP);
            }
        } else {
            this.children = NO_CHILDREN;
        }
        this.childCnt = base10;
    }

    void write(byte[] bArr, OutputStream outputStream) throws IOException {
        int length = bArr.length - 1;
        bArr[length] = 10;
        int base10 = RawParseUtils.formatBase10(bArr, length, this.childCnt) - 1;
        bArr[base10] = 32;
        int base11 = RawParseUtils.formatBase10(bArr, base10, isValid() ? this.entrySpan : -1) - 1;
        bArr[base11] = 0;
        outputStream.write(this.encodedName);
        outputStream.write(bArr, base11, bArr.length - base11);
        if (isValid()) {
            this.f114id.copyRawTo(bArr, 0);
            outputStream.write(bArr, 0, 20);
        }
        for (int i = 0; i < this.childCnt; i++) {
            this.children[i].write(bArr, outputStream);
        }
    }

    public boolean isValid() {
        return this.f114id != null;
    }

    public int getEntrySpan() {
        return this.entrySpan;
    }

    public int getChildCount() {
        return this.childCnt;
    }

    public DirCacheTree getChild(int i) {
        return this.children[i];
    }

    public ObjectId getObjectId() {
        return this.f114id;
    }

    public String getNameString() {
        return StandardCharsets.UTF_8.decode(ByteBuffer.wrap(this.encodedName)).toString();
    }

    public String getPathString() {
        StringBuilder sb = new StringBuilder();
        appendName(sb);
        return sb.toString();
    }

    ObjectId writeTree(DirCacheEntry[] dirCacheEntryArr, int i, int i2, ObjectInserter objectInserter) throws IOException {
        if (this.f114id == null) {
            int i3 = this.entrySpan + i;
            TreeFormatter treeFormatter = new TreeFormatter(computeSize(dirCacheEntryArr, i, i2, objectInserter));
            int i4 = 0;
            while (i < i3) {
                DirCacheEntry dirCacheEntry = dirCacheEntryArr[i];
                byte[] bArr = dirCacheEntry.path;
                if (i4 < this.childCnt) {
                    DirCacheTree dirCacheTree = this.children[i4];
                    if (dirCacheTree.contains(bArr, i2, bArr.length)) {
                        treeFormatter.append(dirCacheTree.encodedName, FileMode.TREE, dirCacheTree.f114id);
                        i += dirCacheTree.entrySpan;
                        i4++;
                    }
                }
                treeFormatter.append(bArr, i2, bArr.length - i2, dirCacheEntry.getFileMode(), dirCacheEntry.idBuffer(), dirCacheEntry.idOffset());
                i++;
            }
            this.f114id = objectInserter.insert(treeFormatter);
        }
        return this.f114id;
    }

    private int computeSize(DirCacheEntry[] dirCacheEntryArr, int i, int i2, ObjectInserter objectInserter) throws IOException {
        int i3 = this.entrySpan + i;
        int iEntrySize = 0;
        int i4 = 0;
        while (i < i3) {
            DirCacheEntry dirCacheEntry = dirCacheEntryArr[i];
            if (dirCacheEntry.getStage() != 0) {
                throw new UnmergedPathException(dirCacheEntry);
            }
            byte[] bArr = dirCacheEntry.path;
            if (i4 < this.childCnt) {
                DirCacheTree dirCacheTree = this.children[i4];
                if (dirCacheTree.contains(bArr, i2, bArr.length)) {
                    dirCacheTree.writeTree(dirCacheEntryArr, i, dirCacheTree.nameLength() + i2 + 1, objectInserter);
                    iEntrySize += TreeFormatter.entrySize(FileMode.TREE, dirCacheTree.nameLength());
                    i += dirCacheTree.entrySpan;
                    i4++;
                }
            }
            iEntrySize += TreeFormatter.entrySize(dirCacheEntry.getFileMode(), bArr.length - i2);
            i++;
        }
        return iEntrySize;
    }

    private void appendName(StringBuilder sb) {
        DirCacheTree dirCacheTree = this.parent;
        if (dirCacheTree != null) {
            dirCacheTree.appendName(sb);
            sb.append(getNameString());
            sb.append('/');
        } else if (nameLength() > 0) {
            sb.append(getNameString());
            sb.append('/');
        }
    }

    final int nameLength() {
        return this.encodedName.length;
    }

    final boolean contains(byte[] bArr, int i, int i2) {
        byte[] bArr2 = this.encodedName;
        int length = bArr2.length;
        int i3 = 0;
        while (i3 < length && i < i2) {
            if (bArr2[i3] != bArr[i]) {
                return false;
            }
            i3++;
            i++;
        }
        return i < i2 && bArr[i] == 47;
    }

    void validate(DirCacheEntry[] dirCacheEntryArr, int i, int i2, int i3) {
        int i4 = this.entrySpan;
        if (i4 >= 0 && i4 + i2 <= i) {
            return;
        }
        int i5 = 0;
        this.entrySpan = 0;
        if (i == 0) {
            return;
        }
        byte[] bArr = dirCacheEntryArr[i2].path;
        while (i2 < i) {
            byte[] bArr2 = dirCacheEntryArr[i2].path;
            if (i3 > 0 && !peq(bArr, bArr2, i3)) {
                break;
            }
            DirCacheTree dirCacheTree = i5 < this.childCnt ? this.children[i5] : null;
            int iNamecmp = namecmp(bArr2, i3, dirCacheTree);
            if (iNamecmp > 0) {
                removeChild(i5);
            } else {
                if (iNamecmp < 0) {
                    int iSlash = slash(bArr2, i3);
                    if (iSlash < 0) {
                        i2++;
                        this.entrySpan++;
                    } else {
                        DirCacheTree dirCacheTree2 = new DirCacheTree(this, bArr2, i3, iSlash - i3);
                        insertChild(i5, dirCacheTree2);
                        dirCacheTree = dirCacheTree2;
                    }
                }
                dirCacheTree.validate(dirCacheEntryArr, i, i2, dirCacheTree.nameLength() + i3 + 1);
                int i6 = dirCacheTree.entrySpan;
                i2 += i6;
                this.entrySpan += i6;
                i5++;
            }
        }
        while (true) {
            int i7 = this.childCnt;
            if (i5 >= i7) {
                return;
            } else {
                removeChild(i7 - 1);
            }
        }
    }

    private void insertChild(int i, DirCacheTree dirCacheTree) {
        DirCacheTree[] dirCacheTreeArr = this.children;
        int i2 = this.childCnt;
        if (i2 + 1 <= dirCacheTreeArr.length) {
            if (i < i2) {
                System.arraycopy(dirCacheTreeArr, i, dirCacheTreeArr, i + 1, i2 - i);
            }
            dirCacheTreeArr[i] = dirCacheTree;
            this.childCnt++;
            return;
        }
        int length = dirCacheTreeArr.length;
        DirCacheTree[] dirCacheTreeArr2 = new DirCacheTree[length + 1];
        if (i > 0) {
            System.arraycopy(dirCacheTreeArr, 0, dirCacheTreeArr2, 0, i);
        }
        dirCacheTreeArr2[i] = dirCacheTree;
        if (i < length) {
            System.arraycopy(dirCacheTreeArr, i, dirCacheTreeArr2, i + 1, length - i);
        }
        this.children = dirCacheTreeArr2;
        this.childCnt++;
    }

    private void removeChild(int i) {
        int i2 = this.childCnt - 1;
        this.childCnt = i2;
        if (i < i2) {
            DirCacheTree[] dirCacheTreeArr = this.children;
            System.arraycopy(dirCacheTreeArr, i + 1, dirCacheTreeArr, i, i2 - i);
        }
        this.children[i2] = null;
    }

    static boolean peq(byte[] bArr, byte[] bArr2, int i) {
        if (bArr2.length < i) {
            return false;
        }
        do {
            i--;
            if (i < 0) {
                return true;
            }
        } while (bArr[i] == bArr2[i]);
        return false;
    }

    private static int namecmp(byte[] bArr, int i, DirCacheTree dirCacheTree) {
        if (dirCacheTree == null) {
            return -1;
        }
        byte[] bArr2 = dirCacheTree.encodedName;
        int length = bArr.length;
        int length2 = bArr2.length;
        int i2 = 0;
        while (i < length && i2 < length2) {
            int i3 = (bArr[i] & 255) - (bArr2[i2] & 255);
            if (i3 != 0) {
                return i3;
            }
            i++;
            i2++;
        }
        if (i2 == length2) {
            return bArr[i] == 47 ? 0 : -1;
        }
        return length - length2;
    }

    private static int slash(byte[] bArr, int i) {
        int length = bArr.length;
        while (i < length) {
            if (bArr[i] == 47) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public String toString() {
        return getNameString();
    }
}
