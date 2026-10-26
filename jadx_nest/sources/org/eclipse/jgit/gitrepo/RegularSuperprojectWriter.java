package org.eclipse.jgit.gitrepo;

import java.io.IOException;
import java.util.List;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.SubmoduleAddCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.gitrepo.internal.RepoText;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;

/* INFO: loaded from: classes5.dex */
class RegularSuperprojectWriter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private ProgressMonitor monitor;
    private Repository repo;

    RegularSuperprojectWriter(Repository repository, ProgressMonitor progressMonitor) {
        this.repo = repository;
        this.monitor = progressMonitor;
    }

    RevCommit write(List<RepoProject> list) throws GitAPIException {
        Throwable th = null;
        try {
            Git git = new Git(this.repo);
            try {
                for (RepoProject repoProject : list) {
                    addSubmodule(repoProject.getName(), repoProject.getUrl(), repoProject.getPath(), repoProject.getRevision(), repoProject.getCopyFiles(), repoProject.getLinkFiles(), git);
                }
                return git.commit().setMessage(RepoText.get().repoCommitMessage).call();
            } finally {
                git.close();
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                try {
                    th.addSuppressed(th2);
                } catch (IOException e) {
                    throw new RepoCommand.ManifestErrorException(e);
                }
            }
            throw null;
        }
    }

    private void addSubmodule(String str, String str2, String str3, String str4, List<RepoProject.CopyFile> list, List<RepoProject.LinkFile> list2, Git git) throws Throwable {
        if (!list2.isEmpty()) {
            throw new UnsupportedOperationException(JGitText.get().nonBareLinkFilesNotSupported);
        }
        SubmoduleAddCommand uri = git.submoduleAdd().setName(str).setPath(str3).setURI(str2);
        ProgressMonitor progressMonitor = this.monitor;
        if (progressMonitor != null) {
            uri.setProgressMonitor(progressMonitor);
        }
        Repository repositoryCall = uri.call();
        if (str4 != null) {
            Throwable th = null;
            try {
                Git git2 = new Git(repositoryCall);
                try {
                    git2.checkout().setName(findRef(str4, repositoryCall)).call();
                    git2.close();
                    repositoryCall.close();
                    git.add().addFilepattern(str3).call();
                } catch (Throwable th2) {
                    git2.close();
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
        for (RepoProject.CopyFile copyFile : list) {
            copyFile.copy();
            git.add().addFilepattern(copyFile.dest).call();
        }
    }

    private static String findRef(String str, Repository repository) throws IOException {
        Ref refExactRef;
        return (ObjectId.isId(str) || (refExactRef = repository.exactRef(new StringBuilder("refs/remotes/origin/").append(str).toString())) == null) ? str : refExactRef.getName();
    }
}
