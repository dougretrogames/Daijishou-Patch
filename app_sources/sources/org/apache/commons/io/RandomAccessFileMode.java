package org.apache.commons.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Objects;
import org.apache.commons.io.function.IOConsumer;
import org.apache.commons.io.function.IOFunction;

/* INFO: loaded from: classes5.dex */
public enum RandomAccessFileMode {
    READ_ONLY(R, 1),
    READ_WRITE(RW, 2),
    READ_WRITE_SYNC_ALL(RWS, 4),
    READ_WRITE_SYNC_CONTENT(RWD, 3);

    private static final String R = "r";
    private static final String RW = "rw";
    private static final String RWD = "rwd";
    private static final String RWS = "rws";
    private final int level;
    private final String mode;

    /* WARN: Code duplicated, block: B:21:0x003a A[PHI: r3
  0x003a: PHI (r3v5 org.apache.commons.io.RandomAccessFileMode) = 
  (r3v4 org.apache.commons.io.RandomAccessFileMode)
  (r3v6 org.apache.commons.io.RandomAccessFileMode)
  (r3v7 org.apache.commons.io.RandomAccessFileMode)
 binds: [B:20:0x0038, B:17:0x002f, B:14:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    public static RandomAccessFileMode valueOf(OpenOption... openOptionArr) {
        RandomAccessFileMode randomAccessFileMode;
        RandomAccessFileMode randomAccessFileMode2 = READ_ONLY;
        for (OpenOption openOption : openOptionArr) {
            if (openOption instanceof StandardOpenOption) {
                int i = AnonymousClass1.$SwitchMap$java$nio$file$StandardOpenOption[((StandardOpenOption) openOption).ordinal()];
                if (i == 1) {
                    randomAccessFileMode = READ_WRITE;
                    if (!randomAccessFileMode2.implies(randomAccessFileMode)) {
                        randomAccessFileMode2 = randomAccessFileMode;
                    }
                } else if (i == 2) {
                    randomAccessFileMode = READ_WRITE_SYNC_CONTENT;
                    if (!randomAccessFileMode2.implies(randomAccessFileMode)) {
                        randomAccessFileMode2 = randomAccessFileMode;
                    }
                } else if (i == 3) {
                    randomAccessFileMode = READ_WRITE_SYNC_ALL;
                    if (!randomAccessFileMode2.implies(randomAccessFileMode)) {
                        randomAccessFileMode2 = randomAccessFileMode;
                    }
                }
            }
        }
        return randomAccessFileMode2;
    }

    /* INFO: renamed from: org.apache.commons.io.RandomAccessFileMode$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$nio$file$StandardOpenOption;

        static {
            int[] iArr = new int[StandardOpenOption.values().length];
            $SwitchMap$java$nio$file$StandardOpenOption = iArr;
            try {
                iArr[StandardOpenOption.WRITE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$nio$file$StandardOpenOption[StandardOpenOption.DSYNC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$nio$file$StandardOpenOption[StandardOpenOption.SYNC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static RandomAccessFileMode valueOfMode(String str) {
        str.hashCode();
        switch (str) {
            case "r":
                return READ_ONLY;
            case "rw":
                return READ_WRITE;
            case "rwd":
                return READ_WRITE_SYNC_CONTENT;
            case "rws":
                return READ_WRITE_SYNC_ALL;
            default:
                throw new IllegalArgumentException(str);
        }
    }

    RandomAccessFileMode(String str, int i) {
        this.mode = str;
        this.level = i;
    }

    public void accept(Path path, IOConsumer<RandomAccessFile> iOConsumer) throws IOException {
        RandomAccessFile randomAccessFileCreate = create(path);
        try {
            iOConsumer.accept(randomAccessFileCreate);
            if (randomAccessFileCreate != null) {
                randomAccessFileCreate.close();
            }
        } catch (Throwable th) {
            if (randomAccessFileCreate != null) {
                try {
                    randomAccessFileCreate.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public <T> T apply(Path path, IOFunction<RandomAccessFile, T> iOFunction) throws IOException {
        RandomAccessFile randomAccessFileCreate = create(path);
        try {
            T tApply = iOFunction.apply(randomAccessFileCreate);
            if (randomAccessFileCreate != null) {
                randomAccessFileCreate.close();
            }
            return tApply;
        } catch (Throwable th) {
            if (randomAccessFileCreate != null) {
                try {
                    randomAccessFileCreate.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public RandomAccessFile create(File file) throws FileNotFoundException {
        return new IORandomAccessFile(file, this.mode);
    }

    public RandomAccessFile create(Path path) throws FileNotFoundException {
        return create((File) Objects.requireNonNull(path.toFile(), "file"));
    }

    public RandomAccessFile create(String str) throws FileNotFoundException {
        return new IORandomAccessFile(str, this.mode);
    }

    private int getLevel() {
        return this.level;
    }

    public String getMode() {
        return this.mode;
    }

    public boolean implies(RandomAccessFileMode randomAccessFileMode) {
        return getLevel() >= randomAccessFileMode.getLevel();
    }

    public IORandomAccessFile io(String str) throws FileNotFoundException {
        return new IORandomAccessFile(str, this.mode);
    }
}
