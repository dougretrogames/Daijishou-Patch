.class public final Lcom/magneticchen/daijishou/utils/Utils;
.super Ljava/lang/Object;
.source "Utils.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/magneticchen/daijishou/utils/Utils$GridSpacingItemDecoration;,
        Lcom/magneticchen/daijishou/utils/Utils$MaxSizeHashMap;
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\ncom/magneticchen/daijishou/utils/Utils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,544:1\n1#2:545\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002GHB\u0007\u0008\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J*\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u0013J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\r2\u0006\u0010 \u001a\u00020!J\u0010\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010 \u001a\u00020!J\u000e\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020&JC\u0010\'\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\n\u0008\u0002\u0010(\u001a\u0004\u0018\u00010\u001b2\n\u0008\u0002\u0010)\u001a\u0004\u0018\u00010\u001b2\n\u0008\u0002\u0010*\u001a\u0004\u0018\u00010\u001b2\n\u0008\u0002\u0010+\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0002\u0010,J\u0010\u0010-\u001a\u00020\u00162\u0008\u0010\u0008\u001a\u0004\u0018\u00010\tJ\u0010\u0010.\u001a\u0004\u0018\u00010\u00042\u0006\u0010/\u001a\u00020\u000fJ\u000e\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\rJ\u000e\u00102\u001a\u00020\r2\u0006\u00103\u001a\u000204J\u0018\u00105\u001a\u00020\r2\u0006\u00106\u001a\u00020&2\u0008\u0008\u0002\u00107\u001a\u00020\u0016J2\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00132\u0006\u0010<\u001a\u00020\u00132\u0008\u0008\u0002\u0010=\u001a\u00020&2\u0008\u0008\u0002\u0010>\u001a\u00020\u0016J6\u0010?\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r0\u001a0@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u000b2\u0006\u0010D\u001a\u00020EJ\u0012\u0010F\u001a\u00020&*\u00020B2\u0006\u0010\u0011\u001a\u00020\u000b\u00a8\u0006I"
    }
    d2 = {
        "Lcom/magneticchen/daijishou/utils/Utils;",
        "",
        "()V",
        "atStartOfDay",
        "Ljava/util/Date;",
        "date",
        "copyFile",
        "",
        "context",
        "Landroid/content/Context;",
        "sourceUri",
        "Landroid/net/Uri;",
        "destinationFilename",
        "",
        "dateToLocalDateTime",
        "Ljava/time/LocalDateTime;",
        "detectMimeType",
        "uri",
        "dimensionRatioToFloat",
        "",
        "dimensionRatio",
        "dismissAllDialogs",
        "",
        "manager",
        "Landroidx/fragment/app/FragmentManager;",
        "getBitmapThemeColors",
        "Lkotlin/Triple;",
        "",
        "bitmap",
        "Landroid/graphics/Bitmap;",
        "luminance",
        "getBoxArtPath",
        "playableItemEntity",
        "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;",
        "getPlayableItemPreviewMediaIndex",
        "Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;",
        "getRelativeTimeString",
        "timestamp",
        "",
        "isBitmapDark",
        "left",
        "top",
        "right",
        "bottom",
        "(Landroid/graphics/Bitmap;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Z",
        "isNetworkAvailable",
        "localDateTimeToDate",
        "localDateTime",
        "readEntireTextFromURL",
        "urlString",
        "readTextFromBufferedReader",
        "buffIn",
        "Ljava/io/BufferedReader;",
        "readableFileSize",
        "size",
        "use1024",
        "scaleView",
        "v",
        "Landroid/view/View;",
        "startScale",
        "endScale",
        "duration",
        "focusFix",
        "traverseDirectoryEntries",
        "",
        "contentResolver",
        "Landroid/content/ContentResolver;",
        "rootUri",
        "application",
        "Lcom/magneticchen/daijishou/DaijishouApplication;",
        "getFileSize",
        "GridSpacingItemDecoration",
        "MaxSizeHashMap",
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
.field public static final INSTANCE:Lcom/magneticchen/daijishou/utils/Utils;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/magneticchen/daijishou/utils/Utils;

    invoke-direct {v0}, Lcom/magneticchen/daijishou/utils/Utils;-><init>()V

    sput-object v0, Lcom/magneticchen/daijishou/utils/Utils;->INSTANCE:Lcom/magneticchen/daijishou/utils/Utils;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .line 118
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static synthetic getBitmapThemeColors$default(Lcom/magneticchen/daijishou/utils/Utils;Landroid/graphics/Bitmap;FILjava/lang/Object;)Lkotlin/Triple;
    .locals 0

    and-int/lit8 p3, p3, 0x2

    if-eqz p3, :cond_0

    const p2, 0x3ea8f5c3    # 0.33f

    .line 374
    :cond_0
    invoke-virtual {p0, p1, p2}, Lcom/magneticchen/daijishou/utils/Utils;->getBitmapThemeColors(Landroid/graphics/Bitmap;F)Lkotlin/Triple;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic isBitmapDark$default(Lcom/magneticchen/daijishou/utils/Utils;Landroid/graphics/Bitmap;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ILjava/lang/Object;)Z
    .locals 1

    and-int/lit8 p7, p6, 0x2

    const/4 v0, 0x0

    if-eqz p7, :cond_0

    move-object p2, v0

    :cond_0
    and-int/lit8 p7, p6, 0x4

    if-eqz p7, :cond_1

    move-object p3, v0

    :cond_1
    and-int/lit8 p7, p6, 0x8

    if-eqz p7, :cond_2

    move-object p4, v0

    :cond_2
    and-int/lit8 p6, p6, 0x10

    if-eqz p6, :cond_3

    move-object p5, v0

    .line 353
    :cond_3
    invoke-virtual/range {p0 .. p5}, Lcom/magneticchen/daijishou/utils/Utils;->isBitmapDark(Landroid/graphics/Bitmap;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Z

    move-result p0

    return p0
.end method

.method public static synthetic readableFileSize$default(Lcom/magneticchen/daijishou/utils/Utils;JZILjava/lang/Object;)Ljava/lang/String;
    .locals 0

    and-int/lit8 p4, p4, 0x2

    if-eqz p4, :cond_0

    const/4 p3, 0x0

    .line 120
    :cond_0
    invoke-virtual {p0, p1, p2, p3}, Lcom/magneticchen/daijishou/utils/Utils;->readableFileSize(JZ)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic scaleView$default(Lcom/magneticchen/daijishou/utils/Utils;Landroid/view/View;FFJZILjava/lang/Object;)V
    .locals 7

    and-int/lit8 p8, p7, 0x8

    if-eqz p8, :cond_0

    const-wide/16 p4, 0x64

    :cond_0
    move-wide v4, p4

    and-int/lit8 p4, p7, 0x10

    if-eqz p4, :cond_1

    const/4 p6, 0x0

    :cond_1
    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move v3, p3

    move v6, p6

    .line 169
    invoke-virtual/range {v0 .. v6}, Lcom/magneticchen/daijishou/utils/Utils;->scaleView(Landroid/view/View;FFJZ)V

    return-void
.end method

.method private static final traverseDirectoryEntries$isDirectory(Ljava/lang/String;)Z
    .locals 1

    .line 225
    const-string v0, "vnd.android.document/directory"

    invoke-static {v0, p0}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result p0

    return p0
.end method


# virtual methods
.method public final atStartOfDay(Ljava/util/Date;)Ljava/util/Date;
    .locals 1

    const-string v0, "date"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 156
    invoke-virtual {p0, p1}, Lcom/magneticchen/daijishou/utils/Utils;->dateToLocalDateTime(Ljava/util/Date;)Ljava/time/LocalDateTime;

    move-result-object p1

    .line 157
    sget-object v0, Ljava/time/LocalTime;->MIN:Ljava/time/LocalTime;

    check-cast v0, Ljava/time/temporal/TemporalAdjuster;

    invoke-virtual {p1, v0}, Ljava/time/LocalDateTime;->with(Ljava/time/temporal/TemporalAdjuster;)Ljava/time/LocalDateTime;

    move-result-object p1

    const-string v0, "with(...)"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 158
    invoke-virtual {p0, p1}, Lcom/magneticchen/daijishou/utils/Utils;->localDateTimeToDate(Ljava/time/LocalDateTime;)Ljava/util/Date;

    move-result-object p1

    return-object p1
.end method

.method public final copyFile(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;)V
    .locals 3

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "sourceUri"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "destinationFilename"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x0

    .line 201
    :try_start_0
    new-instance v1, Ljava/io/File;

    invoke-direct {v1, p3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/io/File;->createNewFile()Z

    .line 202
    new-instance v1, Ljava/io/BufferedInputStream;

    invoke-virtual {p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object p1

    invoke-virtual {p1, p2}, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;

    move-result-object p1

    invoke-direct {v1, p1}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_3
    .catchall {:try_start_0 .. :try_end_0} :catchall_2

    .line 203
    :try_start_1
    new-instance p1, Ljava/io/BufferedOutputStream;

    new-instance p2, Ljava/io/FileOutputStream;

    const/4 v2, 0x0

    invoke-direct {p2, p3, v2}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;Z)V

    check-cast p2, Ljava/io/OutputStream;

    invoke-direct {p1, p2}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    const/16 p2, 0x400

    .line 204
    :try_start_2
    new-array p2, p2, [B

    .line 205
    invoke-virtual {v1, p2}, Ljava/io/BufferedInputStream;->read([B)I

    .line 207
    :cond_0
    invoke-virtual {p1, p2}, Ljava/io/BufferedOutputStream;->write([B)V

    .line 208
    invoke-virtual {v1, p2}, Ljava/io/BufferedInputStream;->read([B)I

    move-result p3
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    const/4 v0, -0x1

    if-ne p3, v0, :cond_0

    .line 213
    :try_start_3
    invoke-virtual {v1}, Ljava/io/BufferedInputStream;->close()V

    .line 214
    :goto_0
    invoke-virtual {p1}, Ljava/io/BufferedOutputStream;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0

    goto :goto_4

    :catch_0
    move-exception p1

    .line 216
    invoke-virtual {p1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_4

    :catchall_0
    move-exception p2

    goto :goto_1

    :catch_1
    move-exception p2

    goto :goto_2

    :catchall_1
    move-exception p2

    move-object p1, v0

    :goto_1
    move-object v0, v1

    goto :goto_5

    :catch_2
    move-exception p2

    move-object p1, v0

    :goto_2
    move-object v0, v1

    goto :goto_3

    :catchall_2
    move-exception p2

    move-object p1, v0

    goto :goto_5

    :catch_3
    move-exception p2

    move-object p1, v0

    .line 210
    :goto_3
    :try_start_4
    invoke-virtual {p2}, Ljava/io/IOException;->printStackTrace()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_3

    if-eqz v0, :cond_1

    .line 213
    :try_start_5
    invoke-virtual {v0}, Ljava/io/BufferedInputStream;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_0

    :cond_1
    if-eqz p1, :cond_2

    goto :goto_0

    :cond_2
    :goto_4
    return-void

    :catchall_3
    move-exception p2

    :goto_5
    if-eqz v0, :cond_3

    :try_start_6
    invoke-virtual {v0}, Ljava/io/BufferedInputStream;->close()V

    goto :goto_6

    :catch_4
    move-exception p1

    goto :goto_7

    :cond_3
    :goto_6
    if-eqz p1, :cond_4

    .line 214
    invoke-virtual {p1}, Ljava/io/BufferedOutputStream;->close()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_4

    goto :goto_8

    .line 216
    :goto_7
    invoke-virtual {p1}, Ljava/io/IOException;->printStackTrace()V

    :cond_4
    :goto_8
    throw p2
.end method

.method public final dateToLocalDateTime(Ljava/util/Date;)Ljava/time/LocalDateTime;
    .locals 1

    const-string v0, "date"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 162
    invoke-virtual {p1}, Ljava/util/Date;->toInstant()Ljava/time/Instant;

    move-result-object p1

    invoke-static {}, Ljava/time/ZoneId;->systemDefault()Ljava/time/ZoneId;

    move-result-object v0

    invoke-static {p1, v0}, Ljava/time/LocalDateTime;->ofInstant(Ljava/time/Instant;Ljava/time/ZoneId;)Ljava/time/LocalDateTime;

    move-result-object p1

    const-string v0, "ofInstant(...)"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    return-object p1
.end method

.method public final detectMimeType(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;
    .locals 3

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "uri"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x0

    .line 530
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    invoke-virtual {v1, p2}, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;

    move-result-object v1

    if-eqz v1, :cond_2

    check-cast v1, Ljava/io/Closeable;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :try_start_1
    move-object v2, v1

    check-cast v2, Ljava/io/InputStream;

    invoke-static {v2}, Lkotlin/io/ByteStreamsKt;->readBytes(Ljava/io/InputStream;)[B

    move-result-object v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_2

    :try_start_2
    invoke-static {v1, v0}, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable;Ljava/lang/Throwable;)V

    if-nez v2, :cond_0

    goto :goto_0

    .line 529
    :cond_0
    new-instance v1, Ljava/io/ByteArrayInputStream;

    .line 533
    invoke-direct {v1, v2}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    check-cast v1, Ljava/io/Closeable;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    :try_start_3
    move-object v2, v1

    check-cast v2, Ljava/io/ByteArrayInputStream;

    check-cast v2, Ljava/io/InputStream;

    invoke-static {v2}, Ljava/net/URLConnection;->guessContentTypeFromStream(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    invoke-static {v1, v0}, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable;Ljava/lang/Throwable;)V

    if-eqz v2, :cond_1

    return-object v2

    .line 537
    :cond_1
    invoke-virtual {p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object p1

    invoke-virtual {p1, p2}, Landroid/content/ContentResolver;->getType(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object p1
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0

    return-object p1

    :catchall_0
    move-exception p1

    .line 533
    :try_start_5
    throw p1
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    :catchall_1
    move-exception p2

    :try_start_6
    invoke-static {v1, p1}, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable;Ljava/lang/Throwable;)V

    throw p2
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_0

    :catchall_2
    move-exception p1

    .line 530
    :try_start_7
    throw p1
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_3

    :catchall_3
    move-exception p2

    :try_start_8
    invoke-static {v1, p1}, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable;Ljava/lang/Throwable;)V

    throw p2
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_0

    :catch_0
    :cond_2
    :goto_0
    return-object v0
.end method

.method public final dimensionRatioToFloat(Ljava/lang/String;)F
    .locals 8

    const-string v0, "dimensionRatio"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 330
    move-object v1, p1

    check-cast v1, Ljava/lang/CharSequence;

    const/4 p1, 0x1

    new-array v2, p1, [Ljava/lang/String;

    const-string v0, ":"

    const/4 v7, 0x0

    aput-object v0, v2, v7

    const/4 v5, 0x6

    const/4 v6, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-static/range {v1 .. v6}, Lkotlin/text/StringsKt;->split$default(Ljava/lang/CharSequence;[Ljava/lang/String;ZIILjava/lang/Object;)Ljava/util/List;

    move-result-object v0

    .line 331
    invoke-interface {v0, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-static {v1}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v1

    .line 332
    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/String;

    invoke-static {p1}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result p1

    div-float/2addr v1, p1

    return v1
.end method

.method public final dismissAllDialogs(Landroidx/fragment/app/FragmentManager;)Z
    .locals 5

    const-string v0, "manager"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 337
    invoke-virtual {p1}, Landroidx/fragment/app/FragmentManager;->getFragments()Ljava/util/List;

    move-result-object p1

    const-string v0, "getFragments(...)"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 338
    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    move-result v0

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    return v1

    .line 340
    :cond_0
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :cond_1
    move v0, v1

    :goto_0
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_4

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/fragment/app/Fragment;

    .line 341
    instance-of v3, v2, Landroidx/fragment/app/DialogFragment;

    const/4 v4, 0x1

    if-eqz v3, :cond_2

    .line 342
    move-object v0, v2

    check-cast v0, Landroidx/fragment/app/DialogFragment;

    .line 343
    invoke-virtual {v0}, Landroidx/fragment/app/DialogFragment;->dismiss()V

    move v0, v4

    .line 346
    :cond_2
    invoke-virtual {v2}, Landroidx/fragment/app/Fragment;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;

    move-result-object v2

    const-string v3, "getChildFragmentManager(...)"

    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 347
    invoke-virtual {p0, v2}, Lcom/magneticchen/daijishou/utils/Utils;->dismissAllDialogs(Landroidx/fragment/app/FragmentManager;)Z

    move-result v2

    if-nez v2, :cond_3

    if-eqz v0, :cond_1

    :cond_3
    move v0, v4

    goto :goto_0

    :cond_4
    return v0
.end method

.method public final getBitmapThemeColors(Landroid/graphics/Bitmap;F)Lkotlin/Triple;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/graphics/Bitmap;",
            "F)",
            "Lkotlin/Triple<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Integer;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    const-string v0, "bitmap"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 376
    invoke-static {p1}, Landroidx/palette/graphics/Palette;->from(Landroid/graphics/Bitmap;)Landroidx/palette/graphics/Palette$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/palette/graphics/Palette$Builder;->generate()Landroidx/palette/graphics/Palette;

    move-result-object v0

    const-string v1, "generate(...)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v1, 0x3

    .line 380
    new-array v2, v1, [F

    .line 382
    sget-object v3, Lcom/magneticchen/daijishou/utils/PlaidColorUtils;->INSTANCE:Lcom/magneticchen/daijishou/utils/PlaidColorUtils;

    invoke-virtual {v3, p1, p2}, Lcom/magneticchen/daijishou/utils/PlaidColorUtils;->isDark(Landroid/graphics/Bitmap;F)Z

    move-result p1

    const/4 p2, -0x1

    if-eqz p1, :cond_1

    .line 383
    invoke-virtual {v0}, Landroidx/palette/graphics/Palette;->getVibrantSwatch()Landroidx/palette/graphics/Palette$Swatch;

    move-result-object p1

    if-eqz p1, :cond_0

    .line 384
    invoke-virtual {p1}, Landroidx/palette/graphics/Palette$Swatch;->getRgb()I

    move-result p1

    goto :goto_0

    :cond_0
    move p1, p2

    .line 386
    :goto_0
    invoke-virtual {v0}, Landroidx/palette/graphics/Palette;->getDarkVibrantSwatch()Landroidx/palette/graphics/Palette$Swatch;

    move-result-object v0

    if-eqz v0, :cond_3

    .line 387
    invoke-virtual {v0}, Landroidx/palette/graphics/Palette$Swatch;->getRgb()I

    move-result p1

    goto :goto_2

    .line 392
    :cond_1
    invoke-virtual {v0}, Landroidx/palette/graphics/Palette;->getDarkVibrantSwatch()Landroidx/palette/graphics/Palette$Swatch;

    move-result-object p1

    if-eqz p1, :cond_2

    .line 393
    invoke-virtual {p1}, Landroidx/palette/graphics/Palette$Swatch;->getRgb()I

    move-result p1

    goto :goto_1

    :cond_2
    move p1, p2

    .line 395
    :goto_1
    invoke-virtual {v0}, Landroidx/palette/graphics/Palette;->getVibrantSwatch()Landroidx/palette/graphics/Palette$Swatch;

    move-result-object v0

    if-eqz v0, :cond_3

    .line 396
    invoke-virtual {v0}, Landroidx/palette/graphics/Palette$Swatch;->getRgb()I

    move-result p1

    .line 401
    :cond_3
    :goto_2
    invoke-static {p1, v2}, Landroidx/core/graphics/ColorUtils;->colorToHSL(I[F)V

    const/4 p1, 0x0

    .line 404
    aget v0, v2, p1

    const/high16 v3, 0x43820000    # 260.0f

    cmpg-float v3, v0, v3

    const/high16 v4, 0x436b0000    # 235.0f

    if-gez v3, :cond_4

    cmpl-float v0, v0, v4

    if-ltz v0, :cond_4

    const/high16 v0, 0x43870000    # 270.0f

    .line 405
    aput v0, v2, p1

    .line 406
    :cond_4
    aget v0, v2, p1

    cmpg-float v3, v0, v4

    if-gez v3, :cond_5

    const/high16 v3, 0x43480000    # 200.0f

    cmpl-float v0, v0, v3

    if-lez v0, :cond_5

    .line 407
    aput v3, v2, p1

    .line 409
    :cond_5
    aget v0, v2, p1

    const/high16 v3, 0x42f00000    # 120.0f

    cmpg-float v4, v0, v3

    const/high16 v5, 0x42dc0000    # 110.0f

    if-gez v4, :cond_6

    cmpl-float v0, v0, v5

    if-ltz v0, :cond_6

    .line 410
    aput v3, v2, p1

    .line 411
    :cond_6
    aget v0, v2, p1

    cmpg-float v3, v0, v5

    if-gez v3, :cond_7

    const/high16 v3, 0x42c80000    # 100.0f

    cmpl-float v0, v0, v3

    if-lez v0, :cond_7

    .line 412
    aput v3, v2, p1

    .line 416
    :cond_7
    aget v0, v2, p1

    const/high16 v3, 0x42960000    # 75.0f

    cmpg-float v4, v0, v3

    const/high16 v5, 0x42700000    # 60.0f

    if-gez v4, :cond_8

    cmpl-float v0, v0, v5

    if-ltz v0, :cond_8

    .line 417
    aput v3, v2, p1

    .line 418
    :cond_8
    aget v0, v2, p1

    cmpg-float v3, v0, v5

    const/4 v4, 0x1

    const/4 v5, 0x2

    if-gez v3, :cond_9

    const/high16 v3, 0x420c0000    # 35.0f

    cmpl-float v0, v0, v3

    if-lez v0, :cond_9

    .line 419
    aput v3, v2, p1

    const p1, 0x3f733333    # 0.95f

    .line 420
    aget v0, v2, v4

    invoke-static {p1, v0}, Ljava/lang/Math;->max(FF)F

    move-result p1

    aput p1, v2, v4

    const p1, 0x3ee66666    # 0.45f

    .line 421
    aget v0, v2, v5

    invoke-static {p1, v0}, Ljava/lang/Math;->min(FF)F

    move-result p1

    aput p1, v2, v5

    :cond_9
    const p1, 0x3dcccccd    # 0.1f

    .line 425
    aget v0, v2, v4

    invoke-static {p1, v0}, Ljava/lang/Math;->max(FF)F

    move-result p1

    aput p1, v2, v4

    const v0, 0x3f4ccccd    # 0.8f

    .line 426
    invoke-static {v0, p1}, Ljava/lang/Math;->min(FF)F

    move-result p1

    aput p1, v2, v4

    const/high16 p1, 0x3e800000    # 0.25f

    .line 429
    aget v0, v2, v5

    invoke-static {p1, v0}, Ljava/lang/Math;->max(FF)F

    move-result p1

    aput p1, v2, v5

    const v0, 0x3f19999a    # 0.6f

    .line 430
    invoke-static {v0, p1}, Ljava/lang/Math;->min(FF)F

    move-result p1

    aput p1, v2, v5

    .line 431
    invoke-static {v2}, Landroidx/core/graphics/ColorUtils;->HSLToColor([F)I

    move-result p1

    .line 434
    new-array v0, v1, [F

    .line 435
    invoke-static {p1, v0}, Landroidx/core/graphics/ColorUtils;->colorToHSL(I[F)V

    const v1, 0x3ecccccd    # 0.4f

    .line 436
    aget v2, v0, v5

    invoke-static {v1, v2}, Ljava/lang/Math;->max(FF)F

    move-result v1

    aput v1, v0, v5

    .line 437
    invoke-static {v0}, Landroidx/core/graphics/ColorUtils;->HSLToColor([F)I

    move-result v0

    .line 439
    new-instance v1, Lkotlin/Triple;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    invoke-direct {v1, p1, v0, p2}, Lkotlin/Triple;-><init>(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    return-object v1
.end method

.method public final getBoxArtPath(Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;)Ljava/lang/String;
    .locals 8

    const-string v0, "playableItemEntity"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    move-object v1, p1

    .line 443
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getPreviewMediaPath()Ljava/lang/String;

    move-result-object p1

    const/4 v0, 0x0

    if-eqz p1, :cond_2

    .line 445
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "index.json"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 447
    new-instance v2, Ljava/io/File;

    invoke-direct {v2, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 449
    new-instance v2, Ljava/io/FileInputStream;

    invoke-direct {v2, v1}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V

    check-cast v2, Ljava/io/InputStream;

    sget-object v1, Ljava/nio/charset/StandardCharsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-static {v2, v1}, Lorg/apache/commons/io/IOUtils;->toString(Ljava/io/InputStream;Ljava/nio/charset/Charset;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "toString(...)"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 450
    sget-object v2, Lkotlinx/serialization/json/Json;->Default:Lkotlinx/serialization/json/Json$Default;

    sget-object v3, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;->Companion:Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex$Companion;

    invoke-virtual {v3}, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex$Companion;->serializer()Lkotlinx/serialization/KSerializer;

    move-result-object v3

    check-cast v3, Lkotlinx/serialization/DeserializationStrategy;

    invoke-virtual {v2, v3, v1}, Lkotlinx/serialization/json/Json$Default;->decodeFromString(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;

    goto :goto_0

    .line 452
    :cond_0
    new-instance v2, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;

    const/4 v6, 0x7

    const/4 v7, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-direct/range {v2 .. v7}, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/jvm/internal/DefaultConstructorMarker;)V

    move-object v1, v2

    :goto_0
    if-nez v1, :cond_1

    .line 454
    const-string v1, "playableItemPreviewMediaIndex"

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_1

    :cond_1
    move-object v0, v1

    :goto_1
    invoke-virtual {v0}, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;->getBoxArtPath()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_has_boxart_arcade

    invoke-static {v1}, Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver;->resolveBoxArtPath(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_has_boxart_arcade
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    return-object p1

    :cond_2
    invoke-static {v1}, Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver;->resolveBoxArtPath(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getFileSize(Landroid/content/ContentResolver;Landroid/net/Uri;)J
    .locals 7

    const-string v0, "<this>"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "uri"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    move-object v1, p1

    move-object v2, p2

    .line 504
    invoke-virtual/range {v1 .. v6}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object p1

    const/4 p2, 0x0

    if-eqz p1, :cond_1

    check-cast p1, Ljava/io/Closeable;

    :try_start_0
    move-object v0, p1

    check-cast v0, Landroid/database/Cursor;

    .line 505
    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 506
    const-string v3, "_size"

    invoke-interface {v0, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    const/4 v4, -0x1

    if-eq v3, v4, :cond_0

    .line 508
    invoke-interface {v0, v3}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 509
    invoke-static {p1, p2}, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable;Ljava/lang/Throwable;)V

    return-wide v0

    .line 512
    :cond_0
    :try_start_1
    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 504
    invoke-static {p1, p2}, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable;Ljava/lang/Throwable;)V

    goto :goto_0

    :catchall_0
    move-exception v0

    move-object p2, v0

    :try_start_2
    throw p2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    :catchall_1
    move-exception v0

    invoke-static {p1, p2}, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable;Ljava/lang/Throwable;)V

    throw v0

    .line 514
    :cond_1
    :goto_0
    invoke-virtual {v1, v2}, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;

    move-result-object p1

    const-wide/16 v1, -0x1

    if-eqz p1, :cond_2

    check-cast p1, Ljava/io/Closeable;

    :try_start_3
    move-object v0, p1

    check-cast v0, Ljava/io/InputStream;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    .line 516
    :try_start_4
    invoke-virtual {v0}, Ljava/io/InputStream;->available()I

    move-result v0
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    int-to-long v1, v0

    goto :goto_1

    :catch_0
    move-exception v0

    .line 518
    :try_start_5
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 520
    :goto_1
    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_2

    .line 514
    invoke-static {p1, p2}, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable;Ljava/lang/Throwable;)V

    return-wide v1

    :catchall_2
    move-exception v0

    move-object p2, v0

    :try_start_6
    throw p2
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_3

    :catchall_3
    move-exception v0

    invoke-static {p1, p2}, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable;Ljava/lang/Throwable;)V

    throw v0

    :cond_2
    return-wide v1
.end method

.method public final getPlayableItemPreviewMediaIndex(Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;)Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;
    .locals 7

    const-string v0, "playableItemEntity"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 460
    invoke-virtual {p1}, Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;->getPreviewMediaPath()Ljava/lang/String;

    move-result-object p1

    const/4 v0, 0x0

    if-eqz p1, :cond_2

    .line 462
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    const-string v1, "index.json"

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    .line 464
    new-instance v1, Ljava/io/File;

    invoke-direct {v1, p1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 466
    new-instance v1, Ljava/io/FileInputStream;

    invoke-direct {v1, p1}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V

    check-cast v1, Ljava/io/InputStream;

    sget-object p1, Ljava/nio/charset/StandardCharsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-static {v1, p1}, Lorg/apache/commons/io/IOUtils;->toString(Ljava/io/InputStream;Ljava/nio/charset/Charset;)Ljava/lang/String;

    move-result-object p1

    const-string v1, "toString(...)"

    invoke-static {p1, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 467
    sget-object v1, Lkotlinx/serialization/json/Json;->Default:Lkotlinx/serialization/json/Json$Default;

    sget-object v2, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;->Companion:Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex$Companion;

    invoke-virtual {v2}, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex$Companion;->serializer()Lkotlinx/serialization/KSerializer;

    move-result-object v2

    check-cast v2, Lkotlinx/serialization/DeserializationStrategy;

    invoke-virtual {v1, v2, p1}, Lkotlinx/serialization/json/Json$Default;->decodeFromString(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;

    goto :goto_0

    .line 469
    :cond_0
    new-instance v1, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;

    const/4 v5, 0x7

    const/4 v6, 0x0

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-direct/range {v1 .. v6}, Lcom/magneticchen/daijishou/data/PlayableItemPreviewMediaIndex;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/jvm/internal/DefaultConstructorMarker;)V

    move-object p1, v1

    :goto_0
    if-nez p1, :cond_1

    .line 471
    const-string p1, "playableItemPreviewMediaIndex"

    invoke-static {p1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    return-object v0

    :cond_1
    return-object p1

    :cond_2
    invoke-static {v1}, Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver;->resolveBoxArtPath(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getRelativeTimeString(J)Ljava/lang/String;
    .locals 7

    .line 496
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    const-wide/32 v4, 0xea60

    const/high16 v6, 0x80000

    move-wide v0, p1

    invoke-static/range {v0 .. v6}, Landroid/text/format/DateUtils;->getRelativeTimeSpanString(JJJI)Ljava/lang/CharSequence;

    move-result-object p1

    .line 498
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p1

    return-object p1
.end method

.method public final isBitmapDark(Landroid/graphics/Bitmap;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Z
    .locals 4

    const-string v0, "bitmap"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x0

    if-eqz p2, :cond_0

    .line 354
    invoke-virtual {p2}, Ljava/lang/Integer;->intValue()I

    move-result p2

    goto :goto_0

    :cond_0
    move p2, v0

    :goto_0
    if-eqz p3, :cond_1

    .line 355
    invoke-virtual {p3}, Ljava/lang/Integer;->intValue()I

    move-result p3

    goto :goto_1

    :cond_1
    move p3, v0

    :goto_1
    if-eqz p4, :cond_2

    .line 356
    invoke-virtual {p4}, Ljava/lang/Integer;->intValue()I

    move-result p4

    goto :goto_2

    :cond_2
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result p4

    :goto_2
    if-eqz p5, :cond_3

    .line 357
    invoke-virtual {p5}, Ljava/lang/Integer;->intValue()I

    move-result p5

    goto :goto_3

    :cond_3
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result p5

    .line 358
    :goto_3
    invoke-static {p1}, Landroidx/palette/graphics/Palette;->from(Landroid/graphics/Bitmap;)Landroidx/palette/graphics/Palette$Builder;

    move-result-object v1

    const/4 v2, 0x3

    .line 359
    invoke-virtual {v1, v2}, Landroidx/palette/graphics/Palette$Builder;->maximumColorCount(I)Landroidx/palette/graphics/Palette$Builder;

    move-result-object v1

    .line 360
    invoke-virtual {v1}, Landroidx/palette/graphics/Palette$Builder;->clearFilters()Landroidx/palette/graphics/Palette$Builder;

    move-result-object v1

    .line 361
    invoke-virtual {v1, p2, p3, p4, p5}, Landroidx/palette/graphics/Palette$Builder;->setRegion(IIII)Landroidx/palette/graphics/Palette$Builder;

    move-result-object v1

    .line 362
    invoke-virtual {v1}, Landroidx/palette/graphics/Palette$Builder;->generate()Landroidx/palette/graphics/Palette;

    move-result-object v1

    .line 364
    sget-object v2, Lcom/magneticchen/daijishou/utils/PlaidColorUtils;->INSTANCE:Lcom/magneticchen/daijishou/utils/PlaidColorUtils;

    const/high16 v3, 0x3f400000    # 0.75f

    invoke-virtual {v2, v1, v3}, Lcom/magneticchen/daijishou/utils/PlaidColorUtils;->isDark(Landroidx/palette/graphics/Palette;F)I

    move-result v1

    const/4 v2, 0x2

    if-ne v1, v2, :cond_4

    .line 366
    sget-object v0, Lcom/magneticchen/daijishou/utils/PlaidColorUtils;->INSTANCE:Lcom/magneticchen/daijishou/utils/PlaidColorUtils;

    add-int/2addr p2, p4

    div-int/2addr p2, v2

    add-int/2addr p3, p5

    div-int/2addr p3, v2

    const p4, 0x3f4ccccd    # 0.8f

    invoke-virtual {v0, p1, p2, p3, p4}, Lcom/magneticchen/daijishou/utils/PlaidColorUtils;->isDark(Landroid/graphics/Bitmap;IIF)Z

    move-result p1

    return p1

    :cond_4
    const/4 p1, 0x1

    if-ne v1, p1, :cond_5

    return p1

    :cond_5
    return v0
.end method

.method public final isNetworkAvailable(Landroid/content/Context;)Z
    .locals 4

    const/4 v0, 0x0

    if-nez p1, :cond_0

    return v0

    .line 130
    :cond_0
    const-string v1, "connectivity"

    invoke-virtual {p1, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p1

    const-string v1, "null cannot be cast to non-null type android.net.ConnectivityManager"

    invoke-static {p1, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast p1, Landroid/net/ConnectivityManager;

    .line 131
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x1d

    const/4 v3, 0x1

    if-lt v1, v2, :cond_3

    .line 132
    invoke-virtual {p1}, Landroid/net/ConnectivityManager;->getActiveNetwork()Landroid/net/Network;

    move-result-object v1

    invoke-virtual {p1, v1}, Landroid/net/ConnectivityManager;->getNetworkCapabilities(Landroid/net/Network;)Landroid/net/NetworkCapabilities;

    move-result-object p1

    if-eqz p1, :cond_4

    .line 135
    invoke-virtual {p1, v0}, Landroid/net/NetworkCapabilities;->hasTransport(I)Z

    move-result v1

    if-eqz v1, :cond_1

    return v3

    .line 138
    :cond_1
    invoke-virtual {p1, v3}, Landroid/net/NetworkCapabilities;->hasTransport(I)Z

    move-result v1

    if-eqz v1, :cond_2

    return v3

    :cond_2
    const/4 v1, 0x3

    .line 141
    invoke-virtual {p1, v1}, Landroid/net/NetworkCapabilities;->hasTransport(I)Z

    move-result p1

    if-eqz p1, :cond_4

    return v3

    .line 147
    :cond_3
    invoke-virtual {p1}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object p1

    if-eqz p1, :cond_4

    .line 148
    invoke-virtual {p1}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result p1

    if-eqz p1, :cond_4

    return v3

    :cond_4
    return v0
.end method

.method public final localDateTimeToDate(Ljava/time/LocalDateTime;)Ljava/util/Date;
    .locals 1

    const-string v0, "localDateTime"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 166
    invoke-static {}, Ljava/time/ZoneId;->systemDefault()Ljava/time/ZoneId;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/time/LocalDateTime;->atZone(Ljava/time/ZoneId;)Ljava/time/ZonedDateTime;

    move-result-object p1

    invoke-virtual {p1}, Ljava/time/ZonedDateTime;->toInstant()Ljava/time/Instant;

    move-result-object p1

    invoke-static {p1}, Ljava/util/Date;->from(Ljava/time/Instant;)Ljava/util/Date;

    move-result-object p1

    return-object p1
.end method

.method public final readEntireTextFromURL(Ljava/lang/String;)Ljava/lang/String;
    .locals 2

    const-string v0, "urlString"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 487
    new-instance v0, Ljava/net/URL;

    invoke-direct {v0, p1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 488
    invoke-virtual {v0}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object p1

    const-string v0, "openConnection(...)"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    const/16 v0, 0xbb8

    .line 489
    invoke-virtual {p1, v0}, Ljava/net/URLConnection;->setReadTimeout(I)V

    .line 490
    invoke-virtual {p1, v0}, Ljava/net/URLConnection;->setConnectTimeout(I)V

    .line 491
    new-instance v0, Ljava/io/BufferedReader;

    new-instance v1, Ljava/io/InputStreamReader;

    invoke-virtual {p1}, Ljava/net/URLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object p1

    invoke-direct {v1, p1}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    check-cast v1, Ljava/io/Reader;

    invoke-direct {v0, v1}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 492
    invoke-virtual {p0, v0}, Lcom/magneticchen/daijishou/utils/Utils;->readTextFromBufferedReader(Ljava/io/BufferedReader;)Ljava/lang/String;

    move-result-object p1

    return-object p1
.end method

.method public final readTextFromBufferedReader(Ljava/io/BufferedReader;)Ljava/lang/String;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    const-string v0, "buffIn"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 478
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 480
    :goto_0
    invoke-virtual {p1}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 481
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 483
    :cond_0
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    const-string v0, "toString(...)"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    return-object p1
.end method

.method public final readableFileSize(JZ)Ljava/lang/String;
    .locals 9

    const-wide/16 v0, 0x0

    cmp-long v0, p1, v0

    if-gtz v0, :cond_0

    .line 121
    const-string p1, "0"

    return-object p1

    :cond_0
    const/4 v0, 0x6

    const/4 v1, 0x5

    const/4 v2, 0x4

    const/4 v3, 0x3

    const/4 v4, 0x2

    const/4 v5, 0x1

    const/4 v6, 0x0

    const/4 v7, 0x7

    .line 122
    new-array v7, v7, [Ljava/lang/String;

    if-eqz p3, :cond_1

    const-string v8, "Bi"

    aput-object v8, v7, v6

    const-string v6, "KiB"

    aput-object v6, v7, v5

    const-string v5, "MiB"

    aput-object v5, v7, v4

    const-string v4, "GiB"

    aput-object v4, v7, v3

    const-string v3, "TiB"

    aput-object v3, v7, v2

    const-string v2, "PiB"

    aput-object v2, v7, v1

    const-string v1, "EiB"

    aput-object v1, v7, v0

    goto :goto_0

    :cond_1
    const-string v8, "B"

    aput-object v8, v7, v6

    const-string v6, "kB"

    aput-object v6, v7, v5

    const-string v5, "MB"

    aput-object v5, v7, v4

    const-string v4, "GB"

    aput-object v4, v7, v3

    const-string v3, "TB"

    aput-object v3, v7, v2

    const-string v2, "PB"

    aput-object v2, v7, v1

    const-string v1, "EB"

    aput-object v1, v7, v0

    :goto_0
    if-eqz p3, :cond_2

    const/high16 p3, 0x44800000    # 1024.0f

    goto :goto_1

    :cond_2
    const/high16 p3, 0x447a0000    # 1000.0f

    :goto_1
    long-to-double p1, p1

    .line 124
    invoke-static {p1, p2}, Ljava/lang/Math;->log10(D)D

    move-result-wide v0

    float-to-double v2, p3

    invoke-static {v2, v3}, Ljava/lang/Math;->log10(D)D

    move-result-wide v4

    double-to-float p3, v4

    float-to-double v4, p3

    div-double/2addr v0, v4

    double-to-int p3, v0

    .line 125
    new-instance v0, Ljava/text/DecimalFormat;

    const-string v1, "#,##0.#"

    invoke-direct {v0, v1}, Ljava/text/DecimalFormat;-><init>(Ljava/lang/String;)V

    int-to-double v4, p3

    invoke-static {v2, v3, v4, v5}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v1

    div-double/2addr p1, v1

    invoke-virtual {v0, p1, p2}, Ljava/text/DecimalFormat;->format(D)Ljava/lang/String;

    move-result-object p1

    aget-object p2, v7, p3

    new-instance p3, Ljava/lang/StringBuilder;

    invoke-direct {p3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    const-string p3, " "

    invoke-virtual {p1, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    return-object p1
.end method

.method public final scaleView(Landroid/view/View;FFJZ)V
    .locals 10

    const-string v0, "v"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 170
    new-instance v1, Landroid/view/animation/ScaleAnimation;

    const/4 v8, 0x1

    const/high16 v9, 0x3f000000    # 0.5f

    const/4 v6, 0x1

    const/high16 v7, 0x3f000000    # 0.5f

    move v4, p2

    move v5, p3

    move v2, p2

    move v3, p3

    invoke-direct/range {v1 .. v9}, Landroid/view/animation/ScaleAnimation;-><init>(FFFFIFIF)V

    check-cast v1, Landroid/view/animation/Animation;

    if-nez p6, :cond_0

    const/4 p2, 0x1

    .line 176
    invoke-virtual {v1, p2}, Landroid/view/animation/Animation;->setFillAfter(Z)V

    .line 177
    :cond_0
    invoke-virtual {v1, p4, p5}, Landroid/view/animation/Animation;->setDuration(J)V

    .line 178
    invoke-virtual {p1}, Landroid/view/View;->clearAnimation()V

    if-eqz p6, :cond_1

    .line 181
    new-instance p2, Lcom/magneticchen/daijishou/utils/Utils$scaleView$1;

    invoke-direct {p2, p1, p3}, Lcom/magneticchen/daijishou/utils/Utils$scaleView$1;-><init>(Landroid/view/View;F)V

    check-cast p2, Landroid/view/animation/Animation$AnimationListener;

    invoke-virtual {v1, p2}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 195
    :cond_1
    invoke-virtual {p1, v1}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    return-void
.end method

.method public final traverseDirectoryEntries(Landroid/content/ContentResolver;Landroid/net/Uri;Lcom/magneticchen/daijishou/DaijishouApplication;)Ljava/util/List;
    .locals 14
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/ContentResolver;",
            "Landroid/net/Uri;",
            "Lcom/magneticchen/daijishou/DaijishouApplication;",
            ")",
            "Ljava/util/List<",
            "Lkotlin/Triple<",
            "Ljava/lang/String;",
            "Landroid/net/Uri;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    move-object/from16 v0, p2

    const-string v1, "getString(...)"

    const-string v2, "contentResolver"

    invoke-static {p1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v2, "rootUri"

    invoke-static {v0, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v2, "application"

    move-object/from16 v9, p3

    invoke-static {v9, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 230
    invoke-static {v0}, Landroid/provider/DocumentsContract;->getTreeDocumentId(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v2

    .line 228
    invoke-static {v0, v2}, Landroid/provider/DocumentsContract;->buildChildDocumentsUriUsingTree(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    .line 234
    new-instance v4, Ljava/util/LinkedList;

    invoke-direct {v4}, Ljava/util/LinkedList;-><init>()V

    move-object v10, v4

    check-cast v10, Ljava/util/List;

    .line 235
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    move-object v11, v4

    check-cast v11, Ljava/util/List;

    .line 237
    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-interface {v10, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 238
    :cond_0
    move-object v2, v10

    check-cast v2, Ljava/util/Collection;

    invoke-interface {v2}, Ljava/util/Collection;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_2

    const/4 v2, 0x0

    .line 239
    invoke-interface {v10, v2}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/net/Uri;

    const/4 v5, 0x3

    .line 244
    new-array v5, v5, [Ljava/lang/String;

    const-string v6, "document_id"

    aput-object v6, v5, v2

    .line 245
    const-string v6, "_display_name"

    const/4 v12, 0x1

    aput-object v6, v5, v12

    .line 246
    const-string v6, "mime_type"

    const/4 v13, 0x2

    aput-object v6, v5, v13

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v6, 0x0

    move-object v3, p1

    .line 241
    invoke-virtual/range {v3 .. v8}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 254
    :goto_0
    invoke-interface {v4}, Landroid/database/Cursor;->moveToNext()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 255
    invoke-interface {v4, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 256
    invoke-interface {v4, v12}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 257
    invoke-interface {v4, v13}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-static {v6, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 259
    invoke-virtual {v9}, Lcom/magneticchen/daijishou/DaijishouApplication;->getDefaultSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v7

    const-string v8, "find_roms_recursively"

    invoke-interface {v7, v8, v12}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v7

    .line 260
    invoke-static {v6}, Lcom/magneticchen/daijishou/utils/Utils;->traverseDirectoryEntries$isDirectory(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_1

    if-eqz v7, :cond_1

    .line 261
    invoke-static {v0, v3}, Landroid/provider/DocumentsContract;->buildChildDocumentsUriUsingTree(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    .line 262
    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-interface {v10, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 264
    :cond_1
    invoke-static {v0, v3}, Landroid/provider/DocumentsContract;->buildDocumentUriUsingTree(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    .line 265
    new-instance v7, Lkotlin/Triple;

    invoke-direct {v7, v5, v3, v6}, Lkotlin/Triple;-><init>(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-interface {v11, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :cond_2
    return-object v11
.end method
