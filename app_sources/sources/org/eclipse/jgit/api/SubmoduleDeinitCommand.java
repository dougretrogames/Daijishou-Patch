package org.eclipse.jgit.api;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidConfigurationException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.errors.ConfigInvalidException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.StoredConfig;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.submodule.SubmoduleWalk;
import org.eclipse.jgit.treewalk.filter.PathFilter;
import org.eclipse.jgit.treewalk.filter.PathFilterGroup;
import org.eclipse.jgit.util.FileUtils;

/* INFO: loaded from: classes5.dex */
public class SubmoduleDeinitCommand extends GitCommand<Collection<SubmoduleDeinitResult>> {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$api$SubmoduleDeinitCommand$SubmoduleDeinitStatus;
    private boolean force;
    private final Collection<String> paths;

    public enum SubmoduleDeinitStatus {
        ALREADY_DEINITIALIZED,
        SUCCESS,
        FORCED,
        DIRTY;

        /* INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static SubmoduleDeinitStatus[] valuesCustom() {
            SubmoduleDeinitStatus[] submoduleDeinitStatusArrValuesCustom = values();
            int length = submoduleDeinitStatusArrValuesCustom.length;
            SubmoduleDeinitStatus[] submoduleDeinitStatusArr = new SubmoduleDeinitStatus[length];
            System.arraycopy(submoduleDeinitStatusArrValuesCustom, 0, submoduleDeinitStatusArr, 0, length);
            return submoduleDeinitStatusArr;
        }
    }

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$api$SubmoduleDeinitCommand$SubmoduleDeinitStatus() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$api$SubmoduleDeinitCommand$SubmoduleDeinitStatus;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[SubmoduleDeinitStatus.valuesCustom().length];
        try {
            iArr2[SubmoduleDeinitStatus.ALREADY_DEINITIALIZED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[SubmoduleDeinitStatus.DIRTY.ordinal()] = 4;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[SubmoduleDeinitStatus.FORCED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[SubmoduleDeinitStatus.SUCCESS.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$api$SubmoduleDeinitCommand$SubmoduleDeinitStatus = iArr2;
        return iArr2;
    }

    public SubmoduleDeinitCommand(Repository repository) {
        super(repository);
        this.paths = new ArrayList();
    }

    /* WARN: Multi-variable type inference failed */
    /* WARN: Type inference failed for: r0v8, types: [java.lang.Throwable] */
    /* WARN: Type inference failed for: r1v13, types: [java.lang.String] */
    /* WARN: Type inference failed for: r1v16 */
    /* WARN: Type inference failed for: r1v17 */
    /* WARN: Type inference failed for: r1v18 */
    /* WARN: Type inference failed for: r1v19 */
    /* WARN: Type inference failed for: r1v5 */
    /* WARN: Type inference failed for: r1v6, types: [java.lang.Throwable] */
    /* WARN: Type inference failed for: r1v7, types: [java.lang.Throwable] */
    /* WARN: Type inference failed for: r1v8 */
    /* WARN: Type inference failed for: r1v9, types: [java.lang.Throwable] */
    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public Collection<SubmoduleDeinitResult> call() throws GitAPIException {
        checkCallable();
        try {
            if (this.paths.isEmpty()) {
                return Collections.emptyList();
            }
            for (String str : this.paths) {
                if (!submoduleExists(str)) {
                    throw new NoSuchSubmoduleException(str);
                }
            }
            ArrayList arrayList = new ArrayList(this.paths.size());
            ?? r1 = 0;
            r1 = 0;
            r1 = 0;
            r1 = 0;
            r1 = 0;
            try {
                RevWalk revWalk = new RevWalk(this.repo);
                try {
                    SubmoduleWalk submoduleWalkForIndex = SubmoduleWalk.forIndex(this.repo);
                    try {
                        submoduleWalkForIndex.setFilter(PathFilterGroup.createFromStrings(this.paths));
                        StoredConfig config = this.repo.getConfig();
                        while (submoduleWalkForIndex.next()) {
                            String path = submoduleWalkForIndex.getPath();
                            String moduleName = submoduleWalkForIndex.getModuleName();
                            SubmoduleDeinitStatus submoduleDeinitStatusCheckDirty = checkDirty(revWalk, path);
                            int i = $SWITCH_TABLE$org$eclipse$jgit$api$SubmoduleDeinitCommand$SubmoduleDeinitStatus()[submoduleDeinitStatusCheckDirty.ordinal()];
                            if (i != 1) {
                                if (i == 2) {
                                    deinit(path);
                                } else if (i == 4) {
                                    if (this.force) {
                                        deinit(path);
                                        submoduleDeinitStatusCheckDirty = SubmoduleDeinitStatus.FORCED;
                                    }
                                } else {
                                    r1 = MessageFormat.format(JGitText.get().unexpectedSubmoduleStatus, submoduleDeinitStatusCheckDirty);
                                    throw new JGitInternalException(r1);
                                }
                            }
                            config.unsetSection(ConfigConstants.CONFIG_SUBMODULE_SECTION, moduleName);
                            arrayList.add(new SubmoduleDeinitResult(path, submoduleDeinitStatusCheckDirty));
                        }
                        if (submoduleWalkForIndex != null) {
                            submoduleWalkForIndex.close();
                        }
                        revWalk.close();
                        return arrayList;
                    } catch (Throwable th) {
                        if (submoduleWalkForIndex == null) {
                            throw th;
                        }
                        submoduleWalkForIndex.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    if (r1 == 0) {
                        r1 = th2;
                    } else if (r1 != th2) {
                        r1.addSuppressed(th2);
                    }
                    revWalk.close();
                    throw r1;
                }
            } catch (Throwable th3) {
                if (r1 == 0) {
                    throw th3;
                }
                if (r1 != th3) {
                    r1.addSuppressed(th3);
                }
                throw r1;
            }
        } catch (IOException e) {
            throw new JGitInternalException(e.getMessage(), e);
        } catch (ConfigInvalidException e2) {
            throw new InvalidConfigurationException(e2.getMessage(), e2);
        }
    }

    private void deinit(String str) throws IOException {
        File file = new File(this.repo.getWorkTree(), str);
        if (!file.isDirectory()) {
            throw new JGitInternalException(MessageFormat.format(JGitText.get().expectedDirectoryNotSubmodule, str));
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                FileUtils.delete(file2, 1);
            }
        }
    }

