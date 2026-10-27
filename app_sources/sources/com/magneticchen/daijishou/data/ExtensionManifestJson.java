package com.magneticchen.daijishou.data;

import com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetViewModel;
import java.util.HashMap;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.io.ConstantsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: ExtensionManifestJson.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 W2\u00020\u0001:\u0002VWBÓ\u0002\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b\u00122\u0010\u0015\u001a.\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b\u0018\u00010\u0016j\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b\u0018\u0001`\u0017\u0012&\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0016j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0017\u0012&\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0016j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u0017\u0012\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b\u0012\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0002\u0010\u001fB«\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b\u00120\b\u0002\u0010\u0015\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\u0016j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b`\u0017\u0012\"\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0016j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0017\u0012\"\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001a0\u0016j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001a`\u0017\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\u0010 J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\u000f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0003J1\u0010<\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\u0016j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b`\u0017HÆ\u0003J%\u0010=\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0016j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0017HÆ\u0003J%\u0010>\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001a0\u0016j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001a`\u0017HÆ\u0003J\u000f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0003J\u000f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010E\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u000f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0003J\u000f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0003J\t\u0010H\u001a\u00020\u0010HÆ\u0003JÉ\u0002\u0010I\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00052\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b20\b\u0002\u0010\u0015\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\u0016j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b`\u00172$\b\u0002\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0016j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u00172$\b\u0002\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001a0\u0016j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001a`\u00172\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0001J\u0013\u0010J\u001a\u00020\u00102\b\u0010K\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010L\u001a\u00020\u0003HÖ\u0001J\t\u0010M\u001a\u00020\u0005HÖ\u0001J&\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020THÁ\u0001¢\u0006\u0002\bUR\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R-\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0016j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0017¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010)R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010)R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010)R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010.R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b/\u0010$R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b0\u0010$R-\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001a0\u0016j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001a`\u0017¢\u0006\b\n\u0000\u001a\u0004\b1\u0010'R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010)R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b3\u0010$R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b4\u0010$R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010)R9\u0010\u0015\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\u0016j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b`\u0017¢\u0006\b\n\u0000\u001a\u0004\b6\u0010'¨\u0006X"}, d2 = {"Lcom/magneticchen/daijishou/data/ExtensionManifestJson;", "", "seen1", "", "id", "", "name", "icon", "iconDarkTheme", "description", "authors", "", "Lcom/magneticchen/daijishou/data/ExtensionManifestDependencyJson;", "previewImages", "licenses", "isNSFW", "", "version", "apiLevel", "entry", "permissions", "whitelists", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "dependencies", "modules", "Lcom/magneticchen/daijishou/data/ExtensionManifestLibraryJson;", "categories", "keywords", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;ZLjava/lang/String;ILjava/lang/String;Ljava/util/List;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;ZLjava/lang/String;ILjava/lang/String;Ljava/util/List;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/List;Ljava/util/List;)V", "getApiLevel", "()I", "getAuthors", "()Ljava/util/List;", "getCategories", "getDependencies", "()Ljava/util/HashMap;", "getDescription", "()Ljava/lang/String;", "getEntry", "getIcon", "getIconDarkTheme", "getId", "()Z", "getKeywords", "getLicenses", "getModules", "getName", "getPermissions", "getPreviewImages", "getVersion", "getWhitelists", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
public final class ExtensionManifestJson {
    private final int apiLevel;
    private final List<ExtensionManifestDependencyJson> authors;
    private final List<String> categories;
    private final HashMap<String, String> dependencies;
    private final String description;
    private final String entry;
    private final String icon;
    private final String iconDarkTheme;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f7id;
    private final boolean isNSFW;
    private final List<String> keywords;
    private final List<String> licenses;
    private final HashMap<String, ExtensionManifestLibraryJson> modules;
    private final String name;
    private final List<String> permissions;
    private final List<String> previewImages;
    private final String version;
    private final HashMap<String, List<String>> whitelists;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, new ArrayListSerializer(ExtensionManifestDependencyJson$$serializer.INSTANCE), new ArrayListSerializer(StringSerializer.INSTANCE), new ArrayListSerializer(StringSerializer.INSTANCE), null, null, null, null, new ArrayListSerializer(StringSerializer.INSTANCE), new HashMapSerializer(StringSerializer.INSTANCE, new ArrayListSerializer(StringSerializer.INSTANCE)), new HashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE), new HashMapSerializer(StringSerializer.INSTANCE, ExtensionManifestLibraryJson$$serializer.INSTANCE), new ArrayListSerializer(StringSerializer.INSTANCE), new ArrayListSerializer(StringSerializer.INSTANCE)};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExtensionManifestJson copy$default(ExtensionManifestJson extensionManifestJson, String str, String str2, String str3, String str4, String str5, List list, List list2, List list3, boolean z, String str6, int i, String str7, List list4, HashMap map, HashMap map2, HashMap map3, List list5, List list6, int i2, Object obj) {
        List list7;
        List list8;
        String str8 = (i2 & 1) != 0 ? extensionManifestJson.f7id : str;
        String str9 = (i2 & 2) != 0 ? extensionManifestJson.name : str2;
        String str10 = (i2 & 4) != 0 ? extensionManifestJson.icon : str3;
        String str11 = (i2 & 8) != 0 ? extensionManifestJson.iconDarkTheme : str4;
        String str12 = (i2 & 16) != 0 ? extensionManifestJson.description : str5;
        List list9 = (i2 & 32) != 0 ? extensionManifestJson.authors : list;
        List list10 = (i2 & 64) != 0 ? extensionManifestJson.previewImages : list2;
        List list11 = (i2 & 128) != 0 ? extensionManifestJson.licenses : list3;
        boolean z2 = (i2 & 256) != 0 ? extensionManifestJson.isNSFW : z;
        String str13 = (i2 & 512) != 0 ? extensionManifestJson.version : str6;
        int i3 = (i2 & CategoryWidgetViewModel.LIMIT) != 0 ? extensionManifestJson.apiLevel : i;
        String str14 = (i2 & 2048) != 0 ? extensionManifestJson.entry : str7;
        List list12 = (i2 & 4096) != 0 ? extensionManifestJson.permissions : list4;
        HashMap map4 = (i2 & ConstantsKt.DEFAULT_BUFFER_SIZE) != 0 ? extensionManifestJson.whitelists : map;
        String str15 = str8;
        HashMap map5 = (i2 & 16384) != 0 ? extensionManifestJson.dependencies : map2;
        HashMap map6 = (i2 & 32768) != 0 ? extensionManifestJson.modules : map3;
        List list13 = (i2 & 65536) != 0 ? extensionManifestJson.categories : list5;
        if ((i2 & 131072) != 0) {
            list8 = list13;
            list7 = extensionManifestJson.keywords;
        } else {
            list7 = list6;
            list8 = list13;
        }
        return extensionManifestJson.copy(str15, str9, str10, str11, str12, list9, list10, list11, z2, str13, i3, str14, list12, map4, map5, map6, list8, list7);
    }

    public final String component1() {
        return this.f7id;
    }

    public final String component10() {
        return this.version;
    }

    public final int component11() {
        return this.apiLevel;
    }

    public final String component12() {
        return this.entry;
    }

    public final List<String> component13() {
        return this.permissions;
    }

    public final HashMap<String, List<String>> component14() {
        return this.whitelists;
    }

    public final HashMap<String, String> component15() {
        return this.dependencies;
    }

    public final HashMap<String, ExtensionManifestLibraryJson> component16() {
        return this.modules;
    }

    public final List<String> component17() {
        return this.categories;
    }

    public final List<String> component18() {
        return this.keywords;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.icon;
    }

    public final String component4() {
        return this.iconDarkTheme;
    }

    public final String component5() {
        return this.description;
    }

    public final List<ExtensionManifestDependencyJson> component6() {
        return this.authors;
    }

    public final List<String> component7() {
        return this.previewImages;
    }

    public final List<String> component8() {
        return this.licenses;
    }

    public final boolean component9() {
        return this.isNSFW;
    }

    public final ExtensionManifestJson copy(String id2, String str, String str2, String str3, String str4, List<ExtensionManifestDependencyJson> authors, List<String> previewImages, List<String> licenses, boolean z, String version, int i, String entry, List<String> permissions, HashMap<String, List<String>> whitelists, HashMap<String, String> dependencies, HashMap<String, ExtensionManifestLibraryJson> modules, List<String> categories, List<String> keywords) {
        Intrinsics.checkNotNullParameter(id2, "id");
        Intrinsics.checkNotNullParameter(authors, "authors");
        Intrinsics.checkNotNullParameter(previewImages, "previewImages");
        Intrinsics.checkNotNullParameter(licenses, "licenses");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(entry, "entry");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(whitelists, "whitelists");
        Intrinsics.checkNotNullParameter(dependencies, "dependencies");
        Intrinsics.checkNotNullParameter(modules, "modules");
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        return new ExtensionManifestJson(id2, str, str2, str3, str4, authors, previewImages, licenses, z, version, i, entry, permissions, whitelists, dependencies, modules, categories, keywords);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExtensionManifestJson)) {
            return false;
        }
        ExtensionManifestJson extensionManifestJson = (ExtensionManifestJson) obj;
        return Intrinsics.areEqual(this.f7id, extensionManifestJson.f7id) && Intrinsics.areEqual(this.name, extensionManifestJson.name) && Intrinsics.areEqual(this.icon, extensionManifestJson.icon) && Intrinsics.areEqual(this.iconDarkTheme, extensionManifestJson.iconDarkTheme) && Intrinsics.areEqual(this.description, extensionManifestJson.description) && Intrinsics.areEqual(this.authors, extensionManifestJson.authors) && Intrinsics.areEqual(this.previewImages, extensionManifestJson.previewImages) && Intrinsics.areEqual(this.licenses, extensionManifestJson.licenses) && this.isNSFW == extensionManifestJson.isNSFW && Intrinsics.areEqual(this.version, extensionManifestJson.version) && this.apiLevel == extensionManifestJson.apiLevel && Intrinsics.areEqual(this.entry, extensionManifestJson.entry) && Intrinsics.areEqual(this.permissions, extensionManifestJson.permissions) && Intrinsics.areEqual(this.whitelists, extensionManifestJson.whitelists) && Intrinsics.areEqual(this.dependencies, extensionManifestJson.dependencies) && Intrinsics.areEqual(this.modules, extensionManifestJson.modules) && Intrinsics.areEqual(this.categories, extensionManifestJson.categories) && Intrinsics.areEqual(this.keywords, extensionManifestJson.keywords);
    }

    public int hashCode() {
        int iHashCode = this.f7id.hashCode() * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.icon;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.iconDarkTheme;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.description;
        return ((((((((((((((((((((((((((iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.authors.hashCode()) * 31) + this.previewImages.hashCode()) * 31) + this.licenses.hashCode()) * 31) + Boolean.hashCode(this.isNSFW)) * 31) + this.version.hashCode()) * 31) + Integer.hashCode(this.apiLevel)) * 31) + this.entry.hashCode()) * 31) + this.permissions.hashCode()) * 31) + this.whitelists.hashCode()) * 31) + this.dependencies.hashCode()) * 31) + this.modules.hashCode()) * 31) + this.categories.hashCode()) * 31) + this.keywords.hashCode();
    }

    public String toString() {
        return "ExtensionManifestJson(id=" + this.f7id + ", name=" + this.name + ", icon=" + this.icon + ", iconDarkTheme=" + this.iconDarkTheme + ", description=" + this.description + ", authors=" + this.authors + ", previewImages=" + this.previewImages + ", licenses=" + this.licenses + ", isNSFW=" + this.isNSFW + ", version=" + this.version + ", apiLevel=" + this.apiLevel + ", entry=" + this.entry + ", permissions=" + this.permissions + ", whitelists=" + this.whitelists + ", dependencies=" + this.dependencies + ", modules=" + this.modules + ", categories=" + this.categories + ", keywords=" + this.keywords + ")";
    }

    /* JADX INFO: compiled from: ExtensionManifestJson.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/magneticchen/daijishou/data/ExtensionManifestJson$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/magneticchen/daijishou/data/ExtensionManifestJson;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ExtensionManifestJson> serializer() {
            return ExtensionManifestJson$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ ExtensionManifestJson(int i, String str, String str2, String str3, String str4, String str5, List list, List list2, List list3, boolean z, String str6, int i2, String str7, List list4, HashMap map, HashMap map2, HashMap map3, List list5, List list6, SerializationConstructorMarker serializationConstructorMarker) {
        if (253921 != (i & 253921)) {
            PluginExceptionsKt.throwMissingFieldException(i, 253921, ExtensionManifestJson$$serializer.INSTANCE.getDescriptor());
        }
        this.f7id = str;
        if ((i & 2) == 0) {
            this.name = null;
        } else {
            this.name = str2;
        }
        if ((i & 4) == 0) {
            this.icon = null;
        } else {
            this.icon = str3;
        }
        if ((i & 8) == 0) {
            this.iconDarkTheme = null;
        } else {
            this.iconDarkTheme = str4;
        }
        if ((i & 16) == 0) {
            this.description = null;
        } else {
            this.description = str5;
        }
        this.authors = list;
        this.previewImages = list2;
        this.licenses = list3;
        this.isNSFW = z;
        this.version = str6;
        this.apiLevel = i2;
        this.entry = str7;
        this.permissions = list4;
        this.whitelists = (i & ConstantsKt.DEFAULT_BUFFER_SIZE) == 0 ? new HashMap() : map;
        this.dependencies = map2;
        this.modules = map3;
        this.categories = list5;
        this.keywords = list6;
    }

    public ExtensionManifestJson(String id2, String str, String str2, String str3, String str4, List<ExtensionManifestDependencyJson> authors, List<String> previewImages, List<String> licenses, boolean z, String version, int i, String entry, List<String> permissions, HashMap<String, List<String>> whitelists, HashMap<String, String> dependencies, HashMap<String, ExtensionManifestLibraryJson> modules, List<String> categories, List<String> keywords) {
        Intrinsics.checkNotNullParameter(id2, "id");
        Intrinsics.checkNotNullParameter(authors, "authors");
        Intrinsics.checkNotNullParameter(previewImages, "previewImages");
        Intrinsics.checkNotNullParameter(licenses, "licenses");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(entry, "entry");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(whitelists, "whitelists");
        Intrinsics.checkNotNullParameter(dependencies, "dependencies");
        Intrinsics.checkNotNullParameter(modules, "modules");
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        this.f7id = id2;
        this.name = str;
        this.icon = str2;
        this.iconDarkTheme = str3;
        this.description = str4;
        this.authors = authors;
        this.previewImages = previewImages;
        this.licenses = licenses;
        this.isNSFW = z;
        this.version = version;
        this.apiLevel = i;
        this.entry = entry;
        this.permissions = permissions;
        this.whitelists = whitelists;
        this.dependencies = dependencies;
        this.modules = modules;
        this.categories = categories;
        this.keywords = keywords;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app_release(ExtensionManifestJson extensionManifestJson, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        SerializationStrategy[] serializationStrategyArr = $childSerializers;
        compositeEncoder.encodeStringElement(serialDescriptor, 0, extensionManifestJson.f7id);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || extensionManifestJson.name != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, extensionManifestJson.name);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || extensionManifestJson.icon != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, extensionManifestJson.icon);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) || extensionManifestJson.iconDarkTheme != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, extensionManifestJson.iconDarkTheme);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 4) || extensionManifestJson.description != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, extensionManifestJson.description);
        }
        compositeEncoder.encodeSerializableElement(serialDescriptor, 5, serializationStrategyArr[5], extensionManifestJson.authors);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 6, serializationStrategyArr[6], extensionManifestJson.previewImages);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 7, serializationStrategyArr[7], extensionManifestJson.licenses);
        compositeEncoder.encodeBooleanElement(serialDescriptor, 8, extensionManifestJson.isNSFW);
        compositeEncoder.encodeStringElement(serialDescriptor, 9, extensionManifestJson.version);
        compositeEncoder.encodeIntElement(serialDescriptor, 10, extensionManifestJson.apiLevel);
        compositeEncoder.encodeStringElement(serialDescriptor, 11, extensionManifestJson.entry);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 12, serializationStrategyArr[12], extensionManifestJson.permissions);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 13) || !Intrinsics.areEqual(extensionManifestJson.whitelists, new HashMap())) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 13, serializationStrategyArr[13], extensionManifestJson.whitelists);
        }
        compositeEncoder.encodeSerializableElement(serialDescriptor, 14, serializationStrategyArr[14], extensionManifestJson.dependencies);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 15, serializationStrategyArr[15], extensionManifestJson.modules);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 16, serializationStrategyArr[16], extensionManifestJson.categories);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 17, serializationStrategyArr[17], extensionManifestJson.keywords);
    }

    public final String getId() {
        return this.f7id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getIconDarkTheme() {
        return this.iconDarkTheme;
    }

    public final String getDescription() {
        return this.description;
    }

    public final List<ExtensionManifestDependencyJson> getAuthors() {
        return this.authors;
    }

    public final List<String> getPreviewImages() {
        return this.previewImages;
    }

    public final List<String> getLicenses() {
        return this.licenses;
    }

    public final boolean isNSFW() {
        return this.isNSFW;
    }

    public final String getVersion() {
        return this.version;
    }

    public final int getApiLevel() {
        return this.apiLevel;
    }

    public final String getEntry() {
        return this.entry;
    }

    public final List<String> getPermissions() {
        return this.permissions;
    }

    public /* synthetic */ ExtensionManifestJson(String str, String str2, String str3, String str4, String str5, List list, List list2, List list3, boolean z, String str6, int i, String str7, List list4, HashMap map, HashMap map2, HashMap map3, List list5, List list6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? null : str5, list, list2, list3, z, str6, i, str7, list4, (i2 & ConstantsKt.DEFAULT_BUFFER_SIZE) != 0 ? new HashMap() : map, map2, map3, list5, list6);
    }

    public final HashMap<String, List<String>> getWhitelists() {
        return this.whitelists;
    }

    public final HashMap<String, String> getDependencies() {
        return this.dependencies;
    }

    public final HashMap<String, ExtensionManifestLibraryJson> getModules() {
        return this.modules;
    }

    public final List<String> getCategories() {
        return this.categories;
    }

    public final List<String> getKeywords() {
        return this.keywords;
    }
}
