package org.eclipse.jgit.submodule;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.eclipse.jgit.dircache.DirCacheIterator;
import org.eclipse.jgit.errors.ConfigInvalidException;
import org.eclipse.jgit.errors.CorruptObjectException;
import org.eclipse.jgit.errors.RepositoryNotFoundException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.BaseRepositoryBuilder;
import org.eclipse.jgit.lib.BlobBasedConfig;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RepositoryBuilder;
import org.eclipse.jgit.lib.RepositoryBuilderFactory;
import org.eclipse.jgit.lib.StoredConfig;
import org.eclipse.jgit.storage.file.FileBasedConfig;
import org.eclipse.jgit.treewalk.AbstractTreeIterator;
import org.eclipse.jgit.treewalk.CanonicalTreeParser;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.treewalk.filter.PathFilter;
import org.eclipse.jgit.treewalk.filter.TreeFilter;
import org.eclipse.jgit.util.FS;

/* JADX INFO: loaded from: classes5.dex */
public class SubmoduleWalk implements AutoCloseable {
    private RepositoryBuilderFactory factory;
    private Config modulesConfig;
    private String path;
    private Map<String, String> pathToName;
    private StoredConfig repoConfig;
    private final Repository repository;
    private AbstractTreeIterator rootTree;
    private final TreeWalk walk;

    public enum IgnoreSubmoduleMode {
        ALL,
        DIRTY,
        UNTRACKED,
        NONE;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static IgnoreSubmoduleMode[] valuesCustom() {
            IgnoreSubmoduleMode[] ignoreSubmoduleModeArrValuesCustom = values();
            int length = ignoreSubmoduleModeArrValuesCustom.length;
            IgnoreSubmoduleMode[] ignoreSubmoduleModeArr = new IgnoreSubmoduleMode[length];
            System.arraycopy(ignoreSubmoduleModeArrValuesCustom, 0, ignoreSubmoduleModeArr, 0, length);
            return ignoreSubmoduleModeArr;
        }
    }

    public static SubmoduleWalk forIndex(Repository repository) throws IOException {
        SubmoduleWalk submoduleWalk = new SubmoduleWalk(repository);
        try {
            submoduleWalk.setTree(new DirCacheIterator(repository.readDirCache()));
            return submoduleWalk;
        } catch (IOException e) {
            submoduleWalk.close();
            throw e;
        }
    }

    public static SubmoduleWalk forPath(Repository repository, AnyObjectId anyObjectId, String str) throws IOException {
        SubmoduleWalk submoduleWalk = new SubmoduleWalk(repository);
        try {
            submoduleWalk.setTree(anyObjectId);
            PathFilter pathFilterCreate = PathFilter.create(str);
            submoduleWalk.setFilter(pathFilterCreate);
            submoduleWalk.setRootTree(anyObjectId);
            while (submoduleWalk.next()) {
                if (pathFilterCreate.isDone(submoduleWalk.walk)) {
                    return submoduleWalk;
                }
            }
            submoduleWalk.close();
            return null;
        } catch (IOException e) {
            submoduleWalk.close();
            throw e;
        }
    }

    public static SubmoduleWalk forPath(Repository repository, AbstractTreeIterator abstractTreeIterator, String str) throws IOException {
        SubmoduleWalk submoduleWalk = new SubmoduleWalk(repository);
        try {
            submoduleWalk.setTree(abstractTreeIterator);
            PathFilter pathFilterCreate = PathFilter.create(str);
            submoduleWalk.setFilter(pathFilterCreate);
            submoduleWalk.setRootTree(abstractTreeIterator);
            while (submoduleWalk.next()) {
                if (pathFilterCreate.isDone(submoduleWalk.walk)) {
                    return submoduleWalk;
                }
            }
            submoduleWalk.close();
            return null;
        } catch (IOException e) {
            submoduleWalk.close();
            throw e;
        }
    }

    public static File getSubmoduleDirectory(Repository repository, String str) {
        return new File(repository.getWorkTree(), str);
    }

