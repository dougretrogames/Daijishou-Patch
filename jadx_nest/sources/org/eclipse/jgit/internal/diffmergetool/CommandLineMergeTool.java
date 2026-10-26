package org.eclipse.jgit.internal.diffmergetool;

/* INFO: loaded from: classes5.dex */
public enum CommandLineMergeTool {
    araxis("compare", "-wait -merge -3 -a1 \"$BASE\" \"$LOCAL\" \"$REMOTE\" \"$MERGED\"", "-wait -2 \"$LOCAL\" \"$REMOTE\" \"$MERGED\"", false),
    bc("bcomp", "\"$LOCAL\" \"$REMOTE\" \"$BASE\" --mergeoutput=\"$MERGED\"", "\"$LOCAL\" \"$REMOTE\" --mergeoutput=\"$MERGED\"", false),
    bc3("bcompare", bc),
    codecompare("CodeMerge", "-MF=\"$LOCAL\" -TF=\"$REMOTE\" -BF=\"$BASE\" -RF=\"$MERGED\"", "-MF=\"$LOCAL\" -TF=\"$REMOTE\" -RF=\"$MERGED\"", false),
    deltawalker("DeltaWalker", "\"$LOCAL\" \"$REMOTE\" \"$BASE\" -pwd=\"$(pwd)\" -merged=\"$MERGED\"", "\"$LOCAL\" \"$REMOTE\" -pwd=\"$(pwd)\" -merged=\"$MERGED\"", true),
    diffmerge("diffmerge", "--merge --result=\"$MERGED\" \"$LOCAL\" \"$BASE\" \"$REMOTE\"", "--merge --result=\"$MERGED\" \"$LOCAL\" \"$REMOTE\"", true),
    diffuse("diffuse", "\"$LOCAL\" \"$MERGED\" \"$REMOTE\" \"$BASE\"", "\"$LOCAL\" \"$MERGED\" \"$REMOTE\"", false),
    ecmerge("ecmerge", "--default --mode=merge3 \"$BASE\" \"$LOCAL\" \"$REMOTE\" --to=\"$MERGED\"", "--default --mode=merge2 \"$LOCAL\" \"$REMOTE\" --to=\"$MERGED\"", false),
    emerge("emacs", "-f emerge-files-with-ancestor-command \"$LOCAL\" \"$REMOTE\" \"$BASE\" \"$(basename \"$MERGED\")\"", "-f emerge-files-command \"$LOCAL\" \"$REMOTE\" \"$(basename \"$MERGED\")\"", true),
    examdiff("ExamDiff", "-merge \"$LOCAL\" \"$BASE\" \"$REMOTE\" -o:\"$MERGED\" -nh", "-merge \"$LOCAL\" \"$REMOTE\" -o:\"$MERGED\" -nh", false),
    guiffy("guiffy", "-s \"$LOCAL\" \"$REMOTE\" \"$BASE\" \"$MERGED\"", "-m \"$LOCAL\" \"$REMOTE\" \"$MERGED\"", true),
    gvimdiff("gvim", "-f -d -c '4wincmd w | wincmd J' \"$LOCAL\" \"$BASE\" \"$REMOTE\" \"$MERGED\"", "-f -d -c 'wincmd l' \"$LOCAL\" \"$MERGED\" \"$REMOTE\"", true),
    gvimdiff2("gvim", "-f -d -c 'wincmd l' \"$LOCAL\" \"$MERGED\" \"$REMOTE\"", "-f -d -c 'wincmd l' \"$LOCAL\" \"$MERGED\" \"$REMOTE\"", true),
    gvimdiff3("gvim", "-f -d -c 'hid | hid | hid' \"$LOCAL\" \"$REMOTE\" \"$BASE\" \"$MERGED\"", "-f -d -c 'hid | hid' \"$LOCAL\" \"$REMOTE\" \"$MERGED\"", true),
    kdiff3("kdiff3", "--auto --L1 \"$MERGED (Base)\" --L2 \"$MERGED (Local)\" --L3 \"$MERGED (Remote)\" -o \"$MERGED\" \"$BASE\" \"$LOCAL\" \"$REMOTE\"", "--auto --L1 \"$MERGED (Local)\" --L2 \"$MERGED (Remote)\" -o \"$MERGED\" \"$LOCAL\" \"$REMOTE\"", true),
    meld("meld", "--output=\"$MERGED\" \"$LOCAL\" \"$BASE\" \"$REMOTE\"", "\"$LOCAL\" \"$MERGED\" \"$REMOTE\"", false),
    opendiff("opendiff", "\"$LOCAL\" \"$REMOTE\" -ancestor \"$BASE\" -merge \"$MERGED\"", "\"$LOCAL\" \"$REMOTE\" -merge \"$MERGED\"", false),
    p4merge("p4merge", "\"$BASE\" \"$REMOTE\" \"$LOCAL\" \"$MERGED\"", "\"$REMOTE\" \"$LOCAL\" \"$MERGED\"", false),
    tkdiff("tkdiff", "-a \"$BASE\" -o \"$MERGED\" \"$LOCAL\" \"$REMOTE\"", "-o \"$MERGED\" \"$LOCAL\" \"$REMOTE\"", true),
    tortoisegitmerge("tortoisegitmerge", "-base \"$BASE\" -mine \"$LOCAL\" -theirs \"$REMOTE\" -merged \"$MERGED\"", null, false),
    tortoisemerge("tortoisemerge", "-base:\"$BASE\" -mine:\"$LOCAL\" -theirs:\"$REMOTE\" -merged:\"$MERGED\"", null, false),
    vimdiff("vim", gvimdiff),
    vimdiff2("vim", gvimdiff2),
    vimdiff3("vim", gvimdiff3),
    winmerge("WinMergeU", "-u -e -dl Local -dr Remote \"$LOCAL\" \"$REMOTE\" \"$MERGED\"", "-u -e -dl Local -dr Remote \"$LOCAL\" \"$REMOTE\" \"$MERGED\"", false),
    xxdiff("xxdiff", "-X --show-merged-pane -R 'Accel.SaveAsMerged: \"Ctrl+S\"' -R 'Accel.Search: \"Ctrl+F\"' -R 'Accel.SearchForward: \"Ctrl+G\"' --merged-file \"$MERGED\" \"$LOCAL\" \"$BASE\" \"$REMOTE\"", "-X -R 'Accel.SaveAsMerged: \"Ctrl+S\"' -R 'Accel.Search: \"Ctrl+F\"' -R 'Accel.SearchForward: \"Ctrl+G\"' --merged-file \"$MERGED\" \"$LOCAL\" \"$REMOTE\"", false);

