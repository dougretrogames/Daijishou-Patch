package com.magneticchen.daijishou.daijishou_widget.widgets.activity;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.google.android.material.imageview.ShapeableImageView;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.daijishou_library_db.EventEntity;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemPreviewMediaIndex;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetFaceFragment;
import com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment;
import com.magneticchen.daijishou.dialog_fragments.StaticPlayableItemCollectionDialogFragment;
import com.magneticchen.daijishou.utils.DayChangedBroadcastReceiver;
import com.magneticchen.daijishou.utils.ScaledBitmapLoader;
import com.magneticchen.daijishou.utils.Utils;
import com.magneticchen.daijishou.view_models.DaijishouLibraryModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: ActivityWidgetTodayFaceFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\rH\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010 \u001a\u00020\u0016H\u0016J\b\u0010!\u001a\u00020\u0016H\u0002J\b\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010#\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/activity/ActivityWidgetTodayFaceFragment;", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetFaceFragment;", "()V", "background", "Lcom/google/android/material/imageview/ShapeableImageView;", "backgroundBitmap", "Landroid/graphics/Bitmap;", "dataChangedBroadcastReceiver", "Lcom/magneticchen/daijishou/utils/DayChangedBroadcastReceiver;", "description", "Landroid/widget/TextView;", "itemCount", "latestEvent", "Lcom/magneticchen/daijishou/daijishou_library_db/EventEntity;", "recentEvents", "", "secondBackground", "secondBackgroundBitmap", "title", "getBitmapFromEvent", "eventEntity", "onClick", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "registerDateChangedBroadcast", "renewAndUpdateFace", "unregisterDateChangedBroadcast", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ActivityWidgetTodayFaceFragment extends WidgetFaceFragment {
    public ShapeableImageView background;
    Bitmap backgroundBitmap;
    private DayChangedBroadcastReceiver dataChangedBroadcastReceiver;
    public TextView description;
    public TextView itemCount;
    private EventEntity latestEvent;
    public List<EventEntity> recentEvents = CollectionsKt.emptyList();
    public ShapeableImageView secondBackground;
    Bitmap secondBackgroundBitmap;
    public TextView title;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HashMap<Long, Integer> widgetInstanceIdToTitle = MapsKt.hashMapOf(TuplesKt.to(4L, Integer.valueOf(R.string.widget_face_activity_today_you_have_played)), TuplesKt.to(5L, Integer.valueOf(R.string.widget_face_activity_today_you_have_viewed)));
    private static final HashMap<Long, Integer> widgetInstanceIdToDescription = MapsKt.hashMapOf(TuplesKt.to(4L, Integer.valueOf(R.string.widget_face_activity_today_you_have_played_today)), TuplesKt.to(5L, Integer.valueOf(R.string.widget_face_activity_today_you_have_viewed_today)));
    private static final HashMap<Long, Integer> widgetInstanceIdToDialogTitle = MapsKt.hashMapOf(TuplesKt.to(4L, Integer.valueOf(R.string.widget_face_activity_today_playable_items_played)), TuplesKt.to(5L, Integer.valueOf(R.string.widget_face_activity_today_playable_items_viewed)));

    /* JADX INFO: compiled from: ActivityWidgetTodayFaceFragment.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005R-\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR-\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR-\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/activity/ActivityWidgetTodayFaceFragment$Companion;", "", "()V", "widgetInstanceIdToDescription", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getWidgetInstanceIdToDescription", "()Ljava/util/HashMap;", "widgetInstanceIdToDialogTitle", "getWidgetInstanceIdToDialogTitle", "widgetInstanceIdToTitle", "getWidgetInstanceIdToTitle", "newInstance", "Lcom/magneticchen/daijishou/daijishou_widget/widgets/activity/ActivityWidgetTodayFaceFragment;", "widgetInstanceId", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ActivityWidgetTodayFaceFragment newInstance(long widgetInstanceId) {
            ActivityWidgetTodayFaceFragment activityWidgetTodayFaceFragment = new ActivityWidgetTodayFaceFragment();
            Bundle bundle = new Bundle();
            bundle.putLong("widgetInstanceId", widgetInstanceId);
            activityWidgetTodayFaceFragment.setArguments(bundle);
            return activityWidgetTodayFaceFragment;
        }

        public final HashMap<Long, Integer> getWidgetInstanceIdToTitle() {
            return ActivityWidgetTodayFaceFragment.widgetInstanceIdToTitle;
        }

        public final HashMap<Long, Integer> getWidgetInstanceIdToDescription() {
            return ActivityWidgetTodayFaceFragment.widgetInstanceIdToDescription;
        }

        public final HashMap<Long, Integer> getWidgetInstanceIdToDialogTitle() {
            return ActivityWidgetTodayFaceFragment.widgetInstanceIdToDialogTitle;
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void renewAndUpdateFace() {
        long j = requireArguments().getLong("widgetInstanceId");
        int i = ((int) j) - 3;
        Date dateAtStartOfDay = Utils.INSTANCE.atStartOfDay(new Date());
        Intrinsics.checkNotNull(dateAtStartOfDay);
        List<EventEntity> recentEventsByEventStatically$default = DaijishouLibraryModel.getRecentEventsByEventStatically$default(getDaijishouLibrary(), i, dateAtStartOfDay, 0, 4, null);
        boolean zIsEmpty = DaijishouLibraryModel.getRecentEventsByEventStatically$default(getDaijishouLibrary(), i, dateAtStartOfDay, 0, 4, null).isEmpty();
        ShapeableImageView shapeableImageView = null;
        if (zIsEmpty) {
            this.backgroundBitmap = null;
            this.secondBackgroundBitmap = null;
            ShapeableImageView shapeableImageView2 = this.background;
            if (shapeableImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("background");
                shapeableImageView2 = null;
            }
            shapeableImageView2.setImageBitmap(null);
            ShapeableImageView shapeableImageView3 = this.secondBackground;
            if (shapeableImageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("secondBackground");
                shapeableImageView3 = null;
            }
            shapeableImageView3.setImageBitmap(null);
        }
        this.recentEvents = recentEventsByEventStatically$default;
        ShapeableImageView shapeableImageView4 = this.background;
        if (shapeableImageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("background");
        } else {
            shapeableImageView = shapeableImageView4;
        }
        shapeableImageView.post(new ActivityWidgetTodayFaceFragment$$ExternalSyntheticLambda0(this, j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void renewAndUpdateFace$lambda$0(ActivityWidgetTodayFaceFragment this$0, long j) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LifecycleOwnerKt.getLifecycleScope(this$0).launchWhenStarted(new ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1(this$0, j, null));
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetFaceFragment
    public void onClick() {
        super.onClick();
        long j = requireArguments().getLong("widgetInstanceId");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = this.recentEvents.iterator();
        while (it.hasNext()) {
            Long playableItemId = ((EventEntity) it.next()).getPlayableItemId();
            if (playableItemId != null) {
                PlayableItemEntity playableItemByIdStatically = getDaijishouLibrary().getPlayableItemByIdStatically(playableItemId.longValue());
                if (playableItemByIdStatically != null && !arrayList2.contains(Long.valueOf(playableItemByIdStatically.getId()))) {
                    arrayList.add(playableItemByIdStatically);
                    arrayList2.add(Long.valueOf(playableItemByIdStatically.getId()));
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

    /* JADX INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.activity.ActivityWidgetTodayFaceFragment$onClick$2, reason: invalid class name */
    /* JADX INFO: compiled from: ActivityWidgetTodayFaceFragment.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass2 extends Lambda<Unit> implements Function1<PlayableItemEntity, Unit> {
        final /* synthetic */ StaticPlayableItemCollectionDialogFragment $dialog;
        final /* synthetic */ ActivityWidgetTodayFaceFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(StaticPlayableItemCollectionDialogFragment staticPlayableItemCollectionDialogFragment, ActivityWidgetTodayFaceFragment activityWidgetTodayFaceFragment) {
            super(1);
            this.$dialog = staticPlayableItemCollectionDialogFragment;
            this.this$0 = activityWidgetTodayFaceFragment;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PlayableItemEntity playableItemEntity) {
            invoke2(playableItemEntity);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PlayableItemEntity it) {
            Intrinsics.checkNotNullParameter(it, "it");
            this.$dialog.dismiss();
            DaijishouLibraryModel daijishouLibrary = this.this$0.getDaijishouLibrary();
            FragmentActivity fragmentActivityRequireActivity = this.this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
            DaijishouLibraryModel.play$default(daijishouLibrary, fragmentActivityRequireActivity, it, null, 4, null);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.activity.ActivityWidgetTodayFaceFragment$onClick$3, reason: invalid class name */
    /* JADX INFO: compiled from: ActivityWidgetTodayFaceFragment.kt */
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

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PlayableItemEntity it) {
            Intrinsics.checkNotNullParameter(it, "it");
            PlayableItemDetailDialogFragment.INSTANCE.newInstance(it).show(ActivityWidgetTodayFaceFragment.this.getParentFragmentManager(), PlayableItemDetailDialogFragment.class.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap getBitmapFromEvent(EventEntity eventEntity) throws IOException {
        Long playableItemId;
        String snapshotPath;
        if ((eventEntity.getEvent() == 1 || eventEntity.getEvent() == 2) && (playableItemId = eventEntity.getPlayableItemId()) != null) {
            PlayableItemEntity playableItemByIdStatically = getDaijishouLibrary().getPlayableItemByIdStatically(playableItemId.longValue());
            if (playableItemByIdStatically != null) {
                String previewMediaPath = playableItemByIdStatically.getPreviewMediaPath();
                PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex = Utils.INSTANCE.getPlayableItemPreviewMediaIndex(playableItemByIdStatically);
                if (playableItemPreviewMediaIndex == null || (snapshotPath = playableItemPreviewMediaIndex.getBoxArtPath()) == null) {
                    snapshotPath = playableItemPreviewMediaIndex != null ? playableItemPreviewMediaIndex.getSnapshotPath() : null;
                    if (snapshotPath == null) {
                        snapshotPath = playableItemPreviewMediaIndex != null ? playableItemPreviewMediaIndex.getTitlePath() : null;
                    }
                }
                if (snapshotPath != null) {
                    try {
                        ScaledBitmapLoader scaledBitmapLoader = ScaledBitmapLoader.INSTANCE;
                        String str = previewMediaPath + snapshotPath;
                        ShapeableImageView shapeableImageView = this.background;
                        if (shapeableImageView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("background");
                            shapeableImageView = null;
                        }
                        int width = shapeableImageView.getWidth() * 2;
                        ShapeableImageView shapeableImageView2 = this.background;
                        if (shapeableImageView2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("background");
                            shapeableImageView2 = null;
                        }
                        Bitmap bitmapDecodeSampledBitmapFromFile = scaledBitmapLoader.decodeSampledBitmapFromFile(str, width, shapeableImageView2.getWidth() * 2);
                        ShapeableImageView shapeableImageView3 = this.background;
                        if (shapeableImageView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("background");
                            shapeableImageView3 = null;
                        }
                        int width2 = shapeableImageView3.getWidth() * 2;
                        ShapeableImageView shapeableImageView4 = this.background;
                        if (shapeableImageView4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("background");
                            shapeableImageView4 = null;
                        }
                        return ThumbnailUtils.extractThumbnail(bitmapDecodeSampledBitmapFromFile, width2, shapeableImageView4.getWidth() * 2);
                    } catch (Exception e) {
                        getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.activity.ActivityWidgetTodayFaceFragment$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: ActivityWidgetTodayFaceFragment.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/magneticchen/daijishou/daijishou_widget/widgets/activity/ActivityWidgetTodayFaceFragment$onCreate$1", "Lcom/magneticchen/daijishou/utils/DayChangedBroadcastReceiver;", "onDayChanged", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class AnonymousClass1 extends DayChangedBroadcastReceiver {
        AnonymousClass1() {
        }

        @Override // com.magneticchen.daijishou.utils.DayChangedBroadcastReceiver
        public void onDayChanged() {
            ActivityWidgetTodayFaceFragment.this.renewAndUpdateFace();
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetFaceFragment, com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.dataChangedBroadcastReceiver = new AnonymousClass1();
        registerDateChangedBroadcast();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        long j = requireArguments().getLong("widgetInstanceId");
        View viewInflate = inflater.inflate(R.layout.widget_face_activity_today, container, false);
        View viewFindViewById = viewInflate.findViewById(R.id.widget_face_activity_today_widget_title);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.title = (TextView) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.widget_face_activity_today_widget_background);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.background = (ShapeableImageView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R.id.widget_face_activity_today_widget_second_background);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.secondBackground = (ShapeableImageView) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(R.id.widget_face_activity_today_widget_items_count);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.itemCount = (TextView) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(R.id.widget_face_activity_today_widget_description);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.description = (TextView) viewFindViewById5;
        TextView textView = this.title;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
            textView = null;
        }
        Integer num = widgetInstanceIdToTitle.get(Long.valueOf(j));
        Intrinsics.checkNotNull(num);
        textView.setText(getString(num.intValue()));
        TextView textView3 = this.description;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("description");
            textView3 = null;
        }
        Integer num2 = widgetInstanceIdToDescription.get(Long.valueOf(j));
        Intrinsics.checkNotNull(num2);
        textView3.setText(getString(num2.intValue()));
        if (!this.recentEvents.isEmpty()) {
            ShapeableImageView shapeableImageView = this.background;
            if (shapeableImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("background");
                shapeableImageView = null;
            }
            shapeableImageView.setImageBitmap(this.backgroundBitmap);
            ShapeableImageView shapeableImageView2 = this.secondBackground;
            if (shapeableImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("secondBackground");
                shapeableImageView2 = null;
            }
            shapeableImageView2.setImageBitmap(this.secondBackgroundBitmap);
            TextView textView4 = this.itemCount;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemCount");
            } else {
                textView2 = textView4;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getString(R.string.widget_face_activity_today_subtitle_format);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this.recentEvents.size())}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            textView2.setText(str);
        }
        renewAndUpdateFace();
        getDaijishouLibrary().getLatestEvent().observe(getViewLifecycleOwner(), new ActivityWidgetTodayFaceFragment$sam$androidx_lifecycle_Observer$0(new C02181()));
        return viewInflate;
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.activity.ActivityWidgetTodayFaceFragment$onCreateView$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ActivityWidgetTodayFaceFragment.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/magneticchen/daijishou/daijishou_library_db/EventEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class C02181 extends Lambda<Unit> implements Function1<EventEntity, Unit> {
        C02181() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(EventEntity eventEntity) {
            invoke2(eventEntity);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(EventEntity eventEntity) {
            if (Intrinsics.areEqual(ActivityWidgetTodayFaceFragment.this.latestEvent, eventEntity)) {
                return;
            }
            ActivityWidgetTodayFaceFragment.this.latestEvent = eventEntity;
            ActivityWidgetTodayFaceFragment.this.renewAndUpdateFace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        unregisterDateChangedBroadcast();
    }

    public static final void access$setBackgroundBitmap$p(ActivityWidgetTodayFaceFragment fragment, Bitmap bitmap) {
        fragment.backgroundBitmap = bitmap;
    }

    public static final void access$setSecondBackgroundBitmap$p(ActivityWidgetTodayFaceFragment fragment, Bitmap bitmap) {
        fragment.secondBackgroundBitmap = bitmap;
    }

    public static final List<EventEntity> access$getRecentEvents$p(ActivityWidgetTodayFaceFragment fragment) {
        return fragment.recentEvents;
    }

    public static final Bitmap access$getBitmapFromEvent(ActivityWidgetTodayFaceFragment fragment, EventEntity event) throws java.io.IOException {
        return fragment.getBitmapFromEvent(event);
    }
}
