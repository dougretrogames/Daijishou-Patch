package androidx.navigation.serialization;

import android.os.Bundle;
import androidx.navigation.NavType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* INFO: compiled from: NavTypeConverter.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J \u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0002\u0010\u000bJ\u0017\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u000eJ'\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"androidx/navigation/serialization/InternalNavType$LongNullableType$1", "Landroidx/navigation/NavType;", "", "name", "", "getName", "()Ljava/lang/String;", "get", "bundle", "Landroid/os/Bundle;", "key", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Long;", "parseValue", "value", "(Ljava/lang/String;)Ljava/lang/Long;", "put", "", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Long;)V", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InternalNavType$LongNullableType$1 extends NavType<Long> {
    InternalNavType$LongNullableType$1() {
        super(true);
    }

    @Override // androidx.navigation.NavType
    public String getName() {
        return "long_nullable";
    }

    @Override // androidx.navigation.NavType
    public void put(Bundle bundle, String key, Long value) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        if (value == null) {
            bundle.putSerializable(key, null);
        } else {
            NavType.LongType.put(bundle, key, value);
        }
    }

    /* WARN: Can't rename method to resolve collision */
    @Override // androidx.navigation.NavType
    public Long get(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = bundle.get(key);
        if (obj instanceof Long) {
            return (Long) obj;
        }
        return null;
    }

    /* WARN: Can't rename method to resolve collision */
    @Override // androidx.navigation.NavType
    public Long parseValue(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(value, AbstractJsonLexerKt.NULL)) {
            return null;
        }
        return NavType.LongType.parseValue(value);
    }
}
