package com.magneticchen.daijishou.daijishou_library_db.portables;

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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* INFO: compiled from: PlatformEntityPortable.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/magneticchen/daijishou/daijishou_library_db/portables/PlatformEntityPortable.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/magneticchen/daijishou/daijishou_library_db/portables/PlatformEntityPortable;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class PlatformEntityPortable$$serializer implements GeneratedSerializer<PlatformEntityPortable> {
    public static final PlatformEntityPortable$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PlatformEntityPortable$$serializer platformEntityPortable$$serializer = new PlatformEntityPortable$$serializer();
        INSTANCE = platformEntityPortable$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.magneticchen.daijishou.daijishou_library_db.portables.PlatformEntityPortable", platformEntityPortable$$serializer, 14);
        pluginGeneratedSerialDescriptor.addElement("name", true);
        pluginGeneratedSerialDescriptor.addElement("uniqueId", true);
        pluginGeneratedSerialDescriptor.addElement("shortname", true);
        pluginGeneratedSerialDescriptor.addElement("description", true);
        pluginGeneratedSerialDescriptor.addElement("acceptedFilenameRegex", true);
        pluginGeneratedSerialDescriptor.addElement("scraperSourceList", true);
        pluginGeneratedSerialDescriptor.addElement("boxArtAspectRatioId", true);
        pluginGeneratedSerialDescriptor.addElement("useCustomBoxArtAspectRatio", true);
        pluginGeneratedSerialDescriptor.addElement("customBoxArtAspectRatio", true);
        pluginGeneratedSerialDescriptor.addElement("screenAspectRatioId", true);
        pluginGeneratedSerialDescriptor.addElement("useCustomScreenAspectRatio", true);
        pluginGeneratedSerialDescriptor.addElement("customScreenAspectRatio", true);
        pluginGeneratedSerialDescriptor.addElement("retroAchievementsConsoleIdList", true);
        pluginGeneratedSerialDescriptor.addElement("extra", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PlatformEntityPortable$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = PlatformEntityPortable.$childSerializers;
        return new KSerializer[]{StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, kSerializerArr[5], IntSerializer.INSTANCE, BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), kSerializerArr[12], StringSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PlatformEntityPortable deserialize(Decoder decoder) {
        String strDecodeStringElement;
        List list;
        String str;
        List list2;
        int i;
        String str2;
        boolean z;
        int i2;
        int i3;
        String str3;
        String str4;
        String str5;
        String str6;
        boolean z2;
        String str7;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = PlatformEntityPortable.$childSerializers;
        int i4 = 10;
        int i5 = 7;
        String strDecodeStringElement2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
            String str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, null);
            String strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
            String str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, null);
            String strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 4);
            List list3 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, kSerializerArr[5], null);
            int iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 6);
            boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 7);
            String str10 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, StringSerializer.INSTANCE, null);
            int iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 9);
            boolean zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 10);
            String str11 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, StringSerializer.INSTANCE, null);
            list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 12, kSerializerArr[12], null);
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 13);
            z = zDecodeBooleanElement2;
            i2 = iDecodeIntElement2;
            z2 = zDecodeBooleanElement;
            i3 = iDecodeIntElement;
            str4 = str10;
            str2 = strDecodeStringElement5;
            i = 16383;
            str = str11;
            str3 = strDecodeStringElement3;
            str5 = str9;
            list = list3;
            str6 = strDecodeStringElement4;
            str7 = str8;
        } else {
            int i6 = 13;
            boolean z3 = true;
            String str12 = null;
            List list4 = null;
            String str13 = null;
            List list5 = null;
            String str14 = null;
            String strDecodeStringElement6 = null;
            String strDecodeStringElement7 = null;
            strDecodeStringElement = null;
            boolean zDecodeBooleanElement3 = false;
            int iDecodeIntElement3 = 0;
            boolean zDecodeBooleanElement4 = false;
            int iDecodeIntElement4 = 0;
            int i7 = 5;
            String str15 = null;
            int i8 = 0;
            while (z3) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z3 = false;
                        i6 = 13;
                        i5 = 7;
                        i7 = 5;
                        break;
                    case 0:
                        strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
                        i8 |= 1;
                        i6 = 13;
                        i4 = 10;
                        i5 = 7;
                        i7 = 5;
                        break;
                    case 1:
                        str12 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, str12);
                        i8 |= 2;
                        i6 = 13;
                        i4 = 10;
                        i5 = 7;
                        i7 = 5;
                        break;
                    case 2:
                        strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
                        i8 |= 4;
                        i6 = 13;
                        i4 = 10;
                        i5 = 7;
                        i7 = 5;
                        break;
                    case 3:
                        str15 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, str15);
                        i8 |= 8;
                        i6 = 13;
                        i4 = 10;
                        i5 = 7;
                        i7 = 5;
                        break;
                    case 4:
                        strDecodeStringElement7 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 4);
                        i8 |= 16;
                        i6 = 13;
                        i4 = 10;
                        i5 = 7;
                        break;
                    case 5:
                        list4 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i7, kSerializerArr[i7], list4);
                        i8 |= 32;
                        i6 = 13;
                        i4 = 10;
                        i5 = 7;
                        break;
                    case 6:
                        iDecodeIntElement4 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 6);
                        i8 |= 64;
                        i6 = 13;
                        i5 = 7;
                        break;
                    case 7:
                        int i9 = i5;
                        zDecodeBooleanElement4 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, i9);
                        i8 |= 128;
                        i5 = i9;
                        i6 = 13;
                        break;
                    case 8:
                        str14 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, StringSerializer.INSTANCE, str14);
                        i8 |= 256;
                        i6 = 13;
                        i5 = 7;
                        break;
                    case 9:
                        iDecodeIntElement3 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 9);
                        i8 |= 512;
                        i6 = 13;
                        i5 = 7;
                        break;
                    case 10:
                        zDecodeBooleanElement3 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, i4);
                        i8 |= 1024;
                        i6 = 13;
                        i5 = 7;
                        break;
                    case 11:
                        str13 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, StringSerializer.INSTANCE, str13);
                        i8 |= 2048;
                        i6 = 13;
                        i5 = 7;
                        break;
                    case 12:
                        list5 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 12, kSerializerArr[12], list5);
                        i8 |= 4096;
                        i6 = 13;
                        break;
                    case 13:
                        strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, i6);
                        i8 |= 8192;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            list = list4;
            str = str13;
            list2 = list5;
            i = i8;
            str2 = strDecodeStringElement7;
            z = zDecodeBooleanElement3;
            i2 = iDecodeIntElement3;
            i3 = iDecodeIntElement4;
            str3 = strDecodeStringElement2;
            str4 = str14;
            str5 = str15;
            str6 = strDecodeStringElement6;
            z2 = zDecodeBooleanElement4;
            str7 = str12;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new PlatformEntityPortable(i, str3, str7, str6, str5, str2, list, i3, z2, str4, i2, z, str, list2, strDecodeStringElement, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PlatformEntityPortable value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        PlatformEntityPortable.write$Self$app_release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
