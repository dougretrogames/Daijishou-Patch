package org.apache.commons.io.monitor;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.build.AbstractOriginSupplier;
import org.apache.commons.io.comparator.NameFileComparator;
import org.apache.commons.io.filefilter.TrueFileFilter;

/* INFO: loaded from: classes5.dex */
public class FileAlterationObserver implements Serializable {
    private static final long serialVersionUID = 1185122225658782848L;
    private final Comparator<File> comparator;
    private final transient FileFilter fileFilter;
    private final transient List<FileAlterationListener> listeners;
    private final FileEntry rootEntry;

    public void destroy() throws Exception {
    }

    /* synthetic */ FileAlterationObserver(FileEntry fileEntry, FileFilter fileFilter, Comparator comparator, AnonymousClass1 anonymousClass1) {
        this(fileEntry, fileFilter, (Comparator<File>) comparator);
    }

    public static final class Builder extends AbstractOriginSupplier<FileAlterationObserver, Builder> {
        private FileFilter fileFilter;
        private IOCase ioCase;
        private FileEntry rootEntry;

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
        }

        @Override // org.apache.commons.io.function.IOSupplier
        public FileAlterationObserver get() throws IOException {
            FileEntry fileEntry = this.rootEntry;
            if (fileEntry == null) {
                fileEntry = new FileEntry(checkOrigin().getFile());
            }
            return new FileAlterationObserver(fileEntry, this.fileFilter, FileAlterationObserver.toComparator(this.ioCase), null);
        }

        /* WARN: Multi-variable type inference failed */
        public Builder setFileFilter(FileFilter fileFilter) {
            this.fileFilter = fileFilter;
            return (Builder) asThis();
        }

        /* WARN: Multi-variable type inference failed */
        public Builder setIOCase(IOCase iOCase) {
            this.ioCase = iOCase;
            return (Builder) asThis();
        }

