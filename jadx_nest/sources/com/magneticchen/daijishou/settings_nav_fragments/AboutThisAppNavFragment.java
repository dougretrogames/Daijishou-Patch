package com.magneticchen.daijishou.settings_nav_fragments;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.abstract_fragment_classes.DaijishouPreferenceFragment;
import com.magneticchen.daijishou.activities.MainActivity;
import com.magneticchen.daijishou.application_data.BooleanPreference;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.dialog_fragments.AcknowledgementDialogFragment;
import com.magneticchen.daijishou.view_models.DaijishouViewModel;
import com.magneticchen.daijishou.view_models.SettingsViewModel;
import java.util.Arrays;
import java.util.Calendar;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;

/* JADX INFO: compiled from: AboutThisAppNavFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\u001a\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001b²\u0006\n\u0010\u001c\u001a\u00020\u001dX\u008a\u0084\u0002²\u0006\n\u0010\u001e\u001a\u00020\u001fX\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/settings_nav_fragments/AboutThisAppNavFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/DaijishouPreferenceFragment;", "()V", "goBack", "", "iconClickedCount", "", "refocusOnScrolledToTop", "scrollView", "Landroid/widget/ScrollView;", "titleString", "", "onBackPressed", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "onViewCreated", "view", "Companion", "app_release", "settingsModel", "Lcom/magneticchen/daijishou/view_models/SettingsViewModel;", "model", "Lcom/magneticchen/daijishou/view_models/DaijishouViewModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AboutThisAppNavFragment extends DaijishouPreferenceFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean goBack;
    private int iconClickedCount;
    private boolean refocusOnScrolledToTop;
    private ScrollView scrollView;
    private String titleString;

    /* JADX INFO: compiled from: AboutThisAppNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/magneticchen/daijishou/settings_nav_fragments/AboutThisAppNavFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/settings_nav_fragments/AboutThisAppNavFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AboutThisAppNavFragment newInstance() {
            return new AboutThisAppNavFragment();
        }
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment
    public boolean onBackPressed() {
        if (this.goBack) {
            return true;
        }
        ScrollView scrollView = this.scrollView;
        ScrollView scrollView2 = null;
        if (scrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollView");
            scrollView = null;
        }
        if (scrollView.getScrollY() == 0) {
            return super.onBackPressed();
        }
        this.refocusOnScrolledToTop = true;
        ScrollView scrollView3 = this.scrollView;
        if (scrollView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollView");
        } else {
            scrollView2 = scrollView3;
        }
        scrollView2.smoothScrollTo(0, 0);
        return false;
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String string = getString(R.string.about_this_app_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.titleString = string;
    }

    /* JADX WARN: Type inference failed for: r3v16, types: [T, java.lang.String] */
    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.fragment_about_this_app, container, false);
        View viewFindViewById = viewInflate.findViewById(R.id.fragment_about_this_app_scroll_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.scrollView = (ScrollView) viewFindViewById;
        TextView textView = (TextView) viewInflate.findViewById(R.id.about_this_app_version);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.about_this_app_description);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.about_this_app_icon);
        Button button = (Button) viewInflate.findViewById(R.id.about_this_app_back_button);
        Button button2 = (Button) viewInflate.findViewById(R.id.about_this_app_details_button);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.about_this_app_copyright);
        String string = getString(R.string.copyright_statement);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(Calendar.getInstance().get(1))}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        textView3.setText(str);
        ScrollView scrollView = this.scrollView;
        if (scrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollView");
            scrollView = null;
        }
        scrollView.setOnScrollChangeListener(new AboutThisAppNavFragment$$ExternalSyntheticLambda0(this, imageView));
        textView.setText("Version: 1.5.0 (416)");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        String str2 = Build.MODEL;
        String str3 = Build.BRAND;
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        Application application = requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        objectRef.element = "Device model: " + str2 + " (" + str3 + ")\nDevice CPU cores: " + iAvailableProcessors + "\nDaijishou UUID: " + ((DaijishouApplication) application).getDaijishouUUID() + "\nEvents count: 0 event(s)\nPlatforms count: 0 platform(s)\nPlayers count: 0 player(s)\nPlayable items count: 0 item(s)\nTarget RAWeb version: 2.0.0\nLibrary Database version: 17\nWidget Database version: 8\nRetroAchievements Database version: 4\n";
        getDaijishouLibrary().getAllEventsCount().observe(getViewLifecycleOwner(), new AboutThisAppNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass2(objectRef)));
        getDaijishouLibrary().getAllPlatformsCount().observe(getViewLifecycleOwner(), new AboutThisAppNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass3(objectRef)));
        getDaijishouLibrary().getAllPlayersCount().observe(getViewLifecycleOwner(), new AboutThisAppNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass4(objectRef)));
        getDaijishouLibrary().getAllPlayableItemCount().observe(getViewLifecycleOwner(), new AboutThisAppNavFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass5(objectRef)));
        imageView.setOnClickListener(new AboutThisAppNavFragment$$ExternalSyntheticLambda1(this));
        textView2.setOnClickListener(new AboutThisAppNavFragment$$ExternalSyntheticLambda2(this));
        button2.setOnClickListener(new AboutThisAppNavFragment$$ExternalSyntheticLambda3(this, objectRef));
        button.setOnClickListener(new AboutThisAppNavFragment$$ExternalSyntheticLambda4(this));
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0(AboutThisAppNavFragment this$0, ImageView imageView, View view, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.refocusOnScrolledToTop) {
            ScrollView scrollView = this$0.scrollView;
            if (scrollView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scrollView");
                scrollView = null;
            }
            if (scrollView.getScrollY() == 0) {
                this$0.refocusOnScrolledToTop = false;
                imageView.requestFocus();
            }
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.settings_nav_fragments.AboutThisAppNavFragment$onCreateView$2, reason: invalid class name */
    /* JADX INFO: compiled from: AboutThisAppNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass2 extends Lambda<Unit> implements Function1<Integer, Unit> {
        final /* synthetic */ Ref.ObjectRef<String> $detailText;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Ref.ObjectRef<String> objectRef) {
            super(1);
            this.$detailText = objectRef;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke2(num);
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference failed for: r6v4, types: [T, java.lang.String] */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Integer num) {
            Ref.ObjectRef<String> objectRef = this.$detailText;
            objectRef.element = new Regex("Events count: \\d+ event\\(s\\)\n").replace(objectRef.element, "Events count: " + num + " events\n");
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.settings_nav_fragments.AboutThisAppNavFragment$onCreateView$3, reason: invalid class name */
    /* JADX INFO: compiled from: AboutThisAppNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass3 extends Lambda<Unit> implements Function1<Integer, Unit> {
        final /* synthetic */ Ref.ObjectRef<String> $detailText;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Ref.ObjectRef<String> objectRef) {
            super(1);
            this.$detailText = objectRef;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke2(num);
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference failed for: r6v4, types: [T, java.lang.String] */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Integer num) {
            Ref.ObjectRef<String> objectRef = this.$detailText;
            objectRef.element = new Regex("Platforms count: \\d+ platform\\(s\\)\n").replace(objectRef.element, "Platforms count: " + num + " items\n");
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.settings_nav_fragments.AboutThisAppNavFragment$onCreateView$4, reason: invalid class name */
    /* JADX INFO: compiled from: AboutThisAppNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass4 extends Lambda<Unit> implements Function1<Integer, Unit> {
        final /* synthetic */ Ref.ObjectRef<String> $detailText;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Ref.ObjectRef<String> objectRef) {
            super(1);
            this.$detailText = objectRef;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke2(num);
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference failed for: r6v4, types: [T, java.lang.String] */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Integer num) {
            Ref.ObjectRef<String> objectRef = this.$detailText;
            objectRef.element = new Regex("Players count: \\d+ player\\(s\\)\n").replace(objectRef.element, "Players count: " + num + " items\n");
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.settings_nav_fragments.AboutThisAppNavFragment$onCreateView$5, reason: invalid class name */
    /* JADX INFO: compiled from: AboutThisAppNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass5 extends Lambda<Unit> implements Function1<Integer, Unit> {
        final /* synthetic */ Ref.ObjectRef<String> $detailText;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(Ref.ObjectRef<String> objectRef) {
            super(1);
            this.$detailText = objectRef;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke2(num);
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference failed for: r6v4, types: [T, java.lang.String] */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Integer num) {
            Ref.ObjectRef<String> objectRef = this.$detailText;
            objectRef.element = new Regex("Playable items count: \\d+ item\\(s\\)\n").replace(objectRef.element, "Playable items count: " + num + " items\n");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1(AboutThisAppNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = this$0.iconClickedCount + 1;
        this$0.iconClickedCount = i;
        if (i % 7 == 0) {
            boolean z = this$0.getDefaultSharedPreferences().getBoolean(BooleanPreference.USE_NSFW.getKey(), BooleanPreference.USE_NSFW.getDefaultValue());
            Toast.makeText(this$0.requireContext(), "Set \"useNSFW\" to \"" + (!z) + "\".", 0).show();
            this$0.getDefaultSharedPreferences().edit().putBoolean("use_nsfw", !z).apply();
        }
        if (this$0.iconClickedCount == 35) {
            Toast.makeText(this$0.requireContext(), "Taiwanese independent!\n台灣獨立萬歲！", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$2(AboutThisAppNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Constants.githubUri)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onCreateView$lambda$3(AboutThisAppNavFragment this$0, Ref.ObjectRef detailText, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(detailText, "$detailText");
        AcknowledgementDialogFragment.Companion.newInstance$default(AcknowledgementDialogFragment.INSTANCE, this$0.getString(R.string.more_detail), (String) detailText.element, null, null, this$0.getString(R.string.donation_title), 12, null).setOnNeutralButtonClickedListener(new AboutThisAppNavFragment$onCreateView$8$1(this$0)).show(this$0.getChildFragmentManager(), AcknowledgementDialogFragment.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$4(AboutThisAppNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.goBack = true;
        FragmentActivity fragmentActivityRequireActivity = this$0.requireActivity();
        Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type com.magneticchen.daijishou.activities.MainActivity");
        ((MainActivity) fragmentActivityRequireActivity).onBackPressedCallback();
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ((ImageView) view.findViewById(R.id.about_this_app_icon)).requestFocus();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        AboutThisAppNavFragment aboutThisAppNavFragment = this;
        SettingsViewModel settingsViewModelOnStart$lambda$5 = onStart$lambda$5(FragmentViewModelLazyKt.createViewModelLazy(aboutThisAppNavFragment, Reflection.getOrCreateKotlinClass(SettingsViewModel.class), new AboutThisAppNavFragment$onStart$$inlined$activityViewModels$default$1(aboutThisAppNavFragment), new AboutThisAppNavFragment$onStart$$inlined$activityViewModels$default$2(null, aboutThisAppNavFragment), new AboutThisAppNavFragment$onStart$$inlined$activityViewModels$default$3(aboutThisAppNavFragment)));
        String str = this.titleString;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleString");
            str = null;
        }
        settingsViewModelOnStart$lambda$5.setTitle(str);
        DaijishouViewModel daijishouViewModelOnStart$lambda$6 = onStart$lambda$6(FragmentViewModelLazyKt.createViewModelLazy(aboutThisAppNavFragment, Reflection.getOrCreateKotlinClass(DaijishouViewModel.class), new AboutThisAppNavFragment$onStart$$inlined$activityViewModels$default$4(aboutThisAppNavFragment), new AboutThisAppNavFragment$onStart$$inlined$activityViewModels$default$5(null, aboutThisAppNavFragment), new AboutThisAppNavFragment$onStart$$inlined$activityViewModels$default$6(aboutThisAppNavFragment)));
        String str2 = this.titleString;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleString");
            str2 = null;
        }
        DaijishouViewModel.setTips$default(daijishouViewModelOnStart$lambda$6, str2, false, 2, null);
    }

    private static final SettingsViewModel onStart$lambda$5(Lazy<SettingsViewModel> lazy) {
        return lazy.getValue();
    }

    private static final DaijishouViewModel onStart$lambda$6(Lazy<DaijishouViewModel> lazy) {
        return lazy.getValue();
    }
}
