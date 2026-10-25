package com.magneticchen.daijishou.application_data;

import android.net.Uri;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;

/* JADX INFO: compiled from: RoomDatabaseConverters.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0007J\u0016\u0010\r\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0007J\u0016\u0010\u000e\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\u0007J\u0016\u0010\u000f\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bH\u0007J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0012H\u0007J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0010H\u0007J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\n\u001a\u00020\tH\u0007J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\n\u001a\u00020\tH\u0007J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\u0006\u0010\n\u001a\u00020\tH\u0007J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b2\u0006\u0010\n\u001a\u00020\tH\u0007J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00122\u0006\u0010\n\u001a\u00020\tH\u0007J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\tH\u0007¨\u0006\u001d"}, d2 = {"Lcom/magneticchen/daijishou/application_data/RoomDatabaseConverters;", "", "()V", "fromDate", "", "date", "Ljava/util/Date;", "(Ljava/util/Date;)Ljava/lang/Long;", "fromMutableIntList", "", "value", "", "", "fromMutableLongList", "fromMutableStringList", "fromMutableUriList", "Landroid/net/Uri;", "fromParcelable", "Landroid/os/Parcelable;", "fromUriList", "toDate", "dateLong", "(Ljava/lang/Long;)Ljava/util/Date;", "toMutableIntList", "toMutableLongList", "toMutableStringList", "toMutableUriList", "toParcelable", "toUriList", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RoomDatabaseConverters {
    public final String fromParcelable(Parcelable value) {
        Json companion = Json.Default;
        companion.getSerializersModule();
        return companion.encodeToString(BuiltinSerializersKt.getNullable(new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(Parcelable.class))), value);
    }

    public final Parcelable toParcelable(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Json companion = Json.Default;
        companion.getSerializersModule();
        return (Parcelable) companion.decodeFromString(BuiltinSerializersKt.getNullable(new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(Parcelable.class))), value);
    }

    public final String fromMutableStringList(List<String> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Json companion = Json.Default;
        companion.getSerializersModule();
        return companion.encodeToString(new ArrayListSerializer(StringSerializer.INSTANCE), value);
    }

    public final List<String> toMutableStringList(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Json companion = Json.Default;
        companion.getSerializersModule();
        return (List) companion.decodeFromString(new ArrayListSerializer(StringSerializer.INSTANCE), value);
    }

    public final String fromMutableIntList(List<Integer> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Json companion = Json.Default;
        companion.getSerializersModule();
        return companion.encodeToString(new ArrayListSerializer(IntSerializer.INSTANCE), value);
    }

    public final List<Integer> toMutableIntList(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Json companion = Json.Default;
        companion.getSerializersModule();
        return (List) companion.decodeFromString(new ArrayListSerializer(IntSerializer.INSTANCE), value);
    }

    public final String fromMutableLongList(List<Long> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Json companion = Json.Default;
        companion.getSerializersModule();
        return companion.encodeToString(new ArrayListSerializer(LongSerializer.INSTANCE), value);
    }

    public final List<Long> toMutableLongList(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Json companion = Json.Default;
        companion.getSerializersModule();
        return (List) companion.decodeFromString(new ArrayListSerializer(LongSerializer.INSTANCE), value);
    }

    public final Date toDate(Long dateLong) {
        if (dateLong != null) {
            return new Date(dateLong.longValue());
        }
        return null;
    }

    public final Long fromDate(Date date) {
        if (date != null) {
            return Long.valueOf(date.getTime());
        }
        return null;
    }

    public final String fromMutableUriList(List<Uri> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        int size = value.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(value.get(i).toString());
        }
        Json companion = Json.Default;
        companion.getSerializersModule();
        return companion.encodeToString(new ArrayListSerializer(StringSerializer.INSTANCE), arrayList);
    }

    public final List<Uri> toMutableUriList(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Json companion = Json.Default;
        companion.getSerializersModule();
        List list = (List) companion.decodeFromString(new ArrayListSerializer(StringSerializer.INSTANCE), value);
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            Uri uri = Uri.parse((String) list.get(i));
            Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
            arrayList.add(uri);
        }
        return arrayList;
    }

    public final String fromUriList(Uri value) {
        Intrinsics.checkNotNullParameter(value, "value");
        String string = value.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final Uri toUriList(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Uri uri = Uri.parse(value);
        Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
        return uri;
    }
}
