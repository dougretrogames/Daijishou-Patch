package com.magneticchen.daijishou.daijishou_widget.widgets.activity;

import android.content.IntentFilter;
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
import androidx.lifecycle.LifecycleOwnerKt;
import com.google.android.material.imageview.ShapeableImageView;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.daijishou_library_db.EventEntity;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetFaceFragment;
import com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment;
import com.magneticchen.daijishou.dialog_fragments.StaticPlayableItemCollectionDialogFragment;
import com.magneticchen.daijishou.utils.DayChangedBroadcastReceiver;
import com.magneticchen.daijishou.view_models.DaijishouLibraryModel;
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
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* INFO: compiled from: ActivityWidgetGridFaceFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\"\u001a\u00020\u0018H\u0016J\b\u0010#\u001a\u00020\u0018H\u0016J\b\u0010$\u001a\u00020\u0018H\u0002J\u0018\u0010%\u001a\u00020\u00182\b\b\u0002\u0010&\u001a\u00020'H\u0082@¢\u0006\u0002\u0010(J\b\u0010)\u001a\u00020\u0018H\u0002J\u000e\u0010*\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010+R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\fX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/activity/ActivityWidgetGridFaceFragment;", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetFaceFragment;", "()V", "activityColor", "", "dataChangedBroadcastReceiver", "Lcom/magneticchen/daijishou/utils/DayChangedBroadcastReceiver;", "eventsCount", "latestEvent", "Lcom/magneticchen/daijishou/daijishou_library_db/EventEntity;", "maxEventsPerDayCount", "recentEvents", "", "recentEventsBitmapList", "", "Landroid/graphics/Bitmap;", "recentEventsList", "recentEventsTintList", "Landroid/content/res/ColorStateList;", "table", "Landroid/widget/TableLayout;", "updateTableMutex", "Lkotlinx/coroutines/sync/Mutex;", "onClick", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onPreload", "registerDateChangedBroadcast", "renewAndUpdateTable", "updateTable", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unregisterDateChangedBroadcast", "updateTableBitmap", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ActivityWidgetGridFaceFragment extends WidgetFaceFragment {
    public static final int BASE_ALPHA = 180;
    public static final int EVENTS_LIMITS = 512;
    public static final int ITEM_COUNTS = 25;
    private static final IntentFilter timeTickIntentFilter;
    private DayChangedBroadcastReceiver dataChangedBroadcastReceiver;
    public int eventsCount;
    private EventEntity latestEvent;
    public int maxEventsPerDayCount;
    public List<EventEntity> recentEvents;
    private TableLayout table;

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HashMap<Long, Integer> widgetInstanceIdToDialogTitle = MapsKt.hashMapOf(TuplesKt.to(2L, Integer.valueOf(R.string.widget_face_activity_grid_playable_item_played)), TuplesKt.to(3L, Integer.valueOf(R.string.widget_face_activity_grid_playable_item_viewed)));
    public final List<List<EventEntity>> recentEventsList = new ArrayList();
    public final List<ColorStateList> recentEventsTintList = new ArrayList();
    public final List<Bitmap> recentEventsBitmapList = new ArrayList();
    public int activityColor = -1;
    private final Mutex updateTableMutex = MutexKt.Mutex$default(false, 1, null);

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.activity.ActivityWidgetGridFaceFragment$renewAndUpdateTable$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: ActivityWidgetGridFaceFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.daijishou_widget.widgets.activity.ActivityWidgetGridFaceFragment", f = "ActivityWidgetGridFaceFragment.kt", i = {0, 0, 0, 0, 1}, l = {262, 168}, m = "renewAndUpdateTable", n = {"this", "$this$withLock_u24default$iv", "updateTable", "widgetInstanceId", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "Z$0", "J$0", "L$0"})
    final class C02171 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C02171(Continuation<?> continuation) {
            super(continuation);
        }

        public final Object invokeSuspendImpl(Object obj)throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ActivityWidgetGridFaceFragment.this.renewAndUpdateTable(false, this);
        }
    }

    /* INFO: compiled from: ActivityWidgetGridFaceFragment.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R-\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0004`\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/activity/ActivityWidgetGridFaceFragment$Companion;", "", "()V", "BASE_ALPHA", "", "EVENTS_LIMITS", "ITEM_COUNTS", "timeTickIntentFilter", "Landroid/content/IntentFilter;", "widgetInstanceIdToDialogTitle", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getWidgetInstanceIdToDialogTitle", "()Ljava/util/HashMap;", "newInstance", "Lcom/magneticchen/daijishou/daijishou_widget/widgets/activity/ActivityWidgetGridFaceFragment;", "widgetInstanceId", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ActivityWidgetGridFaceFragment newInstance(long widgetInstanceId) {
            ActivityWidgetGridFaceFragment activityWidgetGridFaceFragment = new ActivityWidgetGridFaceFragment();
            Bundle bundle = new Bundle();
            bundle.putLong("widgetInstanceId", widgetInstanceId);
            activityWidgetGridFaceFragment.setArguments(bundle);
            return activityWidgetGridFaceFragment;
        }

        public final HashMap<Long, Integer> getWidgetInstanceIdToDialogTitle() {
            return ActivityWidgetGridFaceFragment.widgetInstanceIdToDialogTitle;
        }
    }

    static {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.TIME_TICK");
        intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        intentFilter.addAction("android.intent.action.TIME_SET");
        timeTickIntentFilter = intentFilter;
    }

    private final void registerDateChangedBroadcast() {
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        DayChangedBroadcastReceiver dayChangedBroadcastReceiver = this.dataChangedBroadcastReceiver;
        if (dayChangedBroadcastReceiver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataChangedBroadcastReceiver");
            dayChangedBroadcastReceiver = null;
        }
        fragmentActivityRequireActivity.registerReceiver(dayChangedBroadcastReceiver, DayChangedBroadcastReceiver.INSTANCE.getIntentFilter());
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

    @Override // com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetFaceFragment
    public void onPreload() {
        super.onPreload();
        this.activityColor = ContextCompat.getColor(getApplication(), R.color.activity);
        this.latestEvent = getDaijishouLibraryRepository().getLatestEventStatically();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C02161(null), 3, null);
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.activity.ActivityWidgetGridFaceFragment$onPreload$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: ActivityWidgetGridFaceFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.daijishou_widget.widgets.activity.ActivityWidgetGridFaceFragment$onPreload$1", f = "ActivityWidgetGridFaceFragment.kt", i = {}, l = {113}, m = "invokeSuspendImpl", n = {}, s = {})
    final class C02161 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        int label;

        C02161(Continuation<?> continuation) {
            super(2, continuation);
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return ActivityWidgetGridFaceFragment.this.new C02161(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    return ((C02161) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                }
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
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

    @Override // com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetFaceFragment
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
        StaticPlayableItemCollectionDialogFragment.Companion companion = StaticPlayableItemCollectionDialogFragment.INSTANCE;
        Integer num = widgetInstanceIdToDialogTitle.get(Long.valueOf(j));
        Intrinsics.checkNotNull(num);
        StaticPlayableItemCollectionDialogFragment staticPlayableItemCollectionDialogFragmentNewInstance$default = StaticPlayableItemCollectionDialogFragment.Companion.newInstance$default(companion, arrayList, getString(num.intValue()), false, 4, null);
        staticPlayableItemCollectionDialogFragmentNewInstance$default.setOnClickListener(new AnonymousClass2(staticPlayableItemCollectionDialogFragmentNewInstance$default, this)).setOnLongClickListener(new AnonymousClass3());
        staticPlayableItemCollectionDialogFragmentNewInstance$default.show(getParentFragmentManager(), StaticPlayableItemCollectionDialogFragment.class.getName());
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.activity.ActivityWidgetGridFaceFragment$onClick$2, reason: invalid class name */
    /* INFO: compiled from: ActivityWidgetGridFaceFragment.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass2 extends Lambda<Unit> implements Function1<PlayableItemEntity, Unit> {
        final /* synthetic */ StaticPlayableItemCollectionDialogFragment $dialog;
        final /* synthetic */ ActivityWidgetGridFaceFragment this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(StaticPlayableItemCollectionDialogFragment staticPlayableItemCollectionDialogFragment, ActivityWidgetGridFaceFragment activityWidgetGridFaceFragment) {
            super(1);
            this.$dialog = staticPlayableItemCollectionDialogFragment;
            this.this$0 = activityWidgetGridFaceFragment;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PlayableItemEntity playableItemEntity) {
            invoke2(playableItemEntity);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PlayableItemEntity it) {
            Intrinsics.checkNotNullParameter(it, "it");
            this.$dialog.dismiss();
            DaijishouLibraryModel daijishouLibrary = this.this$0.getDaijishouLibrary();
            FragmentActivity fragmentActivityRequireActivity = this.this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
            DaijishouLibraryModel.play$default(daijishouLibrary, fragmentActivityRequireActivity, it, null, 4, null);
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.activity.ActivityWidgetGridFaceFragment$onClick$3, reason: invalid class name */
    /* INFO: compiled from: ActivityWidgetGridFaceFragment.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass3 extends Lambda<Unit> implements Function1<PlayableItemEntity, Unit> {
        AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PlayableItemEntity playableItemEntity) {
            invoke2(playableItemEntity);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PlayableItemEntity it) {
            Intrinsics.checkNotNullParameter(it, "it");
            PlayableItemDetailDialogFragment.INSTANCE.newInstance(it).show(ActivityWidgetGridFaceFragment.this.getParentFragmentManager(), PlayableItemDetailDialogFragment.class.getName());
        }
    }

    /* INFO: Access modifiers changed from: private */
    public final Object updateTableBitmap(Continuation<?> continuation) {
        TableLayout tableLayout = this.table;
        if (tableLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("table");
            tableLayout = null;
        }
        int i = 0;
        for (View view : com.magneticchen.daijishou.support.DaijishouSupport.iterable(ViewGroupKt.getChildren(tableLayout))) {
            if (view instanceof TableRow) {
                for (View view2 : com.magneticchen.daijishou.support.DaijishouSupport.iterable(ViewGroupKt.getChildren((ViewGroup) view))) {
                    if (view2 instanceof ShapeableImageView) {
                        ((ShapeableImageView) view2).setImageBitmap(this.recentEventsBitmapList.get(i));
                        i++;
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* INFO: Access modifiers changed from: private */
    /* WARN: Code duplicated, block: B:7:0x0018  */
    public final Object renewAndUpdateTable(boolean z, Continuation<?> continuation) throws Throwable {
        C02171 c02171;
        long j;
        boolean z2;
        Mutex mutex;
        ActivityWidgetGridFaceFragment activityWidgetGridFaceFragment;
        boolean z3;
        long j2;
        Mutex mutex2;
        if (continuation instanceof C02171) {
            c02171 = (C02171) continuation;
            if ((c02171.label & Integer.MIN_VALUE) != 0) {
                c02171.label -= Integer.MIN_VALUE;
            } else {
                c02171 = new C02171(continuation);
            }
        } else {
            c02171 = new C02171(continuation);
        }
        Object obj = c02171.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02171.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            j = requireArguments().getLong("widgetInstanceId");
            Mutex mutex3 = this.updateTableMutex;
            c02171.L$0 = this;
            c02171.L$1 = mutex3;
            c02171.Z$0 = z;
            c02171.J$0 = j;
            c02171.label = 1;
            if (mutex3.lock(null, c02171) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex = mutex3;
            activityWidgetGridFaceFragment = this;
            z2 = z;
        } else if (i == 1) {
            j = c02171.J$0;
            z2 = c02171.Z$0;
            mutex = (Mutex) c02171.L$1;
            activityWidgetGridFaceFragment = (ActivityWidgetGridFaceFragment) c02171.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            mutex2 = (Mutex) c02171.L$0;
            ResultKt.throwOnFailure(obj);
            mutex2.unlock(null);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            CoroutineDispatcher io2 = Dispatchers.getIO();
            ActivityWidgetGridFaceFragment$renewAndUpdateTable$2$1 task = new ActivityWidgetGridFaceFragment$renewAndUpdateTable$2$1(j, activityWidgetGridFaceFragment, z2, null);
            c02171.L$0 = mutex;
            c02171.L$1 = null;
            c02171.label = 2;
            if (BuildersKt.withContext(io2, task, c02171) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex2 = mutex;
        } catch (Throwable th2) {
            mutex2 = mutex;
            mutex2.unlock(null);
            throw th2;
        }
        mutex2.unlock(null);
        return Unit.INSTANCE;
    }

    static /* synthetic */ Object renewAndUpdateTable$default(ActivityWidgetGridFaceFragment activityWidgetGridFaceFragment, boolean z, Continuation continuation, int i, Object obj) throws Throwable {
        if ((i & 1) != 0) {
            z = true;
        }
        return activityWidgetGridFaceFragment.renewAndUpdateTable(z, continuation);
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetFaceFragment, com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        this.dataChangedBroadcastReceiver = new AnonymousClass1();
        registerDateChangedBroadcast();
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.activity.ActivityWidgetGridFaceFragment$onCreate$1, reason: invalid class name */
    /* INFO: compiled from: ActivityWidgetGridFaceFragment.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/magneticchen/daijishou/daijishou_widget/widgets/activity/ActivityWidgetGridFaceFragment$onCreate$1", "Lcom/magneticchen/daijishou/utils/DayChangedBroadcastReceiver;", "onDayChanged", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class AnonymousClass1 extends DayChangedBroadcastReceiver {
        AnonymousClass1() {
        }

        @Override // com.magneticchen.daijishou.utils.DayChangedBroadcastReceiver
        public void onDayChanged() {
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(ActivityWidgetGridFaceFragment.this), Dispatchers.getIO(), null, new ActivityWidgetGridFaceFragment$onCreate$1$onDayChanged$1(ActivityWidgetGridFaceFragment.this, null), 2, null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.widget_face_activity_grid, container, false);
        View viewFindViewById = viewInflate.findViewById(R.id.widget_face_activity_grid_table_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.table = (TableLayout) viewFindViewById;
        if (!this.recentEventsList.isEmpty()) {
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new C02141(null), 2, null);
        }
        getDaijishouLibrary().getLatestEvent().observe(getViewLifecycleOwner(), new ActivityWidgetGridFaceFragment$sam$androidx_lifecycle_Observer$0(new C02152()));
        return viewInflate;
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.activity.ActivityWidgetGridFaceFragment$onCreateView$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: ActivityWidgetGridFaceFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.daijishou_widget.widgets.activity.ActivityWidgetGridFaceFragment$onCreateView$1", f = "ActivityWidgetGridFaceFragment.kt", i = {}, l = {242}, m = "invokeSuspendImpl", n = {}, s = {})
    final class C02141 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        int label;

        C02141(Continuation<?> continuation) {
            super(2, continuation);
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return ActivityWidgetGridFaceFragment.this.new C02141(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    return ((C02141) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                }
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
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

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.activity.ActivityWidgetGridFaceFragment$onCreateView$2, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: ActivityWidgetGridFaceFragment.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/magneticchen/daijishou/daijishou_library_db/EventEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class C02152 extends Lambda<Unit> implements Function1<EventEntity, Unit> {
        C02152() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(EventEntity eventEntity) {
            invoke2(eventEntity);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(EventEntity eventEntity) {
            if (Intrinsics.areEqual(ActivityWidgetGridFaceFragment.this.latestEvent, eventEntity)) {
                return;
            }
            ActivityWidgetGridFaceFragment.this.latestEvent = eventEntity;
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(ActivityWidgetGridFaceFragment.this), Dispatchers.getIO(), null, new AnonymousClass1(ActivityWidgetGridFaceFragment.this, null), 2, null);
        }

        /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.activity.ActivityWidgetGridFaceFragment$onCreateView$2$1, reason: invalid class name */
        /* INFO: compiled from: ActivityWidgetGridFaceFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.daijishou_widget.widgets.activity.ActivityWidgetGridFaceFragment$onCreateView$2$1", f = "ActivityWidgetGridFaceFragment.kt", i = {}, l = {247}, m = "invokeSuspendImpl", n = {}, s = {})
        final class AnonymousClass1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
            int label;
            final /* synthetic */ ActivityWidgetGridFaceFragment this$0;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ActivityWidgetGridFaceFragment activityWidgetGridFaceFragment, Continuation<?> continuation) {
                super(2, continuation);
                this.this$0 = activityWidgetGridFaceFragment;
            }


            public final Continuation create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
                try {
                    try {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                    }
                } catch (Throwable th) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                }
            }

            public final Object invokeSuspendImpl(Object obj) throws Throwable {
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
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        unregisterDateChangedBroadcast();
    }
}
