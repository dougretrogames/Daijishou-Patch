package org.eclipse.jgit.internal.storage.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.errors.LockFailedException;
import org.eclipse.jgit.internal.storage.io.BlockSource;
import org.eclipse.jgit.internal.storage.reftable.MergedReftable;
import org.eclipse.jgit.internal.storage.reftable.ReftableCompactor;
import org.eclipse.jgit.internal.storage.reftable.ReftableConfig;
import org.eclipse.jgit.internal.storage.reftable.ReftableReader;
import org.eclipse.jgit.internal.storage.reftable.ReftableWriter;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.util.FileUtils;
import org.eclipse.jgit.util.SystemReader;

/* JADX INFO: loaded from: classes5.dex */
public class FileReftableStack implements AutoCloseable {
    private static long OVERHEAD = 91;
    private final Supplier<Config> configSupplier;
    private MergedReftable mergedReftable;
    private final Runnable onChange;
    private final File reftableDir;
    private final File stackPath;
    private final CompactionStats stats;
    private final SecureRandom random = new SecureRandom();
    private List<StackEntry> stack = new ArrayList();
    private long lastNextUpdateIndex = 0;

    public interface Writer {
        void call(ReftableWriter reftableWriter) throws IOException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class StackEntry {
        String name;
        ReftableReader reftableReader;

        /* synthetic */ StackEntry(FileReftableStackIA fileReftableStackIA) {
            this();
        }

        private StackEntry() {
        }
    }

    static class CompactionStats {
        long tables = 0;
        long bytes = 0;
        int attempted = 0;
        int failed = 0;
        long logCount = 0;
        long refCount = 0;

        CompactionStats() {
        }
    }

    public FileReftableStack(File file, File file2, @Nullable Runnable runnable, Supplier<Config> supplier) throws IOException {
        this.stackPath = file;
        this.reftableDir = file2;
        this.configSupplier = supplier;
        this.onChange = runnable;
        reload();
        this.stats = new CompactionStats();
    }

    CompactionStats getStats() {
        return this.stats;
    }

    private void reloadOnce(List<String> list) throws IOException {
        ReftableReader reftableReader;
        Map map = (Map) this.stack.stream().collect(Collectors.toMap(new FileReftableStack$$ExternalSyntheticLambda1(), new FileReftableStack$$ExternalSyntheticLambda2()));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(this.stack.size() + 1);
        try {
            for (String str : list) {
                StackEntry stackEntry = new StackEntry(null);
                stackEntry.name = str;
                if (map.containsKey(str)) {
                    reftableReader = (ReftableReader) map.remove(str);
                } else {
                    ReftableReader reftableReader2 = new ReftableReader(BlockSource.from(new FileInputStream(new File(this.reftableDir, str))));
                    arrayList.add(reftableReader2);
                    reftableReader = reftableReader2;
                }
                stackEntry.reftableReader = reftableReader;
                arrayList2.add(stackEntry);
            }
            this.stack = arrayList2;
            arrayList.clear();
            map.values().forEach(new FileReftableStack$$ExternalSyntheticLambda3());
        } finally {
            arrayList.forEach(new FileReftableStack$$ExternalSyntheticLambda4());
        }
    }

