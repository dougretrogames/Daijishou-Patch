package org.eclipse.jgit.internal.diffmergetool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.lib.BranchConfig;

/* JADX INFO: loaded from: classes5.dex */
public class FileElement {
    private final String path;
    private InputStream stream;
    private File tempFile;
    private final Type type;
    private final File workDir;

    public enum Type {
        LOCAL,
        REMOTE,
        MERGED,
        BASE,
        BACKUP;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static Type[] valuesCustom() {
            Type[] typeArrValuesCustom = values();
            int length = typeArrValuesCustom.length;
            Type[] typeArr = new Type[length];
            System.arraycopy(typeArrValuesCustom, 0, typeArr, 0, length);
            return typeArr;
        }
    }

    public FileElement(String str, Type type) {
        this(str, type, null);
    }

    public FileElement(String str, Type type, File file) {
        this(str, type, file, null);
    }

    public FileElement(String str, Type type, File file, InputStream inputStream) {
        this.path = str;
        this.type = type;
        this.workDir = file;
        this.stream = inputStream;
    }

    public String getPath() {
        return this.path;
    }

    public Type getType() {
        return this.type;
    }

    public File getFile() throws IOException {
        File file = this.tempFile;
        if (file != null && this.stream == null) {
            return file;
        }
        File file2 = new File(this.workDir, this.path);
        if (this.stream == null && !isNullPath()) {
            return file2;
        }
        if (this.tempFile == null) {
            this.tempFile = getTempFile(file2, this.type.name(), null);
        }
        InputStream inputStream = this.stream;
        if (inputStream != null) {
            copyFromStream(this.tempFile, inputStream);
        }
        this.stream = null;
        return this.tempFile;
    }

    public boolean isNullPath() {
        return this.path.equals(DiffEntry.DEV_NULL);
    }

    public File createTempFile(File file) throws IOException {
        if (this.tempFile == null) {
            this.tempFile = getTempFile(new File(this.path), this.type.name(), file);
        }
        return this.tempFile;
    }

    public void cleanTemporaries() {
        File file = this.tempFile;
        if (file != null && file.exists()) {
            this.tempFile.delete();
        }
        this.tempFile = null;
    }

    public String replaceVariable(String str) throws IOException {
        return str.replace("$" + this.type.name(), getFile().getPath());
    }

    public void addToEnv(Map<String, String> map) throws IOException {
        map.put(this.type.name(), getFile().getPath());
    }

    private static File getTempFile(File file, String str, File file2) throws IOException {
        String[] strArrSplitBaseFileNameAndExtension = splitBaseFileNameAndExtension(file);
        return File.createTempFile(strArrSplitBaseFileNameAndExtension[0] + "_" + str + "_", strArrSplitBaseFileNameAndExtension[1], file2);
    }

    private static void copyFromStream(File file, InputStream inputStream) throws IOException {
        Throwable th = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i != -1) {
                        fileOutputStream.write(bArr, 0, i);
                    } else {
                        fileOutputStream.close();
                        inputStream.close();
                        return;
                    }
                }
            } catch (Throwable th2) {
                fileOutputStream.close();
                throw th2;
            }
        } catch (Throwable th3) {
            if (0 == 0) {
                throw th3;
            }
            if (null != th3) {
                try {
                    th.addSuppressed(th3);
                } catch (Throwable th4) {
                    inputStream.close();
                    throw th4;
                }
            }
            throw null;
        }
    }

    private static String[] splitBaseFileNameAndExtension(File file) {
        String name = file.getName();
        String[] strArr = {name, ""};
        int iLastIndexOf = name.lastIndexOf(BranchConfig.LOCAL_REPOSITORY);
        if (iLastIndexOf > 0) {
            String str = strArr[0];
            strArr[1] = str.substring(iLastIndexOf, str.length());
            strArr[0] = strArr[0].substring(0, iLastIndexOf);
        }
        return strArr;
    }
}
