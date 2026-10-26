package org.eclipse.jgit.api;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.lingala.zip4j.util.InternalZipConstants;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.dircache.DirCacheCheckout;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.util.ShutdownHook;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.BranchConfig;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.NullProgressMonitor;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.RefUpdate;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.transport.FetchResult;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.jgit.transport.RemoteConfig;
import org.eclipse.jgit.transport.TagOpt;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.jgit.util.FS;
import org.eclipse.jgit.util.FileUtils;

/* INFO: loaded from: classes5.dex */
public class CloneCommand extends TransportCommand<CloneCommand, Git> {
    private boolean bare;
    private String branch;
    private Collection<String> branchesToClone;
    private Callback callback;
    private boolean cloneAllBranches;
    private boolean cloneSubmodules;
    private Integer depth;
    private File directory;
    private boolean directoryExistsInitially;
    private FETCH_TYPE fetchType;
    private FS fs;
    private File gitDir;
    private boolean gitDirExistsInitially;
    private boolean mirror;
    private ProgressMonitor monitor;
    private boolean noCheckout;
    private String remote;
    private List<String> shallowExcludes;
    private Instant shallowSince;
    private ShutdownHook.Listener shutdownListener;
    private TagOpt tagOption;
    private String uri;

    public interface Callback {
        void checkingOut(AnyObjectId anyObjectId, String str);

        void cloningSubmodule(String str);

        void initializedSubmodules(Collection<String> collection);
    }

    private enum FETCH_TYPE {
        MULTIPLE_BRANCHES,
        ALL_BRANCHES,
        MIRROR;

        /* INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static FETCH_TYPE[] valuesCustom() {
            FETCH_TYPE[] fetch_typeArrValuesCustom = values();
            int length = fetch_typeArrValuesCustom.length;
            FETCH_TYPE[] fetch_typeArr = new FETCH_TYPE[length];
            System.arraycopy(fetch_typeArrValuesCustom, 0, fetch_typeArr, 0, length);
            return fetch_typeArr;
        }
    }

    public CloneCommand() {
        super(null);
        this.remote = "origin";
        this.branch = "HEAD";
        this.monitor = NullProgressMonitor.INSTANCE;
        this.shallowExcludes = new ArrayList();
        this.shutdownListener = new CloneCommand$$ExternalSyntheticLambda0(this);
    }

    @Nullable
    File getDirectory() {
        return this.directory;
    }

    /* WARN: Code duplicated, block: B:23:0x0049 A[Catch: all -> 0x0042, TRY_ENTER, TryCatch #2 {all -> 0x0042, blocks: (B:4:0x0018, B:23:0x0049, B:24:0x004c, B:25:0x004f, B:28:0x0053, B:29:0x0056, B:30:0x006e, B:33:0x0072, B:34:0x0075, B:35:0x0081), top: B:41:0x0018, inners: #6, #9, #6 }] */
    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public Git call() throws Throwable {
        try {
            URIish uRIish = new URIish(this.uri);
            verifyDirectories(uRIish);
            setFetchType();
            Repository repositoryInit = init();
            ShutdownHook.INSTANCE.register(this.shutdownListener);
            try {
                try {
                    try {
                        FetchResult fetchResultFetch = fetch(repositoryInit, uRIish);
                        ShutdownHook.INSTANCE.unregister(this.shutdownListener);
                        try {
                            checkout(repositoryInit, fetchResultFetch);
                            return new Git(repositoryInit, true);
                        } catch (IOException e) {
                            repositoryInit.close();
                            throw new JGitInternalException(e.getMessage(), e);
                        } catch (RuntimeException e2) {
                            e = e2;
                            repositoryInit.close();
                            throw e;
                        } catch (GitAPIException e3) {
                            e = e3;
                            repositoryInit.close();
                            throw e;
                        }
                    } catch (Throwable th) {
                        ShutdownHook.INSTANCE.unregister(this.shutdownListener);
                        throw th;
                    }
                } catch (RuntimeException e4) {
                    e = e4;
                    if (repositoryInit != null) {
                        repositoryInit.close();
                    }
                    cleanup();
                    throw e;
                } catch (URISyntaxException e5) {
                    if (repositoryInit != null) {
                        repositoryInit.close();
                    }
                    cleanup();
                    throw new InvalidRemoteException(MessageFormat.format(JGitText.get().invalidRemote, this.remote), e5);
                }
            } catch (IOException e6) {
                if (repositoryInit != null) {
                    repositoryInit.close();
                }
                cleanup();
                throw new JGitInternalException(e6.getMessage(), e6);
            } catch (GitAPIException e7) {
                e = e7;
                if (repositoryInit != null) {
                    repositoryInit.close();
                }
                cleanup();
                throw e;
            }
        } catch (URISyntaxException e8) {
            throw new InvalidRemoteException(MessageFormat.format(JGitText.get().invalidURL, this.uri), e8);
        }
    }

