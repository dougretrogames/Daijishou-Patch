package org.eclipse.jgit.gitrepo.internal;

import org.eclipse.jgit.nls.NLS;
import org.eclipse.jgit.nls.TranslationBundle;

/* JADX INFO: loaded from: classes5.dex */
public class RepoText extends TranslationBundle {
    public String errorIncludeFile;
    public String errorIncludeNotImplemented;
    public String errorNoDefault;
    public String errorNoDefaultFilename;
    public String errorNoFetch;
    public String errorParsingManifestFile;
    public String errorRemoteUnavailable;
    public String invalidManifest;
    public String repoCommitMessage;

    public static RepoText get() {
        return (RepoText) NLS.getBundleFor(RepoText.class);
    }
}
