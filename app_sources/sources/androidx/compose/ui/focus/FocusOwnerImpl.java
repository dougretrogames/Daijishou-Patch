package androidx.compose.ui.focus;

import android.view.KeyEvent;
import androidx.collection.MutableLongSet;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* INFO: compiled from: FocusOwnerImpl.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0016J\u001a\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020%H\u0016ø\u0001\u0000¢\u0006\u0004\b&\u0010'J\u001a\u0010(\u001a\u00020!2\u0006\u0010$\u001a\u00020%H\u0016ø\u0001\u0000¢\u0006\u0004\b)\u0010'J\u0010\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020,H\u0016J\n\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u001a\u0010/\u001a\u00020!2\u0006\u00100\u001a\u000201H\u0016ø\u0001\u0000¢\u0006\u0004\b2\u00103J\b\u00104\u001a\u00020\u0005H\u0016J\u0010\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u000207H\u0016J\u0010\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u000208H\u0016J\u0010\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u001aH\u0016J\b\u00109\u001a\u00020\u0005H\u0016J\u001a\u0010:\u001a\u00020!2\u0006\u0010$\u001a\u00020%H\u0002ø\u0001\u0000¢\u0006\u0004\b;\u0010'J\u001a\u0010<\u001a\u00020!2\u0006\u00100\u001a\u000201H\u0002ø\u0001\u0000¢\u0006\u0004\b=\u00103J\u000e\u0010>\u001a\u0004\u0018\u00010?*\u00020@H\u0002JY\u0010A\u001a\u00020\u0005\"\n\b\u0000\u0010B\u0018\u0001*\u00020@*\u00020@2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002HB0D2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u0002HB\u0012\u0004\u0012\u00020\u00050\u00032\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u0002HB\u0012\u0004\u0012\u00020\u00050\u0003H\u0082\bø\u0001\u0000¢\u0006\u0004\bG\u0010HR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006I"}, d2 = {"Landroidx/compose/ui/focus/FocusOwnerImpl;", "Landroidx/compose/ui/focus/FocusOwner;", "onRequestApplyChangesListener", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function1;)V", "focusInvalidationManager", "Landroidx/compose/ui/focus/FocusInvalidationManager;", "focusTransactionManager", "Landroidx/compose/ui/focus/FocusTransactionManager;", "getFocusTransactionManager", "()Landroidx/compose/ui/focus/FocusTransactionManager;", "keysCurrentlyDown", "Landroidx/collection/MutableLongSet;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "rootFocusNode", "Landroidx/compose/ui/focus/FocusTargetNode;", "getRootFocusNode$ui_release", "()Landroidx/compose/ui/focus/FocusTargetNode;", "setRootFocusNode$ui_release", "(Landroidx/compose/ui/focus/FocusTargetNode;)V", "clearFocus", "force", "", "refreshFocusEvents", "dispatchInterceptedSoftKeyboardEvent", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "dispatchInterceptedSoftKeyboardEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "dispatchKeyEvent", "dispatchKeyEvent-ZmokQxo", "dispatchRotaryEvent", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "getFocusRect", "Landroidx/compose/ui/geometry/Rect;", "moveFocus", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "moveFocus-3ESFkO8", "(I)Z", "releaseFocus", "scheduleInvalidation", "node", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "takeFocus", "validateKeyEvent", "validateKeyEvent-ZmokQxo", "wrapAroundFocus", "wrapAroundFocus-3ESFkO8", "lastLocalKeyInputNode", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DelegatableNode;", "traverseAncestors", ExifInterface.GPS_DIRECTION_TRUE, "type", "Landroidx/compose/ui/node/NodeKind;", "onPreVisit", "onVisit", "traverseAncestors-Y-YKmho", "(Landroidx/compose/ui/node/DelegatableNode;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FocusOwnerImpl implements FocusOwner {
    public static final int $stable = 8;
    private final FocusInvalidationManager focusInvalidationManager;
    private MutableLongSet keysCurrentlyDown;
    public LayoutDirection layoutDirection;
    private FocusTargetNode rootFocusNode = new FocusTargetNode();
    private final FocusTransactionManager focusTransactionManager = new FocusTransactionManager();
    private final Modifier modifier = new FocusOwnerImpl$modifier$1(this);

    /* INFO: compiled from: FocusOwnerImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CustomDestinationResult.values().length];
            try {
                iArr[CustomDestinationResult.Redirected.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CustomDestinationResult.Cancelled.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CustomDestinationResult.RedirectCancelled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CustomDestinationResult.None.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FocusStateImpl.values().length];
            try {
                iArr2[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[FocusStateImpl.ActiveParent.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[FocusStateImpl.Captured.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public FocusOwnerImpl(Function1<? super Function0<Unit>, Unit> function1) {
        this.focusInvalidationManager = new FocusInvalidationManager(function1);
    }

    /* INFO: renamed from: getRootFocusNode$ui_release, reason: from getter */
    public final FocusTargetNode getRootFocusNode() {
        return this.rootFocusNode;
    }

    public final void setRootFocusNode$ui_release(FocusTargetNode focusTargetNode) {
        this.rootFocusNode = focusTargetNode;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public FocusTransactionManager getFocusTransactionManager() {
        return this.focusTransactionManager;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public Modifier getModifier() {
        return this.modifier;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public LayoutDirection getLayoutDirection() {
        LayoutDirection layoutDirection = this.layoutDirection;
        if (layoutDirection != null) {
            return layoutDirection;
        }
        Intrinsics.throwUninitializedPropertyAccessException("layoutDirection");
        return null;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void setLayoutDirection(LayoutDirection layoutDirection) {
        this.layoutDirection = layoutDirection;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void takeFocus() {
        if (this.rootFocusNode.getFocusState() == FocusStateImpl.Inactive) {
            this.rootFocusNode.setFocusState(FocusStateImpl.Active);
        }
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void releaseFocus() {
        FocusTransactionsKt.clearFocus(this.rootFocusNode, true, true);
    }

    @Override // androidx.compose.ui.focus.FocusManager
    public void clearFocus(boolean force) {
        clearFocus(force, true);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void clearFocus(boolean force, boolean refreshFocusEvents) {
        FocusStateImpl focusStateImpl;
        FocusTransactionManager focusTransactionManager = getFocusTransactionManager();
        try {
            if (focusTransactionManager.ongoingTransaction) {
                focusTransactionManager.cancelTransaction();
            }
            focusTransactionManager.beginTransaction();
            if (!force) {
                int i = WhenMappings.$EnumSwitchMapping$0[FocusTransactionsKt.m237performCustomClearFocusMxy_nc0(this.rootFocusNode, FocusDirection.INSTANCE.m217getExitdhqQ8s()).ordinal()];
                if (i == 1 || i == 2 || i == 3) {
                    focusTransactionManager.commitTransaction();
                    return;
                }
            }
            FocusStateImpl focusState = this.rootFocusNode.getFocusState();
            if (FocusTransactionsKt.clearFocus(this.rootFocusNode, force, refreshFocusEvents)) {
                FocusTargetNode focusTargetNode = this.rootFocusNode;
                int i2 = WhenMappings.$EnumSwitchMapping$1[focusState.ordinal()];
                if (i2 == 1 || i2 == 2 || i2 == 3) {
                    focusStateImpl = FocusStateImpl.Active;
                } else {
                    if (i2 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    focusStateImpl = FocusStateImpl.Inactive;
                }
                focusTargetNode.setFocusState(focusStateImpl);
            }
            Unit unit = Unit.INSTANCE;
            focusTransactionManager.commitTransaction();
        } catch (Throwable th) {
            focusTransactionManager.commitTransaction();
            throw th;
        }
    }

    @Override // androidx.compose.ui.focus.FocusManager
    /* INFO: renamed from: moveFocus-3ESFkO8 */
    public boolean mo223moveFocus3ESFkO8(int focusDirection) {
        FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (focusTargetNodeFindActiveFocusNode == null) {
            return false;
        }
        FocusRequester focusRequesterM241customFocusSearchOMvw8 = FocusTraversalKt.m241customFocusSearchOMvw8(focusTargetNodeFindActiveFocusNode, focusDirection, getLayoutDirection());
        if (focusRequesterM241customFocusSearchOMvw8 != FocusRequester.INSTANCE.getDefault()) {
            return focusRequesterM241customFocusSearchOMvw8 != FocusRequester.INSTANCE.getCancel() && focusRequesterM241customFocusSearchOMvw8.focus$ui_release();
        }
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        return !booleanRef.element && (FocusTraversalKt.m242focusSearchsMXa3k8(this.rootFocusNode, focusDirection, getLayoutDirection(), new FocusOwnerImpl$moveFocus$foundNextItem$1(focusTargetNodeFindActiveFocusNode, this, focusDirection, booleanRef)) || m228wrapAroundFocus3ESFkO8(focusDirection));
    }

    /* WARN: Multi-variable type inference failed */
    /* WARN: Type inference failed for: r11v16 */
    /* WARN: Type inference failed for: r2v10 */
    /* WARN: Type inference failed for: r2v11, types: [androidx.compose.ui.Modifier$Node] */
    /* WARN: Type inference failed for: r2v12, types: [java.lang.Object] */
    /* WARN: Type inference failed for: r2v13 */
    /* WARN: Type inference failed for: r2v14 */
    /* WARN: Type inference failed for: r2v15 */
    /* WARN: Type inference failed for: r2v16 */
    /* WARN: Type inference failed for: r2v20 */
    /* WARN: Type inference failed for: r2v21 */
    /* WARN: Type inference failed for: r2v3, types: [androidx.compose.ui.Modifier$Node] */
    /* WARN: Type inference failed for: r2v4, types: [androidx.compose.ui.Modifier$Node] */
    /* WARN: Type inference failed for: r3v19 */
    /* WARN: Type inference failed for: r3v20, types: [androidx.compose.ui.Modifier$Node] */
    /* WARN: Type inference failed for: r3v21, types: [java.lang.Object] */
    /* WARN: Type inference failed for: r3v22 */
    /* WARN: Type inference failed for: r3v23 */
    /* WARN: Type inference failed for: r3v24 */
    /* WARN: Type inference failed for: r3v25 */
    /* WARN: Type inference failed for: r3v39 */
    /* WARN: Type inference failed for: r3v4, types: [androidx.compose.ui.Modifier$Node] */
    /* WARN: Type inference failed for: r3v40 */
    /* WARN: Type inference failed for: r3v5, types: [androidx.compose.ui.Modifier$Node] */
    /* WARN: Type inference failed for: r4v11 */
    /* WARN: Type inference failed for: r9v28 */
    /* WARN: Type inference failed for: r9v29 */
    /* WARN: Type inference failed for: r9v37 */
    /* WARN: Type inference failed for: r9v38, types: [androidx.compose.ui.Modifier$Node] */
    /* WARN: Type inference failed for: r9v39 */
    /* WARN: Type inference failed for: r9v40, types: [androidx.compose.ui.Modifier$Node] */
    /* WARN: Type inference failed for: r9v41, types: [java.lang.Object] */
    /* WARN: Type inference failed for: r9v42 */
    /* WARN: Type inference failed for: r9v43 */
    /* WARN: Type inference failed for: r9v44 */
    /* WARN: Type inference failed for: r9v45 */
    /* WARN: Type inference failed for: r9v46 */
    /* WARN: Type inference failed for: r9v47 */
    /* WARN: Type inference failed for: r9v8 */
    /* ERROR: NullPointerException in pass: PrepareForCodeGen
        java.lang.NullPointerException
        */
    @Override // androidx.compose.ui.focus.FocusOwner
    /* INFO: renamed from: dispatchKeyEvent-ZmokQxo */
    public boolean mo225dispatchKeyEventZmokQxo(android.view.KeyEvent r15) {
        /*
            Method dump skipped, instruction units count: 639
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl.mo225dispatchKeyEventZmokQxo(android.view.KeyEvent):boolean");
    }

    /* WARN: Multi-variable type inference failed */
    /* WARN: Type inference failed for: r11v16 */
    /* WARN: Type inference failed for: r1v13 */
    /* WARN: Type inference failed for: r1v14, types: [androidx.compose.ui.Modifier$Node] */
    /* WARN: Type inference failed for: r1v15, types: [java.lang.Object] */
    /* WARN: Type inference failed for: r1v16 */
    /* WARN: Type inference failed for: r1v17 */
    /* WARN: Type inference failed for: r1v18 */
    /* WARN: Type inference failed for: r1v19 */
    /* WARN: Type inference failed for: r1v22 */
    /* WARN: Type inference failed for: r1v23, types: [androidx.compose.ui.Modifier$Node] */
    /* WARN: Type inference failed for: r1v24, types: [java.lang.Object] */
    /* WARN: Type inference failed for: r1v25 */
    /* WARN: Type inference failed for: r1v26 */
    /* WARN: Type inference failed for: r1v27 */
    /* WARN: Type inference failed for: r1v28 */
    /* WARN: Type inference failed for: r1v4, types: [androidx.compose.ui.Modifier$Node] */
    /* WARN: Type inference failed for: r1v42 */
    /* WARN: Type inference failed for: r1v43 */
    /* WARN: Type inference failed for: r1v44 */
    /* WARN: Type inference failed for: r1v45 */
    /* WARN: Type inference failed for: r1v5, types: [androidx.compose.ui.Modifier$Node] */
    /* WARN: Type inference failed for: r1v6, types: [androidx.compose.ui.Modifier$Node] */
    /* WARN: Type inference failed for: r1v7, types: [androidx.compose.ui.Modifier$Node] */
    /* WARN: Type inference failed for: r8v13 */
    /* WARN: Type inference failed for: r8v4 */
    /* WARN: Type inference failed for: r9v16 */
    /* WARN: Type inference failed for: r9v17, types: [androidx.compose.ui.Modifier$Node] */
    /* WARN: Type inference failed for: r9v18 */
    /* WARN: Type inference failed for: r9v19, types: [androidx.compose.ui.Modifier$Node] */
    /* WARN: Type inference failed for: r9v20, types: [java.lang.Object] */
    /* WARN: Type inference failed for: r9v21 */
    /* WARN: Type inference failed for: r9v22 */
    /* WARN: Type inference failed for: r9v23 */
    /* WARN: Type inference failed for: r9v24 */
    /* WARN: Type inference failed for: r9v25 */
    /* WARN: Type inference failed for: r9v26 */
    /* WARN: Type inference failed for: r9v7 */
    /* WARN: Type inference failed for: r9v8 */
    /* ERROR: NullPointerException in pass: PrepareForCodeGen
        java.lang.NullPointerException
        */
    @Override // androidx.compose.ui.focus.FocusOwner
    /* INFO: renamed from: dispatchInterceptedSoftKeyboardEvent-ZmokQxo */
    public boolean mo224dispatchInterceptedSoftKeyboardEventZmokQxo(android.view.KeyEvent r15) {
        /*
            Method dump skipped, instruction units count: 607
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl.mo224dispatchInterceptedSoftKeyboardEventZmokQxo(android.view.KeyEvent):boolean");
    }

    /* WARN: Multi-variable type inference failed */
    /* WARN: Type inference failed for: r11v16 */
    /* WARN: Type inference failed for: r1v13 */
    /* WARN: Type inference failed for: r1v14, types: [androidx.compose.ui.Modifier$Node] */
    /* WARN: Type inference failed for: r1v15, types: [java.lang.Object] */
    /* WARN: Type inference failed for: r1v16 */
    /* WARN: Type inference failed for: r1v17 */
    /* WARN: Type inference failed for: r1v18 */
    /* WARN: Type inference failed for: r1v19 */
    /* WARN: Type inference failed for: r1v22 */
    /* WARN: Type inference failed for: r1v23, types: [androidx.compose.ui.Modifier$Node] */
    /* WARN: Type inference failed for: r1v24, types: [java.lang.Object] */
    /* WARN: Type inference failed for: r1v25 */
    /* WARN: Type inference failed for: r1v26 */
    /* WARN: Type inference failed for: r1v27 */
    /* WARN: Type inference failed for: r1v28 */
    /* WARN: Type inference failed for: r1v4, types: [androidx.compose.ui.Modifier$Node] */
    /* WARN: Type inference failed for: r1v42 */
    /* WARN: Type inference failed for: r1v43 */
    /* WARN: Type inference failed for: r1v44 */
    /* WARN: Type inference failed for: r1v45 */
    /* WARN: Type inference failed for: r1v5, types: [androidx.compose.ui.Modifier$Node] */
    /* WARN: Type inference failed for: r1v6, types: [androidx.compose.ui.Modifier$Node] */
    /* WARN: Type inference failed for: r1v7, types: [androidx.compose.ui.Modifier$Node] */
    /* WARN: Type inference failed for: r8v13 */
    /* WARN: Type inference failed for: r8v4 */
    /* WARN: Type inference failed for: r9v16 */
    /* WARN: Type inference failed for: r9v17, types: [androidx.compose.ui.Modifier$Node] */
    /* WARN: Type inference failed for: r9v18 */
    /* WARN: Type inference failed for: r9v19, types: [androidx.compose.ui.Modifier$Node] */
    /* WARN: Type inference failed for: r9v20, types: [java.lang.Object] */
    /* WARN: Type inference failed for: r9v21 */
    /* WARN: Type inference failed for: r9v22 */
    /* WARN: Type inference failed for: r9v23 */
    /* WARN: Type inference failed for: r9v24 */
    /* WARN: Type inference failed for: r9v25 */
    /* WARN: Type inference failed for: r9v26 */
    /* WARN: Type inference failed for: r9v7 */
    /* WARN: Type inference failed for: r9v8 */
    /* ERROR: NullPointerException in pass: PrepareForCodeGen
        java.lang.NullPointerException
        */
    @Override // androidx.compose.ui.focus.FocusOwner
    public boolean dispatchRotaryEvent(androidx.compose.ui.input.rotary.RotaryScrollEvent r15) {
        /*
            Method dump skipped, instruction units count: 607
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl.dispatchRotaryEvent(androidx.compose.ui.input.rotary.RotaryScrollEvent):boolean");
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(FocusTargetNode node) {
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(FocusEventModifierNode node) {
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(FocusPropertiesModifierNode node) {
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public Rect getFocusRect() {
        FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (focusTargetNodeFindActiveFocusNode != null) {
            return FocusTraversalKt.focusRect(focusTargetNodeFindActiveFocusNode);
        }
        return null;
    }

    /* INFO: renamed from: wrapAroundFocus-3ESFkO8, reason: not valid java name */
    private final boolean m228wrapAroundFocus3ESFkO8(int focusDirection) {
        if (this.rootFocusNode.getFocusState().getHasFocus() && !this.rootFocusNode.getFocusState().isFocused()) {
            if (FocusDirection.m209equalsimpl0(focusDirection, FocusDirection.INSTANCE.m219getNextdhqQ8s()) ? true : FocusDirection.m209equalsimpl0(focusDirection, FocusDirection.INSTANCE.m220getPreviousdhqQ8s())) {
                clearFocus(false);
                if (this.rootFocusNode.getFocusState().isFocused()) {
                    return mo223moveFocus3ESFkO8(focusDirection);
                }
                return false;
            }
        }
        return false;
    }

    /* INFO: renamed from: validateKeyEvent-ZmokQxo, reason: not valid java name */
    private final boolean m227validateKeyEventZmokQxo(KeyEvent keyEvent) {
        long jM1540getKeyZmokQxo = KeyEvent_androidKt.m1540getKeyZmokQxo(keyEvent);
        int iM1541getTypeZmokQxo = KeyEvent_androidKt.m1541getTypeZmokQxo(keyEvent);
        if (KeyEventType.m1533equalsimpl0(iM1541getTypeZmokQxo, KeyEventType.INSTANCE.m1537getKeyDownCS__XNY())) {
            MutableLongSet mutableLongSet = this.keysCurrentlyDown;
            if (mutableLongSet == null) {
                mutableLongSet = new MutableLongSet(3);
                this.keysCurrentlyDown = mutableLongSet;
            }
            mutableLongSet.plusAssign(jM1540getKeyZmokQxo);
        } else if (KeyEventType.m1533equalsimpl0(iM1541getTypeZmokQxo, KeyEventType.INSTANCE.m1538getKeyUpCS__XNY())) {
            MutableLongSet mutableLongSet2 = this.keysCurrentlyDown;
            if (mutableLongSet2 == null || !mutableLongSet2.contains(jM1540getKeyZmokQxo)) {
                return false;
            }
            MutableLongSet mutableLongSet3 = this.keysCurrentlyDown;
            if (mutableLongSet3 != null) {
                mutableLongSet3.remove(jM1540getKeyZmokQxo);
            }
        }
        return true;
    }

    /* INFO: renamed from: traverseAncestors-Y-YKmho, reason: not valid java name */
    private final /* synthetic */ <T extends DelegatableNode> void m226traverseAncestorsYYKmho(DelegatableNode delegatableNode, int i, Function1<? super T, Unit> function1, Function1<? super T, Unit> function2) {
        int i2;
        int size;
        NodeChain nodes;
        if (!delegatableNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        Modifier.Node parent = delegatableNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        ArrayList arrayList = null;
        while (true) {
            if (layoutNodeRequireLayoutNode == null) {
                break;
            }
            if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & i) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & i) != 0) {
                        Modifier.Node nodePop = parent;
                        MutableVector mutableVector = null;
                        while (nodePop != null) {
                            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                            if (nodePop instanceof Object) {
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.add(nodePop);
                            } else if ((nodePop.getKindSet() & i) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i3 = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & i) != 0) {
                                        i3++;
                                        if (i3 == 1) {
                                            nodePop = delegate;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(nodePop);
                                                }
                                                nodePop = null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate);
                                            }
                                        }
                                    }
                                }
                                if (i3 == 1) {
                                }
                            }
                            nodePop = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    parent = parent.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
            parent = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        if (arrayList != null && (size = arrayList.size() - 1) >= 0) {
            while (true) {
                int i4 = size - 1;
                function1.invoke((Object) arrayList.get(size));
                if (i4 < 0) {
                    break;
                } else {
                    size = i4;
                }
            }
        }
        Modifier.Node node = delegatableNode.getNode();
        MutableVector mutableVector2 = null;
        while (node != null) {
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (node instanceof Object) {
                function1.invoke(node);
            } else if ((node.getKindSet() & i) != 0 && (node instanceof DelegatingNode)) {
                int i5 = 0;
                for (Modifier.Node delegate2 = ((DelegatingNode) node).getDelegate(); delegate2 != null; delegate2 = delegate2.getChild()) {
                    if ((delegate2.getKindSet() & i) != 0) {
                        i5++;
                        if (i5 == 1) {
                            node = delegate2;
                        } else {
                            if (mutableVector2 == null) {
                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (node != null) {
                                if (mutableVector2 != null) {
                                    mutableVector2.add(node);
                                }
                                node = null;
                            }
                            if (mutableVector2 != null) {
                                mutableVector2.add(delegate2);
                            }
                        }
                    }
                }
                if (i5 == 1) {
                }
            }
            node = DelegatableNodeKt.pop(mutableVector2);
        }
        Modifier.Node node2 = delegatableNode.getNode();
        MutableVector mutableVector3 = null;
        while (node2 != null) {
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (node2 instanceof Object) {
                function2.invoke(node2);
            } else if ((node2.getKindSet() & i) != 0 && (node2 instanceof DelegatingNode)) {
                int i6 = 0;
                for (Modifier.Node delegate3 = ((DelegatingNode) node2).getDelegate(); delegate3 != null; delegate3 = delegate3.getChild()) {
                    if ((delegate3.getKindSet() & i) != 0) {
                        i6++;
                        if (i6 == 1) {
                            node2 = delegate3;
                        } else {
                            if (mutableVector3 == null) {
                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (node2 != null) {
                                if (mutableVector3 != null) {
                                    mutableVector3.add(node2);
                                }
                                node2 = null;
                            }
                            if (mutableVector3 != null) {
                                mutableVector3.add(delegate3);
                            }
                        }
                    }
                }
                if (i6 == 1) {
                }
            }
            node2 = DelegatableNodeKt.pop(mutableVector3);
        }
        if (arrayList != null) {
            int size2 = arrayList.size();
            for (i2 = 0; i2 < size2; i2++) {
                function2.invoke((Object) arrayList.get(i2));
            }
        }
    }

    private final Modifier.Node lastLocalKeyInputNode(DelegatableNode delegatableNode) {
        int iM2034constructorimpl = NodeKind.m2034constructorimpl(1024) | NodeKind.m2034constructorimpl(8192);
        if (!delegatableNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitLocalDescendants called on an unattached node".toString());
        }
        Modifier.Node node = delegatableNode.getNode();
        Modifier.Node node2 = null;
        if ((node.getAggregateChildKindSet() & iM2034constructorimpl) != 0) {
            for (Modifier.Node child = node.getChild(); child != null; child = child.getChild()) {
                if ((child.getKindSet() & iM2034constructorimpl) != 0) {
                    if ((NodeKind.m2034constructorimpl(1024) & child.getKindSet()) != 0) {
                        return node2;
                    }
                    node2 = child;
                }
            }
        }
        return node2;
    }
}