    private void setFetchType() {
        if (this.mirror) {
            this.fetchType = FETCH_TYPE.MIRROR;
            setBare(true);
        } else {
            if (this.cloneAllBranches) {
                this.fetchType = FETCH_TYPE.ALL_BRANCHES;
                return;
            }
            Collection<String> collection = this.branchesToClone;
            if (collection != null && !collection.isEmpty()) {
                this.fetchType = FETCH_TYPE.MULTIPLE_BRANCHES;
            } else {
                this.fetchType = FETCH_TYPE.ALL_BRANCHES;
            }
        }
    }

    private static boolean isNonEmptyDirectory(File file) {
        File[] fileArrListFiles;
        return (file == null || !file.exists() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length == 0) ? false : true;
    }

    void verifyDirectories(URIish uRIish) {
        if (this.directory == null && this.gitDir == null) {
            this.directory = new File(uRIish.getHumanishName() + (this.bare ? ".git" : ""));
        }
        File file = this.directory;
        this.directoryExistsInitially = file != null && file.exists();
        File file2 = this.gitDir;
        this.gitDirExistsInitially = file2 != null && file2.exists();
        validateDirs(this.directory, this.gitDir, this.bare);
        if (isNonEmptyDirectory(this.directory)) {
            throw new JGitInternalException(MessageFormat.format(JGitText.get().cloneNonEmptyDirectory, this.directory.getName()));
        }
        if (isNonEmptyDirectory(this.gitDir)) {
            throw new JGitInternalException(MessageFormat.format(JGitText.get().cloneNonEmptyDirectory, this.gitDir.getName()));
        }
    }

    private Repository init() throws GitAPIException {
        InitCommand initCommandInit = Git.init();
        initCommandInit.setBare(this.bare);
        FS fs = this.fs;
        if (fs != null) {
            initCommandInit.setFs(fs);
        }
        File file = this.directory;
        if (file != null) {
            initCommandInit.setDirectory(file);
        }
        File file2 = this.gitDir;
        if (file2 != null) {
            initCommandInit.setGitDir(file2);
        }
        return initCommandInit.call().getRepository();
    }

    private FetchResult fetch(Repository repository, URIish uRIish) throws GitAPIException, URISyntaxException, IOException {
        RemoteConfig remoteConfig = new RemoteConfig(repository.getConfig(), this.remote);
        remoteConfig.addURI(uRIish);
        boolean z = this.fetchType == FETCH_TYPE.ALL_BRANCHES || this.fetchType == FETCH_TYPE.MIRROR;
        remoteConfig.setFetchRefSpecs(calculateRefSpecs(this.fetchType, remoteConfig.getName()));
        remoteConfig.setMirror(this.fetchType == FETCH_TYPE.MIRROR);
        TagOpt tagOpt = this.tagOption;
        if (tagOpt != null) {
            remoteConfig.setTagOpt(tagOpt);
        }
        remoteConfig.update(repository.getConfig());
        repository.getConfig().save();
        FetchCommand fetchCommand = new FetchCommand(repository);
        fetchCommand.setRemote(this.remote);
        fetchCommand.setProgressMonitor(this.monitor);
        TagOpt tagOpt2 = this.tagOption;
        if (tagOpt2 != null) {
            fetchCommand.setTagOpt(tagOpt2);
        } else {
            fetchCommand.setTagOpt(z ? TagOpt.FETCH_TAGS : TagOpt.AUTO_FOLLOW);
        }
        fetchCommand.setInitialBranch(this.branch);
        Integer num = this.depth;
        if (num != null) {
            fetchCommand.setDepth(num.intValue());
        }
        Instant instant = this.shallowSince;
        if (instant != null) {
            fetchCommand.setShallowSince(instant);
        }
        fetchCommand.setShallowExcludes(this.shallowExcludes);
        configure(fetchCommand);
        return fetchCommand.call();
    }

