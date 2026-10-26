package org.eclipse.jgit.internal.diffmergetool;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
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

/* INFO: loaded from: classes5.dex */
public class MergeTools {
    private final MergeToolConfig config;
    private final FS fs;
    private final File gitDir;
    private final Map<String, ExternalMergeTool> predefinedTools;
    private final Repository repo;
    private final Map<String, ExternalMergeTool> userDefinedTools;
    private final File workTree;

    public MergeTools(Repository repository) {
        this(repository, repository.getConfig());
    }

    public MergeTools(StoredConfig storedConfig) {
        this(null, storedConfig);
    }

    private MergeTools(Repository repository, StoredConfig storedConfig) {
        this.repo = repository;
        this.config = (MergeToolConfig) storedConfig.get(MergeToolConfig.KEY);
        this.gitDir = repository == null ? null : repository.getDirectory();
        this.fs = repository == null ? FS.DETECTED : repository.getFS();
        this.workTree = repository != null ? repository.getWorkTree() : null;
        Map<String, ExternalMergeTool> map = setupPredefinedTools();
        this.predefinedTools = map;
        this.userDefinedTools = setupUserDefinedTools(map);
    }

    public Optional<FS.ExecutionResult> merge(FileElement fileElement, FileElement fileElement2, FileElement fileElement3, FileElement fileElement4, File file, Optional<String> optional, BooleanTriState booleanTriState, boolean z, PromptContinueHandler promptContinueHandler, InformNoToolHandler informNoToolHandler) throws ToolException {
        String defaultToolName;
        boolean zIsInteractive;
        if (optional == null) {
            throw new ToolException(JGitText.get().diffToolNullError);
        }
        if (optional.isPresent()) {
            defaultToolName = optional.get();
        } else {
            defaultToolName = getDefaultToolName(z);
            if (StringUtils.isEmptyOrNull(defaultToolName)) {
                informNoToolHandler.inform(new ArrayList(this.predefinedTools.keySet()));
                defaultToolName = getFirstAvailableTool();
            }
        }
        if (StringUtils.isEmptyOrNull(defaultToolName)) {
            throw new ToolException(JGitText.get().diffToolNotGivenError);
        }
        if (booleanTriState != BooleanTriState.UNSET) {
            zIsInteractive = booleanTriState == BooleanTriState.TRUE;
        } else {
            zIsInteractive = isInteractive();
        }
        if (zIsInteractive && !promptContinueHandler.prompt(defaultToolName)) {
            return Optional.empty();
        }
        ExternalMergeTool tool = getTool(defaultToolName);
        if (tool == null) {
            throw new ToolException("External merge tool is not defined: " + defaultToolName);
        }
        return Optional.of(merge(fileElement, fileElement2, fileElement3, fileElement4, file, tool));
    }

