package org.eclipse.jgit.internal.diffmergetool;

import org.eclipse.jgit.lib.internal.BooleanTriState;

/* INFO: loaded from: classes5.dex */
public class UserDefinedMergeTool extends UserDefinedDiffTool implements ExternalMergeTool {
    private BooleanTriState trustExitCode;

    public UserDefinedMergeTool(String str, String str2, String str3, BooleanTriState booleanTriState) {
        super(str, str2, str3);
        this.trustExitCode = booleanTriState;
    }

    @Override // org.eclipse.jgit.internal.diffmergetool.ExternalMergeTool
    public BooleanTriState getTrustExitCode() {
        return this.trustExitCode;
    }

    protected void setTrustExitCode(BooleanTriState booleanTriState) {
        this.trustExitCode = booleanTriState;
    }

    public String getCommand(boolean z) {
        return getCommand();
    }
}