    public static Repository getSubmoduleRepository(Repository repository, String str) throws IOException {
        return getSubmoduleRepository(repository.getWorkTree(), str, repository.getFS());
    }

    public static Repository getSubmoduleRepository(File file, String str) throws IOException {
        return getSubmoduleRepository(file, str, FS.DETECTED);
    }

    public static Repository getSubmoduleRepository(File file, String str, FS fs) throws IOException {
        return getSubmoduleRepository(file, str, fs, new RepositoryBuilder());
    }

    public static Repository getSubmoduleRepository(File file, String str, FS fs, BaseRepositoryBuilder<?, ? extends Repository> baseRepositoryBuilder) throws IOException {
        File file2 = new File(file, str);
        if (!file2.isDirectory()) {
            return null;
        }
        try {
            return baseRepositoryBuilder.setMustExist(true).setFS(fs).setWorkTree(file2).build();
        } catch (RepositoryNotFoundException unused) {
            return null;
        }
    }

    public static String getSubmoduleRemoteUrl(Repository repository, String str) throws IOException {
        String string;
        if (!str.startsWith("./") && !str.startsWith("../")) {
            return str;
        }
        Ref refExactRef = repository.exactRef("HEAD");
        if (refExactRef != null) {
            if (refExactRef.isSymbolic()) {
                refExactRef = refExactRef.getLeaf();
            }
            string = repository.getConfig().getString(ConfigConstants.CONFIG_BRANCH_SECTION, Repository.shortenRefName(refExactRef.getName()), "remote");
        } else {
            string = null;
        }
        if (string == null) {
            string = "origin";
        }
        String string2 = repository.getConfig().getString("remote", string, "url");
        if (string2 == null) {
            string2 = repository.getWorkTree().getAbsolutePath();
            if ('\\' == File.separatorChar) {
                string2 = string2.replace('\\', '/');
            }
        }
        if (string2.charAt(string2.length() - 1) == '/') {
            string2 = string2.substring(0, string2.length() - 1);
        }
        char c = '/';
        while (str.length() > 0) {
            if (str.startsWith("./")) {
                str = str.substring(2);
            } else {
                if (!str.startsWith("../")) {
                    break;
                }
                int iLastIndexOf = string2.lastIndexOf(47);
                if (iLastIndexOf < 1) {
                    c = AbstractJsonLexerKt.COLON;
                    iLastIndexOf = string2.lastIndexOf(58);
                }
                if (iLastIndexOf < 1) {
                    throw new IOException(MessageFormat.format(JGitText.get().submoduleParentRemoteUrlInvalid, string2));
                }
                string2 = string2.substring(0, iLastIndexOf);
                str = str.substring(3);
            }
        }
        return string2 + c + str;
    }

    public SubmoduleWalk(Repository repository) throws IOException {
        this.repository = repository;
        this.repoConfig = repository.getConfig();
        TreeWalk treeWalk = new TreeWalk(repository);
        this.walk = treeWalk;
        treeWalk.setRecursive(true);
    }

    public SubmoduleWalk setModulesConfig(Config config) {
        this.modulesConfig = config;
        loadPathNames();
        return this;
    }

    public SubmoduleWalk setRootTree(AbstractTreeIterator abstractTreeIterator) {
        this.rootTree = abstractTreeIterator;
        this.modulesConfig = null;
        this.pathToName = null;
        return this;
    }

    public SubmoduleWalk setRootTree(AnyObjectId anyObjectId) throws IOException {
        CanonicalTreeParser canonicalTreeParser = new CanonicalTreeParser();
        canonicalTreeParser.reset(this.walk.getObjectReader(), anyObjectId);
        this.rootTree = canonicalTreeParser;
        this.modulesConfig = null;
        this.pathToName = null;
        return this;
    }

