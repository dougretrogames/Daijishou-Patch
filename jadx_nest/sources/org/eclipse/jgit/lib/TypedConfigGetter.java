package org.eclipse.jgit.lib;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.jgit.util.FS;

/* JADX INFO: loaded from: classes5.dex */
public interface TypedConfigGetter {
    public static final int UNSET_INT = Integer.MIN_VALUE;

    boolean getBoolean(Config config, String str, String str2, String str3, boolean z);

    <T extends Enum<?>> T getEnum(Config config, T[] tArr, String str, String str2, String str3, T t);

    int getInt(Config config, String str, String str2, String str3, int i);

    int getIntInRange(Config config, String str, String str2, String str3, int i, int i2, int i3);

    long getLong(Config config, String str, String str2, String str3, long j);

    List<RefSpec> getRefSpecs(Config config, String str, String str2, String str3);

    long getTimeUnit(Config config, String str, String str2, String str3, long j, TimeUnit timeUnit);

    default Path getPath(Config config, String str, String str2, String str3, FS fs, File file, Path path) {
        File fileResolve;
        String string = config.getString(str, str2, str3);
        if (string == null) {
            return path;
        }
        if (string.startsWith("~/")) {
            fileResolve = fs.resolve(fs.userHome(), string.substring(2));
        } else {
            fileResolve = fs.resolve(file, string);
        }
        return fileResolve.toPath();
    }
}
