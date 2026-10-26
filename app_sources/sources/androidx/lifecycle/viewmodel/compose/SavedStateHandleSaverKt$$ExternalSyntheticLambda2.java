package androidx.lifecycle.viewmodel.compose;

import androidx.compose.runtime.saveable.Saver;
import androidx.lifecycle.SavedStateHandle;
import kotlin.jvm.functions.Function0;
import kotlin.properties.PropertyDelegateProvider;
import kotlin.reflect.KProperty;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes.dex */
public final /* synthetic */ class SavedStateHandleSaverKt$$ExternalSyntheticLambda2 implements PropertyDelegateProvider {
    public final /* synthetic */ SavedStateHandle f$0;
    public final /* synthetic */ Saver f$1;
    public final /* synthetic */ Function0 f$2;

    public /* synthetic */ SavedStateHandleSaverKt$$ExternalSyntheticLambda2(SavedStateHandle savedStateHandle, Saver saver, Function0 function0) {
        this.f$0 = savedStateHandle;
        this.f$1 = saver;
        this.f$2 = function0;
    }

    @Override // kotlin.properties.PropertyDelegateProvider
    public final Object provideDelegate(Object obj, KProperty kProperty) {
        return SavedStateHandleSaverKt.saveable$lambda$4(this.f$0, this.f$1, this.f$2, obj, kProperty);
    }
}
