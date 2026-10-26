package org.eclipse.jgit.internal.storage.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.util.FS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* INFO: loaded from: classes5.dex */
public class FileSnapshot {
    public static final FileSnapshot DIRTY;
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) FileSnapshot.class);
    public static final FileSnapshot MISSING_FILE;
    private static final Object MISSING_FILEKEY;
    public static final long UNKNOWN_SIZE = -1;
    private static final Instant UNKNOWN_TIME;
    private static final DateTimeFormatter dateFmt;
    private boolean cannotBeRacilyClean;
    private long delta;
    private final File file;
    private final Object fileKey;
    private boolean fileKeyChanged;
    private FS.FileStoreAttributes fileStoreAttributeCache;
    private final Instant lastModified;
    private boolean lastModifiedChanged;
    private volatile Instant lastRead;
    private long racyThreshold;
    private final long size;
    private boolean sizeChanged;
    private boolean useConfig;
    private boolean wasRacyClean;

    /* synthetic */ FileSnapshot(Instant instant, Instant instant2, long j, Duration duration, Object obj, FileSnapshotIA fileSnapshotIA) {
        this(instant, instant2, j, duration, obj);
    }

    static {
        Instant instantOfEpochMilli = Instant.ofEpochMilli(-1L);
        UNKNOWN_TIME = instantOfEpochMilli;
        Object obj = new Object();
        MISSING_FILEKEY = obj;
        dateFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.nnnnnnnnn").withLocale(Locale.getDefault()).withZone(ZoneId.systemDefault());
        DIRTY = new FileSnapshot(instantOfEpochMilli, instantOfEpochMilli, -1L, Duration.ZERO, obj);
        MISSING_FILE = new AnonymousClass1(Instant.EPOCH, Instant.EPOCH, 0L, Duration.ZERO, obj);
    }

    /* INFO: renamed from: org.eclipse.jgit.internal.storage.file.FileSnapshot$1, reason: invalid class name */
    class AnonymousClass1 extends FileSnapshot {
        AnonymousClass1(Instant instant, Instant instant2, long j, Duration duration, Object obj) {
            super(instant, instant2, j, duration, obj, null);
        }

        @Override // org.eclipse.jgit.internal.storage.file.FileSnapshot
        public boolean isModified(File file) {
            return FS.DETECTED.exists(file);
        }
    }

    public static FileSnapshot save(File file) {
        return new FileSnapshot(file);
    }

    public static FileSnapshot saveNoConfig(File file) {
        return new FileSnapshot(file, false);
    }

    private static Object getFileKey(BasicFileAttributes basicFileAttributes) {
        Object objFileKey = basicFileAttributes.fileKey();
        return objFileKey == null ? MISSING_FILEKEY : objFileKey;
    }

    public static FileSnapshot save(Instant instant) {
        return new FileSnapshot(Instant.now(), instant, -1L, FS.FileStoreAttributes.FALLBACK_TIMESTAMP_RESOLUTION, MISSING_FILEKEY);
    }

    protected FileSnapshot(File file) {
        this(file, true);
    }

    protected FileSnapshot(File file, boolean z) {
        this.file = file;
        this.lastRead = Instant.now();
        this.useConfig = z;
        try {
            BasicFileAttributes basicFileAttributesFileAttributes = FS.DETECTED.fileAttributes(file);
            Instant instant = basicFileAttributesFileAttributes.lastModifiedTime().toInstant();
            this.lastModified = instant;
            long size = basicFileAttributesFileAttributes.size();
            this.size = size;
            Object fileKey = getFileKey(basicFileAttributesFileAttributes);
            this.fileKey = fileKey;
            Logger logger = LOG;
            if (logger.isDebugEnabled()) {
                DateTimeFormatter dateTimeFormatter = dateFmt;
                logger.debug("file={}, create new FileSnapshot: lastRead={}, lastModified={}, size={}, fileKey={}", file, dateTimeFormatter.format(this.lastRead), dateTimeFormatter.format(instant), Long.valueOf(size), fileKey.toString());
            }
        } catch (NoSuchFileException unused) {
            this.lastModified = Instant.EPOCH;
            this.size = 0L;
            this.fileKey = MISSING_FILEKEY;
        } catch (IOException e) {
            LOG.error(e.getMessage(), (Throwable) e);
            this.lastModified = Instant.EPOCH;
            this.size = 0L;
            this.fileKey = MISSING_FILEKEY;
        }
    }

    private FileSnapshot(Instant instant, Instant instant2, long j, Duration duration, Object obj) {
        this.file = null;
        this.lastRead = instant;
        this.lastModified = instant2;
        this.fileStoreAttributeCache = new FS.FileStoreAttributes(duration);
        this.size = j;
        this.fileKey = obj;
    }

    public Instant lastModifiedInstant() {
        return this.lastModified;
    }

    public long size() {
        return this.size;
    }

    public boolean isModified(File file) {
        Instant instant;
        Object fileKey;
        long j = 0;
        try {
            BasicFileAttributes basicFileAttributesFileAttributes = FS.DETECTED.fileAttributes(file);
            instant = basicFileAttributesFileAttributes.lastModifiedTime().toInstant();
            long size = basicFileAttributesFileAttributes.size();
            fileKey = getFileKey(basicFileAttributesFileAttributes);
            j = size;
        } catch (NoSuchFileException unused) {
            instant = Instant.EPOCH;
            fileKey = MISSING_FILEKEY;
        } catch (IOException e) {
            LOG.error(e.getMessage(), (Throwable) e);
            instant = Instant.EPOCH;
            fileKey = MISSING_FILEKEY;
        }
        boolean zIsSizeChanged = isSizeChanged(j);
        this.sizeChanged = zIsSizeChanged;
        if (zIsSizeChanged) {
            return true;
        }
        boolean zIsFileKeyChanged = isFileKeyChanged(fileKey);
        this.fileKeyChanged = zIsFileKeyChanged;
        if (zIsFileKeyChanged) {
            return true;
        }
        boolean zIsModified = isModified(instant);
        this.lastModifiedChanged = zIsModified;
        return zIsModified;
    }

    public void setClean(FileSnapshot fileSnapshot) {
        Instant instant = fileSnapshot.lastRead;
        if (!isRacyClean(instant)) {
            this.cannotBeRacilyClean = true;
        }
        this.lastRead = instant;
    }

    public void waitUntilNotRacy() throws InterruptedException {
        long nanos = fileStoreAttributeCache().getFsTimestampResolution().toNanos();
        while (isRacyClean(Instant.now())) {
            TimeUnit.NANOSECONDS.sleep(nanos);
        }
    }

    /* WARN: Code duplicated, block: B:9:0x0016  */
    public boolean equals(FileSnapshot fileSnapshot) {
        boolean z;
        long j = this.size;
        if (j != -1) {
            long j2 = fileSnapshot.size;
            if (j2 == -1 || j == j2) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = true;
        }
        return this.lastModified.equals(fileSnapshot.lastModified) && z && Objects.equals(this.fileKey, fileSnapshot.fileKey);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof FileSnapshot)) {
            return equals((FileSnapshot) obj);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.lastModified, Long.valueOf(this.size), this.fileKey);
    }

    boolean wasSizeChanged() {
        return this.sizeChanged;
    }

    boolean wasFileKeyChanged() {
        return this.fileKeyChanged;
    }

    boolean wasLastModifiedChanged() {
        return this.lastModifiedChanged;
    }

    boolean wasLastModifiedRacilyClean() {
        return this.wasRacyClean;
    }

    public long lastDelta() {
        return this.delta;
    }

    public long lastRacyThreshold() {
        return this.racyThreshold;
    }

    public String toString() {
        if (this == DIRTY) {
            return "DIRTY";
        }
        if (this == MISSING_FILE) {
            return "MISSING_FILE";
        }
        DateTimeFormatter dateTimeFormatter = dateFmt;
        return "FileSnapshot[modified: " + dateTimeFormatter.format(this.lastModified) + ", read: " + dateTimeFormatter.format(this.lastRead) + ", size:" + this.size + ", fileKey: " + String.valueOf(this.fileKey) + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
    }

    private boolean isRacyClean(Instant instant) {
        this.racyThreshold = getEffectiveRacyThreshold();
        long nanos = Duration.between(this.lastModified, instant).toNanos();
        this.delta = nanos;
        this.wasRacyClean = nanos <= this.racyThreshold;
        Logger logger = LOG;
        if (logger.isDebugEnabled()) {
            File file = this.file;
            Boolean boolValueOf = Boolean.valueOf(this.wasRacyClean);
            DateTimeFormatter dateTimeFormatter = dateFmt;
            logger.debug("file={}, isRacyClean={}, read={}, lastModified={}, delta={} ns, racy<={} ns", file, boolValueOf, dateTimeFormatter.format(instant), dateTimeFormatter.format(this.lastModified), Long.valueOf(this.delta), Long.valueOf(this.racyThreshold));
        }
        return this.wasRacyClean;
    }

    private long getEffectiveRacyThreshold() {
        long jMax = Math.max(fileStoreAttributeCache().getFsTimestampResolution().toNanos(), fileStoreAttributeCache().getMinimalRacyInterval().toNanos());
        return (jMax * 5) / (jMax < 100000000 ? 2L : 4L);
    }

    private boolean isModified(Instant instant) {
        boolean zEquals = this.lastModified.equals(instant);
        this.lastModifiedChanged = !zEquals;
        if (!zEquals) {
            Logger logger = LOG;
            if (logger.isDebugEnabled()) {
                File file = this.file;
                DateTimeFormatter dateTimeFormatter = dateFmt;
                logger.debug("file={}, lastModified changed from {} to {}", file, dateTimeFormatter.format(this.lastModified), dateTimeFormatter.format(instant));
            }
            return true;
        }
        if (this.cannotBeRacilyClean) {
            LOG.debug("file={}, cannot be racily clean", this.file);
            return false;
        }
        if (!isRacyClean(this.lastRead)) {
            LOG.debug("file={}, is unmodified", this.file);
            return false;
        }
        LOG.debug("file={}, is racily clean", this.file);
        return true;
    }

    private boolean isFileKeyChanged(Object obj) {
        boolean z = (obj == MISSING_FILEKEY || obj.equals(this.fileKey)) ? false : true;
        if (z) {
            LOG.debug("file={}, FileKey changed from {} to {}", this.file, this.fileKey, obj);
        }
        return z;
    }

    private boolean isSizeChanged(long j) {
        boolean z = (j == -1 || j == this.size) ? false : true;
        if (z) {
            LOG.debug("file={}, size changed from {} to {} bytes", this.file, Long.valueOf(this.size), Long.valueOf(j));
        }
        return z;
    }

    private FS.FileStoreAttributes fileStoreAttributeCache() {
        FS.FileStoreAttributes fileStoreAttributes;
        if (this.fileStoreAttributeCache == null) {
            if (this.useConfig) {
                fileStoreAttributes = FS.getFileStoreAttributes(this.file.toPath().getParent());
            } else {
                fileStoreAttributes = FS.FileStoreAttributes.FALLBACK_FILESTORE_ATTRIBUTES;
            }
            this.fileStoreAttributeCache = fileStoreAttributes;
        }
        return this.fileStoreAttributeCache;
    }
}