    private SubmoduleDeinitStatus checkDirty(RevWalk revWalk, String str) throws GitAPIException, IOException {
        SubmoduleDeinitStatus submoduleDeinitStatus;
        SubmoduleDeinitStatus submoduleDeinitStatus2;
        Ref refExactRef = this.repo.exactRef("HEAD");
        if (refExactRef == null) {
            throw new NoHeadException(JGitText.get().invalidRepositoryStateNoHead);
        }
        RevTree tree = revWalk.parseCommit(refExactRef.getObjectId()).getTree();
        Throwable th = null;
        try {
            SubmoduleWalk submoduleWalkForPath = SubmoduleWalk.forPath(this.repo, tree, str);
            try {
                ObjectId head = submoduleWalkForPath.getHead();
                if (head == null) {
                    submoduleDeinitStatus2 = SubmoduleDeinitStatus.ALREADY_DEINITIALIZED;
                    if (submoduleWalkForPath == null) {
                        return submoduleDeinitStatus2;
                    }
                } else {
                    if (!head.equals((AnyObjectId) submoduleWalkForPath.getObjectId())) {
                        submoduleDeinitStatus2 = SubmoduleDeinitStatus.DIRTY;
                        if (submoduleWalkForPath != null) {
                        }
                        return submoduleDeinitStatus2;
                    }
                    if (submoduleWalkForPath != null) {
                        submoduleWalkForPath.close();
                    }
                    try {
                        SubmoduleWalk submoduleWalkForIndex = SubmoduleWalk.forIndex(this.repo);
                        try {
                            if (!submoduleWalkForIndex.next()) {
                                submoduleDeinitStatus = SubmoduleDeinitStatus.DIRTY;
                                if (submoduleWalkForIndex == null) {
                                    return submoduleDeinitStatus;
                                }
                            } else {
                                if (!head.equals((AnyObjectId) submoduleWalkForIndex.getObjectId())) {
                                    submoduleDeinitStatus = SubmoduleDeinitStatus.DIRTY;
                                    if (submoduleWalkForIndex != null) {
                                    }
                                    return submoduleDeinitStatus;
                                }
                                try {
                                    Repository repository = submoduleWalkForIndex.getRepository();
                                    try {
                                        SubmoduleDeinitStatus submoduleDeinitStatus3 = Git.wrap(repository).status().call().isClean() ? SubmoduleDeinitStatus.SUCCESS : SubmoduleDeinitStatus.DIRTY;
                                        if (repository != null) {
                                            repository.close();
                                        }
                                        if (submoduleWalkForIndex != null) {
                                            submoduleWalkForIndex.close();
                                        }
                                        return submoduleDeinitStatus3;
                                    } catch (Throwable th2) {
                                        if (repository != null) {
                                            repository.close();
                                        }
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
                            }
                            submoduleWalkForIndex.close();
                            return submoduleDeinitStatus;
                        } catch (Throwable th4) {
                            if (submoduleWalkForIndex == null) {
                                throw th4;
                            }
                            submoduleWalkForIndex.close();
                            throw th4;
                        }
                    } catch (Throwable th5) {
                        if (0 == 0) {
                            throw th5;
                        }
                        if (null != th5) {
                            th.addSuppressed(th5);
                        }
                        throw null;
                    }
                }
                submoduleWalkForPath.close();
                return submoduleDeinitStatus2;
            } catch (Throwable th6) {
                if (submoduleWalkForPath == null) {
                    throw th6;
                }
                submoduleWalkForPath.close();
                throw th6;
            }
        } catch (Throwable th7) {
            if (0 == 0) {
                throw th7;
            }
            if (null != th7) {
                th.addSuppressed(th7);
            }
            throw null;
        }
    }

    private boolean submoduleExists(String str) throws IOException {
        PathFilter pathFilterCreate = PathFilter.create(str);
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

    public SubmoduleDeinitCommand addPath(String str) {
        this.paths.add(str);
        return this;
    }

    public SubmoduleDeinitCommand setForce(boolean z) {
        this.force = z;
        return this;
    }

    public static class NoSuchSubmoduleException extends GitAPIException {
        private static final long serialVersionUID = 1;

        public NoSuchSubmoduleException(String str) {
            super(MessageFormat.format(JGitText.get().noSuchSubmodule, str));
        }
    }
}
