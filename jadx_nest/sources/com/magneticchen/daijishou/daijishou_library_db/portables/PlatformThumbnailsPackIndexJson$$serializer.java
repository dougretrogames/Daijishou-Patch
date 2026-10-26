package com.magneticchen.daijishou.daijishou_library_db.portables;

import androidx.core.app.FrameMetricsAggregator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
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

/* INFO: compiled from: PlatformThumbnailsPackIndexJson.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/magneticchen/daijishou/daijishou_library_db/portables/PlatformThumbnailsPackIndexJson.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformThumbnailsPackIndexJson;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class PlatformThumbnailsPackIndexJson$$serializer implements GeneratedSerializer<PlatformThumbnailsPackIndexJson> {
    public static final PlatformThumbnailsPackIndexJson$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PlatformThumbnailsPackIndexJson$$serializer platformThumbnailsPackIndexJson$$serializer = new PlatformThumbnailsPackIndexJson$$serializer();
        INSTANCE = platformThumbnailsPackIndexJson$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.magneticchen.daijishou.daijishou_library_db.portables.PlatformThumbnailsPackIndexJson", platformThumbnailsPackIndexJson$$serializer, 9);
        pluginGeneratedSerialDescriptor.addElement("name", false);
        pluginGeneratedSerialDescriptor.addElement("description", false);
        pluginGeneratedSerialDescriptor.addElement("authors", false);
        pluginGeneratedSerialDescriptor.addElement("sources", false);
        pluginGeneratedSerialDescriptor.addElement("previewThumbnailFilename", false);
        pluginGeneratedSerialDescriptor.addElement("isNSFW", true);
        pluginGeneratedSerialDescriptor.addElement("hasDefaultThumbnail", false);
        pluginGeneratedSerialDescriptor.addElement("defaultThumbnailFilename", false);
        pluginGeneratedSerialDescriptor.addElement("thumbnailList", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PlatformThumbnailsPackIndexJson$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = PlatformThumbnailsPackIndexJson.$childSerializers;
        return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, kSerializerArr[2], kSerializerArr[3], StringSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), kSerializerArr[8]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PlatformThumbnailsPackIndexJson deserialize(Decoder decoder) {
        List list;
        String str;
        int i;
        String str2;
        String str3;
        List list2;
        boolean z;
        List list3;
        String strDecodeStringElement;
        boolean z2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = PlatformThumbnailsPackIndexJson.$childSerializers;
        int i2 = 7;
        int i3 = 6;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
            List list4 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, kSerializerArr[2], null);
            List list5 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, kSerializerArr[3], null);
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 4);
            boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 5);
            boolean zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 6);
            String str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, StringSerializer.INSTANCE, null);
            List list6 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 8, kSerializerArr[8], null);
            i = FrameMetricsAggregator.EVERY_DURATION;
            list2 = list6;
            str = str4;
            z2 = zDecodeBooleanElement2;
            z = zDecodeBooleanElement;
            str3 = strDecodeStringElement3;
            list3 = list5;
            list = list4;
            str2 = strDecodeStringElement2;
        } else {
            int i4 = 3;
            boolean z3 = true;
            boolean zDecodeBooleanElement3 = false;
            int i5 = 0;
            List list7 = null;
            String str5 = null;
            List list8 = null;
            String strDecodeStringElement4 = null;
            String strDecodeStringElement5 = null;
            String strDecodeStringElement6 = null;
            boolean zDecodeBooleanElement4 = false;
            list = null;
            while (z3) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z3 = false;
                        i2 = 7;
                        i4 = 3;
                        break;
                    case 0:
                        i5 |= 1;
                        strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
                        i2 = 7;
                        i3 = 6;
                        i4 = 3;
                        break;
                    case 1:
                        strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
                        i5 |= 2;
                        i2 = 7;
                        i3 = 6;
                        i4 = 3;
                        break;
                    case 2:
                        list = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, kSerializerArr[2], list);
                        i5 |= 4;
                        i2 = 7;
                        i3 = 6;
                        i4 = 3;
                        break;
                    case 3:
                        list8 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i4, kSerializerArr[i4], list8);
                        i5 |= 8;
                        i2 = 7;
                        i3 = 6;
                        break;
                    case 4:
                        strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 4);
                        i5 |= 16;
                        break;
                    case 5:
                        zDecodeBooleanElement4 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 5);
                        i5 |= 32;
                        break;
                    case 6:
                        zDecodeBooleanElement3 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, i3);
                        i5 |= 64;
                        break;
                    case 7:
                        str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i2, StringSerializer.INSTANCE, str5);
                        i5 |= 128;
                        break;
                    case 8:
                        list7 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 8, kSerializerArr[8], list7);
                        i5 |= 256;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            str = str5;
            i = i5;
            str2 = strDecodeStringElement4;
            str3 = strDecodeStringElement6;
            list2 = list7;
            z = zDecodeBooleanElement4;
            list3 = list8;
            strDecodeStringElement = strDecodeStringElement5;
            z2 = zDecodeBooleanElement3;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new PlatformThumbnailsPackIndexJson(i, str2, strDecodeStringElement, list, list3, str3, z, z2, str, list2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PlatformThumbnailsPackIndexJson value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        PlatformThumbnailsPackIndexJson.write$Self$app_release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
