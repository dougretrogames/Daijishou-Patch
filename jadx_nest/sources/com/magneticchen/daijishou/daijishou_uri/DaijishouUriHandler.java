package com.magneticchen.daijishou.daijishou_uri;

import com.magneticchen.daijishou.DaijishouApplication;
import java.io.File;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.FileUtils;

/* INFO: compiled from: DaijishouUriHandler.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001b\u001a\u00020\bJ\u0006\u0010\u001c\u001a\u00020\u0019J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001e\u001a\u00020\bJ\u0006\u0010\u001f\u001a\u00020\u0019J\u000e\u0010 \u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR-\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\fj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR-\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\fj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR-\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\fj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0014\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\nR\u0011\u0010\u0016\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\n¨\u0006#"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_uri/DaijishouUriHandler;", "", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "(Lcom/magneticchen/daijishou/DaijishouApplication;)V", "getApplication", "()Lcom/magneticchen/daijishou/DaijishouApplication;", "cacheDirAbsolutePath", "", "getCacheDirAbsolutePath", "()Ljava/lang/String;", "extensionFileUriToPathHashMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getExtensionFileUriToPathHashMap", "()Ljava/util/HashMap;", "extensionUriToPathHashMap", "getExtensionUriToPathHashMap", "fileUriToPathHashMap", "getFileUriToPathHashMap", "filesDirAbsolutePath", "getFilesDirAbsolutePath", "tempFilesDirAbsolutePath", "getTempFilesDirAbsolutePath", "decodeFromDaijishouExtensionUri", "", "decodeFromDaijishouFileUri", "uriString", "encodeToDaijishouExtensionUri", "encodeToDaijishouFileUri", "path", "initializeFilesAndDirectories", "isDaijishouFileUri", "", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouUriHandler {
    private final DaijishouApplication application;
    private final String cacheDirAbsolutePath;
    private final HashMap<String, String> extensionFileUriToPathHashMap;
    private final HashMap<String, String> extensionUriToPathHashMap;
    private final HashMap<String, String> fileUriToPathHashMap;
    private final String filesDirAbsolutePath;
    private final String tempFilesDirAbsolutePath;

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String DAIJISHOU_FILE_URI = "daijishou-file://";
    private static final String DAIJISHOU_FILE_FILES_BASE_URI = "daijishou-file://files";
    private static final String DAIJISHOU_FILE_TEMP_FILES_BASE_URI = "daijishou-file://files/temp";
    private static final String DAIJISHOU_FILE_CACHE_BASE_URI = "daijishou-file://cache";
    private static final String DAIJISHOU_FILE_EXTENSION_MANAGER_RUNTIME_INSTALLED_BASE_URI = "daijishou-file://extension_manager/installed";
    private static final String DAIJISHOU_FILE_EXTENSION_MANAGER_RUNTIME_FILES_BASE_URI = "daijishou-file://extension_manager/files";
    private static final String DAIJISHOU_FILE_EXTENSION_MANAGER_RUNTIME_CACHE_BASE_URI = "daijishou-file://extension_manager/cache";
    private static final String DAIJISHOU_EXTENSION_BASE_URI = "daijishou-ext://";

    public final void decodeFromDaijishouExtensionUri() {
    }

    public final void encodeToDaijishouExtensionUri() {
    }

    /* INFO: compiled from: DaijishouUriHandler.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_uri/DaijishouUriHandler$Companion;", "", "()V", "DAIJISHOU_EXTENSION_BASE_URI", "", "getDAIJISHOU_EXTENSION_BASE_URI", "()Ljava/lang/String;", "DAIJISHOU_FILE_CACHE_BASE_URI", "getDAIJISHOU_FILE_CACHE_BASE_URI", "DAIJISHOU_FILE_EXTENSION_MANAGER_RUNTIME_CACHE_BASE_URI", "getDAIJISHOU_FILE_EXTENSION_MANAGER_RUNTIME_CACHE_BASE_URI", "DAIJISHOU_FILE_EXTENSION_MANAGER_RUNTIME_FILES_BASE_URI", "getDAIJISHOU_FILE_EXTENSION_MANAGER_RUNTIME_FILES_BASE_URI", "DAIJISHOU_FILE_EXTENSION_MANAGER_RUNTIME_INSTALLED_BASE_URI", "getDAIJISHOU_FILE_EXTENSION_MANAGER_RUNTIME_INSTALLED_BASE_URI", "DAIJISHOU_FILE_FILES_BASE_URI", "getDAIJISHOU_FILE_FILES_BASE_URI", "DAIJISHOU_FILE_TEMP_FILES_BASE_URI", "getDAIJISHOU_FILE_TEMP_FILES_BASE_URI", "DAIJISHOU_FILE_URI", "getDAIJISHOU_FILE_URI", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getDAIJISHOU_FILE_URI() {
            return DaijishouUriHandler.DAIJISHOU_FILE_URI;
        }

        public final String getDAIJISHOU_FILE_FILES_BASE_URI() {
            return DaijishouUriHandler.DAIJISHOU_FILE_FILES_BASE_URI;
        }

        public final String getDAIJISHOU_FILE_TEMP_FILES_BASE_URI() {
            return DaijishouUriHandler.DAIJISHOU_FILE_TEMP_FILES_BASE_URI;
        }

        public final String getDAIJISHOU_FILE_CACHE_BASE_URI() {
            return DaijishouUriHandler.DAIJISHOU_FILE_CACHE_BASE_URI;
        }

        public final String getDAIJISHOU_FILE_EXTENSION_MANAGER_RUNTIME_INSTALLED_BASE_URI() {
            return DaijishouUriHandler.DAIJISHOU_FILE_EXTENSION_MANAGER_RUNTIME_INSTALLED_BASE_URI;
        }

        public final String getDAIJISHOU_FILE_EXTENSION_MANAGER_RUNTIME_FILES_BASE_URI() {
            return DaijishouUriHandler.DAIJISHOU_FILE_EXTENSION_MANAGER_RUNTIME_FILES_BASE_URI;
        }

        public final String getDAIJISHOU_FILE_EXTENSION_MANAGER_RUNTIME_CACHE_BASE_URI() {
            return DaijishouUriHandler.DAIJISHOU_FILE_EXTENSION_MANAGER_RUNTIME_CACHE_BASE_URI;
        }

        public final String getDAIJISHOU_EXTENSION_BASE_URI() {
            return DaijishouUriHandler.DAIJISHOU_EXTENSION_BASE_URI;
        }
    }

    public DaijishouUriHandler(DaijishouApplication application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.application = application;
        String absolutePath = application.getFilesDir().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        this.filesDirAbsolutePath = absolutePath;
        Path path = Paths.get(application.getFilesDir().getAbsolutePath(), "temp");
        Intrinsics.checkNotNullExpressionValue(path, "get(...)");
        String string = path.toAbsolutePath().toString();
        this.tempFilesDirAbsolutePath = string;
        String absolutePath2 = application.getCacheDir().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath2, "getAbsolutePath(...)");
        this.cacheDirAbsolutePath = absolutePath2;
        this.fileUriToPathHashMap = MapsKt.hashMapOf(TuplesKt.to(DAIJISHOU_FILE_FILES_BASE_URI, absolutePath), TuplesKt.to(DAIJISHOU_FILE_TEMP_FILES_BASE_URI, string), TuplesKt.to(DAIJISHOU_FILE_CACHE_BASE_URI, absolutePath2));
        this.extensionFileUriToPathHashMap = new HashMap<>();
        this.extensionUriToPathHashMap = new HashMap<>();
    }

    public final DaijishouApplication getApplication() {
        return this.application;
    }

    public final String getFilesDirAbsolutePath() {
        return this.filesDirAbsolutePath;
    }

    public final String getTempFilesDirAbsolutePath() {
        return this.tempFilesDirAbsolutePath;
    }

    public final String getCacheDirAbsolutePath() {
        return this.cacheDirAbsolutePath;
    }

    public final HashMap<String, String> getFileUriToPathHashMap() {
        return this.fileUriToPathHashMap;
    }

    public final HashMap<String, String> getExtensionFileUriToPathHashMap() {
        return this.extensionFileUriToPathHashMap;
    }

    public final HashMap<String, String> getExtensionUriToPathHashMap() {
        return this.extensionUriToPathHashMap;
    }

    public final boolean isDaijishouFileUri(String uriString) {
        Intrinsics.checkNotNullParameter(uriString, "uriString");
        URI uriNormalize;
        try {
            uriNormalize = new URI(uriString).normalize();
        } catch (java.net.URISyntaxException e) {
            return false;
        }
        if (uriNormalize == null) {
            return false;
        }
        String string = uriNormalize.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this.application.getLogger().debug(this, string);
        return StringsKt.startsWith$default(string, DAIJISHOU_FILE_URI, false, 2, (Object) null);
    }

    public final String encodeToDaijishouFileUri(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        Path absolutePath = Paths.get(path, new String[0]).toAbsolutePath();
        if (absolutePath == null) {
            return null;
        }
        String string = absolutePath.toString();
        for (Map.Entry<String, String> entry : this.fileUriToPathHashMap.entrySet()) {
            String key = entry.getKey();
            if (StringsKt.startsWith$default(entry.getValue(), this.filesDirAbsolutePath, false, 2, (Object) null)) {
                return StringsKt.replace$default(string, this.filesDirAbsolutePath, key, false, 4, (Object) null);
            }
        }
        return null;
    }

    public final String decodeFromDaijishouFileUri(String uriString) {
        Intrinsics.checkNotNullParameter(uriString, "uriString");
        URI uriNormalize;
        try {
            uriNormalize = new URI(uriString).normalize();
        } catch (java.net.URISyntaxException e) {
            return null;
        }
        if (uriNormalize == null) {
            return null;
        }
        String string = uriNormalize.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        for (Map.Entry<String, String> entry : this.fileUriToPathHashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (StringsKt.startsWith$default(string, key, false, 2, (Object) null)) {
                return StringsKt.replace$default(string, key, value, false, 4, (Object) null);
            }
        }
        return null;
    }

    public final void initializeFilesAndDirectories() {
        File file = new File(this.tempFilesDirAbsolutePath);
        try {
            FileUtils.deleteDirectory(file);
        } catch (java.io.IOException e) {
        }
        if (file.exists()) {
            return;
        }
        file.mkdir();
    }
}