    /* WARN: Code duplicated, block: B:49:0x0088  */
    /* WARN: Code duplicated, block: B:51:0x008d  */
    /* WARN: Code duplicated, block: B:53:0x0095  */
    /* WARN: Code duplicated, block: B:55:0x009d  */
    /* WARN: Code duplicated, block: B:58:0x00a8 A[ADDED_TO_REGION] */
    public FS.ExecutionResult merge(FileElement fileElement, FileElement fileElement2, FileElement fileElement3, FileElement fileElement4, File file, ExternalMergeTool externalMergeTool) throws Throwable {
        File file2;
        FS.ExecutionResult executionResult;
        FileElement fileElement5 = null;
        executionResultRun = null;
        executionResultRun = null;
        FS.ExecutionResult executionResultRun = null;
        fileElement5 = null;
        if (file != null) {
            file2 = file;
        } else {
            try {
                file2 = this.workTree;
            } catch (IOException e) {
                e = e;
                executionResult = null;
                try {
                    throw new ToolException(e);
                } catch (Throwable th) {
                    th = th;
                    if (fileElement5 != null) {
                        fileElement5.cleanTemporaries();
                    }
                    if (executionResult == null || !this.config.isKeepTemporaries()) {
                        fileElement.cleanTemporaries();
                        fileElement2.cleanTemporaries();
                        if (fileElement4 != null) {
                            fileElement4.cleanTemporaries();
                        }
                        if (this.config.isWriteToTemp() && file != null && file.exists()) {
                            file.delete();
                        }
                    }
                    throw th;
                }
            } catch (InterruptedException e2) {
                e = e2;
                executionResult = null;
                throw new ToolException(e);
            } catch (Throwable th2) {
                th = th2;
                executionResult = null;
                if (fileElement5 != null) {
                    fileElement5.cleanTemporaries();
                }
                if (executionResult == null) {
                    fileElement.cleanTemporaries();
                    fileElement2.cleanTemporaries();
                    if (fileElement4 != null) {
                        fileElement4.cleanTemporaries();
                    }
                    if (this.config.isWriteToTemp()) {
                        file.delete();
                    }
                } else {
                    fileElement.cleanTemporaries();
                    fileElement2.cleanTemporaries();
                    if (fileElement4 != null) {
                        fileElement4.cleanTemporaries();
                    }
                    if (this.config.isWriteToTemp()) {
                        file.delete();
                    }
                }
                throw th;
            }
        }
        FileElement fileElementCreateBackupFile = createBackupFile(fileElement3, file2);
        boolean z = true;
        try {
            String strPrepareCommand = ExternalToolUtils.prepareCommand(externalMergeTool.getCommand(fileElement4 != null), fileElement, fileElement2, fileElement3, fileElement4);
            Map<String, String> mapPrepareEnvironment = ExternalToolUtils.prepareEnvironment(this.gitDir, fileElement, fileElement2, fileElement3, fileElement4);
            if (externalMergeTool.getTrustExitCode() != BooleanTriState.TRUE) {
                z = false;
            }
            executionResultRun = new CommandExecutor(this.fs, z).run(strPrepareCommand, this.workTree, mapPrepareEnvironment);
            if (fileElementCreateBackupFile != null) {
                keepBackupFile(fileElement3.getPath(), fileElementCreateBackupFile);
            }
            if (fileElementCreateBackupFile != null) {
                fileElementCreateBackupFile.cleanTemporaries();
            }
            if (executionResultRun != null || !this.config.isKeepTemporaries()) {
                fileElement.cleanTemporaries();
                fileElement2.cleanTemporaries();
                if (fileElement4 != null) {
                    fileElement4.cleanTemporaries();
                }
                if (this.config.isWriteToTemp() && file != null && file.exists()) {
                    file.delete();
                }
            }
            return executionResultRun;
        } catch (IOException e3) {
            e = e3;
            executionResult = executionResultRun;
            fileElement5 = fileElementCreateBackupFile;
            throw new ToolException(e);
        } catch (InterruptedException e4) {
            e = e4;
            executionResult = executionResultRun;
            fileElement5 = fileElementCreateBackupFile;
            throw new ToolException(e);
        } catch (Throwable th3) {
            th = th3;
            executionResult = executionResultRun;
            fileElement5 = fileElementCreateBackupFile;
            if (fileElement5 != null) {
                fileElement5.cleanTemporaries();
            }
            if (executionResult == null) {
                fileElement.cleanTemporaries();
                fileElement2.cleanTemporaries();
                if (fileElement4 != null) {
                    fileElement4.cleanTemporaries();
                }
                if (this.config.isWriteToTemp()) {
                    file.delete();
                }
            } else {
                fileElement.cleanTemporaries();
                fileElement2.cleanTemporaries();
                if (fileElement4 != null) {
                    fileElement4.cleanTemporaries();
                }
                if (this.config.isWriteToTemp()) {
                    file.delete();
                }
            }
            throw th;
        }
    }

    private FileElement createBackupFile(FileElement fileElement, File file) throws IOException {
        Path path = Paths.get(fileElement.getPath(), new String[0]);
        if (!Files.exists(path, new LinkOption[0])) {
            return null;
        }
        FileElement fileElement2 = new FileElement(fileElement.getPath(), FileElement.Type.BACKUP);
        Files.copy(path, fileElement2.createTempFile(file).toPath(), StandardCopyOption.REPLACE_EXISTING);
        return fileElement2;
    }

