package org.eclipse.jgit.internal.diffmergetool;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.StoredConfig;
import org.eclipse.jgit.lib.internal.BooleanTriState;
import org.eclipse.jgit.util.FS;
import org.eclipse.jgit.util.StringUtils;

/* JADX INFO: loaded from: classes5.dex */
public class DiffTools {
    private final DiffToolConfig config;
    private final FS fs;
    private final File gitDir;
    private final Map<String, ExternalDiffTool> predefinedTools;
    private final Repository repo;
    private final Map<String, ExternalDiffTool> userDefinedTools;
    private final File workTree;

    public DiffTools(Repository repository) {
        this(repository, repository.getConfig());
    }

    public DiffTools(StoredConfig storedConfig) {
        this(null, storedConfig);
    }

    private DiffTools(Repository repository, StoredConfig storedConfig) {
        this.repo = repository;
        this.config = (DiffToolConfig) storedConfig.get(DiffToolConfig.KEY);
        this.gitDir = repository == null ? null : repository.getDirectory();
        this.fs = repository == null ? FS.DETECTED : repository.getFS();
        this.workTree = repository != null ? repository.getWorkTree() : null;
        Map<String, ExternalDiffTool> map = setupPredefinedTools();
        this.predefinedTools = map;
        this.userDefinedTools = setupUserDefinedTools(map);
    }

    public Optional<FS.ExecutionResult> compare(FileElement fileElement, FileElement fileElement2, Optional<String> optional, BooleanTriState booleanTriState, boolean z, BooleanTriState booleanTriState2, PromptContinueHandler promptContinueHandler, InformNoToolHandler informNoToolHandler) throws ToolException {
        String defaultToolName;
        boolean zIsInteractive;
        if (optional == null) {
            throw new ToolException(JGitText.get().diffToolNullError);
        }
        if (optional.isPresent()) {
            defaultToolName = optional.get();
        } else {
            defaultToolName = getDefaultToolName(z);
        }
        if (StringUtils.isEmptyOrNull(defaultToolName)) {
            throw new ToolException(JGitText.get().diffToolNotGivenError);
        }
        boolean zIsTrustExitCode = true;
        if (booleanTriState != BooleanTriState.UNSET) {
            zIsInteractive = booleanTriState == BooleanTriState.TRUE;
        } else {
            zIsInteractive = isInteractive();
        }
        if (zIsInteractive && !promptContinueHandler.prompt(defaultToolName)) {
            return Optional.empty();
        }
        if (booleanTriState2 != BooleanTriState.UNSET) {
            if (booleanTriState2 != BooleanTriState.TRUE) {
                zIsTrustExitCode = false;
            }
        } else {
            zIsTrustExitCode = this.config.isTrustExitCode();
        }
        ExternalDiffTool tool = getTool(defaultToolName);
        if (tool == null) {
            throw new ToolException("External diff tool is not defined: " + defaultToolName);
        }
        return Optional.of(compare(fileElement, fileElement2, tool, zIsTrustExitCode));
    }

    public FS.ExecutionResult compare(FileElement fileElement, FileElement fileElement2, ExternalDiffTool externalDiffTool, boolean z) throws ToolException {
        try {
            try {
                if (externalDiffTool == null) {
                    throw new ToolException(JGitText.get().diffToolNotSpecifiedInGitAttributesError);
                }
                FS.ExecutionResult executionResultRun = new CommandExecutor(this.fs, z).run(ExternalToolUtils.prepareCommand(externalDiffTool.getCommand(), fileElement, fileElement2, null, null), this.workTree, ExternalToolUtils.prepareEnvironment(this.gitDir, fileElement, fileElement2, null, null));
                fileElement.cleanTemporaries();
                fileElement2.cleanTemporaries();
                return executionResultRun;
            } catch (Throwable th) {
                fileElement.cleanTemporaries();
                fileElement2.cleanTemporaries();
                throw th;
            }
        } catch (IOException | InterruptedException e) {
            throw new ToolException(e);
        }
    }

