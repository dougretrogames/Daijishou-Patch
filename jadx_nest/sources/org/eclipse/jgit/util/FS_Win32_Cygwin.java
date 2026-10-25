package org.eclipse.jgit.util;

import java.io.File;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.errors.CommandFailedException;
import org.eclipse.jgit.lib.BranchConfig;
import org.eclipse.jgit.lib.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class FS_Win32_Cygwin extends FS_Win32 {
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) FS_Win32_Cygwin.class);
    private static String cygpath;

    public static boolean isCygwin() {
        String property = System.getProperty("java.library.path");
        if (property == null) {
            return false;
        }
        File fileSearchPath = FS.searchPath(property, "cygpath.exe");
        if (fileSearchPath != null) {
            cygpath = fileSearchPath.getPath();
        }
        return cygpath != null;
    }

    public FS_Win32_Cygwin() {
    }

    protected FS_Win32_Cygwin(FS fs) {
        super(fs);
    }

    @Override // org.eclipse.jgit.util.FS_Win32, org.eclipse.jgit.util.FS
    public FS newInstance() {
        return new FS_Win32_Cygwin(this);
    }

    @Override // org.eclipse.jgit.util.FS
    public File resolve(File file, String str) {
        String property = System.getProperty("jgit.usecygpath");
        if (property != null && property.equals("true")) {
            try {
                String pipe = readPipe(file, new String[]{cygpath, "--windows", "--absolute", str}, StandardCharsets.UTF_8.name());
                if (!StringUtils.isEmptyOrNull(pipe)) {
                    return new File(pipe);
                }
            } catch (CommandFailedException e) {
                LOG.warn(e.getMessage());
                return null;
            }
        }
        return super.resolve(file, str);
    }

    @Override // org.eclipse.jgit.util.FS_Win32, org.eclipse.jgit.util.FS
    protected File userHomeImpl() {
        String str = System.getenv("HOME");
        if (str == null || str.length() == 0) {
            return super.userHomeImpl();
        }
        return resolve(new File(BranchConfig.LOCAL_REPOSITORY), str);
    }

    @Override // org.eclipse.jgit.util.FS_Win32, org.eclipse.jgit.util.FS
    public ProcessBuilder runInShell(String str, String[] strArr) {
        ArrayList arrayList = new ArrayList(strArr.length + 4);
        arrayList.add("sh.exe");
        arrayList.add("-c");
        arrayList.add(str + " \"$@\"");
        arrayList.add(str);
        arrayList.addAll(Arrays.asList(strArr));
        ProcessBuilder processBuilder = new ProcessBuilder(new String[0]);
        processBuilder.command(arrayList);
        return processBuilder;
    }

    @Override // org.eclipse.jgit.util.FS
    String shellQuote(String str) {
        return QuotedString.BOURNE.quote(str.replace(File.separatorChar, '/'));
    }

    @Override // org.eclipse.jgit.util.FS
    public String relativize(String str, String str2) {
        return super.relativize(str, str2).replace(File.separatorChar, '/');
    }

    @Override // org.eclipse.jgit.util.FS
    public ProcessResult runHookIfPresent(Repository repository, String str, String[] strArr, OutputStream outputStream, OutputStream outputStream2, String str2) throws JGitInternalException {
        return internalRunHookIfPresent(repository, str, strArr, outputStream, outputStream2, str2);
    }
}
