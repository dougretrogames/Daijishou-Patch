package org.eclipse.jgit.lib;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.errors.ConfigInvalidException;
import org.eclipse.jgit.errors.RepositoryNotFoundException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.BaseRepositoryBuilder;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileBasedConfig;
import org.eclipse.jgit.util.FS;
import org.eclipse.jgit.util.IO;
import org.eclipse.jgit.util.RawParseUtils;
import org.eclipse.jgit.util.StringUtils;
import org.eclipse.jgit.util.SystemReader;

/* INFO: loaded from: classes5.dex */
public class BaseRepositoryBuilder<B extends BaseRepositoryBuilder, R extends Repository> {
    private List<File> alternateObjectDirectories;
    private boolean bare;
    private List<File> ceilingDirectories;
    private Config config;
    private FS fs;
    private File gitCommonDir;
    private File gitDir;
    private File indexFile;
    private String initialBranch = Constants.MASTER;
    private boolean mustExist;
    private File objectDirectory;
    private File workTree;

    protected final B self() {
        return this;
    }

    private static boolean isSymRef(byte[] bArr) {
        return bArr.length >= 9 && bArr[0] == 103 && bArr[1] == 105 && bArr[2] == 116 && bArr[3] == 100 && bArr[4] == 105 && bArr[5] == 114 && bArr[6] == 58 && bArr[7] == 32;
    }

    static File getSymRef(File file, File file2, FS fs) throws IOException {
        byte[] fully = IO.readFully(file2);
        if (!isSymRef(fully)) {
            throw new IOException(MessageFormat.format(JGitText.get().invalidGitdirRef, file2.getAbsolutePath()));
        }
        int iNextLF = RawParseUtils.nextLF(fully, 8);
        while (true) {
            byte b = fully[iNextLF - 1];
            if (b != 10 && (b != 13 || !SystemReader.getInstance().isWindows())) {
                break;
            }
            iNextLF--;
        }
        if (iNextLF == 8) {
            throw new IOException(MessageFormat.format(JGitText.get().invalidGitdirRef, file2.getAbsolutePath()));
        }
        String strDecode = RawParseUtils.decode(fully, 8, iNextLF);
        File fileResolve = fs.resolve(file, strDecode);
        return fileResolve.isAbsolute() ? fileResolve : new File(file, strDecode).getCanonicalFile();
    }

    public B setFS(FS fs) {
        this.fs = fs;
        return (B) self();
    }

    public FS getFS() {
        return this.fs;
    }

    public B setGitDir(File file) {
        this.gitDir = file;
        this.config = null;
        return (B) self();
    }

    public File getGitDir() {
        return this.gitDir;
    }

    public B setGitCommonDir(File file) {
        this.gitCommonDir = file;
        this.config = null;
        return (B) self();
    }

    public File getGitCommonDir() {
        return this.gitCommonDir;
    }

    public B setObjectDirectory(File file) {
        this.objectDirectory = file;
        return (B) self();
    }

    public File getObjectDirectory() {
        return this.objectDirectory;
    }

    public B addAlternateObjectDirectory(File file) {
        if (file != null) {
            if (this.alternateObjectDirectories == null) {
                this.alternateObjectDirectories = new ArrayList();
            }
            this.alternateObjectDirectories.add(file);
        }
        return (B) self();
    }

    public B addAlternateObjectDirectories(Collection<File> collection) {
        if (collection != null) {
            Iterator<File> it = collection.iterator();
            while (it.hasNext()) {
                addAlternateObjectDirectory(it.next());
            }
        }
        return (B) self();
    }

    public B addAlternateObjectDirectories(File[] fileArr) {
        if (fileArr != null) {
            for (File file : fileArr) {
                addAlternateObjectDirectory(file);
            }
        }
        return (B) self();
    }

    public File[] getAlternateObjectDirectories() {
        List<File> list = this.alternateObjectDirectories;
        if (list == null) {
            return null;
        }
        return (File[]) list.toArray(new File[0]);
    }

    public B setBare() {
        setIndexFile(null);
        setWorkTree(null);
        this.bare = true;
        return (B) self();
    }

    public boolean isBare() {
        return this.bare;
    }

    public B setMustExist(boolean z) {
        this.mustExist = z;
        return (B) self();
    }

