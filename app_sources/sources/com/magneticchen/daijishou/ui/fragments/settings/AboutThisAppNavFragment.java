package com.magneticchen.daijishou.ui.fragments.settings;

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
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.BooleanPreference;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.ui.activities.MainActivity;
import com.magneticchen.daijishou.ui.fragments.dialog.AcknowledgementDialogFragment;
import com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouPreferenceFragment;
import com.magneticchen.daijishou.ui.model.DaijishouViewModel;
import com.magneticchen.daijishou.ui.model.SettingsViewModel;
import java.util.Arrays;
import java.util.Calendar;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;

/* JADX INFO: compiled from: AboutThisAppNavFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\u001a\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001b²\u0006\n\u0010\u001c\u001a\u00020\u001dX\u008a\u0084\u0002²\u0006\n\u0010\u001e\u001a\u00020\u001fX\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/settings/AboutThisAppNavFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouPreferenceFragment;", "()V", "goBack", "", "iconClickedCount", "", "refocusOnScrolledToTop", "scrollView", "Landroid/widget/ScrollView;", "titleString", "", "onBackPressed", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "onViewCreated", "view", "Companion", "app_release", "settingsModel", "Lcom/magneticchen/daijishou/ui/model/SettingsViewModel;", "model", "Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AboutThisAppNavFragment extends DaijishouPreferenceFragment {
    public static final Companion Companion = new Companion(null);
    private boolean goBack;
    private int iconClickedCount;
    private boolean refocusOnScrolledToTop;
    private ScrollView scrollView;
    private String titleString;

    /* JADX INFO: compiled from: AboutThisAppNavFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/settings/AboutThisAppNavFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/ui/fragments/settings/AboutThisAppNavFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
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

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = getString(R.string.about_this_app_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.titleString = string;
    }

    /* JADX WARN: Type inference failed for: r3v16, types: [T, java.lang.String] */
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.fragment_about_this_app, viewGroup, false);
        View viewFindViewById = viewInflate.findViewById(R.id.fragment_about_this_app_scroll_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.scrollView = (ScrollView) viewFindViewById;
        TextView textView = (TextView) viewInflate.findViewById(R.id.about_this_app_version);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.about_this_app_description);
        final ImageView imageView = (ImageView) viewInflate.findViewById(R.id.about_this_app_icon);
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
        scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.AboutThisAppNavFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
                AboutThisAppNavFragment.onCreateView$lambda$0(this.f$0, imageView, view, i, i2, i3, i4);
            }
        });
        textView.setText("Version: 1.8.1 (426)");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        String str2 = Build.MODEL;
        String str3 = Build.BRAND;
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        Application application = requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        objectRef.element = "Device model: " + str2 + " (" + str3 + ")\nDevice CPU cores: " + iAvailableProcessors + "\nDaijishou UUID: " + ((DaijishouApplication) application).getDaijishouUUID() + "\nEvents count: 0 event(s)\nPlatforms count: 0 platform(s)\nPlayers count: 0 player(s)\nPlayable items count: 0 item(s)\nTarget RAWeb version: 2.0.0\nLibrary Database version: 20\nWidget Database version: 8\nExtension Database version: 1 (Disabled)\nRetroAchievements Database version: 4\n";
        getDaijishouLibrary().getAllEventsCount().observe(getViewLifecycleOwner(), new AboutThisAppNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<Integer, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.AboutThisAppNavFragment.onCreateView.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r6v4, types: [T, java.lang.String] */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                Ref.ObjectRef<String> objectRef2 = objectRef;
                objectRef2.element = new Regex("Events count: \\d+ event\\(s\\)\n").replace(objectRef2.element, "Events count: " + num + " events\n");
            }
        }));
        getDaijishouLibrary().getAllPlatformsCount().observe(getViewLifecycleOwner(), new AboutThisAppNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<Integer, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.AboutThisAppNavFragment.onCreateView.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r6v4, types: [T, java.lang.String] */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                Ref.ObjectRef<String> objectRef2 = objectRef;
                objectRef2.element = new Regex("Platforms count: \\d+ platform\\(s\\)\n").replace(objectRef2.element, "Platforms count: " + num + " items\n");
            }
        }));
        getDaijishouLibrary().getAllPlayersCount().observe(getViewLifecycleOwner(), new AboutThisAppNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<Integer, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.AboutThisAppNavFragment.onCreateView.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r6v4, types: [T, java.lang.String] */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                Ref.ObjectRef<String> objectRef2 = objectRef;
                objectRef2.element = new Regex("Players count: \\d+ player\\(s\\)\n").replace(objectRef2.element, "Players count: " + num + " items\n");
            }
        }));
        getDaijishouLibrary().getAllPlayableItemCount().observe(getViewLifecycleOwner(), new AboutThisAppNavFragment$sam$androidx_lifecycle_Observer$0(new Function1<Integer, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.AboutThisAppNavFragment.onCreateView.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r6v4, types: [T, java.lang.String] */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                Ref.ObjectRef<String> objectRef2 = objectRef;
                objectRef2.element = new Regex("Playable items count: \\d+ item\\(s\\)\n").replace(objectRef2.element, "Playable items count: " + num + " items\n");
            }
        }));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.AboutThisAppNavFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AboutThisAppNavFragment.onCreateView$lambda$1(this.f$0, view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.AboutThisAppNavFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AboutThisAppNavFragment.onCreateView$lambda$2(this.f$0, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.AboutThisAppNavFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AboutThisAppNavFragment.onCreateView$lambda$3(this.f$0, objectRef, view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.settings.AboutThisAppNavFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AboutThisAppNavFragment.onCreateView$lambda$4(this.f$0, view);
            }
        });
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
    public static final void onCreateView$lambda$3(final AboutThisAppNavFragment this$0, Ref.ObjectRef detailText, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(detailText, "$detailText");
        AcknowledgementDialogFragment.Companion.newInstance$default(AcknowledgementDialogFragment.Companion, this$0.getString(R.string.more_detail), (String) detailText.element, null, null, this$0.getString(R.string.donation_title), 12, null).setOnNeutralButtonClickedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.AboutThisAppNavFragment$onCreateView$8$1
            

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Constants.donationUri)));
            }
        }).show(this$0.getChildFragmentManager(), AcknowledgementDialogFragment.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$4(AboutThisAppNavFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.goBack = true;
        MainActivity mainActivityRequireActivity = this$0.requireActivity();
        Intrinsics.checkNotNull(mainActivityRequireActivity, "null cannot be cast to non-null type com.magneticchen.daijishou.ui.activities.MainActivity");
        mainActivityRequireActivity.onBackPressedCallback();
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ((ImageView) view.findViewById(R.id.about_this_app_icon)).requestFocus();
    }

    public void onStart() {
        super.onStart();
        final AboutThisAppNavFragment aboutThisAppNavFragment = this;
        final Function0 function0 = null;
        SettingsViewModel settingsViewModelOnStart$lambda$5 = onStart$lambda$5(FragmentViewModelLazyKt.createViewModelLazy(aboutThisAppNavFragment, Reflection.getOrCreateKotlinClass(SettingsViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.AboutThisAppNavFragment$onStart$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return aboutThisAppNavFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.AboutThisAppNavFragment$onStart$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? aboutThisAppNavFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.AboutThisAppNavFragment$onStart$$inlined$activityViewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return aboutThisAppNavFragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        }));
        String str = this.titleString;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleString");
            str = null;
        }
        settingsViewModelOnStart$lambda$5.setTitle(str);
        DaijishouViewModel daijishouViewModelOnStart$lambda$6 = onStart$lambda$6(FragmentViewModelLazyKt.createViewModelLazy(aboutThisAppNavFragment, Reflection.getOrCreateKotlinClass(DaijishouViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.AboutThisAppNavFragment$onStart$$inlined$activityViewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return aboutThisAppNavFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.AboutThisAppNavFragment$onStart$$inlined$activityViewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? aboutThisAppNavFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.AboutThisAppNavFragment$onStart$$inlined$activityViewModels$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return aboutThisAppNavFragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        }));
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
