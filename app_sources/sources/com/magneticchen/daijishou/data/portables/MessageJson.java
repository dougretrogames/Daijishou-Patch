package com.magneticchen.daijishou.data.portables;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: MessageJson.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 F2\u00020\u0001:\u0002EFB}\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011By\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0012J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0082\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00107J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020\u0003HÖ\u0001J\t\u0010<\u001a\u00020\u0005HÖ\u0001J&\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u00002\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CHÁ\u0001¢\u0006\u0002\bDR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0014\"\u0004\b'\u0010\u0016R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b(\u0010\u001a\"\u0004\b)\u0010\u001cR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0014\"\u0004\b+\u0010\u0016¨\u0006G"}, d2 = {"Lcom/magneticchen/daijishou/data/portables/MessageJson;", "", "seen1", "", "title", "", "message", "acknowledgmentText", "acknowledgmentLink", "cancelText", "cancelLink", "neutralText", "neutralLink", "targetVersion", "belowVersion", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAcknowledgmentLink", "()Ljava/lang/String;", "setAcknowledgmentLink", "(Ljava/lang/String;)V", "getAcknowledgmentText", "setAcknowledgmentText", "getBelowVersion", "()Ljava/lang/Integer;", "setBelowVersion", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCancelLink", "setCancelLink", "getCancelText", "setCancelText", "getMessage", "setMessage", "getNeutralLink", "setNeutralLink", "getNeutralText", "setNeutralText", "getTargetVersion", "setTargetVersion", "getTitle", "setTitle", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/magneticchen/daijishou/data/portables/MessageJson;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
public final class MessageJson {
    public static final Companion Companion = new Companion(null);
    private String acknowledgmentLink;
    private String acknowledgmentText;
    private Integer belowVersion;
    private String cancelLink;
    private String cancelText;
    private String message;
    private String neutralLink;
    private String neutralText;
    private Integer targetVersion;
    private String title;

    public MessageJson() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, 1023, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ MessageJson copy$default(MessageJson messageJson, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = messageJson.title;
        }
        if ((i & 2) != 0) {
            str2 = messageJson.message;
        }
        if ((i & 4) != 0) {
            str3 = messageJson.acknowledgmentText;
        }
        if ((i & 8) != 0) {
            str4 = messageJson.acknowledgmentLink;
        }
        if ((i & 16) != 0) {
            str5 = messageJson.cancelText;
        }
        if ((i & 32) != 0) {
            str6 = messageJson.cancelLink;
        }
        if ((i & 64) != 0) {
            str7 = messageJson.neutralText;
        }
        if ((i & 128) != 0) {
            str8 = messageJson.neutralLink;
        }
        if ((i & 256) != 0) {
            num = messageJson.targetVersion;
        }
        if ((i & 512) != 0) {
            num2 = messageJson.belowVersion;
        }
        Integer num3 = num;
        Integer num4 = num2;
        String str9 = str7;
        String str10 = str8;
        String str11 = str5;
        String str12 = str6;
        return messageJson.copy(str, str2, str3, str4, str11, str12, str9, str10, num3, num4);
    }

    public final String component1() {
        return this.title;
    }

    public final Integer component10() {
        return this.belowVersion;
    }

    public final String component2() {
        return this.message;
    }

    public final String component3() {
        return this.acknowledgmentText;
    }

    public final String component4() {
        return this.acknowledgmentLink;
    }

    public final String component5() {
        return this.cancelText;
    }

    public final String component6() {
        return this.cancelLink;
    }

    public final String component7() {
        return this.neutralText;
    }

    public final String component8() {
        return this.neutralLink;
    }

    public final Integer component9() {
        return this.targetVersion;
    }

    public final MessageJson copy(String title, String str, String acknowledgmentText, String str2, String str3, String str4, String str5, String str6, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(acknowledgmentText, "acknowledgmentText");
        return new MessageJson(title, str, acknowledgmentText, str2, str3, str4, str5, str6, num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageJson)) {
            return false;
        }
        MessageJson messageJson = (MessageJson) obj;
        return Intrinsics.areEqual(this.title, messageJson.title) && Intrinsics.areEqual(this.message, messageJson.message) && Intrinsics.areEqual(this.acknowledgmentText, messageJson.acknowledgmentText) && Intrinsics.areEqual(this.acknowledgmentLink, messageJson.acknowledgmentLink) && Intrinsics.areEqual(this.cancelText, messageJson.cancelText) && Intrinsics.areEqual(this.cancelLink, messageJson.cancelLink) && Intrinsics.areEqual(this.neutralText, messageJson.neutralText) && Intrinsics.areEqual(this.neutralLink, messageJson.neutralLink) && Intrinsics.areEqual(this.targetVersion, messageJson.targetVersion) && Intrinsics.areEqual(this.belowVersion, messageJson.belowVersion);
    }

    public int hashCode() {
        int iHashCode = this.title.hashCode() * 31;
        String str = this.message;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.acknowledgmentText.hashCode()) * 31;
        String str2 = this.acknowledgmentLink;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.cancelText;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.cancelLink;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.neutralText;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.neutralLink;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num = this.targetVersion;
        int iHashCode8 = (iHashCode7 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.belowVersion;
        return iHashCode8 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "MessageJson(title=" + this.title + ", message=" + this.message + ", acknowledgmentText=" + this.acknowledgmentText + ", acknowledgmentLink=" + this.acknowledgmentLink + ", cancelText=" + this.cancelText + ", cancelLink=" + this.cancelLink + ", neutralText=" + this.neutralText + ", neutralLink=" + this.neutralLink + ", targetVersion=" + this.targetVersion + ", belowVersion=" + this.belowVersion + ")";
    }

    /* JADX INFO: compiled from: MessageJson.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/magneticchen/daijishou/data/portables/MessageJson$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/magneticchen/daijishou/data/portables/MessageJson;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<MessageJson> serializer() {
            return MessageJson$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ MessageJson(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Integer num, Integer num2, SerializationConstructorMarker serializationConstructorMarker) {
        this.title = (i & 1) == 0 ? "Message title" : str;
        if ((i & 2) == 0) {
            this.message = "message";
        } else {
            this.message = str2;
        }
        if ((i & 4) == 0) {
            this.acknowledgmentText = "OK";
        } else {
            this.acknowledgmentText = str3;
        }
        if ((i & 8) == 0) {
            this.acknowledgmentLink = null;
        } else {
            this.acknowledgmentLink = str4;
        }
        if ((i & 16) == 0) {
            this.cancelText = "Cancel";
        } else {
            this.cancelText = str5;
        }
        if ((i & 32) == 0) {
            this.cancelLink = null;
        } else {
            this.cancelLink = str6;
        }
        if ((i & 64) == 0) {
            this.neutralText = null;
        } else {
            this.neutralText = str7;
        }
        if ((i & 128) == 0) {
            this.neutralLink = null;
        } else {
            this.neutralLink = str8;
        }
        if ((i & 256) == 0) {
            this.targetVersion = null;
        } else {
            this.targetVersion = num;
        }
        if ((i & 512) == 0) {
            this.belowVersion = null;
        } else {
            this.belowVersion = num2;
        }
    }

    public MessageJson(String title, String str, String acknowledgmentText, String str2, String str3, String str4, String str5, String str6, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(acknowledgmentText, "acknowledgmentText");
        this.title = title;
        this.message = str;
        this.acknowledgmentText = acknowledgmentText;
        this.acknowledgmentLink = str2;
        this.cancelText = str3;
        this.cancelLink = str4;
        this.neutralText = str5;
        this.neutralLink = str6;
        this.targetVersion = num;
        this.belowVersion = num2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app_release(MessageJson messageJson, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) || !Intrinsics.areEqual(messageJson.title, "Message title")) {
            compositeEncoder.encodeStringElement(serialDescriptor, 0, messageJson.title);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || !Intrinsics.areEqual(messageJson.message, "message")) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, messageJson.message);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || !Intrinsics.areEqual(messageJson.acknowledgmentText, "OK")) {
            compositeEncoder.encodeStringElement(serialDescriptor, 2, messageJson.acknowledgmentText);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) || messageJson.acknowledgmentLink != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, messageJson.acknowledgmentLink);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 4) || !Intrinsics.areEqual(messageJson.cancelText, "Cancel")) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, messageJson.cancelText);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 5) || messageJson.cancelLink != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, messageJson.cancelLink);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 6) || messageJson.neutralText != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, messageJson.neutralText);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 7) || messageJson.neutralLink != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, messageJson.neutralLink);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 8) || messageJson.targetVersion != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 8, IntSerializer.INSTANCE, messageJson.targetVersion);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 9) && messageJson.belowVersion == null) {
            return;
        }
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 9, IntSerializer.INSTANCE, messageJson.belowVersion);
    }

    public /* synthetic */ MessageJson(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "Message title" : str, (i & 2) != 0 ? "message" : str2, (i & 4) != 0 ? "OK" : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? "Cancel" : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : num, (i & 512) != 0 ? null : num2);
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final String getAcknowledgmentText() {
        return this.acknowledgmentText;
    }

    public final void setAcknowledgmentText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.acknowledgmentText = str;
    }

    public final String getAcknowledgmentLink() {
        return this.acknowledgmentLink;
    }

    public final void setAcknowledgmentLink(String str) {
        this.acknowledgmentLink = str;
    }

    public final String getCancelText() {
        return this.cancelText;
    }

    public final void setCancelText(String str) {
        this.cancelText = str;
    }

    public final String getCancelLink() {
        return this.cancelLink;
    }

    public final void setCancelLink(String str) {
        this.cancelLink = str;
    }

    public final String getNeutralText() {
        return this.neutralText;
    }

    public final void setNeutralText(String str) {
        this.neutralText = str;
    }

    public final String getNeutralLink() {
        return this.neutralLink;
    }

    public final void setNeutralLink(String str) {
        this.neutralLink = str;
    }

    public final Integer getTargetVersion() {
        return this.targetVersion;
    }

    public final void setTargetVersion(Integer num) {
        this.targetVersion = num;
    }

    public final Integer getBelowVersion() {
        return this.belowVersion;
    }

    public final void setBelowVersion(Integer num) {
        this.belowVersion = num;
    }
}
