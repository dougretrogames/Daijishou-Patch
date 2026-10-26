package org.eclipse.jgit.gitrepo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.TreeMap;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.GitCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.gitrepo.internal.RepoText;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.RefDatabase;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.util.FileUtils;

/* INFO: loaded from: classes5.dex */
public class RepoCommand extends GitCommand<RevCommit> {
    private static final String SLASH = "/";
    private PersonIdent author;
    private BareSuperprojectWriter.BareWriterConfig bareWriterConfig;
    private String baseUri;
    private String branch;
    private RemoteReader callback;
    private final List<BareSuperprojectWriter.ExtraContent> extraContents;
    private String groupsParam;
    private ManifestParser.IncludedFileReader includedReader;
    private InputStream inputStream;
    private String manifestPath;
    private ProgressMonitor monitor;
    private String targetBranch;
    private URI targetUri;

    public interface RemoteReader {
        RemoteFile readFileWithMode(String str, String str2, String str3) throws GitAPIException, IOException;

        @Nullable
        ObjectId sha1(String str, String str2) throws GitAPIException;
    }

    public static final class RemoteFile {
        private final byte[] contents;
        private final FileMode fileMode;

        public RemoteFile(byte[] bArr, FileMode fileMode) {
            this.contents = (byte[]) Objects.requireNonNull(bArr);
            this.fileMode = (FileMode) Objects.requireNonNull(fileMode);
        }

        public byte[] getContents() {
            return this.contents;
        }

        public FileMode getFileMode() {
            return this.fileMode;
        }
    }

    public static class DefaultRemoteReader implements RemoteReader {
        @Override // org.eclipse.jgit.gitrepo.RepoCommand.RemoteReader
        public ObjectId sha1(String str, String str2) throws GitAPIException {
            Ref refFindRef = RefDatabase.findRef(Git.lsRemoteRepository().setRemote(str).callAsMap(), str2);
            if (refFindRef != null) {
                return refFindRef.getObjectId();
            }
            return null;
        }

        @Override // org.eclipse.jgit.gitrepo.RepoCommand.RemoteReader
        public RemoteFile readFileWithMode(String str, String str2, String str3) throws GitAPIException, IOException {
            Throwable th = null;
            File fileCreateTempDir = FileUtils.createTempDir("jgit_", ".git", null);
            try {
                Git gitCall = Git.cloneRepository().setBare(true).setDirectory(fileCreateTempDir).setURI(str).call();
                try {
                    Repository repository = gitCall.getRepository();
                    ObjectId objectIdSha1 = sha1(str, str2);
                    if (objectIdSha1 == null) {
                        throw new InvalidRefNameException(MessageFormat.format(JGitText.get().refNotResolved, str2));
                    }
                    TreeWalk treeWalkForPath = TreeWalk.forPath(repository, str3, repository.parseCommit(objectIdSha1).getTree());
                    RemoteFile remoteFile = new RemoteFile(treeWalkForPath.getObjectReader().open(treeWalkForPath.getObjectId(0)).getCachedBytes(Integer.MAX_VALUE), treeWalkForPath.getFileMode(0));
                    if (gitCall != null) {
                        gitCall.close();
                    }
                    FileUtils.delete(fileCreateTempDir, 1);
                    return remoteFile;
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
                    try {
                        th.addSuppressed(th3);
                    } catch (Throwable th4) {
                        FileUtils.delete(fileCreateTempDir, 1);
                        throw th4;
                    }
                }
                throw null;
            }
        }
    }

    static class ManifestErrorException extends GitAPIException {
        ManifestErrorException(Throwable th) {
            super(RepoText.get().invalidManifest + " " + th.getMessage(), th);
        }
    }

    static class RemoteUnavailableException extends GitAPIException {
        RemoteUnavailableException(String str) {
            super(MessageFormat.format(RepoText.get().errorRemoteUnavailable, str));
        }
    }

    public RepoCommand(Repository repository) {
        super(repository);
        this.targetBranch = "HEAD";
        this.bareWriterConfig = BareSuperprojectWriter.BareWriterConfig.getDefault();
        this.extraContents = new ArrayList();
    }

    public RepoCommand setPath(String str) {
        this.manifestPath = str;
        return this;
    }