    public SubmoduleWalk loadModulesConfig() throws ConfigInvalidException, IOException {
        AbstractTreeIterator abstractTreeIterator;
        if (this.rootTree == null) {
            FileBasedConfig fileBasedConfig = new FileBasedConfig(new File(this.repository.getWorkTree(), Constants.DOT_GIT_MODULES), this.repository.getFS());
            fileBasedConfig.load();
            this.modulesConfig = fileBasedConfig;
            loadPathNames();
            return this;
        }
        Throwable th = null;
        try {
            TreeWalk treeWalk = new TreeWalk(this.repository);
            try {
                treeWalk.addTree(this.rootTree);
                int i = 0;
                while (!this.rootTree.first()) {
                    this.rootTree.back(1);
                    i++;
                }
                try {
                    treeWalk.setRecursive(false);
                    PathFilter pathFilterCreate = PathFilter.create(Constants.DOT_GIT_MODULES);
                    treeWalk.setFilter(pathFilterCreate);
                    while (true) {
                        if (treeWalk.next()) {
                            if (pathFilterCreate.isDone(treeWalk)) {
                                this.modulesConfig = new BlobBasedConfig(null, this.repository, treeWalk.getObjectId(0));
                                loadPathNames();
                                if (i <= 0) {
                                    break;
                                }
                                abstractTreeIterator = this.rootTree;
                                abstractTreeIterator.next(i);
                                break;
                            }
                        } else {
                            this.modulesConfig = new Config();
                            this.pathToName = null;
                            if (i <= 0) {
                                break;
                            }
                            abstractTreeIterator = this.rootTree;
                            abstractTreeIterator.next(i);
                            break;
                        }
                    }
                    treeWalk.close();
                    return this;
                } catch (Throwable th2) {
                    if (i > 0) {
                        this.rootTree.next(i);
                    }
                    throw th2;
                }
            } catch (Throwable th3) {
                treeWalk.close();
                throw th3;
            }
        } catch (Throwable th4) {
            if (0 == 0) {
                throw th4;
            }
            if (null == th4) {
                throw null;
            }
            th.addSuppressed(th4);
            throw null;
        }
    }

    private void loadPathNames() {
        this.pathToName = null;
        if (this.modulesConfig != null) {
            HashMap map = new HashMap();
            for (String str : this.modulesConfig.getSubsections(ConfigConstants.CONFIG_SUBMODULE_SECTION)) {
                map.put(this.modulesConfig.getString(ConfigConstants.CONFIG_SUBMODULE_SECTION, str, "path"), str);
            }
            this.pathToName = map;
        }
    }

    public static boolean containsGitModulesFile(Repository repository) throws IOException {
        if (repository.isBare()) {
            return false;
        }
        return new File(repository.getWorkTree(), Constants.DOT_GIT_MODULES).exists();
    }

    private void lazyLoadModulesConfig() throws ConfigInvalidException, IOException {
        if (this.modulesConfig == null) {
            loadModulesConfig();
        }
    }

    private String getModuleName(String str) {
        Map<String, String> map = this.pathToName;
        String str2 = map != null ? map.get(str) : null;
        return str2 != null ? str2 : str;
    }

    public SubmoduleWalk setFilter(TreeFilter treeFilter) {
        this.walk.setFilter(treeFilter);
        return this;
    }

    public SubmoduleWalk setTree(AbstractTreeIterator abstractTreeIterator) throws CorruptObjectException {
        this.walk.addTree(abstractTreeIterator);
        return this;
    }

    public SubmoduleWalk setTree(AnyObjectId anyObjectId) throws IOException {
        this.walk.addTree(anyObjectId);
        return this;
    }

    public SubmoduleWalk reset() {
        this.repoConfig = this.repository.getConfig();
        this.modulesConfig = null;
        this.pathToName = null;
        this.walk.reset();
        return this;
    }

    public File getDirectory() {
        return getSubmoduleDirectory(this.repository, this.path);
    }

    public boolean next() throws IOException {
        while (this.walk.next()) {
            if (FileMode.GITLINK == this.walk.getFileMode(0)) {
                this.path = this.walk.getPathString();
                return true;
            }
        }
        this.path = null;
        return false;
    }

    public String getPath() {
        return this.path;
    }

    public void setBuilderFactory(RepositoryBuilderFactory repositoryBuilderFactory) {
        this.factory = repositoryBuilderFactory;
    }

