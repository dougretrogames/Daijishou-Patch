package androidx.navigation.serialization;

import android.net.Uri;
import android.os.Bundle;
import androidx.navigation.CollectionNavType;
import androidx.navigation.NavType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NavTypeConverter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001J\u0017\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\bJ(\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0002\u0010\rJ\u001d\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u0010J1\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u00032\u0010\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0012J/\u0010\u0013\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0015J%\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0018J1\u0010\u0019\u001a\u00020\u001a2\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00022\u0010\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u001cR\u0014\u0010\u0004\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001d"}, d2 = {"androidx/navigation/serialization/InternalNavType$StringNullableArrayType$1", "Landroidx/navigation/CollectionNavType;", "", "", "name", "getName", "()Ljava/lang/String;", "emptyCollection", "()[Ljava/lang/String;", "get", "bundle", "Landroid/os/Bundle;", "key", "(Landroid/os/Bundle;Ljava/lang/String;)[Ljava/lang/String;", "parseValue", "value", "(Ljava/lang/String;)[Ljava/lang/String;", "previousValue", "(Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;", "put", "", "(Landroid/os/Bundle;Ljava/lang/String;[Ljava/lang/String;)V", "serializeAsValues", "", "([Ljava/lang/String;)Ljava/util/List;", "valueEquals", "", "other", "([Ljava/lang/String;[Ljava/lang/String;)Z", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InternalNavType$StringNullableArrayType$1 extends CollectionNavType<String[]> {
    @Override // androidx.navigation.CollectionNavType
    public String[] emptyCollection() {
        return new String[0];
    }

    InternalNavType$StringNullableArrayType$1() {
        super(true);
    }

    @Override // androidx.navigation.NavType
    public String getName() {
        return "string_nullable[]";
    }

    @Override // androidx.navigation.NavType
    public void put(Bundle bundle, String key, String[] value) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        bundle.putStringArray(key, value);
    }

    @Override // androidx.navigation.NavType
    public String[] get(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        return (String[]) bundle.get(key);
    }

    @Override // androidx.navigation.NavType
    public String[] parseValue(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new String[]{NavType.StringType.parseValue(value)};
    }

    @Override // androidx.navigation.NavType
    public String[] parseValue(String value, String[] previousValue) {
        String[] strArr;
        Intrinsics.checkNotNullParameter(value, "value");
        return (previousValue == null || (strArr = (String[]) ArraysKt.plus((Object[]) previousValue, (Object[]) parseValue(value))) == null) ? parseValue(value) : strArr;
    }

    @Override // androidx.navigation.NavType
    public boolean valueEquals(String[] value, String[] other) {
        return ArraysKt.contentDeepEquals(value, other);
    }

    @Override // androidx.navigation.CollectionNavType
    public List<String> serializeAsValues(String[] value) {
        if (value == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(value.length);
        for (String str : value) {
            arrayList.add(Uri.encode(str));
        }
        return arrayList;
    }
}