    static /* synthetic */ void lambda$3(ReftableReader reftableReader) {
        try {
            reftableReader.close();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    static /* synthetic */ void lambda$2(ReftableReader reftableReader) {
        try {
            reftableReader.close();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    void reload() throws IOException {
        Runnable runnable;
        long jCurrentTimeMillis = System.currentTimeMillis() + 2500;
        int i = 0;
        long jDelay = 0;
        while (true) {
            if (i < 3 || System.currentTimeMillis() < jCurrentTimeMillis) {
                List<String> tableNames = readTableNames();
                int i2 = i + 1;
                try {
                    reloadOnce(tableNames);
                    this.mergedReftable = new MergedReftable((List) this.stack.stream().map(new FileReftableStack$$ExternalSyntheticLambda0()).collect(Collectors.toList()));
                    long jNextUpdateIndex = nextUpdateIndex();
                    long j = this.lastNextUpdateIndex;
                    if (j > 0 && j != jNextUpdateIndex && (runnable = this.onChange) != null) {
                        runnable.run();
                    }
                    this.lastNextUpdateIndex = jNextUpdateIndex;
                    return;
                } catch (FileNotFoundException e) {
                    if (readTableNames().equals(tableNames)) {
                        throw e;
                    }
                    jDelay = FileUtils.delay(jDelay, 1L, 1000L);
                    try {
                        Thread.sleep(jDelay);
                        i = i2;
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e2);
                    }
                }
            } else {
                throw new LockFailedException(this.stackPath);
            }
        }
    }

    public MergedReftable getMergedReftable() {
        return this.mergedReftable;
    }

    private List<String> readTableNames() throws IOException {
        ArrayList arrayList = new ArrayList(this.stack.size() + 1);
        Throwable th = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(this.stackPath), StandardCharsets.UTF_8));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        if (!line.isEmpty()) {
                            arrayList.add(line);
                        }
                    } else {
                        bufferedReader.close();
                        return arrayList;
                    }
                } catch (Throwable th2) {
                    bufferedReader.close();
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            if (0 == 0) {
                throw th3;
            }
            if (null == th3) {
                throw null;
            }
            try {
                th.addSuppressed(th3);
                throw null;
            } catch (FileNotFoundException unused) {
                return arrayList;
            }
            return arrayList;
        }
    }

    boolean isUpToDate() throws IOException {
        try {
            List<String> tableNames = readTableNames();
            if (tableNames.size() != this.stack.size()) {
                return false;
            }
            for (int i = 0; i < tableNames.size(); i++) {
                if (!tableNames.get(i).equals(this.stack.get(i).name)) {
                    return false;
                }
            }
            return true;
        } catch (FileNotFoundException unused) {
            return this.stack.isEmpty();
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        Iterator<StackEntry> it = this.stack.iterator();
        while (it.hasNext()) {
            try {
                it.next().reftableReader.close();
            } catch (Exception e) {
                throw new AssertionError(e);
            }
        }
    }

    private long nextUpdateIndex() throws IOException {
        if (this.stack.size() <= 0) {
            return 1L;
        }
        List<StackEntry> list = this.stack;
        return list.get(list.size() - 1).reftableReader.maxUpdateIndex() + 1;
    }

    private String filename(long j, long j2) {
        return String.format("%012x-%012x-%08x", Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(this.random.nextInt()));
    }

    public boolean addReftable(Writer writer) throws IOException {
        String str = ".ref";
        LockFile lockFile = new LockFile(this.stackPath);
        try {
            if (!lockFile.lockForAppend()) {
                lockFile.unlock();
                return false;
            }
            if (!isUpToDate()) {
                lockFile.unlock();
                return false;
            }
            String strFilename = filename(nextUpdateIndex(), nextUpdateIndex());
            File fileCreateTempFile = File.createTempFile(strFilename + "_", ".ref", this.stackPath.getParentFile());
            Throwable th = null;
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
                try {
                    ReftableWriter reftableWriter = new ReftableWriter(reftableConfig(), fileOutputStream);
                    writer.call(reftableWriter);
                    reftableWriter.finish();
                    ReftableWriter.Stats stats = reftableWriter.getStats();
                    fileOutputStream.close();
                    if (stats.minUpdateIndex() < nextUpdateIndex()) {
                        lockFile.unlock();
                        return false;
                    }
                    if (stats.refCount() <= 0) {
                        str = ".log";
                    }
                    String str2 = strFilename + str;
                    File file = new File(this.reftableDir, str2);
                    FileUtils.rename(fileCreateTempFile, file, StandardCopyOption.ATOMIC_MOVE);
                    lockFile.write((str2 + "\n").getBytes(StandardCharsets.UTF_8));
                    if (!lockFile.commit()) {
                        FileUtils.delete(file);
                        lockFile.unlock();
                        return false;
                    }
                    reload();
                    autoCompact();
                    lockFile.unlock();
                    return true;
                } catch (Throwable th2) {
                    fileOutputStream.close();
                    throw th2;
                }
            } catch (Throwable th3) {
                if (0 == 0) {
                    throw th3;
                }
                if (null != th3) {
                    th.addSuppressed(th3);
                }
                throw null;
            }
        } catch (Throwable th4) {
            lockFile.unlock();
            throw th4;
        }
    }

