package com.magneticchen.daijishou.data.migration;

import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: PlatformsForeverUpgradeScript.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\f0\u0010H\u0096@¢\u0006\u0002\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013²\u0006\n\u0010\u0014\u001a\u00020\u0015X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/data/migration/PlatformsForeverUpgradeScript;", "Lcom/magneticchen/daijishou/data/migration/UpgradeScript;", "()V", "toVersion", "", "getToVersion", "()I", "upgradeDescription", "", "getUpgradeDescription", "()Ljava/lang/String;", "upgrade", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "callback", "Lkotlin/Function1;", "", "(Landroidx/appcompat/app/AppCompatActivity;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release", "daijishouSynchronization", "Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PlatformsForeverUpgradeScript extends UpgradeScript {
    private final String upgradeDescription = "Updating platforms";
    private final int toVersion = 999999999;

    @Override // com.magneticchen.daijishou.data.migration.UpgradeScript
    public String getUpgradeDescription() {
        return this.upgradeDescription;
    }

    @Override // com.magneticchen.daijishou.data.migration.UpgradeScript
    public int getToVersion() {
        return this.toVersion;
    }

    private static final DaijishouSynchronizationModel upgrade$lambda$0(Lazy<DaijishouSynchronizationModel> lazy) {
        return lazy.getValue();
    }

    @Override // com.magneticchen.daijishou.data.migration.UpgradeScript
    public Object upgrade(AppCompatActivity appCompatActivity, final Function1<? super Boolean, Unit> function1, Continuation<? super Unit> continuation) {
        Object objM478constructorimpl;
        final ComponentActivity componentActivity = (ComponentActivity) appCompatActivity;
        final Function0 function0 = null;
        Lazy viewModelLazy = new ViewModelLazy(Reflection.getOrCreateKotlinClass(DaijishouSynchronizationModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.data.migration.PlatformsForeverUpgradeScript$upgrade$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return componentActivity.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.data.migration.PlatformsForeverUpgradeScript$upgrade$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return componentActivity.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.data.migration.PlatformsForeverUpgradeScript$upgrade$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function2 = function0;
                return (function2 == null || (creationExtras = (CreationExtras) function2.invoke()) == null) ? componentActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        try {
            Result.Companion companion = Result.Companion;
            PlatformsForeverUpgradeScript platformsForeverUpgradeScript = this;
            upgrade$lambda$0(viewModelLazy).updatePlatformsFromGitHub(new Function1<Boolean, Unit>() { // from class: com.magneticchen.daijishou.data.migration.PlatformsForeverUpgradeScript$upgrade$result$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z) {
                    function1.invoke(true);
                }
            });
            objM478constructorimpl = Result.m478constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            objM478constructorimpl = Result.m478constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m484isFailureimpl(objM478constructorimpl)) {
            Throwable thM481exceptionOrNullimpl = Result.m481exceptionOrNullimpl(objM478constructorimpl);
            if (thM481exceptionOrNullimpl != null) {
                thM481exceptionOrNullimpl.printStackTrace();
            }
            function1.invoke(Boxing.boxBoolean(true));
        }
        return Unit.INSTANCE;
    }
}