    private BaseRepositoryBuilder<?, ? extends Repository> getBuilder() {
        RepositoryBuilderFactory repositoryBuilderFactory = this.factory;
        return repositoryBuilderFactory != null ? repositoryBuilderFactory.get() : new RepositoryBuilder();
    }

    public String getModuleName() throws ConfigInvalidException, IOException {
        lazyLoadModulesConfig();
        return getModuleName(this.path);
    }

    public ObjectId getObjectId() {
        return this.walk.getObjectId(0);
    }

    public String getModulesPath() throws ConfigInvalidException, IOException {
        lazyLoadModulesConfig();
        return this.modulesConfig.getString(ConfigConstants.CONFIG_SUBMODULE_SECTION, getModuleName(), "path");
    }

    public String getConfigUrl() throws ConfigInvalidException, IOException {
        return this.repoConfig.getString(ConfigConstants.CONFIG_SUBMODULE_SECTION, getModuleName(), "url");
    }

    public String getModulesUrl() throws ConfigInvalidException, IOException {
        lazyLoadModulesConfig();
        return this.modulesConfig.getString(ConfigConstants.CONFIG_SUBMODULE_SECTION, getModuleName(), "url");
    }

    public String getConfigUpdate() throws ConfigInvalidException, IOException {
        return this.repoConfig.getString(ConfigConstants.CONFIG_SUBMODULE_SECTION, getModuleName(), ConfigConstants.CONFIG_KEY_UPDATE);
    }

    public String getModulesUpdate() throws ConfigInvalidException, IOException {
        lazyLoadModulesConfig();
        return this.modulesConfig.getString(ConfigConstants.CONFIG_SUBMODULE_SECTION, getModuleName(), ConfigConstants.CONFIG_KEY_UPDATE);
    }

    public IgnoreSubmoduleMode getModulesIgnore() throws ConfigInvalidException, IOException {
        IgnoreSubmoduleMode ignoreSubmoduleMode = (IgnoreSubmoduleMode) this.repoConfig.getEnum(IgnoreSubmoduleMode.valuesCustom(), ConfigConstants.CONFIG_SUBMODULE_SECTION, getModuleName(), ConfigConstants.CONFIG_KEY_IGNORE, null);
        if (ignoreSubmoduleMode != null) {
            return ignoreSubmoduleMode;
        }
        lazyLoadModulesConfig();
        return (IgnoreSubmoduleMode) this.modulesConfig.getEnum(IgnoreSubmoduleMode.valuesCustom(), ConfigConstants.CONFIG_SUBMODULE_SECTION, getModuleName(), ConfigConstants.CONFIG_KEY_IGNORE, IgnoreSubmoduleMode.NONE);
    }

    public Repository getRepository() throws IOException {
        return getSubmoduleRepository(this.repository.getWorkTree(), this.path, this.repository.getFS(), getBuilder());
    }

    public ObjectId getHead() throws IOException {
        Throwable th = null;
        try {
            Repository repository = getRepository();
            if (repository == null) {
                if (repository != null) {
                    repository.close();
                }
                return null;
            }
            try {
                return repository.resolve("HEAD");
            } finally {
                if (repository != null) {
                    repository.close();
                }
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null == th2) {
                throw null;
            }
            th.addSuppressed(th2);
            throw null;
        }
    }

    public String getHeadRef() throws IOException {
        Throwable th = null;
        try {
            Repository repository = getRepository();
            if (repository == null) {
                if (repository != null) {
                    repository.close();
                }
                return null;
            }
            try {
                Ref refExactRef = repository.exactRef("HEAD");
                return refExactRef != null ? refExactRef.getLeaf().getName() : null;
            } finally {
                if (repository != null) {
                    repository.close();
                }
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null == th2) {
                throw null;
            }
            th.addSuppressed(th2);
            throw null;
        }
    }

    public String getRemoteUrl() throws ConfigInvalidException, IOException {
        String modulesUrl = getModulesUrl();
        if (modulesUrl != null) {
            return getSubmoduleRemoteUrl(this.repository, modulesUrl);
        }
        return null;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.walk.close();
    }
}
