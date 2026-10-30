.class public final Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;
.super Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouDialogFragment;
.source "EditPlayableItemDialogFragment.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$Companion;
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nEditPlayableItemDialogFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EditPlayableItemDialogFragment.kt\ncom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment\n+ 2 SerialFormat.kt\nkotlinx/serialization/SerialFormatKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,572:1\n113#2:573\n113#2:578\n113#2:579\n113#2:580\n1863#3,2:574\n1863#3,2:576\n1863#3,2:581\n37#4,2:583\n*S KotlinDebug\n*F\n+ 1 EditPlayableItemDialogFragment.kt\ncom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment\n*L\n84#1:573\n105#1:578\n129#1:579\n153#1:580\n470#1:574,2\n473#1:576,2\n332#1:581,2\n341#1:583,2\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0008\u0010\u000b\u001a\u00020\u0007H\u0002J\u0012\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\u000c\u0012\n \u0008*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u000c\u0012\n \u0008*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u000c\u0012\n \u0008*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"
    }
    d2 = {
        "Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;",
        "Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouDialogFragment;",
        "()V",
        "playableItemEntity",
        "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;",
        "setBoxArtActivity",
        "Landroidx/activity/result/ActivityResultLauncher;",
        "",
        "kotlin.jvm.PlatformType",
        "setSnapshotActivity",
        "setTitleActivity",
        "checkPreviewMediaDirectory",
        "onCreateDialog",
        "Landroid/app/Dialog;",
        "savedInstanceState",
        "Landroid/os/Bundle;",
        "onStart",
        "",
        "Companion",
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
.field public static final Companion:Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$Companion;


# instance fields
.field private playableItemEntity:Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;

.field private setBoxArtActivity:Landroidx/activity/result/ActivityResultLauncher;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/activity/result/ActivityResultLauncher<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private setSnapshotActivity:Landroidx/activity/result/ActivityResultLauncher;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/activity/result/ActivityResultLauncher<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private setTitleActivity:Landroidx/activity/result/ActivityResultLauncher;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/activity/result/ActivityResultLauncher<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public static synthetic $r8$lambda$12GyW7ruptK5jBh31FLIDqI5wDs(Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;Ljava/lang/String;Landroid/view/View;)V
    .locals 0

    invoke-static {p0, p1, p2, p3, p4}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$10(Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;Ljava/lang/String;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$4d_kC8kWL7UHQmNUTpTiz_YpNd0(Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Landroid/net/Uri;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->setBoxArtActivity$lambda$0(Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Landroid/net/Uri;)V

    return-void
.end method

.method public static synthetic $r8$lambda$6HCGtrb0XLp02XoYtNdGqSiilKw(Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Landroid/net/Uri;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->setTitleActivity$lambda$2(Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Landroid/net/Uri;)V

    return-void
.end method

.method public static synthetic $r8$lambda$9jMvXHR2Ymdxr8qToJ5YlkkutP0(Lcom/google/android/material/switchmaterial/SwitchMaterial;Landroid/widget/AutoCompleteTextView;Landroid/widget/CompoundButton;Z)V
    .locals 0

    invoke-static {p0, p1, p2, p3}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$14(Lcom/google/android/material/switchmaterial/SwitchMaterial;Landroid/widget/AutoCompleteTextView;Landroid/widget/CompoundButton;Z)V

    return-void
.end method

.method public static synthetic $r8$lambda$CxxzKaNx-47id7t9QVcG-FsW0Oo(Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;Landroid/widget/EditText;Landroid/widget/CheckBox;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Landroid/widget/AutoCompleteTextView;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlin/jvm/internal/Ref$BooleanRef;Ljava/util/List;Landroid/view/View;)V
    .locals 0

    invoke-static/range {p0 .. p14}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$13(Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;Landroid/widget/EditText;Landroid/widget/CheckBox;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Landroid/widget/AutoCompleteTextView;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlin/jvm/internal/Ref$BooleanRef;Ljava/util/List;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$KwvIzNfj6oapa2WA9A6Ay8yjDbU(Landroid/app/AlertDialog;Landroid/content/Context;Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Landroid/widget/EditText;Landroid/widget/CheckBox;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Landroid/widget/AutoCompleteTextView;Ljava/util/List;Ljava/util/List;Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;Ljava/util/List;Lkotlin/jvm/internal/Ref$BooleanRef;Ljava/util/List;Landroid/content/DialogInterface;)V
    .locals 0

    invoke-static/range {p0 .. p16}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$23(Landroid/app/AlertDialog;Landroid/content/Context;Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Landroid/widget/EditText;Landroid/widget/CheckBox;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Landroid/widget/AutoCompleteTextView;Ljava/util/List;Ljava/util/List;Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;Ljava/util/List;Lkotlin/jvm/internal/Ref$BooleanRef;Ljava/util/List;Landroid/content/DialogInterface;)V

    return-void
.end method

.method public static synthetic $r8$lambda$M33SpPkc674f8ArSmVB1rHHhCgQ(Landroid/content/DialogInterface;I)V
    .locals 0

    invoke-static {p0, p1}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$20(Landroid/content/DialogInterface;I)V

    return-void
.end method

.method public static synthetic $r8$lambda$Q_4HMpq8EaaX-pX18HRMkU1ROG0(Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Landroid/app/AlertDialog;Landroid/content/Context;Landroid/widget/Button;Landroid/view/View;)V
    .locals 0

    invoke-static/range {p0 .. p5}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$23$lambda$22(Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Landroid/app/AlertDialog;Landroid/content/Context;Landroid/widget/Button;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$UeFRUh7LW-McEoHvwwF8sXd4UBw(Lcom/google/android/material/textfield/TextInputEditText;Ljava/util/List;Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Landroid/content/Context;Lcom/google/android/material/chip/ChipGroup;Landroid/view/View;)V
    .locals 0

    invoke-static/range {p0 .. p5}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$11(Lcom/google/android/material/textfield/TextInputEditText;Ljava/util/List;Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Landroid/content/Context;Lcom/google/android/material/chip/ChipGroup;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$Vf6uPQE2g3gvwNVJR-1GJsUfB0s(Ljava/util/List;Ljava/lang/String;Lcom/google/android/material/chip/ChipGroup;Landroid/view/View;)V
    .locals 0

    invoke-static {p0, p1, p2, p3}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->onCreateDialog$lambda$26$lambda$25$lambda$24$addGenreId$lambda$6(Ljava/util/List;Ljava/lang/String;Lcom/google/android/material/chip/ChipGroup;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$X3MgNgE2rqEjfa_Ly4eoSLX812s(Landroid/content/DialogInterface;I)V
    .locals 0

    invoke-static {p0, p1}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$17(Landroid/content/DialogInterface;I)V

    return-void
.end method

.method public static synthetic $r8$lambda$Y5KxB-XQrhgbFmaS0pWNp5hEcxc(Landroid/content/DialogInterface;I)V
    .locals 0

    invoke-static {p0, p1}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$19(Landroid/content/DialogInterface;I)V

    return-void
.end method

.method public static synthetic $r8$lambda$YFsx3Slv6QzQbJBtLUvNbt8f_Qk(Landroid/widget/AutoCompleteTextView;Ljava/util/List;Ljava/util/List;Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Ljava/util/List;Lcom/google/android/material/textfield/TextInputEditText;Landroid/content/Context;Lcom/google/android/material/chip/ChipGroup;Landroid/view/View;)V
    .locals 0

    invoke-static/range {p0 .. p8}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$8(Landroid/widget/AutoCompleteTextView;Ljava/util/List;Ljava/util/List;Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Ljava/util/List;Lcom/google/android/material/textfield/TextInputEditText;Landroid/content/Context;Lcom/google/android/material/chip/ChipGroup;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$a1zxOYC4JNED_b9v0qRbFfLSWuo(Landroid/app/AlertDialog;Landroid/content/Context;Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Landroid/widget/EditText;Landroid/widget/CheckBox;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Landroid/widget/AutoCompleteTextView;Ljava/util/List;Ljava/util/List;Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;Ljava/util/List;Lkotlin/jvm/internal/Ref$BooleanRef;Ljava/util/List;Landroid/view/View;)V
    .locals 0

    invoke-static/range {p0 .. p16}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$23$lambda$21(Landroid/app/AlertDialog;Landroid/content/Context;Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Landroid/widget/EditText;Landroid/widget/CheckBox;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Landroid/widget/AutoCompleteTextView;Ljava/util/List;Ljava/util/List;Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;Ljava/util/List;Lkotlin/jvm/internal/Ref$BooleanRef;Ljava/util/List;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$lnOJdwRFZkO3tvVf2_Y_GNrLp1c(Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Landroid/net/Uri;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->setSnapshotActivity$lambda$1(Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Landroid/net/Uri;)V

    return-void
.end method

.method public static synthetic $r8$lambda$m39utMaVejVDiD6qnRG0hjMSBM4(Landroid/content/DialogInterface;I)V
    .locals 0

    invoke-static {p0, p1}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$18(Landroid/content/DialogInterface;I)V

    return-void
.end method

.method public static synthetic $r8$lambda$woLTRlh3k0JueASYzStP0kbTeys(Lkotlin/jvm/internal/Ref$BooleanRef;Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;Landroid/widget/TextView;Landroid/view/View;)V
    .locals 0

    invoke-static {p0, p1, p2, p3}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$12(Lkotlin/jvm/internal/Ref$BooleanRef;Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;Landroid/widget/TextView;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$zALpJMlB4eUCXMOe0-GYTfF2H9E(Ljava/util/List;Ljava/lang/String;Lcom/google/android/material/chip/ChipGroup;Landroid/view/View;)V
    .locals 0

    invoke-static {p0, p1, p2, p3}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->onCreateDialog$lambda$26$lambda$25$lambda$24$addScraperKeyword$lambda$5(Ljava/util/List;Ljava/lang/String;Lcom/google/android/material/chip/ChipGroup;Landroid/view/View;)V

    return-void
.end method

.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$Companion;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    sput-object v0, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->Companion:Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$Companion;

    return-void
.end method

.method public constructor <init>()V
    .locals 3

    .line 61
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouDialogFragment;-><init>()V

    .line 91
    new-instance v0, Landroidx/activity/result/contract/ActivityResultContracts$GetContent;

    invoke-direct {v0}, Landroidx/activity/result/contract/ActivityResultContracts$GetContent;-><init>()V

    check-cast v0, Landroidx/activity/result/contract/ActivityResultContract;

    new-instance v1, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$$ExternalSyntheticLambda4;

    invoke-direct {v1, p0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$$ExternalSyntheticLambda4;-><init>(Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;)V

    invoke-virtual {p0, v0, v1}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->registerForActivityResult(Landroidx/activity/result/contract/ActivityResultContract;Landroidx/activity/result/ActivityResultCallback;)Landroidx/activity/result/ActivityResultLauncher;

    move-result-object v0

    const-string v1, "registerForActivityResult(...)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->setBoxArtActivity:Landroidx/activity/result/ActivityResultLauncher;

    .line 115
    new-instance v0, Landroidx/activity/result/contract/ActivityResultContracts$GetContent;

    invoke-direct {v0}, Landroidx/activity/result/contract/ActivityResultContracts$GetContent;-><init>()V

    check-cast v0, Landroidx/activity/result/contract/ActivityResultContract;

    new-instance v2, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$$ExternalSyntheticLambda5;

    invoke-direct {v2, p0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$$ExternalSyntheticLambda5;-><init>(Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;)V

    invoke-virtual {p0, v0, v2}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->registerForActivityResult(Landroidx/activity/result/contract/ActivityResultContract;Landroidx/activity/result/ActivityResultCallback;)Landroidx/activity/result/ActivityResultLauncher;

    move-result-object v0

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->setSnapshotActivity:Landroidx/activity/result/ActivityResultLauncher;

    .line 139
    new-instance v0, Landroidx/activity/result/contract/ActivityResultContracts$GetContent;

    invoke-direct {v0}, Landroidx/activity/result/contract/ActivityResultContracts$GetContent;-><init>()V

    check-cast v0, Landroidx/activity/result/contract/ActivityResultContract;

    new-instance v2, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$$ExternalSyntheticLambda6;

    invoke-direct {v2, p0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$$ExternalSyntheticLambda6;-><init>(Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;)V

    invoke-virtual {p0, v0, v2}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->registerForActivityResult(Landroidx/activity/result/contract/ActivityResultContract;Landroidx/activity/result/ActivityResultCallback;)Landroidx/activity/result/ActivityResultLauncher;

    move-result-object v0

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->setTitleActivity:Landroidx/activity/result/ActivityResultLauncher;

    return-void
.end method

.method public static final synthetic access$getDaijishouLibrary(Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;)Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;
    .locals 0

    .line 61
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getDaijishouLibrary()Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object p0

    return-object p0
.end method

.method public static final synthetic access$getSetBoxArtActivity$p(Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;)Landroidx/activity/result/ActivityResultLauncher;
    .locals 0

    .line 61
    iget-object p0, p0, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->setBoxArtActivity:Landroidx/activity/result/ActivityResultLauncher;

    return-object p0
.end method

.method public static final synthetic access$getSetSnapshotActivity$p(Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;)Landroidx/activity/result/ActivityResultLauncher;
    .locals 0

    .line 61
    iget-object p0, p0, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->setSnapshotActivity:Landroidx/activity/result/ActivityResultLauncher;

    return-object p0
.end method

.method public static final synthetic access$getSetTitleActivity$p(Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;)Landroidx/activity/result/ActivityResultLauncher;
    .locals 0

    .line 61
    iget-object p0, p0, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->setTitleActivity:Landroidx/activity/result/ActivityResultLauncher;

    return-object p0
.end method

.method private final checkPreviewMediaDirectory()Ljava/lang/String;
    .locals 9

    .line 73
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->requireContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroidx/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 74
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->requireContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/preview_media/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "preview_media_path"

    invoke-interface {v0, v2, v1}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 75
    iget-object v1, p0, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->playableItemEntity:Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;

    const-string v2, "playableItemEntity"

    const/4 v3, 0x0

    if-nez v1, :cond_0

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v1, v3

    :cond_0
    invoke-virtual {v1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getPreviewMediaPath()Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_2

    iget-object v1, p0, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->playableItemEntity:Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;

    if-nez v1, :cond_1

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v1, v3

    :cond_1
    invoke-virtual {v1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getId()J

    move-result-wide v1

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_2
    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->playableItemEntity:Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;

    if-nez v0, :cond_3

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v3

    :cond_3
    invoke-virtual {v0}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getPreviewMediaPath()Ljava/lang/String;

    move-result-object v0

    :goto_0
    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    .line 76
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "index.json"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 77
    new-instance v2, Ljava/io/File;

    invoke-direct {v2, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_4

    return-object v0

    .line 79
    :cond_4
    new-instance v2, Ljava/io/File;

    invoke-direct {v2, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 80
    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v4

    if-nez v4, :cond_5

    .line 81
    invoke-virtual {v2}, Ljava/io/File;->mkdirs()Z

    .line 83
    :cond_5
    sget-object v2, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$checkPreviewMediaDirectory$jsonFormat$1;->INSTANCE:Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$checkPreviewMediaDirectory$jsonFormat$1;

    check-cast v2, Lkotlin/jvm/functions/Function1;

    const/4 v4, 0x1

    invoke-static {v3, v2, v4, v3}, Lkotlinx/serialization/json/JsonKt;->Json$default(Lkotlinx/serialization/json/Json;Lkotlin/jvm/functions/Function1;ILjava/lang/Object;)Lkotlinx/serialization/json/Json;

    move-result-object v2

    .line 84
    check-cast v2, Lkotlinx/serialization/StringFormat;

    new-instance v3, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;

    const/4 v7, 0x7

    const/4 v8, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    invoke-direct/range {v3 .. v8}, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/jvm/internal/DefaultConstructorMarker;)V

    .line 573
    invoke-interface {v2}, Lkotlinx/serialization/StringFormat;->getSerializersModule()Lkotlinx/serialization/modules/SerializersModule;

    sget-object v4, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;->Companion:Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex$Companion;

    invoke-virtual {v4}, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex$Companion;->serializer()Lkotlinx/serialization/KSerializer;

    move-result-object v4

    check-cast v4, Lkotlinx/serialization/SerializationStrategy;

    invoke-interface {v2, v4, v3}, Lkotlinx/serialization/StringFormat;->encodeToString(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 85
    new-instance v3, Ljava/io/OutputStreamWriter;

    new-instance v4, Ljava/io/FileOutputStream;

    invoke-direct {v4, v1}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V

    check-cast v4, Ljava/io/OutputStream;

    invoke-direct {v3, v4}, Ljava/io/OutputStreamWriter;-><init>(Ljava/io/OutputStream;)V

    .line 86
    invoke-virtual {v3, v2}, Ljava/io/OutputStreamWriter;->write(Ljava/lang/String;)V

    .line 87
    invoke-virtual {v3}, Ljava/io/OutputStreamWriter;->close()V

    return-object v0
.end method

.method private static final onCreateDialog$lambda$26$lambda$25$lambda$24$addGenreId(Lcom/google/android/material/textfield/TextInputEditText;Ljava/util/List;Landroid/content/Context;Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Lcom/google/android/material/chip/ChipGroup;Ljava/lang/String;Z)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/material/textfield/TextInputEditText;",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;",
            "Landroid/content/Context;",
            "Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;",
            "Lcom/google/android/material/chip/ChipGroup;",
            "Ljava/lang/String;",
            "Z)V"
        }
    .end annotation

    const/4 v0, 0x0

    .line 245
    invoke-virtual {p0, v0}, Lcom/google/android/material/textfield/TextInputEditText;->setError(Ljava/lang/CharSequence;)V

    .line 246
    invoke-interface {p1, p5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 248
    new-instance p0, Lcom/google/android/material/chip/Chip;

    invoke-direct {p0, p2}, Lcom/google/android/material/chip/Chip;-><init>(Landroid/content/Context;)V

    .line 249
    invoke-static {}, Landroid/view/View;->generateViewId()I

    move-result p2

    invoke-virtual {p0, p2}, Lcom/google/android/material/chip/Chip;->setId(I)V

    .line 250
    sget-object p2, Lcom/magneticchen/daijishou/data/Genres;->INSTANCE:Lcom/magneticchen/daijishou/data/Genres;

    invoke-virtual {p2}, Lcom/magneticchen/daijishou/data/Genres;->getGenres()Ljava/util/HashMap;

    move-result-object p2

    invoke-virtual {p2, p5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p2

    invoke-static {p2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    check-cast p2, Lcom/magneticchen/daijishou/data/Genre;

    invoke-virtual {p2}, Lcom/magneticchen/daijishou/data/Genre;->getNameStringId()I

    move-result p2

    invoke-virtual {p3, p2}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object p2

    check-cast p2, Ljava/lang/CharSequence;

    invoke-virtual {p0, p2}, Lcom/google/android/material/chip/Chip;->setText(Ljava/lang/CharSequence;)V

    const/4 p2, 0x1

    .line 251
    invoke-virtual {p0, p2}, Lcom/google/android/material/chip/Chip;->setCloseIconVisible(Z)V

    .line 252
    new-instance v0, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$$ExternalSyntheticLambda8;

    invoke-direct {v0, p1, p5, p4}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$$ExternalSyntheticLambda8;-><init>(Ljava/util/List;Ljava/lang/String;Lcom/google/android/material/chip/ChipGroup;)V

    invoke-virtual {p0, v0}, Lcom/google/android/material/chip/Chip;->setOnCloseIconClickListener(Landroid/view/View$OnClickListener;)V

    .line 256
    invoke-static {p4}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    move-object p1, p4

    check-cast p1, Landroid/view/ViewGroup;

    invoke-virtual {p4}, Lcom/google/android/material/chip/ChipGroup;->getChildCount()I

    move-result p5

    sub-int/2addr p5, p2

    invoke-static {p1, p5}, Landroidx/core/view/ViewGroupKt;->get(Landroid/view/ViewGroup;I)Landroid/view/View;

    move-result-object p1

    const/4 p2, -0x1

    invoke-virtual {p1, p2}, Landroid/view/View;->setNextFocusRightId(I)V

    .line 257
    invoke-virtual {p0}, Lcom/google/android/material/chip/Chip;->getId()I

    move-result p1

    invoke-virtual {p0, p1}, Lcom/google/android/material/chip/Chip;->setNextFocusRightId(I)V

    .line 258
    check-cast p0, Landroid/view/View;

    invoke-virtual {p4, p0}, Lcom/google/android/material/chip/ChipGroup;->addView(Landroid/view/View;)V

    if-eqz p6, :cond_0

    .line 259
    invoke-virtual {p3}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->requireContext()Landroid/content/Context;

    move-result-object p0

    const p1, 0x7f14004b

    invoke-virtual {p3, p1}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object p1

    check-cast p1, Ljava/lang/CharSequence;

    const/4 p2, 0x0

    invoke-static {p0, p1, p2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object p0

    invoke-virtual {p0}, Landroid/widget/Toast;->show()V

    :cond_0
    return-void
.end method

.method static synthetic onCreateDialog$lambda$26$lambda$25$lambda$24$addGenreId$default(Lcom/google/android/material/textfield/TextInputEditText;Ljava/util/List;Landroid/content/Context;Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Lcom/google/android/material/chip/ChipGroup;Ljava/lang/String;ZILjava/lang/Object;)V
    .locals 7

    and-int/lit8 p7, p7, 0x40

    if-eqz p7, :cond_0

    const/4 p6, 0x1

    :cond_0
    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    move v6, p6

    .line 244
    invoke-static/range {v0 .. v6}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->onCreateDialog$lambda$26$lambda$25$lambda$24$addGenreId(Lcom/google/android/material/textfield/TextInputEditText;Ljava/util/List;Landroid/content/Context;Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Lcom/google/android/material/chip/ChipGroup;Ljava/lang/String;Z)V

    return-void
.end method

.method private static final onCreateDialog$lambda$26$lambda$25$lambda$24$addGenreId$lambda$6(Ljava/util/List;Ljava/lang/String;Lcom/google/android/material/chip/ChipGroup;Landroid/view/View;)V
    .locals 1

    const-string v0, "$genreIdList"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "$genreId"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 253
    invoke-interface {p0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 254
    invoke-virtual {p2, p3}, Lcom/google/android/material/chip/ChipGroup;->removeView(Landroid/view/View;)V

    return-void
.end method

.method private static final onCreateDialog$lambda$26$lambda$25$lambda$24$addScraperKeyword(Lcom/google/android/material/textfield/TextInputEditText;Ljava/util/List;Landroid/content/Context;Lcom/google/android/material/chip/ChipGroup;Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Ljava/lang/String;Z)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/material/textfield/TextInputEditText;",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;",
            "Landroid/content/Context;",
            "Lcom/google/android/material/chip/ChipGroup;",
            "Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;",
            "Ljava/lang/String;",
            "Z)V"
        }
    .end annotation

    const/4 v0, 0x0

    .line 222
    invoke-virtual {p0, v0}, Lcom/google/android/material/textfield/TextInputEditText;->setError(Ljava/lang/CharSequence;)V

    .line 223
    invoke-interface {p1, p5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 225
    new-instance p0, Lcom/google/android/material/chip/Chip;

    invoke-direct {p0, p2}, Lcom/google/android/material/chip/Chip;-><init>(Landroid/content/Context;)V

    .line 226
    invoke-static {}, Landroid/view/View;->generateViewId()I

    move-result p2

    invoke-virtual {p0, p2}, Lcom/google/android/material/chip/Chip;->setId(I)V

    .line 227
    move-object p2, p5

    check-cast p2, Ljava/lang/CharSequence;

    invoke-virtual {p0, p2}, Lcom/google/android/material/chip/Chip;->setText(Ljava/lang/CharSequence;)V

    const/4 p2, 0x1

    .line 228
    invoke-virtual {p0, p2}, Lcom/google/android/material/chip/Chip;->setCloseIconVisible(Z)V

    .line 229
    new-instance v0, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$$ExternalSyntheticLambda7;

    invoke-direct {v0, p1, p5, p3}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$$ExternalSyntheticLambda7;-><init>(Ljava/util/List;Ljava/lang/String;Lcom/google/android/material/chip/ChipGroup;)V

    invoke-virtual {p0, v0}, Lcom/google/android/material/chip/Chip;->setOnCloseIconClickListener(Landroid/view/View$OnClickListener;)V

    .line 233
    invoke-static {p3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    move-object p1, p3

    check-cast p1, Landroid/view/ViewGroup;

    invoke-virtual {p3}, Lcom/google/android/material/chip/ChipGroup;->getChildCount()I

    move-result p5

    sub-int/2addr p5, p2

    invoke-static {p1, p5}, Landroidx/core/view/ViewGroupKt;->get(Landroid/view/ViewGroup;I)Landroid/view/View;

    move-result-object p1

    const/4 p2, -0x1

    invoke-virtual {p1, p2}, Landroid/view/View;->setNextFocusRightId(I)V

    .line 234
    invoke-virtual {p0}, Lcom/google/android/material/chip/Chip;->getId()I

    move-result p1

    invoke-virtual {p0, p1}, Lcom/google/android/material/chip/Chip;->setNextFocusRightId(I)V

    .line 235
    check-cast p0, Landroid/view/View;

    invoke-virtual {p3, p0}, Lcom/google/android/material/chip/ChipGroup;->addView(Landroid/view/View;)V

    if-eqz p6, :cond_0

    .line 236
    invoke-virtual {p4}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->requireContext()Landroid/content/Context;

    move-result-object p0

    const p1, 0x7f14004b

    invoke-virtual {p4, p1}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object p1

    check-cast p1, Ljava/lang/CharSequence;

    const/4 p2, 0x0

    invoke-static {p0, p1, p2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object p0

    invoke-virtual {p0}, Landroid/widget/Toast;->show()V

    :cond_0
    return-void
.end method

.method static synthetic onCreateDialog$lambda$26$lambda$25$lambda$24$addScraperKeyword$default(Lcom/google/android/material/textfield/TextInputEditText;Ljava/util/List;Landroid/content/Context;Lcom/google/android/material/chip/ChipGroup;Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Ljava/lang/String;ZILjava/lang/Object;)V
    .locals 7

    and-int/lit8 p7, p7, 0x40

    if-eqz p7, :cond_0

    const/4 p6, 0x1

    :cond_0
    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    move v6, p6

    .line 221
    invoke-static/range {v0 .. v6}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->onCreateDialog$lambda$26$lambda$25$lambda$24$addScraperKeyword(Lcom/google/android/material/textfield/TextInputEditText;Ljava/util/List;Landroid/content/Context;Lcom/google/android/material/chip/ChipGroup;Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Ljava/lang/String;Z)V

    return-void
.end method

.method private static final onCreateDialog$lambda$26$lambda$25$lambda$24$addScraperKeyword$lambda$5(Ljava/util/List;Ljava/lang/String;Lcom/google/android/material/chip/ChipGroup;Landroid/view/View;)V
    .locals 1

    const-string v0, "$scraperKeywordList"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "$scraperKeywordText"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 230
    invoke-interface {p0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 231
    invoke-virtual {p2, p3}, Lcom/google/android/material/chip/ChipGroup;->removeView(Landroid/view/View;)V

    return-void
.end method

.method private static final onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$10(Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;Ljava/lang/String;Landroid/view/View;)V
    .locals 13

    const-string v0, "this$0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "$playableItemEntity"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "$playableItemPreviewMediaIndex"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "$indexPath"

    move-object/from16 v5, p3

    invoke-static {v5, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 347
    sget-object v6, Lcom/magneticchen/daijishou/ui/fragments/dialog/ListSelectDialogFragment;->Companion:Lcom/magneticchen/daijishou/ui/fragments/dialog/ListSelectDialogFragment$Companion;

    const v0, 0x7f140330

    .line 348
    invoke-virtual {p0, v0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object v7

    const/4 v0, 0x3

    .line 350
    new-array v0, v0, [Ljava/lang/String;

    const v1, 0x7f140088

    invoke-virtual {p0, v1}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    const-string v8, "getString(...)"

    invoke-static {v1, v8}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v9, 0x0

    aput-object v1, v0, v9

    const v1, 0x7f1403e2

    .line 351
    invoke-virtual {p0, v1}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v8}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v9, 0x1

    aput-object v1, v0, v9

    const v1, 0x7f14040a

    .line 352
    invoke-virtual {p0, v1}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v8}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v8, 0x2

    aput-object v1, v0, v8

    .line 349
    invoke-static {v0}, Lkotlin/collections/CollectionsKt;->arrayListOf([Ljava/lang/Object;)Ljava/util/ArrayList;

    move-result-object v8

    const/16 v11, 0xc

    const/4 v12, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    .line 347
    invoke-static/range {v6 .. v12}, Lcom/magneticchen/daijishou/ui/fragments/dialog/ListSelectDialogFragment$Companion;->newInstance$default(Lcom/magneticchen/daijishou/ui/fragments/dialog/ListSelectDialogFragment$Companion;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;ZILjava/lang/Object;)Lcom/magneticchen/daijishou/ui/fragments/dialog/ListSelectDialogFragment;

    move-result-object v1

    .line 355
    new-instance v0, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$onCreateDialog$1$1$1$2$1;

    invoke-direct {v0, v1, p0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$onCreateDialog$1$1$1$2$1;-><init>(Lcom/magneticchen/daijishou/ui/fragments/dialog/ListSelectDialogFragment;Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;)V

    check-cast v0, Lkotlin/jvm/functions/Function1;

    invoke-virtual {v1, v0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/ListSelectDialogFragment;->setOnSelectListener(Lkotlin/jvm/functions/Function1;)Lcom/magneticchen/daijishou/ui/fragments/dialog/ListSelectDialogFragment;

    move-result-object v6

    .line 368
    new-instance v0, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$onCreateDialog$1$1$1$2$2;

    move-object v4, p0

    move-object v2, p1

    move-object v3, p2

    invoke-direct/range {v0 .. v5}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$onCreateDialog$1$1$1$2$2;-><init>(Lcom/magneticchen/daijishou/ui/fragments/dialog/ListSelectDialogFragment;Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Ljava/lang/String;)V

    check-cast v0, Lkotlin/jvm/functions/Function1;

    invoke-virtual {v6, v0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/ListSelectDialogFragment;->setOnLongSelectListener(Lkotlin/jvm/functions/Function1;)Lcom/magneticchen/daijishou/ui/fragments/dialog/ListSelectDialogFragment;

    move-result-object v0

    .line 413
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;

    move-result-object v1

    const-class v2, Lcom/magneticchen/daijishou/ui/fragments/dialog/ListSelectDialogFragment;

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/magneticchen/daijishou/ui/fragments/dialog/ListSelectDialogFragment;->show(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V

    return-void
.end method

.method private static final onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$11(Lcom/google/android/material/textfield/TextInputEditText;Ljava/util/List;Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Landroid/content/Context;Lcom/google/android/material/chip/ChipGroup;Landroid/view/View;)V
    .locals 9

    const-string p5, "$scraperKeywordList"

    invoke-static {p1, p5}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p5, "this$0"

    invoke-static {p2, p5}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p5, "$context"

    invoke-static {p3, p5}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 417
    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputEditText;->getText()Landroid/text/Editable;

    move-result-object p5

    invoke-static {p5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    .line 419
    invoke-interface {p1, v5}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result p5

    const/4 v0, -0x1

    if-eq p5, v0, :cond_0

    const p1, 0x7f1401ed

    .line 420
    invoke-virtual {p2, p1}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object p1

    check-cast p1, Ljava/lang/CharSequence;

    invoke-virtual {p0, p1}, Lcom/google/android/material/textfield/TextInputEditText;->setError(Ljava/lang/CharSequence;)V

    .line 421
    invoke-virtual {p0}, Lcom/google/android/material/textfield/TextInputEditText;->requestFocus()Z

    return-void

    :cond_0
    const/16 v7, 0x40

    const/4 v8, 0x0

    const/4 v6, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v4, p2

    move-object v2, p3

    move-object v3, p4

    .line 424
    invoke-static/range {v0 .. v8}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->onCreateDialog$lambda$26$lambda$25$lambda$24$addScraperKeyword$default(Lcom/google/android/material/textfield/TextInputEditText;Ljava/util/List;Landroid/content/Context;Lcom/google/android/material/chip/ChipGroup;Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Ljava/lang/String;ZILjava/lang/Object;)V

    return-void
.end method

.method private static final onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$12(Lkotlin/jvm/internal/Ref$BooleanRef;Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;Landroid/widget/TextView;Landroid/view/View;)V
    .locals 12

    const-string p3, "$resetRecord"

    invoke-static {p0, p3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p3, "$playableItemEntity"

    invoke-static {p1, p3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 p3, 0x1

    .line 430
    iput-boolean p3, p0, Lkotlin/jvm/internal/Ref$BooleanRef;->element:Z

    const/4 p0, 0x0

    .line 431
    invoke-virtual {p1, p0}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->setLastPlayedTimestamp(Ljava/util/Date;)V

    const/4 p0, 0x0

    .line 432
    invoke-virtual {p1, p0}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->setPlayCount(I)V

    .line 433
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getId()J

    move-result-wide v0

    .line 434
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->isInSingletonDisjointSet()Z

    move-result p0

    .line 435
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getUseDisjointSetPrimaryPlayableItem()Z

    move-result p3

    .line 436
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getDisjointSetPrimaryPlayableItemId()Ljava/lang/Long;

    move-result-object v2

    .line 437
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getMd5()Ljava/lang/String;

    move-result-object v3

    .line 438
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getAddedDateTimestamp()Ljava/util/Date;

    move-result-object v4

    .line 439
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getSyncTreeUri()Landroid/net/Uri;

    move-result-object v5

    invoke-virtual {v5}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v5

    .line 440
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getUri()Landroid/net/Uri;

    move-result-object v6

    .line 441
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getUri()Landroid/net/Uri;

    move-result-object v7

    invoke-virtual {v7}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v7

    .line 442
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getPreviewMediaPath()Ljava/lang/String;

    move-result-object v8

    .line 443
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getPlayCount()I

    move-result v9

    .line 444
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getLastPlayedTimestamp()Ljava/util/Date;

    move-result-object p1

    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, "<b>Id:</b> "

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "<br><b>IsInSingletonDisjointSet:</b> "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object p0

    const-string v0, "<br><b>UseDisjointSetPrimaryPlayableItem:</b> "

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0, p3}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object p0

    const-string p3, "<br><b>DisjointSetPrimaryPlayableItemId:</b> "

    invoke-virtual {p0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object p0

    const-string p3, "<br><b>Lazy md5:</b> "

    invoke-virtual {p0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    const-string p3, "<br><b>Added date:</b> "

    invoke-virtual {p0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object p0

    const-string p3, "<br><b>Sync tree:</b> "

    invoke-virtual {p0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    const-string p3, "<br><b>Uri:</b> "

    invoke-virtual {p0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object p0

    const-string p3, "<br><b>Uri path:</b> "

    invoke-virtual {p0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    const-string p3, "<br><b>Preview media path:</b> "

    invoke-virtual {p0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    const-string p3, "<br><b>Played count:</b> "

    invoke-virtual {p0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0, v9}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object p0

    const-string p3, "<br><b>Last played:</b> "

    invoke-virtual {p0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    .line 445
    invoke-static {p0}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object p0

    check-cast p0, Ljava/lang/CharSequence;

    invoke-virtual {p2, p0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    return-void
.end method

.method private static final onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$13(Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;Landroid/widget/EditText;Landroid/widget/CheckBox;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Landroid/widget/AutoCompleteTextView;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlin/jvm/internal/Ref$BooleanRef;Ljava/util/List;Landroid/view/View;)V
    .locals 1

    const-string p14, "this$0"

    invoke-static {p0, p14}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p14, "$playableItemEntity"

    invoke-static {p1, p14}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p14, "$playerNameList"

    invoke-static {p9, p14}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p14, "$playerIdList"

    invoke-static {p10, p14}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p14, "$scraperKeywordList"

    invoke-static {p11, p14}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p14, "$resetRecord"

    invoke-static {p12, p14}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p14, "$genreIdList"

    invoke-static {p13, p14}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    move-object v0, p7

    move-object p7, p0

    move-object p0, p2

    move-object p2, p4

    move-object p4, p6

    move-object p6, p8

    move-object p8, p9

    move-object p9, p10

    move-object p10, p1

    move-object p1, p3

    move-object p3, p5

    move-object p5, v0

    .line 448
    invoke-static/range {p0 .. p13}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->onCreateDialog$lambda$26$lambda$25$lambda$24$saveChanges(Landroid/widget/EditText;Landroid/widget/CheckBox;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Landroid/widget/AutoCompleteTextView;Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Ljava/util/List;Ljava/util/List;Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;Ljava/util/List;Lkotlin/jvm/internal/Ref$BooleanRef;Ljava/util/List;)Z

    move-result p0

    const/4 p1, 0x0

    if-eqz p0, :cond_1

    .line 449
    invoke-virtual {p7}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getDialog()Landroid/app/Dialog;

    move-result-object p0

    if-eqz p0, :cond_0

    invoke-virtual {p0}, Landroid/app/Dialog;->dismiss()V

    .line 450
    :cond_0
    invoke-virtual {p7}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getDaijishouSynchronization()Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;

    move-result-object p0

    invoke-virtual {p7}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object p2

    const-string p3, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity"

    invoke-static {p2, p3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p2, Landroidx/appcompat/app/AppCompatActivity;

    invoke-virtual {p0, p2, p10}, Lcom/magneticchen/daijishou/ui/model/DaijishouSynchronizationModel;->scheduleScrapingOfPlayableItem(Landroidx/appcompat/app/AppCompatActivity;Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;)V

    .line 451
    invoke-virtual {p7}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->requireContext()Landroid/content/Context;

    move-result-object p0

    const p2, 0x7f1403a4

    invoke-virtual {p7, p2}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object p2

    check-cast p2, Ljava/lang/CharSequence;

    invoke-static {p0, p2, p1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object p0

    invoke-virtual {p0}, Landroid/widget/Toast;->show()V

    return-void

    .line 453
    :cond_1
    invoke-virtual {p7}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->requireContext()Landroid/content/Context;

    move-result-object p0

    const p2, 0x7f14001f

    invoke-virtual {p7, p2}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object p2

    check-cast p2, Ljava/lang/CharSequence;

    invoke-static {p0, p2, p1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object p0

    invoke-virtual {p0}, Landroid/widget/Toast;->show()V

    return-void
.end method

.method private static final onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$14(Lcom/google/android/material/switchmaterial/SwitchMaterial;Landroid/widget/AutoCompleteTextView;Landroid/widget/CompoundButton;Z)V
    .locals 0

    .line 459
    invoke-static {p0, p1, p3}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->onCreateDialog$lambda$26$lambda$25$lambda$24$setUseCustomPlayer(Lcom/google/android/material/switchmaterial/SwitchMaterial;Landroid/widget/AutoCompleteTextView;Z)V

    return-void
.end method

.method private static final onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$17(Landroid/content/DialogInterface;I)V
    .locals 0

    return-void
.end method

.method private static final onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$18(Landroid/content/DialogInterface;I)V
    .locals 0

    .line 502
    invoke-interface {p0}, Landroid/content/DialogInterface;->cancel()V

    return-void
.end method

.method private static final onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$19(Landroid/content/DialogInterface;I)V
    .locals 0

    return-void
.end method

.method private static final onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$20(Landroid/content/DialogInterface;I)V
    .locals 0

    return-void
.end method

.method private static final onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$23(Landroid/app/AlertDialog;Landroid/content/Context;Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Landroid/widget/EditText;Landroid/widget/CheckBox;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Landroid/widget/AutoCompleteTextView;Ljava/util/List;Ljava/util/List;Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;Ljava/util/List;Lkotlin/jvm/internal/Ref$BooleanRef;Ljava/util/List;Landroid/content/DialogInterface;)V
    .locals 19

    move-object/from16 v1, p0

    const-string v0, "$context"

    move-object/from16 v2, p1

    invoke-static {v2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "this$0"

    move-object/from16 v3, p2

    invoke-static {v3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "$playerNameList"

    move-object/from16 v11, p10

    invoke-static {v11, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "$playerIdList"

    move-object/from16 v12, p11

    invoke-static {v12, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "$playableItemEntity"

    move-object/from16 v13, p12

    invoke-static {v13, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "$scraperKeywordList"

    move-object/from16 v14, p13

    invoke-static {v14, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "$resetRecord"

    move-object/from16 v15, p14

    invoke-static {v15, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "$genreIdList"

    move-object/from16 v4, p15

    invoke-static {v4, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 518
    const-string v0, "null cannot be cast to non-null type android.app.AlertDialog"

    invoke-static {v1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, -0x1

    invoke-virtual {v1, v0}, Landroid/app/AlertDialog;->getButton(I)Landroid/widget/Button;

    move-result-object v0

    const-string v5, "getButton(...)"

    invoke-static {v0, v5}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    move-object v6, v0

    .line 519
    new-instance v0, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$$ExternalSyntheticLambda2;

    move-object/from16 v7, p6

    move-object/from16 v8, p7

    move-object/from16 v9, p8

    move-object/from16 v10, p9

    move-object/from16 v16, v4

    move-object/from16 v18, v5

    move-object/from16 v17, v6

    move-object/from16 v4, p3

    move-object/from16 v5, p4

    move-object/from16 v6, p5

    invoke-direct/range {v0 .. v16}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$$ExternalSyntheticLambda2;-><init>(Landroid/app/AlertDialog;Landroid/content/Context;Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Landroid/widget/EditText;Landroid/widget/CheckBox;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Landroid/widget/AutoCompleteTextView;Ljava/util/List;Ljava/util/List;Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;Ljava/util/List;Lkotlin/jvm/internal/Ref$BooleanRef;Ljava/util/List;)V

    move-object/from16 v6, v17

    invoke-virtual {v6, v0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const/4 v0, -0x3

    .line 530
    invoke-virtual {v1, v0}, Landroid/app/AlertDialog;->getButton(I)Landroid/widget/Button;

    move-result-object v0

    if-eqz v0, :cond_neutral_null

    move-object/from16 v2, v18

    invoke-static {v0, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 532
    new-instance v2, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$$ExternalSyntheticLambda3;

    move-object/from16 p7, p1

    move-object/from16 p5, p2

    move-object/from16 p4, p12

    move-object/from16 p8, v0

    move-object/from16 p6, v1

    move-object/from16 p3, v2

    invoke-direct/range {p3 .. p8}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$$ExternalSyntheticLambda3;-><init>(Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Landroid/app/AlertDialog;Landroid/content/Context;Landroid/widget/Button;)V

    move-object/from16 v1, p3

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    :cond_neutral_null
    return-void
.end method

.method private static final onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$23$lambda$21(Landroid/app/AlertDialog;Landroid/content/Context;Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Landroid/widget/EditText;Landroid/widget/CheckBox;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Landroid/widget/AutoCompleteTextView;Ljava/util/List;Ljava/util/List;Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;Ljava/util/List;Lkotlin/jvm/internal/Ref$BooleanRef;Ljava/util/List;Landroid/view/View;)V
    .locals 15

    move-object/from16 v0, p1

    move-object/from16 v8, p2

    const-string v1, "$context"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v1, "this$0"

    invoke-static {v8, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v1, "$playerNameList"

    move-object/from16 v9, p10

    invoke-static {v9, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v1, "$playerIdList"

    move-object/from16 v10, p11

    invoke-static {v10, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v1, "$playableItemEntity"

    move-object/from16 v11, p12

    invoke-static {v11, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v1, "$scraperKeywordList"

    move-object/from16 v12, p13

    invoke-static {v12, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v1, "$resetRecord"

    move-object/from16 v13, p14

    invoke-static {v13, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v1, "$genreIdList"

    move-object/from16 v14, p15

    invoke-static {v14, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    move-object/from16 v1, p3

    move-object/from16 v2, p4

    move-object/from16 v3, p5

    move-object/from16 v4, p6

    move-object/from16 v5, p7

    move-object/from16 v6, p8

    move-object/from16 v7, p9

    .line 520
    invoke-static/range {v1 .. v14}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->onCreateDialog$lambda$26$lambda$25$lambda$24$saveChanges(Landroid/widget/EditText;Landroid/widget/CheckBox;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Landroid/widget/AutoCompleteTextView;Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Ljava/util/List;Ljava/util/List;Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;Ljava/util/List;Lkotlin/jvm/internal/Ref$BooleanRef;Ljava/util/List;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 522
    invoke-virtual {p0}, Landroid/app/AlertDialog;->dismiss()V

    const p0, 0x7f140123

    .line 525
    invoke-virtual {v8, p0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object p0

    check-cast p0, Ljava/lang/CharSequence;

    const/4 v1, 0x0

    .line 523
    invoke-static {v0, p0, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object p0

    .line 527
    invoke-virtual {p0}, Landroid/widget/Toast;->show()V

    :cond_0
    return-void
.end method

.method private static final onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$23$lambda$22(Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Landroid/app/AlertDialog;Landroid/content/Context;Landroid/widget/Button;Landroid/view/View;)V
    .locals 9

    const-string p5, "$playableItemEntity"

    invoke-static {p0, p5}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p5, "this$0"

    invoke-static {p1, p5}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p5, "$context"

    invoke-static {p3, p5}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p5, "$neutralButton"

    invoke-static {p4, p5}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 533
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getSyncTreeUri()Landroid/net/Uri;

    move-result-object p5

    sget-object v0, Landroid/net/Uri;->EMPTY:Landroid/net/Uri;

    invoke-static {p5, v0}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p5

    const v0, 0x7f140066

    if-nez p5, :cond_1

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getUri()Landroid/net/Uri;

    move-result-object p5

    sget-object v1, Landroid/net/Uri;->EMPTY:Landroid/net/Uri;

    invoke-static {p5, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p5

    if-eqz p5, :cond_0

    goto :goto_0

    .line 550
    :cond_0
    sget-object v1, Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment;->Companion:Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment$Companion;

    .line 551
    invoke-virtual {p1, v0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    const p2, 0x7f1400fa

    .line 552
    invoke-virtual {p1, p2}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    const/16 v7, 0x1c

    const/4 v8, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    .line 550
    invoke-static/range {v1 .. v8}, Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment$Companion;->newInstance$default(Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment$Companion;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Object;)Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment;

    move-result-object p2

    .line 553
    new-instance p3, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$onCreateDialog$1$1$1$11$2$2;

    invoke-direct {p3, p0, p1, p4}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$onCreateDialog$1$1$1$11$2$2;-><init>(Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Landroid/widget/Button;)V

    check-cast p3, Lkotlin/jvm/functions/Function0;

    invoke-virtual {p2, p3}, Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment;->setOnAcknowledgedListener(Lkotlin/jvm/functions/Function0;)Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment;

    move-result-object p0

    .line 559
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;

    move-result-object p1

    const-class p2, Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment;

    .line 560
    invoke-virtual {p2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object p2

    .line 558
    invoke-virtual {p0, p1, p2}, Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment;->show(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V

    return-void

    :cond_1
    :goto_0
    move p4, v0

    .line 534
    sget-object v0, Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment;->Companion:Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment$Companion;

    .line 535
    invoke-virtual {p1, p4}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    const p4, 0x7f1400ed

    .line 536
    invoke-virtual {p1, p4}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    const/16 v6, 0x1c

    const/4 v7, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    .line 534
    invoke-static/range {v0 .. v7}, Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment$Companion;->newInstance$default(Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment$Companion;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Object;)Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment;

    move-result-object p4

    .line 537
    new-instance p5, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$onCreateDialog$1$1$1$11$2$1;

    invoke-direct {p5, p1, p0, p2, p3}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$onCreateDialog$1$1$1$11$2$1;-><init>(Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;Landroid/app/AlertDialog;Landroid/content/Context;)V

    check-cast p5, Lkotlin/jvm/functions/Function0;

    invoke-virtual {p4, p5}, Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment;->setOnAcknowledgedListener(Lkotlin/jvm/functions/Function0;)Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment;

    move-result-object p0

    .line 546
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getParentFragmentManager()Landroidx/fragment/app/FragmentManager;

    move-result-object p1

    const-class p2, Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment;

    .line 547
    invoke-virtual {p2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object p2

    .line 545
    invoke-virtual {p0, p1, p2}, Lcom/magneticchen/daijishou/ui/fragments/dialog/AcknowledgementDialogFragment;->show(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V

    return-void
.end method

.method private static final onCreateDialog$lambda$26$lambda$25$lambda$24$lambda$8(Landroid/widget/AutoCompleteTextView;Ljava/util/List;Ljava/util/List;Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Ljava/util/List;Lcom/google/android/material/textfield/TextInputEditText;Landroid/content/Context;Lcom/google/android/material/chip/ChipGroup;Landroid/view/View;)V
    .locals 9

    const-string v0, "$availableGenreIdList"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "$genreNamesList"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "this$0"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "$genreIdList"

    invoke-static {p4, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "$context"

    invoke-static {p6, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 262
    invoke-virtual {p0}, Landroid/widget/AutoCompleteTextView;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 263
    invoke-interface {p2, v0}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result p2

    invoke-static {p1, p2}, Lkotlin/collections/CollectionsKt;->getOrNull(Ljava/util/List;I)Ljava/lang/Object;

    move-result-object p2

    move-object v5, p2

    check-cast v5, Ljava/lang/String;

    .line 265
    invoke-static {p1, v5}, Lkotlin/collections/CollectionsKt;->indexOf(Ljava/util/List;Ljava/lang/Object;)I

    move-result p1

    const/4 p2, -0x1

    if-ne p1, p2, :cond_0

    const p1, 0x7f140327

    .line 266
    invoke-virtual {p3, p1}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object p1

    check-cast p1, Ljava/lang/CharSequence;

    invoke-virtual {p0, p1}, Landroid/widget/AutoCompleteTextView;->setError(Ljava/lang/CharSequence;)V

    .line 267
    invoke-virtual {p0}, Landroid/widget/AutoCompleteTextView;->requestFocus()Z

    return-void

    .line 269
    :cond_0
    invoke-static {p4, v5}, Lkotlin/collections/CollectionsKt;->indexOf(Ljava/util/List;Ljava/lang/Object;)I

    move-result p1

    if-eq p1, p2, :cond_1

    const p1, 0x7f1401ee

    .line 270
    invoke-virtual {p3, p1}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object p1

    check-cast p1, Ljava/lang/CharSequence;

    invoke-virtual {p0, p1}, Landroid/widget/AutoCompleteTextView;->setError(Ljava/lang/CharSequence;)V

    .line 271
    invoke-virtual {p0}, Landroid/widget/AutoCompleteTextView;->requestFocus()Z

    return-void

    :cond_1
    if-eqz v5, :cond_2

    const/4 p1, 0x0

    .line 275
    invoke-virtual {p0, p1}, Landroid/widget/AutoCompleteTextView;->setText(Ljava/lang/CharSequence;)V

    const/16 v7, 0x40

    const/4 v8, 0x0

    const/4 v6, 0x0

    move-object v3, p3

    move-object v1, p4

    move-object v0, p5

    move-object v2, p6

    move-object/from16 v4, p7

    .line 276
    invoke-static/range {v0 .. v8}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->onCreateDialog$lambda$26$lambda$25$lambda$24$addGenreId$default(Lcom/google/android/material/textfield/TextInputEditText;Ljava/util/List;Landroid/content/Context;Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Lcom/google/android/material/chip/ChipGroup;Ljava/lang/String;ZILjava/lang/Object;)V

    :cond_2
    return-void
.end method

.method private static final onCreateDialog$lambda$26$lambda$25$lambda$24$saveChanges(Landroid/widget/EditText;Landroid/widget/CheckBox;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Landroid/widget/AutoCompleteTextView;Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Ljava/util/List;Ljava/util/List;Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;Ljava/util/List;Lkotlin/jvm/internal/Ref$BooleanRef;Ljava/util/List;)Z
    .locals 20
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/EditText;",
            "Landroid/widget/CheckBox;",
            "Lcom/google/android/material/switchmaterial/SwitchMaterial;",
            "Lcom/google/android/material/switchmaterial/SwitchMaterial;",
            "Lcom/google/android/material/switchmaterial/SwitchMaterial;",
            "Lcom/google/android/material/switchmaterial/SwitchMaterial;",
            "Landroid/widget/AutoCompleteTextView;",
            "Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/List<",
            "Ljava/lang/Long;",
            ">;",
            "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;",
            "Lkotlin/jvm/internal/Ref$BooleanRef;",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;)Z"
        }
    .end annotation

    move-object/from16 v0, p7

    move-object/from16 v1, p10

    .line 292
    invoke-virtual/range {p0 .. p0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    .line 293
    invoke-virtual/range {p1 .. p1}, Landroid/widget/CheckBox;->isChecked()Z

    move-result v3

    .line 294
    invoke-virtual/range {p2 .. p2}, Lcom/google/android/material/switchmaterial/SwitchMaterial;->isChecked()Z

    move-result v4

    .line 295
    invoke-virtual/range {p3 .. p3}, Lcom/google/android/material/switchmaterial/SwitchMaterial;->isChecked()Z

    move-result v5

    .line 296
    invoke-virtual/range {p4 .. p4}, Lcom/google/android/material/switchmaterial/SwitchMaterial;->isChecked()Z

    move-result v6

    .line 297
    invoke-virtual/range {p5 .. p5}, Lcom/google/android/material/switchmaterial/SwitchMaterial;->isChecked()Z

    move-result v7

    .line 299
    invoke-virtual/range {p6 .. p6}, Landroid/widget/AutoCompleteTextView;->getText()Landroid/text/Editable;

    move-result-object v8

    .line 303
    move-object v9, v2

    check-cast v9, Ljava/lang/CharSequence;

    invoke-interface {v9}, Ljava/lang/CharSequence;->length()I

    move-result v9

    const/4 v10, 0x0

    if-nez v9, :cond_0

    const v1, 0x7f140321

    .line 304
    invoke-virtual {v0, v1}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    move-object/from16 v1, p0

    invoke-virtual {v1, v0}, Landroid/widget/EditText;->setError(Ljava/lang/CharSequence;)V

    return v10

    .line 307
    :cond_0
    invoke-virtual {v8}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v8

    move-object/from16 v9, p8

    invoke-interface {v9, v8}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v8

    if-nez v7, :cond_1

    const/4 v8, 0x0

    goto :goto_0

    :cond_1
    if-eqz v7, :cond_2

    const/4 v9, -0x1

    if-ne v8, v9, :cond_2

    const v1, 0x7f140326

    .line 312
    invoke-virtual {v0, v1}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    move-object/from16 v1, p6

    invoke-virtual {v1, v0}, Landroid/widget/AutoCompleteTextView;->setError(Ljava/lang/CharSequence;)V

    .line 313
    invoke-virtual {v1}, Landroid/widget/AutoCompleteTextView;->requestFocus()Z

    return v10

    :cond_2
    move-object/from16 v9, p9

    .line 316
    invoke-interface {v9, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/Long;

    .line 320
    :goto_0
    invoke-virtual {v1, v2}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->setName(Ljava/lang/String;)V

    .line 321
    invoke-virtual {v1, v3}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->setVisible(Z)V

    .line 322
    invoke-virtual {v1, v4}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->setDoScrapeName(Z)V

    .line 323
    invoke-virtual/range {p10 .. p11}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->setScraperKeywordList(Ljava/util/List;)V

    .line 324
    invoke-virtual {v1, v6}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->setScrapeScraperKeywords(Z)V

    .line 325
    invoke-virtual {v1, v7}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->setUseCustomPlayer(Z)V

    .line 326
    invoke-virtual {v1, v8}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->setCustomPlayerId(Ljava/lang/Long;)V

    .line 327
    invoke-virtual {v1, v5}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->setDoNotPrettify(Z)V

    .line 329
    invoke-virtual {v0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getDaijishouLibrary()Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object v2

    invoke-virtual {v2, v1}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->updatePlayableItem(Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;)V

    move-object/from16 v2, p12

    .line 330
    iget-boolean v2, v2, Lkotlin/jvm/internal/Ref$BooleanRef;->element:Z

    if-eqz v2, :cond_3

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getDaijishouLibrary()Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object v2

    invoke-virtual {v1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getId()J

    move-result-wide v3

    invoke-virtual {v2, v3, v4}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->deleteAllEventsByPlayableItemId(J)V

    .line 331
    :cond_3
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    check-cast v2, Ljava/util/List;

    .line 332
    move-object/from16 v3, p13

    check-cast v3, Ljava/lang/Iterable;

    .line 581
    invoke-interface {v3}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_4

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    move-object/from16 v16, v4

    check-cast v16, Ljava/lang/String;

    .line 334
    new-instance v11, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemToGenrePairEntity;

    .line 335
    invoke-virtual {v1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getId()J

    move-result-wide v14

    const/16 v18, 0x9

    const/16 v19, 0x0

    const-wide/16 v12, 0x0

    const/16 v17, 0x0

    .line 334
    invoke-direct/range {v11 .. v19}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemToGenrePairEntity;-><init>(JJLjava/lang/String;Ljava/lang/String;ILkotlin/jvm/internal/DefaultConstructorMarker;)V

    .line 333
    invoke-interface {v2, v11}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 340
    :cond_4
    invoke-virtual {v0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getDaijishouLibrary()Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object v3

    invoke-virtual {v1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getId()J

    move-result-wide v4

    invoke-virtual {v3, v4, v5}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->deletePlayableItemToGenrePairsByPlayableItemId(J)V

    .line 341
    invoke-virtual {v0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getDaijishouLibrary()Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object v0

    check-cast v2, Ljava/util/Collection;

    .line 584
    new-array v1, v10, [Lcom/magneticchen/daijishou/data/db/entity/PlayableItemToGenrePairEntity;

    invoke-interface {v2, v1}, Ljava/util/Collection;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v1

    .line 341
    check-cast v1, [Lcom/magneticchen/daijishou/data/db/entity/PlayableItemToGenrePairEntity;

    array-length v2, v1

    invoke-static {v1, v2}, Ljava/util/Arrays;->copyOf([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Lcom/magneticchen/daijishou/data/db/entity/PlayableItemToGenrePairEntity;

    invoke-virtual {v0, v1}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->addPlayableItemToGenrePairs([Lcom/magneticchen/daijishou/data/db/entity/PlayableItemToGenrePairEntity;)Ljava/util/List;

    const/4 v0, 0x1

    return v0
.end method

.method private static final onCreateDialog$lambda$26$lambda$25$lambda$24$setUseCustomPlayer(Lcom/google/android/material/switchmaterial/SwitchMaterial;Landroid/widget/AutoCompleteTextView;Z)V
    .locals 0

    .line 284
    invoke-virtual {p0, p2}, Lcom/google/android/material/switchmaterial/SwitchMaterial;->setChecked(Z)V

    .line 285
    invoke-virtual {p1, p2}, Landroid/widget/AutoCompleteTextView;->setEnabled(Z)V

    return-void
.end method

.method private static final setBoxArtActivity$lambda$0(Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Landroid/net/Uri;)V
    .locals 9

    const-string v0, "this$0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 92
    sget-object v0, Landroid/net/Uri;->EMPTY:Landroid/net/Uri;

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_3

    if-nez p1, :cond_0

    goto/16 :goto_1

    .line 96
    :cond_0
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->checkPreviewMediaDirectory()Ljava/lang/String;

    move-result-object v0

    .line 97
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "index.json"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 98
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "box_art.png"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 99
    new-instance v5, Ljava/io/FileInputStream;

    invoke-direct {v5, v2}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V

    check-cast v5, Ljava/io/InputStream;

    sget-object v6, Ljava/nio/charset/StandardCharsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-static {v5, v6}, Lorg/apache/commons/io/IOUtils;->toString(Ljava/io/InputStream;Ljava/nio/charset/Charset;)Ljava/lang/String;

    move-result-object v5

    const-string v6, "toString(...)"

    invoke-static {v5, v6}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 100
    sget-object v6, Lkotlinx/serialization/json/Json;->Default:Lkotlinx/serialization/json/Json$Default;

    sget-object v7, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;->Companion:Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex$Companion;

    invoke-virtual {v7}, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex$Companion;->serializer()Lkotlinx/serialization/KSerializer;

    move-result-object v7

    check-cast v7, Lkotlinx/serialization/DeserializationStrategy;

    invoke-virtual {v6, v7, v5}, Lkotlinx/serialization/json/Json$Default;->decodeFromString(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;

    .line 101
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v6

    invoke-virtual {v6}, Landroidx/fragment/app/FragmentActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v6

    invoke-virtual {v6, p1}, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;

    move-result-object p1

    invoke-static {p1}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;)Landroid/graphics/Bitmap;

    move-result-object p1

    .line 102
    sget-object v6, Lcom/magneticchen/daijishou/data/Constants;->INSTANCE:Lcom/magneticchen/daijishou/data/Constants;

    invoke-virtual {v6}, Lcom/magneticchen/daijishou/data/Constants;->getScraperFormat()Landroid/graphics/Bitmap$CompressFormat;

    move-result-object v6

    new-instance v7, Ljava/io/FileOutputStream;

    invoke-direct {v7, v3}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V

    check-cast v7, Ljava/io/OutputStream;

    const/16 v8, 0x64

    invoke-virtual {p1, v6, v8, v7}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    .line 103
    invoke-virtual {v5, v4}, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;->setBoxArtPath(Ljava/lang/String;)V

    .line 104
    sget-object p1, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$setBoxArtActivity$1$jsonFormat$1;->INSTANCE:Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$setBoxArtActivity$1$jsonFormat$1;

    check-cast p1, Lkotlin/jvm/functions/Function1;

    const/4 v4, 0x1

    const/4 v6, 0x0

    invoke-static {v6, p1, v4, v6}, Lkotlinx/serialization/json/JsonKt;->Json$default(Lkotlinx/serialization/json/Json;Lkotlin/jvm/functions/Function1;ILjava/lang/Object;)Lkotlinx/serialization/json/Json;

    move-result-object p1

    .line 105
    check-cast p1, Lkotlinx/serialization/StringFormat;

    .line 578
    invoke-interface {p1}, Lkotlinx/serialization/StringFormat;->getSerializersModule()Lkotlinx/serialization/modules/SerializersModule;

    sget-object v4, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;->Companion:Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex$Companion;

    invoke-virtual {v4}, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex$Companion;->serializer()Lkotlinx/serialization/KSerializer;

    move-result-object v4

    check-cast v4, Lkotlinx/serialization/SerializationStrategy;

    invoke-interface {p1, v4, v5}, Lkotlinx/serialization/StringFormat;->encodeToString(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    .line 106
    new-instance v4, Ljava/io/OutputStreamWriter;

    new-instance v5, Ljava/io/FileOutputStream;

    invoke-direct {v5, v2}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V

    check-cast v5, Ljava/io/OutputStream;

    invoke-direct {v4, v5}, Ljava/io/OutputStreamWriter;-><init>(Ljava/io/OutputStream;)V

    .line 107
    invoke-virtual {v4, p1}, Ljava/io/OutputStreamWriter;->write(Ljava/lang/String;)V

    .line 108
    invoke-virtual {v4}, Ljava/io/OutputStreamWriter;->close()V

    .line 109
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->playableItemEntity:Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;

    const-string v2, "playableItemEntity"

    if-nez p1, :cond_1

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object p1, v6

    :cond_1
    invoke-virtual {p1, v0}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->setPreviewMediaPath(Ljava/lang/String;)V

    .line 110
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getDaijishouLibrary()Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object p1

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->getCachedBoxArtBitmapLoader()Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;

    move-result-object p1

    invoke-virtual {p1, v3}, Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;->remove(Ljava/lang/String;)V

    .line 111
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getDaijishouLibrary()Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object p1

    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->playableItemEntity:Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;

    if-nez v0, :cond_2

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_0

    :cond_2
    move-object v6, v0

    :goto_0
    invoke-virtual {p1, v6}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->updatePlayableItem(Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;)V

    .line 112
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->requireContext()Landroid/content/Context;

    move-result-object p1

    const v0, 0x7f14008b

    invoke-virtual {p0, v0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object p0

    check-cast p0, Ljava/lang/CharSequence;

    invoke-static {p1, p0, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object p0

    invoke-virtual {p0}, Landroid/widget/Toast;->show()V

    return-void

    .line 93
    :cond_3
    :goto_1
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->requireContext()Landroid/content/Context;

    move-result-object p1

    const v0, 0x7f14001f

    invoke-virtual {p0, v0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object p0

    check-cast p0, Ljava/lang/CharSequence;

    invoke-static {p1, p0, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object p0

    invoke-virtual {p0}, Landroid/widget/Toast;->show()V

    return-void
.end method

.method private static final setSnapshotActivity$lambda$1(Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Landroid/net/Uri;)V
    .locals 9

    const-string v0, "this$0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 116
    sget-object v0, Landroid/net/Uri;->EMPTY:Landroid/net/Uri;

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_3

    if-nez p1, :cond_0

    goto/16 :goto_1

    .line 120
    :cond_0
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->checkPreviewMediaDirectory()Ljava/lang/String;

    move-result-object v0

    .line 121
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "index.json"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 122
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "snapshot.png"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 123
    new-instance v5, Ljava/io/FileInputStream;

    invoke-direct {v5, v2}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V

    check-cast v5, Ljava/io/InputStream;

    sget-object v6, Ljava/nio/charset/StandardCharsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-static {v5, v6}, Lorg/apache/commons/io/IOUtils;->toString(Ljava/io/InputStream;Ljava/nio/charset/Charset;)Ljava/lang/String;

    move-result-object v5

    const-string v6, "toString(...)"

    invoke-static {v5, v6}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 124
    sget-object v6, Lkotlinx/serialization/json/Json;->Default:Lkotlinx/serialization/json/Json$Default;

    sget-object v7, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;->Companion:Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex$Companion;

    invoke-virtual {v7}, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex$Companion;->serializer()Lkotlinx/serialization/KSerializer;

    move-result-object v7

    check-cast v7, Lkotlinx/serialization/DeserializationStrategy;

    invoke-virtual {v6, v7, v5}, Lkotlinx/serialization/json/Json$Default;->decodeFromString(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;

    .line 125
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v6

    invoke-virtual {v6}, Landroidx/fragment/app/FragmentActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v6

    invoke-virtual {v6, p1}, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;

    move-result-object p1

    invoke-static {p1}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;)Landroid/graphics/Bitmap;

    move-result-object p1

    .line 126
    sget-object v6, Lcom/magneticchen/daijishou/data/Constants;->INSTANCE:Lcom/magneticchen/daijishou/data/Constants;

    invoke-virtual {v6}, Lcom/magneticchen/daijishou/data/Constants;->getScraperFormat()Landroid/graphics/Bitmap$CompressFormat;

    move-result-object v6

    new-instance v7, Ljava/io/FileOutputStream;

    invoke-direct {v7, v3}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V

    check-cast v7, Ljava/io/OutputStream;

    const/16 v8, 0x64

    invoke-virtual {p1, v6, v8, v7}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    .line 127
    invoke-virtual {v5, v4}, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;->setSnapshotPath(Ljava/lang/String;)V

    .line 128
    sget-object p1, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$setSnapshotActivity$1$jsonFormat$1;->INSTANCE:Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$setSnapshotActivity$1$jsonFormat$1;

    check-cast p1, Lkotlin/jvm/functions/Function1;

    const/4 v4, 0x1

    const/4 v6, 0x0

    invoke-static {v6, p1, v4, v6}, Lkotlinx/serialization/json/JsonKt;->Json$default(Lkotlinx/serialization/json/Json;Lkotlin/jvm/functions/Function1;ILjava/lang/Object;)Lkotlinx/serialization/json/Json;

    move-result-object p1

    .line 129
    check-cast p1, Lkotlinx/serialization/StringFormat;

    .line 579
    invoke-interface {p1}, Lkotlinx/serialization/StringFormat;->getSerializersModule()Lkotlinx/serialization/modules/SerializersModule;

    sget-object v4, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;->Companion:Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex$Companion;

    invoke-virtual {v4}, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex$Companion;->serializer()Lkotlinx/serialization/KSerializer;

    move-result-object v4

    check-cast v4, Lkotlinx/serialization/SerializationStrategy;

    invoke-interface {p1, v4, v5}, Lkotlinx/serialization/StringFormat;->encodeToString(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    .line 130
    new-instance v4, Ljava/io/OutputStreamWriter;

    new-instance v5, Ljava/io/FileOutputStream;

    invoke-direct {v5, v2}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V

    check-cast v5, Ljava/io/OutputStream;

    invoke-direct {v4, v5}, Ljava/io/OutputStreamWriter;-><init>(Ljava/io/OutputStream;)V

    .line 131
    invoke-virtual {v4, p1}, Ljava/io/OutputStreamWriter;->write(Ljava/lang/String;)V

    .line 132
    invoke-virtual {v4}, Ljava/io/OutputStreamWriter;->close()V

    .line 133
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->playableItemEntity:Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;

    const-string v2, "playableItemEntity"

    if-nez p1, :cond_1

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object p1, v6

    :cond_1
    invoke-virtual {p1, v0}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->setPreviewMediaPath(Ljava/lang/String;)V

    .line 134
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getDaijishouLibrary()Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object p1

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->getCachedSnapshotBitmapLoader()Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;

    move-result-object p1

    invoke-virtual {p1, v3}, Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;->remove(Ljava/lang/String;)V

    .line 135
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getDaijishouLibrary()Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object p1

    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->playableItemEntity:Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;

    if-nez v0, :cond_2

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_0

    :cond_2
    move-object v6, v0

    :goto_0
    invoke-virtual {p1, v6}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->updatePlayableItem(Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;)V

    .line 136
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->requireContext()Landroid/content/Context;

    move-result-object p1

    const v0, 0x7f1403e4

    invoke-virtual {p0, v0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object p0

    check-cast p0, Ljava/lang/CharSequence;

    invoke-static {p1, p0, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object p0

    invoke-virtual {p0}, Landroid/widget/Toast;->show()V

    return-void

    .line 117
    :cond_3
    :goto_1
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->requireContext()Landroid/content/Context;

    move-result-object p1

    const v0, 0x7f14001f

    invoke-virtual {p0, v0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object p0

    check-cast p0, Ljava/lang/CharSequence;

    invoke-static {p1, p0, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object p0

    invoke-virtual {p0}, Landroid/widget/Toast;->show()V

    return-void
.end method

.method private static final setTitleActivity$lambda$2(Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Landroid/net/Uri;)V
    .locals 9

    const-string v0, "this$0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 140
    sget-object v0, Landroid/net/Uri;->EMPTY:Landroid/net/Uri;

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_3

    if-nez p1, :cond_0

    goto/16 :goto_1

    .line 144
    :cond_0
    invoke-direct {p0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->checkPreviewMediaDirectory()Ljava/lang/String;

    move-result-object v0

    .line 145
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "index.json"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 146
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "title.png"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 147
    new-instance v5, Ljava/io/FileInputStream;

    invoke-direct {v5, v2}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V

    check-cast v5, Ljava/io/InputStream;

    sget-object v6, Ljava/nio/charset/StandardCharsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-static {v5, v6}, Lorg/apache/commons/io/IOUtils;->toString(Ljava/io/InputStream;Ljava/nio/charset/Charset;)Ljava/lang/String;

    move-result-object v5

    const-string v6, "toString(...)"

    invoke-static {v5, v6}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 148
    sget-object v6, Lkotlinx/serialization/json/Json;->Default:Lkotlinx/serialization/json/Json$Default;

    sget-object v7, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;->Companion:Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex$Companion;

    invoke-virtual {v7}, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex$Companion;->serializer()Lkotlinx/serialization/KSerializer;

    move-result-object v7

    check-cast v7, Lkotlinx/serialization/DeserializationStrategy;

    invoke-virtual {v6, v7, v5}, Lkotlinx/serialization/json/Json$Default;->decodeFromString(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;

    .line 149
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v6

    invoke-virtual {v6}, Landroidx/fragment/app/FragmentActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v6

    invoke-virtual {v6, p1}, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;

    move-result-object p1

    invoke-static {p1}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;)Landroid/graphics/Bitmap;

    move-result-object p1

    .line 150
    sget-object v6, Lcom/magneticchen/daijishou/data/Constants;->INSTANCE:Lcom/magneticchen/daijishou/data/Constants;

    invoke-virtual {v6}, Lcom/magneticchen/daijishou/data/Constants;->getScraperFormat()Landroid/graphics/Bitmap$CompressFormat;

    move-result-object v6

    new-instance v7, Ljava/io/FileOutputStream;

    invoke-direct {v7, v3}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V

    check-cast v7, Ljava/io/OutputStream;

    const/16 v8, 0x64

    invoke-virtual {p1, v6, v8, v7}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    .line 151
    invoke-virtual {v5, v4}, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;->setTitlePath(Ljava/lang/String;)V

    .line 152
    sget-object p1, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$setTitleActivity$1$jsonFormat$1;->INSTANCE:Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$setTitleActivity$1$jsonFormat$1;

    check-cast p1, Lkotlin/jvm/functions/Function1;

    const/4 v4, 0x1

    const/4 v6, 0x0

    invoke-static {v6, p1, v4, v6}, Lkotlinx/serialization/json/JsonKt;->Json$default(Lkotlinx/serialization/json/Json;Lkotlin/jvm/functions/Function1;ILjava/lang/Object;)Lkotlinx/serialization/json/Json;

    move-result-object p1

    .line 153
    check-cast p1, Lkotlinx/serialization/StringFormat;

    .line 580
    invoke-interface {p1}, Lkotlinx/serialization/StringFormat;->getSerializersModule()Lkotlinx/serialization/modules/SerializersModule;

    sget-object v4, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;->Companion:Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex$Companion;

    invoke-virtual {v4}, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex$Companion;->serializer()Lkotlinx/serialization/KSerializer;

    move-result-object v4

    check-cast v4, Lkotlinx/serialization/SerializationStrategy;

    invoke-interface {p1, v4, v5}, Lkotlinx/serialization/StringFormat;->encodeToString(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    .line 154
    new-instance v4, Ljava/io/OutputStreamWriter;

    new-instance v5, Ljava/io/FileOutputStream;

    invoke-direct {v5, v2}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V

    check-cast v5, Ljava/io/OutputStream;

    invoke-direct {v4, v5}, Ljava/io/OutputStreamWriter;-><init>(Ljava/io/OutputStream;)V

    .line 155
    invoke-virtual {v4, p1}, Ljava/io/OutputStreamWriter;->write(Ljava/lang/String;)V

    .line 156
    invoke-virtual {v4}, Ljava/io/OutputStreamWriter;->close()V

    .line 157
    iget-object p1, p0, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->playableItemEntity:Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;

    const-string v2, "playableItemEntity"

    if-nez p1, :cond_1

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object p1, v6

    :cond_1
    invoke-virtual {p1, v0}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->setPreviewMediaPath(Ljava/lang/String;)V

    .line 158
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getDaijishouLibrary()Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object p1

    invoke-virtual {p1}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->getCachedTitleBitmapLoader()Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;

    move-result-object p1

    invoke-virtual {p1, v3}, Lcom/magneticchen/daijishou/cache/CachedBitmapLoader;->remove(Ljava/lang/String;)V

    .line 159
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getDaijishouLibrary()Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object p1

    iget-object v0, p0, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->playableItemEntity:Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;

    if-nez v0, :cond_2

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_0

    :cond_2
    move-object v6, v0

    :goto_0
    invoke-virtual {p1, v6}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->updatePlayableItem(Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;)V

    .line 160
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->requireContext()Landroid/content/Context;

    move-result-object p1

    const v0, 0x7f14040c

    invoke-virtual {p0, v0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object p0

    check-cast p0, Ljava/lang/CharSequence;

    invoke-static {p1, p0, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object p0

    invoke-virtual {p0}, Landroid/widget/Toast;->show()V

    return-void

    .line 141
    :cond_3
    :goto_1
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->requireContext()Landroid/content/Context;

    move-result-object p1

    const v0, 0x7f14001f

    invoke-virtual {p0, v0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object p0

    check-cast p0, Ljava/lang/CharSequence;

    invoke-static {p1, p0, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object p0

    invoke-virtual {p0}, Landroid/widget/Toast;->show()V

    return-void
.end method


# virtual methods
.method public onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    .locals 30

    move-object/from16 v3, p0

    .line 171
    invoke-virtual {v3}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    const-string v2, "playableItemEntity"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;

    move-object v13, v0

    goto :goto_0

    :cond_0
    move-object v13, v1

    .line 173
    :goto_0
    invoke-virtual {v3}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    if-eqz v0, :cond_d

    .line 174
    invoke-virtual {v3}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getContext()Landroid/content/Context;

    move-result-object v2

    if-eqz v2, :cond_c

    if-eqz v13, :cond_a

    .line 177
    iput-object v13, v3, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->playableItemEntity:Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;

    .line 178
    invoke-direct {v3}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->checkPreviewMediaDirectory()Ljava/lang/String;

    move-result-object v4

    .line 179
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "index.json"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    .line 180
    new-instance v4, Ljava/io/File;

    invoke-direct {v4, v9}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 181
    new-instance v4, Ljava/io/FileInputStream;

    invoke-direct {v4, v9}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V

    check-cast v4, Ljava/io/InputStream;

    sget-object v5, Ljava/nio/charset/StandardCharsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-static {v4, v5}, Lorg/apache/commons/io/IOUtils;->toString(Ljava/io/InputStream;Ljava/nio/charset/Charset;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "toString(...)"

    invoke-static {v4, v5}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 182
    sget-object v5, Lkotlinx/serialization/json/Json;->Default:Lkotlinx/serialization/json/Json$Default;

    .line 183
    sget-object v6, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;->Companion:Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex$Companion;

    invoke-virtual {v6}, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex$Companion;->serializer()Lkotlinx/serialization/KSerializer;

    move-result-object v6

    check-cast v6, Lkotlinx/serialization/DeserializationStrategy;

    .line 182
    invoke-virtual {v5, v6, v4}, Lkotlinx/serialization/json/Json$Default;->decodeFromString(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;

    move-object v14, v4

    goto :goto_1

    .line 185
    :cond_1
    new-instance v14, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;

    const/16 v18, 0x7

    const/16 v19, 0x0

    const/4 v15, 0x0

    const/16 v16, 0x0

    const/16 v17, 0x0

    invoke-direct/range {v14 .. v19}, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/jvm/internal/DefaultConstructorMarker;)V

    .line 188
    :goto_1
    invoke-virtual {v0}, Landroidx/fragment/app/FragmentActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    const v4, 0x7f0d0036

    invoke-virtual {v0, v4, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v15

    .line 191
    invoke-virtual {v3}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getDaijishouLibrary()Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object v0

    invoke-virtual {v13}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getAttachedPlatformId()Ljava/lang/Long;

    move-result-object v1

    if-eqz v1, :cond_no_plat_found

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-virtual {v0, v4, v5}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->getPlatformByIdStatically(J)Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;

    move-result-object v0

    if-eqz v0, :cond_no_plat_found

    invoke-virtual {v0}, Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;->getPlayerIdList()Ljava/util/List;

    move-result-object v11

    if-nez v11, :cond_plat_found_ok

    :cond_no_plat_found
    new-instance v11, Ljava/util/ArrayList;

    invoke-direct {v11}, Ljava/util/ArrayList;-><init>()V

    :cond_plat_found_ok

    .line 193
    invoke-interface {v11}, Ljava/util/List;->size()I

    move-result v0

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1, v0}, Ljava/util/ArrayList;-><init>(I)V

    const/4 v4, 0x0

    :goto_2
    if-ge v4, v0, :cond_3

    .line 194
    invoke-virtual {v3}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getDaijishouLibrary()Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object v5

    invoke-interface {v11, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Number;

    invoke-virtual {v6}, Ljava/lang/Number;->longValue()J

    move-result-wide v6

    invoke-virtual {v5, v6, v7}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->getPlayerByIdStatically(J)Lcom/magneticchen/daijishou/data/db/entity/PlayerEntity;

    move-result-object v5

    if-eqz v5, :cond_2

    .line 196
    invoke-virtual {v5}, Lcom/magneticchen/daijishou/data/db/entity/PlayerEntity;->getName()Ljava/lang/String;

    move-result-object v5

    goto :goto_3

    :cond_2
    const v5, 0x7f14041f

    .line 198
    invoke-virtual {v3, v5}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    const-string v6, "getString(...)"

    invoke-static {v5, v6}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 193
    :goto_3
    invoke-virtual {v1, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    add-int/lit8 v4, v4, 0x1

    goto :goto_2

    :cond_3
    move-object v12, v1

    check-cast v12, Ljava/util/List;

    .line 203
    new-instance v0, Lkotlin/jvm/internal/Ref$BooleanRef;

    invoke-direct {v0}, Lkotlin/jvm/internal/Ref$BooleanRef;-><init>()V

    .line 204
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    move-object/from16 v16, v1

    check-cast v16, Ljava/util/List;

    .line 205
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    check-cast v1, Ljava/util/List;

    const v4, 0x7f0a03b7

    .line 208
    invoke-virtual {v15, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    move-object/from16 v17, v4

    check-cast v17, Landroid/widget/EditText;

    const v4, 0x7f0a03c6

    .line 209
    invoke-virtual {v15, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    move-object/from16 v18, v4

    check-cast v18, Landroid/widget/CheckBox;

    const v4, 0x7f0a03ba

    .line 210
    invoke-virtual {v15, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    move-object/from16 v19, v4

    check-cast v19, Lcom/google/android/material/switchmaterial/SwitchMaterial;

    const v4, 0x7f0a03af

    .line 212
    invoke-virtual {v15, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/google/android/material/switchmaterial/SwitchMaterial;

    .line 213
    invoke-virtual {v13}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getDoNotPrettify()Z

    move-result v5

    invoke-virtual {v4, v5}, Lcom/google/android/material/switchmaterial/SwitchMaterial;->setChecked(Z)V

    const v5, 0x7f0a03c1

    .line 216
    invoke-virtual {v15, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/Button;

    const v6, 0x7f0a03be

    .line 217
    invoke-virtual {v15, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Lcom/google/android/material/textfield/TextInputEditText;

    const v7, 0x7f0a03bc

    .line 218
    invoke-virtual {v15, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    move-object/from16 v20, v7

    check-cast v20, Lcom/google/android/material/switchmaterial/SwitchMaterial;

    const v7, 0x7f0a03bd

    .line 219
    invoke-virtual {v15, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Lcom/google/android/material/chip/Chip;

    const v8, 0x7f0a03bf

    .line 220
    invoke-virtual {v15, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    move-object/from16 v21, v8

    check-cast v21, Lcom/google/android/material/chip/ChipGroup;

    .line 238
    sget-object v8, Lcom/magneticchen/daijishou/data/Genres;->INSTANCE:Lcom/magneticchen/daijishou/data/Genres;

    invoke-virtual {v3}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->requireContext()Landroid/content/Context;

    move-result-object v10

    move-object/from16 v22, v0

    const-string v0, "requireContext(...)"

    invoke-static {v10, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v8, v10}, Lcom/magneticchen/daijishou/data/Genres;->generateGenreIdsAndNames(Landroid/content/Context;)Lkotlin/Pair;

    move-result-object v0

    invoke-virtual {v0}, Lkotlin/Pair;->component1()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    invoke-virtual {v0}, Lkotlin/Pair;->component2()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    const v10, 0x7f0a03b1

    .line 239
    invoke-virtual {v15, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v10

    check-cast v10, Landroid/widget/AutoCompleteTextView;

    move-object/from16 v23, v0

    .line 240
    new-instance v0, Lcom/magneticchen/daijishou/utils/AutoCompleteAdapter;

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    move-object/from16 v24, v23

    check-cast v24, Ljava/lang/Iterable;

    move-object/from16 v25, v1

    invoke-static/range {v24 .. v24}, Lkotlin/collections/CollectionsKt;->sorted(Ljava/lang/Iterable;)Ljava/util/List;

    move-result-object v1

    move-object/from16 v24, v11

    const v11, 0x7f0d0097

    invoke-direct {v0, v2, v11, v1}, Lcom/magneticchen/daijishou/utils/AutoCompleteAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 241
    check-cast v0, Landroid/widget/ListAdapter;

    invoke-virtual {v10, v0}, Landroid/widget/AutoCompleteTextView;->setAdapter(Landroid/widget/ListAdapter;)V

    const v0, 0x7f0a03b0

    .line 242
    invoke-virtual {v15, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/google/android/material/chip/Chip;

    const v1, 0x7f0a03b2

    .line 243
    invoke-virtual {v15, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/google/android/material/chip/ChipGroup;

    move-object/from16 v26, v0

    .line 261
    new-instance v0, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$$ExternalSyntheticLambda0;

    move-object v11, v5

    move-object/from16 v5, v25

    move-object/from16 v25, v12

    move-object v12, v7

    move-object v7, v2

    move-object v2, v8

    move-object v8, v1

    move-object v1, v10

    move-object/from16 v10, v26

    move-object/from16 v26, v22

    move-object/from16 v22, v4

    move-object v4, v3

    move-object/from16 v3, v23

    invoke-direct/range {v0 .. v8}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$$ExternalSyntheticLambda0;-><init>(Landroid/widget/AutoCompleteTextView;Ljava/util/List;Ljava/util/List;Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Ljava/util/List;Lcom/google/android/material/textfield/TextInputEditText;Landroid/content/Context;Lcom/google/android/material/chip/ChipGroup;)V

    move-object v1, v0

    move-object v3, v4

    move-object v0, v6

    move-object v2, v7

    move-object/from16 v27, v8

    move-object v6, v5

    invoke-virtual {v10, v1}, Lcom/google/android/material/chip/Chip;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const v1, 0x7f0a038e

    .line 281
    invoke-virtual {v15, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    move-object v8, v1

    check-cast v8, Lcom/google/android/material/switchmaterial/SwitchMaterial;

    const v1, 0x7f0a038d

    .line 282
    invoke-virtual {v15, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    move-object v10, v1

    check-cast v10, Landroid/widget/AutoCompleteTextView;

    const v1, 0x7f0a03b9

    .line 287
    invoke-virtual {v15, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    move-object v7, v1

    check-cast v7, Landroid/widget/Button;

    const v1, 0x7f0a03bb

    .line 288
    invoke-virtual {v15, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    const v4, 0x7f0a03aa

    .line 345
    invoke-virtual {v15, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    .line 346
    new-instance v5, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$$ExternalSyntheticLambda10;

    invoke-direct {v5, v3, v13, v14, v9}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$$ExternalSyntheticLambda10;-><init>(Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;Ljava/lang/String;)V

    invoke-virtual {v11, v5}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    move-object v5, v1

    move-object v1, v0

    .line 416
    new-instance v0, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$$ExternalSyntheticLambda11;

    move-object v11, v4

    move-object v9, v5

    move-object/from16 v5, v21

    move-object v4, v2

    move-object/from16 v2, v16

    invoke-direct/range {v0 .. v5}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$$ExternalSyntheticLambda11;-><init>(Lcom/google/android/material/textfield/TextInputEditText;Ljava/util/List;Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Landroid/content/Context;Lcom/google/android/material/chip/ChipGroup;)V

    move-object v14, v1

    move-object v1, v0

    move-object v0, v14

    move-object v14, v2

    move-object v2, v4

    move-object/from16 v16, v5

    invoke-virtual {v12, v1}, Lcom/google/android/material/chip/Chip;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 429
    new-instance v1, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$$ExternalSyntheticLambda12;

    move-object/from16 v3, v26

    invoke-direct {v1, v3, v13, v11}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$$ExternalSyntheticLambda12;-><init>(Lkotlin/jvm/internal/Ref$BooleanRef;Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;Landroid/widget/TextView;)V

    invoke-virtual {v7, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    move-object v1, v0

    .line 447
    new-instance v0, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$$ExternalSyntheticLambda13;

    move-object/from16 v4, v17

    move-object/from16 v17, v2

    move-object v2, v13

    move-object v13, v3

    move-object v3, v4

    move-object/from16 v28, v1

    move-object/from16 v29, v11

    move-object v12, v14

    move-object/from16 v21, v15

    move-object/from16 v4, v18

    move-object/from16 v5, v19

    move-object/from16 v7, v20

    move-object/from16 v11, v24

    move-object/from16 v1, p0

    move-object v14, v6

    move-object v15, v9

    move-object v9, v10

    move-object/from16 v6, v22

    move-object/from16 v10, v25

    invoke-direct/range {v0 .. v14}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$$ExternalSyntheticLambda13;-><init>(Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;Landroid/widget/EditText;Landroid/widget/CheckBox;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Landroid/widget/AutoCompleteTextView;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlin/jvm/internal/Ref$BooleanRef;Ljava/util/List;)V

    move-object v1, v3

    move-object v3, v0

    move-object v0, v7

    move-object v7, v1

    move-object v1, v8

    move-object/from16 v22, v13

    move-object/from16 v25, v14

    move-object v13, v2

    move-object v8, v4

    move-object v2, v9

    move-object v14, v12

    move-object v9, v5

    move-object v12, v6

    invoke-virtual {v15, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 456
    new-instance v3, Lcom/magneticchen/daijishou/utils/AutoCompleteAdapter;

    move-object/from16 v4, v17

    const v5, 0x7f0d0097

    invoke-direct {v3, v4, v5, v10}, Lcom/magneticchen/daijishou/utils/AutoCompleteAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 457
    check-cast v3, Landroid/widget/ListAdapter;

    invoke-virtual {v2, v3}, Landroid/widget/AutoCompleteTextView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 458
    new-instance v3, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$$ExternalSyntheticLambda14;

    invoke-direct {v3, v1, v2}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$$ExternalSyntheticLambda14;-><init>(Lcom/google/android/material/switchmaterial/SwitchMaterial;Landroid/widget/AutoCompleteTextView;)V

    invoke-virtual {v1, v3}, Lcom/google/android/material/switchmaterial/SwitchMaterial;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 463
    invoke-virtual {v13}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getName()Ljava/lang/String;

    move-result-object v3

    check-cast v3, Ljava/lang/CharSequence;

    invoke-virtual {v7, v3}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 464
    invoke-virtual {v13}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->isVisible()Z

    move-result v3

    invoke-virtual {v8, v3}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 465
    invoke-virtual {v13}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getDoScrapeName()Z

    move-result v3

    invoke-virtual {v9, v3}, Lcom/google/android/material/switchmaterial/SwitchMaterial;->setChecked(Z)V

    .line 466
    invoke-virtual {v13}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getScraperKeywordList()Ljava/util/List;

    move-result-object v3

    check-cast v3, Ljava/util/Collection;

    invoke-interface {v3}, Ljava/util/Collection;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_4

    .line 467
    invoke-virtual {v13}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getScraperKeywordList()Ljava/util/List;

    move-result-object v3

    const/4 v15, 0x0

    invoke-interface {v3, v15}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/CharSequence;

    move-object/from16 v6, v28

    invoke-virtual {v6, v3}, Lcom/google/android/material/textfield/TextInputEditText;->setText(Ljava/lang/CharSequence;)V

    goto :goto_4

    :cond_4
    move-object/from16 v6, v28

    const/4 v15, 0x0

    .line 470
    :goto_4
    invoke-virtual {v13}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getScraperKeywordList()Ljava/util/List;

    move-result-object v3

    check-cast v3, Ljava/lang/Iterable;

    .line 574
    invoke-interface {v3}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v17

    :goto_5
    invoke-interface/range {v17 .. v17}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_5

    invoke-interface/range {v17 .. v17}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    move-object v5, v3

    check-cast v5, Ljava/lang/String;

    move-object/from16 v28, v6

    const/4 v6, 0x0

    move-object v15, v2

    move-object v2, v4

    move-object/from16 v3, v16

    move-object/from16 v4, p0

    move-object/from16 v16, v9

    move-object v9, v1

    move-object v1, v14

    move-object v14, v0

    move-object/from16 v0, v28

    .line 471
    invoke-static/range {v0 .. v6}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->onCreateDialog$lambda$26$lambda$25$lambda$24$addScraperKeyword(Lcom/google/android/material/textfield/TextInputEditText;Ljava/util/List;Landroid/content/Context;Lcom/google/android/material/chip/ChipGroup;Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Ljava/lang/String;Z)V

    move-object v6, v0

    move-object v4, v2

    move-object v0, v14

    move-object v2, v15

    const/4 v15, 0x0

    move-object v14, v1

    move-object v1, v9

    move-object/from16 v9, v16

    move-object/from16 v16, v3

    goto :goto_5

    :cond_5
    move-object v15, v2

    move-object v2, v4

    move-object/from16 v16, v9

    move-object/from16 v18, v14

    move-object v14, v0

    move-object v9, v1

    move-object v0, v6

    .line 473
    invoke-virtual/range {p0 .. p0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getDaijishouLibrary()Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;

    move-result-object v1

    invoke-virtual {v13}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getId()J

    move-result-wide v3

    invoke-virtual {v1, v3, v4}, Lcom/magneticchen/daijishou/ui/model/DaijishouLibraryModel;->getGenreIdsByPlayableItemIdStatically(J)Ljava/util/List;

    move-result-object v1

    check-cast v1, Ljava/lang/Iterable;

    .line 576
    invoke-interface {v1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v17

    :goto_6
    invoke-interface/range {v17 .. v17}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_6

    invoke-interface/range {v17 .. v17}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    move-object v5, v1

    check-cast v5, Ljava/lang/String;

    const/4 v6, 0x0

    move-object/from16 v3, p0

    move-object/from16 v1, v25

    move-object/from16 v4, v27

    .line 474
    invoke-static/range {v0 .. v6}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->onCreateDialog$lambda$26$lambda$25$lambda$24$addGenreId(Lcom/google/android/material/textfield/TextInputEditText;Ljava/util/List;Landroid/content/Context;Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Lcom/google/android/material/chip/ChipGroup;Ljava/lang/String;Z)V

    goto :goto_6

    .line 476
    :cond_6
    invoke-virtual {v13}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getScrapeScraperKeywords()Z

    move-result v0

    invoke-virtual {v14, v0}, Lcom/google/android/material/switchmaterial/SwitchMaterial;->setChecked(Z)V

    .line 477
    invoke-virtual {v13}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getUseCustomPlayer()Z

    move-result v0

    invoke-static {v9, v15, v0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->onCreateDialog$lambda$26$lambda$25$lambda$24$setUseCustomPlayer(Lcom/google/android/material/switchmaterial/SwitchMaterial;Landroid/widget/AutoCompleteTextView;Z)V

    .line 478
    invoke-virtual {v13}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getCustomPlayerId()Ljava/lang/Long;

    move-result-object v0

    invoke-static {v11, v0}, Lkotlin/collections/CollectionsKt;->indexOf(Ljava/util/List;Ljava/lang/Object;)I

    move-result v0

    const/4 v1, -0x1

    if-eq v0, v1, :cond_7

    .line 480
    invoke-interface {v10, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    const/4 v1, 0x0

    invoke-virtual {v15, v0, v1}, Landroid/widget/AutoCompleteTextView;->setText(Ljava/lang/CharSequence;Z)V

    .line 482
    :cond_7
    invoke-virtual {v13}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getId()J

    move-result-wide v0

    .line 483
    invoke-virtual {v13}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->isInSingletonDisjointSet()Z

    move-result v4

    .line 484
    invoke-virtual {v13}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getUseDisjointSetPrimaryPlayableItem()Z

    move-result v5

    .line 485
    invoke-virtual {v13}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getDisjointSetPrimaryPlayableItemId()Ljava/lang/Long;

    move-result-object v6

    move-object/from16 v17, v7

    .line 486
    invoke-virtual {v13}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getMd5()Ljava/lang/String;

    move-result-object v7

    move-object/from16 v19, v8

    .line 487
    invoke-virtual {v13}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getAddedDateTimestamp()Ljava/util/Date;

    move-result-object v8

    .line 488
    invoke-virtual {v13}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getSyncTreeUri()Landroid/net/Uri;

    move-result-object v20

    move-object/from16 v23, v9

    if-eqz v20, :cond_sync_null

    invoke-virtual/range {v20 .. v20}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v9

    if-nez v9, :cond_sync_ok

    :cond_sync_null
    const-string v9, ""

    :cond_sync_ok
    move-object/from16 v20, v10

    .line 489
    invoke-virtual {v13}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getUri()Landroid/net/Uri;

    move-result-object v10

    .line 490
    invoke-virtual {v13}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getUri()Landroid/net/Uri;

    move-result-object v24

    move-object/from16 v26, v11

    if-eqz v24, :cond_uri_null

    invoke-virtual/range {v24 .. v24}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v11

    if-nez v11, :cond_uri_ok

    :cond_uri_null
    const-string v11, ""

    :cond_uri_ok

    move-object/from16 p1, v12

    .line 491
    invoke-virtual {v13}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getPreviewMediaPath()Ljava/lang/String;

    move-result-object v12

    move-object/from16 v24, v13

    .line 492
    invoke-virtual/range {v24 .. v24}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getPlayCount()I

    move-result v13

    move-object/from16 v27, v14

    .line 493
    invoke-virtual/range {v24 .. v24}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getLastPlayedTimestamp()Ljava/util/Date;

    move-result-object v14

    move-object/from16 v28, v15

    new-instance v15, Ljava/lang/StringBuilder;

    const-string v3, "<b>Id:</b> "

    invoke-direct {v15, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v15, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "<br><b>IsInSingletonDisjointSet:</b> "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "<br><b>UseDisjointSetPrimaryPlayableItem:</b> "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "<br><b>DisjointSetPrimaryPlayableItemId:</b> "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "<br><b>Lazy md5:</b> "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "<br><b>Added date:</b> "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "<br><b>Sync tree:</b> "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "<br><b>Uri:</b> "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "<br><b>Uri path:</b> "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "<br><b>Preview media path:</b> "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "<br><b>Played count:</b> "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v13}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "<br><b>Last played:</b> "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 494
    invoke-static {v0}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    move-object/from16 v11, v29

    invoke-virtual {v11, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 498
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-direct {v0, v2}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    move-object/from16 v1, v21

    .line 499
    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setView(Landroid/view/View;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x7f140121

    move-object/from16 v3, p0

    .line 500
    invoke-virtual {v3, v1}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    check-cast v1, Ljava/lang/CharSequence;

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x7f14039a

    .line 501
    invoke-virtual {v3, v1}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    check-cast v1, Ljava/lang/CharSequence;

    new-instance v4, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$$ExternalSyntheticLambda15;

    invoke-direct {v4}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$$ExternalSyntheticLambda15;-><init>()V

    invoke-virtual {v0, v1, v4}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x7f140099

    .line 502
    invoke-virtual {v3, v1}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    check-cast v1, Ljava/lang/CharSequence;

    new-instance v4, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$$ExternalSyntheticLambda16;

    invoke-direct {v4}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$$ExternalSyntheticLambda16;-><init>()V

    invoke-virtual {v0, v1, v4}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 504
    invoke-virtual/range {v24 .. v24}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getSyncTreeUri()Landroid/net/Uri;

    move-result-object v1

    sget-object v4, Landroid/net/Uri;->EMPTY:Landroid/net/Uri;

    invoke-static {v1, v4}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_9

    invoke-virtual/range {v24 .. v24}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getUri()Landroid/net/Uri;

    move-result-object v1

    sget-object v4, Landroid/net/Uri;->EMPTY:Landroid/net/Uri;

    invoke-static {v1, v4}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_8

    goto :goto_7

    :cond_8
    const v1, 0x7f140421

    .line 509
    invoke-virtual {v3, v1}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    check-cast v1, Ljava/lang/CharSequence;

    new-instance v4, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$$ExternalSyntheticLambda1;

    invoke-direct {v4}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$$ExternalSyntheticLambda1;-><init>()V

    invoke-virtual {v0, v1, v4}, Landroid/app/AlertDialog$Builder;->setNeutralButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    goto :goto_8

    :cond_9
    :goto_7
    const v1, 0x7f1400e4

    .line 505
    invoke-virtual {v3, v1}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    check-cast v1, Ljava/lang/CharSequence;

    new-instance v4, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$$ExternalSyntheticLambda17;

    invoke-direct {v4}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$$ExternalSyntheticLambda17;-><init>()V

    invoke-virtual {v0, v1, v4}, Landroid/app/AlertDialog$Builder;->setNeutralButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 513
    :goto_8
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v1

    .line 514
    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    move-object v0, v1

    check-cast v0, Landroid/app/Dialog;

    invoke-virtual {v3, v0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->setupDaijishouDialog(Landroid/app/Dialog;)V

    .line 515
    invoke-virtual/range {v17 .. v17}, Landroid/widget/EditText;->requestFocus()Z

    .line 517
    new-instance v0, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$$ExternalSyntheticLambda9;

    move-object/from16 v7, p1

    move-object/from16 v6, v16

    move-object/from16 v4, v17

    move-object/from16 v14, v18

    move-object/from16 v5, v19

    move-object/from16 v11, v20

    move-object/from16 v15, v22

    move-object/from16 v9, v23

    move-object/from16 v13, v24

    move-object/from16 v16, v25

    move-object/from16 v12, v26

    move-object/from16 v8, v27

    move-object/from16 v10, v28

    invoke-direct/range {v0 .. v16}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment$$ExternalSyntheticLambda9;-><init>(Landroid/app/AlertDialog;Landroid/content/Context;Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;Landroid/widget/EditText;Landroid/widget/CheckBox;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Lcom/google/android/material/switchmaterial/SwitchMaterial;Landroid/widget/AutoCompleteTextView;Ljava/util/List;Ljava/util/List;Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;Ljava/util/List;Lkotlin/jvm/internal/Ref$BooleanRef;Ljava/util/List;)V

    invoke-virtual {v1, v0}, Landroid/app/AlertDialog;->setOnShowListener(Landroid/content/DialogInterface$OnShowListener;)V

    :cond_a
    if-eqz v1, :cond_b

    .line 173
    check-cast v1, Landroid/app/Dialog;

    return-object v1

    .line 568
    :cond_b
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "playableItemEntity cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 569
    :cond_c
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Context cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 570
    :cond_d
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Activity cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public onStart()V
    .locals 3

    .line 164
    invoke-super {p0}, Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouDialogFragment;->onStart()V

    .line 165
    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->requireDialog()Landroid/app/Dialog;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/magneticchen/daijishou/ui/fragments/dialog/EditPlayableItemDialogFragment;->requireContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f0800aa

    invoke-static {v1, v2}, Landroidx/appcompat/content/res/AppCompatResources;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/Window;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    :cond_0
    return-void
.end method
