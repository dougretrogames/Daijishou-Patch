package com.magneticchen.daijishou.utils;

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

/* JADX INFO: compiled from: DaijishouUriHandler.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\bJ\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\nj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/magneticchen/daijishou/utils/DaijishouUriHandler;", "", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "(Lcom/magneticchen/daijishou/DaijishouApplication;)V", "getApplication", "()Lcom/magneticchen/daijishou/DaijishouApplication;", "cacheDirAbsolutePath", "", "fileUriToPathHashMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "filesDirAbsolutePath", "tempFilesDirAbsolutePath", "getTempFilesDirAbsolutePath", "()Ljava/lang/String;", "decodeFromDaijishouFileUri", "uriString", "initializeFilesAndDirectories", "", "isDaijishouFileUri", "", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouUriHandler {
    public static final Companion Companion = new Companion(null);
    public static final String DAIJISHOU_FILE_CACHE_BASE_URI = "daijishou-file://cache";
    public static final String DAIJISHOU_FILE_FILES_BASE_URI = "daijishou-file://files";
    public static final String DAIJISHOU_FILE_TEMP_FILES_BASE_URI = "daijishou-file://files/temp";
    public static final String DAIJISHOU_FILE_URI = "daijishou-file://";
    private final DaijishouApplication application;
    private final String cacheDirAbsolutePath;
    private final HashMap<String, String> fileUriToPathHashMap;
    private final String filesDirAbsolutePath;
    private final String tempFilesDirAbsolutePath;

    public DaijishouUriHandler(DaijishouApplication application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.application = application;
        Path path = Paths.get(application.getFilesDir().getAbsolutePath(), "temp");
        Intrinsics.checkNotNullExpressionValue(path, "get(...)");
        String string = path.toAbsolutePath().toString();
        this.tempFilesDirAbsolutePath = string;
        String absolutePath = application.getFilesDir().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        this.filesDirAbsolutePath = absolutePath;
        String absolutePath2 = application.getCacheDir().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath2, "getAbsolutePath(...)");
        this.cacheDirAbsolutePath = absolutePath2;
        this.fileUriToPathHashMap = MapsKt.hashMapOf(TuplesKt.to(DAIJISHOU_FILE_FILES_BASE_URI, absolutePath), TuplesKt.to(DAIJISHOU_FILE_TEMP_FILES_BASE_URI, string), TuplesKt.to(DAIJISHOU_FILE_CACHE_BASE_URI, absolutePath2));
    }

    public final DaijishouApplication getApplication() {
        return this.application;
    }

    public final String getTempFilesDirAbsolutePath() {
        return this.tempFilesDirAbsolutePath;
    }

    /* JADX INFO: compiled from: DaijishouUriHandler.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/magneticchen/daijishou/utils/DaijishouUriHandler$Companion;", "", "()V", "DAIJISHOU_FILE_CACHE_BASE_URI", "", "DAIJISHOU_FILE_FILES_BASE_URI", "DAIJISHOU_FILE_TEMP_FILES_BASE_URI", "DAIJISHOU_FILE_URI", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final boolean isDaijishouFileUri(String uriString) {
        Intrinsics.checkNotNullParameter(uriString, "uriString");
        URI uriNormalize;
        try {
            uriNormalize = new URI(uriString).normalize();
        } catch (Exception e) {
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

    public final String decodeFromDaijishouFileUri(String uriString) {
        Intrinsics.checkNotNullParameter(uriString, "uriString");
        URI uriNormalize;
        try {
            uriNormalize = new URI(uriString).normalize();
        } catch (Exception e) {
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
            org.apache.commons.io.FileUtils.deleteDirectory(file);
        } catch (Exception e) {}
        if (file.exists()) {
            return;
        }
        file.mkdir();
    }
}
