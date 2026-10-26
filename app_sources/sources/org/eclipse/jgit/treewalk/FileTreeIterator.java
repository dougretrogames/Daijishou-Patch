package org.eclipse.jgit.treewalk;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.util.FS;

/* INFO: loaded from: classes5.dex */
public class FileTreeIterator extends WorkingTreeIterator {
    protected final File directory;
    protected final FileModeStrategy fileModeStrategy;
    protected final FS fs;

    public interface FileModeStrategy {
        FileMode getMode(File file, FS.Attributes attributes);
    }

    /* WARN: Illegal instructions before constructor call */
    public FileTreeIterator(Repository repository) {
        FileModeStrategy fileModeStrategy;
        if (((WorkingTreeOptions) repository.getConfig().get(WorkingTreeOptions.KEY)).isDirNoGitLinks()) {
            fileModeStrategy = NoGitlinksStrategy.INSTANCE;
        } else {
            fileModeStrategy = DefaultFileModeStrategy.INSTANCE;
        }
        this(repository, fileModeStrategy);
    }

    public FileTreeIterator(Repository repository, FileModeStrategy fileModeStrategy) {
        this(repository.getWorkTree(), repository.getFS(), (WorkingTreeOptions) repository.getConfig().get(WorkingTreeOptions.KEY), fileModeStrategy);
        initRootIterator(repository);
    }

    public FileTreeIterator(File file, FS fs, WorkingTreeOptions workingTreeOptions) {
        this(file, fs, workingTreeOptions, DefaultFileModeStrategy.INSTANCE);
    }

    public FileTreeIterator(File file, FS fs, WorkingTreeOptions workingTreeOptions, FileModeStrategy fileModeStrategy) {
        super(workingTreeOptions);
        this.directory = file;
        this.fs = fs;
        this.fileModeStrategy = fileModeStrategy;
        init(entries());
    }

    protected FileTreeIterator(FileTreeIterator fileTreeIterator, File file, FS fs) {
        this(fileTreeIterator, file, fs, fileTreeIterator.fileModeStrategy);
    }

    protected FileTreeIterator(WorkingTreeIterator workingTreeIterator, File file, FS fs, FileModeStrategy fileModeStrategy) {
        super(workingTreeIterator);
        this.directory = file;
        this.fs = fs;
        this.fileModeStrategy = fileModeStrategy;
        init(entries());
    }

    @Override // org.eclipse.jgit.treewalk.AbstractTreeIterator
    public AbstractTreeIterator createSubtreeIterator(ObjectReader objectReader) throws IOException {
        if (!walksIgnoredDirectories() && isEntryIgnored() && getDirCacheIterator() == null) {
            return new EmptyTreeIterator(this);
        }
        return enterSubtree();
    }

    protected AbstractTreeIterator enterSubtree() {
        return new FileTreeIterator(this, ((FileEntry) current()).getFile(), this.fs, this.fileModeStrategy);
    }

    private WorkingTreeIterator.Entry[] entries() {
        return this.fs.list(this.directory, this.fileModeStrategy);
    }

    public static class DefaultFileModeStrategy implements FileModeStrategy {
        public static final DefaultFileModeStrategy INSTANCE = new DefaultFileModeStrategy();

        @Override // org.eclipse.jgit.treewalk.FileTreeIterator.FileModeStrategy
        public FileMode getMode(File file, FS.Attributes attributes) {
            if (attributes.isSymbolicLink()) {
                return FileMode.SYMLINK;
            }
            if (attributes.isDirectory()) {
                if (new File(file, ".git").exists()) {
                    return FileMode.GITLINK;
                }
                return FileMode.TREE;
            }
            if (attributes.isExecutable()) {
                return FileMode.EXECUTABLE_FILE;
            }
            return FileMode.REGULAR_FILE;
        }
    }

    public static class NoGitlinksStrategy implements FileModeStrategy {
        public static final NoGitlinksStrategy INSTANCE = new NoGitlinksStrategy();

        @Override // org.eclipse.jgit.treewalk.FileTreeIterator.FileModeStrategy
        public FileMode getMode(File file, FS.Attributes attributes) {
            if (attributes.isSymbolicLink()) {
                return FileMode.SYMLINK;
            }
            if (attributes.isDirectory()) {
                return FileMode.TREE;
            }
            if (attributes.isExecutable()) {
                return FileMode.EXECUTABLE_FILE;
            }
            return FileMode.REGULAR_FILE;
        }
    }

    public static class FileEntry extends WorkingTreeIterator.Entry {
        private FS.Attributes attributes;
        private FS fs;
        private final FileMode mode;

        public FileEntry(File file, FS fs) {
            this(file, fs, DefaultFileModeStrategy.INSTANCE);
        }

        public FileEntry(File file, FS fs, FileModeStrategy fileModeStrategy) {
            this.fs = fs;
            File fileNormalize = fs.normalize(file);
            FS.Attributes attributes = fs.getAttributes(fileNormalize);
            this.attributes = attributes;
            this.mode = fileModeStrategy.getMode(fileNormalize, attributes);
        }

        public FileEntry(File file, FS fs, FS.Attributes attributes, FileModeStrategy fileModeStrategy) {
            this.fs = fs;
            this.attributes = attributes;
            this.mode = fileModeStrategy.getMode(fs.normalize(file), attributes);
        }

        @Override // org.eclipse.jgit.treewalk.WorkingTreeIterator.Entry
        public FileMode getMode() {
            return this.mode;
        }

        @Override // org.eclipse.jgit.treewalk.WorkingTreeIterator.Entry
        public String getName() {
            return this.attributes.getName();
        }

        @Override // org.eclipse.jgit.treewalk.WorkingTreeIterator.Entry
        public long getLength() {
            return this.attributes.getLength();
        }

        @Override // org.eclipse.jgit.treewalk.WorkingTreeIterator.Entry
        public Instant getLastModifiedInstant() {
            return this.attributes.getLastModifiedInstant();
        }

        @Override // org.eclipse.jgit.treewalk.WorkingTreeIterator.Entry
        public InputStream openInputStream() throws IOException {
            if (this.attributes.isSymbolicLink()) {
                return new ByteArrayInputStream(this.fs.readSymLink(getFile()).getBytes(StandardCharsets.UTF_8));
            }
            return new FileInputStream(getFile());
        }

        public File getFile() {
            return this.attributes.getFile();
        }
    }

    public File getDirectory() {
        return this.directory;
    }

    public File getEntryFile() {
        return ((FileEntry) current()).getFile();
    }

    @Override // org.eclipse.jgit.treewalk.WorkingTreeIterator
    protected byte[] idSubmodule(WorkingTreeIterator.Entry entry) {
        return idSubmodule(getDirectory(), entry);
    }

    @Override // org.eclipse.jgit.treewalk.WorkingTreeIterator
    protected String readSymlinkTarget(WorkingTreeIterator.Entry entry) throws IOException {
        return this.fs.readSymLink(getEntryFile());
    }
}
