package org.retroachivements.api.data.pojo.user;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: GetUserAwards.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserAwards;", "", "()V", "Response", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GetUserAwards {

    /* INFO: compiled from: GetUserAwards.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001)BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u0019\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rHÆ\u0003Ji\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R&\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006*"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserAwards$Response;", "", "totalAwardsCount", "", "hiddenAwardsCount", "masteryAwardsCount", "completionAwardsCount", "beatenHardcoreAwardsCount", "eventAwardsCount", "siteAwardsCount", "visibleUserAwards", "Ljava/util/ArrayList;", "Lorg/retroachivements/api/data/pojo/user/GetUserAwards$Response$Award;", "Lkotlin/collections/ArrayList;", "(JJJJJJJLjava/util/ArrayList;)V", "getBeatenHardcoreAwardsCount", "()J", "getCompletionAwardsCount", "getEventAwardsCount", "getHiddenAwardsCount", "getMasteryAwardsCount", "getSiteAwardsCount", "getTotalAwardsCount", "getVisibleUserAwards", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "", "toString", "", "Award", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Response {

        @SerializedName("BeatenHardcoreAwardsCount")
        private final long beatenHardcoreAwardsCount;

        @SerializedName("CompletionAwardsCount")
        private final long completionAwardsCount;

        @SerializedName("EventAwardsCount")
        private final long eventAwardsCount;

        @SerializedName("HiddenAwardsCount")
        private final long hiddenAwardsCount;

        @SerializedName("MasteryAwardsCount")
        private final long masteryAwardsCount;

        @SerializedName("SiteAwardsCount")
        private final long siteAwardsCount;

        @SerializedName("TotalAwardsCount")
        private final long totalAwardsCount;

        @SerializedName("VisibleUserAwards")
        private final ArrayList<Award> visibleUserAwards;

        /* INFO: renamed from: component1, reason: from getter */
        public final long getTotalAwardsCount() {
            return this.totalAwardsCount;
        }

        /* INFO: renamed from: component2, reason: from getter */
        public final long getHiddenAwardsCount() {
            return this.hiddenAwardsCount;
        }

        /* INFO: renamed from: component3, reason: from getter */
        public final long getMasteryAwardsCount() {
            return this.masteryAwardsCount;
        }

        /* INFO: renamed from: component4, reason: from getter */
        public final long getCompletionAwardsCount() {
            return this.completionAwardsCount;
        }

        /* INFO: renamed from: component5, reason: from getter */
        public final long getBeatenHardcoreAwardsCount() {
            return this.beatenHardcoreAwardsCount;
        }

        /* INFO: renamed from: component6, reason: from getter */
        public final long getEventAwardsCount() {
            return this.eventAwardsCount;
        }

        /* INFO: renamed from: component7, reason: from getter */
        public final long getSiteAwardsCount() {
            return this.siteAwardsCount;
        }

        public final ArrayList<Award> component8() {
            return this.visibleUserAwards;
        }

        public final Response copy(long totalAwardsCount, long hiddenAwardsCount, long masteryAwardsCount, long completionAwardsCount, long beatenHardcoreAwardsCount, long eventAwardsCount, long siteAwardsCount, ArrayList<Award> visibleUserAwards) {
            Intrinsics.checkNotNullParameter(visibleUserAwards, "visibleUserAwards");
            return new Response(totalAwardsCount, hiddenAwardsCount, masteryAwardsCount, completionAwardsCount, beatenHardcoreAwardsCount, eventAwardsCount, siteAwardsCount, visibleUserAwards);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Response)) {
                return false;
            }
            Response response = (Response) other;
            return this.totalAwardsCount == response.totalAwardsCount && this.hiddenAwardsCount == response.hiddenAwardsCount && this.masteryAwardsCount == response.masteryAwardsCount && this.completionAwardsCount == response.completionAwardsCount && this.beatenHardcoreAwardsCount == response.beatenHardcoreAwardsCount && this.eventAwardsCount == response.eventAwardsCount && this.siteAwardsCount == response.siteAwardsCount && Intrinsics.areEqual(this.visibleUserAwards, response.visibleUserAwards);
        }

        public int hashCode() {
            return (((((((((((((Long.hashCode(this.totalAwardsCount) * 31) + Long.hashCode(this.hiddenAwardsCount)) * 31) + Long.hashCode(this.masteryAwardsCount)) * 31) + Long.hashCode(this.completionAwardsCount)) * 31) + Long.hashCode(this.beatenHardcoreAwardsCount)) * 31) + Long.hashCode(this.eventAwardsCount)) * 31) + Long.hashCode(this.siteAwardsCount)) * 31) + this.visibleUserAwards.hashCode();
        }

        public String toString() {
            return "Response(totalAwardsCount=" + this.totalAwardsCount + ", hiddenAwardsCount=" + this.hiddenAwardsCount + ", masteryAwardsCount=" + this.masteryAwardsCount + ", completionAwardsCount=" + this.completionAwardsCount + ", beatenHardcoreAwardsCount=" + this.beatenHardcoreAwardsCount + ", eventAwardsCount=" + this.eventAwardsCount + ", siteAwardsCount=" + this.siteAwardsCount + ", visibleUserAwards=" + this.visibleUserAwards + ')';
        }

        public Response(long j, long j2, long j3, long j4, long j5, long j6, long j7, ArrayList<Award> visibleUserAwards) {
            Intrinsics.checkNotNullParameter(visibleUserAwards, "visibleUserAwards");
            this.totalAwardsCount = j;
            this.hiddenAwardsCount = j2;
            this.masteryAwardsCount = j3;
            this.completionAwardsCount = j4;
            this.beatenHardcoreAwardsCount = j5;
            this.eventAwardsCount = j6;
            this.siteAwardsCount = j7;
            this.visibleUserAwards = visibleUserAwards;
        }

        public final long getTotalAwardsCount() {
            return this.totalAwardsCount;
        }

        public final long getHiddenAwardsCount() {
            return this.hiddenAwardsCount;
        }

        public final long getMasteryAwardsCount() {
            return this.masteryAwardsCount;
        }

        public final long getCompletionAwardsCount() {
            return this.completionAwardsCount;
        }

        public final long getBeatenHardcoreAwardsCount() {
            return this.beatenHardcoreAwardsCount;
        }

        public final long getEventAwardsCount() {
            return this.eventAwardsCount;
        }

        public final long getSiteAwardsCount() {
            return this.siteAwardsCount;
        }

        public final ArrayList<Award> getVisibleUserAwards() {
            return this.visibleUserAwards;
        }

        /* INFO: compiled from: GetUserAwards.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003Jm\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u0003HÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\bHÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0016\u0010\r\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015¨\u0006-"}, d2 = {"Lorg/retroachivements/api/data/pojo/user/GetUserAwards$Response$Award;", "", "awardedAt", "", "awardType", "awardData", "", "awardDataExtra", "", "displayOrder", "title", "consoleId", "consoleName", "flags", "imageIcon", "(Ljava/lang/String;Ljava/lang/String;JIILjava/lang/String;JLjava/lang/String;ILjava/lang/String;)V", "getAwardData", "()J", "getAwardDataExtra", "()I", "getAwardType", "()Ljava/lang/String;", "getAwardedAt", "getConsoleId", "getConsoleName", "getDisplayOrder", "getFlags", "getImageIcon", "getTitle", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "toString", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Award {

            @SerializedName("AwardData")
            private final long awardData;

            @SerializedName("AwardDataExtra")
            private final int awardDataExtra;

            @SerializedName("AwardType")
            private final String awardType;

            @SerializedName("AwardedAt")
            private final String awardedAt;

            @SerializedName("ConsoleID")
            private final long consoleId;

            @SerializedName("ConsoleName")
            private final String consoleName;

            @SerializedName("DisplayOrder")
            private final int displayOrder;

            @SerializedName("Flags")
            private final int flags;

            @SerializedName("ImageIcon")
            private final String imageIcon;

            @SerializedName("Title")
            private final String title;

            public static /* synthetic */ Award copy$default(Award award, String str, String str2, long j, int i, int i2, String str3, long j2, String str4, int i3, String str5, int i4, Object obj) {
                if ((i4 & 1) != 0) {
                    str = award.awardedAt;
                }
                if ((i4 & 2) != 0) {
                    str2 = award.awardType;
                }
                if ((i4 & 4) != 0) {
                    j = award.awardData;
                }
                if ((i4 & 8) != 0) {
                    i = award.awardDataExtra;
                }
                if ((i4 & 16) != 0) {
                    i2 = award.displayOrder;
                }
                if ((i4 & 32) != 0) {
                    str3 = award.title;
                }
                if ((i4 & 64) != 0) {
                    j2 = award.consoleId;
                }
                if ((i4 & 128) != 0) {
                    str4 = award.consoleName;
                }
                if ((i4 & 256) != 0) {
                    i3 = award.flags;
                }
                if ((i4 & 512) != 0) {
                    str5 = award.imageIcon;
                }
                String str6 = str5;
                String str7 = str4;
                long j3 = j2;
                String str8 = str3;
                int i5 = i;
                long j4 = j;
                return award.copy(str, str2, j4, i5, i2, str8, j3, str7, i3, str6);
            }

            /* INFO: renamed from: component1, reason: from getter */
            public final String getAwardedAt() {
                return this.awardedAt;
            }

            /* INFO: renamed from: component10, reason: from getter */
            public final String getImageIcon() {
                return this.imageIcon;
            }

            /* INFO: renamed from: component2, reason: from getter */
            public final String getAwardType() {
                return this.awardType;
            }

            /* INFO: renamed from: component3, reason: from getter */
            public final long getAwardData() {
                return this.awardData;
            }

            /* INFO: renamed from: component4, reason: from getter */
            public final int getAwardDataExtra() {
                return this.awardDataExtra;
            }

            /* INFO: renamed from: component5, reason: from getter */
            public final int getDisplayOrder() {
                return this.displayOrder;
            }

            /* INFO: renamed from: component6, reason: from getter */
            public final String getTitle() {
                return this.title;
            }

            /* INFO: renamed from: component7, reason: from getter */
            public final long getConsoleId() {
                return this.consoleId;
            }

            /* INFO: renamed from: component8, reason: from getter */
            public final String getConsoleName() {
                return this.consoleName;
            }

            /* INFO: renamed from: component9, reason: from getter */
            public final int getFlags() {
                return this.flags;
            }

            public final Award copy(String awardedAt, String awardType, long awardData, int awardDataExtra, int displayOrder, String title, long consoleId, String consoleName, int flags, String imageIcon) {
                Intrinsics.checkNotNullParameter(awardedAt, "awardedAt");
                Intrinsics.checkNotNullParameter(awardType, "awardType");
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(consoleName, "consoleName");
                Intrinsics.checkNotNullParameter(imageIcon, "imageIcon");
                return new Award(awardedAt, awardType, awardData, awardDataExtra, displayOrder, title, consoleId, consoleName, flags, imageIcon);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Award)) {
                    return false;
                }
                Award award = (Award) other;
                return Intrinsics.areEqual(this.awardedAt, award.awardedAt) && Intrinsics.areEqual(this.awardType, award.awardType) && this.awardData == award.awardData && this.awardDataExtra == award.awardDataExtra && this.displayOrder == award.displayOrder && Intrinsics.areEqual(this.title, award.title) && this.consoleId == award.consoleId && Intrinsics.areEqual(this.consoleName, award.consoleName) && this.flags == award.flags && Intrinsics.areEqual(this.imageIcon, award.imageIcon);
            }

            public int hashCode() {
                return (((((((((((((((((this.awardedAt.hashCode() * 31) + this.awardType.hashCode()) * 31) + Long.hashCode(this.awardData)) * 31) + Integer.hashCode(this.awardDataExtra)) * 31) + Integer.hashCode(this.displayOrder)) * 31) + this.title.hashCode()) * 31) + Long.hashCode(this.consoleId)) * 31) + this.consoleName.hashCode()) * 31) + Integer.hashCode(this.flags)) * 31) + this.imageIcon.hashCode();
            }

            public String toString() {
                return "Award(awardedAt=" + this.awardedAt + ", awardType=" + this.awardType + ", awardData=" + this.awardData + ", awardDataExtra=" + this.awardDataExtra + ", displayOrder=" + this.displayOrder + ", title=" + this.title + ", consoleId=" + this.consoleId + ", consoleName=" + this.consoleName + ", flags=" + this.flags + ", imageIcon=" + this.imageIcon + ')';
            }

            public Award(String awardedAt, String awardType, long j, int i, int i2, String title, long j2, String consoleName, int i3, String imageIcon) {
                Intrinsics.checkNotNullParameter(awardedAt, "awardedAt");
                Intrinsics.checkNotNullParameter(awardType, "awardType");
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(consoleName, "consoleName");
                Intrinsics.checkNotNullParameter(imageIcon, "imageIcon");
                this.awardedAt = awardedAt;
                this.awardType = awardType;
                this.awardData = j;
                this.awardDataExtra = i;
                this.displayOrder = i2;
                this.title = title;
                this.consoleId = j2;
                this.consoleName = consoleName;
                this.flags = i3;
                this.imageIcon = imageIcon;
            }

            public final String getAwardedAt() {
                return this.awardedAt;
            }

            public final String getAwardType() {
                return this.awardType;
            }

            public final long getAwardData() {
                return this.awardData;
            }

            public final int getAwardDataExtra() {
                return this.awardDataExtra;
            }

            public final int getDisplayOrder() {
                return this.displayOrder;
            }

            public final String getTitle() {
                return this.title;
            }

            public final long getConsoleId() {
                return this.consoleId;
            }

            public final String getConsoleName() {
                return this.consoleName;
            }

            public final int getFlags() {
                return this.flags;
            }

            public final String getImageIcon() {
                return this.imageIcon;
            }
        }
    }
}
