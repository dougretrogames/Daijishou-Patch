package org.eclipse.jgit.internal.diffmergetool;

import org.eclipse.jgit.lib.internal.BooleanTriState;

/* JADX INFO: loaded from: classes5.dex */
public class PreDefinedMergeTool extends UserDefinedMergeTool {
    private final String parametersWithoutBase;

    public PreDefinedMergeTool(String str, String str2, String str3, String str4, BooleanTriState booleanTriState) {
        super(str, str2, str3, booleanTriState);
        this.parametersWithoutBase = str4;
    }

    public PreDefinedMergeTool(CommandLineMergeTool commandLineMergeTool) {
        this(commandLineMergeTool.name(), commandLineMergeTool.getPath(), commandLineMergeTool.getParameters(true), commandLineMergeTool.getParameters(false), commandLineMergeTool.isExitCodeTrustable() ? BooleanTriState.TRUE : BooleanTriState.FALSE);
    }

    @Override // org.eclipse.jgit.internal.diffmergetool.UserDefinedMergeTool
    public void setTrustExitCode(BooleanTriState booleanTriState) {
        super.setTrustExitCode(booleanTriState);
    }

    @Override // org.eclipse.jgit.internal.diffmergetool.UserDefinedDiffTool, org.eclipse.jgit.internal.diffmergetool.ExternalDiffTool
    public String getCommand() {
        return getCommand(true);
    }

    @Override // org.eclipse.jgit.internal.diffmergetool.UserDefinedMergeTool, org.eclipse.jgit.internal.diffmergetool.ExternalMergeTool
    public String getCommand(boolean z) {
        return ExternalToolUtils.quotePath(getPath()) + " " + (z ? super.getCommand() : this.parametersWithoutBase);
    }
}
