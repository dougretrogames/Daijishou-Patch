package com.magneticchen.daijishou.daijishou_library_db.portables;

import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* INFO: compiled from: PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/magneticchen/daijishou/daijishou_library_db/portables/PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson$$serializer implements GeneratedSerializer<PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson> {
    public static final PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson$$serializer platformThumbnailsPacksIndexPlatformThumbnailPackListItemJson$$serializer = new PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson$$serializer();
        INSTANCE = platformThumbnailsPacksIndexPlatformThumbnailPackListItemJson$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.magneticchen.daijishou.daijishou_library_db.portables.PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson", platformThumbnailsPacksIndexPlatformThumbnailPackListItemJson$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("platformThumbnailsPackAuthors", false);
        pluginGeneratedSerialDescriptor.addElement("platformThumbnailsPackName", false);
        pluginGeneratedSerialDescriptor.addElement("platformThumbnailsPackRootPath", false);
        pluginGeneratedSerialDescriptor.addElement("platformThumbnailsPackPreviewThumbnailPath", false);
        pluginGeneratedSerialDescriptor.addElement("platformThumbnailsPackDescription", false);
        pluginGeneratedSerialDescriptor.addElement("platformThumbnailsPackIsNSFW", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson.$childSerializers[0], StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, BooleanSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson deserialize(Decoder decoder) {
        boolean zDecodeBooleanElement;
        String str;
        String str2;
        String str3;
        String str4;
        List list;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson.$childSerializers;
        int i2 = 5;
        int i3 = 0;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            List list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, kSerializerArr[0], null);
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 3);
            String strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 4);
            list = list2;
            str4 = strDecodeStringElement;
            zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 5);
            str2 = strDecodeStringElement3;
            str = strDecodeStringElement4;
            str3 = strDecodeStringElement2;
            i = 63;
        } else {
            int i4 = 1;
            boolean zDecodeBooleanElement2 = false;
            List list3 = null;
            String strDecodeStringElement5 = null;
            String strDecodeStringElement6 = null;
            String strDecodeStringElement7 = null;
            String strDecodeStringElement8 = null;
            int i5 = 0;
            while (i4 != 0) {
                int i6 = i3;
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        i3 = i6;
                        i4 = i3;
                        i2 = 5;
                        break;
                    case 0:
                        list3 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i6, kSerializerArr[i6], list3);
                        i5 |= 1;
                        i3 = i6;
                        i2 = 5;
                        break;
                    case 1:
                        strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
                        i5 |= 2;
                        i3 = i6;
                        break;
                    case 2:
                        strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
                        i5 |= 4;
                        i3 = i6;
                        break;
                    case 3:
                        strDecodeStringElement7 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 3);
                        i5 |= 8;
                        i3 = i6;
                        break;
                    case 4:
                        strDecodeStringElement8 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 4);
                        i5 |= 16;
                        i3 = i6;
                        break;
                    case 5:
                        zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, i2);
                        i5 |= 32;
                        i3 = i6;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            zDecodeBooleanElement = zDecodeBooleanElement2;
            str = strDecodeStringElement8;
            str2 = strDecodeStringElement7;
            str3 = strDecodeStringElement6;
            str4 = strDecodeStringElement5;
            list = list3;
            i = i5;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson(i, list, str4, str3, str2, str, zDecodeBooleanElement, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson.write$Self$app_release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
