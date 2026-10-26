package com.magneticchen.daijishou.utils;

import android.R;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.text.format.DateUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.graphics.ColorUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.RecyclerView;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemPreviewMediaIndex;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjuster;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.Json;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.IOUtils;

/* INFO: compiled from: Utils.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002MNB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0010J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ*\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u001f2\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u0018J\u0010\u0010#\u001a\u0004\u0018\u00010\u00122\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010$\u001a\u00020%J\u000e\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*J\u0010\u0010+\u001a\u0004\u0018\u00010\u00122\u0006\u0010$\u001a\u00020%J\u0010\u0010,\u001a\u0004\u0018\u00010\u00122\u0006\u0010$\u001a\u00020%J \u0010-\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020/2\b\u0010 \u001a\u0004\u0018\u00010!JC\u00100\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\n2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\n2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\n2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u00105J\u0010\u00106\u001a\u00020\u001b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u00107\u001a\u0004\u0018\u00010\u00042\u0006\u00108\u001a\u00020\u0014J\u000e\u00109\u001a\u00020\u00122\u0006\u0010:\u001a\u00020\u0012J\u000e\u0010;\u001a\u00020\u00122\u0006\u0010<\u001a\u00020=J\u0018\u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020*2\b\b\u0002\u0010@\u001a\u00020\u001bJ2\u0010A\u001a\u00020\f2\u0006\u0010.\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00182\u0006\u0010D\u001a\u00020\u00182\b\b\u0002\u0010E\u001a\u00020*2\b\b\u0002\u0010F\u001a\u00020\u001bJ.\u0010G\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00120\u001f0H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u0010J\u0012\u0010L\u001a\u00020**\u00020J2\u0006\u0010\u0016\u001a\u00020\u0010¨\u0006O"}, d2 = {"Lcom/magneticchen/daijishou/utils/Utils;", "", "()V", "atEndOfDay", "Ljava/util/Date;", "date", "atStartOfDay", "colorToColorStateList", "Landroid/content/res/ColorStateList;", TypedValues.Custom.S_COLOR, "", "copyFile", "", "context", "Landroid/content/Context;", "sourceUri", "Landroid/net/Uri;", "destinationFilename", "", "dateToLocalDateTime", "Ljava/time/LocalDateTime;", "detectMimeType", "uri", "dimensionRatioToFloat", "", "dimensionRatio", "dismissAllDialogs", "", "manager", "Landroidx/fragment/app/FragmentManager;", "getBitmapThemeColors", "Lkotlin/Triple;", "bitmap", "Landroid/graphics/Bitmap;", "luminance", "getBoxArtPath", "playableItemEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "getPlayableItemPreviewMediaIndex", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemPreviewMediaIndex;", "getRelativeTimeString", "timestamp", "", "getSnapshotPath", "getTitlePath", "imageViewAnimatedChange", "v", "Landroid/widget/ImageView;", "isBitmapDark", "left", "top", "right", "bottom", "(Landroid/graphics/Bitmap;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Z", "isNetworkAvailable", "localDateTimeToDate", "localDateTime", "readEntireTextFromURL", "urlString", "readTextFromBufferedReader", "buffIn", "Ljava/io/BufferedReader;", "readableFileSize", "size", "use1024", "scaleView", "Landroid/view/View;", "startScale", "endScale", TypedValues.TransitionType.S_DURATION, "focusFix", "traverseDirectoryEntries", "", "contentResolver", "Landroid/content/ContentResolver;", "rootUri", "getFileSize", "GridSpacingItemDecoration", "MaxSizeHashMap", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Utils {
    public static final Utils INSTANCE = new Utils();

    private Utils() {
    }

    public static /* synthetic */ String readableFileSize$default(Utils utils, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return utils.readableFileSize(j, z);
    }

    public final String readableFileSize(long size, boolean use1024) {
        if (size <= 0) {
            return "0";
        }
        String[] strArr = new String[7];
        if (use1024) {
            strArr[0] = "Bi";
            strArr[1] = "KiB";
            strArr[2] = "MiB";
            strArr[3] = "GiB";
            strArr[4] = "TiB";
            strArr[5] = "PiB";
            strArr[6] = "EiB";
        } else {
            strArr[0] = "B";
            strArr[1] = "kB";
            strArr[2] = "MB";
            strArr[3] = "GB";
            strArr[4] = "TB";
            strArr[5] = "PB";
            strArr[6] = "EB";
        }
        double d = size;
        double d2 = use1024 ? 1024.0f : 1000.0f;
        int iLog10 = (int) (Math.log10(d) / ((double) ((float) Math.log10(d2))));
        return new DecimalFormat("#,##0.#").format(d / Math.pow(d2, iLog10)) + " " + strArr[iLog10];
    }

    public final boolean isNetworkAvailable(Context context) {
        if (context == null) {
            return false;
        }
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        if (Build.VERSION.SDK_INT >= 29) {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities != null && (networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(3))) {
                return true;
            }
        } else {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return true;
            }
        }
        return false;
    }

    public final void imageViewAnimatedChange(Context context, ImageView v, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(v, "v");
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, R.anim.fade_out);
        Intrinsics.checkNotNullExpressionValue(animationLoadAnimation, "loadAnimation(...)");
        animationLoadAnimation.setDuration(100L);
        Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, R.anim.fade_in);
        Intrinsics.checkNotNullExpressionValue(animationLoadAnimation2, "loadAnimation(...)");
        animationLoadAnimation2.setDuration(100L);
        animationLoadAnimation.setAnimationListener(new AnonymousClass1(v, bitmap, animationLoadAnimation2));
        v.startAnimation(animationLoadAnimation);
    }

    /* INFO: renamed from: com.magneticchen.daijishou.utils.Utils$imageViewAnimatedChange$1, reason: invalid class name */
    /* INFO: compiled from: Utils.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/magneticchen/daijishou/utils/Utils$imageViewAnimatedChange$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AnonymousClass1 implements Animation.AnimationListener {
        final /* synthetic */ Animation $animIn;
        final /* synthetic */ Bitmap $bitmap;
        final /* synthetic */ ImageView $v;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        AnonymousClass1(ImageView imageView, Bitmap bitmap, Animation animation) {
            this.$v = imageView;
            this.$bitmap = bitmap;
            this.$animIn = animation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            this.$v.setImageBitmap(this.$bitmap);
            this.$animIn.setAnimationListener(new Utils$imageViewAnimatedChange$1$onAnimationEnd$1());
            this.$v.startAnimation(this.$animIn);
        }
    }

    public final ColorStateList colorToColorStateList(int color) {
        return new ColorStateList(new int[][]{new int[]{R.attr.state_enabled}}, new int[]{color});
    }

    public final Date atStartOfDay(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        LocalDateTime localDateTimeWith = dateToLocalDateTime(date).with((TemporalAdjuster) LocalTime.MIN);
        Intrinsics.checkNotNullExpressionValue(localDateTimeWith, "with(...)");
        return localDateTimeToDate(localDateTimeWith);
    }

    public final Date atEndOfDay(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        LocalDateTime localDateTimeWith = dateToLocalDateTime(date).with((TemporalAdjuster) LocalTime.MAX);
        Intrinsics.checkNotNullExpressionValue(localDateTimeWith, "with(...)");
        return localDateTimeToDate(localDateTimeWith);
    }

    public final LocalDateTime dateToLocalDateTime(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        LocalDateTime localDateTimeOfInstant = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        Intrinsics.checkNotNullExpressionValue(localDateTimeOfInstant, "ofInstant(...)");
        return localDateTimeOfInstant;
    }

    /* WARN: Type inference failed for: r2v1, types: [java.time.ZonedDateTime] */
    public final Date localDateTimeToDate(LocalDateTime localDateTime) {
        Intrinsics.checkNotNullParameter(localDateTime, "localDateTime");
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static /* synthetic */ void scaleView$default(Utils utils, View view, float f, float f2, long j, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            j = 100;
        }
        long j2 = j;
        if ((i & 16) != 0) {
            z = false;
        }
        utils.scaleView(view, f, f2, j2, z);
    }

    public final void scaleView(View v, float startScale, float endScale, long duration, boolean focusFix) {
        Intrinsics.checkNotNullParameter(v, "v");
        ScaleAnimation scaleAnimation = new ScaleAnimation(startScale, endScale, startScale, endScale, 1, 0.5f, 1, 0.5f);
        if (!focusFix) {
            scaleAnimation.setFillAfter(true);
        }
        scaleAnimation.setDuration(duration);
        v.clearAnimation();
        if (focusFix) {
            scaleAnimation.setAnimationListener(new AnimationAnimationListenerC02741(v, endScale));
        }
        v.startAnimation(scaleAnimation);
    }

    /* INFO: renamed from: com.magneticchen.daijishou.utils.Utils$scaleView$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: Utils.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/magneticchen/daijishou/utils/Utils$scaleView$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AnimationAnimationListenerC02741 implements Animation.AnimationListener {
        final /* synthetic */ float $endScale;
        final /* synthetic */ View $v;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        AnimationAnimationListenerC02741(View view, float f) {
            this.$v = view;
            this.$endScale = f;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.$v.setScaleX(this.$endScale);
            this.$v.setScaleY(this.$endScale);
        }
    }

    /* WARN: Code duplicated, block: B:40:0x0075 A[DONT_INVERT] */
    /* WARN: Code duplicated, block: B:41:0x0077 A[Catch: IOException -> 0x0073, TRY_LEAVE, TryCatch #3 {IOException -> 0x0073, blocks: (B:37:0x006f, B:41:0x0077), top: B:47:0x006f }] */
    /* WARN: Code duplicated, block: B:47:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final void copyFile(Context context, Uri sourceUri, String destinationFilename) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sourceUri, "sourceUri");
        Intrinsics.checkNotNullParameter(destinationFilename, "destinationFilename");
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                new File(destinationFilename).createNewFile();
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(context.getContentResolver().openInputStream(sourceUri));
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destinationFilename, false));
                    try {
                        byte[] bArr = new byte[1024];
                        bufferedInputStream2.read(bArr);
                        do {
                            bufferedOutputStream.write(bArr);
                        } while (bufferedInputStream2.read(bArr) != -1);
                        bufferedInputStream2.close();
                    } catch (IOException e) {
                        e = e;
                        bufferedInputStream = bufferedInputStream2;
                        try {
                            e.printStackTrace();
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            if (bufferedOutputStream == null) {
                                return;
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                    if (bufferedOutputStream != null) {
                                        bufferedOutputStream.close();
                                    }
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                    throw th;
                                }
                            } else if (bufferedOutputStream != null) {
                                bufferedOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        Throwable th = null;
                        th = th2;
                        bufferedInputStream = bufferedInputStream2;
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                            if (bufferedOutputStream != null) {
                                bufferedOutputStream.close();
                            }
                        } else if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    IOException e = null;
                    e = e3;
                    bufferedOutputStream = null;
                } catch (Throwable th3) {
                    Throwable th = null;
                    th = th3;
                    bufferedOutputStream = null;
                }
            } catch (IOException e4) {
                e4.printStackTrace();
                return;
            }
        } catch (Throwable th4) {
            Throwable th = null;
            th = th4;
            bufferedOutputStream = null;
        }
        bufferedOutputStream.close();
    }

    private static final boolean traverseDirectoryEntries$isDirectory(String str) {
        return Intrinsics.areEqual("vnd.android.document/directory", str);
    }

    public final List<Triple<String, Uri, String>> traverseDirectoryEntries(ContentResolver contentResolver, Uri rootUri) {
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics.checkNotNullParameter(rootUri, "rootUri");
        Uri uriBuildChildDocumentsUriUsingTree = DocumentsContract.buildChildDocumentsUriUsingTree(rootUri, DocumentsContract.getTreeDocumentId(rootUri));
        LinkedList linkedList = new LinkedList();
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNull(uriBuildChildDocumentsUriUsingTree);
        linkedList.add(uriBuildChildDocumentsUriUsingTree);
        while (!linkedList.isEmpty()) {
            ContentResolver contentResolver2 = contentResolver;
            Cursor cursorQuery = contentResolver2.query((Uri) linkedList.remove(0), new String[]{"document_id", "_display_name", "mime_type"}, null, null, null);
            if (cursorQuery != null) {
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(0);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    String string2 = cursorQuery.getString(1);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    String string3 = cursorQuery.getString(2);
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    if (traverseDirectoryEntries$isDirectory(string3)) {
                        Uri uriBuildChildDocumentsUriUsingTree2 = DocumentsContract.buildChildDocumentsUriUsingTree(rootUri, string);
                        Intrinsics.checkNotNull(uriBuildChildDocumentsUriUsingTree2);
                        linkedList.add(uriBuildChildDocumentsUriUsingTree2);
                    } else {
                        arrayList.add(new Triple(string2, DocumentsContract.buildDocumentUriUsingTree(rootUri, string), string3));
                    }
                }
            }
            contentResolver = contentResolver2;
        }
        return arrayList;
    }

    /* INFO: compiled from: Utils.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010&\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\nH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/magneticchen/daijishou/utils/Utils$MaxSizeHashMap;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Ljava/util/LinkedHashMap;", "maxSize", "", "(I)V", "removeEldestEntry", "", "eldest", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class MaxSizeHashMap<K, V> extends LinkedHashMap<K, V> {
        private final int maxSize;

        public MaxSizeHashMap(int i) {
            this.maxSize = i;
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > this.maxSize;
        }
    }

    /* INFO: compiled from: Utils.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/magneticchen/daijishou/utils/Utils$GridSpacingItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "spanCount", "", "spacing", "includeEdge", "", "onlyEdge", "topBottomEdge", "(IIZZZ)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
        private final boolean includeEdge;
        private final boolean onlyEdge;
        private final int spacing;
        private final int spanCount;
        private final boolean topBottomEdge;

        public GridSpacingItemDecoration(int i, int i2, boolean z, boolean z2, boolean z3) {
            this.spanCount = i;
            this.spacing = i2;
            this.includeEdge = z;
            this.onlyEdge = z2;
            this.topBottomEdge = z3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            int i = this.spanCount;
            int i2 = childAdapterPosition % i;
            if (this.includeEdge) {
                if (this.onlyEdge) {
                    outRect.left = (this.spacing / i) * (i - (i2 * 2));
                    int i3 = this.spacing;
                    int i4 = this.spanCount;
                    outRect.right = (i3 / i4) * (-(i4 - ((i2 + 1) * 2)));
                } else {
                    int i5 = this.spacing;
                    outRect.left = i5 - ((i2 * i5) / i);
                    outRect.right = ((i2 + 1) * this.spacing) / this.spanCount;
                }
                if (this.topBottomEdge && childAdapterPosition < this.spanCount) {
                    outRect.top = this.spacing;
                }
                if (this.onlyEdge) {
                    return;
                }
                outRect.bottom = this.spacing;
                return;
            }
            outRect.left = (this.spacing * i2) / i;
            int i6 = this.spacing;
            outRect.right = i6 - (((i2 + 1) * i6) / this.spanCount);
            if (childAdapterPosition >= this.spanCount) {
                outRect.top = this.spacing;
            }
        }
    }

    public final float dimensionRatioToFloat(String dimensionRatio) {
        Intrinsics.checkNotNullParameter(dimensionRatio, "dimensionRatio");
        List listSplit$default = StringsKt.split$default((CharSequence) dimensionRatio, new String[]{CollectionUtils.COLON}, false, 0, 6, (Object) null);
        return Float.parseFloat((String) listSplit$default.get(0)) / Float.parseFloat((String) listSplit$default.get(1));
    }

    public final boolean dismissAllDialogs(FragmentManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        List<Fragment> fragments = manager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "getFragments(...)");
        if (fragments.isEmpty()) {
            return false;
        }
        while (true) {
            boolean z = false;
            for (Fragment fragment : fragments) {
                if (fragment instanceof DialogFragment) {
                    ((DialogFragment) fragment).dismiss();
                    z = true;
                }
                FragmentManager childFragmentManager = fragment.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
                if (dismissAllDialogs(childFragmentManager) || z) {
                    z = true;
                }
            }
            return z;
        }
    }

    public static /* synthetic */ boolean isBitmapDark$default(Utils utils, Bitmap bitmap, Integer num, Integer num2, Integer num3, Integer num4, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            num2 = null;
        }
        if ((i & 8) != 0) {
            num3 = null;
        }
        if ((i & 16) != 0) {
            num4 = null;
        }
        return utils.isBitmapDark(bitmap, num, num2, num3, num4);
    }

    public final boolean isBitmapDark(Bitmap bitmap, Integer left, Integer top, Integer right, Integer bottom) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        int iIntValue = left != null ? left.intValue() : 0;
        int iIntValue2 = top != null ? top.intValue() : 0;
        int iIntValue3 = right != null ? right.intValue() : bitmap.getWidth();
        int iIntValue4 = bottom != null ? bottom.intValue() : bitmap.getHeight();
        int iIsDark = PlaidColorUtils.INSTANCE.isDark(Palette.from(bitmap).maximumColorCount(3).clearFilters().setRegion(iIntValue, iIntValue2, iIntValue3, iIntValue4).generate(), 0.75f);
        if (iIsDark == 2) {
            return PlaidColorUtils.INSTANCE.isDark(bitmap, (iIntValue + iIntValue3) / 2, (iIntValue2 + iIntValue4) / 2, 0.8f);
        }
        return iIsDark == 1;
    }

    public static /* synthetic */ Triple getBitmapThemeColors$default(Utils utils, Bitmap bitmap, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.33f;
        }
        return utils.getBitmapThemeColors(bitmap, f);
    }

    public final Triple<Integer, Integer, Integer> getBitmapThemeColors(Bitmap bitmap, float luminance) {
        int rgb;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Palette paletteGenerate = Palette.from(bitmap).generate();
        Intrinsics.checkNotNullExpressionValue(paletteGenerate, "generate(...)");
        float[] fArr = new float[3];
        if (PlaidColorUtils.INSTANCE.isDark(bitmap, luminance)) {
            Palette.Swatch vibrantSwatch = paletteGenerate.getVibrantSwatch();
            rgb = vibrantSwatch != null ? vibrantSwatch.getRgb() : -1;
            Palette.Swatch darkVibrantSwatch = paletteGenerate.getDarkVibrantSwatch();
            if (darkVibrantSwatch != null) {
                rgb = darkVibrantSwatch.getRgb();
            }
        } else {
            Palette.Swatch darkVibrantSwatch2 = paletteGenerate.getDarkVibrantSwatch();
            rgb = darkVibrantSwatch2 != null ? darkVibrantSwatch2.getRgb() : -1;
            Palette.Swatch vibrantSwatch2 = paletteGenerate.getVibrantSwatch();
            if (vibrantSwatch2 != null) {
                rgb = vibrantSwatch2.getRgb();
            }
        }
        ColorUtils.colorToHSL(rgb, fArr);
        float f = fArr[0];
        if (f < 260.0f && f >= 235.0f) {
            fArr[0] = 270.0f;
        }
        float f2 = fArr[0];
        if (f2 < 235.0f && f2 > 200.0f) {
            fArr[0] = 200.0f;
        }
        float f3 = fArr[0];
        if (f3 < 120.0f && f3 >= 110.0f) {
            fArr[0] = 120.0f;
        }
        float f4 = fArr[0];
        if (f4 < 110.0f && f4 > 100.0f) {
            fArr[0] = 100.0f;
        }
        float f5 = fArr[0];
        if (f5 < 75.0f && f5 >= 60.0f) {
            fArr[0] = 75.0f;
        }
        float f6 = fArr[0];
        if (f6 < 60.0f && f6 > 35.0f) {
            fArr[0] = 35.0f;
            fArr[1] = Math.max(0.95f, fArr[1]);
            fArr[2] = Math.min(0.45f, fArr[2]);
        }
        float fMax = Math.max(0.1f, fArr[1]);
        fArr[1] = fMax;
        fArr[1] = Math.min(0.8f, fMax);
        float fMax2 = Math.max(0.25f, fArr[2]);
        fArr[2] = fMax2;
        fArr[2] = Math.min(0.6f, fMax2);
        int iHSLToColor = ColorUtils.HSLToColor(fArr);
        float[] fArr2 = new float[3];
        ColorUtils.colorToHSL(iHSLToColor, fArr2);
        fArr2[2] = Math.max(0.4f, fArr2[2]);
        return new Triple<>(Integer.valueOf(iHSLToColor), Integer.valueOf(ColorUtils.HSLToColor(fArr2)), -1);
    }

    private static String readIndexJsonSafely(String str) {
        try {
            return IOUtils.toString(new FileInputStream(str), StandardCharsets.UTF_8);
        } catch (java.io.IOException e) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(e);
        }
    }

    public final String getBoxArtPath(PlayableItemEntity playableItemEntity) {
        PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex;
        Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
        String previewMediaPath = playableItemEntity.getPreviewMediaPath();
        PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex2 = null;
        if (previewMediaPath == null) {
            return null;
        }
        String str = previewMediaPath + "index.json";
        if (new File(str).exists()) {
            String string = readIndexJsonSafely(str);
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            playableItemPreviewMediaIndex = (PlayableItemPreviewMediaIndex) Json.Default.decodeFromString(com.magneticchen.daijishou.daijishou_library_db.PlayableItemPreviewMediaIndex$$serializer.INSTANCE, string);
        } else {
            playableItemPreviewMediaIndex = new PlayableItemPreviewMediaIndex((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
        }
        if (playableItemPreviewMediaIndex == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playableItemPreviewMediaIndex");
        } else {
            playableItemPreviewMediaIndex2 = playableItemPreviewMediaIndex;
        }
        return previewMediaPath + playableItemPreviewMediaIndex2.getBoxArtPath();
    }

    public final String getSnapshotPath(PlayableItemEntity playableItemEntity) {
        PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex;
        Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
        String previewMediaPath = playableItemEntity.getPreviewMediaPath();
        PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex2 = null;
        if (previewMediaPath == null) {
            return null;
        }
        String str = previewMediaPath + "index.json";
        if (new File(str).exists()) {
            String string = readIndexJsonSafely(str);
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            playableItemPreviewMediaIndex = (PlayableItemPreviewMediaIndex) Json.Default.decodeFromString(com.magneticchen.daijishou.daijishou_library_db.PlayableItemPreviewMediaIndex$$serializer.INSTANCE, string);
        } else {
            playableItemPreviewMediaIndex = new PlayableItemPreviewMediaIndex((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
        }
        if (playableItemPreviewMediaIndex == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playableItemPreviewMediaIndex");
        } else {
            playableItemPreviewMediaIndex2 = playableItemPreviewMediaIndex;
        }
        return previewMediaPath + playableItemPreviewMediaIndex2.getSnapshotPath();
    }

    public final String getTitlePath(PlayableItemEntity playableItemEntity) {
        PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex;
        Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
        String previewMediaPath = playableItemEntity.getPreviewMediaPath();
        PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex2 = null;
        if (previewMediaPath == null) {
            return null;
        }
        String str = previewMediaPath + "index.json";
        if (new File(str).exists()) {
            String string = readIndexJsonSafely(str);
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            playableItemPreviewMediaIndex = (PlayableItemPreviewMediaIndex) Json.Default.decodeFromString(com.magneticchen.daijishou.daijishou_library_db.PlayableItemPreviewMediaIndex$$serializer.INSTANCE, string);
        } else {
            playableItemPreviewMediaIndex = new PlayableItemPreviewMediaIndex((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
        }
        if (playableItemPreviewMediaIndex == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playableItemPreviewMediaIndex");
        } else {
            playableItemPreviewMediaIndex2 = playableItemPreviewMediaIndex;
        }
        return previewMediaPath + playableItemPreviewMediaIndex2.getTitlePath();
    }

    public final PlayableItemPreviewMediaIndex getPlayableItemPreviewMediaIndex(PlayableItemEntity playableItemEntity) {
        PlayableItemPreviewMediaIndex playableItemPreviewMediaIndex;
        Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
        String previewMediaPath = playableItemEntity.getPreviewMediaPath();
        if (previewMediaPath == null) {
            return null;
        }
        String str = previewMediaPath + "index.json";
        if (new File(str).exists()) {
            String string = readIndexJsonSafely(str);
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            playableItemPreviewMediaIndex = (PlayableItemPreviewMediaIndex) Json.Default.decodeFromString(com.magneticchen.daijishou.daijishou_library_db.PlayableItemPreviewMediaIndex$$serializer.INSTANCE, string);
        } else {
            playableItemPreviewMediaIndex = new PlayableItemPreviewMediaIndex((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
        }
        if (playableItemPreviewMediaIndex != null) {
            return playableItemPreviewMediaIndex;
        }
        Intrinsics.throwUninitializedPropertyAccessException("playableItemPreviewMediaIndex");
        return null;
    }

    public final String readTextFromBufferedReader(BufferedReader buffIn) throws IOException {
        Intrinsics.checkNotNullParameter(buffIn, "buffIn");
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = buffIn.readLine();
            if (line != null) {
                sb.append(line);
            } else {
                String string = sb.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return string;
            }
        }
    }

    public final String readEntireTextFromURL(String urlString) throws IOException {
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        URLConnection uRLConnectionOpenConnection = new URL(urlString).openConnection();
        Intrinsics.checkNotNullExpressionValue(uRLConnectionOpenConnection, "openConnection(...)");
        uRLConnectionOpenConnection.setReadTimeout(3000);
        uRLConnectionOpenConnection.setConnectTimeout(3000);
        return readTextFromBufferedReader(new BufferedReader(new InputStreamReader(uRLConnectionOpenConnection.getInputStream())));
    }

    public final String getRelativeTimeString(long timestamp) {
        return DateUtils.getRelativeTimeSpanString(timestamp, System.currentTimeMillis(), 60000L, 524288).toString();
    }

    public final long getFileSize(ContentResolver contentResolver, Uri uri) throws FileNotFoundException {
        int columnIndex;
        Intrinsics.checkNotNullParameter(contentResolver, "<this>");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Cursor cursorQuery = contentResolver.query(uri, null, null, null, null);
        if (cursorQuery != null) {
            Cursor cursor = cursorQuery;
            try {
                Cursor cursor2 = cursor;
                if (cursor2.moveToFirst() && (columnIndex = cursor2.getColumnIndex("_size")) != -1) {
                    long j = cursor2.getLong(columnIndex);
                    CloseableKt.closeFinally(cursor, null);
                    return j;
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursor, null);
            } catch (Throwable th) {
                                    CloseableKt.closeFinally(cursor, th);
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        }
        InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
        long jAvailable = -1;
        if (inputStreamOpenInputStream == null) {
            return -1L;
        }
        InputStream inputStream = inputStreamOpenInputStream;
        try {
            try {
                jAvailable = inputStream.available();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Unit unit2 = Unit.INSTANCE;
            CloseableKt.closeFinally(inputStream, null);
            return jAvailable;
        } catch (Throwable th3) {
                            CloseableKt.closeFinally(inputStream, th3);
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th3);
        }
    }

    public final String detectMimeType(Context context, Uri uri) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
        if (inputStreamOpenInputStream != null) {
            InputStream inputStream = inputStreamOpenInputStream;
            try {
                byte[] bytes = ByteStreamsKt.readBytes(inputStream);
                CloseableKt.closeFinally(inputStream, null);
                if (bytes != null) {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
                    try {
                        String strGuessContentTypeFromStream = URLConnection.guessContentTypeFromStream(byteArrayInputStream);
                        CloseableKt.closeFinally(byteArrayInputStream, null);
                        return strGuessContentTypeFromStream != null ? strGuessContentTypeFromStream : context.getContentResolver().getType(uri);
                    } catch (Throwable th) {
                                                    CloseableKt.closeFinally(byteArrayInputStream, th);
                            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                    }
                }
            } catch (Throwable th3) {
                CloseableKt.closeFinally(inputStream, th3);
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th3);
            }
        }
        return null;
    }
}
