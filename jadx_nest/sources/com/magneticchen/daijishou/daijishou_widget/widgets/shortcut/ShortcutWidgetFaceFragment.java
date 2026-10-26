package com.magneticchen.daijishou.daijishou_widget.widgets.shortcut;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetFaceFragment;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* INFO: compiled from: ShortcutWidgetFaceFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0007H\u0016J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R6\u0010\u0003\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013²\u0006\n\u0010\u0014\u001a\u00020\u0015X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/shortcut/ShortcutWidgetFaceFragment;", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetFaceFragment;", "()V", "widgetInstanceIdToShortcutFunction", "Ljava/util/HashMap;", "", "Lkotlin/Function0;", "", "Lkotlin/collections/HashMap;", "onClick", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_release", "widgetModel", "Lcom/magneticchen/daijishou/daijishou_widget/widgets/shortcut/ShortcutWidgetViewModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ShortcutWidgetFaceFragment extends WidgetFaceFragment {
    private final HashMap<Long, Function0<Unit>> widgetInstanceIdToShortcutFunction = MapsKt.hashMapOf(TuplesKt.to(1L, new ShortcutWidgetFaceFragment$widgetInstanceIdToShortcutFunction$1(this)), TuplesKt.to(2L, new ShortcutWidgetFaceFragment$widgetInstanceIdToShortcutFunction$2(this)), TuplesKt.to(3L, new ShortcutWidgetFaceFragment$widgetInstanceIdToShortcutFunction$3(this)), TuplesKt.to(4L, new ShortcutWidgetFaceFragment$widgetInstanceIdToShortcutFunction$4(this)), TuplesKt.to(5L, new ShortcutWidgetFaceFragment$widgetInstanceIdToShortcutFunction$5(this)));

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HashMap<Long, String> widgetInstanceIdToTitle = MapsKt.hashMapOf(TuplesKt.to(1L, "Platforms"), TuplesKt.to(2L, "Continue"), TuplesKt.to(3L, "Highlight"), TuplesKt.to(4L, "Apps"), TuplesKt.to(5L, "Settings"));
    private static final HashMap<Long, Integer> widgetInstanceIdToIconResourceId = MapsKt.hashMapOf(TuplesKt.to(1L, Integer.valueOf(R.drawable.ic_baseline_sports_esports_24)), TuplesKt.to(2L, Integer.valueOf(R.drawable.ic_baseline_replay_24)), TuplesKt.to(3L, Integer.valueOf(R.drawable.ic_baseline_auto_awesome_24)), TuplesKt.to(4L, Integer.valueOf(R.drawable.ic_baseline_android_24)), TuplesKt.to(5L, Integer.valueOf(R.drawable.ic_baseline_settings_24)));
    private static final HashMap<Long, String> widgetInstanceIdToDescription = MapsKt.hashMapOf(TuplesKt.to(1L, "Navigate to platforms page."), TuplesKt.to(2L, "Navigate to continue page."), TuplesKt.to(3L, "Navigate to highlight page."), TuplesKt.to(4L, "Navigate to apps page."), TuplesKt.to(5L, "Navigate to settings page."));

    /* INFO: compiled from: ShortcutWidgetFaceFragment.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005R-\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR-\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR-\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/shortcut/ShortcutWidgetFaceFragment$Companion;", "", "()V", "widgetInstanceIdToDescription", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getWidgetInstanceIdToDescription", "()Ljava/util/HashMap;", "widgetInstanceIdToIconResourceId", "", "getWidgetInstanceIdToIconResourceId", "widgetInstanceIdToTitle", "getWidgetInstanceIdToTitle", "newInstance", "Lcom/magneticchen/daijishou/daijishou_widget/widgets/shortcut/ShortcutWidgetFaceFragment;", "widgetInstanceId", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ShortcutWidgetFaceFragment newInstance(long widgetInstanceId) {
            ShortcutWidgetFaceFragment shortcutWidgetFaceFragment = new ShortcutWidgetFaceFragment();
            Bundle bundle = new Bundle();
            bundle.putLong("widgetInstanceId", widgetInstanceId);
            shortcutWidgetFaceFragment.setArguments(bundle);
            return shortcutWidgetFaceFragment;
        }

        public final HashMap<Long, String> getWidgetInstanceIdToTitle() {
            return ShortcutWidgetFaceFragment.widgetInstanceIdToTitle;
        }

        public final HashMap<Long, Integer> getWidgetInstanceIdToIconResourceId() {
            return ShortcutWidgetFaceFragment.widgetInstanceIdToIconResourceId;
        }

        public final HashMap<Long, String> getWidgetInstanceIdToDescription() {
            return ShortcutWidgetFaceFragment.widgetInstanceIdToDescription;
        }
    }

    @Override // com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetFaceFragment
    public void onClick() {
        super.onClick();
        Function0<Unit> function0 = this.widgetInstanceIdToShortcutFunction.get(Long.valueOf(requireArguments().getLong("widgetInstanceId")));
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ShortcutWidgetFaceFragment shortcutWidgetFaceFragment = this;
        FragmentViewModelLazyKt.createViewModelLazy(shortcutWidgetFaceFragment, Reflection.getOrCreateKotlinClass(ShortcutWidgetViewModel.class), new ShortcutWidgetFaceFragment$onCreateView$$inlined$activityViewModels$default$1(shortcutWidgetFaceFragment), new ShortcutWidgetFaceFragment$onCreateView$$inlined$activityViewModels$default$2(null, shortcutWidgetFaceFragment), new ShortcutWidgetFaceFragment$onCreateView$$inlined$activityViewModels$default$3(shortcutWidgetFaceFragment));
        long j = requireArguments().getLong("widgetInstanceId");
        View viewInflate = inflater.inflate(R.layout.widget_face_shortcut_default, container, false);
        TextView textView = (TextView) viewInflate.findViewById(R.id.widget_face_shortcut_default_widget_title);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.widget_face_shortcut_default_widget_description);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.widget_face_shortcut_default_widget_icon);
        textView.setText(widgetInstanceIdToTitle.get(Long.valueOf(j)));
        textView2.setText(widgetInstanceIdToDescription.get(Long.valueOf(j)));
        Integer num = widgetInstanceIdToIconResourceId.get(Long.valueOf(j));
        if (num != null) {
            imageView.setImageResource(num.intValue());
        }
        return viewInflate;
    }
}
