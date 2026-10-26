package org.eclipse.jgit.gitrepo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.gitrepo.internal.RepoText;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Repository;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/* INFO: loaded from: classes5.dex */
public class ManifestParser extends DefaultHandler {
    private final URI baseUrl;
    private RepoProject currentProject;
    private final String defaultBranch;
    private String defaultRemote;
    private String defaultRevision;
    private final String filename;
    private final List<RepoProject> filteredProjects;
    private final IncludedFileReader includedReader;
    private final Set<String> minusGroups;
    private final Set<String> plusGroups = new HashSet();
    private final List<RepoProject> projects;
    private final Map<String, Remote> remotes;
    private final Repository rootRepo;
    private int xmlInRead;

    public interface IncludedFileReader {
        InputStream readIncludeFile(String str) throws GitAPIException, IOException;
    }

    public ManifestParser(IncludedFileReader includedFileReader, String str, String str2, String str3, String str4, Repository repository) {
        this.includedReader = includedFileReader;
        this.filename = str;
        this.defaultBranch = str2;
        this.rootRepo = repository;
        this.baseUrl = normalizeEmptyPath(URI.create(str3));
        HashSet hashSet = new HashSet();
        this.minusGroups = hashSet;
        if (str4 == null || str4.length() == 0 || str4.equals("default")) {
            hashSet.add("notdefault");
        } else {
            for (String str5 : str4.split(CollectionUtils.COMMA)) {
                if (str5.startsWith("-")) {
                    this.minusGroups.add(str5.substring(1));
                } else {
                    this.plusGroups.add(str5);
                }
            }
        }
        this.remotes = new HashMap();
        this.projects = new ArrayList();
        this.filteredProjects = new ArrayList();
    }

    public void read(InputStream inputStream) throws IOException {
        this.xmlInRead++;
        try {
            XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            xMLReader.setContentHandler(this);
            try {
                xMLReader.parse(new InputSource(inputStream));
            } catch (SAXException e) {
                throw new IOException(RepoText.get().errorParsingManifestFile, e);
            }
        } catch (ParserConfigurationException | SAXException e2) {
            throw new IOException(JGitText.get().noXMLParserAvailable, e2);
        }
    }

