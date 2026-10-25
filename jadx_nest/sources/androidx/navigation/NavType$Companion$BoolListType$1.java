package androidx.navigation;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NavType.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J!\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0096\u0002J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J(\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u00052\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J(\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J(\u0010\u0013\u001a\u00020\u00032\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"androidx/navigation/NavType$Companion$BoolListType$1", "Landroidx/navigation/CollectionNavType;", "", "", "name", "", "getName", "()Ljava/lang/String;", "emptyCollection", "get", "bundle", "Landroid/os/Bundle;", "key", "parseValue", "value", "previousValue", "put", "", "serializeAsValues", "valueEquals", "other", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NavType$Companion$BoolListType$1 extends CollectionNavType<List<? extends Boolean>> {
    NavType$Companion$BoolListType$1() {
        super(true);
    }

    @Override // androidx.navigation.CollectionNavType
    public /* bridge */ /* synthetic */ List serializeAsValues(List<? extends Boolean> list) {
        return serializeAsValues2((List<Boolean>) list);
    }

    @Override // androidx.navigation.NavType
    public String getName() {
        return "List<Boolean>";
    }

    @Override // androidx.navigation.NavType
    public void put(Bundle bundle, String key, List<Boolean> value) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        bundle.putBooleanArray(key, value != null ? CollectionsKt.toBooleanArray(value) : null);
    }

    @Override // androidx.navigation.NavType
    public List<Boolean> get(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        boolean[] zArr = (boolean[]) bundle.get(key);
        if (zArr != null) {
            return ArraysKt.toList(zArr);
        }
        return null;
    }

    @Override // androidx.navigation.NavType
    public List<Boolean> parseValue(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return CollectionsKt.listOf(NavType.BoolType.parseValue(value));
    }

    @Override // androidx.navigation.NavType
    public List<Boolean> parseValue(String value, List<Boolean> previousValue) {
        List<Boolean> listPlus;
        Intrinsics.checkNotNullParameter(value, "value");
        return (previousValue == null || (listPlus = CollectionsKt.plus((Collection) previousValue, (Iterable) parseValue(value))) == null) ? parseValue(value) : listPlus;
    }

    @Override // androidx.navigation.NavType
    public boolean valueEquals(List<Boolean> value, List<Boolean> other) {
        return ArraysKt.contentDeepEquals(value != null ? (Boolean[]) value.toArray(new Boolean[0]) : null, other != null ? (Boolean[]) other.toArray(new Boolean[0]) : null);
    }

    /* JADX INFO: renamed from: serializeAsValues, reason: avoid collision after fix types in other method */
    public List<String> serializeAsValues2(List<Boolean> value) {
        if (value != null) {
            List<Boolean> list = value;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf(((Boolean) it.next()).booleanValue()));
            }
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }

    @Override // androidx.navigation.CollectionNavType
    public List<? extends Boolean> emptyCollection() {
        return CollectionsKt.emptyList();
    }
}