    public boolean isMustExist() {
        return this.mustExist;
    }

    public B setWorkTree(File file) {
        this.workTree = file;
        return (B) self();
    }

    public File getWorkTree() {
        return this.workTree;
    }

    public B setIndexFile(File file) {
        this.indexFile = file;
        return (B) self();
    }

    public File getIndexFile() {
        return this.indexFile;
    }

    public B setInitialBranch(String str) throws InvalidRefNameException {
        if (StringUtils.isEmptyOrNull(str)) {
            this.initialBranch = Constants.MASTER;
        } else {
            if (!Repository.isValidRefName(Constants.R_HEADS + str)) {
                throw new InvalidRefNameException(MessageFormat.format(JGitText.get().branchNameInvalid, str));
            }
            this.initialBranch = str;
        }
        return (B) self();
    }

    public String getInitialBranch() {
        return this.initialBranch;
    }

    public B readEnvironment() {
        return (B) readEnvironment(SystemReader.getInstance());
    }

    public B readEnvironment(SystemReader systemReader) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        if (getGitDir() == null && (str7 = systemReader.getenv(Constants.GIT_DIR_KEY)) != null) {
            setGitDir(new File(str7));
        }
        if (getGitCommonDir() == null && (str6 = systemReader.getenv(Constants.GIT_COMMON_DIR_KEY)) != null) {
            setGitCommonDir(new File(str6));
        }
        if (getObjectDirectory() == null && (str5 = systemReader.getenv(Constants.GIT_OBJECT_DIRECTORY_KEY)) != null) {
            setObjectDirectory(new File(str5));
        }
        if (getAlternateObjectDirectories() == null && (str4 = systemReader.getenv(Constants.GIT_ALTERNATE_OBJECT_DIRECTORIES_KEY)) != null) {
            for (String str8 : str4.split(File.pathSeparator, -1)) {
                addAlternateObjectDirectory(new File(str8));
            }
        }
        if (getWorkTree() == null && (str3 = systemReader.getenv(Constants.GIT_WORK_TREE_KEY)) != null) {
            setWorkTree(new File(str3));
        }
        if (getIndexFile() == null && (str2 = systemReader.getenv(Constants.GIT_INDEX_FILE_KEY)) != null) {
            setIndexFile(new File(str2));
        }
        if (this.ceilingDirectories == null && (str = systemReader.getenv(Constants.GIT_CEILING_DIRECTORIES_KEY)) != null) {
            for (String str9 : str.split(File.pathSeparator, -1)) {
                addCeilingDirectory(new File(str9));
            }
        }
        return (B) self();
    }

    public B addCeilingDirectory(File file) {
        if (file != null) {
            if (this.ceilingDirectories == null) {
                this.ceilingDirectories = new ArrayList();
            }
            this.ceilingDirectories.add(file);
        }
        return (B) self();
    }

    public B addCeilingDirectories(Collection<File> collection) {
        if (collection != null) {
            Iterator<File> it = collection.iterator();
            while (it.hasNext()) {
                addCeilingDirectory(it.next());
            }
        }
        return (B) self();
    }

    public B addCeilingDirectories(File[] fileArr) {
        if (fileArr != null) {
            for (File file : fileArr) {
                addCeilingDirectory(file);
            }
        }
        return (B) self();
    }

    public B findGitDir() {
        if (getGitDir() == null) {
            findGitDir(new File("").getAbsoluteFile());
        }
        return (B) self();
    }

    public B findGitDir(File file) {
        List<File> list;
        if (getGitDir() == null) {
            FS fsSafeFS = safeFS();
            while (file != null) {
                File file2 = new File(file, ".git");
                if (RepositoryCache.FileKey.isGitRepository(file2, fsSafeFS)) {
                    setGitDir(file2);
                    break;
                }
                if (file2.isFile()) {
                    try {
                        setGitDir(getSymRef(file, file2, fsSafeFS));
                        break;
                    } catch (IOException unused) {
                        file = file.getParentFile();
                        if (file == null) {
                        }
                    }
                } else {
                    if (RepositoryCache.FileKey.isGitRepository(file, fsSafeFS)) {
                        setGitDir(file);
                        break;
                    }
                    file = file.getParentFile();
                    if (file == null && (list = this.ceilingDirectories) != null && list.contains(file)) {
                        break;
                    }
                }
            }
        }
        return (B) self();
    }

    public B setup() throws IOException, IllegalArgumentException {
        requireGitDirOrWorkTree();
        setupGitDir();
        setupCommonDir();
        setupWorkTree();
        setupInternals();
        return (B) self();
    }

    public R build() throws IOException {
        FileRepository fileRepository = new FileRepository(setup());
        if (!isMustExist() || fileRepository.getObjectDatabase().exists()) {
            return fileRepository;
        }
        throw new RepositoryNotFoundException(getGitDir());
    }

    protected void requireGitDirOrWorkTree() {
        if (getGitDir() == null && getWorkTree() == null) {
            throw new IllegalArgumentException(JGitText.get().eitherGitDirOrWorkTreeRequired);
        }
    }

    protected void setupGitDir() throws IOException {
        if (getGitDir() != null || getWorkTree() == null) {
            return;
        }
        File file = new File(getWorkTree(), ".git");
        if (!file.isFile()) {
            setGitDir(file);
        } else {
            setGitDir(getSymRef(getWorkTree(), file, safeFS()));
        }
    }

    protected void setupCommonDir() throws IOException {
        if (getGitCommonDir() == null) {
            setGitCommonDir(safeFS().getCommonDir(getGitDir()));
        }
    }

    protected void setupWorkTree() throws IOException {
        if (getFS() == null) {
            setFS(FS.DETECTED);
        }
        if (!isBare() && getWorkTree() == null) {
            setWorkTree(guessWorkTreeOrFail());
        }
        if (isBare()) {
            return;
        }
        if (getGitDir() == null) {
            setGitDir(getWorkTree().getParentFile());
        }
        if (getIndexFile() == null) {
            setIndexFile(new File(getGitDir(), ConfigConstants.CONFIG_INDEX_SECTION));
        }
    }

    protected void setupInternals() throws IOException {
        File gitCommonDir;
        if (getObjectDirectory() != null || (gitCommonDir = getGitCommonDir()) == null) {
            return;
        }
        setObjectDirectory(safeFS().resolve(gitCommonDir, Constants.OBJECTS));
    }

    protected Config getConfig() throws IOException {
        if (this.config == null) {
            this.config = loadConfig();
        }
        return this.config;
    }

    protected Config loadConfig() throws IOException {
        File gitCommonDir = getGitCommonDir();
        if (gitCommonDir != null) {
            File fileResolve = safeFS().resolve(gitCommonDir, "config");
            FileBasedConfig fileBasedConfig = new FileBasedConfig(fileResolve, safeFS());
            try {
                fileBasedConfig.load();
                return fileBasedConfig;
            } catch (ConfigInvalidException e) {
                throw new IllegalArgumentException(MessageFormat.format(JGitText.get().repositoryConfigFileInvalid, fileResolve.getAbsolutePath(), e.getMessage()));
            }
        }
        return new Config();
    }

    private File guessWorkTreeOrFail() throws IOException {
        Config config = getConfig();
        String string = config.getString(ConfigConstants.CONFIG_CORE_SECTION, null, ConfigConstants.CONFIG_KEY_WORKTREE);
        if (string != null) {
            return safeFS().resolve(getGitDir(), string).getCanonicalFile();
        }
        File file = new File(getGitDir(), Constants.GITDIR_FILE);
        if (file.isFile()) {
            String strTrim = new String(IO.readFully(file)).trim();
            File file2 = new File(strTrim);
            if (!file2.isAbsolute()) {
                file2 = new File(getGitDir(), strTrim).getCanonicalFile();
            }
            if (file2 != null) {
                return file2.getParentFile();
            }
        }
        if (config.getString(ConfigConstants.CONFIG_CORE_SECTION, null, ConfigConstants.CONFIG_KEY_BARE) != null) {
            if (config.getBoolean(ConfigConstants.CONFIG_CORE_SECTION, ConfigConstants.CONFIG_KEY_BARE, true)) {
                setBare();
                return null;
            }
            return getGitDir().getParentFile();
        }
        if (getGitDir().getName().equals(".git")) {
            return getGitDir().getParentFile();
        }
        setBare();
        return null;
    }

    protected FS safeFS() {
        return getFS() != null ? getFS() : FS.DETECTED;
    }
}
