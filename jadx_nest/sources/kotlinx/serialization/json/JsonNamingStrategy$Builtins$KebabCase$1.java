package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.apache.commons.codec.language.Soundex;

/* JADX INFO: compiled from: JsonNamingStrategy.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"kotlinx/serialization/json/JsonNamingStrategy$Builtins$KebabCase$1", "Lkotlinx/serialization/json/JsonNamingStrategy;", "serialNameForJson", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementIndex", "", "serialName", "toString", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class JsonNamingStrategy$Builtins$KebabCase$1 implements JsonNamingStrategy {
    JsonNamingStrategy$Builtins$KebabCase$1() {
    }

    @Override // kotlinx.serialization.json.JsonNamingStrategy
    public String serialNameForJson(SerialDescriptor descriptor, int elementIndex, String serialName) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        return JsonNamingStrategy.Companion.$$INSTANCE.convertCamelCase(serialName, Soundex.SILENT_MARKER);
    }

    public String toString() {
        return "kotlinx.serialization.json.JsonNamingStrategy.KebabCase";
    }
}