    public File createTempDirectory() throws IOException {
        if (this.config.isWriteToTemp()) {
            return Files.createTempDirectory("jgit-mergetool-", new FileAttribute[0]).toFile();
        }
        return null;
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
        return ExternalToolUtils.getExternalToolFromAttributes(this.repo, str, "mergetool");
    }

    public Set<String> getPredefinedAvailableTools() {
        Map<String, ExternalMergeTool> predefinedTools = getPredefinedTools(true);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Map.Entry<String, ExternalMergeTool> entry : predefinedTools.entrySet()) {
            if (entry.getValue().isAvailable()) {
                linkedHashSet.add(entry.getKey());
            }
        }
        return linkedHashSet;
    }

    public Map<String, ExternalMergeTool> getUserDefinedTools() {
        return Collections.unmodifiableMap(this.userDefinedTools);
    }

    public Map<String, ExternalMergeTool> getPredefinedTools(boolean z) {
        if (z) {
            Iterator<ExternalMergeTool> it = this.predefinedTools.values().iterator();
            while (it.hasNext()) {
                PreDefinedMergeTool preDefinedMergeTool = (PreDefinedMergeTool) it.next();
                preDefinedMergeTool.setAvailable(ExternalToolUtils.isToolAvailable(this.fs, this.gitDir, this.workTree, preDefinedMergeTool.getPath()));
            }
        }
        return Collections.unmodifiableMap(this.predefinedTools);
    }

    public String getFirstAvailableTool() {
        for (ExternalMergeTool externalMergeTool : this.predefinedTools.values()) {
            if (ExternalToolUtils.isToolAvailable(this.fs, this.gitDir, this.workTree, externalMergeTool.getPath())) {
                return externalMergeTool.getName();
            }
        }
        return null;
    }

    public boolean isInteractive() {
        return this.config.isPrompt();
    }

    public String getDefaultToolName(boolean z) {
        if (z) {
            return this.config.getDefaultGuiToolName();
        }
        return this.config.getDefaultToolName();
    }

    private ExternalMergeTool getTool(String str) {
        ExternalMergeTool externalMergeTool = this.userDefinedTools.get(str);
        return externalMergeTool == null ? this.predefinedTools.get(str) : externalMergeTool;
    }

    private void keepBackupFile(String str, FileElement fileElement) throws IOException {
        if (this.config.isKeepBackup()) {
            Path path = fileElement.getFile().toPath();
            Files.move(path, path.resolveSibling(String.valueOf(Paths.get(str, new String[0]).getFileName()) + ".orig"), StandardCopyOption.REPLACE_EXISTING);
        }
    }

    private Map<String, ExternalMergeTool> setupPredefinedTools() {
        TreeMap treeMap = new TreeMap();
        for (CommandLineMergeTool commandLineMergeTool : CommandLineMergeTool.valuesCustom()) {
            treeMap.put(commandLineMergeTool.name(), new PreDefinedMergeTool(commandLineMergeTool));
        }
        return treeMap;
    }

    private Map<String, ExternalMergeTool> setupUserDefinedTools(Map<String, ExternalMergeTool> map) {
        PreDefinedMergeTool preDefinedMergeTool;
        TreeMap treeMap = new TreeMap();
        Map<String, ExternalMergeTool> tools = this.config.getTools();
        for (String str : tools.keySet()) {
            ExternalMergeTool externalMergeTool = tools.get(str);
            if (externalMergeTool.getCommand() != null) {
                treeMap.put(str, externalMergeTool);
            } else if (externalMergeTool.getPath() != null && (preDefinedMergeTool = (PreDefinedMergeTool) map.get(str)) != null) {
                preDefinedMergeTool.setPath(externalMergeTool.getPath());
                if (externalMergeTool.getTrustExitCode() != BooleanTriState.UNSET) {
                    preDefinedMergeTool.setTrustExitCode(externalMergeTool.getTrustExitCode());
                }
            }
        }
        return treeMap;
    }
}
