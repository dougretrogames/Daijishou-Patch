package org.eclipse.jgit.transport;

import java.math.BigInteger;
import java.text.MessageFormat;
import java.util.Objects;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.errors.PackProtocolException;
import org.eclipse.jgit.internal.JGitText;

/* INFO: loaded from: classes5.dex */
public final class FilterSpec {
    public static final FilterSpec NO_FILTER = new FilterSpec(ObjectTypes.ALL, -1, -1);
    private final long blobLimit;
    private final long treeDepthLimit;
    private final ObjectTypes types;

    static class ObjectTypes {
        static ObjectTypes ALL = allow(3, 2, 1, 4);
        private final BigInteger val;

        private ObjectTypes(BigInteger bigInteger) {
            this.val = (BigInteger) Objects.requireNonNull(bigInteger);
        }

        static ObjectTypes allow(int... iArr) {
            BigInteger bit = BigInteger.ZERO;
            for (int i : iArr) {
                bit = bit.setBit(i);
            }
            return new ObjectTypes(bit);
        }

        boolean contains(int i) {
            return this.val.testBit(i);
        }

        public boolean equals(Object obj) {
            if (obj instanceof ObjectTypes) {
                return ((ObjectTypes) obj).val.equals(this.val);
            }
            return false;
        }

        public int hashCode() {
            return this.val.hashCode();
        }
    }

    private FilterSpec(ObjectTypes objectTypes, long j, long j2) {
        this.types = (ObjectTypes) Objects.requireNonNull(objectTypes);
        this.blobLimit = j;
        this.treeDepthLimit = j2;
    }

    public static FilterSpec fromFilterLine(String str) throws PackProtocolException {
        if (str.equals("blob:none")) {
            return withObjectTypes(ObjectTypes.allow(2, 1, 4));
        }
        long j = -1;
        if (str.startsWith("blob:limit=")) {
            try {
                j = Long.parseLong(str.substring("blob:limit=".length()));
            } catch (NumberFormatException unused) {
            }
            if (j >= 0) {
                return withBlobLimit(j);
            }
        } else if (str.startsWith("tree:")) {
            try {
                j = Long.parseLong(str.substring("tree:".length()));
            } catch (NumberFormatException unused2) {
            }
            if (j >= 0) {
                return withTreeDepthLimit(j);
            }
        }
        throw new PackProtocolException(MessageFormat.format(JGitText.get().invalidFilter, str));
    }

    static FilterSpec withObjectTypes(ObjectTypes objectTypes) {
        return new FilterSpec(objectTypes, -1L, -1L);
    }

    static FilterSpec withBlobLimit(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("blobLimit cannot be negative: " + j);
        }
        return new FilterSpec(ObjectTypes.ALL, j, -1L);
    }

    static FilterSpec withTreeDepthLimit(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("treeDepthLimit cannot be negative: " + j);
        }
        return new FilterSpec(ObjectTypes.ALL, -1L, j);
    }

    public boolean allowsType(int i) {
        return this.types.contains(i);
    }

    public long getBlobLimit() {
        return this.blobLimit;
    }

    public long getTreeDepthLimit() {
        return this.treeDepthLimit;
    }

    public boolean isNoOp() {
        return this.types.equals(ObjectTypes.ALL) && this.blobLimit == -1 && this.treeDepthLimit == -1;
    }

    @Nullable
    public String filterLine() {
        if (isNoOp()) {
            return null;
        }
        if (this.types.equals(ObjectTypes.allow(2, 1, 4)) && this.blobLimit == -1 && this.treeDepthLimit == -1) {
            return "filter blob:none";
        }
        if (this.types.equals(ObjectTypes.ALL)) {
            long j = this.blobLimit;
            if (j >= 0 && this.treeDepthLimit == -1) {
                return "filter blob:limit=" + j;
            }
        }
        if (this.types.equals(ObjectTypes.ALL) && this.blobLimit == -1) {
            long j2 = this.treeDepthLimit;
            if (j2 >= 0) {
                return "filter tree:" + j2;
            }
        }
        throw new IllegalStateException();
    }
}
