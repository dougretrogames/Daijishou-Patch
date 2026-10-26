package org.eclipse.jgit.gitrepo;

import androidx.lifecycle.CoroutineLiveDataKt;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.List;
import net.lingala.zip4j.util.InternalZipConstants;
import org.eclipse.jgit.api.errors.ConcurrentRefUpdateException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.dircache.DirCache;
import org.eclipse.jgit.dircache.DirCacheBuilder;
import org.eclipse.jgit.dircache.DirCacheEntry;
import org.eclipse.jgit.dircache.InvalidPathException;
import org.eclipse.jgit.gitrepo.internal.RepoText;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.CommitBuilder;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.lib.RefUpdate;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.util.FileUtils;

/* INFO: loaded from: classes5.dex */
class BareSuperprojectWriter {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result = null;
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int LOCK_FAILURE_MAX_RETRIES = 5;
    private static final int LOCK_FAILURE_MAX_RETRY_DELAY_MILLIS = 5000;
    private static final int LOCK_FAILURE_MIN_RETRY_DELAY_MILLIS = 50;
    private final PersonIdent author;
    private final RepoCommand.RemoteReader callback;
    private final BareWriterConfig config;
    private List<ExtraContent> extraContents;
    private final Repository repo;
    private final String targetBranch;
    private final URI targetUri;

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[RefUpdate.Result.valuesCustom().length];
        try {
            iArr2[RefUpdate.Result.FAST_FORWARD.ordinal()] = 6;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[RefUpdate.Result.FORCED.ordinal()] = 5;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[RefUpdate.Result.IO_FAILURE.ordinal()] = 9;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[RefUpdate.Result.LOCK_FAILURE.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[RefUpdate.Result.NEW.ordinal()] = 4;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[RefUpdate.Result.NOT_ATTEMPTED.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[RefUpdate.Result.NO_CHANGE.ordinal()] = 3;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr2[RefUpdate.Result.REJECTED.ordinal()] = 7;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr2[RefUpdate.Result.REJECTED_CURRENT_BRANCH.ordinal()] = 8;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr2[RefUpdate.Result.REJECTED_MISSING_OBJECT.ordinal()] = 11;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            iArr2[RefUpdate.Result.REJECTED_OTHER_REASON.ordinal()] = 12;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            iArr2[RefUpdate.Result.RENAMED.ordinal()] = 10;
        } catch (NoSuchFieldError unused12) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result = iArr2;
        return iArr2;
    }

    static class BareWriterConfig {
        boolean ignoreRemoteFailures = false;
        boolean recordRemoteBranch = true;
        boolean recordSubmoduleLabels = true;
        boolean recordShallowSubmodules = true;

        static BareWriterConfig getDefault() {
            return new BareWriterConfig();
        }

        private BareWriterConfig() {
        }
    }

    static class ExtraContent {
        final String content;
        final String path;

        ExtraContent(String str, String str2) {
            this.path = str;
            this.content = str2;
        }
    }

    BareSuperprojectWriter(Repository repository, URI uri, String str, PersonIdent personIdent, RepoCommand.RemoteReader remoteReader, BareWriterConfig bareWriterConfig, List<ExtraContent> list) {
        this.repo = repository;
        this.targetUri = uri;
        this.targetBranch = str;
        this.author = personIdent;
        this.callback = remoteReader;
        this.config = bareWriterConfig;
        this.extraContents = list;
    }

    RevCommit write(List<RepoProject> list) throws GitAPIException {
        DirCache dirCacheNewInCore = DirCache.newInCore();
        ObjectInserter objectInserterNewObjectInserter = this.repo.newObjectInserter();
        Throwable th = null;
        try {
            RevWalk revWalk = new RevWalk(this.repo);
            try {
                prepareIndex(list, dirCacheNewInCore, objectInserterNewObjectInserter);
                ObjectId objectIdWriteTree = dirCacheNewInCore.writeTree(objectInserterNewObjectInserter);
                long jDelay = 0;
                for (int i = 0; i < 4; i++) {
                    try {
                        RevCommit revCommitCommitTreeOnCurrentTip = commitTreeOnCurrentTip(objectInserterNewObjectInserter, revWalk, objectIdWriteTree);
                        revWalk.close();
                        return revCommitCommitTreeOnCurrentTip;
                    } catch (ConcurrentRefUpdateException unused) {
                        jDelay = FileUtils.delay(jDelay, 50L, CoroutineLiveDataKt.DEFAULT_TIMEOUT);
                        Thread.sleep(jDelay);
                        this.repo.getRefDatabase().refresh();
                    }
                }
                RevCommit revCommitCommitTreeOnCurrentTip2 = commitTreeOnCurrentTip(objectInserterNewObjectInserter, revWalk, objectIdWriteTree);
                revWalk.close();
                return revCommitCommitTreeOnCurrentTip2;
            } catch (Throwable th2) {
                revWalk.close();
                throw th2;
            }
        } catch (Throwable th3) {
            if (0 == 0) {
                throw th3;
            }
            if (null != th3) {
                try {
                    th.addSuppressed(th3);
                } catch (IOException | InterruptedException | InvalidPathException e) {
                    throw new RepoCommand.ManifestErrorException(e);
                }
            }
            throw null;
        }
    }

    private void prepareIndex(List<RepoProject> list, DirCache dirCache, ObjectInserter objectInserter) throws GitAPIException, IOException {
        ObjectId objectIdSha1;
        Config config = new Config();
        StringBuilder sb = new StringBuilder();
        DirCacheBuilder dirCacheBuilderBuilder = dirCache.builder();
        for (RepoProject repoProject : list) {
            String name = repoProject.getName();
            String path = repoProject.getPath();
            String url = repoProject.getUrl();
            if (ObjectId.isId(repoProject.getRevision())) {
                objectIdSha1 = ObjectId.fromString(repoProject.getRevision());
                if (this.config.recordRemoteBranch && repoProject.getUpstream() != null) {
                    config.setString(ConfigConstants.CONFIG_SUBMODULE_SECTION, name, "ref", repoProject.getUpstream());
                }
            } else {
                objectIdSha1 = this.callback.sha1(url, repoProject.getRevision());
                if (objectIdSha1 == null && !this.config.ignoreRemoteFailures) {
                    throw new RepoCommand.RemoteUnavailableException(url);
                }
                if (this.config.recordRemoteBranch) {
                    config.setString(ConfigConstants.CONFIG_SUBMODULE_SECTION, name, repoProject.getRevision().startsWith(Constants.R_TAGS) ? "ref" : ConfigConstants.CONFIG_BRANCH_SECTION, repoProject.getRevision());
                }
                if (this.config.recordShallowSubmodules && repoProject.getRecommendShallow() != null) {
                    config.setBoolean(ConfigConstants.CONFIG_SUBMODULE_SECTION, name, "shallow", true);
                }
            }
            if (this.config.recordSubmoduleLabels) {
                StringBuilder sb2 = new StringBuilder(InternalZipConstants.ZIP_FILE_SEPARATOR);
                sb2.append(path);
                for (String str : repoProject.getGroups()) {
                    sb2.append(" ");
                    sb2.append(str);
                    sb = sb;
                }
                sb2.append("\n");
                sb.append(sb2.toString());
            }
            StringBuilder sb3 = sb;
            URI uriCreate = URI.create(url);
            URI uri = this.targetUri;
            if (uri != null) {
                uriCreate = RepoCommand.relativize(uri, uriCreate);
            }
            config.setString(ConfigConstants.CONFIG_SUBMODULE_SECTION, name, "path", path);
            config.setString(ConfigConstants.CONFIG_SUBMODULE_SECTION, name, "url", uriCreate.toString());
            if (objectIdSha1 != null) {
                DirCacheEntry dirCacheEntry = new DirCacheEntry(path);
                dirCacheEntry.setObjectId(objectIdSha1);
                dirCacheEntry.setFileMode(FileMode.GITLINK);
                dirCacheBuilderBuilder.add(dirCacheEntry);
                for (RepoProject.CopyFile copyFile : repoProject.getCopyFiles()) {
                    RepoCommand.RemoteFile fileWithMode = this.callback.readFileWithMode(url, repoProject.getRevision(), copyFile.src);
                    ObjectId objectIdInsert = objectInserter.insert(3, fileWithMode.getContents());
                    DirCacheEntry dirCacheEntry2 = new DirCacheEntry(copyFile.dest);
                    dirCacheEntry2.setObjectId(objectIdInsert);
                    dirCacheEntry2.setFileMode(fileWithMode.getFileMode());
                    dirCacheBuilderBuilder.add(dirCacheEntry2);
                }
                for (RepoProject.LinkFile linkFile : repoProject.getLinkFiles()) {
                    ObjectId objectIdInsert2 = objectInserter.insert(3, (linkFile.dest.contains(InternalZipConstants.ZIP_FILE_SEPARATOR) ? FileUtils.relativizeGitPath(linkFile.dest.substring(0, linkFile.dest.lastIndexOf(47)), repoProject.getPath() + InternalZipConstants.ZIP_FILE_SEPARATOR + linkFile.src) : repoProject.getPath() + InternalZipConstants.ZIP_FILE_SEPARATOR + linkFile.src).getBytes(StandardCharsets.UTF_8));
                    DirCacheEntry dirCacheEntry3 = new DirCacheEntry(linkFile.dest);
                    dirCacheEntry3.setObjectId(objectIdInsert2);
                    dirCacheEntry3.setFileMode(FileMode.SYMLINK);
                    dirCacheBuilderBuilder.add(dirCacheEntry3);
                }
            }
            sb = sb3;
        }
        String text = config.toText();
        DirCacheEntry dirCacheEntry4 = new DirCacheEntry(Constants.DOT_GIT_MODULES);
        dirCacheEntry4.setObjectId(objectInserter.insert(3, text.getBytes(StandardCharsets.UTF_8)));
        dirCacheEntry4.setFileMode(FileMode.REGULAR_FILE);
        dirCacheBuilderBuilder.add(dirCacheEntry4);
        if (this.config.recordSubmoduleLabels) {
            DirCacheEntry dirCacheEntry5 = new DirCacheEntry(Constants.DOT_GIT_ATTRIBUTES);
            dirCacheEntry5.setObjectId(objectInserter.insert(3, sb.toString().getBytes(StandardCharsets.UTF_8)));
            dirCacheEntry5.setFileMode(FileMode.REGULAR_FILE);
            dirCacheBuilderBuilder.add(dirCacheEntry5);
        }
        for (ExtraContent extraContent : this.extraContents) {
            DirCacheEntry dirCacheEntry6 = new DirCacheEntry(extraContent.path);
            dirCacheEntry6.setObjectId(objectInserter.insert(3, extraContent.content.getBytes(StandardCharsets.UTF_8)));
            dirCacheEntry6.setFileMode(FileMode.REGULAR_FILE);
            dirCacheBuilderBuilder.add(dirCacheEntry6);
        }
        dirCacheBuilderBuilder.finish();
    }

    private RevCommit commitTreeOnCurrentTip(ObjectInserter objectInserter, RevWalk revWalk, ObjectId objectId) throws ConcurrentRefUpdateException, IOException {
        ObjectId objectIdResolve = this.repo.resolve(this.targetBranch + "^{commit}");
        if (objectIdResolve != null && revWalk.parseCommit(objectIdResolve).getTree().getId().equals((AnyObjectId) objectId)) {
            return revWalk.parseCommit(objectIdResolve);
        }
        CommitBuilder commitBuilder = new CommitBuilder();
        commitBuilder.setTreeId(objectId);
        if (objectIdResolve != null) {
            commitBuilder.setParentIds(objectIdResolve);
        }
        commitBuilder.setAuthor(this.author);
        commitBuilder.setCommitter(this.author);
        commitBuilder.setMessage(RepoText.get().repoCommitMessage);
        ObjectId objectIdInsert = objectInserter.insert(commitBuilder);
        objectInserter.flush();
        RefUpdate refUpdateUpdateRef = this.repo.updateRef(this.targetBranch);
        refUpdateUpdateRef.setNewObjectId(objectIdInsert);
        if (objectIdResolve == null) {
            objectIdResolve = ObjectId.zeroId();
        }
        refUpdateUpdateRef.setExpectedOldObjectId(objectIdResolve);
        RefUpdate.Result resultUpdate = refUpdateUpdateRef.update(revWalk);
        int i = $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result()[resultUpdate.ordinal()];
        if (i != 2) {
            if (i == 4 || i == 5 || i == 6) {
                return revWalk.parseCommit(objectIdInsert);
            }
            if (i != 7) {
                throw new JGitInternalException(MessageFormat.format(JGitText.get().updatingRefFailed, this.targetBranch, objectIdInsert.name(), resultUpdate));
            }
        }
        throw new ConcurrentRefUpdateException(MessageFormat.format(JGitText.get().cannotLock, this.targetBranch), refUpdateUpdateRef.getRef(), resultUpdate);
    }
}
