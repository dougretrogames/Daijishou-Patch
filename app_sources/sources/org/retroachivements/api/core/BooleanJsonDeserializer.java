package org.retroachivements.api.core;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: BooleanJsonDeserializer.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lorg/retroachivements/api/core/BooleanJsonDeserializer;", "Lcom/google/gson/JsonDeserializer;", "", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Ljava/lang/Boolean;", "api-kotlin"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BooleanJsonDeserializer implements JsonDeserializer<Boolean> {
    /* WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public Boolean deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(typeOfT, "typeOfT");
        Intrinsics.checkNotNullParameter(context, "context");
        JsonPrimitive asJsonPrimitive = json.getAsJsonPrimitive();
        if (asJsonPrimitive.isBoolean()) {
            return Boolean.valueOf(asJsonPrimitive.getAsBoolean());
        }
        if (asJsonPrimitive.isNumber()) {
            return Boolean.valueOf(asJsonPrimitive.getAsNumber().intValue() == 1);
        }
        return false;
    }
}
