package org.retroachivements.api.data.pojo.game;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: GetGameProgression.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lorg/retroachivements/api/data/pojo/game/GetGameProgression;", "", "()V", "Response", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetGameProgression {

    /* JADX INFO: compiled from: GetGameProgression.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001@B\u008b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0002\u0010\u0016J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J¯\u0001\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014HÆ\u0001J\u0013\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020\u0003HÖ\u0001J\t\u0010?\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001c¨\u0006A"}, d2 = {"Lorg/retroachivements/api/data/pojo/game/GetGameProgression$Response;", "", "id", "", "title", "", "consoleId", "consoleName", "imageIcon", "numDistinctPlayers", "timesUsedInBeatMedian", "timesUsedInHardcoreBeatMedia", "medianTimeToBeat", "medianTimeToBeatHardcore", "timesUsedInCompletionMedian", "timesUsedInMasteryMedian", "mediaTimeToComplete", "medianTimeToMaster", "numAchievements", "achievements", "", "Lorg/retroachivements/api/data/pojo/game/GetGameProgression$Response$Achievement;", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;IIIIIIIIIILjava/util/List;)V", "getAchievements", "()Ljava/util/List;", "getConsoleId", "()I", "getConsoleName", "()Ljava/lang/String;", "getId", "getImageIcon", "getMediaTimeToComplete", "getMedianTimeToBeat", "getMedianTimeToBeatHardcore", "getMedianTimeToMaster", "getNumAchievements", "getNumDistinctPlayers", "getTimesUsedInBeatMedian", "getTimesUsedInCompletionMedian", "getTimesUsedInHardcoreBeatMedia", "getTimesUsedInMasteryMedian", "getTitle", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "toString", "Achievement", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Response {

        @SerializedName("Achievements")
        private final List<Achievement> achievements;

        @SerializedName("ConsoleID")
        private final int consoleId;

        @SerializedName("ConsoleName")
        private final String consoleName;

        @SerializedName("ID")
        private final int id;

        @SerializedName("ImageIcon")
        private final String imageIcon;

        @SerializedName("MedianTimeToComplete")
        private final int mediaTimeToComplete;

        @SerializedName("MedianTimeToBeat")
        private final int medianTimeToBeat;

        @SerializedName("MedianTimeToBeatHardcore")
        private final int medianTimeToBeatHardcore;

        @SerializedName("MedianTimeToMaster")
        private final int medianTimeToMaster;

        @SerializedName("NumAchievements")
        private final int numAchievements;

        @SerializedName("NumDistinctPlayers")
        private final int numDistinctPlayers;

        @SerializedName("TimesUsedInBeatMedian")
        private final int timesUsedInBeatMedian;

        @SerializedName("TimesUsedInCompletionMedian")
        private final int timesUsedInCompletionMedian;

        @SerializedName("TimesUsedInHardcoreBeatMedian")
        private final int timesUsedInHardcoreBeatMedia;

        @SerializedName("TimesUsedInMasteryMedian")
        private final int timesUsedInMasteryMedian;

        @SerializedName("Title")
        private final String title;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Response copy$default(Response response, int i, String str, int i2, String str2, String str3, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, List list, int i13, Object obj) {
            int i14 = (i13 & 1) != 0 ? response.id : i;
            return response.copy(i14, (i13 & 2) != 0 ? response.title : str, (i13 & 4) != 0 ? response.consoleId : i2, (i13 & 8) != 0 ? response.consoleName : str2, (i13 & 16) != 0 ? response.imageIcon : str3, (i13 & 32) != 0 ? response.numDistinctPlayers : i3, (i13 & 64) != 0 ? response.timesUsedInBeatMedian : i4, (i13 & 128) != 0 ? response.timesUsedInHardcoreBeatMedia : i5, (i13 & 256) != 0 ? response.medianTimeToBeat : i6, (i13 & 512) != 0 ? response.medianTimeToBeatHardcore : i7, (i13 & 1024) != 0 ? response.timesUsedInCompletionMedian : i8, (i13 & 2048) != 0 ? response.timesUsedInMasteryMedian : i9, (i13 & 4096) != 0 ? response.mediaTimeToComplete : i10, (i13 & 8192) != 0 ? response.medianTimeToMaster : i11, (i13 & 16384) != 0 ? response.numAchievements : i12, (i13 & 32768) != 0 ? response.achievements : list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final int getMedianTimeToBeatHardcore() {
            return this.medianTimeToBeatHardcore;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final int getTimesUsedInCompletionMedian() {
            return this.timesUsedInCompletionMedian;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final int getTimesUsedInMasteryMedian() {
            return this.timesUsedInMasteryMedian;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final int getMediaTimeToComplete() {
            return this.mediaTimeToComplete;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final int getMedianTimeToMaster() {
            return this.medianTimeToMaster;
        }

        /* JADX INFO: renamed from: component15, reason: from getter */
        public final int getNumAchievements() {
            return this.numAchievements;
        }

        public final List<Achievement> component16() {
            return this.achievements;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getConsoleId() {
            return this.consoleId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getConsoleName() {
            return this.consoleName;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getImageIcon() {
            return this.imageIcon;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final int getNumDistinctPlayers() {
            return this.numDistinctPlayers;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final int getTimesUsedInBeatMedian() {
            return this.timesUsedInBeatMedian;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final int getTimesUsedInHardcoreBeatMedia() {
            return this.timesUsedInHardcoreBeatMedia;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final int getMedianTimeToBeat() {
            return this.medianTimeToBeat;
        }

        public final Response copy(int id2, String title, int consoleId, String consoleName, String imageIcon, int numDistinctPlayers, int timesUsedInBeatMedian, int timesUsedInHardcoreBeatMedia, int medianTimeToBeat, int medianTimeToBeatHardcore, int timesUsedInCompletionMedian, int timesUsedInMasteryMedian, int mediaTimeToComplete, int medianTimeToMaster, int numAchievements, List<Achievement> achievements) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(consoleName, "consoleName");
            Intrinsics.checkNotNullParameter(imageIcon, "imageIcon");
            Intrinsics.checkNotNullParameter(achievements, "achievements");
            return new Response(id2, title, consoleId, consoleName, imageIcon, numDistinctPlayers, timesUsedInBeatMedian, timesUsedInHardcoreBeatMedia, medianTimeToBeat, medianTimeToBeatHardcore, timesUsedInCompletionMedian, timesUsedInMasteryMedian, mediaTimeToComplete, medianTimeToMaster, numAchievements, achievements);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Response)) {
                return false;
            }
            Response response = (Response) other;
            return this.id == response.id && Intrinsics.areEqual(this.title, response.title) && this.consoleId == response.consoleId && Intrinsics.areEqual(this.consoleName, response.consoleName) && Intrinsics.areEqual(this.imageIcon, response.imageIcon) && this.numDistinctPlayers == response.numDistinctPlayers && this.timesUsedInBeatMedian == response.timesUsedInBeatMedian && this.timesUsedInHardcoreBeatMedia == response.timesUsedInHardcoreBeatMedia && this.medianTimeToBeat == response.medianTimeToBeat && this.medianTimeToBeatHardcore == response.medianTimeToBeatHardcore && this.timesUsedInCompletionMedian == response.timesUsedInCompletionMedian && this.timesUsedInMasteryMedian == response.timesUsedInMasteryMedian && this.mediaTimeToComplete == response.mediaTimeToComplete && this.medianTimeToMaster == response.medianTimeToMaster && this.numAchievements == response.numAchievements && Intrinsics.areEqual(this.achievements, response.achievements);
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.consoleId)) * 31) + this.consoleName.hashCode()) * 31) + this.imageIcon.hashCode()) * 31) + Integer.hashCode(this.numDistinctPlayers)) * 31) + Integer.hashCode(this.timesUsedInBeatMedian)) * 31) + Integer.hashCode(this.timesUsedInHardcoreBeatMedia)) * 31) + Integer.hashCode(this.medianTimeToBeat)) * 31) + Integer.hashCode(this.medianTimeToBeatHardcore)) * 31) + Integer.hashCode(this.timesUsedInCompletionMedian)) * 31) + Integer.hashCode(this.timesUsedInMasteryMedian)) * 31) + Integer.hashCode(this.mediaTimeToComplete)) * 31) + Integer.hashCode(this.medianTimeToMaster)) * 31) + Integer.hashCode(this.numAchievements)) * 31) + this.achievements.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Response(id=");
            sb.append(this.id).append(", title=").append(this.title).append(", consoleId=").append(this.consoleId).append(", consoleName=").append(this.consoleName).append(", imageIcon=").append(this.imageIcon).append(", numDistinctPlayers=").append(this.numDistinctPlayers).append(", timesUsedInBeatMedian=").append(this.timesUsedInBeatMedian).append(", timesUsedInHardcoreBeatMedia=").append(this.timesUsedInHardcoreBeatMedia).append(", medianTimeToBeat=").append(this.medianTimeToBeat).append(", medianTimeToBeatHardcore=").append(this.medianTimeToBeatHardcore).append(", timesUsedInCompletionMedian=").append(this.timesUsedInCompletionMedian).append(", timesUsedInMasteryMedian=");
            sb.append(this.timesUsedInMasteryMedian).append(", mediaTimeToComplete=").append(this.mediaTimeToComplete).append(", medianTimeToMaster=").append(this.medianTimeToMaster).append(", numAchievements=").append(this.numAchievements).append(", achievements=").append(this.achievements).append(')');
            return sb.toString();
        }

        public Response(int i, String title, int i2, String consoleName, String imageIcon, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, List<Achievement> achievements) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(consoleName, "consoleName");
            Intrinsics.checkNotNullParameter(imageIcon, "imageIcon");
            Intrinsics.checkNotNullParameter(achievements, "achievements");
            this.id = i;
            this.title = title;
            this.consoleId = i2;
            this.consoleName = consoleName;
            this.imageIcon = imageIcon;
            this.numDistinctPlayers = i3;
            this.timesUsedInBeatMedian = i4;
            this.timesUsedInHardcoreBeatMedia = i5;
            this.medianTimeToBeat = i6;
            this.medianTimeToBeatHardcore = i7;
            this.timesUsedInCompletionMedian = i8;
            this.timesUsedInMasteryMedian = i9;
            this.mediaTimeToComplete = i10;
            this.medianTimeToMaster = i11;
            this.numAchievements = i12;
            this.achievements = achievements;
        }

        public final int getId() {
            return this.id;
        }

        public final String getTitle() {
            return this.title;
        }

        public final int getConsoleId() {
            return this.consoleId;
        }

        public final String getConsoleName() {
            return this.consoleName;
        }

        public final String getImageIcon() {
            return this.imageIcon;
        }

        public final int getNumDistinctPlayers() {
            return this.numDistinctPlayers;
        }

        public final int getTimesUsedInBeatMedian() {
            return this.timesUsedInBeatMedian;
        }

        public final int getTimesUsedInHardcoreBeatMedia() {
            return this.timesUsedInHardcoreBeatMedia;
        }

        public final int getMedianTimeToBeat() {
            return this.medianTimeToBeat;
        }

        public final int getMedianTimeToBeatHardcore() {
            return this.medianTimeToBeatHardcore;
        }

        public final int getTimesUsedInCompletionMedian() {
            return this.timesUsedInCompletionMedian;
        }

        public final int getTimesUsedInMasteryMedian() {
            return this.timesUsedInMasteryMedian;
        }

        public final int getMediaTimeToComplete() {
            return this.mediaTimeToComplete;
        }

        public final int getMedianTimeToMaster() {
            return this.medianTimeToMaster;
        }

        public final int getNumAchievements() {
            return this.numAchievements;
        }

        public final List<Achievement> getAchievements() {
            return this.achievements;
        }

        /* JADX INFO: compiled from: GetGameProgression.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0002\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u008d\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0003HÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u0003HÖ\u0001J\t\u00103\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013¨\u00064"}, d2 = {"Lorg/retroachivements/api/data/pojo/game/GetGameProgression$Response$Achievement;", "", "id", "", "title", "", "description", "points", "trueRatio", "type", "badgeName", "numAwarded", "numAwardedHardcore", "timesUsedInUnlockMedian", "timesUsedInHardcoreUnlockMedian", "medianTimeToUnlock", "medianTimeToUnlockHardcore", "(ILjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;IIIIII)V", "getBadgeName", "()Ljava/lang/String;", "getDescription", "getId", "()I", "getMedianTimeToUnlock", "getMedianTimeToUnlockHardcore", "getNumAwarded", "getNumAwardedHardcore", "getPoints", "getTimesUsedInHardcoreUnlockMedian", "getTimesUsedInUnlockMedian", "getTitle", "getTrueRatio", "getType", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Achievement {

            @SerializedName("BadgeName")
            private final String badgeName;

            @SerializedName("Description")
            private final String description;

            @SerializedName("ID")
            private final int id;

            @SerializedName("MedianTimeToUnlock")
            private final int medianTimeToUnlock;

            @SerializedName("MedianTimeToUnlockHardcore")
            private final int medianTimeToUnlockHardcore;

            @SerializedName("NumAwarded")
            private final int numAwarded;

            @SerializedName("NumAwardedHardcore")
            private final int numAwardedHardcore;

            @SerializedName("Points")
            private final int points;

            @SerializedName("TimesUsedInHardcoreUnlockMedian")
            private final int timesUsedInHardcoreUnlockMedian;

            @SerializedName("TimesUsedInUnlockMedian")
            private final int timesUsedInUnlockMedian;

            @SerializedName("Title")
            private final String title;

            @SerializedName("TrueRatio")
            private final int trueRatio;

            @SerializedName("Type")
            private final String type;

            public static /* synthetic */ Achievement copy$default(Achievement achievement, int i, String str, String str2, int i2, int i3, String str3, String str4, int i4, int i5, int i6, int i7, int i8, int i9, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    i = achievement.id;
                }
                return achievement.copy(i, (i10 & 2) != 0 ? achievement.title : str, (i10 & 4) != 0 ? achievement.description : str2, (i10 & 8) != 0 ? achievement.points : i2, (i10 & 16) != 0 ? achievement.trueRatio : i3, (i10 & 32) != 0 ? achievement.type : str3, (i10 & 64) != 0 ? achievement.badgeName : str4, (i10 & 128) != 0 ? achievement.numAwarded : i4, (i10 & 256) != 0 ? achievement.numAwardedHardcore : i5, (i10 & 512) != 0 ? achievement.timesUsedInUnlockMedian : i6, (i10 & 1024) != 0 ? achievement.timesUsedInHardcoreUnlockMedian : i7, (i10 & 2048) != 0 ? achievement.medianTimeToUnlock : i8, (i10 & 4096) != 0 ? achievement.medianTimeToUnlockHardcore : i9);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getId() {
                return this.id;
            }

            /* JADX INFO: renamed from: component10, reason: from getter */
            public final int getTimesUsedInUnlockMedian() {
                return this.timesUsedInUnlockMedian;
            }

            /* JADX INFO: renamed from: component11, reason: from getter */
            public final int getTimesUsedInHardcoreUnlockMedian() {
                return this.timesUsedInHardcoreUnlockMedian;
            }

            /* JADX INFO: renamed from: component12, reason: from getter */
            public final int getMedianTimeToUnlock() {
                return this.medianTimeToUnlock;
            }

            /* JADX INFO: renamed from: component13, reason: from getter */
            public final int getMedianTimeToUnlockHardcore() {
                return this.medianTimeToUnlockHardcore;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getTitle() {
                return this.title;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getDescription() {
                return this.description;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final int getPoints() {
                return this.points;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final int getTrueRatio() {
                return this.trueRatio;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final String getType() {
                return this.type;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final String getBadgeName() {
                return this.badgeName;
            }

            /* JADX INFO: renamed from: component8, reason: from getter */
            public final int getNumAwarded() {
                return this.numAwarded;
            }

            /* JADX INFO: renamed from: component9, reason: from getter */
            public final int getNumAwardedHardcore() {
                return this.numAwardedHardcore;
            }

            public final Achievement copy(int id2, String title, String description, int points, int trueRatio, String type, String badgeName, int numAwarded, int numAwardedHardcore, int timesUsedInUnlockMedian, int timesUsedInHardcoreUnlockMedian, int medianTimeToUnlock, int medianTimeToUnlockHardcore) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(description, "description");
                Intrinsics.checkNotNullParameter(badgeName, "badgeName");
                return new Achievement(id2, title, description, points, trueRatio, type, badgeName, numAwarded, numAwardedHardcore, timesUsedInUnlockMedian, timesUsedInHardcoreUnlockMedian, medianTimeToUnlock, medianTimeToUnlockHardcore);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Achievement)) {
                    return false;
                }
                Achievement achievement = (Achievement) other;
                return this.id == achievement.id && Intrinsics.areEqual(this.title, achievement.title) && Intrinsics.areEqual(this.description, achievement.description) && this.points == achievement.points && this.trueRatio == achievement.trueRatio && Intrinsics.areEqual(this.type, achievement.type) && Intrinsics.areEqual(this.badgeName, achievement.badgeName) && this.numAwarded == achievement.numAwarded && this.numAwardedHardcore == achievement.numAwardedHardcore && this.timesUsedInUnlockMedian == achievement.timesUsedInUnlockMedian && this.timesUsedInHardcoreUnlockMedian == achievement.timesUsedInHardcoreUnlockMedian && this.medianTimeToUnlock == achievement.medianTimeToUnlock && this.medianTimeToUnlockHardcore == achievement.medianTimeToUnlockHardcore;
            }

            public int hashCode() {
                int iHashCode = ((((((((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + Integer.hashCode(this.points)) * 31) + Integer.hashCode(this.trueRatio)) * 31;
                String str = this.type;
                return ((((((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.badgeName.hashCode()) * 31) + Integer.hashCode(this.numAwarded)) * 31) + Integer.hashCode(this.numAwardedHardcore)) * 31) + Integer.hashCode(this.timesUsedInUnlockMedian)) * 31) + Integer.hashCode(this.timesUsedInHardcoreUnlockMedian)) * 31) + Integer.hashCode(this.medianTimeToUnlock)) * 31) + Integer.hashCode(this.medianTimeToUnlockHardcore);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("Achievement(id=");
                sb.append(this.id).append(", title=").append(this.title).append(", description=").append(this.description).append(", points=").append(this.points).append(", trueRatio=").append(this.trueRatio).append(", type=").append(this.type).append(", badgeName=").append(this.badgeName).append(", numAwarded=").append(this.numAwarded).append(", numAwardedHardcore=").append(this.numAwardedHardcore).append(", timesUsedInUnlockMedian=").append(this.timesUsedInUnlockMedian).append(", timesUsedInHardcoreUnlockMedian=").append(this.timesUsedInHardcoreUnlockMedian).append(", medianTimeToUnlock=");
                sb.append(this.medianTimeToUnlock).append(", medianTimeToUnlockHardcore=").append(this.medianTimeToUnlockHardcore).append(')');
                return sb.toString();
            }

            public Achievement(int i, String title, String description, int i2, int i3, String str, String badgeName, int i4, int i5, int i6, int i7, int i8, int i9) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(description, "description");
                Intrinsics.checkNotNullParameter(badgeName, "badgeName");
                this.id = i;
                this.title = title;
                this.description = description;
                this.points = i2;
                this.trueRatio = i3;
                this.type = str;
                this.badgeName = badgeName;
                this.numAwarded = i4;
                this.numAwardedHardcore = i5;
                this.timesUsedInUnlockMedian = i6;
                this.timesUsedInHardcoreUnlockMedian = i7;
                this.medianTimeToUnlock = i8;
                this.medianTimeToUnlockHardcore = i9;
            }

            public final int getId() {
                return this.id;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getDescription() {
                return this.description;
            }

            public final int getPoints() {
                return this.points;
            }

            public final int getTrueRatio() {
                return this.trueRatio;
            }

            public final String getType() {
                return this.type;
            }

            public final String getBadgeName() {
                return this.badgeName;
            }

            public final int getNumAwarded() {
                return this.numAwarded;
            }

            public final int getNumAwardedHardcore() {
                return this.numAwardedHardcore;
            }

            public final int getTimesUsedInUnlockMedian() {
                return this.timesUsedInUnlockMedian;
            }

            public final int getTimesUsedInHardcoreUnlockMedian() {
                return this.timesUsedInHardcoreUnlockMedian;
            }

            public final int getMedianTimeToUnlock() {
                return this.medianTimeToUnlock;
            }

            public final int getMedianTimeToUnlockHardcore() {
                return this.medianTimeToUnlockHardcore;
            }
        }
    }
}
