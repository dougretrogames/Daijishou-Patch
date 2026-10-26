package org.eclipse.jgit.gitrepo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.lib.Repository;

/* INFO: loaded from: classes5.dex */
public class RepoProject implements Comparable<RepoProject> {
    private final List<CopyFile> copyfiles;
    private String defaultRevision;
    private String destBranch;
    private final Set<String> groups;
    private final List<LinkFile> linkfiles;
    private final String name;
    private final String path;
    private String recommendShallow;
    private final String remote;
    private final String revision;
    private String upstream;
    private String url;

    public static class ReferenceFile {
        final String dest;
        final String path;
        final Repository repo;
        final String src;

        public ReferenceFile(Repository repository, String str, String str2, String str3) {
            this.repo = repository;
            this.path = str;
            this.src = str2;
            this.dest = str3;
        }
    }

    public static class CopyFile extends ReferenceFile {
        public CopyFile(Repository repository, String str, String str2, String str3) {
            super(repository, str, str2, str3);
        }

        public void copy() throws IOException {
            File file = new File(this.repo.getWorkTree(), this.path + InternalZipConstants.ZIP_FILE_SEPARATOR + this.src);
            File file2 = new File(this.repo.getWorkTree(), this.dest);
            Throwable th = null;
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    try {
                        FileChannel channel = fileInputStream.getChannel();
                        fileOutputStream.getChannel().transferFrom(channel, 0L, channel.size());
                        fileOutputStream.close();
                        fileInputStream.close();
                        file2.setExecutable(file.canExecute());
                    } catch (Throwable th2) {
                        fileOutputStream.close();
                        throw th2;
                    }
                } catch (Throwable th3) {
                    if (0 == 0) {
                        th = th3;
                    } else if (null != th3) {
                        th.addSuppressed(th3);
                    }
                    fileInputStream.close();
                    throw th;
                }
            } catch (Throwable th4) {
                if (0 == 0) {
                    throw th4;
                }
                if (null != th4) {
                    th.addSuppressed(th4);
                }
                throw null;
            }
        }
    }

    public static class LinkFile extends ReferenceFile {
        public LinkFile(Repository repository, String str, String str2, String str3) {
            super(repository, str, str2, str3);
        }
    }

    public RepoProject(String str, String str2, String str3, String str4, Set<String> set, String str5) {
        str.getClass();
        this.name = str;
        if (str2 != null) {
            this.path = str2;
        } else {
            this.path = str;
        }
        this.revision = str3;
        this.remote = str4;
        this.groups = set;
        this.recommendShallow = str5;
        this.copyfiles = new ArrayList();
        this.linkfiles = new ArrayList();
    }

    public RepoProject(String str, String str2, String str3, String str4, String str5) {
        this(str, str2, str3, str4, new HashSet(), null);
        if (str5 == null || str5.length() <= 0) {
            return;
        }
        setGroups(str5);
    }

    public RepoProject setUrl(String str) {
        this.url = str;
        return this;
    }

    public RepoProject setGroups(String str) {
        this.groups.clear();
        this.groups.addAll(Arrays.asList(str.split(CollectionUtils.COMMA)));
        return this;
    }

    public RepoProject setDefaultRevision(String str) {
        this.defaultRevision = str;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public String getPath() {
        return this.path;
    }

    public String getRevision() {
        String str = this.revision;
        return str == null ? this.defaultRevision : str;
    }

    public List<CopyFile> getCopyFiles() {
        return Collections.unmodifiableList(this.copyfiles);
    }

    public List<LinkFile> getLinkFiles() {
        return Collections.unmodifiableList(this.linkfiles);
    }

    public String getUrl() {
        return this.url;
    }

    public String getRemote() {
        return this.remote;
    }

    public boolean inGroup(String str) {
        return this.groups.contains(str);
    }

    public Set<String> getGroups() {
        return this.groups;
    }

    public String getRecommendShallow() {
        return this.recommendShallow;
    }

    public void setRecommendShallow(String str) {
        this.recommendShallow = str;
    }

    public void addCopyFile(CopyFile copyFile) {
        this.copyfiles.add(copyFile);
    }

    public void addCopyFiles(Collection<CopyFile> collection) {
        this.copyfiles.addAll(collection);
    }

    public void clearCopyFiles() {
        this.copyfiles.clear();
    }

    public void addLinkFile(LinkFile linkFile) {
        this.linkfiles.add(linkFile);
    }

    public void addLinkFiles(Collection<LinkFile> collection) {
        this.linkfiles.addAll(collection);
    }

    public void clearLinkFiles() {
        this.linkfiles.clear();
    }

    public String getUpstream() {
        return this.upstream;
    }

    public String getDestBranch() {
        return this.destBranch;
    }

    public void setUpstream(String str) {
        this.upstream = str;
    }

    public void setDestBranch(String str) {
        this.destBranch = str;
    }

    private String getPathWithSlash() {
        if (this.path.endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            return this.path;
        }
        return this.path + InternalZipConstants.ZIP_FILE_SEPARATOR;
    }

    public boolean isAncestorOf(RepoProject repoProject) {
        return isAncestorOf(repoProject.getPathWithSlash());
    }

    public boolean isAncestorOf(String str) {
        return str.startsWith(getPathWithSlash());
    }

    public boolean equals(Object obj) {
        if (obj instanceof RepoProject) {
            return getPathWithSlash().equals(((RepoProject) obj).getPathWithSlash());
        }
        return false;
    }

    public int hashCode() {
        return getPathWithSlash().hashCode();
    }

    @Override // java.lang.Comparable
    public int compareTo(RepoProject repoProject) {
        return getPathWithSlash().compareTo(repoProject.getPathWithSlash());
    }
}
