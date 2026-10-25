package org.eclipse.jgit.api;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.concurrent.Callable;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.errors.ConfigInvalidException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.BranchConfig;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RepositoryBuilder;
import org.eclipse.jgit.util.FS;
import org.eclipse.jgit.util.StringUtils;
import org.eclipse.jgit.util.SystemReader;

/* JADX INFO: loaded from: classes5.dex */
public class InitCommand implements Callable<Git> {
    private boolean bare;
    private File directory;
    private FS fs;
    private File gitDir;
    private String initialBranch;

    @Override // java.util.concurrent.Callable
    public Git call() throws GitAPIException {
        String string;
        try {
            RepositoryBuilder repositoryBuilder = new RepositoryBuilder();
            if (this.bare) {
                repositoryBuilder.setBare();
            }
            FS fs = this.fs;
            if (fs != null) {
                repositoryBuilder.setFS(fs);
            }
            repositoryBuilder.readEnvironment();
            File file = this.gitDir;
            if (file != null) {
                repositoryBuilder.setGitDir(file);
            } else {
                this.gitDir = repositoryBuilder.getGitDir();
            }
            File file2 = this.directory;
            if (file2 != null) {
                if (this.bare) {
                    repositoryBuilder.setGitDir(file2);
                } else {
                    repositoryBuilder.setWorkTree(file2);
                    if (this.gitDir == null) {
                        repositoryBuilder.setGitDir(new File(this.directory, ".git"));
                    }
                }
            } else {
                File gitDir = repositoryBuilder.getGitDir();
                String str = BranchConfig.LOCAL_REPOSITORY;
                if (gitDir == null) {
                    String property = SystemReader.getInstance().getProperty(Constants.OS_USER_DIR);
                    if (property != null) {
                        str = property;
                    }
                    File file3 = new File(str);
                    if (!this.bare) {
                        file3 = new File(file3, ".git");
                    }
                    repositoryBuilder.setGitDir(file3);
                } else if (!this.bare) {
                    String property2 = SystemReader.getInstance().getProperty(Constants.OS_USER_DIR);
                    if (property2 != null) {
                        str = property2;
                    }
                    repositoryBuilder.setWorkTree(new File(str));
                }
            }
            if (StringUtils.isEmptyOrNull(this.initialBranch)) {
                string = SystemReader.getInstance().getUserConfig().getString(ConfigConstants.CONFIG_INIT_SECTION, null, ConfigConstants.CONFIG_KEY_DEFAULT_BRANCH);
            } else {
                string = this.initialBranch;
            }
            repositoryBuilder.setInitialBranch(string);
            Repository repositoryBuild = repositoryBuilder.build();
            if (!repositoryBuild.getObjectDatabase().exists()) {
                repositoryBuild.create(this.bare);
            }
            return new Git(repositoryBuild, true);
        } catch (IOException | ConfigInvalidException e) {
            throw new JGitInternalException(e.getMessage(), e);
        }
    }

    public InitCommand setDirectory(File file) throws IllegalStateException {
        validateDirs(file, this.gitDir, this.bare);
        this.directory = file;
        return this;
    }

    public InitCommand setGitDir(File file) throws IllegalStateException {
        validateDirs(this.directory, file, this.bare);
        this.gitDir = file;
        return this;
    }

    private static void validateDirs(File file, File file2, boolean z) throws IllegalStateException {
        if (file != null) {
            if (z) {
                if (file2 != null && !file2.equals(file)) {
                    throw new IllegalStateException(MessageFormat.format(JGitText.get().initFailedBareRepoDifferentDirs, file2, file));
                }
            } else if (file2 != null && file2.equals(file)) {
                throw new IllegalStateException(MessageFormat.format(JGitText.get().initFailedNonBareRepoSameDirs, file2, file));
            }
        }
    }

    public InitCommand setBare(boolean z) {
        validateDirs(this.directory, this.gitDir, z);
        this.bare = z;
        return this;
    }

    public InitCommand setFs(FS fs) {
        this.fs = fs;
        return this;
    }

    public InitCommand setInitialBranch(String str) throws InvalidRefNameException {
        this.initialBranch = str;
        return this;
    }
}