    private List<RefSpec> calculateRefSpecs(FETCH_TYPE fetch_type, String str) {
        ArrayList arrayList = new ArrayList();
        if (fetch_type == FETCH_TYPE.MIRROR) {
            arrayList.add(new RefSpec().setForceUpdate(true).setSourceDestination("refs/*", "refs/*"));
            return arrayList;
        }
        RefSpec sourceDestination = new RefSpec().setForceUpdate(true).setSourceDestination("refs/heads/*", (this.bare ? Constants.R_HEADS : Constants.R_REMOTES + str + InternalZipConstants.ZIP_FILE_SEPARATOR) + "*");
        if (fetch_type == FETCH_TYPE.MULTIPLE_BRANCHES) {
            RefSpec sourceDestination2 = new RefSpec().setForceUpdate(true).setSourceDestination("refs/tags/*", "refs/tags/*");
            for (String str2 : this.branchesToClone) {
                if (sourceDestination.matchSource(str2)) {
                    arrayList.add(sourceDestination.expandFromSource(str2));
                } else if (sourceDestination2.matchSource(str2)) {
                    arrayList.add(sourceDestination2.expandFromSource(str2));
                }
            }
            return arrayList;
        }
        arrayList.add(sourceDestination);
        return arrayList;
    }

    private void checkout(Repository repository, FetchResult fetchResult) throws GitAPIException, IOException {
        Ref advertisedRef;
        if (!this.branch.equals("HEAD") || (advertisedRef = findBranchToCheckout(fetchResult)) == null) {
            advertisedRef = null;
        }
        if (advertisedRef == null) {
            advertisedRef = fetchResult.getAdvertisedRef(this.branch);
            if (advertisedRef == null) {
                advertisedRef = fetchResult.getAdvertisedRef(Constants.R_HEADS + this.branch);
            }
            if (advertisedRef == null) {
                advertisedRef = fetchResult.getAdvertisedRef(Constants.R_TAGS + this.branch);
            }
        }
        if (advertisedRef == null || advertisedRef.getObjectId() == null) {
            return;
        }
        if (advertisedRef.getName().startsWith(Constants.R_HEADS)) {
            RefUpdate refUpdateUpdateRef = repository.updateRef("HEAD");
            refUpdateUpdateRef.disableRefLog();
            refUpdateUpdateRef.link(advertisedRef.getName());
            addMergeConfig(repository, advertisedRef);
        }
        RevCommit commit = parseCommit(repository, advertisedRef);
        RefUpdate refUpdateUpdateRef2 = repository.updateRef("HEAD", !advertisedRef.getName().startsWith(Constants.R_HEADS));
        refUpdateUpdateRef2.setNewObjectId(commit.getId());
        refUpdateUpdateRef2.forceUpdate();
        if (this.bare || this.noCheckout) {
            return;
        }
        DirCacheCheckout dirCacheCheckout = new DirCacheCheckout(repository, repository.lockDirCache(), commit.getTree());
        dirCacheCheckout.setProgressMonitor(this.monitor);
        dirCacheCheckout.checkout();
        if (this.cloneSubmodules) {
            cloneSubmodules(repository);
        }
    }

