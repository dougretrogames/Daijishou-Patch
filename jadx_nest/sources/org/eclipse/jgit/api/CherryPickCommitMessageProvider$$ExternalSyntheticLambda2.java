package org.eclipse.jgit.api;

import java.util.function.ToIntFunction;
import org.eclipse.jgit.revwalk.FooterLine;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class CherryPickCommitMessageProvider$$ExternalSyntheticLambda2 implements ToIntFunction {
    @Override // java.util.function.ToIntFunction
    public final int applyAsInt(Object obj) {
        return ((FooterLine) obj).getEndOffset();
    }
}