    /* WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        if (str3 == null) {
            return;
        }
        switch (str3.hashCode()) {
            case -934610874:
                if (str3.equals("remote")) {
                    String value = attributes.getValue("alias");
                    Remote remote = new Remote(attributes.getValue("fetch"), attributes.getValue("revision"));
                    this.remotes.put(attributes.getValue("name"), remote);
                    if (value != null) {
                        this.remotes.put(value, remote);
                        return;
                    }
                    return;
                }
                return;
            case -851352880:
                if (str3.equals("remove-project")) {
                    this.projects.removeIf(new ManifestParser$$ExternalSyntheticLambda0(attributes.getValue("name")));
                    return;
                }
                return;
            case -505421199:
                if (str3.equals("copyfile")) {
                    RepoProject repoProject = this.currentProject;
                    if (repoProject == null) {
                        throw new SAXException(RepoText.get().invalidManifest);
                    }
                    repoProject.addCopyFile(new RepoProject.CopyFile(this.rootRepo, this.currentProject.getPath(), attributes.getValue("src"), attributes.getValue("dest")));
                    return;
                }
                return;
            case -309310695:
                if (str3.equals("project")) {
                    if (attributes.getValue("name") == null) {
                        throw new SAXException(RepoText.get().invalidManifest);
                    }
                    RepoProject repoProject2 = new RepoProject(attributes.getValue("name"), attributes.getValue("path"), attributes.getValue("revision"), attributes.getValue("remote"), attributes.getValue("groups"));
                    this.currentProject = repoProject2;
                    repoProject2.setRecommendShallow(attributes.getValue("clone-depth"));
                    this.currentProject.setUpstream(attributes.getValue("upstream"));
                    this.currentProject.setDestBranch(attributes.getValue("dest-branch"));
                    return;
                }
                return;
            case 1194727542:
                if (str3.equals("linkfile")) {
                    RepoProject repoProject3 = this.currentProject;
                    if (repoProject3 == null) {
                        throw new SAXException(RepoText.get().invalidManifest);
                    }
                    repoProject3.addLinkFile(new RepoProject.LinkFile(this.rootRepo, this.currentProject.getPath(), attributes.getValue("src"), attributes.getValue("dest")));
                    return;
                }
                return;
            case 1544803905:
                if (str3.equals("default")) {
                    this.defaultRemote = attributes.getValue("remote");
                    this.defaultRevision = attributes.getValue("revision");
                    return;
                }
                return;
            case 1942574248:
                if (str3.equals("include")) {
                    String value2 = attributes.getValue("name");
                    IncludedFileReader includedFileReader = this.includedReader;
                    Throwable th = null;
                    if (includedFileReader != null) {
                        try {
                            InputStream includeFile = includedFileReader.readIncludeFile(value2);
                            try {
                                if (includeFile == null) {
                                    throw new SAXException(RepoText.get().errorIncludeNotImplemented);
                                }
                                read(includeFile);
                                if (includeFile != null) {
                                    includeFile.close();
                                    return;
                                }
                                return;
                            } catch (Throwable th2) {
                                if (includeFile == null) {
                                    throw th2;
                                }
                                includeFile.close();
                                throw th2;
                            }
                        } catch (Throwable th3) {
                            if (0 == 0) {
                                throw th3;
                            }
                            if (null != th3) {
                                try {
                                    th.addSuppressed(th3);
                                } catch (Exception e) {
                                    throw new SAXException(MessageFormat.format(RepoText.get().errorIncludeFile, value2), e);
                                }
                            }
                            throw null;
                        }
                    } else {
                        String str4 = this.filename;
                        if (str4 != null) {
                            String str5 = this.filename.substring(0, str4.lastIndexOf(47) + 1) + value2;
                            try {
                                FileInputStream fileInputStream = new FileInputStream(str5);
                                try {
                                    read(fileInputStream);
                                    return;
                                } finally {
                                    fileInputStream.close();
                                }
                            } catch (Throwable th4) {
                                if (0 == 0) {
                                    throw th4;
                                }
                                if (null != th4) {
                                    try {
                                        th.addSuppressed(th4);
                                    } catch (IOException e2) {
                                        throw new SAXException(MessageFormat.format(RepoText.get().errorIncludeFile, str5), e2);
                                    }
                                }
                                throw null;
                            }
                        } else {
                            return;
                        }
                    }
                } else {
                    return;
                }
                break;
            default:
                return;
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        if ("project".equals(str3)) {
            this.projects.add(this.currentProject);
            this.currentProject = null;
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endDocument() throws SAXException {
        String str;
        int i = this.xmlInRead - 1;
        this.xmlInRead = i;
        if (i != 0) {
            return;
        }
        HashMap map = new HashMap();
        if (this.defaultRevision == null && (str = this.defaultRemote) != null) {
            Remote remote = this.remotes.get(str);
            if (remote != null) {
                this.defaultRevision = remote.revision;
            }
            if (this.defaultRevision == null) {
                this.defaultRevision = this.defaultBranch;
            }
        }
        for (RepoProject repoProject : this.projects) {
            String remote2 = repoProject.getRemote();
            String str2 = this.defaultRevision;
            if (remote2 == null) {
                remote2 = this.defaultRemote;
                if (remote2 == null) {
                    if (this.filename != null) {
                        throw new SAXException(MessageFormat.format(RepoText.get().errorNoDefaultFilename, this.filename));
                    }
                    throw new SAXException(RepoText.get().errorNoDefault);
                }
            } else {
                Remote remote3 = this.remotes.get(remote2);
                if (remote3 != null && remote3.revision != null) {
                    str2 = remote3.revision;
                }
            }
            URI uriNormalizeEmptyPath = (URI) map.get(remote2);
            if (uriNormalizeEmptyPath == null) {
                String str3 = this.remotes.get(remote2).fetch;
                if (str3 == null) {
                    throw new SAXException(MessageFormat.format(RepoText.get().errorNoFetch, remote2));
                }
                uriNormalizeEmptyPath = normalizeEmptyPath(this.baseUrl.resolve(str3));
                map.put(remote2, uriNormalizeEmptyPath);
            }
            repoProject.setUrl(uriNormalizeEmptyPath.resolve(repoProject.getName()).toString()).setDefaultRevision(str2);
        }
        this.filteredProjects.addAll(this.projects);
        removeNotInGroup();
        removeOverlaps();
    }

    static URI normalizeEmptyPath(URI uri) {
        if (uri.getHost() == null || uri.getHost().isEmpty() || !(uri.getPath() == null || uri.getPath().isEmpty())) {
            return uri;
        }
        try {
            return new URI(uri.getScheme(), uri.getUserInfo(), uri.getHost(), uri.getPort(), InternalZipConstants.ZIP_FILE_SEPARATOR, uri.getQuery(), uri.getFragment());
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public List<RepoProject> getProjects() {
        return this.projects;
    }

    public List<RepoProject> getFilteredProjects() {
        return this.filteredProjects;
    }

    void removeNotInGroup() {
        Iterator<RepoProject> it = this.filteredProjects.iterator();
        while (it.hasNext()) {
            if (!inGroups(it.next())) {
                it.remove();
            }
        }
    }

    void removeOverlaps() {
        Collections.sort(this.filteredProjects);
        Iterator<RepoProject> it = this.filteredProjects.iterator();
        if (it.hasNext()) {
            RepoProject next = it.next();
            while (it.hasNext()) {
                RepoProject next2 = it.next();
                if (next.isAncestorOf(next2)) {
                    it.remove();
                } else {
                    next = next2;
                }
            }
            removeNestedCopyAndLinkfiles();
        }
    }

    private void removeNestedCopyAndLinkfiles() {
        for (RepoProject repoProject : this.filteredProjects) {
            ArrayList<RepoProject.CopyFile> arrayList = new ArrayList(repoProject.getCopyFiles());
            repoProject.clearCopyFiles();
            for (RepoProject.CopyFile copyFile : arrayList) {
                if (!isNestedReferencefile(copyFile)) {
                    repoProject.addCopyFile(copyFile);
                }
            }
            ArrayList<RepoProject.LinkFile> arrayList2 = new ArrayList(repoProject.getLinkFiles());
            repoProject.clearLinkFiles();
            for (RepoProject.LinkFile linkFile : arrayList2) {
                if (!isNestedReferencefile(linkFile)) {
                    repoProject.addLinkFile(linkFile);
                }
            }
        }
    }

    boolean inGroups(RepoProject repoProject) {
        Iterator<String> it = this.minusGroups.iterator();
        while (it.hasNext()) {
            if (repoProject.inGroup(it.next())) {
                return false;
            }
        }
        if (!this.plusGroups.isEmpty() && !this.plusGroups.contains("all")) {
            Iterator<String> it2 = this.plusGroups.iterator();
            while (it2.hasNext()) {
                if (repoProject.inGroup(it2.next())) {
                }
            }
            return false;
        }
        return true;
    }

    private boolean isNestedReferencefile(RepoProject.ReferenceFile referenceFile) {
        if (referenceFile.dest.indexOf(47) == -1) {
            return false;
        }
        for (RepoProject repoProject : this.filteredProjects) {
            if (repoProject.getPath().compareTo(referenceFile.dest) > 0) {
                return false;
            }
            if (repoProject.isAncestorOf(referenceFile.dest)) {
                return true;
            }
        }
        return false;
    }

    private static class Remote {
        final String fetch;
        final String revision;

        Remote(String str, String str2) {
            this.fetch = str;
            this.revision = str2;
        }
    }
}
