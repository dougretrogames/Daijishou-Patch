package com.google.common.hash;

import com.google.common.primitives.Longs;
import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class LittleEndianByteArray {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final LittleEndianBytes byteArray;

    private interface LittleEndianBytes {
        long getLongLittleEndian(byte[] array, int offset);

        void putLongLittleEndian(byte[] array, int offset, long value);
    }

    static long load64(byte[] input, int offset) {
        return byteArray.getLongLittleEndian(input, offset);
    }

    static long load64Safely(byte[] input, int offset, int length) {
        int iMin = Math.min(length, 8);
        long j = 0;
        for (int i = 0; i < iMin; i++) {
            j |= (((long) input[offset + i]) & 255) << (i * 8);
        }
        return j;
    }

    static void store64(byte[] sink, int offset, long value) {
        byteArray.putLongLittleEndian(sink, offset, value);
    }

    static int load32(byte[] source, int offset) {
        return ((source[offset + 3] & 255) << 24) | (source[offset] & 255) | ((source[offset + 1] & 255) << 8) | ((source[offset + 2] & 255) << 16);
    }

    static boolean usingUnsafe() {
        return byteArray instanceof UnsafeByteArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    static abstract class UnsafeByteArray implements LittleEndianBytes {
        private static final int BYTE_ARRAY_BASE_OFFSET;
        private static final Unsafe theUnsafe;
        public static final UnsafeByteArray UNSAFE_LITTLE_ENDIAN = new AnonymousClass1("UNSAFE_LITTLE_ENDIAN", 0);
        public static final UnsafeByteArray UNSAFE_BIG_ENDIAN = new AnonymousClass2("UNSAFE_BIG_ENDIAN", 1);
        private static final /* synthetic */ UnsafeByteArray[] $VALUES = $values();

        private static /* synthetic */ UnsafeByteArray[] $values() {
            return new UnsafeByteArray[]{UNSAFE_LITTLE_ENDIAN, UNSAFE_BIG_ENDIAN};
        }

        private UnsafeByteArray(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        /* synthetic */ UnsafeByteArray(String str, int i, AnonymousClass1 anonymousClass1) {
            this(str, i);
        }

        public static UnsafeByteArray valueOf(String name) {
            return (UnsafeByteArray) Enum.valueOf(UnsafeByteArray.class, name);
        }

        public static UnsafeByteArray[] values() {
            return (UnsafeByteArray[]) $VALUES.clone();
        }

        /* JADX INFO: renamed from: com.google.common.hash.LittleEndianByteArray$UnsafeByteArray$1, reason: invalid class name */
        final enum AnonymousClass1 extends UnsafeByteArray {
            AnonymousClass1(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // com.google.common.hash.LittleEndianByteArray.LittleEndianBytes
            public long getLongLittleEndian(byte[] array, int offset) {
                return UnsafeByteArray.theUnsafe.getLong(array, ((long) offset) + ((long) UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET));
            }

            @Override // com.google.common.hash.LittleEndianByteArray.LittleEndianBytes
            public void putLongLittleEndian(byte[] array, int offset, long value) {
                UnsafeByteArray.theUnsafe.putLong(array, ((long) offset) + ((long) UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET), value);
            }
        }

        static {
            Unsafe unsafe = getUnsafe();
            theUnsafe = unsafe;
            BYTE_ARRAY_BASE_OFFSET = unsafe.arrayBaseOffset(byte[].class);
            if (unsafe.arrayIndexScale(byte[].class) != 1) {
                throw new AssertionError();
            }
        }

        /* JADX INFO: renamed from: com.google.common.hash.LittleEndianByteArray$UnsafeByteArray$2, reason: invalid class name */
        final enum AnonymousClass2 extends UnsafeByteArray {
            AnonymousClass2(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // com.google.common.hash.LittleEndianByteArray.LittleEndianBytes
            public long getLongLittleEndian(byte[] array, int offset) {
                return Long.reverseBytes(UnsafeByteArray.theUnsafe.getLong(array, ((long) offset) + ((long) UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET)));
            }

            @Override // com.google.common.hash.LittleEndianByteArray.LittleEndianBytes
            public void putLongLittleEndian(byte[] array, int offset, long value) {
                UnsafeByteArray.theUnsafe.putLong(array, ((long) offset) + ((long) UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET), Long.reverseBytes(value));
            }
        }

        private static Unsafe getUnsafe() {
            try {
                try {
                    return Unsafe.getUnsafe();
                } catch (PrivilegedActionException e) {
                    throw new RuntimeException("Could not initialize intrinsics", e.getCause());
                }
            } catch (SecurityException unused) {
                return (Unsafe) AccessController.doPrivileged(new LittleEndianByteArray$UnsafeByteArray$$ExternalSyntheticLambda0());
            }
        }

        static /* synthetic */ Unsafe lambda$getUnsafe$0() throws Exception {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            throw new NoSuchFieldError("the Unsafe");
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    private static abstract class JavaLittleEndianBytes implements LittleEndianBytes {
        public static final JavaLittleEndianBytes INSTANCE = new AnonymousClass1("INSTANCE", 0);
        private static final /* synthetic */ JavaLittleEndianBytes[] $VALUES = $values();

        /* JADX INFO: renamed from: com.google.common.hash.LittleEndianByteArray$JavaLittleEndianBytes$1, reason: invalid class name */
        final enum AnonymousClass1 extends JavaLittleEndianBytes {
            AnonymousClass1(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // com.google.common.hash.LittleEndianByteArray.LittleEndianBytes
            public long getLongLittleEndian(byte[] source, int offset) {
                return Longs.fromBytes(source[offset + 7], source[offset + 6], source[offset + 5], source[offset + 4], source[offset + 3], source[offset + 2], source[offset + 1], source[offset]);
            }

            @Override // com.google.common.hash.LittleEndianByteArray.LittleEndianBytes
            public void putLongLittleEndian(byte[] sink, int offset, long value) {
                long j = 255;
                for (int i = 0; i < 8; i++) {
                    sink[offset + i] = (byte) ((value & j) >> (i * 8));
                    j <<= 8;
                }
            }
        }

        private static /* synthetic */ JavaLittleEndianBytes[] $values() {
            return new JavaLittleEndianBytes[]{INSTANCE};
        }

        private JavaLittleEndianBytes(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        /* synthetic */ JavaLittleEndianBytes(String str, int i, AnonymousClass1 anonymousClass1) {
            this(str, i);
        }

        public static JavaLittleEndianBytes valueOf(String name) {
            return (JavaLittleEndianBytes) Enum.valueOf(JavaLittleEndianBytes.class, name);
        }

        public static JavaLittleEndianBytes[] values() {
            return (JavaLittleEndianBytes[]) $VALUES.clone();
        }
    }

    static {
        LittleEndianBytes littleEndianBytes = JavaLittleEndianBytes.INSTANCE;
        try {
            if ("amd64".equals(System.getProperty("os.arch"))) {
                if (ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN)) {
                    littleEndianBytes = UnsafeByteArray.UNSAFE_LITTLE_ENDIAN;
                } else {
                    littleEndianBytes = UnsafeByteArray.UNSAFE_BIG_ENDIAN;
                }
            }
        } catch (Throwable unused) {
        }
        byteArray = littleEndianBytes;
    }

    private LittleEndianByteArray() {
    }
}
