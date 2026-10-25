package androidx.compose.runtime.saveable;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: ListSaver.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a}\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000422\u0010\u0005\u001a.\u0012\u0004\u0012\u00020\u0007\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000b0\u0006¢\u0006\u0002\b\f2)\u0010\r\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u00040\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000e¨\u0006\u0010"}, d2 = {"listSaver", "Landroidx/compose/runtime/saveable/Saver;", "Original", "", "Saveable", "save", "Lkotlin/Function2;", "Landroidx/compose/runtime/saveable/SaverScope;", "Lkotlin/ParameterName;", "name", "value", "", "Lkotlin/ExtensionFunctionType;", "restore", "Lkotlin/Function1;", "list", "runtime-saveable_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ListSaverKt {
    public static final <Original, Saveable> Saver<Original, Object> listSaver(Function2<? super SaverScope, ? super Original, ? extends List<? extends Saveable>> function2, Function1<? super List<? extends Saveable>, ? extends Original> function1) {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(function2);
        Intrinsics.checkNotNull(function1, "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, Original of androidx.compose.runtime.saveable.ListSaverKt.listSaver?>");
        return SaverKt.Saver(anonymousClass1, (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1));
    }

    /* JADX INFO: Add missing generic type declarations: [Original] */
    /* JADX INFO: renamed from: androidx.compose.runtime.saveable.ListSaverKt$listSaver$1, reason: invalid class name */
    /* JADX INFO: compiled from: ListSaver.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "Original", "Saveable", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "invoke", "(Landroidx/compose/runtime/saveable/SaverScope;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass1<Original> extends Lambda implements Function2<SaverScope, Original, Object> {
        final /* synthetic */ Function2<SaverScope, Original, List<Saveable>> $save;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function2<? super SaverScope, ? super Original, ? extends List<? extends Saveable>> function2) {
            super(2);
            this.$save = function2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, Original original) {
            List list = (List) this.$save.invoke(saverScope, original);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Object obj = list.get(i);
                if (obj != null && !saverScope.canBeSaved(obj)) {
                    throw new IllegalArgumentException("item can't be saved".toString());
                }
            }
            List list2 = list;
            if (list2.isEmpty()) {
                return null;
            }
            return new ArrayList(list2);
        }
    }
}
