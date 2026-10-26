package androidx.compose.runtime;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMap;
import androidx.compose.runtime.changelist.ChangeList;
import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.snapshots.ReaderKind;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.tooling.CompositionObserver;
import androidx.compose.runtime.tooling.CompositionObserverHandle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* INFO: compiled from: Composition.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002£\u0001B%\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\b\u0010X\u001a\u00020\u0019H\u0002J\u001e\u0010Y\u001a\u00020\u00192\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020*0)2\u0006\u0010[\u001a\u00020\u0012H\u0002J\b\u0010\\\u001a\u00020\u0019H\u0016J\u0010\u0010]\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010^\u001a\u00020\u0019H\u0016J\b\u0010_\u001a\u00020\u0019H\u0016J\b\u0010`\u001a\u00020\u0019H\u0002J \u0010a\u001a\u00020\u00192\u0011\u0010b\u001a\r\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0002\b\u001aH\u0016¢\u0006\u0002\u0010\u001eJ \u0010c\u001a\u00020\u00192\u0011\u0010b\u001a\r\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0002\b\u001aH\u0002¢\u0006\u0002\u0010\u001eJ\b\u0010d\u001a\u00020\u0019H\u0016J3\u0010e\u001a\u0002Hf\"\u0004\b\u0000\u0010f2\b\u0010g\u001a\u0004\u0018\u00010\u00012\u0006\u0010h\u001a\u0002072\f\u0010i\u001a\b\u0012\u0004\u0012\u0002Hf0\u0018H\u0016¢\u0006\u0002\u0010jJ\b\u0010k\u001a\u00020\u0019H\u0016J\u0010\u0010l\u001a\u00020\u00192\u0006\u0010m\u001a\u00020nH\u0016J\b\u0010o\u001a\u00020\u0019H\u0002J\b\u0010p\u001a\u00020\u0019H\u0002J#\u0010q\u001a\u0004\u0018\u0001Hr\"\u0004\b\u0000\u0010r2\f\u0010s\u001a\b\u0012\u0004\u0012\u0002Hr0tH\u0016¢\u0006\u0002\u0010uJ\"\u0010v\u001a\u0002Hr\"\u0004\b\u0000\u0010r2\f\u0010i\u001a\b\u0012\u0004\u0012\u0002Hr0\u0018H\u0082\b¢\u0006\u0002\u0010wJK\u0010x\u001a\u0002Hr\"\u0004\b\u0000\u0010r25\u0010i\u001a1\u0012'\u0012%\u0012\u0004\u0012\u00020$\u0012\f\u0012\n\u0012\u0004\u0012\u00020*\u0018\u00010:09¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u0002Hr0yH\u0082\b¢\u0006\u0002\u0010|J&\u0010}\u001a\u00020\u00192\u001c\u0010~\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0005\u0012\u00030\u0080\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u0080\u00010\u007f0#H\u0016J\u001e\u0010\u0081\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u0083\u0001\u001a\u00020$2\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010*H\u0016J\t\u0010\u0085\u0001\u001a\u00020\u0019H\u0016J(\u0010\u0086\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u0083\u0001\u001a\u00020$2\b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010*H\u0002J\u000f\u0010\u0089\u0001\u001a\u00020\u00192\u0006\u0010s\u001a\u000207J\u0012\u0010\u008a\u0001\u001a\u00020\u00192\u0007\u0010\u008b\u0001\u001a\u00020*H\u0002J\u001a\u0010\u008c\u0001\u001a\u00030\u008d\u00012\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0000¢\u0006\u0003\b\u0090\u0001J\f\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u0001H\u0002J\u0017\u0010\u0091\u0001\u001a\u00020\u00122\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020*0)H\u0016J\u0017\u0010\u0092\u0001\u001a\u00020\u00192\f\u0010i\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\t\u0010\u0093\u0001\u001a\u00020\u0012H\u0016J\u0012\u0010\u0094\u0001\u001a\u00020\u00192\u0007\u0010\u0083\u0001\u001a\u00020$H\u0016J\u0017\u0010\u0095\u0001\u001a\u00020\u00192\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020*0)H\u0016J\u0012\u0010\u0096\u0001\u001a\u00020\u00192\u0007\u0010\u008b\u0001\u001a\u00020*H\u0016J\u0012\u0010\u0097\u0001\u001a\u00020\u00192\u0007\u0010\u008b\u0001\u001a\u00020*H\u0016J\u001b\u0010\u0098\u0001\u001a\u00020\u00192\n\u0010m\u001a\u0006\u0012\u0002\b\u00030/H\u0000¢\u0006\u0003\b\u0099\u0001J!\u0010\u009a\u0001\u001a\u00020\u00192\u0007\u0010\u0084\u0001\u001a\u00020*2\u0007\u0010\u0083\u0001\u001a\u00020$H\u0000¢\u0006\u0003\b\u009b\u0001J!\u0010\u009c\u0001\u001a\u00020\u00192\u0011\u0010b\u001a\r\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0002\b\u001aH\u0016¢\u0006\u0002\u0010\u001eJ!\u0010\u009d\u0001\u001a\u00020\u00192\u0011\u0010b\u001a\r\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0002\b\u001aH\u0016¢\u0006\u0002\u0010\u001eJ\u001d\u0010\u009e\u0001\u001a\u0016\u0012\u0004\u0012\u00020$\u0012\f\u0012\n\u0012\u0004\u0012\u00020*\u0018\u00010:09H\u0002J#\u0010\u009f\u0001\u001a\u0002Hr\"\u0004\b\u0000\u0010r2\f\u0010i\u001a\b\u0012\u0004\u0012\u0002Hr0\u0018H\u0082\b¢\u0006\u0002\u0010wJ\u001d\u0010 \u0001\u001a\u00020\u00122\u0007\u0010\u0083\u0001\u001a\u00020$2\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010*H\u0002J\u0011\u0010¡\u0001\u001a\u00020\u00192\u0006\u0010S\u001a\u00020TH\u0002J\t\u0010¢\u0001\u001a\u00020\u0019H\u0016JE\u0010Y\u001a\u0016\u0012\u0004\u0012\u00020$\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020$\u0018\u0001`\u0010*\u0016\u0012\u0004\u0012\u00020$\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020$\u0018\u0001`\u00102\u0007\u0010\u008b\u0001\u001a\u00020*2\u0006\u0010[\u001a\u00020\u0012H\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0002\b\u001aX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001e\u0010'\u001a\u0012\u0012\u0004\u0012\u00020$0\u000ej\b\u0012\u0004\u0012\u00020$`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0018\u0010-\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030/0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0014R\u0014\u00103\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u0014R\u0010\u00105\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u00108\u001a\u0016\u0012\u0004\u0012\u00020$\u0012\f\u0012\n\u0012\u0004\u0012\u00020*\u0018\u00010:09X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010;\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010\u0014R\u0014\u0010<\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\u0014R\u0011\u0010=\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0014R\u000e\u0010>\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020$0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010A\u001a\b\u0012\u0004\u0012\u00020$0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020*0)8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\bC\u0010,R\u0014\u0010D\u001a\u00020EX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010H\u001a\u00020\u0012X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bI\u0010J\u001a\u0004\bK\u0010\u0014\"\u0004\bL\u0010MR\"\u0010N\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010*0Oj\n\u0012\u0006\u0012\u0004\u0018\u00010*`PX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u001a\u0010S\u001a\u00020TX\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bU\u0010J\u001a\u0004\bV\u0010W¨\u0006¤\u0001"}, d2 = {"Landroidx/compose/runtime/CompositionImpl;", "Landroidx/compose/runtime/ControlledComposition;", "Landroidx/compose/runtime/ReusableComposition;", "Landroidx/compose/runtime/RecomposeScopeOwner;", "Landroidx/compose/runtime/CompositionServices;", "parent", "Landroidx/compose/runtime/CompositionContext;", "applier", "Landroidx/compose/runtime/Applier;", "recomposeContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/Applier;Lkotlin/coroutines/CoroutineContext;)V", "_recomposeContext", "abandonSet", "Ljava/util/HashSet;", "Landroidx/compose/runtime/RememberObserver;", "Lkotlin/collections/HashSet;", "areChildrenComposing", "", "getAreChildrenComposing", "()Z", "changes", "Landroidx/compose/runtime/changelist/ChangeList;", "composable", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "getComposable", "()Lkotlin/jvm/functions/Function2;", "setComposable", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "composer", "Landroidx/compose/runtime/ComposerImpl;", "conditionalScopes", "", "Landroidx/compose/runtime/RecomposeScopeImpl;", "getConditionalScopes$runtime_release", "()Ljava/util/List;", "conditionallyInvalidatedScopes", "derivedStateDependencies", "", "", "getDerivedStateDependencies$runtime_release", "()Ljava/util/Set;", "derivedStates", "Landroidx/compose/runtime/collection/ScopeMap;", "Landroidx/compose/runtime/DerivedState;", "disposed", "hasInvalidations", "getHasInvalidations", "hasPendingChanges", "getHasPendingChanges", "invalidationDelegate", "invalidationDelegateGroup", "", "invalidations", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "Landroidx/compose/runtime/collection/IdentityArraySet;", "isComposing", "isDisposed", "isRoot", "lateChanges", "lock", "observations", "observationsProcessed", "observedObjects", "getObservedObjects$runtime_release", "observerHolder", "Landroidx/compose/runtime/CompositionObserverHolder;", "getObserverHolder$runtime_release", "()Landroidx/compose/runtime/CompositionObserverHolder;", "pendingInvalidScopes", "getPendingInvalidScopes$runtime_release$annotations", "()V", "getPendingInvalidScopes$runtime_release", "setPendingInvalidScopes$runtime_release", "(Z)V", "pendingModifications", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/AtomicReference;", "getRecomposeContext", "()Lkotlin/coroutines/CoroutineContext;", "slotTable", "Landroidx/compose/runtime/SlotTable;", "getSlotTable$runtime_release$annotations", "getSlotTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "abandonChanges", "addPendingInvalidationsLocked", "values", "forgetConditionalScopes", "applyChanges", "applyChangesInLocked", "applyLateChanges", "changesApplied", "cleanUpDerivedStateObservations", "composeContent", "content", "composeInitial", "deactivate", "delegateInvalidations", "R", TypedValues.TransitionType.S_TO, "groupIndex", "block", "(Landroidx/compose/runtime/ControlledComposition;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "dispose", "disposeUnusedMovableContent", "state", "Landroidx/compose/runtime/MovableContentState;", "drainPendingModificationsForCompositionLocked", "drainPendingModificationsLocked", "getCompositionService", ExifInterface.GPS_DIRECTION_TRUE, "key", "Landroidx/compose/runtime/CompositionServiceKey;", "(Landroidx/compose/runtime/CompositionServiceKey;)Ljava/lang/Object;", "guardChanges", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "guardInvalidationsLocked", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "insertMovableContent", "references", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "invalidate", "Landroidx/compose/runtime/InvalidationResult;", "scope", "instance", "invalidateAll", "invalidateChecked", "anchor", "Landroidx/compose/runtime/Anchor;", "invalidateGroupsWithKey", "invalidateScopeOfLocked", "value", "observe", "Landroidx/compose/runtime/tooling/CompositionObserverHandle;", "observer", "Landroidx/compose/runtime/tooling/CompositionObserver;", "observe$runtime_release", "observesAnyOf", "prepareCompose", "recompose", "recomposeScopeReleased", "recordModificationsOf", "recordReadOf", "recordWriteOf", "removeDerivedStateObservation", "removeDerivedStateObservation$runtime_release", "removeObservation", "removeObservation$runtime_release", "setContent", "setContentWithReuse", "takeInvalidations", "trackAbandonedValues", "tryImminentInvalidation", "validateRecomposeScopeAnchors", "verifyConsistent", "RememberEventDispatcher", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CompositionImpl implements ControlledComposition, ReusableComposition, RecomposeScopeOwner, CompositionServices {
    public static final int $stable = 8;
    private final CoroutineContext _recomposeContext;
    private final HashSet<RememberObserver> abandonSet;
    private final Applier<?> applier;
    private final ChangeList changes;
    private Function2<? super Composer, ? super Integer, Unit> composable;
    private final ComposerImpl composer;
    private final HashSet<RecomposeScopeImpl> conditionallyInvalidatedScopes;
    private final ScopeMap<DerivedState<?>> derivedStates;
    private boolean disposed;
    private CompositionImpl invalidationDelegate;
    private int invalidationDelegateGroup;
    private IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> invalidations;
    private final boolean isRoot;
    private final ChangeList lateChanges;
    private final Object lock;
    private final ScopeMap<RecomposeScopeImpl> observations;
    private final ScopeMap<RecomposeScopeImpl> observationsProcessed;
    private final CompositionObserverHolder observerHolder;
    private final CompositionContext parent;
    private boolean pendingInvalidScopes;
    private final AtomicReference<Object> pendingModifications;
    private final SlotTable slotTable;

    public static /* synthetic */ void getPendingInvalidScopes$runtime_release$annotations() {
    }

    public static /* synthetic */ void getSlotTable$runtime_release$annotations() {
    }

    public CompositionImpl(CompositionContext compositionContext, Applier<?> applier, CoroutineContext coroutineContext) {
        this.parent = compositionContext;
        this.applier = applier;
        this.pendingModifications = new AtomicReference<>(null);
        this.lock = new Object();
        HashSet<RememberObserver> hashSet = new HashSet<>();
        this.abandonSet = hashSet;
        SlotTable slotTable = new SlotTable();
        this.slotTable = slotTable;
        this.observations = new ScopeMap<>();
        this.conditionallyInvalidatedScopes = new HashSet<>();
        this.derivedStates = new ScopeMap<>();
        ChangeList changeList = new ChangeList();
        this.changes = changeList;
        ChangeList changeList2 = new ChangeList();
        this.lateChanges = changeList2;
        this.observationsProcessed = new ScopeMap<>();
        this.invalidations = new IdentityArrayMap<>(0, 1, null);
        this.observerHolder = new CompositionObserverHolder(null, false, 3, null);
        ComposerImpl composerImpl = new ComposerImpl(applier, compositionContext, slotTable, hashSet, changeList, changeList2, this);
        compositionContext.registerComposer$runtime_release(composerImpl);
        this.composer = composerImpl;
        this._recomposeContext = coroutineContext;
        this.isRoot = compositionContext instanceof Recomposer;
        this.composable = ComposableSingletons$CompositionKt.INSTANCE.m35getLambda1$runtime_release();
    }

    public /* synthetic */ CompositionImpl(CompositionContext compositionContext, Applier applier, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(compositionContext, applier, (i & 4) != 0 ? null : coroutineContext);
    }

    /* INFO: renamed from: getSlotTable$runtime_release, reason: from getter */
    public final SlotTable getSlotTable() {
        return this.slotTable;
    }

    public final Set<Object> getObservedObjects$runtime_release() {
        return this.observations.getMap().asMap().keySet();
    }

    public final Set<Object> getDerivedStateDependencies$runtime_release() {
        return this.derivedStates.getMap().asMap().keySet();
    }

    public final List<RecomposeScopeImpl> getConditionalScopes$runtime_release() {
        return CollectionsKt.toList(this.conditionallyInvalidatedScopes);
    }

    /* INFO: renamed from: getPendingInvalidScopes$runtime_release, reason: from getter */
    public final boolean getPendingInvalidScopes() {
        return this.pendingInvalidScopes;
    }

    public final void setPendingInvalidScopes$runtime_release(boolean z) {
        this.pendingInvalidScopes = z;
    }

    /* INFO: renamed from: getObserverHolder$runtime_release, reason: from getter */
    public final CompositionObserverHolder getObserverHolder() {
        return this.observerHolder;
    }

    public final CoroutineContext getRecomposeContext() {
        CoroutineContext coroutineContext = this._recomposeContext;
        return coroutineContext == null ? this.parent.getRecomposeCoroutineContext$runtime_release() : coroutineContext;
    }

    /* INFO: renamed from: isRoot, reason: from getter */
    public final boolean getIsRoot() {
        return this.isRoot;
    }

    private final boolean getAreChildrenComposing() {
        return this.composer.getAreChildrenComposing$runtime_release();
    }

    public final Function2<Composer, Integer, Unit> getComposable() {
        return this.composable;
    }

    public final void setComposable(Function2<? super Composer, ? super Integer, Unit> function2) {
        this.composable = function2;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean isComposing() {
        return this.composer.getIsComposing();
    }

    @Override // androidx.compose.runtime.Composition
    /* INFO: renamed from: isDisposed, reason: from getter */
    public boolean getDisposed() {
        return this.disposed;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean getHasPendingChanges() {
        boolean hasPendingChanges$runtime_release;
        synchronized (this.lock) {
            hasPendingChanges$runtime_release = this.composer.getHasPendingChanges$runtime_release();
        }
        return hasPendingChanges$runtime_release;
    }

    @Override // androidx.compose.runtime.Composition
    public void setContent(Function2<? super Composer, ? super Integer, Unit> content) {
        composeInitial(content);
    }

    @Override // androidx.compose.runtime.ReusableComposition
    public void setContentWithReuse(Function2<? super Composer, ? super Integer, Unit> content) {
        this.composer.startReuseFromRoot();
        composeInitial(content);
        this.composer.endReuseFromRoot();
    }

    private final void composeInitial(Function2<? super Composer, ? super Integer, Unit> content) {
        if (this.disposed) {
            throw new IllegalStateException("The composition is disposed".toString());
        }
        this.composable = content;
        this.parent.composeInitial$runtime_release(this, content);
    }

    public final CompositionObserverHandle observe$runtime_release(CompositionObserver observer) {
        synchronized (this.lock) {
            this.observerHolder.setObserver(observer);
            this.observerHolder.setRoot(true);
            Unit unit = Unit.INSTANCE;
        }
        return new CompositionImpl$observe$2(this, observer);
    }

    public final void invalidateGroupsWithKey(int key) {
        List<RecomposeScopeImpl> listInvalidateGroupsWithKey$runtime_release;
        synchronized (this.lock) {
            listInvalidateGroupsWithKey$runtime_release = this.slotTable.invalidateGroupsWithKey$runtime_release(key);
        }
        if (listInvalidateGroupsWithKey$runtime_release != null) {
            int size = listInvalidateGroupsWithKey$runtime_release.size();
            for (int i = 0; i < size; i++) {
                if (listInvalidateGroupsWithKey$runtime_release.get(i).invalidateForResult(null) != InvalidationResult.IGNORED) {
                }
            }
            return;
        }
        if (this.composer.forceRecomposeScopes$runtime_release()) {
            this.parent.invalidate$runtime_release(this);
        }
    }

    private final void drainPendingModificationsForCompositionLocked() {
        Object andSet = this.pendingModifications.getAndSet(CompositionKt.PendingApplyNoModifications);
        if (andSet != null) {
            if (Intrinsics.areEqual(andSet, CompositionKt.PendingApplyNoModifications)) {
                ComposerKt.composeRuntimeError("pending composition has not been applied");
                throw new KotlinNothingValueException();
            }
            if (andSet instanceof Set) {
                addPendingInvalidationsLocked((Set) andSet, true);
                return;
            }
            if (!(andSet instanceof Object[])) {
                ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
                throw new KotlinNothingValueException();
            }
            for (Set<? extends Object> set : (Set[]) andSet) {
                addPendingInvalidationsLocked(set, true);
            }
        }
    }

    private final void drainPendingModificationsLocked() {
        Object andSet = this.pendingModifications.getAndSet(null);
        if (Intrinsics.areEqual(andSet, CompositionKt.PendingApplyNoModifications)) {
            return;
        }
        if (andSet instanceof Set) {
            addPendingInvalidationsLocked((Set) andSet, false);
            return;
        }
        if (!(andSet instanceof Object[])) {
            if (andSet == null) {
                ComposerKt.composeRuntimeError("calling recordModificationsOf and applyChanges concurrently is not supported");
                throw new KotlinNothingValueException();
            }
            ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
            throw new KotlinNothingValueException();
        }
        for (Set<? extends Object> set : (Set[]) andSet) {
            addPendingInvalidationsLocked(set, false);
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void composeContent(Function2<? super Composer, ? super Integer, Unit> content) throws Exception {
        try {
            synchronized (this.lock) {
                drainPendingModificationsForCompositionLocked();
                IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> identityArrayMapTakeInvalidations = takeInvalidations();
                try {
                    CompositionObserver compositionObserverObserver = observer();
                    if (compositionObserverObserver != null) {
                        Map<RecomposeScopeImpl, IdentityArraySet<Object>> mapAsMap = identityArrayMapTakeInvalidations.asMap();
                        Intrinsics.checkNotNull(mapAsMap, "null cannot be cast to non-null type kotlin.collections.Map<androidx.compose.runtime.RecomposeScope, kotlin.collections.Set<kotlin.Any>?>");
                        compositionObserverObserver.onBeginComposition(this, mapAsMap);
                    }
                    this.composer.composeContent$runtime_release(identityArrayMapTakeInvalidations, content);
                    if (compositionObserverObserver != null) {
                        compositionObserverObserver.onEndComposition(this);
                        Unit unit = Unit.INSTANCE;
                    }
                } catch (Exception e) {
                    this.invalidations = identityArrayMapTakeInvalidations;
                    throw e;
                }
            }
        } catch (Throwable th) {
            try {
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                throw th;
            } catch (Exception e2) {
                abandonChanges();
                throw e2;
            }
        }
    }

    @Override // androidx.compose.runtime.Composition
    public void dispose() {
        synchronized (this.lock) {
            if (this.composer.getIsComposing()) {
                throw new IllegalStateException("Composition is disposed while composing. If dispose is triggered by a call in @Composable function, consider wrapping it with SideEffect block.".toString());
            }
            if (!this.disposed) {
                boolean z = true;
                this.disposed = true;
                this.composable = ComposableSingletons$CompositionKt.INSTANCE.m36getLambda2$runtime_release();
                ChangeList deferredChanges = this.composer.getDeferredChanges();
                if (deferredChanges != null) {
                    applyChangesInLocked(deferredChanges);
                }
                if (this.slotTable.getGroupsSize() <= 0) {
                    z = false;
                }
                if (z || !this.abandonSet.isEmpty()) {
                    RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
                    if (z) {
                        this.applier.onBeginChanges();
                        SlotWriter slotWriterOpenWriter = this.slotTable.openWriter();
                        try {
                            ComposerKt.removeCurrentGroup(slotWriterOpenWriter, rememberEventDispatcher);
                            Unit unit = Unit.INSTANCE;
                            slotWriterOpenWriter.close();
                            this.applier.clear();
                            this.applier.onEndChanges();
                            rememberEventDispatcher.dispatchRememberObservers();
                        } catch (Throwable th) {
                            slotWriterOpenWriter.close();
                            throw th;
                        }
                    }
                    rememberEventDispatcher.dispatchAbandons();
                }
                this.composer.dispose$runtime_release();
            }
            Unit unit2 = Unit.INSTANCE;
        }
        this.parent.unregisterComposition$runtime_release(this);
    }

    @Override // androidx.compose.runtime.Composition
    public boolean getHasInvalidations() {
        boolean z;
        synchronized (this.lock) {
            z = this.invalidations.getSize() > 0;
        }
        return z;
    }

    /* WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.ControlledComposition
    public void recordModificationsOf(Set<? extends Object> values) {
        Object obj;
        Object objPlus;
        do {
            obj = this.pendingModifications.get();
            if (obj == null ? true : Intrinsics.areEqual(obj, CompositionKt.PendingApplyNoModifications)) {
                objPlus = values;
            } else if (obj instanceof Set) {
                objPlus = new Set[]{obj, values};
            } else {
                if (!(obj instanceof Object[])) {
                    throw new IllegalStateException(("corrupt pendingModifications: " + this.pendingModifications).toString());
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.collections.Set<kotlin.Any>>");
                objPlus = ArraysKt.plus((Set<? extends Object>[]) obj, values);
            }
        } while (!CompositionImpl$$ExternalSyntheticBackportWithForwarding0.m(this.pendingModifications, obj, objPlus));
        if (obj == null) {
            synchronized (this.lock) {
                drainPendingModificationsLocked();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean observesAnyOf(Set<? extends Object> values) {
        if (values instanceof IdentityArraySet) {
            IdentityArraySet identityArraySet = (IdentityArraySet) values;
            Object[] values2 = identityArraySet.getValues();
            int size = identityArraySet.size();
            for (int i = 0; i < size; i++) {
                Object obj = values2[i];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                if (this.observations.contains(obj) || this.derivedStates.contains(obj)) {
                    return true;
                }
            }
            return false;
        }
        for (Object obj2 : values) {
            if (this.observations.contains(obj2) || this.derivedStates.contains(obj2)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void prepareCompose(Function0<Unit> block) {
        this.composer.prepareCompose$runtime_release(block);
    }

    private final HashSet<RecomposeScopeImpl> addPendingInvalidationsLocked(HashSet<RecomposeScopeImpl> hashSet, Object obj, boolean z) {
        Object obj2 = this.observations.getMap().get(obj);
        if (obj2 != null) {
            if (obj2 instanceof MutableScatterSet) {
                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                Object[] objArr = mutableScatterSet.elements;
                long[] jArr = mutableScatterSet.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    HashSet<RecomposeScopeImpl> hashSet2 = hashSet;
                    int i = 0;
                    while (true) {
                        long j = jArr[i];
                        if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i2 = 8 - ((~(i - length)) >>> 31);
                            for (int i3 = 0; i3 < i2; i3++) {
                                if ((255 & j) < 128) {
                                    RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr[(i << 3) + i3];
                                    if (!this.observationsProcessed.remove(obj, recomposeScopeImpl) && recomposeScopeImpl.invalidateForResult(obj) != InvalidationResult.IGNORED) {
                                        if (recomposeScopeImpl.isConditional() && !z) {
                                            this.conditionallyInvalidatedScopes.add(recomposeScopeImpl);
                                        } else {
                                            if (hashSet2 == null) {
                                                hashSet2 = new HashSet<>();
                                            }
                                            hashSet2.add(recomposeScopeImpl);
                                        }
                                    }
                                }
                                j >>= 8;
                            }
                            if (i2 != 8) {
                                return hashSet2;
                            }
                        }
                        if (i == length) {
                            return hashSet2;
                        }
                        i++;
                    }
                }
            } else {
                RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj2;
                if (!this.observationsProcessed.remove(obj, recomposeScopeImpl2) && recomposeScopeImpl2.invalidateForResult(obj) != InvalidationResult.IGNORED) {
                    if (recomposeScopeImpl2.isConditional() && !z) {
                        this.conditionallyInvalidatedScopes.add(recomposeScopeImpl2);
                        return hashSet;
                    }
                    HashSet<RecomposeScopeImpl> hashSet3 = hashSet == null ? new HashSet<>() : hashSet;
                    hashSet3.add(recomposeScopeImpl2);
                    return hashSet3;
                }
            }
        }
        return hashSet;
    }

    private final void cleanUpDerivedStateObservations() {
        long[] jArr;
        long[] jArr2;
        long j;
        char c;
        long j2;
        int i;
        boolean zIsEmpty;
        long[] jArr3;
        int i2;
        long j3;
        MutableScatterSet mutableScatterSet;
        MutableScatterMap<Object, Object> map = this.derivedStates.getMap();
        long[] jArr4 = map.metadata;
        int length = jArr4.length - 2;
        if (length >= 0) {
            int i3 = 0;
            while (true) {
                long j4 = jArr4[i3];
                char c2 = 7;
                long j5 = -9187201950435737472L;
                if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i4 = 8;
                    int i5 = 8 - ((~(i3 - length)) >>> 31);
                    int i6 = 0;
                    while (i6 < i5) {
                        if ((j4 & 255) < 128) {
                            int i7 = (i3 << 3) + i6;
                            c = c2;
                            Object obj = map.keys[i7];
                            Object obj2 = map.values[i7];
                            j2 = j5;
                            if (obj2 instanceof MutableScatterSet) {
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<T of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$1>");
                                MutableScatterSet mutableScatterSet2 = (MutableScatterSet) obj2;
                                Object[] objArr = mutableScatterSet2.elements;
                                long[] jArr5 = mutableScatterSet2.metadata;
                                int length2 = jArr5.length - 2;
                                if (length2 >= 0) {
                                    int i8 = i4;
                                    int i9 = 0;
                                    while (true) {
                                        MutableScatterSet mutableScatterSet3 = mutableScatterSet2;
                                        long j6 = jArr5[i9];
                                        j = j4;
                                        if ((((~j6) << c) & j6 & j2) != j2) {
                                            int i10 = 8 - ((~(i9 - length2)) >>> 31);
                                            int i11 = 0;
                                            while (i11 < i10) {
                                                if ((j6 & 255) < 128) {
                                                    jArr3 = jArr4;
                                                    int i12 = (i9 << 3) + i11;
                                                    i2 = i11;
                                                    j3 = j6;
                                                    mutableScatterSet = mutableScatterSet3;
                                                    if (!this.observations.contains((DerivedState) objArr[i12])) {
                                                        mutableScatterSet.removeElementAt(i12);
                                                    }
                                                } else {
                                                    jArr3 = jArr4;
                                                    i2 = i11;
                                                    j3 = j6;
                                                    mutableScatterSet = mutableScatterSet3;
                                                }
                                                i11 = i2 + 1;
                                                mutableScatterSet3 = mutableScatterSet;
                                                jArr4 = jArr3;
                                                j6 = j3 >> i8;
                                            }
                                            jArr2 = jArr4;
                                            mutableScatterSet2 = mutableScatterSet3;
                                            if (i10 != i8) {
                                                break;
                                            }
                                        } else {
                                            jArr2 = jArr4;
                                            mutableScatterSet2 = mutableScatterSet3;
                                        }
                                        if (i9 == length2) {
                                            break;
                                        }
                                        i9++;
                                        j4 = j;
                                        jArr4 = jArr2;
                                        i8 = 8;
                                    }
                                } else {
                                    jArr2 = jArr4;
                                    j = j4;
                                }
                                zIsEmpty = mutableScatterSet2.isEmpty();
                            } else {
                                jArr2 = jArr4;
                                j = j4;
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$1");
                                zIsEmpty = !this.observations.contains((DerivedState) obj2);
                            }
                            if (zIsEmpty) {
                                map.removeValueAt(i7);
                            }
                            i = 8;
                        } else {
                            jArr2 = jArr4;
                            j = j4;
                            c = c2;
                            j2 = j5;
                            i = i4;
                        }
                        j4 = j >> i;
                        i6++;
                        i4 = i;
                        c2 = c;
                        j5 = j2;
                        jArr4 = jArr2;
                    }
                    jArr = jArr4;
                    if (i5 != i4) {
                        break;
                    }
                } else {
                    jArr = jArr4;
                }
                if (i3 == length) {
                    break;
                }
                i3++;
                jArr4 = jArr;
            }
        }
        if (this.conditionallyInvalidatedScopes.isEmpty()) {
            return;
        }
        Iterator<RecomposeScopeImpl> it = this.conditionallyInvalidatedScopes.iterator();
        while (it.hasNext()) {
            if (!it.next().isConditional()) {
                it.remove();
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition, androidx.compose.runtime.RecomposeScopeOwner
    public void recordReadOf(Object value) {
        RecomposeScopeImpl currentRecomposeScope$runtime_release;
        if (getAreChildrenComposing() || (currentRecomposeScope$runtime_release = this.composer.getCurrentRecomposeScope$runtime_release()) == null) {
            return;
        }
        currentRecomposeScope$runtime_release.setUsed(true);
        if (currentRecomposeScope$runtime_release.recordRead(value)) {
            return;
        }
        if (value instanceof StateObjectImpl) {
            ReaderKind.Companion companion = ReaderKind.INSTANCE;
            ((StateObjectImpl) value).m164recordReadInh_f27i8$runtime_release(ReaderKind.m152constructorimpl(1));
        }
        this.observations.add(value, currentRecomposeScope$runtime_release);
        if (!(value instanceof DerivedState)) {
            return;
        }
        this.derivedStates.removeScope(value);
        ObjectIntMap<StateObject> dependencies = ((DerivedState) value).getCurrentRecord().getDependencies();
        Object[] objArr = dependencies.keys;
        long[] jArr = dependencies.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        StateObject stateObject = (StateObject) objArr[(i << 3) + i3];
                        if (stateObject instanceof StateObjectImpl) {
                            ReaderKind.Companion companion2 = ReaderKind.INSTANCE;
                            ((StateObjectImpl) stateObject).m164recordReadInh_f27i8$runtime_release(ReaderKind.m152constructorimpl(1));
                        }
                        this.derivedStates.add(stateObject, value);
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    private final void invalidateScopeOfLocked(Object value) {
        Object obj = this.observations.getMap().get(value);
        if (obj == null) {
            return;
        }
        if (obj instanceof MutableScatterSet) {
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr = mutableScatterSet.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr[(i << 3) + i3];
                            if (recomposeScopeImpl.invalidateForResult(value) == InvalidationResult.IMMINENT) {
                                this.observationsProcessed.add(value, recomposeScopeImpl);
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i == length) {
                    return;
                } else {
                    i++;
                }
            }
        } else {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj;
            if (recomposeScopeImpl2.invalidateForResult(value) == InvalidationResult.IMMINENT) {
                this.observationsProcessed.add(value, recomposeScopeImpl2);
            }
        }
    }

    /* WARN: Code duplicated, block: B:20:0x005a A[DONT_INVERT] */
    /* WARN: Code duplicated, block: B:21:0x005c A[Catch: all -> 0x0068, LOOP:0: B:11:0x0025->B:21:0x005c, LOOP_END, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0012, B:8:0x0016, B:11:0x0025, B:13:0x0035, B:15:0x0041, B:17:0x004a, B:18:0x0054, B:21:0x005c, B:22:0x005f, B:23:0x0064), top: B:29:0x0003 }] */
    /* WARN: Code duplicated, block: B:32:0x0064 A[EDGE_INSN: B:32:0x0064->B:23:0x0064 BREAK  A[LOOP:0: B:11:0x0025->B:21:0x005c], SYNTHETIC] */
    @Override // androidx.compose.runtime.ControlledComposition
    public void recordWriteOf(Object value) {
        synchronized (this.lock) {
            invalidateScopeOfLocked(value);
            Object obj = this.derivedStates.getMap().get(value);
            if (obj != null) {
                if (!(obj instanceof MutableScatterSet)) {
                    invalidateScopeOfLocked((DerivedState) obj);
                } else {
                    MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
                    Object[] objArr = mutableScatterSet.elements;
                    long[] jArr = mutableScatterSet.metadata;
                    int length = jArr.length - 2;
                    if (length >= 0) {
                        int i = 0;
                        while (true) {
                            long j = jArr[i];
                            if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                                if (i != length) {
                                    break;
                                    break;
                                }
                                i++;
                            } else {
                                int i2 = 8 - ((~(i - length)) >>> 31);
                                for (int i3 = 0; i3 < i2; i3++) {
                                    if ((255 & j) < 128) {
                                        invalidateScopeOfLocked((DerivedState) objArr[(i << 3) + i3]);
                                    }
                                    j >>= 8;
                                }
                                if (i2 != 8) {
                                    break;
                                } else if (i != length) {
                                    break;
                                } else {
                                    i++;
                                }
                            }
                        }
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean recompose() {
        boolean zRecompose$runtime_release;
        synchronized (this.lock) {
            drainPendingModificationsForCompositionLocked();
            try {
                IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> identityArrayMapTakeInvalidations = takeInvalidations();
                try {
                    CompositionObserver compositionObserverObserver = observer();
                    if (compositionObserverObserver != null) {
                        Map<RecomposeScopeImpl, IdentityArraySet<Object>> mapAsMap = identityArrayMapTakeInvalidations.asMap();
                        Intrinsics.checkNotNull(mapAsMap, "null cannot be cast to non-null type kotlin.collections.Map<androidx.compose.runtime.RecomposeScope, kotlin.collections.Set<kotlin.Any>?>");
                        compositionObserverObserver.onBeginComposition(this, mapAsMap);
                    }
                    zRecompose$runtime_release = this.composer.recompose$runtime_release(identityArrayMapTakeInvalidations);
                    if (!zRecompose$runtime_release) {
                        drainPendingModificationsLocked();
                    }
                    if (compositionObserverObserver != null) {
                        compositionObserverObserver.onEndComposition(this);
                    }
                } catch (Exception e) {
                    this.invalidations = identityArrayMapTakeInvalidations;
                    throw e;
                }
            } catch (Throwable th) {
                try {
                    if (!this.abandonSet.isEmpty()) {
                        new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                    }
                    throw th;
                } catch (Exception e2) {
                    abandonChanges();
                    throw e2;
                }
            }
        }
        return zRecompose$runtime_release;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void disposeUnusedMovableContent(MovableContentState state) {
        RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
        SlotWriter slotWriterOpenWriter = state.getSlotTable().openWriter();
        try {
            ComposerKt.removeCurrentGroup(slotWriterOpenWriter, rememberEventDispatcher);
            Unit unit = Unit.INSTANCE;
            slotWriterOpenWriter.close();
            rememberEventDispatcher.dispatchRememberObservers();
        } catch (Throwable th) {
            slotWriterOpenWriter.close();
            throw th;
        }
    }

    private final void applyChangesInLocked(ChangeList changes) throws Throwable {
        RememberEventDispatcher rememberEventDispatcher;
        long[] jArr;
        RememberEventDispatcher rememberEventDispatcher2;
        long[] jArr2;
        long j;
        char c;
        long j2;
        int i;
        boolean zIsEmpty;
        long[] jArr3;
        RememberEventDispatcher rememberEventDispatcher3 = new RememberEventDispatcher(this.abandonSet);
        try {
            if (!changes.isEmpty()) {
                try {
                    Object objBeginSection = Trace.INSTANCE.beginSection("Compose:applyChanges");
                    try {
                        this.applier.onBeginChanges();
                        SlotWriter slotWriterOpenWriter = this.slotTable.openWriter();
                        try {
                            changes.executeAndFlushAllPendingChanges(this.applier, slotWriterOpenWriter, rememberEventDispatcher3);
                            Unit unit = Unit.INSTANCE;
                            slotWriterOpenWriter.close();
                            this.applier.onEndChanges();
                            Unit unit2 = Unit.INSTANCE;
                            Trace.INSTANCE.endSection(objBeginSection);
                            rememberEventDispatcher3.dispatchRememberObservers();
                            rememberEventDispatcher3.dispatchSideEffects();
                            if (this.pendingInvalidScopes) {
                                Object objBeginSection2 = Trace.INSTANCE.beginSection("Compose:unobserve");
                                int i2 = 0;
                                try {
                                    this.pendingInvalidScopes = false;
                                    MutableScatterMap<Object, Object> map = this.observations.getMap();
                                    long[] jArr4 = map.metadata;
                                    int length = jArr4.length - 2;
                                    if (length >= 0) {
                                        int i3 = 0;
                                        while (true) {
                                            long j3 = jArr4[i3];
                                            char c2 = 7;
                                            long j4 = -9187201950435737472L;
                                            if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                int i4 = 8;
                                                int i5 = 8 - ((~(i3 - length)) >>> 31);
                                                int i6 = i2;
                                                while (i6 < i5) {
                                                    if ((j3 & 255) < 128) {
                                                        int i7 = (i3 << 3) + i6;
                                                        c = c2;
                                                        Object obj = map.keys[i7];
                                                        Object obj2 = map.values[i7];
                                                        j2 = j4;
                                                        if (obj2 instanceof MutableScatterSet) {
                                                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<T of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$1>");
                                                            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                                            Object[] objArr = mutableScatterSet.elements;
                                                            long[] jArr5 = mutableScatterSet.metadata;
                                                            int i8 = i4;
                                                            int length2 = jArr5.length - 2;
                                                            rememberEventDispatcher2 = rememberEventDispatcher3;
                                                            if (length2 >= 0) {
                                                                j = j3;
                                                                int i9 = 0;
                                                                while (true) {
                                                                    try {
                                                                        long j5 = jArr5[i9];
                                                                        Object[] objArr2 = objArr;
                                                                        long[] jArr6 = jArr5;
                                                                        if ((((~j5) << c) & j5 & j2) != j2) {
                                                                            int i10 = 8 - ((~(i9 - length2)) >>> 31);
                                                                            int i11 = 0;
                                                                            while (i11 < i10) {
                                                                                if ((j5 & 255) < 128) {
                                                                                    jArr3 = jArr4;
                                                                                    int i12 = (i9 << 3) + i11;
                                                                                    if (!((RecomposeScopeImpl) objArr2[i12]).getValid()) {
                                                                                        mutableScatterSet.removeElementAt(i12);
                                                                                    }
                                                                                } else {
                                                                                    jArr3 = jArr4;
                                                                                }
                                                                                j5 >>= i8;
                                                                                i11++;
                                                                                jArr4 = jArr3;
                                                                            }
                                                                            jArr2 = jArr4;
                                                                            if (i10 != i8) {
                                                                                break;
                                                                            }
                                                                        } else {
                                                                            jArr2 = jArr4;
                                                                        }
                                                                        if (i9 == length2) {
                                                                            break;
                                                                        }
                                                                        i9++;
                                                                        objArr = objArr2;
                                                                        jArr5 = jArr6;
                                                                        jArr4 = jArr2;
                                                                        i8 = 8;
                                                                    } catch (Throwable th) {
                                                                        th = th;
                                                                        Trace.INSTANCE.endSection(objBeginSection2);
                                                                        throw th;
                                                                    }
                                                                }
                                                            } else {
                                                                jArr2 = jArr4;
                                                                j = j3;
                                                            }
                                                            zIsEmpty = mutableScatterSet.isEmpty();
                                                        } else {
                                                            rememberEventDispatcher2 = rememberEventDispatcher3;
                                                            jArr2 = jArr4;
                                                            j = j3;
                                                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$1");
                                                            zIsEmpty = !((RecomposeScopeImpl) obj2).getValid();
                                                        }
                                                        if (zIsEmpty) {
                                                            map.removeValueAt(i7);
                                                        }
                                                        i = 8;
                                                    } else {
                                                        rememberEventDispatcher2 = rememberEventDispatcher3;
                                                        jArr2 = jArr4;
                                                        j = j3;
                                                        c = c2;
                                                        j2 = j4;
                                                        i = i4;
                                                    }
                                                    j3 = j >> i;
                                                    i6++;
                                                    i4 = i;
                                                    c2 = c;
                                                    j4 = j2;
                                                    rememberEventDispatcher3 = rememberEventDispatcher2;
                                                    jArr4 = jArr2;
                                                }
                                                rememberEventDispatcher = rememberEventDispatcher3;
                                                jArr = jArr4;
                                                if (i5 != i4) {
                                                    break;
                                                }
                                            } else {
                                                rememberEventDispatcher = rememberEventDispatcher3;
                                                jArr = jArr4;
                                            }
                                            if (i3 == length) {
                                                break;
                                            }
                                            i3++;
                                            rememberEventDispatcher3 = rememberEventDispatcher;
                                            jArr4 = jArr;
                                            i2 = 0;
                                        }
                                    } else {
                                        rememberEventDispatcher = rememberEventDispatcher3;
                                    }
                                    cleanUpDerivedStateObservations();
                                    Unit unit3 = Unit.INSTANCE;
                                    Trace.INSTANCE.endSection(objBeginSection2);
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            } else {
                                rememberEventDispatcher = rememberEventDispatcher3;
                            }
                            if (this.lateChanges.isEmpty()) {
                                rememberEventDispatcher.dispatchAbandons();
                                return;
                            }
                            return;
                        } catch (Throwable th3) {
                            try {
                                slotWriterOpenWriter.close();
                                throw th3;
                            } catch (Throwable th4) {
                                th = th4;
                                Trace.INSTANCE.endSection(objBeginSection);
                                throw th;
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } else {
                if (this.lateChanges.isEmpty()) {
                    rememberEventDispatcher3.dispatchAbandons();
                    return;
                }
                return;
            }
        } catch (Throwable th7) {
            th = th7;
        }
        if (this.lateChanges.isEmpty()) {
            rememberEventDispatcher3.dispatchAbandons();
        }
        throw th;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyChanges() {
        synchronized (this.lock) {
            try {
                applyChangesInLocked(this.changes);
                drainPendingModificationsLocked();
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    if (!this.abandonSet.isEmpty()) {
                        new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                    }
                    throw th;
                } catch (Exception e) {
                    abandonChanges();
                    throw e;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyLateChanges() {
        synchronized (this.lock) {
            try {
                if (this.lateChanges.isNotEmpty()) {
                    applyChangesInLocked(this.lateChanges);
                }
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    if (!this.abandonSet.isEmpty()) {
                        new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                    }
                    throw th;
                } catch (Exception e) {
                    abandonChanges();
                    throw e;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void changesApplied() {
        synchronized (this.lock) {
            try {
                this.composer.changesApplied$runtime_release();
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    if (!this.abandonSet.isEmpty()) {
                        new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                    }
                    throw th;
                } catch (Exception e) {
                    abandonChanges();
                    throw e;
                }
            }
        }
    }

    private final <T> T guardInvalidationsLocked(Function1<? super IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>>, ? extends T> block) throws Exception {
        IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> identityArrayMapTakeInvalidations = takeInvalidations();
        try {
            return block.invoke(identityArrayMapTakeInvalidations);
        } catch (Exception e) {
            this.invalidations = identityArrayMapTakeInvalidations;
            throw e;
        }
    }

    private final void abandonChanges() {
        this.pendingModifications.set(null);
        this.changes.clear();
        this.lateChanges.clear();
        this.abandonSet.clear();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void invalidateAll() {
        synchronized (this.lock) {
            for (Object obj : this.slotTable.getSlots()) {
                RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
                if (recomposeScopeImpl != null) {
                    recomposeScopeImpl.invalidate();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void verifyConsistent() {
        synchronized (this.lock) {
            if (!isComposing()) {
                this.composer.verifyConsistent$runtime_release();
                this.slotTable.verifyWellFormed();
                validateRecomposeScopeAnchors(this.slotTable);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public <R> R delegateInvalidations(ControlledComposition to, int groupIndex, Function0<? extends R> block) {
        if (to != null && !Intrinsics.areEqual(to, this) && groupIndex >= 0) {
            this.invalidationDelegate = (CompositionImpl) to;
            this.invalidationDelegateGroup = groupIndex;
            try {
                return block.invoke();
            } finally {
                this.invalidationDelegate = null;
                this.invalidationDelegateGroup = 0;
            }
        }
        return block.invoke();
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public InvalidationResult invalidate(RecomposeScopeImpl scope, Object instance) {
        CompositionImpl compositionImpl;
        if (scope.getDefaultsInScope()) {
            scope.setDefaultsInvalid(true);
        }
        Anchor anchor = scope.getAnchor();
        if (anchor == null || !anchor.getValid()) {
            return InvalidationResult.IGNORED;
        }
        if (!this.slotTable.ownsAnchor(anchor)) {
            synchronized (this.lock) {
                compositionImpl = this.invalidationDelegate;
            }
            if (compositionImpl != null && compositionImpl.tryImminentInvalidation(scope, instance)) {
                return InvalidationResult.IMMINENT;
            }
            return InvalidationResult.IGNORED;
        }
        if (!scope.getCanRecompose()) {
            return InvalidationResult.IGNORED;
        }
        return invalidateChecked(scope, anchor, instance);
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public void recomposeScopeReleased(RecomposeScopeImpl scope) {
        this.pendingInvalidScopes = true;
    }

    @Override // androidx.compose.runtime.CompositionServices
    public <T> T getCompositionService(CompositionServiceKey<T> key) {
        if (Intrinsics.areEqual(key, CompositionKt.getCompositionImplServiceKey())) {
            return (T) this;
        }
        return null;
    }

    private final boolean tryImminentInvalidation(RecomposeScopeImpl scope, Object instance) {
        return isComposing() && this.composer.tryImminentInvalidation$runtime_release(scope, instance);
    }

    private final InvalidationResult invalidateChecked(RecomposeScopeImpl scope, Anchor anchor, Object instance) {
        synchronized (this.lock) {
            CompositionImpl compositionImpl = this.invalidationDelegate;
            if (compositionImpl == null || !this.slotTable.groupContainsAnchor(this.invalidationDelegateGroup, anchor)) {
                compositionImpl = null;
            }
            if (compositionImpl == null) {
                if (tryImminentInvalidation(scope, instance)) {
                    return InvalidationResult.IMMINENT;
                }
                if (instance != null) {
                    CompositionKt.addValue(this.invalidations, scope, instance);
                } else {
                    this.invalidations.set(scope, null);
                }
            }
            if (compositionImpl != null) {
                return compositionImpl.invalidateChecked(scope, anchor, instance);
            }
            this.parent.invalidate$runtime_release(this);
            return isComposing() ? InvalidationResult.DEFERRED : InvalidationResult.SCHEDULED;
        }
    }

    public final void removeObservation$runtime_release(Object instance, RecomposeScopeImpl scope) {
        this.observations.remove(instance, scope);
    }

    public final void removeDerivedStateObservation$runtime_release(DerivedState<?> state) {
        if (this.observations.contains(state)) {
            return;
        }
        this.derivedStates.removeScope(state);
    }

    private final IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> takeInvalidations() {
        IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> identityArrayMap = this.invalidations;
        this.invalidations = new IdentityArrayMap<>(0, 1, null);
        return identityArrayMap;
    }

    private final void validateRecomposeScopeAnchors(SlotTable slotTable) {
        Object[] slots = slotTable.getSlots();
        ArrayList arrayList = new ArrayList();
        for (Object obj : slots) {
            RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
            if (recomposeScopeImpl != null) {
                arrayList.add(recomposeScopeImpl);
            }
        }
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) arrayList2.get(i);
            Anchor anchor = recomposeScopeImpl2.getAnchor();
            if (anchor != null && !slotTable.slotsOf$runtime_release(anchor.toIndexFor(slotTable)).contains(recomposeScopeImpl2)) {
                throw new IllegalStateException(("Misaligned anchor " + anchor + " in scope " + recomposeScopeImpl2 + " encountered, scope found at " + ArraysKt.indexOf((RecomposeScopeImpl[]) slotTable.getSlots(), recomposeScopeImpl2)).toString());
            }
        }
    }

    private final <T> T trackAbandonedValues(Function0<? extends T> block) {
        try {
            return block.invoke();
        } catch (Throwable th) {
            if (!this.abandonSet.isEmpty()) {
                new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
            }
            throw th;
        }
    }

    private final CompositionObserver observer() {
        CompositionObserverHolder compositionObserverHolder = this.observerHolder;
        if (compositionObserverHolder.getRoot()) {
            return compositionObserverHolder.getObserver();
        }
        CompositionObserverHolder observerHolder = this.parent.getObserverHolder();
        CompositionObserver observer = observerHolder != null ? observerHolder.getObserver() : null;
        if (!Intrinsics.areEqual(observer, compositionObserverHolder.getObserver())) {
            compositionObserverHolder.setObserver(observer);
        }
        return observer;
    }

    /* INFO: compiled from: Composition.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nH\u0016J\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u000eJ\u0010\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u0016\u0010\u0014\u001a\u00020\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/runtime/CompositionImpl$RememberEventDispatcher;", "Landroidx/compose/runtime/RememberManager;", "abandoning", "", "Landroidx/compose/runtime/RememberObserver;", "(Ljava/util/Set;)V", "forgetting", "", "", "releasing", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "remembering", "sideEffects", "Lkotlin/Function0;", "", "deactivating", "instance", "dispatchAbandons", "dispatchRememberObservers", "dispatchSideEffects", "sideEffect", "effect", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class RememberEventDispatcher implements RememberManager {
        private final Set<RememberObserver> abandoning;
        private List<ComposeNodeLifecycleCallback> releasing;
        private final List<RememberObserver> remembering = new ArrayList();
        private final List<Object> forgetting = new ArrayList();
        private final List<Function0<Unit>> sideEffects = new ArrayList();

        public RememberEventDispatcher(Set<RememberObserver> set) {
            this.abandoning = set;
        }

        @Override // androidx.compose.runtime.RememberManager
        public void remembering(RememberObserver instance) {
            this.remembering.add(instance);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void forgetting(RememberObserver instance) {
            this.forgetting.add(instance);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void sideEffect(Function0<Unit> effect) {
            this.sideEffects.add(effect);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void deactivating(ComposeNodeLifecycleCallback instance) {
            this.forgetting.add(instance);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void releasing(ComposeNodeLifecycleCallback instance) {
            ArrayList arrayList = this.releasing;
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.releasing = arrayList;
            }
            arrayList.add(instance);
        }

        public final void dispatchRememberObservers() {
            if (!this.forgetting.isEmpty()) {
                Object objBeginSection = Trace.INSTANCE.beginSection("Compose:onForgotten");
                try {
                    for (int size = this.forgetting.size() - 1; -1 < size; size--) {
                        Object obj = this.forgetting.get(size);
                        TypeIntrinsics.asMutableCollection(this.abandoning).remove(obj);
                        if (obj instanceof RememberObserver) {
                            ((RememberObserver) obj).onForgotten();
                        }
                        if (obj instanceof ComposeNodeLifecycleCallback) {
                            ((ComposeNodeLifecycleCallback) obj).onDeactivate();
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    Trace.INSTANCE.endSection(objBeginSection);
                } catch (Throwable th) {
                    Trace.INSTANCE.endSection(objBeginSection);
                    throw th;
                }
            }
            if (!this.remembering.isEmpty()) {
                Object objBeginSection2 = Trace.INSTANCE.beginSection("Compose:onRemembered");
                try {
                    List<RememberObserver> list = this.remembering;
                    int size2 = list.size();
                    for (int i = 0; i < size2; i++) {
                        RememberObserver rememberObserver = list.get(i);
                        this.abandoning.remove(rememberObserver);
                        rememberObserver.onRemembered();
                    }
                    Unit unit2 = Unit.INSTANCE;
                    Trace.INSTANCE.endSection(objBeginSection2);
                } catch (Throwable th2) {
                    Trace.INSTANCE.endSection(objBeginSection2);
                    throw th2;
                }
            }
            List<ComposeNodeLifecycleCallback> list2 = this.releasing;
            List<ComposeNodeLifecycleCallback> list3 = list2;
            if (list3 == null || list3.isEmpty()) {
                return;
            }
            Object objBeginSection3 = Trace.INSTANCE.beginSection("Compose:releases");
            try {
                for (int size3 = list2.size() - 1; -1 < size3; size3--) {
                    list2.get(size3).onRelease();
                }
                Unit unit3 = Unit.INSTANCE;
            } finally {
                Trace.INSTANCE.endSection(objBeginSection3);
            }
        }

        public final void dispatchSideEffects() {
            if (this.sideEffects.isEmpty()) {
                return;
            }
            Object objBeginSection = Trace.INSTANCE.beginSection("Compose:sideeffects");
            try {
                List<Function0<Unit>> list = this.sideEffects;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    list.get(i).invoke();
                }
                this.sideEffects.clear();
                Unit unit = Unit.INSTANCE;
            } finally {
                Trace.INSTANCE.endSection(objBeginSection);
            }
        }

        public final void dispatchAbandons() {
            if (this.abandoning.isEmpty()) {
                return;
            }
            Object objBeginSection = Trace.INSTANCE.beginSection("Compose:abandons");
            try {
                Iterator<RememberObserver> it = this.abandoning.iterator();
                while (it.hasNext()) {
                    RememberObserver next = it.next();
                    it.remove();
                    next.onAbandoned();
                }
                Unit unit = Unit.INSTANCE;
            } finally {
                Trace.INSTANCE.endSection(objBeginSection);
            }
        }
    }

    @Override // androidx.compose.runtime.ReusableComposition
    public void deactivate() {
        boolean z = this.slotTable.getGroupsSize() > 0;
        if (z || !this.abandonSet.isEmpty()) {
            Object objBeginSection = Trace.INSTANCE.beginSection("Compose:deactivate");
            try {
                RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
                if (z) {
                    this.applier.onBeginChanges();
                    SlotWriter slotWriterOpenWriter = this.slotTable.openWriter();
                    try {
                        ComposerKt.deactivateCurrentGroup(slotWriterOpenWriter, rememberEventDispatcher);
                        Unit unit = Unit.INSTANCE;
                        slotWriterOpenWriter.close();
                        this.applier.onEndChanges();
                        rememberEventDispatcher.dispatchRememberObservers();
                    } catch (Throwable th) {
                        slotWriterOpenWriter.close();
                        throw th;
                    }
                }
                rememberEventDispatcher.dispatchAbandons();
                Unit unit2 = Unit.INSTANCE;
                Trace.INSTANCE.endSection(objBeginSection);
            } catch (Throwable th2) {
                Trace.INSTANCE.endSection(objBeginSection);
                throw th2;
            }
        }
        this.observations.clear();
        this.derivedStates.clear();
        this.invalidations.clear();
        this.changes.clear();
        this.composer.deactivate$runtime_release();
    }

    /* WARN: Code duplicated, block: B:103:0x0214 A[DONT_INVERT] */
    /* WARN: Code duplicated, block: B:104:0x0216 A[LOOP:5: B:77:0x01b2->B:104:0x0216, LOOP_END] */
    /* WARN: Code duplicated, block: B:117:0x024f  */
    /* WARN: Code duplicated, block: B:165:0x0334 A[DONT_INVERT] */
    /* WARN: Code duplicated, block: B:166:0x0336 A[LOOP:9: B:149:0x02e2->B:166:0x0336, LOOP_END] */
    /* WARN: Code duplicated, block: B:187:0x00b3 A[EDGE_INSN: B:187:0x00b3->B:30:0x00b3 BREAK  A[LOOP:1: B:16:0x0063->B:26:0x0095], SYNTHETIC] */
    /* WARN: Code duplicated, block: B:197:0x0223 A[EDGE_INSN: B:197:0x0223->B:106:0x0223 BREAK  A[LOOP:5: B:77:0x01b2->B:104:0x0216], SYNTHETIC] */
    /* WARN: Code duplicated, block: B:209:0x0343 A[EDGE_INSN: B:209:0x0343->B:168:0x0343 BREAK  A[LOOP:9: B:149:0x02e2->B:166:0x0336], SYNTHETIC] */
    /* WARN: Code duplicated, block: B:225:0x014a A[EDGE_INSN: B:225:0x014a->B:58:0x014a BREAK  A[LOOP:12: B:46:0x0110->B:56:0x013f], SYNTHETIC] */
    /* WARN: Code duplicated, block: B:25:0x0093 A[DONT_INVERT, PHI: r5
  0x0093: PHI (r5v34 java.util.HashSet<androidx.compose.runtime.RecomposeScopeImpl>) = 
  (r5v33 java.util.HashSet<androidx.compose.runtime.RecomposeScopeImpl>)
  (r5v35 java.util.HashSet<androidx.compose.runtime.RecomposeScopeImpl>)
 binds: [B:17:0x006d, B:24:0x0091] A[DONT_GENERATE, DONT_INLINE]] */
    /* WARN: Code duplicated, block: B:26:0x0095 A[LOOP:1: B:16:0x0063->B:26:0x0095, LOOP_END] */
    /* WARN: Code duplicated, block: B:55:0x013d A[DONT_INVERT, PHI: r5
  0x013d: PHI (r5v3 java.util.HashSet<androidx.compose.runtime.RecomposeScopeImpl>) = 
  (r5v2 java.util.HashSet<androidx.compose.runtime.RecomposeScopeImpl>)
  (r5v4 java.util.HashSet<androidx.compose.runtime.RecomposeScopeImpl>)
 binds: [B:47:0x011a, B:54:0x013b] A[DONT_GENERATE, DONT_INLINE]] */
    /* WARN: Code duplicated, block: B:56:0x013f A[LOOP:12: B:46:0x0110->B:56:0x013f, LOOP_END] */
    /* WARN: Code duplicated, block: B:96:0x0200  */
    private final void addPendingInvalidationsLocked(Set<? extends Object> values, boolean forgetConditionalScopes) {
        long j;
        long j2;
        char c;
        long j3;
        HashSet<RecomposeScopeImpl> hashSetAddPendingInvalidationsLocked;
        String str;
        long[] jArr;
        long[] jArr2;
        int i;
        long j4;
        boolean zContains;
        int i2;
        long j5;
        long[] jArr3;
        long[] jArr4;
        long j6;
        int i3;
        int i4;
        boolean z;
        boolean zIsEmpty;
        boolean z2;
        long j7;
        int i5;
        boolean z3;
        int i6 = 8;
        Object obj = null;
        if (values instanceof IdentityArraySet) {
            IdentityArraySet identityArraySet = (IdentityArraySet) values;
            Object[] values2 = identityArraySet.getValues();
            int size = identityArraySet.size();
            hashSetAddPendingInvalidationsLocked = null;
            int i7 = 0;
            while (i7 < size) {
                Object obj2 = values2[i7];
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                if (obj2 instanceof RecomposeScopeImpl) {
                    ((RecomposeScopeImpl) obj2).invalidateForResult(obj);
                } else {
                    HashSet<RecomposeScopeImpl> hashSetAddPendingInvalidationsLocked2 = addPendingInvalidationsLocked(hashSetAddPendingInvalidationsLocked, obj2, forgetConditionalScopes);
                    Object obj3 = this.derivedStates.getMap().get(obj2);
                    if (obj3 != null) {
                        if (obj3 instanceof MutableScatterSet) {
                            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj3;
                            Object[] objArr = mutableScatterSet.elements;
                            long[] jArr5 = mutableScatterSet.metadata;
                            int length = jArr5.length - 2;
                            if (length >= 0) {
                                int i8 = 0;
                                while (true) {
                                    long j8 = jArr5[i8];
                                    if ((((~j8) << 7) & j8 & (-9187201950435737472L)) == -9187201950435737472L) {
                                        if (i8 != length) {
                                            break;
                                            break;
                                        }
                                        i8++;
                                    } else {
                                        int i9 = 8 - ((~(i8 - length)) >>> 31);
                                        for (int i10 = 0; i10 < i9; i10++) {
                                            if ((j8 & 255) < 128) {
                                                hashSetAddPendingInvalidationsLocked2 = addPendingInvalidationsLocked(hashSetAddPendingInvalidationsLocked2, (DerivedState) objArr[(i8 << 3) + i10], forgetConditionalScopes);
                                            }
                                            j8 >>= 8;
                                        }
                                        if (i9 != 8) {
                                            break;
                                        } else if (i8 != length) {
                                            break;
                                        } else {
                                            i8++;
                                        }
                                    }
                                }
                            }
                            hashSetAddPendingInvalidationsLocked = hashSetAddPendingInvalidationsLocked2;
                        } else {
                            hashSetAddPendingInvalidationsLocked = addPendingInvalidationsLocked(hashSetAddPendingInvalidationsLocked2, (DerivedState) obj3, forgetConditionalScopes);
                        }
                    }
                    hashSetAddPendingInvalidationsLocked = hashSetAddPendingInvalidationsLocked2;
                }
                i7++;
                obj = null;
            }
            j = 128;
            j2 = 255;
            c = 7;
            j3 = -9187201950435737472L;
        } else {
            j = 128;
            j2 = 255;
            c = 7;
            j3 = -9187201950435737472L;
            hashSetAddPendingInvalidationsLocked = null;
            for (Object obj4 : values) {
                if (obj4 instanceof RecomposeScopeImpl) {
                    ((RecomposeScopeImpl) obj4).invalidateForResult(null);
                } else {
                    HashSet<RecomposeScopeImpl> hashSetAddPendingInvalidationsLocked3 = addPendingInvalidationsLocked(hashSetAddPendingInvalidationsLocked, obj4, forgetConditionalScopes);
                    Object obj5 = this.derivedStates.getMap().get(obj4);
                    if (obj5 != null) {
                        if (obj5 instanceof MutableScatterSet) {
                            MutableScatterSet mutableScatterSet2 = (MutableScatterSet) obj5;
                            Object[] objArr2 = mutableScatterSet2.elements;
                            long[] jArr6 = mutableScatterSet2.metadata;
                            int length2 = jArr6.length - 2;
                            if (length2 >= 0) {
                                int i11 = 0;
                                while (true) {
                                    long j9 = jArr6[i11];
                                    if ((((~j9) << 7) & j9 & (-9187201950435737472L)) == -9187201950435737472L) {
                                        if (i11 != length2) {
                                            break;
                                            break;
                                        }
                                        i11++;
                                    } else {
                                        int i12 = 8 - ((~(i11 - length2)) >>> 31);
                                        for (int i13 = 0; i13 < i12; i13++) {
                                            if ((j9 & 255) < 128) {
                                                hashSetAddPendingInvalidationsLocked3 = addPendingInvalidationsLocked(hashSetAddPendingInvalidationsLocked3, (DerivedState) objArr2[(i11 << 3) + i13], forgetConditionalScopes);
                                            }
                                            j9 >>= 8;
                                        }
                                        if (i12 != 8) {
                                            break;
                                        } else if (i11 != length2) {
                                            break;
                                        } else {
                                            i11++;
                                        }
                                    }
                                }
                            }
                        } else {
                            hashSetAddPendingInvalidationsLocked = addPendingInvalidationsLocked(hashSetAddPendingInvalidationsLocked3, (DerivedState) obj5, forgetConditionalScopes);
                        }
                    }
                    hashSetAddPendingInvalidationsLocked = hashSetAddPendingInvalidationsLocked3;
                }
            }
        }
        String str2 = "null cannot be cast to non-null type androidx.collection.MutableScatterSet<T of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$1>";
        if (!forgetConditionalScopes || this.conditionallyInvalidatedScopes.isEmpty()) {
            if (hashSetAddPendingInvalidationsLocked != null) {
                MutableScatterMap<Object, Object> map = this.observations.getMap();
                long[] jArr7 = map.metadata;
                int length3 = jArr7.length - 2;
                if (length3 >= 0) {
                    int i14 = 0;
                    while (true) {
                        long j10 = jArr7[i14];
                        if ((((~j10) << c) & j10 & j3) != j3) {
                            int i15 = 8 - ((~(i14 - length3)) >>> 31);
                            int i16 = 0;
                            while (i16 < i15) {
                                if ((j10 & j2) < j) {
                                    int i17 = (i14 << 3) + i16;
                                    Object obj6 = map.keys[i17];
                                    Object obj7 = map.values[i17];
                                    if (obj7 instanceof MutableScatterSet) {
                                        Intrinsics.checkNotNull(obj7, str2);
                                        MutableScatterSet mutableScatterSet3 = (MutableScatterSet) obj7;
                                        Object[] objArr3 = mutableScatterSet3.elements;
                                        long[] jArr8 = mutableScatterSet3.metadata;
                                        int length4 = jArr8.length - 2;
                                        if (length4 >= 0) {
                                            j4 = j10;
                                            int i18 = 0;
                                            while (true) {
                                                long j11 = jArr8[i18];
                                                jArr2 = jArr7;
                                                i = length3;
                                                if ((((~j11) << c) & j11 & j3) != j3) {
                                                    int i19 = 8 - ((~(i18 - length4)) >>> 31);
                                                    int i20 = 0;
                                                    while (i20 < i19) {
                                                        if ((j11 & j2) < j) {
                                                            i2 = i20;
                                                            int i21 = (i18 << 3) + i2;
                                                            j5 = j11;
                                                            if (hashSetAddPendingInvalidationsLocked.contains((RecomposeScopeImpl) objArr3[i21])) {
                                                                mutableScatterSet3.removeElementAt(i21);
                                                            }
                                                        } else {
                                                            i2 = i20;
                                                            j5 = j11;
                                                        }
                                                        i20 = i2 + 1;
                                                        j11 = j5 >> 8;
                                                    }
                                                    if (i19 != 8) {
                                                        break;
                                                    }
                                                    if (i18 != length4) {
                                                        break;
                                                    }
                                                    i18++;
                                                    length3 = i;
                                                    jArr7 = jArr2;
                                                } else if (i18 != length4) {
                                                    break;
                                                    break;
                                                } else {
                                                    i18++;
                                                    length3 = i;
                                                    jArr7 = jArr2;
                                                }
                                            }
                                        } else {
                                            jArr2 = jArr7;
                                            i = length3;
                                            j4 = j10;
                                        }
                                        zContains = mutableScatterSet3.isEmpty();
                                    } else {
                                        jArr2 = jArr7;
                                        i = length3;
                                        j4 = j10;
                                        Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$1");
                                        zContains = hashSetAddPendingInvalidationsLocked.contains((RecomposeScopeImpl) obj7);
                                    }
                                    if (zContains) {
                                        map.removeValueAt(i17);
                                    }
                                } else {
                                    str2 = str2;
                                    jArr2 = jArr7;
                                    i = length3;
                                    j4 = j10;
                                }
                                i16++;
                                length3 = i;
                                j10 = j4 >> 8;
                                str2 = str2;
                                jArr7 = jArr2;
                            }
                            str = str2;
                            jArr = jArr7;
                            int i22 = length3;
                            if (i15 != 8) {
                                break;
                            } else {
                                length3 = i22;
                            }
                        } else {
                            str = str2;
                            jArr = jArr7;
                        }
                        if (i14 == length3) {
                            break;
                        }
                        i14++;
                        str2 = str;
                        jArr7 = jArr;
                    }
                }
                cleanUpDerivedStateObservations();
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
                return;
            }
            return;
        }
        MutableScatterMap<Object, Object> map2 = this.observations.getMap();
        long[] jArr9 = map2.metadata;
        int length5 = jArr9.length - 2;
        if (length5 >= 0) {
            int i23 = 0;
            while (true) {
                long j12 = jArr9[i23];
                if ((((~j12) << c) & j12 & j3) != j3) {
                    int i24 = 8 - ((~(i23 - length5)) >>> 31);
                    int i25 = 0;
                    while (i25 < i24) {
                        if ((j12 & j2) < j) {
                            int i26 = (i23 << 3) + i25;
                            Object obj8 = map2.keys[i26];
                            Object obj9 = map2.values[i26];
                            int i27 = i6;
                            if (obj9 instanceof MutableScatterSet) {
                                Intrinsics.checkNotNull(obj9, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<T of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$1>");
                                MutableScatterSet mutableScatterSet4 = (MutableScatterSet) obj9;
                                Object[] objArr4 = mutableScatterSet4.elements;
                                long[] jArr10 = mutableScatterSet4.metadata;
                                jArr4 = jArr9;
                                int length6 = jArr10.length - 2;
                                if (length6 >= 0) {
                                    j6 = j12;
                                    int i28 = 0;
                                    while (true) {
                                        long j13 = jArr10[i28];
                                        Object[] objArr5 = objArr4;
                                        i3 = i25;
                                        if ((((~j13) << c) & j13 & j3) == j3) {
                                            if (i28 != length6) {
                                                break;
                                                break;
                                            }
                                            i28++;
                                            i25 = i3;
                                            objArr4 = objArr5;
                                            i27 = 8;
                                        } else {
                                            int i29 = 8 - ((~(i28 - length6)) >>> 31);
                                            int i30 = 0;
                                            while (i30 < i29) {
                                                if ((j13 & j2) < j) {
                                                    j7 = j13;
                                                    int i31 = (i28 << 3) + i30;
                                                    RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr5[i31];
                                                    i5 = i30;
                                                    if (this.conditionallyInvalidatedScopes.contains(recomposeScopeImpl)) {
                                                        z3 = true;
                                                    } else if (hashSetAddPendingInvalidationsLocked != null && hashSetAddPendingInvalidationsLocked.contains(recomposeScopeImpl)) {
                                                        z3 = true;
                                                    } else {
                                                        z3 = false;
                                                    }
                                                    if (z3) {
                                                        mutableScatterSet4.removeElementAt(i31);
                                                    }
                                                } else {
                                                    j7 = j13;
                                                    i5 = i30;
                                                }
                                                j13 = j7 >> i27;
                                                i30 = i5 + 1;
                                            }
                                            if (i29 != i27) {
                                                break;
                                            }
                                            if (i28 != length6) {
                                                break;
                                            }
                                            i28++;
                                            i25 = i3;
                                            objArr4 = objArr5;
                                            i27 = 8;
                                        }
                                    }
                                } else {
                                    j6 = j12;
                                    i3 = i25;
                                }
                                zIsEmpty = mutableScatterSet4.isEmpty();
                            } else {
                                jArr4 = jArr9;
                                j6 = j12;
                                i3 = i25;
                                Intrinsics.checkNotNull(obj9, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$1");
                                RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj9;
                                if (this.conditionallyInvalidatedScopes.contains(recomposeScopeImpl2)) {
                                    z = true;
                                } else {
                                    if (hashSetAddPendingInvalidationsLocked != null) {
                                        z = true;
                                        z2 = hashSetAddPendingInvalidationsLocked.contains(recomposeScopeImpl2);
                                        if (z2) {
                                            zIsEmpty = false;
                                        }
                                    } else {
                                        z = true;
                                    }
                                    if (z2) {
                                        zIsEmpty = false;
                                    }
                                }
                                zIsEmpty = z;
                            }
                            if (zIsEmpty) {
                                map2.removeValueAt(i26);
                            }
                            i4 = 8;
                        } else {
                            jArr4 = jArr9;
                            j6 = j12;
                            i3 = i25;
                            i4 = i6;
                        }
                        i6 = i4;
                        i25 = i3 + 1;
                        j12 = j6 >> i4;
                        jArr9 = jArr4;
                    }
                    jArr3 = jArr9;
                    if (i24 != i6) {
                        break;
                    }
                } else {
                    jArr3 = jArr9;
                }
                if (i23 == length5) {
                    break;
                }
                i23++;
                jArr9 = jArr3;
                i6 = 8;
            }
        }
        this.conditionallyInvalidatedScopes.clear();
        cleanUpDerivedStateObservations();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void insertMovableContent(List<Pair<MovableContentStateReference, MovableContentStateReference>> references) throws Exception {
        int size = references.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                z = true;
                break;
            } else if (!Intrinsics.areEqual(references.get(i).getFirst().getComposition(), this)) {
                break;
            } else {
                i++;
            }
        }
        ComposerKt.runtimeCheck(z);
        try {
            this.composer.insertMovableContentReferences(references);
            Unit unit = Unit.INSTANCE;
        } catch (Throwable th) {
            try {
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                throw th;
            } catch (Exception e) {
                abandonChanges();
                throw e;
            }
        }
    }

    private final <T> T guardChanges(Function0<? extends T> block) throws Exception {
        try {
            return block.invoke();
        } catch (Throwable th) {
            try {
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                throw th;
            } catch (Exception e) {
                abandonChanges();
                throw e;
            }
        }
    }
}