    private final boolean exitCodeTrustable;
    private final String parametersWithBase;
    private final String parametersWithoutBase;
    private final String path;

    /* INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static CommandLineMergeTool[] valuesCustom() {
        CommandLineMergeTool[] commandLineMergeToolArrValuesCustom = values();
        int length = commandLineMergeToolArrValuesCustom.length;
        CommandLineMergeTool[] commandLineMergeToolArr = new CommandLineMergeTool[length];
        System.arraycopy(commandLineMergeToolArrValuesCustom, 0, commandLineMergeToolArr, 0, length);
        return commandLineMergeToolArr;
    }

    CommandLineMergeTool(String str, String str2, String str3, boolean z) {
        this.path = str;
        this.parametersWithBase = str2;
        this.parametersWithoutBase = str3;
        this.exitCodeTrustable = z;
    }

    CommandLineMergeTool(String str, CommandLineMergeTool commandLineMergeTool) {
        this(str, commandLineMergeTool.getParameters(true), commandLineMergeTool.getParameters(false), commandLineMergeTool.isExitCodeTrustable());
    }

    public String getPath() {
        return this.path;
    }

    public String getParameters(boolean z) {
        if (z) {
            return this.parametersWithBase;
        }
        return this.parametersWithoutBase;
    }

    public boolean isExitCodeTrustable() {
        return this.exitCodeTrustable;
    }

    public boolean canMergeWithoutBasePresent() {
        return this.parametersWithoutBase != null;
    }
}
