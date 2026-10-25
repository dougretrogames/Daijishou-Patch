package org.eclipse.jgit.internal.diffmergetool;

/* JADX INFO: loaded from: classes5.dex */
public enum CommandLineDiffTool {
    araxis("compare", "-wait -2 \"$LOCAL\" \"$REMOTE\""),
    bc("bcomp", "\"$LOCAL\" \"$REMOTE\""),
    bc3("bcompare", bc),
    codecompare("CodeCompare", "\"$LOCAL\" \"$REMOTE\""),
    deltawalker("DeltaWalker", "\"$LOCAL\" \"$REMOTE\""),
    diffmerge("diffmerge", "\"$LOCAL\" \"$REMOTE\""),
    diffuse("diffuse", "\"$LOCAL\" \"$REMOTE\""),
    ecmerge("ecmerge", "--default --mode=diff2 \"$LOCAL\" \"$REMOTE\""),
    emerge("emacs", "-f emerge-files-command \"$LOCAL\" \"$REMOTE\""),
    examdiff("ExamDiff", "\"$LOCAL\" \"$REMOTE\" -nh"),
    guiffy("guiffy", "\"$LOCAL\" \"$REMOTE\""),
    gvimdiff("gvimdiff", "\"$LOCAL\" \"$REMOTE\""),
    gvimdiff2(gvimdiff),
    gvimdiff3(gvimdiff),
    kdiff3("kdiff3", "--L1 \"$MERGED (A)\" --L2 \"$MERGED (B)\" \"$LOCAL\" \"$REMOTE\""),
    kompare("kompare", "\"$LOCAL\" \"$REMOTE\""),
    meld("meld", "\"$LOCAL\" \"$REMOTE\""),
    opendiff("opendiff", "\"$LOCAL\" \"$REMOTE\""),
    p4merge("p4merge", "\"$LOCAL\" \"$REMOTE\""),
    tkdiff("tkdiff", "\"$LOCAL\" \"$REMOTE\""),
    vimdiff("vimdiff", gvimdiff),
    vimdiff2(vimdiff),
    vimdiff3(vimdiff),
    winmerge("WinMergeU", "-u -e \"$LOCAL\" \"$REMOTE\""),
    xxdiff("xxdiff", "-R 'Accel.Search: \"Ctrl+F\"' -R 'Accel.SearchForward: \"Ctrl+G\"' \"$LOCAL\" \"$REMOTE\"");

    private final String parameters;
    private final String path;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static CommandLineDiffTool[] valuesCustom() {
        CommandLineDiffTool[] commandLineDiffToolArrValuesCustom = values();
        int length = commandLineDiffToolArrValuesCustom.length;
        CommandLineDiffTool[] commandLineDiffToolArr = new CommandLineDiffTool[length];
        System.arraycopy(commandLineDiffToolArrValuesCustom, 0, commandLineDiffToolArr, 0, length);
        return commandLineDiffToolArr;
    }

    CommandLineDiffTool(String str, String str2) {
        this.path = str;
        this.parameters = str2;
    }

    CommandLineDiffTool(CommandLineDiffTool commandLineDiffTool) {
        this(commandLineDiffTool.getPath(), commandLineDiffTool.getParameters());
    }

    CommandLineDiffTool(String str, CommandLineDiffTool commandLineDiffTool) {
        this(str, commandLineDiffTool.getParameters());
    }

    public String getPath() {
        return this.path;
    }

    public String getParameters() {
        return this.parameters;
    }
}
