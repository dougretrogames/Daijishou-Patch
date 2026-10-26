package org.eclipse.jgit.internal.diffmergetool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.internal.BooleanTriState;

/* INFO: loaded from: classes5.dex */
public class MergeToolConfig {
    public static final Config.SectionParser<MergeToolConfig> KEY = new MergeToolConfig$$ExternalSyntheticLambda0();
    private final String guiToolName;
    private final boolean keepBackup;
    private final boolean keepTemporaries;
    private final boolean prompt;
    private final String toolName;
    private final Map<String, ExternalMergeTool> tools;
    private final boolean writeToTemp;

    public static /* synthetic */ MergeToolConfig $r8$lambda$mUfFt4Li5VfxLyp4UuEiRQWpgUA(Config config) {
        return new MergeToolConfig(config);
    }

    private MergeToolConfig(Config config) {
        BooleanTriState booleanTriState;
        String string = config.getString("merge", null, ConfigConstants.CONFIG_KEY_TOOL);
        this.toolName = string;
        this.guiToolName = config.getString("merge", null, ConfigConstants.CONFIG_KEY_GUITOOL);
        this.prompt = config.getBoolean("mergetool", string, ConfigConstants.CONFIG_KEY_PROMPT, true);
        this.keepBackup = config.getBoolean("mergetool", ConfigConstants.CONFIG_KEY_KEEP_BACKUP, true);
        this.keepTemporaries = config.getBoolean("mergetool", ConfigConstants.CONFIG_KEY_KEEP_TEMPORARIES, false);
        this.writeToTemp = config.getBoolean("mergetool", ConfigConstants.CONFIG_KEY_WRITE_TO_TEMP, false);
        this.tools = new HashMap();
        for (String str : config.getSubsections("mergetool")) {
            String string2 = config.getString("mergetool", str, ConfigConstants.CONFIG_KEY_CMD);
            String string3 = config.getString("mergetool", str, "path");
            BooleanTriState booleanTriState2 = BooleanTriState.FALSE;
            String string4 = config.getString("mergetool", str, ConfigConstants.CONFIG_KEY_TRUST_EXIT_CODE);
            if (string4 != null) {
                if (Boolean.valueOf(string4).booleanValue()) {
                    booleanTriState = BooleanTriState.TRUE;
                } else {
                    booleanTriState = BooleanTriState.FALSE;
                }
            } else {
                booleanTriState = BooleanTriState.UNSET;
            }
            if (string2 != null || string3 != null) {
                this.tools.put(str, new UserDefinedMergeTool(str, string3, string2, booleanTriState));
            }
        }
    }

    public String getDefaultToolName() {
        return this.toolName;
    }

    public String getDefaultGuiToolName() {
        return this.guiToolName;
    }

    public boolean isPrompt() {
        return this.prompt;
    }

    public boolean isKeepBackup() {
        return this.keepBackup;
    }

    public boolean isKeepTemporaries() {
        return this.keepTemporaries;
    }

    public boolean isWriteToTemp() {
        return this.writeToTemp;
    }

    public Map<String, ExternalMergeTool> getTools() {
        return this.tools;
    }

    public Set<String> getToolNames() {
        return this.tools.keySet();
    }
}
