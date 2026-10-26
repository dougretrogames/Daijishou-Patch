package org.eclipse.jgit.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.AccessDeniedException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;
import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.errors.CommandFailedException;
import org.eclipse.jgit.errors.ConfigInvalidException;
import org.eclipse.jgit.errors.LockFailedException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.file.FileSnapshot;
import org.eclipse.jgit.internal.util.ShutdownHook;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.StoredConfig;
import org.eclipse.jgit.treewalk.FileTreeIterator;
import org.eclipse.jgit.treewalk.WorkingTreeIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* INFO: loaded from: classes5.dex */
public abstract class FS {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static volatile FSFactory factory;
    private volatile Holder<File> gitSystemConfig;
    private volatile Boolean supportSymlinks;
    private volatile Holder<File> userHome;
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) FS.class);
    protected static final WorkingTreeIterator.Entry[] NO_ENTRIES = new WorkingTreeIterator.Entry[0];
    private static final Pattern VERSION = Pattern.compile("\\s(\\d+)\\.(\\d+)\\.(\\d+)");
    private static final Pattern EMPTY_PATH = Pattern.compile("^[\\p{javaWhitespace}" + File.pathSeparator + "]*$");
    public static final FS DETECTED = detect();

    private long makeVersion(int i, int i2, int i3) {
        return (((((long) i) * 10000) + ((long) i2)) * 10000) + ((long) i3);
    }

    public abstract boolean canExecute(File file);

    protected abstract File discoverGitExe();

    public abstract boolean isCaseSensitive();

    public abstract FS newInstance();

    public File normalize(File file) {
        return file;
    }

    public String normalize(String str) {
        return str;
    }

    public abstract boolean retryFailedLockFileCommit();

    public abstract ProcessBuilder runInShell(String str, String[] strArr);

    public abstract boolean setExecute(File file, boolean z);

    String shellQuote(String str) {
        return str;
    }

    public boolean supportsAtomicCreateNewFile() {
        return true;
    }

    public abstract boolean supportsExecute();

    public static class FSFactory {
        protected FSFactory() {
        }

        public FS detect(Boolean bool) {
            if (SystemReader.getInstance().isWindows()) {
                if (bool == null) {
                    bool = Boolean.valueOf(FS_Win32_Cygwin.isCygwin());
                }
                if (bool.booleanValue()) {
                    return new FS_Win32_Cygwin();
                }
                return new FS_Win32();
            }
            return new FS_POSIX();
        }
    }

    public static class ExecutionResult {
        private int rc;
        private TemporaryBuffer stderr;
        private TemporaryBuffer stdout;

        public ExecutionResult(TemporaryBuffer temporaryBuffer, TemporaryBuffer temporaryBuffer2, int i) {
            this.stdout = temporaryBuffer;
            this.stderr = temporaryBuffer2;
            this.rc = i;
        }

        public TemporaryBuffer getStdout() {
            return this.stdout;
        }

        public TemporaryBuffer getStderr() {
            return this.stderr;
        }

        public int getRc() {
            return this.rc;
        }
    }

    public static final class FileStoreAttributes {
        public static final FileStoreAttributes FALLBACK_FILESTORE_ATTRIBUTES;
        private static final Duration FALLBACK_MIN_RACY_INTERVAL;
        public static final Duration FALLBACK_TIMESTAMP_RESOLUTION;
        private static final String JAVA_VERSION_PREFIX;
        private static final long MINIMUM_RESOLUTION_NANOS;
        private static final long ONE_MICROSECOND;
        private static final long ONE_MILLISECOND;
        private static final long ONE_SECOND;
        private static final ExecutorService SAVE_RUNNER;
        private static final Duration UNDEFINED_DURATION = Duration.ofNanos(Long.MAX_VALUE);
        private static final SimpleLruCache<Path, FileStoreAttributes> attrCacheByPath;
        private static final Map<FileStore, FileStoreAttributes> attributeCache;
        private static final AtomicBoolean background;
        private static final Map<FileStore, Lock> locks;
        private static final AtomicInteger threadNumber;
        private final Duration fsTimestampResolution;
        private Duration minimalRacyInterval = Duration.ZERO;

        static {
            Duration durationOfSeconds = Duration.ofSeconds(2L);
            FALLBACK_TIMESTAMP_RESOLUTION = durationOfSeconds;
            FALLBACK_FILESTORE_ATTRIBUTES = new FileStoreAttributes(durationOfSeconds);
            long nanos = TimeUnit.MICROSECONDS.toNanos(1L);
            ONE_MICROSECOND = nanos;
            ONE_MILLISECOND = TimeUnit.MILLISECONDS.toNanos(1L);
            ONE_SECOND = TimeUnit.SECONDS.toNanos(1L);
            MINIMUM_RESOLUTION_NANOS = nanos;
            JAVA_VERSION_PREFIX = System.getProperty("java.vendor") + "|" + System.getProperty("java.version") + "|";
            FALLBACK_MIN_RACY_INTERVAL = Duration.ofMillis(10L);
            attributeCache = new ConcurrentHashMap();
            attrCacheByPath = new SimpleLruCache<>(100, 0.2f);
            background = new AtomicBoolean();
            locks = new ConcurrentHashMap();
            threadNumber = new AtomicInteger(1);
            SAVE_RUNNER = new ThreadPoolExecutor(0, 1, 1L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new FS$FileStoreAttributes$$ExternalSyntheticLambda4());
            ShutdownHook.INSTANCE.register(new FS$FileStoreAttributes$$ExternalSyntheticLambda5());
        }

        static /* synthetic */ Thread lambda$0(Runnable runnable) {
            Thread thread = new Thread(runnable, "JGit-FileStoreAttributeWriter-" + threadNumber.getAndIncrement());
            thread.setDaemon(false);
            return thread;
        }

        /* INFO: Access modifiers changed from: private */
        public static void shutdownSafeRunner() {
            try {
                ExecutorService executorService = SAVE_RUNNER;
                executorService.shutdownNow();
                executorService.awaitTermination(100L, TimeUnit.MILLISECONDS);
            } catch (Exception unused) {
            }
        }

        public static void setBackground(boolean z) {
            background.set(z);
        }

        public static void configureAttributesPathCache(int i, float f) {
            attrCacheByPath.configure(i, f);
        }

        public static FileStoreAttributes get(Path path) {
            try {
                Path absolutePath = path.toAbsolutePath();
                if (!Files.isDirectory(absolutePath, new LinkOption[0])) {
                    absolutePath = absolutePath.getParent();
                }
                if (absolutePath == null) {
                    return FALLBACK_FILESTORE_ATTRIBUTES;
                }
                SimpleLruCache<Path, FileStoreAttributes> simpleLruCache = attrCacheByPath;
                FileStoreAttributes fileStoreAttributes = simpleLruCache.get(absolutePath);
                if (fileStoreAttributes != null) {
                    return fileStoreAttributes;
                }
                FileStoreAttributes fileStoreAttributes2 = getFileStoreAttributes(absolutePath);
                if (fileStoreAttributes2 == null) {
                    return FALLBACK_FILESTORE_ATTRIBUTES;
                }
                simpleLruCache.put(absolutePath, fileStoreAttributes2);
                return fileStoreAttributes2;
            } catch (SecurityException unused) {
                return FALLBACK_FILESTORE_ATTRIBUTES;
            }
        }

        private static FileStoreAttributes getFileStoreAttributes(Path path) {
            Optional optional;
            try {
                if (Files.exists(path, new LinkOption[0])) {
                    FileStore fileStore = Files.getFileStore(path);
                    FileStoreAttributes fileStoreAttributes = attributeCache.get(fileStore);
                    if (fileStoreAttributes != null) {
                        return fileStoreAttributes;
                    }
                    if (!Files.isWritable(path)) {
                        FS.LOG.debug("{}: cannot measure timestamp resolution in read-only directory {}", Thread.currentThread(), path);
                        return FALLBACK_FILESTORE_ATTRIBUTES;
                    }
                    CompletableFuture completableFutureExceptionally = CompletableFuture.supplyAsync(new FS$FileStoreAttributes$$ExternalSyntheticLambda2(fileStore, path)).exceptionally((Function) new FS$FileStoreAttributes$$ExternalSyntheticLambda3());
                    boolean z = background.get();
                    if (z) {
                        optional = (Optional) completableFutureExceptionally.get(100L, TimeUnit.MILLISECONDS);
                    } else {
                        optional = (Optional) completableFutureExceptionally.get();
                    }
                    if (optional.isPresent()) {
                        return (FileStoreAttributes) optional.get();
                    }
                    if (z) {
                        return null;
                    }
                    FS.LOG.debug("{}: use fallback timestamp resolution for directory {}", Thread.currentThread(), path);
                    return FALLBACK_FILESTORE_ATTRIBUTES;
                }
                FS.LOG.debug("{}: cannot measure timestamp resolution of unborn directory {}", Thread.currentThread(), path);
                return FALLBACK_FILESTORE_ATTRIBUTES;
            } catch (IOException e) {
                e = e;
                FS.LOG.error(e.getMessage(), (Throwable) e);
            } catch (InterruptedException e2) {
                FS.LOG.error(e2.getMessage(), (Throwable) e2);
                Thread.currentThread().interrupt();
            } catch (SecurityException | TimeoutException unused) {
            } catch (CancellationException e3) {
                e = e3;
                FS.LOG.error(e.getMessage(), (Throwable) e);
            } catch (ExecutionException e4) {
                e = e4;
                FS.LOG.error(e.getMessage(), (Throwable) e);
            }
        }

        static /* synthetic */ Optional lambda$2(FileStore fileStore, Path path) {
            Optional optionalOf;
            Lock lockComputeIfAbsent = locks.computeIfAbsent(fileStore, new FS$FileStoreAttributes$$ExternalSyntheticLambda0());
            if (!lockComputeIfAbsent.tryLock()) {
                FS.LOG.debug("{}: couldn't get lock to measure timestamp resolution in {}", Thread.currentThread(), path);
                return Optional.empty();
            }
            Optional.empty();
            try {
                Map<FileStore, FileStoreAttributes> map = attributeCache;
                FileStoreAttributes fileStoreAttributes = map.get(fileStore);
                if (fileStoreAttributes != null) {
                    optionalOf = Optional.of(fileStoreAttributes);
                } else {
                    Optional<FileStoreAttributes> fromConfig = readFromConfig(fileStore);
                    if (fromConfig.isPresent()) {
                        map.put(fileStore, fromConfig.get());
                        lockComputeIfAbsent.unlock();
                        return fromConfig;
                    }
                    Optional<Duration> optionalMeasureFsTimestampResolution = measureFsTimestampResolution(fileStore, path);
                    if (optionalMeasureFsTimestampResolution.isPresent()) {
                        fileStoreAttributes = new FileStoreAttributes(optionalMeasureFsTimestampResolution.get());
                        map.put(fileStore, fileStoreAttributes);
                        if (fileStoreAttributes.fsTimestampResolution.toNanos() < 100000000) {
                            fileStoreAttributes.minimalRacyInterval = measureMinimalRacyInterval(path);
                        }
                        if (FS.LOG.isDebugEnabled()) {
                            FS.LOG.debug(fileStoreAttributes.toString());
                        }
                        SAVE_RUNNER.execute(new FS$FileStoreAttributes$$ExternalSyntheticLambda1(fileStore, fileStoreAttributes));
                    }
                    optionalOf = Optional.of(fileStoreAttributes);
                }
                lockComputeIfAbsent.unlock();
                return optionalOf;
            } finally {
                lockComputeIfAbsent.unlock();
                locks.remove(fileStore);
            }
        }

        static /* synthetic */ Lock lambda$3(FileStore fileStore) {
            return new ReentrantLock();
        }

        static /* synthetic */ Optional lambda$5(Throwable th) {
            FS.LOG.error(th.getLocalizedMessage(), th);
            return Optional.empty();
        }

        private static Duration measureMinimalRacyInterval(Path path) {
            FS.LOG.debug("{}: start measure minimal racy interval in {}", Thread.currentThread(), path);
            ArrayList arrayList = new ArrayList();
            Path pathResolve = path.resolve(".probe-" + String.valueOf(UUID.randomUUID()));
            Instant instantPlusSeconds = Instant.now().plusSeconds(3L);
            try {
                try {
                    pathResolve.toFile().deleteOnExit();
                    int i = 0;
                    Files.createFile(pathResolve, new FileAttribute[0]);
                    long jLastRacyThreshold = 0;
                    int i2 = 0;
                    do {
                        i++;
                        write(pathResolve, "a");
                        FileSnapshot fileSnapshotSave = FileSnapshot.save(pathResolve.toFile());
                        read(pathResolve);
                        write(pathResolve, "b");
                        if (!fileSnapshotSave.isModified(pathResolve.toFile())) {
                            arrayList.add(Long.valueOf(fileSnapshotSave.lastDelta()));
                            jLastRacyThreshold = fileSnapshotSave.lastRacyThreshold();
                            i2++;
                        }
                    } while (Instant.now().compareTo(instantPlusSeconds) < 0);
                    deleteProbe(pathResolve);
                    if (i2 > 0) {
                        Stats stats = new Stats();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            stats.add(((Long) it.next()).longValue());
                        }
                        FS.LOG.debug("delta [ns] since modification FileSnapshot failed to detect\ncount, failures, racy limit [ns], delta min [ns], delta max [ns], delta avg [ns], delta stddev [ns]\n{}, {}, {}, {}, {}, {}, {}", Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(jLastRacyThreshold), Double.valueOf(stats.min()), Double.valueOf(stats.max()), Double.valueOf(stats.avg()), Double.valueOf(stats.stddev()));
                        return Duration.ofNanos(Double.valueOf(stats.max()).longValue());
                    }
                    FS.LOG.debug("{}: no failures when measuring minimal racy interval", Thread.currentThread());
                    return Duration.ZERO;
                } catch (IOException e) {
                    FS.LOG.error(e.getMessage(), (Throwable) e);
                    Duration duration = FALLBACK_MIN_RACY_INTERVAL;
                    deleteProbe(pathResolve);
                    return duration;
                }
            } catch (Throwable th) {
                deleteProbe(pathResolve);
                throw th;
            }
        }

        private static void write(Path path, String str) throws IOException {
            Path parent = path.getParent();
            if (parent != null) {
                FileUtils.mkdirs(parent.toFile(), true);
            }
            Throwable th = null;
            try {
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(Files.newOutputStream(path, new OpenOption[0]), StandardCharsets.UTF_8);
                try {
                    outputStreamWriter.write(str);
                } finally {
                    outputStreamWriter.close();
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

        private static String read(Path path) throws IOException {
            byte[] fully = IO.readFully(path.toFile());
            return new String(fully, 0, fully.length, StandardCharsets.UTF_8);
        }

        private static Optional<Duration> measureFsTimestampResolution(FileStore fileStore, Path path) {
            if (FS.LOG.isDebugEnabled()) {
                FS.LOG.debug("{}: start measure timestamp resolution {} in {}", Thread.currentThread(), fileStore, path);
            }
            Path pathResolve = path.resolve(".probe-" + String.valueOf(UUID.randomUUID()));
            try {
                try {
                    try {
                        try {
                            pathResolve.toFile().deleteOnExit();
                            Files.createFile(pathResolve, new FileAttribute[0]);
                            Duration durationPlus = getFsResolution(fileStore, path, pathResolve).plus(measureClockResolution());
                            if (FS.LOG.isDebugEnabled()) {
                                FS.LOG.debug("{}: end measure timestamp resolution {} in {}; got {}", Thread.currentThread(), fileStore, path, durationPlus);
                            }
                            Optional<Duration> optionalOf = Optional.of(durationPlus);
                            deleteProbe(pathResolve);
                            return optionalOf;
                        } catch (IOException e) {
                            FS.LOG.error(e.getLocalizedMessage(), (Throwable) e);
                            deleteProbe(pathResolve);
                            return Optional.empty();
                        }
                    } catch (SecurityException e2) {
                        FS.LOG.warn(e2.getLocalizedMessage(), (Throwable) e2);
                        deleteProbe(pathResolve);
                        return Optional.empty();
                    }
                } catch (AccessDeniedException e3) {
                    FS.LOG.warn(e3.getLocalizedMessage(), (Throwable) e3);
                    deleteProbe(pathResolve);
                    return Optional.empty();
                }
            } catch (Throwable th) {
                deleteProbe(pathResolve);
                throw th;
            }
        }

        private static Duration getFsResolution(FileStore fileStore, Path path, Path path2) throws IOException {
            long j;
            Instant instant;
            FileTime fileTime;
            long j2;
            long j3;
            Duration duration;
            long j4;
            boolean z;
            File file = path2.toFile();
            FileTime lastModifiedTime = Files.getLastModifiedTime(path2, new LinkOption[0]);
            Instant instant2 = lastModifiedTime.toInstant();
            Duration duration2 = FALLBACK_TIMESTAMP_RESOLUTION;
            long jMax = MINIMUM_RESOLUTION_NANOS;
            long j5 = ONE_SECOND;
            long seconds = TimeUnit.MILLISECONDS.toSeconds(duration2.toMillis());
            int i = 2;
            long[] jArr = {ONE_MICROSECOND, ONE_MILLISECOND};
            int i2 = 0;
            while (true) {
                j = 0;
                if (i2 >= i) {
                    instant = instant2;
                    fileTime = lastModifiedTime;
                    j2 = j5;
                    j3 = 1;
                    duration = duration2;
                    break;
                }
                FileTime fileTime2 = lastModifiedTime;
                j2 = jArr[i2];
                if (j2 >= ONE_MILLISECOND) {
                    file.setLastModified(instant2.plusNanos(j2).toEpochMilli());
                    instant = instant2;
                } else {
                    instant = instant2;
                    Files.setLastModifiedTime(path2, FileTime.from(instant.plusNanos(j2)));
                }
                j3 = 1;
                FileTime lastModifiedTime2 = Files.getLastModifiedTime(path2, new LinkOption[0]);
                fileTime = fileTime2;
                if (lastModifiedTime2.compareTo(fileTime) > 0) {
                    Duration durationBetween = Duration.between(instant, lastModifiedTime2.toInstant());
                    if (!durationBetween.isZero() && !durationBetween.isNegative() && durationBetween.compareTo(duration2) < 0) {
                        duration = durationBetween;
                        seconds = 1;
                        break;
                    }
                    z = false;
                } else {
                    z = false;
                    jMax = Math.max(jMax, j2);
                }
                i2++;
                instant2 = instant;
                lastModifiedTime = fileTime;
                i = 2;
            }
            while (seconds > j) {
                long j6 = (seconds + j) / 2;
                if (j6 == 0) {
                    long j7 = j2 / 10;
                    if (j7 < jMax) {
                        break;
                    }
                    long j8 = j2 / j7;
                    long j9 = seconds * j8;
                    j *= j8;
                    seconds = (j9 + j) / 2;
                    j2 = j7;
                    j4 = j9;
                } else {
                    j4 = seconds;
                    seconds = j6;
                }
                long j10 = j;
                long j11 = seconds * j2;
                if (j2 >= ONE_MILLISECOND) {
                    file.setLastModified(instant.plusNanos(j11).toEpochMilli());
                } else {
                    Files.setLastModifiedTime(path2, FileTime.from(instant.plusNanos(j11)));
                }
                FileTime lastModifiedTime3 = Files.getLastModifiedTime(path2, new LinkOption[0]);
                int iCompareTo = lastModifiedTime3.compareTo(fileTime);
                if (iCompareTo > 0) {
                    Duration durationBetween2 = Duration.between(instant, lastModifiedTime3.toInstant());
                    if (durationBetween2.isZero() || durationBetween2.isNegative()) {
                        Duration duration3 = duration;
                        FS.LOG.warn(JGitText.get().logInconsistentFiletimeDiff, Thread.currentThread(), fileStore, path, lastModifiedTime3, fileTime, durationBetween2, duration3);
                        return duration3;
                    }
                    if (durationBetween2.compareTo(duration) > 0) {
                        FS.LOG.warn(JGitText.get().logLargerFiletimeDiff, Thread.currentThread(), fileStore, path, durationBetween2, duration);
                        return duration;
                    }
                    duration = durationBetween2;
                    j = j10;
                } else {
                    long j12 = j2;
                    if (iCompareTo < 0) {
                        FS.LOG.warn(JGitText.get().logSmallerFiletime, Thread.currentThread(), fileStore, path, lastModifiedTime3, fileTime, duration);
                        return duration;
                    }
                    j = seconds + j3;
                    seconds = j4;
                    j2 = j12;
                }
            }
            return duration;
        }

        private static Duration measureClockResolution() {
            Duration duration = Duration.ZERO;
            for (int i = 0; i < 10; i++) {
                Instant instantNow = Instant.now();
                Instant instantNow2 = instantNow;
                while (instantNow2.compareTo(instantNow) <= 0) {
                    instantNow2 = Instant.now();
                }
                Duration durationBetween = Duration.between(instantNow, instantNow2);
                if (durationBetween.compareTo(duration) > 0) {
                    duration = durationBetween;
                }
            }
            return duration;
        }

        private static void deleteProbe(Path path) {
            try {
                FileUtils.delete(path.toFile(), 6);
            } catch (IOException e) {
                FS.LOG.error(e.getMessage(), (Throwable) e);
            }
        }

        private static Optional<FileStoreAttributes> readFromConfig(FileStore fileStore) {
            try {
                StoredConfig userConfig = SystemReader.getInstance().getUserConfig();
                String configKey = getConfigKey(fileStore);
                Duration duration = UNDEFINED_DURATION;
                Duration durationOfNanos = Duration.ofNanos(userConfig.getTimeUnit(ConfigConstants.CONFIG_FILESYSTEM_SECTION, configKey, ConfigConstants.CONFIG_KEY_TIMESTAMP_RESOLUTION, duration.toNanos(), TimeUnit.NANOSECONDS));
                if (duration.equals(durationOfNanos)) {
                    return Optional.empty();
                }
                Duration durationOfNanos2 = Duration.ofNanos(userConfig.getTimeUnit(ConfigConstants.CONFIG_FILESYSTEM_SECTION, configKey, ConfigConstants.CONFIG_KEY_MIN_RACY_THRESHOLD, duration.toNanos(), TimeUnit.NANOSECONDS));
                FileStoreAttributes fileStoreAttributes = new FileStoreAttributes(durationOfNanos);
                if (!duration.equals(durationOfNanos2)) {
                    fileStoreAttributes.minimalRacyInterval = durationOfNanos2;
                }
                return Optional.of(fileStoreAttributes);
            } catch (IOException | ConfigInvalidException e) {
                FS.LOG.error(JGitText.get().readFileStoreAttributesFailed, e);
                return Optional.empty();
            }
        }

        /* INFO: Access modifiers changed from: private */
        public static void saveToConfig(FileStore fileStore, FileStoreAttributes fileStoreAttributes) {
            try {
                StoredConfig jGitConfig = SystemReader.getInstance().getJGitConfig();
                long nanos = fileStoreAttributes.getFsTimestampResolution().toNanos();
                TimeUnit unit = getUnit(nanos);
                long jConvert = unit.convert(nanos, TimeUnit.NANOSECONDS);
                long nanos2 = fileStoreAttributes.getMinimalRacyInterval().toNanos();
                TimeUnit unit2 = getUnit(nanos2);
                long jConvert2 = unit2.convert(nanos2, TimeUnit.NANOSECONDS);
                String configKey = getConfigKey(fileStore);
                boolean z = false;
                int i = 0;
                while (!z && i < 5) {
                    try {
                        jGitConfig.setString(ConfigConstants.CONFIG_FILESYSTEM_SECTION, configKey, ConfigConstants.CONFIG_KEY_TIMESTAMP_RESOLUTION, String.format("%d %s", Long.valueOf(jConvert), unit.name().toLowerCase()));
                        jGitConfig.setString(ConfigConstants.CONFIG_FILESYSTEM_SECTION, configKey, ConfigConstants.CONFIG_KEY_MIN_RACY_THRESHOLD, String.format("%d %s", Long.valueOf(jConvert2), unit2.name().toLowerCase()));
                        jGitConfig.save();
                        z = true;
                    } catch (LockFailedException unused) {
                        i++;
                        if (i < 5) {
                            try {
                                Thread.sleep(100L);
                                FS.LOG.debug("locking {} failed, retries {}/{}", jGitConfig, Integer.valueOf(i), 5);
                            } catch (InterruptedException unused2) {
                                Thread.currentThread().interrupt();
                                return;
                            }
                        } else {
                            FS.LOG.warn(MessageFormat.format(JGitText.get().lockFailedRetry, jGitConfig, Integer.valueOf(i)));
                        }
                    } catch (IOException e) {
                        FS.LOG.error(MessageFormat.format(JGitText.get().cannotSaveConfig, jGitConfig), (Throwable) e);
                        return;
                    }
                }
            } catch (IOException | ConfigInvalidException e2) {
                FS.LOG.error(JGitText.get().saveFileStoreAttributesFailed, e2);
            }
        }

        private static String getConfigKey(FileStore fileStore) {
            Object attribute;
            String strName;
            if (SystemReader.getInstance().isWindows()) {
                try {
                    attribute = fileStore.getAttribute("volume:vsn");
                } catch (IOException unused) {
                    attribute = null;
                }
                if (attribute instanceof Integer) {
                    strName = attribute.toString();
                } else {
                    strName = fileStore.name();
                }
            } else {
                strName = fileStore.name();
            }
            return JAVA_VERSION_PREFIX + strName;
        }

        private static TimeUnit getUnit(long j) {
            if (j < 200000) {
                return TimeUnit.NANOSECONDS;
            }
            if (j < 200000000) {
                return TimeUnit.MICROSECONDS;
            }
            return TimeUnit.MILLISECONDS;
        }

        public Duration getMinimalRacyInterval() {
            return this.minimalRacyInterval;
        }

        public Duration getFsTimestampResolution() {
            return this.fsTimestampResolution;
        }

        public FileStoreAttributes(Duration duration) {
            this.fsTimestampResolution = duration;
        }

        public String toString() {
            return String.format("FileStoreAttributes[fsTimestampResolution=%,d µs, minimalRacyInterval=%,d µs]", Long.valueOf(this.fsTimestampResolution.toNanos() / 1000), Long.valueOf(this.minimalRacyInterval.toNanos() / 1000));
        }
    }

    public static FS detect() {
        return detect(null);
    }

    public static FS detect(Boolean bool) {
        if (factory == null) {
            factory = new FSFactory();
        }
        return factory.detect(bool);
    }

    public static FileStoreAttributes getFileStoreAttributes(Path path) {
        return FileStoreAttributes.get(path);
    }

    protected FS() {
    }

    protected FS(FS fs) {
        this.userHome = fs.userHome;
        this.gitSystemConfig = fs.gitSystemConfig;
    }

    public boolean supportsSymlinks() {
        if (this.supportSymlinks == null) {
            detectSymlinkSupport();
        }
        return Boolean.TRUE.equals(this.supportSymlinks);
    }

    private void detectSymlinkSupport() {
        File fileCreateTempFile = null;
        try {
            try {
                try {
                    fileCreateTempFile = File.createTempFile("tempsymlinktarget", "");
                    File file = new File(fileCreateTempFile.getPath() + "-tempsymlink");
                    createSymLink(file, fileCreateTempFile.getPath());
                    this.supportSymlinks = Boolean.TRUE;
                    file.delete();
                    if (fileCreateTempFile != null) {
                        FileUtils.delete(fileCreateTempFile);
                    }
                } catch (IOException | InternalError | SecurityException | UnsupportedOperationException unused) {
                    this.supportSymlinks = Boolean.FALSE;
                    if (fileCreateTempFile != null) {
                        FileUtils.delete(fileCreateTempFile);
                    }
                }
            } catch (IOException unused2) {
                LOG.error(JGitText.get().cannotDeleteFile, fileCreateTempFile);
            }
        } catch (Throwable th) {
            if (fileCreateTempFile != null) {
                try {
                    FileUtils.delete(fileCreateTempFile);
                } catch (IOException unused3) {
                    LOG.error(JGitText.get().cannotDeleteFile, fileCreateTempFile);
                }
            }
            throw th;
        }
    }

    public Instant lastModifiedInstant(Path path) {
        return FileUtils.lastModifiedInstant(path);
    }

    public Instant lastModifiedInstant(File file) {
        return FileUtils.lastModifiedInstant(file.toPath());
    }

    public void setLastModified(Path path, Instant instant) throws IOException {
        FileUtils.setLastModified(path, instant);
    }

    public long length(File file) throws IOException {
        return FileUtils.getLength(file);
    }

    public void delete(File file) throws IOException {
        FileUtils.delete(file);
    }

    public File resolve(File file, String str) {
        File file2 = new File(str);
        return file2.isAbsolute() ? file2 : new File(file, str);
    }

    public File userHome() {
        Holder<File> holder = this.userHome;
        if (holder == null) {
            holder = new Holder<>(safeUserHomeImpl());
            this.userHome = holder;
        }
        return holder.value;
    }

    private File safeUserHomeImpl() {
        try {
            File fileUserHomeImpl = userHomeImpl();
            if (fileUserHomeImpl != null) {
                fileUserHomeImpl.toPath();
                return fileUserHomeImpl;
            }
        } catch (RuntimeException e) {
            LOG.error(JGitText.get().exceptionWhileFindingUserHome, (Throwable) e);
        }
        File fileDefaultUserHomeImpl = defaultUserHomeImpl();
        if (fileDefaultUserHomeImpl == null) {
            return null;
        }
        try {
            fileDefaultUserHomeImpl.toPath();
            return fileDefaultUserHomeImpl;
        } catch (InvalidPathException e2) {
            LOG.error(MessageFormat.format(JGitText.get().invalidHomeDirectory, fileDefaultUserHomeImpl), (Throwable) e2);
            return null;
        }
    }

    public FS setUserHome(File file) {
        this.userHome = new Holder<>(file);
        return this;
    }

    public BasicFileAttributes fileAttributes(File file) throws IOException {
        return FileUtils.fileAttributes(file);
    }

    protected File userHomeImpl() {
        return defaultUserHomeImpl();
    }

    private File defaultUserHomeImpl() {
        String property = SystemReader.getInstance().getProperty("user.home");
        if (StringUtils.isEmptyOrNull(property)) {
            return null;
        }
        return new File(property).getAbsoluteFile();
    }

    protected static File searchPath(String str, String... strArr) {
        if (StringUtils.isEmptyOrNull(str) || EMPTY_PATH.matcher(str).find()) {
            return null;
        }
        String[] strArrSplit = str.split(File.pathSeparator);
        int length = strArrSplit.length;
        for (int i = 0; i < length; i++) {
            String str2 = strArrSplit[i];
            for (String str3 : strArr) {
                File file = new File(str2, str3);
                try {
                    if (file.isFile() && file.canExecute()) {
                        return file.getAbsoluteFile();
                    }
                } catch (SecurityException unused) {
                    LOG.warn(MessageFormat.format(JGitText.get().skipNotAccessiblePath, file.getPath()));
                }
            }
        }
        return null;
    }

    @Nullable
    protected static String readPipe(File file, String[] strArr, String str) throws CommandFailedException {
        return readPipe(file, strArr, str, null);
    }

    @Nullable
    protected static String readPipe(File file, String[] strArr, String str, Map<String, String> map) throws Throwable {
        Throwable th;
        Logger logger = LOG;
        boolean zIsDebugEnabled = logger.isDebugEnabled();
        if (zIsDebugEnabled) {
            try {
                logger.debug("readpipe " + String.valueOf(Arrays.asList(strArr)) + CollectionUtils.COMMA + String.valueOf(file));
            } catch (IOException e) {
                Logger logger2 = LOG;
                logger2.error("Caught exception in FS.readPipe()", (Throwable) e);
                if (zIsDebugEnabled) {
                    logger2.debug("readpipe returns null");
                }
                return null;
            }
        }
        ProcessBuilder processBuilder = new ProcessBuilder(strArr);
        processBuilder.directory(file);
        if (map != null) {
            processBuilder.environment().putAll(map);
        }
        try {
            Process processStart = processBuilder.start();
            processStart.getOutputStream().close();
            GobblerThread gobblerThread = new GobblerThread(processStart, strArr, file);
            gobblerThread.start();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processStart.getInputStream(), str));
                try {
                    String line = bufferedReader.readLine();
                    if (zIsDebugEnabled) {
                        logger.debug("readpipe may return '" + line + "'");
                        logger.debug("remaining output:\n");
                        while (true) {
                            String line2 = bufferedReader.readLine();
                            if (line2 == null) {
                                break;
                            }
                            LOG.debug(line2);
                        }
                    }
                    bufferedReader.close();
                    while (true) {
                        try {
                            int iWaitFor = processStart.waitFor();
                            gobblerThread.join();
                            if (iWaitFor == 0 && !gobblerThread.fail.get()) {
                                return line;
                            }
                            if (zIsDebugEnabled) {
                                LOG.debug("readpipe rc=" + iWaitFor);
                            }
                            throw new CommandFailedException(iWaitFor, gobblerThread.errorMessage.get(), gobblerThread.exception.get());
                        } catch (InterruptedException unused) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        bufferedReader.close();
                        throw th;
                    } catch (Throwable th3) {
                        th = th3;
                        if (th == null) {
                            throw th;
                        }
                        if (th != th) {
                            th.addSuppressed(th);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                th = null;
            }
        } catch (IOException e2) {
            throw new CommandFailedException(-1, e2.getMessage(), e2);
        }
    }

    private static class GobblerThread extends Thread {
        private static final int PROCESS_EXIT_TIMEOUT = 5;
        private final String desc;
        private final String dir;
        private final Process p;
        final AtomicBoolean fail = new AtomicBoolean();
        final AtomicReference<String> errorMessage = new AtomicReference<>();
        final AtomicReference<Throwable> exception = new AtomicReference<>();

        GobblerThread(Process process, String[] strArr, File file) {
            this.p = process;
            this.desc = Arrays.toString(strArr);
            this.dir = Objects.toString(file);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws Throwable {
            Throwable th;
            boolean zWaitForProcessCompletion;
            int length;
            int iExitValue;
            StringBuilder sb = new StringBuilder();
            try {
                InputStream errorStream = this.p.getErrorStream();
                while (true) {
                    try {
                        int i = errorStream.read();
                        if (i == -1) {
                            break;
                        } else {
                            sb.append((char) i);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (errorStream != null) {
                            try {
                                errorStream.close();
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        }
                        throw th;
                    }
                    try {
                        if (th == null) {
                            throw th;
                        }
                        if (th != th) {
                            th.addSuppressed(th);
                        }
                        throw th;
                    } catch (IOException e) {
                        if (waitForProcessCompletion(e) && this.p.exitValue() != 0) {
                            setError(e, e.getMessage(), this.p.exitValue());
                            this.fail.set(true);
                        }
                        if (zWaitForProcessCompletion) {
                            if (length > 0) {
                                if (iExitValue != 0) {
                                    return;
                                } else {
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    } finally {
                        if (waitForProcessCompletion(null) && sb.length() > 0) {
                            setError(null, sb.toString(), this.p.exitValue());
                            if (this.p.exitValue() != 0) {
                                this.fail.set(true);
                            }
                        }
                    }
                }
                if (errorStream != null) {
                    errorStream.close();
                }
                if (!waitForProcessCompletion(null) || sb.length() <= 0) {
                    return;
                }
                setError(null, sb.toString(), this.p.exitValue());
                if (this.p.exitValue() != 0) {
                    this.fail.set(true);
                }
            } catch (Throwable th4) {
                th = th4;
                th = null;
            }
        }

        private boolean waitForProcessCompletion(IOException iOException) {
            try {
                if (this.p.waitFor(5L, TimeUnit.SECONDS)) {
                    return true;
                }
                setError(iOException, MessageFormat.format(JGitText.get().commandClosedStderrButDidntExit, this.desc, 5), -1);
                this.fail.set(true);
                return false;
            } catch (InterruptedException unused) {
                setError(iOException, MessageFormat.format(JGitText.get().threadInterruptedWhileRunning, this.desc), -1);
                this.fail.set(true);
                return false;
            }
        }

        private void setError(IOException iOException, String str, int i) {
            this.exception.set(iOException);
            this.errorMessage.set(MessageFormat.format(JGitText.get().exceptionCaughtDuringExecutionOfCommand, this.desc, this.dir, Integer.valueOf(i), str));
        }
    }

    protected File discoverGitSystemConfig() throws Throwable {
        int iIndexOf;
        String strSubstring;
        int iIndexOf2;
        File fileDiscoverGitExe = discoverGitExe();
        if (fileDiscoverGitExe == null) {
            return null;
        }
        try {
            String pipe = readPipe(fileDiscoverGitExe.getParentFile(), new String[]{fileDiscoverGitExe.getPath(), "--version"}, SystemReader.getInstance().getDefaultCharset().name());
            if (!StringUtils.isEmptyOrNull(pipe) && (pipe == null || !pipe.startsWith("jgit"))) {
                if (parseVersion(pipe) < makeVersion(2, 8, 0)) {
                    HashMap map = new HashMap();
                    map.put("GIT_EDITOR", "echo");
                    try {
                        String pipe2 = readPipe(fileDiscoverGitExe.getParentFile(), new String[]{fileDiscoverGitExe.getPath(), "config", "--system", "--edit"}, SystemReader.getInstance().getDefaultCharset().name(), map);
                        if (StringUtils.isEmptyOrNull(pipe2)) {
                            return null;
                        }
                        return new File(pipe2);
                    } catch (CommandFailedException e) {
                        LOG.warn(e.getMessage());
                        return null;
                    }
                }
                try {
                    String pipe3 = readPipe(fileDiscoverGitExe.getParentFile(), new String[]{fileDiscoverGitExe.getPath(), "config", "--system", "--show-origin", "--list", "-z"}, SystemReader.getInstance().getDefaultCharset().name());
                    if (pipe3 == null || (iIndexOf = pipe3.indexOf(0)) <= 0 || (iIndexOf2 = (strSubstring = pipe3.substring(0, iIndexOf)).indexOf(58)) < 0) {
                        return null;
                    }
                    String strSubstring2 = strSubstring.substring(iIndexOf2 + 1);
                    if (strSubstring2.isEmpty()) {
                        return null;
                    }
                    return new File(strSubstring2);
                } catch (CommandFailedException e2) {
                    Logger logger = LOG;
                    if (logger.isDebugEnabled()) {
                        logger.debug(e2.getMessage());
                    }
                }
            }
            return null;
        } catch (CommandFailedException e3) {
            LOG.warn(e3.getMessage());
            return null;
        }
    }

    private long parseVersion(String str) {
        Matcher matcher = VERSION.matcher(str);
        if (!matcher.find()) {
            return -1L;
        }
        try {
            return makeVersion(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)));
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public File getGitSystemConfig() {
        if (this.gitSystemConfig == null) {
            this.gitSystemConfig = new Holder<>(discoverGitSystemConfig());
        }
        return this.gitSystemConfig.value;
    }

    public FS setGitSystemConfig(File file) {
        this.gitSystemConfig = new Holder<>(file);
        return this;
    }

    protected static File resolveGrandparentFile(File file) {
        File parentFile;
        if (file == null || (parentFile = file.getParentFile()) == null) {
            return null;
        }
        return parentFile.getParentFile();
    }

    public String readSymLink(File file) throws IOException {
        return FileUtils.readSymLink(file);
    }

    public boolean isSymLink(File file) throws IOException {
        return FileUtils.isSymlink(file);
    }

    public boolean exists(File file) {
        return FileUtils.exists(file);
    }

    public boolean isDirectory(File file) {
        return FileUtils.isDirectory(file);
    }

    public boolean isFile(File file) {
        return FileUtils.isFile(file);
    }

    public boolean isHidden(File file) throws IOException {
        return FileUtils.isHidden(file);
    }

    public void setHidden(File file, boolean z) throws IOException {
        FileUtils.setHidden(file, z);
    }

    public void createSymLink(File file, String str) throws IOException {
        FileUtils.createSymLink(file, str);
    }

    public static class LockToken implements Closeable {
        private boolean isCreated;
        private Optional<Path> link;

        LockToken(boolean z, Optional<Path> optional) {
            this.isCreated = z;
            this.link = optional;
        }

        public boolean isCreated() {
            return this.isCreated;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.link.isPresent()) {
                Path path = this.link.get();
                if (Files.exists(path, new LinkOption[0])) {
                    try {
                        Files.delete(path);
                    } catch (IOException e) {
                        FS.LOG.error(MessageFormat.format(JGitText.get().closeLockTokenFailed, this), (Throwable) e);
                    }
                }
            }
        }

        public String toString() {
            String str;
            boolean z = this.isCreated;
            if (this.link.isPresent()) {
                str = String.valueOf(this.link.get().getFileName()) + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
            } else {
                str = "<null>]";
            }
            return "LockToken [lockCreated=" + z + ", link=" + str;
        }
    }

    public LockToken createNewFileAtomic(File file) throws IOException {
        return new LockToken(file.createNewFile(), Optional.empty());
    }

    public String relativize(String str, String str2) {
        return FileUtils.relativizePath(str, str2, File.separator, isCaseSensitive());
    }

    public WorkingTreeIterator.Entry[] list(File file, FileTreeIterator.FileModeStrategy fileModeStrategy) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return NO_ENTRIES;
        }
        int length = fileArrListFiles.length;
        WorkingTreeIterator.Entry[] entryArr = new WorkingTreeIterator.Entry[length];
        for (int i = 0; i < length; i++) {
            entryArr[i] = new FileTreeIterator.FileEntry(fileArrListFiles[i], this, fileModeStrategy);
        }
        return entryArr;
    }

    public ProcessResult runHookIfPresent(Repository repository, String str, String[] strArr) throws JGitInternalException {
        return runHookIfPresent(repository, str, strArr, System.out, System.err, null);
    }

    public ProcessResult runHookIfPresent(Repository repository, String str, String[] strArr, OutputStream outputStream, OutputStream outputStream2, String str2) throws JGitInternalException {
        return new ProcessResult(ProcessResult.Status.NOT_SUPPORTED);
    }

    protected ProcessResult internalRunHookIfPresent(Repository repository, String str, String[] strArr, OutputStream outputStream, OutputStream outputStream2, String str2) throws JGitInternalException {
        File fileFindHook = findHook(repository, str);
        if (fileFindHook == null || str == null) {
            return new ProcessResult(ProcessResult.Status.NOT_PRESENT);
        }
        File runDirectory = getRunDirectory(repository, str);
        if (runDirectory == null) {
            return new ProcessResult(ProcessResult.Status.NOT_PRESENT);
        }
        ProcessBuilder processBuilderRunInShell = runInShell(shellQuote(fileFindHook.getAbsolutePath()), strArr);
        processBuilderRunInShell.directory(runDirectory.getAbsoluteFile());
        Map<String, String> mapEnvironment = processBuilderRunInShell.environment();
        mapEnvironment.put(Constants.GIT_DIR_KEY, repository.getDirectory().getAbsolutePath());
        if (!repository.isBare()) {
            mapEnvironment.put(Constants.GIT_COMMON_DIR_KEY, repository.getCommonDirectory().getAbsolutePath());
            mapEnvironment.put(Constants.GIT_WORK_TREE_KEY, repository.getWorkTree().getAbsolutePath());
        }
        try {
            return new ProcessResult(runProcess(processBuilderRunInShell, outputStream, outputStream2, str2), ProcessResult.Status.OK);
        } catch (IOException e) {
            throw new JGitInternalException(MessageFormat.format(JGitText.get().exceptionCaughtDuringExecutionOfHook, str), e);
        } catch (InterruptedException e2) {
            throw new JGitInternalException(MessageFormat.format(JGitText.get().exceptionHookExecutionInterrupted, str), e2);
        }
    }

    public File findHook(Repository repository, String str) {
        File hooksDirectory;
        if (str == null || (hooksDirectory = getHooksDirectory(repository)) == null) {
            return null;
        }
        File file = new File(hooksDirectory, str);
        if (file.isAbsolute()) {
            if (file.exists()) {
                FS fs = DETECTED;
                if (!fs.supportsExecute() || fs.canExecute(file)) {
                    return file;
                }
            }
            return null;
        }
        try {
            File runDirectory = getRunDirectory(repository, str);
            if (runDirectory == null) {
                return null;
            }
            Path pathResolve = runDirectory.getAbsoluteFile().toPath().resolve(file.toPath());
            FS fs2 = repository.getFS();
            if (fs2 == null) {
                fs2 = DETECTED;
            }
            if (Files.exists(pathResolve, new LinkOption[0]) && (!fs2.supportsExecute() || fs2.canExecute(pathResolve.toFile()))) {
                return pathResolve.toFile();
            }
            return null;
        } catch (InvalidPathException unused) {
            LOG.warn(MessageFormat.format(JGitText.get().invalidHooksPath, file));
            return null;
        }
    }

    /* WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* WARN: Code restructure failed: missing block: B:10:0x0019, code lost:
    
        if (r3.equals("post-receive") == false) goto L26;
     */
    /* WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
    
        if (r3.equals("push-to-checkout") == false) goto L26;
     */
    /* WARN: Code restructure failed: missing block: B:16:0x002b, code lost:
    
        if (r3.equals("pre-receive") == false) goto L26;
     */
    /* WARN: Code restructure failed: missing block: B:19:0x0034, code lost:
    
        if (r3.equals("post-update") == false) goto L26;
     */
    /* WARN: Code restructure failed: missing block: B:22:0x003d, code lost:
    
        if (r3.equals(org.eclipse.jgit.lib.ConfigConstants.CONFIG_KEY_UPDATE) == false) goto L26;
     */
    /* WARN: Code restructure failed: missing block: B:25:0x0044, code lost:
    
        return r2.getCommonDirectory();
     */
    /* WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.io.File getRunDirectory(org.eclipse.jgit.lib.Repository r2, java.lang.String r3) {
        /*
            r1 = this;
            boolean r0 = r2.isBare()
            if (r0 == 0) goto Lb
            java.io.File r2 = r2.getDirectory()
            return r2
        Lb:
            int r0 = r3.hashCode()
            switch(r0) {
                case -838846263: goto L37;
                case -685435242: goto L2e;
                case -287722055: goto L25;
                case 1179305509: goto L1c;
                case 1543065270: goto L13;
                default: goto L12;
            }
        L12:
            goto L45
        L13:
            java.lang.String r0 = "post-receive"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L40
            goto L45
        L1c:
            java.lang.String r0 = "push-to-checkout"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L40
            goto L45
        L25:
            java.lang.String r0 = "pre-receive"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L40
            goto L45
        L2e:
            java.lang.String r0 = "post-update"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L40
            goto L45
        L37:
            java.lang.String r0 = "update"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L40
            goto L45
        L40:
            java.io.File r2 = r2.getCommonDirectory()
            return r2
        L45:
            java.io.File r2 = r2.getWorkTree()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jgit.util.FS.getRunDirectory(org.eclipse.jgit.lib.Repository, java.lang.String):java.io.File");
    }

    private File getHooksDirectory(Repository repository) {
        String string = repository.getConfig().getString(ConfigConstants.CONFIG_CORE_SECTION, null, ConfigConstants.CONFIG_KEY_HOOKS_PATH);
        if (string != null) {
            return new File(string);
        }
        File commonDirectory = repository.getCommonDirectory();
        if (commonDirectory == null) {
            return null;
        }
        return new File(commonDirectory, Constants.HOOKS);
    }

    public int runProcess(ProcessBuilder processBuilder, OutputStream outputStream, OutputStream outputStream2, String str) throws InterruptedException, IOException {
        return runProcess(processBuilder, outputStream, outputStream2, str == null ? null : new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8)));
    }

    public int runProcess(ProcessBuilder processBuilder, OutputStream outputStream, OutputStream outputStream2, InputStream inputStream) throws InterruptedException, IOException {
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(2);
        Process process = null;
        try {
            try {
                Process processStart = processBuilder.start();
                executorServiceNewFixedThreadPool.execute(new StreamGobbler(processStart.getErrorStream(), outputStream2));
                executorServiceNewFixedThreadPool.execute(new StreamGobbler(processStart.getInputStream(), outputStream));
                OutputStream outputStream3 = processStart.getOutputStream();
                if (inputStream != null) {
                    try {
                        new StreamGobbler(inputStream, outputStream3).copy();
                    } catch (Throwable th) {
                        try {
                            outputStream3.close();
                        } catch (IOException unused) {
                        }
                        throw th;
                    }
                }
                try {
                    outputStream3.close();
                } catch (IOException unused2) {
                }
                int iWaitFor = processStart.waitFor();
                shutdownAndAwaitTermination(executorServiceNewFixedThreadPool);
                if (processStart != null) {
                    try {
                        processStart.waitFor();
                    } catch (InterruptedException unused3) {
                        Thread.interrupted();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    try {
                        processStart.getErrorStream().close();
                    } catch (IOException unused4) {
                    }
                    try {
                        processStart.getInputStream().close();
                    } catch (IOException unused5) {
                    }
                    try {
                        processStart.getOutputStream().close();
                    } catch (IOException unused6) {
                    }
                    processStart.destroy();
                }
                return iWaitFor;
            } catch (Throwable th2) {
                shutdownAndAwaitTermination(executorServiceNewFixedThreadPool);
                if (0 != 0) {
                    try {
                        process.waitFor();
                    } catch (InterruptedException unused7) {
                        Thread.interrupted();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    try {
                        process.getErrorStream().close();
                    } catch (IOException unused8) {
                    }
                    try {
                        process.getInputStream().close();
                    } catch (IOException unused9) {
                    }
                    try {
                        process.getOutputStream().close();
                    } catch (IOException unused10) {
                    }
                    process.destroy();
                }
                throw th2;
            }
        } catch (IOException e) {
            shutdownAndAwaitTermination(executorServiceNewFixedThreadPool);
            if (0 != 0) {
                try {
                    process.waitFor();
                } catch (InterruptedException unused11) {
                    Thread.interrupted();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                try {
                    process.getErrorStream().close();
                } catch (IOException unused12) {
                }
                try {
                    process.getInputStream().close();
                } catch (IOException unused13) {
                }
                try {
                    process.getOutputStream().close();
                } catch (IOException unused14) {
                }
                process.destroy();
            }
            throw e;
        }
    }

    private static boolean shutdownAndAwaitTermination(ExecutorService executorService) {
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(60L, TimeUnit.SECONDS)) {
                return true;
            }
            executorService.shutdownNow();
            return executorService.awaitTermination(60L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public ExecutionResult execute(ProcessBuilder processBuilder, InputStream inputStream) throws InterruptedException, IOException {
        Throwable th = null;
        try {
            TemporaryBuffer.LocalFile localFile = new TemporaryBuffer.LocalFile(null);
            try {
                TemporaryBuffer.Heap heap = new TemporaryBuffer.Heap(1024, 1048576);
                try {
                    ExecutionResult executionResult = new ExecutionResult(localFile, heap, runProcess(processBuilder, localFile, heap, inputStream));
                    heap.close();
                    localFile.close();
                    return executionResult;
                } catch (Throwable th2) {
                    heap.close();
                    throw th2;
                }
            } catch (Throwable th3) {
                if (0 == 0) {
                    th = th3;
                } else if (null != th3) {
                    th.addSuppressed(th3);
                }
                localFile.close();
                throw th;
            }
        } catch (Throwable th4) {
            if (0 == 0) {
                throw th4;
            }
            if (null != th4) {
                th.addSuppressed(th4);
            }
            throw null;
        }
    }

    private static class Holder<V> {
        final V value;

        Holder(V v) {
            this.value = v;
        }
    }

    public static class Attributes {
        private final long creationTime;
        private final boolean exists;
        private final File file;
        final FS fs;
        private final boolean isDirectory;
        private final boolean isExecutable;
        private final boolean isRegularFile;
        private final boolean isSymbolicLink;
        private final Instant lastModifiedInstant;
        protected long length;

        public boolean isDirectory() {
            return this.isDirectory;
        }

        public boolean isExecutable() {
            return this.isExecutable;
        }

        public boolean isSymbolicLink() {
            return this.isSymbolicLink;
        }

        public boolean isRegularFile() {
            return this.isRegularFile;
        }

        public long getCreationTime() {
            return this.creationTime;
        }

        public Instant getLastModifiedInstant() {
            return this.lastModifiedInstant;
        }

        Attributes(FS fs, File file, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, long j, Instant instant, long j2) {
            this.fs = fs;
            this.file = file;
            this.exists = z;
            this.isDirectory = z2;
            this.isExecutable = z3;
            this.isSymbolicLink = z4;
            this.isRegularFile = z5;
            this.creationTime = j;
            this.lastModifiedInstant = instant;
            this.length = j2;
        }

        public Attributes(File file, FS fs) {
            this(fs, file, false, false, false, false, false, 0L, Instant.EPOCH, 0L);
        }

        public long getLength() {
            long j = this.length;
            if (j != -1) {
                return j;
            }
            long length = this.file.length();
            this.length = length;
            return length;
        }

        public String getName() {
            return this.file.getName();
        }

        public File getFile() {
            return this.file;
        }

        boolean exists() {
            return this.exists;
        }
    }

    public Attributes getAttributes(File file) {
        boolean zIsDirectory = isDirectory(file);
        boolean z = !zIsDirectory && file.isFile();
        boolean z2 = zIsDirectory || z;
        return new Attributes(this, file, z2, zIsDirectory, z2 && !zIsDirectory && canExecute(file), false, z, 0L, z2 ? lastModifiedInstant(file) : Instant.EPOCH, -1L);
    }

    public File getCommonDir(File file) throws IOException {
        File file2 = new File(file, Constants.COMMONDIR_FILE);
        if (!file2.isFile()) {
            return file;
        }
        String strTrim = new String(IO.readFully(file2)).trim();
        File file3 = new File(strTrim);
        return !file3.isAbsolute() ? new File(file, strTrim).getCanonicalFile() : file3;
    }

    private static class StreamGobbler implements Runnable {
        private InputStream in;
        private OutputStream out;

        public StreamGobbler(InputStream inputStream, OutputStream outputStream) {
            this.in = inputStream;
            this.out = outputStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                copy();
            } catch (IOException unused) {
            }
        }

        void copy() throws IOException {
            OutputStream outputStream;
            byte[] bArr = new byte[4096];
            boolean z = false;
            while (true) {
                int i = this.in.read(bArr);
                if (i == -1) {
                    return;
                }
                if (!z && (outputStream = this.out) != null) {
                    try {
                        outputStream.write(bArr, 0, i);
                        this.out.flush();
                    } catch (IOException unused) {
                        z = true;
                    }
                }
            }
        }
    }
}