    /* WARN: Bottom block not found for handler: all -> 0x0056 */
    /* WARN: Code restructure failed: missing block: B:42:?, code lost:
    
        throw r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void cloneSubmodules(org.eclipse.jgit.lib.Repository r3) throws org.eclipse.jgit.api.errors.GitAPIException, java.io.IOException {
        /*
            r2 = this;
            org.eclipse.jgit.api.SubmoduleInitCommand r0 = new org.eclipse.jgit.api.SubmoduleInitCommand
            r0.<init>(r3)
            java.util.Collection r0 = r0.call()
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L10
            goto L60
        L10:
            org.eclipse.jgit.api.CloneCommand$Callback r1 = r2.callback
            if (r1 == 0) goto L17
            r1.initializedSubmodules(r0)
        L17:
            org.eclipse.jgit.api.SubmoduleUpdateCommand r0 = new org.eclipse.jgit.api.SubmoduleUpdateCommand
            r0.<init>(r3)
            r2.configure(r0)
            org.eclipse.jgit.lib.ProgressMonitor r1 = r2.monitor
            r0.setProgressMonitor(r1)
            org.eclipse.jgit.api.CloneCommand$Callback r1 = r2.callback
            r0.setCallback(r1)
            java.util.Collection r0 = r0.call()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L60
            org.eclipse.jgit.submodule.SubmoduleWalk r3 = org.eclipse.jgit.submodule.SubmoduleWalk.forIndex(r3)
        L37:
            boolean r0 = r3.next()
            if (r0 != 0) goto L3e
            goto L60
        L3e:
            r0 = 0
            org.eclipse.jgit.lib.Repository r1 = r3.getRepository()     // Catch: java.lang.Throwable -> L56
            if (r1 == 0) goto L50
            r2.cloneSubmodules(r1)     // Catch: java.lang.Throwable -> L49
            goto L50
        L49:
            r0 = move-exception
            if (r1 == 0) goto L4f
            r1.close()     // Catch: java.lang.Throwable -> L56
        L4f:
            throw r0     // Catch: java.lang.Throwable -> L56
        L50:
            if (r1 == 0) goto L37
            r1.close()     // Catch: java.lang.Throwable -> L56
            goto L37
        L56:
            r3 = move-exception
            if (r0 == 0) goto L5f
            if (r0 == r3) goto L5e
            r0.addSuppressed(r3)
        L5e:
            r3 = r0
        L5f:
            throw r3
        L60:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jgit.api.CloneCommand.cloneSubmodules(org.eclipse.jgit.lib.Repository):void");
    }

    private Ref findBranchToCheckout(FetchResult fetchResult) {
        Ref advertisedRef = fetchResult.getAdvertisedRef("HEAD");
        ObjectId objectId = advertisedRef != null ? advertisedRef.getObjectId() : null;
        if (objectId == null) {
            return null;
        }
        if (advertisedRef != null && advertisedRef.isSymbolic()) {
            return advertisedRef.getTarget();
        }
        Ref advertisedRef2 = fetchResult.getAdvertisedRef("refs/heads/master");
        if (objectId.equals((AnyObjectId) (advertisedRef2 != null ? advertisedRef2.getObjectId() : null))) {
            return advertisedRef2;
        }
        for (Ref ref : fetchResult.getAdvertisedRefs()) {
            if (ref.getName().startsWith(Constants.R_HEADS) && objectId.equals((AnyObjectId) ref.getObjectId())) {
                return ref;
            }
        }
        return null;
    }

    private void addMergeConfig(Repository repository, Ref ref) throws IOException {
        String strShortenRefName = Repository.shortenRefName(ref.getName());
        repository.getConfig().setString(ConfigConstants.CONFIG_BRANCH_SECTION, strShortenRefName, "remote", this.remote);
        repository.getConfig().setString(ConfigConstants.CONFIG_BRANCH_SECTION, strShortenRefName, "merge", ref.getName());
        String string = repository.getConfig().getString(ConfigConstants.CONFIG_BRANCH_SECTION, null, ConfigConstants.CONFIG_KEY_AUTOSETUPREBASE);
        if (ConfigConstants.CONFIG_KEY_ALWAYS.equals(string) || "remote".equals(string)) {
            repository.getConfig().setEnum(ConfigConstants.CONFIG_BRANCH_SECTION, strShortenRefName, "rebase", BranchConfig.BranchRebaseMode.REBASE);
        }
        repository.getConfig().save();
    }

    private RevCommit parseCommit(Repository repository, Ref ref) throws IOException {
        Throwable th = null;
        try {
            RevWalk revWalk = new RevWalk(repository);
            try {
                return revWalk.parseCommit(ref.getObjectId());
            } finally {
                revWalk.close();
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

    public CloneCommand setURI(String str) {
        this.uri = str;
        return this;
    }

    public CloneCommand setDirectory(File file) {
        validateDirs(file, this.gitDir, this.bare);
        this.directory = file;
        return this;
    }

    public CloneCommand setGitDir(File file) {
        validateDirs(this.directory, file, this.bare);
        this.gitDir = file;
        return this;
    }

    public CloneCommand setBare(boolean z) throws IllegalStateException {
        validateDirs(this.directory, this.gitDir, z);
        this.bare = z;
        return this;
    }

    public CloneCommand setFs(FS fs) {
        this.fs = fs;
        return this;
    }

    public CloneCommand setRemote(String str) {
        if (str == null) {
            str = "origin";
        }
        this.remote = str;
        return this;
    }

    public CloneCommand setBranch(String str) {
        if (str == null) {
            str = "HEAD";
        }
        this.branch = str;
        return this;
    }

    public CloneCommand setProgressMonitor(ProgressMonitor progressMonitor) {
        if (progressMonitor == null) {
            progressMonitor = NullProgressMonitor.INSTANCE;
        }
        this.monitor = progressMonitor;
        return this;
    }

    public CloneCommand setCloneAllBranches(boolean z) {
        this.cloneAllBranches = z;
        return this;
    }

    public CloneCommand setMirror(boolean z) {
        this.mirror = z;
        return this;
    }

    public CloneCommand setCloneSubmodules(boolean z) {
        this.cloneSubmodules = z;
        return this;
    }

    public CloneCommand setBranchesToClone(Collection<String> collection) {
        this.branchesToClone = collection;
        return this;
    }

    public CloneCommand setTagOption(TagOpt tagOpt) {
        this.tagOption = tagOpt;
        return this;
    }

    public CloneCommand setNoTags() {
        return setTagOption(TagOpt.NO_TAGS);
    }

    public CloneCommand setNoCheckout(boolean z) {
        this.noCheckout = z;
        return this;
    }

    public CloneCommand setCallback(Callback callback) {
        this.callback = callback;
        return this;
    }

    public CloneCommand setDepth(int i) {
        if (i < 1) {
            throw new IllegalArgumentException(JGitText.get().depthMustBeAt1);
        }
        this.depth = Integer.valueOf(i);
        return this;
    }

    public CloneCommand setShallowSince(OffsetDateTime offsetDateTime) {
        this.shallowSince = offsetDateTime.toInstant();
        return this;
    }

    public CloneCommand setShallowSince(Instant instant) {
        this.shallowSince = instant;
        return this;
    }

    public CloneCommand addShallowExclude(String str) {
        this.shallowExcludes.add(str);
        return this;
    }

    public CloneCommand addShallowExclude(ObjectId objectId) {
        this.shallowExcludes.add(objectId.name());
        return this;
    }

    private static void validateDirs(File file, File file2, boolean z) throws IllegalStateException {
        if (file != null) {
            if (file.exists() && !file.isDirectory()) {
                throw new IllegalStateException(MessageFormat.format(JGitText.get().initFailedDirIsNoDirectory, file));
            }
            if (file2 != null && file2.exists() && !file2.isDirectory()) {
                throw new IllegalStateException(MessageFormat.format(JGitText.get().initFailedGitDirIsNoDirectory, file2));
            }
            if (z) {
                if (file2 != null && !file2.equals(file)) {
                    throw new IllegalStateException(MessageFormat.format(JGitText.get().initFailedBareRepoDifferentDirs, file2, file));
                }
            } else if (file2 != null && file2.equals(file)) {
                throw new IllegalStateException(MessageFormat.format(JGitText.get().initFailedNonBareRepoSameDirs, file2, file));
            }
        }
    }

    /* INFO: Access modifiers changed from: private */
    public void cleanup() {
        try {
            File file = this.directory;
            if (file != null) {
                if (!this.directoryExistsInitially) {
                    FileUtils.delete(file, 13);
                } else {
                    deleteChildren(file);
                }
            }
            File file2 = this.gitDir;
            if (file2 != null) {
                if (!this.gitDirExistsInitially) {
                    FileUtils.delete(file2, 13);
                } else {
                    deleteChildren(file2);
                }
            }
        } catch (IOException unused) {
        }
    }

    private void deleteChildren(File file) throws IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            FileUtils.delete(file2, 13);
        }
    }
}
