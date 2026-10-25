package org.apache.commons.io.filefilter;

import java.io.Serializable;
import java.nio.file.Path;
import java.util.function.Function;
import org.apache.commons.io.file.PathUtils;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class RegexFileFilter$$ExternalSyntheticLambda1 implements Function, Serializable {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return PathUtils.getFileNameString((Path) obj);
    }
}
