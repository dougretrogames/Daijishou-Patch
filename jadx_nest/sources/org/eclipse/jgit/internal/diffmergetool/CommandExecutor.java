package org.eclipse.jgit.internal.diffmergetool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import net.lingala.zip4j.util.InternalZipConstants;
import org.eclipse.jgit.errors.NoWorkTreeException;
import org.eclipse.jgit.util.FS;
import org.eclipse.jgit.util.FS_POSIX;
import org.eclipse.jgit.util.FS_Win32;
import org.eclipse.jgit.util.FS_Win32_Cygwin;
import org.eclipse.jgit.util.StringUtils;
import org.eclipse.jgit.util.SystemReader;

/* JADX INFO: loaded from: classes5.dex */
public class CommandExecutor {
    private boolean checkExitCode;
    private File commandFile;
    private FS fs;
    private boolean useMsys2;

    public CommandExecutor(FS fs, boolean z) {
        this.fs = fs;
        this.checkExitCode = z;
    }

    public FS.ExecutionResult run(String str, File file, Map<String, String> map) throws InterruptedException, IOException, ToolException {
        String[] strArrCreateCommandArray = createCommandArray(str);
        try {
            ProcessBuilder processBuilderRunInShell = this.fs.runInShell(strArrCreateCommandArray[0], (String[]) Arrays.copyOfRange(strArrCreateCommandArray, 1, strArrCreateCommandArray.length));
            processBuilderRunInShell.directory(file);
            Map<String, String> mapEnvironment = processBuilderRunInShell.environment();
            if (map != null) {
                mapEnvironment.putAll(map);
            }
            FS.ExecutionResult executionResultExecute = this.fs.execute(processBuilderRunInShell, null);
            int rc = executionResultExecute.getRc();
            if (rc != 0) {
                boolean zIsCommandExecutionError = isCommandExecutionError(rc);
                if (this.checkExitCode || zIsCommandExecutionError) {
                    throw new ToolException("JGit: tool execution return code: " + rc + "\ncheckExitCode: " + this.checkExitCode + "\nexecError: " + zIsCommandExecutionError + "\nstderr: \n" + new String(executionResultExecute.getStderr().toByteArray(), SystemReader.getInstance().getDefaultCharset()), executionResultExecute, zIsCommandExecutionError);
                }
            }
            deleteCommandArray();
            return executionResultExecute;
        } catch (Throwable th) {
            deleteCommandArray();
            throw th;
        }
    }

    public boolean checkExecutable(String str, File file, Map<String, String> map) throws InterruptedException, IOException, ToolException {
        String str2;
        checkUseMsys2(str);
        if (!(this.fs instanceof FS_Win32) || this.useMsys2) {
            str2 = "which " + ExternalToolUtils.quotePath(str);
        } else {
            Path path = Paths.get(str, new String[0]);
            if (path.isAbsolute() && Files.isExecutable(path)) {
                return true;
            }
            str2 = "where " + ExternalToolUtils.quotePath(str);
        }
        try {
            return run(str2, file, map).getRc() == 0;
        } catch (IOException | InterruptedException | NoWorkTreeException | ToolException unused) {
        }
    }

    private void deleteCommandArray() {
        deleteCommandFile();
    }

    private String[] createCommandArray(String str) throws IOException, ToolException {
        checkUseMsys2(str);
        createCommandFile(str);
        FS fs = this.fs;
        if (fs instanceof FS_POSIX) {
            return new String[]{this.commandFile.getCanonicalPath()};
        }
        if (fs instanceof FS_Win32_Cygwin) {
            return new String[]{this.commandFile.getCanonicalPath().replace("\\", InternalZipConstants.ZIP_FILE_SEPARATOR)};
        }
        if (fs instanceof FS_Win32) {
            if (this.useMsys2) {
                return new String[]{"bash.exe", "-c", this.commandFile.getCanonicalPath().replace("\\", InternalZipConstants.ZIP_FILE_SEPARATOR)};
            }
            return new String[]{this.commandFile.getCanonicalPath()};
        }
        throw new ToolException("JGit: file system not supported: " + this.fs.toString());
    }

    private void checkUseMsys2(String str) {
        this.useMsys2 = false;
        String property = System.getProperty("jgit.usemsys2bash");
        if (StringUtils.isEmptyOrNull(property)) {
            return;
        }
        if (property.equalsIgnoreCase("auto")) {
            this.useMsys2 = str.contains(".sh");
        } else {
            this.useMsys2 = Boolean.parseBoolean(property);
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0056  */
    private void createCommandFile(String str) throws IOException, ToolException {
        String str2;
        if (!this.useMsys2) {
            FS fs = this.fs;
            if ((fs instanceof FS_POSIX) || (fs instanceof FS_Win32_Cygwin)) {
                str2 = ".sh";
            } else if (fs instanceof FS_Win32) {
                str = "@echo off" + System.lineSeparator() + str + System.lineSeparator() + "exit /B %ERRORLEVEL%";
                str2 = ".cmd";
            } else {
                throw new ToolException("JGit: file system not supported: " + this.fs.toString());
            }
        } else {
            str2 = ".sh";
        }
        this.commandFile = File.createTempFile(".__", "__jgit_tool".concat(str2));
        Throwable th = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.commandFile);
            try {
                fileOutputStream.write(str.getBytes(SystemReader.getInstance().getDefaultCharset()));
                fileOutputStream.close();
                fileOutputStream.close();
                this.commandFile.setExecutable(true);
            } catch (Throwable th2) {
                fileOutputStream.close();
                throw th2;
            }
        } catch (Throwable th3) {
            if (0 == 0) {
                throw th3;
            }
            if (null != th3) {
                th.addSuppressed(th3);
            }
            throw null;
        }
    }

    private void deleteCommandFile() {
        File file = this.commandFile;
        if (file == null || !file.exists()) {
            return;
        }
        this.commandFile.delete();
    }

    private boolean isCommandExecutionError(int i) {
        if (!this.useMsys2) {
            FS fs = this.fs;
            if (!(fs instanceof FS_POSIX) && !(fs instanceof FS_Win32_Cygwin)) {
                return (fs instanceof FS_Win32) && i == 9009;
            }
        }
        return i == 126 || i == 127;
    }
}
