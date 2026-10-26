package androidx.compose.runtime.saveable;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: SaveableStateHolder.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "Landroidx/compose/runtime/DisposableEffectScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class SaveableStateHolderImpl$SaveableStateProvider$1$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ Object $key;
    final /* synthetic */ SaveableStateHolderImpl.RegistryHolder $registryHolder;
    final /* synthetic */ SaveableStateHolderImpl this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    SaveableStateHolderImpl$SaveableStateProvider$1$1(SaveableStateHolderImpl saveableStateHolderImpl, Object obj, SaveableStateHolderImpl.RegistryHolder registryHolder) {
        super(1);
        this.this$0 = saveableStateHolderImpl;
        this.$key = obj;
        this.$registryHolder = registryHolder;
    }

    @Override // kotlin.jvm.functions.Function1
    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
        boolean zContainsKey = this.this$0.registryHolders.containsKey(this.$key);
        Object obj = this.$key;
        if (!zContainsKey) {
            this.this$0.savedStates.remove(this.$key);
            this.this$0.registryHolders.put(this.$key, this.$registryHolder);
            return new SaveableStateHolderImpl$SaveableStateProvider$1$1$invoke$$inlined$onDispose$1(this.$registryHolder, this.this$0, this.$key);
        }
        throw new IllegalArgumentException(("Key " + obj + " was used multiple times ").toString());
    }
}
