package com.magneticchen.daijishou.ui.widget.widgets.activity;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.google.android.material.imageview.ShapeableImageView;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.db.entity.EventEntity;
import com.magneticchen.daijishou.data.db.entity.PlayableItemEntity;
import com.magneticchen.daijishou.ui.fragments.dialog.PlayableItemDetailDialogFragment;
import com.magneticchen.daijishou.ui.fragments.dialog.StaticPlayableItemCollectionDialogFragment;
import com.magneticchen.daijishou.ui.model.DaijishouLibraryModel;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetFaceFragment;
import com.magneticchen.daijishou.utils.DayChangedBroadcastReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: ActivityWidgetGridFaceFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\"\u001a\u00020\u0018H\u0016J\b\u0010#\u001a\u00020\u0018H\u0016J\b\u0010$\u001a\u00020\u0018H\u0002J\u0018\u0010%\u001a\u00020\u00182\b\b\u0002\u0010&\u001a\u00020'H\u0082@¢\u0006\u0002\u0010(J\b\u0010)\u001a\u00020\u0018H\u0002J\u000e\u0010*\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010+R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\fX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/activity/ActivityWidgetGridFaceFragment;", "Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetFaceFragment;", "()V", "activityColor", "", "dataChangedBroadcastReceiver", "Lcom/magneticchen/daijishou/utils/DayChangedBroadcastReceiver;", "eventsCount", "latestEvent", "Lcom/magneticchen/daijishou/data/db/entity/EventEntity;", "maxEventsPerDayCount", "recentEvents", "", "recentEventsBitmapList", "", "Landroid/graphics/Bitmap;", "recentEventsList", "recentEventsTintList", "Landroid/content/res/ColorStateList;", "table", "Landroid/widget/TableLayout;", "updateTableMutex", "Lkotlinx/coroutines/sync/Mutex;", "onClick", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onPreload", "registerDateChangedBroadcast", "renewAndUpdateTable", "updateTable", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unregisterDateChangedBroadcast", "updateTableBitmap", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ActivityWidgetGridFaceFragment extends WidgetFaceFragment {
    public static final int BASE_ALPHA = 180;
    public static final int EVENTS_LIMITS = 512;
    public static final int ITEM_COUNTS = 25;
    private DayChangedBroadcastReceiver dataChangedBroadcastReceiver;
    private int eventsCount;
    private EventEntity latestEvent;
    private int maxEventsPerDayCount;
    private List<EventEntity> recentEvents;
    private TableLayout table;
    public static final Companion Companion = new Companion(null);
    private static final HashMap<Long, Integer> widgetInstanceIdToDialogTitle = MapsKt.hashMapOf(TuplesKt.to(2L, Integer.valueOf(R.string.widget_face_activity_grid_playable_item_played)), TuplesKt.to(3L, Integer.valueOf(R.string.widget_face_activity_grid_playable_item_viewed)));
    private final List<List<EventEntity>> recentEventsList = new ArrayList();
    private final List<ColorStateList> recentEventsTintList = new ArrayList();
    private final List<Bitmap> recentEventsBitmapList = new ArrayList();
    private int activityColor = -1;
    private final Mutex updateTableMutex = MutexKt.Mutex$default(false, 1, (Object) null);

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetGridFaceFragment$renewAndUpdateTable$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ActivityWidgetGridFaceFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetGridFaceFragment", f = "ActivityWidgetGridFaceFragment.kt", i = {0, 0, 0, 0, 1}, l = {255, 161}, m = "renewAndUpdateTable", n = {"this", "$this$withLock_u24default$iv", "updateTable", "widgetInstanceId", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "Z$0", "J$0", "L$0"})
    static final class C01441 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C01441(Continuation<? super C01441> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ActivityWidgetGridFaceFragment.this.renewAndUpdateTable(false, this);
        }
    }

    /* JADX INFO: compiled from: ActivityWidgetGridFaceFragment.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R-\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0004`\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/activity/ActivityWidgetGridFaceFragment$Companion;", "", "()V", "BASE_ALPHA", "", "EVENTS_LIMITS", "ITEM_COUNTS", "widgetInstanceIdToDialogTitle", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getWidgetInstanceIdToDialogTitle", "()Ljava/util/HashMap;", "newInstance", "Lcom/magneticchen/daijishou/ui/widget/widgets/activity/ActivityWidgetGridFaceFragment;", "widgetInstanceId", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ActivityWidgetGridFaceFragment newInstance(long j) {
            ActivityWidgetGridFaceFragment activityWidgetGridFaceFragment = new ActivityWidgetGridFaceFragment();
            Bundle bundle = new Bundle();
            bundle.putLong("widgetInstanceId", j);
            activityWidgetGridFaceFragment.setArguments(bundle);
            return activityWidgetGridFaceFragment;
        }

        public final HashMap<Long, Integer> getWidgetInstanceIdToDialogTitle() {
            return ActivityWidgetGridFaceFragment.widgetInstanceIdToDialogTitle;
        }
    }

    private final void registerDateChangedBroadcast() {
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        DayChangedBroadcastReceiver dayChangedBroadcastReceiver = this.dataChangedBroadcastReceiver;
        if (dayChangedBroadcastReceiver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataChangedBroadcastReceiver");
            dayChangedBroadcastReceiver = null;
        }
        fragmentActivityRequireActivity.registerReceiver(dayChangedBroadcastReceiver, DayChangedBroadcastReceiver.Companion.getIntentFilter());
    }

    private final void unregisterDateChangedBroadcast() {
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        DayChangedBroadcastReceiver dayChangedBroadcastReceiver = this.dataChangedBroadcastReceiver;
        if (dayChangedBroadcastReceiver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataChangedBroadcastReceiver");
            dayChangedBroadcastReceiver = null;
        }
        fragmentActivityRequireActivity.unregisterReceiver(dayChangedBroadcastReceiver);
    }

    @Override // com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetFaceFragment
    public void onPreload() {
        super.onPreload();
        this.activityColor = ContextCompat.getColor(getApplication(), R.color.activity);
        this.latestEvent = getDaijishouLibraryRepository().getLatestEventStatically();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new C01431(null), 3, (Object) null);
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetGridFaceFragment$onPreload$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ActivityWidgetGridFaceFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetGridFaceFragment$onPreload$1", f = "ActivityWidgetGridFaceFragment.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
    static final class C01431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C01431(Continuation<? super C01431> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ActivityWidgetGridFaceFragment.this.new C01431(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C01431) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ActivityWidgetGridFaceFragment.this.renewAndUpdateTable(false, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetFaceFragment
    public void onClick() {
        Long playableItemId;
        super.onClick();
        long j = requireArguments().getLong("widgetInstanceId");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<EventEntity> list = this.recentEvents;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentEvents");
            list = null;
        }
        int i = 0;
        for (EventEntity eventEntity : list) {
            if (i <= 512 && (playableItemId = eventEntity.getPlayableItemId()) != null) {
                PlayableItemEntity playableItemByIdStatically = getDaijishouLibrary().getPlayableItemByIdStatically(playableItemId.longValue());
                if (playableItemByIdStatically != null && !arrayList2.contains(Long.valueOf(playableItemByIdStatically.getId()))) {
                    arrayList.add(playableItemByIdStatically);
                    arrayList2.add(Long.valueOf(playableItemByIdStatically.getId()));
                    i++;
                }
            }
        }
        StaticPlayableItemCollectionDialogFragment.Companion companion = StaticPlayableItemCollectionDialogFragment.Companion;
        Integer num = widgetInstanceIdToDialogTitle.get(Long.valueOf(j));
        Intrinsics.checkNotNull(num);
        final StaticPlayableItemCollectionDialogFragment staticPlayableItemCollectionDialogFragmentNewInstance$default = StaticPlayableItemCollectionDialogFragment.Companion.newInstance$default(companion, arrayList, getString(num.intValue()), false, 4, null);
        staticPlayableItemCollectionDialogFragmentNewInstance$default.setOnClickListener(new Function1<PlayableItemEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetGridFaceFragment.onClick.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PlayableItemEntity playableItemEntity) {
                invoke2(playableItemEntity);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PlayableItemEntity it) {
                Intrinsics.checkNotNullParameter(it, "it");
                staticPlayableItemCollectionDialogFragmentNewInstance$default.dismiss();
                DaijishouLibraryModel daijishouLibrary = this.getDaijishouLibrary();
                Activity activityRequireActivity = this.requireActivity();
                Intrinsics.checkNotNullExpressionValue(activityRequireActivity, "requireActivity(...)");
                DaijishouLibraryModel.play$default(daijishouLibrary, activityRequireActivity, it, null, 4, null);
            }
        }).setOnLongClickListener(new Function1<PlayableItemEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetGridFaceFragment.onClick.3
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PlayableItemEntity playableItemEntity) {
                invoke2(playableItemEntity);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PlayableItemEntity it) {
                Intrinsics.checkNotNullParameter(it, "it");
                PlayableItemDetailDialogFragment.Companion.newInstance(it).show(ActivityWidgetGridFaceFragment.this.getParentFragmentManager(), PlayableItemDetailDialogFragment.class.getName());
            }
        });
        staticPlayableItemCollectionDialogFragmentNewInstance$default.show(getParentFragmentManager(), StaticPlayableItemCollectionDialogFragment.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateTableBitmap(Continuation<? super Unit> continuation) {
        TableLayout tableLayout = this.table;
        if (tableLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("table");
            tableLayout = null;
        }
        int i = 0;
        for (View view : ViewGroupKt.getChildren(tableLayout)) {
            if (view instanceof TableRow) {
                for (ShapeableImageView shapeableImageView : ViewGroupKt.getChildren((ViewGroup) view)) {
                    if (shapeableImageView instanceof ShapeableImageView) {
                        shapeableImageView.setImageBitmap(this.recentEventsBitmapList.get(i));
                        i++;
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object renewAndUpdateTable(boolean z, Continuation<? super Unit> continuation) throws Throwable {
        C01441 c01441;
        long j;
        boolean z2;
        Mutex mutex;
        ActivityWidgetGridFaceFragment activityWidgetGridFaceFragment;
        boolean z3;
        long j2;
        Mutex mutex2;
        if (continuation instanceof C01441) {
            c01441 = (C01441) continuation;
            if ((c01441.label & Integer.MIN_VALUE) != 0) {
                c01441.label -= Integer.MIN_VALUE;
            } else {
                c01441 = new C01441(continuation);
            }
        } else {
            c01441 = new C01441(continuation);
        }
        Object obj = c01441.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c01441.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                j = requireArguments().getLong("widgetInstanceId");
                Mutex mutex3 = this.updateTableMutex;
                c01441.L$0 = this;
                c01441.L$1 = mutex3;
                z2 = z;
                c01441.Z$0 = z2;
                c01441.J$0 = j;
                c01441.label = 1;
                if (mutex3.lock((Object) null, c01441) != coroutine_suspended) {
                    mutex = mutex3;
                    activityWidgetGridFaceFragment = this;
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutex2 = (Mutex) c01441.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    Unit unit = Unit.INSTANCE;
                    mutex2.unlock((Object) null);
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    mutex2.unlock((Object) null);
                    throw th;
                }
            }
            j = c01441.J$0;
            z2 = c01441.Z$0;
            mutex = (Mutex) c01441.L$1;
            ActivityWidgetGridFaceFragment activityWidgetGridFaceFragment2 = (ActivityWidgetGridFaceFragment) c01441.L$0;
            ResultKt.throwOnFailure(obj);
            activityWidgetGridFaceFragment = activityWidgetGridFaceFragment2;
            CoroutineContext io2 = Dispatchers.getIO();
            ActivityWidgetGridFaceFragment$renewAndUpdateTable$2$1 activityWidgetGridFaceFragment$renewAndUpdateTable$2$1 = new ActivityWidgetGridFaceFragment$renewAndUpdateTable$2$1(j2, activityWidgetGridFaceFragment, z3, null);
            c01441.L$0 = mutex;
            c01441.L$1 = null;
            c01441.label = 2;
            if (BuildersKt.withContext(io2, activityWidgetGridFaceFragment$renewAndUpdateTable$2$1, c01441) != coroutine_suspended) {
                mutex2 = mutex;
                Unit unit2 = Unit.INSTANCE;
                mutex2.unlock((Object) null);
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        } catch (Throwable th2) {
            th = th2;
            mutex2 = mutex;
            mutex2.unlock((Object) null);
            throw th;
        }
        z3 = z2;
        j2 = j;
    }

    static /* synthetic */ Object renewAndUpdateTable$default(ActivityWidgetGridFaceFragment activityWidgetGridFaceFragment, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return activityWidgetGridFaceFragment.renewAndUpdateTable(z, continuation);
    }

    @Override // com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetFaceFragment, com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!this.updateTableMutex.isLocked()) {
            this.recentEvents = CollectionsKt.emptyList();
            this.latestEvent = null;
            this.recentEventsList.clear();
            this.recentEventsTintList.clear();
            this.recentEventsBitmapList.clear();
            this.maxEventsPerDayCount = 0;
            this.eventsCount = 0;
        }
        this.activityColor = ContextCompat.getColor(requireContext(), R.color.activity);
        this.dataChangedBroadcastReceiver = new DayChangedBroadcastReceiver() { // from class: com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetGridFaceFragment.onCreate.1
            @Override // com.magneticchen.daijishou.utils.DayChangedBroadcastReceiver
            public void onDayChanged() {
                BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(ActivityWidgetGridFaceFragment.this), Dispatchers.getIO(), (CoroutineStart) null, new ActivityWidgetGridFaceFragment$onCreate$1$onDayChanged$1(ActivityWidgetGridFaceFragment.this, null), 2, (Object) null);
            }
        };
        registerDateChangedBroadcast();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.widget_face_activity_grid, viewGroup, false);
        View viewFindViewById = viewInflate.findViewById(R.id.widget_face_activity_grid_table_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.table = (TableLayout) viewFindViewById;
        if (!this.recentEventsList.isEmpty()) {
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), Dispatchers.getIO(), (CoroutineStart) null, new C01411(null), 2, (Object) null);
        }
        getDaijishouLibrary().getLatestEvent().observe(getViewLifecycleOwner(), new ActivityWidgetGridFaceFragment$sam$androidx_lifecycle_Observer$0(new Function1<EventEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetGridFaceFragment.onCreateView.2
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EventEntity eventEntity) {
                invoke2(eventEntity);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(EventEntity eventEntity) {
                if (Intrinsics.areEqual(ActivityWidgetGridFaceFragment.this.latestEvent, eventEntity)) {
                    return;
                }
                ActivityWidgetGridFaceFragment.this.latestEvent = eventEntity;
                BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(ActivityWidgetGridFaceFragment.this), Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(ActivityWidgetGridFaceFragment.this, null), 2, (Object) null);
            }

            /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetGridFaceFragment$onCreateView$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: ActivityWidgetGridFaceFragment.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetGridFaceFragment$onCreateView$2$1", f = "ActivityWidgetGridFaceFragment.kt", i = {}, l = {240}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ ActivityWidgetGridFaceFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(ActivityWidgetGridFaceFragment activityWidgetGridFaceFragment, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = activityWidgetGridFaceFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        if (ActivityWidgetGridFaceFragment.renewAndUpdateTable$default(this.this$0, false, this, 1, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }
        }));
        return viewInflate;
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetGridFaceFragment$onCreateView$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ActivityWidgetGridFaceFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetGridFaceFragment$onCreateView$1", f = "ActivityWidgetGridFaceFragment.kt", i = {}, l = {235}, m = "invokeSuspend", n = {}, s = {})
    static final class C01411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C01411(Continuation<? super C01411> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ActivityWidgetGridFaceFragment.this.new C01411(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C01411) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (!ActivityWidgetGridFaceFragment.this.updateTableMutex.isLocked()) {
                    this.label = 1;
                    if (ActivityWidgetGridFaceFragment.this.updateTableBitmap(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        unregisterDateChangedBroadcast();
    }
}
