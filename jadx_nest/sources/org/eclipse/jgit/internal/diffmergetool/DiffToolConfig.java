package org.eclipse.jgit.internal.diffmergetool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.internal.BooleanTriState;

/* JADX INFO: loaded from: classes5.dex */
public class DiffToolConfig {
    public static final Config.SectionParser<DiffToolConfig> KEY = new DiffToolConfig$$ExternalSyntheticLambda0();
    private final String guiToolName;
    private final boolean prompt;
    private final String toolName;
    private final Map<String, ExternalDiffTool> tools;
    private final BooleanTriState trustExitCode;

    /* JADX INFO: renamed from: $r8$lambda$TMdPLj_8iJfmylvCnT_aCZ3Sd-s, reason: not valid java name */
    public static /* synthetic */ DiffToolConfig m5659$r8$lambda$TMdPLj_8iJfmylvCnT_aCZ3Sds(Config config) {
        return new DiffToolConfig(config);
    }

    private DiffToolConfig(Config config) {
        BooleanTriState booleanTriState;
        String string = config.getString("diff", null, ConfigConstants.CONFIG_KEY_TOOL);
        this.toolName = string;
        this.guiToolName = config.getString("diff", null, ConfigConstants.CONFIG_KEY_GUITOOL);
        this.prompt = config.getBoolean("difftool", string, ConfigConstants.CONFIG_KEY_PROMPT, true);
        String string2 = config.getString("difftool", string, ConfigConstants.CONFIG_KEY_TRUST_EXIT_CODE);
        if (string2 != null) {
            if (Boolean.parseBoolean(string2)) {
                booleanTriState = BooleanTriState.TRUE;
            } else {
                booleanTriState = BooleanTriState.FALSE;
            }
            this.trustExitCode = booleanTriState;
        } else {
            this.trustExitCode = BooleanTriState.UNSET;
        }
        this.tools = new HashMap();
        for (String str : config.getSubsections("difftool")) {
            String string3 = config.getString("difftool", str, ConfigConstants.CONFIG_KEY_CMD);
            String string4 = config.getString("difftool", str, "path");
            if (string3 != null || string4 != null) {
                this.tools.put(str, new UserDefinedDiffTool(str, string4, string3));
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

    public boolean isTrustExitCode() {
        return this.trustExitCode == BooleanTriState.TRUE;
    }

    public Map<String, ExternalDiffTool> getTools() {
        return this.tools;
    }

    public Set<String> getToolNames() {
        return this.tools.keySet();
    }
}
