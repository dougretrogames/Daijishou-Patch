package com.magneticchen.daijishou.data;

import com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetViewModel;
import java.util.HashMap;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
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

/* JADX INFO: compiled from: ExtensionManifestJson.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/magneticchen/daijishou/data/ExtensionManifestJson.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/magneticchen/daijishou/data/ExtensionManifestJson;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class ExtensionManifestJson$$serializer implements GeneratedSerializer<ExtensionManifestJson> {
    public static final ExtensionManifestJson$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        ExtensionManifestJson$$serializer extensionManifestJson$$serializer = new ExtensionManifestJson$$serializer();
        INSTANCE = extensionManifestJson$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.magneticchen.daijishou.data.ExtensionManifestJson", extensionManifestJson$$serializer, 18);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement("name", true);
        pluginGeneratedSerialDescriptor.addElement("icon", true);
        pluginGeneratedSerialDescriptor.addElement("iconDarkTheme", true);
        pluginGeneratedSerialDescriptor.addElement("description", true);
        pluginGeneratedSerialDescriptor.addElement("authors", false);
        pluginGeneratedSerialDescriptor.addElement("previewImages", false);
        pluginGeneratedSerialDescriptor.addElement("licenses", false);
        pluginGeneratedSerialDescriptor.addElement("isNSFW", false);
        pluginGeneratedSerialDescriptor.addElement("version", false);
        pluginGeneratedSerialDescriptor.addElement("apiLevel", false);
        pluginGeneratedSerialDescriptor.addElement("entry", false);
        pluginGeneratedSerialDescriptor.addElement("permissions", false);
        pluginGeneratedSerialDescriptor.addElement("whitelists", true);
        pluginGeneratedSerialDescriptor.addElement("dependencies", false);
        pluginGeneratedSerialDescriptor.addElement("modules", false);
        pluginGeneratedSerialDescriptor.addElement("categories", false);
        pluginGeneratedSerialDescriptor.addElement("keywords", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ExtensionManifestJson$$serializer() {
    }

    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = ExtensionManifestJson.$childSerializers;
        return new KSerializer[]{StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), kSerializerArr[5], kSerializerArr[6], kSerializerArr[7], BooleanSerializer.INSTANCE, StringSerializer.INSTANCE, IntSerializer.INSTANCE, StringSerializer.INSTANCE, kSerializerArr[12], kSerializerArr[13], kSerializerArr[14], kSerializerArr[15], kSerializerArr[16], kSerializerArr[17]};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlinx.serialization.UnknownFieldException */
    /* JADX INFO: renamed from: deserialize, reason: merged with bridge method [inline-methods] */
    public ExtensionManifestJson m146deserialize(Decoder decoder) throws UnknownFieldException {
        HashMap map;
        HashMap map2;
        String str;
        HashMap map3;
        String str2;
        List list;
        List list2;
        String str3;
        List list3;
        List list4;
        int i;
        String str4;
        String str5;
        String str6;
        int i2;
        boolean z;
        String str7;
        List list5;
        List list6;
        int i3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        DeserializationStrategy[] deserializationStrategyArr = ExtensionManifestJson.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
            String str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, (Object) null);
            String str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, (Object) null);
            String str10 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, (Object) null);
            String str11 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, (Object) null);
            List list7 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, deserializationStrategyArr[5], (Object) null);
            List list8 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 6, deserializationStrategyArr[6], (Object) null);
            List list9 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 7, deserializationStrategyArr[7], (Object) null);
            boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 8);
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 9);
            int iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 10);
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 11);
            List list10 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 12, deserializationStrategyArr[12], (Object) null);
            HashMap map4 = (HashMap) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 13, deserializationStrategyArr[13], (Object) null);
            HashMap map5 = (HashMap) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 14, deserializationStrategyArr[14], (Object) null);
            HashMap map6 = (HashMap) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 15, deserializationStrategyArr[15], (Object) null);
            list3 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 16, deserializationStrategyArr[16], (Object) null);
            list4 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 17, deserializationStrategyArr[17], (Object) null);
            i2 = iDecodeIntElement;
            str4 = strDecodeStringElement2;
            z = zDecodeBooleanElement;
            str = str11;
            list = list9;
            list2 = list8;
            list5 = list7;
            map = map6;
            map2 = map5;
            map3 = map4;
            str5 = strDecodeStringElement3;
            list6 = list10;
            str6 = strDecodeStringElement;
            i = 262143;
            str2 = str10;
            str3 = str9;
            str7 = str8;
        } else {
            int i4 = 17;
            int iDecodeIntElement2 = 0;
            boolean zDecodeBooleanElement2 = false;
            List list11 = null;
            HashMap map7 = null;
            HashMap map8 = null;
            String str12 = null;
            HashMap map9 = null;
            List list12 = null;
            String str13 = null;
            String strDecodeStringElement4 = null;
            String strDecodeStringElement5 = null;
            List list13 = null;
            String strDecodeStringElement6 = null;
            int i5 = 7;
            int i6 = 6;
            int i7 = 5;
            boolean z2 = true;
            int i8 = 0;
            String str14 = null;
            List list14 = null;
            List list15 = null;
            List list16 = null;
            String str15 = null;
            while (z2) {
                int i9 = i4;
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        i3 = i8;
                        z2 = false;
                        str14 = str14;
                        list11 = list11;
                        i8 = i3;
                        i4 = 17;
                        i7 = 5;
                        i6 = 6;
                        i5 = 7;
                        break;
                    case 0:
                        strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
                        i3 = i8 | 1;
                        str14 = str14;
                        list11 = list11;
                        i8 = i3;
                        i4 = 17;
                        i7 = 5;
                        i6 = 6;
                        i5 = 7;
                        break;
                    case 1:
                        str14 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, str14);
                        i8 |= 2;
                        list11 = list11;
                        i4 = 17;
                        i7 = 5;
                        i6 = 6;
                        i5 = 7;
                        break;
                    case 2:
                        str15 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, str15);
                        i8 |= 4;
                        list11 = list11;
                        str14 = str14;
                        i4 = 17;
                        i7 = 5;
                        i6 = 6;
                        i5 = 7;
                        break;
                    case 3:
                        str13 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, str13);
                        i8 |= 8;
                        list11 = list11;
                        str14 = str14;
                        i4 = 17;
                        i7 = 5;
                        i6 = 6;
                        i5 = 7;
                        break;
                    case 4:
                        str12 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, str12);
                        i8 |= 16;
                        list11 = list11;
                        str14 = str14;
                        i4 = 17;
                        i7 = 5;
                        i6 = 6;
                        i5 = 7;
                        break;
                    case 5:
                        list12 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i7, deserializationStrategyArr[i7], list12);
                        i8 |= 32;
                        list11 = list11;
                        str14 = str14;
                        i4 = 17;
                        i6 = 6;
                        i5 = 7;
                        break;
                    case 6:
                        list16 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i6, deserializationStrategyArr[i6], list16);
                        i8 |= 64;
                        list11 = list11;
                        str14 = str14;
                        i4 = 17;
                        i5 = 7;
                        break;
                    case 7:
                        list15 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i5, deserializationStrategyArr[i5], list15);
                        i8 |= 128;
                        list13 = list13;
                        list11 = list11;
                        str14 = str14;
                        i4 = 17;
                        break;
                    case 8:
                        zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 8);
                        i8 |= 256;
                        list11 = list11;
                        str14 = str14;
                        i4 = 17;
                        break;
                    case 9:
                        strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 9);
                        i8 |= 512;
                        list11 = list11;
                        str14 = str14;
                        i4 = 17;
                        break;
                    case 10:
                        iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 10);
                        i8 |= CategoryWidgetViewModel.LIMIT;
                        list11 = list11;
                        str14 = str14;
                        i4 = 17;
                        break;
                    case 11:
                        strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 11);
                        i8 |= 2048;
                        list11 = list11;
                        str14 = str14;
                        i4 = 17;
                        break;
                    case 12:
                        list14 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 12, deserializationStrategyArr[12], list14);
                        i8 |= 4096;
                        list11 = list11;
                        str14 = str14;
                        i4 = 17;
                        break;
                    case 13:
                        map9 = (HashMap) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 13, deserializationStrategyArr[13], map9);
                        i8 |= ConstantsKt.DEFAULT_BUFFER_SIZE;
                        list11 = list11;
                        str14 = str14;
                        i4 = 17;
                        break;
                    case 14:
                        map8 = (HashMap) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 14, deserializationStrategyArr[14], map8);
                        i8 |= 16384;
                        list11 = list11;
                        str14 = str14;
                        i4 = 17;
                        break;
                    case 15:
                        map7 = (HashMap) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 15, deserializationStrategyArr[15], map7);
                        i8 |= 32768;
                        list11 = list11;
                        str14 = str14;
                        i4 = 17;
                        break;
                    case 16:
                        list13 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 16, deserializationStrategyArr[16], list13);
                        i8 |= 65536;
                        list11 = list11;
                        str14 = str14;
                        i4 = 17;
                        break;
                    case 17:
                        list11 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i9, deserializationStrategyArr[i9], list11);
                        i8 |= 131072;
                        i4 = i9;
                        str14 = str14;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            map = map7;
            map2 = map8;
            str = str12;
            map3 = map9;
            str2 = str13;
            list = list15;
            list2 = list16;
            str3 = str15;
            list3 = list13;
            list4 = list11;
            i = i8;
            str4 = strDecodeStringElement4;
            str5 = strDecodeStringElement5;
            str6 = strDecodeStringElement6;
            i2 = iDecodeIntElement2;
            z = zDecodeBooleanElement2;
            str7 = str14;
            list5 = list12;
            list6 = list14;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new ExtensionManifestJson(i, str6, str7, str3, str2, str, list5, list2, list, z, str4, i2, str5, list6, map3, map2, map, list3, list4, (SerializationConstructorMarker) null);
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, ExtensionManifestJson value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        ExtensionManifestJson.write$Self$app_release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