    public RepoCommand setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
        return this;
    }

    public RepoCommand setURI(String str) {
        this.baseUri = str;
        return this;
    }

    public RepoCommand setTargetURI(String str) {
        this.targetUri = URI.create(str + "/");
        return this;
    }

    public RepoCommand setGroups(String str) {
        this.groupsParam = str;
        return this;
    }

    public RepoCommand setBranch(String str) {
        this.branch = str;
        return this;
    }

    public RepoCommand setTargetBranch(String str) {
        this.targetBranch = Constants.R_HEADS + str;
        return this;
    }

    public RepoCommand setRecordRemoteBranch(boolean z) {
        this.bareWriterConfig.recordRemoteBranch = z;
        return this;
    }

    public RepoCommand setRecordSubmoduleLabels(boolean z) {
        this.bareWriterConfig.recordSubmoduleLabels = z;
        return this;
    }

    public RepoCommand setRecommendShallow(boolean z) {
        this.bareWriterConfig.recordShallowSubmodules = z;
        return this;
    }

    public RepoCommand setProgressMonitor(ProgressMonitor progressMonitor) {
        this.monitor = progressMonitor;
        return this;
    }

    public RepoCommand setIgnoreRemoteFailures(boolean z) {
        this.bareWriterConfig.ignoreRemoteFailures = z;
        return this;
    }

    public RepoCommand setAuthor(PersonIdent personIdent) {
        this.author = personIdent;
        return this;
    }

    public RepoCommand setRemoteReader(RemoteReader remoteReader) {
        this.callback = remoteReader;
        return this;
    }

    public RepoCommand setIncludedFileReader(ManifestParser.IncludedFileReader includedFileReader) {
        this.includedReader = includedFileReader;
        return this;
    }

    public RepoCommand addToDestination(String str, String str2) {
        this.extraContents.add(new BareSuperprojectWriter.ExtraContent(str, str2));
        return this;
    }

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public RevCommit call() throws GitAPIException {
        checkCallable();
        if (this.baseUri == null) {
            this.baseUri = "";
        }
        if (this.inputStream == null) {
            String str = this.manifestPath;
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException(JGitText.get().pathNotConfigured);
            }
            try {
                this.inputStream = new FileInputStream(this.manifestPath);
            } catch (IOException e) {
                throw new IllegalArgumentException(JGitText.get().pathNotConfigured, e);
            }
        }
        try {
            try {
                ManifestParser manifestParser = new ManifestParser(this.includedReader, this.manifestPath, this.branch, this.baseUri, this.groupsParam, this.repo);
                manifestParser.read(this.inputStream);
                List<RepoProject> filteredProjects = manifestParser.getFilteredProjects();
                try {
                    this.inputStream.close();
                } catch (IOException unused) {
                }
                if (this.repo.isBare()) {
                    List<RepoProject> listRenameProjects = renameProjects(filteredProjects);
                    Repository repository = this.repo;
                    URI uri = this.targetUri;
                    String str2 = this.targetBranch;
                    PersonIdent personIdent = this.author;
                    if (personIdent == null) {
                        personIdent = new PersonIdent(this.repo);
                    }
                    RemoteReader defaultRemoteReader = this.callback;
                    if (defaultRemoteReader == null) {
                        defaultRemoteReader = new DefaultRemoteReader();
                    }
                    return new BareSuperprojectWriter(repository, uri, str2, personIdent, defaultRemoteReader, this.bareWriterConfig, this.extraContents).write(listRenameProjects);
                }
                return new RegularSuperprojectWriter(this.repo, this.monitor).write(filteredProjects);
            } catch (IOException e2) {
                throw new ManifestErrorException(e2);
            }
        } catch (Throwable th) {
            try {
                this.inputStream.close();
            } catch (IOException unused2) {
            }
            throw th;
        }
    }

    private List<RepoProject> renameProjects(List<RepoProject> list) {
        TreeMap treeMap = new TreeMap();
        for (RepoProject repoProject : list) {
            List arrayList = (List) treeMap.get(repoProject.getName());
            if (arrayList == null) {
                arrayList = new ArrayList();
                treeMap.put(repoProject.getName(), arrayList);
            }
            arrayList.add(repoProject);
        }
        ArrayList arrayList2 = new ArrayList();
        for (List<RepoProject> list2 : treeMap.values()) {
            boolean z = list2.size() != 1;
            for (RepoProject repoProject2 : list2) {
                String name = repoProject2.getName();
                if (z) {
                    name = name + "/" + repoProject2.getPath();
                }
                RepoProject repoProject3 = new RepoProject(name, repoProject2.getPath(), repoProject2.getRevision(), null, repoProject2.getGroups(), repoProject2.getRecommendShallow());
                repoProject3.setUrl(repoProject2.getUrl());
                repoProject3.addCopyFiles(repoProject2.getCopyFiles());
                repoProject3.addLinkFiles(repoProject2.getLinkFiles());
                repoProject3.setUpstream(repoProject2.getUpstream());
                arrayList2.add(repoProject3);
            }
        }
        return arrayList2;
    }

    static URI relativize(URI uri, URI uri2) {
        String strSubstring;
        if (Objects.equals(uri.getHost(), uri2.getHost())) {
            String path = uri.normalize().getPath();
            String path2 = uri2.normalize().getPath();
            if (path.startsWith("/") == path2.startsWith("/")) {
                while (path.startsWith("/")) {
                    path = path.substring(1);
                }
                while (path2.startsWith("/")) {
                    path2 = path2.substring(1);
                }
                if (path.indexOf(47) == -1 || path2.indexOf(47) == -1) {
                    path = "prefix/" + path;
                    path2 = "prefix/" + path2;
                }
                int i = 0;
                if (!path.endsWith("/")) {
                    path = path.substring(0, path.lastIndexOf(47));
                }
                if (path2.endsWith("/")) {
                    strSubstring = "";
                } else {
                    strSubstring = path2.substring(path2.lastIndexOf(47) + 1, path2.length());
                    path2 = path2.substring(0, path2.lastIndexOf(47));
                }
                String str = strSubstring;
                String[] strArrSplit = path.split("/");
                String[] strArrSplit2 = path2.split("/");
                while (i < strArrSplit.length && i < strArrSplit2.length && strArrSplit[i].equals(strArrSplit2[i])) {
                    i++;
                }
                StringJoiner stringJoiner = new StringJoiner("/");
                for (int i2 = i; i2 < strArrSplit.length; i2++) {
                    stringJoiner.add("..");
                }
                while (i < strArrSplit2.length) {
                    stringJoiner.add(strArrSplit2[i]);
                    i++;
                }
                stringJoiner.add(str);
                return URI.create(stringJoiner.toString());
            }
        }
        return uri2;
    }
}
