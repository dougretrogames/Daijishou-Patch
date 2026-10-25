package org.eclipse.jgit.lib;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public abstract class FileMode {
    public static final int TYPE_FILE = 32768;
    public static final int TYPE_MASK = 61440;
    public static final int TYPE_MISSING = 0;
    public static final int TYPE_TREE = 16384;
    private final int modeBits;
    private final int objectType;
    private final byte[] octalBytes;
    public static final FileMode TREE = new AnonymousClass1(16384, 2);
    public static final int TYPE_SYMLINK = 40960;
    public static final FileMode SYMLINK = new AnonymousClass2(TYPE_SYMLINK, 3);
    public static final FileMode REGULAR_FILE = new AnonymousClass3(33188, 3);
    public static final FileMode EXECUTABLE_FILE = new AnonymousClass4(33261, 3);
    public static final int TYPE_GITLINK = 57344;
    public static final FileMode GITLINK = new AnonymousClass5(TYPE_GITLINK, 1);
    public static final FileMode MISSING = new AnonymousClass6(0, -1);

    /* synthetic */ FileMode(int i, int i2, FileModeIA fileModeIA) {
        this(i, i2);
    }

    public abstract boolean equals(int i);

    /* JADX INFO: renamed from: org.eclipse.jgit.lib.FileMode$1, reason: invalid class name */
    class AnonymousClass1 extends FileMode {
        @Override // org.eclipse.jgit.lib.FileMode
        public boolean equals(int i) {
            return (i & FileMode.TYPE_MASK) == 16384;
        }

        AnonymousClass1(int i, int i2) {
            super(i, i2, null);
        }
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.lib.FileMode$2, reason: invalid class name */
    class AnonymousClass2 extends FileMode {
        @Override // org.eclipse.jgit.lib.FileMode
        public boolean equals(int i) {
            return (i & FileMode.TYPE_MASK) == 40960;
        }

        AnonymousClass2(int i, int i2) {
            super(i, i2, null);
        }
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.lib.FileMode$3, reason: invalid class name */
    class AnonymousClass3 extends FileMode {
        @Override // org.eclipse.jgit.lib.FileMode
        public boolean equals(int i) {
            return (61440 & i) == 32768 && (i & 73) == 0;
        }

        AnonymousClass3(int i, int i2) {
            super(i, i2, null);
        }
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.lib.FileMode$4, reason: invalid class name */
    class AnonymousClass4 extends FileMode {
        @Override // org.eclipse.jgit.lib.FileMode
        public boolean equals(int i) {
            return (61440 & i) == 32768 && (i & 73) != 0;
        }

        AnonymousClass4(int i, int i2) {
            super(i, i2, null);
        }
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.lib.FileMode$5, reason: invalid class name */
    class AnonymousClass5 extends FileMode {
        @Override // org.eclipse.jgit.lib.FileMode
        public boolean equals(int i) {
            return (i & FileMode.TYPE_MASK) == 57344;
        }

        AnonymousClass5(int i, int i2) {
            super(i, i2, null);
        }
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.lib.FileMode$6, reason: invalid class name */
    class AnonymousClass6 extends FileMode {
        @Override // org.eclipse.jgit.lib.FileMode
        public boolean equals(int i) {
            return i == 0;
        }

        AnonymousClass6(int i, int i2) {
            super(i, i2, null);
        }
    }

    public static final FileMode fromBits(int i) {
        int i2 = 61440 & i;
        if (i2 != 0) {
            if (i2 == 16384) {
                return TREE;
            }
            if (i2 == 32768) {
                if ((i & 73) != 0) {
                    return EXECUTABLE_FILE;
                }
                return REGULAR_FILE;
            }
            if (i2 == 40960) {
                return SYMLINK;
            }
            if (i2 == 57344) {
                return GITLINK;
            }
        } else if (i == 0) {
            return MISSING;
        }
        return new AnonymousClass7(i, -1, i);
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.lib.FileMode$7, reason: invalid class name */
    class AnonymousClass7 extends FileMode {
        private final /* synthetic */ int val$bits;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass7(int i, int i2, int i3) {
            super(i, i2, null);
            this.val$bits = i3;
        }

        @Override // org.eclipse.jgit.lib.FileMode
        public boolean equals(int i) {
            return this.val$bits == i;
        }
    }

    private FileMode(int i, int i2) {
        this.modeBits = i;
        this.objectType = i2;
        int i3 = 0;
        if (i != 0) {
            int i4 = 10;
            byte[] bArr = new byte[10];
            while (i != 0) {
                i4--;
                bArr[i4] = (byte) ((i & 7) + 48);
                i >>= 3;
            }
            this.octalBytes = new byte[10 - i4];
            while (true) {
                byte[] bArr2 = this.octalBytes;
                if (i3 >= bArr2.length) {
                    return;
                }
                bArr2[i3] = bArr[i4 + i3];
                i3++;
            }
        } else {
            this.octalBytes = new byte[]{48};
        }
    }

    public void copyTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.octalBytes);
    }

    public void copyTo(byte[] bArr, int i) {
        byte[] bArr2 = this.octalBytes;
        System.arraycopy(bArr2, 0, bArr, i, bArr2.length);
    }

    public int copyToLength() {
        return this.octalBytes.length;
    }

    public int getObjectType() {
        return this.objectType;
    }

    public String toString() {
        return Integer.toOctalString(this.modeBits);
    }

    public int getBits() {
        return this.modeBits;
    }
}
