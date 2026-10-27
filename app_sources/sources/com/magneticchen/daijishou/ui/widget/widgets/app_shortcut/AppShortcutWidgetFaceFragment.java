package com.magneticchen.daijishou.ui.widget.widgets.app_shortcut;

import android.app.Activity;
import android.app.Application;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.data.db.entity.AppShortcutWidgetInstanceEntity;
import com.magneticchen.daijishou.data.db.repositories.DaijishouWidgetRepository;
import com.magneticchen.daijishou.ui.model.AppsViewModel;
import com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetFaceFragment;
import com.magneticchen.daijishou.utils.ScraperUtilsKt;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: AppShortcutWidgetFaceFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 )2\u00020\u0001:\u0001)B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\u0012\u0010\u001f\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J&\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010(\u001a\u00020\u001dH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00140\u00140\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000¨\u0006*²\u0006\n\u0010\u0005\u001a\u00020\u0006X\u008a\u0084\u0002"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/app_shortcut/AppShortcutWidgetFaceFragment;", "Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetFaceFragment;", "()V", "appShortcutWidgetInstanceEntity", "Lcom/magneticchen/daijishou/data/db/entity/AppShortcutWidgetInstanceEntity;", "appsViewModel", "Lcom/magneticchen/daijishou/ui/model/AppsViewModel;", "getAppsViewModel", "()Lcom/magneticchen/daijishou/ui/model/AppsViewModel;", "appsViewModel$delegate", "Lkotlin/Lazy;", "cachedBitmap", "Landroid/graphics/Bitmap;", "imageView", "Landroid/widget/ImageView;", "lastUpdateTimestamp", "", "resolveInfo", "Landroid/content/pm/ResolveInfo;", "resolveInfoStringId", "", "selectImageActivity", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "getSelectImageActivity", "()Landroidx/activity/result/ActivityResultLauncher;", "title", "Landroid/widget/TextView;", "ensureWallpaperDirectory", "", "onClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "updateFace", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppShortcutWidgetFaceFragment extends WidgetFaceFragment {
    public static final Companion Companion = new Companion(null);
    private AppShortcutWidgetInstanceEntity appShortcutWidgetInstanceEntity;
    private final Lazy appsViewModel$delegate;
    private Bitmap cachedBitmap;
    private ImageView imageView;
    private long lastUpdateTimestamp;
    private ResolveInfo resolveInfo;
    private String resolveInfoStringId;
    private final ActivityResultLauncher<String> selectImageActivity;
    private TextView title;

    public AppShortcutWidgetFaceFragment() {
        final AppShortcutWidgetFaceFragment appShortcutWidgetFaceFragment = this;
        final Function0 function0 = null;
        this.appsViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(appShortcutWidgetFaceFragment, Reflection.getOrCreateKotlinClass(AppsViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.app_shortcut.AppShortcutWidgetFaceFragment$special$$inlined$activityViewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return appShortcutWidgetFaceFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.app_shortcut.AppShortcutWidgetFaceFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? appShortcutWidgetFaceFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.app_shortcut.AppShortcutWidgetFaceFragment$special$$inlined$activityViewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return appShortcutWidgetFaceFragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.GetContent(), new ActivityResultCallback() { // from class: com.magneticchen.daijishou.ui.widget.widgets.app_shortcut.AppShortcutWidgetFaceFragment$$ExternalSyntheticLambda0
            public final void onActivityResult(Object obj) {
                AppShortcutWidgetFaceFragment.selectImageActivity$lambda$1(this.f$0, (Uri) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.selectImageActivity = activityResultLauncherRegisterForActivityResult;
    }

    /* JADX INFO: compiled from: AppShortcutWidgetFaceFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widgets/app_shortcut/AppShortcutWidgetFaceFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/ui/widget/widgets/app_shortcut/AppShortcutWidgetFaceFragment;", "widgetInstanceId", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AppShortcutWidgetFaceFragment newInstance(long j) {
            AppShortcutWidgetFaceFragment appShortcutWidgetFaceFragment = new AppShortcutWidgetFaceFragment();
            Bundle bundle = new Bundle();
            bundle.putLong("widgetInstanceId", j);
            appShortcutWidgetFaceFragment.setArguments(bundle);
            return appShortcutWidgetFaceFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppsViewModel getAppsViewModel() {
        return (AppsViewModel) this.appsViewModel$delegate.getValue();
    }

    public final ActivityResultLauncher<String> getSelectImageActivity() {
        return this.selectImageActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void selectImageActivity$lambda$1(AppShortcutWidgetFaceFragment this$0, Uri uri) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        long j = this$0.requireArguments().getLong("widgetInstanceId");
        if (uri == null) {
            return;
        }
        Application application = this$0.requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        DaijishouWidgetRepository daijishouWidgetRepository = ((DaijishouApplication) application).getDaijishouWidgetRepository();
        this$0.ensureWallpaperDirectory();
        AppShortcutWidgetInstanceEntity appShortcutWidgetInstanceByIdStatically = daijishouWidgetRepository.getAppShortcutWidgetInstanceByIdStatically(j);
        if (appShortcutWidgetInstanceByIdStatically != null) {
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(this$0.requireActivity().getContentResolver().openInputStream(uri));
            Intrinsics.checkNotNull(bitmapDecodeStream);
            Bitmap resizedBitmap = ScraperUtilsKt.getResizedBitmap(bitmapDecodeStream, 256);
            Intrinsics.checkNotNull(resizedBitmap);
            String str = this$0.requireContext().getFilesDir() + "/app_shortcut_widget_images/" + j + ".png";
            resizedBitmap.compress(Constants.INSTANCE.getWidgetThumbnailFormat(), 100, new FileOutputStream(str));
            appShortcutWidgetInstanceByIdStatically.setAlternativeImagePath(str);
            daijishouWidgetRepository.updateAppShortcutWidgetInstance(appShortcutWidgetInstanceByIdStatically);
        }
    }

    @Override // com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetFaceFragment
    public void onClick() {
        super.onClick();
        ResolveInfo resolveInfo = this.resolveInfo;
        if (resolveInfo != null) {
            AppsViewModel appsViewModel = getAppsViewModel();
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
            appsViewModel.launchAppByResolveInfo((Activity) fragmentActivityRequireActivity, resolveInfo);
        }
    }

    private final void ensureWallpaperDirectory() {
        File file = new File(requireContext().getFilesDir() + "/app_shortcut_widget_images/");
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateFace() {
        ResolveInfo resolveInfo = this.resolveInfo;
        if (resolveInfo != null) {
            String str = getAppsViewModel().getResolveInfoStringIdToLabelCache().get(getAppsViewModel().resolveInfoToResolveInfoStringId(resolveInfo));
            if (str == null) {
                return;
            }
            Intrinsics.checkNotNull(str);
            TextView textView = this.title;
            ImageView imageView = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("title");
                textView = null;
            }
            textView.setText(str);
            ImageView imageView2 = this.imageView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageView");
            } else {
                imageView = imageView2;
            }
            imageView.setImageBitmap(this.cachedBitmap);
        }
    }

    @Override // com.magneticchen.daijishou.ui.widget.abstract_widget_classes.WidgetFaceFragment, com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Application application = requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        setDaijishouWidgetRepository(((DaijishouApplication) application).getDaijishouWidgetRepository());
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        long j = requireArguments().getLong("widgetInstanceId");
        View viewInflate = inflater.inflate(R.layout.widget_face_app_shortcut, viewGroup, false);
        View viewFindViewById = viewInflate.findViewById(R.id.widget_face_app_shortcut_widget_image_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.imageView = (ImageView) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.widget_face_app_shortcut_widget_title);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.title = (TextView) viewFindViewById2;
        if (this.resolveInfoStringId != null) {
            updateFace();
        }
        getDaijishouWidgetRepository().getAppShortcutWidgetInstanceById(j).observe(getViewLifecycleOwner(), new AppShortcutWidgetFaceFragment$sam$androidx_lifecycle_Observer$0(new Function1<AppShortcutWidgetInstanceEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.app_shortcut.AppShortcutWidgetFaceFragment.onCreateView.2
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AppShortcutWidgetInstanceEntity appShortcutWidgetInstanceEntity) {
                invoke2(appShortcutWidgetInstanceEntity);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AppShortcutWidgetInstanceEntity appShortcutWidgetInstanceEntity) {
                String resolveInfoStringId;
                Date lastUpdateTimestamp;
                AppShortcutWidgetFaceFragment.this.appShortcutWidgetInstanceEntity = appShortcutWidgetInstanceEntity;
                long time = (appShortcutWidgetInstanceEntity == null || (lastUpdateTimestamp = appShortcutWidgetInstanceEntity.getLastUpdateTimestamp()) == null) ? 0L : lastUpdateTimestamp.getTime();
                if (AppShortcutWidgetFaceFragment.this.lastUpdateTimestamp == time) {
                    return;
                }
                AppShortcutWidgetFaceFragment.this.lastUpdateTimestamp = time;
                AppShortcutWidgetFaceFragment.this.resolveInfoStringId = appShortcutWidgetInstanceEntity != null ? appShortcutWidgetInstanceEntity.getResolveInfoStringId() : null;
                if (appShortcutWidgetInstanceEntity != null && (resolveInfoStringId = appShortcutWidgetInstanceEntity.getResolveInfoStringId()) != null) {
                    AppShortcutWidgetFaceFragment appShortcutWidgetFaceFragment = AppShortcutWidgetFaceFragment.this;
                    appShortcutWidgetFaceFragment.resolveInfo = appShortcutWidgetFaceFragment.getAppsViewModel().getResolveInfoStringIdToResolveInfo().get(resolveInfoStringId);
                    appShortcutWidgetFaceFragment.cachedBitmap = appShortcutWidgetFaceFragment.getAppsViewModel().getResolveInfoStringIdToBitmapCache().get(resolveInfoStringId);
                }
                AppShortcutWidgetFaceFragment.this.updateFace();
            }
        }));
        ComponentActivity componentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(componentActivityRequireActivity, "requireActivity(...)");
        final ComponentActivity componentActivity = componentActivityRequireActivity;
        final Function0 function0 = null;
        onCreateView$lambda$5(new ViewModelLazy(Reflection.getOrCreateKotlinClass(AppsViewModel.class), new Function0<ViewModelStore>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.app_shortcut.AppShortcutWidgetFaceFragment$onCreateView$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return componentActivity.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.app_shortcut.AppShortcutWidgetFaceFragment$onCreateView$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return componentActivity.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.app_shortcut.AppShortcutWidgetFaceFragment$onCreateView$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? componentActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        })).getPackageResolveInfoListLiveData().observe(getViewLifecycleOwner(), new AppShortcutWidgetFaceFragment$sam$androidx_lifecycle_Observer$0(new Function1<List<ResolveInfo>, Unit>() { // from class: com.magneticchen.daijishou.ui.widget.widgets.app_shortcut.AppShortcutWidgetFaceFragment.onCreateView.3
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<ResolveInfo> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<ResolveInfo> list) {
                AppShortcutWidgetFaceFragment.this.updateFace();
            }
        }));
        return viewInflate;
    }

    private static final AppsViewModel onCreateView$lambda$5(Lazy<AppsViewModel> lazy) {
        return lazy.getValue();
    }
}