    private ReftableConfig reftableConfig() {
        return new ReftableConfig(this.configSupplier.get());
    }

    private File compactLocked(int i, int i2) throws IOException {
        File fileCreateTempFile = File.createTempFile(filename(i, i2) + "_", ".ref", this.stackPath.getParentFile());
        Throwable th = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            try {
                ReftableCompactor includeDeletes = new ReftableCompactor(fileOutputStream).setConfig(reftableConfig()).setIncludeDeletes(i > 0);
                ArrayList arrayList = new ArrayList();
                long size = 0;
                for (int i3 = i; i3 <= i2; i3++) {
                    arrayList.add(this.stack.get(i3).reftableReader);
                    size += this.stack.get(i3).reftableReader.size();
                }
                includeDeletes.addAll(arrayList);
                includeDeletes.compact();
                this.stats.bytes += size;
                this.stats.tables += (long) ((i - i2) + 1);
                this.stats.attempted++;
                this.stats.refCount += includeDeletes.getStats().refCount();
                this.stats.logCount += includeDeletes.getStats().logCount();
                return fileCreateTempFile;
            } finally {
                fileOutputStream.close();
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

    boolean compactRange(int i, int i2) throws Throwable {
        if (i >= i2) {
            return true;
        }
        LockFile lockFile = new LockFile(this.stackPath);
        ArrayList arrayList = new ArrayList();
        File file = null;
        try {
            if (!lockFile.lock()) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((LockFile) it.next()).unlock();
                }
                lockFile.unlock();
                return false;
            }
            if (!isUpToDate()) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((LockFile) it2.next()).unlock();
                }
                lockFile.unlock();
                return false;
            }
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = i; i3 <= i2; i3++) {
                File file2 = new File(this.reftableDir, this.stack.get(i3).name);
                LockFile lockFile2 = new LockFile(file2);
                if (!lockFile2.lock()) {
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        ((LockFile) it3.next()).unlock();
                    }
                    lockFile.unlock();
                    return false;
                }
                arrayList.add(lockFile2);
                arrayList2.add(file2);
            }
            lockFile.unlock();
            try {
                File fileCompactLocked = compactLocked(i, i2);
                try {
                    LockFile lockFile3 = new LockFile(this.stackPath);
                    try {
                        if (!lockFile3.lock()) {
                            if (fileCompactLocked != null) {
                                fileCompactLocked.delete();
                            }
                            Iterator it4 = arrayList.iterator();
                            while (it4.hasNext()) {
                                ((LockFile) it4.next()).unlock();
                            }
                            lockFile3.unlock();
                            return false;
                        }
                        if (!isUpToDate()) {
                            if (fileCompactLocked != null) {
                                fileCompactLocked.delete();
                            }
                            Iterator it5 = arrayList.iterator();
                            while (it5.hasNext()) {
                                ((LockFile) it5.next()).unlock();
                            }
                            lockFile3.unlock();
                            return false;
                        }
                        String str = filename(this.stack.get(i).reftableReader.minUpdateIndex(), this.stack.get(i2).reftableReader.maxUpdateIndex()) + ".ref";
                        File file3 = new File(this.reftableDir, str);
                        FileUtils.rename(fileCompactLocked, file3, StandardCopyOption.ATOMIC_MOVE);
                        try {
                            StringBuilder sb = new StringBuilder();
                            for (int i4 = 0; i4 < i; i4++) {
                                sb.append(this.stack.get(i4).name + "\n");
                            }
                            sb.append(str + "\n");
                            for (int i5 = i2 + 1; i5 < this.stack.size(); i5++) {
                                sb.append(this.stack.get(i5).name + "\n");
                            }
                            lockFile3.write(sb.toString().getBytes(StandardCharsets.UTF_8));
                            if (!lockFile3.commit()) {
                                file3.delete();
                                Iterator it6 = arrayList.iterator();
                                while (it6.hasNext()) {
                                    ((LockFile) it6.next()).unlock();
                                }
                                lockFile3.unlock();
                                return false;
                            }
                            reload();
                            Iterator it7 = arrayList2.iterator();
                            while (it7.hasNext()) {
                                try {
                                    Files.delete(((File) it7.next()).toPath());
                                } catch (IOException e) {
                                    if (!SystemReader.getInstance().isWindows()) {
                                        throw e;
                                    }
                                }
                            }
                            Iterator it8 = arrayList.iterator();
                            while (it8.hasNext()) {
                                ((LockFile) it8.next()).unlock();
                            }
                            lockFile3.unlock();
                            return true;
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        file = fileCompactLocked;
                    }
                    lockFile = lockFile3;
                } catch (Throwable th3) {
                    th = th3;
                    file = fileCompactLocked;
                    lockFile = null;
                }
            } catch (Throwable th4) {
                th = th4;
                lockFile = null;
            }
        } catch (Throwable th5) {
            th = th5;
        }
        if (file != null) {
            file.delete();
        }
        Iterator it9 = arrayList.iterator();
        while (it9.hasNext()) {
            ((LockFile) it9.next()).unlock();
        }
        if (lockFile != null) {
            lockFile.unlock();
        }
        throw th;
    }

    static int log(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("log2 negative");
        }
        int i = 0;
        while (j > 0) {
            i++;
            j /= 2;
        }
        return i - 1;
    }

    static class Segment {
        long bytes;
        int end;
        int log;
        int start;

        public int hashCode() {
            return 0;
        }

        int size() {
            return this.end - this.start;
        }

        Segment(int i, int i2, int i3, long j) {
            this.log = i3;
            this.start = i;
            this.end = i2;
            this.bytes = j;
        }

        Segment() {
            this(0, 0, 0, 0L);
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof Segment)) {
                return false;
            }
            Segment segment = (Segment) obj;
            return segment.bytes == this.bytes && segment.log == this.log && segment.start == this.start && segment.end == this.end;
        }

        public String toString() {
            return String.format("{ [%d,%d) l=%d sz=%d }", Integer.valueOf(this.start), Integer.valueOf(this.end), Integer.valueOf(this.log), Long.valueOf(this.bytes));
        }
    }

    static List<Segment> segmentSizes(long[] jArr) {
        ArrayList arrayList = new ArrayList();
        Segment segment = new Segment();
        int i = 0;
        while (i < jArr.length) {
            int iLog = log(jArr[i]);
            if (iLog != segment.log && segment.bytes > 0) {
                arrayList.add(segment);
                segment = new Segment();
                segment.start = i;
                segment.log = iLog;
            }
            segment.log = iLog;
            int i2 = i + 1;
            segment.end = i2;
            segment.bytes += jArr[i];
            i = i2;
        }
        arrayList.add(segment);
        return arrayList;
    }

    private static Optional<Segment> autoCompactCandidate(long[] jArr) {
        if (jArr.length == 0) {
            return Optional.empty();
        }
        List list = (List) segmentSizes(jArr).stream().filter(new FileReftableStack$$ExternalSyntheticLambda5()).collect(Collectors.toList());
        if (list.isEmpty()) {
            return Optional.empty();
        }
        Segment segment = (Segment) list.stream().min(Comparator.comparing(new FileReftableStack$$ExternalSyntheticLambda6())).get();
        while (segment.start > 0) {
            int i = segment.start - 1;
            long j = jArr[i];
            if (log(segment.bytes) < log(j)) {
                break;
            }
            segment.start = i;
            segment.bytes += j;
        }
        return Optional.of(segment);
    }

    static /* synthetic */ boolean lambda$5(Segment segment) {
        return segment.size() > 1;
    }

    private void autoCompact() throws IOException {
        Optional<Segment> optionalAutoCompactCandidate = autoCompactCandidate(tableSizes());
        if (!optionalAutoCompactCandidate.isPresent() || compactRange(optionalAutoCompactCandidate.get().start, optionalAutoCompactCandidate.get().end - 1)) {
            return;
        }
        this.stats.failed++;
    }

    private long[] tableSizes() throws IOException {
        long[] jArr = new long[this.stack.size()];
        for (int i = 0; i < this.stack.size(); i++) {
            jArr[i] = this.stack.get(i).reftableReader.size() - OVERHEAD;
        }
        return jArr;
    }

    void compactFully() throws IOException {
        if (compactRange(0, this.stack.size() - 1)) {
            return;
        }
        this.stats.failed++;
    }
}
