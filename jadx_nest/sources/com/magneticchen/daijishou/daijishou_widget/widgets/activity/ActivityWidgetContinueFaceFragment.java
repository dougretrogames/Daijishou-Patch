package com.magneticchen.daijishou.daijishou_widget.widgets.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.application_data.BooleanPreference;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetFaceFragment;
import com.magneticchen.daijishou.dialog_fragments.PlayableItemDetailDialogFragment;
import com.magneticchen.daijishou.view_models.DaijishouLibraryModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* INFO: compiled from: ActivityWidgetContinueFaceFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016J\u001a\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0018\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/activity/ActivityWidgetContinueFaceFragment;", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetFaceFragment;", "()V", "background", "Landroid/widget/ImageView;", "cachedBitmap", "Landroid/graphics/Bitmap;", "description", "Landroid/widget/TextView;", "playableItemEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "onClick", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onViewCreated", "view", "updateViewByCached", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ActivityWidgetContinueFaceFragment extends WidgetFaceFragment {

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public ImageView background;
    public Bitmap cachedBitmap;
    private TextView description;
    PlayableItemEntity playableItemEntity;

    public static final PlayableItemEntity access$getPlayableItemEntity$p(ActivityWidgetContinueFaceFragment activityWidgetContinueFaceFragment) {
        return activityWidgetContinueFaceFragment.playableItemEntity;
    }

    public static final ImageView access$getBackground$p(ActivityWidgetContinueFaceFragment activityWidgetContinueFaceFragment) {
        return activityWidgetContinueFaceFragment.background;
    }

    public static final void access$setCachedBitmap$p(ActivityWidgetContinueFaceFragment activityWidgetContinueFaceFragment, Bitmap bitmap) {
        activityWidgetContinueFaceFragment.cachedBitmap = bitmap;
    }

    /* INFO: compiled from: ActivityWidgetContinueFaceFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/activity/ActivityWidgetContinueFaceFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/daijishou_widget/widgets/activity/ActivityWidgetContinueFaceFragment;", "widgetInstanceId", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ActivityWidgetContinueFaceFragment newInstance(long widgetInstanceId) {
            ActivityWidgetContinueFaceFragment activityWidgetContinueFaceFragment = new ActivityWidgetContinueFaceFragment();
            Bundle bundle = new Bundle();
            bundle.putLong("widgetInstanceId", widgetInstanceId);
            activityWidgetContinueFaceFragment.setArguments(bundle);
            return activityWidgetContinueFaceFragment;
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetFaceFragment
    public void onClick() {
        super.onClick();
        PlayableItemEntity playableItemEntity = this.playableItemEntity;
        if (playableItemEntity != null) {
            if (getDefaultSharedPreferences().getBoolean(BooleanPreference.DETAIL_VIEW_ON_CLICK.getKey(), BooleanPreference.DETAIL_VIEW_ON_CLICK.getDefaultValue())) {
                PlayableItemDetailDialogFragment.INSTANCE.newInstance(playableItemEntity).show(getParentFragmentManager(), PlayableItemDetailDialogFragment.class.getName());
                return;
            }
            DaijishouLibraryModel daijishouLibrary = getDaijishouLibrary();
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
            DaijishouLibraryModel.play$default(daijishouLibrary, fragmentActivityRequireActivity, playableItemEntity, null, 4, null);
        }
    }

    private final void updateViewByCached() {
        TextView textView = this.description;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("description");
            textView = null;
        }
        DaijishouLibraryModel daijishouLibrary = getDaijishouLibrary();
        PlayableItemEntity playableItemEntity = this.playableItemEntity;
        Intrinsics.checkNotNull(playableItemEntity);
        textView.setText(daijishouLibrary.prettifyTitle(playableItemEntity.getName(), false));
        ImageView imageView2 = this.background;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("background");
        } else {
            imageView = imageView2;
        }
        imageView.setImageBitmap(this.cachedBitmap);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        requireArguments().getLong("widgetInstanceId");
        View viewInflate = inflater.inflate(R.layout.widget_face_activity_continue, container, false);
        View viewFindViewById = viewInflate.findViewById(R.id.widget_face_activity_continue_widget_background);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.background = (ImageView) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.widget_face_activity_continue_widget_item_description);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.description = (TextView) viewFindViewById2;
        if (this.playableItemEntity != null) {
            updateViewByCached();
        }
        getDaijishouLibrary().getMostRecentPlayableItem().observe(getViewLifecycleOwner(), new ActivityWidgetContinueFaceFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass2()));
        return viewInflate;
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.activity.ActivityWidgetContinueFaceFragment$onCreateView$2, reason: invalid class name */
    /* INFO: compiled from: ActivityWidgetContinueFaceFragment.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass2 extends Lambda<Unit> implements Function1<PlayableItemEntity, Unit> {
        AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PlayableItemEntity playableItemEntity) {
            invoke2(playableItemEntity);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PlayableItemEntity playableItemEntity) {
            if (playableItemEntity == null || Intrinsics.areEqual(ActivityWidgetContinueFaceFragment.this.playableItemEntity, playableItemEntity)) {
                return;
            }
            ActivityWidgetContinueFaceFragment.this.playableItemEntity = playableItemEntity;
            TextView textView = ActivityWidgetContinueFaceFragment.this.description;
            ImageView imageView = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("description");
                textView = null;
            }
            DaijishouLibraryModel daijishouLibrary = ActivityWidgetContinueFaceFragment.this.getDaijishouLibrary();
            PlayableItemEntity playableItemEntity2 = ActivityWidgetContinueFaceFragment.this.playableItemEntity;
            Intrinsics.checkNotNull(playableItemEntity2);
            textView.setText(daijishouLibrary.prettifyTitle(playableItemEntity2.getName(), false));
            ImageView imageView2 = ActivityWidgetContinueFaceFragment.this.background;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("background");
            } else {
                imageView = imageView2;
            }
            imageView.post(new ActivityWidgetContinueFaceFragment$onCreateView$2$$ExternalSyntheticLambda0(ActivityWidgetContinueFaceFragment.this));
        }

    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    public static final void invoke$lambda$0(ActivityWidgetContinueFaceFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), Dispatchers.getIO(), null, new ActivityWidgetContinueFaceFragment$onCreateView$2$1$1(this$0, null), 2, null);
    }

}
