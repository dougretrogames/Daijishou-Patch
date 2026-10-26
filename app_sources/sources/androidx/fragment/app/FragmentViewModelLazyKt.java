package androidx.fragment.app;

import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* INFO: compiled from: FragmentViewModelLazy.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0010\b\n\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0087\b\u001aC\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0010\b\n\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00062\u0010\b\n\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0087\b\u001aJ\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007\u001aZ\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007\u001aA\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u000e\b\n\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00062\u0010\b\n\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0087\b\u001aS\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u000e\b\n\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00062\u0010\b\n\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00062\u0010\b\n\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0087\b¨\u0006\u0012²\u0006\u0016\u0010\u0013\u001a\u00020\u0011\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003X\u008a\u0084\u0002²\u0006\u0016\u0010\u0013\u001a\u00020\u0011\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003X\u008a\u0084\u0002"}, d2 = {"activityViewModels", "Lkotlin/Lazy;", "VM", "Landroidx/lifecycle/ViewModel;", "Landroidx/fragment/app/Fragment;", "factoryProducer", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "extrasProducer", "Landroidx/lifecycle/viewmodel/CreationExtras;", "createViewModelLazy", "viewModelClass", "Lkotlin/reflect/KClass;", "storeProducer", "Landroidx/lifecycle/ViewModelStore;", "viewModels", "ownerProducer", "Landroidx/lifecycle/ViewModelStoreOwner;", "fragment-ktx_release", "owner"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FragmentViewModelLazyKt {

    /* INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/fragment/app/Fragment;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class C01571 extends Lambda implements Function0<Fragment> {
        final /* synthetic */ Fragment $this_viewModels;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01571(Fragment fragment) {
            super(0);
            this.$this_viewModels = fragment;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Fragment invoke() {
            return this.$this_viewModels;
        }
    }

    public static /* synthetic */ Lazy viewModels$default(Fragment fragment, Function0 function0, Function0 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = new C01571(fragment);
        }
        if ((i & 2) != 0) {
            function1 = null;
        }
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new FragmentViewModelLazyKt$viewModels$owner$2(function0));
        Intrinsics.reifiedOperationMarker(4, "VM");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ViewModel.class);
        C01582 c01582 = new C01582(lazy);
        C01593 c01593 = new C01593(lazy);
        if (function1 == null) {
            function1 = new C01604(fragment, lazy);
        }
        return createViewModelLazy(fragment, orCreateKotlinClass, c01582, c01593, function1);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Superseded by viewModels that takes a CreationExtras producer")
    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> viewModels(Fragment fragment, Function0<? extends ViewModelStoreOwner> function0, Function0<? extends ViewModelProvider.Factory> function1) {
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new FragmentViewModelLazyKt$viewModels$owner$2(function0));
        Intrinsics.reifiedOperationMarker(4, "VM");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ViewModel.class);
        C01582 c01582 = new C01582(lazy);
        C01593 c01593 = new C01593(lazy);
        if (function1 == null) {
            function1 = new C01604(fragment, lazy);
        }
        return createViewModelLazy(fragment, orCreateKotlinClass, c01582, c01593, function1);
    }

    /* INFO: Access modifiers changed from: private */
    /* INFO: renamed from: viewModels$lambda-0, reason: not valid java name */
    public static final ViewModelStoreOwner m3200viewModels$lambda0(Lazy<? extends ViewModelStoreOwner> lazy) {
        return lazy.getValue();
    }

    /* INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$2, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class C01582 extends Lambda implements Function0<ViewModelStore> {
        final /* synthetic */ Lazy<ViewModelStoreOwner> $owner$delegate;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* WARN: Multi-variable type inference failed */
        public C01582(Lazy<? extends ViewModelStoreOwner> lazy) {
            super(0);
            this.$owner$delegate = lazy;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.m3200viewModels$lambda0(this.$owner$delegate).getViewModelStore();
        }
    }

    /* INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$3, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class C01593 extends Lambda implements Function0<CreationExtras> {
        final /* synthetic */ Lazy<ViewModelStoreOwner> $owner$delegate;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* WARN: Multi-variable type inference failed */
        public C01593(Lazy<? extends ViewModelStoreOwner> lazy) {
            super(0);
            this.$owner$delegate = lazy;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CreationExtras invoke() {
            CreationExtras defaultViewModelCreationExtras;
            ViewModelStoreOwner viewModelStoreOwnerM3200viewModels$lambda0 = FragmentViewModelLazyKt.m3200viewModels$lambda0(this.$owner$delegate);
            HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM3200viewModels$lambda0 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM3200viewModels$lambda0 : null;
            return (hasDefaultViewModelProviderFactory == null || (defaultViewModelCreationExtras = hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras()) == null) ? CreationExtras.Empty.INSTANCE : defaultViewModelCreationExtras;
        }
    }

    /* INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$4, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class C01604 extends Lambda implements Function0<ViewModelProvider.Factory> {
        final /* synthetic */ Lazy<ViewModelStoreOwner> $owner$delegate;
        final /* synthetic */ Fragment $this_viewModels;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* WARN: Multi-variable type inference failed */
        public C01604(Fragment fragment, Lazy<? extends ViewModelStoreOwner> lazy) {
            super(0);
            this.$this_viewModels = fragment;
            this.$owner$delegate = lazy;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory;
            ViewModelStoreOwner viewModelStoreOwnerM3200viewModels$lambda0 = FragmentViewModelLazyKt.m3200viewModels$lambda0(this.$owner$delegate);
            HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM3200viewModels$lambda0 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM3200viewModels$lambda0 : null;
            return (hasDefaultViewModelProviderFactory == null || (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory()) == null) ? this.$this_viewModels.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
        }
    }

    /* INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$5, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/fragment/app/Fragment;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class C01615 extends Lambda implements Function0<Fragment> {
        final /* synthetic */ Fragment $this_viewModels;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01615(Fragment fragment) {
            super(0);
            this.$this_viewModels = fragment;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Fragment invoke() {
            return this.$this_viewModels;
        }
    }

    public static /* synthetic */ Lazy viewModels$default(Fragment fragment, Function0 function0, Function0 function1, Function0 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = new C01615(fragment);
        }
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function2 = null;
        }
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new FragmentViewModelLazyKt$viewModels$owner$4(function0));
        Intrinsics.reifiedOperationMarker(4, "VM");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ViewModel.class);
        C01626 c01626 = new C01626(lazy);
        AnonymousClass7 anonymousClass7 = new AnonymousClass7(function1, lazy);
        if (function2 == null) {
            function2 = new AnonymousClass8(fragment, lazy);
        }
        return createViewModelLazy(fragment, orCreateKotlinClass, c01626, anonymousClass7, function2);
    }

    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> viewModels(Fragment fragment, Function0<? extends ViewModelStoreOwner> function0, Function0<? extends CreationExtras> function1, Function0<? extends ViewModelProvider.Factory> function2) {
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new FragmentViewModelLazyKt$viewModels$owner$4(function0));
        Intrinsics.reifiedOperationMarker(4, "VM");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ViewModel.class);
        C01626 c01626 = new C01626(lazy);
        AnonymousClass7 anonymousClass7 = new AnonymousClass7(function1, lazy);
        if (function2 == null) {
            function2 = new AnonymousClass8(fragment, lazy);
        }
        return createViewModelLazy(fragment, orCreateKotlinClass, c01626, anonymousClass7, function2);
    }

    /* INFO: Access modifiers changed from: private */
    /* INFO: renamed from: viewModels$lambda-1, reason: not valid java name */
    public static final ViewModelStoreOwner m3201viewModels$lambda1(Lazy<? extends ViewModelStoreOwner> lazy) {
        return lazy.getValue();
    }

    /* INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$6, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class C01626 extends Lambda implements Function0<ViewModelStore> {
        final /* synthetic */ Lazy<ViewModelStoreOwner> $owner$delegate;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* WARN: Multi-variable type inference failed */
        public C01626(Lazy<? extends ViewModelStoreOwner> lazy) {
            super(0);
            this.$owner$delegate = lazy;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.m3201viewModels$lambda1(this.$owner$delegate).getViewModelStore();
        }
    }

    /* INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$7, reason: invalid class name */
    /* INFO: compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class AnonymousClass7 extends Lambda implements Function0<CreationExtras> {
        final /* synthetic */ Function0<CreationExtras> $extrasProducer;
        final /* synthetic */ Lazy<ViewModelStoreOwner> $owner$delegate;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* WARN: Multi-variable type inference failed */
        public AnonymousClass7(Function0<? extends CreationExtras> function0, Lazy<? extends ViewModelStoreOwner> lazy) {
            super(0);
            this.$extrasProducer = function0;
            this.$owner$delegate = lazy;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CreationExtras invoke() {
            CreationExtras creationExtrasInvoke;
            Function0<CreationExtras> function0 = this.$extrasProducer;
            if (function0 != null && (creationExtrasInvoke = function0.invoke()) != null) {
                return creationExtrasInvoke;
            }
            ViewModelStoreOwner viewModelStoreOwnerM3201viewModels$lambda1 = FragmentViewModelLazyKt.m3201viewModels$lambda1(this.$owner$delegate);
            HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM3201viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM3201viewModels$lambda1 : null;
            return hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
        }
    }

    /* INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$8, reason: invalid class name */
    /* INFO: compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class AnonymousClass8 extends Lambda implements Function0<ViewModelProvider.Factory> {
        final /* synthetic */ Lazy<ViewModelStoreOwner> $owner$delegate;
        final /* synthetic */ Fragment $this_viewModels;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* WARN: Multi-variable type inference failed */
        public AnonymousClass8(Fragment fragment, Lazy<? extends ViewModelStoreOwner> lazy) {
            super(0);
            this.$this_viewModels = fragment;
            this.$owner$delegate = lazy;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory;
            ViewModelStoreOwner viewModelStoreOwnerM3201viewModels$lambda1 = FragmentViewModelLazyKt.m3201viewModels$lambda1(this.$owner$delegate);
            HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM3201viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM3201viewModels$lambda1 : null;
            return (hasDefaultViewModelProviderFactory == null || (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory()) == null) ? this.$this_viewModels.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
        }
    }

    /* INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$1, reason: invalid class name */
    /* INFO: compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class AnonymousClass1 extends Lambda implements Function0<ViewModelStore> {
        final /* synthetic */ Fragment $this_activityViewModels;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelStore invoke() {
            return this.$this_activityViewModels.requireActivity().getViewModelStore();
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Superseded by activityViewModels that takes a CreationExtras producer")
    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> activityViewModels(Fragment fragment, Function0<? extends ViewModelProvider.Factory> function0) {
        Intrinsics.reifiedOperationMarker(4, "VM");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ViewModel.class);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(fragment);
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(fragment);
        if (function0 == null) {
            function0 = new AnonymousClass3(fragment);
        }
        return createViewModelLazy(fragment, orCreateKotlinClass, anonymousClass1, anonymousClass2, function0);
    }

    public static /* synthetic */ Lazy activityViewModels$default(Fragment fragment, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        Intrinsics.reifiedOperationMarker(4, "VM");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ViewModel.class);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(fragment);
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(fragment);
        if (function0 == null) {
            function0 = new AnonymousClass3(fragment);
        }
        return createViewModelLazy(fragment, orCreateKotlinClass, anonymousClass1, anonymousClass2, function0);
    }

    /* INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$2, reason: invalid class name */
    /* INFO: compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class AnonymousClass2 extends Lambda implements Function0<CreationExtras> {
        final /* synthetic */ Fragment $this_activityViewModels;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CreationExtras invoke() {
            return this.$this_activityViewModels.requireActivity().getDefaultViewModelCreationExtras();
        }
    }

    /* INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$3, reason: invalid class name */
    /* INFO: compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class AnonymousClass3 extends Lambda implements Function0<ViewModelProvider.Factory> {
        final /* synthetic */ Fragment $this_activityViewModels;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return this.$this_activityViewModels.requireActivity().getDefaultViewModelProviderFactory();
        }
    }

    /* INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$4, reason: invalid class name */
    /* INFO: compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class AnonymousClass4 extends Lambda implements Function0<ViewModelStore> {
        final /* synthetic */ Fragment $this_activityViewModels;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelStore invoke() {
            return this.$this_activityViewModels.requireActivity().getViewModelStore();
        }
    }

    public static final /* synthetic */ <VM extends ViewModel> Lazy<VM> activityViewModels(Fragment fragment, Function0<? extends CreationExtras> function0, Function0<? extends ViewModelProvider.Factory> function1) {
        Intrinsics.reifiedOperationMarker(4, "VM");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ViewModel.class);
        AnonymousClass4 anonymousClass4 = new AnonymousClass4(fragment);
        AnonymousClass5 anonymousClass5 = new AnonymousClass5(function0, fragment);
        if (function1 == null) {
            function1 = new AnonymousClass6(fragment);
        }
        return createViewModelLazy(fragment, orCreateKotlinClass, anonymousClass4, anonymousClass5, function1);
    }

    public static /* synthetic */ Lazy activityViewModels$default(Fragment fragment, Function0 function0, Function0 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        if ((i & 2) != 0) {
            function1 = null;
        }
        Intrinsics.reifiedOperationMarker(4, "VM");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ViewModel.class);
        AnonymousClass4 anonymousClass4 = new AnonymousClass4(fragment);
        AnonymousClass5 anonymousClass5 = new AnonymousClass5(function0, fragment);
        if (function1 == null) {
            function1 = new AnonymousClass6(fragment);
        }
        return createViewModelLazy(fragment, orCreateKotlinClass, anonymousClass4, anonymousClass5, function1);
    }

    /* INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$5, reason: invalid class name */
    /* INFO: compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class AnonymousClass5 extends Lambda implements Function0<CreationExtras> {
        final /* synthetic */ Function0<CreationExtras> $extrasProducer;
        final /* synthetic */ Fragment $this_activityViewModels;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* WARN: Multi-variable type inference failed */
        public AnonymousClass5(Function0<? extends CreationExtras> function0, Fragment fragment) {
            super(0);
            this.$extrasProducer = function0;
            this.$this_activityViewModels = fragment;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CreationExtras invoke() {
            CreationExtras creationExtrasInvoke;
            Function0<CreationExtras> function0 = this.$extrasProducer;
            return (function0 == null || (creationExtrasInvoke = function0.invoke()) == null) ? this.$this_activityViewModels.requireActivity().getDefaultViewModelCreationExtras() : creationExtrasInvoke;
        }
    }

    /* INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$6, reason: invalid class name */
    /* INFO: compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class AnonymousClass6 extends Lambda implements Function0<ViewModelProvider.Factory> {
        final /* synthetic */ Fragment $this_activityViewModels;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return this.$this_activityViewModels.requireActivity().getDefaultViewModelProviderFactory();
        }
    }

    public static /* synthetic */ Lazy createViewModelLazy$default(Fragment fragment, KClass kClass, Function0 function0, Function0 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        return createViewModelLazy(fragment, kClass, function0, function1);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Superseded by createViewModelLazy that takes a CreationExtras producer")
    public static final /* synthetic */ Lazy createViewModelLazy(Fragment fragment, KClass kClass, Function0 function0, Function0 function1) {
        return createViewModelLazy(fragment, kClass, function0, new C01551(fragment), function1);
    }

    /* INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$createViewModelLazy$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C01551 extends Lambda implements Function0<CreationExtras> {
        final /* synthetic */ Fragment $this_createViewModelLazy;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01551(Fragment fragment) {
            super(0);
            this.$this_createViewModelLazy = fragment;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CreationExtras invoke() {
            return this.$this_createViewModelLazy.getDefaultViewModelCreationExtras();
        }
    }

    /* INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$createViewModelLazy$2, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: FragmentViewModelLazy.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C01562 extends Lambda implements Function0<CreationExtras> {
        final /* synthetic */ Fragment $this_createViewModelLazy;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01562(Fragment fragment) {
            super(0);
            this.$this_createViewModelLazy = fragment;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CreationExtras invoke() {
            return this.$this_createViewModelLazy.getDefaultViewModelCreationExtras();
        }
    }

    public static /* synthetic */ Lazy createViewModelLazy$default(Fragment fragment, KClass kClass, Function0 function0, Function0 function1, Function0 function2, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = new C01562(fragment);
        }
        if ((i & 8) != 0) {
            function2 = null;
        }
        return createViewModelLazy(fragment, kClass, function0, function1, function2);
    }

    public static final <VM extends ViewModel> Lazy<VM> createViewModelLazy(Fragment fragment, KClass<VM> kClass, Function0<? extends ViewModelStore> function0, Function0<? extends CreationExtras> function1, Function0<? extends ViewModelProvider.Factory> function2) {
        if (function2 == null) {
            function2 = new FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1(fragment);
        }
        return new ViewModelLazy(kClass, function0, function2, function1);
    }
}
