package androidx.navigation;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NavType.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0096\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u001c\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u0013\u001a\u00020\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"androidx/navigation/NavType$Companion$FloatArrayType$1", "Landroidx/navigation/CollectionNavType;", "", "name", "", "getName", "()Ljava/lang/String;", "emptyCollection", "get", "bundle", "Landroid/os/Bundle;", "key", "parseValue", "value", "previousValue", "put", "", "serializeAsValues", "", "valueEquals", "", "other", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NavType$Companion$FloatArrayType$1 extends CollectionNavType<float[]> {
    @Override // androidx.navigation.CollectionNavType
    public float[] emptyCollection() {
        return new float[0];
    }

    NavType$Companion$FloatArrayType$1() {
        super(true);
    }

    @Override // androidx.navigation.NavType
    public String getName() {
        return "float[]";
    }

    @Override // androidx.navigation.NavType
    public void put(Bundle bundle, String key, float[] value) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        bundle.putFloatArray(key, value);
    }

    @Override // androidx.navigation.NavType
    public float[] get(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        return (float[]) bundle.get(key);
    }

    @Override // androidx.navigation.NavType
    public float[] parseValue(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new float[]{NavType.FloatType.parseValue(value).floatValue()};
    }

    @Override // androidx.navigation.NavType
    public float[] parseValue(String value, float[] previousValue) {
        float[] fArrPlus;
        Intrinsics.checkNotNullParameter(value, "value");
        return (previousValue == null || (fArrPlus = ArraysKt.plus(previousValue, parseValue(value))) == null) ? parseValue(value) : fArrPlus;
    }

    @Override // androidx.navigation.NavType
    public boolean valueEquals(float[] value, float[] other) {
        return ArraysKt.contentDeepEquals(value != null ? ArraysKt.toTypedArray(value) : null, other != null ? ArraysKt.toTypedArray(other) : null);
    }

    @Override // androidx.navigation.CollectionNavType
    public List<String> serializeAsValues(float[] value) {
        List<Float> list;
        if (value == null || (list = ArraysKt.toList(value)) == null) {
            return CollectionsKt.emptyList();
        }
        List<Float> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((Number) it.next()).floatValue()));
        }
        return arrayList;
    }
}
