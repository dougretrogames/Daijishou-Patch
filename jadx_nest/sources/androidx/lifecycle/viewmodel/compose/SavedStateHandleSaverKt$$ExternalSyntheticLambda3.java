package androidx.lifecycle.viewmodel.compose;

import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SavedStateHandleSaverKt$$ExternalSyntheticLambda3 implements ReadOnlyProperty {
    public final /* synthetic */ Object f$0;

    public /* synthetic */ SavedStateHandleSaverKt$$ExternalSyntheticLambda3(Object obj) {
        this.f$0 = obj;
    }

    @Override // kotlin.properties.ReadOnlyProperty
    public final Object getValue(Object obj, KProperty kProperty) {
        return SavedStateHandleSaverKt.saveable$lambda$3$lambda$2(this.f$0, obj, kProperty);
    }
}
