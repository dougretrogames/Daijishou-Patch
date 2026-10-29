.class public final Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;
.super Lcom/magneticchen/daijishou/ui/fragments/abstract/PlatformNavFragment;
.source "PlatformLibraryListViewNavFragment.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$Companion;,
        Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nPlatformLibraryListViewNavFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlatformLibraryListViewNavFragment.kt\ncom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,1178:1\n172#2,9:1179\n172#2,9:1188\n327#3,2:1197\n329#3,2:1201\n327#3,4:1203\n255#3,4:1207\n327#3,2:1211\n329#3,2:1215\n1317#4,2:1199\n1317#4,2:1213\n1872#5,3:1217\n1872#5,3:1222\n37#6,2:1220\n*S KotlinDebug\n*F\n+ 1 PlatformLibraryListViewNavFragment.kt\ncom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment\n*L\n120#1:1179,9\n121#1:1188,9\n169#1:1197,2\n169#1:1201,2\n183#1:1203,4\n283#1:1207,4\n901#1:1211,2\n901#1:1215,2\n170#1:1199,2\n902#1:1213,2\n1078#1:1217,3\n1099#1:1222,3\n1073#1:1220,2\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u00e2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000c\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u0000 \u0089\u00012\u00020\u0001:\u0004\u0089\u0001\u008a\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0008\u0010Y\u001a\u00020\u001cH\u0002J\u0010\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020JH\u0002J\u0008\u0010]\u001a\u00020[H\u0002J\u0008\u0010^\u001a\u00020[H\u0002J\u0008\u0010_\u001a\u00020[H\u0002J\u0008\u0010`\u001a\u00020[H\u0002J\u0008\u0010a\u001a\u00020[H\u0002J\u0012\u0010b\u001a\u00020[2\u0008\u0010c\u001a\u0004\u0018\u00010dH\u0016J&\u0010e\u001a\u0004\u0018\u00010f2\u0006\u0010g\u001a\u00020h2\u0008\u0010i\u001a\u0004\u0018\u00010j2\u0008\u0010c\u001a\u0004\u0018\u00010dH\u0017J \u0010k\u001a\u00020\u001c2\u0006\u0010l\u001a\u00020J2\u0006\u0010m\u001a\u00020J2\u0006\u0010n\u001a\u00020oH\u0016J\u0008\u0010p\u001a\u00020[H\u0016J\u0008\u0010q\u001a\u00020[H\u0016J\u0008\u0010r\u001a\u00020[H\u0002J\u0008\u0010s\u001a\u00020[H\u0016J\u0010\u0010t\u001a\u00020[2\u0006\u0010u\u001a\u00020MH\u0002J\u0010\u0010t\u001a\u00020[2\u0006\u0010v\u001a\u00020wH\u0002J,\u0010x\u001a\u00020[2\u000c\u0010y\u001a\u0008\u0012\u0004\u0012\u00020\t0\u000b2\u000c\u0010z\u001a\u0008\u0012\u0004\u0012\u00020\t0\u000b2\u0006\u0010u\u001a\u00020MH\u0002J,\u0010x\u001a\u00020[2\u000c\u0010y\u001a\u0008\u0012\u0004\u0012\u00020\t0\u000b2\u000c\u0010z\u001a\u0008\u0012\u0004\u0012\u00020\t0\u000b2\u0006\u0010v\u001a\u00020wH\u0002J\u0010\u0010{\u001a\u00020[2\u0006\u0010u\u001a\u00020MH\u0002J\u0010\u0010{\u001a\u00020[2\u0006\u0010v\u001a\u00020wH\u0002J\u0018\u0010|\u001a\u00020[2\u0006\u0010}\u001a\u00020M2\u0006\u0010~\u001a\u00020JH\u0002J\u0010\u0010\u007f\u001a\u00020[2\u0006\u0010u\u001a\u00020MH\u0002J\u0010\u0010\u007f\u001a\u00020[2\u0006\u0010v\u001a\u00020wH\u0002J\u0011\u0010\u0080\u0001\u001a\u00020[2\u0006\u0010u\u001a\u00020MH\u0002J\u0019\u0010\u0080\u0001\u001a\u00020[2\u0006\u0010u\u001a\u00020M2\u0006\u0010v\u001a\u00020wH\u0002J\t\u0010\u0081\u0001\u001a\u00020[H\u0002J\t\u0010\u0082\u0001\u001a\u00020[H\u0002J\u0015\u0010\u0083\u0001\u001a\u00020[2\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001H\u0002J\u0015\u0010\u0086\u0001\u001a\u00020[2\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0085\u0001H\u0002J\t\u0010\u0088\u0001\u001a\u00020[H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002\u00a2\u0006\u000c\n\u0004\u0008)\u0010*\u001a\u0004\u0008\'\u0010(R\u000e\u0010+\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002\u00a2\u0006\u000c\n\u0004\u00080\u0010*\u001a\u0004\u0008.\u0010/R\u000e\u00101\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u00105\u001a\u0002068BX\u0082\u0084\u0002\u00a2\u0006\u000c\n\u0004\u00089\u0010*\u001a\u0004\u00087\u00108R\u000e\u0010:\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082.\u00a2\u0006\u0002\n\u0000R\u0012\u0010B\u001a\u00060CR\u00020\u0000X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010G\u001a\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020J0HX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010K\u001a\u0008\u0012\u0004\u0012\u00020M0LX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010P\u001a\u0008\u0012\u0004\u0012\u00020\t0\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u0004\u0018\u00010MX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u008b\u0001"
    }
    d2 = {
        "Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;",
        "Lcom/magneticchen/daijishou/ui/fragments/abstract/PlatformNavFragment;",
        "()V",
        "backgroundGradientImageView",
        "Landroid/widget/ImageView;",
        "backgroundImageView",
        "backgroundSetLayout",
        "Landroidx/constraintlayout/widget/ConstraintLayout;",
        "boxArtAspectRatio",
        "",
        "boxArtAspectRatioList",
        "",
        "chipGroup",
        "Lcom/google/android/material/chip/ChipGroup;",
        "completeButton",
        "Lcom/google/android/material/chip/Chip;",
        "descriptionFormatString",
        "descriptionTextView",
        "Landroid/widget/TextView;",
        "descriptionWithGenresFormatString",
        "detailButton",
        "dimensionRatio",
        "editButton",
        "favoriteButton",
        "focusListener",
        "Landroid/view/View$OnFocusChangeListener;",
        "gridViewButton",
        "hopToNextItemLock",
        "",
        "isCompletedDrawable",
        "Landroid/graphics/drawable/Drawable;",
        "isFavoriteDrawable",
        "isNotCompletedDrawable",
        "isNotFavoriteDrawable",
        "lastHopToNextItemTimeMillis",
        "",
        "lastToggleViewModeTimeMillis",
        "libraryViewModel",
        "Lcom/magneticchen/daijishou/ui/model/LibraryViewModel;",
        "getLibraryViewModel",
        "()Lcom/magneticchen/daijishou/ui/model/LibraryViewModel;",
        "libraryViewModel$delegate",
        "Lkotlin/Lazy;",
        "lockToggleViewMode",
        "model",
        "Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;",
        "getModel",
        "()Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;",
        "model$delegate",
        "newlyButton",
        "noneString",
        "packageManager",
        "Landroid/content/pm/PackageManager;",
        "pinAndPlayWidget",
        "Lcom/magneticchen/daijishou/ui/widget/widgets/pin_and_play/PinAndPlayWidgetBuilder;",
        "getPinAndPlayWidget",
        "()Lcom/magneticchen/daijishou/ui/widget/widgets/pin_and_play/PinAndPlayWidgetBuilder;",
        "pinAndPlayWidget$delegate",
        "pinButton",
        "placeholderImageView",
        "platformEntity",
        "Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;",
        "platformFormatString",
        "platformId",
        "platformLibraryListRecyclerView",
        "Landroidx/recyclerview/widget/RecyclerView;",
        "platformLibraryListRecyclerViewAdapter",
        "Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;",
        "platformString",
        "platformTextView",
        "playButton",
        "playableItemCharacterIndexingHashmap",
        "Ljava/util/SortedMap;",
        "",
        "",
        "playableItemList",
        "",
        "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;",
        "recentButton",
        "screenAspectRatio",
        "screenAspectRatioList",
        "selectedLetterFormatString",
        "selectedPlayableItemEntity",
        "setPreviewToBoxArtString",
        "setPreviewToSnapshotString",
        "setPreviewToTitleString",
        "thumbnailImageView",
        "tipsFormatString",
        "titleTextView",
        "getMergePlayableItemsPreference",
        "hopToNextItemByFirstCharacter",
        "",
        "offset",
        "initChipFocusListener",
        "initCompletedClickListener",
        "initFavoriteClickListener",
        "initOrientationObserver",
        "initTypeface",
        "onCreate",
        "savedInstanceState",
        "Landroid/os/Bundle;",
        "onCreateView",
        "Landroid/view/View;",
        "inflater",
        "Landroid/view/LayoutInflater;",
        "container",
        "Landroid/view/ViewGroup;",
        "onHotKeyPressed",
        "hotkeyCode",
        "keyCode",
        "keyEvent",
        "Landroid/view/KeyEvent;",
        "onKioskMode",
        "onNoneKioskMode",
        "onOrientationChanged",
        "onResume",
        "onUpdateCompletedButton",
        "item",
        "mergedInfo",
        "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;",
        "onUpdateDescription",
        "genres",
        "genresNames",
        "onUpdateFavoriteButton",
        "onUpdatePlayableItemEntity",
        "playableItemEntity",
        "position",
        "onUpdateRecentButton",
        "onUpdateTitle",
        "refreshPinButton",
        "refreshPreview",
        "setBackground",
        "bitmap",
        "Landroid/graphics/Bitmap;",
        "setThumbnail",
        "it",
        "toggleViewMode",
        "Companion",
        "PlatformLibraryListAdapter",
        "app_release"
    }
    k = 0x1
    mv = {
        0x1,
        0x9,
        0x0
    }
    xi = 0x30
.end annotation


# static fields
.field public static final Companion:Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$Companion;

.field private static final typeface:Landroid/graphics/Typeface;


# instance fields
.field private backgroundGradientImageView:Landroid/widget/ImageView;

.field private backgroundImageView:Landroid/widget/ImageView;

.field private backgroundSetLayout:Landroidx/constraintlayout/widget/ConstraintLayout;

.field private boxArtAspectRatio:Ljava/lang/String;

.field private boxArtAspectRatioList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private chipGroup:Lcom/google/android/material/chip/ChipGroup;

.field private completeButton:Lcom/google/android/material/chip/Chip;

.field private descriptionFormatString:Ljava/lang/String;

.field private descriptionTextView:Landroid/widget/TextView;

.field private descriptionWithGenresFormatString:Ljava/lang/String;

.field private detailButton:Lcom/google/android/material/chip/Chip;

.field private dimensionRatio:Ljava/lang/String;

.field private editButton:Lcom/google/android/material/chip/Chip;

.field private favoriteButton:Lcom/google/android/material/chip/Chip;

.field private final focusListener:Landroid/view/View$OnFocusChangeListener;

.field private gridViewButton:Lcom/google/android/material/chip/Chip;

.field private hopToNextItemLock:Z

.field private isCompletedDrawable:Landroid/graphics/drawable/Drawable;

.field private isFavoriteDrawable:Landroid/graphics/drawable/Drawable;

.field private isNotCompletedDrawable:Landroid/graphics/drawable/Drawable;

.field private isNotFavoriteDrawable:Landroid/graphics/drawable/Drawable;

.field private lastHopToNextItemTimeMillis:J

.field private lastToggleViewModeTimeMillis:J

.field private final libraryViewModel$delegate:Lkotlin/Lazy;

.field private lockToggleViewMode:Z

.field private final model$delegate:Lkotlin/Lazy;

.field private newlyButton:Lcom/google/android/material/chip/Chip;

.field private noneString:Ljava/lang/String;

.field private packageManager:Landroid/content/pm/PackageManager;

.field private final pinAndPlayWidget$delegate:Lkotlin/Lazy;

.field private pinButton:Lcom/google/android/material/chip/Chip;

.field private placeholderImageView:Landroid/widget/ImageView;

.field private platformEntity:Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;

.field private platformFormatString:Ljava/lang/String;

.field private platformId:J

.field private platformLibraryListRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

.field private platformLibraryListRecyclerViewAdapter:Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;

.field private platformString:Ljava/lang/String;

.field private platformTextView:Landroid/widget/TextView;

.field private playButton:Lcom/google/android/material/chip/Chip;

.field private final playableItemCharacterIndexingHashmap:Ljava/util/SortedMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/SortedMap<",
            "Ljava/lang/Character;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private final playableItemList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;",
            ">;"
        }
    .end annotation
.end field

.field private recentButton:Lcom/google/android/material/chip/Chip;

.field private screenAspectRatio:Ljava/lang/String;

.field private screenAspectRatioList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private selectedLetterFormatString:Ljava/lang/String;

.field private selectedPlayableItemEntity:Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;

.field private setPreviewToBoxArtString:Ljava/lang/String;

.field private setPreviewToSnapshotString:Ljava/lang/String;

.field private setPreviewToTitleString:Ljava/lang/String;

.field private thumbnailImageView:Landroid/widget/ImageView;

.field private tipsFormatString:Ljava/lang/String;

.field private titleTextView:Landroid/widget/TextView;