    public Set<String> getUserDefinedToolNames() {
        return this.userDefinedTools.keySet();
    }

    public Set<String> getPredefinedToolNames() {
        return this.predefinedTools.keySet();
    }

    public Set<String> getAllToolNames() {
        String defaultToolName = getDefaultToolName(false);
        if (defaultToolName == null) {
            defaultToolName = getFirstAvailableTool();
        }
        return ExternalToolUtils.createSortedToolSet(defaultToolName, getUserDefinedToolNames(), getPredefinedToolNames());
    }

    public Optional<String> getExternalToolFromAttributes(String str) throws ToolException {
        return ExternalToolUtils.getExternalToolFromAttributes(this.repo, str, "difftool");
    }

    public Set<String> getPredefinedAvailableTools() {
        Map<String, ExternalDiffTool> predefinedTools = getPredefinedTools(true);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Map.Entry<String, ExternalDiffTool> entry : predefinedTools.entrySet()) {
            if (entry.getValue().isAvailable()) {
                linkedHashSet.add(entry.getKey());
            }
        }
        return linkedHashSet;
    }

    public Map<String, ExternalDiffTool> getUserDefinedTools() {
        return Collections.unmodifiableMap(this.userDefinedTools);
    }

    public Map<String, ExternalDiffTool> getPredefinedTools(boolean z) {
        if (z) {
            Iterator<ExternalDiffTool> it = this.predefinedTools.values().iterator();
            while (it.hasNext()) {
                PreDefinedDiffTool preDefinedDiffTool = (PreDefinedDiffTool) it.next();
                preDefinedDiffTool.setAvailable(ExternalToolUtils.isToolAvailable(this.fs, this.gitDir, this.workTree, preDefinedDiffTool.getPath()));
            }
        }
        return Collections.unmodifiableMap(this.predefinedTools);
    }

    public String getFirstAvailableTool() {
        for (ExternalDiffTool externalDiffTool : this.predefinedTools.values()) {
            if (ExternalToolUtils.isToolAvailable(this.fs, this.gitDir, this.workTree, externalDiffTool.getPath())) {
                return externalDiffTool.getName();
            }
        }
        return null;
    }

    public String getDefaultToolName(boolean z) {
        String defaultGuiToolName;
        return (!z || (defaultGuiToolName = this.config.getDefaultGuiToolName()) == null) ? this.config.getDefaultToolName() : defaultGuiToolName;
    }

    public boolean isInteractive() {
        return this.config.isPrompt();
    }

    private ExternalDiffTool getTool(String str) {
        ExternalDiffTool externalDiffTool = this.userDefinedTools.get(str);
        return externalDiffTool == null ? this.predefinedTools.get(str) : externalDiffTool;
    }

    private static Map<String, ExternalDiffTool> setupPredefinedTools() {
        TreeMap treeMap = new TreeMap();
        for (CommandLineDiffTool commandLineDiffTool : CommandLineDiffTool.valuesCustom()) {
            treeMap.put(commandLineDiffTool.name(), new PreDefinedDiffTool(commandLineDiffTool));
        }
        return treeMap;
    }

    private Map<String, ExternalDiffTool> setupUserDefinedTools(Map<String, ExternalDiffTool> map) {
        PreDefinedDiffTool preDefinedDiffTool;
        TreeMap treeMap = new TreeMap();
        Map<String, ExternalDiffTool> tools = this.config.getTools();
        for (String str : tools.keySet()) {
            ExternalDiffTool externalDiffTool = tools.get(str);
            if (externalDiffTool.getCommand() != null) {
                treeMap.put(str, externalDiffTool);
            } else if (externalDiffTool.getPath() != null && (preDefinedDiffTool = (PreDefinedDiffTool) map.get(str)) != null) {
                preDefinedDiffTool.setPath(externalDiffTool.getPath());
            }
        }
        return treeMap;
    }
}
