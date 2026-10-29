.class public Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver;
.super Ljava/lang/Object;
.source "ArcadeMediaResolver.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver$ArtworkFiles;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String; = "ArcadeMediaResolver"


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static calculateInSampleSize(Landroid/graphics/BitmapFactory$Options;II)I
    .locals 3

    .line 197
    iget v0, p0, Landroid/graphics/BitmapFactory$Options;->outHeight:I

    .line 198
    iget p0, p0, Landroid/graphics/BitmapFactory$Options;->outWidth:I

    const/4 v1, 0x1

    if-gt v0, p2, :cond_1

    if-le p0, p1, :cond_0

    goto :goto_0

    :cond_0
    return v1

    .line 202
    :cond_1
    :goto_0
    div-int/lit8 v0, v0, 0x2

    .line 203
    div-int/lit8 p0, p0, 0x2

    .line 204
    :goto_1
    div-int v2, v0, v1

    if-lt v2, p2, :cond_2

    div-int v2, p0, v1

    if-lt v2, p1, :cond_2

    mul-int/lit8 v1, v1, 0x2

    goto :goto_1

    :cond_2
    return v1
.end method

.method public static decodeSampledBitmap(Ljava/lang/String;II)Landroid/graphics/Bitmap;
    .locals 2

    .line 183
    :try_start_0
    new-instance v0, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v0}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    const/4 v1, 0x1

    .line 184
    iput-boolean v1, v0, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 185
    invoke-static {p0, v0}, Landroid/graphics/BitmapFactory;->decodeFile(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    .line 187
    invoke-static {v0, p1, p2}, Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver;->calculateInSampleSize(Landroid/graphics/BitmapFactory$Options;II)I

    move-result p1

    iput p1, v0, Landroid/graphics/BitmapFactory$Options;->inSampleSize:I

    const/4 p1, 0x0

    .line 188
    iput-boolean p1, v0, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 189
    sget-object p1, Landroid/graphics/Bitmap$Config;->RGB_565:Landroid/graphics/Bitmap$Config;

    iput-object p1, v0, Landroid/graphics/BitmapFactory$Options;->inPreferredConfig:Landroid/graphics/Bitmap$Config;

    .line 190
    invoke-static {p0, v0}, Landroid/graphics/BitmapFactory;->decodeFile(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-object p0

    :catchall_0
    const/4 p0, 0x0

    return-object p0
.end method

.method private static findMediaFile(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    .locals 8

    .line 84
    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result v0

    const/4 v1, 0x0

    if-eqz v0, :cond_4

    invoke-virtual {p0}, Ljava/io/File;->isDirectory()Z

    move-result v0

    if-nez v0, :cond_0

    goto/16 :goto_2

    :cond_0
    const/4 v0, 0x6

    .line 86
    new-array v2, v0, [Ljava/lang/String;

    const-string v3, ".png"

    const/4 v4, 0x0

    aput-object v3, v2, v4

    const-string v3, ".jpg"

    const/4 v5, 0x1

    aput-object v3, v2, v5

    const/4 v3, 0x2

    const-string v5, ".jpeg"

    aput-object v5, v2, v3

    const/4 v3, 0x3

    const-string v5, ".PNG"

    aput-object v5, v2, v3

    const/4 v3, 0x4

    const-string v5, ".JPG"

    aput-object v5, v2, v3

    const/4 v3, 0x5

    const-string v5, ".JPEG"

    aput-object v5, v2, v3

    if-eqz p1, :cond_2

    .line 88
    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_2

    move v3, v4

    :goto_0
    if-ge v3, v0, :cond_2

    .line 89
    aget-object v5, v2, v3

    .line 90
    new-instance v6, Ljava/io/File;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v6, p0, v5}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 91
    invoke-virtual {v6}, Ljava/io/File;->exists()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-virtual {v6}, Ljava/io/File;->isFile()Z

    move-result v5

    if-eqz v5, :cond_1

    return-object v6

    :cond_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    :cond_2
    if-eqz p2, :cond_4

    .line 95
    invoke-virtual {p2}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_4

    invoke-virtual {p2, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result p1

    if-nez p1, :cond_4

    :goto_1
    if-ge v4, v0, :cond_4

    .line 96
    aget-object p1, v2, v4

    .line 97
    new-instance v3, Ljava/io/File;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v3, p0, p1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 98
    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result p1

    if-eqz p1, :cond_3

    invoke-virtual {v3}, Ljava/io/File;->isFile()Z

    move-result p1

    if-eqz p1, :cond_3

    return-object v3

    :cond_3
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    :cond_4
    :goto_2
    return-object v1
.end method

.method private static loadIntoImageView(Landroidx/fragment/app/Fragment;Ljava/io/File;Landroid/widget/ImageView;IIZ)V
    .locals 0

    .line 167
    :try_start_0
    invoke-static {p0}, Lcom/bumptech/glide/Glide;->with(Landroidx/fragment/app/Fragment;)Lcom/bumptech/glide/RequestManager;

    move-result-object p0

    .line 168
    invoke-virtual {p0, p1}, Lcom/bumptech/glide/RequestManager;->load(Ljava/io/File;)Lcom/bumptech/glide/RequestBuilder;

    move-result-object p0

    .line 169
    invoke-virtual {p0, p2}, Lcom/bumptech/glide/RequestBuilder;->into(Landroid/widget/ImageView;)Lcom/bumptech/glide/request/target/ViewTarget;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    .line 173
    :catchall_0
    :try_start_1
    invoke-virtual {p1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object p0

    invoke-static {p0, p3, p4}, Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver;->decodeSampledBitmap(Ljava/lang/String;II)Landroid/graphics/Bitmap;

    move-result-object p0

    if-eqz p0, :cond_0

    .line 175
    invoke-virtual {p2, p0}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    :catchall_1
    :cond_0
    return-void
.end method

.method public static resolveAndApplyPreview(Landroidx/fragment/app/Fragment;Ljava/lang/Object;)Z
    .locals 16

    const/4 v0, 0x0

    if-eqz p0, :cond_8

    if-nez p1, :cond_0

    goto/16 :goto_1

    .line 119
    :cond_0
    invoke-virtual/range {p0 .. p0}, Landroidx/fragment/app/Fragment;->getView()Landroid/view/View;

    move-result-object v1

    if-nez v1, :cond_1

    return v0

    .line 122
    :cond_1
    invoke-static/range {p1 .. p1}, Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver;->resolveArtworkFiles(Ljava/lang/Object;)Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver$ArtworkFiles;

    move-result-object v2

    if-eqz v2, :cond_8

    .line 123
    iget-object v3, v2, Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver$ArtworkFiles;->backgroundFile:Ljava/io/File;

    if-nez v3, :cond_2

    iget-object v3, v2, Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver$ArtworkFiles;->boxFile:Ljava/io/File;

    if-nez v3, :cond_2

    goto/16 :goto_1

    .line 127
    :cond_2
    invoke-virtual {v1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    .line 130
    const-string v3, "platform_library_placeholder"

    invoke-static {v0, v3}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v3

    const/16 v4, 0x8

    if-eqz v3, :cond_3

    .line 132
    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    if-eqz v3, :cond_3

    .line 133
    invoke-virtual {v3, v4}, Landroid/view/View;->setVisibility(I)V

    .line 136
    :cond_3
    const-string v3, "platform_library_platform_text_view"

    invoke-static {v0, v3}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v3

    if-eqz v3, :cond_4

    .line 138
    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    if-eqz v3, :cond_4

    .line 139
    invoke-virtual {v3, v4}, Landroid/view/View;->setVisibility(I)V

    .line 143
    :cond_4
    const-string v3, "platform_library_background"

    invoke-static {v0, v3}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v3

    if-eqz v3, :cond_5

    .line 145
    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    move-object v6, v3

    check-cast v6, Landroid/widget/ImageView;

    if-eqz v6, :cond_5

    .line 146
    iget-object v3, v2, Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver$ArtworkFiles;->backgroundFile:Ljava/io/File;

    if-eqz v3, :cond_5

    iget-object v3, v2, Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver$ArtworkFiles;->backgroundFile:Ljava/io/File;

    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_5

    .line 147
    iget-object v5, v2, Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver$ArtworkFiles;->backgroundFile:Ljava/io/File;

    const/16 v8, 0x2d0

    const/4 v9, 0x1

    const/16 v7, 0x500

    move-object/from16 v4, p0

    invoke-static/range {v4 .. v9}, Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver;->loadIntoImageView(Landroidx/fragment/app/Fragment;Ljava/io/File;Landroid/widget/ImageView;IIZ)V

    .line 152
    :cond_5
    const-string v3, "platform_library_thumbnail"

    invoke-static {v0, v3}, Lcom/magneticchen/daijishou/arcade/ArcadeRes;->getId(Landroid/content/Context;Ljava/lang/String;)I

    move-result v0

    if-eqz v0, :cond_7

    .line 154
    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    move-object v12, v0

    check-cast v12, Landroid/widget/ImageView;

    .line 155
    iget-object v0, v2, Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver$ArtworkFiles;->boxFile:Ljava/io/File;

    if-eqz v0, :cond_6

    iget-object v0, v2, Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver$ArtworkFiles;->boxFile:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_6

    iget-object v0, v2, Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver$ArtworkFiles;->boxFile:Ljava/io/File;

    goto :goto_0

    :cond_6
    iget-object v0, v2, Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver$ArtworkFiles;->backgroundFile:Ljava/io/File;

    :goto_0
    move-object v11, v0

    if-eqz v12, :cond_7

    if-eqz v11, :cond_7

    .line 156
    invoke-virtual {v11}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_7

    const/16 v14, 0x190

    const/4 v15, 0x0

    const/16 v13, 0x190

    move-object/from16 v10, p0

    .line 157
    invoke-static/range {v10 .. v15}, Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver;->loadIntoImageView(Landroidx/fragment/app/Fragment;Ljava/io/File;Landroid/widget/ImageView;IIZ)V

    :cond_7
    const/4 v0, 0x1

    :cond_8
    :goto_1
    return v0
.end method

.method public static resolveArtworkFiles(Ljava/lang/Object;)Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver$ArtworkFiles;
    .locals 7

    const/4 v0, 0x0

    if-nez p0, :cond_0

    return-object v0

    .line 27
    :cond_0
    :try_start_0
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    const-string v2, "getUri"

    const/4 v3, 0x0

    new-array v4, v3, [Ljava/lang/Class;

    invoke-virtual {v1, v2, v4}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    .line 28
    new-array v2, v3, [Ljava/lang/Object;

    invoke-virtual {v1, p0, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    if-nez v1, :cond_1

    return-object v0

    .line 31
    :cond_1
    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    .line 33
    instance-of v4, v1, Landroid/net/Uri;

    if-eqz v4, :cond_2

    .line 34
    check-cast v1, Landroid/net/Uri;

    invoke-virtual {v1}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 35
    :cond_2
    const-string v1, "file://"

    invoke-virtual {v2, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    const/4 v1, 0x7

    .line 36
    invoke-virtual {v2, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v2

    :cond_3
    :goto_0
    if-eqz v2, :cond_9

    .line 41
    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_4

    goto/16 :goto_2

    .line 42
    :cond_4
    const-string v1, "UTF-8"

    invoke-static {v2, v1}, Ljava/net/URLDecoder;->decode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 44
    new-instance v2, Ljava/io/File;

    invoke-direct {v2, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 45
    invoke-virtual {v2}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object v1

    if-eqz v1, :cond_9

    .line 46
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v4

    if-nez v4, :cond_5

    goto :goto_2

    .line 48
    :cond_5
    invoke-virtual {v2}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v2

    const/16 v4, 0x2e

    .line 49
    invoke-virtual {v2, v4}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v4

    if-lez v4, :cond_6

    .line 50
    invoke-virtual {v2, v3, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 54
    :cond_6
    :try_start_1
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    const-string v5, "getName"

    new-array v6, v3, [Ljava/lang/Class;

    invoke-virtual {v4, v5, v6}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v4

    .line 55
    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v4, p0, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    if-eqz p0, :cond_7

    .line 56
    invoke-virtual {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    :catchall_0
    :cond_7
    move-object p0, v0

    .line 59
    :goto_1
    :try_start_2
    new-instance v3, Ljava/io/File;

    const-string v4, "media"

    invoke-direct {v3, v1, v4}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 60
    new-instance v1, Ljava/io/File;

    const-string v4, "background"

    invoke-direct {v1, v3, v4}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 61
    new-instance v4, Ljava/io/File;

    const-string v5, "box"

    invoke-direct {v4, v3, v5}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 63
    new-instance v3, Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver$ArtworkFiles;

    invoke-direct {v3}, Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver$ArtworkFiles;-><init>()V

    .line 66
    invoke-static {v1, v2, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver;->findMediaFile(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;

    move-result-object v1

    iput-object v1, v3, Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver$ArtworkFiles;->backgroundFile:Ljava/io/File;

    .line 69
    invoke-static {v4, v2, p0}, Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver;->findMediaFile(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;

    move-result-object p0

    iput-object p0, v3, Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver$ArtworkFiles;->boxFile:Ljava/io/File;

    .line 72
    iget-object p0, v3, Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver$ArtworkFiles;->boxFile:Ljava/io/File;

    if-nez p0, :cond_8

    iget-object p0, v3, Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver$ArtworkFiles;->backgroundFile:Ljava/io/File;

    if-eqz p0, :cond_8

    .line 73
    iget-object p0, v3, Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver$ArtworkFiles;->backgroundFile:Ljava/io/File;

    iput-object p0, v3, Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver$ArtworkFiles;->boxFile:Ljava/io/File;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    :cond_8
    return-object v3

    :cond_9
    :goto_2
    return-object v0

    :catchall_1
    move-exception p0

    .line 78
    const-string v1, "ArcadeMediaResolver"

    const-string v2, "Error resolving artwork files"

    invoke-static {v1, v2, p0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    return-object v0
.end method

.method public static resolveBoxArtPath(Ljava/lang/Object;)Ljava/lang/String;
    .locals 2

    .line 106
    invoke-static {p0}, Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver;->resolveArtworkFiles(Ljava/lang/Object;)Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver$ArtworkFiles;

    move-result-object p0

    const/4 v0, 0x0

    if-nez p0, :cond_0

    return-object v0

    .line 108
    :cond_0
    iget-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver$ArtworkFiles;->boxFile:Ljava/io/File;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver$ArtworkFiles;->boxFile:Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 109
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver$ArtworkFiles;->boxFile:Ljava/io/File;

    invoke-virtual {p0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object p0

    return-object p0

    .line 111
    :cond_1
    iget-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver$ArtworkFiles;->backgroundFile:Ljava/io/File;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver$ArtworkFiles;->backgroundFile:Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 112
    iget-object p0, p0, Lcom/magneticchen/daijishou/arcade/ArcadeMediaResolver$ArtworkFiles;->backgroundFile:Ljava/io/File;

    invoke-virtual {p0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_2
    return-object v0
.end method
