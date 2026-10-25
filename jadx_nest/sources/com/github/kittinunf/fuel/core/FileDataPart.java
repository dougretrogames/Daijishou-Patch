package com.github.kittinunf.fuel.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLConnection;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: DataPart.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J=\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\b\u0010!\u001a\u00020\"H\u0016J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0007\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000b¨\u0006%"}, d2 = {"Lcom/github/kittinunf/fuel/core/FileDataPart;", "Lcom/github/kittinunf/fuel/core/DataPart;", "file", "Ljava/io/File;", "name", "", "filename", "contentType", "contentDisposition", "(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContentDisposition", "()Ljava/lang/String;", "contentLength", "", "getContentLength", "()Ljava/lang/Long;", "getContentType", "getFile", "()Ljava/io/File;", "getFilename", "getName", "component1", "component2", "component3", "component4", "component5", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "", "hashCode", "", "inputStream", "Ljava/io/FileInputStream;", "toString", "Companion", "fuel"}, k = 1, mv = {1, 4, 0})
public final /* data */ class FileDataPart extends DataPart {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String contentDisposition;
    private final String contentType;
    private final File file;
    private final String filename;
    private final String name;

    public static /* synthetic */ FileDataPart copy$default(FileDataPart fileDataPart, File file, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            file = fileDataPart.file;
        }
        if ((i & 2) != 0) {
            str = fileDataPart.name;
        }
        if ((i & 4) != 0) {
            str2 = fileDataPart.filename;
        }
        if ((i & 8) != 0) {
            str3 = fileDataPart.getContentType();
        }
        if ((i & 16) != 0) {
            str4 = fileDataPart.getContentDisposition();
        }
        String str5 = str4;
        String str6 = str2;
        return fileDataPart.copy(file, str, str6, str3, str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final File getFile() {
        return this.file;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFilename() {
        return this.filename;
    }

    public final String component4() {
        return getContentType();
    }

    public final String component5() {
        return getContentDisposition();
    }

    public final FileDataPart copy(File file, String name, String filename, String contentType, String contentDisposition) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(contentDisposition, "contentDisposition");
        return new FileDataPart(file, name, filename, contentType, contentDisposition);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileDataPart)) {
            return false;
        }
        FileDataPart fileDataPart = (FileDataPart) other;
        return Intrinsics.areEqual(this.file, fileDataPart.file) && Intrinsics.areEqual(this.name, fileDataPart.name) && Intrinsics.areEqual(this.filename, fileDataPart.filename) && Intrinsics.areEqual(getContentType(), fileDataPart.getContentType()) && Intrinsics.areEqual(getContentDisposition(), fileDataPart.getContentDisposition());
    }

    public int hashCode() {
        File file = this.file;
        int iHashCode = (file != null ? file.hashCode() : 0) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.filename;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String contentType = getContentType();
        int iHashCode4 = (iHashCode3 + (contentType != null ? contentType.hashCode() : 0)) * 31;
        String contentDisposition = getContentDisposition();
        return iHashCode4 + (contentDisposition != null ? contentDisposition.hashCode() : 0);
    }

    public String toString() {
        return "FileDataPart(file=" + this.file + ", name=" + this.name + ", filename=" + this.filename + ", contentType=" + getContentType() + ", contentDisposition=" + getContentDisposition() + ")";
    }

    public final File getFile() {
        return this.file;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ FileDataPart(File file, String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        String nameWithoutExtension = (i & 2) != 0 ? FilesKt.getNameWithoutExtension(file) : str;
        String name = (i & 4) != 0 ? file.getName() : str2;
        String strGuessContentType = (i & 8) != 0 ? INSTANCE.guessContentType(file) : str3;
        if ((i & 16) != 0) {
            str4 = "form-data; name=\"" + nameWithoutExtension + '\"' + (name != null ? "; filename=\"" + name + '\"' : "");
        }
        this(file, nameWithoutExtension, name, strGuessContentType, str4);
    }

    public final String getName() {
        return this.name;
    }

    public final String getFilename() {
        return this.filename;
    }

    @Override // com.github.kittinunf.fuel.core.DataPart
    public String getContentType() {
        return this.contentType;
    }

    @Override // com.github.kittinunf.fuel.core.DataPart
    public String getContentDisposition() {
        return this.contentDisposition;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileDataPart(File file, String name, String str, String contentType, String contentDisposition) {
        super(null);
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(contentDisposition, "contentDisposition");
        this.file = file;
        this.name = name;
        this.filename = str;
        this.contentType = contentType;
        this.contentDisposition = contentDisposition;
    }

    @Override // com.github.kittinunf.fuel.core.DataPart
    public FileInputStream inputStream() {
        return new FileInputStream(this.file);
    }

    @Override // com.github.kittinunf.fuel.core.DataPart
    public Long getContentLength() {
        return Long.valueOf(this.file.length());
    }

    /* JADX INFO: compiled from: DataPart.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\bJ:\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\bJ2\u0010\u0003\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\bJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006¨\u0006\u000f"}, d2 = {"Lcom/github/kittinunf/fuel/core/FileDataPart$Companion;", "", "()V", TypedValues.TransitionType.S_FROM, "Lcom/github/kittinunf/fuel/core/DataPart;", "directory", "Ljava/io/File;", "filename", "", "name", "remoteFileName", "contentType", "path", "guessContentType", "file", "fuel"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String guessContentType(File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            try {
                String strGuessContentTypeFromName = URLConnection.guessContentTypeFromName(file.getName());
                return strGuessContentTypeFromName != null ? strGuessContentTypeFromName : BlobDataPart.INSTANCE.guessContentType(new FileInputStream(file));
            } catch (NoClassDefFoundError unused) {
                return "application/octet-stream";
            }
        }

        public static /* synthetic */ DataPart from$default(Companion companion, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = "";
            }
            if ((i & 4) != 0) {
                str3 = null;
            }
            if ((i & 8) != 0) {
                str4 = null;
            }
            return companion.from(str, str2, str3, str4);
        }

        public final DataPart from(String path, String remoteFileName, String name, String contentType) {
            Intrinsics.checkNotNullParameter(path, "path");
            File file = new File(path);
            if (name == null) {
                name = FilesKt.getNameWithoutExtension(file);
            }
            String str = name;
            if (remoteFileName == null) {
                remoteFileName = null;
            } else if (StringsKt.isBlank(remoteFileName)) {
                remoteFileName = file.getName();
            }
            String str2 = remoteFileName;
            if (contentType == null) {
                contentType = guessContentType(file);
            }
            return new FileDataPart(file, str, str2, contentType, null, 16, null);
        }

        public static /* synthetic */ DataPart from$default(Companion companion, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            String str6;
            String str7;
            if ((i & 4) != 0) {
                str6 = null;
            } else {
                str6 = str3;
            }
            if ((i & 8) != 0) {
                str4 = "";
            }
            String str8 = str4;
            if ((i & 16) != 0) {
                str7 = null;
            } else {
                str7 = str5;
            }
            return companion.from(str, str2, str6, str8, str7);
        }

        public final DataPart from(String directory, String filename, String name, String remoteFileName, String contentType) {
            String str;
            Intrinsics.checkNotNullParameter(directory, "directory");
            Intrinsics.checkNotNullParameter(filename, "filename");
            return (new File(directory).isFile() && ((str = remoteFileName) == null || StringsKt.isBlank(str))) ? from(directory, filename, name, contentType) : from(new File(directory), filename, name, remoteFileName, contentType);
        }

        public static /* synthetic */ DataPart from$default(Companion companion, File file, String str, String str2, String str3, String str4, int i, Object obj) {
            String str5;
            String str6;
            if ((i & 4) != 0) {
                str5 = null;
            } else {
                str5 = str2;
            }
            if ((i & 8) != 0) {
                str3 = "";
            }
            String str7 = str3;
            if ((i & 16) != 0) {
                str6 = null;
            } else {
                str6 = str4;
            }
            return companion.from(file, str, str5, str7, str6);
        }

        public final DataPart from(File directory, String filename, String name, String remoteFileName, String contentType) {
            Intrinsics.checkNotNullParameter(filename, "filename");
            File file = new File(directory, filename);
            if (name == null) {
                name = FilesKt.getNameWithoutExtension(file);
            }
            String str = name;
            if (remoteFileName == null) {
                filename = null;
            } else if (!StringsKt.isBlank(remoteFileName)) {
                filename = remoteFileName;
            }
            String str2 = filename;
            if (contentType == null) {
                contentType = guessContentType(file);
            }
            return new FileDataPart(file, str, str2, contentType, null, 16, null);
        }
    }
}
