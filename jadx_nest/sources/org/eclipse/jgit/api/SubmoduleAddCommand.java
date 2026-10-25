package org.eclipse.jgit.api;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.api.errors.NoFilepatternException;
import org.eclipse.jgit.errors.ConfigInvalidException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.submodule.SubmoduleValidator;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.StoredConfig;
import org.eclipse.jgit.storage.file.FileBasedConfig;
import org.eclipse.jgit.submodule.SubmoduleWalk;
import org.eclipse.jgit.treewalk.filter.PathFilter;

/* JADX INFO: loaded from: classes5.dex */
public class SubmoduleAddCommand extends TransportCommand<SubmoduleAddCommand, Repository> {
    private ProgressMonitor monitor;
    private String name;
    private String path;
    private String uri;

    public SubmoduleAddCommand(Repository repository) {
        super(repository);
    }

    public SubmoduleAddCommand setName(String str) {
        this.name = str;
        return this;
    }

    public SubmoduleAddCommand setPath(String str) {
        this.path = str;
        return this;
    }

    public SubmoduleAddCommand setURI(String str) {
        this.uri = str;
        return this;
    }

    public SubmoduleAddCommand setProgressMonitor(ProgressMonitor progressMonitor) {
        this.monitor = progressMonitor;
        return this;
    }

    protected boolean submoduleExists() throws IOException {
        PathFilter pathFilterCreate = PathFilter.create(this.path);
        Throwable th = null;
        try {
            SubmoduleWalk submoduleWalkForIndex = SubmoduleWalk.forIndex(this.repo);
            try {
                return submoduleWalkForIndex.setFilter(pathFilterCreate).next();
            } finally {
                if (submoduleWalkForIndex != null) {
                    submoduleWalkForIndex.close();
                }
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

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public Repository call() throws Throwable {
        checkCallable();
        String str = this.path;
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException(JGitText.get().pathNotConfigured);
        }
        String str2 = this.uri;
        if (str2 == null || str2.length() == 0) {
            throw new IllegalArgumentException(JGitText.get().uriNotConfigured);
        }
        String str3 = this.name;
        if (str3 == null || str3.length() == 0) {
            this.name = this.path;
        }
        try {
            SubmoduleValidator.assertValidSubmoduleName(this.name);
            SubmoduleValidator.assertValidSubmodulePath(this.path);
            SubmoduleValidator.assertValidSubmoduleUri(this.uri);
            try {
                if (submoduleExists()) {
                    throw new JGitInternalException(MessageFormat.format(JGitText.get().submoduleExists, this.path));
                }
                try {
                    String submoduleRemoteUrl = SubmoduleWalk.getSubmoduleRemoteUrl(this.repo, this.uri);
                    File submoduleDirectory = SubmoduleWalk.getSubmoduleDirectory(this.repo, this.path);
                    CloneCommand cloneCommandCloneRepository = Git.cloneRepository();
                    configure(cloneCommandCloneRepository);
                    cloneCommandCloneRepository.setDirectory(submoduleDirectory);
                    cloneCommandCloneRepository.setGitDir(new File(new File(this.repo.getCommonDirectory(), Constants.MODULES), this.path));
                    cloneCommandCloneRepository.setURI(submoduleRemoteUrl);
                    ProgressMonitor progressMonitor = this.monitor;
                    if (progressMonitor != null) {
                        cloneCommandCloneRepository.setProgressMonitor(progressMonitor);
                    }
                    Throwable th = null;
                    try {
                        Git gitCall = cloneCommandCloneRepository.call();
                        try {
                            Repository repository = gitCall.getRepository();
                            repository.incrementOpen();
                            if (gitCall != null) {
                                gitCall.close();
                            }
                            StoredConfig config = this.repo.getConfig();
                            config.setString(ConfigConstants.CONFIG_SUBMODULE_SECTION, this.name, "url", submoduleRemoteUrl);
                            try {
                                config.save();
                                FileBasedConfig fileBasedConfig = new FileBasedConfig(new File(this.repo.getWorkTree(), Constants.DOT_GIT_MODULES), this.repo.getFS());
                                try {
                                    fileBasedConfig.load();
                                    fileBasedConfig.setString(ConfigConstants.CONFIG_SUBMODULE_SECTION, this.name, "path", this.path);
                                    fileBasedConfig.setString(ConfigConstants.CONFIG_SUBMODULE_SECTION, this.name, "url", this.uri);
                                    fileBasedConfig.save();
                                    AddCommand addCommand = new AddCommand(this.repo);
                                    addCommand.addFilepattern(Constants.DOT_GIT_MODULES);
                                    addCommand.addFilepattern(this.path);
                                    try {
                                        addCommand.call();
                                        return repository;
                                    } catch (NoFilepatternException e) {
                                        throw new JGitInternalException(e.getMessage(), e);
                                    }
                                } catch (IOException | ConfigInvalidException e2) {
                                    throw new JGitInternalException(e2.getMessage(), e2);
                                }
                            } catch (IOException e3) {
                                throw new JGitInternalException(e3.getMessage(), e3);
                            }
                        } catch (Throwable th2) {
                            if (gitCall == null) {
                                throw th2;
                            }
                            gitCall.close();
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
                } catch (IOException e4) {
                    throw new JGitInternalException(e4.getMessage(), e4);
                }
            } catch (IOException e5) {
                throw new JGitInternalException(e5.getMessage(), e5);
            }
        } catch (SubmoduleValidator.SubmoduleValidationException e6) {
            throw new IllegalArgumentException(e6.getMessage());
        }
    }
}
