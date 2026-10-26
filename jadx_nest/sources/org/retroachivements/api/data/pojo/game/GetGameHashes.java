package org.retroachivements.api.data.pojo.game;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: GetGameHashes.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lorg/retroachivements/api/data/pojo/game/GetGameHashes;", "", "()V", "Response", "Result", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetGameHashes {

    /* INFO: compiled from: GetGameHashes.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lorg/retroachivements/api/data/pojo/game/GetGameHashes$Response;", "", "results", "", "Lorg/retroachivements/api/data/pojo/game/GetGameHashes$Result;", "(Ljava/util/List;)V", "getResults", "()Ljava/util/List;", "component1", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Response {

        @SerializedName("Results")
        private final List<Result> results;

        /* WARN: Multi-variable type inference failed */
        public static /* synthetic */ Response copy$default(Response response, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = response.results;
            }
            return response.copy(list);
        }

        public final List<Result> component1() {
            return this.results;
        }

        public final Response copy(List<Result> results) {
            Intrinsics.checkNotNullParameter(results, "results");
            return new Response(results);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Response) && Intrinsics.areEqual(this.results, ((Response) other).results);
        }

        public int hashCode() {
            return this.results.hashCode();
        }

        public String toString() {
            return "Response(results=" + this.results + ')';
        }

        public Response(List<Result> results) {
            Intrinsics.checkNotNullParameter(results, "results");
            this.results = results;
        }

        public final List<Result> getResults() {
            return this.results;
        }
    }

    /* INFO: compiled from: GetGameHashes.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, d2 = {"Lorg/retroachivements/api/data/pojo/game/GetGameHashes$Result;", "", "name", "", "md5", "labels", "", "patchUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getLabels", "()Ljava/util/List;", "getMd5", "()Ljava/lang/String;", "getName", "getPatchUrl", "component1", "component2", "component3", "component4", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Result {

        @SerializedName("Labels")
        private final List<String> labels;

        @SerializedName(MessageDigestAlgorithms.MD5)
        private final String md5;

        @SerializedName("Name")
        private final String name;

        @SerializedName("PatchUrl")
        private final String patchUrl;

        /* WARN: Multi-variable type inference failed */
        public static /* synthetic */ Result copy$default(Result result, String str, String str2, List list, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = result.name;
            }
            if ((i & 2) != 0) {
                str2 = result.md5;
            }
            if ((i & 4) != 0) {
                list = result.labels;
            }
            if ((i & 8) != 0) {
                str3 = result.patchUrl;
            }
            return result.copy(str, str2, list, str3);
        }

        /* INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* INFO: renamed from: component2, reason: from getter */
        public final String getMd5() {
            return this.md5;
        }

        public final List<String> component3() {
            return this.labels;
        }

        /* INFO: renamed from: component4, reason: from getter */
        public final String getPatchUrl() {
            return this.patchUrl;
        }

        public final Result copy(String name, String md5, List<String> labels, String patchUrl) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(md5, "md5");
            Intrinsics.checkNotNullParameter(labels, "labels");
            return new Result(name, md5, labels, patchUrl);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Result)) {
                return false;
            }
            Result result = (Result) other;
            return Intrinsics.areEqual(this.name, result.name) && Intrinsics.areEqual(this.md5, result.md5) && Intrinsics.areEqual(this.labels, result.labels) && Intrinsics.areEqual(this.patchUrl, result.patchUrl);
        }

        public int hashCode() {
            int iHashCode = ((((this.name.hashCode() * 31) + this.md5.hashCode()) * 31) + this.labels.hashCode()) * 31;
            String str = this.patchUrl;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Result(name=" + this.name + ", md5=" + this.md5 + ", labels=" + this.labels + ", patchUrl=" + this.patchUrl + ')';
        }

        public Result(String name, String md5, List<String> labels, String str) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(md5, "md5");
            Intrinsics.checkNotNullParameter(labels, "labels");
            this.name = name;
            this.md5 = md5;
            this.labels = labels;
            this.patchUrl = str;
        }

        public final String getName() {
            return this.name;
        }

        public final String getMd5() {
            return this.md5;
        }

        public final List<String> getLabels() {
            return this.labels;
        }

        public final String getPatchUrl() {
            return this.patchUrl;
        }
    }
}
