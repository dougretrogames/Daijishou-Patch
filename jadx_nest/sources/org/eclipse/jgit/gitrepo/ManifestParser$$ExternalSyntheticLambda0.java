package org.eclipse.jgit.gitrepo;

import java.util.function.Predicate;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class ManifestParser$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ String f$0;

    public /* synthetic */ ManifestParser$$ExternalSyntheticLambda0(String str) {
        this.f$0 = str;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return ((RepoProject) obj).getName().equals(this.f$0);
    }
}
