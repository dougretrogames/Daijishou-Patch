package org.retroachivements.api.core;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DateFormatAdapterFactory.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\tH\u0016J\u0018\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00042\u0006\u0010\f\u001a\u00020\rH\u0002J\u0014\u0010\u000e\u001a\u00020\r2\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0002¨\u0006\u0010"}, d2 = {"Lorg/retroachivements/api/core/DateFormatAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "()V", "create", "Lcom/google/gson/TypeAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "gson", "Lcom/google/gson/Gson;", "type", "Lcom/google/gson/reflect/TypeToken;", "createAdapter", "Ljava/util/Date;", "dateFormat", "Ljava/text/DateFormat;", "getDateFormat", "Ljava/lang/Class;", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DateFormatAdapterFactory implements TypeAdapterFactory {
    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(type, "type");
        if (!Intrinsics.areEqual(type.getRawType(), Date.class)) {
            return null;
        }
        Class<? super T> rawType = type.getRawType();
        Intrinsics.checkNotNullExpressionValue(rawType, "getRawType(...)");
        TypeAdapter<T> typeAdapter = (TypeAdapter<T>) createAdapter(getDateFormat(rawType));
        Intrinsics.checkNotNull(typeAdapter, "null cannot be cast to non-null type com.google.gson.TypeAdapter<T of org.retroachivements.api.core.DateFormatAdapterFactory.create>");
        return typeAdapter;
    }

    /* JADX INFO: renamed from: org.retroachivements.api.core.DateFormatAdapterFactory$createAdapter$1, reason: invalid class name */
    /* JADX INFO: compiled from: DateFormatAdapterFactory.kt */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000b"}, d2 = {"org/retroachivements/api/core/DateFormatAdapterFactory$createAdapter$1", "Lcom/google/gson/TypeAdapter;", "Ljava/util/Date;", "read", "in", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AnonymousClass1 extends TypeAdapter<Date> {
        final /* synthetic */ java.text.DateFormat $dateFormat;

        @Override // com.google.gson.TypeAdapter
        public Date read(JsonReader in) {
            Intrinsics.checkNotNullParameter(in, "in");
            return null;
        }

        AnonymousClass1(java.text.DateFormat dateFormat) {
            this.$dateFormat = dateFormat;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter out, Date value) throws IOException {
            Intrinsics.checkNotNullParameter(out, "out");
            if (value == null) {
                out.nullValue();
            } else {
                out.value(this.$dateFormat.format(value));
            }
        }
    }

    private final TypeAdapter<Date> createAdapter(java.text.DateFormat dateFormat) {
        return new AnonymousClass1(dateFormat);
    }

    private final java.text.DateFormat getDateFormat(Class<?> type) {
        DateFormat dateFormat = (DateFormat) type.getAnnotation(DateFormat.class);
        if (dateFormat != null) {
            return new SimpleDateFormat(dateFormat.value());
        }
        return new SimpleDateFormat("MM/dd/yyyy");
    }
}
