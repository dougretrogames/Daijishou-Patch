package org.eclipse.jgit.internal.diffmergetool;

import org.eclipse.jgit.lib.internal.BooleanTriState;

/* JADX INFO: loaded from: classes5.dex */
public interface ExternalMergeTool extends ExternalDiffTool {
    String getCommand(boolean z);

    BooleanTriState getTrustExitCode();
}
