package org.retroachivements.api.data.pojo;

import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: ErrorResponse.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0016B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lorg/retroachivements/api/data/pojo/ErrorResponse;", "", "message", "", "errors", "Ljava/util/ArrayList;", "Lorg/retroachivements/api/data/pojo/ErrorResponse$Error;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/util/ArrayList;)V", "getErrors", "()Ljava/util/ArrayList;", "getMessage", "()Ljava/lang/String;", "component1", "component2", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "Error", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class ErrorResponse {
    private final ArrayList<Error> errors;
    private final String message;

    /* WARN: Multi-variable type inference failed */
    public static /* synthetic */ ErrorResponse copy$default(ErrorResponse errorResponse, String str, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = errorResponse.message;
        }
        if ((i & 2) != 0) {
            arrayList = errorResponse.errors;
        }
        return errorResponse.copy(str, arrayList);
    }

    /* INFO: renamed from: component1, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final ArrayList<Error> component2() {
        return this.errors;
    }

    public final ErrorResponse copy(String message, ArrayList<Error> errors) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(errors, "errors");
        return new ErrorResponse(message, errors);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ErrorResponse)) {
            return false;
        }
        ErrorResponse errorResponse = (ErrorResponse) other;
        return Intrinsics.areEqual(this.message, errorResponse.message) && Intrinsics.areEqual(this.errors, errorResponse.errors);
    }

    public int hashCode() {
        return (this.message.hashCode() * 31) + this.errors.hashCode();
    }

    public String toString() {
        return "ErrorResponse(message=" + this.message + ", errors=" + this.errors + ')';
    }

    public ErrorResponse(String message, ArrayList<Error> errors) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(errors, "errors");
        this.message = message;
        this.errors = errors;
    }

    public final String getMessage() {
        return this.message;
    }

    public final ArrayList<Error> getErrors() {
        return this.errors;
    }

    /* INFO: compiled from: ErrorResponse.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016"}, d2 = {"Lorg/retroachivements/api/data/pojo/ErrorResponse$Error;", "", NotificationCompat.CATEGORY_STATUS, "", "code", "", "title", "(ILjava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getStatus", "()I", "getTitle", "component1", "component2", "component3", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Error {
        private final String code;
        private final int status;
        private final String title;

        public static /* synthetic */ Error copy$default(Error error, int i, String str, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = error.status;
            }
            if ((i2 & 2) != 0) {
                str = error.code;
            }
            if ((i2 & 4) != 0) {
                str2 = error.title;
            }
            return error.copy(i, str, str2);
        }

        /* INFO: renamed from: component1, reason: from getter */
        public final int getStatus() {
            return this.status;
        }

        /* INFO: renamed from: component2, reason: from getter */
        public final String getCode() {
            return this.code;
        }

        /* INFO: renamed from: component3, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public final Error copy(int status, String code, String title) {
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(title, "title");
            return new Error(status, code, title);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Error)) {
                return false;
            }
            Error error = (Error) other;
            return this.status == error.status && Intrinsics.areEqual(this.code, error.code) && Intrinsics.areEqual(this.title, error.title);
        }

        public int hashCode() {
            return (((Integer.hashCode(this.status) * 31) + this.code.hashCode()) * 31) + this.title.hashCode();
        }

        public String toString() {
            return "Error(status=" + this.status + ", code=" + this.code + ", title=" + this.title + ')';
        }

        public Error(int i, String code, String title) {
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(title, "title");
            this.status = i;
            this.code = code;
            this.title = title;
        }

        public final int getStatus() {
            return this.status;
        }

        public final String getCode() {
            return this.code;
        }

        public final String getTitle() {
            return this.title;
        }
    }
}
