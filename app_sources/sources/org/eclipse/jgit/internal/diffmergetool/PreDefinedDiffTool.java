package org.eclipse.jgit.internal.diffmergetool;

/* INFO: loaded from: classes5.dex */
public class PreDefinedDiffTool extends UserDefinedDiffTool {
    public PreDefinedDiffTool(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    public PreDefinedDiffTool(CommandLineDiffTool commandLineDiffTool) {
        this(commandLineDiffTool.name(), commandLineDiffTool.getPath(), commandLineDiffTool.getParameters());
    }

    @Override // org.eclipse.jgit.internal.diffmergetool.UserDefinedDiffTool
    public void setPath(String str) {
        super.setPath(str);
    }

    @Override // org.eclipse.jgit.internal.diffmergetool.UserDefinedDiffTool, org.eclipse.jgit.internal.diffmergetool.ExternalDiffTool
    public String getCommand() {
        return ExternalToolUtils.quotePath(getPath()) + " " + super.getCommand();
    }
}