# direct methods
.method public static synthetic $r8$lambda$0tvGtrxvwMTb1xurg9r8SToOAcI(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/view/View;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->onCreateView$lambda$23(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$1xCXVOAhCGN0uriGlo6D5qgw6j8(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/view/View;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->onCreateView$lambda$20(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$6kP3ReIomQUyCDtHbQ8pnMY7084(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/view/View;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->onCreateView$lambda$22(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$XcFOPO1xpzj6jN8ocjK0VQj1m3Y(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/content/Context;Landroid/view/View;)V
    .locals 0

    invoke-static {p0, p1, p2}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->onCreateView$lambda$15(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/content/Context;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$l2C9TR7vKylqY6IwJZiOUoD232o(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/view/View;)Z
    .locals 0

    invoke-static {p0, p1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->onCreateView$lambda$17(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/view/View;)Z

    move-result p0

    return p0
.end method

.method public static synthetic $r8$lambda$oWNZWdIgoCgB6uhtynRveBEtuuE(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/view/View;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->onCreateView$lambda$12(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$rcdri3ffYZqU2fiT7x4PfrkTx1Y(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/view/View;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->onCreateView$lambda$19(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$un3x8p8KI89HVgtIHPjaujzWAXU(Landroid/view/View;Z)V
    .locals 0

    invoke-static {p0, p1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->focusListener$lambda$0(Landroid/view/View;Z)V

    return-void
.end method

.method public static synthetic $r8$lambda$wadxBSHiUwy_PCkuBXYaeLxk3tA(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/view/View;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->initFavoriteClickListener$lambda$11(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$wch67_h9rd-Tl4VqEoqXFeBqYPo(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/view/View;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->onCreateView$lambda$25(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$yPQKAfH-SUM-y3UmpY5OGfv9SNU(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/view/View;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->initCompletedClickListener$lambda$9(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/view/View;)V

    return-void
.end method

.method static constructor <clinit>()V
    .locals 3

    new-instance v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$Companion;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    sput-object v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->Companion:Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$Companion;

    .line 91
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x1c

    if-lt v0, v2, :cond_0

    const/16 v0, 0x2ee

    const/4 v2, 0x0

    invoke-static {v1, v0, v2}, Landroid/graphics/Typeface;->create(Landroid/graphics/Typeface;IZ)Landroid/graphics/Typeface;

    move-result-object v0

    goto :goto_0

    :cond_0
    const/4 v0, 0x1

    invoke-static {v0}, Landroid/graphics/Typeface;->defaultFromStyle(I)Landroid/graphics/Typeface;

    move-result-object v0

    :goto_0
    sput-object v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->typeface:Landroid/graphics/Typeface;

    return-void
.end method

.method public constructor <init>()V
    .locals 6

    .line 87
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/fragments/abstract/PlatformNavFragment;-><init>()V

    .line 94
    new-instance v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda1;

    invoke-direct {v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda1;-><init>()V

    iput-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->focusListener:Landroid/view/View$OnFocusChangeListener;

    .line 120
    move-object v0, p0

    check-cast v0, Landroidx/fragment/app/Fragment;

    .line 1182
    const-class v1, Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;

    invoke-static {v1}, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;

    move-result-object v1

    new-instance v2, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$special$$inlined$activityViewModels$default$1;

    invoke-direct {v2, v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$special$$inlined$activityViewModels$default$1;-><init>(Landroidx/fragment/app/Fragment;)V

    check-cast v2, Lkotlin/jvm/functions/Function0;

    new-instance v3, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$special$$inlined$activityViewModels$default$2;

    const/4 v4, 0x0

    invoke-direct {v3, v4, v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$special$$inlined$activityViewModels$default$2;-><init>(Lkotlin/jvm/functions/Function0;Landroidx/fragment/app/Fragment;)V

    check-cast v3, Lkotlin/jvm/functions/Function0;

    new-instance v5, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$special$$inlined$activityViewModels$default$3;

    invoke-direct {v5, v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$special$$inlined$activityViewModels$default$3;-><init>(Landroidx/fragment/app/Fragment;)V

    check-cast v5, Lkotlin/jvm/functions/Function0;

    invoke-static {v0, v1, v2, v3, v5}, Landroidx/fragment/app/FragmentViewModelLazyKt;->createViewModelLazy(Landroidx/fragment/app/Fragment;Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;

    move-result-object v1

    .line 120
    iput-object v1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->model$delegate:Lkotlin/Lazy;

    .line 1191
    const-class v1, Lcom/magneticchen/daijishou/ui/model/LibraryViewModel;

    invoke-static {v1}, Lkotlin/jvm/internal/Reflection;->getOrCreateKotlinClass(Ljava/lang/Class;)Lkotlin/reflect/KClass;

    move-result-object v1

    new-instance v2, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$special$$inlined$activityViewModels$default$4;

    invoke-direct {v2, v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$special$$inlined$activityViewModels$default$4;-><init>(Landroidx/fragment/app/Fragment;)V

    check-cast v2, Lkotlin/jvm/functions/Function0;

    new-instance v3, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$special$$inlined$activityViewModels$default$5;

    invoke-direct {v3, v4, v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$special$$inlined$activityViewModels$default$5;-><init>(Lkotlin/jvm/functions/Function0;Landroidx/fragment/app/Fragment;)V

    check-cast v3, Lkotlin/jvm/functions/Function0;

    new-instance v4, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$special$$inlined$activityViewModels$default$6;

    invoke-direct {v4, v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$special$$inlined$activityViewModels$default$6;-><init>(Landroidx/fragment/app/Fragment;)V

    check-cast v4, Lkotlin/jvm/functions/Function0;

    invoke-static {v0, v1, v2, v3, v4}, Landroidx/fragment/app/FragmentViewModelLazyKt;->createViewModelLazy(Landroidx/fragment/app/Fragment;Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;

    move-result-object v0

    .line 121
    iput-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->libraryViewModel$delegate:Lkotlin/Lazy;

    const-wide/16 v0, -0x1

    .line 144
    iput-wide v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformId:J

    .line 146
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    check-cast v0, Ljava/util/List;

    iput-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->playableItemList:Ljava/util/List;

    .line 148
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->lastHopToNextItemTimeMillis:J

    .line 149
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->lastToggleViewModeTimeMillis:J

    const/4 v0, 0x1

    .line 150
    iput-boolean v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->lockToggleViewMode:Z

    const/4 v0, 0x0

    .line 154
    new-array v0, v0, [Lkotlin/Pair;

    invoke-static {v0}, Lkotlin/collections/MapsKt;->sortedMapOf([Lkotlin/Pair;)Ljava/util/SortedMap;

    move-result-object v0

    iput-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->playableItemCharacterIndexingHashmap:Ljava/util/SortedMap;

    .line 156
    new-instance v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$pinAndPlayWidget$2;

    invoke-direct {v0, p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$pinAndPlayWidget$2;-><init>(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)V

    check-cast v0, Lkotlin/jvm/functions/Function0;

    invoke-static {v0}, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;

    move-result-object v0

    iput-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->pinAndPlayWidget$delegate:Lkotlin/Lazy;

    return-void
.end method

.method public static final synthetic access$getBackgroundGradientImageView$p(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)Landroid/widget/ImageView;
    .locals 0

    .line 87
    iget-object p0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->backgroundGradientImageView:Landroid/widget/ImageView;

    return-object p0
.end method

.method public static final synthetic access$getBackgroundImageView$p(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)Landroid/widget/ImageView;
    .locals 0

    .line 87
    iget-object p0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->backgroundImageView:Landroid/widget/ImageView;

    return-object p0
.end method

.method public static final synthetic access$getBoxArtAspectRatioList$p(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)Ljava/util/List;
    .locals 0

    .line 87
    iget-object p0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->boxArtAspectRatioList:Ljava/util/List;

    return-object p0
.end method

.method public static final synthetic access$getDaijishouLibrary(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;
    .locals 0

    .line 87
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getDaijishouLibrary()Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object p0

    return-object p0
.end method

.method public static final synthetic access$getDefaultSharedPreferences(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)Landroid/content/SharedPreferences;
    .locals 0

    .line 87
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object p0

    return-object p0
.end method

.method public static final synthetic access$getDpToPxConverter(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)Lcom/magneticchen/daijishou/utils/DpToPxConverter;
    .locals 0

    .line 87
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getDpToPxConverter()Lcom/magneticchen/daijishou/utils/DpToPxConverter;

    move-result-object p0

    return-object p0
.end method

.method public static final synthetic access$getLibraryViewModel(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)Lcom/magneticchen/daijishou/ui/model/LibraryViewModel;
    .locals 0

    .line 87
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getLibraryViewModel()Lcom/magneticchen/daijishou/ui/model/LibraryViewModel;

    move-result-object p0

    return-object p0
.end method

.method public static final synthetic access$getLogger(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;
    .locals 0

    .line 87
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getLogger()Lcom/magneticchen/daijishou/DaijishouApplication$WrappedLogger;

    move-result-object p0

    return-object p0
.end method

.method public static final synthetic access$getMergePlayableItemsPreference(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)Z
    .locals 0

    .line 87
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getMergePlayableItemsPreference()Z

    move-result p0

    return p0
.end method

.method public static final synthetic access$getModel(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;
    .locals 0

    .line 87
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getModel()Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;

    move-result-object p0

    return-object p0
.end method

.method public static final synthetic access$getPlatformFormatString$p(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)Ljava/lang/String;
    .locals 0

    .line 87
    iget-object p0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformFormatString:Ljava/lang/String;

    return-object p0
.end method

.method public static final synthetic access$getPlatformId$p(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)J
    .locals 2

    .line 87
    iget-wide v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformId:J

    return-wide v0
.end method

.method public static final synthetic access$getPlatformLibraryListRecyclerViewAdapter$p(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;
    .locals 0

    .line 87
    iget-object p0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformLibraryListRecyclerViewAdapter:Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;

    return-object p0
.end method

.method public static final synthetic access$getScreenAspectRatioList$p(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)Ljava/util/List;
    .locals 0

    .line 87
    iget-object p0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->screenAspectRatioList:Ljava/util/List;

    return-object p0
.end method

.method public static final synthetic access$getSelectedPlayableItemEntity$p(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;
    .locals 0

    .line 87
    iget-object p0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->selectedPlayableItemEntity:Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;

    return-object p0
.end method

.method public static final synthetic access$getThumbnailImageView$p(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)Landroid/widget/ImageView;
    .locals 0

    .line 87
    iget-object p0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->thumbnailImageView:Landroid/widget/ImageView;

    return-object p0
.end method

.method public static final synthetic access$getTitleTextView$p(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)Landroid/widget/TextView;
    .locals 0

    .line 87
    iget-object p0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->titleTextView:Landroid/widget/TextView;

    return-object p0
.end method

.method public static final synthetic access$getWidgetManager(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)Lcom/magneticchen/daijishou/ui/widget/WidgetsManager;
    .locals 0

    .line 87
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getWidgetManager()Lcom/magneticchen/daijishou/ui/widget/WidgetsManager;

    move-result-object p0

    return-object p0
.end method

.method public static final synthetic access$onCreateView$refreshPlayableItems(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/content/SharedPreferences;Ljava/util/List;)V
    .locals 0

    .line 87
    invoke-static {p0, p1, p2}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->onCreateView$refreshPlayableItems(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/content/SharedPreferences;Ljava/util/List;)V

    return-void
.end method

.method public static final synthetic access$onOrientationChanged(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)V
    .locals 0

    .line 87
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->onOrientationChanged()V

    return-void
.end method

.method public static final synthetic access$onUpdatePlayableItemEntity(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;I)V
    .locals 0

    .line 87
    invoke-direct {p0, p1, p2}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->onUpdatePlayableItemEntity(Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;I)V

    return-void
.end method

.method public static final synthetic access$refreshPreview(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)V
    .locals 0

    .line 87
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->refreshPreview()V

    return-void
.end method

.method public static final synthetic access$setBackground(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/graphics/Bitmap;)V
    .locals 0

    .line 87
    invoke-direct {p0, p1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->setBackground(Landroid/graphics/Bitmap;)V

    return-void
.end method

.method public static final synthetic access$setBoxArtAspectRatio$p(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Ljava/lang/String;)V
    .locals 0

    .line 87
    iput-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->boxArtAspectRatio:Ljava/lang/String;

    return-void
.end method

.method public static final synthetic access$setPlatformEntity$p(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;)V
    .locals 0

    .line 87
    iput-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformEntity:Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;

    return-void
.end method

.method public static final synthetic access$setScreenAspectRatio$p(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Ljava/lang/String;)V
    .locals 0

    .line 87
    iput-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->screenAspectRatio:Ljava/lang/String;

    return-void
.end method

.method public static final synthetic access$setThumbnail(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/graphics/Bitmap;)V
    .locals 0

    .line 87
    invoke-direct {p0, p1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->setThumbnail(Landroid/graphics/Bitmap;)V

    return-void
.end method

.method private static final focusListener$lambda$0(Landroid/view/View;Z)V
    .locals 18

    if-eqz p1, :cond_0

    .line 95
    sget-object v0, Lcom/magneticchen/daijishou/utils/Utils;->INSTANCE:Lcom/magneticchen/daijishou/utils/Utils;

    invoke-static/range {p0 .. p0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    const/16 v7, 0x18

    const/4 v8, 0x0

    const/high16 v2, 0x3f800000    # 1.0f

    const v3, 0x3f83d70a    # 1.03f

    const-wide/16 v4, 0x0

    const/4 v6, 0x0

    move-object/from16 v1, p0

    invoke-static/range {v0 .. v8}, Lcom/magneticchen/daijishou/utils/Utils;->scaleView$default(Lcom/magneticchen/daijishou/utils/Utils;Landroid/view/View;FFJZILjava/lang/Object;)V

    return-void

    .line 96
    :cond_0
    sget-object v9, Lcom/magneticchen/daijishou/utils/Utils;->INSTANCE:Lcom/magneticchen/daijishou/utils/Utils;

    invoke-static/range {p0 .. p0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    const/16 v16, 0x18

    const/16 v17, 0x0

    const v11, 0x3f83d70a    # 1.03f

    const/high16 v12, 0x3f800000    # 1.0f

    const-wide/16 v13, 0x0

    const/4 v15, 0x0

    move-object/from16 v10, p0

    invoke-static/range {v9 .. v17}, Lcom/magneticchen/daijishou/utils/Utils;->scaleView$default(Lcom/magneticchen/daijishou/utils/Utils;Landroid/view/View;FFJZILjava/lang/Object;)V

    return-void
.end method

.method private final getLibraryViewModel()Lcom/magneticchen/daijishou/ui/model/LibraryViewModel;
    .locals 1

    .line 121
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->libraryViewModel$delegate:Lkotlin/Lazy;

    invoke-interface {v0}, Lkotlin/Lazy;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/magneticchen/daijishou/ui/model/LibraryViewModel;

    return-object v0
.end method

.method private final getMergePlayableItemsPreference()Z
    .locals 3

    .line 161
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v0

    sget-object v1, Lcom/magneticchen/daijishou/data/BooleanPreference;->MERGE_PLAYABLE_ITEMS:Lcom/magneticchen/daijishou/data/BooleanPreference;

    invoke-virtual {v1}, Lcom/magneticchen/daijishou/data/BooleanPreference;->getKey()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lcom/magneticchen/daijishou/data/BooleanPreference;->MERGE_PLAYABLE_ITEMS:Lcom/magneticchen/daijishou/data/BooleanPreference;

    invoke-virtual {v2}, Lcom/magneticchen/daijishou/data/BooleanPreference;->getDefaultValue()Z

    move-result v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method private final getModel()Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;
    .locals 1

    .line 120
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->model$delegate:Lkotlin/Lazy;

    invoke-interface {v0}, Lkotlin/Lazy;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;

    return-object v0
.end method

.method private final getPinAndPlayWidget()Lcom/magneticchen/daijishou/ui/widget/widgets/pin_and_play/PinAndPlayWidgetBuilder;
    .locals 1

    .line 156
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->pinAndPlayWidget$delegate:Lkotlin/Lazy;

    invoke-interface {v0}, Lkotlin/Lazy;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/magneticchen/daijishou/ui/widget/widgets/pin_and_play/PinAndPlayWidgetBuilder;

    return-object v0
.end method

.method private final hopToNextItemByFirstCharacter(I)V
    .locals 7

    .line 216
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->playableItemList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_7

    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->playableItemCharacterIndexingHashmap:Ljava/util/SortedMap;

    invoke-interface {v0}, Ljava/util/SortedMap;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    goto/16 :goto_2

    .line 217
    :cond_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 218
    iget-boolean v2, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->hopToNextItemLock:Z

    if-nez v2, :cond_7

    iget-wide v2, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->lastHopToNextItemTimeMillis:J

    sub-long v2, v0, v2

    const-wide/16 v4, 0x2d

    cmp-long v2, v2, v4

    if-gez v2, :cond_1

    goto/16 :goto_2

    .line 219
    :cond_1
    iput-wide v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->lastHopToNextItemTimeMillis:J

    const/4 v0, 0x1

    .line 220
    iput-boolean v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->hopToNextItemLock:Z

    .line 221
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->playableItemList:Ljava/util/List;

    iget-object v1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformLibraryListRecyclerViewAdapter:Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;

    const-string v2, "platformLibraryListRecyclerViewAdapter"

    const/4 v3, 0x0

    if-nez v1, :cond_2

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v1, v3

    :cond_2
    invoke-virtual {v1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;->getSelectedPosition()I

    move-result v1

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;

    .line 222
    invoke-virtual {v0}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getName()Ljava/lang/String;

    move-result-object v0

    sget-object v1, Ljava/util/Locale;->ROOT:Ljava/util/Locale;

    invoke-virtual {v0, v1}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "toUpperCase(...)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 223
    iget-object v4, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->playableItemCharacterIndexingHashmap:Ljava/util/SortedMap;

    invoke-interface {v4}, Ljava/util/SortedMap;->keySet()Ljava/util/Set;

    move-result-object v4

    const-string v5, "<get-keys>(...)"

    invoke-static {v4, v5}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v4, Ljava/lang/Iterable;

    invoke-static {v4}, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;

    move-result-object v4

    .line 224
    invoke-static {v0}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v0

    invoke-interface {v4, v0}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v0

    add-int/2addr v0, p1

    .line 225
    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result p1

    rem-int/2addr v0, p1

    xor-int v5, v0, p1

    neg-int v6, v0

    or-int/2addr v6, v0

    and-int/2addr v5, v6

    shr-int/lit8 v5, v5, 0x1f

    and-int/2addr p1, v5

    add-int/2addr v0, p1

    .line 226
    invoke-interface {v4, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/Character;

    .line 227
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->playableItemCharacterIndexingHashmap:Ljava/util/SortedMap;

    invoke-interface {v0, p1}, Ljava/util/SortedMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/Integer;

    if-eqz p1, :cond_3

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result p1

    goto :goto_0

    :cond_3
    move p1, v1

    .line 229
    :goto_0
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformLibraryListRecyclerViewAdapter:Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;

    if-nez v0, :cond_4

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v3

    :cond_4
    invoke-virtual {v0, p1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;->selectPosition(I)V

    .line 230
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformLibraryListRecyclerViewAdapter:Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;

    if-nez v0, :cond_5

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v3

    :cond_5
    invoke-virtual {v0, p1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;->notifyItemChanged(I)V

    .line 231
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformLibraryListRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    if-nez v0, :cond_6

    const-string v0, "platformLibraryListRecyclerView"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_1

    :cond_6
    move-object v3, v0

    :goto_1
    invoke-static {v1, p1}, Ljava/lang/Math;->max(II)I

    move-result p1

    invoke-virtual {v3, p1}, Landroidx/recyclerview/widget/RecyclerView;->scrollToPosition(I)V

    .line 232
    iput-boolean v1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->hopToNextItemLock:Z

    :cond_7
    :goto_2
    return-void
.end method

.method private final initChipFocusListener()V
    .locals 3

    .line 647
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->backgroundSetLayout:Landroidx/constraintlayout/widget/ConstraintLayout;

    const/4 v1, 0x0

    if-nez v0, :cond_0

    const-string v0, "backgroundSetLayout"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_0
    iget-object v2, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->focusListener:Landroid/view/View$OnFocusChangeListener;

    invoke-virtual {v0, v2}, Landroidx/constraintlayout/widget/ConstraintLayout;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 648
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->playButton:Lcom/google/android/material/chip/Chip;

    if-nez v0, :cond_1

    const-string v0, "playButton"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_1
    iget-object v2, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->focusListener:Landroid/view/View$OnFocusChangeListener;

    invoke-virtual {v0, v2}, Lcom/google/android/material/chip/Chip;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 649
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->favoriteButton:Lcom/google/android/material/chip/Chip;

    if-nez v0, :cond_2

    const-string v0, "favoriteButton"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_2
    iget-object v2, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->focusListener:Landroid/view/View$OnFocusChangeListener;

    invoke-virtual {v0, v2}, Lcom/google/android/material/chip/Chip;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 650
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->completeButton:Lcom/google/android/material/chip/Chip;

    if-nez v0, :cond_3

    const-string v0, "completeButton"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_3
    iget-object v2, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->focusListener:Landroid/view/View$OnFocusChangeListener;

    invoke-virtual {v0, v2}, Lcom/google/android/material/chip/Chip;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 651
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->pinButton:Lcom/google/android/material/chip/Chip;

    if-nez v0, :cond_4

    const-string v0, "pinButton"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_4
    iget-object v2, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->focusListener:Landroid/view/View$OnFocusChangeListener;

    invoke-virtual {v0, v2}, Lcom/google/android/material/chip/Chip;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 652
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->recentButton:Lcom/google/android/material/chip/Chip;

    if-nez v0, :cond_5

    const-string v0, "recentButton"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_5
    iget-object v2, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->focusListener:Landroid/view/View$OnFocusChangeListener;

    invoke-virtual {v0, v2}, Lcom/google/android/material/chip/Chip;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 653
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->newlyButton:Lcom/google/android/material/chip/Chip;

    if-nez v0, :cond_6

    const-string v0, "newlyButton"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_6
    iget-object v2, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->focusListener:Landroid/view/View$OnFocusChangeListener;

    invoke-virtual {v0, v2}, Lcom/google/android/material/chip/Chip;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 654
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->detailButton:Lcom/google/android/material/chip/Chip;

    if-nez v0, :cond_7

    const-string v0, "detailButton"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_7
    iget-object v2, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->focusListener:Landroid/view/View$OnFocusChangeListener;

    invoke-virtual {v0, v2}, Lcom/google/android/material/chip/Chip;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 655
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->gridViewButton:Lcom/google/android/material/chip/Chip;

    if-nez v0, :cond_8

    const-string v0, "gridViewButton"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_8
    iget-object v2, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->focusListener:Landroid/view/View$OnFocusChangeListener;

    invoke-virtual {v0, v2}, Lcom/google/android/material/chip/Chip;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 656
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->editButton:Lcom/google/android/material/chip/Chip;

    if-nez v0, :cond_9

    const-string v0, "editButton"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_0

    :cond_9
    move-object v1, v0

    :goto_0
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->focusListener:Landroid/view/View$OnFocusChangeListener;

    invoke-virtual {v1, v0}, Lcom/google/android/material/chip/Chip;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    return-void
.end method

.method private final initCompletedClickListener()V
    .locals 2

    .line 630
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->completeButton:Lcom/google/android/material/chip/Chip;

    if-nez v0, :cond_0

    const-string v0, "completeButton"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 v0, 0x0

    :cond_0
    new-instance v1, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda0;

    invoke-direct {v1, p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda0;-><init>(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)V

    invoke-virtual {v0, v1}, Lcom/google/android/material/chip/Chip;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    return-void
.end method

.method private static final initCompletedClickListener$lambda$9(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/view/View;)V
    .locals 2

    const-string p1, "this$0"

    invoke-static {p0, p1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 631
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->selectedPlayableItemEntity:Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;

    if-eqz p1, :cond_0

    .line 632
    const-string v0, "daijishouLibrary"

    const-string v1, "update is completed"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 633
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getDaijishouLibrary()Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object p0

    invoke-virtual {p0, p1}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->toggleIsPlayableItemCompleted(Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;)Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;

    :cond_0
    return-void
.end method

.method private final initFavoriteClickListener()V
    .locals 2

    .line 639
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->favoriteButton:Lcom/google/android/material/chip/Chip;

    if-nez v0, :cond_0

    const-string v0, "favoriteButton"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 v0, 0x0

    :cond_0
    new-instance v1, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda10;

    invoke-direct {v1, p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda10;-><init>(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)V

    invoke-virtual {v0, v1}, Lcom/google/android/material/chip/Chip;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    return-void
.end method

.method private static final initFavoriteClickListener$lambda$11(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/view/View;)V
    .locals 0

    const-string p1, "this$0"

    invoke-static {p0, p1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 640
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->selectedPlayableItemEntity:Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;

    if-eqz p1, :cond_0

    .line 641
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getDaijishouLibrary()Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object p0

    invoke-virtual {p0, p1}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->toggleIsPlayableItemFavorite(Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;)Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;

    :cond_0
    return-void
.end method

.method private final initOrientationObserver()V
    .locals 3

    .line 1164
    new-instance v0, Lcom/magneticchen/daijishou/ui/observer/OrientationObserver;

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->requireContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "requireContext(...)"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    new-instance v2, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$initOrientationObserver$1;

    invoke-direct {v2, p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$initOrientationObserver$1;-><init>(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)V

    check-cast v2, Lkotlin/jvm/functions/Function1;

    invoke-direct {v0, v1, v2}, Lcom/magneticchen/daijishou/ui/observer/OrientationObserver;-><init>(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V

    .line 1165
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->onOrientationChanged()V

    return-void
.end method

.method private final initTypeface()V
    .locals 4

    .line 616
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->playButton:Lcom/google/android/material/chip/Chip;

    const/4 v1, 0x0

    if-nez v0, :cond_0

    const-string v0, "playButton"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_0
    const/4 v2, 0x3

    invoke-virtual {v0, v1, v2}, Lcom/google/android/material/chip/Chip;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 617
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->favoriteButton:Lcom/google/android/material/chip/Chip;

    if-nez v0, :cond_1

    const-string v0, "favoriteButton"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_1
    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/google/android/material/chip/Chip;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 618
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->pinButton:Lcom/google/android/material/chip/Chip;

    if-nez v0, :cond_2

    const-string v0, "pinButton"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_2
    invoke-virtual {v0, v1, v2}, Lcom/google/android/material/chip/Chip;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 619
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->completeButton:Lcom/google/android/material/chip/Chip;

    const-string v3, "completeButton"

    if-nez v0, :cond_3

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_3
    invoke-virtual {v0, v1, v2}, Lcom/google/android/material/chip/Chip;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 621
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->completeButton:Lcom/google/android/material/chip/Chip;

    if-nez v0, :cond_4

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_4
    sget-object v2, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->typeface:Landroid/graphics/Typeface;

    invoke-virtual {v0, v2}, Lcom/google/android/material/chip/Chip;->setTypeface(Landroid/graphics/Typeface;)V

    .line 622
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->recentButton:Lcom/google/android/material/chip/Chip;

    if-nez v0, :cond_5

    const-string v0, "recentButton"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_5
    invoke-virtual {v0, v2}, Lcom/google/android/material/chip/Chip;->setTypeface(Landroid/graphics/Typeface;)V

    .line 623
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->newlyButton:Lcom/google/android/material/chip/Chip;

    if-nez v0, :cond_6

    const-string v0, "newlyButton"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_6
    invoke-virtual {v0, v2}, Lcom/google/android/material/chip/Chip;->setTypeface(Landroid/graphics/Typeface;)V

    .line 624
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->detailButton:Lcom/google/android/material/chip/Chip;

    if-nez v0, :cond_7

    const-string v0, "detailButton"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_7
    invoke-virtual {v0, v2}, Lcom/google/android/material/chip/Chip;->setTypeface(Landroid/graphics/Typeface;)V

    .line 625
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->gridViewButton:Lcom/google/android/material/chip/Chip;

    if-nez v0, :cond_8

    const-string v0, "gridViewButton"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_8
    invoke-virtual {v0, v2}, Lcom/google/android/material/chip/Chip;->setTypeface(Landroid/graphics/Typeface;)V

    .line 626
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->editButton:Lcom/google/android/material/chip/Chip;

    if-nez v0, :cond_9

    const-string v0, "editButton"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_0

    :cond_9
    move-object v1, v0

    :goto_0
    invoke-virtual {v1, v2}, Lcom/google/android/material/chip/Chip;->setTypeface(Landroid/graphics/Typeface;)V

    return-void
.end method

.method private static final onCreateView$lambda$12(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/view/View;)V
    .locals 4

    const-string p1, "this$0"

    invoke-static {p0, p1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 869
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->selectedPlayableItemEntity:Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;

    const/4 v0, 0x0

    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getName()Ljava/lang/String;

    move-result-object p1

    goto :goto_0

    :cond_0
    move-object p1, v0

    :goto_0
    if-eqz p1, :cond_4

    .line 871
    iget-object v1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->titleTextView:Landroid/widget/TextView;

    const-string v2, "titleTextView"

    if-nez v1, :cond_1

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v1, v0

    :cond_1
    iget-object v3, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->titleTextView:Landroid/widget/TextView;

    if-nez v3, :cond_2

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v3, v0

    :cond_2
    invoke-virtual {v3}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v2

    invoke-static {v2, p1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getDaijishouLibrary()Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object p0

    const/4 v2, 0x0

    const/4 v3, 0x2

    invoke-static {p0, p1, v2, v3, v0}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->prettifyTitle$default(Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;Ljava/lang/String;ZILjava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    check-cast p0, Ljava/lang/CharSequence;

    goto :goto_1

    :cond_3
    move-object p0, p1

    check-cast p0, Ljava/lang/CharSequence;

    :goto_1
    invoke-virtual {v1, p0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    :cond_4
    return-void
.end method

.method private static final onCreateView$lambda$15(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/content/Context;Landroid/view/View;)V
    .locals 4

    const-string p2, "this$0"

    invoke-static {p0, p2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p2, "$context"

    invoke-static {p1, p2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 929
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getLibraryViewModel()Lcom/magneticchen/daijishou/ui/model/LibraryViewModel;

    move-result-object p2

    invoke-virtual {p2}, Lcom/magneticchen/daijishou/ui/model/LibraryViewModel;->togglePreviewAspectRatioMode()I

    move-result p2

    .line 930
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->refreshPreview()V

    const/4 v0, 0x2

    const/4 v1, 0x0

    if-eqz p2, :cond_2

    const/4 v2, 0x1

    if-eq p2, v2, :cond_1

    if-eq p2, v0, :cond_0

    :goto_0
    move-object p2, v1

    goto :goto_1

    .line 945
    :cond_0
    iget-object p2, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->setPreviewToTitleString:Ljava/lang/String;

    if-nez p2, :cond_3

    const-string p2, "setPreviewToTitleString"

    invoke-static {p2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_0

    .line 940
    :cond_1
    iget-object p2, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->setPreviewToSnapshotString:Ljava/lang/String;

    if-nez p2, :cond_3

    const-string p2, "setPreviewToSnapshotString"

    invoke-static {p2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_0

    .line 935
    :cond_2
    iget-object p2, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->setPreviewToBoxArtString:Ljava/lang/String;

    if-nez p2, :cond_3

    const-string p2, "setPreviewToBoxArtString"

    invoke-static {p2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_0

    .line 948
    :cond_3
    :goto_1
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getModel()Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;

    move-result-object p0

    if-nez p2, :cond_4

    const-string v2, "toastMessage"

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v2, v1

    goto :goto_2

    :cond_4
    move-object v2, p2

    :goto_2
    const/4 v3, 0x0

    invoke-static {p0, v2, v3, v0, v1}, Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;->setTips$default(Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;Ljava/lang/String;ZILjava/lang/Object;)V

    .line 949
    check-cast p2, Ljava/lang/CharSequence;

    invoke-static {p1, p2, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object p0

    invoke-virtual {p0}, Landroid/widget/Toast;->show()V

    return-void
.end method

.method private static final onCreateView$lambda$17(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/view/View;)Z
    .locals 1

    const-string p1, "this$0"

    invoke-static {p0, p1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 953
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->selectedPlayableItemEntity:Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;

    if-eqz p1, :cond_0

    .line 954
    sget-object v0, Lcom/magneticchen/daijishou/ui/fragments/dialog/PlayableItemDetailDialogFragment;->Companion:Lcom/magneticchen/daijishou/ui/fragments/dialog/PlayableItemDetailDialogFragment$Companion;

    invoke-virtual {v0, p1}, Lcom/magneticchen/daijishou/ui/fragments/dialog/PlayableItemDetailDialogFragment$Companion;->newInstance(Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;)Lcom/magneticchen/daijishou/ui/fragments/dialog/PlayableItemDetailDialogFragment;

    move-result-object p1

    .line 955
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;

    move-result-object p0

    const-string v0, "playable_item_detail"

    invoke-virtual {p1, p0, v0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/PlayableItemDetailDialogFragment;->show(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V

    :cond_0
    const/4 p0, 0x1

    return p0
.end method

.method private static final onCreateView$lambda$19(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/view/View;)V
    .locals 6

    const-string p1, "this$0"

    invoke-static {p0, p1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 961
    iget-object v2, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->selectedPlayableItemEntity:Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;

    if-eqz v2, :cond_0

    .line 962
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getDaijishouLibrary()Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object v0

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object p0

    const-string p1, "requireActivity(...)"

    invoke-static {p0, p1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    move-object v1, p0

    check-cast v1, Landroid/app/Activity;

    const/4 v4, 0x4

    const/4 v5, 0x0

    const/4 v3, 0x0

    invoke-static/range {v0 .. v5}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->play$default(Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;Landroid/app/Activity;Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;Lkotlin/jvm/functions/Function1;ILjava/lang/Object;)V

    :cond_0
    return-void
.end method

.method private static final onCreateView$lambda$20(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/view/View;)V
    .locals 5

    const-string p1, "this$0"

    invoke-static {p0, p1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 972
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->selectedPlayableItemEntity:Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;

    if-nez p1, :cond_0

    return-void

    .line 973
    :cond_0
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getMergePlayableItemsPreference()Z

    move-result v0

    const-string v1, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity"

    if-eqz v0, :cond_2

    .line 974
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getPinAndPlayWidget()Lcom/magneticchen/daijishou/ui/widget/widgets/pin_and_play/PinAndPlayWidgetBuilder;

    move-result-object v0

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getMergedInfo()Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;->getMergedDisjointSetPrimaryPlayableItemIds()Ljava/util/List;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/magneticchen/daijishou/ui/widget/widgets/pin_and_play/PinAndPlayWidgetBuilder;->isPlayableItemIdsInAPinAndPlayWidget(Ljava/util/List;)Z

    move-result v0

    if-nez v0, :cond_1

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getWidgetManager()Lcom/magneticchen/daijishou/ui/widget/WidgetsManager;

    move-result-object v0

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v2, Landroidx/appcompat/app/AppCompatActivity;

    const-class v1, Lcom/magneticchen/daijishou/ui/widget/widgets/pin_and_play/PinAndPlayWidgetBuilder;

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getId()J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object p1

    new-instance v3, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$onCreateView$6$1;

    invoke-direct {v3, p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$onCreateView$6$1;-><init>(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)V

    check-cast v3, Lkotlin/jvm/functions/Function1;

    invoke-virtual {v0, v2, v1, p1, v3}, Lcom/magneticchen/daijishou/ui/widget/WidgetsManager;->requestWidgetInstanceCreation(Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/Class;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V

    goto :goto_0

    .line 978
    :cond_1
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getWidgetManager()Lcom/magneticchen/daijishou/ui/widget/WidgetsManager;

    move-result-object v0

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v2, Landroidx/appcompat/app/AppCompatActivity;

    const-class v1, Lcom/magneticchen/daijishou/ui/widget/widgets/pin_and_play/PinAndPlayWidgetBuilder;

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getMergedInfo()Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;

    move-result-object p1

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;->getMergedDisjointSetPrimaryPlayableItemIds()Ljava/util/List;

    move-result-object p1

    new-instance v3, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$onCreateView$6$2;

    invoke-direct {v3, p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$onCreateView$6$2;-><init>(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)V

    check-cast v3, Lkotlin/jvm/functions/Function1;

    invoke-virtual {v0, v2, v1, p1, v3}, Lcom/magneticchen/daijishou/ui/widget/WidgetsManager;->requestWidgetInstanceRemoval(Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/Class;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V

    goto :goto_0

    .line 984
    :cond_2
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getPinAndPlayWidget()Lcom/magneticchen/daijishou/ui/widget/widgets/pin_and_play/PinAndPlayWidgetBuilder;

    move-result-object v0

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getId()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/magneticchen/daijishou/ui/widget/widgets/pin_and_play/PinAndPlayWidgetBuilder;->isPlayableItemIdInAPinAndPlayWidget(J)Z

    move-result v0

    if-nez v0, :cond_3

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getWidgetManager()Lcom/magneticchen/daijishou/ui/widget/WidgetsManager;

    move-result-object v0

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v2, Landroidx/appcompat/app/AppCompatActivity;

    const-class v1, Lcom/magneticchen/daijishou/ui/widget/widgets/pin_and_play/PinAndPlayWidgetBuilder;

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getId()J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object p1

    new-instance v3, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$onCreateView$6$3;

    invoke-direct {v3, p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$onCreateView$6$3;-><init>(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)V

    check-cast v3, Lkotlin/jvm/functions/Function1;

    invoke-virtual {v0, v2, v1, p1, v3}, Lcom/magneticchen/daijishou/ui/widget/WidgetsManager;->requestWidgetInstanceCreation(Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/Class;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V

    goto :goto_0

    .line 988
    :cond_3
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getWidgetManager()Lcom/magneticchen/daijishou/ui/widget/WidgetsManager;

    move-result-object v0

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v2, Landroidx/appcompat/app/AppCompatActivity;

    const-class v1, Lcom/magneticchen/daijishou/ui/widget/widgets/pin_and_play/PinAndPlayWidgetBuilder;

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getId()J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object p1

    new-instance v3, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$onCreateView$6$4;

    invoke-direct {v3, p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$onCreateView$6$4;-><init>(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)V

    check-cast v3, Lkotlin/jvm/functions/Function1;

    invoke-virtual {v0, v2, v1, p1, v3}, Lcom/magneticchen/daijishou/ui/widget/WidgetsManager;->requestWidgetInstanceRemoval(Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/Class;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V

    .line 994
    :goto_0
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->refreshPinButton()V

    return-void
.end method

.method private static final onCreateView$lambda$22(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/view/View;)V
    .locals 1

    const-string p1, "this$0"

    invoke-static {p0, p1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 998
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->selectedPlayableItemEntity:Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;

    if-eqz p1, :cond_0

    .line 999
    sget-object v0, Lcom/magneticchen/daijishou/ui/fragments/dialog/PlayableItemDetailDialogFragment;->Companion:Lcom/magneticchen/daijishou/ui/fragments/dialog/PlayableItemDetailDialogFragment$Companion;

    invoke-virtual {v0, p1}, Lcom/magneticchen/daijishou/ui/fragments/dialog/PlayableItemDetailDialogFragment$Companion;->newInstance(Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;)Lcom/magneticchen/daijishou/ui/fragments/dialog/PlayableItemDetailDialogFragment;

    move-result-object p1

    .line 1000
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;

    move-result-object p0

    const-class v0, Lcom/magneticchen/daijishou/ui/fragments/dialog/PlayableItemDetailDialogFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, p0, v0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/PlayableItemDetailDialogFragment;->show(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V

    :cond_0
    return-void
.end method

.method private static final onCreateView$lambda$23(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/view/View;)V
    .locals 0

    const-string p1, "this$0"

    invoke-static {p0, p1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1005
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->toggleViewMode()V

    return-void
.end method

.method private static final onCreateView$lambda$25(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/view/View;)V
    .locals 2

    const-string p1, "this$0"

    invoke-static {p0, p1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1009
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->selectedPlayableItemEntity:Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;

    if-eqz p1, :cond_0

    .line 1010
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getDaijishouLibrary()Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object v0

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object p0

    const-string v1, "requireActivity(...)"

    invoke-static {p0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p0, Landroid/app/Activity;

    invoke-virtual {v0, p0, p1}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->editPlayableItem(Landroid/app/Activity;Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;)V

    :cond_0
    return-void
.end method

.method private static final onCreateView$refreshPlayableItems(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/content/SharedPreferences;Ljava/util/List;)V
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;",
            "Landroid/content/SharedPreferences;",
            "Ljava/util/List<",
            "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;",
            ">;)V"
        }
    .end annotation

    .line 1073
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getMergePlayableItemsPreference()Z

    move-result v0

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getDaijishouLibrary()Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object v0

    check-cast p2, Ljava/util/Collection;

    .line 1221
    new-array v2, v1, [Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;

    invoke-interface {p2, v2}, Ljava/util/Collection;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object p2

    .line 1073
    check-cast p2, [Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;

    array-length v2, p2

    invoke-static {p2, v2}, Ljava/util/Arrays;->copyOf([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object p2

    check-cast p2, [Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;

    invoke-virtual {v0, p2}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->getMergedPlayableItems([Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;)Ljava/util/List;

    move-result-object p2

    .line 1096
    :cond_0
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v0

    iget-object v2, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->playableItemList:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-eq v0, v2, :cond_1

    invoke-static {p0, p2, p1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->onCreateView$refreshPlayableItems$updateAll(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Ljava/util/List;Landroid/content/SharedPreferences;)V

    goto/16 :goto_2

    .line 1097
    :cond_1
    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_2
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_9

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;

    .line 1099
    iget-object v3, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->playableItemList:Ljava/util/List;

    check-cast v3, Ljava/lang/Iterable;

    .line 1223
    invoke-interface {v3}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v3

    const/4 v4, 0x1

    move v5, v1

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_8

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    add-int/lit8 v7, v5, 0x1

    if-gez v5, :cond_3

    invoke-static {}, Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V

    :cond_3
    check-cast v6, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;

    .line 1100
    invoke-virtual {v2}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getId()J

    move-result-wide v8

    invoke-virtual {v6}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getId()J

    move-result-wide v10

    cmp-long v8, v8, v10

    if-nez v8, :cond_7

    .line 1102
    invoke-static {v2, v6}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_6

    .line 1104
    iget-object v4, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->playableItemList:Ljava/util/List;

    invoke-interface {v4, v5, v2}, Ljava/util/List;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 1105
    iget-object v4, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformLibraryListRecyclerViewAdapter:Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;

    const/4 v6, 0x0

    const-string v8, "platformLibraryListRecyclerViewAdapter"

    if-nez v4, :cond_4

    invoke-static {v8}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v4, v6

    :cond_4
    invoke-virtual {v4, v5}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;->notifyItemChanged(I)V

    .line 1106
    iget-object v4, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformLibraryListRecyclerViewAdapter:Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;

    if-nez v4, :cond_5

    invoke-static {v8}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_1

    :cond_5
    move-object v6, v4

    :goto_1
    invoke-virtual {v6}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;->getSelectedPosition()I

    move-result v4

    if-ne v5, v4, :cond_6

    .line 1107
    invoke-direct {p0, v2, v5}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->onUpdatePlayableItemEntity(Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;I)V

    :cond_6
    move v4, v1

    :cond_7
    move v5, v7

    goto :goto_0

    :cond_8
    if-eqz v4, :cond_2

    .line 1113
    invoke-static {p0, p2, p1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->onCreateView$refreshPlayableItems$updateAll(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Ljava/util/List;Landroid/content/SharedPreferences;)V

    .line 1117
    :cond_9
    :goto_2
    iput-boolean v1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->lockToggleViewMode:Z

    return-void
.end method

.method private static final onCreateView$refreshPlayableItems$updateAll(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Ljava/util/List;Landroid/content/SharedPreferences;)V
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;",
            "Ljava/util/List<",
            "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;",
            ">;",
            "Landroid/content/SharedPreferences;",
            ")V"
        }
    .end annotation

    .line 1075
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->playableItemList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 1076
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->playableItemList:Ljava/util/List;

    move-object v1, p1

    check-cast v1, Ljava/util/Collection;

    invoke-interface {v0, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 1078
    move-object v0, p1

    check-cast v0, Ljava/lang/Iterable;

    .line 1218
    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    move-object v4, v1

    move v3, v2

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_6

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    add-int/lit8 v6, v3, 0x1

    if-gez v3, :cond_0

    invoke-static {}, Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V

    :cond_0
    check-cast v5, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;

    .line 1079
    invoke-virtual {v5}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getDisjointSetPrimaryPlayableItemId()Ljava/lang/Long;

    move-result-object v7

    if-eqz v7, :cond_2

    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getMergePlayableItemsPreference()Z

    move-result v7

    if-nez v7, :cond_1

    goto :goto_1

    :cond_1
    invoke-virtual {v5}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getMergedInfo()Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;

    move-result-object v5

    invoke-virtual {v5}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;->getMergedName()Ljava/lang/String;

    move-result-object v5

    goto :goto_2

    :cond_2
    :goto_1
    invoke-virtual {v5}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getName()Ljava/lang/String;

    move-result-object v5

    .line 1080
    :goto_2
    move-object v7, v5

    check-cast v7, Ljava/lang/CharSequence;

    invoke-interface {v7}, Ljava/lang/CharSequence;->length()I

    move-result v7

    if-nez v7, :cond_3

    goto :goto_4

    .line 1081
    :cond_3
    sget-object v7, Ljava/util/Locale;->ROOT:Ljava/util/Locale;

    invoke-virtual {v5, v7}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v5

    const-string v7, "toUpperCase(...)"

    invoke-static {v5, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v5, v2}, Ljava/lang/String;->charAt(I)C

    move-result v5

    if-nez v4, :cond_4

    goto :goto_3

    .line 1082
    :cond_4
    invoke-virtual {v4}, Ljava/lang/Character;->charValue()C

    move-result v7

    if-eq v7, v5, :cond_5

    .line 1083
    :goto_3
    invoke-static {v5}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v4

    invoke-static {v5}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v5

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    .line 1084
    iget-object v7, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->playableItemCharacterIndexingHashmap:Ljava/util/SortedMap;

    check-cast v7, Ljava/util/Map;

    invoke-interface {v7, v5, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_5
    :goto_4
    move v3, v6

    goto :goto_0

    .line 1087
    :cond_6
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformLibraryListRecyclerViewAdapter:Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;

    const-string v3, "platformLibraryListRecyclerViewAdapter"

    if-nez v0, :cond_7

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_7
    invoke-virtual {v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;->notifyDataSetChanged()V

    .line 1088
    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_8

    return-void

    .line 1091
    :cond_8
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result p1

    add-int/lit8 p1, p1, -0x1

    iget-wide v4, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformId:J

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, "_selected_position"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p2, v0, v2}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result p2

    invoke-static {p1, p2}, Ljava/lang/Math;->min(II)I

    move-result p1

    .line 1092
    iget-object p2, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformLibraryListRecyclerViewAdapter:Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;

    if-nez p2, :cond_9

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object p2, v1

    :cond_9
    invoke-virtual {p2, p1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;->selectPosition(I)V

    .line 1093
    iget-object p2, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformLibraryListRecyclerViewAdapter:Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;

    if-nez p2, :cond_a

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object p2, v1

    :cond_a
    invoke-virtual {p2, p1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;->notifyItemChanged(I)V

    .line 1094
    iget-object p0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformLibraryListRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    if-nez p0, :cond_b

    const-string p0, "platformLibraryListRecyclerView"

    invoke-static {p0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_5

    :cond_b
    move-object v1, p0

    :goto_5
    add-int/lit8 p1, p1, -0x3

    invoke-static {v2, p1}, Ljava/lang/Math;->max(II)I

    move-result p0

    invoke-virtual {v1, p0}, Landroidx/recyclerview/widget/RecyclerView;->scrollToPosition(I)V

    return-void
.end method

.method private final onOrientationChanged()V
    .locals 2

    .line 1169
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    iget v0, v0, Landroid/content/res/Configuration;->orientation:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    .line 1170
    :goto_0
    move-object v0, p0

    check-cast v0, Landroidx/fragment/app/Fragment;

    invoke-static {v0}, Landroidx/navigation/fragment/FragmentKt;->findNavController(Landroidx/fragment/app/Fragment;)Landroidx/navigation/NavController;

    move-result-object v0

    if-eqz v1, :cond_1

    const v1, 0x7f0a033c

    .line 1173
    invoke-virtual {v0, v1}, Landroidx/navigation/NavController;->navigate(I)V

    :cond_1
    return-void
.end method

.method private final onUpdateCompletedButton(Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;)V
    .locals 3

    .line 591
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->isCompleted()Z

    move-result v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "update is completed button: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "daijishouLibrary"

    invoke-static {v1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 593
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->isCompleted()Z

    move-result p1

    const-string v0, "completeButton"

    const/4 v1, 0x0

    if-eqz p1, :cond_3

    .line 594
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->completeButton:Lcom/google/android/material/chip/Chip;

    if-nez p1, :cond_0

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object p1, v1

    :cond_0
    iget-object v2, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->isCompletedDrawable:Landroid/graphics/drawable/Drawable;

    if-nez v2, :cond_1

    const-string v2, "isCompletedDrawable"

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v2, v1

    :cond_1
    invoke-virtual {p1, v2}, Lcom/google/android/material/chip/Chip;->setChipIcon(Landroid/graphics/drawable/Drawable;)V

    .line 595
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->completeButton:Lcom/google/android/material/chip/Chip;

    if-nez p1, :cond_2

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_0

    :cond_2
    move-object v1, p1

    :goto_0
    const p1, 0x7f1401e5

    invoke-virtual {p0, p1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getString(I)Ljava/lang/String;

    move-result-object p1

    check-cast p1, Ljava/lang/CharSequence;

    invoke-virtual {v1, p1}, Lcom/google/android/material/chip/Chip;->setText(Ljava/lang/CharSequence;)V

    return-void

    .line 597
    :cond_3
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->completeButton:Lcom/google/android/material/chip/Chip;

    if-nez p1, :cond_4

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object p1, v1

    :cond_4
    iget-object v2, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->isNotCompletedDrawable:Landroid/graphics/drawable/Drawable;

    if-nez v2, :cond_5

    const-string v2, "isNotCompletedDrawable"

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v2, v1

    :cond_5
    invoke-virtual {p1, v2}, Lcom/google/android/material/chip/Chip;->setChipIcon(Landroid/graphics/drawable/Drawable;)V

    .line 598
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->completeButton:Lcom/google/android/material/chip/Chip;

    if-nez p1, :cond_6

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_1

    :cond_6
    move-object v1, p1

    :goto_1
    const p1, 0x7f140249

    invoke-virtual {p0, p1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getString(I)Ljava/lang/String;

    move-result-object p1

    check-cast p1, Ljava/lang/CharSequence;

    invoke-virtual {v1, p1}, Lcom/google/android/material/chip/Chip;->setText(Ljava/lang/CharSequence;)V

    return-void
.end method

.method private final onUpdateCompletedButton(Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;)V
    .locals 3

    .line 604
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;->getMergedIsCompleted()Z

    move-result v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "update is completed button: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "daijishouLibrary"

    invoke-static {v1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 606
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;->getMergedIsCompleted()Z

    move-result p1

    const-string v0, "completeButton"

    const/4 v1, 0x0

    if-eqz p1, :cond_3

    .line 607
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->completeButton:Lcom/google/android/material/chip/Chip;

    if-nez p1, :cond_0

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object p1, v1

    :cond_0
    iget-object v2, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->isCompletedDrawable:Landroid/graphics/drawable/Drawable;

    if-nez v2, :cond_1

    const-string v2, "isCompletedDrawable"

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v2, v1

    :cond_1
    invoke-virtual {p1, v2}, Lcom/google/android/material/chip/Chip;->setChipIcon(Landroid/graphics/drawable/Drawable;)V

    .line 608
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->completeButton:Lcom/google/android/material/chip/Chip;

    if-nez p1, :cond_2

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_0

    :cond_2
    move-object v1, p1

    :goto_0
    const p1, 0x7f1401e5

    invoke-virtual {p0, p1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getString(I)Ljava/lang/String;

    move-result-object p1

    check-cast p1, Ljava/lang/CharSequence;

    invoke-virtual {v1, p1}, Lcom/google/android/material/chip/Chip;->setText(Ljava/lang/CharSequence;)V

    return-void

    .line 610
    :cond_3
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->completeButton:Lcom/google/android/material/chip/Chip;

    if-nez p1, :cond_4

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object p1, v1

    :cond_4
    iget-object v2, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->isNotCompletedDrawable:Landroid/graphics/drawable/Drawable;

    if-nez v2, :cond_5

    const-string v2, "isNotCompletedDrawable"

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v2, v1

    :cond_5
    invoke-virtual {p1, v2}, Lcom/google/android/material/chip/Chip;->setChipIcon(Landroid/graphics/drawable/Drawable;)V

    .line 611
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->completeButton:Lcom/google/android/material/chip/Chip;

    if-nez p1, :cond_6

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_1

    :cond_6
    move-object v1, p1

    :goto_1
    const p1, 0x7f140249

    invoke-virtual {p0, p1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getString(I)Ljava/lang/String;

    move-result-object p1

    check-cast p1, Ljava/lang/CharSequence;

    invoke-virtual {v1, p1}, Lcom/google/android/material/chip/Chip;->setText(Ljava/lang/CharSequence;)V

    return-void
.end method

.method private final onUpdateDescription(Ljava/util/List;Ljava/util/List;Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;)V
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;",
            ")V"
        }
    .end annotation

    .line 515
    invoke-virtual {p3}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getLastPlayedTimestamp()Ljava/util/Date;

    move-result-object v0

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    .line 516
    sget-object v0, Lcom/magneticchen/daijishou/utils/Utils;->INSTANCE:Lcom/magneticchen/daijishou/utils/Utils;

    invoke-virtual {p3}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getLastPlayedTimestamp()Ljava/util/Date;

    move-result-object v2

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-virtual {v2}, Ljava/util/Date;->getTime()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/magneticchen/daijishou/utils/Utils;->getRelativeTimeString(J)Ljava/lang/String;

    move-result-object v0

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v2

    const-string v3, "getDefault(...)"

    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-static {v0, v2}, Lkotlin/text/StringsKt;->decapitalize(Ljava/lang/String;Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 518
    :cond_0
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->noneString:Ljava/lang/String;

    if-nez v0, :cond_1

    const-string v0, "noneString"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    .line 521
    :cond_1
    :goto_0
    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    move-result p1

    const-string v2, "format(...)"

    const-string v3, "descriptionTextView"

    if-eqz p1, :cond_4

    .line 522
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->descriptionTextView:Landroid/widget/TextView;

    if-nez p1, :cond_2

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object p1, v1

    :cond_2
    sget-object p2, Lkotlin/jvm/internal/StringCompanionObject;->INSTANCE:Lkotlin/jvm/internal/StringCompanionObject;

    .line 523
    iget-object p2, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->descriptionFormatString:Ljava/lang/String;

    if-nez p2, :cond_3

    const-string p2, "descriptionFormatString"

    invoke-static {p2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_1

    :cond_3
    move-object v1, p2

    .line 525
    :goto_1
    invoke-virtual {p3}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getPlayCount()I

    move-result p2

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    filled-new-array {v0, p2}, [Ljava/lang/Object;

    move-result-object p2

    const/4 p3, 0x2

    .line 522
    invoke-static {p2, p3}, Ljava/util/Arrays;->copyOf([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object p2

    invoke-static {v1, p2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p2

    invoke-static {p2, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p2, Ljava/lang/CharSequence;

    invoke-virtual {p1, p2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    return-void

    .line 528
    :cond_4
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->descriptionTextView:Landroid/widget/TextView;

    if-nez p1, :cond_5

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object p1, v1

    :cond_5
    sget-object v3, Lkotlin/jvm/internal/StringCompanionObject;->INSTANCE:Lkotlin/jvm/internal/StringCompanionObject;

    .line 529
    iget-object v3, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->descriptionWithGenresFormatString:Ljava/lang/String;

    if-nez v3, :cond_6

    const-string v3, "descriptionWithGenresFormatString"

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_2

    :cond_6
    move-object v1, v3

    .line 530
    :goto_2
    move-object v3, p2

    check-cast v3, Ljava/lang/Iterable;

    const-string p2, ", "

    move-object v4, p2

    check-cast v4, Ljava/lang/CharSequence;

    const/16 v10, 0x3e

    const/4 v11, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    invoke-static/range {v3 .. v11}, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;ILjava/lang/Object;)Ljava/lang/String;

    move-result-object p2

    .line 532
    invoke-virtual {p3}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getPlayCount()I

    move-result p3

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p3

    filled-new-array {p2, v0, p3}, [Ljava/lang/Object;

    move-result-object p2

    const/4 p3, 0x3

    .line 528
    invoke-static {p2, p3}, Ljava/util/Arrays;->copyOf([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object p2

    invoke-static {v1, p2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p2

    invoke-static {p2, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p2, Ljava/lang/CharSequence;

    invoke-virtual {p1, p2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    return-void
.end method

.method private final onUpdateDescription(Ljava/util/List;Ljava/util/List;Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;)V
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;",
            ")V"
        }
    .end annotation

    .line 491
    invoke-virtual {p3}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;->getMergedLastPlayedTimestamp()Ljava/util/Date;

    move-result-object v0

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    .line 492
    sget-object v0, Lcom/magneticchen/daijishou/utils/Utils;->INSTANCE:Lcom/magneticchen/daijishou/utils/Utils;

    invoke-virtual {p3}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;->getMergedLastPlayedTimestamp()Ljava/util/Date;

    move-result-object v2

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-virtual {v2}, Ljava/util/Date;->getTime()J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lcom/magneticchen/daijishou/utils/Utils;->getRelativeTimeString(J)Ljava/lang/String;

    move-result-object v0

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v2

    const-string v3, "getDefault(...)"

    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-static {v0, v2}, Lkotlin/text/StringsKt;->decapitalize(Ljava/lang/String;Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 494
    :cond_0
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->noneString:Ljava/lang/String;

    if-nez v0, :cond_1

    const-string v0, "noneString"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    .line 497
    :cond_1
    :goto_0
    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    move-result p1

    const-string v2, "format(...)"

    const-string v3, "descriptionTextView"

    if-eqz p1, :cond_4

    .line 498
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->descriptionTextView:Landroid/widget/TextView;

    if-nez p1, :cond_2

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object p1, v1

    :cond_2
    sget-object p2, Lkotlin/jvm/internal/StringCompanionObject;->INSTANCE:Lkotlin/jvm/internal/StringCompanionObject;

    .line 499
    iget-object p2, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->descriptionFormatString:Ljava/lang/String;

    if-nez p2, :cond_3

    const-string p2, "descriptionFormatString"

    invoke-static {p2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_1

    :cond_3
    move-object v1, p2

    .line 501
    :goto_1
    invoke-virtual {p3}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;->getMergedPlayedCount()I

    move-result p2

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    filled-new-array {v0, p2}, [Ljava/lang/Object;

    move-result-object p2

    const/4 p3, 0x2

    .line 498
    invoke-static {p2, p3}, Ljava/util/Arrays;->copyOf([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object p2

    invoke-static {v1, p2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p2

    invoke-static {p2, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p2, Ljava/lang/CharSequence;

    invoke-virtual {p1, p2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    return-void

    .line 504
    :cond_4
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->descriptionTextView:Landroid/widget/TextView;

    if-nez p1, :cond_5

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object p1, v1

    :cond_5
    sget-object v3, Lkotlin/jvm/internal/StringCompanionObject;->INSTANCE:Lkotlin/jvm/internal/StringCompanionObject;

    .line 505
    iget-object v3, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->descriptionWithGenresFormatString:Ljava/lang/String;

    if-nez v3, :cond_6

    const-string v3, "descriptionWithGenresFormatString"

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_2

    :cond_6
    move-object v1, v3

    .line 506
    :goto_2
    move-object v3, p2

    check-cast v3, Ljava/lang/Iterable;

    const-string p2, ", "

    move-object v4, p2

    check-cast v4, Ljava/lang/CharSequence;

    const/16 v10, 0x3e

    const/4 v11, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    invoke-static/range {v3 .. v11}, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;ILjava/lang/Object;)Ljava/lang/String;

    move-result-object p2

    .line 508
    invoke-virtual {p3}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;->getMergedPlayedCount()I

    move-result p3

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p3

    filled-new-array {p2, v0, p3}, [Ljava/lang/Object;

    move-result-object p2

    const/4 p3, 0x3

    .line 504
    invoke-static {p2, p3}, Ljava/util/Arrays;->copyOf([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object p2

    invoke-static {v1, p2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p2

    invoke-static {p2, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p2, Ljava/lang/CharSequence;

    invoke-virtual {p1, p2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    return-void
.end method

.method private final onUpdateFavoriteButton(Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;)V
    .locals 3

    .line 569
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->isFavorite()Z

    move-result p1

    const-string v0, "favoriteButton"

    const/4 v1, 0x0

    if-eqz p1, :cond_3

    .line 570
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->favoriteButton:Lcom/google/android/material/chip/Chip;

    if-nez p1, :cond_0

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object p1, v1

    :cond_0
    iget-object v2, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->isFavoriteDrawable:Landroid/graphics/drawable/Drawable;

    if-nez v2, :cond_1

    const-string v2, "isFavoriteDrawable"

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v2, v1

    :cond_1
    invoke-virtual {p1, v2}, Lcom/google/android/material/chip/Chip;->setChipIcon(Landroid/graphics/drawable/Drawable;)V

    .line 571
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->favoriteButton:Lcom/google/android/material/chip/Chip;

    if-nez p1, :cond_2

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_0

    :cond_2
    move-object v1, p1

    :goto_0
    const p1, 0x7f1401e6

    invoke-virtual {p0, p1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getString(I)Ljava/lang/String;

    move-result-object p1

    check-cast p1, Ljava/lang/CharSequence;

    invoke-virtual {v1, p1}, Lcom/google/android/material/chip/Chip;->setText(Ljava/lang/CharSequence;)V

    return-void

    .line 573
    :cond_3
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->favoriteButton:Lcom/google/android/material/chip/Chip;

    if-nez p1, :cond_4

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object p1, v1

    :cond_4
    iget-object v2, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->isNotFavoriteDrawable:Landroid/graphics/drawable/Drawable;

    if-nez v2, :cond_5

    const-string v2, "isNotFavoriteDrawable"

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v2, v1

    :cond_5
    invoke-virtual {p1, v2}, Lcom/google/android/material/chip/Chip;->setChipIcon(Landroid/graphics/drawable/Drawable;)V

    .line 574
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->favoriteButton:Lcom/google/android/material/chip/Chip;

    if-nez p1, :cond_6

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_1

    :cond_6
    move-object v1, p1

    :goto_1
    const p1, 0x7f140042

    invoke-virtual {p0, p1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getString(I)Ljava/lang/String;

    move-result-object p1

    check-cast p1, Ljava/lang/CharSequence;

    invoke-virtual {v1, p1}, Lcom/google/android/material/chip/Chip;->setText(Ljava/lang/CharSequence;)V

    return-void
.end method

.method private final onUpdateFavoriteButton(Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;)V
    .locals 3

    .line 580
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;->getMergedIsFavorite()Z

    move-result p1

    const-string v0, "favoriteButton"

    const/4 v1, 0x0

    if-eqz p1, :cond_3

    .line 581
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->favoriteButton:Lcom/google/android/material/chip/Chip;

    if-nez p1, :cond_0

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object p1, v1

    :cond_0
    iget-object v2, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->isFavoriteDrawable:Landroid/graphics/drawable/Drawable;

    if-nez v2, :cond_1

    const-string v2, "isFavoriteDrawable"

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v2, v1

    :cond_1
    invoke-virtual {p1, v2}, Lcom/google/android/material/chip/Chip;->setChipIcon(Landroid/graphics/drawable/Drawable;)V

    .line 582
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->favoriteButton:Lcom/google/android/material/chip/Chip;

    if-nez p1, :cond_2

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_0

    :cond_2
    move-object v1, p1

    :goto_0
    const p1, 0x7f1401e6

    invoke-virtual {p0, p1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getString(I)Ljava/lang/String;

    move-result-object p1

    check-cast p1, Ljava/lang/CharSequence;

    invoke-virtual {v1, p1}, Lcom/google/android/material/chip/Chip;->setText(Ljava/lang/CharSequence;)V

    return-void

    .line 584
    :cond_3
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->favoriteButton:Lcom/google/android/material/chip/Chip;

    if-nez p1, :cond_4

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object p1, v1

    :cond_4
    iget-object v2, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->isNotFavoriteDrawable:Landroid/graphics/drawable/Drawable;

    if-nez v2, :cond_5

    const-string v2, "isNotFavoriteDrawable"

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v2, v1

    :cond_5
    invoke-virtual {p1, v2}, Lcom/google/android/material/chip/Chip;->setChipIcon(Landroid/graphics/drawable/Drawable;)V

    .line 585
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->favoriteButton:Lcom/google/android/material/chip/Chip;

    if-nez p1, :cond_6

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_1

    :cond_6
    move-object v1, p1

    :goto_1
    const p1, 0x7f140042

    invoke-virtual {p0, p1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getString(I)Ljava/lang/String;

    move-result-object p1

    check-cast p1, Ljava/lang/CharSequence;

    invoke-virtual {v1, p1}, Lcom/google/android/material/chip/Chip;->setText(Ljava/lang/CharSequence;)V

    return-void
.end method

.method private final onUpdatePlayableItemEntity(Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;I)V
    .locals 6

    .line 420
    iput-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->selectedPlayableItemEntity:Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;

    .line 421
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->titleTextView:Landroid/widget/TextView;

    const/4 v1, 0x0

    if-nez v0, :cond_0

    const-string v0, "titleTextView"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_0
    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setSelected(Z)V

    .line 422
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->descriptionTextView:Landroid/widget/TextView;

    if-nez v0, :cond_1

    const-string v0, "descriptionTextView"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_1
    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setSelected(Z)V

    .line 424
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getModel()Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;

    move-result-object v0

    sget-object v3, Lkotlin/jvm/internal/StringCompanionObject;->INSTANCE:Lkotlin/jvm/internal/StringCompanionObject;

    iget-object v3, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->tipsFormatString:Ljava/lang/String;

    if-nez v3, :cond_2

    const-string v3, "tipsFormatString"

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v3, v1

    :cond_2
    iget-object v4, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformEntity:Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;

    if-eqz v4, :cond_3

    invoke-virtual {v4}, Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;->getShortname()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_3

    sget-object v5, Ljava/util/Locale;->ROOT:Ljava/util/Locale;

    invoke-virtual {v4, v5}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "toUpperCase(...)"

    invoke-static {v4, v5}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    goto :goto_0

    :cond_3
    move-object v4, v1

    :goto_0
    add-int/2addr p2, v2

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    iget-object v2, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformLibraryListRecyclerViewAdapter:Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;

    if-nez v2, :cond_4

    const-string v2, "platformLibraryListRecyclerViewAdapter"

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v2, v1

    :cond_4
    invoke-virtual {v2}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;->getItemCount()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    filled-new-array {v4, p2, v2}, [Ljava/lang/Object;

    move-result-object p2

    const/4 v2, 0x3

    invoke-static {p2, v2}, Ljava/util/Arrays;->copyOf([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object p2

    invoke-static {v3, p2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p2

    const-string v2, "format(...)"

    invoke-static {p2, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v2, 0x2

    const/4 v3, 0x0

    invoke-static {v0, p2, v3, v2, v1}, Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;->setTips$default(Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;Ljava/lang/String;ZILjava/lang/Object;)V

    .line 426
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getDaijishouLibrary()Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object p2

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getId()J

    move-result-wide v4

    invoke-virtual {p2, v4, v5}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->getGenreIdsByPlayableItemIdStatically(J)Ljava/util/List;

    move-result-object p2

    .line 427
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v0

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2, v0}, Ljava/util/ArrayList;-><init>(I)V

    :goto_1
    if-ge v3, v0, :cond_6

    .line 428
    sget-object v4, Lcom/magneticchen/daijishou/data/Genres;->INSTANCE:Lcom/magneticchen/daijishou/data/Genres;

    invoke-virtual {v4}, Lcom/magneticchen/daijishou/data/Genres;->getGenres()Ljava/util/HashMap;

    move-result-object v4

    invoke-interface {p2, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/magneticchen/daijishou/data/Genre;

    if-eqz v4, :cond_5

    invoke-virtual {v4}, Lcom/magneticchen/daijishou/data/Genre;->getNameStringId()I

    move-result v4

    goto :goto_2

    :cond_5
    const v4, 0x7f14041e

    :goto_2
    invoke-virtual {p0, v4}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 427
    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    :cond_6
    check-cast v2, Ljava/util/List;

    .line 431
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getMergePlayableItemsPreference()Z

    move-result v0

    if-eqz v0, :cond_7

    .line 432
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getMergedInfo()Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->onUpdateTitle(Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;)V

    .line 433
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getMergedInfo()Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;

    move-result-object v0

    invoke-direct {p0, p2, v2, v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->onUpdateDescription(Ljava/util/List;Ljava/util/List;Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;)V

    .line 434
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getMergedInfo()Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;

    move-result-object p2

    invoke-direct {p0, p2}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->onUpdateFavoriteButton(Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;)V

    .line 435
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getMergedInfo()Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;

    move-result-object p2

    invoke-direct {p0, p2}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->onUpdateCompletedButton(Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;)V

    .line 436
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getMergedInfo()Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;

    move-result-object p1

    invoke-direct {p0, p1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->onUpdateRecentButton(Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;)V

    goto :goto_3

    .line 438
    :cond_7
    invoke-direct {p0, p1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->onUpdateTitle(Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;)V

    .line 439
    invoke-direct {p0, p2, v2, p1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->onUpdateDescription(Ljava/util/List;Ljava/util/List;Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;)V

    .line 440
    invoke-direct {p0, p1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->onUpdateFavoriteButton(Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;)V

    .line 441
    invoke-direct {p0, p1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->onUpdateCompletedButton(Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;)V

    .line 442
    invoke-direct {p0, p1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->onUpdateRecentButton(Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;)V

    .line 445
    :goto_3
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->refreshPinButton()V

    .line 446
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->refreshPreview()V

    .line 447
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->recentButton:Lcom/google/android/material/chip/Chip;

    if-nez p1, :cond_8

    const-string p1, "recentButton"

    invoke-static {p1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object p1, v1

    :cond_8
    invoke-virtual {p1}, Lcom/google/android/material/chip/Chip;->requestLayout()V

    .line 448
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->newlyButton:Lcom/google/android/material/chip/Chip;

    if-nez p1, :cond_9

    const-string p1, "newlyButton"

    invoke-static {p1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_4

    :cond_9
    move-object v1, p1

    :goto_4
    invoke-virtual {v1}, Lcom/google/android/material/chip/Chip;->requestLayout()V

    return-void
.end method

.method private final onUpdateRecentButton(Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;)V
    .locals 5

    .line 554
    new-instance v0, Ljava/util/Date;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    sget-object v3, Lcom/magneticchen/daijishou/data/Constants;->INSTANCE:Lcom/magneticchen/daijishou/data/Constants;

    invoke-virtual {v3}, Lcom/magneticchen/daijishou/data/Constants;->getRecentDurationDefinition-UwyO8pc()J

    move-result-wide v3

    invoke-static {v3, v4}, Lkotlin/time/Duration;->getInWholeMilliseconds-impl(J)J

    move-result-wide v3

    sub-long/2addr v1, v3

    invoke-direct {v0, v1, v2}, Ljava/util/Date;-><init>(J)V

    .line 555
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getLastPlayedTimestamp()Ljava/util/Date;

    move-result-object p1

    const/4 v1, 0x0

    .line 556
    const-string v2, "recentButton"

    if-eqz p1, :cond_1

    .line 557
    invoke-virtual {p1, v0}, Ljava/util/Date;->after(Ljava/util/Date;)Z

    move-result p1

    if-eqz p1, :cond_1

    .line 559
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->recentButton:Lcom/google/android/material/chip/Chip;

    if-nez p1, :cond_0

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_0

    :cond_0
    move-object v1, p1

    :goto_0
    const/4 p1, 0x0

    invoke-virtual {v1, p1}, Lcom/google/android/material/chip/Chip;->setVisibility(I)V

    return-void

    .line 564
    :cond_1
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->recentButton:Lcom/google/android/material/chip/Chip;

    if-nez p1, :cond_2

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_1

    :cond_2
    move-object v1, p1

    :goto_1
    const/16 p1, 0x8

    invoke-virtual {v1, p1}, Lcom/google/android/material/chip/Chip;->setVisibility(I)V

    return-void
.end method

.method private final onUpdateRecentButton(Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;)V
    .locals 5

    .line 539
    new-instance v0, Ljava/util/Date;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    sget-object v3, Lcom/magneticchen/daijishou/data/Constants;->INSTANCE:Lcom/magneticchen/daijishou/data/Constants;

    invoke-virtual {v3}, Lcom/magneticchen/daijishou/data/Constants;->getRecentDurationDefinition-UwyO8pc()J

    move-result-wide v3

    invoke-static {v3, v4}, Lkotlin/time/Duration;->getInWholeMilliseconds-impl(J)J

    move-result-wide v3

    sub-long/2addr v1, v3

    invoke-direct {v0, v1, v2}, Ljava/util/Date;-><init>(J)V

    .line 540
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;->getMergedLastPlayedTimestamp()Ljava/util/Date;

    move-result-object p1

    const/4 v1, 0x0

    .line 541
    const-string v2, "recentButton"

    if-eqz p1, :cond_1

    .line 542
    invoke-virtual {p1, v0}, Ljava/util/Date;->after(Ljava/util/Date;)Z

    move-result p1

    if-eqz p1, :cond_1

    .line 544
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->recentButton:Lcom/google/android/material/chip/Chip;

    if-nez p1, :cond_0

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_0

    :cond_0
    move-object v1, p1

    :goto_0
    const/4 p1, 0x0

    invoke-virtual {v1, p1}, Lcom/google/android/material/chip/Chip;->setVisibility(I)V

    return-void

    .line 549
    :cond_1
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->recentButton:Lcom/google/android/material/chip/Chip;

    if-nez p1, :cond_2

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_1

    :cond_2
    move-object v1, p1

    :goto_1
    const/16 p1, 0x8

    invoke-virtual {v1, p1}, Lcom/google/android/material/chip/Chip;->setVisibility(I)V

    return-void
.end method

.method private final onUpdateTitle(Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;)V
    .locals 3

    .line 473
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "do_not_prettify_titles_in_details_view"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    const/4 v1, 0x0

    .line 474
    const-string v2, "titleTextView"

    if-eqz v0, :cond_1

    .line 475
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->titleTextView:Landroid/widget/TextView;

    if-nez v0, :cond_0

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_0

    :cond_0
    move-object v1, v0

    :goto_0
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getMergedInfo()Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;

    move-result-object p1

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;->getMergedName()Ljava/lang/String;

    move-result-object p1

    check-cast p1, Ljava/lang/CharSequence;

    invoke-virtual {v1, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    return-void

    .line 480
    :cond_1
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getDoNotPrettify()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 481
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->titleTextView:Landroid/widget/TextView;

    if-nez v0, :cond_2

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_1

    :cond_2
    move-object v1, v0

    :goto_1
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getName()Ljava/lang/String;

    move-result-object p1

    check-cast p1, Ljava/lang/CharSequence;

    invoke-virtual {v1, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    return-void

    .line 486
    :cond_3
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->titleTextView:Landroid/widget/TextView;

    if-nez v0, :cond_4

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_2

    :cond_4
    move-object v1, v0

    :goto_2
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getDaijishouLibrary()Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object v0

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getName()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, p1}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->prettifyTitleWithPreferences(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    check-cast p1, Ljava/lang/CharSequence;

    invoke-virtual {v1, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    return-void
.end method

.method private final onUpdateTitle(Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;)V
    .locals 3

    .line 454
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "do_not_prettify_titles_in_details_view"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    const/4 v1, 0x0

    .line 455
    const-string v2, "titleTextView"

    if-eqz v0, :cond_1

    .line 456
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->titleTextView:Landroid/widget/TextView;

    if-nez p1, :cond_0

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_0

    :cond_0
    move-object v1, p1

    :goto_0
    invoke-virtual {p2}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;->getMergedName()Ljava/lang/String;

    move-result-object p1

    check-cast p1, Ljava/lang/CharSequence;

    invoke-virtual {v1, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    return-void

    .line 461
    :cond_1
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getDoNotPrettify()Z

    move-result p1

    if-eqz p1, :cond_3

    .line 462
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->titleTextView:Landroid/widget/TextView;

    if-nez p1, :cond_2

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_1

    :cond_2
    move-object v1, p1

    :goto_1
    invoke-virtual {p2}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;->getMergedName()Ljava/lang/String;

    move-result-object p1

    check-cast p1, Ljava/lang/CharSequence;

    invoke-virtual {v1, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    return-void

    .line 467
    :cond_3
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->titleTextView:Landroid/widget/TextView;

    if-nez p1, :cond_4

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_2

    :cond_4
    move-object v1, p1

    :goto_2
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getDaijishouLibrary()Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object p1

    invoke-virtual {p2}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;->getMergedName()Ljava/lang/String;

    move-result-object p2

    invoke-virtual {p1, p2}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->prettifyTitleWithPreferences(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    check-cast p1, Ljava/lang/CharSequence;

    invoke-virtual {v1, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    return-void
.end method

.method private final refreshPinButton()V
    .locals 11

    .line 660
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->selectedPlayableItemEntity:Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;

    .line 661
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getMergePlayableItemsPreference()Z

    move-result v1

    const-string v2, "platformLibraryListRecyclerView"

    const/16 v3, 0x8

    const v4, 0x7f1402ee

    const v5, 0x7f0801a3

    const/4 v6, 0x0

    const-string v7, "pinButton"

    const/4 v8, 0x0

    if-eqz v1, :cond_8

    if-eqz v0, :cond_4

    .line 662
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getPinAndPlayWidget()Lcom/magneticchen/daijishou/ui/widget/widgets/pin_and_play/PinAndPlayWidgetBuilder;

    move-result-object v1

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getMergedInfo()Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntityMergedInfo;->getMergedDisjointSetPrimaryPlayableItemIds()Ljava/util/List;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/magneticchen/daijishou/ui/widget/widgets/pin_and_play/PinAndPlayWidgetBuilder;->isPlayableItemIdsInAPinAndPlayWidget(Ljava/util/List;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 663
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->pinButton:Lcom/google/android/material/chip/Chip;

    if-nez v0, :cond_0

    invoke-static {v7}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v8

    :cond_0
    invoke-virtual {v0}, Lcom/google/android/material/chip/Chip;->isFocused()Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformLibraryListRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    if-nez v0, :cond_1

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v8

    :cond_1
    invoke-virtual {v0}, Landroidx/recyclerview/widget/RecyclerView;->requestFocus()Z

    .line 664
    :cond_2
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->pinButton:Lcom/google/android/material/chip/Chip;

    if-nez v0, :cond_3

    invoke-static {v7}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_0

    :cond_3
    move-object v8, v0

    :goto_0
    invoke-virtual {v8, v3}, Lcom/google/android/material/chip/Chip;->setVisibility(I)V

    return-void

    .line 667
    :cond_4
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->pinButton:Lcom/google/android/material/chip/Chip;

    if-nez v0, :cond_5

    invoke-static {v7}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v8

    :cond_5
    invoke-virtual {v0, v6}, Lcom/google/android/material/chip/Chip;->setVisibility(I)V

    .line 668
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->pinButton:Lcom/google/android/material/chip/Chip;

    if-nez v0, :cond_6

    invoke-static {v7}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v8

    :cond_6
    invoke-virtual {v0, v5}, Lcom/google/android/material/chip/Chip;->setChipIconResource(I)V

    .line 669
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->pinButton:Lcom/google/android/material/chip/Chip;

    if-nez v0, :cond_7

    invoke-static {v7}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_1

    :cond_7
    move-object v8, v0

    :goto_1
    invoke-virtual {p0, v4}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    invoke-virtual {v8, v0}, Lcom/google/android/material/chip/Chip;->setText(Ljava/lang/CharSequence;)V

    return-void

    :cond_8
    if-eqz v0, :cond_d

    .line 673
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getPinAndPlayWidget()Lcom/magneticchen/daijishou/ui/widget/widgets/pin_and_play/PinAndPlayWidgetBuilder;

    move-result-object v1

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getId()J

    move-result-wide v9

    invoke-virtual {v1, v9, v10}, Lcom/magneticchen/daijishou/ui/widget/widgets/pin_and_play/PinAndPlayWidgetBuilder;->isPlayableItemIdInAPinAndPlayWidget(J)Z

    move-result v0

    if-eqz v0, :cond_d

    .line 674
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->pinButton:Lcom/google/android/material/chip/Chip;

    if-nez v0, :cond_9

    invoke-static {v7}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v8

    :cond_9
    invoke-virtual {v0}, Lcom/google/android/material/chip/Chip;->isFocused()Z

    move-result v0

    if-eqz v0, :cond_b

    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformLibraryListRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    if-nez v0, :cond_a

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v8

    :cond_a
    invoke-virtual {v0}, Landroidx/recyclerview/widget/RecyclerView;->requestFocus()Z

    .line 675
    :cond_b
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->pinButton:Lcom/google/android/material/chip/Chip;

    if-nez v0, :cond_c

    invoke-static {v7}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_2

    :cond_c
    move-object v8, v0

    :goto_2
    invoke-virtual {v8, v3}, Lcom/google/android/material/chip/Chip;->setVisibility(I)V

    return-void

    .line 678
    :cond_d
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->pinButton:Lcom/google/android/material/chip/Chip;

    if-nez v0, :cond_e

    invoke-static {v7}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v8

    :cond_e
    invoke-virtual {v0, v6}, Lcom/google/android/material/chip/Chip;->setVisibility(I)V

    .line 679
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->pinButton:Lcom/google/android/material/chip/Chip;

    if-nez v0, :cond_f

    invoke-static {v7}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v8

    :cond_f
    invoke-virtual {v0, v5}, Lcom/google/android/material/chip/Chip;->setChipIconResource(I)V

    .line 680
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->pinButton:Lcom/google/android/material/chip/Chip;

    if-nez v0, :cond_10

    invoke-static {v7}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_3

    :cond_10
    move-object v8, v0

    :goto_3
    invoke-virtual {p0, v4}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    invoke-virtual {v8, v0}, Lcom/google/android/material/chip/Chip;->setText(Ljava/lang/CharSequence;)V

    return-void
.end method

.method private final refreshPreview()V
    .locals 12

    .line 288
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getLibraryViewModel()Lcom/magneticchen/daijishou/ui/model/LibraryViewModel;

    move-result-object v0

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/ui/model/LibraryViewModel;->getPreviewAspectRatioMode()I

    move-result v5

    .line 289
    iget-object v2, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->selectedPlayableItemEntity:Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;

    if-eqz v2, :cond_1

    .line 291
    invoke-virtual {v2}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getPreviewMediaPath()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    invoke-static {p0, v2}, Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver;->resolveAndApplyPreview(Landroidx/fragment/app/Fragment;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_media_resolved_arcade

    return-void

    :cond_media_resolved_arcade
    const/4 v0, 0x0

    .line 292
    invoke-direct {p0, v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->setThumbnail(Landroid/graphics/Bitmap;)V

    .line 293
    invoke-direct {p0, v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->setBackground(Landroid/graphics/Bitmap;)V

    return-void

    .line 298
    :cond_0
    move-object v0, p0

    check-cast v0, Landroidx/lifecycle/LifecycleOwner;

    invoke-static {v0}, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;

    move-result-object v0

    check-cast v0, Lkotlinx/coroutines/CoroutineScope;

    invoke-static {}, Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;

    move-result-object v1

    move-object v7, v1

    check-cast v7, Lkotlin/coroutines/CoroutineContext;

    new-instance v1, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$refreshPreview$1$1;

    const/4 v6, 0x0

    move-object v3, v2

    move-object v4, p0

    invoke-direct/range {v1 .. v6}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$refreshPreview$1$1;-><init>(Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;ILkotlin/coroutines/Continuation;)V

    move-object v9, v1

    check-cast v9, Lkotlin/jvm/functions/Function2;

    const/4 v10, 0x2

    const/4 v11, 0x0

    const/4 v8, 0x0

    move-object v6, v0

    invoke-static/range {v6 .. v11}, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;ILjava/lang/Object;)Lkotlinx/coroutines/Job;

    :cond_1
    return-void
.end method

.method private final setBackground(Landroid/graphics/Bitmap;)V
    .locals 5

    const/4 v0, 0x1

    const/4 v1, 0x0

    if-eqz p1, :cond_0

    .line 281
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v2

    sget-object v3, Lcom/magneticchen/daijishou/data/BooleanPreference;->FORCE_SET_WALLPAPER_FOR_ALL:Lcom/magneticchen/daijishou/data/BooleanPreference;

    invoke-virtual {v3}, Lcom/magneticchen/daijishou/data/BooleanPreference;->getKey()Ljava/lang/String;

    move-result-object v3

    sget-object v4, Lcom/magneticchen/daijishou/data/BooleanPreference;->FORCE_SET_WALLPAPER_FOR_ALL:Lcom/magneticchen/daijishou/data/BooleanPreference;

    invoke-virtual {v4}, Lcom/magneticchen/daijishou/data/BooleanPreference;->getDefaultValue()Z

    move-result v4

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    if-nez v2, :cond_0

    move v2, v0

    goto :goto_0

    :cond_0
    move v2, v1

    .line 282
    :goto_0
    iget-object v3, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->backgroundImageView:Landroid/widget/ImageView;

    const/4 v4, 0x0

    if-nez v3, :cond_1

    const-string v3, "backgroundImageView"

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v3, v4

    :cond_1
    invoke-virtual {v3, p1}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 283
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->backgroundGradientImageView:Landroid/widget/ImageView;

    const-string v3, "backgroundGradientImageView"

    if-nez p1, :cond_2

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object p1, v4

    :cond_2
    check-cast p1, Landroid/view/View;

    .line 1207
    invoke-virtual {p1}, Landroid/view/View;->getVisibility()I

    move-result p1

    if-nez p1, :cond_3

    goto :goto_1

    :cond_3
    move v0, v1

    :goto_1
    if-eq v0, v2, :cond_6

    .line 283
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->backgroundGradientImageView:Landroid/widget/ImageView;

    if-nez p1, :cond_4

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_2

    :cond_4
    move-object v4, p1

    :goto_2
    check-cast v4, Landroid/view/View;

    if-eqz v2, :cond_5

    goto :goto_3

    :cond_5
    const/16 v1, 0x8

    .line 1209
    :goto_3
    invoke-virtual {v4, v1}, Landroid/view/View;->setVisibility(I)V

    :cond_6
    return-void
.end method

.method private final setThumbnail(Landroid/graphics/Bitmap;)V
    .locals 5

    .line 247
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->thumbnailImageView:Landroid/widget/ImageView;

    const/4 v1, 0x0

    if-nez v0, :cond_0

    const-string v0, "thumbnailImageView"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_0
    invoke-virtual {v0, p1}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 248
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->placeholderImageView:Landroid/widget/ImageView;

    if-nez v0, :cond_1

    const-string v0, "placeholderImageView"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_1
    const/4 v2, 0x0

    const/16 v3, 0x8

    if-nez p1, :cond_2

    move v4, v2

    goto :goto_0

    :cond_2
    move v4, v3

    :goto_0
    invoke-virtual {v0, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 249
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformTextView:Landroid/widget/TextView;

    const-string v4, "platformTextView"

    if-nez v0, :cond_3

    invoke-static {v4}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_3
    if-nez p1, :cond_4

    goto :goto_1

    :cond_4
    move v2, v3

    :goto_1
    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 250
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformTextView:Landroid/widget/TextView;

    if-nez p1, :cond_5

    invoke-static {v4}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object p1, v1

    :cond_5
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformEntity:Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;

    if-eqz v0, :cond_6

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;->getShortname()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_6

    goto :goto_2

    :cond_6
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformString:Ljava/lang/String;

    if-nez v0, :cond_7

    const-string v0, "platformString"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_7
    :goto_2
    check-cast v0, Ljava/lang/CharSequence;

    invoke-virtual {p1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 252
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getLibraryViewModel()Lcom/magneticchen/daijishou/ui/model/LibraryViewModel;

    move-result-object p1

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/ui/model/LibraryViewModel;->getPreviewAspectRatioMode()I

    move-result p1

    const-string v0, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams"

    const-string v2, "backgroundSetLayout"

    if-eqz p1, :cond_c

    const/4 v3, 0x1

    if-eq p1, v3, :cond_a

    const/4 v3, 0x2

    if-eq p1, v3, :cond_8

    goto :goto_3

    .line 265
    :cond_8
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->screenAspectRatio:Ljava/lang/String;

    iput-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->dimensionRatio:Ljava/lang/String;

    .line 266
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->backgroundSetLayout:Landroidx/constraintlayout/widget/ConstraintLayout;

    if-nez p1, :cond_9

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object p1, v1

    :cond_9
    invoke-virtual {p1}, Landroidx/constraintlayout/widget/ConstraintLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object p1

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p1, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;

    iget-object v3, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->screenAspectRatio:Ljava/lang/String;

    iput-object v3, p1, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->dimensionRatio:Ljava/lang/String;

    goto :goto_3

    .line 260
    :cond_a
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->screenAspectRatio:Ljava/lang/String;

    iput-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->dimensionRatio:Ljava/lang/String;

    .line 261
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->backgroundSetLayout:Landroidx/constraintlayout/widget/ConstraintLayout;

    if-nez p1, :cond_b

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object p1, v1

    :cond_b
    invoke-virtual {p1}, Landroidx/constraintlayout/widget/ConstraintLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object p1

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p1, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;

    iget-object v3, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->screenAspectRatio:Ljava/lang/String;

    iput-object v3, p1, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->dimensionRatio:Ljava/lang/String;

    goto :goto_3

    .line 255
    :cond_c
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->boxArtAspectRatio:Ljava/lang/String;

    iput-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->dimensionRatio:Ljava/lang/String;

    .line 256
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->backgroundSetLayout:Landroidx/constraintlayout/widget/ConstraintLayout;

    if-nez p1, :cond_d

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object p1, v1

    :cond_d
    invoke-virtual {p1}, Landroidx/constraintlayout/widget/ConstraintLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object p1

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p1, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;

    iget-object v3, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->boxArtAspectRatio:Ljava/lang/String;

    iput-object v3, p1, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->dimensionRatio:Ljava/lang/String;

    .line 270
    :goto_3
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->dimensionRatio:Ljava/lang/String;

    if-eqz p1, :cond_11

    .line 271
    iget-object v3, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->backgroundSetLayout:Landroidx/constraintlayout/widget/ConstraintLayout;

    if-nez v3, :cond_e

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v3, v1

    :cond_e
    invoke-virtual {v3}, Landroidx/constraintlayout/widget/ConstraintLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    invoke-static {v3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v3, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;

    .line 272
    iget-object v0, v3, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->dimensionRatio:Ljava/lang/String;

    invoke-static {v0, p1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_f

    .line 273
    iput-object p1, v3, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->dimensionRatio:Ljava/lang/String;

    .line 275
    :cond_f
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->backgroundSetLayout:Landroidx/constraintlayout/widget/ConstraintLayout;

    if-nez p1, :cond_10

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_4

    :cond_10
    move-object v1, p1

    :goto_4
    invoke-virtual {v1}, Landroidx/constraintlayout/widget/ConstraintLayout;->requestLayout()V

    :cond_11
    return-void
.end method

.method private final toggleViewMode()V
    .locals 6

    .line 236
    iget-boolean v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->lockToggleViewMode:Z

    if-eqz v0, :cond_0

    goto :goto_0

    .line 237
    :cond_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 238
    iget-wide v2, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->lastToggleViewModeTimeMillis:J

    sub-long v2, v0, v2

    const-wide/16 v4, 0x168

    cmp-long v2, v2, v4

    if-gez v2, :cond_1

    :goto_0
    return-void

    .line 239
    :cond_1
    iput-wide v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->lastToggleViewModeTimeMillis:J

    .line 240
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getLibraryViewModel()Lcom/magneticchen/daijishou/ui/model/LibraryViewModel;

    move-result-object v0

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/ui/model/LibraryViewModel;->getPreferences()Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "view_mode"

    const/4 v2, 0x1

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 241
    move-object v0, p0

    check-cast v0, Landroidx/fragment/app/Fragment;

    invoke-static {v0}, Landroidx/navigation/fragment/FragmentKt;->findNavController(Landroidx/fragment/app/Fragment;)Landroidx/navigation/NavController;

    move-result-object v0

    .line 242
    invoke-virtual {v0}, Landroidx/navigation/NavController;->getCurrentDestination()Landroidx/navigation/NavDestination;

    move-result-object v1

    if-eqz v1, :cond_2

    invoke-virtual {v1}, Landroidx/navigation/NavDestination;->getId()I

    move-result v1

    const v2, 0x7f0a033d

    if-ne v1, v2, :cond_2

    const v1, 0x7f0a033c

    invoke-virtual {v0, v1}, Landroidx/navigation/NavController;->navigate(I)V

    :cond_2
    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 5

    .line 821
    invoke-super {p0, p1}, Lcom/magneticchen/daijishou/ui/fragments/abstract/PlatformNavFragment;->onCreate(Landroid/os/Bundle;)V

    .line 823
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->requireContext()Landroid/content/Context;

    move-result-object p1

    const-string v0, "requireContext(...)"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 824
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    const-string v1, "requireActivity(...)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    const v1, 0x7f1402f0

    .line 827
    invoke-virtual {p0, v1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    const-string v2, "getString(...)"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object v1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformString:Ljava/lang/String;

    const v1, 0x7f1402ce

    .line 828
    invoke-virtual {p0, v1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object v1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->noneString:Ljava/lang/String;

    const v1, 0x7f1403c4

    .line 829
    invoke-virtual {p0, v1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object v1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->setPreviewToBoxArtString:Ljava/lang/String;

    const v1, 0x7f1403c5

    .line 830
    invoke-virtual {p0, v1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object v1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->setPreviewToSnapshotString:Ljava/lang/String;

    const v1, 0x7f1403c6

    .line 831
    invoke-virtual {p0, v1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object v1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->setPreviewToTitleString:Ljava/lang/String;

    const v1, 0x7f1403c1

    .line 832
    invoke-virtual {p0, v1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object v1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->selectedLetterFormatString:Ljava/lang/String;

    .line 833
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getLibraryViewModel()Lcom/magneticchen/daijishou/ui/model/LibraryViewModel;

    move-result-object v1

    invoke-virtual {v1}, Lcom/magneticchen/daijishou/ui/model/LibraryViewModel;->getSelectedPlatformId()J

    move-result-wide v3

    iput-wide v3, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformId:J

    const v1, 0x7f1402f3

    .line 834
    invoke-virtual {p0, v1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object v1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformFormatString:Ljava/lang/String;

    const v1, 0x7f1402f6

    .line 835
    invoke-virtual {p0, v1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object v1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->tipsFormatString:Ljava/lang/String;

    const v1, 0x7f14030f

    .line 836
    invoke-virtual {p0, v1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object v1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->descriptionFormatString:Ljava/lang/String;

    const v1, 0x7f140310

    .line 837
    invoke-virtual {p0, v1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object v1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->descriptionWithGenresFormatString:Ljava/lang/String;

    .line 840
    invoke-virtual {v0}, Landroidx/fragment/app/FragmentActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    const-string v1, "getPackageManager(...)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->packageManager:Landroid/content/pm/PackageManager;

    const v0, 0x7f080109

    .line 841
    invoke-static {p1, v0}, Landroidx/appcompat/content/res/AppCompatResources;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->isFavoriteDrawable:Landroid/graphics/drawable/Drawable;

    const v0, 0x7f0800b7

    .line 842
    invoke-static {p1, v0}, Landroidx/appcompat/content/res/AppCompatResources;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->isCompletedDrawable:Landroid/graphics/drawable/Drawable;

    const v0, 0x7f080105

    .line 843
    invoke-static {p1, v0}, Landroidx/appcompat/content/res/AppCompatResources;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->isNotCompletedDrawable:Landroid/graphics/drawable/Drawable;

    const v0, 0x7f08010a

    .line 844
    invoke-static {p1, v0}, Landroidx/appcompat/content/res/AppCompatResources;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object p1

    invoke-static {p1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    iput-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->isNotFavoriteDrawable:Landroid/graphics/drawable/Drawable;

    .line 845
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getResources()Landroid/content/res/Resources;

    move-result-object p1

    const/high16 v0, 0x7f030000

    invoke-virtual {p1, v0}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object p1

    const-string v0, "getStringArray(...)"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p1, [Ljava/lang/Object;

    invoke-static {p1}, Lkotlin/collections/ArraysKt;->toList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object p1

    iput-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->boxArtAspectRatioList:Ljava/util/List;

    .line 846
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getResources()Landroid/content/res/Resources;

    move-result-object p1

    const v1, 0x7f030012

    invoke-virtual {p1, v1}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object p1

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p1, [Ljava/lang/Object;

    invoke-static {p1}, Lkotlin/collections/ArraysKt;->toList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object p1

    iput-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->screenAspectRatioList:Ljava/util/List;

    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 16

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    const-string v2, "inflater"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 855
    invoke-virtual {v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->requireContext()Landroid/content/Context;

    move-result-object v2

    const-string v3, "requireContext(...)"

    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 856
    invoke-direct {v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getLibraryViewModel()Lcom/magneticchen/daijishou/ui/model/LibraryViewModel;

    move-result-object v4

    invoke-virtual {v4}, Lcom/magneticchen/daijishou/ui/model/LibraryViewModel;->getPreferences()Landroid/content/SharedPreferences;

    move-result-object v4

    const v5, 0x7f0d0045

    const/4 v6, 0x0

    move-object/from16 v7, p2

    .line 858
    invoke-virtual {v1, v5, v7, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    const v5, 0x7f0a03ce

    .line 861
    invoke-virtual {v1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    const-string v7, "findViewById(...)"

    invoke-static {v5, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v5, Lcom/google/android/material/chip/ChipGroup;

    iput-object v5, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->chipGroup:Lcom/google/android/material/chip/ChipGroup;

    const v5, 0x7f0a036e

    .line 862
    invoke-virtual {v1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-static {v5, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v5, Lcom/google/android/material/chip/Chip;

    iput-object v5, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->playButton:Lcom/google/android/material/chip/Chip;

    const v5, 0x7f0a0368

    .line 863
    invoke-virtual {v1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-static {v5, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v5, Landroidx/recyclerview/widget/RecyclerView;

    iput-object v5, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformLibraryListRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    .line 864
    new-instance v5, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;

    iget-object v8, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->playableItemList:Ljava/util/List;

    iget-object v9, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->playButton:Lcom/google/android/material/chip/Chip;

    const-string v10, "playButton"

    const/4 v11, 0x0

    if-nez v9, :cond_0

    invoke-static {v10}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v9, v11

    :cond_0
    invoke-virtual {v9}, Lcom/google/android/material/chip/Chip;->getId()I

    move-result v9

    invoke-direct {v5, v0, v8, v9}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;-><init>(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Ljava/util/List;I)V

    iput-object v5, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformLibraryListRecyclerViewAdapter:Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;

    const v5, 0x7f0a0372

    .line 866
    invoke-virtual {v1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-static {v5, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v5, Landroid/widget/TextView;

    iput-object v5, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->titleTextView:Landroid/widget/TextView;

    if-nez v5, :cond_1

    .line 867
    const-string v5, "titleTextView"

    invoke-static {v5}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v5, v11

    :cond_1
    new-instance v8, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda2;

    invoke-direct {v8, v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda2;-><init>(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)V

    invoke-virtual {v5, v8}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const v5, 0x7f0a034d

    .line 875
    invoke-virtual {v1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-static {v5, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v5, Landroid/widget/TextView;

    iput-object v5, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->descriptionTextView:Landroid/widget/TextView;

    const v5, 0x7f0a036d

    .line 876
    invoke-virtual {v1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-static {v5, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v5, Landroid/widget/TextView;

    iput-object v5, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformTextView:Landroid/widget/TextView;

    const v5, 0x7f0a0370

    .line 877
    invoke-virtual {v1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-static {v5, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v5, Landroid/widget/ImageView;

    iput-object v5, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->thumbnailImageView:Landroid/widget/ImageView;

    const v5, 0x7f0a0348

    .line 878
    invoke-virtual {v1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-static {v5, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v5, Landroid/widget/ImageView;

    iput-object v5, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->backgroundImageView:Landroid/widget/ImageView;

    const v5, 0x7f0a0349

    .line 879
    invoke-virtual {v1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-static {v5, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v5, Landroid/widget/ImageView;

    iput-object v5, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->backgroundGradientImageView:Landroid/widget/ImageView;

    const v5, 0x7f0a034a

    .line 880
    invoke-virtual {v1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-static {v5, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v5, Landroidx/constraintlayout/widget/ConstraintLayout;

    iput-object v5, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->backgroundSetLayout:Landroidx/constraintlayout/widget/ConstraintLayout;

    const v5, 0x7f0a036c

    .line 881
    invoke-virtual {v1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-static {v5, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v5, Landroid/widget/ImageView;

    iput-object v5, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->placeholderImageView:Landroid/widget/ImageView;

    const v5, 0x7f0a0350

    .line 882
    invoke-virtual {v1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-static {v5, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v5, Lcom/google/android/material/chip/Chip;

    iput-object v5, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->favoriteButton:Lcom/google/android/material/chip/Chip;

    const v5, 0x7f0a034c

    .line 883
    invoke-virtual {v1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-static {v5, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v5, Lcom/google/android/material/chip/Chip;

    iput-object v5, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->completeButton:Lcom/google/android/material/chip/Chip;

    const v5, 0x7f0a036b

    .line 885
    invoke-virtual {v1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-static {v5, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v5, Lcom/google/android/material/chip/Chip;

    iput-object v5, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->pinButton:Lcom/google/android/material/chip/Chip;

    const v5, 0x7f0a036f

    .line 886
    invoke-virtual {v1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-static {v5, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v5, Lcom/google/android/material/chip/Chip;

    iput-object v5, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->recentButton:Lcom/google/android/material/chip/Chip;

    const v5, 0x7f0a036a

    .line 887
    invoke-virtual {v1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-static {v5, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v5, Lcom/google/android/material/chip/Chip;

    iput-object v5, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->newlyButton:Lcom/google/android/material/chip/Chip;

    const v5, 0x7f0a034e

    .line 888
    invoke-virtual {v1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-static {v5, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v5, Lcom/google/android/material/chip/Chip;

    iput-object v5, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->detailButton:Lcom/google/android/material/chip/Chip;

    const v5, 0x7f0a0361

    .line 889
    invoke-virtual {v1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-static {v5, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v5, Lcom/google/android/material/chip/Chip;

    iput-object v5, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->gridViewButton:Lcom/google/android/material/chip/Chip;

    const v5, 0x7f0a034f

    .line 890
    invoke-virtual {v1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-static {v5, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v5, Lcom/google/android/material/chip/Chip;

    iput-object v5, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->editButton:Lcom/google/android/material/chip/Chip;

    .line 892
    invoke-direct {v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->initOrientationObserver()V

    .line 895
    iget-object v5, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->playableItemList:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->clear()V

    .line 899
    iget-object v5, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->editButton:Lcom/google/android/material/chip/Chip;

    const-string v7, "editButton"

    if-nez v5, :cond_2

    invoke-static {v7}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v5, v11

    :cond_2
    invoke-virtual {v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->isKioskMode()Z

    move-result v8

    if-eqz v8, :cond_3

    const/16 v8, 0x8

    goto :goto_0

    :cond_3
    move v8, v6

    :goto_0
    invoke-virtual {v5, v8}, Lcom/google/android/material/chip/Chip;->setVisibility(I)V

    .line 900
    iget-object v5, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->gridViewButton:Lcom/google/android/material/chip/Chip;

    const-string v8, "gridViewButton"

    if-nez v5, :cond_4

    invoke-static {v8}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v5, v11

    :cond_4
    invoke-virtual {v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->isKioskMode()Z

    move-result v9

    if-eqz v9, :cond_5

    iget-object v9, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->playButton:Lcom/google/android/material/chip/Chip;

    if-nez v9, :cond_6

    invoke-static {v10}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_1

    :cond_5
    iget-object v9, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->editButton:Lcom/google/android/material/chip/Chip;

    if-nez v9, :cond_6

    invoke-static {v7}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    :goto_1
    move-object v9, v11

    :cond_6
    invoke-virtual {v9}, Lcom/google/android/material/chip/Chip;->getId()I

    move-result v9

    invoke-virtual {v5, v9}, Lcom/google/android/material/chip/Chip;->setNextFocusRightId(I)V

    .line 901
    invoke-virtual {v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->isKioskMode()Z

    move-result v5

    if-eqz v5, :cond_e

    iget-object v5, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->gridViewButton:Lcom/google/android/material/chip/Chip;

    if-nez v5, :cond_7

    invoke-static {v8}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v5, v11

    :cond_7
    check-cast v5, Landroid/view/View;

    .line 1211
    invoke-virtual {v5}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v9

    if-eqz v9, :cond_d

    check-cast v9, Lcom/google/android/material/chip/ChipGroup$LayoutParams;

    check-cast v9, Landroid/view/ViewGroup$LayoutParams;

    .line 1212
    move-object v12, v9

    check-cast v12, Lcom/google/android/material/chip/ChipGroup$LayoutParams;

    .line 902
    iget-object v13, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->chipGroup:Lcom/google/android/material/chip/ChipGroup;

    const-string v14, "chipGroup"

    if-nez v13, :cond_8

    invoke-static {v14}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v13, v11

    :cond_8
    check-cast v13, Landroid/view/ViewGroup;

    invoke-static {v13}, Landroidx/core/view/ViewGroupKt;->getChildren(Landroid/view/ViewGroup;)Lkotlin/sequences/Sequence;

    move-result-object v13

    .line 1213
    invoke-interface {v13}, Lkotlin/sequences/Sequence;->iterator()Ljava/util/Iterator;

    move-result-object v13

    :goto_2
    invoke-interface {v13}, Ljava/util/Iterator;->hasNext()Z

    move-result v15

    if-eqz v15, :cond_c

    invoke-interface {v13}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Landroid/view/View;

    .line 903
    iget-object v6, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->editButton:Lcom/google/android/material/chip/Chip;

    if-nez v6, :cond_9

    invoke-static {v7}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v6, v11

    :cond_9
    invoke-static {v15, v6}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_b

    .line 904
    iget-object v6, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->chipGroup:Lcom/google/android/material/chip/ChipGroup;

    if-nez v6, :cond_a

    invoke-static {v14}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v6, v11

    :cond_a
    invoke-virtual {v6, v15}, Lcom/google/android/material/chip/ChipGroup;->removeView(Landroid/view/View;)V

    :cond_b
    const/4 v6, 0x0

    goto :goto_2

    .line 907
    :cond_c
    invoke-virtual {v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getDpToPxConverter()Lcom/magneticchen/daijishou/utils/DpToPxConverter;

    move-result-object v6

    const/high16 v13, 0x41000000    # 8.0f

    invoke-virtual {v6, v13}, Lcom/magneticchen/daijishou/utils/DpToPxConverter;->convert(F)I

    move-result v6

    invoke-virtual {v12, v6}, Lcom/google/android/material/chip/ChipGroup$LayoutParams;->setMarginEnd(I)V

    .line 1215
    invoke-virtual {v5, v9}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    goto :goto_3

    .line 1211
    :cond_d
    new-instance v1, Ljava/lang/NullPointerException;

    const-string v2, "null cannot be cast to non-null type com.google.android.material.chip.ChipGroup.LayoutParams"

    invoke-direct {v1, v2}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 909
    :cond_e
    :goto_3
    iget-object v5, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformLibraryListRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    const-string v6, "platformLibraryListRecyclerView"

    if-nez v5, :cond_f

    invoke-static {v6}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v5, v11

    :cond_f
    new-instance v9, Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouCycleLinearLayoutManager;

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->requireContext()Landroid/content/Context;

    move-result-object v12

    invoke-static {v12, v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {v9, v12}, Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouCycleLinearLayoutManager;-><init>(Landroid/content/Context;)V

    check-cast v9, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;

    invoke-virtual {v5, v9}, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V

    .line 910
    iget-object v3, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformLibraryListRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    if-nez v3, :cond_10

    invoke-static {v6}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v3, v11

    :cond_10
    iget-object v5, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformLibraryListRecyclerViewAdapter:Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;

    const-string v9, "platformLibraryListRecyclerViewAdapter"

    if-nez v5, :cond_11

    invoke-static {v9}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v5, v11

    :cond_11
    check-cast v5, Landroidx/recyclerview/widget/RecyclerView$Adapter;

    invoke-virtual {v3, v5}, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V

    .line 911
    iget-object v3, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformLibraryListRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    if-nez v3, :cond_12

    invoke-static {v6}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v3, v11

    :cond_12
    invoke-virtual {v3, v11}, Landroidx/recyclerview/widget/RecyclerView;->setItemAnimator(Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;)V

    .line 913
    iget-object v3, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->playButton:Lcom/google/android/material/chip/Chip;

    if-nez v3, :cond_13

    invoke-static {v10}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v3, v11

    :cond_13
    iget-object v5, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->backgroundSetLayout:Landroidx/constraintlayout/widget/ConstraintLayout;

    const-string v6, "backgroundSetLayout"

    if-nez v5, :cond_14

    invoke-static {v6}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v5, v11

    :cond_14
    invoke-virtual {v5}, Landroidx/constraintlayout/widget/ConstraintLayout;->getId()I

    move-result v5

    invoke-virtual {v3, v5}, Lcom/google/android/material/chip/Chip;->setNextFocusUpId(I)V

    .line 914
    iget-object v3, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->favoriteButton:Lcom/google/android/material/chip/Chip;

    if-nez v3, :cond_15

    const-string v3, "favoriteButton"

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v3, v11

    :cond_15
    iget-object v5, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->backgroundSetLayout:Landroidx/constraintlayout/widget/ConstraintLayout;

    if-nez v5, :cond_16

    invoke-static {v6}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v5, v11

    :cond_16
    invoke-virtual {v5}, Landroidx/constraintlayout/widget/ConstraintLayout;->getId()I

    move-result v5

    invoke-virtual {v3, v5}, Lcom/google/android/material/chip/Chip;->setNextFocusUpId(I)V

    .line 916
    iget-object v3, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->pinButton:Lcom/google/android/material/chip/Chip;

    const-string v5, "pinButton"

    if-nez v3, :cond_17

    invoke-static {v5}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v3, v11

    :cond_17
    iget-object v12, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->backgroundSetLayout:Landroidx/constraintlayout/widget/ConstraintLayout;

    if-nez v12, :cond_18

    invoke-static {v6}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v12, v11

    :cond_18
    invoke-virtual {v12}, Landroidx/constraintlayout/widget/ConstraintLayout;->getId()I

    move-result v12

    invoke-virtual {v3, v12}, Lcom/google/android/material/chip/Chip;->setNextFocusUpId(I)V

    .line 918
    iget-object v3, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->recentButton:Lcom/google/android/material/chip/Chip;

    if-nez v3, :cond_19

    const-string v3, "recentButton"

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v3, v11

    :cond_19
    iget-object v12, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->backgroundSetLayout:Landroidx/constraintlayout/widget/ConstraintLayout;

    if-nez v12, :cond_1a

    invoke-static {v6}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v12, v11

    :cond_1a
    invoke-virtual {v12}, Landroidx/constraintlayout/widget/ConstraintLayout;->getId()I

    move-result v12

    invoke-virtual {v3, v12}, Lcom/google/android/material/chip/Chip;->setNextFocusUpId(I)V

    .line 920
    iget-object v3, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->newlyButton:Lcom/google/android/material/chip/Chip;

    if-nez v3, :cond_1b

    const-string v3, "newlyButton"

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v3, v11

    :cond_1b
    iget-object v12, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->backgroundSetLayout:Landroidx/constraintlayout/widget/ConstraintLayout;

    if-nez v12, :cond_1c

    invoke-static {v6}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v12, v11

    :cond_1c
    invoke-virtual {v12}, Landroidx/constraintlayout/widget/ConstraintLayout;->getId()I

    move-result v12

    invoke-virtual {v3, v12}, Lcom/google/android/material/chip/Chip;->setNextFocusUpId(I)V

    .line 922
    iget-object v3, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->detailButton:Lcom/google/android/material/chip/Chip;

    const-string v12, "detailButton"

    if-nez v3, :cond_1d

    invoke-static {v12}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v3, v11

    :cond_1d
    iget-object v13, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->backgroundSetLayout:Landroidx/constraintlayout/widget/ConstraintLayout;

    if-nez v13, :cond_1e

    invoke-static {v6}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v13, v11

    :cond_1e
    invoke-virtual {v13}, Landroidx/constraintlayout/widget/ConstraintLayout;->getId()I

    move-result v13

    invoke-virtual {v3, v13}, Lcom/google/android/material/chip/Chip;->setNextFocusUpId(I)V

    .line 924
    iget-object v3, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->gridViewButton:Lcom/google/android/material/chip/Chip;

    if-nez v3, :cond_1f

    invoke-static {v8}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v3, v11

    :cond_1f
    iget-object v13, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->backgroundSetLayout:Landroidx/constraintlayout/widget/ConstraintLayout;

    if-nez v13, :cond_20

    invoke-static {v6}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v13, v11

    :cond_20
    invoke-virtual {v13}, Landroidx/constraintlayout/widget/ConstraintLayout;->getId()I

    move-result v13

    invoke-virtual {v3, v13}, Lcom/google/android/material/chip/Chip;->setNextFocusUpId(I)V

    .line 926
    iget-object v3, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->editButton:Lcom/google/android/material/chip/Chip;

    if-nez v3, :cond_21

    invoke-static {v7}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v3, v11

    :cond_21
    iget-object v13, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->backgroundSetLayout:Landroidx/constraintlayout/widget/ConstraintLayout;

    if-nez v13, :cond_22

    invoke-static {v6}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v13, v11

    :cond_22
    invoke-virtual {v13}, Landroidx/constraintlayout/widget/ConstraintLayout;->getId()I

    move-result v13

    invoke-virtual {v3, v13}, Lcom/google/android/material/chip/Chip;->setNextFocusUpId(I)V

    .line 928
    iget-object v3, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->backgroundSetLayout:Landroidx/constraintlayout/widget/ConstraintLayout;

    if-nez v3, :cond_23

    invoke-static {v6}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v3, v11

    :cond_23
    new-instance v13, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda3;

    invoke-direct {v13, v0, v2}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda3;-><init>(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/content/Context;)V

    invoke-virtual {v3, v13}, Landroidx/constraintlayout/widget/ConstraintLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 952
    iget-object v2, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->backgroundSetLayout:Landroidx/constraintlayout/widget/ConstraintLayout;

    if-nez v2, :cond_24

    invoke-static {v6}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v2, v11

    :cond_24
    new-instance v3, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda4;

    invoke-direct {v3, v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda4;-><init>(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)V

    invoke-virtual {v2, v3}, Landroidx/constraintlayout/widget/ConstraintLayout;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    .line 960
    iget-object v2, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->playButton:Lcom/google/android/material/chip/Chip;

    if-nez v2, :cond_25

    invoke-static {v10}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v2, v11

    :cond_25
    new-instance v3, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda5;

    invoke-direct {v3, v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda5;-><init>(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)V

    invoke-virtual {v2, v3}, Lcom/google/android/material/chip/Chip;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 966
    invoke-direct {v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->initTypeface()V

    .line 967
    invoke-direct {v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->initCompletedClickListener()V

    .line 968
    invoke-direct {v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->initFavoriteClickListener()V

    .line 969
    invoke-direct {v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->initChipFocusListener()V

    .line 971
    iget-object v2, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->pinButton:Lcom/google/android/material/chip/Chip;

    if-nez v2, :cond_26

    invoke-static {v5}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v2, v11

    :cond_26
    new-instance v3, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda6;

    invoke-direct {v3, v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda6;-><init>(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)V

    invoke-virtual {v2, v3}, Lcom/google/android/material/chip/Chip;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 997
    iget-object v2, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->detailButton:Lcom/google/android/material/chip/Chip;

    if-nez v2, :cond_27

    invoke-static {v12}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v2, v11

    :cond_27
    new-instance v3, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda7;

    invoke-direct {v3, v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda7;-><init>(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)V

    invoke-virtual {v2, v3}, Lcom/google/android/material/chip/Chip;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1004
    iget-object v2, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->gridViewButton:Lcom/google/android/material/chip/Chip;

    if-nez v2, :cond_28

    invoke-static {v8}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v2, v11

    :cond_28
    new-instance v3, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda8;

    invoke-direct {v3, v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda8;-><init>(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)V

    invoke-virtual {v2, v3}, Lcom/google/android/material/chip/Chip;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1008
    iget-object v2, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->editButton:Lcom/google/android/material/chip/Chip;

    if-nez v2, :cond_29

    invoke-static {v7}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v2, v11

    :cond_29
    new-instance v3, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda9;

    invoke-direct {v3, v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$$ExternalSyntheticLambda9;-><init>(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)V

    invoke-virtual {v2, v3}, Lcom/google/android/material/chip/Chip;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1014
    iget-object v2, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformLibraryListRecyclerViewAdapter:Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;

    if-nez v2, :cond_2a

    invoke-static {v9}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v2, v11

    :cond_2a
    new-instance v3, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$onCreateView$10;

    invoke-direct {v3, v4, v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$onCreateView$10;-><init>(Landroid/content/SharedPreferences;Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)V

    check-cast v3, Lkotlin/jvm/functions/Function4;

    invoke-virtual {v2, v3}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;->setOnItemSelectListener(Lkotlin/jvm/functions/Function4;)V

    .line 1019
    iget-object v2, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformLibraryListRecyclerViewAdapter:Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;

    if-nez v2, :cond_2b

    invoke-static {v9}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v2, v11

    :cond_2b
    new-instance v3, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$onCreateView$11;

    invoke-direct {v3, v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$onCreateView$11;-><init>(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)V

    check-cast v3, Lkotlin/jvm/functions/Function4;

    invoke-virtual {v2, v3}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;->setOnItemClickListener(Lkotlin/jvm/functions/Function4;)V

    .line 1023
    iget-object v2, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformLibraryListRecyclerViewAdapter:Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;

    if-nez v2, :cond_2c

    invoke-static {v9}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v2, v11

    :cond_2c
    new-instance v3, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$onCreateView$12;

    invoke-direct {v3, v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$onCreateView$12;-><init>(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)V

    check-cast v3, Lkotlin/jvm/functions/Function4;

    invoke-virtual {v2, v3}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;->setOnItemLongClickListener(Lkotlin/jvm/functions/Function4;)V

    .line 1030
    new-instance v2, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v3

    sget-object v5, Lcom/magneticchen/daijishou/data/BooleanPreference;->PRETTIFY_TITLES:Lcom/magneticchen/daijishou/data/BooleanPreference;

    invoke-virtual {v5}, Lcom/magneticchen/daijishou/data/BooleanPreference;->getKey()Ljava/lang/String;

    move-result-object v5

    sget-object v6, Lcom/magneticchen/daijishou/data/BooleanPreference;->PRETTIFY_TITLES:Lcom/magneticchen/daijishou/data/BooleanPreference;

    invoke-virtual {v6}, Lcom/magneticchen/daijishou/data/BooleanPreference;->getDefaultValue()Z

    move-result v6

    invoke-direct {v2, v3, v5, v6}, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;-><init>(Landroid/content/SharedPreferences;Ljava/lang/String;Z)V

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;

    move-result-object v3

    new-instance v5, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$onCreateView$13;

    invoke-direct {v5, v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$onCreateView$13;-><init>(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)V

    check-cast v5, Lkotlin/jvm/functions/Function1;

    new-instance v6, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$sam$androidx_lifecycle_Observer$0;

    invoke-direct {v6, v5}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V

    check-cast v6, Landroidx/lifecycle/Observer;

    invoke-virtual {v2, v3, v6}, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;->observe(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

    .line 1046
    new-instance v2, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v3

    const-string v5, "do_not_prettify_titles_in_details_view"

    const/4 v6, 0x0

    invoke-direct {v2, v3, v5, v6}, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;-><init>(Landroid/content/SharedPreferences;Ljava/lang/String;Z)V

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;

    move-result-object v3

    new-instance v5, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$onCreateView$14;

    invoke-direct {v5, v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$onCreateView$14;-><init>(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)V

    check-cast v5, Lkotlin/jvm/functions/Function1;

    new-instance v6, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$sam$androidx_lifecycle_Observer$0;

    invoke-direct {v6, v5}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V

    check-cast v6, Landroidx/lifecycle/Observer;

    invoke-virtual {v2, v3, v6}, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;->observe(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

    .line 1063
    new-instance v2, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v3

    sget-object v5, Lcom/magneticchen/daijishou/data/BooleanPreference;->SHOW_RECENT_INDICATORS:Lcom/magneticchen/daijishou/data/BooleanPreference;

    invoke-virtual {v5}, Lcom/magneticchen/daijishou/data/BooleanPreference;->getKey()Ljava/lang/String;

    move-result-object v5

    sget-object v6, Lcom/magneticchen/daijishou/data/BooleanPreference;->SHOW_RECENT_INDICATORS:Lcom/magneticchen/daijishou/data/BooleanPreference;

    invoke-virtual {v6}, Lcom/magneticchen/daijishou/data/BooleanPreference;->getDefaultValue()Z

    move-result v6

    invoke-direct {v2, v3, v5, v6}, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;-><init>(Landroid/content/SharedPreferences;Ljava/lang/String;Z)V

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;

    move-result-object v3

    new-instance v5, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$onCreateView$15;

    invoke-direct {v5, v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$onCreateView$15;-><init>(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)V

    check-cast v5, Lkotlin/jvm/functions/Function1;

    new-instance v6, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$sam$androidx_lifecycle_Observer$0;

    invoke-direct {v6, v5}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V

    check-cast v6, Landroidx/lifecycle/Observer;

    invoke-virtual {v2, v3, v6}, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;->observe(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

    .line 1067
    new-instance v2, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v3

    sget-object v5, Lcom/magneticchen/daijishou/data/BooleanPreference;->FORCE_SET_WALLPAPER_FOR_ALL:Lcom/magneticchen/daijishou/data/BooleanPreference;

    invoke-virtual {v5}, Lcom/magneticchen/daijishou/data/BooleanPreference;->getKey()Ljava/lang/String;

    move-result-object v5

    sget-object v6, Lcom/magneticchen/daijishou/data/BooleanPreference;->FORCE_SET_WALLPAPER_FOR_ALL:Lcom/magneticchen/daijishou/data/BooleanPreference;

    invoke-virtual {v6}, Lcom/magneticchen/daijishou/data/BooleanPreference;->getDefaultValue()Z

    move-result v6

    invoke-direct {v2, v3, v5, v6}, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;-><init>(Landroid/content/SharedPreferences;Ljava/lang/String;Z)V

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;

    move-result-object v3

    new-instance v5, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$onCreateView$16;

    invoke-direct {v5, v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$onCreateView$16;-><init>(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)V

    check-cast v5, Lkotlin/jvm/functions/Function1;

    new-instance v6, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$sam$androidx_lifecycle_Observer$0;

    invoke-direct {v6, v5}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V

    check-cast v6, Landroidx/lifecycle/Observer;

    invoke-virtual {v2, v3, v6}, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;->observe(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

    .line 1120
    new-instance v2, Lkotlin/jvm/internal/Ref$BooleanRef;

    invoke-direct {v2}, Lkotlin/jvm/internal/Ref$BooleanRef;-><init>()V

    invoke-direct {v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getMergePlayableItemsPreference()Z

    move-result v3

    iput-boolean v3, v2, Lkotlin/jvm/internal/Ref$BooleanRef;->element:Z

    .line 1121
    new-instance v3, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v5

    sget-object v6, Lcom/magneticchen/daijishou/data/BooleanPreference;->MERGE_PLAYABLE_ITEMS:Lcom/magneticchen/daijishou/data/BooleanPreference;

    invoke-virtual {v6}, Lcom/magneticchen/daijishou/data/BooleanPreference;->getKey()Ljava/lang/String;

    move-result-object v6

    sget-object v7, Lcom/magneticchen/daijishou/data/BooleanPreference;->MERGE_PLAYABLE_ITEMS:Lcom/magneticchen/daijishou/data/BooleanPreference;

    invoke-virtual {v7}, Lcom/magneticchen/daijishou/data/BooleanPreference;->getDefaultValue()Z

    move-result v7

    invoke-direct {v3, v5, v6, v7}, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;-><init>(Landroid/content/SharedPreferences;Ljava/lang/String;Z)V

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;

    move-result-object v5

    new-instance v6, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$onCreateView$17;

    invoke-direct {v6, v2, v0, v4}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$onCreateView$17;-><init>(Lkotlin/jvm/internal/Ref$BooleanRef;Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/content/SharedPreferences;)V

    check-cast v6, Lkotlin/jvm/functions/Function1;

    new-instance v2, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$sam$androidx_lifecycle_Observer$0;

    invoke-direct {v2, v6}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V

    check-cast v2, Landroidx/lifecycle/Observer;

    invoke-virtual {v3, v5, v2}, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;->observe(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

    .line 1127
    iget-object v2, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->backgroundImageView:Landroid/widget/ImageView;

    if-nez v2, :cond_2d

    const-string v2, "backgroundImageView"

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_4

    :cond_2d
    move-object v11, v2

    :goto_4
    invoke-virtual {v11}, Landroid/widget/ImageView;->getAlpha()F

    move-result v2

    .line 1128
    new-instance v3, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v5

    const-string v6, "use_pure_dark_theme"

    const/4 v7, 0x0

    invoke-direct {v3, v5, v6, v7}, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;-><init>(Landroid/content/SharedPreferences;Ljava/lang/String;Z)V

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;

    move-result-object v5

    new-instance v6, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$onCreateView$18;

    invoke-direct {v6, v0, v2}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$onCreateView$18;-><init>(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;F)V

    check-cast v6, Lkotlin/jvm/functions/Function1;

    new-instance v2, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$sam$androidx_lifecycle_Observer$0;

    invoke-direct {v2, v6}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V

    check-cast v2, Landroidx/lifecycle/Observer;

    invoke-virtual {v3, v5, v2}, Lcom/magneticchen/daijishou/data/live/SharedPreferenceBooleanLiveData;->observe(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

    .line 1139
    invoke-direct {v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getLibraryViewModel()Lcom/magneticchen/daijishou/ui/model/LibraryViewModel;

    move-result-object v2

    invoke-virtual {v2}, Lcom/magneticchen/daijishou/ui/model/LibraryViewModel;->getAllPlayableItems()Landroidx/lifecycle/LiveData;

    move-result-object v2

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;

    move-result-object v3

    new-instance v5, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$onCreateView$19;

    invoke-direct {v5, v0, v4}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$onCreateView$19;-><init>(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;Landroid/content/SharedPreferences;)V

    check-cast v5, Lkotlin/jvm/functions/Function1;

    new-instance v4, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$sam$androidx_lifecycle_Observer$0;

    invoke-direct {v4, v5}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V

    check-cast v4, Landroidx/lifecycle/Observer;

    invoke-virtual {v2, v3, v4}, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

    .line 1143
    invoke-virtual {v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getDaijishouLibrary()Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object v2

    iget-wide v3, v0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformId:J

    invoke-virtual {v2, v3, v4}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->getPlatformById(J)Landroidx/lifecycle/LiveData;

    move-result-object v2

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;

    move-result-object v3

    new-instance v4, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$onCreateView$20;

    invoke-direct {v4, v0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$onCreateView$20;-><init>(Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;)V

    check-cast v4, Lkotlin/jvm/functions/Function1;

    new-instance v5, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$sam$androidx_lifecycle_Observer$0;

    invoke-direct {v5, v4}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$sam$androidx_lifecycle_Observer$0;-><init>(Lkotlin/jvm/functions/Function1;)V

    check-cast v5, Landroidx/lifecycle/Observer;

    invoke-virtual {v2, v3, v5}, Landroidx/lifecycle/LiveData;->observe(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V

    invoke-static {v0, v1}, Lcom/magneticchen/daijishou/arcade/ArcadeUIController;->setupLibraryLegendBar(Landroidx/fragment/app/Fragment;Landroid/view/View;)V

    return-object v1
.end method

.method public onHotKeyPressed(IILandroid/view/KeyEvent;)Z
    .locals 1

    const-string v0, "keyEvent"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 190
    invoke-super {p0, p1, p2, p3}, Lcom/magneticchen/daijishou/ui/fragments/abstract/PlatformNavFragment;->onHotKeyPressed(IILandroid/view/KeyEvent;)Z

    const/4 p2, 0x1

    if-eq p1, p2, :cond_6

    const/4 p3, 0x2

    if-eq p1, p3, :cond_5

    const/4 p3, 0x3

    if-eq p1, p3, :cond_4

    const/4 p3, 0x4

    if-eq p1, p3, :cond_0

    goto :goto_0

    .line 205
    :cond_0
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformLibraryListRecyclerViewAdapter:Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;

    if-nez p1, :cond_1

    const-string p1, "platformLibraryListRecyclerViewAdapter"

    invoke-static {p1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 p1, 0x0

    :cond_1
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment$PlatformLibraryListAdapter;->getSelectedViewHolder()Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;

    move-result-object p1

    if-eqz p1, :cond_3

    .line 206
    iget-object p3, p1, Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {p3}, Landroid/view/View;->isFocused()Z

    move-result p3

    if-eqz p3, :cond_2

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;->getAbsoluteAdapterPosition()I

    move-result p3

    if-ltz p3, :cond_2

    iget-object p1, p1, Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;->itemView:Landroid/view/View;

    invoke-virtual {p1}, Landroid/view/View;->performLongClick()Z

    :cond_2
    return p2

    :cond_3
    :goto_0
    const/4 p1, 0x0

    return p1

    .line 201
    :cond_4
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->toggleViewMode()V

    return p2

    :cond_5
    const/4 p1, -0x1

    .line 193
    invoke-direct {p0, p1}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->hopToNextItemByFirstCharacter(I)V

    return p2

    .line 197
    :cond_6
    invoke-direct {p0, p2}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->hopToNextItemByFirstCharacter(I)V

    return p2
.end method

.method public onKioskMode()V
    .locals 9

    .line 166
    invoke-super {p0}, Lcom/magneticchen/daijishou/ui/fragments/abstract/PlatformNavFragment;->onKioskMode()V

    .line 167
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->editButton:Lcom/google/android/material/chip/Chip;

    const-string v1, "editButton"

    const/4 v2, 0x0

    if-nez v0, :cond_0

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v2

    :cond_0
    const/16 v3, 0x8

    invoke-virtual {v0, v3}, Lcom/google/android/material/chip/Chip;->setVisibility(I)V

    .line 168
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->gridViewButton:Lcom/google/android/material/chip/Chip;

    const-string v3, "gridViewButton"

    if-nez v0, :cond_1

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v2

    :cond_1
    iget-object v4, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->playButton:Lcom/google/android/material/chip/Chip;

    if-nez v4, :cond_2

    const-string v4, "playButton"

    invoke-static {v4}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v4, v2

    :cond_2
    invoke-virtual {v4}, Lcom/google/android/material/chip/Chip;->getId()I

    move-result v4

    invoke-virtual {v0, v4}, Lcom/google/android/material/chip/Chip;->setNextFocusRightId(I)V

    .line 169
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->gridViewButton:Lcom/google/android/material/chip/Chip;

    if-nez v0, :cond_3

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v2

    :cond_3
    check-cast v0, Landroid/view/View;

    .line 1197
    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    if-eqz v3, :cond_9

    check-cast v3, Lcom/google/android/material/chip/ChipGroup$LayoutParams;

    check-cast v3, Landroid/view/ViewGroup$LayoutParams;

    .line 1198
    move-object v4, v3

    check-cast v4, Lcom/google/android/material/chip/ChipGroup$LayoutParams;

    .line 170
    iget-object v5, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->chipGroup:Lcom/google/android/material/chip/ChipGroup;

    const-string v6, "chipGroup"

    if-nez v5, :cond_4

    invoke-static {v6}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v5, v2

    :cond_4
    check-cast v5, Landroid/view/ViewGroup;

    invoke-static {v5}, Landroidx/core/view/ViewGroupKt;->getChildren(Landroid/view/ViewGroup;)Lkotlin/sequences/Sequence;

    move-result-object v5

    .line 1199
    invoke-interface {v5}, Lkotlin/sequences/Sequence;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_5
    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_8

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/view/View;

    .line 171
    iget-object v8, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->editButton:Lcom/google/android/material/chip/Chip;

    if-nez v8, :cond_6

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v8, v2

    :cond_6
    invoke-static {v7, v8}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_5

    .line 172
    iget-object v8, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->chipGroup:Lcom/google/android/material/chip/ChipGroup;

    if-nez v8, :cond_7

    invoke-static {v6}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v8, v2

    :cond_7
    invoke-virtual {v8, v7}, Lcom/google/android/material/chip/ChipGroup;->removeView(Landroid/view/View;)V

    goto :goto_0

    .line 175
    :cond_8
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getDpToPxConverter()Lcom/magneticchen/daijishou/utils/DpToPxConverter;

    move-result-object v1

    const/high16 v2, 0x41000000    # 8.0f

    invoke-virtual {v1, v2}, Lcom/magneticchen/daijishou/utils/DpToPxConverter;->convert(F)I

    move-result v1

    invoke-virtual {v4, v1}, Lcom/google/android/material/chip/ChipGroup$LayoutParams;->setMarginEnd(I)V

    .line 1201
    invoke-virtual {v0, v3}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    return-void

    .line 1197
    :cond_9
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "null cannot be cast to non-null type com.google.android.material.chip.ChipGroup.LayoutParams"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public onNoneKioskMode()V
    .locals 7

    .line 180
    invoke-super {p0}, Lcom/magneticchen/daijishou/ui/fragments/abstract/PlatformNavFragment;->onNoneKioskMode()V

    .line 181
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->editButton:Lcom/google/android/material/chip/Chip;

    const-string v1, "editButton"

    const/4 v2, 0x0

    if-nez v0, :cond_0

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v2

    :cond_0
    const/4 v3, 0x0

    invoke-virtual {v0, v3}, Lcom/google/android/material/chip/Chip;->setVisibility(I)V

    .line 182
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->gridViewButton:Lcom/google/android/material/chip/Chip;

    const-string v3, "gridViewButton"

    if-nez v0, :cond_1

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v2

    :cond_1
    iget-object v4, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->editButton:Lcom/google/android/material/chip/Chip;

    if-nez v4, :cond_2

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v4, v2

    :cond_2
    invoke-virtual {v4}, Lcom/google/android/material/chip/Chip;->getId()I

    move-result v4

    invoke-virtual {v0, v4}, Lcom/google/android/material/chip/Chip;->setNextFocusRightId(I)V

    .line 183
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->gridViewButton:Lcom/google/android/material/chip/Chip;

    if-nez v0, :cond_3

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v2

    :cond_3
    check-cast v0, Landroid/view/View;

    .line 1203
    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    if-eqz v3, :cond_6

    check-cast v3, Lcom/google/android/material/chip/ChipGroup$LayoutParams;

    check-cast v3, Landroid/view/ViewGroup$LayoutParams;

    .line 1204
    move-object v4, v3

    check-cast v4, Lcom/google/android/material/chip/ChipGroup$LayoutParams;

    .line 184
    iget-object v5, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->chipGroup:Lcom/google/android/material/chip/ChipGroup;

    if-nez v5, :cond_4

    const-string v5, "chipGroup"

    invoke-static {v5}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v5, v2

    :cond_4
    iget-object v6, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->editButton:Lcom/google/android/material/chip/Chip;

    if-nez v6, :cond_5

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_0

    :cond_5
    move-object v2, v6

    :goto_0
    check-cast v2, Landroid/view/View;

    invoke-virtual {v5, v2}, Lcom/google/android/material/chip/ChipGroup;->addView(Landroid/view/View;)V

    .line 185
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getDpToPxConverter()Lcom/magneticchen/daijishou/utils/DpToPxConverter;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/magneticchen/daijishou/utils/DpToPxConverter;->convert(F)I

    move-result v1

    invoke-virtual {v4, v1}, Lcom/google/android/material/chip/ChipGroup$LayoutParams;->setMarginEnd(I)V

    .line 1205
    invoke-virtual {v0, v3}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    return-void

    .line 1203
    :cond_6
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "null cannot be cast to non-null type com.google.android.material.chip.ChipGroup.LayoutParams"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public onResume()V
    .locals 5

    .line 1158
    invoke-super {p0}, Lcom/magneticchen/daijishou/ui/fragments/abstract/PlatformNavFragment;->onResume()V

    .line 1159
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformLibraryListRecyclerView:Landroidx/recyclerview/widget/RecyclerView;

    const/4 v1, 0x0

    if-nez v0, :cond_0

    const-string v0, "platformLibraryListRecyclerView"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_0
    invoke-virtual {v0}, Landroidx/recyclerview/widget/RecyclerView;->requestFocus()Z

    .line 1160
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->getModel()Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;

    move-result-object v0

    iget-object v2, p0, Lcom/magneticchen/daijishou/ui/fragments/nav/PlatformLibraryListViewNavFragment;->platformEntity:Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;

    if-eqz v2, :cond_1

    invoke-virtual {v2}, Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;->getShortname()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_1

    sget-object v3, Ljava/util/Locale;->ROOT:Ljava/util/Locale;

    invoke-virtual {v2, v3}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "toUpperCase(...)"

    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    goto :goto_0

    :cond_1
    move-object v2, v1

    :goto_0
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " platform"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    const/4 v4, 0x2

    invoke-static {v0, v2, v3, v4, v1}, Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;->setTips$default(Lcom/magneticchen/daijishou/ui/model/DaijishouViewModel;Ljava/lang/String;ZILjava/lang/Object;)V

    return-void
.end method
