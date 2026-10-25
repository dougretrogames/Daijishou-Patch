package com.magneticchen.daijishou.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import com.magneticchen.daijishou.DaijishouApplication;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.collections4.CollectionUtils;

/* JADX INFO: compiled from: FileUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J;\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0019\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u000fJ\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\u0018"}, d2 = {"Lcom/magneticchen/daijishou/utils/FileUtils;", "", "()V", "getDataColumn", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "selection", "selectionArgs", "", "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "getFilePath", "getMountedPaths", "(Landroid/content/Context;)[Ljava/lang/String;", "getPathFromExternalStorage", "getPathFromMedia", "getPrimaryStoragePath", "isDownloadsDocument", "", "isExternalStorageDocument", "isMediaDocument", "isVirtualFile", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FileUtils {
    public static final FileUtils INSTANCE = new FileUtils();

    private FileUtils() {
    }

    public final String getFilePath(Context context, Uri uri) {
        try {
            String pathFromMedia;
            String dataColumn;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            if (DocumentsContract.isDocumentUri(context, uri)) {
                if (isVirtualFile(context, uri)) {
                    throw new Exception("VirtualFile is not supported.\nURI: " + uri);
                }
                if (isDownloadsDocument(uri)) {
                    throw new Exception("DownloadsDocument is not supported.\nURI: " + uri);
                }
                if (StringsKt.equals("content", uri.getScheme(), true) && StringsKt.equals(uri.getHost(), "com.android.providers", true) && (dataColumn = getDataColumn(context, uri, null, null)) != null) {
                    return dataColumn;
                }
                if (StringsKt.equals("file", uri.getScheme(), true) && uri.getPath() != null) {
                    String path = uri.getPath();
                    Intrinsics.checkNotNull(path);
                    return path;
                }
                if (isExternalStorageDocument(uri)) {
                    return getPathFromExternalStorage(context, uri);
                }
                if (isMediaDocument(uri) && (pathFromMedia = getPathFromMedia(context, uri)) != null) {
                    return pathFromMedia;
                }
                try {
                    return getPathFromExternalStorage(context, uri);
                } catch (Exception unused) {
                    throw new Exception("The URI is unsupported.\nURI: " + uri);
                }
            }
            throw new Exception("The URI is unsupported.\nURI: " + uri);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    private final boolean isVirtualFile(Context context, Uri uri) {
        if (!DocumentsContract.isDocumentUri(context, uri)) {
            return false;
        }
        Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"flags"}, null, null, null);
        Intrinsics.checkNotNull(cursorQuery);
        int i = cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        cursorQuery.close();
        return (i & 512) != 0;
    }

    private final boolean isExternalStorageDocument(Uri uri) {
        return Intrinsics.areEqual("com.android.externalstorage.documents", uri.getAuthority());
    }

    public final boolean isDownloadsDocument(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return Intrinsics.areEqual("com.android.providers.downloads.documents", uri.getAuthority());
    }

    private final boolean isMediaDocument(Uri uri) {
        return Intrinsics.areEqual("com.android.providers.media.documents", uri.getAuthority());
    }

    private final String getPathFromExternalStorage(Context context, Uri uri) {
        String documentId = DocumentsContract.getDocumentId(uri);
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        DaijishouApplication.WrappedLogger logger = ((DaijishouApplication) applicationContext).getLogger();
        Intrinsics.checkNotNull(documentId);
        logger.debug(this, documentId);
        for (String str : getMountedPaths(context)) {
            logger.debug(this, str);
        }
        String[] strArr = (String[]) StringsKt.split$default((CharSequence) documentId, new String[]{CollectionUtils.COLON}, false, 2, 2, (Object) null).toArray(new String[0]);
        String str2 = strArr[0];
        if (StringsKt.equals("primary", str2, true) || StringsKt.equals("home", str2, true)) {
            return getPrimaryStoragePath() + InternalZipConstants.ZIP_FILE_SEPARATOR + strArr[1];
        }
        for (String str3 : getMountedPaths(context)) {
            if (StringsKt.contains$default((CharSequence) str3, (CharSequence) str2, false, 2, (Object) null)) {
                return str3 + InternalZipConstants.ZIP_FILE_SEPARATOR + strArr[1];
            }
        }
        return "/storage/" + str2 + InternalZipConstants.ZIP_FILE_SEPARATOR + strArr[1];
    }

    /* JADX WARN: Code duplicated, block: B:19:0x005a  */
    private final String getPathFromMedia(Context context, Uri uri) {
        Uri uri2;
        String documentId = DocumentsContract.getDocumentId(uri);
        Intrinsics.checkNotNull(documentId);
        String[] strArr = (String[]) StringsKt.split$default((CharSequence) documentId, new String[]{CollectionUtils.COLON}, false, 2, 2, (Object) null).toArray(new String[0]);
        String str = strArr[0];
        int iHashCode = str.hashCode();
        if (iHashCode != 93166550) {
            if (iHashCode != 100313435) {
                if (iHashCode == 112202875 && str.equals("video")) {
                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else {
                    uri2 = null;
                }
            } else if (str.equals("image")) {
                uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else {
                uri2 = null;
            }
        } else if (str.equals("audio")) {
            uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        } else {
            uri2 = null;
        }
        return getDataColumn(context, uri2, "_id=?", new String[]{strArr[1]});
    }

    private final String getDataColumn(Context context, Uri uri, String selection, String[] selectionArgs) {
        String[] strArr = {"_data"};
        ContentResolver contentResolver = context.getContentResolver();
        Intrinsics.checkNotNull(uri);
        Cursor cursorQuery = contentResolver.query(uri, strArr, selection, selectionArgs, null);
        if (cursorQuery == null) {
            return null;
        }
        try {
            if (cursorQuery.moveToFirst()) {
                return cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
            }
            return null;
        } finally {
            cursorQuery.close();
        }
    }

    private final String getPrimaryStoragePath() {
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        return absolutePath;
    }

    public final String[] getMountedPaths(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("storage");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.storage.StorageManager");
        List<StorageVolume> storageVolumes = ((StorageManager) systemService).getStorageVolumes();
        Intrinsics.checkNotNullExpressionValue(storageVolumes, "getStorageVolumes(...)");
        ArrayList<File> arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 30) {
            Iterator<StorageVolume> it = storageVolumes.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getDirectory());
            }
        } else {
            try {
                Method method = StorageVolume.class.getMethod("getPathFile", new Class[0]);
                Intrinsics.checkNotNullExpressionValue(method, "getMethod(...)");
                Iterator<StorageVolume> it2 = storageVolumes.iterator();
                while (it2.hasNext()) {
                    Object objInvoke = method.invoke(it2.next(), new Object[0]);
                    Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type java.io.File");
                    arrayList.add((File) objInvoke);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (File file : arrayList) {
            if (file != null) {
                String absolutePath = file.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                arrayList2.add(absolutePath);
            }
        }
        return (String[]) arrayList2.toArray(new String[0]);
    }
}
