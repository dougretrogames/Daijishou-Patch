package org.apache.commons.io.filefilter;

import java.nio.file.Path;
import java.util.function.Predicate;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.file.PathUtils;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class WildcardFilter$$ExternalSyntheticLambda2 implements Predicate {
    public final /* synthetic */ Path f$0;

    public /* synthetic */ WildcardFilter$$ExternalSyntheticLambda2(Path path) {
        this.f$0 = path;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return FilenameUtils.wildcardMatch(PathUtils.getFileNameString(this.f$0), (String) obj);
    }
}
