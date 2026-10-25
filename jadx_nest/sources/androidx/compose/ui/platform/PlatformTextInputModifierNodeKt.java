package androidx.compose.ui.platform;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.Owner;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: PlatformTextInputModifierNode.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\u0007\u001a\u00020\b*\u00020\t2'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000b¢\u0006\u0002\b\u000fH\u0086@¢\u0006\u0002\u0010\u0010\"$\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"LocalPlatformTextInputMethodOverride", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/platform/PlatformTextInputSessionHandler;", "getLocalPlatformTextInputMethodOverride$annotations", "()V", "getLocalPlatformTextInputMethodOverride", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "establishTextInputSession", "", "Landroidx/compose/ui/platform/PlatformTextInputModifierNode;", "block", "Lkotlin/Function2;", "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/platform/PlatformTextInputModifierNode;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PlatformTextInputModifierNodeKt {
    private static final ProvidableCompositionLocal<PlatformTextInputSessionHandler> LocalPlatformTextInputMethodOverride = CompositionLocalKt.staticCompositionLocalOf(PlatformTextInputModifierNodeKt$LocalPlatformTextInputMethodOverride$1.INSTANCE);

    /* JADX INFO: renamed from: androidx.compose.ui.platform.PlatformTextInputModifierNodeKt$establishTextInputSession$1, reason: invalid class name */
    /* JADX INFO: compiled from: PlatformTextInputModifierNode.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.ui.platform.PlatformTextInputModifierNodeKt", f = "PlatformTextInputModifierNode.kt", i = {}, l = {101}, m = "establishTextInputSession", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlatformTextInputModifierNodeKt.establishTextInputSession(null, null, this);
        }
    }

    public static /* synthetic */ void getLocalPlatformTextInputMethodOverride$annotations() {
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final Object establishTextInputSession(PlatformTextInputModifierNode platformTextInputModifierNode, Function2<? super PlatformTextInputSessionScope, ? super Continuation<?>, ? extends Object> function2, Continuation<?> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!platformTextInputModifierNode.getNode().getIsAttached()) {
                throw new IllegalArgumentException("establishTextInputSession called from an unattached node".toString());
            }
            PlatformTextInputModifierNode platformTextInputModifierNode2 = platformTextInputModifierNode;
            Owner ownerRequireOwner = (PlatformTextInputSessionHandler) DelegatableNodeKt.requireLayoutNode(platformTextInputModifierNode2).getCompositionLocalMap().get(LocalPlatformTextInputMethodOverride);
            if (ownerRequireOwner == null) {
                ownerRequireOwner = DelegatableNodeKt.requireOwner(platformTextInputModifierNode2);
            }
            anonymousClass1.label = 1;
            if (ownerRequireOwner.textInputSession(function2, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }

    public static final ProvidableCompositionLocal<PlatformTextInputSessionHandler> getLocalPlatformTextInputMethodOverride() {
        return LocalPlatformTextInputMethodOverride;
    }
}