        /* WARN: Multi-variable type inference failed */
        public Builder setRootEntry(FileEntry fileEntry) {
            this.rootEntry = fileEntry;
            return (Builder) asThis();
        }
    }

    public static Builder builder() {
        return new Builder(null);
    }

    /* INFO: renamed from: org.apache.commons.io.monitor.FileAlterationObserver$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$io$IOCase;

        static {
            int[] iArr = new int[IOCase.values().length];
            $SwitchMap$org$apache$commons$io$IOCase = iArr;
            try {
                iArr[IOCase.SYSTEM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$io$IOCase[IOCase.INSENSITIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static Comparator<File> toComparator(IOCase iOCase) {
        int i = AnonymousClass1.$SwitchMap$org$apache$commons$io$IOCase[IOCase.value(iOCase, IOCase.SYSTEM).ordinal()];
        if (i == 1) {
            return NameFileComparator.NAME_SYSTEM_COMPARATOR;
        }
        if (i == 2) {
            return NameFileComparator.NAME_INSENSITIVE_COMPARATOR;
        }
        return NameFileComparator.NAME_COMPARATOR;
    }

    @Deprecated
    public FileAlterationObserver(File file) {
        this(file, (FileFilter) null);
    }

    @Deprecated
    public FileAlterationObserver(File file, FileFilter fileFilter) {
        this(file, fileFilter, (IOCase) null);
    }

    @Deprecated
    public FileAlterationObserver(File file, FileFilter fileFilter, IOCase iOCase) {
        this(new FileEntry(file), fileFilter, iOCase);
    }

    private FileAlterationObserver(FileEntry fileEntry, FileFilter fileFilter, Comparator<File> comparator) {
        this.listeners = new CopyOnWriteArrayList();
        Objects.requireNonNull(fileEntry, "rootEntry");
        Objects.requireNonNull(fileEntry.getFile(), "rootEntry.getFile()");
        this.rootEntry = fileEntry;
        this.fileFilter = fileFilter == null ? TrueFileFilter.INSTANCE : fileFilter;
        this.comparator = (Comparator) Objects.requireNonNull(comparator, "comparator");
    }

    protected FileAlterationObserver(FileEntry fileEntry, FileFilter fileFilter, IOCase iOCase) {
        this(fileEntry, fileFilter, toComparator(iOCase));
    }

    @Deprecated
    public FileAlterationObserver(String str) {
        this(new File(str));
    }

    @Deprecated
    public FileAlterationObserver(String str, FileFilter fileFilter) {
        this(new File(str), fileFilter);
    }

    @Deprecated
    public FileAlterationObserver(String str, FileFilter fileFilter, IOCase iOCase) {
        this(new File(str), fileFilter, iOCase);
    }

    public void addListener(FileAlterationListener fileAlterationListener) {
        if (fileAlterationListener != null) {
            this.listeners.add(fileAlterationListener);
        }
    }

    private void checkAndFire(FileEntry fileEntry, FileEntry[] fileEntryArr, File[] fileArr) {
        FileEntry[] fileEntryArr2 = fileArr.length > 0 ? new FileEntry[fileArr.length] : FileEntry.EMPTY_FILE_ENTRY_ARRAY;
        int i = 0;
        for (FileEntry fileEntry2 : fileEntryArr) {
            while (i < fileArr.length && this.comparator.compare(fileEntry2.getFile(), fileArr[i]) > 0) {
                FileEntry fileEntryM5621xd1c1b90a = m5621xd1c1b90a(fileEntry, fileArr[i]);
                fileEntryArr2[i] = fileEntryM5621xd1c1b90a;
                fireOnCreate(fileEntryM5621xd1c1b90a);
                i++;
            }
            if (i < fileArr.length && this.comparator.compare(fileEntry2.getFile(), fileArr[i]) == 0) {
                fireOnChange(fileEntry2, fileArr[i]);
                checkAndFire(fileEntry2, fileEntry2.getChildren(), listFiles(fileArr[i]));
                fileEntryArr2[i] = fileEntry2;
                i++;
            } else {
                checkAndFire(fileEntry2, fileEntry2.getChildren(), FileUtils.EMPTY_FILE_ARRAY);
                fireOnDelete(fileEntry2);
            }
        }
        while (i < fileArr.length) {
            FileEntry fileEntryM5621xd1c1b90a2 = m5621xd1c1b90a(fileEntry, fileArr[i]);
            fileEntryArr2[i] = fileEntryM5621xd1c1b90a2;
            fireOnCreate(fileEntryM5621xd1c1b90a2);
            i++;
        }
        fileEntry.setChildren(fileEntryArr2);
    }

    public void checkAndNotify() {
        this.listeners.forEach(new FileAlterationObserver$$ExternalSyntheticLambda6(this));
        File file = this.rootEntry.getFile();
        if (file.exists()) {
            FileEntry fileEntry = this.rootEntry;
            checkAndFire(fileEntry, fileEntry.getChildren(), listFiles(file));
        } else if (this.rootEntry.isExists()) {
            FileEntry fileEntry2 = this.rootEntry;
            checkAndFire(fileEntry2, fileEntry2.getChildren(), FileUtils.EMPTY_FILE_ARRAY);
        }
        this.listeners.forEach(new FileAlterationObserver$$ExternalSyntheticLambda7(this));
    }

    /* INFO: renamed from: lambda$checkAndNotify$0$org-apache-commons-io-monitor-FileAlterationObserver, reason: not valid java name */
    /* synthetic */ void m5619x2d975733(FileAlterationListener fileAlterationListener) {
        fileAlterationListener.onStart(this);
    }

    /* INFO: renamed from: lambda$checkAndNotify$1$org-apache-commons-io-monitor-FileAlterationObserver, reason: not valid java name */
    /* synthetic */ void m5620x47b2d5d2(FileAlterationListener fileAlterationListener) {
        fileAlterationListener.onStop(this);
    }

    /* INFO: Access modifiers changed from: private */
    /* INFO: renamed from: createFileEntry, reason: merged with bridge method [inline-methods] */
    public FileEntry m5621xd1c1b90a(FileEntry fileEntry, File file) {
        FileEntry fileEntryNewChildInstance = fileEntry.newChildInstance(file);
        fileEntryNewChildInstance.refresh(file);
        fileEntryNewChildInstance.setChildren(listFileEntries(file, fileEntryNewChildInstance));
        return fileEntryNewChildInstance;
    }

    private void fireOnChange(FileEntry fileEntry, File file) {
        if (fileEntry.refresh(file)) {
            this.listeners.forEach(new FileAlterationObserver$$ExternalSyntheticLambda1(fileEntry, file));
        }
    }

    static /* synthetic */ void lambda$fireOnChange$2(FileEntry fileEntry, File file, FileAlterationListener fileAlterationListener) {
        if (fileEntry.isDirectory()) {
            fileAlterationListener.onDirectoryChange(file);
        } else {
            fileAlterationListener.onFileChange(file);
        }
    }

    /* INFO: Access modifiers changed from: private */
    public void fireOnCreate(FileEntry fileEntry) {
        this.listeners.forEach(new FileAlterationObserver$$ExternalSyntheticLambda4(fileEntry));
        Stream.of((Object[]) fileEntry.getChildren()).forEach(new FileAlterationObserver$$ExternalSyntheticLambda5(this));
    }

    static /* synthetic */ void lambda$fireOnCreate$3(FileEntry fileEntry, FileAlterationListener fileAlterationListener) {
        if (fileEntry.isDirectory()) {
            fileAlterationListener.onDirectoryCreate(fileEntry.getFile());
        } else {
            fileAlterationListener.onFileCreate(fileEntry.getFile());
        }
    }

    private void fireOnDelete(FileEntry fileEntry) {
        this.listeners.forEach(new FileAlterationObserver$$ExternalSyntheticLambda8(fileEntry));
    }

    static /* synthetic */ void lambda$fireOnDelete$4(FileEntry fileEntry, FileAlterationListener fileAlterationListener) {
        if (fileEntry.isDirectory()) {
            fileAlterationListener.onDirectoryDelete(fileEntry.getFile());
        } else {
            fileAlterationListener.onFileDelete(fileEntry.getFile());
        }
    }

    Comparator<File> getComparator() {
        return this.comparator;
    }

    public File getDirectory() {
        return this.rootEntry.getFile();
    }

    public FileFilter getFileFilter() {
        return this.fileFilter;
    }

    public Iterable<FileAlterationListener> getListeners() {
        return new ArrayList(this.listeners);
    }

    public void initialize() throws Exception {
        FileEntry fileEntry = this.rootEntry;
        fileEntry.refresh(fileEntry.getFile());
        FileEntry fileEntry2 = this.rootEntry;
        fileEntry2.setChildren(listFileEntries(fileEntry2.getFile(), this.rootEntry));
    }

    static /* synthetic */ FileEntry[] lambda$listFileEntries$6(int i) {
        return new FileEntry[i];
    }

    private FileEntry[] listFileEntries(File file, FileEntry fileEntry) {
        return (FileEntry[]) Stream.of((Object[]) listFiles(file)).map(new FileAlterationObserver$$ExternalSyntheticLambda2(this, fileEntry)).toArray(new FileAlterationObserver$$ExternalSyntheticLambda3());
    }

    private File[] listFiles(File file) {
        return file.isDirectory() ? sort(file.listFiles(this.fileFilter)) : FileUtils.EMPTY_FILE_ARRAY;
    }

    public void removeListener(FileAlterationListener fileAlterationListener) {
        if (fileAlterationListener != null) {
            List<FileAlterationListener> list = this.listeners;
            Objects.requireNonNull(fileAlterationListener);
            list.removeIf(new FileAlterationObserver$$ExternalSyntheticLambda0(fileAlterationListener));
        }
    }

    private File[] sort(File[] fileArr) {
        if (fileArr == null) {
            return FileUtils.EMPTY_FILE_ARRAY;
        }
        if (fileArr.length > 1) {
            Arrays.sort(fileArr, this.comparator);
        }
        return fileArr;
    }

    public String toString() {
        return getClass().getSimpleName() + "[file='" + getDirectory().getPath() + "', " + this.fileFilter.toString() + ", listeners=" + this.listeners.size() + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
    }
}
