package androidx.compose.runtime;

import androidx.compose.runtime.changelist.ChangeList;
import androidx.compose.runtime.changelist.ComposerChangeListWriter;
import androidx.compose.runtime.collection.IntMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: Composer.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class ComposerImpl$insertMovableContentGuarded$1$1$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ChangeList $offsetChanges;
    final /* synthetic */ SlotReader $reader;
    final /* synthetic */ MovableContentStateReference $to;
    final /* synthetic */ ComposerImpl this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComposerImpl$insertMovableContentGuarded$1$1$1$1(ComposerImpl composerImpl, ChangeList changeList, SlotReader slotReader, MovableContentStateReference movableContentStateReference) {
        super(0);
        this.this$0 = composerImpl;
        this.$offsetChanges = changeList;
        this.$reader = slotReader;
        this.$to = movableContentStateReference;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ComposerChangeListWriter composerChangeListWriter = this.this$0.changeListWriter;
        ChangeList changeList = this.$offsetChanges;
        ComposerImpl composerImpl = this.this$0;
        SlotReader slotReader = this.$reader;
        MovableContentStateReference movableContentStateReference = this.$to;
        ChangeList changeList2 = composerChangeListWriter.getChangeList();
        try {
            composerChangeListWriter.setChangeList(changeList);
            SlotReader reader = composerImpl.getReader();
            int[] iArr = composerImpl.nodeCountOverrides;
            IntMap intMap = composerImpl.providerUpdates;
            composerImpl.nodeCountOverrides = null;
            composerImpl.providerUpdates = null;
            try {
                composerImpl.setReader$runtime_release(slotReader);
                ComposerChangeListWriter composerChangeListWriter2 = composerImpl.changeListWriter;
                boolean implicitRootStart = composerChangeListWriter2.getImplicitRootStart();
                try {
                    composerChangeListWriter2.setImplicitRootStart(false);
                    composerImpl.invokeMovableContentLambda(movableContentStateReference.getContent$runtime_release(), movableContentStateReference.getLocals(), movableContentStateReference.getParameter(), true);
                    composerChangeListWriter2.setImplicitRootStart(implicitRootStart);
                    Unit unit = Unit.INSTANCE;
                    composerImpl.setReader$runtime_release(reader);
                    composerImpl.nodeCountOverrides = iArr;
                    composerImpl.providerUpdates = intMap;
                    composerChangeListWriter.setChangeList(changeList2);
                } catch (Throwable th) {
                    composerChangeListWriter2.setImplicitRootStart(implicitRootStart);
                    throw th;
                }
            } catch (Throwable th2) {
                composerImpl.setReader$runtime_release(reader);
                composerImpl.nodeCountOverrides = iArr;
                composerImpl.providerUpdates = intMap;
                throw th2;
            }
        } catch (Throwable th3) {
            composerChangeListWriter.setChangeList(changeList2);
            throw th3;
        }
    }
}
